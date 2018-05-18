package com.icomp.common.service.impl.icomp.v01c01.s012;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s012.ICOMPV01C01S012Service;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.BusinessDao;
import com.icomp.dao.BusinessflowlnkDao;
import com.icomp.dao.SynthesisexperienceDao;
import com.icomp.dao.SynthesisknifeDao;
import com.icomp.dao.ToolDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.TooltransferhistoryDao;
import com.icomp.dao.ToolwholelifecycleDao;
import com.icomp.dao.VgetbacktoolnamebyrfidDao;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Businessflowlnk;
import com.icomp.entity.base.Synthesisexperience;
import com.icomp.entity.base.Synthesisknife;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Tooltransferhistory;
import com.icomp.entity.base.Toolwholelifecycle;
import com.icomp.entity.base.Vgetbacktoolnamebyrfid;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设备安上-Service实体类
 *
 * @author Taoyy
 * @ClassName: ICOMPV01C01S012ServiceImpl
 * @date 2014-10-29 下午05:26:02
 */
@SuppressWarnings("unchecked")
public class ICOMPV01C01S012ServiceImpl extends BaseService implements ICOMPV01C01S012Service {
    private static final String BUSINESSCODE = "C01S013";
    // 根据合成刀具RFID取得待收回合成刀具信息Dao
    private VgetbacktoolnamebyrfidDao vgetbacktoolnamebyrfidDao;
    // 合成刀库Dao
    private SynthesisknifeDao synthesisknifeDao;
    // 流转刀具
    private TooltransferDao tooltransferDao;
    // 取得当前刀具的最后执行业务流程
    private BusinessflowlnkDao businessflowlnkDao;
    // 取得业务流程ID
    private BusinessDao businessDao;
    // 刀具参数
    private ToolDao toolDao;
    // 生命周期
    private ToolwholelifecycleDao toolwholelifecycleDao;
    // 刀具流转履历
    private TooltransferhistoryDao tooltransferhistoryDao;
    private SynthesisexperienceDao synthesisexperienceDao;

    public void setSynthesisexperienceDao(SynthesisexperienceDao synthesisexperienceDao) {
        this.synthesisexperienceDao = synthesisexperienceDao;
    }

    /**
     * 根据合成刀具RFID取得待收回合成刀具信息
     */
    @Override
    public List<Vgetbacktoolnamebyrfid> getToolRecoveryInfo(Vgetbacktoolnamebyrfid entity) throws Exception {
        List<Vgetbacktoolnamebyrfid> list1 = new ArrayList<Vgetbacktoolnamebyrfid>();
        List<Vgetbacktoolnamebyrfid> list = new ArrayList<Vgetbacktoolnamebyrfid>();
        try {
            // 待收回合成刀具信息
            list1 = (List<Vgetbacktoolnamebyrfid>) vgetbacktoolnamebyrfidDao.searchByList(entity);
            if (list1 == null || list1.size() <= 0) {
                return list1;
            } else {
                // 筛选是旧刀回收的信息
                for (Vgetbacktoolnamebyrfid v0 : list1) {
                    if (BUSINESSCODE.equals(v0.getBusinessFlowLnkID())) {
                        list.add(v0);
                    }
                }
            }
            if (list.size() < 1) {
                Vgetbacktoolnamebyrfid vedemptionapplied = new Vgetbacktoolnamebyrfid();
                vedemptionapplied.setMessageCode(IConstant.WMSG0232);
                vedemptionapplied.setRetErrFlag(true);
                list.add(vedemptionapplied);
            }
        } catch (SQLException e) {
            Vgetbacktoolnamebyrfid vgetbacktoolnamebyrfid = new Vgetbacktoolnamebyrfid();
            vgetbacktoolnamebyrfid.setMessageCode(IConstant.EMSG0004);
            vgetbacktoolnamebyrfid.setRetErrFlag(true);
            vgetbacktoolnamebyrfid.setExceMessage(e.getMessage());
            list.add(vgetbacktoolnamebyrfid);
        }
        return list;
    }

