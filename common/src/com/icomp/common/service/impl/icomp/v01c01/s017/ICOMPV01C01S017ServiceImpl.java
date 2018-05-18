package com.icomp.common.service.impl.icomp.v01c01.s017;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s017.ICOMPV01C01S017Service;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.BusinessDao;
import com.icomp.dao.BusinessflowlnkDao;
import com.icomp.dao.MachiningexperienceDao;
import com.icomp.dao.NoticeequipmentDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.ToolDao;
import com.icomp.dao.ToolnoticehistoryDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.TooltransferhistoryDao;
import com.icomp.dao.ToolwholelifecycleDao;
import com.icomp.dao.VgrindingtoolmsgDao;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Businessflowlnk;
import com.icomp.entity.base.Noticeequipment;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Toolnoticehistory;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Tooltransferhistory;
import com.icomp.entity.base.Toolwholelifecycle;
import com.icomp.entity.base.Vgrindingtoolmsg;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 刀具复磨卸下-Service实体类
 *
 * @author Taoyy
 * @ClassName: ICOMPV01C01S017ServiceImpl
 * @date 2014-10-16 下午02:49:31
 */
@SuppressWarnings("unchecked")
public class ICOMPV01C01S017ServiceImpl extends BaseService implements ICOMPV01C01S017Service {
    //刃磨中设备Dao
    private NoticeequipmentDao noticeequipmentDao;

    public void setNoticeequipmentDao(NoticeequipmentDao noticeequipmentDao) {
        this.noticeequipmentDao = noticeequipmentDao;
    }

    //取得刃磨设备中刀具信息Dao
    private VgrindingtoolmsgDao vgrindingtoolmsgDao;

    public void setVgrindingtoolmsgDao(VgrindingtoolmsgDao vgrindingtoolmsgDao) {
        this.vgrindingtoolmsgDao = vgrindingtoolmsgDao;
    }

    // 业务-流程中间表Dao
    private BusinessflowlnkDao businessflowlnkDao;

    public void setBusinessflowlnkDao(BusinessflowlnkDao businessflowlnkDao) {
        this.businessflowlnkDao = businessflowlnkDao;
    }

    //刀具流转Dao
    private TooltransferDao tooltransferDao;

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    // 取得业务流程Dao
    private BusinessDao businessDao;

    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    // 刀具流转履历Dao
    private TooltransferhistoryDao tooltransferhistoryDao;

    public void setTooltransferhistoryDao(TooltransferhistoryDao tooltransferhistoryDao) {
        this.tooltransferhistoryDao = tooltransferhistoryDao;
    }

    // 刀具参数Dao
    private ToolDao toolDao;
    // 生命周期Dao
    private ToolwholelifecycleDao toolwholelifecycleDao;

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    public void setToolwholelifecycleDao(ToolwholelifecycleDao toolwholelifecycleDao) {
        this.toolwholelifecycleDao = toolwholelifecycleDao;
    }

    //刃磨安上
    private MachiningexperienceDao machiningexperienceDao;

    public void setMachiningexperienceDao(MachiningexperienceDao machiningexperienceDao) {
        this.machiningexperienceDao = machiningexperienceDao;
    }

    //刃磨修复记录
    private ToolnoticehistoryDao toolnoticehistoryDao;
    private RfidcontainerDao rfidcontainerDao;

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    public void setToolnoticehistoryDao(ToolnoticehistoryDao toolnoticehistoryDao) {
        this.toolnoticehistoryDao = toolnoticehistoryDao;
    }

    /**
     * 取得刃磨中设备列表
     * getNoticeEquipmentList
     *
     * @param entity
     * @return
     * @throws Exception
     */
    @Override
    public List<Noticeequipment> getNoticeEquipmentList(Noticeequipment entity) throws Exception {
        List<Noticeequipment> list = new ArrayList<Noticeequipment>();
        try {
            //取得刃磨中设备列表
            list = (List<Noticeequipment>) noticeequipmentDao.searchByList(entity);
            if (list == null || list.size() <= 0) {
                //刃磨中设备未找到相应数据!
                Noticeequipment noticeequipment = new Noticeequipment();
                noticeequipment.setMessageCode(IConstant.WMSG0139);
                noticeequipment.setRetErrFlag(true);
                list.add(noticeequipment);
            }
        } catch (SQLException e) {
            //数据库操作异常，查询失败!
            list = new ArrayList<Noticeequipment>();
            Noticeequipment noticeequipment = new Noticeequipment();
            noticeequipment.setMessageCode(IConstant.EMSG0004);
            noticeequipment.setRetErrFlag(true);
            noticeequipment.setExceMessage(e.getMessage());
            list.add(noticeequipment);
        }
        return list;
    }

