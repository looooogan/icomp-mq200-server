package com.icomp.wsdl.v01c01.c01s019.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c01.s018.ICOMPV01C01S018Service;
import com.icomp.common.service.icomp.v01c01.s019.ICOMPV01C01S019Service;
import com.icomp.common.utils.UUIDgen;
import com.icomp.entity.base.Leasertabe;
import com.icomp.entity.base.Outsidefactory;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Vgettoolbindinginfo;
import com.icomp.entity.base.Vgettoolinfolist;
import com.icomp.wsdl.v01c01.c01s018.endpoint.ToolNoticeInfo;
import com.icomp.wsdl.v01c01.c01s019.business.C01S019Business;
import com.icomp.wsdl.v01c01.c01s019.endpoint.BindingToolEntity;
import com.icomp.wsdl.v01c01.c01s019.endpoint.C01S019Request;
import com.icomp.wsdl.v01c01.c01s019.endpoint.C01S019Respons;

import org.apache.commons.collections.map.HashedMap;
import org.apache.cxf.common.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对刀结束-Business实现类
 *
 * @author Taoyy
 * @ClassName: C01S019BusinessImpl
 * @date 2014-9-23 下午03:30:03
 */
public class C01S019BusinessImpl implements C01S019Business {

    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    private ICOMPV01C01S019Service iCOMPV01C01S019Service;
    private ICOMPV01C01S018Service iCOMPV01C01S018Service;

    public void setiCOMPV01C01S019Service(ICOMPV01C01S019Service iCOMPV01C01S019Service) {
        this.iCOMPV01C01S019Service = iCOMPV01C01S019Service;
    }

    public void setiCOMPV01C01S018Service(ICOMPV01C01S018Service iCOMPV01C01S018Service) {
        this.iCOMPV01C01S018Service = iCOMPV01C01S018Service;
    }

