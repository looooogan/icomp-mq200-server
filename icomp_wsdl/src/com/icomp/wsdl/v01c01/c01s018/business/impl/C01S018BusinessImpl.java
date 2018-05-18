package com.icomp.wsdl.v01c01.c01s018.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c01.s018.ICOMPV01C01S018Service;
import com.icomp.entity.base.Authorization;
import com.icomp.entity.base.Noticeequipment;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Toolnoticehistory;
import com.icomp.entity.base.TooltranarMassage;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Vgetgrindingonmsg;
import com.icomp.entity.base.Vgetnoticeequipmentlist;
import com.icomp.entity.base.Vgettoolinfolist;
import com.icomp.wsdl.v01c01.c01s018.business.C01S018Business;
import com.icomp.wsdl.v01c01.c01s018.endpoint.C01S018Request;
import com.icomp.wsdl.v01c01.c01s018.endpoint.C01S018Respons;
import com.icomp.wsdl.v01c01.c01s018.endpoint.GrindingEquipmentEntity;
import com.icomp.wsdl.v01c01.c01s018.endpoint.GrindingonmsgList;
import com.icomp.wsdl.v01c01.c01s018.endpoint.NoticeequipmentSelect;
import com.icomp.wsdl.v01c01.c01s018.endpoint.ToolNoticeInfo;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 刀具复磨安上-Business实现类
 *
 * @author Taoyy
 * @ClassName: C01S018BusinessImpl
 * @date 2014-9-23 下午03:26:15
 */
public class C01S018BusinessImpl implements C01S018Business {
    private C01S018Respons respons;

    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    /**
     * 取得修磨设备列表
     *
     * @param request
     * @return
     * @throws Exception
     */

    @Override
    public C01S018Respons getGrindingEqulist(C01S018Request request) throws Exception {
        C01S018Respons respons = new C01S018Respons ();
        try {
            //修磨设备列表
            List<GrindingEquipmentEntity> equipments = new ArrayList<GrindingEquipmentEntity> ();
            GrindingEquipmentEntity reEntity = null;
            // 返回修磨设备列表
            List<Vgetnoticeequipmentlist> reList = iCOMPV01C01S018Service.getNoticeEquipmentList ();
            if (reList == null || reList.size () < 1) {
                respons.setStateCode ( IConstant.DEL_FLAG_1 );
                respons.setStateMsg ( "未找到修磨设备列表信息或未绑定设备标签" );
                return respons;
            } else {
                for (Vgetnoticeequipmentlist v : reList) {
                    reEntity = new GrindingEquipmentEntity ();
                    //修磨设备id
                    reEntity.setEquipmentID ( v.getNoticeEquipmentID () );
                    //设备名称
                    reEntity.setEquipmentName ( v.getEquipmentName () );
                    //RFID
                    reEntity.setEquipmentRfid ( v.getRfidCode () );
                    //设备类型（3钻头，4刀片）
                    //reEntity.setEquipmenttype(v.getEquipmentType());
                    equipments.add ( reEntity );
                }
                respons.setEquipments ( equipments );
            }
            respons.setStateCode ( IConstant.STOCK_STATE_0 );
            respons.setStateMsg ( "查询成功" );
        } catch (Exception e) {
            respons.setStateCode ( IConstant.STOCK_STATE_1 );
            respons.setStateMsg ( "获取异常" );
        }
        return respons;
    }

