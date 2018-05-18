package com.icomp.common.service.impl.icomp.v01c01.s014;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s014.ICOMPV01C01S014Service;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.common.utils.UUIDgen;
import com.icomp.dao.BusinessDao;
import com.icomp.dao.BusinessflowlnkDao;
import com.icomp.dao.ContainercarrierDao;
import com.icomp.dao.KnifeinventoryDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.ToolDao;
import com.icomp.dao.ToolrepairnoticeDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.TooltransferhistoryDao;
import com.icomp.dao.ToolwholelifecycleDao;
import com.icomp.dao.VgetrepairnoticetoolmsgDao;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Businessflowlnk;
import com.icomp.entity.base.Containercarrier;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Toolrepairnotice;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Tooltransferhistory;
import com.icomp.entity.base.Toolwholelifecycle;
import com.icomp.entity.base.Vgetrepairnoticetoolmsg;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 刀具分拣-Service实现类
 *
 * @author Taoyy
 * @ClassName: ICOMPV01C01S014ServiceImpl
 * @date 2016-2-29 上午10:37:06
 */
public class ICOMPV01C01S014ServiceImpl extends BaseService implements ICOMPV01C01S014Service {
    /**
     * 取得刀具修复通知单信息Dao
     */
    private VgetrepairnoticetoolmsgDao vgetrepairnoticetoolmsgDao;

    public void setVgetrepairnoticetoolmsgDao(VgetrepairnoticetoolmsgDao vgetrepairnoticetoolmsgDao) {
        this.vgetrepairnoticetoolmsgDao = vgetrepairnoticetoolmsgDao;
    }

    /**
     * 刀具修复通知Dao
     */
    private ToolrepairnoticeDao toolrepairnoticeDao;

    public void setToolrepairnoticeDao(ToolrepairnoticeDao toolrepairnoticeDao) {
        this.toolrepairnoticeDao = toolrepairnoticeDao;
    }

    private TooltransferDao tooltransferDao;

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    /* 刀具Dao */
    private ToolDao toolDao;

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    private BusinessDao businessDao;

    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    private BusinessflowlnkDao businessflowlnkDao;

    public void setBusinessflowlnkDao(BusinessflowlnkDao businessflowlnkDao) {
        this.businessflowlnkDao = businessflowlnkDao;
    }

    private RfidcontainerDao rfidcontainerDao;

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    // 生命周期
    private ToolwholelifecycleDao toolwholelifecycleDao;
    // 刀具流转履历
    private TooltransferhistoryDao tooltransferhistoryDao;

    public void setToolwholelifecycleDao(ToolwholelifecycleDao toolwholelifecycleDao) {
        this.toolwholelifecycleDao = toolwholelifecycleDao;
    }

    public void setTooltransferhistoryDao(TooltransferhistoryDao tooltransferhistoryDao) {
        this.tooltransferhistoryDao = tooltransferhistoryDao;
    }

    private KnifeinventoryDao knifeinventoryDao;

    public void setKnifeinventoryDao(KnifeinventoryDao knifeinventoryDao) {
        this.knifeinventoryDao = knifeinventoryDao;
    }

    private ContainercarrierDao containercarrierDao;

    public void setContainercarrierDao(ContainercarrierDao containercarrierDao) {
        this.containercarrierDao = containercarrierDao;
    }

    /**
     * 取得刀具修复通知单信息 getToolInfo
     *
     * @param entity
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @Override
    public Vgetrepairnoticetoolmsg getToolInfo(Vgetrepairnoticetoolmsg entity) throws Exception {
        Vgetrepairnoticetoolmsg vgetrepairnoticetoolmsg = new Vgetrepairnoticetoolmsg();
        try {
            // 取得待换领刀具信息列表
            List<Vgetrepairnoticetoolmsg> list = (List<Vgetrepairnoticetoolmsg>) vgetrepairnoticetoolmsgDao.searchByList(entity);
            if (list == null || list.size() == 0) {
                // 刀具修复通知单未找到相应数据!
                vgetrepairnoticetoolmsg.setMessageCode(IConstant.WMSG0137);
                vgetrepairnoticetoolmsg.setRetErrFlag(true);
            } else {
                vgetrepairnoticetoolmsg.setMessageCode(IConstant.IMSG0001);
                vgetrepairnoticetoolmsg.setRetErrFlag(false);
                vgetrepairnoticetoolmsg = list.get(0);
            }
        } catch (SQLException e) {
            // 数据库操作异常，查询失败!
            vgetrepairnoticetoolmsg.setMessageCode(IConstant.EMSG0004);
            vgetrepairnoticetoolmsg.setRetErrFlag(true);
            vgetrepairnoticetoolmsg.setExceMessage(e.getMessage());
        }
        return vgetrepairnoticetoolmsg;
    }

    /**
     * 修复通知单号生成 createRepairNoticeNumber
     *
     * @param customerID
     * @return
     * @throws Exception
     */
    @Override
    public String createRepairNoticeNumber(String customerID) throws Exception {
        // 修复通知单号表(ToolRepairNoticeID)主键
        return NextKeyValue.getNextkeyvalueNo(IConstant.REDEMPTION_APPLIED, IConstant.REDEMPTION_APPLIED_ID, customerID);
    }

