package com.icomp.wsdl.v01c01.c01s027.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c01.s027.ICOMPV01C01S027Service;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.TooltranarMassage;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.wsdl.v01c01.c01s027.business.C01S027Business;
import com.icomp.wsdl.v01c01.c01s027.endpoint.C01S027Request;
import com.icomp.wsdl.v01c01.c01s027.endpoint.C01S027Respons;
import com.icomp.wsdl.v01c01.c01s027.endpoint.ToolBackInfo;
import com.icomp.wsdl.v01c01.c01s027.endpoint.TransferToolMsg;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 刀具管理-刀具送回-Business实现类
 *
 * @author Taoyy
 * @ClassName: C01S027BusinessImpl
 * @date 2016年3月9日 14:15:12
 */
public class C01S027BusinessImpl implements C01S027Business {
    private C01S027Respons respons = null;
    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    private ICOMPV01C01S027Service iCOMPV01C01S027Service;

    public void setiCOMPV01C01S027Service(ICOMPV01C01S027Service iCOMPV01C01S027Service) {
        this.iCOMPV01C01S027Service = iCOMPV01C01S027Service;
    }

    /**
     * 取得交接的容器
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S027Respons getTransferToolsContarner(C01S027Request request) throws Exception {
        respons = new C01S027Respons();
        Map<String, Object> map = new HashMap<String, Object>();
        List<TransferToolMsg> ttmList = new ArrayList<TransferToolMsg>();
        TransferToolMsg ttm = null;

        if (retParams(request, 1)) {
            throw new BusinessException(IConstant.CEMSG0005, request.getLanguageCode(), request.getLanguageValue());
        }
        // 0:非容器 1:正常容器 2:报废容器 3:空容器
        String toolType = service.getToolsContainerByRfid(request.getRfidStringOut(), request.getCustomerID());
        if (toolType.equals(IConstant.TOOL_KIND_0)) {
            throw new BusinessException(IConstant.WMSG0247_1, request.getLanguageCode(), request.getLanguageValue());
        }
        if (!toolType.equals(IConstant.TOOL_KIND_1) && !toolType.equals(IConstant.TOOL_KIND_3)) {
            // 请扫描装刃磨刀具的容器
            throw new BusinessException(IConstant.WMSG0245_3, request.getLanguageCode(), request.getLanguageValue());
        }
        // 取得并判断刀具当前扫描刀具是否可以进行当前业务
        Map<String, Object> ret = service.checkToolStauts(request.getRfidStringOut(), "C01S027", request.getLanguageCode());
        if (ret.size() > 0 && !(Boolean.valueOf(ret.get("agreeFlag").toString()).booleanValue())) {
            if (ret.get("messageText") == null) {
                throw new BusinessException((String) ret.get("messageCode"), request.getLanguageCode(), request.getLanguageValue());
            } else {
                throw new BusinessException((String) ret.get("messageCode"), request.getLanguageCode(), request.getLanguageValue(), (String) ret.get("newFlowText"), (String) ret.get("lastFlowText"), (String) ret.get("messageText"));
            }
        }
        try {
            // 交换RFID
            map.put("rfidString", request.getRfidStringOut());
            // 取得交接的容器
            List<TooltranarMassage> reList = iCOMPV01C01S027Service.getTransferToolsContarner(map);
            // 交接方向(0对刀室-->刃磨室,1刃磨室-->对刀室)
            String aspact = null;
            if (reList.size() > 0) {
                for (TooltranarMassage tm : reList) {
                    ttm = new TransferToolMsg();
                    // 刀具编码
                    ttm.setToolCode(tm.getToolCode());
                    // 刀具id
                    ttm.setToolId(tm.getToolId());
                    // 交接数量
                    ttm.setTratarnerCount(Integer.parseInt(tm.getGrindingCount()));
                    aspact = tm.getToolThisState();
                    ttmList.add(ttm);
                }
                if (aspact != null) {
                    // 刀具部门(0库存,1对刀室,2刃磨室,3,车间)
                    if (IConstant.STSATIC_ONE.equals(aspact)) {
                        aspact = IConstant.STSATIC_ZERO;
                    } else if (IConstant.STSATIC_TWO.equals(aspact)) {
                        aspact = IConstant.STSATIC_ONE;
                    } else {
                        throw new BusinessException(IConstant.WMSG0225, request.getLanguageCode(), request.getLanguageValue());
                    }
                }
                respons.setAspact(aspact);
                respons.setTransferToolMsgList(ttmList);
                respons.setStatus(IConstant.ZERO);
                respons.setMessageText("信息取得成功");
            } else {
                throw new BusinessException(IConstant.WMSG0225, request.getLanguageCode(), request.getLanguageValue());
            }
        } catch (Exception e) {
            throw new BusinessException(IConstant.WMSG0225, request.getLanguageCode(), request.getLanguageValue());
        }
        return respons;
    }

    /**
     * 对刀室-->刃磨室 提交数据
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S027Respons saveKnifeToGrindingData(C01S027Request request) throws Exception {
        respons = new C01S027Respons();
        Map<String, Object> map = new HashMap<String, Object>();
        int reVal = 0;
        if (retParams(request, 4)) {
            throw new BusinessException(IConstant.CEMSG0005, request.getLanguageCode(), request.getLanguageValue());
        }
        // 根据RFID取得载体id
        String rfidContarnerIdOut = service.getrfidContainerIdByRfid(request.getRfidStringOut());
        String rfidContarnerIdIn = service.getrfidContainerIdByRfid(request.getRfidStringIn());
        List<TooltranarMassage> lists = new ArrayList<TooltranarMassage>();
        TooltranarMassage tt = null;
        for (TransferToolMsg ttm : request.getTransferToolMsgList()) {
            tt = new TooltranarMassage();
            // 刀具id
            tt.setToolId(ttm.getToolId());
            // 交接数量
            tt.setGrindingCount(ttm.getConfirmCount() + "");
            lists.add(tt);
        }
        // 容器中的信息
        map.put("transferToolMsg", lists);
        // 用户id
        map.put("userId", request.getCustomerID());
        // 交接人id
        map.put("gruantUserId", request.getGruantUserID());
        // 载体Out_id
        map.put("rfidContarnerIdOut", rfidContarnerIdOut);
        // 载体In_id
        map.put("rfidContarnerIdIn", rfidContarnerIdIn);
        try {
            // 对刀室-->刃磨室 提交数据
            reVal = iCOMPV01C01S027Service.saveKnifeToGrindingData(map);
            if (reVal < 1) {
                throw new BusinessException(IConstant.WMSG0228, request.getLanguageCode(), request.getLanguageValue());
            }
            respons.setStatus(IConstant.ZERO);
            respons.setMessageText("保存成功");
        } catch (Exception e) {
            throw new BusinessException(IConstant.WMSG0228, request.getLanguageCode(), request.getLanguageValue());
        }
        return respons;
    }

    /**
     * 刃磨室-->对刀室 提交数据
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S027Respons saveGrindingToKnifeData(C01S027Request request) throws Exception {
        respons = new C01S027Respons();
        Map<String, Object> map = new HashMap<String, Object>();
        int reVal = 0;
        if (retParams(request, 3)) {
            throw new BusinessException(IConstant.CEMSG0005, request.getLanguageCode(), request.getLanguageValue());
        }
        String rfidContarnerIdOut = service.getrfidContainerIdByRfid(request.getRfidStringOut());
        List<TooltranarMassage> lists = new ArrayList<TooltranarMassage>();
        TooltranarMassage tt = null;
        for (TransferToolMsg ttm : request.getTransferToolMsgList()) {
            tt = new TooltranarMassage();
            // 刀具id
            tt.setToolId(ttm.getToolId());
            // 交接数量
            tt.setGrindingCount(ttm.getConfirmCount() + "");
            lists.add(tt);
        }
        // 容器中的信息
        map.put("transferToolMsg", lists);
        // 用户id
        map.put("userId", request.getCustomerID());
        // 授权人id
        map.put("gruantUserId", request.getGruantUserID());
        // 取出容器载体
        map.put("rfidContarnerIdOut", rfidContarnerIdOut);
        try {
            // 刃磨室-->对刀室 提交数据
            reVal = iCOMPV01C01S027Service.saveGrindingToKnifeData(map);
            if (reVal < 1) {
                throw new BusinessException(IConstant.WMSG0228, request.getLanguageCode(), request.getLanguageValue());
            }
            respons.setStatus(IConstant.ZERO);
            respons.setMessageText("保存成功");
        } catch (Exception e) {
            throw new BusinessException(IConstant.WMSG0228, request.getLanguageCode(), request.getLanguageValue());
        }
        return respons;
    }

    /**
     * 取得盛放的容器
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S027Respons getPutContarner(C01S027Request request) throws Exception {
        respons = new C01S027Respons();
        if (retParams(request, 2)) {
            throw new BusinessException(IConstant.CEMSG0005, request.getLanguageCode(), request.getLanguageValue());
        }
        // 0:非容器 1:正常容器 2:报废容器 3:空容器
        String toolType = service.getToolsContainerByRfid(request.getRfidStringIn(), request.getCustomerID());
        if (toolType.equals(IConstant.TOOL_KIND_0)) {
            throw new BusinessException(IConstant.WMSG0247_1, request.getLanguageCode(), request.getLanguageValue());
        }
        if (!toolType.equals(IConstant.TOOL_KIND_1) && !toolType.equals(IConstant.TOOL_KIND_3)) {
            // 请扫描装刃磨刀具的容器
            throw new BusinessException(IConstant.WMSG0245_3, request.getLanguageCode(), request.getLanguageValue());
        }
        respons.setStatus(IConstant.ZERO);
        respons.setMessageText("取得成功");
        return respons;
    }

    /**
     * 参数验证
     *
     * @param request
     * @return boolean
     * @title retParams
     */
    private boolean retParams(C01S027Request request, int state) {
        boolean retParams = false;
        if (request.getCustomerID() == null || request.getCustomerID() == "") {
            retParams = true;// 用户ID
        }
        if (request.getLanguageCode() == null || request.getLanguageCode() == "") {
            retParams = true;// 语言编码（01）
        }
        if (request.getLanguageValue() == null || request.getLanguageValue() == "") {
            retParams = true;// 语言值（zh_en）
        }
        if (state == 1) {
            if (request.getRfidStringOut() == null || "".equals(request.getRfidStringOut())) {
                retParams = true;
            }
        }
        if (state == 2) {
            if (request.getRfidStringIn() == null || "".equals(request.getRfidStringIn())) {
                retParams = true;
            }
        }
        if (state == 3) {
            if (request.getRfidStringOut() == null || "".equals(request.getRfidStringOut())) {
                retParams = true;
            }
            if (request.getTransferToolMsgList() == null || (request.getTransferToolMsgList().size() < 1)) {
                retParams = true;
            }
        }
        if (state == 4) {
            if (request.getRfidStringOut() == null || "".equals(request.getRfidStringOut())) {
                retParams = true;
            }
            if (request.getRfidStringIn() == null || "".equals(request.getRfidStringIn())) {
                retParams = true;
            }
            if (request.getTransferToolMsgList() == null || (request.getTransferToolMsgList().size() < 1)) {
                retParams = true;
            }
        }

        return retParams;
    }