    /**
     * 取得修磨刀具的信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S018Respons getGrindingToolsInfo(C01S018Request request) throws Exception {
        C01S018Respons respons = new C01S018Respons ();
        try {
            // 参数验证
            if (StringUtils.isEmpty ( request.getRfidCode () )) {
                throw new BusinessException ( IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH );
            }
            // 不是单品刀具
            if (!IConstant.DEL_FLAG_1.equals ( request.getRfidType () )) {
                throw new BusinessException ( IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH );
            }
            // 查询刀具载体
            Rfidcontainer rfe = new Rfidcontainer ();
            rfe.setRfidCode ( request.getRfidCode () );
            // 标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
            rfe.setQueryType ( IConstant.BAND_TYPE_1 );
            rfe.setDelFlag ( IConstant.DEL_FLAG_0 );
            String rfidConner = service.getRfidContainerIDByRfidCode ( rfe );
            if (null == rfidConner) {
                respons.setStateCode ( IConstant.DEL_FLAG_1 );
                respons.setStateMsg ( "请扫描待修磨的单品刀具" );
                return respons;
            }
            Map<String, String> param1 = new HashMap<String, String> ();
            param1.put ( "businessCode", IConstant.C01S018 );
            param1.put ( "rfidCode", request.getRfidCode () );
            param1.put ( "gruantUserID", request.getGruantUserID () );
            Map<String, String> reBuss = service.processControlBussinesCode ( param1 );
            if (reBuss == null) {
                respons.setStateCode ( IConstant.DEL_FLAG_1 );
                respons.setStateMsg ( "查询失败，请联系管理员" );
                return respons;
            } else {
                if (reBuss.get ( "ToolID" ) != null) {
                    //修磨类别(0:厂内修磨，1厂外修磨，2厂外涂层
                    Tool reTool = service.getToolsByID ( reBuss.get ( "ToolID" ) );
                    if (reTool != null && reTool.getToolGrinding () != null) {
                        if (IConstant.STRING_1.equals ( reTool.getToolGrinding () )) {
                            respons.setStateCode ( IConstant.STRING_1 );
                            respons.setStateMsg ( "您扫描的单品刀具是厂外修磨刀具" );
                            return respons;
                        }
                    }
                }
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
                auth.setAuthorizedReason ( IConstant.STRING_6 );
                //刀具类型（0单品，1合成刀具）
                auth.setTooltype ( IConstant.DEL_FLAG_0 );
                //材料号或合成刀具编码
                if (reBuss.get ( "toolCode" ) != null) {
                    auth.setToolCode ( reBuss.get ( "toolCode" ) );
                }
                //业务流程编码
                auth.setBusinessCode ( IConstant.C01S018 );
                auth.setCreateUserID ( request.getCustomerID () );
                //备注
                auth.setNote ( "重复修磨" );
                service.innsetGruant ( auth );
            }

            Vgettoolinfolist vv = new Vgettoolinfolist ();
            vv.setRfidContainerID ( rfidConner );
            //            vv.setToolState(IConstant.TOOL_STATE_6);//厂内待刃磨
            Vgettoolinfolist reList = iCOMPV01C01S018Service.getToolInfoList ( vv );
            if (reList.isRetErrFlag ()) {
                respons.setStateCode ( IConstant.DEL_FLAG_1 );
                respons.setStateMsg ( "请扫描厂内待修磨的单品刀具" );
                return respons;
            }
            //刀具id
            respons.setToolID ( reList.getToolID () );
            //刀具编码（材料号）
            respons.setMaterialNu ( reList.getToolCode () );
            respons.setStateCode ( IConstant.STOCK_STATE_0 );
            respons.setStateMsg ( "查询成功" );
        } catch (Exception e) {
            respons.setStateCode ( IConstant.STOCK_STATE_1 );
            respons.setStateMsg ( "获取异常" );
        }
        return respons;
    }

    /**
     * 提交刀具修磨设备信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S018Respons submitToolsGrindingEquInfo(C01S018Request request) throws Exception {
        C01S018Respons respons = new C01S018Respons ();

        // 参数验证
        if (checkParam ( request, 1 )) {
            throw new BusinessException ( IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH );
        }
        //放入list以外的值
        Toolnoticehistory entity = new Toolnoticehistory ();
        entity.setUpdateUser ( request.getCustomerID () );
        entity.setNoticeEquipmentID ( request.getNoticeEquipmentID () );
        entity.setExpandSpace1 ( request.getHandSetId () );
        //取得list里的值
        List<ToolNoticeInfo> toolNoticeInfoList = request.getToolNoticeInfoList ();
        List<Map<String, Object>> tooltfList = new ArrayList<Map<String, Object>> ();
        //循环加入map
        if (toolNoticeInfoList.size () > 0) {
            for (ToolNoticeInfo toolNoticeInfo : toolNoticeInfoList) {
                Map<String, Object> ibm = new HashMap<String, Object> ();
                ibm.put ( "ToolID", toolNoticeInfo.getToolID () );
                ibm.put ( "MaterialNum", toolNoticeInfo.getMaterialNum () );
                ibm.put ( "RfidCode", toolNoticeInfo.getRfidCode () );
                tooltfList.add ( ibm );
            }
        }
        Map<String, Object> ret = iCOMPV01C01S018Service.submitToolsGrindingEquInfo ( tooltfList, entity );
        if (Integer.parseInt ( ret.get ( "status" ).toString () ) < 0) {
            throw new BusinessException ( ret.get ( "messagetext" ).toString (), request.getLanguageCode (), request.getLanguageValue () );
        }
        respons.setStateCode ( IConstant.DEL_FLAG_0 );
        respons.setStateMsg ( "修磨成功" );
        return respons;
    }

    /**
     * 参数验证
     */
    private boolean checkParam(C01S018Request request, int i) {
        // 用户ID
        if (StringUtils.isEmpty ( request.getCustomerID () )) {
            return true;
        }
        // 修磨设备ID
        if (StringUtils.isEmpty ( request.getNoticeEquipmentID () )) {
            return true;
        }
        //修磨刀具信息
        if (i == 1) {
            if (null == request.getToolNoticeInfoList () || request.getToolNoticeInfoList ().size () < 1)
                return true;
        }

        return false;
    }