    /**
     * 修复通知单发布 批量添加 saveToolRepairNotice
     *
     * @param list
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object saveToolRepairNotice(List<Toolrepairnotice> list, String userId, String handId) throws Exception {
        String rfidContainerId = null;
        // 取得业务流程下一个ID
        Business business = new Business();
        business.setBusinessCode("C01S014");
        List<Business> businessList = (List<Business>) businessDao.searchByList(business);
        business = businessList.get(0);
        Businessflowlnk businessflowlnks = new Businessflowlnk();
        businessflowlnks.setBusinessID(business.getBusinessID());
        List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);
        businessflowlnks = list1.get(0);
        List<String> lists = new ArrayList<String>();
        for (Toolrepairnotice toolrepairnotice : list) {
            Rfidcontainer rfidcontainer = new Rfidcontainer();
            rfidcontainer.setRfidCode(toolrepairnotice.getRfidCode());
            List<Rfidcontainer> rfidcontainerList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
            // 根据通知单中的rfid 取得流转中数据
            Tooltransfer entity = new Tooltransfer();
            rfidContainerId = rfidcontainerList.get(0).getRfidContainerID();
            toolrepairnotice.setRfidCode(rfidContainerId);
            entity.setRfidContainerID(rfidContainerId);
            List<Tooltransfer> tooltransferList = (List<Tooltransfer>) tooltransferDao.searchByList(entity);
            Toolwholelifecycle toolwholelifecycle = null;
            List<Toolwholelifecycle> tlcList = new ArrayList<Toolwholelifecycle>();
            Tooltransferhistory tth = null;
            List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory>();
            // 取得刀具信息
            Tool tool = new Tool();
            tool.setToolID(tooltransferList.get(0).getToolID());
            List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
            tool = toolList.get(0);
            // 刀具流转信息
            for (Tooltransfer tt : tooltransferList) {
                // 记录刀具生命周期数据
                toolwholelifecycle = new Toolwholelifecycle();
                toolwholelifecycle.setBusinessFlowLnkID(businessflowlnks.getBusinessFlowLnkID());
                toolwholelifecycle.setHandSetID(handId);

                toolwholelifecycle.setKnifeInventoryCode(tt.getKnifeInventoryCode());
                toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
                if (tt.getProcessAmount() != null) {
                    toolwholelifecycle.setProcessAmount(tt.getProcessAmount().toString());
                } else {
                    toolwholelifecycle.setProcessAmount(IConstant.DEL_FLAG_0);
                }
                toolwholelifecycle.setCreateTime(new Date());
                toolwholelifecycle.setUpdateTime(new Date());
                toolwholelifecycle.setCreateUser(userId);
                toolwholelifecycle.setUpdateUser(userId);
                toolwholelifecycle.setVersion(BigDecimal.ZERO);
                toolwholelifecycle.setToolWholeLifecycleID(NextKeyValue.getNextkeyvalue(IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, userId));
                tlcList.add(toolwholelifecycle);

                // 添加刀具流转履历
                tth = new Tooltransferhistory();
                tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(IConstant.TOOL_TRANSFER_HISTORY, IConstant.TOOL_TRANSFER_HISTORY_ID, userId)); // id
                tth.setRfidContainerID(tt.getRfidContainerID()); // RFID载体ID
                tth.setKnifeInventoryCode(tt.getKnifeInventoryCode()); // 刀具入库编码
                tth.setToolID(tt.getToolID());// 刀具ID
                tth.setToolProcuredID(tt.getProcuredBatch()); // 采购ID
                tth.setBusinessFlowLnkID(businessflowlnks.getBusinessFlowLnkID());// 最后执行业务流程
                tth.setToolDurable(tt.getToolDurable());// 耐用度
                tth.setToolSharpennum(tt.getToolDurable());// 可使用(刃磨)次数
                tth.setToolSharpenCriterion(tt.getToolSharpenCriterion()); // 复磨标准
                tth.setToolLength(tt.getToolLength());// 刀具长度
                tth.setToolSharpenLength(tt.getToolSharpenLength());// 可刃磨长度
                tth.setUsageCounter(tt.getUsageCounter()); // 已使用(刃磨)次数
                tth.setToolGrindingLength(tt.getToolGrindingLength());// 刀具已刃磨长度
                tth.setInstallationState(IConstant.INSTALLATION_STATE_1);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
                tth.setDelFlag(IConstant.DEL_FLAG_0); // 删除区分
                tth.setCreateTime(new Date());// 创建时间
                tth.setCreateUser(userId); // 创建者
                tth.setVersion(BigDecimal.ZERO);// 版本号
                tthList.add(tth);
                // 修改流转刀具状态
                Tooltransfer updateTooltransfer = new Tooltransfer();
                updateTooltransfer.setRfidContainerIDWhere(rfidcontainerList.get(0).getRfidContainerID());
                updateTooltransfer.setKnifeInventoryCodeWhere(tooltransferList.get(0).getKnifeInventoryCode());
                updateTooltransfer.setDelFlagWhere(IConstant.DEL_FLAG_0);
                updateTooltransfer.setBusinessFlowLnkID(businessflowlnks.getBusinessFlowLnkID());
                updateTooltransfer.setStockState(IConstant.STOCK_STATE_4);
                updateTooltransfer.setVersion(tooltransferList.get(0).getVersion().add(BigDecimal.ONE));
                updateTooltransfer.setUpdateTime(new Date());
                updateTooltransfer.setUpdateUser(userId);
                tooltransferDao.updateNonQuery(updateTooltransfer);
            }

            // 批量添加【生命周期】
            if (tlcList.size() > 0) {
                toolwholelifecycleDao.insertBatchs(tlcList);
            }
            // 批量添加【刀具流转履历】
            if (tthList.size() > 0) {
                tooltransferhistoryDao.insertBatchDefined(tthList);
            }

        }
        // 批量添加
        return toolrepairnoticeDao.saveToolRepairNotice(list);

    }

    /**
     * 取得修磨处理(非单品)
     */
    @Override
    public Map<String, Object> getRegrindingList(Map<String, Object> rtn) throws Exception {
        String rfidCode = rtn.get("rfidString").toString();
        Tooltransfer entity = new Tooltransfer();
        entity.setExpandSpace1(rfidCode);
        entity.setGroupString("ToolID");

        List<Tooltransfer> toolTransferList = (List<Tooltransfer>) tooltransferDao.getRegrindingList(entity);
        rtn.put("data", toolTransferList);
        return rtn;

    }

