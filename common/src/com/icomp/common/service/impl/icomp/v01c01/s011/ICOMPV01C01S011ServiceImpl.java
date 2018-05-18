package com.icomp.common.service.impl.icomp.v01c01.s011;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s011.ICOMPV01C01S011Service;
import com.icomp.common.utils.DateFormatUtil;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.common.utils.UUIDgen;
import com.icomp.dao.*;
import com.icomp.entity.base.*;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 设备安上
 *
 * @author Taoyy
 * @ClassName: ICOMPV01C01S011ServiceImpl
 * @date 2014-11-7 上午09:13:09
 */
@SuppressWarnings("unchecked")
public class ICOMPV01C01S011ServiceImpl extends BaseService implements ICOMPV01C01S011Service {
    SimpleDateFormat sf = new SimpleDateFormat ( "yyyyMMddHHmmss" );
    private SynthesisknifeDao synthesisknifeDao;
    private ToolsmachiningDao toolsmachiningDao;
    private String customerID;

    public void setSf(SimpleDateFormat sf) {
        this.sf = sf;
    }

    public void setToolsmachiningDao(ToolsmachiningDao toolsmachiningDao) {
        this.toolsmachiningDao = toolsmachiningDao;
    }

    public void setSynthesisknifeDao(SynthesisknifeDao synthesisknifeDao) {
        this.synthesisknifeDao = synthesisknifeDao;
    }

    private VgetequipmentlistDao vgetequipmentlistDao;

    public void setVgetequipmentlistDao(VgetequipmentlistDao vgetequipmentlistDao) {
        this.vgetequipmentlistDao = vgetequipmentlistDao;
    }

    // 根据合成刀具RFID取得设备信息
    private VgetequipmentnamebyrfidDao vgetequipmentnamebyrfidDao;

    public void setVgetequipmentnamebyrfidDao(VgetequipmentnamebyrfidDao vgetequipmentnamebyrfidDao) {
        this.vgetequipmentnamebyrfidDao = vgetequipmentnamebyrfidDao;
    }

    // 载体
    private RfidcontainerDao rfidcontainerDao;

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    // 流转刀具
    private TooltransferDao tooltransferDao;

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    // 取得当前刀具的最后执行业务流程
    private BusinessflowlnkDao businessflowlnkDao;

    public void setBusinessflowlnkDao(BusinessflowlnkDao businessflowlnkDao) {
        this.businessflowlnkDao = businessflowlnkDao;
    }

    // 取得业务流程ID
    private BusinessDao businessDao;

    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    // 刀具参数
    private ToolDao toolDao;

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    // 生命周期
    private ToolwholelifecycleDao toolwholelifecycleDao;

    public void setToolwholelifecycleDao(ToolwholelifecycleDao toolwholelifecycleDao) {
        this.toolwholelifecycleDao = toolwholelifecycleDao;
    }

    // 加工履历
    private SynthesistoolsmachiningDao synthesistoolsmachiningDao;

    public void setSynthesistoolsmachiningDao(SynthesistoolsmachiningDao synthesistoolsmachiningDao) {
        this.synthesistoolsmachiningDao = synthesistoolsmachiningDao;
    }

    // 刀具流转履历
    private TooltransferhistoryDao tooltransferhistoryDao;

    public void setTooltransferhistoryDao(TooltransferhistoryDao tooltransferhistoryDao) {
        this.tooltransferhistoryDao = tooltransferhistoryDao;
    }

    private SynthesisexperienceDao synthesisexperienceDao;

    public void setSynthesisexperienceDao(SynthesisexperienceDao synthesisexperienceDao) {
        this.synthesisexperienceDao = synthesisexperienceDao;
    }

    private EquipmentDao equipmentDao;

    public void setEquipmentDao(EquipmentDao equipmentDao) {
        this.equipmentDao = equipmentDao;
    }

    private SynthesisparametersDao synthesisparametersDao;

    public void setSynthesisparametersDao(SynthesisparametersDao synthesisparametersDao) {
        this.synthesisparametersDao = synthesisparametersDao;
    }

    private OplinkDao oplinkDao;

    public void setOplinkDao(OplinkDao oplinkDao) {
        this.oplinkDao = oplinkDao;
    }

    private AssemblylineDao assemblylineDao;

    public void setAssemblylineDao(AssemblylineDao assemblylineDao) {
        this.assemblylineDao = assemblylineDao;
    }
    //2017/08/14 王冉 追加↓↓↓　dazhong@YMSC
    private VsynthesisconditionDao vsynthesisconditionDao;

