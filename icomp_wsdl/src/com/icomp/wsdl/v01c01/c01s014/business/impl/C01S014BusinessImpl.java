package com.icomp.wsdl.v01c01.c01s014.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c01.s001.ICOMPV01C01S001Service;
import com.icomp.common.service.icomp.v01c01.s014.ICOMPV01C01S014Service;
import com.icomp.entity.base.Authorization;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Toolrepairnotice;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Vgetrepairnoticetoolmsg;
import com.icomp.wsdl.v01c01.c01s014.business.C01S014Business;
import com.icomp.wsdl.v01c01.c01s014.endpoint.C01S014Request;
import com.icomp.wsdl.v01c01.c01s014.endpoint.C01S014Respons;
import com.icomp.wsdl.v01c01.c01s014.endpoint.InputTool;
import com.icomp.wsdl.v01c01.c01s014.endpoint.ReplaceGringding;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 刀具分拣-Business实现类
 *
 * @author Taoyy
 * @ClassName: C01S014BusinessImpl
 * @date 2016-2-29 下午03:07:50
 */
public class C01S014BusinessImpl implements C01S014Business {

    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    private ICOMPV01C01S001Service iCOMPV01C01S001Service;

    public void setiCOMPV01C01S001Service(ICOMPV01C01S001Service iCOMPV01C01S001Service) {
        this.iCOMPV01C01S001Service = iCOMPV01C01S001Service;
    }

    /**
     * 刀具分拣-Service接口
     */
    private ICOMPV01C01S014Service iCOMPV01C01S014Service;

    public void setiCOMPV01C01S014Service(ICOMPV01C01S014Service iCOMPV01C01S014Service) {
        this.iCOMPV01C01S014Service = iCOMPV01C01S014Service;
    }