    /**
     * 刀具复磨安上-Service接口
     */
    private ICOMPV01C01S018Service iCOMPV01C01S018Service;

    public void setiCOMPV01C01S018Service(ICOMPV01C01S018Service iCOMPV01C01S018Service) {
        this.iCOMPV01C01S018Service = iCOMPV01C01S018Service;
    }

    /**
     * 取得刀具复磨按上信息
     * getToolInfo
     *
     * @param
     * @return
     * @throws Exception
     */
    public C01S018Respons getToolInfo(C01S018Request request) throws Exception {
        respons = new C01S018Respons ();// 返回参数
        Vgetgrindingonmsg entity = new Vgetgrindingonmsg ();// VIEW实体类
        NoticeequipmentSelect nes = new NoticeequipmentSelect ();// 刃磨实体类
        List<NoticeequipmentSelect> nesList = new ArrayList<NoticeequipmentSelect> ();// 刃磨实体类list
        GrindingonmsgList gl = new GrindingonmsgList ();//刃磨安上实体类
        List<GrindingonmsgList> gls = new ArrayList<GrindingonmsgList> ();//list

        // 参数验证
        boolean retParams = false;
        if (request.getCustomerID () == null || request.getCustomerID () == "") {
            retParams = true;// 用户ID
        }
        if (request.getLanguageCode () == null || request.getLanguageCode () == "") {
            retParams = true;// 语言编码（01）
        }
        if (request.getLanguageValue () == null || request.getLanguageValue () == "") {
            retParams = true;// 语言值（zh_en）
        }
        if (request.getRfidString () == null || request.getRfidString () == "") {
            retParams = true;// 扫描的rfid标签
        }
        if (retParams) {
            //参数异常
            throw new BusinessException ( IConstant.CEMSG0005, request.getLanguageCode (), request.getLanguageValue () );
        }

        //判断扫描的刀具类型
        if (request.getRfidString () != null && !"".equals ( request.getRfidString ().trim () )) {
            String toolType = service.getToolsTypeByRfid ( request.getRfidString () );
            if (toolType.equals ( IConstant.TOOL_KIND_0 )) { //未初始化
                throw new BusinessException ( IConstant.WMSG0247, request.getLanguageCode (), request.getLanguageValue () );
            }
            if (!toolType.equals ( IConstant.TOOL_KIND_2 )) {
                throw new BusinessException ( IConstant.WMSG0245, request.getLanguageCode (), request.getLanguageValue () );
            }
        }

        // 赋值
        entity.setRfidCode ( request.getRfidString () );// 扫描的rfid标签
        // 取得并判断刀具当前扫描刀具是否可以进行【复磨安上】业务
        Map<String, Object> ret = service.checkToolStauts ( request.getRfidString (), "C01S018", request.getLanguageCode () );
        if (ret.size () > 0 && !(Boolean.valueOf ( ret.get ( "agreeFlag" ).toString () ).booleanValue ())) {
            if (ret.get ( "messageText" ) == null) {
                throw new BusinessException ( (String) ret.get ( "messageCode" ), request.getLanguageCode (), request.getLanguageValue () );
            } else {
                throw new BusinessException ( (String) ret.get ( "messageCode" ), request.getLanguageCode (), request.getLanguageValue (), (String) ret.get ( "newFlowText" ), (String) ret.get ( "lastFlowText" ), (String) ret.get ( "messageText" ) );
            }
        }

        //取得刀具复磨按上信息
        List<Vgetgrindingonmsg> list = iCOMPV01C01S018Service.getToolInfo ( entity );
        Noticeequipment noticeequipment = new Noticeequipment ();
        noticeequipment.setDelFlag ( IConstant.DEL_FLAG_0 );
        //取得刃磨设备列表
        List<Noticeequipment> neList = iCOMPV01C01S018Service.searchByList ( noticeequipment );
        entity = list.get ( 0 );
        // 处理区分(true:成功 false:失败)
        if (entity.isRetErrFlag ()) {
            throw new BusinessException ( entity.getMessageCode (), request.getLanguageCode (), request.getLanguageValue () );
        }
        if (neList.get ( 0 ).isRetErrFlag ()) {
            throw new BusinessException ( IConstant.WMSG0142, request.getLanguageCode (), request.getLanguageValue () );
        } else {
            respons.setStatus ( IConstant.RESULT_CODE_0 );
            respons.setMessageText ( IConstant.CIMSG0063, request.getLanguageCode (), request.getLanguageValue () );
            respons.setToolType ( entity.getToolConsumetype () );//刀具类型
            respons.setKnifeInventoryCode ( entity.getKnifeInventoryCode () );//入库编码
            for (Noticeequipment nt : neList) {
                nes = new NoticeequipmentSelect ();
                nes.setNoticeEquipmentID ( nt.getNoticeEquipmentID () );//刃磨设备id
                nes.setEquipmentName ( nt.getEquipmentName () );//刃磨设备名称
                nes.setEquipmentType ( nt.getEquipmentType () ); //
                nesList.add ( nes );
            }
            respons.setNoticeEquipmentList ( nesList );//刃磨设备列表
            for (Vgetgrindingonmsg gom : list) {
                gl = new GrindingonmsgList ();
                gl.setRfidCode ( gom.getRfidCode () );//rfid
                gl.setKnifeInventoryCode ( gom.getKnifeInventoryCode () );//刀具入库编码
                gl.setRfidContainerID ( gom.getRfidContainerID () );//rfid载体Id
                gl.setStockState ( gom.getStockState () );//库存状态
                gl.setToolCode ( gom.getToolCode () );//刀具编码
                gl.setToolConsumetype ( gom.getToolConsumetype () );//消耗类别
                gl.setToolID ( gom.getToolID () );//刀具ID
                gl.setToolName ( gom.getToolName () );//刀具名称
                gl.setBusinessID ( gom.getBusinessID () );//业务流程中间表ID
                gls.add ( gl );
            }
            respons.setGrindingonmsgList ( gls );
        }
        return respons;
    }

