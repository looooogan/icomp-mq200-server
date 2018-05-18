package com.icomp.common.service.impl.icomp.v01c01.s018;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s018.ICOMPV01C01S018Service;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.common.utils.UUIDgen;
import com.icomp.dao.BusinessDao;
import com.icomp.dao.BusinessflowlnkDao;
import com.icomp.dao.MachiningexperienceDao;
import com.icomp.dao.NoticeequipmentDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.SynthesistoolsmachiningDao;
import com.icomp.dao.ToolDao;
import com.icomp.dao.ToolnoticehistoryDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.TooltransferhistoryDao;
import com.icomp.dao.ToolwholelifecycleDao;
import com.icomp.dao.VgetgrindingonmsgDao;
import com.icomp.dao.VgetnoticeequipmentlistDao;
import com.icomp.dao.VgettoolinfolistDao;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Businessflowlnk;
import com.icomp.entity.base.Machiningexperience;
import com.icomp.entity.base.Noticeequipment;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Toolnoticehistory;
import com.icomp.entity.base.TooltranarMassage;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Tooltransferhistory;
import com.icomp.entity.base.Toolwholelifecycle;
import com.icomp.entity.base.Vgetgrindingonmsg;
import com.icomp.entity.base.Vgetnoticeequipmentlist;
import com.icomp.entity.base.Vgettoolinfolist;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 回库刀具处理-Service实现类
 *
 * @author Taoyy
 * @ClassName: ICOMPV01C01S018ServiceImpl
 * @date 2014-10-15 下午02:38:56
 */
public class ICOMPV01C01S018ServiceImpl extends BaseService implements ICOMPV01C01S018Service {
    // 取得刀具复磨按上信息Dao
    private VgetgrindingonmsgDao vgetgrindingonmsgDao;

    public void setVgetgrindingonmsgDao(VgetgrindingonmsgDao vgetgrindingonmsgDao) {
        this.vgetgrindingonmsgDao = vgetgrindingonmsgDao;
    }

    public void setVgetnoticeequipmentlistDao(VgetnoticeequipmentlistDao vgetnoticeequipmentlistDao) {
        this.vgetnoticeequipmentlistDao = vgetnoticeequipmentlistDao;
    }

    public void setVgettoolinfolistDao(VgettoolinfolistDao vgettoolinfolistDao) {
        this.vgettoolinfolistDao = vgettoolinfolistDao;
    }

    private VgetnoticeequipmentlistDao vgetnoticeequipmentlistDao;
    private VgettoolinfolistDao vgettoolinfolistDao;
    // 取得刃磨设备列表Dao
    private NoticeequipmentDao noticeequipmentDao;

    public void setNoticeequipmentDao(NoticeequipmentDao noticeequipmentDao) {
        this.noticeequipmentDao = noticeequipmentDao;
    }

    // 刀具修复履历Dao
    private ToolnoticehistoryDao toolnoticehistoryDao;

