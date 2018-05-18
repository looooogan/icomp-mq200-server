package com.icomp.wsdl.v01c01.c01s020.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c01.s020.ICOMPV01C01S020Service;
import com.icomp.entity.base.Outsidefactory;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.wsdl.v01c01.c01s020.business.C01S020Business;
import com.icomp.wsdl.v01c01.c01s020.endpoint.BackFactoryToolInfo;
import com.icomp.wsdl.v01c01.c01s020.endpoint.C01S020Request;
import com.icomp.wsdl.v01c01.c01s020.endpoint.C01S020Respons;
import com.icomp.wsdl.v01c01.c01s020.endpoint.NotificationList;
import com.icomp.wsdl.v01c01.c01s020.endpoint.NotificationListInfo;
import com.icomp.wsdl.v01c01.c01s020.endpoint.ToolInfo;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 回厂识别-Business实现类
 *
 * @author Taoyy
 * @ClassName: C01S020BusinessImpl
 * @date 2014-9-23 下午03:36:24
 */
public class C01S020BusinessImpl implements C01S020Business {

    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    private ICOMPV01C01S020Service iCOMPV01C01S020Service;

    public void setiCOMPV01C01S020Service(ICOMPV01C01S020Service iCOMPV01C01S020Service) {
        this.iCOMPV01C01S020Service = iCOMPV01C01S020Service;
    }