    /**
     * 保存修磨处理(非单品)
     */
    @Override
    public Map<String, Object> saveRegrinding(Map<String, Object> rtn) throws Exception {
        String userId = rtn.get("userId").toString();
        String rfidCode = rtn.get("rfidCode").toString();
        String toolCode = rtn.get("toolCode").toString();
        String handId = rtn.get("handId").toString();
        String toolState = rtn.get("toolState").toString();
        int gringdingCount = Integer.parseInt(rtn.get("gringdingCount").toString());
        Tooltransfer entity = new Tooltransfer();
        entity.setExpandSpace1(rfidCode);
        // 刀具id暂放刀具编码在sql语句中查询
        entity.setToolID(toolCode);
        entity.setStaIndex(0);
        entity.setRowCount(gringdingCount);
        List<Tooltransfer> toolTransferList = (List<Tooltransfer>) tooltransferDao.getRegrindingList(entity);

        Toolwholelifecycle toolwholelifecycle = null;
        List<Toolwholelifecycle> tlcList = new ArrayList<Toolwholelifecycle>();
        Tooltransferhistory tth = null;
        List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory>();
        String rfidContainerId = null;

        // 取得业务流程下一个ID
        Business business = new Business();
        business.setBusinessCode("C01S014");
        List<Business> businessList = (List<Business>) businessDao.searchByList(business);
        business = businessList.get(0);
        Businessflowlnk businessflowlnks = new Businessflowlnk();
        businessflowlnks.setBusinessID(business.getBusinessID());
        List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);
        businessflowlnks = list1.get(0);
        String businessFlowLnkID = businessflowlnks.getBusinessFlowLnkID();

