package com.icomp.common.service.impl.icomp.v01c01.s016;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c01.s016.ICOMPV01C01S016Service;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.common.utils.UUIDgen;
import com.icomp.dao.BusinessDao;
import com.icomp.dao.BusinessflowlnkDao;
import com.icomp.dao.ComlistDao;
import com.icomp.dao.KnifeinventoryDao;
import com.icomp.dao.RedemptionappliedDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.ScrapDao;
import com.icomp.dao.ToolDao;
import com.icomp.dao.ToolrepairnoticeDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.TooltransferhistoryDao;
import com.icomp.dao.ToolwholelifecycleDao;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Businessflowlnk;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Redemptionapplied;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Scrap;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Toolrepairnotice;
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
import java.util.UUID;

public class ICOMPV01C01S016ServiceImpl extends BaseService implements ICOMPV01C01S016Service {
    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    private ScrapDao scrapDao;

    public void setScrapDao(ScrapDao scrapDao) {
        this.scrapDao = scrapDao;
    }

    private RedemptionappliedDao redemptionappliedDao;

    public void setRedemptionappliedDao(RedemptionappliedDao redemptionappliedDao) {
        this.redemptionappliedDao = redemptionappliedDao;
    }

    private RfidcontainerDao rfidcontainerDao;

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
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

    private ToolrepairnoticeDao toolrepairnoticeDao;

    public void setToolrepairnoticeDao(ToolrepairnoticeDao toolrepairnoticeDao) {
        this.toolrepairnoticeDao = toolrepairnoticeDao;
    }

    /* 系统区分Dao */
    private ComlistDao comlistDao;

    /**
     * 系统区分Dao 设定
     *
     * @param comlistDao
     */
    public void setComlistDao(ComlistDao comlistDao) {
        this.comlistDao = comlistDao;
    }

    private ToolwholelifecycleDao toolwholelifecycleDao;

    public void setToolwholelifecycleDao(ToolwholelifecycleDao toolwholelifecycleDao) {
        this.toolwholelifecycleDao = toolwholelifecycleDao;
    }

    private BusinessDao businessDao;

    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    private BusinessflowlnkDao businessflowlnkDao;

    public void setBusinessflowlnkDao(BusinessflowlnkDao businessflowlnkDao) {
        this.businessflowlnkDao = businessflowlnkDao;
    }

    private TooltransferhistoryDao tooltransferhistoryDao;

    public void setTooltransferhistoryDao(TooltransferhistoryDao tooltransferhistoryDao) {
        this.tooltransferhistoryDao = tooltransferhistoryDao;
    }

    private KnifeinventoryDao knifeinventoryDao;

    public void setKnifeinventoryDao(KnifeinventoryDao knifeinventoryDao) {
        this.knifeinventoryDao = knifeinventoryDao;
    }