    /**
     * 取得通知单号列表
     *
     * @param request
     * @return
     */
    public C01S020Respons getNotificationList(C01S020Request request) throws Exception {
        C01S020Respons respons = new C01S020Respons ();
        //厂外修复表
        Outsidefactory out = new Outsidefactory ();
        //修复状态(0.未修复1.已修复2.其他）
        out.setRepairState ( IConstant.STOCK_STATE_1 );
        out.setDelFlag ( IConstant.DEL_FLAG_0 );
        out.setGroupString ( "orderNum" );
        out.setOrderString ( "orderNum" );
        List<Outsidefactory> oentity = iCOMPV01C01S020Service.getBackFactoryToolInfolist ( out );
        if (oentity.size () <= 0) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "未找到通知单号列表" );
            return respons;
        }
        List<NotificationList> list = new ArrayList<NotificationList> ();
        NotificationList re = null;
        for (Outsidefactory no : oentity) {
            re = new NotificationList ();
            //通知单号
            re.setOrderNum ( no.getOrderNum () );
            //通知单号ID
            re.setOutsideFactoryID ( no.getOutsideFactoryID () );
            list.add ( re );
        }
        respons.setNotificationLists ( list );
        if (null == list || list.size () < 1) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "未找到通知单号列表" );
            return respons;
        }
        respons.setStateCode ( IConstant.STOCK_STATE_0 );
        respons.setStateMsg ( "取得成功" );
        return respons;
    }

    /**
     * 取得通知单号信息
     *
     * @param request
     */
    public C01S020Respons getNotificationListInfo(C01S020Request request) throws Exception {
        C01S020Respons respons = new C01S020Respons ();
        Outsidefactory out = new Outsidefactory ();
        //通知单号
        out.setOrderNum ( request.getOrderNum () );
        out.setDelFlag ( IConstant.DEL_FLAG_0 );
        out.setGroupString ( "orderNum,MaterialNum" );
        List<Outsidefactory> ofList = iCOMPV01C01S020Service.getBackFactoryToolSumInfo ( out );
        if (ofList.size () <= 0) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "未找到通知单号信息" );
            return respons;
        }

        List<NotificationListInfo> notificationListInfos = new ArrayList<NotificationListInfo> ();
        for (Outsidefactory of : ofList) {
            NotificationListInfo re = new NotificationListInfo ();
            // 刀具ID
            re.setToolID ( of.getToolID () );
            // 修磨类型
            re.setGrindingType ( of.getGrindingType () );
            // 激光码
            re.setLaserCode ( of.getLaserCode () );
            // 材料号
            re.setMaterialNum ( of.getMaterialNum () );
            // 修磨数量
            re.setNumberGrinding ( of.getNumberGrinding () );
            notificationListInfos.add ( re );
        }

        respons.setNotificationListInfoList ( notificationListInfos );

        if (null == notificationListInfos || notificationListInfos.size () < 1) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "未找到通知单号信息" );
            return respons;
        }
        respons.setStateCode ( IConstant.STOCK_STATE_0 );
        respons.setStateMsg ( "取得成功" );
        return respons;
    }

    /**
     * 取得盛放入库刀具的空盒信息
     *
     * @param request
     * @return
     */
    public C01S020Respons getEmptyBoxInfo(C01S020Request request) throws Exception {
        C01S020Respons respons = new C01S020Respons ();
        // 参数验证
        if (StringUtils.isEmpty ( request.getRfidCode () ) || StringUtils.isEmpty ( request.getRfidType () )) {
            throw new BusinessException ( IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH );
        }
        //查询刀具载体ID
        Rfidcontainer rfc = new Rfidcontainer ();
        rfc.setRfidCode ( request.getRfidCode () );
        //删除区分
        rfc.setDelFlag ( IConstant.DEL_FLAG_1 );
        //根据rfid查询RFID载体
        Rfidcontainer rfid = iCOMPV01C01S020Service.getRfidContainerIDByRfidCode ( rfc );
        if (null == rfid || rfid.getRfidContainerID () == null) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "取得成功" );
            return respons;
        }
        respons.setRfidCode ( request.getRfidCode () );
        respons.setStateCode ( IConstant.STOCK_STATE_0 );
        respons.setStateMsg ( "已有信息" );
        return respons;
    }

    /**
     * 提交回厂入库刀片信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S020Respons submitBackFactoryToolInfo(C01S020Request request) throws Exception {
        C01S020Respons respons = new C01S020Respons ();
        // 参数验证
        if (checkParam ( request, 1 )) {
            throw new BusinessException ( IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH );
        }
        List<BackFactoryToolInfo> btList = new ArrayList<BackFactoryToolInfo> ();

        btList = request.getBackFactoryToolInfoList ();

        //查询刀具信息
        Tooltransfer ttf = new Tooltransfer ();
        //刀具ID
        ttf.setToolID ( btList.get ( 0 ).getToolID () );
        ttf.setDelFlag ( IConstant.DEL_FLAG_0 );
        Tooltransfer reVal = iCOMPV01C01S020Service.getToolInFactory ( ttf );
        if (reVal.isRetErrFlag ()) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "未找到当前对应的刀具信息" );
            return respons;
        }
        BigDecimal bd = new BigDecimal ( btList.get ( 0 ).getBackFactoryCount () );
        Tooltransfer tt = new Tooltransfer ();
        String userId = request.getCustomerID ();
        //条件
        tt.setToolIDWhere ( btList.get ( 0 ).getToolID () );
        tt.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
        //set
        tt.setToolDurable ( bd );
        if (reVal.getUsageCounter () == null) {
            reVal.setUsageCounter ( BigDecimal.ZERO );
        }
        tt.setUsageCounter ( reVal.getUsageCounter ().add ( BigDecimal.ONE ) );
        tt.setUpdateTime ( new Date () );
        tt.setUpdateUser ( userId );
        tt.setDelFlag ( IConstant.DEL_FLAG_0 );
        tt.setToolState ( IConstant.TOOL_STATE_8 );
        tt.setToolThisState ( IConstant.TOOL_KIND_3 );

        // 提交刀片回厂入库信息

        int reValCount = iCOMPV01C01S020Service.submitBackFactoryToolInfo ( tt );
        if (reValCount < 1) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "提交回厂入库信息失败" );
            return respons;
        }
        respons.setStateCode ( IConstant.DEL_FLAG_0 );
        respons.setStateMsg ( "提交回厂入库信息成功" );

        return respons;
    }

    /**
     * 提交钻头激光码
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S020Respons submitBitLaserCode(C01S020Request request) throws Exception {
        C01S020Respons respons = new C01S020Respons ();
        // 输入参数验证
        if (checkParam ( request, 2 )) {
            throw new BusinessException ( IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH );
        }
        //查询刀具载体
        Rfidcontainer rf = new Rfidcontainer ();
        //激光码
        rf.setLaserIdentificationCode ( request.getLaserCode () );
        //标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
        rf.setQueryType ( IConstant.BAND_TYPE_1 );
        //绑定类型(0RFID 1 激光码 2 工具盘 9 其他)
        rf.setBandType ( IConstant.BAND_TYPE_1 );
        rf.setDelFlag ( IConstant.DEL_FLAG_0 );
        //根据激光码查询RFID载体
        Rfidcontainer rc = iCOMPV01C01S020Service.getRfidContainerIDByLaserCode ( rf );
        if (rc.getRfidContainerID () == null) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "未找到当前激光码对应的信息" );
            return respons;
        }
        String userId = request.getCustomerID ();
        Rfidcontainer rff = new Rfidcontainer ();
        //条件
        rff.setRfidContainerIDWhere ( rc.getRfidContainerID () );
        rff.setQueryTypeWhere ( IConstant.QUERY_TYPE_1 );
        //Set
        rff.setLaserIdentificationCode ( request.getLaserCode () );
        rff.setRfidCode ( request.getRfidCode () );
        if (rc.getRfidReCount () == null) {
            rc.setRfidReCount ( BigDecimal.ZERO );
        }
        rff.setRfidReCount ( rc.getRfidReCount ().add ( BigDecimal.ONE ) );
        rff.setBandType ( IConstant.BAND_TYPE_0 );
        rff.setDelFlag ( IConstant.DEL_FLAG_0 );
        rff.setUpdateTime ( new Date () );
        rff.setUpdateUser ( userId );
        //手持机id
        rff.setExpandSpace1 ( request.getHandSetId () );
        //出厂方式（0涂层，1修磨）
        rff.setExpandSpace2 ( request.getGrindingType () );
        // 提交钻头回厂入库信息
        int reValCount = iCOMPV01C01S020Service.submitBitLaserCode ( rff );
        if (reValCount < 0) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "提交钻头回厂入库信息失败" );
            return respons;
        }
        if (reValCount == 0) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "该激光码对应的刀具不能进行回厂入库，请在管理平台上编辑厂外修复通知单" );
            return respons;
        }
        respons.setStateCode ( IConstant.DEL_FLAG_0 );
        respons.setStateMsg ( "提交钻头回厂入库信息成功" );
        return respons;
    }

    /**
     * 参数验证
     */
    private boolean checkParam(C01S020Request request, int state) {
        // 用户ID
        if (StringUtils.isEmpty ( request.getCustomerID () )) {
            return true;
        }

        if (state == 1) {
            //刀具信息
            if (null == request.getBackFactoryToolInfoList () || request.getBackFactoryToolInfoList ().size () < 1) {
                return true;
            }

        }
        if (2 == state) {
            // rfid
            if (StringUtils.isEmpty ( request.getRfidCode () )) {
                return true;
            }
            //激光码
            if (StringUtils.isEmpty ( request.getLaserCode () )) {
                return true;
            }
        }
        return false;

    }

    /**
     * 查询出厂单号列表
     */
    public C01S020Respons getFactoryNoList(C01S020Request regSwitch) throws Exception {
        C01S020Respons respons = new C01S020Respons ();
        List<String> list = new ArrayList<String> ();
        list.add ( "11111" );
        list.add ( "22222" );
        list.add ( "33333" );
        list.add ( "44444" );
        respons.setToolRepairNoticeIDList ( list );
        return respons;
    }

    /**
     * 根据用户选择的出厂单号,查询同一出厂单号下的刀具编码列表
     */
    public C01S020Respons getFactoryToolList(C01S020Request regSwitch) throws Exception {
        C01S020Respons respons = new C01S020Respons ();
        List<ToolInfo> list = new ArrayList<ToolInfo> ();
        ToolInfo toolInfo = new ToolInfo ();
        toolInfo.setToolCode ( "aaaaa" );
        toolInfo.setToolCount ( 20 );
        list.add ( toolInfo );
        ToolInfo toolInfo1 = new ToolInfo ();
        toolInfo1.setToolCount ( 30 );
        toolInfo1.setToolCode ( "bbbbb" );
        list.add ( toolInfo1 );
        ToolInfo toolInfo2 = new ToolInfo ();
        toolInfo2.setToolCount ( 40 );
        toolInfo2.setToolCode ( "ccccc" );
        list.add ( toolInfo2 );
        ToolInfo toolInfo3 = new ToolInfo ();
        toolInfo3.setToolCount ( 50 );
        toolInfo3.setToolCode ( "ddddd" );
        list.add ( toolInfo3 );
        respons.setToolInfoList ( list );
        return respons;
    }

    /**
     * 绑定回厂识别刀片
     */
    public C01S020Respons saveFactoryBlade(C01S020Request regSwitch) throws Exception {
        C01S020Respons respons = new C01S020Respons ();
        return respons;
    }

    /**
     * 绑定回厂识别钻头
     */
    public C01S020Respons saveFactoryBoringCrown(C01S020Request request) throws Exception {
        C01S020Respons respons = new C01S020Respons ();
        if (retParams ( request, 1 )) {
            throw new BusinessException ( IConstant.WMSG0221, request.getLanguageCode (), request.getLanguageValue () );
        }
        //验证当前钻头是否已绑定
        Rfidcontainer entity = new Rfidcontainer ();
        entity.setLaserIdentificationCode ( request.getLaserIdentificationCode () );
        entity = iCOMPV01C01S020Service.checkLaserIdentificationCode ( entity );
        if (entity.isRetErrFlag ()) {
            throw new BusinessException ( entity.getMessageCode (), request.getLanguageCode (), request.getLanguageValue () );
        }
        //进行钻头绑定
        entity.setRfidCode ( request.getRfidString () );
        entity.setLaserIdentificationCode ( request.getLaserIdentificationCode () );
        entity.setUpdateUser ( request.getCustomerID () );
        entity.setSystemLogUser ( request.getCustomerID () );
        entity.setzTreeId ( request.getHandSetId () );
        entity.setUpdateTime ( new Date () );
        entity = iCOMPV01C01S020Service.saveFactoryBoringCrown ( entity );
        if (entity.isRetErrFlag ()) {
            throw new BusinessException ( entity.getMessageCode (), request.getLanguageCode (), request.getLanguageValue () );
        } else {
            respons.setStatus ( IConstant.RESULT_CODE_0 );
            respons.setMessageText ( IConstant.CIMSG0069, request.getLanguageCode (), request.getLanguageValue () );
        }
        return respons;
    }

    /**
     * 验证当前RFID是否已绑定
     */
    public C01S020Respons checkRfid(C01S020Request request) throws Exception {
        //参数验证
        if (retParams ( request, 0 )) {
            throw new BusinessException ( IConstant.WMSG0221, request.getLanguageCode (), request.getLanguageValue () );
        }
        //判断扫描的刀具类型
        if (request.getRfidString () != null && !"".equals ( request.getRfidString ().trim () )) {
            String toolType = service.getToolsTypeByRfid ( request.getRfidString () );
            if (!toolType.equals ( IConstant.TOOL_KIND_0 )) { //请扫描空盒
                throw new BusinessException ( IConstant.WMSG0218, request.getLanguageCode (), request.getLanguageValue () );
            }
        }
        C01S020Respons respons = new C01S020Respons ();
        Rfidcontainer entity = new Rfidcontainer ();
        entity.setRfidCode ( request.getRfidString () );
        entity = iCOMPV01C01S020Service.checkRfid ( entity );
        if (entity.isRetErrFlag ()) {
            throw new BusinessException ( entity.getMessageCode (), request.getLanguageCode (), request.getLanguageValue () );
        }
        return respons;
    }

    @Override
    public C01S020Respons getRFIDnullCode(C01S020Request request) throws Exception {
        C01S020Respons respons = new C01S020Respons ();
        //参数验证
        if (StringUtils.isEmpty ( request.getRfidCode () )) {
            throw new BusinessException ( IConstant.WMSG0221, request.getLanguageCode (), request.getLanguageValue () );
        }
        //判断扫描的刀具类型

        String toolType = service.getToolsTypeByRfid ( request.getRfidCode () );
        if (!toolType.equals ( IConstant.TOOL_KIND_0 )) { //请扫描空盒
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "请扫描空盒" );
        } else {
            respons.setStateCode ( IConstant.STRING_0 );
        }

        return respons;
    }

    @Override
    public C01S020Respons submitOutFactInData(C01S020Request request) throws Exception {
        C01S020Respons respons = new C01S020Respons ();
        //验证
        //参数验证
        if (retParams ( request, 2 )) {
            throw new BusinessException ( IConstant.WMSG0221, request.getLanguageCode (), request.getLanguageValue () );
        }
        //参数
        Map<String, Object> map = new HashedMap ();
        //用户ID
        map.put ( "userID", request.getCustomerID () );
        map.put ( "grindingType", request.getGrindingType () );
        //rfidCodeList
        map.put ( "rfidList", request.getRfidCodeList () );
        //出厂单号
        map.put ( "outsideFactoryID", request.getOutsideFactoryID () );
        //材料号
        map.put ( "toolCode", request.getToolCode () );
        //提交扫描信息并初始化
        int reVal = iCOMPV01C01S020Service.submitOutFactInData ( map );
        if (reVal > 0) {
            //返回信息
            respons.setStateCode ( IConstant.STRING_0 );
        } else {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "提交失败，请重新提交" );
        }
        return respons;
    }

    /**
     * 参数验证
     *
     * @param request
     * @return boolean
     * @title retParams
     */
    private boolean retParams(C01S020Request request, int state) {
        boolean retParams = false;
        if (request.getCustomerID () == null || request.getCustomerID () == "") {
            retParams = true;// 用户ID
        }

        if (state == 1) {
            if (request.getRfidString () == null || request.getRfidString () == "") {
                retParams = true;
            }
            if (request.getLaserIdentificationCode () == null || "".equals ( request.getLaserIdentificationCode () )) {
                retParams = true;
            }
        } else if (2 == state) {
            //材料号
            if (StringUtils.isEmpty ( request.getToolCode () )) {
                retParams = true;
            }
            if (StringUtils.isEmpty ( request.getOutsideFactoryID () )) {
                retParams = true;
            }
            if (request.getRfidCodeList () == null || request.getRfidCodeList ().size () < 1) {
                retParams = true;
            }


        }
        return retParams;
    }
}