    public void setToolnoticehistoryDao(ToolnoticehistoryDao toolnoticehistoryDao) {
        this.toolnoticehistoryDao = toolnoticehistoryDao;
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

    // 刀具流转履历Dao
    private TooltransferhistoryDao tooltransferhistoryDao;

    public void setTooltransferhistoryDao(TooltransferhistoryDao tooltransferhistoryDao) {
        this.tooltransferhistoryDao = tooltransferhistoryDao;
    }

    private SynthesistoolsmachiningDao synthesistoolsmachiningDao;

    public void setSynthesistoolsmachiningDao(SynthesistoolsmachiningDao synthesistoolsmachiningDao) {
        this.synthesistoolsmachiningDao = synthesistoolsmachiningDao;
    }

    // 取得业务流程Dao
    private BusinessDao businessDao;

    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    private RfidcontainerDao rfidcontainerDao;

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
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

    private MachiningexperienceDao machiningexperienceDao;

    public void setMachiningexperienceDao(MachiningexperienceDao machiningexperienceDao) {
        this.machiningexperienceDao = machiningexperienceDao;
    }

    /**
     * 取得刀具复磨按上信息
     * getToolInfo
     *
     * @param entity
     * @return
     * @throws Exception
     */
    @Override
    public List<Vgetgrindingonmsg> getToolInfo(Vgetgrindingonmsg entity) throws Exception {
        List<Vgetgrindingonmsg> list = new ArrayList<Vgetgrindingonmsg> ();
        try {
            Map<String, Object> map = new HashMap<String, Object> ();
            map.put ( "rfidString", entity.getRfidCode () );
            // 取得待换领刀具信息列表
            list = (List<Vgetgrindingonmsg>) vgetgrindingonmsgDao.searchByToolList ( map );
            if (list == null || list.size () <= 0) {
                // 刀具复磨安上未找到相应数据!
                Vgetgrindingonmsg vgetgrindingonmsg = new Vgetgrindingonmsg ();
                vgetgrindingonmsg.setMessageCode ( IConstant.WMSG0141 );
                vgetgrindingonmsg.setRetErrFlag ( true );
                list.add ( vgetgrindingonmsg );
            }
        } catch (SQLException e) {
            // 数据库操作异常，查询失败!
            list = new ArrayList<Vgetgrindingonmsg> ();
            Vgetgrindingonmsg vgetgrindingonmsg = new Vgetgrindingonmsg ();
            vgetgrindingonmsg.setMessageCode ( IConstant.EMSG0004 );
            vgetgrindingonmsg.setRetErrFlag ( true );
            vgetgrindingonmsg.setExceMessage ( e.getMessage () );
            list.add ( vgetgrindingonmsg );
        }
        return list;
    }

    /**
     * 取得刃磨设备列表
     * searchByList
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Noticeequipment> searchByList(Noticeequipment entity) throws Exception {
        List<Noticeequipment> list = new ArrayList<Noticeequipment> ();
        try {
            // 取得待换领刀具信息列表
            list = (List<Noticeequipment>) noticeequipmentDao.searchByList ( entity );
            if (list == null || list.size () <= 0) {
                // 刃磨设备未找到相应数据!
                Noticeequipment noticeequipment = new Noticeequipment ();
                noticeequipment.setMessageCode ( IConstant.WMSG0142 );
                noticeequipment.setRetErrFlag ( true );
                list.add ( noticeequipment );
            }
        } catch (SQLException e) {
            // 数据库操作异常，查询失败!
            list = new ArrayList<Noticeequipment> ();
            Noticeequipment noticeequipment = new Noticeequipment ();
            noticeequipment.setMessageCode ( IConstant.EMSG0004 );
            noticeequipment.setRetErrFlag ( true );
            noticeequipment.setExceMessage ( e.getMessage () );
            list.add ( noticeequipment );
        }
        return list;
    }

    /**
     * 复磨刀具安上保存
     * toolScrapConfirmation
     *
     * @param map
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @Override
    public int toolScrapConfirmation(Map<String, Object> map) throws Exception {
        //
        /*
            1. 刀具复磨安上报废流程
                   刀片: 报废后输入要数量 放在一个盒子中 (无限大)
            2. 刃磨设备中记录的不是刀具入库编码 现在换成RFID
                这样可以管理进行简单
         */

        int reUpdateCount = 0;// 返回值
        String RFID = map.get ( "RFID" ).toString ();// 刀具入库编码
        String customerId = map.get ( "CustomerID" ).toString ();// 用户id
        String noticeLength = map.get ( "NoticeLength" ).toString ();// 修复前测量长度
        String noticeEquipmentID = map.get ( "NoticeEquipmentID" ).toString ();// 刃磨设备ID
        String handId = map.get ( "HandSetId" ).toString ();
        double upCeLiangLength = 0;//上一次测量后长度
        double toolLength = 0;

        Noticeequipment nqm = new Noticeequipment ();
        nqm.setNoticeEquipmentID ( noticeEquipmentID );
        nqm.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Noticeequipment> noticeequipments = (List<Noticeequipment>) noticeequipmentDao.searchByList ( nqm );
        if (noticeequipments.size () < 1) {
            return reUpdateCount;
        }
        String RfidConmainerIsNull = noticeequipments.get ( 0 ).getKnifeInventoryCode ();
        if (RfidConmainerIsNull != null && !"".equals ( RfidConmainerIsNull )) {
            return -1;
        }
        // 取得业务流程ID
        Business business = new Business ();
        business.setBusinessCode ( "C01S018" );
        List<Business> businessList = (List<Business>) businessDao.searchByList ( business );
        business = businessList.get ( 0 );
        Businessflowlnk businessflowlnks = new Businessflowlnk ();
        businessflowlnks.setBusinessID ( business.getBusinessID () );
        List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList ( businessflowlnks );
        // 下一个流程
        String businessFlowLnkID = list1.get ( 0 ).getBusinessFlowLnkID ();

        Rfidcontainer rfidcontainer = new Rfidcontainer ();
        rfidcontainer.setRfidCode ( RFID );
        rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Rfidcontainer> rfidcontainerList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
        //刀具流转
        Tooltransfer tooltransfer = new Tooltransfer ();
        tooltransfer.setRfidContainerID ( rfidcontainerList.get ( 0 ).getRfidContainerID () );
        tooltransfer.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Tooltransfer> ttList = (List<Tooltransfer>) tooltransferDao.searchByList ( tooltransfer );
        for (Tooltransfer tt : ttList) {
            //更新刀具修复履历
            Toolnoticehistory tnh = new Toolnoticehistory ();
            tnh.setDelFlag ( IConstant.DEL_FLAG_0 );
            tnh.setKnifeInventoryCode ( tt.getKnifeInventoryCode () );
            tnh.setOrderString ( "UpdateTime DESC" );
            List<Toolnoticehistory> thList = (List<Toolnoticehistory>) toolnoticehistoryDao.searchByList ( tnh );
            if (thList.size () > 0 && thList.get ( 0 ).getNoticeLength () != null) {
                //上一次测量后长度
                upCeLiangLength = thList.get ( 0 ).getNoticeLength ().doubleValue ();
            }
            tnh = new Toolnoticehistory ();
            tnh.setKnifeInventoryCodeWhere ( tt.getKnifeInventoryCode () );// 刀具入库编码
            tnh.setDelFlagWhere ( IConstant.DEL_FLAG_0 );// 删除区分(0有效1删除)
            tnh.setNoticeTime ( new Date () );// 修复时间
            tnh.setToolRepairNoticeUser ( customerId );// 操作人
            tnh.setNoticeLength ( new BigDecimal ( noticeLength ) );// 修复前测量长度
            tnh.setUpdateTime ( new Date () );// 更新时间
            tnh.setUpdateUser ( customerId );// 更新者
            reUpdateCount += toolnoticehistoryDao.updateProNotece ( tnh );
            // 记录生命周期
            Toolwholelifecycle toolwholelifecycle = new Toolwholelifecycle ();
            toolwholelifecycle.setBusinessFlowLnkID ( businessFlowLnkID );
            toolwholelifecycle.setHandSetID ( handId );
            // 取得刀具信息
            Tool tool = new Tool ();
            tool.setToolID ( tt.getToolID () );
            List<Tool> toolList = (List<Tool>) toolDao.searchByList ( tool );
            if (toolList != null) {
                tool = toolList.get ( 0 );
                toolLength = tool.getToolLength ().doubleValue ();
                toolwholelifecycle.setToolCode ( tool.getToolCode () );
                toolwholelifecycle.setToolName ( tool.getToolName () );
            }
            toolwholelifecycle.setKnifeInventoryCode ( tt.getKnifeInventoryCode () );
            toolwholelifecycle.setDelFlag ( IConstant.DEL_FLAG_0 );
            toolwholelifecycle.setCreateTime ( new Date () );
            toolwholelifecycle.setUpdateTime ( new Date () );
            toolwholelifecycle.setCreateUser ( customerId );
            toolwholelifecycle.setUpdateUser ( customerId );
            toolwholelifecycle.setVersion ( BigDecimal.ZERO );
            String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue ( IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, customerId );
            toolwholelifecycle.setToolWholeLifecycleID ( toolWholeLifecycleID );
            toolwholelifecycleDao.insert ( toolwholelifecycle );
            // 更新流转表
            Tooltransfer updateTooltransfer = new Tooltransfer ();
            updateTooltransfer.setRfidContainerIDWhere ( tt.getRfidContainerID () );
            updateTooltransfer.setKnifeInventoryCodeWhere ( tt.getKnifeInventoryCode () );
            updateTooltransfer.setBusinessFlowLnkID ( businessFlowLnkID );
            updateTooltransfer.setStockState ( IConstant.STOCK_STATE_4 );
            updateTooltransfer.setUpdateTime ( new Date () );// 更新时间
            updateTooltransfer.setUpdateUser ( customerId );// 更新者
            updateTooltransfer.setVersion ( tt.getVersion ().add ( BigDecimal.ONE ) );// 版本号
            tooltransferDao.updateNonQuery ( updateTooltransfer );
            //添加流转履历表
            Tooltransferhistory tth = new Tooltransferhistory ();
            tth.setToolTransferHistoryID ( NextKeyValue.getNextkeyvalue ( IConstant.TOOLTRANSFERHISTORY, IConstant.TOOLTRANSFERHISTORYID, customerId ) );
            tth.setRfidContainerID ( tt.getRfidContainerID () ); // RFID载体ID
            tth.setKnifeInventoryCode ( tt.getKnifeInventoryCode () );// 刀具入库编码
            tth.setToolID ( tt.getToolID () );// 刀具ID
            tth.setToolProcuredID ( tt.getProcuredBatch () );// 采购ID
            tth.setBusinessFlowLnkID ( tt.getBusinessFlowLnkID () );// 最后执行业务流程(刀具安上)
            tth.setToolDurable ( tt.getToolDurable () );// 耐用度
            tth.setToolSharpennum ( tt.getToolDurable () );// 可使用(刃磨)次数
            tth.setToolSharpenCriterion ( tt.getToolSharpenCriterion () );// 复磨标准
            tth.setToolLength ( tt.getToolLength () );// 刀具长度
            tth.setToolSharpenLength ( tt.getToolSharpenLength () );// 可刃磨长度
            tth.setUsageCounter ( tt.getUsageCounter () );// 已使用(刃磨)次数
            tth.setToolGrindingLength ( tt.getToolGrindingLength () );// 刀具已刃磨长度
            tth.setInstallationState ( tt.getInstallationState () );// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
            tth.setStockState ( IConstant.STOCK_STATE_4 );
            tth.setoutUser ( tt.getUpdateUser () );// 转出人
            tth.setinUser ( customerId );// 接收人
            tth.setUpdateTime ( new Date () );// 更新时间
            tth.setUpdateUser ( customerId );// 更新者
            tth.setDelFlag ( IConstant.DEL_FLAG_0 );// 删除区分
            tth.setCreateTime ( new Date () );// 创建时间
            tth.setCreateUser ( customerId );// 创建者
            tth.setVersion ( BigDecimal.ZERO );// 版本号
            tooltransferhistoryDao.insert ( tth );

            //记录刀具磨损(加工履历表)
            Machiningexperience machiningexperience = new Machiningexperience ();
            machiningexperience.setKnifeInventoryCode ( tt.getKnifeInventoryCode () );
            machiningexperience.setOrderString ( "UpdateTime desc" );
            List<Machiningexperience> machiningexperienceList = (List<Machiningexperience>) machiningexperienceDao.searchByList ( machiningexperience );
            if (machiningexperienceList != null && machiningexperienceList.size () > 1) {
                machiningexperience = machiningexperienceList.get ( 0 );
                Machiningexperience updatemachin = new Machiningexperience ();
                updatemachin.setSynthesisParametersCodeWhere ( machiningexperience.getSynthesisParametersCodeWhere () );
                updatemachin.setSynthesisParametersNumberWhere ( machiningexperience.getSynthesisParametersNumberWhere () );
                updatemachin.setSynthesisNumberWhere ( machiningexperience.getSynthesisNumber () );
                updatemachin.setSynthesisCutterNumberWhere ( machiningexperience.getSynthesisCutterNumberWhere () );
                if (upCeLiangLength <= 0) {
                    upCeLiangLength = toolLength;
                }
                //刀具磨损 = 前刀具磨损 + （上一次测量后长度 -当前测量前长度）
                updatemachin.setToolWastage ( machiningexperience.getToolWastage ().add ( new BigDecimal ( upCeLiangLength ).subtract ( new BigDecimal ( noticeLength ) ) ) );
                reUpdateCount += machiningexperienceDao.updateNonQuery ( updatemachin );
            }
        }
        // 更新刃磨设备
        Noticeequipment ne = new Noticeequipment ();
        ne.setNoticeEquipmentIDWhere ( noticeEquipmentID );// 条件
        ne.setKnifeInventoryCode ( RFID );
        reUpdateCount += noticeequipmentDao.updateNonQuery ( ne );
        return reUpdateCount;
    }

