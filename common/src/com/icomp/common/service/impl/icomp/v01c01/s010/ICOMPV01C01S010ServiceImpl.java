package com.icomp.common.service.impl.icomp.v01c01.s010;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s010.ICOMPV01C01S010Service;
import com.icomp.common.utils.UUIDgen;
import com.icomp.dao.BusinessDao;
import com.icomp.dao.BusinessflowlnkDao;
import com.icomp.dao.ContainercarrierDao;
import com.icomp.dao.KnifeinventoryDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.SynthesisknifeDao;
import com.icomp.dao.SynthesisparametersDao;
import com.icomp.dao.ToolDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.TooltransferhistoryDao;
import com.icomp.dao.ToolwholelifecycleDao;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Businessflowlnk;
import com.icomp.entity.base.Containercarrier;
import com.icomp.entity.base.GrindingBitMsge;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.ScanGrinding;
import com.icomp.entity.base.Synthesisknife;
import com.icomp.entity.base.Synthesisparameters;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Tooltransferhistory;
import com.icomp.entity.base.Toolwholelifecycle;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 刀具换装-Service实现类
 *
 * @author Taoyy
 * @ClassName: ICOMPV01C01S010ServiceImpl
 * @date 2016-2-26 下午02:02:47
 */

@SuppressWarnings("unchecked")
public class ICOMPV01C01S010ServiceImpl extends BaseService implements ICOMPV01C01S010Service {

    /* 刀具Dao */
    private ToolDao toolDao;
    private RfidcontainerDao rfidcontainerDao;
    private ToolwholelifecycleDao toolwholelifecycleDao;
    private TooltransferhistoryDao tooltransferhistoryDao;

    public void setTooltransferhistoryDao(TooltransferhistoryDao tooltransferhistoryDao) {
        this.tooltransferhistoryDao = tooltransferhistoryDao;
    }

    public void setToolwholelifecycleDao(ToolwholelifecycleDao toolwholelifecycleDao) {
        this.toolwholelifecycleDao = toolwholelifecycleDao;
    }

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    /* 合成刀库Dao */
    private SynthesisknifeDao synthesisknifeDao;

    public void setSynthesisknifeDao(SynthesisknifeDao synthesisknifeDao) {
        this.synthesisknifeDao = synthesisknifeDao;
    }

    /* 刀具流转Dao */
    private TooltransferDao tooltransferDao;

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    /*合成刀参数*/
    private SynthesisparametersDao synthesisparametersDao;
    private BusinessDao businessDao;

    public void setBusinessflowlnkDao(BusinessflowlnkDao businessflowlnkDao) {
        this.businessflowlnkDao = businessflowlnkDao;
    }

    private BusinessflowlnkDao businessflowlnkDao;

    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    public void setSynthesisparametersDao(SynthesisparametersDao synthesisparametersDao) {
        this.synthesisparametersDao = synthesisparametersDao;
    }

    /*容器*/
    private ContainercarrierDao containercarrierDao;

    public void setContainercarrierDao(ContainercarrierDao containercarrierDao) {
        this.containercarrierDao = containercarrierDao;
    }

    private KnifeinventoryDao knifeinventoryDao;

    public void setKnifeinventoryDao(KnifeinventoryDao knifeinventoryDao) {
        this.knifeinventoryDao = knifeinventoryDao;
    }

    /**
     * 根据载体id查询合成刀具编码
     *
     * @param syentity
     * @return
     */
    @Override
    public Synthesisknife getSynthesisknife(Synthesisknife syentity) throws Exception {
        return synthesisknifeDao.getSynthesisknife ( syentity );
    }

    /**
     * 根据载体id查询合成刀具ID
     *
     * @param entity
     * @return
     */
    @Override
    public List<Tooltransfer> getTooltransferList(Tooltransfer entity) throws Exception {
        List<Tooltransfer> list = null;
        try {
            list = (List<Tooltransfer>) tooltransferDao.searchByList ( entity );
            if (list == null || list.size () <= 0) {
                // 系统无合成刀具ID!
                list = new ArrayList<Tooltransfer> ();
                Tooltransfer tooltransferlist = new Tooltransfer ();
                tooltransferlist.setMessageCode ( IConstant.EMSG0005 );
                tooltransferlist.setRetErrFlag ( true );
                list.add ( tooltransferlist );
            }

        } catch (SQLException e) {
            // 数据库操作异常,查询失败!
            list = new ArrayList<Tooltransfer> ();
            Tooltransfer tooltransferlist = new Tooltransfer ();
            tooltransferlist.setMessageCode ( IConstant.EMSG0004 );
            tooltransferlist.setRetErrFlag ( true );
            tooltransferlist.setExceMessage ( e.getMessage () );
            list.add ( tooltransferlist );
        }

        return list;
    }

    /**
     * 根据刀具ID取得材料号和刀具类型
     *
     * @param entity
     * @return
     */
    @Override
    public Tool getTool(Tool entity) throws Exception {

        List<Tool> reList = (List<Tool>) toolDao.searchByList ( entity );
        Tool reEntity = new Tool ();
        if (reList.size () < 1) {
            // 未找到相应数据
            reEntity.setRetErrFlag ( true );
        } else {
            reEntity = reList.get ( 0 );
        }
        return reEntity;
    }

    /**
     * 查询合成刀信息
     *
     * @param entity
     * @return
     */
    @Override
    public List<Tooltransfer> getSyrfid(Tooltransfer entity) throws Exception {
        return (List<Tooltransfer>) tooltransferDao.searchByList ( entity );
    }

    /**
     * 查询单品刀信息
     *
     * @param entity
     * @return
     */
    @Override
    public List<Tooltransfer> getSirfids(Tooltransfer entity) throws Exception {
        return (List<Tooltransfer>) tooltransferDao.searchByList ( entity );
    }

    /**
     * 更新刀具流转表
     *
     * @param entity
     * @return
     */
    @Override
    public int updateSyrfid(Tooltransfer entity) throws Exception {
        int count = tooltransferDao.updateNonQuery ( entity );
        return count;
    }

    @Override
    public Synthesisparameters getSynthesisknifeId(Synthesisparameters syters) throws Exception {
        List<Synthesisparameters> synList = (List<Synthesisparameters>) synthesisparametersDao.searchByList ( syters );
        Synthesisparameters syentity = new Synthesisparameters ();
        if (synList == null || synList.size () == 0) {
            syentity.setRetErrFlag ( true );
        } else {
            syentity = synList.get ( 0 );
        }
        return syentity;
    }

    @Override
    public Tooltransfer getTooltransfer(Tooltransfer tooltransfer) throws Exception {
        List<Tooltransfer> ttflist = (List<Tooltransfer>) tooltransferDao.searchByList ( tooltransfer );
        Tooltransfer ttf = new Tooltransfer ();
        if (ttflist == null || ttflist.size () == 0) {
            ttf.setRetErrFlag ( true );
        } else {
            ttf = ttflist.get ( 0 );
        }
        return ttf;
    }

