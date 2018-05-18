package com.icomp.wsdl.v01c01.c01s003.business.impl;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c01.s003.ICOMPV01C01S003Service;
import com.icomp.common.service.icomp.v01c01.s010.ICOMPV01C01S010Service;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Knifeinventory;
import com.icomp.entity.base.Ledplane;
import com.icomp.entity.base.Redemptionapplied;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Vgetboxmessage;
import com.icomp.entity.base.Vgetpositioncapability;
import com.icomp.entity.base.Vgetredemptionappdetailedmsg;
import com.icomp.entity.base.Vgetshelfinformation;
import com.icomp.entity.base.Vledplanelist;
import com.icomp.entity.base.Vquerytoollist;
import com.icomp.entity.base.Vredemptionappdetailedmsgnew;
import com.icomp.wsdl.v01c01.c01s003.business.C01S003Business;
import com.icomp.wsdl.v01c01.c01s003.endpoint.AppliedInfo;
import com.icomp.wsdl.v01c01.c01s003.endpoint.C01S003Request;
import com.icomp.wsdl.v01c01.c01s003.endpoint.C01S003Respons;
import com.icomp.wsdl.v01c01.c01s003.endpoint.ChoiceDemption;
import com.icomp.wsdl.v01c01.c01s003.endpoint.LedPlaneStauts;
import com.icomp.wsdl.v01c01.c01s003.endpoint.RedemptionApplied;
import com.icomp.wsdl.v01c01.c01s003.endpoint.RedemptionApply;
import com.icomp.wsdl.v01c01.c01s003.endpoint.RedemptionDemption;
import com.icomp.wsdl.v01c01.c01s003.endpoint.RenewedToolInfo;
import com.icomp.wsdl.v01c01.c01s003.endpoint.StockMsgList;
import com.icomp.wsdl.v01c01.c01s003.endpoint.TempToolTransfer;

/**
 * 刀具换领-Business实现类
 *
 * @author Taoyy
 * @ClassName: C01S003BusinessImpl
 * @date 2016-3-4 下午01:26:56
 */
@SuppressWarnings("unchecked")
public class C01S003BusinessImpl implements C01S003Business {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    /**
     * 刀具换领-Serbice接口
     */
    private ICOMPV01C01S003Service iCOMPV01C01S003Service;

    public void setiCOMPV01C01S003Service(
            ICOMPV01C01S003Service iCOMPV01C01S003Service) {
        this.iCOMPV01C01S003Service = iCOMPV01C01S003Service;
    }

    /**
     * 查询单品刀具信息
     */
    private ICOMPV01C01S010Service icompv01c01s010Service;

    public void setIcompv01c01s010Service(
            ICOMPV01C01S010Service icompv01c01s010Service) {
        this.icompv01c01s010Service = icompv01c01s010Service;
    }

