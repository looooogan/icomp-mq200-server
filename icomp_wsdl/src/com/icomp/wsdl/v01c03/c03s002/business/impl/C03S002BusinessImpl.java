package com.icomp.wsdl.v01c03.c03s002.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c03.s002.ICOMPV01C03S002Service;
import com.icomp.dao.OnoffDao;
import com.icomp.entity.base.Authorization;
import com.icomp.entity.base.Noticeequipment;
import com.icomp.entity.base.Onoff;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Synthesisparameters;
import com.icomp.entity.base.Vgetassequipmentlist;
import com.icomp.entity.base.Vtoollist;
import com.icomp.wsdl.v01c03.c03s002.business.C03S002Business;
import com.icomp.wsdl.v01c03.c03s002.endpoint.C03S002Request;
import com.icomp.wsdl.v01c03.c03s002.endpoint.C03S002Respons;
import com.icomp.wsdl.v01c03.c03s002.endpoint.EquipmentEntity;
import com.icomp.wsdl.v01c03.c03s002.endpoint.Equipments;
import com.icomp.wsdl.v01c03.c03s002.endpoint.InputTool;
import com.icomp.wsdl.v01c03.c03s002.endpoint.ToolParameters;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 合成刀具初始化
 */
public class C03S002BusinessImpl implements C03S002Business {

    @SuppressWarnings("unused")
    private CommonService service;
    private OnoffDao onoffDao;
	public void setOnoffDao(OnoffDao onoffDao) {
		this.onoffDao = onoffDao;
	}

    public void setService(CommonService service) {
        this.service = service;
    }

    private ICOMPV01C03S002Service iCOMPV01C03S002Service;

    public void setiCOMPV01C03S002Service(ICOMPV01C03S002Service iCOMPV01C03S002Service) {
        this.iCOMPV01C03S002Service = iCOMPV01C03S002Service;
    }

    Map<String, Object> parMap = new HashMap<String, Object>();