    /**
     * 复磨刀具安上
     * saveNoticeToolload
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S018Respons saveNoticeToolload(C01S018Request request) throws Exception {
        respons = new C01S018Respons ();

        Map<String, Object> map = new HashMap<String, Object> ();
        // 参数验证
        if (retParams ( request )) {
            //参数异常
            throw new BusinessException ( IConstant.CEMSG0005, request.getLanguageCode (), request.getLanguageValue () );
        }
        map.put ( "RFID", request.getRfidString () );    //rfid
        map.put ( "CustomerID", request.getCustomerID () );//用户ID
        map.put ( "NoticeLength", request.getNoticeLength () );//修复前测量长度
        map.put ( "NoticeEquipmentID", request.getNoticeEquipmentID () );//刃磨设备Id
        map.put ( "HandSetId", request.getHandSetId () );//刃磨设备Id
        int reVal = 0;
        try {
            //复磨刀具安上
            reVal = iCOMPV01C01S018Service.toolScrapConfirmation ( map );
        } catch (Exception e) {
            throw new BusinessException ( IConstant.CEMSG0042, request.getLanguageCode (), request.getLanguageValue () );
        }
        if (reVal > 0) {
            respons.setStatus ( IConstant.RESULT_CODE_0 );
            respons.setMessageText ( IConstant.CIMSG0100, request.getLanguageCode (), request.getLanguageValue () );
        } else if (reVal == -1) {
            throw new BusinessException ( IConstant.CEMSG0041_1, request.getLanguageCode (), request.getLanguageValue () );
        } else {
            throw new BusinessException ( IConstant.CEMSG0041, request.getLanguageCode (), request.getLanguageValue () );
        }

        return respons;
    }

    /**
     * 取得报废盒子
     *
     * @param request
     */
    @Override
    public C01S018Respons getDiscardBox(C01S018Request request) throws Exception {
        respons = new C01S018Respons ();
        if (retParams ( request )) {
            //参数异常
            throw new BusinessException ( IConstant.CEMSG0005, request.getLanguageCode (), request.getLanguageValue () );
        }
        String toolType = service.checkIsHasDiscard ( request.getRfidString ().trim (), request.getCustomerID () );
        if (IConstant.STSATIC_TWO.equals ( toolType ) || IConstant.STSATIC_ZERO.equals ( toolType )) {
            respons.setStatus ( IConstant.ZERO );
        } else {
            throw new BusinessException ( IConstant.WMSG0245_1, request.getLanguageCode (), request.getLanguageValue () );
        }
        return respons;
    }

