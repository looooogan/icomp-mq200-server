package com.icomp.common.service.impl.icomp.v01c01.s008;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s008.ICOMPV01C01S008Service;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.BusinessDao;
import com.icomp.dao.BusinessflowlnkDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.SynthesisexperienceDao;
import com.icomp.dao.SynthesisknifeDao;
import com.icomp.dao.ToolDao;
import com.icomp.dao.ToolshelflnkDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.TooltransferhistoryDao;
import com.icomp.dao.ToolwholelifecycleDao;
import com.icomp.dao.VgetsynthesistooldownmsgDao;
import com.icomp.dao.VgetsynthesistoolinfoDao;
import com.icomp.dao.VtoolplatemessagelistDao;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Businessflowlnk;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Synthesisexperience;
import com.icomp.entity.base.Synthesisknife;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Toolshelflnk;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Tooltransferhistory;
import com.icomp.entity.base.Toolwholelifecycle;
import com.icomp.entity.base.Vgetsynthesistooldownmsg;
import com.icomp.entity.base.Vgetsynthesistoolinfo;
import com.icomp.entity.base.Vgettoolshelfmessage;
import com.icomp.entity.base.Vtoolplatemessagelist;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 刀具卸下辅具-Services实现类
 *
 * @ClassName: ICOMPV01C01S008ServiceImpl
 * @author Taoyy
 * @date 2014-9-25 下午07:01:53
 */

/**
 * @author Taoyy
 * @ClassName: ICOMPV01C01S008ServiceImpl
 * @date 2014-11-14 下午06:28:54
 */
@SuppressWarnings("unchecked")
public class ICOMPV01C01S008ServiceImpl extends BaseService implements ICOMPV01C01S008Service {
    // 刀具卸下辅具Dao
    private VgetsynthesistooldownmsgDao vgetsynthesistooldownmsgDao;
    private VgetsynthesistoolinfoDao vgetsynthesistoolinfoDao;
    // 刀具流转
    private TooltransferDao tooltransferDao;
    // 载体id
    private RfidcontainerDao rfidcontainerDao;
    // 取得当前刀具的最后执行业务流程Dao
    private BusinessflowlnkDao businessflowlnkDao;
    // 取得业务流程Dao
    private BusinessDao businessDao;
    // 刀具参数Dao
    private ToolDao toolDao;
    // 生命周期Dao
    private ToolwholelifecycleDao toolwholelifecycleDao;
    // 刀具流转履历Dao
    private TooltransferhistoryDao tooltransferhistoryDao;
    // 更新合成刀库Dao
    private SynthesisknifeDao synthesisknifeDao;
    // 合成刀库履历Dao
    private SynthesisexperienceDao synthesisexperienceDao;
    // 工具盘信息Dao
    private ToolshelflnkDao toolshelflnkDao;
    // 工具盘信息Dao
    private VtoolplatemessagelistDao vtoolplatemessagelistDao;

    /**
     * 取得合成刀具信息
     * getSynthesisToolInfo
     *
     * @param map
     * @return
     * @throws Exception
     */

    @Override
    public List<Vgetsynthesistooldownmsg> getSynthesisToolInfo(Map<String, Object> map) throws Exception {
        List<Vgetsynthesistooldownmsg> list = new ArrayList<Vgetsynthesistooldownmsg>();
        String rfidString = map.get("rfid").toString();
        Vgetsynthesistooldownmsg entity = new Vgetsynthesistooldownmsg();
        Synthesisknife sk = new Synthesisknife();
        try {
            // 载体id
            Rfidcontainer rfidcontainer = new Rfidcontainer();
            rfidcontainer.setRfidCode(rfidString);
            rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
            rfidcontainer = (Rfidcontainer) rfidcontainerDao.searchByList(rfidcontainer).get(0);
            String rfidconString = rfidcontainer.getRfidContainerID();

            // 合成刀库
            sk.setrFID(rfidconString);
            sk.setDelFlag(IConstant.DEL_FLAG_0);
            sk.setOrderString("CreateTime DESC;");
            sk = (Synthesisknife) synthesisknifeDao.searchByList(sk).get(0);
            entity.setSynthesisParametersCode(sk.getSynthesisParametersCode());
            entity.setSynthesisParametersNumber(sk.getSynthesisParametersNumber());
            entity.setDelFlag(IConstant.DEL_FLAG_0);
            // 取得合成刀具卸下信息列表
            list = (List<Vgetsynthesistooldownmsg>) vgetsynthesistooldownmsgDao.searchByList(entity);
            if (list == null || list.size() <= 0) {
                // 合成刀具参数未找到相应的数据!
                Vgetsynthesistooldownmsg vgetsynthesistooldownmsg = new Vgetsynthesistooldownmsg();
                vgetsynthesistooldownmsg.setMessageCode(IConstant.WMSG0131);
                vgetsynthesistooldownmsg.setRetErrFlag(true);
                list.add(vgetsynthesistooldownmsg);
            } else {
                for (Vgetsynthesistooldownmsg vv : list) {
                    if (IConstant.STRING_0.equals(vv.getSynthesisCutterNumber().toString())) {
                        entity = vv;
                        break;
                    }
                }
                list.remove(entity);
            }
            list.get(0); //测试是否出异常

        } catch (SQLException e) {
            // 数据库操作异常，查询失败!
            list = new ArrayList<Vgetsynthesistooldownmsg>();
            Vgetsynthesistooldownmsg vgetsynthesistooldownmsg = new Vgetsynthesistooldownmsg();
            vgetsynthesistooldownmsg.setMessageCode(IConstant.EMSG0004);
            vgetsynthesistooldownmsg.setRetErrFlag(true);
            vgetsynthesistooldownmsg.setExceMessage(e.getMessage());
            list.add(vgetsynthesistooldownmsg);
        }
        return list;
    }

    public List<Vgetsynthesistoolinfo> getSynthesisToolInfo(Vgetsynthesistoolinfo entity) throws Exception {
        List<Vgetsynthesistoolinfo> list = new ArrayList<Vgetsynthesistoolinfo>();
        try {
            // 取得合成刀具信息列表
            list = (List<Vgetsynthesistoolinfo>) vgetsynthesistoolinfoDao.searchByList(entity);
            if (list == null || list.size() <= 0) {
                // 合成刀具参数未找到相应的数据!
                Vgetsynthesistoolinfo vgetsynthesistoolinfo = new Vgetsynthesistoolinfo();
                vgetsynthesistoolinfo.setMessageCode(IConstant.WMSG0131);
                vgetsynthesistoolinfo.setRetErrFlag(true);
                list.add(vgetsynthesistoolinfo);
            }
        } catch (SQLException e) {
            // 数据库操作异常，查询失败!
            list = new ArrayList<Vgetsynthesistoolinfo>();
            Vgetsynthesistoolinfo vgetsynthesistoolinfo = new Vgetsynthesistoolinfo();
            vgetsynthesistoolinfo.setMessageCode(IConstant.EMSG0004);
            vgetsynthesistoolinfo.setRetErrFlag(true);
            vgetsynthesistoolinfo.setExceMessage(e.getMessage());
            list.add(vgetsynthesistoolinfo);
        }
        return list;
    }

