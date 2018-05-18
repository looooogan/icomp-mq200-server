package com.icomp.wsdl.v01c01.c01s013.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c01.s011.ICOMPV01C01S011Service;
import com.icomp.common.service.icomp.v01c01.s013.ICOMPV01C01S013Service;
import com.icomp.entity.base.*;
import com.icomp.wsdl.v01c01.c01s013.business.C01S013Business;
import com.icomp.wsdl.v01c01.c01s013.endpoint.C01S013Request;
import com.icomp.wsdl.v01c01.c01s013.endpoint.C01S013Respons;
import com.icomp.wsdl.v01c01.c01s013.endpoint.PartsEntity;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 设备卸下-Business实现类
 *
 * @author Taoyy
 * @ClassName: C01S013BusinessImpl
 * @date 2014-9-23 下午02:59:30
 */
public class C01S013BusinessImpl implements C01S013Business {

    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    /**
     * 设备卸下-Service接口
     */
    private ICOMPV01C01S013Service iCOMPV01C01S013Service;

    private ICOMPV01C01S011Service iCOMPV01C01S011Service;

    public void setiCOMPV01C01S013Service(ICOMPV01C01S013Service iCOMPV01C01S013Service) {
        this.iCOMPV01C01S013Service = iCOMPV01C01S013Service;
    }

    public void setiCOMPV01C01S011Service(ICOMPV01C01S011Service iCOMPV01C01S011Service) {
        this.iCOMPV01C01S011Service = iCOMPV01C01S011Service;
    }

    /**
     * 取得合成刀下设备信息
     *
     * @param request
     * @return
     * @throws Exception
     */