    /**
     * 取得刃磨设备中刀具信息
     * getNoticeToolInfo
     *
     * @param entity
     * @return
     * @throws Exception
     */
    @Override
    public Vgrindingtoolmsg getNoticeToolInfo(Vgrindingtoolmsg entity) throws Exception {
        Vgrindingtoolmsg vgrindingtoolmsg = new Vgrindingtoolmsg();
        try {
            //取得刃磨设备中刀具信息
            List<Vgrindingtoolmsg> list = (List<Vgrindingtoolmsg>) vgrindingtoolmsgDao.searchByList(entity);
            if (list == null || list.size() == 0) {
                //刃磨设备中刀具未找到相应数据!
                vgrindingtoolmsg.setMessageCode(IConstant.WMSG0140);
                vgrindingtoolmsg.setRetErrFlag(true);
            } else {
                //检索成功
                vgrindingtoolmsg.setMessageCode(IConstant.IMSG0001);
                vgrindingtoolmsg.setRetErrFlag(false);
                vgrindingtoolmsg = list.get(0);
            }
        } catch (SQLException e) {
            //数据库操作异常，查询失败!
            vgrindingtoolmsg.setMessageCode(IConstant.EMSG0004);
            vgrindingtoolmsg.setRetErrFlag(true);
            vgrindingtoolmsg.setExceMessage(e.getMessage());
        }
        return vgrindingtoolmsg;
    }