    /**
     * 取得分拣刀具的信息 getToolsSorting
     *
     * @param request
     * @return
     * @throws Exception
     */
    /**
     *
     */
    @Override
    public C01S014Respons getToolsSorting(C01S014Request request) throws Exception {
        C01S014Respons respons = new C01S014Respons();// 返回参数
        Rfidcontainer entity = new Rfidcontainer();
        // 参数验证
        if (StringUtils.isEmpty(request.getRfidCode()) || StringUtils.isEmpty(request.getCustomerID())) {
            throw new BusinessException(IConstant.WMSG0221, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE);
        }
        // RFID标签
        entity.setRfidCode(request.getRfidCode());
        // 删除区分
        entity.setDelFlag(IConstant.DEL_FLAG_0);
        // 验证RFID标签是否存在
        Rfidcontainer rfentity = iCOMPV01C01S001Service.getRfidExist(entity);
        if (rfentity.isRetErrFlag()) {
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg("当前标签未初始化");
            return respons;
        } else if (!IConstant.STRING_1.equals(rfentity.getQueryType()) && !IConstant.STRING_5.equals(rfentity.getQueryType())) {
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg("请扫描待分拣的可刃磨容器或待刃磨的单品刀具");
            return respons;
        } else {
        	//验证容器类型，看其是否是待分拣容器
			if ("5".equals(rfentity.getQueryType())) {
				String containerType = iCOMPV01C01S014Service
						.getContainerType(rfentity.getRfidContainerID());
				if ("-1".equals(containerType)) {
					respons.setStateCode(IConstant.DEL_FLAG_1);
					respons.setStateMsg("容器不存在或没有容器类型");
					return respons;
				} else if (!"2".equals(containerType)) {
					respons.setStateCode(IConstant.DEL_FLAG_1);
					respons.setStateMsg("该容器不是待分拣容器");
					return respons;
				}
			}
            Map<String, String> param1 = new HashMap<String, String>();
            param1.put("businessCode", IConstant.C01S014);
            param1.put("rfidCode", request.getRfidCode());
            param1.put("gruantUserID", request.getGruantUserID());
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
            
            if (request.getGruantUserID() != null) {
                //授权记录插入
                Authorization auth = new Authorization();
                //授权人ID
                auth.setAuthorizationUserID(request.getGruantUserID());
                //授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它）
                auth.setAuthorizedReason(IConstant.STRING_12);
                //刀具类型（0单品，1合成刀具）
                auth.setTooltype(IConstant.DEL_FLAG_0);
                //材料号或合成刀具编码
                if (reBuss.get("toolCode") != null) {
                    auth.setToolCode(reBuss.get("toolCode"));
                }
                //业务流程编码
                auth.setBusinessCode(IConstant.C01S014);
                auth.setCreateUserID(request.getCustomerID());
                //备注
                auth.setNote("重复分拣");
                service.innsetGruant(auth);
            }

            // 刀具流转表
            Tooltransfer tfentity = new Tooltransfer();
            // RFID载体ID
            tfentity.setRfidContainerID(rfentity.getRfidContainerID());
            // 删除区分
            tfentity.setDelFlag(IConstant.DEL_FLAG_0);
            // 取得刀具ID
            String ToolID = iCOMPV01C01S014Service.getToolID(tfentity);
            if (StringUtils.isEmpty(ToolID)) {
                respons.setStateCode(IConstant.STRING_1);
                respons.setStateMsg("未找到相应的刀具ID");
                return respons;
            } else {
                // 单品
                if ((IConstant.DEL_FLAG_1).equals(rfentity.getQueryType())) {
                    // 刀具参数表
                    Tool toentity = new Tool();
                    // 刀具ID
                    toentity.setToolID(ToolID);
                    // 删除区分
                    toentity.setDelFlag(IConstant.DEL_FLAG_0);
                    // 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他
                    toentity.setToolConsumetype(IConstant.DEL_FLAG_0);
                    // 取得刀具参数信息
                    Tool tool = iCOMPV01C01S014Service.getToolInfo(toentity);
                    if (tool.isRetErrFlag()) {
                        respons.setStateCode(IConstant.BAND_TYPE_2);
                        respons.setStateMsg("未找到刀具参数信息");
                        return respons;
                    }
                    // rfid类型（0单品，1容器）
                    respons.setQueryType(IConstant.STRING_0);
                    // 刀具id(单品)
                    respons.setToolID(ToolID);
                    // 材料号(单品)
                    respons.setMaterialNum(tool.getToolCode());
                    // 修磨方式(单品)(0:厂内，1厂外）
                    respons.setGrindingMode(tool.getToolGrinding());
                }
                // 容器列表
                else if ((IConstant.KNIFE_INVENTORY_TYPE_5).equals(rfentity.getQueryType())) {
                    //查询容器中的刀具ID
                    Tooltransfer tr = new Tooltransfer();
                    tr.setRfidContainerID(rfentity.getRfidContainerID());
                    tr.setDelFlag(IConstant.DEL_FLAG_0);
                    List<Tooltransfer> trlist = iCOMPV01C01S014Service.getToolidBrfidconer(tr);
                    if (null == trlist || trlist.size() < 0) {
                        respons.setStateCode(IConstant.BAND_TYPE_2);
                        respons.setStateMsg("未找到刀具流转信息");
                        return respons;
                    }
                    String counts = String.valueOf(trlist.get(0).getToolDurable());
                    List<ReplaceGringding> peList = new ArrayList<ReplaceGringding>();
                    for (int i = 0; i < trlist.size(); i++) {
                        String ToolID1 = trlist.get(i).getToolID();

                        // 刀具参数表
                        Tool toentity = new Tool();
                        // 刀具ID
                        toentity.setToolID(ToolID1);
                        // 删除区分
                        toentity.setDelFlag(IConstant.DEL_FLAG_0);
                        // 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他
                        toentity.setToolConsumetype(IConstant.DEL_FLAG_1);
                        List<Tool> reList = iCOMPV01C01S014Service.getToolList(toentity);
                        if (reList == null || reList.size() < 1) {
                            respons.setStateCode(IConstant.BAND_TYPE_2);
                            respons.setStateMsg("请扫描待分拣的可刃磨容器或待刃磨的单品刀具");
                            return respons;
                        } else {
                            ReplaceGringding re = new ReplaceGringding();
                            for (Tool to : reList) {
                                // 刀具id(容器)
                                re.setRtoolID(to.getToolID());
                                // 材料号(容器)
                                re.setRmaterialNum(to.getToolCode());
                                // 修磨方式(容器)(0:厂内，1厂外）
                                re.setRgrindingMode(to.getToolGrinding());
                                // 数量(容器)
                                re.setRcount(counts);
                                peList.add(re);
                            }
                            respons.setGringdingList(peList);
                        }
                    }
                    // rfid类型（0单品，1容器）
                    respons.setQueryType(IConstant.DEL_FLAG_1);
                }
            }
        }
        respons.setStateCode(IConstant.STOCK_STATE_0);
        respons.setStateMsg("查询成功");
        return respons;
    }