    /**
     * 取得刀具长度和不可刃磨长度
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Tool> getToolLength(Tooltransfer entity) throws Exception {
        String knifeInventoryCode = entity.getKnifeInventoryCode ();
        Tooltransfer tooltransfer1 = new Tooltransfer ();
        tooltransfer1.setKnifeInventoryCode ( knifeInventoryCode );
        tooltransfer1.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Tooltransfer> ttList1 = (List<Tooltransfer>) tooltransferDao.searchByList ( tooltransfer1 );
        if (ttList1.size () < 1) {
            throw new Exception ();
        }
        Tool t1 = new Tool ();
        t1.setToolID ( ttList1.get ( 0 ).getToolID () );
        t1.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Tool> tList1 = (List<Tool>) toolDao.searchByList ( t1 );
        if (tList1.size () < 1) {
            throw new Exception ();
        }
        return tList1;
    }

    @Override
    public int updateNoticeequipment(Map<String, Object> map) throws Exception {
        int reUpdateCount = 0;
        String noticeEquipmentID = map.get ( "noticeEquipmentID" ).toString ();
        String businessCode = map.get ( "BusinessCode" ).toString ();//流程名
        String userID = map.get ( "CustomerID" ).toString ();//用户ID
        String handsetID = map.get ( "HandSetId" ).toString ();
        String rfidString = null;//rfid
        //更新刃磨设备数据
        Noticeequipment noticeequipment = new Noticeequipment ();
        noticeequipment.setNoticeEquipmentID ( noticeEquipmentID );
        noticeequipment = (Noticeequipment) noticeequipmentDao.searchByPrimaryKey ( noticeequipment );
        rfidString = noticeequipment.getKnifeInventoryCode ();
        noticeequipment.setKnifeInventoryCode ( null );
        noticeequipment.setNoticeEquipmentIDWhere ( noticeEquipmentID );
        if (rfidString == null) {
            return reUpdateCount;
        }

        // 取得业务流程ID
        Business business = new Business ();
        business.setBusinessCode ( businessCode );
        List<Business> businessList = (List<Business>) businessDao.searchByList ( business );
        business = businessList.get ( 0 );
        Businessflowlnk businessflowlnks = new Businessflowlnk ();
        businessflowlnks.setBusinessID ( business.getBusinessID () );
        List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList ( businessflowlnks );
        // 下一个流程
        String businessFlowLnkID = list1.get ( 0 ).getBusinessFlowLnkID ();

        Rfidcontainer rfidcontainer = new Rfidcontainer ();
        rfidcontainer.setRfidCode ( rfidString );
        rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Rfidcontainer> rfidList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
        if (rfidList.size () < 1) {
            return reUpdateCount;
        }
        //取得刀具流转
        Tooltransfer tt1 = new Tooltransfer ();
        tt1.setRfidContainerID ( rfidList.get ( 0 ).getRfidContainerID () );
        tt1.setDelFlag ( IConstant.DEL_FLAG_0 );
        //取得流转中数据
        List<Tooltransfer> ttList = (List<Tooltransfer>) tooltransferDao.searchByList ( tt1 );
        //不能刃磨长度
        double staticLength = 0;
        for (Tooltransfer tt : ttList) {
            //记录刀具生命周期
            Toolwholelifecycle toolwholelifecycle = new Toolwholelifecycle ();
            toolwholelifecycle.setBusinessFlowLnkID ( businessFlowLnkID );
            toolwholelifecycle.setHandSetID ( handsetID );
            // 取得刀具信息
            Tool tool = new Tool ();
            tool.setToolID ( tt.getToolID () );
            List<Tool> toolList = (List<Tool>) toolDao.searchByList ( tool );
            if (toolList != null) {
                tool = toolList.get ( 0 );
                if (IConstant.STRING_0.equals ( tool.getToolType () )) {
                    // 不能刃磨长度 = 总长度 - 总刃磨长度
                    staticLength = tool.getToolLength ().doubleValue () - tool.getToolSharpenLength ().doubleValue ();
                }
                toolwholelifecycle.setToolCode ( tool.getToolCode () );
                toolwholelifecycle.setToolName ( tool.getToolName () );
            }
            toolwholelifecycle.setKnifeInventoryCode ( tt.getKnifeInventoryCode () );
            toolwholelifecycle.setDelFlag ( IConstant.DEL_FLAG_0 );
            toolwholelifecycle.setCreateTime ( new Date () );
            toolwholelifecycle.setUpdateTime ( new Date () );
            toolwholelifecycle.setCreateUser ( userID );
            toolwholelifecycle.setUpdateUser ( userID );
            toolwholelifecycle.setVersion ( BigDecimal.ZERO );
            String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue ( IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, userID );
            toolwholelifecycle.setToolWholeLifecycleID ( toolWholeLifecycleID );
            toolwholelifecycleDao.insert ( toolwholelifecycle );

            // 更新流转表
            Tooltransfer updateTooltransfer = new Tooltransfer ();
            updateTooltransfer.setRfidContainerIDWhere ( tt.getRfidContainerID () );
            updateTooltransfer.setKnifeInventoryCodeWhere ( tt.getKnifeInventoryCode () );
            updateTooltransfer.setBusinessFlowLnkID ( businessFlowLnkID );
            if (tt.getUsageCounter () == null) {
                tt.setUsageCounter ( BigDecimal.ZERO );
            }
            updateTooltransfer.setUsageCounter ( tt.getUsageCounter ().add ( BigDecimal.ONE ) );//已使用(刃磨)次数
            if ((tt.getToolSharpennum ().subtract ( BigDecimal.ONE )).intValue () <= 0) {
                updateTooltransfer.setToolSharpennum ( BigDecimal.ZERO ); //可使用(刃磨)次数
            } else {
                updateTooltransfer.setToolSharpennum ( tt.getToolSharpennum ().subtract ( BigDecimal.ONE ) );
            }
            updateTooltransfer.setStockState ( IConstant.STOCK_STATE_4 );
            updateTooltransfer.setUpdateTime ( new Date () );// 更新时间
            updateTooltransfer.setUpdateUser ( userID );// 更新者
            updateTooltransfer.setVersion ( tt.getVersion ().add ( BigDecimal.ONE ) );// 版本号
            reUpdateCount += tooltransferDao.updateNonQuery ( updateTooltransfer );

            //记录刀具流转履历
            Tooltransferhistory tth = new Tooltransferhistory ();
            tth.setToolTransferHistoryID ( NextKeyValue.getNextkeyvalue ( IConstant.TOOLTRANSFERHISTORY, IConstant.TOOLTRANSFERHISTORYID, userID ) );
            tth.setRfidContainerID ( tt.getRfidContainerID () ); // RFID载体ID
            tth.setKnifeInventoryCode ( tt.getKnifeInventoryCode () );// 刀具入库编码
            tth.setToolID ( tt.getToolID () );// 刀具ID
            tth.setToolProcuredID ( tt.getProcuredBatch () );// 采购ID
            tth.setBusinessFlowLnkID ( businessFlowLnkID );// 最后执行业务流程(刀具安上)
            tth.setToolDurable ( tt.getToolDurable () );// 耐用度
            tth.setToolSharpennum ( updateTooltransfer.getToolDurable () );// 可使用(刃磨)次数
            tth.setToolSharpenCriterion ( tt.getToolSharpenCriterion () );// 复磨标准
            tth.setToolLength ( tt.getToolLength () );// 刀具长度
            tth.setToolSharpenLength ( updateTooltransfer.getToolSharpenLength () );// 可刃磨长度
            tth.setUsageCounter ( updateTooltransfer.getUsageCounter () );// 已使用(刃磨)次数
            tth.setToolGrindingLength ( updateTooltransfer.getToolGrindingLength () );// 刀具已刃磨长度
            tth.setInstallationState ( tt.getInstallationState () );// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
            tth.setStockState ( IConstant.STOCK_STATE_4 );
            tth.setoutUser ( tt.getUpdateUser () );// 转出人
            tth.setinUser ( userID );// 接收人
            tth.setUpdateTime ( new Date () );// 更新时间
            tth.setUpdateUser ( userID );// 更新者
            tth.setDelFlag ( IConstant.DEL_FLAG_0 );// 删除区分
            tth.setCreateTime ( new Date () );// 创建时间
            tth.setCreateUser ( userID );// 创建者
            tth.setVersion ( BigDecimal.ZERO );// 版本号
            tooltransferhistoryDao.insert ( tth );
        }
        return noticeequipmentDao.update ( noticeequipment );
    }

    @Override
    public int getToolInfoCount(String rfidString) throws Exception {
        int count = 0;
        Rfidcontainer rfidcontainer = new Rfidcontainer ();
        rfidcontainer.setRfidCode ( rfidString );
        rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Rfidcontainer> rfidcontainers = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
        if (rfidcontainers.size () == 0) {
            return count;
        }
        Tooltransfer tt = new Tooltransfer ();
        tt.setRfidContainerID ( rfidcontainers.get ( 0 ).getRfidContainerID () );
        tt.setDelFlag ( IConstant.DEL_FLAG_0 );
        return tooltransferDao.searchByCount ( tt );
    }

    /**
     * 按刀具编码或物料号查询取得刃磨数量
     *
     * @param map toolCode 刀具编码(String)
     *            kiCode    物料号(String)
     * @return
     * @throws Exception
     */
    @Override
    public List<TooltranarMassage> getToolCodeAndKivCode(Map<String, Object> map) throws Exception {
        TooltranarMassage entity = new TooltranarMassage ();
        String toolCode = (String) map.get ( "toolCode" );
        String kiCode = (String) map.get ( "kiCode" );
        //刀具编码
        if (toolCode != null && !"".equals ( toolCode )) {
            entity.setToolCode ( toolCode );
        }
        //物料号
        if (kiCode != null && !"".equals ( kiCode )) {
            entity.setCustomerCode ( kiCode );
        }
        //刃磨室
        entity.setToolThisState ( IConstant.STSATIC_TWO );
        //6厂内待刃磨
        entity.setToolState ( IConstant.STSATIC_SIX );
        List<TooltranarMassage> reList = tooltransferDao.getToolCodeAndKivCode ( entity );
        return reList;
    }

