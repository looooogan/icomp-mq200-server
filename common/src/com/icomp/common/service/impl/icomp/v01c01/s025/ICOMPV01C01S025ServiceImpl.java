package com.icomp.common.service.impl.icomp.v01c01.s025;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s025.ICOMPV01C01S025Service;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.BusinessDao;
import com.icomp.dao.BusinessflowlnkDao;
import com.icomp.dao.EquipmentDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.SynthesisexperienceDao;
import com.icomp.dao.SynthesisknifeDao;
import com.icomp.dao.ToolDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.TooltransferhistoryDao;
import com.icomp.dao.ToolwholelifecycleDao;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Businessflowlnk;
import com.icomp.entity.base.Equipment;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Synthesisexperience;
import com.icomp.entity.base.Synthesisknife;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Tooltransferhistory;
import com.icomp.entity.base.Toolwholelifecycle;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class ICOMPV01C01S025ServiceImpl extends BaseService implements ICOMPV01C01S025Service {

    private RfidcontainerDao rfidcontainerDao;

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    private TooltransferDao tooltransferDao;

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    private BusinessflowlnkDao businessflowlnkDao;

    public void setBusinessflowlnkDao(BusinessflowlnkDao businessflowlnkDao) {
        this.businessflowlnkDao = businessflowlnkDao;
    }

    private TooltransferhistoryDao tooltransferhistoryDao;

    public void setTooltransferhistoryDao(TooltransferhistoryDao tooltransferhistoryDao) {
        this.tooltransferhistoryDao = tooltransferhistoryDao;
    }

    private SynthesisknifeDao synthesisknifeDao;

    public void setSynthesisknifeDao(SynthesisknifeDao synthesisknifeDao) {
        this.synthesisknifeDao = synthesisknifeDao;
    }

    private ToolwholelifecycleDao toolwholelifecycleDao;

    public void setToolwholelifecycleDao(ToolwholelifecycleDao toolwholelifecycleDao) {
        this.toolwholelifecycleDao = toolwholelifecycleDao;
    }

    /* 刀具Dao */
    private ToolDao toolDao;

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    private SynthesisexperienceDao synthesisexperienceDao;

    public void setSynthesisexperienceDao(SynthesisexperienceDao synthesisexperienceDao) {
        this.synthesisexperienceDao = synthesisexperienceDao;
    }

    private BusinessDao businessDao;

    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    private EquipmentDao equipmentDao;

    public void setEquipmentDao(EquipmentDao equipmentDao) {
        this.equipmentDao = equipmentDao;
    }

    /**
     * 保存对刀开始数据
     *
     * @param rfidString
     * @param langCode
     * @param langValue
     * @param customerID
     */
    public Map<String, Object> saveToolInfo(String equipmentID, String rfidString, String langCode, String langValue, String customerID, String handsetid) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            Equipment eq = new Equipment();
            eq.setEquipmentID(equipmentID);
            eq.setEquipmentType(IConstant.EQUIPMENT_TYPE_1);
            eq.setDelFlag(IConstant.DEL_FLAG_0);
            eq = (Equipment) equipmentDao.searchByPrimaryKey(eq);
            //  当前是否使用(0是,1否)
            if (IConstant.STSATIC_ZERO.equals(eq.getStatues())) {
               result.put("status", IConstant.RESULT_CODE_1);
                result.put("messagetext", IConstant.WMSG0143_1);
                return result;
            }

            Date date = new Date();
            Rfidcontainer rfidcontainer = new Rfidcontainer();
            rfidcontainer.setRfidCode(rfidString);
            rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
            List<Rfidcontainer> rfidList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
            if (rfidList == null || rfidList.size() == 0) {
                // 当前扫描的RFID未绑定刀具!
                result.put("status", IConstant.RESULT_CODE_1);
                result.put("messagetext", IConstant.WMSG0143);
                return result;
            }
            rfidcontainer = rfidList.get(0);

            // 取得流转刀具信息
            Tooltransfer tooltransfer = new Tooltransfer();
            tooltransfer.setRfidContainerID(rfidcontainer.getRfidContainerID());// 取得载体ID
            tooltransfer.setDelFlag(IConstant.DEL_FLAG_0);
            List<Tooltransfer> tooltransferList = (List<Tooltransfer>) tooltransferDao.searchByList(tooltransfer);

            // 取得当前刀具的最后执行业务流程
            Business business = new Business();
            business.setBusinessCode("C01S025");
            List<Business> businessList = (List<Business>) businessDao.searchByList(business);
            business = businessList.get(0);
            Businessflowlnk businessflowlnks = new Businessflowlnk();
            businessflowlnks.setBusinessID(business.getBusinessID());
            List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);
            String businessFlowLnkID = list1.get(0).getBusinessFlowLnkID();

            // 更新流转刀具信息
            for (Tooltransfer tooltransfer2 : tooltransferList) {
                // 记录刀具生命周期数据
                Toolwholelifecycle toolwholelifecycle = new Toolwholelifecycle();
                toolwholelifecycle.setBusinessFlowLnkID(businessFlowLnkID);
                toolwholelifecycle.setHandSetID(handsetid);
                // 取得刀具信息
                Tool tool = new Tool();
                tool.setToolID(tooltransfer2.getToolID());
                List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
                if (toolList == null || toolList.size() <= 0) {
                    // 当前刀具编码未记录!
                    result.put("status", IConstant.RESULT_CODE_1);
                    result.put("messagetext", IConstant.WMSG0116);
                    return result;
                } else {
                    tool = toolList.get(0);
                }
                toolwholelifecycle.setToolCode(tool.getToolCode());
                toolwholelifecycle.setToolName(tool.getToolName());
                toolwholelifecycle.setKnifeInventoryCode(tooltransfer2.getKnifeInventoryCode());
                toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
                toolwholelifecycle.setCreateTime(date);
                toolwholelifecycle.setUpdateTime(date);
                toolwholelifecycle.setCreateUser(customerID);
                toolwholelifecycle.setUpdateUser(customerID);
                toolwholelifecycle.setVersion(BigDecimal.ZERO);
                String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue(IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, customerID);
                toolwholelifecycle.setToolWholeLifecycleID(toolWholeLifecycleID);
                toolwholelifecycleDao.insert(toolwholelifecycle);
                // 更新刀具流转履历
                Tooltransferhistory tooltransferhistory = new Tooltransferhistory();
                tooltransferhistory.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(IConstant.TOOLTRANSFERHISTORY, IConstant.TOOLTRANSFERHISTORYID, customerID));
                tooltransferhistory.setToolID(tooltransfer2.getToolID());
                tooltransferhistory.setRfidContainerID(tooltransfer2.getRfidContainerID());
                tooltransferhistory.setKnifeInventoryCode(tooltransfer2.getKnifeInventoryCode());
                tooltransferhistory.setToolProcuredID(tooltransfer2.getProcuredBatch());
                tooltransferhistory.setBusinessFlowLnkID(tooltransfer2.getBusinessFlowLnkID());
                tooltransferhistory.setToolDurable(tooltransfer2.getToolDurable());
                tooltransferhistory.setToolSharpennum(tooltransfer2.getToolSharpennum());
                tooltransferhistory.setToolSharpenCriterion(tooltransfer2.getToolSharpenCriterion());
                tooltransferhistory.setToolLength(tooltransfer2.getToolLength());
                tooltransferhistory.setToolSharpenLength(tooltransfer2.getToolSharpenLength());
                tooltransferhistory.setUsageCounter(tooltransfer2.getUsageCounter());
                tooltransferhistory.setToolGrindingLength(tooltransfer2.getToolGrindingLength());
                tooltransferhistory.setInstallationState(tooltransfer2.getInstallationState());
                tooltransferhistory.setToolState(tooltransfer2.getToolState());
                tooltransferhistory.setReplacementFlag(tooltransfer2.getReplacementFlag());
                tooltransferhistory.setoutUser(tooltransfer2.getUpdateUser());
                // 需要写入转出者(转出者为上一条数据的接收者)
                tooltransferhistory.setinUser(customerID);
                tooltransferhistory.setConfirmedUser(tooltransfer2.getConfirmedUser());
                tooltransferhistory.setStockState(IConstant.STOCK_STATE_4);
                tooltransferhistory.setDelFlag(IConstant.DEL_FLAG_0);
                tooltransferhistory.setUpdateTime(date);
                tooltransferhistory.setUpdateUser(customerID);
                tooltransferhistory.setCreateTime(date);
                tooltransferhistory.setCreateUser(customerID);
                tooltransferhistory.setVersion(BigDecimal.ZERO);
                tooltransferhistoryDao.insert(tooltransferhistory);

                Tooltransfer param = new Tooltransfer();
                // 更新刀具流转信息
                param.setBusinessFlowLnkID(businessFlowLnkID);
                param.setUpdateTime(date);
                param.setUpdateUser(customerID);
                param.setVersion(tooltransfer2.getVersion().add(BigDecimal.ONE));
                param.setStockState(IConstant.STOCK_STATE_4);
                param.setRfidContainerIDWhere(tooltransfer2.getRfidContainerID());
                param.setKnifeInventoryCodeWhere(tooltransfer2.getKnifeInventoryCode());
                param.setDelFlagWhere(IConstant.DEL_FLAG_0);
                tooltransferDao.updateNonQuery(param);

            }
            // 取得合成刀信息
            Synthesisknife synthesisknife = new Synthesisknife();
            synthesisknife.setrFID(rfidcontainer.getRfidContainerID());
            synthesisknife.setDelFlag(IConstant.DEL_FLAG_0);
            List<Synthesisknife> listSynthesisknife = (List<Synthesisknife>) synthesisknifeDao.searchByList(synthesisknife);
            synthesisknife = new Synthesisknife();
            synthesisknife.setSynthesisParametersCode(listSynthesisknife.get(0).getSynthesisParametersCode());
            synthesisknife.setSynthesisParametersNumber(listSynthesisknife.get(0).getSynthesisParametersNumber());
            listSynthesisknife = (List<Synthesisknife>) synthesisknifeDao.searchByList(synthesisknife);
            for (Synthesisknife synthesisknife2 : listSynthesisknife) {
                // 更新合成刀具流转履历
                Synthesisexperience synthesisexperience = new Synthesisexperience();
                synthesisexperience.setSynthesisParametersCode(synthesisknife2.getSynthesisParametersCode());
                synthesisexperience.setSynthesisCutterNumber(synthesisknife2.getSynthesisCutterNumber());
                synthesisexperience.setBusinessFlowLnkID(businessFlowLnkID);
                synthesisexperience.setSynthesisParametersNumber(synthesisknife2.getSynthesisParametersNumber());
                synthesisexperience.setOperationTime(date);
                synthesisexperience.setArrivalUser(synthesisknife2.getUpdateUser());
                // 需要写入转出者(转出者为上一条数据的接收者)
                synthesisexperience.setRecipientUser(customerID);
                synthesisexperience.setTransitionBecause(IConstant.TRANSITION_BECAUSE_3);
                synthesisexperience.setDelFlag(IConstant.DEL_FLAG_0);
                synthesisexperience.setCreateTime(date);
                synthesisexperience.setUpdateTime(date);
                synthesisexperience.setCreateUser(customerID);
                synthesisexperience.setUpdateUser(customerID);
                synthesisexperience.setVersion(BigDecimal.ZERO);
                synthesisexperienceDao.insert(synthesisexperience);
                // 更新合成刀具流转信息
                Synthesisknife param = new Synthesisknife();
                param.setBusinessFlowLnkID(businessFlowLnkID);
                param.setUpdateTime(date);
                param.setUpdateUser(customerID);
                param.setVersion(synthesisknife2.getVersion().add(BigDecimal.ONE));
                param.setSynthesisParametersCodeWhere(synthesisknife2.getSynthesisParametersCode());
                param.setEquipmentID(equipmentID);
                param.setSynthesisCutterNumberWhere(synthesisknife2.getSynthesisCutterNumber());
                param.setSynthesisParametersNumberWhere(synthesisknife2.getSynthesisParametersNumber());
                param.setDelFlagWhere(IConstant.DEL_FLAG_0);
                synthesisknifeDao.updateNonQuery(param);
            }
            Equipment entity = new Equipment();
            entity.setEquipmentIDWhere(eq.getEquipmentID());
            entity.setDelFlagWhere(IConstant.DEL_FLAG_0);
            entity.setEquipmentTypeWhere(IConstant.EQUIPMENT_TYPE_1);
            entity.setStatues(IConstant.STSATIC_ZERO); //使用中
            entity.setUpdateTime(new Date());
            entity.setUpdateUser(customerID);
            entity.setVersion(eq.getVersion().add(BigDecimal.ONE));
            int reSCU = equipmentDao.updateNonQuery(entity);

            result.put("status", IConstant.RESULT_CODE_0);
            result.put("SynthesisParametersCode", listSynthesisknife.get(0).getSynthesisParametersCode());
            result.put("equipmentName", eq.getEquipmentName());
            result.put("messagetext", IConstant.IMSG0011);
            return result;
        } catch (SQLException e) {
            result.put("status", IConstant.RESULT_CODE_2);
            result.put("messagetext", IConstant.EMSG0004);
            return result;
        }
    }

    /**
     * 取得对刀设备列表
     *
     * @param rfidString
     */
    public Map<String, Object> getEquipment(String rfidString) {
        Map<String, Object> ret = new HashMap<String, Object>();
        try {
            if (rfidString == null) {//取得列表
                Equipment equipment = new Equipment();
                equipment.setEquipmentType(IConstant.EQUIPMENT_TYPES_1);
                equipment.setDelFlag(IConstant.DEL_FLAG_0);
                List<Equipment> list = (List<Equipment>) equipmentDao.searchByList(equipment);
                List<Equipment> retList = new ArrayList<Equipment>();
                if (list == null || list.size() == 0) {
                    // 对刀设备列表为空!
                    ret.put("error", true);
                    ret.put("messagetext", IConstant.WMSG0251);
                    return ret;
                }
                ret.put("rows", list);
            } else {//取得单条
                Rfidcontainer rfidcontainer = new Rfidcontainer();
                rfidcontainer.setRfidCode(rfidString);
                rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
                List<Rfidcontainer> rfidList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
                if (rfidList == null || rfidList.size() == 0) {
                    // 当前扫描的RFID未绑定刀具!
                    ret.put("error", true);
                    ret.put("messagetext", IConstant.WMSG0143);
                    return ret;
                }
                rfidcontainer = rfidList.get(0);
                Equipment equipment = new Equipment();
                equipment.setEquipmentType(IConstant.EQUIPMENT_TYPES_1);
                equipment.setRfidContainerID(rfidcontainer.getRfidContainerID());
                equipment.setDelFlag(IConstant.DEL_FLAG_0);
                List<Equipment> list = (List<Equipment>) equipmentDao.searchByList(equipment);
                if (list == null || list.size() == 0 || list.get(0).getRfidContainerID() == null) {
                    // 设备列表取得失败!
                    ret.put("error", true);
                    ret.put("messagetext", IConstant.WMSG0249);
                    return ret;
                }
                equipment = list.get(0);
                ret.put("data", equipment);
            }
            return ret;
        } catch (SQLException e) {
            ret.put("error", true);
            ret.put("messagetext", IConstant.EMSG0004);
            return ret;
        }
    }
}