    /**
     * 取得要绑定的刀具信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S019Respons getBindingToolInfo(C01S019Request request) throws Exception {
        C01S019Respons respons = new C01S019Respons ();
        //try{
        // 参数验证
        if (StringUtils.isEmpty ( request.getRfidCode () )) {
            throw new BusinessException ( IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH );
        }
        // 不是单品刀具
        if (!IConstant.STRING_1.equals ( request.getRfidType () )) {
            throw new BusinessException ( IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH );
        }
        //查询刀具载体ID
        Rfidcontainer rfc = new Rfidcontainer ();
        rfc.setRfidCode ( request.getRfidCode () );
        //删除区分
        rfc.setDelFlag ( IConstant.DEL_FLAG_0 );
        //根据rfid查询RFID载体
        String rfidcontainerId = service.getRfidContainerIDByRfidCode ( rfc );
        if (StringUtils.isEmpty ( rfidcontainerId )) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "当前标签未初始化" );
            return respons;
        }
        Rfidcontainer rfidcontainer = service.getRfidContainerByRfidCode ( rfc );
        //验证标签类型
        if (!IConstant.STRING_1.equals ( rfidcontainer.getQueryType () )) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "请扫描单品刀具" );
            return respons;
        }
        Map<String, String> param1 = new HashMap<String, String> ();
        param1.put ( "businessCode", IConstant.C01S019 );
        param1.put ( "rfidCode", request.getRfidCode () );
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

        Vgettoolbindinginfo r = new Vgettoolbindinginfo ();
        r.setRfidContainerID ( rfidcontainerId );
        List<BindingToolEntity> equipments = new ArrayList<BindingToolEntity> ();
        BindingToolEntity reEntity = null;
        List<Vgettoolbindinginfo> reList = iCOMPV01C01S019Service.gettoolbindinginfo ( r );
        if (reList == null || reList.size () < 1) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "未找到绑定刀具信息" );
            return respons;
        } else {
            for (Vgettoolbindinginfo v : reList) {
                //判断所扫描的刀具的修磨方式是厂内还是厂外，如果是厂内则不能进行刀具绑定
                Tool t = new Tool ();
                t.setToolCode ( v.getToolCode () );
                t.setDelFlag ( IConstant.DEL_FLAG_0 );
                Tool tool = iCOMPV01C01S019Service.getToolCode ( t );
                if (tool.isRetErrFlag ()) {
                    respons.setStateCode ( IConstant.STRING_1 );
                    respons.setStateMsg ( "未找到刀具信息" );
                    return respons;
                }
                if (IConstant.STRING_0.equals ( tool.getToolGrinding () )) {
                    respons.setStateCode ( IConstant.STRING_1 );
                    respons.setStateMsg ( "该刀具的修磨方式为厂内修磨，不能进行刀具绑定" );
                    return respons;
                }
                reEntity = new BindingToolEntity ();
                //刀具id
                reEntity.setToolID ( v.getToolID () );
                //材料号（刀具编码）
                reEntity.setToolCode ( v.getToolCode () );
                //激光码
                if (null == v.getLaserIdentificationCode ()) {
                    reEntity.setLaserCode ( "" );
                } else
                    reEntity.setLaserCode ( v.getLaserIdentificationCode () );
                equipments.add ( reEntity );
            }
            respons.setEquipments ( equipments );
        }
        respons.setStateCode ( IConstant.STOCK_STATE_0 );
        respons.setStateMsg ( "查询成功" );
        //    }catch{
        //        respons.setStateCode(IConstant.STOCK_STATE_1);
        //        respons.setStateMsg("获取失败");
        //         }
        return respons;
    }

    /**
     * 取得激光码
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S019Respons getLaserCode(C01S019Request request) throws Exception {
        C01S019Respons respons = new C01S019Respons ();
        // 时间格式化
        SimpleDateFormat format = new SimpleDateFormat ( "yyyyMM" );
        // 参数验证
        if (StringUtils.isEmpty ( request.getRfidCode () ) || StringUtils.isEmpty ( request.getToolCode () )) {
            throw new BusinessException ( IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH );
        }
        //查询刀具载体ID
        Rfidcontainer rfc = new Rfidcontainer ();
        rfc.setRfidCode ( request.getRfidCode () );
        //标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
        rfc.setQueryType ( IConstant.BAND_TYPE_1 );
        //删除区分
        rfc.setDelFlag ( IConstant.DEL_FLAG_0 );
        //根据rfid查询RFID载体
        String rfidContainerId = service.getRfidContainerIDByRfidCode ( rfc );
        if (null == rfidContainerId) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "未找到当前rfid对应载体ID的信息" );
            return respons;
        }
        //查询刀具id
        Tool t = new Tool ();
        t.setToolCode ( request.getToolCode () );
        t.setDelFlag ( IConstant.DEL_FLAG_0 );
        Tool reval = iCOMPV01C01S019Service.getToolCode ( t );
        if (null == reval) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "未找到刀具参数信息" );
            return respons;
        }
        //查询是否有流转信息
        Tooltransfer tf = new Tooltransfer ();
        tf.setRfidContainerID ( rfidContainerId );
        tf.setToolID ( reval.getToolID () );
        tf.setDelFlag ( IConstant.DEL_FLAG_0 );
        Tooltransfer treval = iCOMPV01C01S019Service.getToolPB ( tf );
        if (treval.isRetErrFlag ()) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "未找到刀具流转信息" );
            return respons;
        }

        //获取当前时间的年月作为批次
        Date date = new Date ();
        String dateString = format.format ( date );
        //将材料号与当前时间年月进行拼接，作为模糊查询激光码的条件
        Rfidcontainer entity = new Rfidcontainer ();
        entity.setLaserIdentificationCode ( request.getToolCode () + "-" + dateString );
        List<Rfidcontainer> rList = iCOMPV01C01S019Service.getLacerCode ( entity );

        //将1变成001
        //        DecimalFormat nf = new DecimalFormat("000");
        //        String number=String.valueOf(nf.format(rList.size()+1));
        String number = String.valueOf ( rList.size () + 1 );

        //材料号+批次+编号
        respons.setLaserCode ( (request.getToolCode ()) + "-" + dateString + "-" + number );
        respons.setStateCode ( IConstant.DEL_FLAG_0 );
        respons.setStateMsg ( "生成成功" );
        return respons;
    }

    /**
     * 传送激光码
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S019Respons setLaserCode(C01S019Request request) throws Exception {
        C01S019Respons respons = new C01S019Respons ();
        // 参数验证
        if (checkParam ( request, 1 )) {
            throw new BusinessException ( IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH );
        }
        try {
            //判断激光码是否已传送
            Leasertabe entity = new Leasertabe ();
            //激光码
            entity.setLaserCode ( request.getLaserCode () );
            if (iCOMPV01C01S019Service.getLaserCodeInfo ( entity ) > 0) {
                //激光码已传送
                respons.setStateCode ( IConstant.STRING_2 );
                respons.setStateMsg ( "该激光码已被占用" );
                return respons;
            } else {
                Leasertabe lt = new Leasertabe ();
                lt.setLeaserID ( UUIDgen.getId () );
                lt.setLaserCode ( request.getLaserCode () );
                //激光码状态（0 激活 1未激活）
                lt.setLaserState ( IConstant.STOCK_STATE_1 );
                lt.setRfid ( request.getRfidCode () );
                lt.setDelFlag ( IConstant.DEL_FLAG_0 );
                lt.setUpdateTime ( new Date () );
                lt.setCreateTime ( new Date () );
                lt.setUpdateUser ( request.getCustomerID () );
                lt.setCreateUser ( request.getCustomerID () );
                iCOMPV01C01S019Service.leasertabeInsert ( lt );
                respons.setStateCode ( IConstant.DEL_FLAG_0 );
                respons.setStateMsg ( "传送成功" );
                return respons;
            }
        } catch (Exception e) {
            respons.setStateCode ( IConstant.STRING_2 );
            respons.setStateMsg ( "传送失败" );
            return respons;
        }
    }

    /**
     * 提交刀具绑定信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S019Respons submitToolBindingInfo(C01S019Request request) throws Exception {
        C01S019Respons respons = new C01S019Respons ();
        // 参数验证
        if (checkParam ( request, 1 )) {
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
            respons.setStateMsg ( "未找到当前标签对应的刀具信息" );
            return respons;
        }

        Leasertabe leasertabe = new Leasertabe ();
        leasertabe.setLaserCode ( request.getNewLaserCode () );
        String lacerStr = iCOMPV01C01S019Service.getLacerCodeState ( leasertabe );
        if (lacerStr != null) {
            //激光码状态（0 激活 1未激活）取得
            if (IConstant.DEL_FLAG_1.equals ( lacerStr )) {
                respons.setStateCode ( IConstant.DEL_FLAG_1 );
                respons.setStateMsg ( "当前激光码还未进行激光打码，请打码后确认绑定" );
                return respons;
            }
        } else {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "未找到当前激光码的信息，请先进行发送" );
            return respons;
        }

        //用户ID
        String userId = request.getCustomerID ();
        Rfidcontainer rt = new Rfidcontainer ();
        //rfid
        rt.setRfidContainerIDWhere ( rfidConner );
        //rfidCode
        rt.setRfidCode ( "" );
        if (!"".equals ( request.getOldLaserCode () ) && request.getOldLaserCode () != null) {
            //原有激光码
            rt.setLaserIdentificationCodeWhere ( request.getOldLaserCode () );
        }
        //生成或修改后的激光码
        rt.setLaserIdentificationCode ( request.getNewLaserCode () );
        //绑定类型(0RFID 1 激光码 2 工具盘 9 其他)
        rt.setBandType ( IConstant.BAND_TYPE_1 );
        //标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
        rt.setQueryType ( IConstant.QUERY_TYPE_1 );
        rt.setDelFlag ( IConstant.DEL_FLAG_0 );//删除区分
        rt.setUpdateTime ( new Date () );// 更新时间
        rt.setUpdateUser ( userId );// 更新者
        rt.setSystemLogUser ( userId );//操作人
        rt.setExpandSpace1 ( request.getHandSetId () );// 手持机id
        // 提交刀具绑定信息
        int reValCount = iCOMPV01C01S019Service.submitToolBindingInfo ( rt, request.getToolCode () );
        if (reValCount < 1) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "提交刀具绑定信息失败" );
            return respons;
        }
        // 返回是否提交成功
        respons.setStateCode ( IConstant.DEL_FLAG_0 );
        respons.setStateMsg ( "提交刀具绑定信息" );
        return respons;
    }

    @Override
    public C01S019Respons getOutfactTools(C01S019Request request) throws Exception {
        //  取得要出厂的刀具信息
        C01S019Respons respons = new C01S019Respons ();
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
                        if (IConstant.STRING_0.equals ( reTool.getToolGrinding () )) {
                            respons.setStateCode ( IConstant.STRING_1 );
                            respons.setStateMsg ( "您扫描的单品刀具不是厂外修磨刀具" );
                            return respons;
                        }
                    }
                }
            }
            Vgettoolinfolist vv = new Vgettoolinfolist ();
            vv.setRfidContainerID ( rfidConner );
            //            vv.setToolState(IConstant.TOOL_STATE_6);//厂内待刃磨
            Vgettoolinfolist reList = iCOMPV01C01S018Service.getToolInfoList ( vv );
            if (reList.isRetErrFlag ()) {
                respons.setStateCode ( IConstant.DEL_FLAG_1 );
                respons.setStateMsg ( "请扫描待修磨的单品刀具" );
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

    @Override
    public C01S019Respons submitOutFackterTools(C01S019Request request) throws Exception {
        //提交出厂刀具信息
        C01S019Respons respons = new C01S019Respons ();
        try {
            // 参数验证
            if (request.getToolNoticeInfoList () == null || request.getToolNoticeInfoList ().size () < 1 || request.getCustomerID () == null) {
                throw new BusinessException ( IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH );
            }
            //出门单号
            String orderNumber = request.getLaserCode ();
            String userID = request.getCustomerID ();
            Outsidefactory uf = null;
            List<Outsidefactory> outsinderList = new ArrayList<> ();
            List<String> rfidCodes = new ArrayList<> ();
            for (ToolNoticeInfo info : request.getToolNoticeInfoList ()) {
                uf = new Outsidefactory ();
                //厂外修复ID
                uf.setOutsideFactoryID ( UUIDgen.getId () );
                uf.setOrderNum ( orderNumber );
                uf.setToolID ( info.getToolID () );
                //材料号
                uf.setMaterialNum ( info.getMaterialNum () );
                //修磨数量
                uf.setNumberGrinding ( IConstant.STRING_1 );
                //修复类型（0.厂外图层1.厂外复磨）
                Tool tool = service.getToolsByID ( info.getToolID () );
                if (tool != null && tool.getToolGrinding () != null) {
                    //修磨类别(0:厂内修磨，1厂外修磨，2厂外涂层取得
                    if (IConstant.STRING_1.equals ( tool.getToolGrinding () )) {
                        uf.setGrindingType ( IConstant.STRING_1 );
                    } else {
                        uf.setGrindingType ( IConstant.STRING_0 );
                    }
                }
                String rfidConnerID = service.getrfidContainerIdByRfid ( info.getRfidCode () );
                if(! StringUtils.isEmpty ( rfidConnerID )) {
                        uf.setExpandSpace4 ( rfidConnerID);
                }
                //刀具类型（0.钻头1.刀片)
                uf.setToolType ( IConstant.STRING_0 );
                //修复状态(0.待出厂1.已出厂2.已送回）
                uf.setRepairState( IConstant.STRING_1 );
                uf.setDelFlag ( IConstant.DEL_FLAG_0 );
                uf.setCreateTime ( new Date () );
                uf.setUpdateTime ( new Date () );
                uf.setCreateUser ( userID );
                uf.setUpdateUser ( userID );
                outsinderList.add ( uf );
                rfidCodes.add ( info.getRfidCode () );
            }
            Map<String, Object> params = new HashedMap ();
            //用户ID
            params.put ( "userID",userID);
            //列表
            params.put ( "toolNoticeInfo", outsinderList );
            //RFIDList
            params.put ( "rfidCodes", rfidCodes );
            // 提交出厂刀具信息
            int reValCount = iCOMPV01C01S019Service.submitOutFackterTools ( params );
            if (reValCount < 1) {
                respons.setStateCode ( IConstant.DEL_FLAG_1 );
                respons.setStateMsg ( "提交出厂刀具信息失败" );
                return respons;
            }
            // 返回是否提交成功
            respons.setStateCode ( IConstant.DEL_FLAG_0 );
        } catch (Exception e) {
            System.out.println ( "C01S019BusinessImpl.java---submitOutFackterTools-----" + e.toString () );
            respons.setStateCode ( IConstant.STOCK_STATE_1 );
            respons.setStateMsg ( "提交异常" );
        }
        return respons;
    }

    /**
     * 参数验证
     *
     * @param request
     * @param i
     * @return
     */
    private boolean checkParam(C01S019Request request, int i) {
        // RFID
        if (StringUtils.isEmpty ( request.getRfidCode () )) {
            return true;
        }
        // 用户ID
        if (StringUtils.isEmpty ( request.getCustomerID () )) {
            return true;
        }
        // 激光码
        if (StringUtils.isEmpty ( request.getNewLaserCode () ) && StringUtils.isEmpty ( request.getLaserCode () )) {
            return true;
        }

        return false;
    }

