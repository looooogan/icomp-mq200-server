package com.icomp.common.service.impl.icomp.v01c01.s020;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.dao.BaseDao;
import com.icomp.common.service.icomp.v01c01.s020.ICOMPV01C01S020Service;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.common.utils.UUIDgen;
import com.icomp.dao.KnifeinventoryDao;
import com.icomp.dao.OutsidefactoryDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.TooltransferhistoryDao;
import com.icomp.dao.ToolwholelifecycleDao;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Businessflowlnk;
import com.icomp.entity.base.Outsidefactory;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Tooltransferhistory;
import com.icomp.entity.base.Toolwholelifecycle;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ICOMPV01C01S020ServiceImpl extends BaseService implements ICOMPV01C01S020Service {

    private RfidcontainerDao rfidcontainerDao;
    private OutsidefactoryDao outsidefactoryDao;

    public void setOutsidefactoryDao(OutsidefactoryDao outsidefactoryDao) {
        this.outsidefactoryDao = outsidefactoryDao;
    }

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    private TooltransferDao tooltransferDao;
    private BaseDao businessDao;
    private BaseDao toolDao;
    private BaseDao businessflowlnkDao;
    private ToolwholelifecycleDao toolwholelifecycleDao;
    private TooltransferhistoryDao tooltransferhistoryDao;

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    public void setBusinessDao(BaseDao businessDao) {
        this.businessDao = businessDao;
    }

    public void setToolDao(BaseDao toolDao) {
        this.toolDao = toolDao;
    }

    public void setBusinessflowlnkDao(BaseDao businessflowlnkDao) {
        this.businessflowlnkDao = businessflowlnkDao;
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
     * 验证标签是否已被使用
     *
     * @param entity
     * @return
     */
    @SuppressWarnings("unchecked")
    public Rfidcontainer checkRfid(Rfidcontainer entity) {
        try {
            List<Rfidcontainer> rfidList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( entity );
            if (rfidList != null && rfidList.size () > 0 && IConstant.DEL_FLAG_0.equals ( rfidList.get ( 0 ).getDelFlag () )) {
                // 当前扫描的RFID已绑定刀具!
                entity = new Rfidcontainer ();
                entity.setRetErrFlag ( true );
                entity.setMessageCode ( IConstant.WMSG0147 );
                return entity;
            } else {
                return entity;
            }
        } catch (SQLException e) {
            entity.setRetErrFlag ( true );
            entity.setMessageCode ( IConstant.EMSG0004 );
            entity.setExceMessage ( e.getMessage () );
            return entity;
        }
    }

    /**
     * 验证标签是否已被使用
     *
     * @param entity
     * @return
     */
    @SuppressWarnings("unchecked")
    public Rfidcontainer checkLaserIdentificationCode(Rfidcontainer entity) {
        try {
            List<Rfidcontainer> rfidList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( entity );
            if (rfidList == null || rfidList.size () < 1) {
                // 当前激光码不存在!
                entity = new Rfidcontainer ();
                entity.setRetErrFlag ( true );
                entity.setMessageCode ( IConstant.WMSG0148 );
                return entity;
            } else {
                if (!IConstant.BAND_TYPE_1.equals ( rfidList.get ( 0 ).getBandType () )) {
                    // 当前激光码已绑定!
                    entity = new Rfidcontainer ();
                    entity.setRetErrFlag ( true );
                    entity.setMessageCode ( IConstant.WMSG0149_1 );
                    return entity;
                } else {
                    return entity;
                }
            }
        } catch (SQLException e) {
            entity.setRetErrFlag ( true );
            entity.setMessageCode ( IConstant.EMSG0004 );
            entity.setExceMessage ( e.getMessage () );
            return entity;
        }
    }

    /**
     * 刀具激光码保存
     *
     * @param entity
     * @return
     */
    @SuppressWarnings("unchecked")
    public Rfidcontainer saveFactoryBoringCrown(Rfidcontainer entity) {
        Rfidcontainer rfidcontainer = new Rfidcontainer ();
        List<Toolwholelifecycle> listTlf = new ArrayList<Toolwholelifecycle> ();
        List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory> ();
        List<String> rfidLists = new ArrayList<String> ();
        String userId = entity.getUpdateUser ();
        String handId = entity.getzTreeId ();
        rfidLists.add ( entity.getRfidCode () );
        String businessFlowLnkID = null;
        try {
            rfidcontainer.setLaserIdentificationCode ( entity.getLaserIdentificationCode () );
            List<Rfidcontainer> rfidList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
            if (rfidList == null || rfidList.size () == 0) {
                // 当前激光码不存在!
                rfidcontainer = new Rfidcontainer ();
                rfidcontainer.setRetErrFlag ( true );
                rfidcontainer.setMessageCode ( IConstant.WMSG0148 );
                return rfidcontainer;
            }
            rfidcontainer = rfidList.get ( 0 );
            entity.setRfidContainerIDWhere ( rfidcontainer.getRfidContainerID () );
            entity.setBandType ( IConstant.BAND_TYPE_0 );
            entity.setVersion ( rfidcontainer.getVersion ().add ( BigDecimal.ONE ) );
            String rfidContainerId = rfidcontainer.getRfidContainerID ();
            Tooltransfer tooltransfer = new Tooltransfer ();
            tooltransfer.setRfidContainerID ( rfidContainerId );
            tooltransfer.setDelFlag ( IConstant.DEL_FLAG_0 );
            List<Tooltransfer> tooltransfers = (List<Tooltransfer>) tooltransferDao.searchByList ( tooltransfer );
            if (tooltransfers.size () > 0) {
                // 取得业务流程ID
                Business business = new Business ();
                business.setBusinessCode ( "C01S020" );

                List<Business> businessList = (List<Business>) businessDao.searchByList ( business );
                business = businessList.get ( 0 );
                Businessflowlnk businessflowlnks = new Businessflowlnk ();
                businessflowlnks.setBusinessID ( business.getBusinessID () );
                List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList ( businessflowlnks );
                if (list1.size () < 1) {
                    rfidcontainer.setRetErrFlag ( true );
                    rfidcontainer.setMessageCode ( IConstant.WMSG0119 );
                    return rfidcontainer;
                }
                businessFlowLnkID = list1.get ( 0 ).getBusinessFlowLnkID ();
                for (Tooltransfer tt : tooltransfers) {
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
                        toolwholelifecycle.setToolCode ( tool.getToolCode () );
                        toolwholelifecycle.setToolName ( tool.getToolName () );
                    }
                    toolwholelifecycle.setKnifeInventoryCode ( tt.getKnifeInventoryCode () );
                    toolwholelifecycle.setDelFlag ( IConstant.DEL_FLAG_0 );
                    toolwholelifecycle.setCreateTime ( new Date () );
                    toolwholelifecycle.setUpdateTime ( new Date () );
                    toolwholelifecycle.setCreateUser ( userId );
                    toolwholelifecycle.setUpdateUser ( userId );
                    toolwholelifecycle.setVersion ( BigDecimal.ZERO );
                    String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue ( IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, userId );
                    toolwholelifecycle.setToolWholeLifecycleID ( toolWholeLifecycleID );
                    listTlf.add ( toolwholelifecycle );

                    // 刀具流转履历
                    Tooltransferhistory tth = new Tooltransferhistory ();
                    tth.setToolTransferHistoryID ( NextKeyValue.getNextkeyvalue ( IConstant.TOOLTRANSFERHISTORY, IConstant.TOOLTRANSFERHISTORYID, userId ) );
                    tth.setRfidContainerID ( tt.getRfidContainerID () ); // RFID载体ID
                    tth.setKnifeInventoryCode ( tt.getKnifeInventoryCode () );// 刀具入库编码
                    tth.setToolID ( tt.getToolID () );// 刀具ID
                    tth.setToolProcuredID ( tt.getProcuredBatch () );// 采购ID
                    tth.setBusinessFlowLnkID ( businessFlowLnkID );// 最后执行业务流程
                    tth.setToolDurable ( tt.getToolDurable () );// 耐用度
                    if (tt.getToolDurable () == null) {
                        tt.setToolDurable ( BigDecimal.ONE );
                    }
                    tth.setToolSharpennum ( tt.getToolDurable ().subtract ( BigDecimal.ONE ) );// 可使用(刃磨)次数
                    tth.setToolSharpenCriterion ( tt.getToolSharpenCriterion () );// 复磨标准
                    tth.setToolLength ( tt.getToolLength () );// 刀具长度
                    tth.setToolSharpenLength ( tt.getToolSharpenLength () );// 可刃磨长度
                    if (tt.getUsageCounter () == null) {
                        tt.setUsageCounter ( BigDecimal.ONE );
                    }
                    tth.setUsageCounter ( tt.getUsageCounter ().add ( BigDecimal.ONE ) );// 已使用(刃磨)次数
                    tth.setToolGrindingLength ( tt.getToolGrindingLength () );// 刀具已刃磨长度
                    tth.setInstallationState ( IConstant.INSTALLATION_STATE_0 );// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
                    tth.setStockState ( IConstant.STOCK_STATE_4 );
                    tth.setoutUser ( tt.getUpdateUser () );// 转出人
                    tth.setinUser ( userId );// 接收人
                    tth.setUpdateTime ( new Date () );// 更新时间
                    tth.setUpdateUser ( userId );// 更新者
                    tth.setDelFlag ( IConstant.DEL_FLAG_0 );// 删除区分
                    tth.setCreateTime ( new Date () );// 创建时间
                    tth.setCreateUser ( userId );// 创建者
                    tth.setVersion ( BigDecimal.ZERO );// 版本号
                    tthList.add ( tth );
                }
                // 批量增加生命周期
                if (listTlf.size () > 0) {
                    toolwholelifecycleDao.insertBatchs ( listTlf );
                }
                // 批量增加【刀具流转履历】
                if (tthList.size () > 0) {
                    tooltransferhistoryDao.insertBatchDefined ( tthList );
                }

            }
            if (rfidcontainerDao.updateNonQuery ( entity ) < 1) {
                rfidcontainer.setRetErrFlag ( true );
                rfidcontainer.setMessageCode ( IConstant.EMSG0004 );
            } else {
                // 刀具流转信息
                Map<String, Object> map = new HashMap<String, Object> ();
                map.put ( "businessFlowLnkID", businessFlowLnkID );
                map.put ( "userId", userId );
                map.put ( "list", rfidLists );
                tooltransferDao.updateBatchByRfid ( map );
            }
            return rfidcontainer;
        } catch (SQLException e) {
            rfidcontainer.setRetErrFlag ( true );
            rfidcontainer.setMessageCode ( IConstant.EMSG0004 );
            rfidcontainer.setExceMessage ( e.getMessage () );
            return rfidcontainer;
        }
    }

    //提交回厂入库刀片信息
    @Override
    public int submitBackFactoryToolInfo(Tooltransfer tt) throws SQLException {
        return tooltransferDao.updateNonQuery ( tt );
    }

    //提交钻头激光码
    @Override
    public int submitBitLaserCode(Rfidcontainer rff) throws Exception {
        try {
            // 判断在出厂修复通知单里，激光码是否有对应的通知单号，
            // 并以此来判断该激光码所对应的单品刀具是否可以进行回厂入库
            Outsidefactory ofEntity = new Outsidefactory ();
            ofEntity.setLaserCode ( rff.getLaserIdentificationCode () );
            ofEntity.setDelFlag ( IConstant.DEL_FLAG_0 );
            List<Outsidefactory> ofList = (List<Outsidefactory>) outsidefactoryDao.searchByList ( ofEntity );
            if (ofList.size () <= 0) {
                return 0;
            }
            if (ofList.get ( 0 ).getOrderNum () == null) {
                return 0;
            }

            rfidcontainerDao.updateNonQuery ( rff );

            // 更新厂外修复表
            Outsidefactory of = new Outsidefactory ();
            // 更新条件：激光码
            of.setLaserCodeWhere ( rff.getLaserIdentificationCode () );
            // set 修复状态(0.未修复1.已修复2.已送回）
            of.setRepairState ( IConstant.STRING_2 );
            // 删除区分(0有效1删除)
            of.setDelFlag ( IConstant.STRING_1 );
            of.setUpdateTime ( new Date () );
            of.setUpdateUser ( rff.getUpdateUser () );
            outsidefactoryDao.updateNonQuery ( of );

            // 获取已刃磨次数
            Tooltransfer ttEntity = new Tooltransfer ();
            ttEntity.setRfidContainerID ( rff.getRfidContainerIDWhere () );
            ttEntity.setDelFlag ( IConstant.STRING_0 );
            List<Tooltransfer> ttList = (List<Tooltransfer>) tooltransferDao.searchByList ( ttEntity );
            // 已刃磨次数
            BigDecimal count = BigDecimal.ZERO;
            if (ttList.size () > 0) {
                if (ttList.get ( 0 ).getUsageCounter () != null) {
                    count = ttList.get ( 0 ).getUsageCounter ();
                }
            }
            // 根据载体id更新流转表
            Tooltransfer tt = new Tooltransfer ();
            // 更新条件：载体id
            tt.setRfidContainerIDWhere ( rff.getRfidContainerIDWhere () );
            // set 刀具状态：待换装
            tt.setToolState ( IConstant.STRING_4 );
            // 刀具部门：对刀室
            tt.setToolThisState ( IConstant.STRING_1 );
            // 最后流程:回厂入库
            tt.setBusinessFlowLnkID ( IConstant.C01S020 );
            // 如果是厂外修磨，刃磨次数加1
            if ("1".equals ( rff.getExpandSpace2 () )) {
                tt.setUsageCounter ( count.add ( BigDecimal.ONE ) );
            }
            tt.setUpdateUser ( rff.getUpdateUser () );
            tt.setUpdateTime ( new Date () );
            tooltransferDao.updateNonQuery ( tt );

            //查询刀具入库编码
            String knifeInventoryCode = null;
            tt = new Tooltransfer ();
            tt.setRfidContainerID ( rff.getRfidContainerIDWhere () );
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
            twl.setBusinessFlowLnkID ( IConstant.C01S020 );
            // 手持机id
            twl.setHandSetID ( rff.getExpandSpace1 () );
            // 刀具id
            twl.setToolID ( ttList.get ( 0 ).getToolID () );
            //零部件id
            twl.setPartsID ( "" );
            //加工数量
            twl.setProcessAmount ( "0" );
            //删除区分(0有效1删除)
            twl.setDelFlag ( IConstant.DEL_FLAG_0 );
            //更新时间
            twl.setUpdateTime ( new Date () );
            //更新者
            twl.setUpdateUser ( rff.getUpdateUser () );
            //创建时间
            twl.setCreateTime ( new Date () );
            //创建者
            twl.setCreateUser ( rff.getUpdateUser () );
            //版本号
            twl.setVersion ( BigDecimal.ONE );
            toolwholelifecycleDao.insert ( twl );

            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 查询刀具信息
     *
     * @param ttf
     * @return
     * @throws Exception
     */
    @Override
    public Tooltransfer getToolInFactory(Tooltransfer ttf) throws Exception {
        try {
            List<Tooltransfer> list = (List<Tooltransfer>) tooltransferDao.searchByList ( ttf );
            if (list == null || list.size () <= 0) {
                // 您所查询的RFID类型不存在!
                Tooltransfer rfidcontainer = new Tooltransfer ();
                rfidcontainer.setMessageCode ( IConstant.WMSG0122 );
                rfidcontainer.setRetErrFlag ( true );
                return rfidcontainer;
            } else {
                return list.get ( 0 );
            }

        } catch (SQLException e) {
            // 数据库操作异常，查询失败!
            Tooltransfer rfidcontainer = new Tooltransfer ();
            rfidcontainer.setMessageCode ( IConstant.EMSG0004 );
            rfidcontainer.setRetErrFlag ( true );
            rfidcontainer.setExceMessage ( e.getMessage () );
            return rfidcontainer;
        }
    }

    /**
     * 根据激光码查询载体ID
     *
     * @param rf
     * @return
     * @throws Exception
     */
    @Override
    public Rfidcontainer getRfidContainerIDByLaserCode(Rfidcontainer rf) throws Exception {
        List<Rfidcontainer> reList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rf );
        Rfidcontainer reEntity = new Rfidcontainer ();
        if (reList.size () < 1) {
            //未找到相应数据
            reEntity.setRetErrFlag ( true );
        } else {
            reEntity = reList.get ( 0 );
        }
        return reEntity;
    }

    /**
     * 根据rfid查询rfid载体
     *
     * @param rfc
     * @return
     * @throws Exception
     */
    @Override
    public Rfidcontainer getRfidContainerIDByRfidCode(Rfidcontainer rfc) throws Exception {
        List<Rfidcontainer> reList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfc );
        Rfidcontainer reEntit = new Rfidcontainer ();
        if (reList.size () < 1) {
            //未找到相应数据
            reEntit.setRetErrFlag ( true );
        } else {
            reEntit = reList.get ( 0 );
        }
        return reEntit;
    }

    /**
     * 验证标签是否已被使用
     *
     * @param tt
     * @return
     */
    @SuppressWarnings("unchecked")
    public int getToolmsg(Tooltransfer tt) {
        try {
            List<Tooltransfer> rfidList = (List<Tooltransfer>) tooltransferDao.searchByList ( tt );
            if (rfidList != null && rfidList.size () > 0 && IConstant.DEL_FLAG_0.equals ( rfidList.get ( 0 ).getDelFlag () )) {
                // 当前扫描的RFID已绑定刀具!
                tt = new Tooltransfer ();
                tt.setRetErrFlag ( true );
                tt.setMessageCode ( IConstant.WMSG0147 );
                return rfidList.size ();
            } else {
                return rfidList.size ();
            }
        } catch (SQLException e) {
            tt.setRetErrFlag ( true );
            tt.setMessageCode ( IConstant.EMSG0004 );
            tt.setExceMessage ( e.getMessage () );
            return 1;
        }
    }

    @Override
    public int submitOutFactInData(Map<String, Object> map) throws SQLException {
        int reVal = 0;
        List<String> rfidConnerIDs = new ArrayList<> ();
        List<Rfidcontainer> rcList = new ArrayList<> ();
        Rfidcontainer rf = null;
        //用户ID
        String userID = (String) map.get ( "userID" );
        //修复类型（0.厂外图层1.厂外复磨）
        String grindingType = (String) map.get ( "grindingType" );
        //扫描到的rfidlist信息
        List<String> rfidString = (List<String>) map.get ( "rfidList" );
        //出厂单号
        String outsideFactoryID = (String) map.get ( "outsideFactoryID" );
        //材料号
        String toolCode = (String) map.get ( "toolCode" );
        Outsidefactory out = new Outsidefactory ();
        //通知单号
        out.setOrderNum ( outsideFactoryID );
        //材料号
        out.setMaterialNum ( toolCode );
        //修复状态(0.待出厂1.已出厂2.已送回）
        out.setRepairState ( IConstant.STOCK_STATE_1 );
        out.setStaIndex ( 0 );
        if (rfidString != null) {
            out.setRowCount ( rfidString.size () );
        }

        //根据出厂单号和材料号查询已出厂的刀具信息（rfid载体）
        List<Outsidefactory> reList = (List<Outsidefactory>) outsidefactoryDao.searchByList ( out );
        int i = 0;
        String rfidContarner = null;
        for (Outsidefactory ou : reList) {
            rfidContarner = ou.getExpandSpace4 ();
            if (StringUtils.isEmpty ( rfidContarner )) {
                continue;
            }
            rf = new Rfidcontainer ();
            rfidConnerIDs.add ( rfidContarner );
            // 先插入到rfid载体
            rf.setRfidContainerID ( rfidContarner );
            rf.setRfidCode ( rfidString.get ( i ) );
            rf.setQueryType ( IConstant.QUERY_TYPE_1 );
            rf.setBandType ( IConstant.BAND_TYPE_0 );
            rf.setRfidReCount ( BigDecimal.ZERO );
            rf.setDelFlag ( IConstant.DEL_FLAG_0 );
            rf.setUpdateUser ( userID );
            rf.setUpdateTime ( new Date () );
            rf.setCreateUser ( userID );
            rf.setCreateTime ( new Date () );
            rf.setSystemLogUser ( userID );
            rcList.add ( rf );
            i++;
        }
        if (rfidConnerIDs.size () < 1) {
            return 0;
        }
             Map<String, Object> param = new HashedMap ();
        param.put ( "userID", userID );
        param.put ( "list", rfidConnerIDs );
        param.put ( "repairState", IConstant.STRING_2 );
        param.put ( "delFlag", IConstant.STRING_1 );
        //修改出厂表信息为回厂
        reVal += outsidefactoryDao.updateRepairStateByRfidConnerID ( param );
        param.put ( "toolState", IConstant.STRING_4 );
        if (IConstant.STRING_1.equals ( grindingType )) {
            //如果是厂外修磨则修磨加1
            reVal += tooltransferDao.updateToolStateBatchByRFIDConnerIDAddOne ( param );
        } else {
        //修改流转表中的信息为待换装状态
        reVal += tooltransferDao.updateToolStateBatchByRFIDConnerID ( param );
        }
        //根据rfid载体ID插入rfidCode表中
        if (rcList.size () > 0) {
            rfidcontainerDao.insertBatchs ( rcList );
        }
        return reVal;
    }

    /**
     * 取得通知单号列表
     *
     * @param tt
     * @return
     */
    public List<Outsidefactory> getBackFactoryToolInfolist(Outsidefactory tt) throws SQLException {
        return (List<Outsidefactory>) outsidefactoryDao.searchByList ( tt );
    }

    /**
     * 取得通知单号信息
     *
     * @param tt
     * @return
     */
    public Outsidefactory getBackFactoryToolInfo(Outsidefactory tt) throws Exception {
        return outsidefactoryDao.getBackFactoryToolInfo ( tt );
    }

    /**
     * 相同材料号记录合并，数量累加
     *
     * @param out
     * @return
     * @throws Exception
     */
    @Override
    public List<Outsidefactory> getBackFactoryToolSumInfo(Outsidefactory out) throws Exception {
        return (List<Outsidefactory>) outsidefactoryDao.getBackFactoryToolInfoSumlist ( out );
    }
}