    /**
     * 取得刀具送回信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S027Respons getToolBackInfo(C01S027Request request) throws Exception {
        C01S027Respons respons = new C01S027Respons();
        Rfidcontainer entity = new Rfidcontainer();

        // 参数验证
        if (StringUtils.isEmpty(request.getRfidCode()) || StringUtils.isEmpty(request.getRfidType())) {
            throw new BusinessException(IConstant.WMSG0221, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE);
        }

        // RFID标签
        entity.setRfidCode(request.getRfidCode());
        // 删除区分
        entity.setDelFlag(IConstant.DEL_FLAG_0);

        // 验证RFID标签是否存在
        Rfidcontainer rfidcontainer = service.getRfidContainerByRfidCode(entity);
        if (rfidcontainer == null) {
            respons.setStateCode(IConstant.STRING_1);
            respons.setStateMsg("当前标签未初始化");
            return respons;
        }
        // 验证是否为单品刀具标签
        if (!IConstant.STRING_1.equals(rfidcontainer.getQueryType())) {
            respons.setStateCode(IConstant.STRING_1);
            respons.setStateMsg("请扫描单品刀具");
            return respons;
        }
        Map<String, String> param1 = new HashMap<String, String>();
        param1.put("businessCode", IConstant.C01S027);
        param1.put("rfidCode", request.getRfidCode());
        Map<String, String> reBuss = service.processControlBussinesCode(param1);
        if (reBuss == null) {
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg("查询失败，请联系管理员");
            return respons;
        } else {
            //0 正常流程 1.需要授权 2.不能执行当前流程 9.未知错误
            String buss = reBuss.get(IConstant.STATE_CODE);
            if (IConstant.STRING_1.equals(buss)) {
                respons.setStateCode(IConstant.STRING_5);
                respons.setStateMsg("需要授权");
                return respons;
            } else if (IConstant.STRING_2.equals(buss) || IConstant.BAND_TYPE_9.equals(buss)) {
                respons.setStateCode(IConstant.STRING_1);
                respons.setStateMsg(reBuss.get(IConstant.STATE_MSG));
                return respons;
            }
        }
        // 刀具流转表
        Tooltransfer tfentity = new Tooltransfer();
        // RFID载体ID
        tfentity.setRfidContainerID(rfidcontainer.getRfidContainerID());
        // 刀具状态(0断刀1丢失2不合格3待分拣4待换装,5到寿,6厂内待刃磨,7.厂外待刃磨8刃磨完毕,9其他)
        tfentity.setToolState(IConstant.TOOL_STATE_8);
        // 刀具部门(0库存,1对刀室,2刃磨室,3,车间)
        tfentity.setToolThisState(IConstant.USER_BLOOD_GROUP_2);
        // 删除区分
        tfentity.setDelFlag(IConstant.DEL_FLAG_0);
        Tooltransfer reentity = iCOMPV01C01S027Service.getTooltransferList(tfentity);
        if (reentity.getRetErrFlag()) {
            respons.setStateCode(IConstant.BAND_TYPE_2);
            respons.setStateMsg("未找到刀具流转信息");
            return respons;
        }
        // 刀具参数表
        Tool tlentity = new Tool();
        // 刀具id(容器)
        tlentity.setToolID(reentity.getToolID());
        // 删除区分
        tlentity.setDelFlag(IConstant.DEL_FLAG_0);
        Tool tool = iCOMPV01C01S027Service.getToolInfo(tlentity);
        if (tool == null) {
            respons.setStateCode(IConstant.BAND_TYPE_2);
            respons.setStateMsg("未找到刀具参数信息");
            return respons;
        }
        if (IConstant.STRING_1.equals(tool.getToolGrinding())) {
            respons.setStateCode(IConstant.BAND_TYPE_2);
            respons.setStateMsg("不能扫描厂外修磨的刀具");
            return respons;
        }
        Tooltransfer tt = new Tooltransfer();
        tt.setToolID(reentity.getToolID());
        tt.setToolState(IConstant.TOOL_STATE_8);
        List<Tooltransfer> ttlist = iCOMPV01C01S027Service.getToolState(tt);
        if (ttlist.size() < 0) {
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg("无应送回数量");
            return respons;
        }

        // 刀具ID
        respons.setToolID(reentity.getToolID());
        // 修磨方式（0,1）
        respons.setToolGrinding(tool.getToolGrinding());
        // 材料号
        respons.setMaterialNum(tool.getToolCode());
        // 应送回数量
        respons.setInventory(String.valueOf(ttlist.size()));
        // RFID标签
        respons.setRfidCode(request.getRfidCode());

        respons.setStateCode(IConstant.DEL_FLAG_0);
        respons.setStateMsg("取得成功");
        return respons;
    }

    /**
     * 提交刀具送回的刀具信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S027Respons saveToolBackInfo(C01S027Request request) throws Exception {
        C01S027Respons respons = new C01S027Respons();
        // 输入参数验证
        if (checkParam(request, 1)) {
            throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
        }

        Rfidcontainer entity = new Rfidcontainer();
        Tooltransfer tt = new Tooltransfer();
        // RFID标签
        for (ToolBackInfo tb : request.getToolBackInfoList()) {
            // 删除区分
            entity.setDelFlag(IConstant.DEL_FLAG_0);
            entity.setRfidCode(tb.getRfidCode());
            List<Rfidcontainer> rfList = iCOMPV01C01S027Service.getRfidcontainerIDs(entity);
            if (rfList == null) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("载体ID未找到");
            }

            //刀具ID
            tt.setToolIDWhere(tb.getToolID());
            //rfid载体
            tt.setRfidContainerIDWhere(rfList.get(0).getRfidContainerID());
            tt.setDelFlagWhere(IConstant.DEL_FLAG_0);
            //刀具状态
            tt.setToolStateWhere(IConstant.TOOL_STATE_8);
            //刀具部门
            tt.setToolThisStateWhere(IConstant.STOCK_STATE_2);
            //set
            tt.setToolThisState(IConstant.STOCK_STATE_1);
            tt.setToolState(IConstant.TOOL_STATE_4);
            tt.setBusinessFlowLnkID(IConstant.C01S027);
            tt.setToolDurable(BigDecimal.valueOf(tb.getFactCount()));
            tt.setInstallationState(IConstant.INSTALLATION_STATE_0);
            tt.setUpdateTime(new Date());
            tt.setUpdateUser(request.getCustomerID());
            tt.setDelFlag(IConstant.DEL_FLAG_0);
            //存放手持机id
            tt.setExpandSpace1(request.getHandSetId());

            //提交刀具送回信息
            int reValCount = iCOMPV01C01S027Service.saveToolBackInfo(tt);
            if (reValCount < 1) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("提交钻头刀具送回信息失败");
                return respons;
            }
        }

        //刀具送回签收，不需要授权
        //        if (request.getGruantUserID() != null) {
        //            //授权记录插入
        //            Authorization auth = new Authorization();
        //            //授权人ID
        //            auth.setAuthorizationUserID(request.getGruantUserID());
        //            //授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它）
        //            auth.setAuthorizedReason(IConstant.STRING_3);
        //            //刀具类型（0单品，1合成刀具）
        //            auth.setTooltype(IConstant.DEL_FLAG_0);
        //            //材料号或合成刀具编码
        //            auth.setToolCode(request.getToolCode());
        //            //业务流程编码
        //            auth.setBusinessCode("C01S027");
        //            auth.setCreateUserID(request.getCustomerID());
        //            //备注
        //            auth.setNote("刀具送回");
        //            service.innsetGruant(auth);
        //        }

        //		String RfidContainerID = service.getRfidContainerIDByRfidCode(entity);
        //		if (StringUtils.isEmpty(RfidContainerID)) {
        //			throw new BusinessException("未找到相应的RFID载体");
        //		}

        respons.setStateCode(IConstant.DEL_FLAG_0);
        respons.setStateMsg("aaaaa");
        return respons;
    }

    /**
     * 参数验证
     *
     * @param request
     * @param state
     * @return
     */

    private boolean checkParam(C01S027Request request, int state) {
        // 用户ID
        if (StringUtils.isEmpty(request.getCustomerID())) {
            return true;
        }
        // 签收人ID
        if (StringUtils.isEmpty(request.getGruantUserID())) {
            return true;
        }
        if (state == 1) {
            //刀具送回信息
            if (null == request.getToolBackInfoList() || request.getToolBackInfoList().size() < 1)
                return true;

        }
        return false;
    }

}
