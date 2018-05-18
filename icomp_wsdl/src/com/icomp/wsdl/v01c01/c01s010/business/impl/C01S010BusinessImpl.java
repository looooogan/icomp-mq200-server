package com.icomp.wsdl.v01c01.c01s010.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c01.s010.ICOMPV01C01S010Service;
import com.icomp.common.service.icomp.v01c03.s001.ICOMPV01C03S001Service;
import com.icomp.entity.base.Authorization;
import com.icomp.entity.base.Containercarrier;
import com.icomp.entity.base.GrindingBitMsge;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.ScanGrinding;
import com.icomp.entity.base.Synthesisknife;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Vsynthesisparameters;
import com.icomp.wsdl.v01c01.c01s010.business.C01S010Business;
import com.icomp.wsdl.v01c01.c01s010.endpoint.C01S010Request;
import com.icomp.wsdl.v01c01.c01s010.endpoint.C01S010Respons;
import com.icomp.wsdl.v01c01.c01s010.endpoint.GrindingBitInfo;
import com.icomp.wsdl.v01c01.c01s010.endpoint.GrindingBitMsg;
import com.icomp.wsdl.v01c01.c01s010.endpoint.OutputTool;
import com.icomp.wsdl.v01c01.c01s010.endpoint.ScanGrindingMsg;
import com.icomp.wsdl.v01c01.c01s010.endpoint.ToolScrapInfo;
import com.icomp.wsdl.v01c03.c03s001.endpoint.SynthesisEntity;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 刀具换装-Business实现类
 *
 * @author Taoyy
 * @ClassName: C01S010BusinessImpl
 * @date 2016-2-26 下午02:45:38
 */
public class C01S010BusinessImpl implements C01S010Business {

    private CommonService service;
    private Map<String, String> param = null;

    public void setService(CommonService service) {
        this.service = service;
    }

    /**
     * 刀具换装-Service接口
     */
    private ICOMPV01C01S010Service iCOMPV01C01S010Service;
    private ICOMPV01C03S001Service iCOMPV01C03S001Service;

    public void setiCOMPV01C01S010Service(ICOMPV01C01S010Service iCOMPV01C01S010Service) {
        this.iCOMPV01C01S010Service = iCOMPV01C01S010Service;
    }

    public void setiCOMPV01C03S001Service(ICOMPV01C03S001Service iCOMPV01C03S001Service) {
        this.iCOMPV01C03S001Service = iCOMPV01C03S001Service;
    }

