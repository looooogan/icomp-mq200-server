package com.icomp.common.service.impl.icomp.v01c01.s021;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s021.ICOMPV01C01S021Service;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.BusinessDao;
import com.icomp.dao.BusinessflowlnkDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.ToolnoticehistoryDao;
import com.icomp.dao.ToolrepairnoticeDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.TooltransferhistoryDao;
import com.icomp.dao.VgettoolcodeandnumberbyidDao;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Businessflowlnk;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Toolnoticehistory;
import com.icomp.entity.base.Toolrepairnotice;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Tooltransferhistory;
import com.icomp.entity.base.Vgettoolcodeandnumberbyid;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 修复通知领取-Service实现类
 *
 * @author Taoyy
 * @ClassName: ICOMPV01C01S021ServiceImpl
 * @date 2014-10-30 上午10:27:10
 */
@SuppressWarnings("unchecked")
public class ICOMPV01C01S021ServiceImpl extends BaseService implements ICOMPV01C01S021Service {
    private static final String UPDATETIME = "UpdateTime"; //排序参数
    // 刀具修复通知
    private ToolrepairnoticeDao toolrepairnoticeDao;

    public void setToolrepairnoticeDao(ToolrepairnoticeDao toolrepairnoticeDao) {
        this.toolrepairnoticeDao = toolrepairnoticeDao;
    }

    // 取得修复刀具编码和数量
    private VgettoolcodeandnumberbyidDao vgettoolcodeandnumberbyidDao;

    public void setVgettoolcodeandnumberbyidDao(VgettoolcodeandnumberbyidDao vgettoolcodeandnumberbyidDao) {
        this.vgettoolcodeandnumberbyidDao = vgettoolcodeandnumberbyidDao;
    }

    // 刀具流转
    private TooltransferDao tooltransferDao;

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    // 刀具流转履历
    private TooltransferhistoryDao tooltransferhistoryDao;

    public void setTooltransferhistoryDao(TooltransferhistoryDao tooltransferhistoryDao) {
        this.tooltransferhistoryDao = tooltransferhistoryDao;
    }

    // 取得当前刀具的最后执行业务流程Dao
    private BusinessflowlnkDao businessflowlnkDao;
    // 取得业务流程Dao
    private BusinessDao businessDao;
    private RfidcontainerDao rfidcontainerDao;

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    public void setBusinessflowlnkDao(BusinessflowlnkDao businessflowlnkDao) {
        this.businessflowlnkDao = businessflowlnkDao;
    }

    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    private ToolnoticehistoryDao toolnoticehistoryDao;

    public void setToolnoticehistoryDao(ToolnoticehistoryDao toolnoticehistoryDao) {
        this.toolnoticehistoryDao = toolnoticehistoryDao;
    }

    /**
     * 取得修复通知单列表
     */
    @Override
    public List<Toolrepairnotice> getToolRepairNoticeList(Toolrepairnotice entity) throws Exception {
        entity.setDelFlag(IConstant.DEL_FLAG_0);
        // entity.setOrderString(UPDATETIME );
        List<Toolrepairnotice> list = new ArrayList<Toolrepairnotice>();
        try {
            // 待收回合成刀具信息
            list = (List<Toolrepairnotice>) toolrepairnoticeDao.searchByListGroupId(entity);
            if (list == null || list.size() <= 0) {
                Toolrepairnotice vedemptionapplied = new Toolrepairnotice();
                vedemptionapplied.setMessageCode(IConstant.WMSG0225);
                vedemptionapplied.setRetErrFlag(true);
                list.add(vedemptionapplied);
            }
        } catch (SQLException e) {
            Toolrepairnotice toolrepairnotice = new Toolrepairnotice();
            toolrepairnotice.setMessageCode(IConstant.EMSG0004);
            toolrepairnotice.setRetErrFlag(true);
            toolrepairnotice.setExceMessage(e.getMessage());
            list.add(toolrepairnotice);
        }
        return list;
    }

