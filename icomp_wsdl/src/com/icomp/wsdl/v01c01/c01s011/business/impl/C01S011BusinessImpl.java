package com.icomp.wsdl.v01c01.c01s011.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c01.s011.ICOMPV01C01S011Service;
import com.icomp.entity.base.Authorization;
import com.icomp.entity.base.Equipment;
import com.icomp.entity.base.Oplink;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Synthesisknife;
import com.icomp.entity.base.Synthesistoolsmachining;
import com.icomp.entity.base.Vgetequipmentlist;
import com.icomp.entity.base.Vgetequipmentnamebyrfid;
import com.icomp.wsdl.v01c01.c01s011.business.C01S011Business;
import com.icomp.wsdl.v01c01.c01s011.endpoint.C01S011Request;
import com.icomp.wsdl.v01c01.c01s011.endpoint.C01S011Respons;
import com.icomp.wsdl.v01c01.c01s011.endpoint.EquipmentEntity;
import com.icomp.wsdl.v01c01.c01s011.endpoint.Equipments;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设备安上-Business实现类
 *
 * @author Taoyy
 * @ClassName: C01S011BusinessImpl
 * @date 2014-9-23 下午02:50:30
 */
public class C01S011BusinessImpl implements C01S011Business {

    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    /**
     * 设备安上-Service接口
     */
    private ICOMPV01C01S011Service iCOMPV01C01S011Service;

    public void setiCOMPV01C01S011Service(ICOMPV01C01S011Service iCOMPV01C01S011Service) {
        this.iCOMPV01C01S011Service = iCOMPV01C01S011Service;
    }

    /**
     * 取得合成刀信息和设备列表 getSyntheticInfoEquipmentList
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S011Respons getSyntheticInfoEquipmentList(C01S011Request request) throws Exception {
        C01S011Respons respons = new C01S011Respons();// 返回数据
        Rfidcontainer entity = new Rfidcontainer();
        try {
            // 参数验证
            if (StringUtils.isEmpty(request.getRfidCode()) || StringUtils.isEmpty(request.getQueryType())) {
                throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
            }
            // RFID标签
            entity.setRfidCode(request.getRfidCode());
            // 删除区分
            entity.setDelFlag(IConstant.DEL_FLAG_0);

            // rfid没有初始化
            String RfidContainerID = service.getRfidContainerIDByRfidCode(entity);
            if (StringUtils.isEmpty(RfidContainerID)) {
                respons.setStateCode(IConstant.STRING_1);
                respons.setStateMsg("当前标签未初始化");
                return respons;
            }
            // 不是合成刀具
            Rfidcontainer rc = service.getRfidContainerByRfidCode(entity);
            if (!IConstant.STRING_2.equals(rc.getQueryType())) {
                respons.setStateCode(IConstant.STSATIC_ONE);
                respons.setStateMsg("请扫描合成刀具");
                return respons;
            }
            Map<String, String> param = new HashMap<String, String>();
            param.put("businessCode", IConstant.C01S011);
            param.put("rfidCode", request.getRfidCode());
            param.put("gruantUserID", request.getGruantUserID());
            Map<String, String> reBuss = service.processControlBussinesCode(param);
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
                //  授权记录插入
                Authorization auth = new Authorization();
                //授权人ID
                auth.setAuthorizationUserID(request.getGruantUserID());
                //授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它）
                auth.setAuthorizedReason(IConstant.STRING_4);
                //刀具类型（0单品，1合成刀具）
                auth.setTooltype(IConstant.DEL_FLAG_1);
                //材料号或合成刀具编码
                if (reBuss.get("toolCode") != null) {
                    auth.setToolCode(reBuss.get("toolCode"));
                }

                //业务流程编码
                auth.setBusinessCode(IConstant.C01S011);
                auth.setCreateUserID(request.getCustomerID());
                //备注
                auth.setNote("卸下后安上");
                service.innsetGruant(auth);
            }
            Synthesisknife skEntity = new Synthesisknife();
            // 载体id
            skEntity.setrFID(RfidContainerID);
            // 删除区分
            skEntity.setDelFlag(IConstant.DEL_FLAG_0);

            // 根据载体id查询合成刀具编码
            Synthesisknife reValue = iCOMPV01C01S011Service.getSynthesisknifebyRfidc(skEntity);
            if (null == reValue) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("未找到合成刀具编码");
                return respons;
            }
            //2017/08/14 王冉 变更↓↓↓　dazhong@YMSC
            else if ("0".equals(reValue.getLoadState())) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("该合成刀具已安上，不可重复安上设备");
                return respons;
            }else if ("6".equals(reValue.getLoadState())) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("该合成刀具已拆分，需组装后方可安装");
                return respons;
            }else if ("7".equals(reValue.getLoadState())) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("该合成刀具已出厂修磨，需回厂后方可安装");
                return respons;
            }else if ("10".equals(reValue.getLoadState())) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("该合成刀具只能进行厂外修磨");
                return respons;
            }
            //2017/08/14 王冉 变更↑↑↑　dazhong@YMSC
            // 合成刀具编码
            respons.setSynthesisParametersCode(reValue.getSynthesisParametersCode());
            // 设备列表
            List<EquipmentEntity> equipments = new ArrayList<EquipmentEntity>();
            EquipmentEntity reEntity = null;
            Vgetequipmentlist vg = new Vgetequipmentlist();
            // 合成刀具编码
            vg.setSynthesisParametersCode(reValue.getSynthesisParametersCode());
            // 返回设备列表
            // 取得所有设备列表
            List<Vgetequipmentlist> reList = iCOMPV01C01S011Service.getEquipmentList(vg);
            for (Vgetequipmentlist v : reList) {
                reEntity = new EquipmentEntity();
                // 设备ID
                reEntity.setEquipmentId(v.getEquipmentID());
                // 设备名称
                reEntity.setEquipmentName(v.getEquipmentName());
                // 轴ID
                reEntity.setAxleID(v.getAxleID());
                // 轴编码
                reEntity.setAxleCode(v.getAxleCode());
                // RFID
                reEntity.setRfidCode(v.getRfidCode());
                equipments.add(reEntity);
            }
            respons.setEquipments(equipments);

            respons.setStateCode(IConstant.STOCK_STATE_0);
        } catch (Exception e) {
            respons.setStateCode(IConstant.STOCK_STATE_2);
            respons.setStateMsg("获取失败");
        }
        return respons;
    }

    /**
     * 提交合成刀具安上设备信息
     *
     * @param request
     * @return
     * @throws Exception
     */