    /**
     * 提交分拣刀具的信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S014Respons saveToolsSortingInfo(C01S014Request request) throws Exception {
        C01S014Respons respons = new C01S014Respons();
        // 参数验证
        if (StringUtils.isEmpty(request.getCustomerID())) {
            throw new BusinessException(IConstant.WMSG0221, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE);
        }
        // 传入的分拣刀具信息
        List<InputTool> inputToolList = request.getInputToolList();
        if (inputToolList.size() > 0) {
            for (InputTool inputTool : inputToolList) {
                Rfidcontainer entity = new Rfidcontainer();
                // RFID标签
                entity.setRfidCode(inputTool.getRfidCode());
                // 删除区分
                entity.setDelFlag(IConstant.DEL_FLAG_0);
                // 根据rfid判断是单品还是容器
                Rfidcontainer rfentity = iCOMPV01C01S014Service.getQueryType(entity);
                // 单品刀
                if ((IConstant.KNIFE_INVENTORY_TYPE_1).equals(rfentity.getQueryType())) {
                    Tooltransfer toentity = new Tooltransfer();
                    // RFID标签
                    toentity.setRfidContainerID(rfentity.getRfidContainerID());
                    // 刀具ID
                    toentity.setToolID(inputTool.getToolID());
                    // 删除区分
                    toentity.setDelFlag(IConstant.DEL_FLAG_0);
                    // 取得流转表刀具信息
                    Tooltransfer tfentity = iCOMPV01C01S014Service.getToolSortInfo(toentity);
                    if (tfentity.isRetErrFlag()) {
                        throw new BusinessException(rfentity.getMessageCode(), IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE);
                    } else {
                        Map<String, Object> map = new HashMap<String, Object>();
                        //修磨方式(0:厂内，1厂外）
                        map.put("grindingMode", inputTool.getGrindingMode());
                        //刀具ID
                        map.put("toolID", inputTool.getToolID());
                        //用户ID
                        map.put("customerID", request.getCustomerID());
                        //手持机id
                        map.put("handSetId", request.getHandSetId());
                        //刃磨容器的载体ID
                        String rfidContainerId = service.getrfidContainerIdByRfid(inputTool.getRfidCode());
                        if (IConstant.STRING_0.equals(rfidContainerId)) {
                            throw new BusinessException("未找到相应的rfid载体");
                        } else {
                            map.put("rfidContainerId", rfidContainerId);
                        }
                        // 更新刀具流转表
                        iCOMPV01C01S014Service.updateSyrfid(map);
                    }
                    // 容器
                } else if ((IConstant.KNIFE_INVENTORY_TYPE_5).equals(rfentity.getQueryType())) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    //用户ID
                    map.put("customerID", request.getCustomerID());
                    //载体ID
                    map.put("rfidConnerID", rfentity.getRfidContainerID());
                    //刀具ID
                    map.put("toolID", inputTool.getToolID());
                    //确认数量
                    map.put("toolDurable", inputTool.getConfirmCount());
                    //扫描数量
                    map.put("toolDurab", inputTool.getScanCount());
                    //0厂内,1厂外
                    map.put("grindingMode", inputTool.getGrindingMode());
                    //对数据修改
                    iCOMPV01C01S014Service.updateToolMsg(map);
                }
            }
        }

        // 刀具分拣签收，不需要授权
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
//            auth.setBusinessCode(IConstant.C01S014);
//            auth.setCreateUserID(request.getCustomerID());
//            //备注
//            auth.setNote("刀具分拣");
//            service.innsetGruant(auth);
//        }

        respons.setStateCode(IConstant.STOCK_STATE_0);
        respons.setStateMsg("成功修改");
        return respons;
    }

    /**
     * 修复通知单号生成 createRepairNoticeNumber
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S014Respons createRepairNoticeNumber(C01S014Request request) throws Exception {
        C01S014Respons respons = new C01S014Respons();// 返回参数
        // 修复通知单号生成
        String repairNoticeNumber = iCOMPV01C01S014Service.createRepairNoticeNumber(request.getCustomerID());
        if (repairNoticeNumber.length() < 1) {
            // 获取失败
            throw new BusinessException(IConstant.CEMSG0030, request.getLanguageCode(), request.getLanguageValue());
        } else {
            // 获取成功
            respons.setStatus(IConstant.RESULT_CODE_0);
            respons.setMessageText(IConstant.CIMSG0052, request.getLanguageCode(), request.getLanguageValue());
        }
        respons.setRepairNoticeNumber(repairNoticeNumber);
        return respons;
    }

    /**
     * 取得扫描刀具信息 getToolInfo
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S014Respons getToolInfo(C01S014Request request) throws Exception {
        C01S014Respons respons = new C01S014Respons();// 返回参数
        Vgetrepairnoticetoolmsg entity = new Vgetrepairnoticetoolmsg();// VIEW实体类

        // 参数验证
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
        if (request.getRfidString() == null || request.getRfidString() == "") {
            retParams = true;// 扫描的rfid标签
        }
        if (retParams) {
            throw new BusinessException(IConstant.CEMSG0005, request.getLanguageCode(), request.getLanguageValue());
        }

        // 判断扫描的刀具类型
        if (request.getRfidString() != null && !"".equals(request.getRfidString().trim())) {
            String toolType = service.getToolsTypeByRfid(request.getRfidString());
            if (toolType.equals(IConstant.TOOL_KIND_0)) { // 未初始化
                throw new BusinessException(IConstant.WMSG0247, request.getLanguageCode(), request.getLanguageValue());
            }
            if (!toolType.equals(IConstant.TOOL_KIND_2)) {
                throw new BusinessException(IConstant.WMSG0245, request.getLanguageCode(), request.getLanguageValue());
            }
        }

        // 赋值
        entity.setRfidCode(request.getRfidString());// 扫描的rfid标签

        // 取得并判断刀具当前扫描刀具是否可以进行【旧刀回收】业务
        Map<String, Object> ret = service.checkToolStauts(request.getRfidString(), "C01S014", request.getLanguageCode());
        if (ret.size() > 0 && !(Boolean.valueOf(ret.get("agreeFlag").toString()).booleanValue())) {
            if (ret.get("messageText") == null) {
                throw new BusinessException((String) ret.get("messageCode"), request.getLanguageCode(), request.getLanguageValue());
            } else {
                throw new BusinessException((String) ret.get("messageCode"), request.getLanguageCode(), request.getLanguageValue(), (String) ret.get("newFlowText"), (String) ret.get("lastFlowText"), (String) ret.get("messageText"));
            }
        }
        // 取得刀具修复通知单信息
        Vgetrepairnoticetoolmsg reEntity = iCOMPV01C01S014Service.getToolInfo(entity);
        // 处理区分(true:成功 false:失败)
        if (reEntity.isRetErrFlag()) {
            throw new BusinessException(reEntity.getMessageCode(), request.getLanguageCode(), request.getLanguageValue());
        } else {
            // 扫描刀具信息获取成功!
            respons.setStatus(IConstant.RESULT_CODE_0);
            respons.setMessageText(IConstant.CIMSG0053, request.getLanguageCode(), request.getLanguageValue());
            respons.setVgetrepairnoticetoolmsg(reEntity);
        }
        return respons;
    }

    /**
     * 修复通知单发布 saveToolRepairNotice
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S014Respons saveToolRepairNotice(C01S014Request request) throws Exception {
        C01S014Respons respons = new C01S014Respons();// 返回参数
        List<Toolrepairnotice> list = new ArrayList<Toolrepairnotice>();// 刀具修复通知实体类list

        boolean retParams = false;
        // 扫描的rfid标签
        if (request.getCustomerID() == null || request.getCustomerID() == "") {
            retParams = true;
        }
        if (request.getLanguageCode() == null || request.getLanguageCode() == "") {
            retParams = true;
        }
        if (request.getLanguageValue() == null || request.getLanguageValue() == "") {
            retParams = true;
        }
        if (request.getTrnList() == null) {
            retParams = true;
        }
        if (retParams) {
            // 参数异常
            throw new BusinessException(IConstant.CEMSG0005, request.getLanguageCode(), request.getLanguageValue());
        }
        // 赋值
        Toolrepairnotice tn = null;
        for (Toolrepairnotice re : request.getTrnList()) {
            tn = new Toolrepairnotice();

            tn.setToolRepairNoticeID(re.getToolRepairNoticeID());// 修复通知流水号
            tn.setRfidCode(re.getRfidCode());// RFID标签ID
            tn.setNoticeTime(new Date());// 通知时间
            tn.setSentBackNumber(re.getSentBackNumber());// 应送回数量
            tn.setRealSentBackNumber(re.getRealSentBackNumber());// 实际送回数量
            tn.setRepairWay(re.getRepairWay());// 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)
            tn.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分(0有效1删除)
            tn.setUpdateTime(new Date());// 更新时间
            tn.setUpdateUser(request.getCustomerID());// 更新者
            tn.setCreateTime(new Date());// 创建时间
            tn.setCreateUser(request.getCustomerID());// 创建者
            tn.setVersion(BigDecimal.ZERO);// 版本号
            list.add(tn); // 增加
        }
        try {
            // 修复通知单发布
            iCOMPV01C01S014Service.saveToolRepairNotice(list, request.getCustomerID(), request.getHandSetId());
            respons.setStatus(IConstant.RESULT_CODE_0);
            respons.setMessageText(IConstant.CIMSG0054, request.getLanguageCode(), request.getLanguageValue());
        } catch (Exception e) {
            throw new BusinessException(IConstant.CEMSG0032, request.getLanguageCode(), request.getLanguageValue());
        }
        return respons;
    }

    /**
     * 取得修磨处理(非单品)
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S014Respons getRegrindingList(C01S014Request request) throws Exception {
        C01S014Respons respons = new C01S014Respons();
        Map<String, Object> rtn = new HashMap<String, Object>();
        // 取得并判断刀具当前扫描刀具是否可以进行当前业务
        Map<String, Object> ret = service.checkToolStauts(request.getRfidString(), IConstant.C01S014, request.getLanguageCode());
        if (ret.size() > 0 && !(Boolean.valueOf(ret.get("agreeFlag").toString()).booleanValue())) {
            if (ret.get("messageText") == null) {
                throw new BusinessException((String) ret.get("messageCode"), request.getLanguageCode(), request.getLanguageValue());
            } else {
                throw new BusinessException((String) ret.get("messageCode"), request.getLanguageCode(), request.getLanguageValue(), (String) ret.get("newFlowText"), (String) ret.get("lastFlowText"), (String) ret.get("messageText"));
            }
        }
        String rfidString = request.getRfidString();
        String customerID = request.getCustomerID();
        String handSetId = request.getHandSetId();
        rtn.put("handSetId", handSetId);
        rtn.put("customerID", customerID);
        rtn.put("rfidString", rfidString);
        rtn.put("request", request);

        try {
            // 取得修磨处理
            rtn = iCOMPV01C01S014Service.getRegrindingList(rtn);
            respons.setStatus(IConstant.RESULT_CODE_0);
            respons.setMessageText("取得成功");
            List<ReplaceGringding> repList = new ArrayList<ReplaceGringding>();
            List<Tooltransfer> tList = (List<Tooltransfer>) rtn.get("data");
            if (tList.size() < 1) {
                throw new RuntimeException();
            }
            for (Tooltransfer tooltransfer : tList) {
                ReplaceGringding rep = new ReplaceGringding();
                rep.setToolCode(tooltransfer.getExpandSpace2());
                rep.setGringdingCount(Integer.parseInt(tooltransfer.getExpandSpace1()));
                rep.setHandleType(IConstant.STRING_0);
                repList.add(rep);
            }
            respons.setGringdingList(repList);
            respons.setMessageText(IConstant.WMSG0226, request.getLanguageCode(), request.getLanguageValue());
        } catch (Exception e) {
            respons.setStatus(IConstant.RESULT_CODE_1);
            throw new BusinessException(IConstant.WMSG0225, request.getLanguageCode(), request.getLanguageValue());
        }

        return respons;
    }

    /**
     * 保存修磨处理(非单品)
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S014Respons saveRegrinding(C01S014Request request) throws Exception {
        C01S014Respons respons = new C01S014Respons();

        Map<String, Object> rtn = new HashMap<String, Object>();
        rtn.put("request", request);
        rtn.put("userId", request.getCustomerID());
        rtn.put("handId", request.getHandSetId());
        rtn.put("rfidCode", request.getRfidString());
        for (ReplaceGringding element : request.getGringdingList()) {
            rtn.put("toolCode", element.getToolCode());
            rtn.put("gringdingCount", element.getGringdingCount());
            rtn.put("toolState", element.getHandleType());
            iCOMPV01C01S014Service.saveRegrinding(rtn);
        }
        respons.setStatus(0);
        respons.setMessageText("修磨处理保存成功");
        return respons;
    }

    /**
     * 刃磨方式取得 getRepairWayList
     *
     * @param regSwitch
     * @return
     * @throws Exception
     */
    public C01S014Respons getRepairWayList(C01S014Request regSwitch) throws Exception {
        Comlist entity = new Comlist();
        entity.setComListType(IConstant.REPAIR_WAY);
        entity.setLanguageCode(regSwitch.getLanguageCode());
        entity.setDelFlag(IConstant.DEL_FLAG_0);
        List<Comlist> list = service.getComList(entity);
        if (list.size() == 1 && list.get(0).isRetErrFlag()) {
            throw new BusinessException(list.get(0).getMessageCode(), regSwitch.getLanguageCode(), regSwitch.getLanguageValue());
        }
        C01S014Respons respons = new C01S014Respons();// 返回参数
        respons.setRepairWayList(list);
        return respons;
    }

}