    /**
     * 取得扫描RFID的刀具信息
     *
     * @param rfidString
     * @return
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> getToolInfo(String rfidString, String langCode) {
        Map<String, Object> result = new HashMap<String, Object> ();
        try {
            Rfidcontainer rfidcontainer = new Rfidcontainer ();
            rfidcontainer.setRfidCode ( rfidString );
            rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
            List<Rfidcontainer> rfidList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
            if (rfidList == null || rfidList.size () == 0) {
                // 当前扫描的RFID未绑定刀具!
                result.put ( "status", IConstant.RESULT_CODE_1 );
                result.put ( "messageCode", IConstant.WMSG0143 );
                return result;
            }
            rfidcontainer = rfidList.get ( 0 );
            // 取得流转刀具信息
            Tooltransfer tooltransfer = new Tooltransfer ();
            // 取得载体ID
            String rfidContainerID = rfidcontainer.getRfidContainerID ();
            tooltransfer.setRfidContainerID ( rfidContainerID );
            tooltransfer.setDelFlag ( IConstant.DEL_FLAG_0 );
            List<Tooltransfer> tooltransferList = (List<Tooltransfer>) tooltransferDao.searchByList ( tooltransfer );
            int count = tooltransferDao.searchByCount ( tooltransfer );
            int lostCount = 0; // 报废数量
            result.put ( "SentBackNumber", count );// 领取数量
            for (Tooltransfer tt : tooltransferList) {
                if (IConstant.STOCK_STATE_1.equals ( tt.getStockState () )) {// 报废
                    lostCount++;
                    result.put ( "IdentifyingUserId", tt.getConfirmedUser () );
                }
            }
            result.put ( "LostCount", lostCount );// 报废数量
            tooltransfer = tooltransferList.get ( 0 );
            // 取得刀具信息
            Tool tool = new Tool ();
            tool.setToolID ( tooltransfer.getToolID () );
            List<Tool> toolList = (List<Tool>) toolDao.searchByList ( tool );
            if (toolList == null || toolList.size () <= 0) {
                // 当前刀具编码未记录!
                result.put ( "status", IConstant.RESULT_CODE_1 );
                result.put ( "messageCode", IConstant.WMSG0116 );
                return result;
            } else {
                tool = toolList.get ( 0 );
                if (!tool.getToolType ().equals ( IConstant.TOOL_TYPE_0 )) {
                    // 所扫描的rfid不是刀具!
                    result.put ( "status", IConstant.RESULT_CODE_1 );
                    result.put ( "messageCode", IConstant.WMSG0120 );
                    return result;
                }
            }
            result.put ( "ToolCode", tool.getToolCode () );// 刀具编码
            // 取得修复通知数据
            // [根据载体ID取得通知单号、修复方式]
            Toolrepairnotice toolrepairnotice = new Toolrepairnotice ();
            toolrepairnotice.setRfidCode ( rfidContainerID );
            toolrepairnotice.setDelFlag ( IConstant.DEL_FLAG_0 );
            List<Toolrepairnotice> toolrepairnoticeList = (List<Toolrepairnotice>) toolrepairnoticeDao.searchByList ( toolrepairnotice );
            if (toolrepairnoticeList == null || toolrepairnoticeList.size () == 0) {
                // 当前修复通知单记录不存在!
                result.put ( "status", IConstant.RESULT_CODE_1 );
                result.put ( "messageCode", IConstant.CIMSG0087 );
                return result;
            }
            toolrepairnotice = toolrepairnoticeList.get ( 0 );
            result.put ( "ToolRepairNoticeID", toolrepairnotice.getToolRepairNoticeID () );// 修复通知单号
            result.put ( "ReplacementFlag", toolrepairnotice.getRepairWay () );// 修复方式
            // 取得修复方式文本
            Comlist comlist = new Comlist ();
            comlist.setLanguageCode ( langCode );
            comlist.setComListType ( IConstant.REPAIR_WAY );
            comlist.setComListValue ( toolrepairnotice.getRepairWay () );
            comlist.setDelFlag ( IConstant.DEL_FLAG_0 );
            List<Comlist> list = (List<Comlist>) comlistDao.searchByList ( comlist );
            if (list == null || list.size () == 0) {
                // 当前区分定义不存在!
                result.put ( "status", IConstant.RESULT_CODE_1 );
                result.put ( "messageCode", IConstant.WMSG0007 );
                return result;
            }
            comlist = list.get ( 0 );
            result.put ( "ReplacementFlagText", comlist.getComListText () );// 修复方式
            // 取得刀具参数，判断当前刀具状态(是否达到报废标准)
            // (刀片已刃磨 == 标准刃磨次数、钻头可刃磨长度 < 标准刃磨长度)
            // 如果是厂外修复(入新刀库)
            if (IConstant.REPAIR_WAY_3.equals ( toolrepairnotice.getRepairWay () ) || IConstant.REPAIR_WAY_4.equals ( toolrepairnotice.getRepairWay () )) {
                result.put ( "ToolStatus", IConstant.STRING_1 );// 刀具状态
                result.put ( "ToolStatusText", IConstant.WMSG0237 );// 刀具状态
            } else {
                if (IConstant.TOOL_CONSUME_TYPE_0.equals ( tool.getToolConsumetype () )) {// 钻头
                    // 已达到报废标准
                    if (IConstant.STOCK_STATE_1.equals ( tooltransfer.getStockState () )) {
                        // 报废
                        result.put ( "ToolStatus", IConstant.STRING_0 );// 刀具状态
                        result.put ( "ToolStatusText", IConstant.WMSG0238 );// 刀具状态
                    } else {
                        // 入旧刀库
                        result.put ( "ToolStatus", IConstant.STRING_2 );// 刀具状态
                        result.put ( "ToolStatusText", IConstant.WMSG0239 );// 刀具状态
                    }

                } else if (IConstant.TOOL_CONSUME_TYPE_1.equals ( tool.getToolConsumetype () )) {// 刃磨刀片
                    // 已达到报废标准
                    if (IConstant.STOCK_STATE_1.equals ( tooltransfer.getStockState () )) {
                        // 报废
                        result.put ( "ToolStatus", IConstant.STRING_0 );// 刀具状态
                        result.put ( "ToolStatusText", IConstant.WMSG0238 );// 刀具状态
                    } else {
                        // 入旧刀库
                        result.put ( "ToolStatus", IConstant.STRING_2 );// 刀具状态
                        result.put ( "ToolStatusText", IConstant.WMSG0239 );// 刀具状态
                    }
                }

            }
            result.put ( "status", IConstant.RESULT_CODE_0 );
            return result;
        } catch (SQLException e) {
            result.put ( "status", IConstant.RESULT_CODE_2 );
            result.put ( "messageCode", IConstant.EMSG0004 );
            return result;
        }
    }

    /**
     * 取得扫描RFID的刀具信息（非单品）
     *
     * @param rtn
     * @return
     */
    public Map<String, Object> getToolInfoDetail(Map<String, Object> rtn) {
        // 结果集
        Map<String, Object> result = new HashMap<String, Object> ();
        // rfid
        String rfidString = rtn.get ( "rfidString" ).toString ();
        try {
            // 取得流转刀具信息
            Tooltransfer tooltransfer = new Tooltransfer ();
            // 取得载体ID
            tooltransfer.setExpandSpace1 ( rfidString );
            tooltransfer.setDelFlag ( IConstant.DEL_FLAG_0 );
            tooltransfer.setGroupString ( "ToolID" );
            int count = tooltransferDao.searchByCount ( tooltransfer );
            if (count < 1) {
                System.out.println ( rfidString + "数量为0" );
                throw new RuntimeException ();
            }
            List<Tooltransfer> tooltransferList = (List<Tooltransfer>) tooltransferDao.getToolInfoDetail ( tooltransfer );
            int scapeCount = 0; // 报废总数量（申请总数量）
            result.put ( "ToolTotalNumber", count );// 容器中刀具的总数量
            for (Tooltransfer tt : tooltransferList) {
                scapeCount += Integer.parseInt ( tt.getExpandSpace1 () );
            }
            result.put ( "ScapeCount", scapeCount );// 报废总数量（申请总数量）

            tooltransfer = tooltransferList.get ( 0 );

            result.put ( "ToolThisState", tooltransfer.getToolThisState () );// 刀具部门
            result.put ( "ToolInfoDetailList", tooltransferList );// 刀具信息列表
            result.put ( "status", IConstant.RESULT_CODE_0 );
            return result;
        } catch (SQLException e) {
            result.put ( "status", IConstant.RESULT_CODE_2 );
            result.put ( "messageCode", IConstant.EMSG0004 );
            return result;
        }
    }

    /**
     * 取得扫描RFID的刀具信息（非单品）
     *
     * @param rtn
     * @return
     */
    public Map<String, Object> saveToolInfoDetail(Map<String, Object> rtn) {
        // 结果集
        Map<String, Object> result = new HashMap<String, Object> ();
        Redemptionapplied entity = (Redemptionapplied) rtn.get ( "redemptionapplied" );
        try {
            redemptionappliedDao.insert ( entity );
            result.put ( "status", IConstant.RESULT_CODE_0 );
            return result;
        } catch (SQLException e) {
            e.printStackTrace ();
            result.put ( "status", IConstant.RESULT_CODE_2 );
            result.put ( "messageCode", IConstant.EMSG0007 );
            return result;
        }
    }