    public void setVsynthesisconditionDao(VsynthesisconditionDao vsynthesisconditionDao) {
        this.vsynthesisconditionDao = vsynthesisconditionDao;
    }
    //2017/08/14 王冉 追加↑↑↑　dazhong@YMSC
    private static final Logger logger = Logger.getLogger ( ICOMPV01C01S011ServiceImpl.class );

    /**
     * 取得合成刀具安装设备信息
     * getEquipmentToolInfo
     *
     * @param entity
     * @return
     * @throws Exception
     */
    @Override
    public List<Vgetequipmentnamebyrfid> getEquipmentToolInfo(Vgetequipmentnamebyrfid entity) throws Exception {
        List<Vgetequipmentnamebyrfid> list = new ArrayList<Vgetequipmentnamebyrfid> ();
        try {
            // 在合成刀库查找该rfid信息
            list = (List<Vgetequipmentnamebyrfid>) vgetequipmentnamebyrfidDao.searchByList ( entity );
            if (list == null || list.size () <= 0) {
                // 合成刀库未在"生产关联配置"中找到设备!
                Vgetequipmentnamebyrfid vedemptionapplied = new Vgetequipmentnamebyrfid ();
                vedemptionapplied.setMessageCode ( IConstant.WMSG0244 );
                vedemptionapplied.setRetErrFlag ( true );
                list.add ( vedemptionapplied );
            }
        } catch (SQLException e) {
            Vgetequipmentnamebyrfid vgetequipmentnamebyrfid = new Vgetequipmentnamebyrfid ();
            // 数据库操作异常,查询失败!
            vgetequipmentnamebyrfid.setMessageCode ( IConstant.EMSG0004 );
            vgetequipmentnamebyrfid.setRetErrFlag ( true );
            vgetequipmentnamebyrfid.setExceMessage ( e.getMessage () );
            list.add ( vgetequipmentnamebyrfid );
        }
        return list;
    }

    /**
     * 取得设备
     * saveToolInEquipment
     *
     * @param rfidString
     * @param synthesisParametersCode
     * @return
     */
    public Map<String, Object> getEquipmentInfo(String rfidString, String synthesisParametersCode) throws Exception {
        Map<String, Object> ret = new HashMap<String, Object> ();
        try {
            //验证扫描的RFID是否正确
            // 取得RFID载体ID
            Rfidcontainer rfidcontainer = new Rfidcontainer ();
            rfidcontainer.setRfidCode ( rfidString );
            rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
            List<Rfidcontainer> rfidList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
            if (rfidList == null || rfidList.size () == 0) {
                ret.put ( "error", true );
                ret.put ( "MessageCode", IConstant.EMSG0004 );// 扫描的标签不存在!
                return ret;
            }
            rfidcontainer = rfidList.get ( 0 );
            Equipment equipment = new Equipment ();
            equipment.setRfidContainerID ( rfidcontainer.getRfidContainerID () );
            List<Equipment> equipmentList = (List<Equipment>) equipmentDao.searchByList ( equipment );
            if (equipmentList == null || equipmentList.size () == 0) {
                ret.put ( "error", true );
                ret.put ( "MessageCode", IConstant.EMSG0004 );// 扫描的设备不存在!
                return ret;
            }
            //验证扫描的设备是否可以安装指定的合成刀具
            //取得合成刀具ID
            Synthesisparameters synthesisparameters = new Synthesisparameters ();
            synthesisparameters.setSynthesisParametersCode ( synthesisParametersCode );
            List<Synthesisparameters> list = (List<Synthesisparameters>) synthesisparametersDao.searchByLikeList ( synthesisparameters );
            if (list == null || list.size () <= 0) {
                // 合成刀具参数未找到相应的数据!
                ret.put ( "error", true );
                ret.put ( "MessageCode", IConstant.WMSG0131 );
                return ret;
            } else {
                synthesisparameters = list.get ( 0 );
                Oplink oplink = new Oplink ();
                oplink.setSynthesisParametersID ( synthesisparameters.getSynthesisParametersID () );
                oplink.setEquipmentID ( equipmentList.get ( 0 ).getEquipmentID () );
                List<Oplink> oplinkList = (List<Oplink>) oplinkDao.searchByList ( oplink );
                if (oplinkList == null || oplinkList.size () <= 0) {
                    ret.put ( "error", true );
                    ret.put ( "MessageCode", IConstant.WMSG0244_1 );// 当前设备无法装入指定的合成刀具!
                    return ret;
                } else {
                    ret.put ( "rows", equipmentList.get ( 0 ) );
                    return ret;
                }
            }
        } catch (SQLException e) {
            ret.put ( "error", true );
            ret.put ( "MessageCode", IConstant.EMSG0004 );
            return ret;
        }
    }