    public C01S013Respons getSynthesisToolInfoOutEqu(C01S013Request request) throws Exception {
        C01S013Respons respons = new C01S013Respons ();
        Rfidcontainer entity = new Rfidcontainer ();
        // 参数验证
        if (StringUtils.isEmpty ( request.getRfidCode () ) || StringUtils.isEmpty ( request.getQueryType () )) {
            throw new BusinessException ( IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH );
        }
        // RFID标签
        entity.setRfidCode ( request.getRfidCode () );
        // 删除区分
        entity.setDelFlag ( IConstant.DEL_FLAG_0 );

      /*  // rfid没有初始化
        String RfidContainerID = service.getRfidContainerIDByRfidCode(entity);
        if (StringUtils.isEmpty(RfidContainerID)) {
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg("未找到相应的RFID载体");
            return respons;
        }*/
        // 不是合成刀具
        Rfidcontainer rc = service.getRfidContainerByRfidCode ( entity );
        if (rc == null || StringUtils.isEmpty ( rc.getRfidContainerID () )) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "未找到相应的RFID载体" );
            return respons;

        } else if (!IConstant.STRING_2.equals ( rc.getQueryType () )) {
            respons.setStateCode ( IConstant.STSATIC_ONE );
            respons.setStateMsg ( "请扫描合成刀具" );
            return respons;
        }
        String RfidContainerID = rc.getRfidContainerID ();
        Map<String, String> param1 = new HashMap<String, String> ();
        param1.put ( "businessCode", IConstant.C01S013 );
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
        Synthesisknife sk = new Synthesisknife ();
        // 合成刀具编码(系统唯一)
        //		sk.setSynthesisParametersCode(request.getSynthesisParametersCode());
        // RFID载体
        sk.setrFID ( RfidContainerID );
        // 删除区分(0有效1删除)
        sk.setDelFlag ( IConstant.DEL_FLAG_0 );
        // 查询合成刀具编码和编号
        Synthesisknife reVal = iCOMPV01C01S011Service.getSynthesisknifebyRfidc ( sk );
        if (reVal.isRetErrFlag ()) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "未找到当前标签对应的合成刀具编号信息" );
            return respons;
        }

        Vgetdownsynthistoolsmsg param = new Vgetdownsynthistoolsmsg ();
        // 编码
        param.setSynthesisParametersCode ( reVal.getSynthesisParametersCode () );
        // 编号
        param.setSynthesisParametersNumber ( reVal.getSynthesisParametersNumber () );
        param.setOrderString ( "UpdateTime desc" );
        // 根据合成刀具编码和编号查询信息
        Vgetdownsynthistoolsmsg reVmsg = iCOMPV01C01S013Service.getdownsynthistoolsmsg ( param );
        if (reVmsg.isRetErrFlag ()) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "未找到当前合成刀具的加工信息,请先进行设备安上流程" );
            return respons;
        }

        // 对应工序ID
        respons.setProcessID ( reVmsg.getProcessID () );
        // 对应工序编码
        respons.setProcessCode ( reVmsg.getProcessCode () );
        // 设备名称
        respons.setEquipmentName ( reVmsg.getEquipmentName () );
        // 设备ID
        respons.setEquipmentID ( reVmsg.getEquipmentID () );
        // 轴号名称
        respons.setAxleName ( reVmsg.getAxleName () );
        // 轴号ID
        respons.setAxleID ( reVmsg.getAxleID () );
        // 合成刀具编码
        respons.setSynthesisParametersCode ( reVal.getSynthesisParametersCode () );
        // 根据合成刀具编码获取合成刀具id
        Synthesisparameters sp = new Synthesisparameters ();
        sp.setSynthesisParametersCode ( reVal.getSynthesisParametersCode () );
        sp.setDelFlag ( IConstant.DEL_FLAG_0 );
        sp = iCOMPV01C01S013Service.getSynthesisId ( sp );
        if (sp.isRetErrFlag ()) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "未找到对应的合成刀具id" );
            return respons;
        }
        // 合成刀具id
        respons.setSynthesisParametersID ( sp.getSynthesisParametersID () );
        //2017/08/14 王冉 变更↓↓↓　dazhong@YMSC
        //String equipmentna = reVmsg.getEquipmentName ();
        //if (equipmentna != null) {
            //equipmentna = equipmentna.substring ( 0, 3 );
        //}
        //Parts p = new Parts ();
        //p.setPartsCode ( equipmentna );
        //p.setDelFlag ( IConstant.DEL_FLAG_0 );
        Oplink opLink= new Oplink();
        opLink.setSynthesisParametersID(sp.getSynthesisParametersID ());
        List<Oplink> reList = iCOMPV01C01S013Service.getOplinkList(opLink);
        // 零部件列表
         //List<Parts> reList = iCOMPV01C01S013Service.getPartsList ( p );
        //2017/08/14 王冉 变更↑↑↑　dazhong@YMSC
        if (reList == null || reList.size () < 1) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "未找到零部件列表信息" );
            return respons;
        } else {
            List<PartsEntity> peList = new ArrayList<PartsEntity> ();
            //2017/08/14 王冉 变更↓↓↓　dazhong@YMSC
            //Map<String, String> maps = new HashMap<> ();
            //for (Oplink o : reVmsg.getOplinks ()) {
                //maps.put ( o.getPartsID (), o.getToolDurable ()+"" );
            //}
            //2017/08/14 王冉 变更↑↑↑　dazhong@YMSC
            PartsEntity pe = null;
            for (Oplink op : reList) {
                pe = new PartsEntity ();
                pe.setPartsID ( op.getPartsID () );
                pe.setPartsName ( op.getPartsName () );
                pe.setPartsType ( op.getPartsType () );
                //2017/08/14 王冉 变更↓↓↓　dazhong@YMSC
                pe.setProcessCount (String.valueOf(op.getToolDurable()));
                //2017/08/14 王冉 变更↑↑↑　dazhong@YMSC
                peList.add ( pe );
            }
            respons.setPartsList ( peList );
        }

        respons.setStateCode ( IConstant.STOCK_STATE_0 );
        respons.setStateMsg ( "查询成功" );
        return respons;
    }

    /**
     * 提交合成刀下设备信息
     *
     * @param request
     * @return
     * @throws Exception
     */

    @Override
    public C01S013Respons submitSyntheticUnloadEquipmentInfo(C01S013Request request) throws Exception {
        C01S013Respons respons = new C01S013Respons ();
        // 参数验证
        if (checkParam ( request, 1 )) {
            throw new BusinessException ( IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH );
        }
        // 查询合成刀具载体
        Rfidcontainer rfe = new Rfidcontainer ();
        rfe.setRfidCode ( request.getRfidCode () );
        // 标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
        rfe.setQueryType ( IConstant.BAND_TYPE_2 );
        rfe.setDelFlag ( IConstant.DEL_FLAG_0 );
        String rfidConner = service.getRfidContainerIDByRfidCode ( rfe );
        if (null == rfidConner) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "未找到当前标签对应的合成刀具信息" );
            return respons;
        }
        //   List<Tooltransfer> list = iCOMPV01C01S013Service.getAllTool(rfidConner, request.getCustomerID());
        Synthesisknife sk = new Synthesisknife ();
        // 合成刀具编码(系统唯一)
        sk.setSynthesisParametersCode ( request.getSynthesisParametersCode () );
        // RFID载体
        sk.setrFID ( rfidConner );
        // 删除区分(0有效1删除)
        sk.setDelFlag ( IConstant.DEL_FLAG_0 );
        // 查询合成刀具编码和编号
        List<Synthesisknife> reVal = iCOMPV01C01S013Service.getSynParameNumber ( sk );
        if (reVal == null) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "未找到当前标签对应的合成刀具编号信息" );
            return respons;
        }
        String Snumber = reVal.get ( 0 ).getSynthesisParametersNumber ();
        String userId = request.getCustomerID ();
        // 从生产关联表中查询数据
        Oplink entity = new Oplink ();
        // 设备ID
        entity.setEquipmentID ( request.getEquipmentID () );
        // 轴号ID
        entity.setAxleID ( request.getAxisID () );
        //零部件id
        entity.setPartsID ( request.getPartsID () );
        // 合成刀具ID
        entity.setSynthesisParametersID ( request.getSynthesisParametersID () );

        Oplink reValue = iCOMPV01C01S013Service.getOplinkInfo ( entity );
        if (reValue.isRetErrFlag ()) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "生产关联表中未找到相应数据" );
            return respons;
        }
        Synthesistoolsmachining stm = new Synthesistoolsmachining ();
        // 合成刀具参数编码
        stm.setSynthesisParametersCodeWhere ( request.getSynthesisParametersCode () );
        // 合成刀具参数编号
        stm.setSynthesisParametersNumberWhere ( Snumber );
        // 工序ID
        stm.setProcessIDWhere ( reValue.getProcessID () );
        // 设备ID
        stm.setEquipmentIDWhere ( reValue.getEquipmentID () );
        // 流水线ID
        stm.setAssemblyLineIDWhere ( reValue.getAssemblyLineID () );
        stm.setRfidContainerIDWhere ( rfidConner );
        stm.setRfidContainerID ( rfidConner );
        stm.setAxleID ( reValue.getAxleID () );
        stm.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
        stm.setRemoveUser ( userId );//卸下人
        stm.setRemoveReason ( request.getRemoveReason () );//卸下原因
        stm.setOuterTime ( new Date () );// 卸下时间
        stm.setOuterUser ( userId );// 卸下人
        stm.setProcessAmount ( new BigDecimal ( request.getProcessAmount () ) );// 加工数量
        stm.setPartsID ( request.getPartsID () );// 零部件ID（卸下设备后插入）
        stm.setUpdateTime ( new Date () );// 更新时间
        stm.setUpdateUser ( userId );// 更新者
        stm.setExpandSpace1 ( rfidConner );
        stm.setExpandSpace3 ( request.getPartsID () );
        stm.setExpandSpace4 ( request.getHandSetId () );

        // 提交合成刀具加工信息
        stm.setExpandSpace2 ( rfidConner );
        int reValCount = iCOMPV01C01S013Service.submitSyntheticUnloadEquipmentInfo ( stm );
        if (reValCount < 1) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "提交合成刀具卸下设备信息失败" );
            return respons;
        }
        respons.setStateCode ( IConstant.DEL_FLAG_0 );
        respons.setStateMsg ( "提交合成刀具卸下设备信息成功" );
        // 返回是否提交成功
        return respons;
    }

    /**
     * 参数验证
     *
     * @param request
     * @param state
     * @return
     */
    private Boolean checkParam(C01S013Request request, int state) {
        if (state == 1) {
            // 用户ID
            if (StringUtils.isEmpty ( request.getCustomerID () )) {
                return true;
            }
            // 合成刀具ID
            //			if (StringUtils.isEmpty(request.getSynthesisParametersID())) {
            //				return true;
            //			}
            // 合成刀具编码
            if (StringUtils.isEmpty ( request.getSynthesisParametersCode () )) {
                return true;
            }
            // 设备ID
            if (StringUtils.isEmpty ( request.getEquipmentID () )) {
                return true;
            }
            // 轴号ID
            if (StringUtils.isEmpty ( request.getAxisID () )) {
                return true;
            }
            // 合成刀具RFID
            if (StringUtils.isEmpty ( request.getRfidCode () )) {
                return true;

            }
            // 卸下原因(0正常卸下1打刀2不合格9其他)(可维护)
            if (StringUtils.isEmpty ( request.getRemoveReason () )) {
                return true;
            }
            // 零部件ID
            if (StringUtils.isEmpty ( request.getPartsID () )) {
                return true;
            }
            // 零部件名称
            if (StringUtils.isEmpty ( request.getPartsName () )) {
                return true;
            }
        }

        return false;
    }

    /**
     * 取得扫描合成刀具信息 getSynthesisToolInfo
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S013Respons getSynthesisToolInfo(C01S013Request request) throws Exception {
        C01S013Respons respons = new C01S013Respons ();// 返回参数
        Vgetequipmentunloadingmsg entity = new Vgetequipmentunloadingmsg ();// VIEW实体类

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
            // 参数异常
            throw new BusinessException ( IConstant.CEMSG0005, request.getLanguageCode (), request.getLanguageValue () );
        }

        if (request.getRfidString () != null) {
            String toolType = service.getToolsTypeByRfid ( request.getRfidString () );
            if (toolType.equals ( IConstant.TOOL_KIND_0 )) {
                throw new BusinessException ( IConstant.WMSG0247, request.getLanguageCode (), request.getLanguageValue () );
            }
            if (!toolType.equals ( IConstant.TOOL_KIND_1 )) {
                throw new BusinessException ( IConstant.WMSG0246, request.getLanguageCode (), request.getLanguageValue () );
            }
        }
        // 赋值
        entity.setRfid ( request.getRfidString () );// 扫描的rfid标签
        // 取得并判断刀具当前扫描刀具是否可以进行【设备卸下】业务
        Map<String, Object> ret = service.checkToolStauts ( request.getRfidString (), "C01S013", request.getLanguageCode () );
        if (ret.size () > 0 && !(Boolean.valueOf ( ret.get ( "agreeFlag" ).toString () ).booleanValue ())) {
            if (ret.get ( "messageText" ) == null) {
                throw new BusinessException ( (String) ret.get ( "messageCode" ), request.getLanguageCode (), request.getLanguageValue () );
            } else {
                throw new BusinessException ( (String) ret.get ( "messageCode" ), request.getLanguageCode (), request.getLanguageValue (), (String) ret.get ( "newFlowText" ), (String) ret.get ( "lastFlowText" ), (String) ret.get ( "messageText" ) );
            }
        }

        // 取得设备卸下信息
        List<Vgetequipmentunloadingmsg> list = iCOMPV01C01S013Service.getSynthesisToolInfo ( entity );
        // 处理区分(true:成功 false:失败)
        if (list.get ( 0 ).isRetErrFlag ()) {
            throw new BusinessException ( list.get ( 0 ).getMessageCode (), request.getLanguageCode (), request.getLanguageValue () );
        } else {
            // 扫描合成刀具信息取得成功!
            respons.setStatus ( IConstant.RESULT_CODE_0 );
            respons.setMessageText ( IConstant.CIMSG0049, request.getLanguageCode (), request.getLanguageValue () );
            respons.setVgetequipmentunloadingmsgs ( list );
        }
        return respons;
    }

    /**
     * 合成刀具卸下设备 saveToolRecovery
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S013Respons saveToolRecovery(C01S013Request request) throws Exception {
        C01S013Respons respons = new C01S013Respons ();// 返回参数
        Synthesistoolsmachining entity = new Synthesistoolsmachining ();// 合成刀具加工实体类
        Map<String, Object> map = new HashMap<String, Object> ();
        // 验证
        if (validateParams ( request )) {
            // 参数异常
            throw new BusinessException ( IConstant.CEMSG0005, request.getLanguageCode (), request.getLanguageValue () );
        }
        // 赋值
        // entity.setSynthesisParametersCode(request.getSynthesisParametersCode());//
        // 合成刀具编码(系统唯一)
        // entity.setSynthesisParametersNumber(request.getSynthesisParametersNumber());
        entity.setRemoveReason ( request.getRemoveReason () );// 卸下原因(0正常卸下1打刀2不合格9其他)(可维护)
        if (IConstant.STRING_3.equals ( request.getRemoveReason () )) {
            entity.setRemoveReason ( IConstant.REMOVE_REASON_9 );
        }
        entity.setProcessAmount ( new BigDecimal ( request.getProcessAmount () ) );// 加工数量
        entity.setOuterUser ( request.getCustomerID () );// 卸下人
        entity.setRemoveReasonWhere ( request.getRfidString () );// rfid
        entity.setAssemblyLineIDWhere ( request.getAssemblyLineName () );// 零部件种类
        map.put ( "entity", entity );
        map.put ( "rfidString", request.getRfidString () );
        map.put ( "handId", request.getHandSetId () );
        map.put ( "userId", request.getCustomerID () );
        int reVal = 0;
        // 合成刀具卸下设备
        try {
            reVal = iCOMPV01C01S013Service.saveToolRecovery ( map );
        } catch (Exception e) {
            // 合成刀具卸下设备保存异常!
            throw new BusinessException ( IConstant.CEMSG0028, request.getLanguageCode (), request.getLanguageValue () );
        }
        if (reVal > 0) {
            // 合成刀具卸下设备保存成功!
            respons.setStatus ( IConstant.RESULT_CODE_0 );
            respons.setMessageText ( IConstant.CIMSG0097, request.getLanguageCode (), request.getLanguageValue () );
        } else {
            // 合成刀具卸下设备保存异常!
            throw new BusinessException ( IConstant.CEMSG0028, request.getLanguageCode (), request.getLanguageValue () );
        }
        return respons;
    }

    /**
     * 参数验证
     *
     * @param request
     * @return boolean
     * @title validateParams
     */
    private boolean validateParams(C01S013Request request) {
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
        if (request.getHandSetId () == null || request.getHandSetId () == "") {
            retParams = true;// 手持机id
        }
        if (request.getSynthesisParametersCode () == null || request.getSynthesisParametersCode () == "") {
            retParams = true;// 合成刀具编码
        }
        if (request.getRemoveReason () == null || request.getRemoveReason () == "") {
            retParams = true;// 卸下原因
        }

        return retParams;
    }

    /**
     * 取得设备（砂轮）卸下合成刀具信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S013Respons getSynthesisToolInfoOutWheel(C01S013Request request) throws Exception {
        C01S013Respons respons = new C01S013Respons ();
        // 参数验证
        if (StringUtils.isEmpty ( request.getRfidCode () ) || StringUtils.isEmpty ( request.getQueryType () )) {
            throw new BusinessException ( IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH );
        }
        // 判断扫描的是否是空标签
        Rfidcontainer rfidcontainer = new Rfidcontainer ();
        rfidcontainer.setRfidCode ( request.getRfidCode () );
        rfidcontainer.setDelFlag ( IConstant.STRING_0 );
        String rfidcontainerId = service.getRfidContainerIDByRfidCode ( rfidcontainer );
        if (rfidcontainerId == null) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "当前标签未初始化" );
            return respons;
        }
        respons.setRfidContainerId ( rfidcontainerId );

        // 不是设备标签
        rfidcontainer = service.getRfidContainerByRfidCode ( rfidcontainer );
        if (!IConstant.STRING_4.equals ( rfidcontainer.getQueryType () )) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "请扫描专用刀设备标签" );
            return respons;
        }

        // 取得砂轮设备信息
        Equipment equipment = new Equipment ();
        equipment.setRfidContainerID ( rfidcontainerId );
        equipment.setDelFlag ( IConstant.STRING_0 );
        List<Equipment> eList = iCOMPV01C01S013Service.getEquipmentID ( equipment );
        if (eList.size () <= 0) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "未找到当前标签对应的设备信息" );
            return respons;
        }
        String equipmentID = eList.get ( 0 ).getEquipmentID ();
        String equipmentName = eList.get ( 0 ).getEquipmentName();
        respons.setEquipmentID ( equipmentID );
        respons.setEquipmentName( equipmentName );

        // 取得设备对应的生产关联信息
        Vgetwheelinfo wheel = new Vgetwheelinfo ();
        wheel.setEquipmentID ( equipmentID );
        List<Vgetwheelinfo> wheelList = iCOMPV01C01S013Service.getWheelInfo ( wheel );
        if (wheelList.size () <= 0) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "请扫描专用刀设备" );
            return respons;
        }

        // 该砂轮对应的合成刀具编码列表
        //List<String> synthesisParametersCodeList = new ArrayList<String> ();
//        for (Vgetwheelinfo w : wheelList) {
//            //2017/11/14 王冉 变更↓↓↓　dazhong@YMSC
//            Vgetwheelinfo wheel2 = new Vgetwheelinfo ();
//            wheel2.setEquipmentID ( equipmentID );
//            wheel2.setProcessID (  w.getProcessID() );
//            wheel2.setAssemblyLineID (  w.getAssemblyLineID ()  );
//            //wheel2.setAxisID ( w.getAxisID() );
//            //wheel2.setSynthesisParametersCode ( w.getSynthesisParametersCode() );
//            wheel2.setPartsID(w.getPartsID());
//            List<Vgetwheelinfo> wheelList2 = iCOMPV01C01S013Service.getWheelInfo ( wheel2 );
//            if (synthesisParametersCodeList.contains ( w.getSynthesisParametersCode () + "," + wheelList2.get(0).getToolDurable())) {
//                continue;
//            } else {
//
//                synthesisParametersCodeList.add ( w.getSynthesisParametersCode () + "," + wheelList2.get(0).getToolDurable());
//            }
//        }
        //2017/11/14 王冉 变更↑↑↑　dazhong@YMSC

        // 合成刀具编码列表
        respons.setSynthesisParametersCodeList ( wheelList );
        // 对应工序ID
        respons.setProcessID ( wheelList.get ( 0 ).getProcessID () );
        // 对应工序编码
        respons.setProcessCode ( wheelList.get ( 0 ).getProcessCode () );
        // 流水线ID
        respons.setAssemblyLineID ( wheelList.get ( 0 ).getAssemblyLineID () );
        // 流水线名称
        respons.setAssemblyLineName ( wheelList.get ( 0 ).getAssemblyLineName () );
        //2017/10/23 王冉 追加↓↓↓　dazhong@YMSC
        respons.setAxleID(wheelList.get ( 0 ).getAxisID());
        // 由于安卓不知道如何生成新的bean PartsID暂用此字段代替
        respons.setSynthesisParametersID(wheelList.get ( 0 ).getPartsID());
        //2017/10/23 王冉 追加↑↑↑　dazhong@YMSC
        respons.setStateCode ( IConstant.STRING_0 );
        respons.setStateMsg ( "获取成功" );
        return respons;
    }

    /**
     * 提交设备（砂轮）卸下合成刀具信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S013Respons submitSyntheticUnloadWheelInfo(C01S013Request request) throws Exception {
        C01S013Respons respons = new C01S013Respons ();
        // 参数验证
        if (StringUtils.isEmpty ( request.getCustomerID () ) || StringUtils.isEmpty ( request.getAssemblyLineID () ) || StringUtils.isEmpty ( request.getProcessID () ) || StringUtils.isEmpty ( request.getSynthesisParametersCode () ) || StringUtils.isEmpty ( request.getEquipmentID () ) || StringUtils.isEmpty ( request.getRfidContainerId () )) {
            throw new BusinessException ( IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH );
        }

        // 时间格式化
        SimpleDateFormat format = new SimpleDateFormat ( "yyyyMMddHHmmss" );

        // 往合成刀具加工表插入数据
        Synthesistoolsmachining sm = new Synthesistoolsmachining ();
        // 加工编号(年月日时分秒 14位字符串)
        sm.setSynthesisNumber ( format.format ( new Date () ) );
        // 合成刀具号码
        sm.setSynthesisParametersNumber ( "001" );
        // 合成刀具编号
        sm.setSynthesisParametersCode ( request.getSynthesisParametersCode () );
        // 流水线ID
        sm.setAssemblyLineID ( request.getAssemblyLineID () );
        // 设备ID
        sm.setEquipmentID ( request.getEquipmentID () );
        // 轴ID
        //2017/10/23 王冉 变更↓↓↓　dazhong@YMSC
        sm.setAxleID ( request.getAxisID());
        //2017/10/23 王冉 变更↑↑↑　dazhong@YMSC
        // 工序ID
        sm.setProcessID ( request.getProcessID () );
        // 加工数量
        sm.setProcessAmount ( new BigDecimal ( request.getProcessAmount () ) );
        if (request.getRemoveReason () != null) {
            sm.setProcessAmountWhere ( new BigDecimal ( request.getRemoveReason () ) );
        }
        // 删除区分
        sm.setDelFlag ( IConstant.STRING_0 );
        // 创建时间
        sm.setCreateTime ( new Date () );
        // 创建者
        sm.setCreateUser ( request.getCustomerID () );
        // 更新时间
        sm.setUpdateTime ( new Date () );
        // 更新者
        sm.setUpdateUser ( request.getCustomerID () );
        // 版本号
        sm.setVersion ( BigDecimal.ONE );
        //2017/10/23 王冉 变更↓↓↓　dazhong@YMSC
        sm.setPartsID(request.getPartsID());
        // 卸下原因
        sm.setRemoveReason(request.getRemoveReason());
        // 卸下数量
        sm.setRemoveNum(request.getRemoveNum());
        sm.setRfidContainerID(request.getRfidContainerId());
        //2017/10/23 王冉 变更↑↑↑　dazhong@YMSC

        // check备刀
        int flg = iCOMPV01C01S013Service.checkSpareKnifeSum ( sm );
        if (flg == 1) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "备刀数量不足" );
            return respons;
        }

        int reval = iCOMPV01C01S013Service.submitSyntheticUnloadWheelInfo ( sm );
        if (reval == 0) {
            respons.setStateCode ( IConstant.STRING_0 );
            respons.setStateMsg ( "提交成功" );
        } else {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "提交失败" );
        }
        return respons;
    }

}