    /**
     * 合成刀具卸下装盒
     * saveToolBox
     *
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public int saveToolBox(Map<String, Object> map) throws Exception {
        int reval = 0;
        String userId = map.get("customerID").toString();// 用户Id
        String handId = map.get("handId").toString();// 手持机ID
        String rfidString = map.get("rfidString").toString();// 合成刀具RFID
        int staIndex = (Integer) map.get("staIndex");// 装盒状态 1:到寿,2:断刀,3.正常
        String placeNumber = map.get("placeNumber").toString(); // 位置号
        String toolsType = null;
        if (map.get("toolsType") != null)
            toolsType = map.get("toolsType").toString(); // 0：一次性刀片 1：可刃磨
        String newRfidString = null;
        if (map.get("newRfidString") != null)
            newRfidString = map.get("newRfidString").toString();// 盒RFID
        String langCode = map.get("langCode").toString();
        String lostKnife = null;
        String[] lostPos = null;
        // 丢刀位置
        if (map.get("lostKnife") != null) {
            lostKnife = map.get("lostKnife").toString();
            lostPos = lostKnife.split(",");// 位置
        }
        String confirmedUser = null;
        if (map.get("confirmedUser") != null) {
            confirmedUser = map.get("confirmedUser").toString();// 丢刀确认人
        } else {
            confirmedUser = userId;
        }
        String[] strpos = placeNumber.split(",");// 位置
        List<String> rfidList = new ArrayList<String>();
        List<String> kicList = new ArrayList<String>();// 刀具入库编码
        List<String> lostKicList = new ArrayList<String>();// 丢刀刀具入库编码
        rfidList.add(rfidString);
        // 合成刀库
        List<Synthesisknife> sysnthesList = new ArrayList<Synthesisknife>();
        Synthesisknife sk = new Synthesisknife();
        sk.setrFID(rfidString);
        // 查询合成刀具详细信息
        List<Synthesisknife> synthesisknifes = synthesisknifeDao.searchListByRfid(sk);
        if (synthesisknifes.size() < 1) {
            throw new Exception();
        }
        sk = synthesisknifes.get(0);
        String skRfidConnerid = sk.getrFID();
        // String thisBussinFlowlnkId = sk.getBusinessFlowLnkID();
        Synthesisknife sk1 = new Synthesisknife();
        sk1.setSynthesisParametersCode(sk.getSynthesisParametersCode());
        sk1.setSynthesisParametersNumber(sk.getSynthesisParametersNumber());
        sk1.setDelFlag(IConstant.DEL_FLAG_0);
        // 查询合成刀具详细信息
        sysnthesList = (List<Synthesisknife>) synthesisknifeDao.searchByList(sk1);
        // 合成刀具信息
        for (Synthesisknife sye : sysnthesList) {
            for (int i = 0; i < strpos.length; i++) {
                // 找到对应位置的信息
                if (strpos[i].equals(sye.getSynthesisCutterNumber().toString())) {
                    kicList.add(sye.getKnifeInventoryCode());
                    break;
                }
                // 丢刀
                if (lostKnife != null) {
                    for (int j = 0; j < lostPos.length; j++) {
                        if (lostPos[j].equals(sye.getSynthesisCutterNumber().toString())) {
                            lostKicList.add(sye.getKnifeInventoryCode());
                        }
                    }
                }
            }
        }
        String newRfidContainerID = "";
        if (staIndex != 4) {
            // 求新空盒的RFID载体
            Rfidcontainer rf = new Rfidcontainer();
            rf.setRfidCode(newRfidString);
            rf.setDelFlag(IConstant.DEL_FLAG_0);
            List<Rfidcontainer> rfList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rf);

            if (rfList.size() > 0) {
                newRfidContainerID = rfList.get(0).getRfidContainerID();
            } else {
                // 添加rfid关联数据
                Rfidcontainer rfidcontainer = new Rfidcontainer();
                rfidcontainer.setRfidContainerID(NextKeyValue.getNextkeyvalue(IConstant.RFIDCONTAINER, IConstant.RFIDCONTAINERID, userId));// 取得表主键
                rfidcontainer.setRfidCode(newRfidString);
                rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
                rfidcontainer.setUpdateTime(new Date());// 更新时间
                rfidcontainer.setUpdateUser(userId);// 更新者
                rfidcontainer.setCreateTime(new Date());// 更新时间
                rfidcontainer.setCreateUser(userId);// 更新者
                rfidcontainer.setBandType(IConstant.BAND_TYPE_2);// 更新者
                rfidcontainer.setVersion(BigDecimal.ZERO);// 版本号
                rfidcontainerDao.insert(rfidcontainer);
                newRfidContainerID = rfidcontainer.getRfidContainerID();

            }
        }

        // 取得刀具流转信息
        List<Tooltransfer> ttList = tooltransferDao.searchHalfByList(rfidList);

        // 取得当前刀具的最后执行业务流程
        Businessflowlnk businessflowlnk = new Businessflowlnk();
        Tooltransfer tooltransfer = ttList.get(0);
        businessflowlnk.setBusinessFlowLnkID(tooltransfer.getBusinessFlowLnkID());
        Businessflowlnk flowLink = (Businessflowlnk) businessflowlnkDao.searchByPrimaryKey(businessflowlnk);
        Business business = new Business();
        business.setLanguageCode(langCode);
        business.setBusinessID(flowLink.getBusinessID());
        List<Business> businessList = (List<Business>) businessDao.searchByList(business);
        if (businessList == null || businessList.size() <= 0) {
            throw new Exception();
        } else {
            business = businessList.get(0);// 取出流程ID

        }
        business = new Business();
        business.setBusinessCode("C01S008");
        businessList = (List<Business>) businessDao.searchByList(business);
        business = businessList.get(0);

        Businessflowlnk businessflowlnks = new Businessflowlnk();
        businessflowlnks.setBusinessID(business.getBusinessID());
        List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);
        businessflowlnk = list1.get(0);
        //		}
        // 下一个流程
        String businessFlowLnkID = businessflowlnk.getBusinessFlowLnkID();

        Tooltransferhistory tth = null;
        Tooltransfer tt2 = null;
        List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory>();
        List<Tooltransfer> delList = new ArrayList<Tooltransfer>();
        Toolwholelifecycle toolwholelifecycle = null;
        List<Toolwholelifecycle> twlcList = new ArrayList<Toolwholelifecycle>();
        // 刀具流转
        for (Tooltransfer tt : ttList) {
            if (kicList.contains(tt.getKnifeInventoryCode()) || lostKicList.contains(tt.getKnifeInventoryCode())) {
                toolwholelifecycle = new Toolwholelifecycle();
                // 记录生命周期
                toolwholelifecycle.setBusinessFlowLnkID(businessFlowLnkID);
                toolwholelifecycle.setHandSetID(handId);
                // 取得刀具信息
                Tool tool = new Tool();
                tool.setToolID(tt.getToolID());
                List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
                tool = toolList.get(0);
                toolwholelifecycle.setToolCode(tool.getToolCode());
                toolwholelifecycle.setToolName(tool.getToolName());
                toolwholelifecycle.setKnifeInventoryCode(tt.getKnifeInventoryCode());
                toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
                toolwholelifecycle.setCreateTime(new Date());
                toolwholelifecycle.setUpdateTime(new Date());
                toolwholelifecycle.setCreateUser(userId);
                toolwholelifecycle.setUpdateUser(userId);
                toolwholelifecycle.setVersion(BigDecimal.ZERO);
                String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue(IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, userId);
                toolwholelifecycle.setToolWholeLifecycleID(toolWholeLifecycleID);
                twlcList.add(toolwholelifecycle);

                if (staIndex != 4) {
                    tt2 = new Tooltransfer();
                    if (lostKicList.contains(tt.getKnifeInventoryCode())) {
                        tt2.setKnifeInventoryCodeWhere(tt.getKnifeInventoryCode());
                        tt2.setDelFlagWhere(IConstant.DEL_FLAG_0);
                        tt2.setToolState(IConstant.TOOL_STATE_1);
                        tt2.setStockState(IConstant.STOCK_STATE_1);
                        tt2.setUpdateTime(new Date());
                        tt2.setConfirmedUser(confirmedUser);
                        tooltransferDao.updateNonQuery(tt2);
                        continue;
                    }
                    tt2.setRfidContainerID(newRfidContainerID);

                    tt2.setBusinessFlowLnkID(businessFlowLnkID);
                    tt2.setToolID(tt.getToolID());
                    tt2.setProcuredBatch(tt.getProcuredBatch());
                    tt2.setKnifeInventoryCode(tt.getKnifeInventoryCode());
                    //如果是一次性刀 只要卸下就相当于换了一个
                    if (IConstant.STSATIC_ZERO.equals(toolsType)) {
                        if (tt.getToolSharpennum() == null) {//可使用(刃磨)次数
                            tt2.setToolSharpennum(BigDecimal.ZERO);
                        } else {
                            tt2.setToolSharpennum(tt.getToolSharpennum().subtract(BigDecimal.ONE));
                        }
                        if (tt.getUsageCounter() == null) {//已使用(刃磨)次数
                            tt2.setUsageCounter(BigDecimal.ONE);
                        } else {
                            tt2.setUsageCounter(tt.getUsageCounter().add(BigDecimal.ONE));
                        }
                    } else {
                        tt2.setToolSharpennum(tt.getToolSharpennum());//可使用(刃磨)次数
                        tt2.setUsageCounter(tt.getUsageCounter());//已使用(刃磨)次数
                    }

                    tt2.setToolSharpenCriterion(tt.getToolSharpenCriterion());
                    tt2.setToolLength(tt.getToolLength());
                    tt2.setToolSharpenLength(tt.getToolSharpenLength());
                    tt2.setToolGrindingLength(tt.getToolGrindingLength());
                    tt2.setInstallationState(IConstant.INSTALLATION_STATE_2);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
                    tt2.setReplacementFlag(tt.getReplacementFlag());

                    if (staIndex == 2) {//0断刀
                        tt2.setToolState(IConstant.TOOL_STATE_0);
                        tt2.setStockState(IConstant.STOCK_STATE_1);
                    } else {
                        tt2.setStockState(IConstant.STOCK_STATE_4);
                    }
                    tt2.setDelFlag(IConstant.DEL_FLAG_0);
                    // 确认人(断刀、丢失、不合格的状态选择时需要上级确认)
                    tt2.setConfirmedUser(confirmedUser);

                    tt2.setUpdateTime(new Date());// 更新时间
                    tt2.setUpdateUser(userId);// 更新者
                    tt2.setCreateTime(tt.getCreateTime());
                    tt2.setCreateUser(tt.getCreateUser());
                    tt2.setVersion(tt.getVersion().add(BigDecimal.ONE));// 版本号
                    tooltransferDao.insert(tt2);

                    // 换RFID载体-更新[刀具流转履历]
                    tth = new Tooltransferhistory();
                    tth.setKnifeInventoryCodeWhere(tt.getKnifeInventoryCode());
                    tth.setDelFlagWhere(IConstant.DEL_FLAG_0);
                    tth.setRfidContainerID(newRfidContainerID);
                    reval += tooltransferhistoryDao.updateNonQuery(tth);

                    // 刀具流转履历
                    tth = new Tooltransferhistory();

                    tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(IConstant.TOOLTRANSFERHISTORY, IConstant.TOOLTRANSFERHISTORYID, userId));
                    tth.setRfidContainerID(newRfidContainerID); // 应该新盒的RFID载体
                    tth.setKnifeInventoryCode(tt.getKnifeInventoryCode());// 刀具入库编码
                    tth.setToolID(tt.getToolID());// 刀具ID
                    tth.setToolProcuredID(tt.getProcuredBatch());// 采购ID
                    tth.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程(刀具安上)
                    tth.setToolDurable(tt.getToolDurable());// 耐用度
                    if (IConstant.STSATIC_ZERO.equals(toolsType)) {
                        tth.setToolSharpennum(tt.getToolSharpennum().subtract(BigDecimal.ONE));// 可使用(刃磨)次数
                        tth.setToolSharpenCriterion(BigDecimal.ONE.add(tt.getToolSharpenCriterion()));// 复磨标准
                    } else {
                        tth.setToolSharpennum(tt.getToolSharpennum());// 可使用(刃磨)次数
                        tth.setToolSharpenCriterion(tt.getToolSharpenCriterion());// 复磨标准
                    }
                    tth.setToolLength(tt.getToolLength());// 刀具长度
                    tth.setToolSharpenLength(tt.getToolSharpenLength());// 可刃磨长度
                    tth.setUsageCounter(tt.getUsageCounter());// 已使用(刃磨)次数
                    tth.setToolGrindingLength(tt.getToolGrindingLength());// 刀具已刃磨长度
                    tth.setInstallationState(IConstant.INSTALLATION_STATE_2);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
                    tth.setoutUser(tt.getUpdateUser());// 转出人
                    tth.setStockState(IConstant.STOCK_STATE_4);
                    tth.setinUser(userId);// 接收人
                    tth.setUpdateTime(new Date());// 更新时间
                    tth.setUpdateUser(userId);// 更新者
                    tth.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
                    tth.setCreateTime(new Date());// 创建时间
                    tth.setCreateUser(userId);// 创建者
                    tth.setVersion(BigDecimal.ZERO);// 版本号
                    tthList.add(tth);
                    delList.add(tt);
                } else { //丢刀处理
                    tt2 = new Tooltransfer();
                    tt2.setRfidContainerIDWhere(skRfidConnerid);
                    tt2.setDelFlagWhere(IConstant.DEL_FLAG_0);
                    tt2.setKnifeInventoryCodeWhere(tt.getKnifeInventoryCode());

                    tt2.setDelFlag(IConstant.DEL_FLAG_1);
                    tt2.setBusinessFlowLnkID(businessFlowLnkID);
                    tt2.setKnifeInventoryCode(tt.getKnifeInventoryCode());
                    tt2.setToolSharpennum(BigDecimal.ZERO);
                    tt2.setUsageCounter(BigDecimal.ONE);
                    tt2.setInstallationState(IConstant.INSTALLATION_STATE_2);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
                    tt2.setToolState(IConstant.TOOL_STATE_1);
                    tt2.setStockState(IConstant.STOCK_STATE_1);
                    tt2.setConfirmedUser(confirmedUser);
                    tt2.setDelFlag(IConstant.DEL_FLAG_0);
                    tt2.setUpdateTime(new Date());// 更新时间
                    tt2.setUpdateUser(userId);// 更新者
                    tt2.setVersion(tt.getVersion().add(BigDecimal.ONE));// 版本号
                    tooltransferDao.updateNonQuery(tt2);
                }
            }

        }
        if (twlcList.size() > 0) {
            // 增加生命周期
            toolwholelifecycleDao.insertBatchs(twlcList);
        }
        if (tthList.size() > 0) {
            // 批量增加【刀具流转履历】
            tooltransferhistoryDao.insertBatchDefined(tthList);
        }
        // 删除多余的
        for (Tooltransfer deltt : delList) {
            tt2 = new Tooltransfer();
            tt2.setRfidContainerIDWhere(deltt.getRfidContainerID());
            tt2.setKnifeInventoryCodeWhere(deltt.getKnifeInventoryCode());
            tooltransferDao.delete(tt2);
        }

        // 本合成刀具信息卸下
        List<Synthesisexperience> seliList = new ArrayList<Synthesisexperience>();
        for (Synthesisknife sye : sysnthesList) {
            if (kicList.contains(sye.getKnifeInventoryCode()) || lostKicList.contains(sye.getKnifeInventoryCode())) {
                Synthesisknife sk2 = new Synthesisknife();
                // 更新条件
                sk2.setSynthesisParametersCodeWhere(sye.getSynthesisParametersCode());
                sk2.setSynthesisParametersNumberWhere(sye.getSynthesisParametersNumber());
                sk2.setKnifeInventoryCodeWhere(sye.getKnifeInventoryCode());
                sk2.setDelFlagWhere(IConstant.DEL_FLAG_0);
                // 更新数据
                sk2.setOffloadType(IConstant.OFFLOAD_TYPE_0);// 卸下方式(0装盒1装盘3保留)
                sk2.setInstallFlag(IConstant.INSTALL_FLAG_1);// 是否安装(0安装1卸下9其他)
                sk2.setLoadState(IConstant.LOADSTATE_1);// '使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回)(该状态绑定到带标签的数据上)'
                sk2.setBusinessFlowLnkID(businessFlowLnkID); // 最后流程
                sk2.setUpdateTime(new Date());// 更新时间
                sk2.setUpdateUser(userId);// 更新用户
                sk2.setVersion(sye.getVersion().add(BigDecimal.ONE));// 版本加一
                // 更新数据
                reval += synthesisknifeDao.updateNonQuery(sk2);
                // 合成刀库履历
                Synthesisexperience se = new Synthesisexperience();
                se.setSynthesisParametersCode(sye.getSynthesisParametersCode());// 合成刀具编码(系统唯一)
                se.setSynthesisCutterNumber(sye.getSynthesisCutterNumber());// 位置号
                se.setSynthesisParametersNumber(sye.getSynthesisParametersNumber());// 合成刀具编号(例如：001、002、003)
                se.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程
                se.setOperationTime(new Date());// 操作时间
                se.setArrivalUser(sye.getUpdateUser());// 转出人
                se.setRecipientUser(userId);// 接收人
                se.setTransitionBecause(IConstant.TRANSITION_BECAUSE_1);// 交接原因(0送入车间1旧刀回收2不合格送回3对刀)
                se.setDelFlag(IConstant.EDIT_FLAG_0);// 删除区分(0有效1删除)
                se.setUpdateTime(new Date());// 更新时间
                se.setUpdateUser(userId);// 更新者
                se.setCreateTime(new Date());//
                se.setCreateUser(userId);// 创建者
                se.setVersion(sk2.getVersion().add(BigDecimal.ONE));// 版本号
                seliList.add(se);
            }
        }
        if (seliList.size() > 0) {
            // 合成刀库履历批量添加
            synthesisexperienceDao.batchInsert(seliList);
        }
        return reval;
    }

    /**
     * 不合格刀具卸下提交
     * saveBelow
     *
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public int saveBelow(Map<String, Object> map) throws Exception {
        int reval = 0;
        String userId = map.get("userId").toString();// 用户id
        String rfidString = map.get("rfidString").toString();// RFID
        String handId = map.get("handId").toString();// 手持机Id
        String posstionNum = map.get("posstionNum").toString();// 不合格位置号
        int isHasLast = (Integer) map.get("isHasLast");
        String newRfidString = map.get("newRfidString").toString();

        String[] strpos = posstionNum.split(",");// 位置
        List<String> rfidList = new ArrayList<String>();
        List<String> kicList = new ArrayList<String>();// 刀具入库编码
        rfidList.add(rfidString);
        // 合成刀库
        List<Synthesisknife> sysnthesList = null;
        Synthesisknife sk = new Synthesisknife();
        Synthesisknife sk3 = new Synthesisknife();
        sk.setrFID(rfidString);
        // 查询合成刀具详细信息
        List<Synthesisknife> synthesisknifes = synthesisknifeDao.searchListByRfid(sk);
        if (synthesisknifes.size() < 1) {
            throw new Exception();
        }
        sk = synthesisknifes.get(0);
        String thisBussinFlowlnkId = null;
        for (Synthesisknife sktest : synthesisknifes) {
            if (IConstant.STRING_0.equals(sktest.getSynthesisCutterNumber())) {
                // 取得当前流程
                sk3 = sktest;
            }
        }
        Synthesisknife sk1 = new Synthesisknife();
        sk1.setSynthesisParametersCode(sk.getSynthesisParametersCode());
        sk1.setSynthesisParametersNumber(sk.getSynthesisParametersNumber());
        sk1.setDelFlag(IConstant.DEL_FLAG_0);
        // 查询合成刀具详细信息
        sysnthesList = (List<Synthesisknife>) synthesisknifeDao.searchByList(sk1);
        // 合成刀具信息
        for (int i = 0; i < strpos.length; i++) {
            for (Synthesisknife sye : sysnthesList) {
                // 找到对应位置的入库编码
                if (strpos[i].equals(sye.getSynthesisCutterNumber() + "")) {
                    kicList.add(sye.getKnifeInventoryCode());
                    break;
                }
            }
        }
        // 求新空盒的RFID载体
        Rfidcontainer rf = new Rfidcontainer();
        rf.setRfidCode(newRfidString);
        rf.setDelFlag(IConstant.DEL_FLAG_0);
        List<Rfidcontainer> rfList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rf);
        String newRfidContainerID = "";
        if (rfList.size() > 0) {
            newRfidContainerID = rfList.get(0).getRfidContainerID();

        } else {
            // 添加rfid关联数据
            Rfidcontainer rfidcontainer = new Rfidcontainer();
            rfidcontainer.setRfidContainerID(NextKeyValue.getNextkeyvalue(IConstant.RFIDCONTAINER, IConstant.RFIDCONTAINERID, userId));// 取得表主键
            rfidcontainer.setRfidCode(newRfidString);
            rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
            rfidcontainer.setUpdateTime(new Date());// 更新时间
            rfidcontainer.setUpdateUser(userId);// 更新者
            rfidcontainer.setCreateTime(new Date());// 更新时间
            rfidcontainer.setCreateUser(userId);// 更新者
            rfidcontainer.setBandType(IConstant.BAND_TYPE_2);// 更新者
            rfidcontainer.setVersion(BigDecimal.ZERO);// 版本号
            rfidcontainerDao.insert(rfidcontainer);
            newRfidContainerID = rfidcontainer.getRfidContainerID();

        }
        // 取得刀具流转信息
        List<Tooltransfer> ttList = tooltransferDao.searchHalfByList(rfidList);

        // 取得当前刀具的最后执行业务流程
        // 取得业务流程ID
        // 取得业务流程ID
        Business business = new Business();
        business.setBusinessCode("C01S008");
        List<Business> businessList = (List<Business>) businessDao.searchByList(business);
        business = businessList.get(0);

        Businessflowlnk businessflowlnks = new Businessflowlnk();
        businessflowlnks.setBusinessID(business.getBusinessID());
        List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);
        Businessflowlnk businessflowlnk = list1.get(0);
        // 下一个流程
        String businessFlowLnkID = businessflowlnk.getBusinessFlowLnkID();

        Tooltransferhistory tth = null;
        List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory>();
        List<Toolwholelifecycle> lisToolwholelifecycles = new ArrayList<Toolwholelifecycle>();
        Toolwholelifecycle toolwholelifecycle = null;
        // 刀具流转
        for (Tooltransfer tt : ttList) {
            if (kicList.contains(tt.getKnifeInventoryCode())) {
                toolwholelifecycle = new Toolwholelifecycle();
                // 记录生命周期
                toolwholelifecycle.setBusinessFlowLnkID(businessFlowLnkID);
                toolwholelifecycle.setHandSetID(handId);
                // 取得刀具信息
                Tool tool = new Tool();
                tool.setToolID(tt.getToolID());
                List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
                if (toolList.size() < 1) {
                    return 0;
                }
                tool = toolList.get(0);
                toolwholelifecycle.setToolCode(tool.getToolCode());
                toolwholelifecycle.setToolName(tool.getToolName());
                toolwholelifecycle.setKnifeInventoryCode(tt.getKnifeInventoryCode());
                toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
                toolwholelifecycle.setCreateTime(new Date());
                toolwholelifecycle.setUpdateTime(new Date());
                toolwholelifecycle.setCreateUser(userId);
                toolwholelifecycle.setUpdateUser(userId);
                toolwholelifecycle.setVersion(BigDecimal.ZERO);
                String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue(IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, userId);
                toolwholelifecycle.setToolWholeLifecycleID(toolWholeLifecycleID);
                lisToolwholelifecycles.add(toolwholelifecycle);

                // 更新流转刀具
                Tooltransfer tt1 = new Tooltransfer();
                tt1.setKnifeInventoryCodeWhere(tt.getKnifeInventoryCode());// 刀具入库编码
                tt1.setDelFlagWhere(IConstant.DEL_FLAG_0);
                tt1.setRfidContainerID(newRfidContainerID);// RFID载体ID
                tt1.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程
                tt1.setInstallationState(IConstant.INSTALLATION_STATE_2);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
                // 刀具状态(0断刀1丢失2不合格3借入4申领9其他)
                tt1.setToolState(IConstant.TOOL_STATE_2);
                tt1.setStockState(IConstant.STOCK_STATE_4);
                tt1.setUpdateTime(new Date());// 更新时间
                tt1.setUpdateUser(userId);// 更新者
                tt1.setVersion(tt.getVersion().add(BigDecimal.ONE));// 版本号
                reval += tooltransferDao.updateNonQuery(tt1);

                // 换RFID载体-更新[刀具流转履历]
                tth = new Tooltransferhistory();
                tth.setKnifeInventoryCodeWhere(tt.getKnifeInventoryCode());
                tth.setDelFlag(IConstant.DEL_FLAG_0);
                tth.setRfidContainerID(newRfidContainerID);
                reval += tooltransferhistoryDao.updateNonQuery(tth);

                // 刀具流转履历
                tth = new Tooltransferhistory();
                tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(IConstant.TOOLTRANSFERHISTORY, IConstant.TOOLTRANSFERHISTORYID, userId));
                tth.setRfidContainerID(newRfidContainerID); // 应该新盒的RFID载体
                tth.setKnifeInventoryCode(tt.getKnifeInventoryCode());// 刀具入库编码
                tth.setToolID(tt.getToolID());// 刀具ID
                tth.setToolProcuredID(tt.getProcuredBatch());// 采购ID
                tth.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程(刀具安上)
                tth.setToolDurable(tt.getToolDurable());// 耐用度
                tth.setToolSharpennum(tt.getToolSharpennum());// 可使用(刃磨)次数
                tth.setToolSharpenCriterion(tt.getToolSharpenCriterion());// 复磨标准
                tth.setToolLength(tt.getToolLength());// 刀具长度
                tth.setToolSharpenLength(tt.getToolSharpenLength());// 可刃磨长度
                tth.setUsageCounter(tt.getUsageCounter());// 已使用(刃磨)次数
                tth.setToolGrindingLength(tt.getToolGrindingLength());// 刀具已刃磨长度
                tth.setInstallationState(IConstant.INSTALLATION_STATE_2);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
                tth.setoutUser(tt.getUpdateUser());// 转出人
                tth.setinUser(userId);// 接收人
                tth.setUpdateTime(new Date());// 更新时间
                tth.setUpdateUser(userId);// 更新者
                tth.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
                tth.setCreateTime(new Date());// 创建时间
                tth.setCreateUser(userId);// 创建者
                tth.setVersion(BigDecimal.ZERO);// 版本号
                tthList.add(tth);
            }

        }
        // 增加生命周期
        if (lisToolwholelifecycles.size() > 0) {
            toolwholelifecycleDao.insertBatchs(lisToolwholelifecycles);
        }

        // 本合成刀具信息
        List<Synthesisexperience> seliList = new ArrayList<Synthesisexperience>();
        for (Synthesisknife sye : sysnthesList) {
            if (kicList.contains(sye.getKnifeInventoryCode())) {
                Synthesisknife sk2 = new Synthesisknife();
                // 更新条件
                sk2.setSynthesisParametersCodeWhere(sye.getSynthesisParametersCode());
                sk2.setSynthesisParametersNumberWhere(sye.getSynthesisParametersNumber());
                sk2.setKnifeInventoryCodeWhere(sye.getKnifeInventoryCode());
                sk2.setDelFlagWhere(IConstant.DEL_FLAG_0);
                // 更新数据
                sk2.setOffloadType(IConstant.OFFLOAD_TYPE_0);// 卸下方式(0装盒1装盘3保留)
                sk2.setInstallFlag(IConstant.INSTALL_FLAG_1);// 是否安装(0安装1卸下9其他)
                sk2.setDelFlagWhere(IConstant.DEL_FLAG_0);// 删除区分
                sk2.setLoadState(IConstant.LOADSTATE_4);// '使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回)(该状态绑定到带标签的数据上)'
                sk2.setBusinessFlowLnkID(businessFlowLnkID); // 最后流程
                sk2.setUpdateTime(new Date());// 更新时间
                sk2.setUpdateUser(userId);// 更新用户
                sk2.setVersion(sye.getVersion().add(BigDecimal.ONE));// 版本加一
                // 更新数据
                reval += synthesisknifeDao.updateNonQuery(sk2);
                // 合成刀库履历
                Synthesisexperience se = new Synthesisexperience();
                se.setSynthesisParametersCode(sye.getSynthesisParametersCode());// 合成刀具编码(系统唯一)
                se.setSynthesisCutterNumber(sye.getSynthesisCutterNumber());// 位置号
                se.setSynthesisParametersNumber(sye.getSynthesisParametersNumber());// 合成刀具编号(例如：001、002、003)
                se.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程
                se.setOperationTime(new Date());// 操作时间
                se.setArrivalUser(sk2.getUpdateUser());// 转出人
                se.setRecipientUser(userId);// 接收人
                se.setTransitionBecause(IConstant.TRANSITION_BECAUSE_2);// 交接原因(0送入车间1旧刀回收2不合格送回3对刀)
                se.setDelFlag(IConstant.EDIT_FLAG_0);// 删除区分(0有效1删除)
                se.setUpdateTime(new Date());// 更新时间
                se.setUpdateUser(userId);// 更新者
                se.setCreateTime(new Date());//
                se.setCreateUser(userId);// 创建者
                se.setVersion(sk2.getVersion().add(BigDecimal.ONE));// 版本号
                seliList.add(se);
            }
        }

        // 最后一次提交把未卸下的刀具进入下一个流程
        if (isHasLast > 0) {
            // 取得刀具流转信息
            ttList = tooltransferDao.searchHalfByList(rfidList);
            lisToolwholelifecycles = new ArrayList<Toolwholelifecycle>();
            // 刀具流转
            for (Tooltransfer tt : ttList) {
                toolwholelifecycle = new Toolwholelifecycle();
                // 记录生命周期
                toolwholelifecycle.setBusinessFlowLnkID(businessFlowLnkID);
                toolwholelifecycle.setHandSetID(handId);
                // 取得刀具信息
                Tool tool = new Tool();
                tool.setToolID(tt.getToolID());
                List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
                if (toolList == null || toolList.size() <= 0) {
                    return 0;
                }
                tool = toolList.get(0);
                toolwholelifecycle.setToolCode(tool.getToolCode());
                toolwholelifecycle.setToolName(tool.getToolName());
                toolwholelifecycle.setKnifeInventoryCode(tt.getKnifeInventoryCode());
                toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
                toolwholelifecycle.setCreateTime(new Date());
                toolwholelifecycle.setUpdateTime(new Date());
                toolwholelifecycle.setCreateUser(userId);
                toolwholelifecycle.setUpdateUser(userId);
                toolwholelifecycle.setVersion(BigDecimal.ZERO);
                String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue(IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, userId);
                toolwholelifecycle.setToolWholeLifecycleID(toolWholeLifecycleID);
                lisToolwholelifecycles.add(toolwholelifecycle);

                // 更新流转刀具
                Tooltransfer tt1 = new Tooltransfer();
                tt1.setKnifeInventoryCodeWhere(tt.getKnifeInventoryCode());// 刀具入库编码
                tt1.setDelFlagWhere(IConstant.DEL_FLAG_0);
                //  tt1.setRfidContainerID(newRfidContainerID);// RFID载体ID
                tt1.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程
                tt1.setInstallationState(IConstant.INSTALLATION_STATE_2);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
                tt1.setStockState(IConstant.STOCK_STATE_4);
                tt1.setUpdateTime(new Date());// 更新时间
                tt1.setUpdateUser(userId);// 更新者
                tt1.setVersion(tt.getVersion().add(BigDecimal.ONE));// 版本号
                reval += tooltransferDao.updateNonQuery(tt1);

                // 刀具流转履历
                tth = new Tooltransferhistory();
                tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(IConstant.TOOLTRANSFERHISTORY, IConstant.TOOLTRANSFERHISTORYID, userId));
                tth.setRfidContainerID(newRfidContainerID); // 应该新盒的RFID载体
                tth.setKnifeInventoryCode(tt.getKnifeInventoryCode());// 刀具入库编码
                tth.setToolID(tt.getToolID());// 刀具ID
                tth.setToolProcuredID(tt.getProcuredBatch());// 采购ID
                tth.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程(刀具卸下)
                tth.setToolDurable(tt.getToolDurable());// 耐用度
                tth.setToolSharpennum(tt.getToolSharpennum());// 可使用(刃磨)次数
                tth.setToolSharpenCriterion(tt.getToolSharpenCriterion());// 复磨标准
                tth.setToolLength(tt.getToolLength());// 刀具长度
                tth.setToolSharpenLength(tt.getToolSharpenLength());// 可刃磨长度
                tth.setUsageCounter(tt.getUsageCounter());// 已使用(刃磨)次数
                tth.setToolGrindingLength(tt.getToolGrindingLength());// 刀具已刃磨长度
                tth.setInstallationState(IConstant.INSTALLATION_STATE_1);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
                tth.setoutUser(tt.getUpdateUser());// 转出人
                tth.setStockState(IConstant.STOCK_STATE_4);
                tth.setinUser(userId);// 接收人
                tth.setUpdateTime(new Date());// 更新时间
                tth.setUpdateUser(userId);// 更新者
                tth.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
                tth.setCreateTime(new Date());// 创建时间
                tth.setCreateUser(userId);// 创建者
                tth.setVersion(BigDecimal.ZERO);// 版本号
                tthList.add(tth);

            }

            // 增加生命周期
            if (lisToolwholelifecycles.size() > 0) {
                toolwholelifecycleDao.insertBatchs(lisToolwholelifecycles);
            }

            // 批量增加【刀具流转履历】
            if (tthList.size() > 0)
                tooltransferhistoryDao.insertBatchDefined(tthList);

            // 本合成刀具信息
            sysnthesList = (List<Synthesisknife>) synthesisknifeDao.searchByList(sk1);
            for (Synthesisknife sye : sysnthesList) {
                if (!sye.getBusinessFlowLnkID().equals(businessFlowLnkID)) {
                    Synthesisknife sk2 = new Synthesisknife();
                    // 更新条件
                    sk2.setSynthesisParametersCodeWhere(sk3.getSynthesisParametersCode());
                    sk2.setSynthesisParametersNumberWhere(sk3.getSynthesisParametersNumber());
                    sk2.setDelFlagWhere(IConstant.DEL_FLAG_0);
                    // 更新数据
                    // sk2.setOffloadType(IConstant.OFFLOAD_TYPE_3);//
                    // 卸下方式(0装盒1装盘3保留)
                    // sk2.setInstallFlag(IConstant.INSTALL_FLAG_1);//
                    // 是否安装(0安装1卸下9其他)
                    sk2.setDelFlagWhere(IConstant.DEL_FLAG_0);// 删除区分
                    sk2.setLoadState(IConstant.LOADSTATE_4);// '使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回)(该状态绑定到带标签的数据上)'
                    sk2.setBusinessFlowLnkID(businessFlowLnkID); // 最后流程
                    sk2.setInstallFlag(IConstant.INSTALL_FLAG_0);
                    sk2.setUpdateTime(new Date());// 更新时间
                    sk2.setUpdateUser(userId);// 更新用户
                    sk2.setVersion(sye.getVersion().add(BigDecimal.ONE));// 版本加一
                    // 更新数据
                    reval += synthesisknifeDao.updateNonQuery(sk2);
                    // 合成刀库履历
                    Synthesisexperience se = new Synthesisexperience();
                    se.setSynthesisParametersCode(sye.getSynthesisParametersCode());// 合成刀具编码(系统唯一)
                    se.setSynthesisCutterNumber(sye.getSynthesisCutterNumber());// 位置号
                    se.setSynthesisParametersNumber(sye.getSynthesisParametersNumber());// 合成刀具编号(例如：001、002、003)
                    se.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程
                    se.setOperationTime(new Date());// 操作时间
                    se.setArrivalUser(sye.getUpdateUser());// 转出人
                    se.setRecipientUser(userId);// 接收人
                    se.setTransitionBecause(IConstant.TRANSITION_BECAUSE_2);// 交接原因(0送入车间1旧刀回收2不合格送回3对刀)
                    se.setDelFlag(IConstant.EDIT_FLAG_0);// 删除区分(0有效1删除)
                    se.setUpdateTime(new Date());// 更新时间
                    se.setUpdateUser(userId);// 更新者
                    se.setCreateTime(new Date());//
                    se.setCreateUser(userId);// 创建者
                    se.setVersion(sk2.getVersion().add(BigDecimal.ONE));// 版本号
                    seliList.add(se);
                }
            }
        }
        if (seliList.size() > 0) {
            // 合成刀库履历批量添加
            synthesisexperienceDao.batchInsert(seliList);
        }

        return reval;
    }

    /**
     * 合成刀具卸下装盘
     * saveToolPlate
     *
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public int saveToolPlate(Map<String, Object> map) throws Exception {
        int reval = 0;
        String userId = map.get("customerID").toString();// 用户Id
        String handId = map.get("handId").toString();// 手持机ID
        String rfidString = map.get("rfidString").toString();// 合成刀具RFID
        String placeNumber = map.get("placeNumber").toString(); // 位置号
        String toolPanId = map.get("toolPanId").toString();// 工具盘ID
        String[] strpos = placeNumber.split(",");// 位置

        List<String> rfidList = new ArrayList<String>();
        List<String> kicList = new ArrayList<String>();// 刀具入库编码
        rfidList.add(rfidString);
        // 更新RFID对应的工具盘Id
        Rfidcontainer rf = new Rfidcontainer();
        rf.setToolShelfID(toolPanId);
        rf.setDelFlag(IConstant.DEL_FLAG_0);
        List<Rfidcontainer> rfList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rf);
        if (rfList.size() < 1) {
            return 0;
        }
        // 工具盘载体ID
        String panRfContString = rfList.get(0).getRfidContainerID();
        /**
         * (1)根据合成刀RFID找到合成刀具位置上的刀具入库编码
         */
        // 合成刀库
        List<Synthesisknife> sysnthesList = new ArrayList<Synthesisknife>();
        Synthesisknife sk = new Synthesisknife();
        sk.setrFID(rfidString);
        // 查询合成刀具详细信息
        List<Synthesisknife> synthesisknifes = synthesisknifeDao.searchListByRfid(sk);
        if (synthesisknifes.size() < 1) {
            throw new Exception();
        }
        sk = synthesisknifes.get(0);
        String thisBussinFlowlnkId = null;
        for (Synthesisknife sktest : synthesisknifes) {
            if (IConstant.STRING_0.equals(sktest.getSynthesisCutterNumber() + "")) {
                thisBussinFlowlnkId = sktest.getBusinessFlowLnkID();
            }
        }
        // 取得该合成刀具上的所有刀具信息（除辅具）
        Synthesisknife sk1 = new Synthesisknife();
        sk1.setSynthesisParametersCode(sk.getSynthesisParametersCode());
        sk1.setSynthesisParametersNumber(sk.getSynthesisParametersNumber());
        sk1.setDelFlag(IConstant.DEL_FLAG_0);
        // 查询合成刀具详细信息
        sysnthesList = (List<Synthesisknife>) synthesisknifeDao.searchByList(sk1);
        // 合成刀具信息
        for (int i = 0; i < strpos.length; i++) {
            for (Synthesisknife sye : sysnthesList) {
                // 找到对应位置的信息
                if (strpos[i].equals(sye.getSynthesisCutterNumber().toString())) {
                    // 要卸下的所有刀具入库编码
                    kicList.add(sye.getKnifeInventoryCode());
                    break;
                }

            }
        }
        // 取得刀具流转信息（RFID）
        List<Tooltransfer> ttList = tooltransferDao.searchHalfByList(rfidList);
        // 取得当前刀具的最后执行业务流程
        Businessflowlnk businessflowlnk = new Businessflowlnk();
        businessflowlnk.setBusinessFlowLnkID(thisBussinFlowlnkId);
        // 取得业务流程ID
        Business business = new Business();
        business.setBusinessCode("C01S008");
        List<Business> businessList = (List<Business>) businessDao.searchByList(business);
        business = businessList.get(0);
        Businessflowlnk businessflowlnks = new Businessflowlnk();
        businessflowlnks.setBusinessID(business.getBusinessID());
        List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);

        // 下一个流程
        String businessFlowLnkID = null;
        if (list1.size() > 0) {
            businessFlowLnkID = list1.get(0).getBusinessFlowLnkID();

        }
        // (2)根据工具盘ID找到盘，按空位置依次放入刀具入库编码

        Tooltransferhistory tth = null;
        List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory>();
        Toolwholelifecycle toolwholelifecycle = null;
        List<Toolwholelifecycle> twlcList = new ArrayList<Toolwholelifecycle>();
        // 刀具流转
        for (Tooltransfer tt : ttList) {
            if (kicList.contains(tt.getKnifeInventoryCode())) {
                toolwholelifecycle = new Toolwholelifecycle();
                // 记录生命周期
                toolwholelifecycle.setBusinessFlowLnkID(businessFlowLnkID);
                toolwholelifecycle.setHandSetID(handId);
                // 取得刀具信息
                Tool tool = new Tool();
                tool.setToolID(tt.getToolID());
                List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
                if (toolList.size() < 1) {
                    return 0;
                }
                tool = toolList.get(0);
                toolwholelifecycle.setToolCode(tool.getToolCode());
                toolwholelifecycle.setToolName(tool.getToolName());
                toolwholelifecycle.setKnifeInventoryCode(tt.getKnifeInventoryCode());
                toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
                toolwholelifecycle.setCreateTime(new Date());
                toolwholelifecycle.setUpdateTime(new Date());
                toolwholelifecycle.setCreateUser(userId);
                toolwholelifecycle.setUpdateUser(userId);
                toolwholelifecycle.setVersion(BigDecimal.ZERO);
                String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue(IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, userId);
                toolwholelifecycle.setToolWholeLifecycleID(toolWholeLifecycleID);
                twlcList.add(toolwholelifecycle);

                // 更新流转刀具
                Tooltransfer tt1 = new Tooltransfer();
                tt1.setKnifeInventoryCodeWhere(tt.getKnifeInventoryCode());// 刀具入库编码
                tt1.setDelFlagWhere(IConstant.DEL_FLAG_0);
                if (tt.getToolSharpennum() == null) {//可使用(刃磨)次数
                    tt1.setToolSharpennum(BigDecimal.ONE);
                } else {
                    tt1.setToolSharpennum(tt.getToolSharpennum().subtract(BigDecimal.ONE));
                }
                tt1.setUsageCounter(BigDecimal.ONE.add(tt.getUsageCounter()));
                tt1.setRfidContainerID(panRfContString);// RFID载体ID
                tt1.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程
                tt1.setInstallationState(IConstant.INSTALLATION_STATE_2);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
                tt1.setStockState(IConstant.STOCK_STATE_4);
                tt1.setUpdateTime(new Date());// 更新时间
                tt1.setUpdateUser(userId);// 更新者
                tt1.setVersion(tt.getVersion().add(BigDecimal.ONE));// 版本号
                reval += tooltransferDao.updateNonQuery(tt1);

                // 刀具流转履历
                tth = new Tooltransferhistory();
                tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(IConstant.TOOLTRANSFERHISTORY, IConstant.TOOLTRANSFERHISTORYID, userId));
                tth.setRfidContainerID(panRfContString); // 应该新盒的RFID载体
                tth.setKnifeInventoryCode(tt.getKnifeInventoryCode());// 刀具入库编码
                tth.setToolID(tt.getToolID());// 刀具ID
                tth.setToolProcuredID(tt.getProcuredBatch());// 采购ID
                tth.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程(刀具安上)
                tth.setToolDurable(tt.getToolDurable());// 耐用度
                tth.setToolSharpennum(tt.getToolSharpennum());// 可使用(刃磨)次数
                tth.setToolSharpenCriterion(tt.getToolSharpenCriterion());// 复磨标准
                tth.setToolLength(tt.getToolLength());// 刀具长度
                tth.setToolSharpenLength(tt.getToolSharpenLength());// 可刃磨长度
                tth.setUsageCounter(tt.getUsageCounter());// 已使用(刃磨)次数
                tth.setToolGrindingLength(tt.getToolGrindingLength());// 刀具已刃磨长度
                tth.setInstallationState(IConstant.INSTALLATION_STATE_2);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
                tth.setStockState(IConstant.STOCK_STATE_4);
                tth.setoutUser(tt.getUpdateUser());// 转出人
                tth.setinUser(userId);// 接收人
                tth.setUpdateTime(new Date());// 更新时间
                tth.setUpdateUser(userId);// 更新者
                tth.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
                tth.setCreateTime(new Date());// 创建时间
                tth.setCreateUser(userId);// 创建者
                tth.setVersion(BigDecimal.ZERO);// 版本号
                tthList.add(tth);
            }

        }

        // 本合成刀具信息（ (3)修改合成刀具为卸下状态）
        List<Synthesisexperience> seliList = new ArrayList<Synthesisexperience>();
        for (Synthesisknife sye : sysnthesList) {
            if (kicList.contains(sye.getKnifeInventoryCode())) {
                Synthesisknife sk2 = new Synthesisknife();
                // 更新条件
                sk2.setSynthesisParametersCodeWhere(sye.getSynthesisParametersCode());
                sk2.setSynthesisParametersNumberWhere(sye.getSynthesisParametersNumber());
                sk2.setKnifeInventoryCodeWhere(sye.getKnifeInventoryCode());
                sk2.setDelFlagWhere(IConstant.DEL_FLAG_0);
                // 更新数据
                sk2.setOffloadType(IConstant.OFFLOAD_TYPE_1);// 卸下方式(0装盒1装盘3保留)
                sk2.setInstallFlag(IConstant.INSTALL_FLAG_1);// 是否安装(0安装1卸下9其他)
                sk2.setDelFlagWhere(IConstant.DEL_FLAG_0);// 删除区分
                sk2.setLoadState(IConstant.LOADSTATE_1);// '使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回)(该状态绑定到带标签的数据上)'
                sk2.setBusinessFlowLnkID(businessFlowLnkID); // 最后流程
                sk2.setUpdateTime(new Date());// 更新时间
                sk2.setUpdateUser(userId);// 更新用户
                sk2.setVersion(sye.getVersion().add(BigDecimal.ONE));// 版本加一
                // 更新数据
                reval += synthesisknifeDao.updateNonQuery(sk2);
                // 合成刀库履历
                Synthesisexperience se = new Synthesisexperience();
                se.setSynthesisParametersCode(sye.getSynthesisParametersCode());// 合成刀具编码(系统唯一)
                se.setSynthesisCutterNumber(sye.getSynthesisCutterNumber());// 位置号
                se.setSynthesisParametersNumber(sye.getSynthesisParametersNumber());// 合成刀具编号(例如：001、002、003)
                se.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程
                se.setOperationTime(new Date());// 操作时间
                se.setArrivalUser(sye.getUpdateUser());// 转出人
                se.setRecipientUser(userId);// 接收人
                se.setDelFlag(IConstant.EDIT_FLAG_0);// 删除区分(0有效1删除)
                se.setUpdateTime(new Date());// 更新时间
                se.setUpdateUser(userId);// 更新者
                se.setCreateTime(new Date());//
                se.setCreateUser(userId);// 创建者
                se.setVersion(sye.getVersion().add(BigDecimal.ONE));// 版本号
                seliList.add(se);
            }
        }
        if (seliList.size() > 0) {
            // 合成刀库履历批量添加
            synthesisexperienceDao.batchInsert(seliList);
        }
        if (twlcList.size() > 0) {
            // 增加生命周期
            toolwholelifecycleDao.insertBatchs(twlcList);
        }
        if (tthList.size() > 0) {
            // 批量增加【刀具流转履历】
            tooltransferhistoryDao.insertBatchDefined(tthList);
        }
        // 更新流转履历载体id
        if (kicList.size() > 0) {
            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put("userId", userId);
            map2.put("newRfid", panRfContString);
            map2.put("list", kicList);
            // 按刀具入库编码修改载体ID
            reval += tooltransferhistoryDao.updateByList(map2);
        }

        Vtoolplatemessagelist vt = new Vtoolplatemessagelist();
        vt.setToolShelfID(toolPanId);
        List<Vtoolplatemessagelist> vpanList = vtoolplatemessagelistDao.searchIsNullByPanId(vt);
        if (vpanList.size() < 1) {
            return 0;
        }
        Toolshelflnk tsf = null;
        // 根据工具盘ID查询对应的位置（不等于空）
        for (int i = 0; i < vpanList.size(); i++) {
            if (kicList.size() > i) { //刀具入库编码数量
                tsf = new Toolshelflnk();
                tsf.setToolShelfIDWhere(toolPanId);// 工具盘id
                tsf.setToolShelfPlaceNumberWhere(vpanList.get(i).getToolShelfPlaceNumber());// 工具盘的位置ID
                tsf.setKnifeInventoryCode(kicList.get(i));
                reval += toolshelflnkDao.updateNonQuery(tsf);
            } else {
                break;
            }
        }
        return reval;
    }

    /**
     * 合成刀具卸下提交
     */
    @Override
    public int synthesisUnloadSubmit(Map<String, Object> map) throws Exception {
        int reval = 0;
        String userId = map.get("userId").toString();// 用户Id
        String handId = map.get("handId").toString();// 手持机ID
        String rfidString = map.get("rfidString").toString();// 合成刀具RFID
        List<String> rfidList = new ArrayList<String>();
        rfidList.add(rfidString);
        // 合成刀库
        List<Synthesisknife> sysnthesList = new ArrayList<Synthesisknife>();
        Synthesisknife sk = new Synthesisknife();
        Synthesisknife sk0 = new Synthesisknife();
        sk.setrFID(rfidString);
        // 查询合成刀具详细信息
        List<Synthesisknife> synthesisknifes = synthesisknifeDao.searchListByRfid(sk);
        if (synthesisknifes.size() < 1) {
            return 0;
        }
        sk = synthesisknifes.get(0);
        String thisBussinFlowlnkId = null;
        for (Synthesisknife sktest : synthesisknifes) {
            if (IConstant.STRING_0.equals(sktest.getSynthesisCutterNumber().toString())) {
                sk0 = sktest;
            }
        }
        thisBussinFlowlnkId = sk.getBusinessFlowLnkID();
        Synthesisknife sk1 = new Synthesisknife();
        sk1.setSynthesisParametersCode(sk.getSynthesisParametersCode());
        sk1.setSynthesisParametersNumber(sk.getSynthesisParametersNumber());
        sk1.setDelFlag(IConstant.DEL_FLAG_0);
        // 查询合成刀具详细信息
        sysnthesList = (List<Synthesisknife>) synthesisknifeDao.searchByList(sk1);

        // 取得刀具流转信息
        List<Tooltransfer> ttList = tooltransferDao.searchHalfByList(rfidList);
        // 取得当前刀具的最后执行业务流程
        Businessflowlnk businessflowlnk = new Businessflowlnk();
        businessflowlnk.setBusinessFlowLnkID(thisBussinFlowlnkId);
        Businessflowlnk flowLink = (Businessflowlnk) businessflowlnkDao.searchByPrimaryKey(businessflowlnk);
        // 取得业务流程ID
        Business business = new Business();
        business.setBusinessCode("C01S008");
        List<Business> businessList = (List<Business>) businessDao.searchByList(business);
        business = businessList.get(0);
        Businessflowlnk businessflowlnks = new Businessflowlnk();
        businessflowlnks.setBusinessID(business.getBusinessID());
        List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);
        businessflowlnks.setBusinessID(flowLink.getBusinessID());
        /*List<Businessflowlnk> list2 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);
        for (Businessflowlnk temp1 : list1) {
			for (Businessflowlnk temp2 : list2) {
				if (temp1.getBusinessFlowID().equals(temp2.getBusinessFlowID()) && temp1.getOrderNumber().intValue() == temp2.getOrderNumber().add(BigDecimal.ONE).intValue()) {
					businessflowlnk = temp1;
				}
			}
		}*/
        String businessFlowLnkID = null;
        if (list1.size() > 0) {
            businessFlowLnkID = list1.get(0).getBusinessFlowLnkID();
        } else {
            return 0;
        }

        Tooltransferhistory tth = null;
        List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory>();
        Toolwholelifecycle toolwholelifecycle = null;
        List<Toolwholelifecycle> listtwc = new ArrayList<Toolwholelifecycle>();
        // 刀具流转
        for (Tooltransfer tt : ttList) {// 只剩下已保留的刀具
            toolwholelifecycle = new Toolwholelifecycle();
            // 记录生命周期
            toolwholelifecycle.setBusinessFlowLnkID(businessFlowLnkID);
            toolwholelifecycle.setHandSetID(handId);
            // 取得刀具信息
            Tool tool = new Tool();
            tool.setToolID(tt.getToolID());
            List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
            tool = toolList.get(0);
            toolwholelifecycle.setToolCode(tool.getToolCode());
            toolwholelifecycle.setToolName(tool.getToolName());
            toolwholelifecycle.setKnifeInventoryCode(tt.getKnifeInventoryCode());
            toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
            toolwholelifecycle.setCreateTime(new Date());
            toolwholelifecycle.setUpdateTime(new Date());
            toolwholelifecycle.setCreateUser(userId);
            toolwholelifecycle.setUpdateUser(userId);
            toolwholelifecycle.setVersion(BigDecimal.ZERO);
            String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue(IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, userId);
            toolwholelifecycle.setToolWholeLifecycleID(toolWholeLifecycleID);
            listtwc.add(toolwholelifecycle);

            // 更新流转刀具
            Tooltransfer tt1 = new Tooltransfer();
            tt1.setKnifeInventoryCodeWhere(tt.getKnifeInventoryCode());// 刀具入库编码
            tt1.setDelFlagWhere(IConstant.DEL_FLAG_0);
            tt1.setRfidContainerID(tt.getRfidContainerID());// RFID载体ID
            tt1.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程
            tt1.setInstallationState(IConstant.INSTALLATION_STATE_1);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
            tt1.setStockState(IConstant.STOCK_STATE_4);
            tt1.setUpdateTime(new Date());// 更新时间
            tt1.setUpdateUser(userId);// 更新者
            tt1.setVersion(tt.getVersion().add(BigDecimal.ONE));// 版本号
            reval += tooltransferDao.updateNonQuery(tt1);

            // 刀具流转履历
            tth = new Tooltransferhistory();
            tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(IConstant.TOOLTRANSFERHISTORY, IConstant.TOOLTRANSFERHISTORYID, userId));
            tth.setRfidContainerID(tt.getRfidContainerID());
            tth.setKnifeInventoryCode(tt.getKnifeInventoryCode());// 刀具入库编码
            tth.setToolID(tt.getToolID());// 刀具ID
            tth.setToolProcuredID(tt.getProcuredBatch());// 采购ID
            tth.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程(刀具安上)
            tth.setToolDurable(tt.getToolDurable());// 耐用度
            tth.setToolSharpennum(tt.getToolSharpennum());// 可使用(刃磨)次数
            tth.setToolSharpenCriterion(tt.getToolSharpenCriterion());// 复磨标准
            tth.setToolLength(tt.getToolLength());// 刀具长度
            tth.setToolSharpenLength(tt.getToolSharpenLength());// 可刃磨长度
            tth.setUsageCounter(tt.getUsageCounter());// 已使用(刃磨)次数
            tth.setToolGrindingLength(tt.getToolGrindingLength());// 刀具已刃磨长度
            tth.setInstallationState(IConstant.INSTALLATION_STATE_1);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
            tth.setStockState(IConstant.STOCK_STATE_4);
            tth.setoutUser(tt.getUpdateUser());// 转出人
            tth.setinUser(userId);// 接收人
            tth.setUpdateTime(new Date());// 更新时间
            tth.setUpdateUser(userId);// 更新者
            tth.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
            tth.setCreateTime(new Date());// 创建时间
            tth.setCreateUser(userId);// 创建者
            tth.setVersion(BigDecimal.ZERO);// 版本号
            tthList.add(tth);

        }
        // 增加生命周期
        toolwholelifecycleDao.insertBatchs(listtwc);
        // 批量增加【刀具流转履历】
        tooltransferhistoryDao.insertBatchDefined(tthList);
        Synthesisknife sk2 = null;
        // 本合成刀具信息
        List<Synthesisexperience> seliList = new ArrayList<Synthesisexperience>();
        for (Synthesisknife sye : sysnthesList) {
            if (!sye.getBusinessFlowLnkID().equals(businessFlowLnkID) || (IConstant.STRING_0.equals(sye.getSynthesisCutterNumber() + ""))) {
                sk2 = new Synthesisknife();
                // 更新条件
                sk2.setSynthesisParametersCodeWhere(sk0.getSynthesisParametersCode());
                sk2.setSynthesisParametersNumberWhere(sk0.getSynthesisParametersNumber());
                sk2.setSynthesisCutterNumberWhere(sye.getSynthesisCutterNumber());
                sk2.setDelFlagWhere(IConstant.DEL_FLAG_0);// 删除区分
                sk2.setLoadState(IConstant.LOADSTATE_1);// '使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回)(该状态绑定到带标签的数据上)'
                sk2.setBusinessFlowLnkID(businessFlowLnkID); // 最后流程
                //	sk2.setInstallFlag(IConstant.INSTALL_FLAG_1);
                sk2.setUpdateTime(new Date());// 更新时间
                sk2.setUpdateUser(userId);// 更新用户
                sk2.setVersion(sye.getVersion().add(BigDecimal.ONE));// 版本加一
                // 更新数据
                reval += synthesisknifeDao.updateNonQuery(sk2);
                // 合成刀库履历
                Synthesisexperience se = new Synthesisexperience();
                se.setSynthesisParametersCode(sye.getSynthesisParametersCode());// 合成刀具编码(系统唯一)
                se.setSynthesisCutterNumber(sye.getSynthesisCutterNumber());// 位置号
                se.setSynthesisParametersNumber(sye.getSynthesisParametersNumber());// 合成刀具编号(例如：001、002、003)
                se.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程
                se.setOperationTime(new Date());// 操作时间
                se.setArrivalUser(sye.getUpdateUser());// 转出人
                se.setRecipientUser(userId);// 接收人
                se.setTransitionBecause(IConstant.TRANSITION_BECAUSE_1);// 交接原因(0送入车间1旧刀回收2不合格送回3对刀)
                se.setDelFlag(IConstant.EDIT_FLAG_0);// 删除区分(0有效1删除)
                se.setUpdateTime(new Date());// 更新时间
                se.setUpdateUser(userId);// 更新者
                se.setCreateTime(new Date());//
                se.setCreateUser(userId);// 创建者
                se.setVersion(sk2.getVersion().add(BigDecimal.ONE));// 版本号
                seliList.add(se);
            }
        }
        if (seliList.size() > 0) {
            // 合成刀库履历批量添加
            synthesisexperienceDao.batchInsert(seliList);
        }
        return reval;
    }

    /**
     * 取得要清洗的工具盘list
     */
    @Override
    public List<Vtoolplatemessagelist> getToolShelfList(Vgettoolshelfmessage entity) throws Exception {
        List<Vtoolplatemessagelist> list = new ArrayList<Vtoolplatemessagelist>();
        List<Vtoolplatemessagelist> list1 = new ArrayList<Vtoolplatemessagelist>();
        int pCount = entity.getRowCount();// 要装的数量
        try {
            // 取得工具盘列表
            list1 = (List<Vtoolplatemessagelist>) vtoolplatemessagelistDao.searchAllToolPan();
            if (list1 == null || list1.size() <= 0) {
                Vtoolplatemessagelist reEntity = new Vtoolplatemessagelist();
                reEntity.setMessageCode(IConstant.WMSG0225_1);
                reEntity.setRetErrFlag(true);
                list.add(reEntity);
            } else {
                for (Vtoolplatemessagelist v : list1) {
                    // 盘中剩余空位置的数量
                    int rCount = Integer.parseInt(v.getPlaceCode());
                    if (rCount < pCount) {
                        list.add(v);
                    }
                }
                for (Vtoolplatemessagelist vt : list) {
                    if (list1.contains(vt)) {
                        list1.remove(vt);
                    }
                }
            }
        } catch (SQLException e) {
            Vtoolplatemessagelist reEntity = new Vtoolplatemessagelist();
            reEntity.setMessageCode(IConstant.EMSG0004);
            reEntity.setRetErrFlag(true);
            reEntity.setExceMessage(e.getMessage());
            list.add(reEntity);
        }
        return list1;
    }

    public void setVgetsynthesistooldownmsgDao(VgetsynthesistooldownmsgDao vgetsynthesistooldownmsgDao) {
        this.vgetsynthesistooldownmsgDao = vgetsynthesistooldownmsgDao;
    }

    public void setVgetsynthesistoolinfoDao(VgetsynthesistoolinfoDao vgetsynthesistoolinfoDao) {
        this.vgetsynthesistoolinfoDao = vgetsynthesistoolinfoDao;
    }

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    public void setSynthesisknifeDao(SynthesisknifeDao synthesisknifeDao) {
        this.synthesisknifeDao = synthesisknifeDao;
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

    public void setToolshelflnkDao(ToolshelflnkDao toolshelflnkDao) {
        this.toolshelflnkDao = toolshelflnkDao;
    }

    public void setVtoolplatemessagelistDao(VtoolplatemessagelistDao vtoolplatemessagelistDao) {
        this.vtoolplatemessagelistDao = vtoolplatemessagelistDao;
    }

}