    /**
     * 安上设备保存
     */
    @Override
    public int saveToolInEquipment(Synthesisknife entity, String rfidString, String handsetid) throws Exception {
        String userId = entity.getUpdateUser ();
        int reVal = 0;

        Synthesisknife synthesisknife = new Synthesisknife ();
        synthesisknife.setSynthesisParametersCode ( entity.getSynthesisParametersCode () );
        synthesisknife.setSynthesisParametersNumber ( entity.getSynthesisParametersNumber () );
        synthesisknife.setDelFlag ( IConstant.DEL_FLAG_0 );
        // 查询要修改的数据
        List<Synthesisknife> list = (List<Synthesisknife>) synthesisknifeDao.searchByList ( synthesisknife );
        if (list == null || list.size () <= 0) {
            //System.out.println(IConstant.WMSG0135);
        } else {
            // 取得RFID载体ID
            Rfidcontainer rfidcontainer = new Rfidcontainer ();
            rfidcontainer.setRfidCode ( rfidString );
            rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
            List<Rfidcontainer> rfidList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
            rfidcontainer = rfidList.get ( 0 );

            // 取得流转刀具信息
            Tooltransfer tooltransfer = new Tooltransfer ();
            tooltransfer.setRfidContainerID ( rfidcontainer.getRfidContainerID () );// 取得载体ID
            List<Tooltransfer> tooltransferList = (List<Tooltransfer>) tooltransferDao.searchByList ( tooltransfer );

            // 取得当前刀具的最后执行业务流程
            Businessflowlnk businessflowlnk = new Businessflowlnk ();
            tooltransfer = tooltransferList.get ( 0 );
            businessflowlnk.setBusinessFlowLnkID ( tooltransfer.getBusinessFlowLnkID () );
            //			Businessflowlnk flowLink = (Businessflowlnk) businessflowlnkDao.searchByPrimaryKey(businessflowlnk);
            // 取得业务流程下一个ID
            Business business = new Business ();
            business.setBusinessCode ( "C01S011" );
            List<Business> businessList = (List<Business>) businessDao.searchByList ( business );
            business = businessList.get ( 0 );
            Businessflowlnk businessflowlnks = new Businessflowlnk ();
            businessflowlnks.setBusinessID ( business.getBusinessID () );
            List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList ( businessflowlnks );
            //			businessflowlnks.setBusinessID(flowLink.getBusinessID());
            //			List<Businessflowlnk> list2 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);
            //			for (Businessflowlnk temp1 : list1) {
            //				for (Businessflowlnk temp2 : list2) {
            //					if (temp1.getBusinessFlowID().equals(temp2.getBusinessFlowID()) && temp1.getOrderNumber().intValue() == temp2.getOrderNumber().add(BigDecimal.ONE).intValue()) {
            //						businessflowlnk = temp1;
            //					}
            //				}
            //			}
            businessflowlnk = list1.get ( 0 );
            // 下一个流程ID
            String nextString = businessflowlnk.getBusinessFlowLnkID ();

            Toolwholelifecycle toolwholelifecycle = null;
            List<Toolwholelifecycle> tlcList = new ArrayList<Toolwholelifecycle> ();
            Tooltransferhistory tth = null; // 刀具流转履历
            List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory> ();
            // 流转信息
            for (Tooltransfer tt : tooltransferList) {
                // 记录刀具生命周期数据
                toolwholelifecycle = new Toolwholelifecycle ();
                toolwholelifecycle.setBusinessFlowLnkID ( nextString );
                toolwholelifecycle.setHandSetID ( handsetid );
                Tool tool = new Tool ();
                tool.setToolID ( tt.getToolID () );// 取得刀具信息
                List<Tool> toolList = (List<Tool>) toolDao.searchByList ( tool );
                tool = toolList.get ( 0 );
                toolwholelifecycle.setToolCode ( tool.getToolCode () );
                toolwholelifecycle.setToolName ( tool.getToolName () );
                toolwholelifecycle.setKnifeInventoryCode ( tt.getKnifeInventoryCode () );
                toolwholelifecycle.setDelFlag ( IConstant.DEL_FLAG_0 );
                toolwholelifecycle.setCreateTime ( new Date () );
                toolwholelifecycle.setUpdateTime ( new Date () );
                toolwholelifecycle.setCreateUser ( userId );
                toolwholelifecycle.setUpdateUser ( userId );
                toolwholelifecycle.setVersion ( BigDecimal.ZERO );
                String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue ( IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, userId );
                toolwholelifecycle.setToolWholeLifecycleID ( toolWholeLifecycleID );
                tlcList.add ( toolwholelifecycle );
                // 刀具流转履历
                tth = new Tooltransferhistory ();
                tth.setToolTransferHistoryID ( NextKeyValue.getNextkeyvalue ( IConstant.TOOLTRANSFERHISTORY, IConstant.TOOLTRANSFERHISTORYID, userId ) );
                tth.setRfidContainerID ( tt.getRfidContainerID () ); // RFID载体ID
                tth.setKnifeInventoryCode ( tt.getKnifeInventoryCode () );// 刀具入库编码
                tth.setToolID ( tt.getToolID () );// 刀具ID
                tth.setToolProcuredID ( tt.getProcuredBatch () );// 采购ID
                tth.setBusinessFlowLnkID ( nextString );// 最后执行业务流程(刀具安上)
                tth.setToolDurable ( tt.getToolDurable () );// 耐用度
                tth.setToolSharpennum ( tt.getToolDurable () );// 可使用(刃磨)次数
                tth.setToolSharpenCriterion ( tt.getToolSharpenCriterion () );// 复磨标准
                tth.setToolLength ( tt.getToolLength () );// 刀具长度
                tth.setToolSharpenLength ( tt.getToolSharpenLength () );// 可刃磨长度
                tth.setUsageCounter ( tt.getUsageCounter () );// 已使用(刃磨)次数
                tth.setToolGrindingLength ( tt.getToolGrindingLength () );// 刀具已刃磨长度
                tth.setInstallationState ( IConstant.INSTALLATION_STATE_1 );// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
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
            // 增加生命周期
            toolwholelifecycleDao.insertBatchs ( tlcList );
            // 批量增加【刀具流转履历】
            tooltransferhistoryDao.insertBatchDefined ( tthList );
            // 增加合成刀具加工
            Synthesistoolsmachining stm = null;
            List<Synthesistoolsmachining> list3 = new ArrayList<Synthesistoolsmachining> ();
            String SynthesisNumber = sf.format ( new Date () );// 加工编号(年月日时分秒
            // 14位字符串)
            for (Synthesisknife sk : list) {
                stm = new Synthesistoolsmachining ();
                stm.setSynthesisNumber ( SynthesisNumber );// 加工编号(年月日时分秒 14位字符串)
                //stm.setSynthesisParametersCode(sk.getSynthesisParametersCode());// 合成刀具编码(系统唯一)
                //	stm.setSynthesisCutterNumber(sk.getSynthesisCutterNumber());// 位置号
                //	stm.setSynthesisParametersNumber(sk.getSynthesisParametersNumber());// 合成刀具编号(例如：001、002、003)
                stm.setEquipmentID ( entity.getEquipmentID () );//设备ID
                stm.setAssemblyLineID ( entity.getDelFlag () );//流水线ID
                stm.setLoadTime ( new Date () );// 装入时间
                stm.setLoadUser ( userId );// 操作人
                stm.setOuterTime ( new Date () );// 卸下时间
                stm.setOuterUser ( userId );// 卸下人
                stm.setProcessAmount ( BigDecimal.ZERO );// 加工数量
                stm.setDelFlag ( IConstant.DEL_FLAG_0 );
                stm.setCreateTime ( new Date () );
                stm.setCreateUser ( userId );
                stm.setUpdateTime ( new Date () );// 更新时间
                stm.setUpdateUser ( userId );// 更新者
                stm.setVersion ( BigDecimal.ZERO );// 版本号
                list3.add ( stm );
            }
            // 批量增加【合成刀具加工】
            //	synthesistoolsmachiningDao.insertBatchs(list3);
            // 更新刀具流转
            tooltransfer = new Tooltransfer ();
            tooltransfer.setRfidContainerIDWhere ( rfidcontainer.getRfidContainerID () );// 取得载体ID
            tooltransfer.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
            tooltransfer.setBusinessFlowLnkID ( nextString );
            tooltransfer.setStockState ( IConstant.STOCK_STATE_4 );
            tooltransfer.setUpdateTime ( new Date () );
            tooltransfer.setUpdateUser ( userId );
            tooltransfer.setVersion ( tooltransferList.get ( 0 ).getVersion ().add ( BigDecimal.ONE ) );
            reVal += tooltransferDao.updateNonQuery ( tooltransfer );

            Date date = new Date ();
            // 更新合成刀具流转履历
            Synthesisexperience synthesisexperience = new Synthesisexperience ();
            synthesisexperience.setSynthesisParametersCode ( entity.getSynthesisParametersCode () );
            synthesisexperience.setSynthesisCutterNumber ( BigDecimal.ZERO );
            synthesisexperience.setBusinessFlowLnkID ( nextString );
            synthesisexperience.setSynthesisParametersNumber ( entity.getSynthesisParametersNumber () );
            synthesisexperience.setOperationTime ( date );
            synthesisexperience.setArrivalUser ( userId );
            // 需要写入转出者(转出者为上一条数据的接收者)
            synthesisexperience.setRecipientUser ( userId );
            synthesisexperience.setTransitionBecause ( IConstant.TRANSITION_BECAUSE_0 );
            synthesisexperience.setDelFlag ( IConstant.DEL_FLAG_0 );
            synthesisexperience.setCreateTime ( date );
            synthesisexperience.setUpdateTime ( date );
            synthesisexperience.setCreateUser ( userId );
            synthesisexperience.setUpdateUser ( userId );
            synthesisexperience.setVersion ( BigDecimal.ZERO );
            synthesisexperienceDao.insert ( synthesisexperience );

            // 更新合成刀库
            Synthesisknife entity1 = new Synthesisknife ();
            entity1.setSynthesisParametersCodeWhere ( entity.getSynthesisParametersCode () );// 更新条件
            entity1.setSynthesisParametersNumberWhere ( entity.getSynthesisParametersNumber () );
            entity1.setDelFlagWhere ( IConstant.DEL_FLAG_0 );// 删除区分
            entity1.setEquipmentID ( entity.getEquipmentID () );// 设备id
            entity1.setLoadState ( IConstant.LOADSTATE_0 );// '使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回)(该状态绑定到带标签的数据上)'
            entity1.setBusinessFlowLnkID ( nextString ); // 最后流程
            entity1.setInstallFlag ( IConstant.INSTALL_FLAG_0 );
            entity1.setUpdateTime ( new Date () );// 更新时间
            entity1.setUpdateUser ( userId );// 更新用户
            entity1.setVersion ( list.get ( 0 ).getVersion ().add ( BigDecimal.ONE ) );// 版本加一
            // 更新数据
            reVal += synthesisknifeDao.updateNonQuery ( entity1 );
        }

        return reVal;

    }

    @Override
    public Synthesisknife getSynthesisknife(Synthesisknife spEmtity) throws Exception {
        return synthesisknifeDao.getSynthesisknife ( spEmtity );
    }

    @Override
    public List<Vgetequipmentlist> getEquipmentList(Vgetequipmentlist entity) throws Exception {
        return (List<Vgetequipmentlist>) vgetequipmentlistDao.searchByList ( entity );
    }

    @Override
    public Oplink getOplinkInfo(Oplink entity) throws Exception {
        List<Oplink> list = new ArrayList<Oplink> ();
        Oplink vedemptionapplied = new Oplink ();
        try {
            // 在合成刀库查找该rfid信息
            list = (List<Oplink>) oplinkDao.searchByList ( entity );
            if (list == null || list.size () <= 0) {
                // 合成刀库未在"生产关联配置"中找到设备!
                vedemptionapplied.setMessageCode ( IConstant.WMSG0244 );
                vedemptionapplied.setRetErrFlag ( true );
            } else {
                vedemptionapplied = list.get ( 0 );
            }
        } catch (SQLException e) {
            // 数据库操作异常,查询失败!
            vedemptionapplied.setMessageCode ( IConstant.EMSG0004 );
            vedemptionapplied.setRetErrFlag ( true );
            vedemptionapplied.setExceMessage ( e.getMessage () );
        }
        return vedemptionapplied;
    }

    @Override
    public Synthesisknife getSynParameNumber(Synthesisknife sk) throws SQLException {
        List<Synthesisknife> reList = (List<Synthesisknife>) synthesisknifeDao.searchByList ( sk );
        Synthesisknife reEntity = new Synthesisknife ();
        if (reList.size () < 1) {
            //未找到相应数据
            reEntity.setRetErrFlag ( true );
        } else {
            reEntity = reList.get ( 0 );
        }
        return reEntity;
    }

    @Override
    public Synthesisknife getSynthesisknifebyRfidc(Synthesisknife skEntity) throws Exception {
        List<Synthesisknife> reList = (List<Synthesisknife>) synthesisknifeDao.searchByList ( skEntity );
        Synthesisknife reEntity = new Synthesisknife ();
        if (reList.size () < 1) {
            //未找到相应数据
            reEntity.setRetErrFlag ( true );
        } else {
            reEntity = reList.get ( 0 );
        }
        return reEntity;
    }

    /**
     * 批量增加合成刀加工和单品刀加工列表
     *
     * @param stm
     * @return
     * @throws SQLException
     */

    public int submitSyntheticInstallEquipmentInfo(Synthesistoolsmachining stm) throws SQLException {

        int reIntVal = 0;
        //查询合成加工的数据
        String rfidCode = stm.getExpandSpace1 ();
        List<Toolsmachining> tsList = new ArrayList<Toolsmachining> ();
        Toolsmachining ts = null;
        List<Synthesisknife> sslist = new ArrayList<Synthesisknife> ();
        Synthesisknife st = null;
        //查询合成刀具上单品刀具的信息
        Tooltransfer tt = new Tooltransfer ();
        Rfidcontainer rf = new Rfidcontainer ();
        try {
            rf.setRfidCode ( rfidCode );
            // 标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
            rf.setQueryType ( IConstant.BAND_TYPE_2 );
            rf.setDelFlag ( IConstant.DEL_FLAG_0 );
            List<Rfidcontainer> rlist = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rf );
            String rfidcon = rlist.get ( 0 ).getRfidContainerID ();
            tt.setRfidContainerID ( rfidcon );
            tt.setDelFlag ( IConstant.DEL_FLAG_0 );
            List<Tooltransfer> toolList = tooltransferDao.getSynSingesToolList ( tt );
            List<Toolwholelifecycle> twls = new ArrayList<Toolwholelifecycle> ();
            Toolwholelifecycle twl = null;
            for (Tooltransfer ttf : toolList) {
                twl = new Toolwholelifecycle ();
                twl.setBusinessFlowLnkID ( IConstant.C01S011 );
                twl.setHandSetID ( stm.getExpandSpace4 () );
                twl.setToolCode ( ttf.getToolID () );
                twl.setToolID ( ttf.getToolID () );
                twl.setPartsID ( "" );
                if (ttf.getProcessAmount () != null) {
                    twl.setProcessAmount ( ttf.getProcessAmount ().toString () );
                } else {
                    twl.setProcessAmount ( IConstant.BELONG_FLAG_0 );
                }
                twl.setKnifeInventoryCode ( ttf.getKnifeInventoryCode () );
                twl.setDelFlag ( IConstant.DEL_FLAG_0 );
                twl.setCreateTime ( new Date () );
                twl.setUpdateTime ( new Date () );
                twl.setCreateUser ( stm.getUpdateUser () );
                twl.setUpdateUser ( stm.getUpdateUser () );
                twl.setVersion ( BigDecimal.ZERO );
                twl.setToolWholeLifecycleID ( UUIDgen.getId () );
                twls.add ( twl );

            /*
              //安上时不许要加工信息
              ts = new Toolsmachining();
                //加工编号(年月日时分秒 14位字符串)

                //				if (StringUtils.isEmpty(param.getSynthesisNumber())){
                //					ts.setSynthesisNumber("001");
                //				}else {
                //					ts.setSynthesisNumber(param.getSynthesisNumber());
                //				}

                //刀具入库编码
                if (StringUtils.isEmpty(ttf.getKnifeInventoryCode())) {
                    ts.setKnifeInventoryCode(UUIDgen.getId());
                } else {
                    ts.setKnifeInventoryCode(ttf.getKnifeInventoryCode());
                }

                //刀具ID
                ts.setToolID(ttf.getToolID());
                //流水线ID
                ts.setAssemblyLineID(stm.getAssemblyLineID());
                //设备ID
                ts.setEquipmentID(stm.getEquipmentID());
                //工序ID
                ts.setProcessID(stm.getProcessID());
                //轴ID
                ts.setAxleID(stm.getAxleID());
                //卸下时间
           //     ts.setOuterTime(null);
                //操作人
                ts.setOuterUser(stm.getUpdateUser());
                //卸下原因(0正常卸下1打刀2不合格9其他)(可维护)
                //ts.setRemoveReason(param.getRemoveReason());
                //加工数量
                ts.setProcessAmount(BigDecimal.ZERO);
                //卸下确认人(不合格卸下时需要进行确认)
                //ts.setRemoveUser(null);
                //删除区分(0有效1删除)
                ts.setDelFlag(IConstant.DEL_FLAG_0);
                //更新时间
                ts.setUpdateTime(new Date());
                //更新者
                ts.setUpdateUser(stm.getUpdateUser());
                //创建时间
                ts.setCreateTime(new Date());
                //创建者
                ts.setCreateUser(stm.getUpdateUser());
                tsList.add(ts);*/
            }
            //2017/08/14 王冉 追加↓↓↓　dazhong@YMSC
            // 查询刀具参数信息
            Synthesisparameters entity = new Synthesisparameters();
            entity.setSynthesisParametersCode(stm.getSynthesisParametersCode());
            entity.setDelFlag("0");
            List<Synthesisparameters> list = (List<Synthesisparameters>) synthesisparametersDao.searchByLikeList(entity);
            // 刀具为一体刀的场合
            if("4".equals(list.get(0).getCreateType())){
                Tool tool = new Tool();
                tool.setToolID(toolList.get(0).getToolID());
                tool.setDelFlag("0");
                // 根据合成刀上的材料号查询刀具参数信息
                List<Tool> toolInfo = (List<Tool>) toolDao.searchByList ( tool );

                // 根据一体刀编号查询流转统计表数据
                TooltransferTotal ttEntity = new TooltransferTotal();
                ttEntity.setToolCodeWhere(toolInfo.get(0).getToolCode());
                List<TooltransferTotal> tst = vsynthesisconditionDao
                        .searchByList3(ttEntity);
                // 卸下后直接安上减待修模
                TooltransferTotal updateEntity = new TooltransferTotal();
                if(IConstant.C01S013.equals(toolList.get(0).getBusinessFlowLnkID())){
                    updateEntity.setProductionLineSum(tst.get(0).getProductionLineSum().add(BigDecimal.ONE));
                    // 刀具参数为厂外修磨时 减厂外待修磨数
                    if("1".equals(toolInfo.get(0).getToolGrinding())){

                        updateEntity.setToolCode(toolInfo.get(0).getToolCode());
                        updateEntity.setStayExternalGrindingSum(tst.get(0).getStayExternalGrindingSum().subtract(BigDecimal.ONE));


                        // 刀具参数为厂内修磨或厂外涂层时 减厂内待修磨数
                    }else{

                        updateEntity.setToolCode(toolInfo.get(0).getToolCode());
                        updateEntity.setGrindingFactorySnum(tst.get(0).getGrindingFactorySnum().subtract(BigDecimal.ONE));
                    }
                    vsynthesisconditionDao.updateTooltransferTotal(updateEntity);
                    //修磨或回厂后安上加生产线
                }else if(IConstant.C01S017.equals(toolList.get(0).getBusinessFlowLnkID()) ||
                        IConstant.C01S018.equals(toolList.get(0).getBusinessFlowLnkID())){


                    updateEntity.setToolCode(toolInfo.get(0).getToolCode());
                    updateEntity.setProductionLineSum(tst.get(0).getProductionLineSum().add(BigDecimal.ONE));

                    vsynthesisconditionDao.updateTooltransferTotal(updateEntity);
                }

            }
            //2017/08/14 王冉 追加↑↑↑　dazhong@YMSC

            if (twls.size () > 0) {
                toolwholelifecycleDao.insertBatchs ( twls );
            }
            //批量插入单品刀具加工信息
            //            if (tsList.size() > 0) {
            //                //      toolsmachiningDao.insertBacths(tsList);
            //            }
            //修改合成刀具为安上状态
            st = new Synthesisknife ();
            //合成刀具编码(系统唯一)
            st.setSynthesisParametersCodeWhere ( stm.getSynthesisParametersCode () );
            //合成刀具编号(例如：001、002、003)
            st.setSynthesisParametersNumberWhere ( stm.getSynthesisParametersNumber () );
            st.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
            //使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上)(该状态绑定到带标签的数据上)
            st.setLoadState ( IConstant.DEL_FLAG_0 );
            //是否安装(0安装1卸下9其他)
            st.setInstallFlag ( IConstant.INSTALL_FLAG_0 );
            st.setBusinessFlowLnkID ( IConstant.C01S011 );
            st.setUpdateTime ( new Date () );//更新时间
            st.setUpdateUser ( stm.getUpdateUser () );//更新者
            synthesisknifeDao.updateNonQuery ( st );
            //提交合成刀安上设备信息
            synthesistoolsmachiningDao.insert ( stm );

            Tooltransfer tooltransfer = new Tooltransfer ();
            tooltransfer.setRfidContainerIDWhere ( rfidcon );
            tooltransfer.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
            tooltransfer.setBusinessFlowLnkID ( IConstant.C01S011 );
            tooltransfer.setToolThisState ( IConstant.STRING_3 );//车间
            //2017/08/14 王冉 追加↓↓↓　dazhong@YMSC
            tooltransfer.setToolState("9");
            //2017/08/14 王冉 追加↑↑↑　dazhong@YMSC
            tooltransfer.setUpdateTime ( new Date () );
            tooltransfer.setUpdateUser ( stm.getUpdateUser () );
            tooltransferDao.updateNonQuery ( tooltransfer );
            reIntVal = 1;
        } catch (Exception e) {
            reIntVal = 0;
        }
        StringBuilder sb = new StringBuilder ();
        sb.append ( "\n ----------------------BEGEN----------------------------" );
        sb.append ( "\n 设备安上" );
        sb.append ( "\n DateTime："+ DateFormatUtil.dateToString ( new Date (  ),1 ) );
        Assemblyline al = new Assemblyline ();
        al.setAssemblyLineID ( stm.getAssemblyLineID () );
        sb.append ( "\n AssemblyLineName："+((Assemblyline)assemblylineDao.searchByPrimaryKey ( al )).getAssemblyLineName ());
        Equipment equipment = new Equipment ();
        equipment.setEquipmentID ( stm.getEquipmentID () );
        sb.append ( "\n EquipmentCode：" +((Equipment)equipmentDao.searchByPrimaryKey (equipment )).getEquipmentCode ());
        sb.append ( "\n SynthesisParametersCode：" +stm .getSynthesisParametersCode ());
        sb.append ( "\n SynthesisParametersNumber："+stm.getSynthesisParametersNumber () );
        sb.append ( "\n ----------------------END----------------------------" );
        logger.info (sb.toString ());
        return reIntVal;
    }