    /**
     * 取得合成刀组成信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @SuppressWarnings("null")
    public C01S010Respons getSynthesisTool(C01S010Request request) throws Exception {
        C01S010Respons respons = new C01S010Respons ();
        Rfidcontainer entity = new Rfidcontainer ();
        // 参数验证
        if (StringUtils.isEmpty ( request.getRfidCode () ) || StringUtils.isEmpty ( request.getQueryType () )) {
            throw new BusinessException ( IConstant.WMSG0221, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE );
        }

        // RFID标签
        entity.setRfidCode ( request.getRfidCode () );

        // 删除区分
        entity.setDelFlag ( IConstant.DEL_FLAG_0 );

        // 验证RFID标签是否存在
        Rfidcontainer reVal = service.getRfidContainerByRfidCode ( entity );
        if (reVal == null) {
            respons.setStateCode ( IConstant.STRING_4 );
            respons.setStateMsg ( "当前标签未初始化" );
            return respons;
        } else if (!IConstant.STRING_2.equals ( reVal.getQueryType () )) {
            respons.setStateCode ( IConstant.STRING_9 );
            respons.setStateMsg ( "请扫描合成刀具" );
            return respons;
        }

        param = new HashMap<String, String> ();
        param.put ( "businessCode", IConstant.C01S010 );
        param.put ( "rfidCode", request.getRfidCode () );
        param.put ( "gruantUserID", request.getGruantUserID () );
        Map<String, String> reBuss = service.processControlBussinesCode ( param );
        if (reBuss == null) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "查询失败，请联系管理员" );
            return respons;
        } else {
            //0 正常流程 1.需要授权 2.不能执行当前流程 9.未知错误
            String buss = reBuss.get ( IConstant.STATE_CODE );
            if (IConstant.STRING_1.equals ( buss )) {
                respons.setStateCode ( IConstant.STRING_5 );
                respons.setStateMsg ( "需要授权" );
                return respons;
            } else if (IConstant.STRING_2.equals ( buss ) || IConstant.BAND_TYPE_9.equals ( buss )) {
                respons.setStateCode ( IConstant.STRING_1 );
                respons.setStateMsg ( reBuss.get ( IConstant.STATE_MSG ) );
                return respons;
            }
        }
        if (request.getGruantUserID () != null) {
            //  授权记录插入
            Authorization auth = new Authorization ();
            //授权人ID
            auth.setAuthorizationUserID ( request.getGruantUserID () );
            //授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它）
            auth.setAuthorizedReason ( IConstant.STRING_5 );
            //刀具类型（0单品，1合成刀具）
            auth.setTooltype ( IConstant.DEL_FLAG_1 );
            //材料号或合成刀具编码
            if (reBuss.get ( "toolCode" ) != null) {
                auth.setToolCode ( reBuss.get ( "toolCode" ) );
            }

            //业务流程编码
            auth.setBusinessCode ( IConstant.C01S010 );
            auth.setCreateUserID ( request.getCustomerID () );
            //备注
            auth.setNote ( "重复换装" );
            service.innsetGruant ( auth );
        }
        //载体id
        String RfidContainerID = reVal.getRfidContainerID ();

        // 合成刀库
        Synthesisknife syentity = new Synthesisknife ();
        // RFID(RFID载体ID.只有的位置0上有)
        syentity.setrFID ( RfidContainerID );
        // 删除区分
        syentity.setDelFlag ( IConstant.DEL_FLAG_0 );
        // 根据载体id查询合成刀具编码
        Synthesisknife skentity = iCOMPV01C01S010Service.getSynthesisknife ( syentity );

        // 合成刀具类型（0热套，1复合刀具）
        respons.setSynthesisParametersType ( skentity.getExpandSpace1 () );
        // 合成刀具编码
        respons.setSynthesisParametersCode ( skentity.getSynthesisParametersCode () );

        // 刀具流转表
        Tooltransfer tfentity = new Tooltransfer ();
        // RFID(RFID载体ID.只有的位置0上有)
        tfentity.setRfidContainerID ( RfidContainerID );
        // 删除区分
        tfentity.setDelFlag ( IConstant.DEL_FLAG_0 );
        // 获取刀具ID和数量
        List<Tooltransfer> tooltransfer = iCOMPV01C01S010Service.getSynthesisknifeToolMsg ( tfentity );

        if (tooltransfer.size () == 0 && tooltransfer.get ( 0 ).isRetErrFlag ()) {
            throw new BusinessException ( tooltransfer.get ( 0 ).getMessageCode (), request.getLanguageCode (), request.getLanguageValue () );
        }
        // 输出的刀具list
        List<OutputTool> retlist = new ArrayList<OutputTool> ();
        OutputTool tool = null;
        for (Tooltransfer tf : tooltransfer) {
            tool = new OutputTool ();
            // 刀具id
            tool.setToolID ( tf.getToolID () );
            // 数量
            tool.setToolCount ( tf.getToolDurable () );
            // 材料号
            tool.setMaterialNum ( tf.getExpandSpace1 () );
            // 刀具类型
            tool.setToolType ( tf.getToolState () );
            retlist.add ( tool );
        }

        respons.setOutputTool ( retlist );
        respons.setStatus ( IConstant.ZERO );
        respons.setStateCode ( IConstant.STRING_0 );
        respons.setStateMsg ( "请求成功" );

        return respons;
    }

    /**
     * 取得单品刀具信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S010Respons getSingleTool(C01S010Request request) throws Exception {
        C01S010Respons respons = new C01S010Respons ();
        Rfidcontainer entity = new Rfidcontainer ();
        // 参数验证
        if (StringUtils.isEmpty ( request.getRfidCode () ) || StringUtils.isEmpty ( request.getQueryType () )) {
            throw new BusinessException ( IConstant.WMSG0221, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE );
        }

        // RFID标签
        entity.setRfidCode ( request.getRfidCode () );
        // 删除区分
        entity.setDelFlag ( IConstant.DEL_FLAG_0 );

        // 验证RFID标签是否存在
        String RfidContainerID = service.getRfidContainerIDByRfidCode ( entity );
        if (StringUtils.isEmpty ( RfidContainerID )) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "当前标签未初始化" );
            return respons;
        }
        // 验证扫描的标签是否为单品刀具
        Rfidcontainer rfidcontainer = service.getRfidContainerByRfidCode ( entity );
        if (!IConstant.STRING_1.equals ( rfidcontainer.getQueryType () )) {
            respons.setStateCode ( IConstant.STRING_9 );
            respons.setStateMsg ( "请扫描单品刀具" );
            return respons;
        }

        // 刀具流转表
        Tooltransfer tfentity = new Tooltransfer ();
        // RFID载体ID
        tfentity.setRfidContainerID ( RfidContainerID );
        // 删除区分
        tfentity.setDelFlag ( IConstant.DEL_FLAG_0 );

        // 获取刀具ID
        List<Tooltransfer> tooltransfer = iCOMPV01C01S010Service.getTooltransferList ( tfentity );
        if (tooltransfer.get ( 0 ).isRetErrFlag ()) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "该刀具不是流转中的刀具" );
            return respons;
        }

        // 判断所扫描的单品刀具的材料号是否与热套上的单品刀具的材料号是否相同
        if (!request.getToolID ().equals ( tooltransfer.get ( 0 ).getToolID () )) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "您所扫描的单品刀具的材料号与热套上的单品刀具的材料号不同，请重新扫描" );
            return respons;
        }
        HashMap<String, String> param1 = new HashMap<String, String> ();
        param1.put ( "businessCode", IConstant.C01S010 );
        param1.put ( "rfidCode", request.getRfidCode () );
        param1.put ( "gruantUserID", request.getGruantUserID () );
        Map<String, String> reBuss = service.processControlBussinesCode ( param1 );
        if (reBuss == null) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "查询失败，请联系管理员" );
            return respons;
        } else {
            //0 正常流程 1.需要授权 2.不能执行当前流程 9.未知错误
            String buss = reBuss.get ( IConstant.STATE_CODE );
            if (IConstant.STRING_1.equals ( buss )) {
                respons.setStateCode ( IConstant.STRING_5 );
                respons.setStateMsg ( "需要授权" );
                return respons;
            } else if (IConstant.STRING_2.equals ( buss ) || IConstant.BAND_TYPE_9.equals ( buss )) {
                respons.setStateCode ( IConstant.STRING_1 );
                respons.setStateMsg ( reBuss.get ( IConstant.STATE_MSG ) );
                return respons;
            }
        }
        if (request.getGruantUserID () != null) {
            //  授权记录插入
            Authorization auth = new Authorization ();
            //授权人ID
            auth.setAuthorizationUserID ( request.getGruantUserID () );
            //授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它）
            auth.setAuthorizedReason ( IConstant.STRING_5 );
            //刀具类型（0单品，1合成刀具）
            auth.setTooltype ( IConstant.DEL_FLAG_0 );
            //材料号或合成刀具编码
            if (reBuss.get ( "toolCode" ) != null) {
                auth.setToolCode ( reBuss.get ( "toolCode" ) );
            }
            //业务流程编码
            auth.setBusinessCode ( IConstant.C01S010 );
            auth.setCreateUserID ( request.getCustomerID () );
            //备注
            auth.setNote ( "重复换装" );
            service.innsetGruant ( auth );
        }
        Tool tl = new Tool ();
        tl.setToolID ( request.getToolID () );
        tl.setDelFlag ( IConstant.DEL_FLAG_0 );
        Tool tool = iCOMPV01C01S010Service.getTool ( tl );

        if (tool != null) {
            respons.setToolID ( tool.getToolID () );
            respons.setToolCode ( tool.getToolCode () );
            respons.setStateCode ( IConstant.DEL_FLAG_0 );
            respons.setStateMsg ( "请求成功" );
        } else {
            respons.setStateCode ( IConstant.INSTALLATION_STATE_1 );
            respons.setStateMsg ( "未找到当前扫描刀具信息" );
        }
        return respons;
    }

    /**
     * 提交热套换装完成信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @SuppressWarnings("null")
    @Override
    public C01S010Respons saveHotChangeInfo(C01S010Request request) throws Exception {
        C01S010Respons respons = new C01S010Respons ();
        // 参数验证
        if (StringUtils.isEmpty ( request.getSynthesisParametersRfid () ) || StringUtils.isEmpty ( request.getSingleToolRfid () )) {
            throw new BusinessException ( IConstant.WMSG0221, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE );
        }
        Map<String, String> par = new HashMap<String, String> ();
        //合成刀具RFID载体
        par.put ( "synthesConnterID", service.getrfidContainerIdByRfid ( request.getSynthesisParametersRfid () ) );
        //单品刀具RFID载体
        par.put ( "singerConneterID", service.getrfidContainerIdByRfid ( request.getSingleToolRfid () ) );
        par.put ( "userID", request.getCustomerID () );
        par.put ( "toolID", request.getToolID () );
        //手持机id
        par.put ( "handSetId", request.getHandSetId () );
        //提交热套换装完成信息
        int reval = iCOMPV01C01S010Service.saveHotChangeInfo ( par );

        if (reval > 0) {
            respons.setStateCode ( IConstant.DEL_FLAG_0 );
            respons.setStateMsg ( "请求成功" );
        } else {
            respons.setStateCode ( IConstant.STRING_1 );
        }

        return respons;
    }

    /**
     * 提交合成刀具报废信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S010Respons saveToolScrapInfo(C01S010Request request) throws Exception {
        C01S010Respons respons = new C01S010Respons ();
        // 传入数据 存在性校验
        if (checkParam ( request, 1 )) {
            throw new BusinessException ( IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH );
        }
        //容器RFID
        String containerRfid = request.getContainerRfid ();
        //查询容器验证容器信息
     /*   Rfidcontainer rfidcon = new Rfidcontainer();
        rfidcon.setQueryType(IConstant.LOADSTATE_5);
        rfidcon.setRfidCode(request.getRfidCode());
        Rfidcontainer reRfid = service.getRfidContainerByRfidCode(rfidcon);
        if (rfidcon == null) {
            respons.setStateCode(IConstant.TOOL_STATE_1);
            respons.setStateMsg("请勿扫描非容器标签");
        }*/
        //0:非容器 1:正常容器 2:报废容器 3:空容器
        String toolType = service.getToolsContainerByRfid ( containerRfid, request.getCustomerID () );
        if (toolType.equals ( IConstant.TOOL_KIND_0 )) {
            throw new BusinessException ( IConstant.WMSG0247_1, request.getLanguageCode (), request.getLanguageValue () );
        }
        if (!toolType.equals ( IConstant.TOOL_KIND_2 ) && !toolType.equals ( IConstant.TOOL_KIND_3 )) {
            //请扫描装报废刀具的容器!
            throw new BusinessException ( IConstant.WMSG0245_2, request.getLanguageCode (), request.getLanguageValue () );
        }
        Map<String, Object> map = new HashMap<String, Object> ();
        List<ScanGrinding> scrapMsgs = new ArrayList<ScanGrinding> ();
        ScanGrinding sg = null;
        for (ToolScrapInfo ts : request.getToolScrapInfos ()) {
            sg = new ScanGrinding ();
            sg.setToolCode ( ts.getMaterialNum () );  //材料号
            //当前状态（0报废，1丢刀）
            if (IConstant.DEL_FLAG_0.equals ( ts.getState () )) {
                sg.setNumbers ( ts.getScrapCount () ); //数量
            } else {
                sg.setNumbers ( ts.getThrowingKnifeCount () ); //数量
            }
            sg.setToolType ( IConstant.STRING_2 ); //类型
            sg.setThisStaic ( ts.getState () ); //报废状态
            scrapMsgs.add ( sg );
        }
        String scrapRfidString = service.getrfidContainerIdByRfid ( containerRfid );
        // String scrapRfidString = service.getrfidContainerIdByRfid(containerRfid);
        int reval = 0;
        // 系统语言编码
        map.put ( "languageCode", request.getLanguageCode () );
        // 系统语言值
        map.put ( "languageValue", request.getLanguageValue () );
        // 当前用户ID
        map.put ( "userId", request.getCustomerID () );
        // 当前合成刀具RFID
        map.put ( "rfidSynthesisString", request.getSynthesisParametersCode () );
        //报废容器载体id
        map.put ( "scrapRfidString", scrapRfidString );
        //报废信息
        map.put ( "scrapMsgs", scrapMsgs );
        // 手持机id
        map.put ( "handerId", request.getHandSetId () );
        // 当前合成刀具RFid
        map.put ( "rfidSynthesisString", request.getSynthesisParametersCode () );
        //授权人
        map.put ( "gruantUserId", request.getGruantUserID () );
        try {
            //提交合成刀具报废信息
            reval = iCOMPV01C01S010Service.saveToolScrapInfo ( map );
        } catch (Exception e) {
            throw new BusinessException ( IConstant.CEMSG0005_1, request.getLanguageCode (), request.getLanguageValue () );
        }
        if (reval > 0) {
            respons.setStateCode ( IConstant.STOCK_STATE_0 );
            respons.setStateMsg ( "提交刀具报废信息成功" );
        } else if (IConstant.RESULT_CODE_2 == reval) {
            respons.setStateCode ( IConstant.STOCK_STATE_1 );
            respons.setStateMsg ( "当前备用刀库数量不足" );
        } else {
            throw new BusinessException ( IConstant.CEMSG0005_1, request.getLanguageCode (), request.getLanguageValue () );
        }
        return respons;
    }

    /**
     * 参数验证
     *
     * @param request
     * @param state
     * @return
     */
    private Boolean checkParam(C01S010Request request, int state) {
        // 用户ID
        if (StringUtils.isEmpty ( request.getCustomerID () )) {
            return true;
        }

        if (state == 1) {
            // 容器RFID
            if (StringUtils.isEmpty ( request.getContainerRfid () )) {
                return true;
            }       // 合成刀具RFID
            if (StringUtils.isEmpty ( request.getSynthesisParametersRfid () )) {
                return true;
            }

        } else if (state == 3) {
            // 容器RFID
            if (StringUtils.isEmpty ( request.getContainerRfid () )) {
                return true;
            }       // 合成刀具RFID
            if (StringUtils.isEmpty ( request.getSynthesisParametersRfid () )) {
                return true;
            }
            if (request.getGrindingBitInfo () == null || request.getGrindingBitInfo ().size () < 1) {
                return true;
            }
        } else if (state == 2) {
            // 合成刀具RFIDCode
            if (StringUtils.isEmpty ( request.getRfidCode () )) {
                return true;
            }
            //刀具ID
            if (StringUtils.isEmpty ( request.getToolID () )) {
                return true;
            }
            //空盒的RfidCode
            if (StringUtils.isEmpty ( request.getScrapContainerRfid () )) {
                return true;
            }
            //单品ID
            if (StringUtils.isEmpty ( request.getSingleToolRfid () )) {
                return true;
            }
        } else if (state == 4) {
            // 合成刀具RFIDCode
            if (StringUtils.isEmpty ( request.getRfidCode () )) {
                return true;
            }
            //刀具ID
            if (StringUtils.isEmpty ( request.getToolCode () )) {
                return true;
            }
            //钻头的RfidCode
            if (StringUtils.isEmpty ( request.getSingleToolRfid () )) {
                return true;
            }
        } else if (state == 5) {
            // 合成刀具RFIDCode
            if (StringUtils.isEmpty ( request.getRfidCode () )) {
                return true;
            }
            //刀具ID
            if (StringUtils.isEmpty ( request.getToolCode () )) {
                return true;
            }

        } else if (state == 6) {
            // 合成刀具RFIDCode
            if (StringUtils.isEmpty ( request.getToolType () )) {
                return true;
            }
            if (IConstant.STRING_0.equals ( request.getToolType () )) {
                //钻头
                //刀具ID
                if (null == request.getRfidCodeList () || request.getRfidCodeList ().size () < 1) {
                    return true;
                }
            } else {
                //刀片
                //刀具ID
                if (StringUtils.isEmpty ( request.getToolCode () )) {
                    return true;
                }
            }
        } else if (state == 7) {
            //材料号
            if (StringUtils.isEmpty ( request.getToolCode () )) {
                return true;
            }
            //rfid
            if (StringUtils.isEmpty ( request.getRfidCode () )) {
                return true;
            }
        }

        return false;
    }

    @Override
    public C01S010Respons savesGrindingToolInfo(C01S010Request request) throws Exception {
        //提交可复磨刀片的信息
        C01S010Respons respons = new C01S010Respons ();
        if (checkParam ( request, 3 )) {
            respons.setStateCode ( IConstant.STOCK_STATE_1 );
            respons.setStateMsg ( "参数异常" );
            return respons;
        }
        // 传入数据 存在性校验
        if (checkParam ( request, 1 )) {
            throw new BusinessException ( IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH );
        }
        //容器RFID
        String containerRfid = request.getContainerRfid ();

        //0:非容器 1:正常容器 2:报废容器 3:空容器
        String toolType = service.getToolsContainerByRfid ( containerRfid, request.getCustomerID () );
        if (toolType.equals ( IConstant.TOOL_KIND_0 )) {
            throw new BusinessException ( IConstant.WMSG0247_1, request.getLanguageCode (), request.getLanguageValue () );
        }
        if (!toolType.equals ( IConstant.TOOL_KIND_1 ) && !toolType.equals ( IConstant.TOOL_KIND_3 )) {
            //请扫描装刃磨刀具的容器!
            throw new BusinessException ( IConstant.WMSG0245_3, request.getLanguageCode (), request.getLanguageValue () );
        }
        Map<String, Object> map = new HashMap<String, Object> ();
        List<ScanGrinding> grindingMsgs = new ArrayList<ScanGrinding> ();
        ScanGrinding sg = null;
        for (GrindingBitInfo ts : request.getGrindingBitInfo ()) {
            sg = new ScanGrinding ();
            sg.setToolCode ( ts.getMaterialNum () );  //材料号
            sg.setNumbers ( ts.getCount () ); //数量
            sg.setToolType ( IConstant.STRING_2 ); //类型
            sg.setThisStaic ( ts.getState () ); //报废状态
            grindingMsgs.add ( sg );
        }
        String scrapRfidString = service.getrfidContainerIdByRfid ( containerRfid );
        // String scrapRfidString = service.getrfidContainerIdByRfid(containerRfid);
        int reval = 0;
        // 系统语言编码
        map.put ( "languageCode", request.getLanguageCode () );
        // 系统语言值
        map.put ( "languageValue", request.getLanguageValue () );
        // 当前用户ID
        map.put ( "userId", request.getCustomerID () );
        // 当前合成刀具RFID
        map.put ( "rfidSynthesisString", request.getSynthesisParametersCode () );
        //刃磨容器载体id
        map.put ( "grindingRfidString", scrapRfidString );
        //刃磨信息
        map.put ( "grindingMsgs", grindingMsgs );
        // 手持机id
        map.put ( "handerId", request.getHandSetId () );
        // 当前合成刀具RFid
        map.put ( "rfidSynthesisString", request.getSynthesisParametersCode () );
        //授权人
        map.put ( "gruantUserId", request.getGruantUserID () );
        try {
            //提交合成刀具报废信息
            reval = iCOMPV01C01S010Service.savesGrindingToolInfo ( map );
        } catch (Exception e) {
            throw new BusinessException ( IConstant.CEMSG0005_1, request.getLanguageCode (), request.getLanguageValue () );
        }
        if (reval > 0) {
            respons.setStateCode ( IConstant.STOCK_STATE_0 );
            respons.setStateMsg ( "提交刀具报废信息成功" );
        } else {
            throw new BusinessException ( IConstant.CEMSG0005_1, request.getLanguageCode (), request.getLanguageValue () );
        }
        return respons;

    }

    @Override
    public C01S010Respons getSynthesisToolByRfid(C01S010Request request) throws Exception {
        // 取得合成刀组成信息（新增）
        C01S010Respons respons = new C01S010Respons ();
        // 参数验证
        if (StringUtils.isEmpty ( request.getRfidCode () ) || StringUtils.isEmpty ( request.getQueryType () )) {
            throw new BusinessException ( IConstant.WMSG0221, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE );
        }

        Rfidcontainer entity = new Rfidcontainer ();
        // RFID标签
        entity.setRfidCode ( request.getRfidCode () );
        // 删除区分
        entity.setDelFlag ( IConstant.DEL_FLAG_0 );

        // 验证RFID标签是否存在
        Rfidcontainer reVal = service.getRfidContainerByRfidCode ( entity );
        if (reVal == null) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "当前标签未初始化" );
            return respons;
        } else if (!IConstant.STRING_2.equals ( reVal.getQueryType () )) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "请扫描合成刀具" );
            return respons;
        }

        //流利控制
        param = new HashMap<String, String> ();
        param.put ( "businessCode", IConstant.C01S006 );
        param.put ( "rfidCode", request.getRfidCode () );
        param.put ( "gruantUserID", request.getGruantUserID () );
        Map<String, String> reBuss = service.processControlBussinesCode ( param );
        if (reBuss == null) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "查询失败，请联系管理员" );
            return respons;
        } else {
            //0 正常流程 1.需要授权 2.不能执行当前流程 9.未知错误
            String buss = reBuss.get ( IConstant.STATE_CODE );
            if (IConstant.STRING_1.equals ( buss )) {
                respons.setStateCode ( IConstant.STRING_5 );
                respons.setStateMsg ( "需要授权" );
                return respons;
            } else if (IConstant.STRING_2.equals ( buss ) || IConstant.BAND_TYPE_9.equals ( buss )) {
                respons.setStateCode ( IConstant.STRING_1 );
                respons.setStateMsg ( reBuss.get ( IConstant.STATE_MSG ) );
                return respons;
            }
        }
        if (request.getGruantUserID () != null) {
            //  授权记录插入
            Authorization auth = new Authorization ();
            //授权人ID
            auth.setAuthorizationUserID ( request.getGruantUserID () );
            //授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它）
            auth.setAuthorizedReason ( IConstant.STRING_5 );
            //刀具类型（0单品，1合成刀具）
            auth.setTooltype ( IConstant.DEL_FLAG_1 );
            //材料号或合成刀具编码
            if (reBuss.get ( "toolCode" ) != null) {
                auth.setToolCode ( reBuss.get ( "toolCode" ) );
            }

            //业务流程编码
            auth.setBusinessCode ( IConstant.C01S006 );
            auth.setCreateUserID ( request.getCustomerID () );
            //备注
            auth.setNote ( "重复换装" );
            service.innsetGruant ( auth );
        }
        //载体id
        String RfidContainerID = reVal.getRfidContainerID ();

        // 合成刀库
        Synthesisknife syentity = new Synthesisknife ();
        syentity.setrFID ( RfidContainerID );
        // 删除区分
        syentity.setDelFlag ( IConstant.DEL_FLAG_0 );
        // 根据载体id查询合成刀具编码
        Synthesisknife skentity = iCOMPV01C01S010Service.getSynthesisknife ( syentity );

        // 合成刀具类型（0热套，1复合刀具）
        respons.setSynthesisParametersType ( skentity.getExpandSpace1 () );
        // 合成刀具编码
        respons.setSynthesisParametersCode ( skentity.getSynthesisParametersCode () );

        // 刀具流转表
        Tooltransfer tfentity = new Tooltransfer ();
        // RFID(RFID载体ID.只有的位置0上有)
        tfentity.setRfidContainerID ( RfidContainerID );
        // 删除区分
        tfentity.setDelFlag ( IConstant.DEL_FLAG_0 );
        // 获取刀具ID和数量
        List<Tooltransfer> tooltransfer = iCOMPV01C01S010Service.getSynthesisknifeToolMsg ( tfentity );

        if (tooltransfer == null || tooltransfer.size () < 1) {
            throw new BusinessException ( "WMSG0151", request.getLanguageCode (), request.getLanguageValue () );
        }
        // 输出的刀具list
        List<OutputTool> retlist = new ArrayList<OutputTool> ();
        OutputTool tool = null;
        for (Tooltransfer tf : tooltransfer) {
            tool = new OutputTool ();
            // 刀具id
            tool.setToolID ( tf.getToolID () );
            // 数量
            tool.setToolCount ( tf.getToolDurable () );
            // 材料号
            tool.setMaterialNum ( tf.getExpandSpace1 () );
            // 刀具类型
            tool.setToolType ( tf.getToolState () );
            retlist.add ( tool );
        }
        if (tooltransfer != null && tooltransfer.size () > 0) {
            respons.setToolID ( tooltransfer.get ( 0 ).getToolID () );
            //单品ID
            respons.setToolCode ( tooltransfer.get ( 0 ).getKnifeInventoryCode () );
        }
        respons.setOutputTool ( retlist );
        respons.setStatus ( IConstant.ZERO );
        respons.setStateCode ( IConstant.STRING_0 );
        respons.setStateMsg ( "请求成功" );

        return respons;
    }

    @Override
    public C01S010Respons saveLoadownMsg(C01S010Request request) throws Exception {
        // 保存刀具卸下辅具信息（新增）
        C01S010Respons respons = new C01S010Respons ();
        // 参数验证
        if (checkParam ( request, 2 )) {
            throw new BusinessException ( IConstant.WMSG0221, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE );
        }
        Rfidcontainer entity = new Rfidcontainer ();
        // RFID标签
        entity.setRfidCode ( request.getScrapContainerRfid () );
        // 删除区分
        entity.setDelFlag ( IConstant.DEL_FLAG_0 );
        //0：钻头  1：刀片
        String flag = request.getFlag ();
        // 验证RFID标签是否存在
        Rfidcontainer reVal = service.getRfidContainerByRfidCode ( entity );
        if (reVal != null) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            if (IConstant.STRING_0.equals ( flag )) {
                //钻头
                respons.setStateMsg ( "请扫描盛放单品刀具的空盒" );
                return respons;
            } else {
                //刀片 -  判断扫描的是否是报废容器
                Containercarrier cc = new Containercarrier ();
                cc.setRfidContainerID ( reVal.getRfidContainerID () );
                //容器类别（0备用刀，1一次性报废 2待分拣容器 3厂内待刃磨 4厂外待刃磨 5刃磨完毕 6刃磨报废 7待涂层 8库房报废 9其他）',
                cc.setContainerCarrierType ( IConstant.STRING_1 );
                cc.setDelFlag ( IConstant.DEL_FLAG_0 );
                if (service.getContainerTypeByRfidContainer ( cc ) < 1) {
                    respons.setStateMsg ( "请扫描要盛放卸下刀具的报废容器" );
                    return respons;
                }
            }
        } else {
            if (IConstant.STRING_1.equals ( flag )) {
                respons.setStateMsg ( "当前标签未初始化" );
                respons.setStateCode ( IConstant.DEL_FLAG_1 );
                return respons;
            }
        }

        Map<String, String> par = new HashMap<String, String> ();

        //合成刀具RFID载体
        par.put ( "synthesConnterID", service.getrfidContainerIdByRfid ( request.getRfidCode () ) );
        if (IConstant.STRING_0.equals ( flag )) {
            //单品刀具
            par.put ( "singerConneterID", request.getScrapContainerRfid () );
        } else {
            //单品刀具
            par.put ( "singerConneterID", reVal.getRfidContainerID () );
        }
        //用户ID
        par.put ( "userID", request.getCustomerID () );
        //刀具ID
        par.put ( "toolID", request.getToolID () );
        //单品ID
        par.put ( "singlsToolID", request.getSingleToolRfid () );
        //手持机id
        par.put ( "handSetId", request.getHandSetId () );
        par.put ( "flag", flag );

        //保存刀具卸下辅具信息（新增）
        int reval = iCOMPV01C01S010Service.saveLoadownMsg ( par );

        if (reval > 0) {
            respons.setStateCode ( IConstant.DEL_FLAG_0 );
            respons.setStateMsg ( "请求成功" );
        } else {
            respons.setStateCode ( IConstant.STRING_1 );
        }

        return respons;
    }

    @Override
    public C01S010Respons getSynthesisToolByupload(C01S010Request request) throws Exception {
        //TOCO取得合成刀组成信息（安上新增）
        // 取得合成刀组成信息（新增）
        C01S010Respons respons = new C01S010Respons ();
        // 参数验证
        if (StringUtils.isEmpty ( request.getRfidCode () )) {
            throw new BusinessException ( IConstant.WMSG0221, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE );
        }

        Rfidcontainer entity = new Rfidcontainer ();
        // RFID标签
        entity.setRfidCode ( request.getRfidCode () );
        // 删除区分
        entity.setDelFlag ( IConstant.DEL_FLAG_0 );

        // 验证RFID标签是否存在
        Rfidcontainer reVal = service.getRfidContainerByRfidCode ( entity );
        if (reVal == null) {
            respons.setStateCode ( IConstant.STRING_4 );
            respons.setStateMsg ( "当前标签未初始化" );
            return respons;
        } else if (!IConstant.STRING_2.equals ( reVal.getQueryType () )) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "请扫描合成刀具" );
            return respons;
        }

        //流利控制
        param = new HashMap<String, String> ();
        param.put ( "businessCode", IConstant.C01S007 );
        param.put ( "rfidCode", request.getRfidCode () );
        param.put ( "gruantUserID", request.getGruantUserID () );
        Map<String, String> reBuss = service.processControlBussinesCode ( param );
        if (reBuss == null) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "查询失败，请联系管理员" );
            return respons;
        } else {
            //0 正常流程 1.需要授权 2.不能执行当前流程 9.未知错误
            String buss = reBuss.get ( IConstant.STATE_CODE );
            if (IConstant.STRING_1.equals ( buss )) {
                respons.setStateCode ( IConstant.STRING_5 );
                respons.setStateMsg ( "需要授权" );
                return respons;
            } else if (IConstant.STRING_2.equals ( buss ) || IConstant.BAND_TYPE_9.equals ( buss )) {
                respons.setStateCode ( IConstant.STRING_1 );
                respons.setStateMsg ( reBuss.get ( IConstant.STATE_MSG ) );
                return respons;
            }
        }
        if (request.getGruantUserID () != null) {
            //  授权记录插入
            Authorization auth = new Authorization ();
            //授权人ID
            auth.setAuthorizationUserID ( request.getGruantUserID () );
            //授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它）
            auth.setAuthorizedReason ( IConstant.STRING_5 );
            //刀具类型（0单品，1合成刀具）
            auth.setTooltype ( IConstant.DEL_FLAG_1 );
            //材料号或合成刀具编码
            if (reBuss.get ( "toolCode" ) != null) {
                auth.setToolCode ( reBuss.get ( "toolCode" ) );
            }

            //业务流程编码
            auth.setBusinessCode ( IConstant.C01S006 );
            auth.setCreateUserID ( request.getCustomerID () );
            //备注
            auth.setNote ( "刀具卸下辅具" );
            service.innsetGruant ( auth );
        }
        //载体id
        String RfidContainerID = reVal.getRfidContainerID ();
        Tooltransfer tt = new Tooltransfer ();
        tt.setRfidContainerID ( RfidContainerID );
        tt.setDelFlag ( IConstant.DEL_FLAG_0 );
        int reCount = iCOMPV01C01S010Service.getTooltransferCount ( tt );
        if (reCount > 1) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "当前合成刀具不能执行该流程" );
            return respons;
        }

        // 合成刀库
        Synthesisknife syentity = new Synthesisknife ();
        syentity.setrFID ( RfidContainerID );
        // 删除区分
        syentity.setDelFlag ( IConstant.DEL_FLAG_0 );
        // 根据载体id查询合成刀具编码
        Synthesisknife skentity = iCOMPV01C01S010Service.getSynthesisknife ( syentity );
        // 合成刀具类型（0热套，1复合刀具）
        respons.setSynthesisParametersType ( skentity.getExpandSpace1 () );
        // 合成刀具编码
        respons.setSynthesisParametersCode ( skentity.getSynthesisParametersCode () );