    /**
     * 扫描待放刃磨完刀具的容器(报废)
     *
     * @param map scrapCount  报废数量(int)
     *            userId  当前用户ID(String)
     *            rfidString 容器rifd(String)
     *            gruantUserId 授权人id(String)
     * @return
     * @throws Exception
     */
    @Override
    public int putScrapGrindingContainer(Map<String, Object> map) throws Exception {
        Tooltransfer entity = new Tooltransfer ();
        Tooltransfer param = new Tooltransfer ();
        // 报废数量
        int scrapCount = (Integer) map.get ( "scrapCount" );
        // 当前用户ID
        String userId = map.get ( "userId" ).toString ();
        //容器rifd
        String rfidContarnerId = (String) map.get ( "rfidContarnerId" );
        //授权人id
        String gruantUserId = (String) map.get ( "gruantUserId" );
        //手持机
        String handerId = (String) map.get ( "handerId" );
        //刀具编码
        String toolCode = (String) map.get ( "toolCode" );
        Tool tool = new Tool ();
        tool.setToolCode ( toolCode );
        tool.setDelFlag ( IConstant.DEL_FLAG_0 );
        String toolId = ((Tool) toolDao.searchByList ( tool ).get ( 0 )).getToolID ();
        // 取得业务流程ID
        Business business = new Business ();
        business.setBusinessCode ( IConstant.C01S018 );
        List<Business> businessList = (List<Business>) businessDao.searchByList ( business );
        business = businessList.get ( 0 );
        Businessflowlnk businessflowlnks = new Businessflowlnk ();
        businessflowlnks.setBusinessID ( business.getBusinessID () );
        List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList ( businessflowlnks );
        String businessFlowLnkID = list1.get ( 0 ).getBusinessFlowLnkID ();
        //刃磨室
        entity.setRfidContainerIDWhere ( IConstant.GRINDING_CONTARNERID );
        param.setToolThisState ( IConstant.STSATIC_TWO );
        param.setToolStateWhere ( IConstant.STSATIC_SIX );
        param.setToolID ( toolId );
        param.setDelFlag ( IConstant.DEL_FLAG_0 );
        param.setStaIndex ( 0 );
        param.setRowCount ( scrapCount );
        //刀具部门(0库存,1对刀室,2刃磨室,3,车间)
        entity.setToolThisStateWhere ( IConstant.STSATIC_TWO );
        entity.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
        entity.setToolID ( toolId );
        //数量
        entity.setRowCount ( scrapCount );
        entity.setBusinessFlowLnkID ( businessFlowLnkID );
        entity.setRfidContainerID ( rfidContarnerId );
        if (gruantUserId == null) {
            entity.setConfirmedUser ( userId ); //确认人
        } else {
            entity.setConfirmedUser ( gruantUserId ); //确认人
        }
        //其他
        entity.setToolState ( IConstant.TOOL_STATE_9 );
        //报废
        entity.setStockState ( IConstant.STOCK_STATE_1 );
        entity.setUpdateTime ( new Date () );
        entity.setUpdateUser ( userId );

        //根据合成刀具RFID查询到流转中的刀具
        List<Tooltransfer> ttlist = (List<Tooltransfer>) tooltransferDao.searchByList ( param );
        List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory> ();
        Tooltransferhistory tth = null;
        List<Toolwholelifecycle> tlcList = new ArrayList<Toolwholelifecycle> ();
        Toolwholelifecycle toolwholelifecycle = null;
        for (Tooltransfer tt : ttlist) {
            // 记录生命周期
            if (handerId != null) {
                toolwholelifecycle = new Toolwholelifecycle ();
                toolwholelifecycle.setBusinessFlowLnkID ( businessFlowLnkID );
                toolwholelifecycle.setHandSetID ( handerId );
                // 取得刀具信息
                tool = new Tool ();
                tool.setToolID ( tt.getToolID () );
                List<Tool> toolList = (List<Tool>) toolDao.searchByList ( tool );
                if (toolList != null && toolList.size () > 0) {
                    tool = toolList.get ( 0 );
                    toolwholelifecycle.setToolCode ( tool.getToolCode () );
                    toolwholelifecycle.setToolName ( tool.getToolName () );
                }
                toolwholelifecycle.setKnifeInventoryCode ( tt.getKnifeInventoryCode () );
                toolwholelifecycle.setDelFlag ( IConstant.DEL_FLAG_0 );
                toolwholelifecycle.setCreateTime ( new Date () );
                toolwholelifecycle.setUpdateTime ( new Date () );
                toolwholelifecycle.setCreateUser ( userId );
                if (gruantUserId != null)
                    toolwholelifecycle.setUpdateUser ( gruantUserId );
                toolwholelifecycle.setVersion ( BigDecimal.ZERO );
                toolwholelifecycle.setToolWholeLifecycleID ( UUID.randomUUID ().toString () );
                tlcList.add ( toolwholelifecycle );
            }

            // 刀具流转履历
            tth = new Tooltransferhistory ();
            tth.setToolTransferHistoryID ( UUID.randomUUID ().toString () );
            tth.setRfidContainerID ( tt.getRfidContainerID () ); // RFID载体ID
            tth.setKnifeInventoryCode ( tt.getKnifeInventoryCode () );// 刀具入库编码
            tth.setToolID ( tt.getToolID () );// 刀具ID
            tth.setToolProcuredID ( tt.getProcuredBatch () );// 采购ID
            tth.setBusinessFlowLnkID ( tt.getBusinessFlowLnkID () );// 最后执行业务流程
            tth.setToolDurable ( tt.getToolDurable () );// 耐用度
            tth.setToolSharpennum ( tt.getToolDurable () );// 可使用(刃磨)次数
            tth.setToolSharpenCriterion ( tt.getToolSharpenCriterion () );// 复磨标准
            tth.setToolLength ( tt.getToolLength () );// 刀具长度
            tth.setToolSharpenLength ( tt.getToolSharpenLength () );// 可刃磨长度
            tth.setUsageCounter ( tt.getUsageCounter () );// 已使用(刃磨)次数
            tth.setToolGrindingLength ( tt.getToolGrindingLength () );// 刀具已刃磨长度
            tth.setInstallationState ( IConstant.INSTALLATION_STATE_1 );// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
            tth.setToolState ( IConstant.TOOL_STATE_9 );// 刀具状态(0断刀1丢失2不合格3借入4申领9其他)
            tth.setoutUser ( userId );// 转出人
            if (gruantUserId != null) {
                tth.setinUser ( gruantUserId );// 接收人
            } else {
                tth.setinUser ( userId );
            }
            tth.setStockState ( IConstant.STOCK_STATE_1 );//报废
            tth.setUpdateTime ( new Date () );// 更新时间
            tth.setUpdateUser ( gruantUserId );// 更新者
            tth.setDelFlag ( IConstant.DEL_FLAG_0 );// 删除区分
            tth.setCreateTime ( new Date () );// 创建时间
            tth.setCreateUser ( userId );// 创建者
            tth.setVersion ( BigDecimal.ZERO );// 版本号
            tthList.add ( tth );
            //加入修复履历
            Toolnoticehistory tnh = new Toolnoticehistory ();
            tnh.setKnifeInventoryCode ( tt.getKnifeInventoryCode () );// 刀具入库编码
            tnh.setDelFlag ( IConstant.DEL_FLAG_0 );// 删除区分(0有效1删除)
            tnh.setNoticeTime ( new Date () );// 修复时间
            tnh.setToolRepairNoticeUser ( userId );// 操作人
            tnh.setRepairWay ( IConstant.REPAIR_WAY_0 );
            tnh.setNoticeLength ( BigDecimal.ONE );// 修复前测量长度
            //修复原因(0断刀1正常刃磨)
            tnh.setRepairedBecause ( IConstant.REPAIRED_BECAUSE_1 );
            tnh.setCreateUser ( userId );
            tnh.setCreateTime ( new Date () );
            tnh.setUpdateTime ( new Date () );// 更新时间
            tnh.setUpdateUser ( userId );// 更新者
            tnh.setVersion ( BigDecimal.ZERO );
            toolnoticehistoryDao.insert ( tnh );
        }
        // 增加生命周期
        if (tlcList.size () > 0)
            toolwholelifecycleDao.insertBatchs ( tlcList );
        // 批量增加【刀具流转履历】
        if (tthList.size () > 0)
            tooltransferhistoryDao.insertBatchDefined ( tthList );
        return tooltransferDao.updateDateByToolID ( entity );
    }