        // 刀具流转信息
        for (Tooltransfer tt : toolTransferList) {
            // 记录刀具生命周期数据
            toolwholelifecycle = new Toolwholelifecycle();
            toolwholelifecycle.setBusinessFlowLnkID(businessFlowLnkID);
            toolwholelifecycle.setHandSetID(handId);
            toolwholelifecycle.setToolCode(toolCode);
            toolwholelifecycle.setToolName(toolCode);
            toolwholelifecycle.setKnifeInventoryCode(tt.getKnifeInventoryCode());
            toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
            toolwholelifecycle.setCreateTime(new Date());
            toolwholelifecycle.setUpdateTime(new Date());
            toolwholelifecycle.setCreateUser(userId);
            toolwholelifecycle.setUpdateUser(userId);
            toolwholelifecycle.setVersion(BigDecimal.ZERO);
            toolwholelifecycle.setToolWholeLifecycleID(NextKeyValue.getNextkeyvalue(IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, userId));
            tlcList.add(toolwholelifecycle);

            // 添加刀具流转履历
            tth = new Tooltransferhistory();
            tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(IConstant.TOOL_TRANSFER_HISTORY, IConstant.TOOL_TRANSFER_HISTORY_ID, userId)); // id
            tth.setRfidContainerID(tt.getRfidContainerID()); // RFID载体ID
            tth.setKnifeInventoryCode(tt.getKnifeInventoryCode()); // 刀具入库编码
            tth.setToolID(tt.getToolID());// 刀具ID
            tth.setToolProcuredID(tt.getProcuredBatch()); // 采购ID
            tth.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程
            tth.setToolDurable(tt.getToolDurable());// 耐用度
            tth.setToolSharpennum(tt.getToolDurable());// 可使用(刃磨)次数
            tth.setToolSharpenCriterion(tt.getToolSharpenCriterion()); // 复磨标准
            tth.setToolLength(tt.getToolLength());// 刀具长度
            tth.setToolSharpenLength(tt.getToolSharpenLength());// 可刃磨长度
            tth.setUsageCounter(tt.getUsageCounter()); // 已使用(刃磨)次数
            tth.setToolGrindingLength(tt.getToolGrindingLength());// 刀具已刃磨长度
            tth.setInstallationState(IConstant.INSTALLATION_STATE_1);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
            tth.setDelFlag(IConstant.DEL_FLAG_0); // 删除区分
            tth.setCreateTime(new Date());// 创建时间
            tth.setCreateUser(userId); // 创建者
            tth.setVersion(BigDecimal.ZERO);// 版本号
            tthList.add(tth);
            // 修改流转刀具状态
            Tooltransfer updateTooltransfer = new Tooltransfer();
            updateTooltransfer.setRfidContainerIDWhere(tt.getRfidContainerID());
            updateTooltransfer.setKnifeInventoryCodeWhere(tt.getKnifeInventoryCode());
            updateTooltransfer.setDelFlagWhere(IConstant.DEL_FLAG_0);
            updateTooltransfer.setRfidContainerID(IConstant.GRINDING_CONTARNERID);
            updateTooltransfer.setBusinessFlowLnkID(businessFlowLnkID);
            // 刀具状态:6厂内待刃磨,7.厂外待刃磨
            if (IConstant.STSATIC_ZERO.equals(toolState)) {
                updateTooltransfer.setToolState(IConstant.STSATIC_SIX);
            } else {
                updateTooltransfer.setToolState(IConstant.STSATIC_SEVEN);
            }
            updateTooltransfer.setStockState(IConstant.STOCK_STATE_4);
            updateTooltransfer.setVersion(tt.getVersion().add(BigDecimal.ONE));
            updateTooltransfer.setUpdateTime(new Date());
            updateTooltransfer.setUpdateUser(userId);
            tooltransferDao.updateNonQuery(updateTooltransfer);
        }

        // 批量添加【生命周期】
        if (tlcList.size() > 0) {
            toolwholelifecycleDao.insertBatchs(tlcList);
        }
        // 批量添加【刀具流转履历】
        if (tthList.size() > 0) {
            tooltransferhistoryDao.insertBatchDefined(tthList);
        }
        return rtn;

    }

    @Override
    public List<Tooltransfer> getToolidBrfidconer(Tooltransfer tr) throws Exception {
        return (List<Tooltransfer>) tooltransferDao.searchByList(tr);
    }

    /**
     * 查询容器列表
     */
    @Override
    public List<Tool> getToolList(Tool entity) throws Exception {
        return toolDao.getToolList(entity);
    }

    /**
     * 查询刀具ID
     */
    @SuppressWarnings("unchecked")
    @Override
    public String getToolID(Tooltransfer entity) throws Exception {
        List<Tooltransfer> reList = (List<Tooltransfer>) tooltransferDao.searchByList(entity);
        if (reList.size() < 1) {
            // 没有RIFD载体
            return null;
        } else {
            return reList.get(0).getToolID();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Tool getToolInfo(Tool entity) throws SQLException {
        List<Tool> reList = (List<Tool>) toolDao.searchByList(entity);
        Tool reEntity = new Tool();
        if (reList.size() < 1) {
            // 未找到相应数据
            reEntity.setRetErrFlag(true);
        } else {
            reEntity = reList.get(0);
        }
        return reEntity;
    }

    /**
     * 查询标签类型
     */
    @SuppressWarnings("unchecked")
    @Override
    public Rfidcontainer getQueryType(Rfidcontainer entity) throws SQLException {
        List<Rfidcontainer> reList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(entity);
        Rfidcontainer reEntity = new Rfidcontainer();
        if (reList.size() < 1) {
            // 未找到相应数据
            reEntity.setRetErrFlag(true);
        } else {
            reEntity = reList.get(0);
        }
        return reEntity;
    }

    /**
     * 取得流转表刀具信息
     */
    @SuppressWarnings("unchecked")
    @Override
    public Tooltransfer getToolSortInfo(Tooltransfer entity) throws SQLException {
        List<Tooltransfer> reList = (List<Tooltransfer>) tooltransferDao.searchByList(entity);
        Tooltransfer reEntity = new Tooltransfer();
        if (reList.size() < 1) {
            // 未找到相应数据
            reEntity.setRetErrFlag(true);
        } else {
            reEntity = reList.get(0);
        }
        return reEntity;
    }

    /**
     * 分拣容器中的数据
     */
    @SuppressWarnings("unchecked")
    @Override
    public int updateToolMsg(Map<String, Object> map) throws Exception {
        int reVal = 0;
        // 用户ID
        // 取值
        String customerID = map.get("customerID").toString();
        // 刃磨容器的载体ID
        String rfidConnerID = map.get("rfidConnerID").toString();
        // 刀具ID
        String toolID = map.get("toolID").toString();
        // 确认数量
        int toolDurable = Integer.parseInt(map.get("toolDurable").toString());
        // 扫描数量（原有数量）
        int toolNumber = Integer.parseInt(map.get("toolDurab").toString());
        //查询刀具入库编码和批次
        Tooltransfer t = new Tooltransfer();
        t.setToolID(toolID);
        t.setDelFlag(IConstant.DEL_FLAG_0);
        List<Tooltransfer> ttt = tooltransferDao.getToolMSgBToolID(t);
        //刀具入库编码
        String kCode = ttt.get(0).getKnifeInventoryCode();
        //批次
        String procuredBatch = ttt.get(0).getProcuredBatch();

        // 0厂内,1厂外
        String grindingMode = map.get("grindingMode").toString();
        // 修改原容器的数据
        Tooltransfer tt = new Tooltransfer();
        //未确认数量
        int number = toolNumber - toolDurable;
        // 条件
        // 刃磨容器的载体ID
        tt.setRfidContainerIDWhere(rfidConnerID);
        // 刀具ID
        tt.setToolIDWhere(toolID);
        // set的值
        if (number == 0) {
            // 没有未确认数量，即该刀片已全部分拣完毕
            // 0厂内1厂外
            if (IConstant.DEL_FLAG_0.equals(grindingMode)) {
                // 0厂内
                tt.setRfidContainerID(IConstant.GRINDING_CONTARNERID);
                // 6厂内待刃磨
                tt.setToolState(IConstant.STSATIC_SIX);
            } else {
                // 1厂外
                tt.setRfidContainerID(IConstant.GRINDING_CONTARNERID_OUT);
                // 7.厂外待刃磨
                tt.setToolState(IConstant.STSATIC_SEVEN);
            }
            // 2刃磨室
            tt.setToolThisState(IConstant.CREATE_TYPE_2);
            //数量
            tt.setToolDurable(new BigDecimal(toolNumber));
            tt.setUpdateUser(customerID);
            tt.setUpdateTime(new Date());
            // 修改分拣后厂内厂外的数据
            reVal = +tooltransferDao.updateNonQuery(tt);
        } else {
            // 如果有未确认数量
            Tooltransfer tt2 = new Tooltransfer();
            // 条件
            // 刀具id
            tt2.setToolIDWhere(toolID);
            // 刃磨容器的载体id
            tt2.setRfidContainerIDWhere(rfidConnerID);
            // 2刃磨室
            //			tt2.setToolThisState(IConstant.CREATE_TYPE_2);
            // 0厂内1厂外
            if (IConstant.DEL_FLAG_0.equals(grindingMode)) {
                // 0厂内
                // 厂内待刃磨容器的载体id
                tt2.setRfidContainerID(IConstant.GRINDING_CONTARNERID);
                // 刀具id
                tt2.setToolID(toolID);
                // 6厂内待刃磨
                tt2.setToolState(IConstant.STSATIC_SIX);
                // 删除区分
                tt2.setDelFlag(IConstant.DEL_FLAG_0);
                // 查询是否有厂内待刃磨信息
                List<Tooltransfer> reList = (List<Tooltransfer>) tooltransferDao.searchByList(tt2);
                if (reList.size() > 0) {
                    // 如果有,则在查询到的记录上更新刃磨信息
                    BigDecimal count = reList.get(0).getToolDurable();
                    // 刃磨数量为空,则默认为零
                    if (null == count) {
                        count = BigDecimal.ZERO;
                    }
                    // 变换更新条件,对刃磨数量进行累加
                    tt2.setRfidContainerIDWhere(IConstant.GRINDING_CONTARNERID);
                    tt2.setToolIDWhere(toolID);
                    tt2.setToolDurable(count.add(new BigDecimal(toolDurable)));
                    tooltransferDao.updateNonQuery(tt2);
                } else {
                    // 如果没有,则在该条记录上更新刃磨信息
                    tt2.setRfidContainerID(IConstant.GRINDING_CONTARNERID);
                    tt2.setKnifeInventoryCode(kCode);
                    tt2.setProcuredBatch(procuredBatch);
                    tt2.setToolDurable(BigDecimal.valueOf(toolDurable));
                    tt2.setUpdateTime(new Date());
                    tt2.setUpdateUser(customerID);
                    tt2.setVersion(BigDecimal.ONE);
                    tooltransferDao.updateNonQuery(tt2);
                }
            } else {
                // 1厂外
                // 刃磨容器的载体id
                tt2.setRfidContainerID(IConstant.GRINDING_CONTARNERID_OUT);
                // 刀具id
                tt2.setToolID(toolID);
                // 7.厂外待刃磨
                tt2.setToolState(IConstant.STSATIC_SEVEN);
                // 删除区分
                tt2.setDelFlag(IConstant.DEL_FLAG_0);
                List<Tooltransfer> reList = (List<Tooltransfer>) tooltransferDao.searchByList(tt2);
                if (reList.size() > 0) {
                    // 如果有,则在查询到的记录上更新刃磨信息
                    BigDecimal count = reList.get(0).getToolDurable();
                    // 刃磨数量为空,则默认为零
                    if (null == count) {
                        count = BigDecimal.ZERO;
                    }
                    tt2.setRfidContainerIDWhere(IConstant.GRINDING_CONTARNERID_OUT);
                    tt2.setToolIDWhere(toolID);
                    tt2.setToolDurable(count.add(new BigDecimal(toolDurable)));
                    tooltransferDao.updateNonQuery(tt2);
                } else {
                    // 如果没有,则在该条记录上更新刃磨信息
                    tt2.setRfidContainerID(IConstant.GRINDING_CONTARNERID_OUT);
                    tt2.setKnifeInventoryCode(kCode);
                    tt2.setProcuredBatch(procuredBatch);
                    tt2.setToolDurable(BigDecimal.valueOf(toolDurable));
                    tt2.setUpdateTime(new Date());
                    tt2.setUpdateUser(customerID);
                    tt2.setVersion(BigDecimal.ONE);
                    tooltransferDao.updateNonQuery(tt2);
                }
            }
        }
        return reVal;
    }

    /**
     * 分拣单品刀的数据
     */
    @Override
    public int updateSyrfid(Map<String, Object> map) throws Exception {
		int reVal = 0;
		try {
			// 取值
			// 修磨方式(0:厂内，1厂外）
			String grindingMode = map.get("grindingMode").toString();
			// 刀具ID
			String toolID = map.get("toolID").toString();
			// 用户ID
			String customerID = map.get("customerID").toString();
			// rfidContainerId
			String rfidContainerId = map.get("rfidContainerId").toString();
			// 手持机id
			String handSetID = map.get("handSetId").toString();

			Tooltransfer tt = new Tooltransfer();
			if (IConstant.DEL_FLAG_1.equals(grindingMode)) {
				// 厂外
				// 刀具状态(6厂内待刃磨)
				tt.setToolState(IConstant.KNIFE_INVENTORY_TYPE_7);
			} else {
				// 厂内
				// 刀具状态(7厂外待刃磨)
				tt.setToolState(IConstant.KNIFE_INVENTORY_TYPE_6);
			}
			// 刀具ID
			tt.setToolIDWhere(toolID);
			tt.setBusinessFlowLnkID(IConstant.C01S014);
			// 载体id
			tt.setRfidContainerIDWhere(rfidContainerId);
			// 刀具部门(0库存,1对刀室,2刃磨室,3,车间)
			tt.setToolThisState(IConstant.KNIFE_INVENTORY_TYPE_2);
			tt.setUpdateTime(new Date());
			tt.setUpdateUser(customerID);
			reVal = +tooltransferDao.updateNonQuery(tt);

			// 查询刀具入库编码
			String knifeInventoryCode = null;
			tt = new Tooltransfer();
			tt.setRfidContainerID(rfidContainerId);
			List<Tooltransfer> ttList2 = (List<Tooltransfer>) tooltransferDao
					.searchByList(tt);
			if (ttList2.size() > 0) {
				List<Toolwholelifecycle> twls = new ArrayList<Toolwholelifecycle>();
				for (Tooltransfer tt2 : ttList2) {
					// 建立生命周期
					Toolwholelifecycle twl = new Toolwholelifecycle();
					// 刀具全生命周期id
					twl.setToolWholeLifecycleID(UUIDgen.getId());
					// 刀具入库编码
					twl.setKnifeInventoryCode(tt2.getKnifeInventoryCode());
					// 流程id
					twl.setBusinessFlowLnkID(IConstant.C01S014);
					// 手持机id
					twl.setHandSetID(tt.getExpandSpace1());
					// 刀具id
					twl.setToolID(tt2.getToolID());
					// 零部件id
					twl.setPartsID("");
					if (tt2.getProcessAmount() != null) {
						twl.setProcessAmount(tt2.getProcessAmount().toString());
					} else {
						twl.setProcessAmount(IConstant.DEL_FLAG_0);
					}
					// 删除区分(0有效1删除)
					twl.setDelFlag(IConstant.DEL_FLAG_0);
					// 更新时间
					twl.setUpdateTime(new Date());
					// 更新者
					twl.setUpdateUser(customerID);
					// 创建时间
					twl.setCreateTime(new Date());
					// 创建者
					twl.setCreateUser(customerID);
					// 刃磨次数
					if (tt2.getUsageCounter()!=null) {
						twl.setVersion(tt2.getUsageCounter());
					}else {
						twl.setVersion(BigDecimal.ZERO);
					}
					twls.add(twl);
				}
				if (twls.size() > 0) {
					toolwholelifecycleDao.insertBatchs(twls);
				}
			}

		} catch (Exception e) {
			return 0;
		}
		return reVal;
    }

    @Override
    public String getContainerType(String rfidContainerId) throws Exception {
        Containercarrier cc = new Containercarrier();
        cc.setRfidContainerID(rfidContainerId);//载体id
        cc.setDelFlag(IConstant.DEL_FLAG_0);
        List<Containercarrier> ccList = (List<Containercarrier>) containercarrierDao.searchByList(cc);
        if (ccList.size() <= 0) {
            return "-1";
        } else {
            //容器类型
            String containerType = null;
            if ("".equals(ccList.get(0).getContainerCarrierType()) || ccList.get(0).getContainerCarrierType() == null) {
                return "-1";
            } else {
                containerType = ccList.get(0).getContainerCarrierType();
                return containerType;
            }
        }
    }
}