    @Override
    public C01S011Respons submitSyntheticInstallEquipmentInfo(C01S011Request request) throws Exception {
        C01S011Respons respons = new C01S011Respons();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        // 参数验证
        if (checkParam(request, 1)) {
            throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
        }
        String handSetId = request.getHandSetId();

        //查询合成刀具载体
        Rfidcontainer rf = new Rfidcontainer();
        rf.setRfidCode(request.getSynthesisParametersRfid());
        //标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
        rf.setQueryType(IConstant.BAND_TYPE_2);
        rf.setDelFlag(IConstant.DEL_FLAG_0);
        String rfidConner = service.getRfidContainerIDByRfidCode(rf);
        if (null == rfidConner) {
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg("未找到当前标签对应的合成刀具信息");
            return respons;
        }


        Synthesisknife sk = new Synthesisknife();
        //合成刀具编码(系统唯一)
        sk.setSynthesisParametersCode(request.getSynthesisParametersCode());
        //RFID载体
        sk.setrFID(rfidConner);
        //删除区分(0有效1删除)
        sk.setDelFlag(IConstant.DEL_FLAG_0);
        //查询合成刀具编码和编号
        Synthesisknife reVal = iCOMPV01C01S011Service.getSynParameNumber(sk);
        if (reVal.isRetErrFlag()) {
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg("未找到当前标签对应的合成刀具编号信息");
            return respons;
        }
        String synthesisparametersID = service.getSynthesisToolCode(request.getSynthesisParametersCode());

        if (synthesisparametersID == null) {
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg("未找到当前合成刀具的id");
            return respons;
        }
        String userId = request.getCustomerID();
        // 从生产关联表中查询数据
        Oplink entity = new Oplink();
        // 设备ID
        entity.setEquipmentID(request.getEquipmentID());
        // 轴号ID
        entity.setAxleID(request.getEquipmentAxisNumberID());
        //合成刀具ID
        entity.setSynthesisParametersID(synthesisparametersID);
        Oplink reValue = iCOMPV01C01S011Service.getOplinkInfo(entity);
        if (reValue.isRetErrFlag()) {
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg("生产关联表中未找到相应数据");
            return respons;
        }

        Synthesistoolsmachining stm = new Synthesistoolsmachining();
        // 加工编号(年月日时分秒 14位字符串)
        stm.setSynthesisNumber(sf.format(new Date()));
        // 合成刀具参数编码
        stm.setSynthesisParametersCode(request.getSynthesisParametersCode());
        //合成刀具参数编号
        stm.setSynthesisParametersNumber(reVal.getSynthesisParametersNumber());
        // 工序ID
        stm.setProcessID(reValue.getProcessID());
        stm.setEquipmentID(reValue.getEquipmentID());// 设备ID
        stm.setAssemblyLineID(reValue.getAssemblyLineID());// 流水线ID
        stm.setAxleID(reValue.getAxleID());// 轴号
        stm.setPartsID(reValue.getPartsID());// 零部件ID
        //		stm.setOuterTime(null);// 卸下时间
        //		stm.setOuterUser(null);// 卸下人
        stm.setProcessAmount(BigDecimal.ZERO);// 加工数量
        stm.setDelFlag(IConstant.DEL_FLAG_0);
        stm.setCreateTime(new Date());
        stm.setCreateUser(userId);
        stm.setUpdateTime(new Date());// 更新时间
        stm.setUpdateUser(userId);// 更新者
        stm.setVersion(BigDecimal.ZERO);// 版本号
        stm.setRfidContainerID(rfidConner);
        //RFIDCode传入server
        stm.setExpandSpace1(request.getSynthesisParametersRfid());
        stm.setExpandSpace4(handSetId);
        // 提交合成刀具加工信息
        int reValCount = iCOMPV01C01S011Service.submitSyntheticInstallEquipmentInfo(stm);
        if (reValCount < 1) {
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg("提交合成刀具安上设备信息失败");
            return respons;
        }
        respons.setStateCode(IConstant.DEL_FLAG_0);
        respons.setStateMsg("提交合成刀具安上设备信息成功");
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
    private Boolean checkParam(C01S011Request request, int state) {
        if (state == 1) {
            // 用户ID
            if (StringUtils.isEmpty(request.getCustomerID())) {
                return true;
            }
            // 合成刀具编码
            if (StringUtils.isEmpty(request.getSynthesisParametersCode())) {
                return true;
            }
            // 装入设备的设备ID
            if (StringUtils.isEmpty(request.getEquipmentID())) {
                return true;
            }
            // 装入设备的轴号ID
            if (StringUtils.isEmpty(request.getEquipmentAxisNumberID())) {
                return true;
            }
            // 合成刀具RFID
            if (StringUtils.isEmpty(request.getSynthesisParametersRfid())) {
                return true;
            }
        }

        return false;
    }

    /***************************************************************************************************/
    /**
     * getEquipmentToolInfo
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S011Respons getEquipmentToolInfo(C01S011Request request) throws Exception {
        C01S011Respons respons = new C01S011Respons();// 杩斿洖鏁版嵁
        Vgetequipmentnamebyrfid entity = new Vgetequipmentnamebyrfid();
        List<Equipments> reList = new ArrayList<Equipments>();
        if (chickParams(request, 0)) {
            throw new BusinessException(IConstant.CEMSG0005, request.getLanguageCode(), request.getLanguageValue());
        }

        if (request.getRfidString() != null) {
            String toolType = service.getToolsTypeByRfid(request.getRfidString());
            if (toolType.equals(IConstant.TOOL_KIND_0)) {
                throw new BusinessException(IConstant.WMSG0247, request.getLanguageCode(), request.getLanguageValue());
            }
            if (!toolType.equals(IConstant.TOOL_KIND_1)) {
                throw new BusinessException(IConstant.WMSG0246, request.getLanguageCode(), request.getLanguageValue());
            }
        }
        Map<String, Object> ret = service.checkToolStauts(request.getRfidString(), "C01S011", request.getLanguageCode());
        if (ret.size() > 0 && !(Boolean.valueOf(ret.get("agreeFlag").toString()).booleanValue())) {
            if (ret.get("messageCode") == null) {
                throw new BusinessException((String) ret.get("messageCode"), request.getLanguageCode(), request.getLanguageValue());
            } else {
                throw new BusinessException((String) ret.get("messageCode"), request.getLanguageCode(), request.getLanguageValue(), (String) ret.get("newFlowText"), (String) ret.get("lastFlowText"), (String) ret.get("messageText"));
            }
        }
        entity.setRfid(request.getRfidString());
        List<Vgetequipmentnamebyrfid> list = iCOMPV01C01S011Service.getEquipmentToolInfo(entity);
        if (list.get(0).isRetErrFlag()) {
            throw new BusinessException(list.get(0).getMessageCode(), request.getLanguageCode(), request.getLanguageValue());
        } else {
            Equipments info = null;
            for (Vgetequipmentnamebyrfid vs : list) {
                info = new Equipments();
                info.setEquipmentId(vs.getEquipmentID());
                info.setEquipmentCode(vs.getEquipmentCode());
                info.setEquipmentName(vs.getEquipmentName());
                reList.add(info);
            }
            respons.setXpoint(list.get(0).getXpoint().doubleValue());
            respons.setYpoint(list.get(0).getYpoint().doubleValue());
            respons.setSynthesisParametersCode(list.get(0).getSynthesisParametersCode());
            respons.setSynthesisParametersNumber(list.get(0).getSynthesisParametersNumber());
            respons.setEquipmentList(reList);
            respons.setStatus(IConstant.RESULT_CODE_0);
            respons.setMessageText(IConstant.CIMSG0046, request.getLanguageCode(), request.getLanguageValue());
        }
        return respons;
    }

    /**
     * 取得设备信息
     *
     * @param request
     * @return
     * @throws Exception C01S011Respons
     * @title getEquipmentToolInfo
     */
    public C01S011Respons getEquipmentInfo(C01S011Request request) throws Exception {
        C01S011Respons respons = new C01S011Respons();// 返回数据
        // 判断扫描的刀具类型
        if (request.getRfidString() != null && !"".equals(request.getRfidString().trim())) {
            String toolType = service.getToolsTypeByRfid(request.getRfidString());
            if (toolType.equals(IConstant.TOOL_KIND_0)) { // 未初始化
                throw new BusinessException(IConstant.WMSG0247, request.getLanguageCode(), request.getLanguageValue());
            }
            if (!toolType.equals(IConstant.LOADSTATE_5)) {
                throw new BusinessException(IConstant.WMSG0248, request.getLanguageCode(), request.getLanguageValue());
            }
        }
        // 取得合成刀具安装设备信息
        Map<String, Object> ret = iCOMPV01C01S011Service.getEquipmentInfo(request.getRfidString(), request.getSynthesisParametersCode());
        if (ret.size() > 0 && ret.get("error") != null) {
            throw new BusinessException(ret.get("MessageCode").toString(), request.getLanguageCode(), request.getLanguageValue());
        }
        respons.setEquipmentId(((Equipment) ret.get("rows")).getEquipmentID());
        respons.setEquipmentName(((Equipment) ret.get("rows")).getEquipmentName());
        return respons;
    }

    /**
     * 合成刀具安上设备 saveToolInEquipment
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S011Respons saveToolInEquipment(C01S011Request request) throws Exception {
        C01S011Respons respons = new C01S011Respons();
        Synthesisknife entity = new Synthesisknife();
        // 参数验证
        if (chickParams(request, 1)) {
            throw new BusinessException(IConstant.CEMSG0005, request.getLanguageCode(), request.getLanguageValue());
        }
        // 赋值
        entity.setSynthesisParametersCode(request.getSynthesisParametersCode());
        entity.setSynthesisParametersNumber(request.getSynthesisParametersNumber());
        entity.setEquipmentID(request.getEquipmentID());
        entity.setUpdateUser(request.getCustomerID());
        entity.setDelFlag(request.getGruantUserID());

        // 安上设备保存
        if (iCOMPV01C01S011Service.saveToolInEquipment(entity, request.getRfidString(), request.getHandSetId()) > 0) {
            respons.setStatus(IConstant.RESULT_CODE_0);
            respons.setMessageText(IConstant.CIMSG0096, request.getLanguageCode(), request.getLanguageValue());

        } else {
            throw new BusinessException(IConstant.CEMSG0026, request.getLanguageCode(), request.getLanguageValue());
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
    private boolean chickParams(C01S011Request request, int state) {
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
        if (state == 0) {
            if (request.getRfidString() == null || request.getRfidString() == "") {
                retParams = true;// RFID
            }
        }
        if (state == 1) {
            if (request.getRfidString() == null || request.getRfidString() == "") {
                retParams = true;// 合成刀具编码
            }
            if (request.getEquipmentID() == null || request.getEquipmentID() == "") {
                retParams = true;// 设备ID
            }
            if (request.getHandSetId() == null || request.getHandSetId() == "") {
                retParams = true;// 手持机ID
            }
            if (request.getGruantUserID() == null || request.getGruantUserID() == "") {
                retParams = true;// 流水线
            }
        }
        return retParams;
    }

}