    /**
     * 取得扫描RFID的刀具信息（非单品）
     *
     * @param rtn
     * @return
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> updateTooltransfer(Map<String, Object> rtn) {
        int reVal = 0;
        // 结果集
        Map<String, Object> result = new HashMap<String, Object> ();

        String rfidContarnerId = (String) rtn.get ( "rfidContarnerId" );
        String userId = (String) rtn.get ( "userId" );
        String gruantUserID = (String) rtn.get ( "gruantUserID" );// 授权人
        String lostNum = (String) rtn.get ( "lostNum" );// 丢失数量
        String toolId = (String) rtn.get ( "toolId" );// 刀具id
        String toolCode = (String) rtn.get ( "toolCode" );// 刀具编码
        String handerId = (String) rtn.get ( "handerId" );// 手持机编码
        String appliedNumber = (String) rtn.get ( "appliedNumber" );// 申请数量
        int suerNum = Integer.parseInt ( appliedNumber ) - Integer.parseInt ( lostNum );

        Tooltransfer entity = null;
        List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory> ();
        Tooltransferhistory tth = null;
        List<Toolwholelifecycle> tlcList = new ArrayList<Toolwholelifecycle> ();
        Toolwholelifecycle toolwholelifecycle = null;

        try {

            // 取得流转刀具信息
            Tooltransfer tooltransfer = new Tooltransfer ();
            tooltransfer.setRfidContainerID ( rfidContarnerId );// 载体ID
            tooltransfer.setToolID ( toolId );
            tooltransfer.setDelFlag ( IConstant.DEL_FLAG_0 );
            tooltransfer.setOrderString ( "ToolState ASC" );
            tooltransfer.setStaIndex ( 0 );
            tooltransfer.setRowCount ( suerNum + Integer.parseInt ( lostNum ) );// 确认数量
            List<Tooltransfer> tooltransferList = (List<Tooltransfer>) tooltransferDao.searchByList ( tooltransfer );

            // 取得业务流程ID
            Business business = new Business ();
            business.setBusinessCode ( "C01S016" );
            List<Business> businessList = (List<Business>) businessDao.searchByList ( business );
            business = businessList.get ( 0 );
            Businessflowlnk businessflowlnks = new Businessflowlnk ();
            businessflowlnks.setBusinessID ( business.getBusinessID () );
            List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList ( businessflowlnks );
            String businessFlowLnkID = list1.get ( 0 ).getBusinessFlowLnkID ();

            // ------更新确认报废刀具---start----
            for (Tooltransfer tt : tooltransferList) {
                // 记录生命周期
                if (handerId != null) {
                    toolwholelifecycle = new Toolwholelifecycle ();
                    toolwholelifecycle.setBusinessFlowLnkID ( businessFlowLnkID );
                    toolwholelifecycle.setHandSetID ( handerId );
                    // 取得刀具信息
                    Tool tool = new Tool ();
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
                    if (gruantUserID != null)
                        toolwholelifecycle.setUpdateUser ( gruantUserID );
                    toolwholelifecycle.setVersion ( BigDecimal.ZERO );
                    toolwholelifecycle.setToolWholeLifecycleID ( UUID.randomUUID ().toString () );
                    tlcList.add ( toolwholelifecycle );
                }
                // 刀具流转
                entity = new Tooltransfer ();
                entity.setKnifeInventoryCodeWhere ( tt.getKnifeInventoryCode () );
                entity.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
                entity.setRfidContainerID ( IConstant.LIBRARY_CONTARNERID );
                entity.setStockState ( IConstant.STSATIC_ONE );
                entity.setToolThisState ( IConstant.STSATIC_ZERO );// 回库
                entity.setUpdateTime ( new Date () );
                entity.setUpdateUser ( userId );
                entity.setVersion ( tt.getVersion ().add ( BigDecimal.ONE ) );
                tooltransferDao.updateNonQuery ( entity );
                reVal++;

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
                tth.setinUser ( userId );// 接收人
                if (gruantUserID != null) {
                    tth.setoutUser ( gruantUserID );// 转出人
                } else {
                    tth.setoutUser ( userId );
                }
                tth.setStockState ( IConstant.STOCK_STATE_1 );// 报废
                tth.setUpdateTime ( new Date () );// 更新时间
                tth.setUpdateUser ( gruantUserID );// 更新者
                tth.setDelFlag ( IConstant.DEL_FLAG_0 );// 删除区分
                tth.setCreateTime ( new Date () );// 创建时间
                tth.setCreateUser ( userId );// 创建者
                tth.setVersion ( BigDecimal.ZERO );// 版本号
                tthList.add ( tth );
            }
            // ------更新确认刀具---end------
            /*
             * tooltransfer.setStaIndex(0);
			 * tooltransfer.setRowCount(Integer.parseInt(lostNum));
			 * tooltransferList = (List<Tooltransfer>)
			 * tooltransferDao.searchByList(tooltransfer);
			 * //------更新丢失刀具---start---- for (Tooltransfer tt :
			 * tooltransferList) { // 记录生命周期 if (handerId != null) {
			 * toolwholelifecycle = new Toolwholelifecycle();
			 * toolwholelifecycle.setBusinessFlowLnkID(businessFlowLnkID);
			 * toolwholelifecycle.setHandSetID(handerId); // 取得刀具信息 Tool tool =
			 * new Tool(); tool.setToolID(tt.getToolID()); List<Tool> toolList =
			 * (List<Tool>) toolDao.searchByList(tool); if (toolList != null &&
			 * toolList.size() > 0) { tool = toolList.get(0);
			 * toolwholelifecycle.setToolCode(tool.getToolCode());
			 * toolwholelifecycle.setToolName(tool.getToolName()); }
			 * toolwholelifecycle
			 * .setKnifeInventoryCode(tt.getKnifeInventoryCode());
			 * toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
			 * toolwholelifecycle.setCreateTime(new Date());
			 * toolwholelifecycle.setUpdateTime(new Date());
			 * toolwholelifecycle.setCreateUser(userId); if (gruantUserID !=
			 * null) toolwholelifecycle.setUpdateUser(gruantUserID);
			 * toolwholelifecycle.setVersion(BigDecimal.ZERO);
			 * toolwholelifecycle
			 * .setToolWholeLifecycleID(UUID.randomUUID().toString());
			 * tlcList.add(toolwholelifecycle); }
			 * 
			 * //刀具流转 entity = new Tooltransfer();
			 * entity.setToolIDWhere(tt.getToolID());
			 * entity.setKnifeInventoryCodeWhere(tt.getKnifeInventoryCode());
			 * entity.setDelFlagWhere(IConstant.DEL_FLAG_0);
			 * entity.setRfidContainerID(IConstant.LIBRARY_CONTARNERID);
			 * entity.setStockState(IConstant.STSATIC_ONE);
			 * entity.setToolState(IConstant
			 * .TOOL_STATE_1);//刀具状态(0断刀1丢失2不合格3借入4申领
			 * ,5到寿,6厂内待刃磨,7.厂外待刃磨8刃磨完毕,9其他)
			 * entity.setToolThisState(IConstant.STSATIC_ZERO);//回库
			 * entity.setUpdateTime(new Date()); entity.setUpdateUser(userId);
			 * entity.setVersion(tt.getVersion().add(BigDecimal.ONE));
			 * tooltransferDao.updateNonQuery(entity); reVal++;
			 * 
			 * // 刀具流转履历 tth = new Tooltransferhistory();
			 * tth.setToolTransferHistoryID(UUID.randomUUID().toString());
			 * tth.setRfidContainerID(tt.getRfidContainerID()); // RFID载体ID
			 * tth.setKnifeInventoryCode(tt.getKnifeInventoryCode());// 刀具入库编码
			 * tth.setToolID(tt.getToolID());// 刀具ID
			 * tth.setToolProcuredID(tt.getToolProcuredID());// 采购ID
			 * tth.setBusinessFlowLnkID(tt.getBusinessFlowLnkID());// 最后执行业务流程
			 * tth.setToolDurable(tt.getToolDurable());// 耐用度
			 * tth.setToolSharpennum(tt.getToolDurable());// 可使用(刃磨)次数
			 * tth.setToolSharpenCriterion(tt.getToolSharpenCriterion());// 复磨标准
			 * tth.setToolLength(tt.getToolLength());// 刀具长度
			 * tth.setToolSharpenLength(tt.getToolSharpenLength());// 可刃磨长度
			 * tth.setUsageCounter(tt.getUsageCounter());// 已使用(刃磨)次数
			 * tth.setToolGrindingLength(tt.getToolGrindingLength());// 刀具已刃磨长度
			 * tth.setInstallationState(IConstant.INSTALLATION_STATE_1);//
			 * 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
			 * tth.setToolState(IConstant.TOOL_STATE_1);//
			 * 刀具状态(0断刀1丢失2不合格3借入4申领9其他) tth.setinUser(userId);// 接收人 if
			 * (gruantUserID != null) { tth.setoutUser(gruantUserID);//转出人 }
			 * else { tth.setoutUser(userId); }
			 * tth.setStockState(IConstant.STOCK_STATE_1);//报废
			 * tth.setUpdateTime(new Date());// 更新时间
			 * tth.setUpdateUser(gruantUserID);// 更新者
			 * tth.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
			 * tth.setCreateTime(new Date());// 创建时间
			 * tth.setCreateUser(userId);// 创建者
			 * tth.setVersion(BigDecimal.ZERO);// 版本号 tthList.add(tth); }
			 */

