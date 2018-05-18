package com.icomp.common.service.impl.icomp.v01c01.s027;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s027.ICOMPV01C01S027Service;
import com.icomp.common.utils.UUIDgen;
import com.icomp.dao.BusinessDao;
import com.icomp.dao.BusinessflowlnkDao;
import com.icomp.dao.KnifeinventoryDao;
import com.icomp.dao.OutsidefactoryDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.ToolDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.TooltransferhistoryDao;
import com.icomp.dao.ToolwholelifecycleDao;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Businessflowlnk;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.TooltranarMassage;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Tooltransferhistory;
import com.icomp.entity.base.Toolwholelifecycle;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 刀具交接
 */
@SuppressWarnings("unchecked")
public class ICOMPV01C01S027ServiceImpl extends BaseService implements ICOMPV01C01S027Service {

    private TooltransferDao tooltransferDao;
    private BusinessDao businessDao;
    private BusinessflowlnkDao businessflowlnkDao;
    private ToolDao toolDao;
    private ToolwholelifecycleDao toolwholelifecycleDao;
    private TooltransferhistoryDao tooltransferhistoryDao;
    private OutsidefactoryDao outsidefactoryDao;
    private RfidcontainerDao rfidcontainerDao;
    private SqlMapClient dataSource;

    public void setDataSource(SqlMapClient dataSource) {
        this.dataSource = dataSource;
    }

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    public void setOutsidefactoryDao(OutsidefactoryDao outsidefactoryDao) {
        this.outsidefactoryDao = outsidefactoryDao;
    }

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    public void setBusinessflowlnkDao(BusinessflowlnkDao businessflowlnkDao) {
        this.businessflowlnkDao = businessflowlnkDao;
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

    private KnifeinventoryDao knifeinventoryDao;

    public void setKnifeinventoryDao(KnifeinventoryDao knifeinventoryDao) {
        this.knifeinventoryDao = knifeinventoryDao;
    }

    /**
     * 取得交接的容器
     *
     * @param map rfidString 交换容器RFID(String)
     * @return
     * @throws Exception
     */
    @Override
    public List<TooltranarMassage> getTransferToolsContarner(Map<String, Object> map) throws Exception {
        String rfidString = (String) map.get("rfidString");
        TooltranarMassage entity = new TooltranarMassage();
        // rfid
        entity.setRfidCode(rfidString);
        // 取得交接的容器
        return tooltransferDao.getGrindingContarnerByRfid(entity);
    }

    /**
     * 刃磨室-->对刀室 提交数据
     *
     * @param map transferToolMsg 容器中的信息(List<TooltranarMassage>) userId
     *            用户id(String) rfidContarnerId 载体id(String) gruantUserId
     *            授权人id(String)
     * @return
     * @throws SQLException
     */

    @Override
    public int saveGrindingToKnifeData(Map<String, Object> map) {
        try {

            int reVal = 0;
            Tooltransfer entity = null;
            // 容器中的信息
            List<TooltranarMassage> tooltranarMassages = (List<TooltranarMassage>) map.get("transferToolMsg");
            // 用户id
            String userId = (String) map.get("userId");
            // 授权人id
            String gruantUserId = (String) map.get("gruantUserId");
            // 载体id
            String rfidContarnerId = (String) map.get("rfidContarnerIdOut");
            // 手持机
            String handerId = (String) map.get("handerId");
            // 取得业务流程ID
            Business business = new Business();
            business.setBusinessCode("C01S027");
            List<Business> businessList = (List<Business>) businessDao.searchByList(business);
            business = businessList.get(0);
            Businessflowlnk businessflowlnks = new Businessflowlnk();
            businessflowlnks.setBusinessID(business.getBusinessID());
            List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);
            String businessFlowLnkID = list1.get(0).getBusinessFlowLnkID();
            // 根据合成刀具RFID查询到流转中的刀具
            List<Tooltransfer> ttlist = new ArrayList<Tooltransfer>();
            List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory>();
            Tooltransferhistory tth = null;
            List<Toolwholelifecycle> tlcList = new ArrayList<Toolwholelifecycle>();
            Toolwholelifecycle toolwholelifecycle = null;
            for (TooltranarMassage ttm : tooltranarMassages) {
                entity = new Tooltransfer();
                Tooltransfer ran = new Tooltransfer();
                entity.setToolIDWhere(ttm.getToolId());
                ran.setToolID(ttm.getToolId());
                ran.setRfidContainerID(rfidContarnerId);
                ran.setStaIndex(0);
                ran.setRowCount(Integer.parseInt(ttm.getGrindingCount()));
                entity.setRfidContainerIDWhere(rfidContarnerId);
                // 数量
                entity.setRowCount(Integer.parseInt(ttm.getGrindingCount()));
                // 刀具部门(0库存,1对刀室,2刃磨室,3,车间)
                entity.setToolThisState(IConstant.STSATIC_ONE);
                entity.setRfidContainerID(IConstant.KNIFE_CONTARNERID);
                entity.setBusinessFlowLnkID(businessFlowLnkID);
                // 交接确认人
                entity.setConfirmedUser(gruantUserId);
                // 其他
                entity.setToolState(IConstant.TOOL_STATE_9);
                // 4.流转
                entity.setStockState(IConstant.STOCK_STATE_4);
                entity.setUpdateTime(new Date());
                entity.setUpdateUser(userId);
                ttlist.addAll((List<Tooltransfer>) tooltransferDao.searchByList(ran));
                reVal += tooltransferDao.updateDateByToolID(entity);
            }
            for (Tooltransfer tt : ttlist) {
                // 记录生命周期
                if (handerId != null) {
                    toolwholelifecycle = new Toolwholelifecycle();
                    toolwholelifecycle.setBusinessFlowLnkID(businessFlowLnkID);
                    toolwholelifecycle.setHandSetID(handerId);
                    // 取得刀具信息
                    Tool tool = new Tool();
                    tool.setToolID(tt.getToolID());
                    List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
                    if (toolList != null && toolList.size() > 0) {
                        tool = toolList.get(0);
                        toolwholelifecycle.setToolCode(tool.getToolCode());
                        toolwholelifecycle.setToolName(tool.getToolName());
                    }
                    toolwholelifecycle.setKnifeInventoryCode(tt.getKnifeInventoryCode());
                    toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
                    toolwholelifecycle.setCreateTime(new Date());
                    toolwholelifecycle.setUpdateTime(new Date());
                    toolwholelifecycle.setCreateUser(userId);
                    if (gruantUserId != null)
                        toolwholelifecycle.setUpdateUser(gruantUserId);
                    toolwholelifecycle.setVersion(BigDecimal.ZERO);
                    toolwholelifecycle.setToolWholeLifecycleID(UUID.randomUUID().toString());
                    tlcList.add(toolwholelifecycle);
                }
                // 刀具流转
                entity = new Tooltransfer();
                entity.setRfidContainerIDWhere(tt.getRfidContainerID());
                entity.setDelFlagWhere(IConstant.DEL_FLAG_0);
                entity.setKnifeInventoryCodeWhere(tt.getKnifeInventoryCode());
                entity.setBusinessFlowLnkID(businessFlowLnkID);
                entity.setUpdateUser(userId);
                entity.setUpdateTime(new Date());
                entity.setVersion(tt.getVersion().add(BigDecimal.ONE));
                reVal += tooltransferDao.updateNonQuery(entity);

                // 刀具流转履历
                tth = new Tooltransferhistory();
                tth.setToolTransferHistoryID(UUID.randomUUID().toString());
                tth.setRfidContainerID(tt.getRfidContainerID()); // RFID载体ID
                tth.setKnifeInventoryCode(tt.getKnifeInventoryCode());// 刀具入库编码
                tth.setToolID(tt.getToolID());// 刀具ID
                tth.setToolProcuredID(tt.getProcuredBatch());// 采购ID
                tth.setBusinessFlowLnkID(tt.getBusinessFlowLnkID());// 最后执行业务流程
                tth.setToolDurable(tt.getToolDurable());// 耐用度
                tth.setToolSharpennum(tt.getToolDurable());// 可使用(刃磨)次数
                tth.setToolSharpenCriterion(tt.getToolSharpenCriterion());// 复磨标准
                tth.setToolLength(tt.getToolLength());// 刀具长度
                tth.setToolSharpenLength(tt.getToolSharpenLength());// 可刃磨长度
                tth.setUsageCounter(tt.getUsageCounter());// 已使用(刃磨)次数
                tth.setToolGrindingLength(tt.getToolGrindingLength());// 刀具已刃磨长度
                tth.setInstallationState(IConstant.INSTALLATION_STATE_1);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
                tth.setToolState(IConstant.TOOL_STATE_9);// 刀具状态(0断刀1丢失2不合格3借入4申领9其他)
                tth.setoutUser(userId);// 转出人
                if (gruantUserId != null) {
                    tth.setinUser(gruantUserId);// 接收人
                } else {
                    tth.setinUser(userId);
                }
                tth.setStockState(IConstant.STOCK_STATE_1);// 报废
                tth.setUpdateTime(new Date());// 更新时间
                tth.setUpdateUser(gruantUserId);// 更新者
                tth.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
                tth.setCreateTime(new Date());// 创建时间
                tth.setCreateUser(userId);// 创建者
                tth.setVersion(BigDecimal.ZERO);// 版本号
                tthList.add(tth);
            }
            // 增加生命周期
            if (tlcList.size() > 0)
                toolwholelifecycleDao.insertBatchs(tlcList);
            // 批量增加【刀具流转履历】
            if (tthList.size() > 0)
                tooltransferhistoryDao.insertBatchDefined(tthList);

            return reVal;
        } catch (Exception e) {
            return IConstant.RESULT_CODE_1;
        }
    }