    /**
     * 取得修复通知单下的刀具信息
     */
    @Override
    public List<Vgettoolcodeandnumberbyid> getToolList(Vgettoolcodeandnumberbyid entity) throws Exception {
        List<Vgettoolcodeandnumberbyid> list = new ArrayList<Vgettoolcodeandnumberbyid>();
        Vgettoolcodeandnumberbyid vedemptionapplied = null;
        String toolRepairNoticeID = entity.getToolRepairNoticeID();
        Toolrepairnotice toolrepairnotice = new Toolrepairnotice();
        toolrepairnotice.setToolRepairNoticeID(toolRepairNoticeID);//领取单号
        toolrepairnotice.setDelFlag(IConstant.DEL_FLAG_0);
        List<Toolrepairnotice> toolrepairnotices = (List<Toolrepairnotice>) toolrepairnoticeDao.searchByList(toolrepairnotice);
        List<String> rfidlist = new ArrayList<String>();
        if (toolrepairnotices.size() > 0) {
            for (Toolrepairnotice trn : toolrepairnotices) {
                //修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)
                if (IConstant.REPAIR_WAY_3.equals(trn.getRepairWay()) || IConstant.REPAIR_WAY_4.equals(trn.getRepairWay())) {
                    rfidlist.add(getRFIDCode(trn.getRfidCode())); //载体id
                }
            }
        }
        if (rfidlist.size() > 0) {
            List<Rfidcontainer> rfidcontainerList = rfidcontainerDao.searchListByRfids(rfidlist);
            if (rfidcontainerList.size() > 0) {
                for (Rfidcontainer rc : rfidcontainerList) {
                    if ("".equals(rc.getLaserIdentificationCode()) || null == rc.getLaserIdentificationCode()) {
                        vedemptionapplied = new Vgettoolcodeandnumberbyid();
                        vedemptionapplied.setMessageCode(IConstant.WMSG0224_1);
                        vedemptionapplied.setRetErrFlag(true);
                        list.add(vedemptionapplied);
                        return list;
                    }
                }
            }
        }

        try {
            // 取得修复通知单下的刀具信息
            list = (List<Vgettoolcodeandnumberbyid>) vgettoolcodeandnumberbyidDao.searchByList(entity);
            if (list == null || list.size() <= 0) {
                vedemptionapplied = new Vgettoolcodeandnumberbyid();
                vedemptionapplied.setMessageCode(IConstant.WMSG0225);
                vedemptionapplied.setRetErrFlag(true);
                list.add(vedemptionapplied);
            }
        } catch (SQLException e) {
            vedemptionapplied = new Vgettoolcodeandnumberbyid();
            vedemptionapplied.setMessageCode(IConstant.EMSG0004);
            vedemptionapplied.setRetErrFlag(true);
            vedemptionapplied.setExceMessage(e.getMessage());
            list.add(vedemptionapplied);
        }
        return list;
    }

    /**
     * 根据载体ID查找RFIDCode
     *
     * @param rfidContainerID
     * @return
     */
    private String getRFIDCode(String rfidContainerID) throws SQLException {
        Rfidcontainer rfidcontainer = new Rfidcontainer();
        rfidcontainer.setRfidContainerID(rfidContainerID);
        rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
        return ((Rfidcontainer) rfidcontainerDao.searchByList(rfidcontainer).get(0)).getRfidCode();
    }

    /**
     * 保存修复通知单领取
     */
    @Override
    public int saveToolRepairNoticeReceive(Map<String, Object> map) throws Exception {
        int reVal = 0;
        String userId = map.get("userId").toString();
        int number = Integer.parseInt(map.get("number").toString());
        String toolRepairNoticeId = map.get("toolRepairNoticeId").toString();
        String repairWay = null;
        String receiveUser = userId;
        Date receiveTime = new Date();

        // 更新领取单信息
        Toolrepairnotice entity = new Toolrepairnotice();
        List<String> rfidList = new ArrayList<String>(); // RFID——List
        entity.setToolRepairNoticeID(toolRepairNoticeId);
        entity.setDelFlag(IConstant.DEL_FLAG_0);
        List<Toolrepairnotice> toolrepairnotices = (List<Toolrepairnotice>) toolrepairnoticeDao.searchByList(entity);
        // 查询要更新的数据
        for (Toolrepairnotice tn : toolrepairnotices) {
            repairWay = tn.getRepairWay();
            rfidList.add(getRFIDCode(tn.getRfidCode()));
        }
        Map<String, Object> map1 = new HashMap<String, Object>();
        Business business = new Business();
        business.setBusinessCode("C01S021");
        List<Business> businessList = (List<Business>) businessDao.searchByList(business);
        business = businessList.get(0);
        Businessflowlnk businessflowlnks = new Businessflowlnk();
        businessflowlnks.setBusinessID(business.getBusinessID());
        List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);
        // 下一个流程
        String businessFlowLnkID = list1.get(0).getBusinessFlowLnkID();

        /**
         * 添加刀具流转履历
         */
        // 取得要增加的数据
        List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory>();
        Tooltransferhistory tth = null;
        Toolnoticehistory tnh = null;