    /**
     * 取得盒子的数量
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S018Respons getToolInfoCount(C01S018Request request) throws Exception {
        respons = new C01S018Respons ();
        //取得盒子的数量
        int count = 0;
        try {
            count = iCOMPV01C01S018Service.getToolInfoCount ( request.getRfidString () );
        } catch (Exception e) {
            System.out.printf ( "C01S018BusinessImpl_getToolInfoCount" + e.toString () );
            throw new BusinessException ( IConstant.EMSG0002, request.getLanguageCode (), request.getLanguageValue () );
        }
        if (count > 0) {
            respons.setStatus ( IConstant.ZERO );
            respons.setScrapNumber ( count );
        } else {
            throw new BusinessException ( IConstant.EMSG0002, request.getLanguageCode (), request.getLanguageValue () );
        }
        return respons;
    }

    /**
     * 按刀具编码或物料号查询取得刃磨数量(非单品)
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S018Respons getToolCodeAndKivCode(C01S018Request request) throws Exception {
        respons = new C01S018Respons ();
        Map<String, Object> map = new HashMap<String, Object> ();
        if (retParams ( request )) {
            //参数异常
            throw new BusinessException ( IConstant.CEMSG0005, request.getLanguageCode (), request.getLanguageValue () );
        }
        try {
            String toolCode = request.getToolCode ();
            String kiCode = request.getKivCode ();
            map.put ( "toolCode", toolCode );
            map.put ( "kiCode", kiCode );
            //按刀具编码或物料号查询取得刃磨数量
            List<TooltranarMassage> reList = iCOMPV01C01S018Service.getToolCodeAndKivCode ( map );
            if (reList.size () > 0) {
                TooltranarMassage reVal = reList.get ( 0 );
                if (reVal.getCustomerCode () != null) {
                    respons.setKivCode ( reVal.getCustomerCode () );
                } else {
                    respons.setKivCode ( reVal.getSysteCode () );
                }
                respons.setToolCode ( reVal.getToolCode () );
                respons.setGringCount ( Integer.parseInt ( reVal.getGrindingCount () ) );
                respons.setStatus ( IConstant.ZERO );
                respons.setMessageText ( "信息取得成功" );
            } else {
                throw new BusinessException ( IConstant.WMSG0225, request.getLanguageCode (), request.getLanguageValue () );
            }
        } catch (Exception e) {
            throw new BusinessException ( IConstant.WMSG0225, request.getLanguageCode (), request.getLanguageValue () );
        }

        return respons;
    }

    /**
     * 取得刃磨设备信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S018Respons getEquipmentByRfid(C01S018Request request) throws Exception {
        respons = new C01S018Respons ();
        List<NoticeequipmentSelect> reList = new ArrayList<NoticeequipmentSelect> ();
        NoticeequipmentSelect nes = null;
        Noticeequipment entity = new Noticeequipment ();
        String rfidContainerId = null;
        //判断扫描的刀具类型
        if (request.getRfidString () != null && !"".equals ( request.getRfidString ().trim () )) {
            rfidContainerId = service.getrfidContainerIdByRfid ( request.getRfidString () );
            if (rfidContainerId.equals ( IConstant.TOOL_KIND_0 )) { //未初始化
                throw new BusinessException ( IConstant.WMSG0247, request.getLanguageCode (), request.getLanguageValue () );
            }
        } else {
            throw new BusinessException ( IConstant.CEMSG0005, request.getLanguageCode (), request.getLanguageValue () );
        }
        //删除区分
        entity.setDelFlag ( IConstant.DEL_FLAG_0 );
        entity.setRfidContainerID ( rfidContainerId );
        //设备类型(3钻头4刀片)
        entity.setEquipmentType ( IConstant.EQUIPMENT_TYPES_4 );
        //语言
        entity.setLanguageCode ( request.getLanguageCode () );
        try {
            // 取得所有刃磨刀具的设备列表
            List<Noticeequipment> neList = iCOMPV01C01S018Service.searchByList ( entity );
            if (neList.get ( 0 ).isRetErrFlag ()) {
                throw new BusinessException ( IConstant.WMSG0142, request.getLanguageCode (), request.getLanguageValue () );
            } else {
                for (Noticeequipment nt : neList) {
                    nes = new NoticeequipmentSelect ();
                    nes.setNoticeEquipmentID ( nt.getNoticeEquipmentID () );//刃磨设备id
                    nes.setEquipmentName ( nt.getEquipmentName () );//刃磨设备名称
                    nes.setEquipmentType ( nt.getEquipmentCode () ); //设备编码
                    reList.add ( nes );
                }
            }
            if (reList.size () > 0) {
                respons.setNoticeEquipmentList ( reList );
                respons.setStatus ( IConstant.ZERO );
                respons.setMessageText ( "刃磨设备取得成功" );
            } else {
                respons.setStatus ( IConstant.RESULT_CODE_1 );
                respons.setMessageText ( "刃磨设备未找到相应数据" );
            }
        } catch (Exception e) {
            throw new BusinessException ( IConstant.WMSG0142, request.getLanguageCode (), request.getLanguageValue () );
        }
        return respons;
    }

    /**
     * 扫描待放刃磨完刀具的容器(无报废)
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S018Respons putGrindingContainer(C01S018Request request) throws Exception {
        respons = new C01S018Respons ();
        int reCount = 0;
        //报废数量
        int scrapCount = request.getScrapCount ();
        //数量刃磨
        int grindingCount = request.getGringCount ();
        if (grindingCount < 1 || request.getRfidString () == null) {
            throw new BusinessException ( IConstant.CEMSG0005, request.getLanguageCode (), request.getLanguageValue () );
        }
        Map<String, Object> map = new HashMap<String, Object> ();
        //0:非容器 1:正常容器 2:报废容器 3:空容器
        String toolType = service.getToolsContainerByRfid ( request.getRfidString (), request.getCustomerID () );
        if (toolType.equals ( IConstant.TOOL_KIND_0 )) {
            throw new BusinessException ( IConstant.WMSG0247_1, request.getLanguageCode (), request.getLanguageValue () );
        }
        if (!toolType.equals ( IConstant.TOOL_KIND_1 ) && !toolType.equals ( IConstant.TOOL_KIND_3 )) {
            //请扫描装正常刀具的容器!
            throw new BusinessException ( IConstant.WMSG0245_2, request.getLanguageCode (), request.getLanguageValue () );
        }
        String rfidContarnerId = service.getrfidContainerIdByRfid ( request.getRfidString () );
        try {
            //报废数量
            map.put ( "scrapCount", scrapCount );
            //刃磨数量
            map.put ( "grindingCount", grindingCount );
            // 当前用户ID
            map.put ( "userId", request.getCustomerID () );
            // 当前合成刀具RFID
            //容器rifd
            map.put ( "rfidContarnerId", rfidContarnerId );
            //授权人id
            map.put ( "gruantUserId", request.getGruantUserID () );
            //刀具编码
            map.put ( "toolCode", request.getToolCode () );
            //扫描待放刃磨完刀具的容器(无报废)
            reCount = iCOMPV01C01S018Service.putGrindingContainer ( map );
            if (reCount > 0) {
                respons.setStatus ( IConstant.ZERO );
                respons.setMessageText ( "取得成功" );
            } else {
                throw new BusinessException ( IConstant.CEMSG0005_1, request.getLanguageCode (), request.getLanguageValue () );
            }
        } catch (Exception e) {
            throw new BusinessException ( IConstant.CEMSG0005_1, request.getLanguageCode (), request.getLanguageValue () );
        }
        return respons;
    }

    /**
     * 扫描待放刃磨完刀具的容器(报废)
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S018Respons putScrapGrindingContainer(C01S018Request request) throws Exception {
        respons = new C01S018Respons ();
        int reCount = 0;
        int scrapCount = request.getScrapCount ();
        if (scrapCount < 1 || request.getRfidString () == null) {
            throw new BusinessException ( IConstant.CEMSG0005, request.getLanguageCode (), request.getLanguageValue () );
        }
        Map<String, Object> map = new HashMap<String, Object> ();
        //0:非容器 1:正常容器 2:报废容器 3:空容器
        String toolType = service.getToolsContainerByRfid ( request.getRfidString (), request.getCustomerID () );
        if (toolType.equals ( IConstant.TOOL_KIND_0 )) {
            throw new BusinessException ( IConstant.WMSG0247_1, request.getLanguageCode (), request.getLanguageValue () );
        }
        if (!toolType.equals ( IConstant.TOOL_KIND_2 ) && !toolType.equals ( IConstant.TOOL_KIND_3 )) {
            //请扫描装报废刀具的容器!
            throw new BusinessException ( IConstant.WMSG0245_2, request.getLanguageCode (), request.getLanguageValue () );
        }
        try {
            String rfidContarnerId = service.getrfidContainerIdByRfid ( request.getRfidString () );
            //报废数量
            map.put ( "scrapCount", scrapCount );
            // 当前用户ID
            map.put ( "userId", request.getCustomerID () );
            // 当前合成刀具RFID
            //容器rifd载体
            map.put ( "rfidContarnerId", rfidContarnerId );
            //刀具编码
            map.put ( "toolCode", request.getToolCode () );
            //授权人id
            map.put ( "gruantUserId", request.getGruantUserID () );
            //扫描待放刃磨完刀具的容器(报废)
            reCount = iCOMPV01C01S018Service.putScrapGrindingContainer ( map );
            if (reCount > 0) {
                respons.setStatus ( IConstant.ZERO );
                respons.setMessageText ( "取得成功" );
            } else {
                throw new BusinessException ( IConstant.CEMSG0005_1, request.getLanguageCode (), request.getLanguageValue () );
            }
        } catch (Exception e) {
            throw new BusinessException ( IConstant.CEMSG0005_1, request.getLanguageCode (), request.getLanguageValue () );
        }
        return respons;
    }

    /**
     * 取得所有刃磨刀具的设备列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S018Respons getPanGrindingEquipment(C01S018Request request) throws Exception {
        respons = new C01S018Respons ();
        List<NoticeequipmentSelect> reList = new ArrayList<NoticeequipmentSelect> ();
        NoticeequipmentSelect nes = null;
        Noticeequipment entity = new Noticeequipment ();
        //删除区分
        entity.setDelFlag ( IConstant.DEL_FLAG_0 );
        //设备类型(3钻头4刀片)
        entity.setEquipmentType ( IConstant.EQUIPMENT_TYPES_4 );
        //语言
        entity.setLanguageCode ( request.getLanguageCode () );
        try {
            // 取得所有刃磨刀具的设备列表
            List<Noticeequipment> neList = iCOMPV01C01S018Service.searchByList ( entity );
            if (neList.get ( 0 ).isRetErrFlag ()) {
                throw new BusinessException ( IConstant.WMSG0142, request.getLanguageCode (), request.getLanguageValue () );
            } else {
                for (Noticeequipment nt : neList) {
                    nes = new NoticeequipmentSelect ();
                    nes.setNoticeEquipmentID ( nt.getNoticeEquipmentID () );//刃磨设备id
                    nes.setEquipmentName ( nt.getEquipmentName () );//刃磨设备名称
                    nes.setEquipmentType ( nt.getEquipmentCode () ); //设备编码
                    reList.add ( nes );
                }
            }
            if (reList.size () > 0) {
                respons.setNoticeEquipmentList ( reList );
                respons.setStatus ( IConstant.ZERO );
                respons.setMessageText ( "取得成功" );
            } else {
                respons.setStatus ( IConstant.RESULT_CODE_1 );
                respons.setMessageText ( "刃磨设备未找到相应数据" );
            }
        } catch (Exception e) {
            throw new BusinessException ( IConstant.WMSG0142, request.getLanguageCode (), request.getLanguageValue () );
        }

        return respons;
    }

    /**
     * 复磨刀具报废
     *
     * @param request
     * @return
     * @throws Exception C01S018Respons
     * @title savetoolDelete
     */