    /**
     * 取得换领申请单 getRedemptionInfo
     *
     * @param
     * @return
     * @throws Exception
     */
    public C01S003Respons getRedemptionInfo(C01S003Request request)
            throws Exception {
        C01S003Respons respons = new C01S003Respons();
        // 参数验证
        if (retParams(request, 0)) {
            throw new BusinessException(IConstant.WMSG0221, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        List<Redemptionapplied> lists = new ArrayList<Redemptionapplied>();
        // 判断用户的角色 D:库管员, R:换领人
        String role = null;
        Vgetpositioncapability pc = new Vgetpositioncapability();
        pc.setCustomerID(request.getCustomerID());
        List<Vgetpositioncapability> pclist = service.getPositionCapability(pc);
        if (pclist.get(0).isRetErrFlag()) {
            role = "NO";
        } else {
            role = pclist.get(0).getCapabilityCode();
        }
        // 取得换领申请单
        if ("D".equals(role) || "R".equals(role)) {
            lists = iCOMPV01C01S003Service
                    .getRedemptionInfo(new Redemptionapplied());
        } else {
            // 暂无权限
            respons.setStatus(IConstant.RESULT_CODE_1);
            respons.setMessageText(IConstant.EMSG0003, request
                    .getLanguageCode(), request.getLanguageValue());
            return respons;
        }
        if (lists.get(0).isRetErrFlag()) {
            // 查询失败
            throw new BusinessException(lists.get(0).getMessageCode(), request
                    .getLanguageCode(), request.getLanguageValue());
        } else {
            // 查询成功
            respons.setStatus(IConstant.RESULT_CODE_0);
            respons.setMessageText(IConstant.WMSG0219, request
                    .getLanguageCode(), request.getLanguageValue());
            respons.setToolCode(role);// 权限
            respons.setRedemptionAppliedList(lists);
        }
        return respons;
    }

    /**
     * 取得换领申请单明细 D：库房管理员： 申请中，已备货 ，换领未送回 R: 领刀人： 已备货（只读），换领未送回（只读）,充许换领（可操作)
     * 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )
     */
    public C01S003Respons getRedemptionDetail(C01S003Request request)
            throws Exception {
        C01S003Respons respons = new C01S003Respons();
        Vgetredemptionappdetailedmsg entity = new Vgetredemptionappdetailedmsg();
        List<RedemptionDemption> reList = new ArrayList<RedemptionDemption>();
        // 参数验证
        if (retParams(request, 1)) {
            throw new BusinessException(IConstant.WMSG0221, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        // 申请单号
        entity.setRedemptionAppliedID(request.getRedemptionAppliedID());

        // 角色
        entity.setToolCode(request.getToolCode());
        // 取得换领申请单明细
        List<Vgetredemptionappdetailedmsg> lists = iCOMPV01C01S003Service
                .getRedemptionDetail(entity);
        if (lists.get(0).isRetErrFlag()) {
            // 查询失败
            throw new BusinessException(lists.get(0).getMessageCode(), request
                    .getLanguageCode(), request.getLanguageValue());
        } else {
            // 查询成功
            RedemptionDemption rDemption = null;
            for (Vgetredemptionappdetailedmsg vm : lists) {
                rDemption = new RedemptionDemption();
                rDemption.setRedemptionAppliedID(vm.getRedemptionAppliedID());
                rDemption.setAppliedNumber(vm.getAppliedNumber().intValue());
                rDemption.setBrokenNumber(vm.getBrokenNumber().intValue());
                rDemption.setInventoryCount_A(vm.getInventoryCount_A()
                        .intValue());
                rDemption.setInventoryCount_B(vm.getInventoryCount_B()
                        .intValue());
                rDemption.setLostNumber(vm.getLostNumber().intValue());
                rDemption.setReturnNumber(vm.getReturnNumber().intValue());
                rDemption.setToolCode(vm.getToolCode());
                rDemption.setProcessingStatus(vm.getProcessingStatus());

                if (vm.getStockNumber() != null) {
                    rDemption.setStockNumber(vm.getStockNumber().toString());
                } else {
                    rDemption.setStockNumber(IConstant.STRING_0);
                }
                reList.add(rDemption);
            }
            respons.setReDetailedMsgList(reList);
            respons.setStatus(IConstant.RESULT_CODE_0);
            respons.setMessageText(IConstant.WMSG0219, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        return respons;
    }

    /**
     * 取得货架信息 getRedemptionToolInfo
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S003Respons getRedemptionToolInfo(C01S003Request request)
            throws Exception {
        C01S003Respons respons = new C01S003Respons();
        Vgetshelfinformation entity = new Vgetshelfinformation();
        List<RenewedToolInfo> reList = new ArrayList<RenewedToolInfo>();
        // 参数验证
        if (retParams(request, 2)) {
            throw new BusinessException(IConstant.WMSG0221, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        // 刀具编码
        entity.setToolCode(request.getToolCode());

        // 取得货架信息
        List<Vgetshelfinformation> lists = iCOMPV01C01S003Service
                .getRedemptionToolInfo(entity);
        if (lists.get(0).isRetErrFlag()) {
            // 查询失败
            throw new BusinessException(lists.get(0).getMessageCode(), request
                    .getLanguageCode(), request.getLanguageValue());
        } else {
            // 查询成功
            RenewedToolInfo rtInfo = null;
            for (Vgetshelfinformation info : lists) {
                rtInfo = new RenewedToolInfo();
                if (info.getCustomerCode() != null
                        && info.getCustomerCode() != "") {
                    rtInfo.setLibraryCode(info.getCustomerCode());// 入库码
                } else {
                    rtInfo.setLibraryCode(info.getSysteCode());// 入库码
                }
                rtInfo.setLayer(info.getLayerText());// 层
                rtInfo.setShelf(info.getShelfText());// 货架
                rtInfo.setStack(info.getStackText());// 货位
                rtInfo.setExistingNumber_A(info.getA_inverntoryCount()
                        .intValue());// A库
                rtInfo.setExistingNumber_B(info.getB_inverntoryCount()
                        .intValue());// B库
                reList.add(rtInfo);
            }
            respons.setRenewedToolInfoList(reList);
            respons.setStatus(IConstant.RESULT_CODE_0);
            respons.setMessageText(IConstant.WMSG0219, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        return respons;
    }

    /**
     * 查询单品刀具信息 seachToolInfo
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S003Respons seachToolInfo(C01S003Request request)
            throws Exception {
        C01S003Respons respons = new C01S003Respons();
        Vgetboxmessage entity = new Vgetboxmessage();
        List<RenewedToolInfo> reList = new ArrayList<RenewedToolInfo>();
        // 参数验证
        if (retParams(request, 3)) {
            throw new BusinessException(IConstant.WMSG0221, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        String toolType = service.getToolsTypeByRfid(request.getRfidString());
        if (toolType.equals(IConstant.TOOL_KIND_0)) { // 初始化
            throw new BusinessException(IConstant.WMSG0247, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        if (!toolType.equals(IConstant.TOOL_KIND_2)) {
            throw new BusinessException(IConstant.WMSG0245, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        // 刀具编码
        entity.setRfidCode(request.getRfidString());
        entity.setToolNameWhere(request.getShelf());// 状态标志
        // 取得并判断刀具当前扫描刀具是否可以进行【刀具换领】业务
        Map<String, Object> ret = service.checkToolStauts(request
                .getRfidString(), "C01S003", request.getLanguageCode());
        if (ret.size() > 0
                && !(Boolean.valueOf(ret.get("agreeFlag").toString())
                .booleanValue())) {
            if (ret.get("messageText") == null) {
                // 查询是否RFID是否绑定 如果没有绑定则绑定
                Map<String, Object> ret1 = service.checkIsHasRfid(request
                        .getRfidString(), request.getCustomerID());
                if (ret1.size() > 0) {
                    if ((Boolean) ret1.get("retIsEmptiy")) {
                        // 空盒
                        respons.setStatus(IConstant.RESULT_CODE_0);
                        respons.setMessageText(IConstant.CIMSG0045, request
                                .getLanguageCode(), request.getLanguageValue());
                        respons.setToolCount(0);
                    } else {
                        respons.setStatus(IConstant.RESULT_CODE_1);
                        respons.setMessageText(IConstant.CIMSG0045, request
                                .getLanguageCode(), request.getLanguageValue());
                        respons.setToolCount(1);
                    }
                } else {
                    throw new BusinessException(IConstant.WMSG0220, request
                            .getLanguageCode(), request.getLanguageValue());
                }
                return respons;
            } else {
                throw new BusinessException((String) ret.get("messageCode"),
                        request.getLanguageCode(), request.getLanguageValue(),
                        (String) ret.get("newFlowText"), (String) ret
                        .get("lastFlowText"), (String) ret
                        .get("messageText"));
            }
        }
        // 查询单品刀具信息
        // List<Vgetboxmessage> lists =
        // icompv01c01s010Service.getBoxMessage(entity);
        List<Vgetboxmessage> lists = null;
        Vgetshelfinformation entity1 = new Vgetshelfinformation();
        if (lists.size() > 0) {
            // 取得货架信息
            entity1.setToolCode(lists.get(0).getToolCode());// 刀具编码
            List<Vgetshelfinformation> shelfList = iCOMPV01C01S003Service
                    .getRedemptionToolInfo(entity1);
            if (lists.get(0).isRetErrFlag()) {
                // 查询失败
                throw new BusinessException(lists.get(0).getMessageCode(),
                        request.getLanguageCode(), request.getLanguageValue());
            } else if (shelfList.get(0).isRetErrFlag()) {
                // 查询失败
                throw new BusinessException(shelfList.get(0).getMessageCode(),
                        request.getLanguageCode(), request.getLanguageValue());

            } else {
                // 查询成功
                RenewedToolInfo rtInfo = null;
                for (Vgetshelfinformation info : shelfList) {
                    rtInfo = new RenewedToolInfo();
                    if (info.getCustomerCode() != null
                            && info.getCustomerCode() != "") {
                        rtInfo.setLibraryCode(info.getCustomerCode());// 入库码
                    } else {
                        rtInfo.setLibraryCode(info.getSysteCode());// 入库码
                    }
                    rtInfo.setLayer(info.getLayerText());// 层
                    rtInfo.setShelf(info.getShelfText());// 货架
                    rtInfo.setStack(info.getStackText());// 货位
                    rtInfo.setExistingNumber_A(info.getA_inverntoryCount()
                            .intValue());// A库
                    rtInfo.setExistingNumber_B(info.getB_inverntoryCount()
                            .intValue());// B库
                    reList.add(rtInfo);
                }
                respons.setRenewedToolInfoList(reList);
                respons.setToolCode(lists.get(0).getToolCode());// 刀具编码
                respons.setToolCount(lists.size());// 刀具数量
                respons.setStatus(IConstant.RESULT_CODE_0);
                respons.setMessageText(IConstant.WMSG0219, request
                        .getLanguageCode(), request.getLanguageValue());
            }
        } else {
            respons.setToolCount(lists.size());
            respons.setStatus(IConstant.RESULT_CODE_0);
            respons.setMessageText(IConstant.WMSG0219, request
                    .getLanguageCode(), request.getLanguageValue());

        }
        return respons;
    }

    /**
     * 新旧RFID交换 saveOutputStockingTool
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S003Respons saveOutputStockingTool(C01S003Request request)
            throws Exception {
        C01S003Respons respons = new C01S003Respons();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            // 参数验证
            if (retParams(request, 4)) {
                throw new BusinessException(IConstant.WMSG0221, request
                        .getLanguageCode(), request.getLanguageValue());
            }
            map.put("newRfid", request.getNewRfidString());
            map.put("oldRfid", request.getOldRfidString());
            map.put("tempNumbe", request.getTempNumber());
            map.put("userId", request.getCustomerID());

            // 新旧RFID交换
            // int reVal = iCOMPV01C01S003Service.saveOutputStockingTool(map);
            if (service.saveSplitBoxTool(map)) {
                respons.setStatus(IConstant.RESULT_CODE_0);
                respons.setMessageText(IConstant.WMSG0227, request
                        .getLanguageCode(), request.getLanguageValue());
            } else {
                throw new BusinessException(IConstant.IMSG0006, request
                        .getLanguageCode(), request.getLanguageValue());
            }
        } catch (Exception e) {
            throw new BusinessException(IConstant.IMSG0006, request
                    .getLanguageCode(), request.getLanguageValue());
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
    private boolean retParams(C01S003Request request, int state) {
        boolean retParams = false;
        if (request.getCustomerID() == null || request.getCustomerID() == "") {
            retParams = true;// 用户ID
        }
        if (request.getLanguageCode() == null
                || request.getLanguageCode() == "") {
            retParams = true;// 语言编码（01）
        }
        if (request.getLanguageValue() == null
                || request.getLanguageValue() == "") {
            retParams = true;// 语言值（zh_en）
        }
        if (state == 1) {
            if (request.getRedemptionAppliedID() == null
                    || request.getRedemptionAppliedID() == "") {
                retParams = true;// 申请单号
            }
            if (request.getToolCode() == null
                    || "".equals(request.getToolCode())) {
                retParams = true;// rold
            }

        }
        if (state == 2) {
            if (request.getToolCode() == null
                    || "".equals(request.getToolCode())) {
                retParams = true;// 刀具编码
            }

        }
        if (state == 3) {
            if (request.getRfidString() == null
                    || "".equals(request.getRfidString())) {
                retParams = true;// 扫描RFID
            }
        }

        if (state == 4) {
            if (request.getNewRfidString() == null
                    || "".equals(request.getNewRfidString())) {
                retParams = true;// 新RFID
            }
            if (request.getOldRfidString() == null
                    || "".equals(request.getOldRfidString())) {
                retParams = true;// 旧RFID
            }
            if (request.getTempNumber() == 0) {
                retParams = true;// 交换数量
            }
        }
        if (state == 5) {
            if (request.getRfidList() == null || request.getTransfers() == null) {
                retParams = true;// rfid 和换领申请单
            }
            if (request.getHandSetId() == null || request.getHandSetId() == "") {
                retParams = true;// rfid 和换领申请单
            }
            /*
			 * if (request.getToolCode() == null ||
			 * "".equals(request.getToolCode())) { retParams = true;// 状态 }
			 */

        }
        if (state == 6) {
            if (request.getRedemptionAppliedID() == null
                    || request.getRedemptionAppliedID() == "") {
                retParams = true;// 申请单号
            }
            if (request.getHandSetId() == null || request.getHandSetId() == "") {
                retParams = true;// 手持机ID
            }
            if (request.getToolCode() == null
                    || "".equals(request.getToolCode())) {
                // 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4允许换领 )
                retParams = true;
            }
        }
        if (state == 7) {
            if (request.getUserID() == null || request.getUserID() == "") {
                retParams = true;
            }
            if (request.getUserTime() == null || request.getUserTime() == "") {
                retParams = true;
            }
        }
        if (state == 8) {
            if (request.getUserID() == null || request.getUserID() == "") {
                retParams = true;
            }
            if (request.getUserTime() == null || request.getUserTime() == "") {
                retParams = true;
            }
            if (request.getStockLists() == null
                    || request.getStockLists().size() == 0) {
                retParams = true;
            }
        }
        if (state == 9) {
            if (request.getUserID() == null || request.getUserID() == "") {
                retParams = true;
            }
            if (request.getUserTime() == null || request.getUserTime() == "") {
                retParams = true;
            }
            if (request.getStockLists() == null
                    || request.getStockLists().size() == 0) {
                retParams = true;
            }
            if (request.getHandSetId() == null || request.getHandSetId() == "") {
                retParams = true;// 手持机ID
            }
        }
        if (state == 10) {
            if (request.getVledplanelist() == null
                    || request.getVledplanelist().size() == 0) {
                retParams = true;
            }
            if (request.getRfidList() == null
                    || request.getRfidList().size() == 0) {
                retParams = true;
            }
            if (request.getHandSetId() == null
                    || "".equals(request.getHandSetId())) {
                retParams = true;
            }
            if (request.getGruantUserID() == null
                    || "".equals(request.getGruantUserID())) {
                retParams = true;// 手持机ID
            }
        }
        return retParams;
    }

    /**
     * 更新备货刀具状态 aveStockingToolStauts
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S003Respons saveStockingToolStauts(C01S003Request request)
            throws Exception {
        C01S003Respons respons = new C01S003Respons();// 返回参数
        Map<String, Object> map = new HashMap<String, Object>();
        int parm = 0;
        // 验证
        if (retParams(request, 6)) {
            throw new BusinessException(IConstant.WMSG0221, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        String userID = request.getCustomerID();
        String state = request.getToolCode();// 状态
        List<Redemptionapplied> list = new ArrayList<Redemptionapplied>();

        try {
            Redemptionapplied re = null;
            if (request.getTransfers() != null) {
                for (TempToolTransfer ra : request.getTransfers()) {
                    re = new Redemptionapplied();
                    // 条件
                    re.setRedemptionAppliedID(ra.getRedemptionAppliedID());// 换领申请流水号
                    re.setToolCode(ra.getToolCode());// 刀具编码
                    re.setReceiveNumber(new BigDecimal(ra.getAppliedNumber()));// 领取数量
                    re.setUpdateUser(userID);// 更新者
                    re.setUpdateTime(new Date());
                    list.add(re);
                }

            }
            // 赋值
            map.put("appliedID", request.getRedemptionAppliedID());
            map.put("userId", request.getCustomerID());
            map.put("delList", request.getDelRfidList());
            map.put("rfidList", request.getRfidList());
            map.put("state", state); // 状态
            map.put("handerId", request.getHandSetId()); // 手机Id
            map.put("reList", list);// 换领申请
            if (request.getTransfersThree() != null
                    && request.getTransfersThree().size() > 0) {
                parm = request.getTransfersThree().size();
            }
            map.put("paramNumber", parm);

            // 更新备货刀具状态
            int reVal = iCOMPV01C01S003Service.saveStockingToolStauts(map);
            if (reVal > 0) {
                respons.setStatus(IConstant.RESULT_CODE_0);
                respons.setMessageText(IConstant.CIMSG0010, request
                        .getLanguageCode(), request.getLanguageValue());
            } else {
                throw new BusinessException(IConstant.CEMSG0003, request
                        .getLanguageCode(), request.getLanguageValue());
            }
        } catch (Exception e) {

            throw new BusinessException(IConstant.CEMSG0004, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        return respons;
    }

    /**
     * 保存换领出库信息-非单品
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S003Respons saveRedemptionApplied(C01S003Request request)
            throws Exception {
        C01S003Respons respons = new C01S003Respons();
        List<Redemptionapplied> RedemptionappliedList = request
                .getRedemptionAppliedInputList();
        String gruantUserID = request.getUserName();
        String userId = request.getCustomerID();
        String handId = request.getHandSetId();
        Map<String, Object> map = new HashMap<String, Object>();
        try {

            for (Redemptionapplied redemptionapplied : RedemptionappliedList) {
                // 领取人
                redemptionapplied.setReceiveUser(gruantUserID);
                // 更新换领申请表
                map = iCOMPV01C01S003Service
                        .updateRedemptionApplied(redemptionapplied);
                if (Integer.parseInt(map.get("status").toString()) < 0) {
                    // 异常
                    throw new BusinessException(IConstant.CEMSG0007, request
                            .getLanguageCode(), request.getLanguageValue());
                } else {
                    map.put("redemptionapplied", redemptionapplied);
                    map.put("handId", handId);
                    map.put("gruantUserID", gruantUserID);
                    map.put("userId", userId);
                    // 刀具出库进流转
                    Map<String, Object> ret = iCOMPV01C01S003Service
                            .saveRedemptionApplied(map);
                    if (!ret.get("status").equals(IConstant.RESULT_CODE_0)) {
                        throw new BusinessException(IConstant.CEMSG0007,
                                request.getLanguageCode(), request
                                .getLanguageValue());
                    }
                }
            }
            // 正常
            respons.setStatus(IConstant.RESULT_CODE_0);
            respons.setMessageText(IConstant.CIMSG0011, request
                    .getLanguageCode(), request.getLanguageValue());
        } catch (Exception e) {
            throw new BusinessException(IConstant.CEMSG0007, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        return respons;
    }

    /**
     * 换领结束 saveRedemptionInfo
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S003Respons saveRedemptionInfo(C01S003Request request)
            throws Exception {
        C01S003Respons respons = new C01S003Respons();
        List<Redemptionapplied> list = new ArrayList<Redemptionapplied>();
        List<Redemptionapplied> listThree = new ArrayList<Redemptionapplied>();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            // 参数验证
            if (retParams(request, 5)) {
                throw new BusinessException(IConstant.CEMSG0005, request
                        .getLanguageCode(), request.getLanguageValue());
            }
            String userID = request.getCustomerID();
            // 取得Old用户
            Redemptionapplied re = null;
            for (TempToolTransfer ra : request.getTransfers()) {
                re = new Redemptionapplied();
                // 条件
                re.setRedemptionAppliedID(ra.getRedemptionAppliedID());// 换领申请流水号
                re.setToolCode(ra.getToolCode());// 刀具编码
                re.setReceiveNumber(new BigDecimal(ra.getAppliedNumber()));// 领取数量
                re.setReceiveTime(new Date());
                re.setReceiveUser(userID);// 领取人
                // 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4换领完毕 )
                re.setProcessingStatus(IConstant.STRING_4);
                re.setUpdateUser(userID);// 更新者
                re.setUpdateTime(new Date());
                list.add(re);
            }
            for (TempToolTransfer ra : request.getTransfersThree()) {
                re = new Redemptionapplied();
                // 条件
                re.setRedemptionAppliedID(ra.getRedemptionAppliedID());// 换领申请流水号
                re.setToolCode(ra.getToolCode());// 刀具编码
                re.setReceiveNumber(new BigDecimal(ra.getAppliedNumber()));// 领取数量
                re.setReceiveTime(new Date());
                re.setReceiveUser(userID);// 领取人
                re.setUpdateUser(userID);// 更新者
                re.setUpdateTime(new Date());
                listThree.add(re);
            }
            map.put("userId", userID);
            map.put("reList", list);// 换领申请
            map.put("listThree", listThree);// 换领申请(未送回)
            map.put("handerId", request.getHandSetId());
            map.put("rfidList", request.getRfidList());

            // 换领结束
            int reVal = iCOMPV01C01S003Service.saveRedemptionInfo(map);
            if (reVal > 0) {
                respons.setStatus(IConstant.RESULT_CODE_0);
                respons.setMessageText(IConstant.CIMSG0011, request
                        .getLanguageCode(), request.getLanguageValue());
            } else {
                throw new BusinessException(IConstant.CEMSG0007, request
                        .getLanguageCode(), request.getLanguageValue());
            }
        } catch (Exception e) {
            throw new BusinessException(IConstant.CEMSG0007, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        return respons;
    }

    /**
     * 验证是否存在专机领用数据
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S003Respons
     * @title existLedplane
     */
    public C01S003Respons existLedplane(C01S003Request regSwitch)
            throws Exception {
        C01S003Respons respons = new C01S003Respons();
        Vledplanelist entity = new Vledplanelist();
        List<Vledplanelist> list = iCOMPV01C01S003Service.existLedplane(entity);
        if (list.get(0).isRetErrFlag()) {
            // 查询失败
            throw new BusinessException(list.get(0).getMessageCode(), regSwitch
                    .getLanguageCode(), regSwitch.getLanguageValue());
        } else {
            respons.setExistLedplane(true);
            respons.setLedplaneList(list);
        }
        return respons;
    }

    /**
     * 取得区分值列表
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S003Respons
     * @title getComlist
     */
    public C01S003Respons getComlist(C01S003Request regSwitch) throws Exception {
        C01S003Respons respons = new C01S003Respons();
        Comlist comlist = new Comlist();
        comlist.setLanguageCode(regSwitch.getLanguageCode());
        comlist.setComListType("LedPlaneStauts");
        List<Comlist> list = service.getComList(comlist);
        List<LedPlaneStauts> ledPlaneStautsList = new ArrayList<LedPlaneStauts>();
        for (Comlist entity : list) {
            LedPlaneStauts ledPlaneStauts = new LedPlaneStauts();
            ledPlaneStauts.setValue(entity.getComListValue());
            ledPlaneStauts.setName(entity.getComListText());
            ledPlaneStautsList.add(ledPlaneStauts);
        }
        respons.setLedPlaneStautsList(ledPlaneStautsList);
        return respons;
    }

    /**
     * 取得扫描标签的绑定刀具数量及刀具编码
     *
     * @param request
     * @return
     * @throws Exception C01S003Respons
     * @title getToolInfo
     */
    public C01S003Respons getToolInfo(C01S003Request request) throws Exception {
        C01S003Respons respons = new C01S003Respons();
        Vquerytoollist entity = new Vquerytoollist();

        // 判断扫描的刀具类型
        if (request.getRfidString() != null
                && !"".equals(request.getRfidString().trim())) {
            String toolType = service.getToolsTypeByRfid(request
                    .getRfidString());
            if (toolType.equals(IConstant.TOOL_KIND_0)) { // 未初始化
                throw new BusinessException(IConstant.WMSG0247, request
                        .getLanguageCode(), request.getLanguageValue());
            }
            if (!toolType.equals(IConstant.TOOL_KIND_2)) {
                throw new BusinessException(IConstant.WMSG0245, request
                        .getLanguageCode(), request.getLanguageValue());
            }
        }

        // 取得并判断刀具当前扫描刀具是否可以进行【刀具换领】业务
        Map<String, Object> ret = service.checkToolStauts(request
                .getRfidString(), "C01S003", request.getLanguageCode());
        if (ret.size() > 0
                && !(Boolean.valueOf(ret.get("agreeFlag").toString())
                .booleanValue())) {
            if (ret.get("messageText") == null) {
                // 查询是否RFID是否绑定 如果没有绑定则绑定
                Map<String, Object> ret1 = service.checkIsHasRfid(request
                        .getRfidString(), request.getCustomerID());
                if (ret1.size() > 0) {
                    if ((Boolean) ret1.get("retIsEmptiy")) {
                        // 空盒
                        respons.setStatus(IConstant.RESULT_CODE_0);
                        respons.setMessageText(IConstant.CIMSG0045, request
                                .getLanguageCode(), request.getLanguageValue());
                        respons.setToolCount(0);
                    } else {
                        respons.setStatus(IConstant.RESULT_CODE_1);
                        respons.setMessageText(IConstant.CIMSG0045, request
                                .getLanguageCode(), request.getLanguageValue());
                        respons.setToolCount(1);
                    }
                } else {
                    throw new BusinessException(IConstant.WMSG0220, request
                            .getLanguageCode(), request.getLanguageValue());
                }
                return respons;
            } else {
                throw new BusinessException((String) ret.get("messageCode"),
                        request.getLanguageCode(), request.getLanguageValue(),
                        (String) ret.get("newFlowText"), (String) ret
                        .get("lastFlowText"), (String) ret
                        .get("messageText"));
            }
        }
        entity.setRfidCode("".equals(request.getRfidString()) ? null : request
                .getRfidString());
        List<Vquerytoollist> list = iCOMPV01C01S003Service.getToolInfo(entity);
        if (list.size() == 1 && list.get(0).isRetErrFlag()) {
            throw new BusinessException(list.get(0).getMessageCode(), request
                    .getLanguageCode(), request.getLanguageValue());
        }
        // 刀具编码
        respons.setToolCode(list.get(0).getToolCode());
        // 刀具数量
        respons.setToolCount(list.get(0).getToolCount().intValue());
        respons.setStatus(IConstant.ZERO);
        return respons;
    }

    /**
     * 保存专机领用数据
     *
     * @param request
     * @return
     * @throws Exception C01S003Respons
     * @title saveLedplane
     */
    public C01S003Respons saveLedplane(C01S003Request request) throws Exception {
        C01S003Respons respons = new C01S003Respons();
        Map<String, Object> map = new HashMap<String, Object>();
        List<Ledplane> list = new ArrayList<Ledplane>();
        Ledplane ledplane = null;
        // 参数验证
        if (retParams(request, 10)) {
            throw new BusinessException(IConstant.CEMSG0005, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        for (Vledplanelist v : request.getVledplanelist()) {
            ledplane = new Ledplane();
            ledplane.setLedPlaneID(v.getLedPlaneID());// 专机领用申请ID
            ledplane.setToolID(v.getToolID()); // 刀具id
            ledplane.setLedPlaneCount(v.getLedPlaneCount());// 申请数量
            ledplane.setReturnCount(v.getReturnCount());// 领取数量
            list.add(ledplane);
        }
        map.put("rfidlist", request.getRfidList());// 扫描的rfidlist
        map.put("ledplaneList", list);// 要提交的数据
        map.put("gruantUserID", request.getGruantUserID());// 授权人id
        map.put("handId", request.getHandSetId());// 手持机ID
        map.put("userId", request.getCustomerID());
        int ret;
        try {
            ret = iCOMPV01C01S003Service.saveLedplane(map);
            if (ret < 0) {
                throw new BusinessException(IConstant.WMSG0262, request
                        .getLanguageCode(), request.getLanguageValue());
            }
        } catch (Exception ex) {
            System.out.printf("saveLedplane" + ex.getMessage().toString());
            throw new BusinessException(IConstant.WMSG0262, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        respons.setStatus(IConstant.ZERO);
        return respons;
    }

    /**
     * 取得换领申请单列表按照人名和日期进行排序并显示在list中
     *
     * @param request
     * @return
     * @throws Exception C01S004Respons
     * @title saveStockingToolStauts
     */
    public C01S003Respons getRequestList(C01S003Request request)
            throws Exception {
        C01S003Respons ret = new C01S003Respons();
        List<RedemptionApplied> redemptionappliedList = new ArrayList<RedemptionApplied>();
        // 取得申请信息
        List<Redemptionapplied> reLIst = iCOMPV01C01S003Service
                .getRequestList();
        if (reLIst.get(0).isRetErrFlag()) {
            // 查询失败
            throw new BusinessException(reLIst.get(0).getMessageCode(), request
                    .getLanguageCode(), request.getLanguageValue());
        }
        RedemptionApplied rede = null;
        for (Redemptionapplied re1 : reLIst) {
            rede = new RedemptionApplied();
            rede.setUserName(service.getUserName(re1.getApplyUser())); // 名称
            rede.setUserTime(df.format(re1.getApplyTime()));// 申请时间
            rede.setUserId(re1.getApplyUser());
            redemptionappliedList.add(rede);
        }
        if (redemptionappliedList.size() > 0) {
            ret.setRedemptionappliedList(redemptionappliedList);
            ret.setStatus(IConstant.ZERO);
        } else {
            throw new BusinessException(reLIst.get(0).getMessageCode(), request
                    .getLanguageCode(), request.getLanguageValue());
        }
        return ret;
    }

    /**
     * 取得前页面传递的用户选择的申请单归还清单
     *
     * @param regSwitch
     * @return
     * @throws Exception
     * @throws Exception C01S003Respons
     * @title getRemand
     */
    public C01S003Respons getRemand(C01S003Request regSwitch) throws Exception {
        C01S003Respons ret = new C01S003Respons();
        List<ChoiceDemption> choiceDemptionList = new ArrayList<ChoiceDemption>();
        ChoiceDemption choiceDemption = new ChoiceDemption();
        // 根据前台传递的 申请人及申请时间取得对应的领取数据
        String userID = regSwitch.getUserID();// 申请人
        String userTime = regSwitch.getUserTime();// 申请时间
        Redemptionapplied entity = new Redemptionapplied();
        entity.setApplyUser(userID);
        entity.setApplyTime(Ctl.strToDate(userTime));
        // 取得换领申请单信息
        List<Redemptionapplied> reLIst = iCOMPV01C01S003Service
                .getRemand(entity);
        if (reLIst.size() == 1 && reLIst.get(0).isRetErrFlag()) {
            throw new BusinessException(reLIst.get(0).getMessageCode(),
                    regSwitch.getLanguageCode(), regSwitch.getLanguageValue());
        }
        for (Redemptionapplied re1 : reLIst) {
            choiceDemption = new ChoiceDemption();
            choiceDemption.setToolCode(re1.getToolCode()); // 名称
            choiceDemption.setAppliedNumber(re1.getAppliedNumber().intValue());// 申请时间
            choiceDemption.setReturnNumber(re1.getReturnNumber().intValue()
                    + re1.getLostNumber().intValue());
            choiceDemptionList.add(choiceDemption);
        }
        ret.setChoiceDemptionList(choiceDemptionList);
        return ret;
    }

    /**
     * 备货信息提交_新
     *
     * @param request
     * @throws Exception
     */
    public C01S003Respons stockMsgSubmit(C01S003Request request)
            throws Exception {
        C01S003Respons respons = new C01S003Respons();
        List<Redemptionapplied> list = new ArrayList<Redemptionapplied>();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            // 参数验证
            if (retParams(request, 8)) {
                throw new BusinessException(IConstant.CEMSG0005, request
                        .getLanguageCode(), request.getLanguageValue());
            }
            String userID = request.getCustomerID();

            Redemptionapplied re = null;
            for (StockMsgList sml : request.getStockLists()) {
                re = new Redemptionapplied();
                re.setApplyUser(request.getUserID());// 换领申请申请人
                re.setToolCode(sml.getToolCode());// 刀具编码
                re.setApplyTime(df.parse(request.getUserTime()));// 申请时间
                re.setStockNumber(new BigDecimal(sml.getStockNum()));// 备货数量
                re.setRfidList(sml.getRfids()); // 扫描的rfid
                list.add(re);
            }
            map.put("userId", userID);
            map.put("reList", list);//

            // 当前备货结束
            int reVal = iCOMPV01C01S003Service.stockMsgSubmit(map);
            if (reVal > 0) {
                respons.setStatus(IConstant.RESULT_CODE_0);
                respons.setMessageText(IConstant.CIMSG0011, request
                        .getLanguageCode(), request.getLanguageValue());
            } else {
                throw new BusinessException(IConstant.CEMSG0007, request
                        .getLanguageCode(), request.getLanguageValue());
            }
        } catch (Exception e) {
            throw new BusinessException(IConstant.CEMSG0007, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        return respons;
    }

    /**
     * 领刀授权提交
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S003Respons saveGetChangeTool(C01S003Request request)
            throws Exception {
        C01S003Respons respons = new C01S003Respons();// 返回参数
        Map<String, Object> map = new HashMap<String, Object>();
        // 验证
        if (retParams(request, 9)) {
            throw new BusinessException(IConstant.WMSG0221, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        List<Redemptionapplied> list = new ArrayList<Redemptionapplied>();

        try {
            Redemptionapplied re = null;
            for (StockMsgList ra : request.getStockLists()) {
                re = new Redemptionapplied();
                re.setApplyUser(request.getUserID());// 申请人
                re.setApplyTime(df.parse(request.getUserTime()));// 申请时间
                re.setToolCode(ra.getToolCode());// 刀具编码
                re.setReceiveNumber(new BigDecimal(ra.getStockNum())); // 实际领取数量
                re.setReceiveUser(request.getUserName()); // 授权人id
                list.add(re);
            }
            // 赋值
            map.put("userId", request.getCustomerID());
            map.put("handerId", request.getHandSetId()); // 手机Id
            map.put("reList", list);// 换领申请
            map.put("gruantUserID", request.getUserName());// 授权人id
            // 更新备货刀具状态
            int reVal = iCOMPV01C01S003Service.saveGetChangeTool(map);
            if (reVal > 0) {
                respons.setStatus(IConstant.RESULT_CODE_0);
                respons.setMessageText(IConstant.CEMSG0003_2, request
                        .getLanguageCode(), request.getLanguageValue());
            } else {
                throw new BusinessException(IConstant.CEMSG0003_1, request
                        .getLanguageCode(), request.getLanguageValue());
            }
        } catch (Exception e) {
            throw new BusinessException(IConstant.CEMSG0003_1, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        return respons;
    }

    /**
     * 取得用户选择的申请人、申请时间对应的备货信息
     *
     * @param request
     * @return
     * @throws Exception C01S004Respons
     * @title getChoiceList
     */
    public C01S003Respons getChoiceList(C01S003Request request)
            throws Exception {
        C01S003Respons ret = new C01S003Respons();
        Vredemptionappdetailedmsgnew vredemptionappdetailedmsgnew = new Vredemptionappdetailedmsgnew();
        // 参数验证
        if (retParams(request, 7)) {
            throw new BusinessException(IConstant.WMSG0221, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        vredemptionappdetailedmsgnew.setApplyUser(request.getUserID());
        vredemptionappdetailedmsgnew.setApplyTime(request.getUserTime());

        List<ChoiceDemption> choiceDemptionList = new ArrayList<ChoiceDemption>();
        ChoiceDemption choiceDemption = null;
        // 获取申请单列表详细信息_新
        List<Vredemptionappdetailedmsgnew> vnews = iCOMPV01C01S003Service
                .getChoiceList(vredemptionappdetailedmsgnew);
        if (vnews.get(0).isRetErrFlag()) {
            // 查询失败
            throw new BusinessException(vnews.get(0).getMessageCode(), request
                    .getLanguageCode(), request.getLanguageValue());
        } else {
            for (Vredemptionappdetailedmsgnew vn : vnews) {
                choiceDemption = new ChoiceDemption();
                choiceDemption.setAppliedNumber(vn.getAppliedNumber()
                        .intValue()); // 申请数量
                choiceDemption.setBrokenNumber(vn.getBrokenNumber().intValue());// 断刀数量
                choiceDemption.setFinishNumber(vn.getLifeOverNumber()
                        .intValue());// 到寿数量
                choiceDemption.setInventoryCount_A(vn.getInventoryCount_A()
                        .intValue()); // 新库中的数量
                choiceDemption.setInventoryCount_B(vn.getInventoryCount_B()
                        .intValue());// B库数量
                choiceDemption.setLblCode(vn.getLblCode()); // 库位码
                choiceDemption.setLostNumber(vn.getLostNumber().intValue());// 丢刀数量
                choiceDemption.setProcessingStatus(vn.getProcessingStatus()); // 申请状态
                choiceDemption.setRedemptionAppliedID(null);
                choiceDemption.setReturnNumber(vn.getReturnNumber().intValue());// 送回数量
                choiceDemption.setStockNumber(vn.getStockNumber().intValue());// 备货数量
                choiceDemption.setToolCode(vn.getToolCode()); // 刀具编码
                choiceDemption.setReceiveNumber(vn.getReceiveNumber()
                        .intValue());// 已领取数量
                choiceDemptionList.add(choiceDemption);
            }
            ret.setChoiceDemptionList(choiceDemptionList);
            ret.setStatus(IConstant.ZERO);
        }
        return ret;
    }

    /**
     * 旧刀送回信息提交
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S003Respons reToolSubmit(C01S003Request request) throws Exception {
        C01S003Respons ret = new C01S003Respons();
        // 取得前台扫描的rfid列表
        List<String> rfids = request.getRfidList();
        List<StockMsgList> stockLists = request.getStockLists();
        Map<String, Object> map = new HashMap<String, Object>();

        List<Redemptionapplied> list = new ArrayList<Redemptionapplied>();
        for (StockMsgList stockMsgList : stockLists) {
            Redemptionapplied redemptionapplied = new Redemptionapplied();
            redemptionapplied.setAppliedNumber(new BigDecimal(stockMsgList
                    .getAppliedNum()));
            redemptionapplied.setApplyUser(request.getUserID());
            redemptionapplied.setApplyTime(df.parse(request.getUserTime()));
            redemptionapplied.setToolCode(stockMsgList.getToolCode());
            redemptionapplied.setReturnNumber(new BigDecimal(stockMsgList
                    .getStockNum()));
            list.add(redemptionapplied);
        }
        map.put("rfids", rfids);
        map.put("stockLists", list);
        map.put("userId", request.getCustomerID());
        map.put("handerId", request.getHandSetId());
        int reVal = 0;
        try {
            reVal = iCOMPV01C01S003Service.rereToolSubmit(map);
        } catch (Exception e) {
            System.out.printf("rereToolSubmit" + e.getMessage().toString());
            throw new BusinessException(IConstant.CEMSG0007, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        if (reVal > 0) {
            ret.setStatus(IConstant.RESULT_CODE_0);
            ret.setMessageText(IConstant.CIMSG0011, request.getLanguageCode(),
                    request.getLanguageValue());
        } else {
            throw new BusinessException(IConstant.CEMSG0007, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        return ret;
    }

    /**
     * 取得已备货的刀具信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S003Respons getReadiedToolsMessage(C01S003Request request)
            throws Exception {
        C01S003Respons respons = new C01S003Respons();
        Map<String, Object> map = new HashMap<String, Object>();
        // 判断扫描的刀具类型
        if (request.getRfidString() != null
                && !"".equals(request.getRfidString().trim())) {
            String toolType = service.getToolsTypeByRfid(request
                    .getRfidString());
            if (toolType.equals(IConstant.TOOL_KIND_0)) { // 未初始化
                throw new BusinessException(IConstant.WMSG0247, request
                        .getLanguageCode(), request.getLanguageValue());
            }
            if (!toolType.equals(IConstant.TOOL_KIND_2)) {
                throw new BusinessException(IConstant.WMSG0245, request
                        .getLanguageCode(), request.getLanguageValue());
            }
        }
        // 参数验证
        if (retParams(request, 3)) {
            throw new BusinessException(IConstant.WMSG0221, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        map.put("rfidString", request.getRfidString());
        map.put("userId", request.getCustomerID());
        Redemptionapplied redemptionapplied = iCOMPV01C01S003Service
                .getReadiedToolsMessage(map);
        if (redemptionapplied.isRetErrFlag()) {
            throw new BusinessException(redemptionapplied.getMessageCode(),
                    request.getLanguageCode(), request.getLanguageValue());
        }
        respons.setToolCode(df.format(redemptionapplied.getApplyTime())); // 申请时间
        respons.setOptionName(service.getUserName(redemptionapplied
                .getApplyUser()));// 申请人
        respons.setStatus(IConstant.ZERO);
        return respons;
    }

    /**
     * 获取申请人列表
     */
    @Override
    public C01S003Respons getApplyUser(C01S003Request request) throws Exception {
        C01S003Respons respons = new C01S003Respons();
        Map<String, Object> rtn = iCOMPV01C01S003Service.getApplyUser();
        if (Integer.parseInt(rtn.get("status").toString()) < 0) {
            throw new BusinessException(IConstant.EMSG0004_A, request
                    .getLanguageCode(), request.getLanguageValue());
        }
        List<Redemptionapplied> list = (List<Redemptionapplied>) rtn
                .get("data");
        respons.setStateCode(IConstant.DEL_FLAG_0);
        respons.setStateMsg("取得成功");
        respons.setRedemptionAppliedList(list);
        return respons;
    }

    @Override
    public C01S003Respons getRedemptionappliedListCodeByUserid(
            C01S003Request request) throws Exception {
        C01S003Respons respons = new C01S003Respons();
        Map<String, Object> rtn = iCOMPV01C01S003Service
                .getRedemptionappliedListCodeByUserid();
        List<Redemptionapplied> list = (List<Redemptionapplied>) rtn
                .get("data");
        if (Integer.parseInt(rtn.get("status").toString()) < 0) {
            respons.setMessageText(rtn.get("message").toString());
            throw new BusinessException(rtn.get("MessageCode").toString(),
                    request.getLanguageCode(), request.getLanguageValue());
        }
        respons.setStatus(Integer.parseInt(rtn.get("status").toString()));
        respons.setRedemptionAppliedList(list);
        return respons;
    }

    /**
     * 取得刀具基本信息
     *
     * @param request (通过RFIDCode)
     * @return
     * @throws
     * @throws Exception
     */
    public C01S003Respons getToolInfoFD(C01S003Request request)
            throws Exception {
        // 判断扫描和刀具类型
        String toolType = null;
        if (request.getRfidString() != null) {
            toolType = service.getToolsTypeByRfid(request.getRfidString());
            if (toolType.equals(IConstant.TOOL_KIND_0)) { // 未初始化
                throw new BusinessException(IConstant.WMSG0247, request
                        .getLanguageCode(), request.getLanguageValue());
            }
            if (!toolType.equals(IConstant.TOOL_KIND_2)) {
                throw new BusinessException(IConstant.WMSG0245, request
                        .getLanguageCode(), request.getLanguageValue());
            }
        }
        C01S003Respons respons = new C01S003Respons();
        // 依据刀具库位码取得刀具基本信息
        Vquerytoollist entity = new Vquerytoollist();
        entity.setRfidCode(request.getRfidString());
        Vquerytoollist vquerytoollist = iCOMPV01C01S003Service
                .findToolInfo(entity);

        if (vquerytoollist.isRetErrFlag()) {
            throw new BusinessException(vquerytoollist.getMessageCode(),
                    request.getLanguageCode(), request.getLanguageValue());
        }

        respons.setVquerytoollist(vquerytoollist);
        respons.setStatus(IConstant.RESULT_CODE_0);
        return respons;
    }

    /**
     * 取得换领申请人申请信息
     *
     * @param request (通过RFIDCode)
     * @return
     * @throws
     * @throws Exception
     */
    @SuppressWarnings("null")
    @Override
    public C01S003Respons getApplyInfo(C01S003Request request) throws Exception {
        C01S003Respons respons = new C01S003Respons();
        Redemptionapplied entity = new Redemptionapplied();
        // 参数验证
        if (StringUtils.isEmpty(request.getRedemptionApplyUserName())
                || StringUtils.isEmpty(request.getRedemptionApplyUserID())) {
            throw new BusinessException(IConstant.WMSG0221,
                    IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE);
        }
        // 用户ID
        entity.setApplyUser(request.getRedemptionApplyUserID());
        // 删除区分(0有效1删除)
        entity.setDelFlag(IConstant.DEL_FLAG_0);
        // 验证用户是否存在
        Redemptionapplied userdetail = iCOMPV01C01S003Service.searchUserExit(entity);
        if (userdetail.isRetErrFlag()) {
            throw new BusinessException(userdetail.getMessageCode(),
                    IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE);
        }
        // 查询换领申请表
        Map<String, Object> rtn = iCOMPV01C01S003Service.getApplyInfo(userdetail);
        List<Redemptionapplied> list = (List<Redemptionapplied>) rtn.get("data");
        if (Integer.parseInt(rtn.get("status").toString()) < 0) {
            respons.setStateCode(IConstant.STRING_1);
            respons.setStateMsg("该申请人没有对应的换领出库单");
            return respons;
        }
        List<AppliedInfo> rep = new ArrayList<AppliedInfo>();
        for (Redemptionapplied ra : list) {
            AppliedInfo ap = new AppliedInfo();
            // 材料号
            ap.setMaterialNum(ra.getToolCode());
            // 库位码
            ap.setLibraryCodeID(ra.getExpandSpace1());
            // 申请数量
            ap.setAppliedNumber(ra.getAppliedNumber().toString());
            rep.add(ap);
        }
        respons.setStateCode(IConstant.DEL_FLAG_0);
        respons.setStateMsg("查询成功");
        respons.setAppliedInfoList(rep);
        return respons;
    }

    /**
     * 取得要换领出库的刀具信息
     *
     * @param request (通过RFIDCode)
     * @return
     * @throws
     * @throws Exception
     */
    @Override
    public C01S003Respons getRedemptionapplyInfo(C01S003Request request)
            throws Exception {
        C01S003Respons respons = new C01S003Respons();
        Rfidcontainer entity = new Rfidcontainer();
        // 参数验证
        if (StringUtils.isEmpty(request.getCustomerID())
                || StringUtils.isEmpty(request.getRfidCode())) {
            throw new BusinessException(IConstant.WMSG0221,
                    IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE);
        }
        // RFID标签
        entity.setRfidCode(request.getRfidCode());
        // 删除区分
        entity.setDelFlag(IConstant.DEL_FLAG_0);
        Rfidcontainer rfidcontainer = service.getRfidContainerByRfidCode(entity);
        if (rfidcontainer==null) {
        	respons.setStateCode(IConstant.STRING_1);
        	respons.setStateMsg("当前标签未初始化");
        	return respons;
        }
        if (!IConstant.STRING_0.equals(rfidcontainer.getQueryType())&&!IConstant.STRING_1.equals(rfidcontainer.getQueryType())) {
        	respons.setStateCode(IConstant.STRING_1);
        	respons.setStateMsg("请扫描单品刀具或库位标签");
        	return respons;
		}
        
//        //流程控制
//        Map<String, String> param = new HashMap<String, String>();
//        param.put("businessCode", IConstant.C01S003);
//        param.put("rfidCode", request.getRfidCode());
//        Map<String, String> reBuss = service.processControlBussinesCode(param);
//        if (reBuss == null) {
//            respons.setStateCode(IConstant.DEL_FLAG_1);
//            respons.setStateMsg("查询失败，请联系管理员");
//            return respons;
//        } else {
//            //0 正常流程 1.需要授权 2.不能执行当前流程 9.未知错误
//            String buss = reBuss.get(IConstant.STATE_CODE);
//            if (IConstant.STRING_1.equals(buss)) {
//                respons.setStateCode(IConstant.STRING_5);
//                respons.setStateMsg("需要授权");
//                return respons;
//            } else if (IConstant.STRING_2.equals(buss) || IConstant.BAND_TYPE_9.equals(buss)) {
//                respons.setStateCode(IConstant.STRING_1);
//                respons.setStateMsg(reBuss.get(IConstant.STATE_MSG));
//                return respons;
//            }
//        }
        
        // 新刀库存表
        Knifeinventory kfentity = new Knifeinventory();
        // RFID标签
        kfentity.setRfidContainerID(rfidcontainer.getRfidContainerID());
        // 删除区分
        kfentity.setDelFlag(IConstant.DEL_FLAG_0);
        // 取得刀具ID和库存数量
        Knifeinventory knifeinventory = iCOMPV01C01S003Service.searchToolIn(kfentity);
        if (knifeinventory.isRetErrFlag()) {
            respons.setStateCode(IConstant.USER_BLOOD_GROUP_2);
            respons.setStateMsg("未找到库存信息");
            return respons;
        } else {
            // 取得要换领出库的刀具信息
            Tool tool = new Tool();
            tool.setToolID(knifeinventory.getToolID());
            tool = iCOMPV01C01S003Service.getRedemptionapplyInfo(tool);
            if (tool.isRetErrFlag()) {
                respons.setStateCode(IConstant.USER_BLOOD_GROUP_2);
                respons.setStateMsg("未找到要换领出库的刀具信息");
                return respons;
            } else {
            	// 新刀库存表
            	Knifeinventory ki = new Knifeinventory();
            	ki.setToolID(knifeinventory.getToolID());
            	ki.setDelFlag(IConstant.STRING_0);
            	List<Knifeinventory> kiList = iCOMPV01C01S003Service.getKnifeinventoryInfo(ki);
            	if (kiList == null && kiList.isEmpty()) {
            		respons.setStateCode(IConstant.USER_BLOOD_GROUP_2);
                    respons.setStateMsg("库存中找不到相应的刀具信息");
                    return respons;
				}else {
					// 库存量
					int sum = 0;
					if (IConstant.STRING_0.equals(tool.getToolConsumetype())) {
						//钻头
						sum = kiList.size();
					}else {
						//刀片
						for (Knifeinventory ki2 : kiList) {
							sum = sum + Integer.parseInt(ki2.getKnifelnventoryNumber());
						}
					}
	                // 刀具ID
	                respons.setToolID(tool.getToolID());
	                //材料号
	                respons.setMaterialNum(tool.getToolCode());
	                //库存量
	                respons.setInventory(sum+"");
	                //刀具类型
	                respons.setToolType(tool.getToolConsumetype());
	                //库位码
	                respons.setLibraryCodeID(tool.getLibraryCodeID());
				}
            }
        }
        respons.setStateCode(IConstant.STOCK_STATE_0);
        respons.setStateMsg("取得成功");
        return respons;
    }

    /**
     * 提交换领出库的刀具信息
     *
     * @param request
     * @return
     * @throws
     * @throws Exception
     */
    @Override
    public C01S003Respons saveRedemptionapplyInfo(C01S003Request request)
            throws Exception {
        C01S003Respons respons = new C01S003Respons();
        Rfidcontainer entity = new Rfidcontainer();
        // 参数验证
        if (StringUtils.isEmpty(request.getCustomerID())
                || StringUtils.isEmpty(request.getGruantUserID())) {
            throw new BusinessException(IConstant.WMSG0221,
                    IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE);
        }
            // 取得前台扫描的列表
            Map<String, Object> map = new HashMap<String, Object>();

            List<Map<String, Object>> toolList = new ArrayList<Map<String, Object>>();

            if (request.getRedemptionApplyInputList() != null) {
                for (RedemptionApply ra : request.getRedemptionApplyInputList()) {
                    Map<String, Object> re = new HashMap<String, Object>();
                    // RFID标签
                    entity.setRfidCode(ra.getRfidCode());
                    // 删除区分
                    entity.setDelFlag(IConstant.DEL_FLAG_0);
                    String RfidContainerID = service.getRfidContainerIDByRfidCode(entity);
                    if (StringUtils.isEmpty(RfidContainerID)) {
                        throw new BusinessException("未找到相应的RFID载体");
                    }
                    // 条件
                    re.put("ToolID", ra.getToolID());// 刀具ID
                    re.put("RfidCode", ra.getRfidCode());// RFID标签
                    re.put("MaterialNum", ra.getMaterialNum());// 材料号
                    re.put("ToolConsumetype", ra.getToolConsumetype());//消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他
                    re.put("AppliedNumber", ra.getAppliedNumber());// 申请数量
                    re.put("ReceiveCount", ra.getReceiveCount());// 出库数量
                    re.put("CustomerID", request.getCustomerID());
                    re.put("SignID", request.getGruantUserID());
                    re.put("RfidContainerID", RfidContainerID);
                    re.put("HandSetID", request.getHandSetId());
                    toolList.add(re);
                }
            }
            
            //换领出库签收，不需要授权
//            if (request.getGruantUserID() != null) {
//                //授权记录插入
//                Authorization auth = new Authorization();
//                //授权人ID
//                auth.setAuthorizationUserID(request.getGruantUserID());
//                //授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它）
//                auth.setAuthorizedReason(IConstant.STRING_3);
//                //刀具类型（0单品，1合成刀具）
//                auth.setTooltype(IConstant.DEL_FLAG_0);
//                //材料号或合成刀具编码
//                auth.setToolCode(request.getToolCode());
//                //业务流程编码
//                auth.setBusinessCode("C01S003");
//                auth.setCreateUserID(request.getCustomerID());
//                //备注
//                auth.setNote("换领出库");
//                service.innsetGruant(auth);
//            }



            // 提交换领出库的刀具信息
            Map<String, Object> ret = iCOMPV01C01S003Service.saveRedemptionapplyInfo(toolList);
            if (Integer.parseInt(ret.get("status").toString()) > 0) {
                throw new BusinessException(ret.get("messagetext").toString(),
                        request.getLanguageCode(), request.getLanguageValue());
            }
            respons.setStateCode(ret.get("status").toString());
            respons.setStateMsg(ret.get("messagetext").toString());
            return respons;
        }
    }