        List<Tooltransfer> tList = (List<Tooltransfer>) tooltransferDao.searchHalfByList(rfidList);
        for (Tooltransfer tooltransfer : tList) {
            /**
             * 添加刀具流转履历
             */
            tth = new Tooltransferhistory();
            // id
            tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(IConstant.TOOL_TRANSFER_HISTORY, IConstant.TOOL_TRANSFER_HISTORY_ID, userId));
            // RFID载体ID
            tth.setRfidContainerID(tooltransfer.getRfidContainerID());
            // 刀具入库编码
            tth.setKnifeInventoryCode(tooltransfer.getKnifeInventoryCode());
            // 刀具ID
            tth.setToolID(tooltransfer.getToolID());
            // 采购ID
            tth.setToolProcuredID(tooltransfer.getProcuredBatch());
            // 最后执行业务流程(刀具安上)
            tth.setBusinessFlowLnkID(businessFlowLnkID);
            // 耐用度
            tth.setToolDurable(tooltransfer.getToolDurable());
            // 可使用(刃磨)次数
            tth.setToolSharpennum(tooltransfer.getToolDurable());
            // 复磨标准
            tth.setToolSharpenCriterion(tooltransfer.getToolSharpenCriterion());
            // 刀具长度
            tth.setToolLength(tooltransfer.getToolLength());
            // 可刃磨长度
            tth.setToolSharpenLength(tooltransfer.getToolSharpenLength());
            // 已使用(刃磨)次数
            tth.setUsageCounter(tooltransfer.getUsageCounter());
            // 刀具已刃磨长度
            tth.setToolGrindingLength(tooltransfer.getToolGrindingLength());
            // 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
            tth.setInstallationState(IConstant.INSTALLATION_STATE_2);
            tth.setoutUser(tooltransfer.getUpdateUser());//转出人
            tth.setinUser(userId);//接收人
            tth.setUpdateTime(new Date());//更新时间
            tth.setUpdateUser(userId);//更新者
            // 删除区分
            tth.setDelFlag(IConstant.DEL_FLAG_0);
            // 创建时间
            tth.setCreateTime(new Date());
            // 创建者
            tth.setCreateUser(userId);
            // 版本号
            tth.setVersion(BigDecimal.ZERO);
            tthList.add(tth);

            tnh = new Toolnoticehistory();
            tnh.setKnifeInventoryCode(tooltransfer.getKnifeInventoryCode());// 刀具入库编码
            tnh.setNoticeTime(new Date()); //刃磨时间
            tnh.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分(0有效1删除)
            tnh.setCreateUser(userId);//创建人
            tnh.setReceiveUser(receiveUser);//领取人
            tnh.setReceiveTime(receiveTime);//领取时间
            tnh.setRepairWay(repairWay);      //修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)
            tnh.setRepairedBecause(IConstant.REPAIRED_BECAUSE_1); //修复原因(0断刀1正常刃磨)
            tnh.setCreateTime(new Date());//创建时间
            tnh.setUpdateTime(new Date());// 更新时间
            tnh.setUpdateUser(userId);// 更新者
            tnh.setVersion(BigDecimal.ZERO);//版本号
            toolnoticehistoryDao.insert(tnh);
        }
        // 添加刀具流转履历
        if (tthList.size() > 0)
            tooltransferhistoryDao.insertBatchDefined(tthList);
        // 批量更新刀具流转为被修复通知领取状态
        map1.put("businessFlowLnkID", businessFlowLnkID);
        map1.put("installationState", IConstant.INSTALLATION_STATE_2);
        map1.put("userId", userId);
        map1.put("list", rfidList);
        if (rfidList.size() > 0)
            tooltransferDao.updateBatchByRfid(map1);

        for (Toolrepairnotice trn : toolrepairnotices) {
            //更新修复通知
            entity = new Toolrepairnotice();
            entity.setToolRepairNoticeIDWhere(toolRepairNoticeId);// 修复通知流水号
            entity.setSentBackNumber(new BigDecimal(number));// 应送回数量
            entity.setReceiveUser(userId);//领取人
            entity.setReceiveTime(new Date());//领取时间
            entity.setUpdateTime(new Date());// 更新时间
            entity.setUpdateUser(userId);// 更新者
            entity.setVersion(trn.getVersion().add(BigDecimal.ONE));// 版本号
            reVal += toolrepairnoticeDao.updateNonQuery(entity);

            //更新厂外修复的刀具
            if (IConstant.REPAIR_WAY_4.equals(trn.getRepairWay()) || IConstant.REPAIR_WAY_3.equals(trn.getRepairWay())) {
                Rfidcontainer rfidcontainer = new Rfidcontainer();
                rfidcontainer.setRfidCodeWhere(getRFIDCode(trn.getRfidCode()));
                rfidcontainer.setDelFlagWhere(IConstant.DEL_FLAG_0);
                rfidcontainer.setRfidCode("way" + toolRepairNoticeId);
                rfidcontainerDao.updateNonQuery(rfidcontainer);
            }

        }
        return reVal;
    }

}