    /**
     * 卸下刃磨中刀具
     * saveNoticeTool
     *
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public int saveNoticeTool(Map<String, Object> map) throws Exception {
        int reUpdateCount = 0;// 返回值
        // 设备id
        String noticeEquipmentID = map.get("noticeEquipmentID").toString();
        // RfidCode
        String rfidCode = map.get("KnifeInventoryCode").toString();
        // 最后测量长度
        double noticeOldLength = map.get("NoticeOldLength") == null ? 0 : Double.parseDouble(map.get("NoticeOldLength").toString());
        // 用户ID
        String userID = map.get("userID").toString();
        // 手持机ID
        String handsetID = map.get("handsetID").toString();

        //取得当前系统流程ID
        Business business = new Business();
        business.setBusinessCode("C01S017");
        List<Business> businessList = (List<Business>) businessDao.searchByList(business);
        business = businessList.get(0);
        Businessflowlnk businessflowlnks = new Businessflowlnk();
        businessflowlnks.setBusinessID(business.getBusinessID());
        List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);
        // 流程ID
        String businessFlowLnkID = list1.get(0).getBusinessFlowLnkID();

        Rfidcontainer rfidcontainer = new Rfidcontainer();
        rfidcontainer.setRfidCode(rfidCode);
        rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
        List<Rfidcontainer> rfidList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
        if (rfidList.size() < 1)
            return reUpdateCount;
        //取得刀具流转
        Tooltransfer tt1 = new Tooltransfer();
        tt1.setRfidContainerID(rfidList.get(0).getRfidContainerID());
        tt1.setDelFlag(IConstant.DEL_FLAG_0);
        //取得流转中数据
        List<Tooltransfer> ttList = (List<Tooltransfer>) tooltransferDao.searchByList(tt1);
        //不能刃磨长度
        double staticLength = 0;
        for (Tooltransfer tt : ttList) {
            //记录刀具生命周期
            Toolwholelifecycle toolwholelifecycle = new Toolwholelifecycle();
            toolwholelifecycle.setBusinessFlowLnkID(businessFlowLnkID);
            toolwholelifecycle.setHandSetID(handsetID);
            // 取得刀具信息
            Tool tool = new Tool();
            tool.setToolID(tt.getToolID());
            List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
            if (toolList != null) {
                tool = toolList.get(0);
                if (IConstant.STRING_0.equals(tool.getToolType())) {
                    // 不能刃磨长度 = 总长度 - 总刃磨长度
                    staticLength = tool.getToolLength().doubleValue() - tool.getToolSharpenLength().doubleValue();
                }
                toolwholelifecycle.setToolCode(tool.getToolCode());
                toolwholelifecycle.setToolName(tool.getToolName());
            }
            toolwholelifecycle.setKnifeInventoryCode(tt.getKnifeInventoryCode());
            toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
            toolwholelifecycle.setCreateTime(new Date());
            toolwholelifecycle.setUpdateTime(new Date());
            toolwholelifecycle.setCreateUser(userID);
            toolwholelifecycle.setUpdateUser(userID);
            toolwholelifecycle.setVersion(BigDecimal.ZERO);
            String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue(IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, userID);
            toolwholelifecycle.setToolWholeLifecycleID(toolWholeLifecycleID);
            toolwholelifecycleDao.insert(toolwholelifecycle);

            //取得修复前测量长度
            Toolnoticehistory tnh = new Toolnoticehistory();
            tnh.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分(0有效1删除)
            tnh.setKnifeInventoryCode(tt.getKnifeInventoryCode());// 刀具入库编码
            List<Toolnoticehistory> tnhList = (List<Toolnoticehistory>) toolnoticehistoryDao.searchByList(tnh);
            double noticeProLength = 0;
            if (tnhList.size() < 1) {
                throw new SQLException();
            }
            //修复前测量长度
     //       noticeProLength = tnhList.get(0).getNoticeLength().doubleValue();

            //记录刀具修复履历
            tnh = tnhList.get(0);
            tnh.setKnifeInventoryCodeWhere(tnh.getKnifeInventoryCode());
            tnh.setNoticeTimeWhere(tnh.getNoticeTime());
            tnh.setNoticeOldLength(new BigDecimal(noticeOldLength));
            tnh.setUpdateTime(new Date());
            tnh.setUpdateUser(userID);
            tnh.setVersion(tnh.getVersion().add(BigDecimal.ONE));
            reUpdateCount += toolnoticehistoryDao.updateNonQuery(tnh);

            // 更新流转表
            Tooltransfer updateTooltransfer = new Tooltransfer();
            updateTooltransfer.setRfidContainerIDWhere(tt.getRfidContainerID());
            updateTooltransfer.setKnifeInventoryCodeWhere(tt.getKnifeInventoryCode());

            updateTooltransfer.setBusinessFlowLnkID(businessFlowLnkID);
            if (tt.getUsageCounter() == null) {
                tt.setUsageCounter(BigDecimal.ZERO);
            }
            updateTooltransfer.setUsageCounter(tt.getUsageCounter().add(BigDecimal.ONE));//已使用(刃磨)次数
            //已刃磨长度 =刀具长度-最后测量长度
            updateTooltransfer.setToolGrindingLength(tt.getToolLength().subtract(new BigDecimal(noticeOldLength)));
            //可刃磨长度= 最后测量长度-不可刃磨长度
            updateTooltransfer.setToolSharpenLength(new BigDecimal(noticeOldLength - staticLength));
            if ((tt.getToolSharpennum().subtract(BigDecimal.ONE)).intValue() <= 0) {
            	updateTooltransfer.setToolSharpennum(BigDecimal.ZERO); //可使用(刃磨)次数
            } else {
            	if (IConstant.STRING_0.equals(tool.getToolConsumetype())) {
					updateTooltransfer.setToolSharpennum(updateTooltransfer.getToolSharpenLength().divide(tt.getToolSharpenCriterion()));
				}
            	else if (IConstant.STRING_1.equals(tool.getToolConsumetype())) {
            		updateTooltransfer.setToolSharpennum(tt.getToolSharpennum().subtract(BigDecimal.ONE));
				}
            }
            updateTooltransfer.setStockState(IConstant.STOCK_STATE_4);
            updateTooltransfer.setUpdateTime(new Date());// 更新时间
            updateTooltransfer.setUpdateUser(userID);// 更新者
            updateTooltransfer.setVersion(tt.getVersion().add(BigDecimal.ONE));// 版本号
            reUpdateCount += tooltransferDao.updateNonQuery(updateTooltransfer);

            //记录刀具流转履历
            Tooltransferhistory tth = new Tooltransferhistory();
            tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(IConstant.TOOLTRANSFERHISTORY, IConstant.TOOLTRANSFERHISTORYID, userID));
            tth.setRfidContainerID(tt.getRfidContainerID()); // RFID载体ID
            tth.setKnifeInventoryCode(tt.getKnifeInventoryCode());// 刀具入库编码
            tth.setToolID(tt.getToolID());// 刀具ID
            tth.setToolProcuredID(tt.getProcuredBatch());// 采购ID
            tth.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程(刀具安上)
            tth.setToolDurable(tt.getToolDurable());// 耐用度
            tth.setToolSharpennum(updateTooltransfer.getToolDurable());// 可使用(刃磨)次数
            tth.setToolSharpenCriterion(tt.getToolSharpenCriterion());// 复磨标准
            tth.setToolLength(tt.getToolLength());// 刀具长度
            tth.setToolSharpenLength(updateTooltransfer.getToolSharpenLength());// 可刃磨长度
            tth.setUsageCounter(updateTooltransfer.getUsageCounter());// 已使用(刃磨)次数
            tth.setToolGrindingLength(updateTooltransfer.getToolGrindingLength());// 刀具已刃磨长度
            tth.setInstallationState(tt.getInstallationState());// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
            tth.setStockState(IConstant.STOCK_STATE_4);
            tth.setoutUser(tt.getUpdateUser());// 转出人
            tth.setinUser(userID);// 接收人
            tth.setUpdateTime(new Date());// 更新时间
            tth.setUpdateUser(userID);// 更新者
            tth.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
            tth.setCreateTime(new Date());// 创建时间
            tth.setCreateUser(userID);// 创建者
            tth.setVersion(BigDecimal.ZERO);// 版本号
            tooltransferhistoryDao.insert(tth);
        }

        //更新刃磨设备数据
        Noticeequipment noticeequipment = new Noticeequipment();
        noticeequipment.setNoticeEquipmentID(noticeEquipmentID);
        noticeequipment = (Noticeequipment) noticeequipmentDao.searchByPrimaryKey(noticeequipment);
        noticeequipment.setKnifeInventoryCode(null);
        noticeequipment.setNoticeEquipmentIDWhere(noticeEquipmentID);
        reUpdateCount += noticeequipmentDao.update(noticeequipment);
        return reUpdateCount;
    }
}
