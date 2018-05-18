package com.icomp.common.service.impl.icomp.v01c01.s013;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s013.ICOMPV01C01S013Service;
import com.icomp.common.utils.DateFormatUtil;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.common.utils.UUIDgen;
import com.icomp.dao.*;
import com.icomp.entity.base.*;
import org.apache.log4j.Logger;

import java.lang.System;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 设备卸下-Service实现类
 *
 * @ClassName: ICOMPV01C01S013ServiceImpl
 * @author Taoyy
 * @date 2014-10-11 下午02:24:32
 */

/**
 * @author Taoyy
 * @ClassName: ICOMPV01C01S013ServiceImpl
 * @date 2014-11-18 上午10:47:46
 */
@SuppressWarnings("unchecked")
public class ICOMPV01C01S013ServiceImpl extends BaseService implements ICOMPV01C01S013Service {

    private static final String ORDER_STRING = "createTime DESC";
    /**
     * 取得设备卸下信息Dao
     */
    private VgetequipmentunloadingmsgDao vgetequipmentunloadingmsgDao;

    private RfidcontainerDao rfidcontainerDao;
    private PartsDao partsDao;
    private VgetwheelsmachiningmsgDao vgetwheelsmachiningmsgDao;

    public void setVgetwheelsmachiningmsgDao(VgetwheelsmachiningmsgDao vgetwheelsmachiningmsgDao) {
        this.vgetwheelsmachiningmsgDao = vgetwheelsmachiningmsgDao;
    }

    public void setPartsDao(PartsDao partsDao) {
        this.partsDao = partsDao;
    }

    public void setVgetequipmentunloadingmsgDao(VgetequipmentunloadingmsgDao vgetequipmentunloadingmsgDao) {
        this.vgetequipmentunloadingmsgDao = vgetequipmentunloadingmsgDao;
    }

    private VgetdownsynthistoolsmsgDao vgetdownsynthistoolsmsgDao;

    public void setVgetdownsynthistoolsmsgDao(VgetdownsynthistoolsmsgDao vgetdownsynthistoolsmsgDao) {
        this.vgetdownsynthistoolsmsgDao = vgetdownsynthistoolsmsgDao;
    }

    /**
     * 合成刀具加工Dao
     */
    private SynthesistoolsmachiningDao synthesistoolsmachiningDao;

    public void setSynthesistoolsmachiningDao(SynthesistoolsmachiningDao synthesistoolsmachiningDao) {
        this.synthesistoolsmachiningDao = synthesistoolsmachiningDao;
    }

    // 合成刀库Dao
    private SynthesisknifeDao synthesisknifeDao;

    public void setSynthesisknifeDao(SynthesisknifeDao synthesisknifeDao) {
        this.synthesisknifeDao = synthesisknifeDao;
    }

    // 加工履历
    private MachiningexperienceDao machiningexperienceDao;

    public void setMachiningexperienceDao(MachiningexperienceDao machiningexperienceDao) {
        this.machiningexperienceDao = machiningexperienceDao;
    }

    // 流转刀具
    private TooltransferDao tooltransferDao;
    // 取得当前刀具的最后执行业务流程
    private BusinessflowlnkDao businessflowlnkDao;
    // 取得业务流程ID
    private BusinessDao businessDao;
    // 刀具参数
    private ToolDao toolDao;
    private ToolsmachiningDao toolsmachiningDao;
    private SynthesisExchangeDao synthesisExchangeDao;

    public void setSynthesisExchangeDao(SynthesisExchangeDao synthesisExchangeDao) {
        this.synthesisExchangeDao = synthesisExchangeDao;
    }

    public void setToolsmachiningDao(ToolsmachiningDao toolsmachiningDao) {
        this.toolsmachiningDao = toolsmachiningDao;
    }

    // 生命周期
    private ToolwholelifecycleDao toolwholelifecycleDao;
    // 刀具流转履历
    private TooltransferhistoryDao tooltransferhistoryDao;
    // 合成刀具流转履历
    private SynthesisexperienceDao synthesisexperienceDao;

    private OplinkDao oplinkDao;

    public void setOplinkDao(OplinkDao oplinkDao) {
        this.oplinkDao = oplinkDao;
    }

    private EquipmentDao equipmentDao;

    public void setEquipmentDao(EquipmentDao equipmentDao) {
        this.equipmentDao = equipmentDao;
    }

    private VgetwheelinfoDao vgetwheelinfoDao;

    public void setVgetwheelinfoDao(VgetwheelinfoDao vgetwheelinfoDao) {
        this.vgetwheelinfoDao = vgetwheelinfoDao;
    }

    // 合成刀具参数Dao
    private SynthesisparametersDao synthesisparametersDao;

    public void setSynthesisparametersDao(SynthesisparametersDao synthesisparametersDao) {
        this.synthesisparametersDao = synthesisparametersDao;
    }

    //2017/08/14 王冉 追加↓↓↓　dazhong@YMSC
    private VsynthesisconditionDao vsynthesisconditionDao;

    public void setVsynthesisconditionDao(VsynthesisconditionDao vsynthesisconditionDao) {
        this.vsynthesisconditionDao = vsynthesisconditionDao;
    }
    private SynthesiscutterlocationDao synthesiscutterlocationDao;

    public void setSynthesiscutterlocationDao(SynthesiscutterlocationDao synthesiscutterlocationDao) {
        this.synthesiscutterlocationDao = synthesiscutterlocationDao;
    }

    private RedemptionappliedDao redemptionappliedDao;

    public void setRedemptionappliedDao(RedemptionappliedDao redemptionappliedDao) {
        this.redemptionappliedDao = redemptionappliedDao;
    }

    private ScrapDao scrapDao;


    public void setScrapDao(ScrapDao scrapDao) {
        this.scrapDao = scrapDao;
    }
    //2017/08/14 王冉 追加↑↑↑　dazhong@YMSC

    /**
     * 取得设备卸下信息 getSynthesisToolInfo
     *
     * @param entity
     * @return
     */

