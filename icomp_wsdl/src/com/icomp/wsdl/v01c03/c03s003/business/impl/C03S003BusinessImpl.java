package com.icomp.wsdl.v01c03.c03s003.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c03.s003.ICOMPV01C03S003Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Equipment;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Vgetcustomerinfo;
import com.icomp.wsdl.v01c03.c03s003.business.C03S003Business;
import com.icomp.wsdl.v01c03.c03s003.endpoint.C03S003Request;
import com.icomp.wsdl.v01c03.c03s003.endpoint.C03S003Respons;
import com.icomp.wsdl.v01c03.c03s003.endpoint.EquipmentInfo;
import com.icomp.wsdl.v01c03.c03s003.endpoint.EquipmentType;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C03S003BusinessImpl implements C03S003Business {

    @SuppressWarnings("unused")
    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    private ICOMPV01C03S003Service iCOMPV01C03S003Service;

    public void setiCOMPV01C03S003Service(ICOMPV01C03S003Service iCOMPV01C03S003Service) {
        this.iCOMPV01C03S003Service = iCOMPV01C03S003Service;
    }

    Map<String, Object> parMap = new HashMap<String, Object>();

    /**
     *
     */
    @SuppressWarnings("unchecked")
    public C03S003Respons getEquipment(C03S003Request request) throws Exception {
        C03S003Respons respons = new C03S003Respons();

        Map<String, Object> ret = iCOMPV01C03S003Service.getEquipment(request.getValue(), request.getLanguageCode());
        if (ret.size() > 0 && ret.get("error") != null) {
            throw new BusinessException(ret.get("MessageCode").toString(), request.getLanguageCode(), request.getLanguageValue());
        }
        List<Comlist> comlists = (List<Comlist>) ret.get("EquipmentTypes");
        List<EquipmentType> equipmentTypeList = new ArrayList<EquipmentType>();
        List<EquipmentInfo> equipmentInfoList = new ArrayList<EquipmentInfo>();
        for (Comlist comlist : comlists) {
            if (!comlist.getComListValue().equals(IConstant.STRING_3)) {
                EquipmentType equipmentType = new EquipmentType();
                equipmentType.setName(comlist.getComListText());
                equipmentType.setValue(comlist.getComListValue());
                equipmentTypeList.add(equipmentType);
            }
        }
        List<Equipment> equipmentList = (List<Equipment>) ret.get("EquipmentList");
        for (Equipment equipment : equipmentList) {
            if (equipment.getRfidContainerID() == null) {
                EquipmentInfo equipmentInfo = new EquipmentInfo();
                equipmentInfo.setEquipmentID(equipment.getEquipmentID());
                equipmentInfo.setEquipmentName(equipment.getEquipmentName());
                equipmentInfoList.add(equipmentInfo);
            }
        }
        respons.setEquipmentTypeList(equipmentTypeList);
        respons.setEquipmentInfoList(equipmentInfoList);
        respons.setStatus(Integer.parseInt(ret.get("status").toString()));
        return respons;
    }

    /**
     *
     */
    public C03S003Respons saveEquipmentRfid(C03S003Request request) throws Exception {
        //对扫描的rfid进行验证
        if (request.getRfidString() != null) {
            String toolType = service.getToolsTypeByRfid(request.getRfidString());
            if (!toolType.equals(IConstant.TOOL_KIND_0)) {
                throw new BusinessException(IConstant.WMSGC01S022_1, request.getLanguageCode(), request.getLanguageValue());
            }
        }
        C03S003Respons respons = new C03S003Respons();
        Equipment equipment = new Equipment();
        equipment.setEquipmentID(request.getEquipmentID());
        equipment.setRfidContainerID(request.getRfidString());
        equipment.setUpdateUser(request.getCustomerID());
        Map<String, Object> ret = iCOMPV01C03S003Service.saveEquipmentRfid(equipment);
        if (ret.size() > 0 && ret.get("error") != null) {
            throw new BusinessException(ret.get("MessageCode").toString(), request.getLanguageCode(), request.getLanguageValue());
        }
        respons.setMessageText(MessageReSource.getMessageBox(ret.get("MessageCode").toString(), request.getLanguageCode(), request.getLanguageValue()));
        respons.setStatus(Integer.parseInt(ret.get("status").toString()));
        return respons;
    }
    /**************************************************************************************************************************************/
    /**
     * 查询员工信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C03S003Respons findMemberMsgByCard(C03S003Request request) throws Exception {
        C03S003Respons respons = new C03S003Respons();
        // 参数验证
        if (StringUtils.isEmpty(request.getEmployeeCard())) {
            throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
        }
        Vgetcustomerinfo v = new Vgetcustomerinfo();
        v.setEmployeeCard(request.getEmployeeCard());
        Vgetcustomerinfo reList = iCOMPV01C03S003Service.findMemberMsgByCard(v);
        if (reList.getRetErrFlag()) {
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg("未找到员工号绑定信息");
            return respons;
        }
        //真实姓名
        respons.setUserName(reList.getUserName());
        //用户ID
        respons.setBlindCustomerID(reList.getCustomerID());
        //部门
        respons.setDepartmentName(reList.getDepartmentName());
        //员工卡号
        respons.setEmployeeCard(reList.getEmployeeCard());

        respons.setStateCode(IConstant.STOCK_STATE_0);
        respons.setStateMsg("查询成功");
        return respons;
    }

    /**
     * 提交员工初始化信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C03S003Respons submitEmployeeCardMsg(C03S003Request request) throws Exception {
        C03S003Respons respons = new C03S003Respons();

        // 参数验证
        if (checkParam(request, 1)) {
            throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
        }
        // 查询载体
        Rfidcontainer rfe = new Rfidcontainer();
        rfe.setRfidCode(request.getRfidCode());
        rfe.setDelFlag(IConstant.DEL_FLAG_0);
        Rfidcontainer rfidConner = service.getRfidContainerByRfidCode(rfe);
        if (null != rfidConner && rfidConner.getQueryType() != null) {
            if (!IConstant.STRING_3.equals(rfidConner.getQueryType()))
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg("请扫描空标签");
            respons.setEmployeeCard(request.getEmployeeCard());
            return respons;
        }
        //判断当卡号是否已绑定
        Customer customer = new Customer();
        customer.setEmployeeCard(request.getEmployeeCard());
        customer.setCustomerID(request.getBlindCustomerID());
        //卡号（RFID截体）
        String userCard = service.getisHasInit(customer);
        if (userCard != null && request.getGruantUserID() ==null) {
            respons.setStateCode(IConstant.STRING_5);
            respons.setStateMsg("当前员工卡已绑定");
            return respons;
        }

        parMap = new HashMap<String, Object>();
        try {
            //RFidCode
            parMap.put("rfidCode", request.getRfidCode());
            //用户iD
            parMap.put("userID", request.getCustomerID());
            //用户卡号
            parMap.put("userCard", request.getEmployeeCard());
            //要绑定的用户ID
            parMap.put("blindCustomerID", request.getBlindCustomerID());
            //旧RFID载体
            parMap.put("oldRfidConnerID", userCard);

            //提交员工初始化信息
            int reValCount = iCOMPV01C03S003Service.submitEmployeeCardMsg(parMap);
            if (reValCount < 1) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("提交员工初始化信息失败");
                return respons;
            }
            respons.setStateCode(IConstant.DEL_FLAG_0);
            respons.setStateMsg("提交员工初始化信息成功");
        } catch (Exception e) {
            System.out.println("C03S003BusinessImpl--submitEmployeeCardMsg" + e.toString());
            throw new BusinessException(IConstant.EWMSG0276, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
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
    private boolean checkParam(C03S003Request request, int state) {
        // RFID
        if (StringUtils.isEmpty(request.getRfidCode())) {
            return true;
        }
        // 绑定用户ID
        if (StringUtils.isEmpty(request.getBlindCustomerID())) {
            return true;
        }
        // 用户ID
        if (StringUtils.isEmpty(request.getCustomerID())) {
            return true;
        }

        return false;
    }


}