    /**
     * 扫描待放刃磨完刀具的容器(无报废)
     *
     * @param map scrapCount  报废数量(int)
     *            grindingCount  刃磨数量(int)
     *            userId  当前用户ID(String)
     *            rfidString 容器rifd(String)
     *            gruantUserId 授权人id(String)
     * @return
     * @throws Exception
     */
    @Override
    public int putGrindingContainer(Map<String, Object> map) throws Exception {
        int reVal = 0;
        // 报废数量
        int scrapCount = (Integer) map.get ( "scrapCount" );
        //刃磨数量
        int grindingCount = (Integer) map.get ( "grindingCount" );
        // 当前用户ID
        String userId = map.get ( "userId" ).toString ();
        //容器rifd载体
        String rfidContarnerId = (String) map.get ( "rfidContarnerId" );
        //授权人id
        String gruantUserId = (String) map.get ( "gruantUserId" );
        //刀具编码
        String toolCode = (String) map.get ( "toolCode" );
        Tool tool = new Tool ();
        tool.setToolCode ( toolCode );
        tool.setDelFlag ( IConstant.DEL_FLAG_0 );
        String toolId = ((Tool) toolDao.searchByList ( tool ).get ( 0 )).getToolID ();
        //手持机
        String handerId = (String) map.get ( "handerId" );
        // 取得业务流程ID
        Business business = new Business ();
        business.setBusinessCode ( IConstant.C01S018 );
        List<Business> businessList = (List<Business>) businessDao.searchByList ( business );
        business = businessList.get ( 0 );
        Businessflowlnk businessflowlnks = new Businessflowlnk ();
        businessflowlnks.setBusinessID ( business.getBusinessID () );
        List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList ( businessflowlnks );
        String businessFlowLnkID = list1.get ( 0 ).getBusinessFlowLnkID ();
        Tooltransfer param = new Tooltransfer ();
        // param.setRfidContainerID(IConstant.GRINDING_CONTARNERID);
        param.setToolThisState ( IConstant.STSATIC_TWO );
        param.setDelFlag ( IConstant.DEL_FLAG_0 );
        param.setToolStateWhere ( IConstant.STSATIC_SIX );
        param.setStaIndex ( 0 );
        param.setRowCount ( scrapCount );
        param.setToolID ( toolId );

        //根据合成刀具RFID查询到流转中的刀具
        List<Tooltransfer> ttlist = (List<Tooltransfer>) tooltransferDao.searchByList ( param );
        List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory> ();
        Tooltransferhistory tth = null;
        List<Toolwholelifecycle> tlcList = new ArrayList<Toolwholelifecycle> ();
        Toolwholelifecycle toolwholelifecycle = null;
        for (Tooltransfer tt : ttlist) {
            // 记录生命周期
            if (handerId != null) {
                toolwholelifecycle = new Toolwholelifecycle ();
                toolwholelifecycle.setBusinessFlowLnkID ( businessFlowLnkID );
                toolwholelifecycle.setHandSetID ( handerId );
                // 取得刀具信息
                tool = new Tool ();
                tool.setToolID ( tt.getToolID () );
                List<Tool> toolList = (List<Tool>) toolDao.searchByList ( tool );
                if (toolList != null && toolList.size () > 0) {
                    tool = toolList.get ( 0 );
                    toolwholelifecycle.setToolCode ( tool.getToolCode () );
                    toolwholelifecycle.setToolName ( tool.getToolName () );
                }
                toolwholelifecycle.setKnifeInventoryCode ( tt.getKnifeInventoryCode () );
                toolwholelifecycle.setDelFlag ( IConstant.DEL_FLAG_0 );
                toolwholelifecycle.setCreateTime ( new Date () );
                toolwholelifecycle.setUpdateTime ( new Date () );
                toolwholelifecycle.setCreateUser ( userId );
                if (gruantUserId != null)
                    toolwholelifecycle.setUpdateUser ( gruantUserId );
                toolwholelifecycle.setVersion ( BigDecimal.ZERO );
                toolwholelifecycle.setToolWholeLifecycleID ( UUID.randomUUID ().toString () );
                tlcList.add ( toolwholelifecycle );
            }
            // 刀具流转履历
            tth = new Tooltransferhistory ();
            tth.setToolTransferHistoryID ( UUID.randomUUID ().toString () );
            tth.setRfidContainerID ( tt.getRfidContainerID () ); // RFID载体ID
            tth.setKnifeInventoryCode ( tt.getKnifeInventoryCode () );// 刀具入库编码
            tth.setToolID ( tt.getToolID () );// 刀具ID
            tth.setToolProcuredID ( tt.getProcuredBatch () );// 采购ID
            tth.setBusinessFlowLnkID ( businessFlowLnkID );// 最后执行业务流程
            tth.setToolDurable ( tt.getToolDurable () );// 耐用度
            tth.setToolSharpennum ( tt.getToolDurable () );// 可使用(刃磨)次数
            tth.setToolSharpenCriterion ( tt.getToolSharpenCriterion () );// 复磨标准
            tth.setToolLength ( tt.getToolLength () );// 刀具长度
            tth.setToolSharpenLength ( tt.getToolSharpenLength () );// 可刃磨长度
            tth.setUsageCounter ( tt.getUsageCounter () );// 已使用(刃磨)次数
            tth.setToolGrindingLength ( tt.getToolGrindingLength () );// 刀具已刃磨长度
            tth.setInstallationState ( IConstant.INSTALLATION_STATE_1 );// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
            tth.setToolState ( IConstant.TOOL_STATE_9 );// 刀具状态(0断刀1丢失2不合格3借入4申领9其他)
            tth.setoutUser ( userId );// 转出人
            if (gruantUserId != null) {
                tth.setinUser ( gruantUserId );// 接收人
            } else {
                tth.setinUser ( userId );
            }
            tth.setStockState ( IConstant.STOCK_STATE_1 );//报废
            tth.setUpdateTime ( new Date () );// 更新时间
            tth.setUpdateUser ( gruantUserId );// 更新者
            tth.setDelFlag ( IConstant.DEL_FLAG_0 );// 删除区分
            tth.setCreateTime ( new Date () );// 创建时间
            tth.setCreateUser ( userId );// 创建者
            tth.setVersion ( BigDecimal.ZERO );// 版本号
            tthList.add ( tth );
            //加入修复履历
            Toolnoticehistory tnh = new Toolnoticehistory ();
            tnh.setKnifeInventoryCode ( tt.getKnifeInventoryCode () );// 刀具入库编码
            tnh.setDelFlag ( IConstant.DEL_FLAG_0 );// 删除区分(0有效1删除)
            tnh.setNoticeTime ( new Date () );// 修复时间
            tnh.setToolRepairNoticeUser ( userId );// 操作人
            tnh.setRepairWay ( IConstant.REPAIR_WAY_0 );
            tnh.setNoticeLength ( BigDecimal.ONE );// 修复前测量长度
            //修复原因(0断刀1正常刃磨)
            tnh.setRepairedBecause ( IConstant.REPAIRED_BECAUSE_1 );
            tnh.setCreateUser ( userId );
            tnh.setCreateTime ( new Date () );
            tnh.setUpdateTime ( new Date () );// 更新时间
            tnh.setUpdateUser ( userId );// 更新者
            tnh.setVersion ( BigDecimal.ZERO );
            toolnoticehistoryDao.insert ( tnh );
        }
        // 增加生命周期
        if (tlcList.size () > 0)
            toolwholelifecycleDao.insertBatchs ( tlcList );
        // 批量增加【刀具流转履历】
        if (tthList.size () > 0)
            tooltransferhistoryDao.insertBatchDefined ( tthList );
        Tooltransfer entity = new Tooltransfer ();
        //刃磨室
        entity.setToolStateWhere ( IConstant.STSATIC_SIX );
        //刀具部门(0库存,1对刀室,2刃磨室,3,车间)
        entity.setToolThisStateWhere ( IConstant.STSATIC_TWO );
        entity.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
        entity.setToolID ( toolId );
        entity.setStaIndex ( 0 );
        if (scrapCount > 0) {
            //数量
            entity.setRowCount ( scrapCount );
            entity.setRfidContainerID ( rfidContarnerId );
            if (gruantUserId == null) {
                entity.setConfirmedUser ( userId ); //确认人
            } else {
                entity.setConfirmedUser ( gruantUserId ); //确认人
            }
            //其他
            entity.setToolState ( IConstant.TOOL_STATE_9 );
            entity.setBusinessFlowLnkID ( businessFlowLnkID );
            //报废
            entity.setStockState ( IConstant.STOCK_STATE_1 );
            entity.setUpdateTime ( new Date () );
            entity.setUpdateUser ( userId );
            reVal = tooltransferDao.updateDateByToolID ( entity );
        }
        //数量
        entity.setRowCount ( grindingCount );
        entity.setRfidContainerID ( rfidContarnerId );
        //刃磨完毕
        entity.setToolState ( IConstant.STSATIC_EIGHT );
        entity.setBusinessFlowLnkID ( businessFlowLnkID );
        //流转
        entity.setStockState ( IConstant.STOCK_STATE_4 );
        entity.setUpdateTime ( new Date () );
        entity.setUpdateUser ( userId );
        reVal += tooltransferDao.updateDateByToolID ( entity );
        return reVal;
    }