    /**
     * 取得刀具状态
     */
    public C01S019Respons getToolInfo(C01S019Request request) throws Exception {
        C01S019Respons respons = new C01S019Respons ();
        Rfidcontainer entity = new Rfidcontainer ();
        //参数验证
        // if (retParams(request, 0)) {
        throw new BusinessException ( IConstant.WMSG0221, request.getLanguageCode (), request.getLanguageValue () );
    }
    //判断扫描的刀具类型
    //if (request.getRfidString() != null && !"".equals(request.getRfidString().trim())) {
    //String toolType = service.getToolsTypeByRfid(request.getRfidString());
    //if (toolType.equals(IConstant.TOOL_KIND_0)) { //未初始化
    //throw new BusinessException(IConstant.WMSG0247, request.getLanguageCode(), request.getLanguageValue());
    //  }
    // if (!toolType.equals(IConstant.TOOL_KIND_2)) {
    //  throw new BusinessException(IConstant.WMSG0245, request.getLanguageCode(), request.getLanguageValue());
    //  }
    // }
    // entity.setDelFlag(IConstant.DEL_FLAG_0);
    //entity.setRfidCode(request.getRfidString());
    // entity = iCOMPV01C01S019Service.getToolInfo(entity);
    //if (entity.isRetErrFlag()) {
    //  throw new BusinessException(entity.getMessageCode(), request.getLanguageCode(), request.getLanguageValue());
    // }
    // return respons;
    // }