    /**
     * 更新刀具为已回收状态
     */
    @Override
    public int saveToolRecovery(Map<String, Object> map) throws Exception {
        List<String> rfidList = (List<String>) map.get("rfidlist");// rfid
        String userId = map.get("userId").toString(); // 用户id
        String handId = map.get("handId").toString(); // handId
        int reVal = 0;
        // 取得刀具流转信息
        List<Tooltransfer> ttList = tooltransferDao.searchHalfByList(rfidList);
        Tooltransfer tooltransfer = new Tooltransfer();
        // 取得当前刀具的最后执行业务流程
        Businessflowlnk businessflowlnk = new Businessflowlnk();
        tooltransfer = ttList.get(0);
        businessflowlnk.setBusinessFlowLnkID(tooltransfer.getBusinessFlowLnkID());
        // Businessflowlnk flowLink = (Businessflowlnk)
        // businessflowlnkDao.searchByPrimaryKey(businessflowlnk);
        // 取得业务流程ID
        Business business = new Business();
        business.setBusinessCode("C01S012");
        List<Business> businessList = (List<Business>) businessDao.searchByList(business);
        business = businessList.get(0);
        Businessflowlnk businessflowlnks = new Businessflowlnk();
        businessflowlnks.setBusinessID(business.getBusinessID());
        List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);

        businessflowlnk = list1.get(0);
        // 下一个流程
        String businessFlowLnkID = businessflowlnk.getBusinessFlowLnkID();