    @Override
    public List<Vgetnoticeequipmentlist> getNoticeEquipmentList() throws Exception {
        return (List<Vgetnoticeequipmentlist>) vgetnoticeequipmentlistDao.searchByList ( new Vgetnoticeequipmentlist () );
    }

    @Override
    public Vgettoolinfolist getToolInfoList(Vgettoolinfolist vv) throws Exception {
        List<Vgettoolinfolist> reList = (List<Vgettoolinfolist>) vgettoolinfolistDao.searchByList ( vv );
        Vgettoolinfolist reEntity = new Vgettoolinfolist ();
        if (reList.size () < 1) {
            //未找到相应数据
            reEntity.setRetErrFlag ( true );
        } else {
            reEntity = reList.get ( 0 );
        }
        return reEntity;
    }

    /**
     * 提交刀具修磨信息
     *
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> submitToolsGrindingEquInfo(List<Map<String, Object>> toolList, Toolnoticehistory entity) {
        Map<String, Object> result = new HashMap<String, Object> ();
        Toolnoticehistory tn = null;
        List<Toolnoticehistory> tnlist = new ArrayList<Toolnoticehistory> ();
        //用户ID
        String userID = entity.getUpdateUser ();
        //修磨设备ID
        String noticeEqmentID = entity.getNoticeEquipmentID ();
        //手持机id
        String handSetID = entity.getExpandSpace1 ();
        Tooltransfer tt = null;
        List<Tooltransfer> ttlist = new ArrayList<Tooltransfer> ();
        List<String> bakRfidCon = new ArrayList<> ();
        List<String> outRfidCon = new ArrayList<> ();
        try {
            for (Map<String, Object> map : toolList) {
                //查询载体ID
                Rfidcontainer rc = new Rfidcontainer ();
                rc.setRfidCode ( (String) map.get ( "RfidCode" ) );
                rc.setDelFlag ( IConstant.DEL_FLAG_0 );
                List<Rfidcontainer> reval = rfidcontainerDao.getRfidMsg ( rc );
                //载体ID
                String rfc = reval.get ( 0 ).getRfidContainerID ();

                String toolID = (String) map.get ( "ToolID" );
                Tool tool = new Tool ();
                tool.setToolID ( toolID );
                tool = (Tool) toolDao.searchByPrimaryKey ( tool );
                //修磨类别(0:厂内修磨，1厂外修磨，2厂外涂层
                if (tool != null && tool.getToolGrinding () != null) {
                    if (IConstant.STRING_0.equals ( tool.getToolGrinding () )) {
                        //0:厂内修磨
                        bakRfidCon.add ( rfc );
                    } else {
                        // 2厂外涂层
                        outRfidCon.add ( rfc );
                    }
                }

                //查询刀具入库编码
                Tooltransfer tf = new Tooltransfer ();
                tf.setRfidContainerID ( rfc );
                tf.setToolID ( toolID );
                tf.setDelFlag ( IConstant.DEL_FLAG_0 );
                List<Tooltransfer> treval = tooltransferDao.getTooltransferMsg ( tf );
                Tooltransfer ttransfer = treval.get ( 0 );
                //刀具入库编码
                String kCode = ttransfer.getKnifeInventoryCode ();

                tn = new Toolnoticehistory ();
                //材料号
                tn.setToolCode ( map.get ( "MaterialNum" ).toString () );
                //刀具入库编码
                tn.setKnifeInventoryCode ( kCode );
                //修复时间
                tn.setNoticeTime ( new Date () );
                //修复数量
                tn.setNoticeCount ( BigDecimal.ONE );
                //操作人
                tn.setToolRepairNoticeUser ( userID );
                tn.setRepairWay ( IConstant.DEL_FLAG_0 );
                //删除区分
                tn.setDelFlag ( IConstant.DEL_FLAG_0 );
                //修磨设备ID
                tn.setNoticeEquipmentID ( noticeEqmentID );
                //修磨后状态（现在都是正常）
                tn.setRepairedBecause ( IConstant.DEL_FLAG_0 );
                // 更新时间
                tn.setUpdateTime ( new Date () );
                tn.setCreateTime ( new Date () );
                tn.setCreateUser ( userID );
                // 更新者
                tn.setUpdateUser ( userID );
                tn.setVersion ( BigDecimal.ONE );
                toolnoticehistoryDao.insert ( tn );
                tt = new Tooltransfer ();
                tt.setRfidContainerID ( rfc );
                tt.setDelFlag ( IConstant.DEL_FLAG_0 );
                List<Tooltransfer> tt1 = (List<Tooltransfer>) tooltransferDao.searchByList ( tt );
                List<Toolwholelifecycle> twls = new ArrayList<Toolwholelifecycle> ();
                for (Tooltransfer tt2 : tt1) {
                    //建立生命周期
                    Toolwholelifecycle twl = new Toolwholelifecycle ();
                    // 刀具全生命周期id
                    twl.setToolWholeLifecycleID ( UUIDgen.getId () );
                    // 刀具入库编码
                    twl.setKnifeInventoryCode ( tt2.getKnifeInventoryCode () );
                    // 流程id
                    twl.setBusinessFlowLnkID ( IConstant.C01S018 );
                    // 手持机id
                    twl.setHandSetID ( handSetID );
                    // 刀具id
                    twl.setToolID ( tt2.getToolID () );
                    //零部件id
                    twl.setPartsID ( "" );
                    //加工数量
                    if (tt2.getProcessAmount () != null) {
                        twl.setProcessAmount ( tt2.getProcessAmount ().toString () );
                    } else {
                        twl.setProcessAmount ( IConstant.DEL_FLAG_0 );
                    }
                    //删除区分(0有效1删除)
                    twl.setDelFlag ( IConstant.DEL_FLAG_0 );
                    //更新时间
                    twl.setUpdateTime ( new Date () );
                    //更新者
                    twl.setUpdateUser ( userID );
                    //创建时间
                    twl.setCreateTime ( new Date () );
                    //创建者
                    twl.setCreateUser ( userID );
                    //刃磨次数
                    if (ttransfer.getUsageCounter () == null) {
                        twl.setVersion ( BigDecimal.ONE );
                    } else {
                        twl.setVersion ( ttransfer.getUsageCounter ().add ( BigDecimal.ONE ) );
                    }
                    twls.add ( twl );
                }
                if (twls.size () > 0) {
                    toolwholelifecycleDao.insertBatchs ( twls );
                }

            }
            Map<String, Object> params = new HashMap<> ();

            params.put ( "updateTime", new Date () );
            params.put ( "updateUser", userID );
            //库存状态(0正常1报废2返厂3封存4.流转9其他)设定
            params.put ( "stockState", IConstant.STRING_4 );
            //刃磨次数加1
            params.put ( "businessFlowLnkID", IConstant.C01S018 );

            //备刀库
            if (bakRfidCon.size () > 0) {
                //刀具状态(0断刀1丢失2不合格3待分拣4待换装,5到寿,6厂内待刃磨,7.厂外待刃磨8刃磨完毕,9其他10.已出厂修磨 11.厂外待涂层 12.出库报废)
                params.put ( "toolState", IConstant.STRING_4 );
                // 刀具部门(0库存,1对刀室,2刃磨室,3,车间4,初始化)
                params.put ( "toolThisState", IConstant.STRING_3 );
                params.put ( "list", bakRfidCon );
                tooltransferDao.updatStateByRfidConner ( params );
            }
            //修复完毕
            if (outRfidCon.size () > 0) {
                params.put ( "toolState", IConstant.STRING_8 );
                params.put ( "toolThisState", IConstant.STRING_2 );
                params.put ( "list", outRfidCon );
                tooltransferDao.updatStateByRfidConner ( params );

            }

            result.put ( "status", IConstant.RESULT_CODE_0 );
            result.put ( "messagetext", IConstant.WMSG0227 );
            return result;
        } catch (SQLException e) {
            e.printStackTrace ();
            result.put ( "status", IConstant.RESULT_CODE_2 );
            // 数据库操作异常,查询失败!
            result.put ( "messagetext", IConstant.WMSG0228 );
            return result;
        }

    }

}