    /**
     * 批量增加合成刀加工和单品刀加工列表
     *
     * @param rfidConner
     * @return
     * @throws SQLException
     */

    public List<Tooltransfer> getAllTool(String rfidConner, String customerID) throws SQLException {
        Tooltransfer entity = new Tooltransfer ();
        entity.setRfidContainerID ( rfidConner );
        List<Tooltransfer> list = (List<Tooltransfer>) tooltransferDao.searchByList ( entity );
        for (Tooltransfer tooltransfer : list) {
            Toolwholelifecycle toolwholelifecycle = new Toolwholelifecycle ();
            toolwholelifecycle.setBusinessFlowLnkID ( IConstant.C01S011 );
            toolwholelifecycle.setHandSetID ( "-" );
            toolwholelifecycle.setToolCode ( tooltransfer.getToolID () );
            toolwholelifecycle.setToolID ( tooltransfer.getToolID () );
            toolwholelifecycle.setPartsID ( "" );
            toolwholelifecycle.setKnifeInventoryCode ( tooltransfer.getKnifeInventoryCode () );
            toolwholelifecycle.setDelFlag ( IConstant.DEL_FLAG_0 );
            toolwholelifecycle.setCreateTime ( new Date () );
            toolwholelifecycle.setUpdateTime ( new Date () );
            toolwholelifecycle.setCreateUser ( customerID );
            toolwholelifecycle.setUpdateUser ( customerID );
            toolwholelifecycle.setVersion ( BigDecimal.ZERO );
            toolwholelifecycle.setToolWholeLifecycleID ( UUIDgen.getId () );
            toolwholelifecycleDao.insert ( toolwholelifecycle );
        }
        return list;
    }

}