    /**
     * 对刀室-->刃磨室 提交数据
     *
     * @param map transferToolMsg 容器中的信息(List<TooltranarMassage>) userId
     *            用户id(String) gruantUserId 授权人id(String) rfidContarnerIdOut
     *            载体Out_id(String) rfidContarnerIdIn 载体In_id(String)
     * @return
     * @throws SQLException
     */
    @Override
    public int saveKnifeToGrindingData(Map<String, Object> map) throws SQLException {
        int reVal = 0;
        Tooltransfer entity = null;
        // 容器中的信息
        List<TooltranarMassage> tooltranarMassages = (List<TooltranarMassage>) map.get("transferToolMsg");
        // 用户id
        String userId = (String) map.get("userId");
        // 授权人id
        String gruantUserId = (String) map.get("gruantUserId");
        // 载体Out_id
        String rfidContarnerIdOut = (String) map.get("rfidContarnerIdOut");
        // 载体In_id
        String rfidContarnerIdIn = (String) map.get("rfidContarnerIdIn");
        // 手持机id
        String handerId = (String) map.get("handerId");

        // 取得业务流程ID
        Business business = new Business();
        business.setBusinessCode("C01S027");
        List<Business> businessList = (List<Business>) businessDao.searchByList(business);
        business = businessList.get(0);
        Businessflowlnk businessflowlnks = new Businessflowlnk();
        businessflowlnks.setBusinessID(business.getBusinessID());
        List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);
        String businessFlowLnkID = list1.get(0).getBusinessFlowLnkID();
        List<Tooltransfer> ttList = new ArrayList<Tooltransfer>();
        for (TooltranarMassage ttm : tooltranarMassages) {
            entity = new Tooltransfer();
            Tooltransfer tooltransfer = new Tooltransfer();
            entity.setToolIDWhere(ttm.getToolId());
            tooltransfer.setRfidContainerID(rfidContarnerIdOut);
            tooltransfer.setToolID(ttm.getToolId());
            tooltransfer.setStaIndex(0);
            tooltransfer.setRowCount(Integer.parseInt(ttm.getGrindingCount()));
            entity.setRfidContainerIDWhere(rfidContarnerIdOut);
            entity.setBusinessFlowLnkID(businessFlowLnkID);
            // 数量
            entity.setRowCount(Integer.parseInt(ttm.getGrindingCount()));
            // 刀具部门(0库存,1对刀室,2刃磨室,3,车间)
            entity.setToolThisState(IConstant.STSATIC_TWO);
            entity.setRfidContainerID(rfidContarnerIdIn);
            // 交接确认人
            entity.setConfirmedUser(gruantUserId);
            // 其他
            entity.setToolState(IConstant.TOOL_STATE_9);
            // 4.流转
            entity.setStockState(IConstant.STOCK_STATE_4);
            entity.setUpdateTime(new Date());
            entity.setUpdateUser(userId);
            ttList.addAll((List<Tooltransfer>) tooltransferDao.searchByList(tooltransfer));
            tooltransferDao.updateDateByToolID(entity);
            reVal++;
        }