    public C01S018Respons savetoolDelete(C01S018Request request) throws Exception {
        respons = new C01S018Respons ();
        Map<String, Object> map = new HashMap<String, Object> ();
        // 参数验证
        if (retParams ( request ) || request.getBusinessFlowLnkID () == null || "".equals ( request.getBusinessFlowLnkID ().trim () )) {
            //参数异常
            throw new BusinessException ( IConstant.CEMSG0005, request.getLanguageCode (), request.getLanguageValue () );
        }
        // 1 刀片
        if (IConstant.STSATIC_ONE.equals ( request.getToolType () )) {
            map.put ( "userId", request.getCustomerID () );
            map.put ( "newRfid", request.getNewRfidString () );
            map.put ( "oldRfid", request.getOldRfidString () );
            map.put ( "tempNumbe", request.getTempNumber () );
            map.put ( "BusinessCode", request.getBusinessFlowLnkID () );//流程名
            if (!service.saveSplitBoxTool ( map )) {//分盒
                throw new BusinessException ( IConstant.CEMSG0033, request.getLanguageCode (), request.getLanguageValue () );
            }
            map.put ( "CustomerID", request.getCustomerID () );//用户ID
            map.put ( "RfidString", request.getNewRfidString () );//报废标签Id
            map.put ( "HandSetId", request.getHandSetId () );//刃磨设备Id
            map.put ( "gruantId", request.getGruantUserID () );//授权人Id
            map.put ( "noticeEquipmentID", request.getNoticeEquipmentID () );//设备Id

        } else {
            //报废后直接进行旧刀入库交接
            map.put ( "CustomerID", request.getCustomerID () );//用户ID
            map.put ( "RfidString", request.getRfidString () );//报废标签Id
            map.put ( "BusinessCode", "C01S017" );//流程名
            map.put ( "HandSetId", request.getHandSetId () );//刃磨设备Id
            map.put ( "gruantId", request.getGruantUserID () );//授权人Id
        }

        try {
            //刀具报废
            int reVal = service.savetoolDelete ( map );
            if ("C01S017".equals ( request.getBusinessFlowLnkID () )) {
                if (reVal > 0)
                    iCOMPV01C01S018Service.updateNoticeequipment ( map );
            }
            if (reVal > 0) {
                respons.setStatus ( IConstant.RESULT_CODE_0 );
                respons.setMessageText ( IConstant.CIMSG0057, request.getLanguageCode (), request.getLanguageValue () );
            } else {
                throw new BusinessException ( IConstant.CEMSG0033, request.getLanguageCode (), request.getLanguageValue () );
            }
        } catch (Exception e) {
            throw new BusinessException ( IConstant.CEMSG0033, request.getLanguageCode (), request.getLanguageValue () );
        }
        return respons;
    }