    /**
     * 验证RFID是否可用
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C03S002Respons checkRfid(C03S002Request request) throws Exception {
        C03S002Respons ret = new C03S002Respons();
        //判断扫描的刀具类型
        if (request.getRfidString() != null) {
            String toolType = service.getToolsTypeByRfid(request.getRfidString());
            if (!toolType.equals(IConstant.TOOL_KIND_0) && !toolType.equals(IConstant.TOOL_KIND_1)) { //未初始化
                throw new BusinessException(IConstant.WMSG0158, request.getLanguageCode(), request.getLanguageValue());
            }
        }
        Rfidcontainer entity = new Rfidcontainer();
        entity.setRfidCode(request.getRfidString());
        entity.setDelFlag(IConstant.DEL_FLAG_0);
        entity = iCOMPV01C03S002Service.checkRfid(entity);
        if (entity.isRetErrFlag() && entity.getToolShelfID() != null && entity.getToolShelfID().trim() != "") {
            List<ToolParameters> tpList = new ArrayList<ToolParameters>();
            ToolParameters toolParameters = new ToolParameters();
            //返回合成刀具编码
            toolParameters.setSynthesisParametersCode(entity.getToolShelfID());
            ret.setMessageText("CHECKRFID");
            ret.setMessageInfo(entity.getRfidCode());
            tpList.add(toolParameters);
            ret.setToolParametersList(tpList);
        } else {
            throw new BusinessException(entity.getMessageCode(), request.getLanguageCode(), request.getLanguageValue());
        }
        return ret;
    }

    /**
     * 取得合成刀具列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C03S002Respons getToolList(C03S002Request request) throws Exception {
        C03S002Respons respons = new C03S002Respons();
        Synthesisparameters entity = new Synthesisparameters();
        entity.setSynthesisParametersCode(request.getSynthesisParametersCode());
        entity.setDelFlag(IConstant.DEL_FLAG_0);
        List<Synthesisparameters> ret = iCOMPV01C03S002Service.getToolList(entity);
        if (ret.size() > 0 && ret.get(0).isRetErrFlag()) {
            throw new BusinessException(ret.get(0).getMessageCode(), request.getLanguageCode(), request.getLanguageValue());
        }
        List<String> list = new ArrayList<String>();
        for (Synthesisparameters synthesisparameters : ret) {
            if (!list.contains(synthesisparameters.getSynthesisParametersCode())) {
                list.add(synthesisparameters.getSynthesisParametersCode());
            }
        }
        respons.setSynthesisCodeList(list);
        return respons;
    }

    /**
     * 取得合成刀具配置信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C03S002Respons getToolInfo(C03S002Request request) throws Exception {
        C03S002Respons respons = new C03S002Respons();
        Vtoollist entity = new Vtoollist();
        if (request.getRfidString() != null) {
            String toolType = service.getToolsTypeByRfid(request.getRfidString());
            if (toolType.equals(IConstant.TOOL_KIND_0)) {
                throw new BusinessException(IConstant.WMSG0247, request.getLanguageCode(), request.getLanguageValue());
            }
            if (toolType.equals(IConstant.TOOL_KIND_2)) {
                throw new BusinessException(IConstant.WMSG0246, request.getLanguageCode(), request.getLanguageValue());
            }
            entity.setrFID(request.getRfidString());
        } else {
            entity.setrFID("-1");
            entity.setSynthesisParametersCode(request.getSynthesisParametersCode());
        }
        List<Vtoollist> ret = (List<Vtoollist>) iCOMPV01C03S002Service.getToolInfo(entity);
        if (ret.size() > 0 && ret.get(0).isRetErrFlag()) {
            throw new BusinessException(ret.get(0).getMessageCode(), request.getLanguageCode(), request.getLanguageValue());
        }
        List<ToolParameters> toolParametersList = new ArrayList<ToolParameters>();
        List<ToolParameters> retList = new ArrayList<ToolParameters>();
        for (Vtoollist vtoollist : ret) {
            ToolParameters toolParameters = new ToolParameters();
            toolParameters.setToolCode(vtoollist.getToolCode());
            toolParameters.setToolType(vtoollist.getCutterType());
            toolParameters.setSynthesisParametersCode(vtoollist.getSynthesisParametersCode());
            toolParametersList.add(toolParameters);
        }
        retList.add(toolParametersList.get(0));
        a:
        //数量
        for (ToolParameters toolParameters : toolParametersList) {
            if (toolParameters.getToolCount() == 0) {
                boolean addFlag = false;
                for (ToolParameters temp : retList) {
                    if (toolParameters.getToolCode().equals(temp.getToolCode())) {
                        temp.setToolCount(temp.getToolCount() + 1);
                        toolParameters.setToolCount(1);
                        addFlag = false;
                        continue a;
                    } else {
                        addFlag = true;
                    }
                }
                if (addFlag) {
                    toolParameters.setToolCount(1);
                    retList.add(toolParameters);
                }
            }
        }
        respons.setToolParametersList(retList);
        return respons;
    }

    /**
     * 保存初始化合成刀具信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C03S002Respons saveToolList(C03S002Request request) throws Exception {
        C03S002Respons respons = new C03S002Respons();

        List<InputTool> inputToolList = request.getInputToolList();
        List<String> rfidList = new ArrayList<String>(),
                inputTypeList = new ArrayList<String>(),
                toolCodeList = new ArrayList<String>();
        for (InputTool inputTool : inputToolList) {
            rfidList.add(inputTool.getRfidString());
            inputTypeList.add(inputTool.getInputType());
            toolCodeList.add(inputTool.getSynthesisParametersCode());
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rfidList", rfidList);
        map.put("toolCodeList", toolCodeList);
        map.put("inputTypeList", inputTypeList);
        map.put("customerID", request.getCustomerID());
        map.put("langCode", request.getLanguageCode());
        map.put("langCode", request.getLanguageCode());
        map.put("langValue", request.getLanguageValue());
        map.put("handsetid", request.getHandSetId());
        Map<String, Object> ret = iCOMPV01C03S002Service.saveToolList(map);
        if (Integer.parseInt(ret.get("status").toString()) < 0) {
            throw new BusinessException(ret.get("messagetext").toString(), request.getLanguageCode(), request.getLanguageValue());
        }
        respons.setStatus(Integer.parseInt(ret.get("status").toString()));
        respons.setMessageText(ret.get("messagetext").toString(), request.getLanguageCode(), request.getLanguageValue());
        return respons;
    }

    /**
     * 查询所有流水线和设备
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C03S002Respons findAllEquipment(C03S002Request request) throws Exception {
        C03S002Respons respons = new C03S002Respons();
        //流水线及设备列表
        List<EquipmentEntity> entity = new ArrayList<EquipmentEntity>();
        EquipmentEntity reEntiti = null;
        List<Vgetassequipmentlist> reList = iCOMPV01C03S002Service.getEquipmentList();
        for (Vgetassequipmentlist v : reList) {
            reEntiti = new EquipmentEntity();
            //流水线编码
            reEntiti.setAssemblyLineCode(v.getAssemblyLineCode());
            //流水线ID
            reEntiti.setAssemblyLineID(v.getAssemblyLineID());
            //流水线
            reEntiti.setAssemblyLineName(v.getAssemblyLineName());
            //设备编码
            reEntiti.setEquipmentCode(v.getEquipmentCode());
            //设备ID
            reEntiti.setEquipmentID(v.getEquipmentID());
            //设备名称
            reEntiti.setEquipmentName(v.getEquipmentName());
            entity.add(reEntiti);
        }
        if (entity == null || entity.size() < 1) {
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg("未找到流水线及设备列表信息");
            return respons;
        }
        respons.setEquipmentList(entity);
        respons.setStateCode(IConstant.STOCK_STATE_0);
        respons.setStateMsg("查询成功");
        return respons;
    }

    /**
     * 设备标签绑定
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C03S002Respons submitEquipmentRifdCode(C03S002Request request) throws Exception {
        C03S002Respons respons = new C03S002Respons();
        parMap = new HashMap<String, Object>();
        // 参数验证
        if (checkParam(request, 1)) {
            throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
        }
        try {
            // 查询刀具载体
            Rfidcontainer rfe = new Rfidcontainer();
            rfe.setRfidCode(request.getRfidCode());
            rfe.setDelFlag(IConstant.DEL_FLAG_0);
            Rfidcontainer rfidConner = service.getRfidContainerByRfidCode(rfe);
            if (null != rfidConner) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("当前标签已初始化，请扫描空标签");
                return respons;
            }
            //用户ID
            parMap.put("userID", request.getCustomerID());
            parMap.put("configUserID", request.getGruantUserID());
            //RFID
            parMap.put("rfidCode", request.getRfidCode());
            //设备类型
            parMap.put("equipmentType", request.getEquipmentType());
            //设备ID
            parMap.put("equipmentID", request.getEquipmentID());

            //提交容器初始化信息
            int reVal = iCOMPV01C03S002Service.submitEquipmentRifdCode(parMap);
            if (reVal > 0) {
                if (request.getGruantUserID() != null) {
                    //授权记录插入
                    Authorization auth = new Authorization();
                    //授权人ID
                    auth.setAuthorizationUserID(request.getGruantUserID());
                    //授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它）
                    auth.setAuthorizedReason(IConstant.STRING_7);
                    //刀具类型（0单品，1合成刀具，2其它）
                    auth.setTooltype(IConstant.STRING_2);
                    //业务流程编码
                    auth.setBusinessCode(IConstant.C03S001);
                    auth.setCreateUserID(request.getCustomerID());
                    //备注
                    //2017/08/14 王冉 变更↓↓↓　dazhong@YMSC
                    auth.setNote("设备重复初始化");
                    //2017/08/14 王冉 变更↑↑↑　dazhong@YMSC
                    service.innsetGruant(auth);
                }
                respons.setStateCode(IConstant.DEL_FLAG_0);
                respons.setStateMsg("提交初始化容器信息成功");
            } else {
                if (-1 == reVal) {

                    List<Onoff> onOff =  iCOMPV01C03S002Service.search("C03S002_006Activity");
                    // 0为打开，1为关闭
                    if (IConstant.BAND_TYPE_1.equals(onOff.get(0).getOnOffState().toString())) {
//            		reVal.put(IConstant.STATE_CODE, IConstant.BAND_TYPE_0);
                        respons.setStateCode(IConstant.BAND_TYPE_0);
                        respons.setStateMsg("消息取得成功");
                    } else {
                        respons.setStateCode(IConstant.STRING_2);
                        respons.setStateMsg("当前设备已初始化，重新初始化需要授权");
                    }

                } else if (-2 == reVal) {
                    respons.setStateCode(IConstant.STRING_1);
                    respons.setStateMsg("未找到该设备信息");
                } else {
                    respons.setStateCode(IConstant.DEL_FLAG_1);
                    respons.setStateMsg("提交设备初始化信息失败");
                }
            }
        } catch (Exception e) {
            throw new BusinessException(IConstant.EWMSG0275, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
        }

        return respons;
    }

    /**
     * 容器标签绑定
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C03S002Respons submitContainer(C03S002Request request) {
        C03S002Respons respons = new C03S002Respons();
        // 参数验证
        if (checkParam(request, 2)) {
            throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
        }
        try {
            parMap = new HashMap<String, Object>();
            // 查询载体
            Rfidcontainer rfe = new Rfidcontainer();
            rfe.setRfidCode(request.getRfidCode());
            rfe.setDelFlag(IConstant.DEL_FLAG_0);
            String rfidConner = service.getRfidContainerIDByRfidCode(rfe);
            if (null != rfidConner) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("当前标签已初始化，请扫描空标签");
                return respons;
            }
            //用户ID
            parMap.put("userID", request.getCustomerID());
            //RFID
            parMap.put("rfidCode", request.getRfidCode());
            //标签类型
            parMap.put("carrierType", request.getContainerCarrierType());

            //提交容器初始化信息
            int reVal = iCOMPV01C03S002Service.submitContainer(parMap);
            if (reVal > 0) {
                respons.setStateCode(IConstant.DEL_FLAG_0);
                respons.setStateMsg("提交初始化容器信息成功");

            } else if (reVal == -1) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("该容器只能初始化一个");
            }

        } catch (Exception e) {
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg("提交初始化容器信息失败");
        }

        return respons;
    }

    /**
     * 查询所有刃磨设备
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C03S002Respons findGrindEquipment(C03S002Request request) throws Exception {
        C03S002Respons respons = new C03S002Respons();
        List<Noticeequipment> reList = iCOMPV01C03S002Service.getNoticeList();
        if (null == reList || reList.size() < 1) {
            respons.setStateCode(IConstant.DEL_FLAG_0);
            respons.setNocequipmentList(new ArrayList<Equipments>());
            return respons;
        } else {
            List<Equipments> noc = new ArrayList<Equipments>();
            Equipments re = null;
            for (Noticeequipment ree : reList) {
                re = new Equipments();
                //设备ID
                re.setEquipmentID(ree.getNoticeEquipmentID());
                //设备名称
                re.setEquipmentName(ree.getEquipmentName());
                //设备编码
                re.setEquipmentCode(ree.getEquipmentCode());
                noc.add(re);
            }
            try {
                respons.setNocequipmentList(noc);
            } catch (Exception e) {
                e.printStackTrace();
            }
            respons.setStateCode(IConstant.STOCK_STATE_0);
            respons.setStateMsg("取得成功");
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
    private boolean checkParam(C03S002Request request, int i) {
        // RfidCode标签
        if (StringUtils.isEmpty(request.getRfidCode())) {
            return true;
        }
        if (i == 1) {
            // 用户ID
            if (StringUtils.isEmpty(request.getCustomerID())) {
                return true;
            }
            // 设备id
            if (StringUtils.isEmpty(request.getEquipmentID())) {
                return true;
            }
            // 绑定类型（0加工，1修磨）
            if (StringUtils.isEmpty(request.getEquipmentType())) {
                return true;
            }
            // rfidCode
            if (StringUtils.isEmpty(request.getRfidCode())) {
                return true;
            }
        }
        if (i == 2) {
            // 容器类别（0一次性报废 2待分拣容器 3厂内待刃磨 4厂外待刃磨 5刃磨完毕 6刃磨报废 7待涂层 8库房报废 9其他）
            if (StringUtils.isEmpty(request.getContainerCarrierType())) {
                return true;
            }
        }

        return false;
    }


}