            if (reVal < Integer.parseInt ( appliedNumber )) {
                throw new RuntimeException ();
            } else {
                result.put ( "status", IConstant.RESULT_CODE_0 );
            }
            // 增加生命周期
            if (tlcList.size () > 0)
                toolwholelifecycleDao.insertBatchs ( tlcList );
            // 批量增加【刀具流转履历】
            if (tthList.size () > 0)
                tooltransferhistoryDao.insertBatchDefined ( tthList );
            return result;
        } catch (SQLException e) {
            result.put ( "status", IConstant.RESULT_CODE_2 );
            result.put ( "messageCode", IConstant.EMSG0004 );
            return result;
        }
    }

    @Override
    public Rfidcontainer getRfidContainerIDByRfidCode(Rfidcontainer entity) throws Exception {
        List<Rfidcontainer> reList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( entity );
        Rfidcontainer reEntity = new Rfidcontainer ();
        if (reList.size () < 1) {
            // 未找到相应数据
            reEntity.setRetErrFlag ( true );
        } else {
            reEntity = reList.get ( 0 );
        }
        return reEntity;
    }

    /**
     * 保存旧刀交接信息
     *
     * @param list
     * @return
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> saveToolJoint(List<Map<String, Object>> list) {
        Map<String, Object> result = new HashMap<String, Object> ();
        try {
            for (Map<String, Object> map : list) {
                // 修复通知单号
                String handsetID = map.get ( "handsetid" ).toString ();
                String customerID = map.get ( "UpdateUser" ).toString ();
                String toolRepairNoticeID = map.get ( "ToolRepairNoticeID" ).toString ();
                List<String> rfidList = (List<String>) map.get ( "RfidStringList" );
                List<Integer> returnCountList = (List<Integer>) map.get ( "returnCountList" );
                Date date = new Date ();
                // 更新修复通知单内容
                for (int i = 0; i < rfidList.size (); i++) {
                    Rfidcontainer rfidcontainer = new Rfidcontainer ();
                    rfidcontainer.setRfidCode ( rfidList.get ( i ) );
                    rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
                    List<Rfidcontainer> rfidcontainerist = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
                    if (rfidList == null || rfidList.size () == 0) {
                        // 当前扫描的RFID未绑定刀具!
                        result.put ( "status", IConstant.RESULT_CODE_1 );
                        result.put ( "messageCode", IConstant.WMSG0143 );
                        return result;
                    }
                    rfidcontainer = rfidcontainerist.get ( 0 );
                    Toolrepairnotice toolrepairnotice = new Toolrepairnotice ();
                    toolrepairnotice.setRfidCode ( rfidcontainer.getRfidContainerID () );
                    toolrepairnotice.setToolRepairNoticeID ( toolRepairNoticeID );
                    toolrepairnotice = (Toolrepairnotice) toolrepairnoticeDao.searchByPrimaryKey ( toolrepairnotice );
                    toolrepairnotice.setRfidCodeWhere ( getRFIDCode ( rfidList.get ( i ) ) ); // 载体id
                    toolrepairnotice.setToolRepairNoticeIDWhere ( toolRepairNoticeID );
                    toolrepairnotice.setVersion ( toolrepairnotice.getVersion ().add ( BigDecimal.ONE ) );
                    toolrepairnotice.setUpdateTime ( date );
                    toolrepairnotice.setUpdateUser ( customerID );// 更新者
                    toolrepairnotice.setReturnUser ( customerID );// 送回人
                    toolrepairnotice.setReturnTime ( date );// 送回时间
                    toolrepairnotice.setSentBackNumber ( new BigDecimal ( map.get ( "SentBackNumber" ).toString () ) );// 应送回数量
                    toolrepairnotice.setRealSentBackNumber ( new BigDecimal ( returnCountList.get ( i ) ) );// 实际送回数量
                    toolrepairnotice.setRecoverLostNumber ( new BigDecimal ( map.get ( "SentBackNumber" ).toString () ).subtract ( new BigDecimal ( returnCountList.get ( i ) ) ) );// 丢失数量
                    if (map.get ( "GruantUserID" ) != null) {
                        toolrepairnotice.setLostIdentifyingUser ( map.get ( "GruantUserID" ).toString () );
                    }
                    toolrepairnoticeDao.updateNonQuery ( toolrepairnotice );

                    // 取得流转刀具信息
                    Tooltransfer tooltransfer = new Tooltransfer ();
                    tooltransfer.setRfidContainerID ( rfidcontainer.getRfidContainerID () );// 取得载体ID
                    List<Tooltransfer> tooltransferList = (List<Tooltransfer>) tooltransferDao.searchByList ( tooltransfer );

                    // 取得当前刀具的最后执行业务流程
                    Businessflowlnk businessflowlnk = new Businessflowlnk ();
                    // 取得业务流程ID
                    Business business = new Business ();
                    business.setBusinessCode ( "C01S016" );
                    List<Business> businessList = (List<Business>) businessDao.searchByList ( business );
                    business = businessList.get ( 0 );
                    Businessflowlnk businessflowlnks = new Businessflowlnk ();
                    businessflowlnks.setBusinessID ( business.getBusinessID () );
                    List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList ( businessflowlnks );
                    businessflowlnk = list1.get ( 0 );
                    // 更新流转刀具信息
                    for (Tooltransfer tooltransfer2 : tooltransferList) {
                        // 更新刀具流转履历
                        Tooltransferhistory tooltransferhistory = new Tooltransferhistory ();
                        tooltransferhistory.setToolTransferHistoryID ( NextKeyValue.getNextkeyvalue ( IConstant.TOOLTRANSFERHISTORY, IConstant.TOOLTRANSFERHISTORYID, customerID ) );
                        tooltransferhistory.setToolID ( tooltransfer2.getToolID () );
                        tooltransferhistory.setRfidContainerID ( tooltransfer2.getRfidContainerID () );
                        tooltransferhistory.setKnifeInventoryCode ( tooltransfer2.getKnifeInventoryCode () );
                        tooltransferhistory.setToolProcuredID ( tooltransfer2.getProcuredBatch () );
                        tooltransferhistory.setBusinessFlowLnkID ( tooltransfer2.getBusinessFlowLnkID () );
                        tooltransferhistory.setToolDurable ( tooltransfer2.getToolDurable () );
                        tooltransferhistory.setToolSharpennum ( tooltransfer2.getToolSharpennum () );
                        tooltransferhistory.setToolSharpenCriterion ( tooltransfer2.getToolSharpenCriterion () );
                        tooltransferhistory.setToolLength ( tooltransfer2.getToolLength () );
                        tooltransferhistory.setToolSharpenLength ( tooltransfer2.getToolSharpenLength () );
                        tooltransferhistory.setUsageCounter ( tooltransfer2.getUsageCounter () );
                        tooltransferhistory.setToolGrindingLength ( tooltransfer2.getToolGrindingLength () );
                        tooltransferhistory.setInstallationState ( tooltransfer2.getInstallationState () );
                        tooltransferhistory.setToolState ( tooltransfer2.getToolState () );
                        tooltransferhistory.setReplacementFlag ( tooltransfer2.getReplacementFlag () );
                        tooltransferhistory.setoutUser ( tooltransfer2.getUpdateUser () );
                        // 需要写入转出者(转出者为上一条数据的接收者)
                        tooltransferhistory.setinUser ( customerID );
                        tooltransferhistory.setConfirmedUser ( tooltransfer2.getConfirmedUser () );
                        if (IConstant.STOCK_STATE_4.equals ( tooltransfer2.getStockState () )) {
                            tooltransferhistory.setStockState ( IConstant.STOCK_STATE_0 );
                        }
                        tooltransferhistory.setDelFlag ( IConstant.DEL_FLAG_0 );
                        tooltransferhistory.setUpdateTime ( date );
                        tooltransferhistory.setUpdateUser ( customerID );
                        tooltransferhistory.setCreateTime ( date );
                        tooltransferhistory.setCreateUser ( customerID );
                        tooltransferhistory.setVersion ( BigDecimal.ZERO );
                        tooltransferhistoryDao.insert ( tooltransferhistory );
                        // 更新刀具流转信息
                        tooltransfer2.setBusinessFlowLnkID ( businessflowlnk.getBusinessFlowLnkID () );
                        tooltransfer2.setUpdateTime ( date );
                        tooltransfer2.setUpdateUser ( customerID );
                        if (!IConstant.STOCK_STATE_1.equals ( tooltransfer2.getStockState () )) {
                            tooltransfer2.setStockState ( IConstant.STOCK_STATE_0 );
                        }
                        if (IConstant.STOCK_STATE_4.equals ( tooltransfer2.getStockState () )) {
                            tooltransfer2.setStockState ( IConstant.STOCK_STATE_0 );
                        }
                        if (IConstant.TOOL_STATE_1.equals ( tooltransfer2.getToolState () )) {
                            tooltransfer2.setDelFlag ( IConstant.DEL_FLAG_1 );
                        }
                        tooltransfer2.setVersion ( tooltransfer2.getVersion ().add ( BigDecimal.ONE ) );
                        tooltransfer2.setRfidContainerIDWhere ( tooltransfer2.getRfidContainerID () );
                        tooltransfer2.setKnifeInventoryCodeWhere ( tooltransfer2.getKnifeInventoryCode () );
                        tooltransferDao.updateNonQuery ( tooltransfer2 );
                        // 记录刀具生命周期数据
                        Toolwholelifecycle toolwholelifecycle = new Toolwholelifecycle ();
                        toolwholelifecycle.setBusinessFlowLnkID ( businessflowlnk.getBusinessFlowLnkID () );
                        toolwholelifecycle.setHandSetID ( handsetID );
                        // 取得刀具信息
                        Tool tool = new Tool ();
                        tool.setToolID ( tooltransfer2.getToolID () );
                        List<Tool> toolList = (List<Tool>) toolDao.searchByList ( tool );
                        if (toolList == null || toolList.size () <= 0) {
                            // 当前刀具编码未记录!
                            result.put ( "status", IConstant.RESULT_CODE_1 );
                            result.put ( "messageCode", IConstant.WMSG0116 );
                            return result;
                        } else {
                            tool = toolList.get ( 0 );
                        }
                        toolwholelifecycle.setToolCode ( tool.getToolCode () );
                        toolwholelifecycle.setToolName ( tool.getToolName () );
                        toolwholelifecycle.setKnifeInventoryCode ( tooltransfer2.getKnifeInventoryCode () );
                        toolwholelifecycle.setDelFlag ( IConstant.DEL_FLAG_0 );
                        toolwholelifecycle.setCreateTime ( date );
                        toolwholelifecycle.setUpdateTime ( date );
                        toolwholelifecycle.setCreateUser ( customerID );
                        toolwholelifecycle.setUpdateUser ( customerID );
                        toolwholelifecycle.setVersion ( BigDecimal.ZERO );
                        String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue ( IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, customerID );
                        toolwholelifecycle.setToolWholeLifecycleID ( toolWholeLifecycleID );
                        toolwholelifecycleDao.insert ( toolwholelifecycle );
                    }
                }
            }
            result.put ( "status", IConstant.RESULT_CODE_0 );
            return result;
        } catch (SQLException e) {
            result.put ( "status", IConstant.RESULT_CODE_2 );
            result.put ( "messageCode", IConstant.EMSG0004 );
            return result;
        }
    }

    /**
     * 根据载体ID查找RFIDCode
     *
     * @param rfidCode
     * @return
     */
    private String getRFIDCode(String rfidCode) throws SQLException {
        Rfidcontainer rfidcontainer = new Rfidcontainer ();
        rfidcontainer.setRfidCode ( rfidCode );
        rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
        return ((Rfidcontainer) rfidcontainerDao.searchByList ( rfidcontainer ).get ( 0 )).getRfidContainerID ();
    }

    /**
     * 待报废刀具流转表信息
     *
     * @param entity
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Tooltransfer> getToolTransferList(Tooltransfer entity) throws Exception {
        List<Tooltransfer> reList = (List<Tooltransfer>) tooltransferDao.searchByList2 ( entity );
        Tooltransfer reEntity = new Tooltransfer ();
        if (reList.size () < 1) {
            // 未找到相应数据
            reEntity.setRetErrFlag ( true );
        } else {
            reEntity = reList.get ( 0 );
        }
        return reList;
    }

    /**
     * 取得丢刀信息
     *
     * @param entity
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public Tooltransfer getToolTransfer(Tooltransfer entity) throws SQLException {
        List<Tooltransfer> reList = (List<Tooltransfer>) tooltransferDao.searchByList ( entity );
        Tooltransfer reEntity = new Tooltransfer ();
        if (reList.size () < 1) {
            // 未找到相应数据
            reEntity.setRetErrFlag ( true );
        } else {
            reEntity = reList.get ( 0 );
            reEntity.setRetErrFlag ( false );
        }
        return reEntity;
    }

    /**
     * 提交回库处理刀具信息
     *
     * @param customerID
     * @param list
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> saveToolLibraryInfo(String customerID, List<Map<String, Object>> list) throws Exception {
        Map<String, Object> result = new HashMap<String, Object> ();

        try {
            for (Map<String, Object> map : list) {
                // 签收人id
                String signID = null;
                if (map.get ( "SignID" ) != null) {
                    signID = (String) map.get ( "SignID" );
                }
                // 报废数量
                String scrapCount = (String) map.get ( "ScrapCount" );
                // 确认数量
                String confirmCount = (String) map.get ( "ConfirmCount" );

                Rfidcontainer rfidcontainer = new Rfidcontainer ();
                rfidcontainer.setRfidCode ( (String) map.get ( "RfidCode" ) );
                rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
                List<Rfidcontainer> rfidConner = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
                if (rfidConner.size () < 1) {
                    result.put ( "status", IConstant.RESULT_CODE_2 );
                    result.put ( "messageCode", IConstant.EMSG0004_A );
                    return result;
                }
                String rfidID = rfidConner.get ( 0 ).getRfidContainerID ();
                String qertype = rfidConner.get ( 0 ).getQueryType ();
                // 取得流转刀具信息--丢刀
                Tooltransfer tf2 = new Tooltransfer ();
                // 取得载体ID
                tf2.setRfidContainerID ( rfidID );
                // 取得刀具ID
                tf2.setToolID ( (String) map.get ( "ToolID" ) );
                // 刀具状态(0断刀1丢失2不合格3待分拣4待换装,5到寿,6厂内待刃磨,7.厂外待刃磨8刃磨完毕,9其他)
                tf2.setToolState ( IConstant.DEL_FLAG_1 );
                tf2.setDelFlag ( IConstant.DEL_FLAG_0 );
                List<Tooltransfer> tts = (List<Tooltransfer>) tooltransferDao.searchByList ( tf2 );
                if (tts != null && tts.size () > 0) {
                    Tooltransfer tt = new Tooltransfer ();
                    //where
                    tt.setRfidContainerIDWhere ( rfidID );
                    tt.setToolIDWhere ( tf2.getToolID () );
                    tt.setBusinessFlowLnkIDWhere ( IConstant.C01S010 );
                    tt.setToolStateWhere ( IConstant.STRING_1 );
                    // 刀具部门：对刀室
                    tt.setToolThisStateWhere ( IConstant.STRING_1 );
                    // 库存状态：报废
                    tt.setStockStateWhere ( IConstant.STRING_1 );

                    // 更新刀具流转信息
                    tt.setBusinessFlowLnkID ( IConstant.C01S016 );
                    tt.setToolThisState ( IConstant.STRING_0 );
                    tt.setDelFlag ( IConstant.STRING_1 );
                    tt.setUpdateTime ( new Date () );
                    tt.setUpdateUser ( customerID );
                    tooltransferDao.updateNonQuery ( tt );

                    //						// 取得刀具信息
                    //						tool.setToolID(tooltransfer2.getToolID());
                    //						List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
                    //						if (toolList == null || toolList.size() <= 0) {
                    //							// 当前刀具编码未记录!
                    //							result.put("status", IConstant.RESULT_CODE_1);
                    //							result.put("messageCode", IConstant.WMSG0116);
                    //							return result;
                    //						} else {
                    //							tool = toolList.get(0);
                    //						}
                }
                //				// 取得流转刀具信息--报废
                //				Tooltransfer tf1 = new Tooltransfer();
                //				// 取得载体ID
                //				tf1.setRfidContainerID(rfidcontainer.getRfidContainerID());
                //				// 取得刀具ID
                //				tf1.setToolID(map.get("ToolID").toString());
                //				// 库存状态(0正常1报废2返厂3封存4.流转9其他)
                //				tf1.setStockState(IConstant.DEL_FLAG_1);
                //				tf1.setDelFlag(IConstant.DEL_FLAG_0);
                //				List<Tooltransfer> tooltransferList2 =  tooltransferDao.tooltransferList2(tf1);
                //				if(tooltransferList2.size() < 1){
                //					result.put("status", IConstant.RESULT_CODE_2);
                //					result.put("messageCode", IConstant.EMSG0004_A);
                //					return result;
                //				}
                if (IConstant.STRING_5.equals ( qertype )) {
                    // 更新流转表
                    Tooltransfer tt = new Tooltransfer ();
                    if (Integer.parseInt ( scrapCount ) - Integer.parseInt ( confirmCount ) == 0) {
                        // 报废容器的载体id
                        tt.setRfidContainerIDWhere ( rfidID );
                        // 刀具id
                        tt.setToolIDWhere ( map.get ( "ToolID" ).toString () );
                        // 刀具状态：到寿
                        tt.setToolStateWhere ( IConstant.STRING_5 );
                        // 刀具部门：对刀室
                        tt.setToolThisStateWhere ( IConstant.STRING_1 );
                        // 库存状态：报废
                        tt.setStockStateWhere ( IConstant.STRING_1 );
                        tt.setDelFlagWhere ( IConstant.STRING_0 );
                        // set
                        // 回库处理
                        tt.setBusinessFlowLnkID ( IConstant.C01S016 );
                        // 刀具部门：库房
                        tt.setToolThisState ( IConstant.STRING_0 );
                        // 全部回库，则删除这条记录
                        tt.setDelFlag ( IConstant.STRING_1 );
                        tt.setUpdateTime ( new Date () );
                        tt.setUpdateUser ( customerID );
                        tooltransferDao.updateNonQuery ( tt );
                    } else {
                        // 更新并插入流转表
                        // 报废容器的载体id
                        tt.setRfidContainerIDWhere ( rfidID );
                        // 刀具id
                        tt.setToolIDWhere ( map.get ( "ToolID" ).toString () );
                        // 刀具状态：到寿
                        tt.setToolStateWhere ( IConstant.STRING_5 );
                        // 刀具部门：对刀室
                        tt.setToolThisStateWhere ( IConstant.STRING_1 );
                        // 库存状态：报废
                        tt.setStockStateWhere ( IConstant.STRING_1 );
                        tt.setDelFlagWhere ( IConstant.STRING_0 );
                        // set 报废数量
                        tt.setToolDurable ( new BigDecimal ( Integer.parseInt ( scrapCount ) - Integer.parseInt ( confirmCount ) ) );
                        tt.setUpdateTime ( new Date () );
                        tt.setUpdateUser ( customerID );
                        tooltransferDao.updateNonQuery ( tt );

                        tt = new Tooltransfer ();
                        tt.setRfidContainerID ( rfidID );
                        tt.setToolID ( map.get ( "ToolID" ).toString () );
                        tt.setKnifeInventoryCode ( UUIDgen.getId () );
                        tt.setBusinessFlowLnkID ( IConstant.C01S016 );//回库处理
                        tt.setToolDurable ( new BigDecimal ( confirmCount ) );//已报废数量
                        tt.setToolState ( IConstant.STRING_5 );
                        tt.setToolThisState ( IConstant.STRING_0 );
                        tt.setStockState ( IConstant.STRING_1 );
                        tt.setDelFlag ( IConstant.DEL_FLAG_1 );//报废标识
                        tt.setCreateTime ( new Date () );
                        tt.setCreateUser ( customerID );
                        tt.setUpdateTime ( new Date () );
                        tt.setUpdateUser ( customerID );
                        tooltransferDao.insert ( tt );
                    }

                    // 插入换领申请
                    Redemptionapplied reentity = new Redemptionapplied ();
                    // 换领申请流水号
                    reentity.setRedemptionAppliedID ( UUIDgen.getId () );
                    // 刀具编码
                    reentity.setToolCode ( map.get ( "MaterialNum" ).toString () );
                    // 领取数量
                    reentity.setReceiveNumber ( BigDecimal.ZERO );
                    // 申请数量(确认数量+丢刀数量)
                    reentity.setAppliedNumber ( new BigDecimal ( Integer.parseInt ( map.get ( "ConfirmCount" ).toString () ) + Integer.parseInt ( map.get ( "LostCount" ).toString () ) ) );
                    // 丢失数量
                    reentity.setLostNumber ( new BigDecimal ( map.get ( "LostCount" ).toString () ) );
                    //申请时间
                    reentity.setApplyTime ( new Date () );
                    //申请人
                    reentity.setApplyUser ( signID );
                    //接收时间
                    reentity.setReceiveTime ( new Date () );
                    // 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )
                    reentity.setProcessingStatus ( IConstant.DEL_FLAG_0 );
                    // 删除区分(0有效1删除)
                    reentity.setDelFlag ( IConstant.DEL_FLAG_0 );
                    // 更新时间
                    reentity.setUpdateTime ( new Date () );
                    // 更新者
                    reentity.setUpdateUser ( customerID );
                    // 创建时间
                    reentity.setCreateTime ( new Date () );
                    // 创建者
                    reentity.setCreateUser ( customerID );
                    //版本号
                    reentity.setVersion ( BigDecimal.ONE );

                    redemptionappliedDao.insert ( reentity );
                    for (Tooltransfer t1 : tts) {
                        // 插入报废表
                        Scrap spentity = new Scrap ();
                        // 报废ID
                        spentity.setScrapID ( UUIDgen.getId () );
                        // 刀具分类(0刀具1辅具2配套9其他）
                        spentity.setToolType ( IConstant.DEL_FLAG_0 );
                        // 材料号
                        spentity.setMaterial ( map.get ( "MaterialNum" ).toString () );
                        // 刀具ID
                        spentity.setToolID ( map.get ( "ToolID" ).toString () );

                        //流程   TODO需要在流转表中取
                        spentity.setBusinessID ( IConstant.C01S016 );
                        // 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他） TODO需要在流转表中取
                        spentity.setScrapState ( IConstant.USER_BLOOD_GROUP_2 );
                        //授权人   TODO需要在流转表中取
                        spentity.setAuthorizationID ( customerID );
                        //报废原因   TODO需要在流转表中取
                        //已刃磨次数
                        spentity.setUsageCounter ( t1.getUsageCounter () );
                        spentity.setKnifeInventoryCode ( t1.getKnifeInventoryCode () );
                        // 报废时间
                        spentity.setScrapTime ( new Date () );
                        // 更新时间
                        spentity.setUpdateTime ( new Date () );
                        // 更新者
                        spentity.setUpdateUser ( customerID );
                        // 创建时间
                        spentity.setCreateUser ( customerID );
                        spentity.setCreateTime ( new Date () );
                        // 创建者
                        scrapDao.insert ( spentity );
                    }
                } else if (IConstant.STRING_1.equals ( qertype )) {
                    // 获取单品刀具的报废状态
                    Tooltransfer tt = new Tooltransfer ();
                    tt.setRfidContainerID ( rfidID );
                    // 刀具状态为待报废
                    tt.setStockState ( IConstant.STRING_1 );
                    tt.setDelFlag ( IConstant.DEL_FLAG_0 );
                    List<Tooltransfer> ttList = (List<Tooltransfer>) tooltransferDao.searchByList ( tt );
                    // 报废状态
                    String toolState = null;
                    Tooltransfer tt1 = null;
                    if (ttList.size () > 0) {
                        toolState = ttList.get ( 0 ).getToolState ();
                        tt1 = ttList.get ( 0 );
                    }

                    // 更新流转表
                    tt = new Tooltransfer ();
                    // 钻头的载体id
                    tt.setRfidContainerIDWhere ( rfidID );
                    // 刀具id
                    tt.setToolIDWhere ( map.get ( "ToolID" ).toString () );
                    // 库存状态：报废
                    tt.setStockStateWhere ( IConstant.STRING_1 );
                    // set
                    tt.setBusinessFlowLnkID ( IConstant.C01S016 );
                    tt.setToolThisState ( IConstant.STRING_0 );
                    tt.setDelFlag ( IConstant.STRING_1 );
                    tt.setUpdateTime ( new Date () );
                    tt.setUpdateUser ( customerID );
                    tooltransferDao.updateNonQuery ( tt );

                    //释放rfid标签
                    Rfidcontainer r = new Rfidcontainer ();
                    r.setRfidContainerIDWhere ( rfidID );
                    r.setDelFlagWhere ( IConstant.STRING_0 );
                    rfidcontainerDao.delete ( r );

                    Redemptionapplied rd = new Redemptionapplied ();
                    rd.setToolCode ( map.get ( "MaterialNum" ).toString () );
                    rd.setApplyUser ( signID );
                    rd.setProcessingStatus ( IConstant.PROCESSING_STATUS_0 );
                    rd.setDelFlag ( IConstant.STRING_0 );
                    List<Redemptionapplied> redemptionappliedList = (List<Redemptionapplied>) redemptionappliedDao.searchByList ( rd );

                    // 确认数量
                    if (redemptionappliedList.size () > 0) {
                        BigDecimal count = redemptionappliedList.get ( 0 ).getAppliedNumber ();
                        int toolDurable = Integer.parseInt ( map.get ( "ConfirmCount" ).toString () );
                        rd.setToolCodeWhere ( map.get ( "MaterialNum" ).toString () );
                        rd.setApplyUserWhere ( signID );
                        rd.setProcessingStatusWhere ( IConstant.PROCESSING_STATUS_0 );
                        rd.setDelFlagWhere ( IConstant.STRING_0 );
                        rd.setAppliedNumber ( count.add ( new BigDecimal ( toolDurable ) ) );
                        redemptionappliedDao.updateNonQuery ( rd );
                    } else {
                        // 插入换领申请
                        Redemptionapplied reentity = new Redemptionapplied ();
                        // 换领申请流水号
                        reentity.setRedemptionAppliedID ( UUIDgen.getId () );
                        // 刀具编码
                        reentity.setToolCode ( map.get ( "MaterialNum" ).toString () );
                        // 领取数量
                        reentity.setReceiveNumber ( BigDecimal.ZERO );
                        // 申请数量(确认数量)
                        reentity.setAppliedNumber ( new BigDecimal ( map.get ( "ConfirmCount" ).toString () ) );
                        //申请时间
                        reentity.setApplyTime ( new Date () );
                        //申请人
                        reentity.setApplyUser ( signID );
                        // 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )
                        reentity.setProcessingStatus ( IConstant.DEL_FLAG_0 );
                        // 删除区分(0有效1删除)
                        reentity.setDelFlag ( IConstant.DEL_FLAG_0 );
                        // 更新时间
                        reentity.setUpdateTime ( new Date () );
                        // 更新者
                        reentity.setUpdateUser ( customerID );
                        // 创建时间
                        reentity.setCreateTime ( new Date () );
                        // 创建者
                        reentity.setCreateUser ( customerID );
                        //版本号
                        reentity.setVersion ( BigDecimal.ONE );

                        redemptionappliedDao.insert ( reentity );
                    }
                    // 插入报废表
                    Scrap spentity = new Scrap ();
                    // 报废ID
                    spentity.setScrapID ( UUIDgen.getId () );
                    // 刀具分类(0刀具1辅具2配套9其他）
                    spentity.setToolType ( IConstant.DEL_FLAG_0 );
                    // 材料号
                    spentity.setMaterial ( map.get ( "MaterialNum" ).toString () );
                    // 刀具ID
                    spentity.setToolID ( map.get ( "ToolID" ).toString () );
                    if (tt1 != null) {
                    //已刃磨次数
                    spentity.setUsageCounter ( tt1.getUsageCounter () );
                    spentity.setKnifeInventoryCode ( tt1.getKnifeInventoryCode () );
                    }
                    //流程   需要在流转表中取
                    spentity.setBusinessID ( IConstant.C01S016 );
                    // 报废数量(钻头默认为1)
                    spentity.setScrapNumber ( BigDecimal.ONE );
                    // 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他） TODO需要在流转表中取
                    if ("0".equals ( toolState )) {
                        spentity.setScrapState ( IConstant.STRING_0 );
                    } else if ("1".equals ( toolState )) {
                        spentity.setScrapState ( IConstant.STRING_1 );
                    } else if ("5".equals ( toolState )) {
                        spentity.setScrapState ( IConstant.STRING_2 );
                    } else if ("9".equals ( toolState )) {
                        spentity.setScrapState ( IConstant.STRING_9 );
                    }
                    //授权人   TODO需要在流转表中取
                    spentity.setAuthorizationID ( customerID );
                    //报废原因   TODO需要在流转表中取
                    // 报废时间
                    spentity.setScrapTime ( new Date () );
                    // 更新时间
                    spentity.setUpdateTime ( new Date () );
                    // 更新者
                    spentity.setUpdateUser ( customerID );
                    // 创建时间
                    spentity.setCreateTime ( new Date () );
                    // 创建者
                    spentity.setCreateUser ( customerID );
                    scrapDao.insert ( spentity );

                    //查询刀具入库编码
                    String knifeInventoryCode = null;
                    tt = new Tooltransfer ();
                    tt.setRfidContainerID ( rfidID );
                    List<Tooltransfer> ttList2 = (List<Tooltransfer>) tooltransferDao.searchByList ( tt );
                    if (ttList2.size () > 0) {
                        knifeInventoryCode = ttList2.get ( 0 ).getKnifeInventoryCode ();
                    }

                    //建立生命周期
                    Toolwholelifecycle twl = new Toolwholelifecycle ();
                    // 刀具全生命周期id
                    twl.setToolWholeLifecycleID ( UUIDgen.getId () );
                    // 刀具入库编码
                    if (knifeInventoryCode != null) {
                        twl.setKnifeInventoryCode ( knifeInventoryCode );
                    } else {
                        twl.setKnifeInventoryCode ( "" );
                    }
                    // 流程id
                    twl.setBusinessFlowLnkID ( IConstant.C01S016 );
                    // 手持机id
                    twl.setHandSetID ( map.get ( "HandSetID" ).toString () );
                    // 刀具id
                    twl.setToolID ( map.get ( "ToolID" ).toString () );
                    //零部件id
                    twl.setPartsID ( "" );
                    //加工数量
                    twl.setProcessAmount ( "0" );
                    //删除区分(0有效1删除)
                    twl.setDelFlag ( IConstant.DEL_FLAG_0 );
                    //更新时间
                    twl.setUpdateTime ( new Date () );
                    //更新者
                    twl.setUpdateUser ( customerID );
                    //创建时间
                    twl.setCreateTime ( new Date () );
                    //创建者
                    twl.setCreateUser ( customerID );
                    //刃磨次数
                    twl.setVersion ( BigDecimal.ZERO );
                    toolwholelifecycleDao.insert ( twl );
                }
            }

            result.put ( "status", IConstant.RESULT_CODE_0 );
            return result;
        } catch (SQLException e) {
            result.put ( "status", IConstant.RESULT_CODE_2 );
            result.put ( "messageCode", IConstant.EMSG0004 );
            return result;
        }
    }

}