        List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory>();
        Tooltransferhistory tth = null;
        List<Toolwholelifecycle> tlcList = new ArrayList<Toolwholelifecycle>();
        Toolwholelifecycle toolwholelifecycle = null;
        for (Tooltransfer tt : ttList) {
            // 记录生命周期
            if (handerId != null) {
                toolwholelifecycle = new Toolwholelifecycle();
                toolwholelifecycle.setBusinessFlowLnkID(businessFlowLnkID);
                toolwholelifecycle.setHandSetID(handerId);
                // 取得刀具信息
                Tool tool = new Tool();
                tool.setToolID(tt.getToolID());
                List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
                if (toolList != null && toolList.size() > 0) {
                    tool = toolList.get(0);
                    toolwholelifecycle.setToolCode(tool.getToolCode());
                    toolwholelifecycle.setToolName(tool.getToolName());
                }
                toolwholelifecycle.setKnifeInventoryCode(tt.getKnifeInventoryCode());
                toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
                toolwholelifecycle.setCreateTime(new Date());
                toolwholelifecycle.setUpdateTime(new Date());
                toolwholelifecycle.setCreateUser(userId);
                if (gruantUserId != null)
                    toolwholelifecycle.setUpdateUser(gruantUserId);
                toolwholelifecycle.setVersion(BigDecimal.ZERO);
                toolwholelifecycle.setToolWholeLifecycleID(UUID.randomUUID().toString());
                tlcList.add(toolwholelifecycle);
            }
            // 刀具流转
            entity = new Tooltransfer();
            entity.setRfidContainerIDWhere(tt.getRfidContainerID());
            entity.setDelFlagWhere(IConstant.DEL_FLAG_0);
            entity.setKnifeInventoryCodeWhere(tt.getKnifeInventoryCode());
            entity.setBusinessFlowLnkID(businessFlowLnkID);
            entity.setUpdateUser(userId);
            entity.setUpdateTime(new Date());
            entity.setVersion(tt.getVersion().add(BigDecimal.ONE));
            reVal += tooltransferDao.updateNonQuery(entity);

            // 刀具流转履历
            tth = new Tooltransferhistory();
            tth.setToolTransferHistoryID(UUID.randomUUID().toString());
            tth.setRfidContainerID(tt.getRfidContainerID()); // RFID载体ID
            tth.setKnifeInventoryCode(tt.getKnifeInventoryCode());// 刀具入库编码
            tth.setToolID(tt.getToolID());// 刀具ID
            tth.setToolProcuredID(tt.getProcuredBatch());// 采购ID
            tth.setBusinessFlowLnkID(tt.getBusinessFlowLnkID());// 最后执行业务流程
            tth.setToolDurable(tt.getToolDurable());// 耐用度
            tth.setToolSharpennum(tt.getToolDurable());// 可使用(刃磨)次数
            tth.setToolSharpenCriterion(tt.getToolSharpenCriterion());// 复磨标准
            tth.setToolLength(tt.getToolLength());// 刀具长度
            tth.setToolSharpenLength(tt.getToolSharpenLength());// 可刃磨长度
            tth.setUsageCounter(tt.getUsageCounter());// 已使用(刃磨)次数
            tth.setToolGrindingLength(tt.getToolGrindingLength());// 刀具已刃磨长度
            tth.setInstallationState(IConstant.INSTALLATION_STATE_1);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
            tth.setToolState(IConstant.TOOL_STATE_9);// 刀具状态(0断刀1丢失2不合格3借入4申领9其他)
            tth.setoutUser(userId);// 转出人
            if (gruantUserId != null) {
                tth.setinUser(gruantUserId);// 接收人
            } else {
                tth.setinUser(userId);
            }
            tth.setStockState(IConstant.STOCK_STATE_1);// 报废
            tth.setUpdateTime(new Date());// 更新时间
            tth.setUpdateUser(gruantUserId);// 更新者
            tth.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
            tth.setCreateTime(new Date());// 创建时间
            tth.setCreateUser(userId);// 创建者
            tth.setVersion(BigDecimal.ZERO);// 版本号
            tthList.add(tth);
        }
        // 增加生命周期
        if (tlcList.size() > 0)
            toolwholelifecycleDao.insertBatchs(tlcList);
        // 批量增加【刀具流转履历】
        if (tthList.size() > 0)
            tooltransferhistoryDao.insertBatchDefined(tthList);
        return reVal;
    }

    /**
     * 提交刀具送回信息
     */
    @Override
    public int saveToolBackInfo(Tooltransfer tt) throws Exception {
        Tool tool = new Tool();
        tool.setToolID(tt.getToolIDWhere());
        Tool t = (Tool) toolDao.searchByPrimaryKey(tool);
        if (IConstant.STRING_2.equals(t.getToolGrinding())) {
            tt.setToolThisState(IConstant.STOCK_STATE_2);
            tt.setToolState(IConstant.STRING_11);
        }
        //查询刀具入库编码
        String knifeInventoryCode = null;
        Tooltransfer entity = new Tooltransfer();
        entity.setRfidContainerID(tt.getRfidContainerIDWhere());
        List<Tooltransfer> ttList2 = (List<Tooltransfer>) tooltransferDao.searchByList(entity);
        List<Toolwholelifecycle> twls = new ArrayList<Toolwholelifecycle>();
        for (Tooltransfer tt2 : ttList2) {
            //建立生命周期
            Toolwholelifecycle twl = new Toolwholelifecycle();
            // 刀具全生命周期id
            twl.setToolWholeLifecycleID(UUIDgen.getId());
            // 刀具入库编码
            twl.setKnifeInventoryCode(tt2.getKnifeInventoryCode());
            // 流程id
            twl.setBusinessFlowLnkID(IConstant.C01S027);
            // 手持机id
            twl.setHandSetID(tt.getExpandSpace1());
            // 刀具id
            twl.setToolID(tt2.getToolID());
            //零部件id
            twl.setPartsID("");
            if (tt2.getProcessAmount() != null) {
                twl.setProcessAmount(tt2.getProcessAmount().toString());
            } else {
                twl.setProcessAmount(IConstant.DEL_FLAG_0);
            }
            //删除区分(0有效1删除)
            twl.setDelFlag(IConstant.DEL_FLAG_0);
            //更新时间
            twl.setUpdateTime(new Date());
            //更新者
            twl.setUpdateUser(tt.getUpdateUser());
            //创建时间
            twl.setCreateTime(new Date());
            //创建者
            twl.setCreateUser(tt.getUpdateUser());
            //刃磨次数
            if (tt2.getUsageCounter()!=null) {
				twl.setVersion(tt2.getUsageCounter());
			}else {
				twl.setVersion(BigDecimal.ZERO);
			}
            twls.add(twl);
        }
        try {
            if (twls.size() > 0) {
                toolwholelifecycleDao.insertBatchs(twls);
            }
            tooltransferDao.updateNonQuery(tt);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public List<Rfidcontainer> getRfidcontainerIDs(Rfidcontainer rfidcontainer) throws SQLException {
        return (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
    }

    @Override
    public List<Tooltransfer> getToolState(Tooltransfer tt) throws Exception {
        return (List<Tooltransfer>) tooltransferDao.searchByList(tt);
    }

    /**
     * 查询流转表信息
     */
    @Override
    public Tooltransfer getTooltransferList(Tooltransfer entity) throws Exception {
        Tooltransfer reEntity = new Tooltransfer();
        List<Tooltransfer> reList = (List<Tooltransfer>) tooltransferDao.searchByList(entity);
        if (reList.size() < 1) {
            // 未找到相应数据
            reEntity.setRetErrFlag(true);
        } else {
            reEntity = reList.get(0);
        }
        return reEntity;
    }

    /**
     * 查询刀具信息
     */
    @Override
    public Tool getToolInfo(Tool entity) throws Exception {
        List<Tool> list = (List<Tool>) toolDao.searchByList(entity);
        if (list == null || list.size() <= 0) {
            // 您所查询的信息不存在!
            Tool tool = new Tool();
            tool.setMessageCode(IConstant.WMSG0122);
            tool.setRetErrFlag(true);
            return tool;
        } else {
            return list.get(0);
        }
    }

}
