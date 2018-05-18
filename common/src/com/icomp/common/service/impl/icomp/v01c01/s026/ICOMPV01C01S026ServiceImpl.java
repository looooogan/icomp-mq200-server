package com.icomp.common.service.impl.icomp.v01c01.s026;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s026.ICOMPV01C01S026Service;
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
import com.icomp.dao.VsynthesisDao;
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
import com.icomp.entity.base.Vsynthesis;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ICOMPV01C01S026ServiceImpl extends BaseService implements ICOMPV01C01S026Service {

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

    private VsynthesisDao vsynthesisDao;

    public void setVsynthesisDao(VsynthesisDao vsynthesisDao) {
        this.vsynthesisDao = vsynthesisDao;
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
     * 取得合成刀具信息
     *
     * @param entity
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Vsynthesis> getToolInfo(Vsynthesis entity) {
        try {
            // 取得合成刀信息
            List<Vsynthesis> listSynthesisknife = (List<Vsynthesis>) vsynthesisDao.searchByList(entity);
            if (listSynthesisknife == null || listSynthesisknife.size() <= 0) {
                // 合成刀具未找到相应数据!
                listSynthesisknife = new ArrayList<Vsynthesis>();
                Vsynthesis vsynthesis = new Vsynthesis();
                vsynthesis.setMessageCode(IConstant.WMSG0151);
                vsynthesis.setRetErrFlag(true);
                listSynthesisknife.add(vsynthesis);
                return listSynthesisknife;
            } else {
                return listSynthesisknife;
            }

        } catch (SQLException e) {
            List<Vsynthesis> listSynthesisknife = new ArrayList<Vsynthesis>();
            Vsynthesis vsynthesis = new Vsynthesis();
            vsynthesis.setMessageCode(IConstant.EMSG0004);
            vsynthesis.setRetErrFlag(true);
            vsynthesis.setExceMessage(e.getMessage());
            listSynthesisknife.add(vsynthesis);
            return listSynthesisknife;
        }
    }

    /**
     * 保存对刀开始数据
     *
     * @param rfidString
     * @param langCode
     * @param langValue
     * @param customerID
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> saveToolInfo(String rfidString, double xpoint, double ypoint, String langCode, String langValue, String customerID, String handsetid) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
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
            Businessflowlnk businessflowlnk = new Businessflowlnk();
            tooltransfer = tooltransferList.get(0);
            businessflowlnk.setBusinessFlowLnkID(tooltransfer.getBusinessFlowLnkID());
            Businessflowlnk flowLink = (Businessflowlnk) businessflowlnkDao.searchByPrimaryKey(businessflowlnk);
            Business business = new Business();
            business.setLanguageCode(langCode);
            business.setBusinessID(flowLink.getBusinessID());
            List<Business> businessList = (List<Business>) businessDao.searchByList(business);
            if (businessList == null || businessList.size() <= 0) {
                // 当前流程不存在!
                result.put("status", IConstant.RESULT_CODE_1);
                result.put("messagetext", IConstant.WMSG0119);
                return result;
            } else {
                business = businessList.get(0);// 取出流程ID

            }
            business = new Business();
            business.setBusinessCode("C01S026");
            businessList = (List<Business>) businessDao.searchByList(business);
            business = businessList.get(0);

            Businessflowlnk businessflowlnks = new Businessflowlnk();
            businessflowlnks.setBusinessID(business.getBusinessID());
            List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);
            businessflowlnk = list1.get(0);
            String businessflowlnkId = businessflowlnk.getBusinessFlowLnkID();
            // 更新流转刀具信息
            for (Tooltransfer tooltransfer2 : tooltransferList) {
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
                // 更新刀具流转信息
                tooltransfer2.setBusinessFlowLnkID(businessflowlnkId);
                tooltransfer2.setUpdateTime(date);
                tooltransfer2.setStockState(IConstant.STOCK_STATE_4);
                tooltransfer2.setUpdateUser(customerID);
                tooltransfer2.setVersion(tooltransfer2.getVersion().add(BigDecimal.ONE));
                tooltransfer2.setRfidContainerIDWhere(tooltransfer2.getRfidContainerID());
                tooltransfer2.setKnifeInventoryCodeWhere(tooltransfer2.getKnifeInventoryCode());
                tooltransfer2.setDelFlagWhere(IConstant.DEL_FLAG_0);
                tooltransferDao.updateNonQuery(tooltransfer2);
                // 记录刀具生命周期数据
                Toolwholelifecycle toolwholelifecycle = new Toolwholelifecycle();
                toolwholelifecycle.setBusinessFlowLnkID(businessflowlnk.getBusinessFlowLnkID());
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
            }
            // 取得合成刀信息
            Synthesisknife synthesisknife = new Synthesisknife();
            synthesisknife.setrFID(rfidcontainer.getRfidContainerID());
            synthesisknife.setDelFlag(IConstant.DEL_FLAG_0);
            List<Synthesisknife> listSynthesisknife = (List<Synthesisknife>) synthesisknifeDao.searchByList(synthesisknife);
            synthesisknife = new Synthesisknife();
            synthesisknife.setSynthesisParametersCode(listSynthesisknife.get(0).getSynthesisParametersCode());
            synthesisknife.setSynthesisParametersNumber(listSynthesisknife.get(0).getSynthesisParametersNumber());
            synthesisknife.setDelFlag(IConstant.DEL_FLAG_0);
            listSynthesisknife = (List<Synthesisknife>) synthesisknifeDao.searchByList(synthesisknife);

            for (Synthesisknife synthesisknife2 : listSynthesisknife) {
                // 更新合成刀具流转履历
                Synthesisexperience synthesisexperience = new Synthesisexperience();
                synthesisexperience.setSynthesisParametersCode(synthesisknife2.getSynthesisParametersCode());
                synthesisexperience.setSynthesisCutterNumber(synthesisknife2.getSynthesisCutterNumber());
                synthesisexperience.setBusinessFlowLnkID(businessflowlnkId);
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
                synthesisknife2.setBusinessFlowLnkID(businessflowlnkId);
                synthesisknife2.setUpdateTime(date);
                synthesisknife2.setxPoint(BigDecimal.valueOf(xpoint));
                synthesisknife2.setyPoint(BigDecimal.valueOf(ypoint));
                synthesisknife2.setKnifeMan(customerID);
                synthesisknife2.setUpdateUser(customerID);
                synthesisknife2.setVersion(synthesisknife2.getVersion().add(BigDecimal.ONE));
                synthesisknife2.setSynthesisParametersCodeWhere(synthesisknife2.getSynthesisParametersCode());
                synthesisknife2.setSynthesisCutterNumberWhere(synthesisknife2.getSynthesisCutterNumber());
                synthesisknife2.setSynthesisParametersNumberWhere(synthesisknife2.getSynthesisParametersNumber());
                synthesisknife2.setDelFlagWhere(IConstant.DEL_FLAG_0);
                synthesisknifeDao.updateNonQuery(synthesisknife2);
            }
            // 对刀结束！
            result.put("status", IConstant.RESULT_CODE_0);
            Equipment Equipmenten = new Equipment();

            if (listSynthesisknife.size() > 0)
                Equipmenten.setEquipmentID(listSynthesisknife.get(0).getEquipmentID());
                Equipmenten.setDelFlag(IConstant.DEL_FLAG_0);

            List<Equipment> equipment = (List<Equipment>) equipmentDao.searchByList(Equipmenten);

            if (equipment.size() > 0) {
                Equipment eq =equipment.get(0);
                Equipment entity = new Equipment();
                entity.setEquipmentIDWhere(eq.getEquipmentID());
                entity.setDelFlagWhere(IConstant.DEL_FLAG_0);
                entity.setEquipmentType(IConstant.EQUIPMENT_TYPE_1);
                entity.setStatues(IConstant.STSATIC_ONE);
                entity.setUpdateUser(customerID);
                entity.setUpdateTime(new Date());
                entity.setVersion(eq.getVersion().add(BigDecimal.ONE));
                equipmentDao.updateNonQueryEmpRifd(entity);
                result.put("EquipmentName", equipment.get(0).getEquipmentName());

            }

            result.put("messagetext", IConstant.CIMSG0065);
            return result;
        } catch (SQLException e) {
            result.put("status", IConstant.RESULT_CODE_2);
            result.put("messagetext", IConstant.EMSG0004);
            return result;
        }
    }
}