        Tooltransferhistory tth = null;
        List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory>();
        Toolwholelifecycle toolwholelifecycle = null;
        List<Toolwholelifecycle> twllist = new ArrayList<Toolwholelifecycle>();
        // 刀具流转
        for (Tooltransfer tt : ttList) {
            // 记录生命周期
            toolwholelifecycle = new Toolwholelifecycle();
            toolwholelifecycle.setBusinessFlowLnkID(businessFlowLnkID);
            toolwholelifecycle.setHandSetID(handId);
            // 取得刀具信息
            Tool tool = new Tool();
            tool.setToolID(tt.getToolID());
            //tool.setDelFlag(IConstant.DEL_FLAG_0);
            List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
            if (toolList.size() > 0 || toolList != null) {
                tool = toolList.get(0);
                toolwholelifecycle.setToolCode(tool.getToolCode());
                toolwholelifecycle.setToolName(tool.getToolName());
                toolwholelifecycle.setKnifeInventoryCode(tt.getKnifeInventoryCode());
                toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
                toolwholelifecycle.setCreateTime(new Date());
                toolwholelifecycle.setUpdateTime(new Date());
                toolwholelifecycle.setCreateUser(userId);
                toolwholelifecycle.setUpdateUser(userId);
                toolwholelifecycle.setVersion(BigDecimal.ZERO);
                toolwholelifecycle.setToolWholeLifecycleID(NextKeyValue.getNextkeyvalue(IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, userId));
                twllist.add(toolwholelifecycle);
                // 刀具流转履历
                tth = new Tooltransferhistory();
                tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(IConstant.TOOLTRANSFERHISTORY, IConstant.TOOLTRANSFERHISTORYID, userId));
                tth.setRfidContainerID(tt.getRfidContainerID()); // RFID载体ID
                tth.setKnifeInventoryCode(tt.getKnifeInventoryCode());// 刀具入库编码
                tth.setToolID(tt.getToolID());// 刀具ID
                tth.setToolProcuredID(tt.getProcuredBatch());// 采购ID
                tth.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程(刀具安上)
                tth.setToolDurable(tt.getToolDurable());// 耐用度
                tth.setToolSharpennum(tt.getToolDurable());// 可使用(刃磨)次数
                tth.setToolSharpenCriterion(tt.getToolSharpenCriterion());// 复磨标准
                tth.setToolLength(tt.getToolLength());// 刀具长度
                tth.setToolSharpenLength(tt.getToolSharpenLength());// 可刃磨长度
                tth.setUsageCounter(tt.getUsageCounter());// 已使用(刃磨)次数
                tth.setToolGrindingLength(tt.getToolGrindingLength());// 刀具已刃磨长度
                tth.setInstallationState(IConstant.INSTALLATION_STATE_1);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
                tth.setStockState(IConstant.STOCK_STATE_4);
                tth.setoutUser(tt.getUpdateUser());// 转出人
                tth.setinUser(userId);// 接收人
                tth.setUpdateTime(new Date());// 更新时间
                tth.setUpdateUser(userId);// 更新者
                tth.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
                tth.setCreateTime(new Date());// 创建时间
                tth.setCreateUser(userId);// 创建者
                tth.setVersion(BigDecimal.ZERO);// 版本号
                tthList.add(tth);
            }
        }
        if (twllist.size() > 0) {
            // 增加生命周期
            toolwholelifecycleDao.insertBatchs(twllist);
        }

        if (tthList.size() > 0) {
            // 批量增加【刀具流转履历】
            tooltransferhistoryDao.insertBatchDefined(tthList);
        }

        // 更新刀具流转
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("installationState", IConstant.INSTALLATION_STATE_1);
        map2.put("businessFlowLnkID", businessFlowLnkID);
        map2.put("userId", userId);
        map2.put("list", rfidList);
        reVal += tooltransferDao.updateBatchByRfid(map2);

        // 更新合成刀库
        map2 = new HashMap<String, Object>();
        map2.put("loadState", IConstant.LOADSTATE_2);
        map2.put("businessFlowLnkID", businessFlowLnkID);
        map2.put("userId", userId);
        map2.put("list", rfidList);
        // 更新数据
        reVal += synthesisknifeDao.updateBatchByRfid(map2);


        //根据RFIDlist查询合成刀库对应的信息（只查询辅具）
        List<Synthesisknife> skList = synthesisknifeDao.findskListByRfidList(rfidList);
        Date date = new Date();
        Synthesisexperience synthesisexperience = null;
        for (Synthesisknife synthesisknife2 : skList) {
            // 更新合成刀具流转履历
                 synthesisexperience = new Synthesisexperience();
                synthesisexperience.setSynthesisParametersCode(synthesisknife2.getSynthesisParametersCode());
                synthesisexperience.setSynthesisCutterNumber(synthesisknife2.getSynthesisCutterNumber());
                synthesisexperience.setBusinessFlowLnkID(businessFlowLnkID);
                synthesisexperience.setSynthesisParametersNumber(synthesisknife2.getSynthesisParametersNumber());
                synthesisexperience.setOperationTime(date);
                synthesisexperience.setArrivalUser(synthesisknife2.getUpdateUser());
                // 需要写入转出者(转出者为上一条数据的接收者)
                synthesisexperience.setRecipientUser(userId);
                synthesisexperience.setTransitionBecause(IConstant.TRANSITION_BECAUSE_3);
                synthesisexperience.setDelFlag(IConstant.DEL_FLAG_0);
                synthesisexperience.setCreateTime(date);
                synthesisexperience.setUpdateTime(date);
                synthesisexperience.setCreateUser(userId);
                synthesisexperience.setUpdateUser(userId);
                synthesisexperience.setVersion(BigDecimal.ZERO);
            synthesisexperienceDao.insert(synthesisexperience);
        }



        return reVal;
    }

    public void setSynthesisknifeDao(SynthesisknifeDao synthesisknifeDao) {
        this.synthesisknifeDao = synthesisknifeDao;
    }

    public void setVgetbacktoolnamebyrfidDao(VgetbacktoolnamebyrfidDao vgetbacktoolnamebyrfidDao) {
        this.vgetbacktoolnamebyrfidDao = vgetbacktoolnamebyrfidDao;
    }

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    public void setBusinessflowlnkDao(BusinessflowlnkDao businessflowlnkDao) {
        this.businessflowlnkDao = businessflowlnkDao;
    }

    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    public void setToolwholelifecycleDao(ToolwholelifecycleDao toolwholelifecycleDao) {
        this.toolwholelifecycleDao = toolwholelifecycleDao;
    }

    public void setTooltransferhistoryDao(TooltransferhistoryDao tooltransferhistoryDao) {
        this.tooltransferhistoryDao = tooltransferhistoryDao;
    }

}