/*
        // 刀具流转表
        Tooltransfer tfentity = new Tooltransfer ();
        // RFID(RFID载体ID.只有的位置0上有)
        tfentity.setRfidContainerID ( RfidContainerID );
        // 删除区分
        tfentity.setDelFlag ( IConstant.DEL_FLAG_0 );
        // 获取刀具ID和数量
        List<Tooltransfer> tooltransfer = iCOMPV01C01S010Service.getSynthesisknifeToolMsg ( tfentity );

        if (tooltransfer == null || tooltransfer.size () < 1) {
            throw new BusinessException ( "WMSG0151", request.getLanguageCode (), request.getLanguageValue () );
        }
        // 输出的刀具list
        List<OutputTool> retlist = new ArrayList<OutputTool> ();
        OutputTool tool = null;
        for (Tooltransfer tf : tooltransfer) {
            tool = new OutputTool ();
            // 刀具id
            tool.setToolID ( tf.getToolID () );
            // 数量
            tool.setToolCount ( tf.getToolDurable () );
            // 材料号
            tool.setMaterialNum ( tf.getExpandSpace1 () );
            // 刀具类型
            tool.setToolType ( tf.getToolState () );
            retlist.add ( tool );
        }
        if (tooltransfer != null && tooltransfer.size () > 0) {
            respons.setToolID ( tooltransfer.get ( 0 ).getToolID () );
            //单品ID
            respons.setToolCode ( tooltransfer.get ( 0 ).getKnifeInventoryCode () );
        }
        respons.setOutputTool ( retlist );*/
        respons.setStatus ( IConstant.ZERO );
        respons.setStateCode ( IConstant.STRING_0 );
        respons.setStateMsg ( "请求成功" );
        return respons;
    }

    @Override
    public C01S010Respons getSynthesisToolByCode(C01S010Request request) throws Exception {
        // 根据合成刀具编码查询刀具信息（安上）
        C01S010Respons respons = new C01S010Respons ();
        // 参数验证
        if (StringUtils.isEmpty ( request.getSynthesisParametersCode () )) {
            throw new BusinessException ( IConstant.WMSG0221, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE );
        }
        List<SynthesisEntity> outputToolList = new ArrayList<> ();
        SynthesisEntity reEnt = null;
        Map<String, Object> parMap = new HashMap<String, Object> ();
        //合成刀具编码（输入类型为1时，必须传入）
        parMap.put ( "synthesisParametersCode", request.getSynthesisParametersCode () );
        //按合成刀具编码查询合成刀具信息
        List<Vsynthesisparameters> reVal = iCOMPV01C03S001Service.getSynLocationMsgs ( parMap );
        if (reVal == null || reVal.size () < 1) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "未找到当前合成刀具编码信息" );
            return respons;
        } else {
            for (Vsynthesisparameters vp : reVal) {
                reEnt = new SynthesisEntity ();
                //材料号
                reEnt.setToolCode ( vp.getToolCode () );
                //数量
                if (null == vp.getTempToolCode ()) {
                    vp.setTempToolCode ( IConstant.STRING_0 );
                }
                reEnt.setCounts ( Integer.parseInt ( vp.getTempToolCode () ) );
                //组成类型(0刀片1钻头2复合刀具3热套类)
                reEnt.setCutterType ( vp.getToolPic () );
                if (!IConstant.STRING_0.equals ( vp.getSynthesisCutterNumber () )) {
                    //刀具编码
                    respons.setToolCode ( vp.getToolCode () );
                    respons.setSynthesisParametersCode ( vp.getSynthesisParametersCode () );
                    respons.setSynthesisParametersType ( vp.getVersion () + "" );
                }
                outputToolList.add ( reEnt );
            }
        }
        respons.setInputToolList ( outputToolList );
        respons.setStateCode ( IConstant.DEL_FLAG_0 );
        respons.setStateMsg ( "查询成功" );
        return respons;
    }

    @Override
    public C01S010Respons saveUploadingMsg(C01S010Request request) throws Exception {
        // 提交刀具安上辅具信息
        C01S010Respons respons = new C01S010Respons ();
        Map<String, String> map = new HashMap<String, String> ();
        // //0：钻头，1刀片
        String flag = request.getFlag ();
        if (IConstant.STRING_1.equals ( flag )) {
            if (checkParam ( request, 5 )) {
                throw new BusinessException ( IConstant.WMSG0221, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE );
            }
        } else {
            // 参数验证
            if (checkParam ( request, 4 )) {
                throw new BusinessException ( IConstant.WMSG0221, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE );
            }
            Rfidcontainer entity = new Rfidcontainer ();
            // RFID标签
            entity.setRfidCode ( request.getSingleToolRfid () );
            // 删除区分
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );

            // 验证RFID标签是否存在
            Rfidcontainer reVal = service.getRfidContainerByRfidCode ( entity );
            if (reVal == null || (!IConstant.STRING_1.equals ( reVal.getQueryType () ))) {
                respons.setStateCode ( IConstant.DEL_FLAG_1 );
                respons.setStateMsg ( "请扫描单品刀具" );
                return respons;
            }
            //单品刀具
            map.put ( "singerConneterID", reVal.getRfidContainerID () );
        }
        String ToolID = service.getToolIDByToolCode ( request.getToolCode () );

        //合成刀具RFID载体
        map.put ( "synthesConnterID", service.getrfidContainerIdByRfid ( request.getRfidCode () ) );
        map.put ( "synthesConnterCode", request.getSynthesisParametersCode () );
        //用户ID
        map.put ( "userID", request.getCustomerID () );
        //刀具ID
        map.put ( "toolID", ToolID );
        //手持机id
        map.put ( "handSetId", request.getHandSetId () );
           //0：未初始化同，1已初始化
        map.put ( "init", request.getQueryType () );
        // //0：钻头，1刀片
        map.put ( "flag", flag );
        // 提交刀具安上辅具信息
        int reval = iCOMPV01C01S010Service.saveUploadingMsg ( map );

        if (reval > 0) {
            respons.setStateCode ( IConstant.DEL_FLAG_0 );
            respons.setStateMsg ( "请求成功" );
        } else if (reval == -3) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "您扫描的单品刀具和要安上的单品刀具不一致" );
        } else if (reval == -4) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "材料号" + request.getToolCode () + "对刀室备刀数量不足，请补充" );
        } else if (reval == -5) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "请扫描备用刀单品刀具" );
        } else {
            respons.setStateCode ( IConstant.STRING_1 );
        }

        return respons;
    }

    @Override
    public C01S010Respons deleteRfidByToolID(C01S010Request request) throws Exception {
        // 提交刀具安上辅具信息
        C01S010Respons respons = new C01S010Respons ();
        Map<String, Object> map = new HashMap<String, Object> ();

        // 参数验证
        if (checkParam ( request, 6 )) {
            throw new BusinessException ( IConstant.WMSG0221, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE );
        }
        //刀具类型(0:钻头1一次性)
        String flag = request.getToolType ();

        String ToolID = service.getToolIDByToolCode ( request.getToolCode () );

        //用户ID
        map.put ( "userID", request.getCustomerID () );
        //刀具ID
        map.put ( "toolID", ToolID );
        //手持机id
        map.put ( "handSetId", request.getHandSetId () );
        // //0：钻头，1刀片
        map.put ( "flag", flag );

        map.put ( "rfidList", request.getRfidCodeList () );
        for (String rfigstring : request.getRfidCodeList ()) {
            Rfidcontainer entity = new Rfidcontainer ();
            // RFID标签
            entity.setRfidCode ( request.getRfidCode () );
            // 删除区分
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            // 验证RFID标签是否存在
            Rfidcontainer reVal = service.getRfidContainerByRfidCode ( entity );
            if (reVal == null) {
                respons.setStateCode ( IConstant.STRING_4 );
                respons.setStateMsg ( "当前标签未初始化" );
                return respons;
            }
        }

        // 删除备刀库的刀具信息
        int reval = iCOMPV01C01S010Service.deleteRfidByToolID ( map );

        if (reval > 0) {
            respons.setStateCode ( IConstant.DEL_FLAG_0 );
            respons.setStateMsg ( "请求成功" );
        } else if (reval == -1) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "材料号" + request.getToolCode () + "对刀室备刀数量不足，请补充" );
        }
        return respons;
    }

    @Override
    public C01S010Respons seachToolMsg(C01S010Request request) throws Exception {
        // 提交刀具安上辅具信息
        C01S010Respons respons = new C01S010Respons ();
        Map<String, String> map = new HashMap<String, String> ();

        // 参数验证
        if (checkParam ( request, 7 )) {
            throw new BusinessException ( IConstant.WMSG0221, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE );
        }
        Rfidcontainer entity = new Rfidcontainer ();
        // RFID标签
        entity.setRfidCode ( request.getRfidCode () );
        // 删除区分
        entity.setDelFlag ( IConstant.DEL_FLAG_0 );
        // 验证RFID标签是否存在
        Rfidcontainer reVal = service.getRfidContainerByRfidCode ( entity );
        if (reVal == null) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "当前标签未初始化" );
            return respons;
        }
        //是否是单品刀具
        if (!IConstant.STRING_1.equals ( reVal.getQueryType () )) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "请扫描单品刀具" );
            return respons;
        }
        map.put ( "rfidConnerID", reVal.getRfidContainerID () );
        map.put ( "toolID", service.getToolIDByToolCode ( request.getToolCode () ) );
        //验证扫描的是否和安上的刀具相符合
        int reValInt = iCOMPV01C01S010Service.seachToolMsg ( map );
        if (reValInt > 0) {
            respons.setStateCode ( IConstant.STRING_0 );
        } else if (reValInt == -1) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "请扫描单品刀具和要安上的刀具查材料号不一致" );
        } else {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "请扫描备用刀单品刀具" );
        }

        return respons;
    }

    @Override
    public C01S010Respons saveGrindingBitInfo(C01S010Request request) throws Exception {
        //提交可复磨钻头的信息
        C01S010Respons respons = new C01S010Respons ();
        //用户ID
        //合成刀具RFID

        //list<GrindingBitInfo>
        //单品刀具RFID
        //材料号
        //刀具类型

        return respons;

    }

    /**
     * 刀具换装最后提交
     */
    @Override
    public C01S010Respons saveSubmit(C01S010Request request) throws Exception {
        C01S010Respons respons = new C01S010Respons ();
        // 如果存在换装时不卸下刀具的情况
        if ("0".equals ( request.getFlag () )) {
            try {
                // 合成刀具的载体id
                String synthesisContainerId = service.getrfidContainerIdByRfid ( request.getSynthesisParametersRfid () );
                String userId = request.getCustomerID ();
                int val = 0;
                val = iCOMPV01C01S010Service.saveSubmitWithoutUnload ( synthesisContainerId, userId );
                if (val < 1) {
                    respons.setStateCode ( IConstant.STRING_1 );
                    respons.setStateMsg ( "提交数据失败" );
                    return respons;
                }
                respons.setStateCode ( IConstant.STRING_0 );
                respons.setStateMsg ( "刀具换装完成" );
                return respons;
            } catch (Exception e) {
                respons.setStateCode ( IConstant.STRING_1 );
                respons.setStateMsg ( "提交数据失败" );
                return respons;
            }
        }
        // 存放从Android前端传送过来的值
        Map<String, Object> map = new HashMap<String, Object> ();
        // 存放报废丢刀信息的列表
        List<ScanGrinding> scrapMsgs = new ArrayList<ScanGrinding> ();
        // 存放刃磨刀片信息的列表
        List<ScanGrinding> grindingMsgs = new ArrayList<ScanGrinding> ();
        // 存放刃磨钻头信息的列表
        List<GrindingBitMsge> grindingBitMsgs = new ArrayList<GrindingBitMsge> ();
        // 如果有报废丢刀信息
        if (request.getScrapContainerRfid () != null && request.getScrapMsgs ().size () > 0) {
            // 遍历list存放到scrapMsgs中，传给service
            for (ScanGrindingMsg sgm : request.getScrapMsgs ()) {
                ScanGrinding sg = new ScanGrinding ();
                sg.setToolCode ( sgm.getToolCode () );//材料号
                sg.setToolType ( sgm.getToolType () );//刀具类型(0:钻头1可刃磨2一次性)
                sg.setNumbers ( sgm.getNumbers () );//丢刀数量或报废数量
                sg.setThisStaic ( sgm.thisStaic );//刀具状态(0:报废,1.丢刀)
                scrapMsgs.add ( sg );
            }
            map.put ( "scrapMsgs", scrapMsgs );
        }
        // 如果有可刃磨钻头信息
        GrindingBitMsge GBM = null;
        if (request.getGrindingBitMsgs () != null && request.getGrindingBitMsgs ().size () > 0) {
            for (GrindingBitMsg gbm : request.getGrindingBitMsgs ()) {
                GBM = new GrindingBitMsge ();
                GBM.setToolCode ( gbm.getToolCode () );
                GBM.setRfidCode ( gbm.getRfidCode () );
                grindingBitMsgs.add ( GBM );
            }
            map.put ( "grindingBitMsgs", grindingBitMsgs );
        }
        // 如果有可刃磨刀片信息
        if (request.getGrindingContainerRfid () != null && request.getGrindingMsgs () != null && request.getGrindingMsgs ().size () > 0) {
            // 遍历list存放到grindingMsgs中，传给service
            for (ScanGrindingMsg sgm : request.getGrindingMsgs ()) {
                ScanGrinding sg = new ScanGrinding ();
                sg.setToolCode ( sgm.getToolCode () );//材料号
                sg.setToolType ( sgm.getToolType () );//刀具类型(1可刃磨刀片)
                sg.setNumbers ( sgm.getNumbers () );//刃磨数量
                sg.setThisStaic ( sgm.thisStaic );//刀具状态(2:刃磨)
                grindingMsgs.add ( sg );
            }
            map.put ( "grindingMsgs", grindingMsgs );
        }
        map.put ( "userId", request.getCustomerID () );
        map.put ( "handSetId", request.getHandSetId () );
        if (request.getGruantUserID () != null) {
            map.put ( "signId", request.getGruantUserID () );
        }
        // 报废容器的rfid
        if (request.getScrapContainerRfid () != null) {
            map.put ( "scrapContainerRfid", request.getScrapContainerRfid () );
        }
        // 刃磨容器的rfid
        if (request.getGrindingContainerRfid () != null) {
            map.put ( "grindingContainerRfid", request.getGrindingContainerRfid () );
        }

        // 合成刀具rfid载体
        map.put ( "synthesisParametersRfid", service.getrfidContainerIdByRfid ( request.getSynthesisParametersRfid () ) );
        // 合成刀具编码
        map.put ( "synthesisParametersCode", request.getSynthesisParametersCode () );

        String reval = IConstant.STRING_0;
        try {
            reval = iCOMPV01C01S010Service.saveSubmit ( map );
            if (IConstant.DEL_FLAG_0.equals ( reval )) {
                if (request.getGruantUserID () != null) {
                    //  授权记录插入
                    Authorization auth = new Authorization ();
                    //授权人ID
                    auth.setAuthorizationUserID ( request.getGruantUserID () );
                    //授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它）
                    auth.setAuthorizedReason ( IConstant.STRING_1 );
                    //刀具类型（0单品，1合成刀具）
                    auth.setTooltype ( IConstant.DEL_FLAG_0 );
                    //材料号或合成刀具编码
                    auth.setToolCode ( request.getSynthesisParametersCode () );
                    //业务流程编码
                    auth.setBusinessCode ( IConstant.C01S010 );
                    auth.setCreateUserID ( request.getCustomerID () );
                    //备注
                    auth.setNote ( "刀具换装丢刀授权" );
                    service.innsetGruant ( auth );
                }
                respons.setStateCode ( IConstant.STRING_0 );
                respons.setStateMsg ( "刀具换装完成" );
            } else if (IConstant.STRING_1.equals ( reval )) {
                respons.setStateCode ( IConstant.STRING_1 );
                respons.setStateMsg ( "提交数据失败" );
            } else if (IConstant.STRING_2.equals ( reval )) {
                respons.setStateCode ( IConstant.STRING_1 );
                respons.setStateMsg ( "未找到装备用刀的容器" );
            } else if (IConstant.STRING_3.equals ( reval )) {
                respons.setStateCode ( IConstant.STRING_1 );
                respons.setStateMsg ( "刀具编码不存在，无法补充周转量" );
            } else {
                respons.setStateCode ( IConstant.STRING_1 );
                respons.setStateMsg ( "刀具编码" + reval + "对刀室流转数量不足" );
            }

        } catch (Exception e) {
            e.printStackTrace ();
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "提交数据失败" );
        }
        return respons;
    }

    /**
     * 查询刃磨容器的Rfid
     */
    @Override
    public C01S010Respons searchByGrindingContainerRfid(C01S010Request request) throws Exception {
        C01S010Respons respons = new C01S010Respons ();
        if (request.getGrindingContainerRfid () == null) {
            throw new BusinessException ( IConstant.CEMSG0005, request.getLanguageCode (), request.getLanguageValue () );
        }
        //0:非容器 1:其它类型容器 2:待分拣容器 3:空标签
        String toolType = iCOMPV01C01S010Service.getRfidType ( request.getGrindingContainerRfid (), request.getCustomerID (), IConstant.STRING_2 );
        if (!IConstant.STRING_2.equals ( toolType )) {
            //请扫描装刃磨刀具的待分拣容器!
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "请扫描装刃磨刀具的待分拣容器" );
            return respons;
        }
        respons.setStateCode ( IConstant.STRING_0 );
        respons.setStateMsg ( "获取成功" );
        return respons;
    }

    /**
     * 查询报废容器的RFID
     */
    @Override
    public C01S010Respons searchByScrapContainerRfid(C01S010Request request) throws Exception {
        C01S010Respons respons = new C01S010Respons ();
        if (request.getScrapContainerRfid () == null) {
            throw new BusinessException ( IConstant.CEMSG0005, request.getLanguageCode (), request.getLanguageValue () );
        }
        //0:非容器 1:其它类型容器 2:报废容器 3:空标签
        String toolType = iCOMPV01C01S010Service.getRfidType ( request.getScrapContainerRfid (), request.getCustomerID (), IConstant.STRING_1 );
        if (!IConstant.STRING_2.equals ( toolType )) {
            //请扫描装报废刀具的报废容器!
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "请扫描装报废刀具的报废容器" );
            return respons;
        }

        respons.setStateCode ( IConstant.STRING_0 );
        respons.setStateMsg ( "获取成功" );
        return respons;
    }

    /**
     * 查询盛放可刃磨钻头的刀盒的信息
     */
    @Override
    public C01S010Respons searchGrindingBitInfo(C01S010Request request) throws Exception {
        C01S010Respons respons = new C01S010Respons ();
        if (request.getRfidCode () == null) {
            throw new BusinessException ( IConstant.CEMSG0005, request.getLanguageCode (), request.getLanguageValue () );
        }
        // 空标签
        Rfidcontainer rfidcontainer = new Rfidcontainer ();
        rfidcontainer.setRfidCode ( request.getRfidCode () );
        rfidcontainer.setDelFlag ( IConstant.STRING_0 );
        rfidcontainer = service.getRfidContainerByRfidCode ( rfidcontainer );
        if (rfidcontainer == null) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "当前标签未初始化" );
            return respons;
        }

        // 非单品刀具标签
        if (!IConstant.STRING_1.equals ( rfidcontainer.getQueryType () )) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "请扫描单品刀具" );
            return respons;
        }

        // 查询该单品刀具是否是流转中的待换装刀具
        Tooltransfer tt = new Tooltransfer ();
        tt.setRfidContainerID ( rfidcontainer.getRfidContainerID () );
        // 刀具部门：对刀室
        tt.setToolThisState ( IConstant.STRING_1 );
        // 库存状态：流转
        tt.setStockState ( IConstant.STRING_4 );
        // 删除区分
        tt.setDelFlag ( IConstant.STRING_0 );
        tt = iCOMPV01C01S010Service.getTooltransfer ( tt );
           if (tt.isRetErrFlag ()){
        	   //如果对刀室没有就去车间查询
        	   Tooltransfer tt2 = new Tooltransfer ();
               tt2.setRfidContainerID ( rfidcontainer.getRfidContainerID () );
               // 刀具部门：车间
               tt2.setToolThisState ( IConstant.STRING_3 );
               // 库存状态：流转
               tt2.setStockState ( IConstant.STRING_4 );
               // 删除区分
               tt2.setDelFlag ( IConstant.STRING_0 );
               tt = iCOMPV01C01S010Service.getTooltransfer ( tt2 );
           }
        if (tt.isRetErrFlag ()) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "扫描的单品刀具不是流转中的刀具" );
            return respons;
        } else {
            HashMap<String, String> param1 = new HashMap<String, String> ();
            param1.put ( "businessCode", IConstant.C01S010 );
            param1.put ( "rfidCode", request.getRfidCode () );
            param1.put ( "gruantUserID", request.getGruantUserID () );
            Map<String, String> reBuss = service.processControlBussinesCode ( param1 );
            if (reBuss == null) {
                respons.setStateCode ( IConstant.DEL_FLAG_1 );
                respons.setStateMsg ( "查询失败，请联系管理员" );
                return respons;
            } else {
                //0 正常流程 1.需要授权 2.不能执行当前流程 9.未知错误
                String buss = reBuss.get ( IConstant.STATE_CODE );
                if (IConstant.STRING_1.equals ( buss )) {
                    respons.setStateCode ( IConstant.STRING_5 );
                    respons.setStateMsg ( "需要授权" );
                    return respons;
                } else if (IConstant.STRING_2.equals ( buss ) || IConstant.BAND_TYPE_9.equals ( buss )) {
                    respons.setStateCode ( IConstant.STRING_1 );
                    respons.setStateMsg ( reBuss.get ( IConstant.STATE_MSG ) );
                    return respons;
                }
            }
            if (request.getGruantUserID () != null) {
                //  授权记录插入
                Authorization auth = new Authorization ();
                //授权人ID
                auth.setAuthorizationUserID ( request.getGruantUserID () );
                //授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它）
                auth.setAuthorizedReason ( IConstant.STRING_5 );
                //刀具类型（0单品，1合成刀具）
                auth.setTooltype ( IConstant.DEL_FLAG_0 );
                //材料号或合成刀具编码
                if (reBuss.get ( "toolCode" ) != null) {
                    auth.setToolCode ( reBuss.get ( "toolCode" ) );
                }
                //业务流程编码
                auth.setBusinessCode ( IConstant.C01S010 );
                auth.setCreateUserID ( request.getCustomerID () );
                //备注
                auth.setNote ( "重复换装" );
                service.innsetGruant ( auth );
            }

            // 材料号
            Tool tool = new Tool ();
            tool.setToolID ( tt.getToolID () );
            tool.setDelFlag ( IConstant.STRING_0 );
            tool = iCOMPV01C01S010Service.getTool ( tool );
            if (tool.isRetErrFlag ()) {
                respons.setStateCode ( IConstant.STRING_1 );
                respons.setStateMsg ( "未找到材料号" );
                return respons;
            }
            respons.setToolCode ( tool.getToolCode () );
        }

        // 返回查询刀盒rfid的信息
        respons.setStateCode ( IConstant.STRING_0 );
        respons.setStateMsg ( "查询成功" );
        return respons;
    }


}