    @Override
    public List<Vgetequipmentunloadingmsg> getSynthesisToolInfo(Vgetequipmentunloadingmsg entity) {
        List<Vgetequipmentunloadingmsg> list = new ArrayList<Vgetequipmentunloadingmsg>();
        try {
            Rfidcontainer rfidcontainer = new Rfidcontainer();
            rfidcontainer.setRfidCode(entity.getRfid());
            rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
            List<Rfidcontainer> rfidList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);

            Synthesisknife synthesisknife = new Synthesisknife();
            synthesisknife.setrFID(rfidList.get(0).getRfidContainerID());
            synthesisknife.setDelFlag(IConstant.DEL_FLAG_0);
            List<Synthesisknife> listSynthesisknife = (List<Synthesisknife>) synthesisknifeDao.searchByList(synthesisknife);

            entity.setEquipmentID(listSynthesisknife.get(0).getEquipmentID());
            // 取得待换领刀具信息列表
            list = (List<Vgetequipmentunloadingmsg>) vgetequipmentunloadingmsgDao.searchByList(entity);
            if (list == null || list.size() <= 0) {
                // 设备上没有安装该合成刀具!
                Vgetequipmentunloadingmsg vgetequipmentunloadingmsg = new Vgetequipmentunloadingmsg();
                vgetequipmentunloadingmsg.setMessageCode(IConstant.WMSG0303_1);
                vgetequipmentunloadingmsg.setRetErrFlag(true);
                list.add(vgetequipmentunloadingmsg);
            }
        } catch (SQLException e) {
            // 数据库操作异常，查询失败!
            list = new ArrayList<Vgetequipmentunloadingmsg>();
            Vgetequipmentunloadingmsg vgetequipmentunloadingmsg = new Vgetequipmentunloadingmsg();
            vgetequipmentunloadingmsg.setMessageCode(IConstant.EMSG0004);
            vgetequipmentunloadingmsg.setRetErrFlag(true);
            vgetequipmentunloadingmsg.setExceMessage(e.getMessage());
            list.add(vgetequipmentunloadingmsg);
        }
        return list;
    }

    /**
     * 合成刀具卸下设备 saveToolRecovery
     *
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public int saveToolRecovery(Map<String, Object> map) throws Exception {
        int reCount = 0;
        String rfidString = map.get("rfidString").toString();
        String userId = map.get("userId").toString();
        Synthesistoolsmachining entity = (Synthesistoolsmachining) map.get("entity");
        String handId = map.get("handId").toString();
        List<String> rfidList = new ArrayList<String>();
        rfidList.add(rfidString);

        // 载体Id
        Rfidcontainer rf = new Rfidcontainer();
        rf.setRfidCode(rfidString);
        rf.setDelFlag(IConstant.DEL_FLAG_0);
        rf = (Rfidcontainer) rfidcontainerDao.searchByList(rf).get(0);
        String rfidContainerID = rf.getRfidContainerID();

        // 取得要更新合成刀库list
        Synthesisknife sk = new Synthesisknife();
        Synthesisknife sk1 = new Synthesisknife();
        sk.setrFID(rfidContainerID);
        sk.setDelFlag(IConstant.DEL_FLAG_0);
        sk = (Synthesisknife) synthesisknifeDao.searchByList(sk).get(0);
        sk1.setSynthesisParametersCode(sk.getSynthesisParametersCode());
        sk1.setSynthesisParametersNumber(sk.getSynthesisParametersNumber());
        sk1.setDelFlag(IConstant.DEL_FLAG_0);
        List<Synthesisknife> list = (List<Synthesisknife>) synthesisknifeDao.searchByList(sk1);

        if (list == null || list.size() <= 0) {
            System.out.println(IConstant.WMSG0135);
        } else {
            // 取得流转刀具信息
            List<Tooltransfer> tooltransferList = (List<Tooltransfer>) tooltransferDao.searchHalfByList(rfidList);
            Tooltransfer tooltransfer = new Tooltransfer();
            // 取得当前刀具的最后执行业务流程
            Businessflowlnk businessflowlnk = new Businessflowlnk();
            tooltransfer = tooltransferList.get(0);
            businessflowlnk.setBusinessFlowLnkID(tooltransfer.getBusinessFlowLnkID());
            // Businessflowlnk flowLink = (Businessflowlnk)
            // businessflowlnkDao.searchByPrimaryKey(businessflowlnk);
            // 取得业务流程下一个ID
            Business business = new Business();
            business.setBusinessCode("C01S013");
            List<Business> businessList = (List<Business>) businessDao.searchByList(business);
            business = businessList.get(0);
            Businessflowlnk businessflowlnks = new Businessflowlnk();
            businessflowlnks.setBusinessID(business.getBusinessID());
            List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);

            businessflowlnk = list1.get(0);
            // 下一个流程ID
            String nextString = businessflowlnk.getBusinessFlowLnkID();

            Toolwholelifecycle toolwholelifecycle = null;
            List<Toolwholelifecycle> tlcList = new ArrayList<Toolwholelifecycle>();
            Tooltransferhistory tth = null;
            List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory>();
            List<String> knifnCodeList = new ArrayList<String>();

            // 刀具流转信息
            for (Tooltransfer tt : tooltransferList) {
                // 记录刀具生命周期数据
                toolwholelifecycle = new Toolwholelifecycle();
                toolwholelifecycle.setBusinessFlowLnkID(nextString);
                toolwholelifecycle.setHandSetID(handId);
                // 取得刀具信息
                toolwholelifecycle.setKnifeInventoryCode(tt.getKnifeInventoryCode());
                if (entity.getProcessAmount() != null) {
                    toolwholelifecycle.setProcessAmount(entity.getProcessAmount().toString());
                }
                toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
                toolwholelifecycle.setCreateTime(new Date());
                toolwholelifecycle.setUpdateTime(new Date());
                toolwholelifecycle.setCreateUser(userId);
                toolwholelifecycle.setUpdateUser(userId);
                toolwholelifecycle.setVersion(BigDecimal.ZERO);
                toolwholelifecycle.setToolWholeLifecycleID(UUIDgen.getId());
                tlcList.add(toolwholelifecycle);
                knifnCodeList.add(tt.getKnifeInventoryCode());

                // 添加刀具流转履历
                tth = new Tooltransferhistory();
                tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(IConstant.TOOL_TRANSFER_HISTORY, IConstant.TOOL_TRANSFER_HISTORY_ID, userId)); // id
                tth.setRfidContainerID(tt.getRfidContainerID()); // RFID载体ID
                tth.setKnifeInventoryCode(tt.getKnifeInventoryCode()); // 刀具入库编码
                tth.setToolID(tt.getToolID());// 刀具ID
                tth.setToolProcuredID(tt.getProcuredBatch()); // 采购ID
                tth.setBusinessFlowLnkID(nextString);// 最后执行业务流程(刀具安上)
                tth.setToolDurable(tt.getToolDurable());// 耐用度
                tth.setToolSharpennum(tt.getToolDurable());// 可使用(刃磨)次数
                tth.setToolSharpenCriterion(tt.getToolSharpenCriterion()); // 复磨标准
                tth.setToolLength(tt.getToolLength());// 刀具长度
                tth.setToolSharpenLength(tt.getToolSharpenLength());// 可刃磨长度
                tth.setUsageCounter(tt.getUsageCounter()); // 已使用(刃磨)次数
                tth.setToolGrindingLength(tt.getToolGrindingLength());// 刀具已刃磨长度
                tth.setInstallationState(IConstant.INSTALLATION_STATE_1);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
                tth.setStockState(IConstant.STOCK_STATE_4);
                tth.setDelFlag(IConstant.DEL_FLAG_0); // 删除区分
                tth.setCreateTime(new Date());// 创建时间
                tth.setCreateUser(userId); // 创建者
                tth.setVersion(BigDecimal.ZERO);// 版本号
                tthList.add(tth);
            }

            // 更新刀具流转
            tooltransfer = new Tooltransfer();
            tooltransfer.setRfidContainerIDWhere(rfidContainerID);// 取得载体ID
            tooltransfer.setDelFlagWhere(IConstant.DEL_FLAG_0);
            tooltransfer.setBusinessFlowLnkID(nextString);
            tooltransfer.setStockState(IConstant.STOCK_STATE_4);
            tooltransfer.setUpdateTime(new Date());
            tooltransfer.setUpdateUser(userId);
            tooltransfer.setVersion(tooltransferList.get(0).getVersion().add(BigDecimal.ONE));
            reCount += tooltransferDao.updateNonQuery(tooltransfer);

            // 合成刀具加工更新数据
            // 按时间倒序,每加工一次增加一条数据(在设备安上是增加)

            Synthesistoolsmachining stm1 = new Synthesistoolsmachining();
            // stm1.setSynthesisParametersCode(entity.getSynthesisParametersCode());
            // stm1.setSynthesisParametersNumber(entity.getSynthesisParametersNumber());
            // stm1.setSynthesisCutterNumber(BigDecimal.ZERO);
            stm1.setOrderString(ORDER_STRING);
            stm1.setDelFlag(IConstant.DEL_FLAG_0);
            // 按任意查询
            List<Synthesistoolsmachining> stmList = (List<Synthesistoolsmachining>) synthesistoolsmachiningDao.searchByList(stm1);
            Synthesistoolsmachining stm = new Synthesistoolsmachining();
            stm1 = stmList.get(0);
            String synthesisNumber = stm1.getSynthesisNumber();
            // 条件
            // stm.setSynthesisParametersCodeWhere(entity.getSynthesisParametersCode());
            // stm.setSynthesisParametersNumberWhere(entity.getSynthesisParametersNumber());
            stm.setSynthesisNumberWhere(synthesisNumber);
            stm.setDelFlagWhere(IConstant.DEL_FLAG_0);
            // 参数
            stm.setOuterTime(new Date());// 卸下时间
            stm.setOuterUser(userId);// 卸下人
            stm.setRemoveReason(entity.getRemoveReason());// 卸下原因(0正常卸下1打刀2不合格9其他)(可维护)
            stm.setProcessAmount(entity.getProcessAmount());// 加工数量
            // stm.setAssemblyLineIDWhere(entity.getAssemblyLineIDWhere());//
            // 零部件种类
            stm.setUpdateTime(new Date());// 更新时间
            stm.setUpdateUser(userId);// 更新者
            stm.setVersion(new BigDecimal((stm1.getVersion().intValue() + 1)));// 版本号
            reCount += synthesistoolsmachiningDao.updateNonQuery(stm);

            // 操作合成刀库
            Synthesisexperience se = null;
            List<Synthesisexperience> seList = new ArrayList<Synthesisexperience>();
            Machiningexperience me = null;
            List<Machiningexperience> meList = new ArrayList<Machiningexperience>();
            for (Synthesisknife sk2 : list) {
                // 更新合成刀库
                sk = new Synthesisknife();
                sk.setKnifeInventoryCodeWhere(sk2.getKnifeInventoryCode());// 刀具入库编码
                sk.setDelFlagWhere(IConstant.DEL_FLAG_0);// 删除状态
                sk.setLoadState(IConstant.LOADSTATE_1);// 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回)(该状态绑定到带标签的数据上)
                sk.setBusinessFlowLnkID(nextString);
                sk.setUpdateTime(new Date());// 更新时间
                sk.setUpdateUser(userId);// 更新者
                sk.setVersion(sk2.getVersion().add(BigDecimal.ONE));
                reCount += synthesisknifeDao.updateNonQuery(sk);

                // 添加合成刀流转履历
                se = new Synthesisexperience();
                se.setSynthesisParametersCode(sk2.getSynthesisParametersCode());// 合成刀具编码
                se.setSynthesisCutterNumber(sk2.getSynthesisCutterNumber());// 位置号
                se.setSynthesisParametersNumber(sk2.getSynthesisParametersNumber());// 001.002.003
                se.setBusinessFlowLnkID(nextString);// 最后执行业务流程(刀具安上辅具)
                se.setOperationTime(new Date()); // 操作时间
                se.setArrivalUser(sk2.getUpdateUser()); // 转出人
                se.setRecipientUser(userId); // 接收人
                se.setTransitionBecause(IConstant.TRANSITION_BECAUSE_3);// 交接原因(0送入车间1旧刀回收2不合格送回3对刀)
                se.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分(0有效1删除)
                se.setCreateTime(new Date());// 创建时间
                se.setCreateUser(userId);// 创建者
                se.setVersion(BigDecimal.ZERO);// 版本号
                seList.add(se);

                // 加工履历）
                me = new Machiningexperience();
                me.setSynthesisParametersCode(sk2.getSynthesisParametersCode());// 合成刀具编码
                me.setSynthesisParametersNumber(sk2.getSynthesisParametersNumber());// 合成刀具编号
                me.setKnifeInventoryCode(sk2.getKnifeInventoryCode());
                me.setSynthesisNumber(synthesisNumber);// 加工编号
                me.setSynthesisCutterNumber(sk2.getSynthesisCutterNumber());// 位置号
                me.setToolWastage(BigDecimal.ZERO);// 刀具损耗
                me.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
                me.setUpdateTime(new Date());// 更新时间
                me.setUpdateUser(userId);// 更新者
                me.setCreateTime(new Date());// 创建时间
                me.setCreateUser(userId);// 创建者
                me.setVersion(BigDecimal.ZERO);// 版本号
                meList.add(me);
            }

            // 加工履历（在刀具安上设备上需要记录当前合成刀与刀具的绑定关系）
            if (meList.size() > 0) {
                machiningexperienceDao.insertBatchs(meList);
            }
            if (tlcList.size() > 0) {
                // 批量添加【生命周期】
                toolwholelifecycleDao.insertBatchs(tlcList);
            }
            if (seList.size() > 0) {
                // 批量添加【合成刀库履历】
                synthesisexperienceDao.batchInsert(seList);

            }
            if (tthList.size() > 0) {
                // 批量添加【刀具流转履历】
                tooltransferhistoryDao.insertBatchDefined(tthList);

            }
        }
        return reCount;
    }

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
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

    public void setSynthesisexperienceDao(SynthesisexperienceDao synthesisexperienceDao) {
        this.synthesisexperienceDao = synthesisexperienceDao;
    }

    private AssemblylineDao assemblylineDao;

    public void setAssemblylineDao(AssemblylineDao assemblylineDao) {
        this.assemblylineDao = assemblylineDao;
    }

    private static final Logger logger = Logger.getLogger(ICOMPV01C01S013ServiceImpl.class);

    @Override
    public Vgetdownsynthistoolsmsg getdownsynthistoolsmsg(Vgetdownsynthistoolsmsg param) throws SQLException {
        Vgetdownsynthistoolsmsg reEntity = new Vgetdownsynthistoolsmsg();
        // 根据合成刀具编码和编号查询信息
        List<Vgetdownsynthistoolsmsg> reList = (List<Vgetdownsynthistoolsmsg>) vgetdownsynthistoolsmsgDao.searchByList(param);
        if (reList == null || reList.size() < 1) {
            reEntity.setRetErrFlag(true);
        } else {
            reEntity = reList.get(0);
            Oplink op = new Oplink();
            //工序ID
            op.setProcessID(reEntity.getProcessID());
            //设备ID
            op.setEquipmentID(reEntity.getEquipmentID());
            //流水线ID
            op.setAssemblyLineID(reEntity.getAssemblyLineID());
            //合成刀具参数ID
            Synthesisparameters entity = new Synthesisparameters();
            entity.setSynthesisParametersCode(reEntity.getSynthesisParametersCode());
            try {
                op.setSynthesisParametersID(getSynthesisId(entity).getSynthesisParametersID());
            } catch (Exception e) {
                op.setSynthesisParametersID("");
            }
            //轴ID
            op.setAxleID(reEntity.getAxleID());
            //reEntity.setOplinks((List<Oplink>) oplinkDao.searchByList(op));
        }
        return reEntity;
    }

    @Override
    public List<Parts> getPartsList(Parts p) throws Exception {
        // 根据ID查询零部件列表
        return partsDao.searchListByName(p);
    }

    //2017/08/14 王冉 追加↓↓↓　dazhong@YMSC
    public List<Oplink> getOplinkList(Oplink op) throws Exception {
        // 根据ID查询零部件列表
        return oplinkDao.searchOplinkList(op);
    }
    //2017/08/14 王冉 追加↑↑↑　dazhong@YMSC

    @Override
    public Oplink getOplinkInfo(Oplink entity) throws Exception {
        Oplink reVal = new Oplink();
        //    return oplinkDao.getOplinkInfo(entity);
        List<Oplink> reVals = (List<Oplink>) oplinkDao.searchByList(entity);
        if (reVals != null && reVals.size() > 0) {
            reVal = reVals.get(0);
        }
        return reVal;
    }

    //查询合成刀具编号
    @Override
    public List<Synthesisknife> getSynParameNumber(Synthesisknife sk) throws Exception {

        return (List<Synthesisknife>) synthesisknifeDao.searchByList(sk);
    }

    @Override
    public Oplink getoplink(Oplink o) throws Exception {
        Oplink reVal = new Oplink();
        //    return oplinkDao.getOplinkInfo(entity);
        List<Oplink> reVals = (List<Oplink>) oplinkDao.searchByList(o);
        if (reVals != null && reVals.size() > 0) {
            reVal = reVals.get(0);
        }
        return reVal;
    }

    /**
     * 批量增加合成刀加工和单品刀加工列表
     *
     * @param stm
     * @return
     * @throws SQLException
     */
    @Override
    public int submitSyntheticUnloadEquipmentInfo(Synthesistoolsmachining stm) throws Exception {
        int reIntVal = 0;
        //查询合成加工的数据
        Synthesistoolsmachining entity = new Synthesistoolsmachining();
        Synthesistoolsmachining param = new Synthesistoolsmachining();
        // 合成刀具参数编码
        entity.setSynthesisParametersCode(stm.getSynthesisParametersCodeWhere());
        // 合成刀具参数编号
        entity.setSynthesisParametersNumber(stm.getSynthesisParametersNumberWhere());
        // 工序ID
        entity.setProcessID(stm.getProcessIDWhere());
        // 设备ID
        entity.setEquipmentID(stm.getEquipmentIDWhere());
        // 流水线ID
        entity.setAssemblyLineID(stm.getAssemblyLineIDWhere());
        entity.setAxleID(stm.getAxleID());
        entity.setRfidContainerID(stm.getRfidContainerID());
        entity.setDelFlag(IConstant.DEL_FLAG_0);
        entity.setOrderString("SynthesisNumber DESC");
        List<Toolsmachining> tsList = new ArrayList<Toolsmachining>();
        Toolsmachining ts = null;
        List<Synthesistoolsmachining> reVal = (List<Synthesistoolsmachining>) synthesistoolsmachiningDao.searchByList(entity);
        if (reVal != null && reVal.size() > 0) {
            param = reVal.get(0);
            //查询合成刀具上单品刀具的信息
            Tooltransfer tt = new Tooltransfer();
            /*Rfidcontainer rf = new Rfidcontainer();
            rf.setRfidCode(stm.getExpandSpace1());
            // 标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
            rf.setQueryType(IConstant.BAND_TYPE_2);
            rf.setDelFlag(IConstant.DEL_FLAG_0);*/
            tt.setRfidContainerID(stm.getRfidContainerID());
            tt.setDelFlag(IConstant.DEL_FLAG_0);
            List<Tooltransfer> toolList = tooltransferDao.getSynSingesToolList(tt);

            //2017/08/14 王冉 追加↓↓↓　dazhong@YMSC
            // 查询刀具参数信息
            Synthesisparameters sp = new Synthesisparameters();
            sp.setSynthesisParametersCode(stm.getSynthesisParametersCodeWhere());
            sp.setDelFlag("0");
            List<Synthesisparameters> list = (List<Synthesisparameters>) synthesisparametersDao.searchByLikeList(sp);
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
                // 卸下时加待修磨数量
                TooltransferTotal updateEntity = new TooltransferTotal();

                // 刀具参数为厂外修磨时 加厂外待修磨数
                if("1".equals(toolInfo.get(0).getToolGrinding())){


                    updateEntity.setToolCode(toolInfo.get(0).getToolCode());
                    updateEntity.setStayExternalGrindingSum(tst.get(0).getStayExternalGrindingSum().add(BigDecimal.ONE));
                    updateEntity.setProductionLineSum(tst.get(0).getProductionLineSum().subtract(BigDecimal.ONE));

                    // 刀具参数为厂内修磨或厂外涂层时 减厂内待修磨数
                }else{


                    updateEntity.setToolCode(toolInfo.get(0).getToolCode());
                    updateEntity.setGrindingFactorySnum(tst.get(0).getGrindingFactorySnum().add(BigDecimal.ONE));
                    updateEntity.setProductionLineSum(tst.get(0).getProductionLineSum().subtract(BigDecimal.ONE));
                }
                try {
                    vsynthesisconditionDao.updateTooltransferTotal(updateEntity);
                }catch (Exception e){
                    e.printStackTrace();

                }


            }
            //2017/08/14 王冉 追加↑↑↑　dazhong@YMSC

            Toolwholelifecycle toolwholelifecycle = null;
            List<Toolwholelifecycle> tlcList = new ArrayList<Toolwholelifecycle>();
            SynthesisExchange synthesisExchange = new SynthesisExchange();
            synthesisExchange.setRfidWhere(stm.getRfidContainerID());
            List<SynthesisExchange> synthesisExchanges = (List<SynthesisExchange>) synthesisExchangeDao.searchByList(synthesisExchange);

            int o = 0;
            for (SynthesisExchange exchange : synthesisExchanges) {
                ts = new Toolsmachining();
                //加工编号(年月日时分秒 14位字符串)
                Date date = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.SECOND, +o);
                o++;
                date = c.getTime();
                SimpleDateFormat dateformat = new SimpleDateFormat(
                        "yyyyMMddHHmmss");
                // 加工编号(年月日时分秒 14位字符串)
                ts.setSynthesisNumber(dateformat.format(date)); // 刃磨时间

                //刀具入库编码
                ts.setKnifeInventoryCode("");
                //刀具ID
                ts.setToolID(exchange.getToolID());
                //流水线ID
                ts.setAssemblyLineID(param.getAssemblyLineID());
                //设备ID
                ts.setEquipmentID(param.getEquipmentID());
                //工序ID
                ts.setProcessID(param.getProcessID());
                //零部件ID
                ts.setPartsID(stm.getExpandSpace3());
                //轴ID
                ts.setAxleID(param.getAxleID());
                //卸下时间
                ts.setOuterTime(new Date());
                //操作人
                ts.setOuterUser(stm.getUpdateUser());
                //卸下原因(0正常卸下1打刀2不合格9其他)(可维护)
                ts.setRemoveReason(stm.getRemoveReason());
                //加工数量
                ts.setProcessAmount(stm.getProcessAmount());
                //卸下确认人(不合格卸下时需要进行确认)
                ts.setRemoveUser(stm.getUpdateUser());
                //删除区分(0有效1删除)
                ts.setDelFlag(param.getDelFlag());
                //更新时间
                ts.setUpdateTime(new Date());
                //更新者
                ts.setUpdateUser(stm.getUpdateUser());
                //创建时间
                ts.setCreateTime(new Date());
                //创建者
                ts.setCreateUser(stm.getUpdateUser());
                tsList.add(ts);
            }
            for (Tooltransfer ttf : toolList) {
                for(int i = 0;i<ttf.getToolDurable().intValue();i++){
                    ts = new Toolsmachining();
                    //加工编号(年月日时分秒 14位字符串)
                    Date date = new Date();
                    Calendar c = Calendar.getInstance();
                    c.setTime(date);
                    c.add(Calendar.SECOND, +i);
                    date = c.getTime();
                    SimpleDateFormat dateformat = new SimpleDateFormat(
                            "yyyyMMddHHmmss");
                    // 加工编号(年月日时分秒 14位字符串)
                    ts.setSynthesisNumber(dateformat.format(date)); // 刃磨时间

                    //刀具入库编码
                    ts.setKnifeInventoryCode(ttf.getKnifeInventoryCode());
                    //刀具ID
                    ts.setToolID(ttf.getToolID());
                    //流水线ID
                    ts.setAssemblyLineID(param.getAssemblyLineID());
                    //设备ID
                    ts.setEquipmentID(param.getEquipmentID());
                    //工序ID
                    ts.setProcessID(param.getProcessID());
                    //零部件ID
                    ts.setPartsID(stm.getExpandSpace3());
                    //轴ID
                    ts.setAxleID(param.getAxleID());
                    //卸下时间
                    ts.setOuterTime(new Date());
                    //操作人
                    ts.setOuterUser(stm.getUpdateUser());
                    //卸下原因(0正常卸下1打刀2不合格9其他)(可维护)
                    ts.setRemoveReason(stm.getRemoveReason());
                    //加工数量
                    ts.setProcessAmount(stm.getProcessAmount());
                    //卸下确认人(不合格卸下时需要进行确认)
                    ts.setRemoveUser(stm.getUpdateUser());
                    //删除区分(0有效1删除)
                    ts.setDelFlag(param.getDelFlag());
                    //更新时间
                    ts.setUpdateTime(new Date());
                    //更新者
                    ts.setUpdateUser(stm.getUpdateUser());
                    //创建时间
                    ts.setCreateTime(new Date());
                    //创建者
                    ts.setCreateUser(stm.getUpdateUser());
//                    tsList.add(ts);
                }
                stm.setSynthesisNumberWhere(param.getSynthesisNumber());

                // 记录刀具生命周期数据
                toolwholelifecycle = new Toolwholelifecycle();
                toolwholelifecycle.setBusinessFlowLnkID(IConstant.C01S013);
                toolwholelifecycle.setHandSetID(stm.getExpandSpace4());
                toolwholelifecycle.setToolID(ts.getToolID());
                // 取得刀具信息
                toolwholelifecycle.setKnifeInventoryCode(ts.getKnifeInventoryCode());
                // 合成刀具加工表的加工数量
                BigDecimal stmProcessCount = BigDecimal.ZERO;
                // 流转表的加工数量
                BigDecimal ttProcessCount = BigDecimal.ZERO;
                // 加工数量为空，自动转0
                if (stm.getProcessAmount() != null) {
                    stmProcessCount = stm.getProcessAmount();
                }
                if (ttf.getProcessAmount() != null) {
                    ttProcessCount = ttf.getProcessAmount();
                }

                toolwholelifecycle.setProcessAmount((stmProcessCount.add(ttProcessCount)).toString());
                toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
                toolwholelifecycle.setCreateTime(new Date());
                toolwholelifecycle.setUpdateTime(new Date());
                toolwholelifecycle.setCreateUser(stm.getUpdateUser());
                toolwholelifecycle.setUpdateUser(stm.getUpdateUser());
                toolwholelifecycle.setVersion(BigDecimal.ZERO);
                toolwholelifecycle.setToolWholeLifecycleID(UUIDgen.getId());
                tlcList.add(toolwholelifecycle);

            }
            if (tlcList.size() > 0) {
                toolwholelifecycleDao.insertBatchs(tlcList);
            }
            //批量插入单品刀具加工信息
            if (tsList.size() > 0) {

                toolsmachiningDao.insertBacths(tsList);
            }

            Synthesisknife st = new Synthesisknife();
            //合成刀具编码(系统唯一)
            st.setrFIDWhere(stm.getExpandSpace1());
            st.setDelFlagWhere(IConstant.DEL_FLAG_0);
            //使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上)(该状态绑定到带标签的数据上)
            st.setLoadState(IConstant.DEL_FLAG_1);
            st.setBusinessFlowLnkID(IConstant.C01S013);
            //是否安装(0安装1卸下9其他)
            st.setInstallFlag(IConstant.INSTALL_FLAG_1);
            st.setUpdateTime(new Date());//更新时间
            st.setUpdateUser(stm.getUpdateUser());//更新者
            st.setCreateTime(new Date());//创建时间
            st.setCreateUser(stm.getCreateUser());//创建者
            reIntVal += synthesisknifeDao.updateNonQuery(st);

            //提交合成刀下设备信息
            reIntVal += synthesistoolsmachiningDao.updateNonQuery(stm);

            Tooltransfer tooltransfer = new Tooltransfer();
            tooltransfer.setRfidContainerID(stm.getExpandSpace2());
            tooltransfer.setDelFlag(IConstant.DEL_FLAG_0);
            List<Tooltransfer> ttList = (List<Tooltransfer>) tooltransferDao.searchByList(tooltransfer);
            //原有的加工数量
            BigDecimal processAmount = null;
            if (ttList.size() > 0) {
                //获取原有加工数量
                if ("".equals(ttList.get(0).getProcessAmount()) || ttList.get(0).getProcessAmount() == null) {
                    processAmount = BigDecimal.ZERO;
                } else {
                    processAmount = ttList.get(0).getProcessAmount();
                }

                tooltransfer = new Tooltransfer();
                tooltransfer.setRfidContainerIDWhere(stm.getExpandSpace2());
                tooltransfer.setDelFlagWhere(IConstant.DEL_FLAG_0);
                //流程为设备卸下
                tooltransfer.setBusinessFlowLnkID(IConstant.C01S013);
                //部门为对刀室
                tooltransfer.setToolThisState(IConstant.STRING_1);
                //加工数量累加
                tooltransfer.setProcessAmount(processAmount.add(stm.getProcessAmount()));
                tooltransfer.setUpdateTime(new Date());
                tooltransfer.setUpdateUser(stm.getUpdateUser());
                reIntVal += tooltransferDao.updateNonQuery(tooltransfer);
            } else {
                return 0;
            }
        } else {
            reIntVal = 0;
        }
        if (reIntVal != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n ----------------------BEGEN----------------------------");
            sb.append("\n 设备卸下");
            sb.append("\n DateTime：" + DateFormatUtil.dateToString(new Date(), 1));
            Assemblyline al = new Assemblyline();
            al.setAssemblyLineID(param.getAssemblyLineID());
            sb.append("\n AssemblyLineName：" + ((Assemblyline) assemblylineDao.searchByPrimaryKey(al)).getAssemblyLineName());
            Equipment equipment = new Equipment();
            equipment.setEquipmentID(param.getEquipmentID());
            sb.append("\n EquipmentCode：" + ((Equipment) equipmentDao.searchByPrimaryKey(equipment)).getEquipmentCode());
            sb.append("\n SynthesisParametersCode：" + param.getSynthesisParametersCode());
            sb.append("\n SynthesisParametersNumber：" + param.getSynthesisParametersNumber());
            sb.append("\n加工数量：" + stm.getProcessAmount());
            sb.append("\n ----------------------END----------------------------");
            logger.info(sb.toString());
        }

        return reIntVal;
    }

    @Override
    public List<Equipment> getEquipmentID(Equipment equipment) throws Exception {
        List<Equipment> eList = (List<Equipment>) equipmentDao.searchByList(equipment);
        return eList;
    }

    @Override
    public List<Vgetwheelinfo> getWheelInfo(Vgetwheelinfo wheel) throws Exception {
        List<Vgetwheelinfo> wheelList = (List<Vgetwheelinfo>) vgetwheelinfoDao.searchByList(wheel);
        return wheelList;

    }

    @Override
    public int checkSpareKnifeSum(Synthesistoolsmachining sm) throws Exception {

        List<Synthesiscutterlocation> slList = synthesiscutterlocationDao.searchSynthesiscutterlocationBySpCode(sm.getSynthesisParametersCode());
        if (slList.size() > 0) {
            for (int i = 0; i < slList.size(); i++) {
                Tool toolEntity = new Tool();
                toolEntity.setToolCode(slList.get(i).getToolCode());
                //List<Tool> toolInfo = toolDao.searchBitInputInfo(toolEntity);
                BigDecimal number = BigDecimal.valueOf(Integer.valueOf(slList.get(i).getToolCount()) * Integer.valueOf(sm.getRemoveNum()));
                TooltransferTotal ttEntity = new TooltransferTotal();
                ttEntity.setToolCodeWhere(slList.get(i).getToolCode());
                List<TooltransferTotal> tst = vsynthesisconditionDao
                        .searchByList3(ttEntity);

                if (number.doubleValue() > tst.get(0).getSpareKnifeSum().doubleValue()) {
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override
    public int submitSyntheticUnloadWheelInfo(Synthesistoolsmachining sm) throws Exception {
        Toolsmachining ts = null;
        List<Toolsmachining> tsList = new ArrayList<Toolsmachining>();
        Vgetwheelsmachiningmsg vg = new Vgetwheelsmachiningmsg();
        vg.setSynthesisParametersCode(sm.getSynthesisParametersCode());
        List<Vgetwheelsmachiningmsg> vwmcList = (List<Vgetwheelsmachiningmsg>) vgetwheelsmachiningmsgDao.searchByList(vg);

        for(int i = 0;i < Integer.valueOf(sm.getRemoveNum());i++){
            for (Vgetwheelsmachiningmsg ttf : vwmcList) {
                //2017/11/14 王冉 变更↓↓↓　dazhong@YMSC
                Date date = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.SECOND, +i);
                date = c.getTime();
                SimpleDateFormat dateformat = new SimpleDateFormat(
                        "yyyyMMddHHmmss");
                //2017/11/14 王冉 变更↑↑↑　dazhong@YMSC
                ts = new Toolsmachining();
                //加工编号(年月日时分秒 14位字符串)
                ts.setSynthesisNumber(dateformat.format(date));
                //刀具入库编码
                ts.setKnifeInventoryCode(UUIDgen.getId());
                //刀具ID
                ts.setToolID(ttf.getToolID());
                //流水线ID
                ts.setAssemblyLineID(sm.getAssemblyLineID());
                //设备ID
                ts.setEquipmentID(sm.getEquipmentID());
                //工序ID
                ts.setProcessID(sm.getProcessID());
                //零部件ID
                //2017/10/23 王冉 变更↓↓↓　dazhong@YMSC
                //ts.setPartsID(sm.getExpandSpace3());
                ts.setPartsID(sm.getPartsID());
                //2017/10/23 王冉 变更↑↑↑　dazhong@YMSC
                //轴ID
                ts.setAxleID(sm.getAxleID());
                //卸下时间
                ts.setOuterTime(new Date());
                sm.setOuterTime(new Date());
                //操作人
                ts.setOuterUser(sm.getUpdateUser());
                sm.setOuterUser(sm.getUpdateUser());
                //卸下原因(0正常卸下1打刀2不合格9其他)(可维护)
                ts.setRemoveReason(sm.getRemoveReason());
                //sm.setRemoveReason(IConstant.DEL_FLAG_0);
                //加工数量
                ts.setProcessAmount(sm.getProcessAmount());
                //卸下确认人(不合格卸下时需要进行确认)
                ts.setRemoveUser(sm.getUpdateUser());
                sm.setRemoveUser(sm.getUpdateUser());
                ts.setDelFlag(IConstant.DEL_FLAG_0);
                ts.setUpdateTime(new Date());
                ts.setUpdateUser(sm.getUpdateUser());
                ts.setCreateTime(new Date());
                ts.setCreateUser(sm.getUpdateUser());
                tsList.add(ts);
            }
        }

        Oplink oplink = new Oplink();
        oplink.setProcessID(sm.getProcessID());
        oplink.setEquipmentID(sm.getEquipmentID());
        oplink.setAssemblyLineID(sm.getAssemblyLineID());
        oplink.setAxleID(sm.getAxleID());
        oplink.setRowCount(1);
        oplink.setStaIndex(0);
        List<Oplink> oplinks = (List<Oplink>) oplinkDao.searchByList(oplink);
        if (oplinks.size() > 0) {
            sm.setPartsID(oplinks.get(0).getPartsID());
        }
        //批量插入单品刀具加工信息
        if (tsList.size() > 0) {
            toolsmachiningDao.insertBacths(tsList);

        }
//        if (sm.getProcessAmountWhere() == null) {
//            sm.setProcessAmountWhere(BigDecimal.ONE);
//        }
        //int removereson = sm.getProcessAmountWhere().intValue();

        List<Synthesistoolsmachining> sysList = new ArrayList<>();
        Synthesistoolsmachining syn = null;
        for (int i = 0; i < Integer.valueOf(sm.getRemoveNum()); i++) {
            syn = new Synthesistoolsmachining();

            // 加工编号(年月日时分秒 14位字符串)
            syn.setSynthesisNumber(sm.getSynthesisNumber());
            // 合成刀具号码
            syn.setSynthesisParametersNumber("00" + (i + 1));
            // 合成刀具编号
            syn.setSynthesisParametersCode(sm.getSynthesisParametersCode());
            // 流水线ID
            syn.setAssemblyLineID(sm.getAssemblyLineID());
            // 设备ID
            syn.setEquipmentID(sm.getEquipmentID());
            // 轴ID
            syn.setAxleID(sm.getAxleID());
            // 工序ID
            syn.setProcessID(sm.getProcessID());
            syn.setPartsID(sm.getPartsID());
            // 加工数量
            syn.setProcessAmount(sm.getProcessAmount());
            syn.setOuterTime(new Date());
            syn.setOuterUser(sm.getUpdateUser());
            // 删除区分
            syn.setDelFlag(IConstant.STRING_0);
            // 创建时间
            syn.setCreateTime(new Date());
            // 创建者
            syn.setCreateUser(sm.getCreateUser());
            // 更新时间
            syn.setUpdateTime(new Date());
            // 更新者
            syn.setUpdateUser(sm.getUpdateUser());
            // 版本号
            syn.setVersion(BigDecimal.ONE);
            syn.setRfidContainerID(sm.getRfidContainerID());
            syn.setRemoveReason(sm.getRemoveReason());
            sysList.add(syn);
        }
        if (sysList.size() > 0) {
            synthesistoolsmachiningDao.insertBatchs(sysList);
        }

        //2017/10/18 王冉 追加↓↓↓　dazhong@YMSC
        //卸下的设备所对应的材料 增加统计表中总报废数量
        List<Synthesiscutterlocation> slList = synthesiscutterlocationDao.searchSynthesiscutterlocationBySpCode(sm.getSynthesisParametersCode());
        if(slList.size() > 0){
            for(int i = 0;i < slList.size();i++){
                BigDecimal number = BigDecimal.valueOf(Integer.valueOf(slList.get(i).getToolCount())*Integer.valueOf(sm.getRemoveNum()));
                Tool toolEntity = new Tool();
                toolEntity.setToolCode(slList.get(i).getToolCode());
                List<Tool> toolInfo = toolDao.searchBitInputInfo(toolEntity);
                TooltransferTotal ttEntity = new TooltransferTotal();
                ttEntity.setToolCodeWhere(slList.get(i).getToolCode());
                List<TooltransferTotal> tst = vsynthesisconditionDao
                        .searchByList3(ttEntity);
                TooltransferTotal updateEntity = new TooltransferTotal();
                updateEntity.setToolCode(slList.get(i).getToolCode());


                // 材料为一次性时 拆下即报废
                if ("2".equals(toolInfo.get(0).getToolConsumetype())) {

                    // 新增报废表信息
                    Scrap scrap = new Scrap();
                    scrap.setScrapID(UUIDgen.getId ());
                    scrap.setBusinessID("C01S013");
                    // 材料号
                    scrap.setMaterial(toolInfo.get(0).getToolCode());
                    // 刀具ID
                    scrap.setToolID(toolInfo.get(0).getToolID());
                    // 报废数量
                    scrap.setScrapNumber(number);
                    // 报废原因
                    scrap.setScrapCause("卸下报废");
                    // 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）
                    scrap.setScrapState("2");
                    // 创建者
                    scrap.setCreateUser(sm.getCreateUser());
                    scrap.setDelFlag("0");
                    // 插入报废表数据
                    scrapDao.insert(scrap);

                    // 增加累积报废数量
                    updateEntity.setScrapSum(tst.get(0).getScrapSum().add (number));

                    // 新建换领申请表数据
                    Redemptionapplied r = new Redemptionapplied();
                    r.setRedemptionAppliedID(UUIDgen.getId());
                    r.setToolCode(slList.get(i).getToolCode());
                    r.setAppliedNumber(number);
                    r.setApplyUser(sm.getCreateUser());
                    r.setProcessingStatus("0");
                    // 删除区分
                    r.setDelFlag(IConstant.STRING_0);
                    // 创建时间
                    r.setCreateTime(new Date());
                    // 创建者
                    r.setCreateUser(sm.getCreateUser());
                    // 更新时间
                    r.setUpdateTime(new Date());
                    // 申请时间
                    r.setApplyTime(new Date());
                    // 更新者
                    r.setUpdateUser(sm.getUpdateUser());
                    // 版本号
                    r.setVersion(BigDecimal.ONE);
                    redemptionappliedDao.insert ( r );


                }else{
                    // 判断刀具修磨类型

                    // 修磨类别为厂外修磨时 增加统计表厂外待修磨数量
                    if ("1".equals(toolInfo.get(0).getToolGrinding())) {

                        updateEntity.setStayExternalGrindingSum(tst.get(0)
                                .getStayExternalGrindingSum().add(number));

                        // 修磨类别为厂内修磨或厂外涂层时 增加统计表厂内修磨数量 厂外涂层先厂内修磨在厂外涂层
                    } else {

                        updateEntity.setGrindingFactorySnum(tst.get(0)
                                .getGrindingFactorySnum().add(number));
                    }
                }

                updateEntity.setSpareKnifeSum(tst.get(0).getSpareKnifeSum().subtract(number));
                vsynthesisconditionDao.updateTooltransferTotal(updateEntity);

            }
        }
        //2017/08/14 王冉 追加↑↑↑　dazhong@YMSC
        return 0;
    }

    @Override
    public Synthesisparameters getSynthesisId(Synthesisparameters sp) throws Exception {
        // 根据合成刀具编码查询合成刀具id
        Synthesisparameters entity = new Synthesisparameters();
        List<Synthesisparameters> list = (List<Synthesisparameters>) synthesisparametersDao.searchByList(sp);
        if (list == null || list.size() < 1) {
            entity.setRetErrFlag(true);
        } else {
            entity = list.get(0);
        }
        return entity;
    }

    /**
     * 批量增加合成刀加工和单品刀加工列表
     *
     * @param rfidConner
     * @return
     * @throws SQLException
     */

    public List<Tooltransfer> getAllTool(String rfidConner, String customerID) throws SQLException {
        Tooltransfer entity = new Tooltransfer();
        entity.setRfidContainerID(rfidConner);
        List<Tooltransfer> list = (List<Tooltransfer>) tooltransferDao.searchByList(entity);
        for (Tooltransfer tooltransfer : list) {
            Toolwholelifecycle toolwholelifecycle = new Toolwholelifecycle();
            toolwholelifecycle.setBusinessFlowLnkID(IConstant.C01S013);
            toolwholelifecycle.setHandSetID("-");
            toolwholelifecycle.setToolCode(tooltransfer.getToolID());
            toolwholelifecycle.setToolID(tooltransfer.getToolID());
            toolwholelifecycle.setPartsID("");
            toolwholelifecycle.setToolName("-");
            toolwholelifecycle.setKnifeInventoryCode(tooltransfer.getKnifeInventoryCode());
            toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
            toolwholelifecycle.setCreateTime(new Date());
            toolwholelifecycle.setUpdateTime(new Date());
            toolwholelifecycle.setCreateUser(customerID);
            toolwholelifecycle.setUpdateUser(customerID);
            toolwholelifecycle.setVersion(BigDecimal.ZERO);
            String toolWholeLifecycleID = UUIDgen.getId();
            toolwholelifecycle.setToolWholeLifecycleID(toolWholeLifecycleID);
            toolwholelifecycleDao.insert(toolwholelifecycle);
        }
        return list;
    }
}