    /**
     * 保存刀具打码信息
     */
    public C01S019Respons saveToolInfo(C01S019Request request) throws Exception {
        C01S019Respons respons = new C01S019Respons ();
        if (retParams ( request, 0 )) {
            throw new BusinessException ( IConstant.WMSG0221, request.getLanguageCode (), request.getLanguageValue () );
        }
        //是否已绑定激光码
        //String laserIdentificationCode = service.getBandType(request.getLaserIdentificationCode());
        // if (laserIdentificationCode != null && IConstant.BAND_TYPE_0.equals(laserIdentificationCode)) {
        //绑定失败,刀具激光码已绑定其它刀具,请重新绑定
        throw new BusinessException ( IConstant.WMSGC01S019_1, request.getLanguageCode (), request.getLanguageValue () );
    }

    Rfidcontainer entity = new Rfidcontainer ();
    //entity.setRfidCode(request.getRfidString());
    // entity.setLaserIdentificationCode(request.getLaserIdentificationCode());
    //entity.setUpdateUser(request.getCustomerID());
    //entity.setSystemLogUser(request.getCustomerID());
    //entity.setUpdateTime(new Date());
    //entity = iCOMPV01C01S019Service.saveToolInfo(entity);
    //if (entity.isRetErrFlag()) {
    //   throw new BusinessException(IConstant.WMSG0312_4, request.getLanguageCode(), request.getLanguageValue());
    //} else {
    // respons.setStatus(IConstant.RESULT_CODE_0);
    //  respons.setMessageText(IConstant.WMSG0312_3, request.getLanguageCode(), request.getLanguageValue());
    //  }
    // return respons;
    // }

    /**
     * 参数验证
     *
     * @param request
     * @return boolean
     * @title retParams
     */
    private boolean retParams(C01S019Request request, int state) {
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
        if (state == 0) {
            // if (request.getRfidString() == null || request.getRfidString() == "") {
            retParams = true;//rfid
        }
        //}

        return retParams;
    }

}