    /**
     *
     */
    @Override
    public int saveToolScrapInfo(Map<String, Object> map) throws SQLException {
        int reVal = 0;
        Tooltransfer tt1 = null;
        List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory> ();
        Tooltransferhistory tth = null;
        List<Toolwholelifecycle> tlcList = new ArrayList<Toolwholelifecycle> ();
        Toolwholelifecycle toolwholelifecycle = null;
        // 当前用户ID
        String userId = map.get ( "userId" ).toString ();
        // 当前合成刀具RFID
        String rfidSynthesisString = (String) map.get ( "rfidSynthesisString" );
        //报废容器载体id
        String scrapRfidString = (String) map.get ( "scrapRfidString" );
        //报废信息
        List<ScanGrinding> scrapMsgs = (List<ScanGrinding>) map.get ( "scrapMsgs" );
        //手持机id
        String handerId = (String) map.get ( "handerId" );
        //授权人id
        String gruantUserId = (String) map.get ( "gruantUserId" );

        // 取得业务流程ID
        Business business = new Business ();
        business.setBusinessCode ( IConstant.C01S010 );
        List<Business> businessList = (List<Business>) businessDao.searchByList ( business );
        business = businessList.get ( 0 );
        Businessflowlnk businessflowlnks = new Businessflowlnk ();
        businessflowlnks.setBusinessID ( business.getBusinessID () );
        List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList ( businessflowlnks );
        String businessFlowLnkID = list1.get ( 0 ).getBusinessFlowLnkID ();
        Rfidcontainer rfidcontainer = new Rfidcontainer ();
        rfidcontainer.setRfidCode ( rfidSynthesisString );
        rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
        String rfidContainerID = ((Rfidcontainer) rfidcontainerDao.searchByList ( rfidcontainer ).get ( 0 )).getRfidContainerID ();
        Tooltransfer entity = null;
        ArrayList<Tooltransfer> ttlist = new ArrayList<Tooltransfer> ();
        //处理刀具报废的刀具
        for (ScanGrinding gm : scrapMsgs) {
            Tool tool = new Tool ();
            tool.setToolCode ( gm.getToolCode () );
            String toolId = ((Tool) toolDao.searchByList ( tool ).get ( 0 )).getToolID ();
            tt1 = new Tooltransfer ();
            tt1.setToolID ( toolId );
            entity = new Tooltransfer ();
            entity.setRfidContainerID ( IConstant.KNIFE_CONTARNERID );
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            entity.setToolID ( toolId );
            if (IConstant.STRING_0.equals ( gm.getToolType () )) {
                // 钻头
                if (tooltransferDao.searchByCount ( entity ) < Integer.parseInt ( gm.getNumbers () )) {
                    System.out.println ( "刀具编码" + gm.getToolCode () + "对刀室流转数量不足" );
                    return IConstant.RESULT_CODE_2;
                }
            } else if (IConstant.STRING_1.equals ( gm.getToolType () ) || IConstant.STRING_2.equals ( gm.getToolType () )) {
                // 可刃磨刀片或一次性刀片
                List<Tooltransfer> ttList = (List<Tooltransfer>) tooltransferDao.searchByList ( entity );
                // 该把刀在备用库的总数量
                int sum = 0;
                for (Tooltransfer tooltransfer : ttList) {
                    sum = sum + tooltransfer.getToolDurable ().intValue ();
                }
                if (sum < Integer.parseInt ( gm.getNumbers () )) {
                    System.out.println ( "刀具编码" + gm.getToolCode () + "对刀室流转数量不足" );
                    return IConstant.RESULT_CODE_2;
                }
            }
            //对刀室
            //刀具部门(0库存,1对刀室,2刃磨室,3,车间)
            tt1.setToolThisState ( IConstant.STSATIC_ONE );
            tt1.setRowCount ( Integer.parseInt ( gm.getNumbers () ) ); //数量
            entity.setRowCount ( Integer.parseInt ( gm.getNumbers () ) );
            entity.setStaIndex ( 0 );
            tt1.setRfidContainerID ( scrapRfidString );
            tt1.setKnifeInventoryCode ( UUIDgen.getId () );
            tt1.setStockState ( IConstant.STOCK_STATE_1 );
            tt1.setBusinessFlowLnkID ( businessFlowLnkID );
            tt1.setInstallationState ( IConstant.INSTALLATION_STATE_2 );
            if (IConstant.STSATIC_ZERO.equals ( gm.getThisStaic () )) {
                //报废
                tt1.setConfirmedUser ( userId );
                tt1.setToolState ( IConstant.STSATIC_FIVE ); //到寿
            } else if (IConstant.STSATIC_ONE.equals ( gm.getThisStaic () )) {
                //丢刀
                tt1.setConfirmedUser ( gruantUserId );
                tt1.setToolState ( IConstant.STSATIC_ONE ); //丢刀
                if (gruantUserId == null) {
                    tt1.setConfirmedUser ( userId ); //确认人
                } else {
                    tt1.setConfirmedUser ( gruantUserId ); //确认人
                }
            }
            tt1.setDelFlag ( IConstant.DEL_FLAG_0 );
            tt1.setCreateTime ( new Date () );
            tt1.setCreateUser ( userId );
            tooltransferDao.insert ( tt1 );
            List<Tooltransfer> list = (List<Tooltransfer>) tooltransferDao.searchByList ( entity );
            ttlist.addAll ( list );
        }
        for (Tooltransfer tt : ttlist) {
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
                toolwholelifecycle.setUpdateUser ( userId );
                toolwholelifecycle.setCreateUser ( userId );
                if (gruantUserId != null)
                    toolwholelifecycle.setUpdateUser ( gruantUserId );
                toolwholelifecycle.setVersion ( BigDecimal.ZERO );
                toolwholelifecycle.setToolWholeLifecycleID ( UUID.randomUUID ().toString () );
                tlcList.add ( toolwholelifecycle );
            }
            //刀具流转
            entity = new Tooltransfer ();
            entity.setRfidContainerIDWhere ( tt.getRfidContainerID () );
            entity.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
            entity.setKnifeInventoryCodeWhere ( tt.getKnifeInventoryCode () );
            entity.setBusinessFlowLnkID ( businessFlowLnkID );
            entity.setUpdateUser ( userId );
            entity.setUpdateTime ( new Date () );
            entity.setVersion ( tt.getVersion ().add ( BigDecimal.ONE ) );
            reVal += tooltransferDao.updateNonQuery ( entity );

            // 刀具流转履历
            tth = new Tooltransferhistory ();
            tth.setToolTransferHistoryID ( UUID.randomUUID ().toString () );
            tth.setRfidContainerID ( tt.getRfidContainerID () ); // RFID载体ID
            tth.setKnifeInventoryCode ( tt.getKnifeInventoryCode () );// 刀具入库编码
            tth.setToolID ( tt.getToolID () );// 刀具ID
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
                tth.setinUser ( userId );// 接收人
            } else {
                tth.setinUser ( userId );
            }
            tth.setStockState ( tt.getStockState () );
            tth.setUpdateTime ( new Date () );// 更新时间
            tth.setUpdateUser ( gruantUserId );// 更新者
            tth.setDelFlag ( IConstant.DEL_FLAG_0 );// 删除区分
            tth.setCreateTime ( new Date () );// 创建时间
            tth.setCreateUser ( userId );// 创建者
            tth.setVersion ( BigDecimal.ZERO );// 版本号
            tthList.add ( tth );
        }
        // 增加生命周期
        if (tlcList.size () > 0)
            toolwholelifecycleDao.insertBatchs ( tlcList );
        // 批量增加【刀具流转履历】
        if (tthList.size () > 0)
            tooltransferhistoryDao.insertBatchDefined ( tthList );

        //更新流程
        Synthesisknife synthesisknife = new Synthesisknife ();
        synthesisknife.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
        synthesisknife.setrFIDWhere ( rfidContainerID );
        synthesisknife.setBusinessFlowLnkID ( businessFlowLnkID );
        synthesisknife.setUpdateTime ( new Date () );
        synthesisknife.setUpdateUser ( userId );
        reVal += synthesisknifeDao.updateNonQuery ( synthesisknife );
        return reVal;

    }

    @Override
    public int savesGrindingToolInfo(Map<String, Object> map) throws SQLException {
        int reVal = 0;
        Tooltransfer tt1 = null;
        List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory> ();
        Tooltransferhistory tth = null;
        List<Toolwholelifecycle> tlcList = new ArrayList<Toolwholelifecycle> ();
        Toolwholelifecycle toolwholelifecycle = null;
        // 当前用户ID
        String userId = (String) map.get ( "userId" );
        // 当前合成刀具RFID
        String rfidSynthesisString = (String) map.get ( "rfidSynthesisString" );
        //容器rifd
        String rfidString = (String) map.get ( "rfidString" );
        //刃磨信息
        List<ScanGrinding> grindingMsgs = (List<ScanGrinding>) map.get ( "grindingMsgs" );
        //手持机id
        String handerId = (String) map.get ( "handerId" );
        //授权人id
        String gruantUserId = (String) map.get ( "gruantUserId" );
        // 取得业务流程ID
        Business business = new Business ();
        business.setBusinessCode ( IConstant.C01S010 );
        List<Business> businessList = (List<Business>) businessDao.searchByList ( business );
        business = businessList.get ( 0 );
        Businessflowlnk businessflowlnks = new Businessflowlnk ();
        businessflowlnks.setBusinessID ( business.getBusinessID () );
        List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList ( businessflowlnks );
        String businessFlowLnkID = list1.get ( 0 ).getBusinessFlowLnkID ();
        Rfidcontainer rfidcontainer = new Rfidcontainer ();
        rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
        rfidcontainer.setRfidCode ( rfidString );
        //容器载体
        String rfinConneridConnerId = ((Rfidcontainer) rfidcontainerDao.searchByList ( rfidcontainer ).get ( 0 )).getRfidContainerID ();
        Tooltransfer entity = null;
        List<Tooltransfer> ttlist = new ArrayList<Tooltransfer> ();
        //处理可刃磨的刀具
        for (ScanGrinding gm : grindingMsgs) {
            Tool tool = new Tool ();
            tool.setToolCode ( gm.getToolCode () );
            String toolId = ((Tool) toolDao.searchByList ( tool ).get ( 0 )).getToolID ();
            tt1 = new Tooltransfer ();
            tt1.setToolIDWhere ( toolId );
            entity = new Tooltransfer ();
            entity.setRfidContainerID ( IConstant.KNIFE_CONTARNERID );
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            entity.setToolID ( toolId );
            if (tooltransferDao.searchByCount ( entity ) < Integer.parseInt ( gm.getNumbers () )) {
                System.err.println ( "刀具编码" + gm.getToolCode () + "备用库流转数量不足" );
                return IConstant.RESULT_CODE_2;
            }
            entity.setToolThisState ( IConstant.STSATIC_ONE );
            entity.setRowCount ( Integer.parseInt ( gm.getNumbers () ) ); //数量
            entity.setStaIndex ( 0 );
            //对刀室
            tt1.setRfidContainerIDWhere ( IConstant.KNIFE_CONTARNERID );
            tt1.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
            tt1.setRowCount ( Integer.parseInt ( gm.getNumbers () ) ); //数量
            //刀具部门(0库存,1对刀室,2刃磨室,3,车间)
            tt1.setToolThisStateWhere ( IConstant.STSATIC_ONE );
            tt1.setRfidContainerID ( rfinConneridConnerId );
            tt1.setBusinessFlowLnkID ( businessFlowLnkID );
            //流转
            tt1.setStockState ( IConstant.STOCK_STATE_4 );
            tt1.setInstallationState ( IConstant.INSTALLATION_STATE_2 );
            tt1.setUpdateTime ( new Date () );
            tt1.setUpdateUser ( userId );
            ttlist.addAll ( (List<Tooltransfer>) tooltransferDao.searchByList ( entity ) );
            reVal += tooltransferDao.updateDateByToolID ( tt1 );
        }
        if (reVal == 0) {
            throw new RuntimeException ();
        }

        return reVal;

    }

    @Override
    public List<Tooltransfer> getSynthesisknifeToolMsg(Tooltransfer tfentity) throws SQLException {
        return tooltransferDao.getSynthesisknifeToolMsg ( tfentity );
    }

    /**
     * 查询当前标签类型
     */
    @Override
    public String getRfidType(String containerRfid, String userId, String type) throws SQLException {
        Rfidcontainer rfidcontainer = new Rfidcontainer ();
        rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
        rfidcontainer.setRfidCode ( containerRfid );
        //查询RFID载体
        List<Rfidcontainer> rfList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
        if (rfList.size () <= 0) {
            //空标签
            return IConstant.STRING_3;
        } else {
            //不是5代表这是非容器标签
            if (!IConstant.STRING_5.equals ( rfList.get ( 0 ).getQueryType () )) {
                return IConstant.STRING_0;
            }
            String rfidContainerId = rfList.get ( 0 ).getRfidContainerID ();
            Containercarrier cc = new Containercarrier ();
            cc.setRfidContainerID ( rfidContainerId );
            List<Containercarrier> ccList = (List<Containercarrier>) containercarrierDao.searchByList ( cc );
            if (ccList.size () > 0) {
                // 存在容器初始化数据，获取容器类型
                String ContainerCarrierType = ccList.get ( 0 ).getContainerCarrierType ();
                if (IConstant.STRING_1.equals ( type )) {
                    // type为1时，代表需要往报废容器中装入刀具
                    if (IConstant.STRING_1.equals ( ContainerCarrierType )) {
                        // 当扫描的是报废容器，则返回2
                        return IConstant.STRING_2;
                    } else {
                        // 当扫描的是其他容器，则返回1（其它类型容器）
                        return IConstant.STRING_1;
                    }
                } else if (IConstant.STRING_2.equals ( type )) {
                    // type为2时，代表需要往待分拣容器装入刀具
                    if (IConstant.STRING_2.equals ( ContainerCarrierType )) {
                        // 当扫描的是待分拣容器，则返回2
                        return IConstant.STRING_2;
                    } else {
                        // 当扫描的是其他容器，则返回1（其它类型容器）
                        return IConstant.STRING_1;
                    }
                }
            }
            return IConstant.STRING_3;
        }
    }

    /**
     * 刀具换装最后提交
     */
    @Override
    public String saveSubmit(Map<String, Object> map) throws SQLException {
        String reVal = IConstant.STRING_0;
        Tooltransfer tt1 = new Tooltransfer ();
        Tooltransfer tt2 = new Tooltransfer ();
        Tooltransfer tt3 = new Tooltransfer ();

        //当前用户ID
        String userId = (String) map.get ( "userId" );
        //授权人ID
        String signId = null;
        if (map.get ( "signId" ) != null) {
            signId = map.get ( "signId" ).toString ();
        }
        //当前合成刀具RFID
        String synthesisParametersRfid = (String) map.get ( "synthesisParametersRfid" );
        //当前合成刀具编码
        String synthesisParametersCode = (String) map.get ( "synthesisParametersCode" );

        //报废容器rfid
        String scrapContainerRfid = null;
        if (map.get ( "scrapContainerRfid" ) != null) {
            scrapContainerRfid = (String) map.get ( "scrapContainerRfid" );
        }
        //刃磨容器rfid
        String grindingContainerRfid = null;
        if (map.get ( "grindingContainerRfid" ) != null) {
            grindingContainerRfid = (String) map.get ( "grindingContainerRfid" );
        }

        //报废信息
        List<ScanGrinding> scrapMsgs = null;
        if (map.get ( "scrapMsgs" ) != null) {
            scrapMsgs = (List<ScanGrinding>) map.get ( "scrapMsgs" );
        }
        //可刃磨钻头刃磨信息
        List<GrindingBitMsge> grindingBitMsgs = null;
        if (map.get ( "grindingBitMsgs" ) != null) {
            grindingBitMsgs = (List<GrindingBitMsge>) map.get ( "grindingBitMsgs" );
        }
        //可刃磨刀片刃磨信息
        List<ScanGrinding> grindingMsgs = null;
        if (map.get ( "grindingMsgs" ) != null) {
            grindingMsgs = (List<ScanGrinding>) map.get ( "grindingMsgs" );
        }
        Tooltransfer entity = null;

        // 先判断所有换装的刀具的对刀室流转量是否充足
        if (scrapContainerRfid != null && scrapMsgs != null && scrapMsgs.size () > 0) {
            for (ScanGrinding gm : scrapMsgs) {
                Tool tool = new Tool ();
                tool.setToolCode ( gm.getToolCode () );
                String toolId = ((Tool) toolDao.searchByList ( tool ).get ( 0 )).getToolID ();
                entity = new Tooltransfer ();
                entity.setDelFlag ( IConstant.DEL_FLAG_0 );
                entity.setToolID ( toolId );
                entity.setToolState ( IConstant.STRING_4 );//刀具状态：待换装
                // 判断对刀室的流转量是否充足
                if (IConstant.DEL_FLAG_0.equals ( gm.getToolType () )) {
                    // 钻头
                    if (tooltransferDao.searchByCount ( entity ) < Integer.parseInt ( gm.getNumbers () )) {
                        System.out.println ( "材料号" + gm.getToolCode () + "对刀室流转数量不足" );
                        if (gm.getToolCode () != null) {
                            return gm.getToolCode ();
                        } else {
                            return IConstant.STRING_3;
                        }

                    }
                } else if (IConstant.STRING_1.equals ( gm.getToolType () ) || IConstant.STRING_2.equals ( gm.getToolType () )) {
                    // 可刃磨刀片或一次性刀片
                    List<Tooltransfer> ttList = (List<Tooltransfer>) tooltransferDao.searchByList ( entity );
                    // 该把刀在备用库的总数量
                    int sum = 0;
                    for (Tooltransfer tooltransfer : ttList) {
                        sum = sum + tooltransfer.getToolDurable ().intValue ();
                    }
                    if (sum < Integer.parseInt ( gm.getNumbers () )) {
                        System.out.println ( "材料号" + gm.getToolCode () + "对刀室流转数量不足" );
                        if (gm.getToolCode () != null) {
                            return gm.getToolCode ();
                        } else {
                            return IConstant.STRING_3;
                        }
                    }
                }
            }
        }

        if (grindingContainerRfid != null && grindingMsgs != null && grindingMsgs.size () > 0) {
            for (ScanGrinding gm : grindingMsgs) {
                Tool tool = new Tool ();
                tool.setToolCode ( gm.getToolCode () );
                String toolId = ((Tool) toolDao.searchByList ( tool ).get ( 0 )).getToolID ();
                entity = new Tooltransfer ();
                entity.setDelFlag ( IConstant.DEL_FLAG_0 );
                entity.setToolID ( toolId );
                entity.setToolState ( IConstant.STRING_4 );//刀具状态：待换装
                // 判断对刀室的流转量是否充足
                if (IConstant.DEL_FLAG_0.equals ( gm.getToolType () )) {
                    // 钻头
                    if (tooltransferDao.searchByCount ( entity ) < Integer.parseInt ( gm.getNumbers () )) {
                        System.out.println ( "材料号" + gm.getToolCode () + "对刀室流转数量不足" );
                        if (gm.getToolCode () != null) {
                            return gm.getToolCode ();
                        } else {
                            return IConstant.STRING_3;
                        }
                    }
                } else if (IConstant.STRING_1.equals ( gm.getToolType () ) || IConstant.STRING_2.equals ( gm.getToolType () )) {
                    // 可刃磨刀片或一次性刀片
                    List<Tooltransfer> ttList = (List<Tooltransfer>) tooltransferDao.searchByList ( entity );
                    // 该把刀在备用库的总数量
                    int sum = 0;
                    for (Tooltransfer tooltransfer : ttList) {
                        sum = sum + tooltransfer.getToolDurable ().intValue ();
                    }
                    if (sum < Integer.parseInt ( gm.getNumbers () )) {
                        System.out.println ( "材料号" + gm.getToolCode () + "对刀室流转数量不足" );
                        if (gm.getToolCode () != null) {
                            return gm.getToolCode ();
                        } else {
                            return IConstant.STRING_3;
                        }
                    }
                }
            }
        }

        if (grindingBitMsgs != null && grindingBitMsgs.size () > 0) {
            for (GrindingBitMsge gbm : grindingBitMsgs) {
                Tool tool = new Tool ();
                tool.setToolCode ( gbm.getToolCode () );
                String toolId = ((Tool) toolDao.searchByList ( tool ).get ( 0 )).getToolID ();
                entity = new Tooltransfer ();
                entity.setDelFlag ( IConstant.DEL_FLAG_0 );
                entity.setToolID ( toolId );
                entity.setToolState ( IConstant.STRING_4 );//刀具状态：待换装
                // 判断对刀室的流转量是否充足
                // 钻头
                if (tooltransferDao.searchByCount ( entity ) < 1) {
                    System.out.println ( "材料号" + gbm.getToolCode () + "对刀室流转数量不足" );
                    if (gbm.getToolCode () != null) {
                        return gbm.getToolCode ();
                    } else {
                        return IConstant.STRING_3;
                    }
                }
            }
        }

        Containercarrier cc = new Containercarrier ();
        cc.setDelFlag ( IConstant.DEL_FLAG_0 );
        cc.setContainerCarrierType ( IConstant.STACK_0 );
        List<Containercarrier> connerList = (List<Containercarrier>) containercarrierDao.searchByList ( cc );
        if (connerList == null || connerList.size () < 1) {
            return IConstant.STRING_2;
        }
        //备刀库载体ID
        String beiyongRfidConner = connerList.get ( 0 ).getRfidContainerID ();

        Tooltransfer tooltransfer = new Tooltransfer ();
        tooltransfer.setRfidContainerID ( synthesisParametersRfid );
        tooltransfer.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Tooltransfer> tooltrs = (List<Tooltransfer>) tooltransferDao.searchByList ( tooltransfer );
        if (tooltrs == null || tooltrs.size () < 1) {
            return null;
        }
        BigDecimal toolString = tooltrs.get ( 0 ).getProcessAmount ();

        //如果周转量充足
        //处理刀具报废的刀具
        if (scrapContainerRfid != null && scrapMsgs != null && scrapMsgs.size () > 0) {
            // 根据rfid获取对应的载体id
            Rfidcontainer rfidcontainer = new Rfidcontainer ();
            rfidcontainer.setRfidCode ( scrapContainerRfid );
            rfidcontainer.setDelFlag ( IConstant.STRING_0 );
            String rfidcontainerId = ((Rfidcontainer) rfidcontainerDao.searchByList ( rfidcontainer ).get ( 0 )).getRfidContainerID ();
            for (ScanGrinding gm : scrapMsgs) {
                Tool tool = new Tool ();
                tool.setToolCode ( gm.getToolCode () );
                String toolId = ((Tool) toolDao.searchByList ( tool ).get ( 0 )).getToolID ();

                // 查询是否有相同的换装信息(数量除外)，如果有则将数据合并
                tt1 = new Tooltransfer ();
                // 报废容器的载体id
                tt1.setRfidContainerID ( rfidcontainerId );
                // 刀具id
                tt1.setToolID ( toolId );
                // 刀具部门:对刀室
                tt1.setToolThisState ( IConstant.STSATIC_ONE );
                //库存状态:报废
                tt1.setStockState ( IConstant.STOCK_STATE_1 );
                if (IConstant.STSATIC_ZERO.equals ( gm.getThisStaic () )) {
                    // 报废
                    tt1.setToolState ( IConstant.STSATIC_FIVE ); // 到寿
                } else if (IConstant.STSATIC_ONE.equals ( gm.getThisStaic () )) {
                    // 丢刀
                    tt1.setConfirmedUser ( signId );// 丢刀确认人
                    tt1.setToolState ( IConstant.STSATIC_ONE ); // 丢刀
                }
                // 删除区分
                tt1.setDelFlag ( IConstant.DEL_FLAG_0 );
                List<Tooltransfer> ttList = (List<Tooltransfer>) tooltransferDao.searchByList ( tt1 );
                if (ttList.size () > 0) {
                    //有相同数据
                    //获取原有报废或丢刀数量
                    BigDecimal number = BigDecimal.ZERO;
                    if (ttList.get ( 0 ).getToolDurable () != null) {
                        number = ttList.get ( 0 ).getToolDurable ();
                    }
                    //更新数量
                    tt1.setRfidContainerIDWhere ( tt1.getRfidContainerID () );
                    tt1.setToolIDWhere ( tt1.getToolID () );
                    tt1.setToolThisStateWhere ( tt1.getToolThisState () );
                    tt1.setStockStateWhere ( tt1.getStockState () );
                    if (IConstant.STSATIC_ZERO.equals ( gm.getThisStaic () )) {
                        // 报废
                        tt1.setToolStateWhere ( IConstant.STSATIC_FIVE ); // 到寿
                    } else if (IConstant.STSATIC_ONE.equals ( gm.getThisStaic () )) {
                        // 丢刀
                        tt1.setConfirmedUserWhere ( tt1.getConfirmedUser () );// 丢刀确认人
                        tt1.setToolStateWhere ( IConstant.STSATIC_ONE ); // 丢刀
                    }
                    tt1.setDelFlagWhere ( IConstant.STRING_0 );
                    tt1.setToolDurable ( number.add ( new BigDecimal ( gm.getNumbers () ) ) );
                    tt1.setUpdateTime ( new Date () );
                    tt1.setUpdateUser ( userId );
                    try {
                        // 减少备用刀的数量
                        Tooltransfer tt = new Tooltransfer ();
                        tt.setRfidContainerID ( beiyongRfidConner );
                        tt.setToolID ( tt1.getToolID () );
                        tt.setToolDurable ( new BigDecimal ( gm.getNumbers () ) );
                        tt.setUpdateTime ( new Date () );
                        tt.setUpdateUser ( userId );
                        tooltransferDao.updatecontainerCount ( tt );

                        tooltransferDao.updateNonQuery ( tt1 );
                    } catch (Exception e) {
                        e.printStackTrace ();
                        return IConstant.STRING_1;
                    }
                } else {
                    tt1.setToolDurable ( new BigDecimal ( gm.getNumbers () ) ); // 数量
                    tt1.setProcessAmount ( toolString );// 加工数量
                    tt1.setKnifeInventoryCode ( UUIDgen.getId () );// 刀具入库编码
                    // 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
                    tt1.setInstallationState ( IConstant.INSTALLATION_STATE_2 );
                    tt1.setCreateTime ( new Date () );
                    tt1.setBusinessFlowLnkID ( IConstant.C01S010 );
                    tt1.setCreateUser ( userId );
                    tt1.setUpdateTime ( new Date () );
                    tt1.setUpdateUser ( userId );
                    try {
                        // 减少备用刀的数量
                        Tooltransfer tt = new Tooltransfer ();
                        tt.setRfidContainerID ( beiyongRfidConner );
                        tt.setToolID ( tt1.getToolID () );
                        tt.setBusinessFlowLnkID ( IConstant.C01S010 );
                        tt.setToolDurable ( new BigDecimal ( gm.getNumbers () ) );
                        tt.setUpdateTime ( new Date () );
                        tt.setUpdateUser ( userId );
                        tooltransferDao.updatecontainerCount ( tt );

                        tooltransferDao.insert ( tt1 );
                    } catch (Exception e) {
                        e.printStackTrace ();
                        return IConstant.STRING_1;
                    }
                }
            }
        }
        //处理刃磨的刀片
        if (grindingContainerRfid != null && grindingMsgs != null && grindingMsgs.size () > 0) {
            Rfidcontainer rfidcontainer = new Rfidcontainer ();
            rfidcontainer.setRfidCode ( grindingContainerRfid );
            rfidcontainer.setDelFlag ( IConstant.STSATIC_ZERO );
            String rfidcontainerId = ((Rfidcontainer) rfidcontainerDao.searchByList ( rfidcontainer ).get ( 0 )).getRfidContainerID ();
            for (ScanGrinding gm : grindingMsgs) {
                Tool tool = new Tool ();
                tool.setToolCode ( gm.getToolCode () );
                String toolId = ((Tool) toolDao.searchByList ( tool ).get ( 0 )).getToolID ();
                tt2.setToolID ( toolId );
                // 对刀室
                // 刀具部门(0库存,1对刀室,2刃磨室,3,车间)
                tt2.setToolThisState ( IConstant.STSATIC_ONE );
                tt2.setToolDurable ( new BigDecimal ( gm.getNumbers () ) ); // 数量
                tt2.setRfidContainerID ( rfidcontainerId );
                tt2.setProcessAmount ( toolString );
                tt2.setKnifeInventoryCode ( UUIDgen.getId () );// 刀具入库编码
                tt2.setStockState ( IConstant.STOCK_STATE_4 );//库存状态(0正常1报废2返厂3封存4.流转9其他)
                tt2.setInstallationState ( IConstant.INSTALLATION_STATE_2 );
                tt2.setCreateTime ( new Date () );
                tt2.setCreateUser ( userId );
                tt2.setUpdateTime ( new Date () );
                tt2.setUpdateUser ( userId );
                tt2.setDelFlag ( IConstant.DEL_FLAG_0 );
                try {
                    Tooltransfer tt = new Tooltransfer ();
                    tt.setRfidContainerID ( beiyongRfidConner );
                    tt.setProcessAmount ( toolString );
                    tt.setToolID ( tt2.getToolID () );
                    tt.setBusinessFlowLnkID ( IConstant.C01S010 );
                    tt.setToolDurable ( new BigDecimal ( gm.getNumbers () ) );
                    tt.setUpdateTime ( new Date () );
                    tt.setUpdateUser ( userId );
                    tooltransferDao.updatecontainerCount ( tt );
                    tooltransferDao.insert ( tt2 );
                } catch (Exception e) {
                    e.printStackTrace ();
                    return IConstant.STRING_1;
                }
            }
        }
        // 处理刃磨的钻头
        if (grindingBitMsgs != null && grindingBitMsgs.size () > 0) {
            // 合成刀具的载体id
            String synthesisRfid = (String) map.get ( "synthesisParametersRfid" );
            for (GrindingBitMsge gbm : grindingBitMsgs) {
                try {
                    String uuid = UUIDgen.getId ();

                    // 待换装的单品刀具的载体id
                    Rfidcontainer r = new Rfidcontainer ();
                    r.setRfidCode ( gbm.getRfidCode () );
                    r.setDelFlag ( IConstant.STRING_0 );
                    String singleRfid = ((List<Rfidcontainer>) rfidcontainerDao.searchByList ( r )).get ( 0 ).getRfidContainerID ();

                    Tool tool = new Tool ();
                    tool.setToolCode ( gbm.getToolCode () );
                    String toolId = ((Tool) toolDao.searchByList ( tool ).get ( 0 )).getToolID ();

                    tt3 = new Tooltransfer ();
                    tt3.setRfidContainerIDWhere ( singleRfid );
                    tt3.setToolIDWhere ( toolId );
                    tt3.setRfidContainerID ( uuid );
                    tt3.setToolDurable ( BigDecimal.ONE );
                    tt3.setProcessAmount ( toolString );
                    tt3.setUpdateTime ( new Date () );
                    tt3.setUpdateUser ( userId );
                    tt3.setBusinessFlowLnkID ( IConstant.C01S010 );
                    tt3.setToolState ( IConstant.STRING_3 );
                    tt3.setToolThisState ( IConstant.STRING_1 );
                    tt3.setUpdateTime ( new Date () );
                    tt3.setUpdateUser ( userId );
                    tooltransferDao.updateNonQuery ( tt3 );

                    tt3 = new Tooltransfer ();
                    tt3.setRfidContainerIDWhere ( synthesisRfid );
                    tt3.setToolIDWhere ( toolId );
                    tt3.setRfidContainerID ( singleRfid );
                    tt3.setToolDurable ( BigDecimal.ONE );
                    tt3.setProcessAmount ( toolString );
                    tt3.setUpdateTime ( new Date () );
                    tt3.setUpdateUser ( userId );
                    tt3.setBusinessFlowLnkID ( IConstant.C01S010 );
                    tt3.setToolState ( IConstant.STRING_3 );
                    tt3.setToolThisState ( IConstant.STRING_1 );
                    tt3.setOrderString ( "UpdateTime" );
                    tt3.setStaIndex ( 1 );
                    tooltransferDao.updateNonQuery ( tt3 );

                    tt3 = new Tooltransfer ();
                    tt3.setRfidContainerIDWhere ( uuid );
                    tt3.setToolIDWhere ( toolId );
                    tt3.setRfidContainerID ( synthesisRfid );
                    tt3.setUpdateTime ( new Date () );
                    tt3.setUpdateUser ( userId );
                    tt3.setBusinessFlowLnkID ( IConstant.C01S010 );
                    tt3.setToolState ( IConstant.STRING_3 );
                    tt3.setToolThisState ( IConstant.STRING_1 );
                    tooltransferDao.updateNonQuery ( tt3 );

                    Tooltransfer tsentity = new Tooltransfer ();
                    // 更新rfid
                    tsentity.setRfidContainerIDWhere ( synthesisRfid );
                    tsentity.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
                    tsentity.setUpdateTime ( new Date () );
                    tsentity.setUpdateUser ( userId );
                    tsentity.setBusinessFlowLnkID ( IConstant.C01S010 );
                    // 更新刀具流转表
                    tooltransferDao.updateNonQuery ( tsentity );

                    // 查询刀具入库编码
                    String knifeInventoryCode = null;
                    tsentity = new Tooltransfer ();
                    tsentity.setRfidContainerID ( singleRfid );
                    List<Tooltransfer> ttList2 = (List<Tooltransfer>) tooltransferDao.searchByList ( tsentity );
                    if (ttList2.size () > 0) {
                        knifeInventoryCode = ttList2.get ( 0 ).getKnifeInventoryCode ();
                    }

                    // 建立生命周期
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
                    twl.setBusinessFlowLnkID ( IConstant.C01S010 );
                    // 手持机id
                    twl.setHandSetID ( map.get ( "handSetId" ).toString () );
                    // 刀具id
                    twl.setToolID ( toolId );
                    //零部件id
                    twl.setPartsID ( "" );
                    //加工数量
                    if (toolString == null) {
                        twl.setProcessAmount ( "0" );
                    } else {
                        twl.setProcessAmount ( toolString + "" );
                    }
                    //删除区分(0有效1删除)
                    twl.setDelFlag ( IConstant.DEL_FLAG_0 );
                    //更新时间
                    twl.setUpdateTime ( new Date () );
                    //更新者
                    twl.setUpdateUser ( userId );
                    //创建时间
                    twl.setCreateTime ( new Date () );
                    //创建者
                    twl.setCreateUser ( userId );
                    //刃磨次数
                    twl.setVersion ( BigDecimal.ZERO );
                    toolwholelifecycleDao.insert ( twl );
                } catch (Exception e) {
                    e.printStackTrace ();
                    return IConstant.STRING_1;
                }
            }
        }

        tooltransfer = new Tooltransfer ();
        tooltransfer.setRfidContainerIDWhere ( synthesisParametersRfid );
        tooltransfer.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
        tooltransfer.setBusinessFlowLnkID ( IConstant.C01S010 );
        tooltransfer.setToolThisState ( IConstant.STRING_1 );
        tooltransfer.setUpdateTime ( new Date () );
        tooltransfer.setUpdateUser ( userId );
        tooltransferDao.updateNonQuery ( tooltransfer );

        // 更新合成刀库
        Synthesisknife sk = new Synthesisknife ();
        sk.setrFIDWhere ( synthesisParametersRfid );
        sk.setDelFlagWhere ( IConstant.DEL_FLAG_0 );// 删除状态
        sk.setLoadState ( IConstant.STRING_5 );// 状态变为已换装
        sk.setBusinessFlowLnkID ( IConstant.C01S010 );
        sk.setUpdateTime ( new Date () );// 更新时间
        sk.setUpdateUser ( userId );// 更新者
        synthesisknifeDao.updateNonQuery ( sk );

        return reVal;
    }

    @Override
    public int saveHotChangeInfo(Map<String, String> par) throws Exception {
        int rev = 0;
        String uuid = UUIDgen.getId ();
        //合成刀具RFID载体
        String synthesConnterID = par.get ( "synthesConnterID" );
        //单品刀具RFID载体
        String singerConneterID = par.get ( "singerConneterID" );
        //用户ID
        String userID = par.get ( "userID" );

        String toolID = par.get ( "toolID" );
        if (toolID == null) {
            return -2;
        }
        //手持机id
        String handSetID = par.get ( "handSetId" );
        //提交热套换装完成信息
        //单品的RFID换成临时ID
        Tooltransfer tt = new Tooltransfer ();
        tt.setRfidContainerIDWhere ( singerConneterID );
        tt.setToolIDWhere ( toolID );
        tt.setRfidContainerID ( uuid );
        tt.setUpdateTime ( new Date () );
        tt.setUpdateUser ( userID );
        tt.setBusinessFlowLnkID ( IConstant.C01S010 );
        tt.setToolState ( IConstant.STRING_3 );
        tt.setToolThisState ( IConstant.STRING_1 );
        rev += tooltransferDao.updateNonQuery ( tt );
        //合成刀换成单品
        tt = new Tooltransfer ();
        tt.setRfidContainerIDWhere ( synthesConnterID );
        tt.setToolIDWhere ( toolID );
        tt.setRfidContainerID ( singerConneterID );
        tt.setUpdateTime ( new Date () );
        tt.setUpdateUser ( userID );
        tt.setBusinessFlowLnkID ( IConstant.C01S010 );
        tt.setToolState ( IConstant.STRING_3 );
        tt.setToolThisState ( IConstant.STRING_1 );

        rev += tooltransferDao.updateNonQuery ( tt );
        //临时ID换成合成刀
        tt = new Tooltransfer ();
        tt.setRfidContainerIDWhere ( uuid );
        tt.setToolIDWhere ( toolID );
        tt.setRfidContainerID ( synthesConnterID );
        tt.setUpdateTime ( new Date () );
        tt.setUpdateUser ( userID );
        tt.setBusinessFlowLnkID ( IConstant.C01S010 );
        tt.setToolState ( IConstant.STRING_3 );
        tt.setToolThisState ( IConstant.STRING_1 );
        rev += tooltransferDao.updateNonQuery ( tt );

        Tooltransfer tsentity = new Tooltransfer ();
        // 更新rfid
        tsentity.setRfidContainerIDWhere ( synthesConnterID );
        tsentity.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
        tsentity.setUpdateTime ( new Date () );
        tsentity.setUpdateUser ( userID );
        tsentity.setBusinessFlowLnkID ( IConstant.C01S010 );
        // 更新刀具流转表
        rev += updateSyrfid ( tsentity );

        //查询刀具入库编码
        String knifeInventoryCode = null;
        tsentity = new Tooltransfer ();
        tsentity.setRfidContainerID ( singerConneterID );
        List<Tooltransfer> ttList2 = (List<Tooltransfer>) tooltransferDao.searchByList ( tsentity );
        tsentity = new Tooltransfer ();
        tsentity.setRfidContainerID ( synthesConnterID );
        List<Tooltransfer> ttList3 = (List<Tooltransfer>) tooltransferDao.searchByList ( tsentity );
        ttList2.addAll ( ttList3 );
        //建立生命周
        Toolwholelifecycle twl = null;
        List<Toolwholelifecycle> twls = new ArrayList<Toolwholelifecycle> ();
        for (Tooltransfer tt2 : ttList2) {
            twl = new Toolwholelifecycle ();
            // 刀具全生命周期id
            twl.setToolWholeLifecycleID ( UUIDgen.getId () );
            // 刀具入库编码
            twl.setKnifeInventoryCode ( tt2.getKnifeInventoryCode () );
            // 流程id
            twl.setBusinessFlowLnkID ( IConstant.C01S010 );
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
            //版本号
            if (tt2.getUsageCounter () != null) {
                twl.setVersion ( tt2.getUsageCounter () );
            } else {
                twl.setVersion ( BigDecimal.ZERO );
            }
            twls.add ( twl );
        }
        toolwholelifecycleDao.insertBatchs ( twls );

        Synthesisknife st = new Synthesisknife ();
        st.setrFIDWhere ( synthesConnterID );
        st.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
        //状态变为已换装
        st.setLoadState ( IConstant.STRING_5 );
        st.setBusinessFlowLnkID ( IConstant.C01S010 );
        //是否安装(0安装1卸下9其他)
        st.setInstallFlag ( IConstant.INSTALL_FLAG_1 );
        st.setUpdateTime ( new Date () );//更新时间
        st.setUpdateUser ( userID );//更新者
        st.setCreateTime ( new Date () );//创建时间
        st.setCreateUser ( userID );//创建者
        rev += synthesisknifeDao.updateNonQuery ( st );
        return rev;
    }

    @Override
    public int saveSubmitWithoutUnload(String rfidContainerId, String userId) throws Exception {
        int reVal = 0;
        try {
            Tooltransfer tt = new Tooltransfer ();
            tt.setRfidContainerIDWhere ( rfidContainerId );
            tt.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
            // 最后业务流程：刀具换装
            tt.setBusinessFlowLnkID ( IConstant.C01S010 );
            // 刀具部门：对刀室
            tt.setToolThisState ( IConstant.STRING_1 );
            tt.setUpdateTime ( new Date () );
            tt.setUpdateUser ( userId );
            reVal += tooltransferDao.updateNonQuery ( tt );

            // 更新合成刀库
            Synthesisknife sk = new Synthesisknife ();
            sk.setrFIDWhere ( rfidContainerId );
            sk.setDelFlagWhere ( IConstant.DEL_FLAG_0 );// 删除状态
            sk.setLoadState ( IConstant.STRING_5 );// 状态变为已换装
            sk.setBusinessFlowLnkID ( IConstant.C01S010 );
            sk.setUpdateTime ( new Date () );// 更新时间
            sk.setUpdateUser ( userId );// 更新者
            reVal += synthesisknifeDao.updateNonQuery ( sk );
        } catch (Exception e) {
            System.out.println ( "ICOMPV01C01S010ServiceImpl.java--saveSubmitWithoutUnload----" + e.toString () );
            return 0;
        }
        return reVal;
    }

    @Override
    public int saveLoadownMsg(Map<String, String> par) throws Exception {
        int rev = 0;
        String rifdConnerID = UUIDgen.getId ();
        //合成刀具RFID载体
        String synthesConnterID = par.get ( "synthesConnterID" );
        //空盒的RFIDCode
        String singerConneterID = par.get ( "singerConneterID" );
        //用户ID
        String userID = par.get ( "userID" );

        String toolID = par.get ( "toolID" );
        //单品ID
        String singlsToolID = par.get ( "singlsToolID" );
        //0：钻头  1：刀片
        String flag = par.get ( "flag" );
        if (toolID == null) {
            return -2;
        }
        //手持机id
        String handSetID = par.get ( "handSetId" );
        if (singerConneterID != null && IConstant.STRING_0.equals ( flag )) {
            Rfidcontainer rfidcontainer = new Rfidcontainer ();
            //RFID载体ID
            rfidcontainer.setRfidContainerID ( rifdConnerID );
            //RFID标签ID
            rfidcontainer.setRfidCode ( singerConneterID );
            //RFID重用次数
            rfidcontainer.setRfidReCount ( BigDecimal.ONE );
            //绑定类型(0RFID 1 激光码 2 工具盘 9 其他)
            rfidcontainer.setBandType ( IConstant.BAND_TYPE_0 );
            //标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
            rfidcontainer.setQueryType ( IConstant.KNIFE_INVENTORY_TYPE_1 );
            //删除区分(0有效1删除)
            rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
            rfidcontainer.setCreateTime ( new Date () );
            rfidcontainer.setUpdateTime ( new Date () );
            rfidcontainer.setCreateUser ( userID );
            rfidcontainer.setUpdateUser ( userID );
            rfidcontainer.setVersion ( BigDecimal.ZERO );
            //加入载体表
            rfidcontainerDao.insert ( rfidcontainer );
        }

        Tooltransfer tt = new Tooltransfer ();
        if (IConstant.STRING_1.equals ( flag )) {
            //刀片
            tt.setRfidContainerID ( singerConneterID );
            tt.setToolID ( toolID );
            tt.setDelFlag ( IConstant.DEL_FLAG_0 );
            List<Tooltransfer> tts = (List<Tooltransfer>) tooltransferDao.searchByList ( tt );
            if (tts != null && tts.size () > 0) {
                //  装入报废容器
                tt.setRfidContainerIDWhere ( singerConneterID );
                if (tts.get ( 0 ).getToolDurable () == null) {
                    tt.setToolDurable ( BigDecimal.ONE );
                } else {
                    tt.setToolDurable ( BigDecimal.ONE.add ( tts.get ( 0 ).getToolDurable () ) );
                }


            } else {
                //装入空容器-刀片
                tt.setRfidContainerIDWhere ( synthesConnterID );
                //报废容器
                tt.setRfidContainerID ( singerConneterID );
            }
            tt.setToolIDWhere ( toolID );
            tt.setUpdateUser ( userID );
            tt.setBusinessFlowLnkID ( IConstant.C01S006 );
            tt.setToolState ( IConstant.STRING_5 );
            tt.setToolThisState ( IConstant.STRING_1 );
            tt.setStockState ( IConstant.STOCK_STATE_1 );
            tt.setInstallationState ( IConstant.STOCK_STATE_2 );
            tt.setUpdateTime ( new Date () );
            rev += tooltransferDao.updateNonQuery ( tt );


        } else {
            //装入空盒-钻头
            tt.setRfidContainerIDWhere ( synthesConnterID );
            tt.setToolIDWhere ( toolID );
            tt.setKnifeInventoryCodeWhere ( singlsToolID );
            tt.setRfidContainerID ( rifdConnerID );
            tt.setUpdateTime ( new Date () );
            tt.setUpdateUser ( userID );
            tt.setBusinessFlowLnkID ( IConstant.C01S006 );
            tt.setToolState ( IConstant.STRING_3 );
            tt.setToolThisState ( IConstant.STRING_1 );
            rev += tooltransferDao.updateNonQuery ( tt );
        }

        tt = new Tooltransfer ();
        //合成刀具载体
        tt.setRfidContainerIDWhere ( synthesConnterID );
        tt.setToolIDWhere ( toolID );
        tooltransferDao.delete ( tt );
        Tooltransfer tsentity = new Tooltransfer ();
        // 更新rfid
        tsentity.setRfidContainerIDWhere ( synthesConnterID );
        tsentity.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
        tsentity.setUpdateTime ( new Date () );
        tsentity.setUpdateUser ( userID );
        tsentity.setBusinessFlowLnkID ( IConstant.C01S006 );
        // 更新刀具流转表
        rev += updateSyrfid ( tsentity );

        //查询单品刀具
        tsentity = new Tooltransfer ();
        tsentity.setRfidContainerID ( rifdConnerID );

        List<Tooltransfer> ttList2 = (List<Tooltransfer>) tooltransferDao.searchByList ( tsentity );
        //合成刀具
        tsentity = new Tooltransfer ();
        tsentity.setRfidContainerID ( synthesConnterID );
        List<Tooltransfer> ttList3 = (List<Tooltransfer>) tooltransferDao.searchByList ( tsentity );
        if (ttList2 == null) {
            ttList2 = new ArrayList<> ();
        }
        ttList2.addAll ( ttList3 );
        //建立生命周
        Toolwholelifecycle twl = null;
        List<Toolwholelifecycle> twls = new ArrayList<Toolwholelifecycle> ();
        for (Tooltransfer tt2 : ttList2) {
            twl = new Toolwholelifecycle ();
            // 刀具全生命周期id
            twl.setToolWholeLifecycleID ( UUIDgen.getId () );
            // 刀具入库编码
            twl.setKnifeInventoryCode ( tt2.getKnifeInventoryCode () );
            // 流程id
            twl.setBusinessFlowLnkID ( IConstant.C01S006 );
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
            //版本号
            if (tt2.getUsageCounter () != null) {
                twl.setVersion ( tt2.getUsageCounter () );
            } else {
                twl.setVersion ( BigDecimal.ZERO );
            }
            twls.add ( twl );
        }
        if (twls.size () > 0) {
            toolwholelifecycleDao.insertBatchs ( twls );
        }

        Synthesisknife st = new Synthesisknife ();
        st.setrFIDWhere ( synthesConnterID );
        st.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
        //状态变为已换装
        st.setLoadState ( IConstant.STRING_5 );
        st.setBusinessFlowLnkID ( IConstant.C01S006 );
        //是否安装(0安装1卸下9其他)
        st.setInstallFlag ( IConstant.INSTALL_FLAG_1 );
        st.setUpdateTime ( new Date () );//更新时间
        st.setUpdateUser ( userID );//更新者
        st.setCreateTime ( new Date () );//创建时间
        st.setCreateUser ( userID );//创建者
        rev += synthesisknifeDao.updateNonQuery ( st );
        return rev;
    }

    @Override
    public int saveUploadingMsg(Map<String, String> par) throws Exception {

        Tooltransfer tsentity = new Tooltransfer ();
        Tooltransfer tt = new Tooltransfer ();
        int rev = 0;
        //合成刀具RFID载体
        String synthesConnterID = par.get ( "synthesConnterID" );
        //砖头的载体
        String singerConneterID = par.get ( "singerConneterID" );
        String synthesConnterCode = par.get ( "synthesConnterCode" );
        //0：钻头，1刀片
        String flag = par.get ( "flag" );
        //用户ID
        String userID = par.get ( "userID" );
        //手持机id
        String handSetID = par.get ( "handSetId" );
        //0：未初始化同，1已初始化
        String init = par.get ( "init" );

        String toolID = par.get ( "toolID" );
        if (StringUtils.isEmpty ( toolID )) {
            return -2;
        }
        if (IConstant.STRING_0.equals ( flag )) {
            //钻头
            Tooltransfer toll = new Tooltransfer ();
            toll.setRfidContainerID ( singerConneterID );
            List<Tooltransfer> tooltransfers = (List<Tooltransfer>) tooltransferDao.searchByList ( toll );
            if (tooltransfers != null && tooltransfers.size () > 0) {
                if (!toolID.equals ( tooltransfers.get ( 0 ).getToolID () )) {
                    //刀具不一致
                    return -3;
                }
            }
            toll = new Tooltransfer ();
            toll.setRfidContainerID ( singerConneterID );
            toll.setToolID ( toolID );
            toll.setDelFlag ( IConstant.DEL_FLAG_0 );
            toll.setToolState ( IConstant.STRING_4 );
            toll.setStockState ( IConstant.STOCK_STATE_4 );
            if (tooltransferDao.searchByCount ( toll ) < 1) {
                return -5;
            }
            //钻头载体改为合成刀具载体
            tt = new Tooltransfer ();
            tt.setRfidContainerIDWhere ( singerConneterID );
            tt.setToolIDWhere ( toolID );

            tt.setRfidContainerID ( synthesConnterID );
            tt.setUpdateTime ( new Date () );
            tt.setUpdateUser ( userID );
            tt.setBusinessFlowLnkID ( IConstant.C01S007 );
            //刀具状态(0断刀1丢失2不合格3待分拣4待换装,5到寿,6厂内待刃磨,7.厂外待刃磨8刃磨完毕,9其他10.已出厂修磨 11.厂外待涂层 12.出库报废)
            tt.setToolState ( IConstant.STRING_4 );
            // 刀具部门(0库存,1对刀室,2刃磨室,3,车间4,初始化)
            tt.setToolThisState ( IConstant.STRING_3 );
            //刀具安装合成刀状态(0未安装1已安装2卸下9其他)
            tt.setInstallationState ( IConstant.INSTALLATION_STATE_1 );
            rev += tooltransferDao.updateNonQuery ( tt );

            // 更新rfid
            tsentity.setRfidContainerIDWhere ( synthesConnterID );
            tsentity.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
            tsentity.setUpdateTime ( new Date () );
            tsentity.setUpdateUser ( userID );
            tsentity.setInstallationState ( IConstant.STOCK_STATE_1 );
            tsentity.setBusinessFlowLnkID ( IConstant.C01S007 );
            // 更新刀具流转表
            rev += updateSyrfid ( tsentity );

            //钻头变为空盒
            Rfidcontainer rfidcontainer = new Rfidcontainer ();
            rfidcontainer.setRfidContainerIDWhere ( singerConneterID );
            rfidcontainerDao.delete ( rfidcontainer );
        } else {
            //查询备刀库中是否有要更换的刀具
            tsentity = new Tooltransfer ();
            tsentity.setToolID ( toolID );
            tsentity.setDelFlag ( IConstant.DEL_FLAG_0 );
            tsentity.setToolState ( IConstant.STRING_4 );
            tsentity.setStockState ( IConstant.STOCK_STATE_4 );
            List<Tooltransfer> baks = (List<Tooltransfer>) tooltransferDao.searchByList ( tsentity );
            if (baks != null && baks.size () > 0 && baks.get ( 0 ).getToolDurable () != null && baks.get ( 0 ).getToolDurable ().intValue () > 0) {
                tt = baks.get ( 0 ); //备用刀
                //如果有减一
                tsentity = new Tooltransfer ();
                tsentity.setRfidContainerIDWhere ( tt.getRfidContainerID () );
                tsentity.setToolIDWhere ( tt.getToolID () );
                tsentity.setKnifeInventoryCodeWhere ( tt.getKnifeInventoryCode () );
                if (tt.getToolDurable () == null) {
                    tt.setToolDurable ( BigDecimal.ONE );
                }
                tsentity.setToolDurable ( tt.getToolDurable ().subtract ( BigDecimal.ONE ) );
                tsentity.setUpdateTime ( new Date () );
                tsentity.setUpdateUser ( userID );
                tooltransferDao.updateNonQuery ( tsentity );
                //并且插入数据
                tsentity = new Tooltransfer ();
                tsentity.setRfidContainerID ( synthesConnterID );
                tsentity.setToolID ( toolID );
                // 对刀室
                // 刀具部门(0库存,1对刀室,2刃磨室,3,车间)
                tsentity.setToolThisState ( IConstant.STSATIC_ONE );
                tsentity.setBusinessFlowLnkID ( IConstant.C01S007 );
                tsentity.setToolDurable ( BigDecimal.ONE ); // 数量
                tsentity.setProcessAmount ( BigDecimal.ZERO );
                tsentity.setKnifeInventoryCode ( UUIDgen.getTimes () );// 刀具入库编码
                tsentity.setStockState ( IConstant.STOCK_STATE_4 );//库存状态(0正常1报废2返厂3封存4.流转9其他)
                tsentity.setInstallationState ( IConstant.INSTALLATION_STATE_1 );
                tsentity.setCreateTime ( new Date () );
                tsentity.setCreateUser ( userID );
                tsentity.setUpdateTime ( new Date () );
                tsentity.setUpdateUser ( userID );
                tsentity.setDelFlag ( IConstant.DEL_FLAG_0 );
                tooltransferDao.insert ( tsentity );
            } else {
                return -4;
                //如果没有返回-4
            }
        }

        //合成刀具
        tsentity = new Tooltransfer ();
        tsentity.setRfidContainerID ( synthesConnterID );
        List<Tooltransfer> ttList2 = (List<Tooltransfer>) tooltransferDao.searchByList ( tsentity );

        //建立生命周
        Toolwholelifecycle twl = null;
        List<Toolwholelifecycle> twls = new ArrayList<Toolwholelifecycle> ();
        for (Tooltransfer tt2 : ttList2) {
            twl = new Toolwholelifecycle ();
            // 刀具全生命周期id
            twl.setToolWholeLifecycleID ( UUIDgen.getId () );
            // 刀具入库编码
            twl.setKnifeInventoryCode ( tt2.getKnifeInventoryCode () );
            // 流程id
            twl.setBusinessFlowLnkID ( IConstant.C01S007 );
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
            //版本号
            if (tt2.getUsageCounter () != null) {
                twl.setVersion ( tt2.getUsageCounter () );
            } else {
                twl.setVersion ( BigDecimal.ZERO );
            }
            twls.add ( twl );
        }
        if (twls.size () > 0) {
            toolwholelifecycleDao.insertBatchs ( twls );
        }
        if (IConstant.STRING_1.equals ( flag ) && IConstant.STRING_0.equals ( init )) {
            //刀片未初始化
            //备刀库容器
            tsentity = new Tooltransfer ();
            tsentity.setRfidContainerIDWhere ( tt.getRfidContainerID () );
            tsentity.setToolIDWhere ( tt.getToolID () );
            tsentity.setKnifeInventoryCodeWhere ( tt.getKnifeInventoryCode () );
            if (tt.getToolDurable () == null) {
                tt.setToolDurable ( BigDecimal.ONE );
            }
            tsentity.setToolDurable ( tt.getToolDurable ().subtract ( BigDecimal.ONE ) );
            tsentity.setUpdateTime ( new Date () );
            tsentity.setUpdateUser ( userID );
            tooltransferDao.updateNonQuery ( tsentity );

        }

        // 更新流程
        tsentity = new Tooltransfer ();
        tsentity.setRfidContainerIDWhere ( synthesConnterID );
        tsentity.setToolThisState ( IConstant.STSATIC_ONE );
        tsentity.setBusinessFlowLnkID ( IConstant.C01S007 );
        tsentity.setUpdateTime ( new Date () );
        tsentity.setUpdateUser ( userID );

        tooltransferDao.updateNonQuery ( tsentity );

        Synthesisknife st = new Synthesisknife ();

        if (IConstant.STRING_0.equals ( init )) {
            //未初始化
            st.setSynthesisParametersCode ( synthesConnterCode );//合成刀具编码
            st.setOrderString ( "ABS(SynthesisParametersNumber) desc" );
            st.setRowCount ( 1 );
            Synthesisknife sk1 = synthesisknifeDao.searchBySynthesisknife ( st );
            String synthesisParametersNumber = "001";
            if (sk1 != null) {
                int temp = Integer.parseInt ( sk1.getSynthesisParametersNumber () );
                if (temp < 9) {
                    synthesisParametersNumber = "00" + (temp + 1);
                } else if (temp < 99) {
                    synthesisParametersNumber = "0" + (temp + 1);
                } else {
                    synthesisParametersNumber = (temp + 1) + "";
                }
            }
            st = new Synthesisknife ();
            st.setrFIDWhere ( synthesConnterID );
            st.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
            //状态变为已换装
            st.setLoadState ( IConstant.STRING_3 );
            st.setBusinessFlowLnkID ( IConstant.C01S007 );
            //是否安装(0安装1卸下9其他)
            st.setInstallFlag ( IConstant.INSTALL_FLAG_0 );
            st.setSynthesisParametersCode ( synthesConnterCode );
            st.setSynthesisParametersNumber ( synthesisParametersNumber );
            st.setUpdateTime ( new Date () );//更新时间
            st.setUpdateUser ( userID );//更新者
            st.setCreateTime ( new Date () );//创建时间
            st.setCreateUser ( userID );//创建者
            rev += synthesisknifeDao.updateNonQuery ( st );
        } else {
            //已初始化
            st = new Synthesisknife ();
            st.setrFIDWhere ( synthesConnterID );
            st.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
            //状态变为已换装
            st.setLoadState ( IConstant.STRING_3 );
            st.setBusinessFlowLnkID ( IConstant.C01S007 );
            //是否安装(0安装1卸下9其他)
            st.setInstallFlag ( IConstant.INSTALL_FLAG_0 );
            st.setSynthesisParametersCode ( synthesConnterCode );
            st.setUpdateTime ( new Date () );//更新时间
            st.setUpdateUser ( userID );//更新者
            st.setCreateTime ( new Date () );//创建时间
            st.setCreateUser ( userID );//创建者
            rev += synthesisknifeDao.updateNonQuery ( st );
        }

        return rev;
    }

    @Override
    public int getTooltransferCount(Tooltransfer tt) throws Exception {
        return tooltransferDao.searchByCount ( tt );
    }

    @Override
    public int deleteRfidByToolID(Map<String, Object> map) throws Exception {
        //删除备刀库的刀具信息
        int reVal = 0;

        //用户ID
        String userID = (String) map.get ( "userID" );
        //刀具ID
        String toolID = (String) map.get ( "toolID" );
        //手持机id
        String handSetId = (String) map.get ( "handSetId" );
        // //0：钻头，1刀片
        String flag = (String) map.get ( "flag" );
        if (IConstant.STRING_0.equals ( flag )) {
            //钻头
            List<String> rfidList = (List<String>) map.get ( "rfidList" );
            //删除流转表
            if (rfidList != null && rfidList.size () > 0)
                reVal += tooltransferDao.deleteByRfidCodeList ( rfidList );

            //删除RFID载体表
            if (rfidList != null && rfidList.size () > 0)
                reVal += rfidcontainerDao.deleteByRfidCodeList ( rfidList );

        } else {
            //刀片
            //备刀库相应的刀具数量减少
            //备刀库容器
            Tooltransfer tt = new Tooltransfer ();
            Tooltransfer tsentity = new Tooltransfer ();
            tsentity.setToolID ( toolID );
            tsentity.setDelFlag ( IConstant.DEL_FLAG_0 );
            tsentity.setToolState ( IConstant.STRING_4 );
            tsentity.setStockState ( IConstant.STOCK_STATE_4 );
            List<Tooltransfer> baks = (List<Tooltransfer>) tooltransferDao.searchByList ( tsentity );
            if (baks != null && baks.size () > 0 && baks.get ( 0 ).getToolDurable () != null && baks.get ( 0 ).getToolDurable ().intValue () > 0) {
                tt = baks.get ( 0 );
            } else {
                return -1;
            }
            tsentity.setRfidContainerIDWhere ( tt.getRfidContainerID () );
            tsentity.setToolIDWhere ( toolID );
            if (tt.getToolDurable () == null) {
                tt.setToolDurable ( BigDecimal.ONE );
            }
            tsentity.setToolDurable ( tt.getToolDurable ().subtract ( BigDecimal.ONE ) );
            tsentity.setUpdateTime ( new Date () );
            tsentity.setUpdateUser ( userID );
            reVal += tooltransferDao.updateNonQuery ( tsentity );
        }
        return reVal;
    }

    @Override
    public int seachToolMsg(Map<String, String> map) throws Exception {
        //载体ID
        String rfidConnerID = map.get ( "rfidConnerID" );
        //刀具ID
        String toolID = map.get ( "toolID" );

        //是否是和要安上的刀具ID一样
        Tooltransfer tt = new Tooltransfer ();
        tt.setRfidContainerID ( rfidConnerID );
        tt = (Tooltransfer) tooltransferDao.searchByPrimaryKey ( tt );
        if (tt != null && tt.getToolID () != null && (!tt.getToolID ().equals ( toolID ))) {
            return -1;
        }
        //是否是备刀库中的刀具
        tt = new Tooltransfer ();
        tt.setRfidContainerID ( rfidConnerID );
        tt.setToolID ( toolID );
        tt.setDelFlag ( IConstant.DEL_FLAG_0 );
        tt.setToolState ( IConstant.STRING_4 );
        tt.setStockState ( IConstant.STOCK_STATE_4 );
        return tooltransferDao.searchByCount ( tt );
    }

}