    /**
     * @param request
     * @return boolean
     * @title retParams
     */
    private boolean retParams(C01S018Request request) {
        boolean retParams = false;
        if (request.getCustomerID () == null || request.getCustomerID () == "") {
            retParams = true;// 用户ID
        }
        if (request.getLanguageCode () == null || request.getLanguageCode () == "") {
            retParams = true;// 语言编码（01）
        }
        if (request.getLanguageValue () == null || request.getLanguageValue () == "") {
            retParams = true;// 语言值（zh_en）
        }

        return retParams;
    }

    public C01S018Respons getToolLength(C01S018Request regSwitch) throws Exception {
        C01S018Respons respons = new C01S018Respons ();
        Tooltransfer entity = new Tooltransfer ();
        entity.setKnifeInventoryCode ( regSwitch.getKnifeInventoryCode () );
        List<Tool> tList = iCOMPV01C01S018Service.getToolLength ( entity );
        if (tList.get ( 0 ).isRetErrFlag ()) {
            throw new BusinessException ( tList.get ( 0 ).getMessageCode (), regSwitch.getLanguageCode (), regSwitch.getLanguageValue () );
        }
        respons.setToolLength ( tList.get ( 0 ).getToolLength () );
        respons.setNoGrindingLength ( (tList.get ( 0 ).getToolLength ()).subtract ( tList.get ( 0 ).getToolSharpenLength () ) );
        return respons;
    }


}
