package com.icomp.common.service.impl.icomp.v01c03.s002;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c03.s002.ICOMPV01C03S002Service;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.common.utils.UUIDgen;
import com.icomp.dao.*;
import com.icomp.entity.base.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ICOMPV01C03S002ServiceImpl extends BaseService implements ICOMPV01C03S002Service {

    private RfidcontainerDao rfidcontainerDao;
    private EquipmentDao equipmentDao;
    private NoticeequipmentDao noticeequipmentDao;
    private OnoffDao onoffDao;

    public void setOnoffDao(OnoffDao onoffDao) {
        this.onoffDao = onoffDao;
    }

    public void setContainercarrierDao(ContainercarrierDao containercarrierDao) {
        this.containercarrierDao = containercarrierDao;
    }

    private ContainercarrierDao containercarrierDao;

    public void setNoticeequipmentDao(NoticeequipmentDao noticeequipmentDao) {
        this.noticeequipmentDao = noticeequipmentDao;
    }

    public void setEquipmentDao(EquipmentDao equipmentDao) {
        this.equipmentDao = equipmentDao;
    }

    public void setVgetassequipmentlistDao(VgetassequipmentlistDao vgetassequipmentlistDao) {
        this.vgetassequipmentlistDao = vgetassequipmentlistDao;
    }

    private VgetassequipmentlistDao vgetassequipmentlistDao;

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    private SynthesisparametersDao synthesisparametersDao;

    public void setSynthesisparametersDao(SynthesisparametersDao synthesisparametersDao) {
        this.synthesisparametersDao = synthesisparametersDao;
    }

    private VtoollistDao vtoollistDao;

    public void setVtoollistDao(VtoollistDao vtoollistDao) {
        this.vtoollistDao = vtoollistDao;
    }

    private SynthesiscutterlocationDao synthesiscutterlocationDao;

    public void setSynthesiscutterlocationDao(SynthesiscutterlocationDao synthesiscutterlocationDao) {
        this.synthesiscutterlocationDao = synthesiscutterlocationDao;
    }

    private ToolwholelifecycleDao toolwholelifecycleDao;

    public void setToolwholelifecycleDao(ToolwholelifecycleDao toolwholelifecycleDao) {
        this.toolwholelifecycleDao = toolwholelifecycleDao;
    }

    /* 刀具Dao */
    private ToolDao toolDao;

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    private BusinessDao businessDao;

    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    private BusinessflowlnkDao businessflowlnkDao;

    public void setBusinessflowlnkDao(BusinessflowlnkDao businessflowlnkDao) {
        this.businessflowlnkDao = businessflowlnkDao;
    }

    private TooltransferDao tooltransferDao;

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    public SynthesisknifeDao synthesisknifeDao;

    public void setSynthesisknifeDao(SynthesisknifeDao synthesisknifeDao) {
        this.synthesisknifeDao = synthesisknifeDao;
    }

    public TooltransferhistoryDao tooltransferhistoryDao;

    public void setTooltransferhistoryDao(TooltransferhistoryDao tooltransferhistoryDao) {
        this.tooltransferhistoryDao = tooltransferhistoryDao;
    }

    public SynthesisexperienceDao synthesisexperienceDao;

    public void setSynthesisexperienceDao(SynthesisexperienceDao synthesisexperienceDao) {
        this.synthesisexperienceDao = synthesisexperienceDao;
    }

    /**
     * 验证RFID是否可用
     *
     * @param entity
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public Rfidcontainer checkRfid(Rfidcontainer entity) {
        Rfidcontainer rfidcontainer = new Rfidcontainer();
        try {
            List<Rfidcontainer> list = (List<Rfidcontainer>) rfidcontainerDao.searchByList(entity);
            if (list == null || list.size() <= 0) {
                return new Rfidcontainer();
            } else {
                // 您所使用的RFID已被占用!
                Synthesisknife synthesisknife = new Synthesisknife();
                synthesisknife.setDelFlag(IConstant.DEL_FLAG_0);
                synthesisknife.setrFID(list.get(0).getRfidContainerID());
                List<Synthesisknife> skList = (List<Synthesisknife>) synthesisknifeDao.searchByList(synthesisknife);
                if (skList.size() > 0) {
                    rfidcontainer.setRfidCode(entity.getRfidCode());
                    rfidcontainer.setRfidContainerID(list.get(0).getRfidContainerID());
                    //用工具盘ID暂时装合成刀具编码
                    rfidcontainer.setToolShelfID(skList.get(0).getSynthesisParametersCode());
                    rfidcontainer.setMessageCode(IConstant.WMSG0158);
                    rfidcontainer.setRetErrFlag(true);
                }
                return rfidcontainer;
            }

        } catch (SQLException e) {
            rfidcontainer.setMessageCode(IConstant.EMSG0004);
            rfidcontainer.setRetErrFlag(true);
            rfidcontainer.setExceMessage(e.getMessage());
            return rfidcontainer;
        }

    }

    /**
     * 取得合成刀具列表
     *
     * @param entity
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<Synthesisparameters> getToolList(Synthesisparameters entity) {

        try {
            List<Synthesisparameters> list = (List<Synthesisparameters>) synthesisparametersDao.searchByLikeList(entity);
            if (list == null || list.size() <= 0) {
                // 合成刀具参数未找到相应的数据!
                list = new ArrayList<Synthesisparameters>();
                Synthesisparameters synthesisparameters = new Synthesisparameters();
                synthesisparameters.setMessageCode(IConstant.WMSG0131);
                synthesisparameters.setRetErrFlag(true);
                list.add(synthesisparameters);
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Synthesisparameters> list = new ArrayList<Synthesisparameters>();
            Synthesisparameters synthesisparameters = new Synthesisparameters();
            synthesisparameters.setMessageCode(IConstant.EMSG0004);
            synthesisparameters.setRetErrFlag(true);
            synthesisparameters.setExceMessage(e.getMessage());
            list.add(synthesisparameters);
            return list;
        }

    }

    /**
     * 取得合成刀具配置信息
     *
     * @param entity
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<Vtoollist> getToolInfo(Vtoollist entity) {

        try {
            List<Vtoollist> list = (List<Vtoollist>) vtoollistDao.searchByList(entity);
            if (list == null || list.size() <= 0) {
                // 您所查询的合成刀具不存在!
                list = new ArrayList<Vtoollist>();
                Vtoollist vtoollist = new Vtoollist();
                vtoollist.setMessageCode(IConstant.WMSG0160);
                vtoollist.setRetErrFlag(true);
                list.add(vtoollist);
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Vtoollist> list = new ArrayList<Vtoollist>();
            Vtoollist vtoollist = new Vtoollist();
            vtoollist.setMessageCode(IConstant.EMSG0004);
            vtoollist.setRetErrFlag(true);
            vtoollist.setExceMessage(e.getMessage());
            list.add(vtoollist);
            return list;
        }

    }

    /**
     * 保存合成刀具配置信息
     *
     * @param map
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> saveToolList(Map<String, Object> map) throws Exception {
        List<String> rfidList = (List<String>) map.get("rfidList");
        List<String> toolCodeList = (List<String>) map.get("toolCodeList");
        List<String> inputTypeList = (List<String>) map.get("inputTypeList");
        String customerID = (String) map.get("customerID");
        String langCode = (String) map.get("langCode");
        String handsetid = map.get("handsetid").toString();

        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> map2 = new HashMap<String, Object>();

        map2.put("delFlag", IConstant.DEL_FLAG_1);
        map2.put("userId", customerID);
        map2.put("updateTime", new Date());
        map2.put("list", rfidList);
        try {

            // 查询已经有的合成刀具信息
            List<Synthesisknife> skList = synthesisknifeDao.findskListByRfidList(rfidList);
            if (skList.size() > 0) {
                //删除流转中的数据
                tooltransferDao.updateBatchDeFlagByRfid(map2);
            }

            Synthesisknife sk1 = null;
            Synthesisexperience se = null;
            //删除合成刀库中的数据
            for (Synthesisknife sk : skList) {
                //合成刀库
                sk1 = new Synthesisknife();
                sk1.setDelFlag(IConstant.DEL_FLAG_1);
                sk1.setUpdateTime(new Date());
                sk1.setUpdateUser(customerID);
                sk1.setSynthesisParametersCodeWhere(sk.getSynthesisParametersCode());
                sk1.setSynthesisParametersNumberWhere(sk.getSynthesisParametersNumber());
                synthesisknifeDao.updateNonQuery(sk1);
                //合成刀库履历
                //            se = new Synthesisexperience();
                //            se.setDelFlag(IConstant.DEL_FLAG_1);
                //            se.setUpdateTime(new Date());
                //            se.setUpdateUser(customerID);
                //            se.setSynthesisParametersCodeWhere(sk.getSynthesisParametersCode());
                //            se.setSynthesisParametersNumber(sk.getSynthesisParametersNumber());
                //            synthesisexperienceDao.updateNonQuery(se);
            }
/*       Rfidcontainer rf1 = null;
        for (String rfid : rfidList) {
            rf1 = new Rfidcontainer();
            rf1.setRfidCode(rfid);
            rf1.setDelFlag(IConstant.DEL_FLAG_1);
            rf1.setUpdateUser(customerID);
            rf1.setUpdateTime(new Date());
            rf1.setRfidCodeWhere(rfid);
            rf1.setDelFlagWhere(IConstant.DEL_FLAG_0);
            rfidcontainerDao.updateNonQuery(rf1);
        }*/

            for (int i = 0; i < rfidList.size(); i++) {
                // 根据入库类型判断最后业务流程
                // 取得当前业务对应的流程ID
                Businessflowlnk businessflowlnk = new Businessflowlnk();
                Business business = new Business();
                business.setLanguageCode(langCode);
                business.setBusinessCode(IConstant.C03S002);
                List<Business> businessList = (List<Business>) businessDao.searchByList(business);
                if (businessList == null || businessList.size() <= 0) {
                    // 当前流程不存在!
                    result.put("status", IConstant.RESULT_CODE_1);
                    result.put("messagetext", IConstant.WMSG0119);
                    return result;
                } else {
                    business = businessList.get(0);// 取出流程ID
                    businessflowlnk.setBusinessID(business.getBusinessID());
                    List<Businessflowlnk> businessflowlnkList = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnk);
                    if (businessflowlnkList == null || businessflowlnkList.size() <= 0) {
                        // 当前流程不存在!
                        result.put("status", IConstant.RESULT_CODE_1);
                        result.put("messagetext", IConstant.WMSG0119);
                        return result;
                    } else {
                        businessflowlnk = businessflowlnkList.get(0);
                    }
                }
                // 当前合成刀具RFID
                String rfidString = rfidList.get(i);
                // 当前合成刀具编码
                String toolCode = toolCodeList.get(i);
                // 取得当前合成刀具组成
                Synthesisparameters synthesisparameters = new Synthesisparameters();
                synthesisparameters.setSynthesisParametersCode(toolCode);
                synthesisparameters.setDelFlag(IConstant.DEL_FLAG_0);
                List<Synthesisparameters> synthesisparametersList = (List<Synthesisparameters>) synthesisparametersDao.searchByList(synthesisparameters);
                if (synthesisparametersList == null || synthesisparametersList.size() <= 0) {
                    // 当前合成刀不存在!
                    result.put("status", IConstant.RESULT_CODE_1);
                    result.put("messagetext", IConstant.WMSG0119);
                    return result;
                }
                String synthesisparametersID = synthesisparametersList.get(0).getSynthesisParametersID();

                Synthesiscutterlocation synthesiscutterlocation = new Synthesiscutterlocation();
                synthesiscutterlocation.setSynthesisParametersID(synthesisparametersID);
                List<Synthesiscutterlocation> synthesiscutterlocationList = (List<Synthesiscutterlocation>) synthesiscutterlocationDao.searchByList(synthesiscutterlocation);
                if (synthesiscutterlocationList == null || synthesiscutterlocationList.size() <= 0) {
                    // 位置信息取得失败!
                    result.put("status", IConstant.RESULT_CODE_1);
                    result.put("messagetext", IConstant.WMSG0161);
                    return result;
                }
                List<Tooltransfer> inputList = new ArrayList<Tooltransfer>();
                String rfidID = null;
                // 获取RFID载体ID 如果不存在则新建数据
                Rfidcontainer rfidcontainer = new Rfidcontainer();
                rfidcontainer.setRfidCode(rfidString);
                List<Rfidcontainer> rfidcontainerList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
                if (rfidcontainerList == null || rfidcontainerList.size() <= 0) {
                    // 新建载体数据
                    rfidcontainer.setBandType(IConstant.BAND_TYPE_0);
                    rfidcontainer.setQueryType(IConstant.QUERY_TYPE_1);
                    rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
                    rfidcontainer.setVersion(BigDecimal.ZERO);
                    rfidcontainer.setUpdateTime(new Date());
                    rfidcontainer.setUpdateUser(customerID);
                    rfidcontainer.setSystemLogUser(customerID);
                    rfidcontainer.setRfidReCount(BigDecimal.ONE);
                    rfidID = NextKeyValue.getNextkeyvalue(IConstant.RFIDCONTAINER, IConstant.RFIDCONTAINERID, customerID);
                    rfidcontainer.setRfidContainerID(rfidID);
                    rfidcontainerDao.insert(rfidcontainer);
                } else {
                    // 如果删除区分为无效
                    rfidcontainer = rfidcontainerList.get(0);
                    if (IConstant.DEL_FLAG_1.equals(rfidcontainer.getDelFlag())) {
                        rfidID = rfidcontainer.getRfidContainerID();
                        Rfidcontainer entity = new Rfidcontainer();
                        if (rfidcontainer.getRfidReCount() == null) {
                            entity.setRfidReCount(BigDecimal.ONE);
                        } else {
                            entity.setRfidReCount(rfidcontainer.getRfidReCount().add(BigDecimal.ONE));
                        }
                        entity.setRfidContainerIDWhere(rfidcontainer.getRfidContainerID());
                        entity.setDelFlag(IConstant.DEL_FLAG_0);
                        rfidcontainerDao.updateNonQuery(entity);
                    } else {
                        rfidID = rfidcontainer.getRfidContainerID();
                        Rfidcontainer entity = new Rfidcontainer();
                        entity.setRfidReCount(rfidcontainer.getRfidReCount().add(BigDecimal.ONE));
                        entity.setRfidContainerIDWhere(rfidcontainer.getRfidContainerID());
                        entity.setDelFlag(IConstant.DEL_FLAG_0);
                        rfidcontainerDao.updateNonQuery(entity);
                    }
                }
                //	String key = NextKeyValue.getkeyvalue(IConstant.KNIFEINVENTORY,IConstant.KNIFEINVENTORYCODE);
                // 建立组成该合成刀具的流转刀具数据
                for (Synthesiscutterlocation synthesiscutterlocation2 : synthesiscutterlocationList) {
                    // 取得刀具参数ID
                    Tool tool = new Tool();
                    tool.setToolCode(synthesiscutterlocation2.getToolCode());
                    List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
                    if (toolList == null || toolList.size() <= 0) {
                        //  当前刀具编码未记录!
                        result.put("status", IConstant.RESULT_CODE_1);
                        result.put("messagetext", IConstant.WMSG0116);
                        return result;
                    }
                    tool = toolList.get(0);

                    Tooltransfer tooltransfer = new Tooltransfer();
                    tooltransfer.setToolID(tool.getToolID());// 刀具编码
                    tooltransfer.setToolSharpennum(tool.getToolSharpennum());// 可使用(刃磨)次数
                    tooltransfer.setToolSharpenCriterion(tool.getToolSharpenCriterion());// 复磨标准
                    tooltransfer.setBusinessFlowLnkID(businessflowlnk.getBusinessFlowLnkID());// 最后业务流程
                    // tooltransfer.setToolDurable(tool.getToolDurable());// 耐用度
                    tooltransfer.setToolLength(tool.getToolLength());// 刀具长度
                    tooltransfer.setToolSharpenLength(tool.getToolSharpenLength());// 可刃磨长度
                    tooltransfer.setStockState(IConstant.STOCK_STATE_4);// 库存状态
                    tooltransfer.setToolGrindingLength(BigDecimal.ZERO);
                    tooltransfer.setUsageCounter(BigDecimal.ZERO);
                    tooltransfer.setInstallationState(IConstant.INSTALLATION_STATE_1);// 刀具安装状态
                    tooltransfer.setToolState(IConstant.TOOL_STATE_9);
                    tooltransfer.setDelFlag(IConstant.DEL_FLAG_0);
                    tooltransfer.setCreateTime(new Date());
                    tooltransfer.setUpdateTime(new Date());
                    tooltransfer.setCreateUser(customerID);
                    tooltransfer.setUpdateUser(customerID);
                    tooltransfer.setVersion(BigDecimal.ZERO);
                    tooltransfer.setRfidContainerID(rfidID);
                    //key = (new BigDecimal(key).add(BigDecimal.ONE)).toString();
                    tooltransfer.setKnifeInventoryCode(UUIDgen.getId());
                    //车间
                    tooltransfer.setToolThisState(IConstant.STSATIC_FOUR);
                    inputList.add(tooltransfer);
                }
                //	NextKeyValue.savekeyvalue(IConstant.KNIFEINVENTORY,IConstant.KNIFEINVENTORYCODE, key, customerID);
                int j = 0;//遍历位置信息使用
                //取得合成刀具序号
                Synthesisknife entity = new Synthesisknife();
                entity.setSynthesisParametersCode(toolCode);//合成刀具编码
                entity.setOrderString("SynthesisParametersNumber desc");
                List<Synthesisknife> numberList = (List<Synthesisknife>) synthesisknifeDao.searchByList(entity);
                String synthesisParametersNumber = "001";
                if (numberList.size() > 0) {
                    synthesisParametersNumber = "000" + (Integer.parseInt(numberList.get(0).getSynthesisParametersNumber()) + 1);
                    synthesisParametersNumber = synthesisParametersNumber.substring(synthesisParametersNumber.length() - 3);
                }
                for (Tooltransfer tooltransfer : inputList) {
                    tooltransferDao.insert(tooltransfer);// 刀具入库

                    //合成刀库数据建立
                    Synthesisknife synthesisknife = new Synthesisknife();
                    synthesisknife.setSynthesisParametersCode(toolCode);//合成刀具编码
                    synthesisknife.setSynthesisParametersNumber(synthesisParametersNumber);
                    synthesisknife.setSynthesisCutterNumber(synthesiscutterlocationList.get(j).getSynthesisCutterNumber());//位置号
                    synthesisknife.setBusinessFlowLnkID(businessflowlnk.getBusinessFlowLnkID());//最后流程ID
                    synthesisknife.setKnifeInventoryCode(tooltransfer.getKnifeInventoryCode());//刀具入库编码
                    //如果当前刀具为辅具
                    if (IConstant.CUTTER_TYPE_1.equals(synthesiscutterlocationList.get(j).getCutterType())) {
                        //使用状态
                        String statu = "";
                        if (IConstant.STRING_1.equals(inputTypeList.get(i))) {// 车间待安上
                            statu = IConstant.LOADSTATE_5;
                        } else if (IConstant.STRING_2.equals(inputTypeList.get(i))) {// 车间待卸下
                            statu = IConstant.LOADSTATE_0;
                        } else if (IConstant.STRING_3.equals(inputTypeList.get(i))) {// 对刀室新刀
                            statu = IConstant.LOADSTATE_3;
                        } else if (IConstant.STRING_4.equals(inputTypeList.get(i))) {// 对刀室旧刀
                            statu = IConstant.LOADSTATE_2;
                        }
                        synthesisknife.setLoadState(statu);
                        //RFID
                        synthesisknife.setrFID(rfidID);
                    }
                    //是否安装
                    synthesisknife.setInstallFlag(IConstant.INSTALL_FLAG_0);
/*					if (IConstant.STRING_2.equals(inputTypeList.get(i))) {// 车间待卸下
                    }else{
						synthesisknife.setInstallFlag(IConstant.INSTALL_FLAG_1);
					}*/
                    synthesisknife.setOffloadType(BigDecimal.ZERO.toString());
                    synthesisknife.setxPoint(BigDecimal.ZERO);
                    synthesisknife.setyPoint(BigDecimal.ZERO);
                    synthesisknife.setDelFlag(IConstant.DEL_FLAG_0);
                    synthesisknife.setCreateTime(new Date());
                    synthesisknife.setUpdateTime(new Date());
                    synthesisknife.setCreateUser(customerID);
                    synthesisknife.setUpdateUser(customerID);
                    synthesisknife.setVersion(BigDecimal.ZERO);
                    synthesisknifeDao.insert(synthesisknife);
                    j++;
                    // 记录刀具生命周期
                    Tool tool = new Tool();
                    tool.setToolID(tooltransfer.getToolID());
                    tool = (Tool) toolDao.searchByPrimaryKey(tool);
                    if (tool == null) {
                        // 当前刀具编码未记录!
                        result.put("status", IConstant.RESULT_CODE_1);
                        result.put("messagetext", IConstant.WMSG0116);
                        return result;
                    }
                    Toolwholelifecycle toolwholelifecycle = new Toolwholelifecycle();
                    toolwholelifecycle.setBusinessFlowLnkID(businessflowlnk.getBusinessFlowLnkID());
                    toolwholelifecycle.setHandSetID(handsetid);
                    toolwholelifecycle.setToolCode(tool.getToolCode());
                    toolwholelifecycle.setToolName(tool.getToolName());
                    toolwholelifecycle.setKnifeInventoryCode(tooltransfer.getKnifeInventoryCode());
                    toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
                    toolwholelifecycle.setCreateTime(new Date());
                    toolwholelifecycle.setUpdateTime(new Date());
                    toolwholelifecycle.setCreateUser(customerID);
                    toolwholelifecycle.setUpdateUser(customerID);
                    toolwholelifecycle.setVersion(BigDecimal.ZERO);
                    String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue(IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, customerID);
                    toolwholelifecycle.setToolWholeLifecycleID(toolWholeLifecycleID);
                    toolwholelifecycleDao.insert(toolwholelifecycle);
                }

            }
            result.put("status", IConstant.RESULT_CODE_0);
            result.put("messagetext", IConstant.CIMSG0093);//入库成功！
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            result.put("status", IConstant.RESULT_CODE_1);
            result.put("messagetext", IConstant.EMSG0004);
            return result;
        }
    }

    /**
     * 查询流水线及设备列表
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Vgetassequipmentlist> getEquipmentList() throws Exception {
        return (List<Vgetassequipmentlist>) vgetassequipmentlistDao.searchByList(new Vgetassequipmentlist());
    }

    @Override
    public int submitEquipmentRifdCode(Map<String, Object> param) throws Exception {
        int reValCount = 0;
        //用户ID
        String userID = (String) param.get("userID");
        //授权ID
        String configUserID = (String) param.get("configUserID");
        //RFID
        String rfidCode = (String) param.get("rfidCode");
        //设备类型
        String equipmentType = (String) param.get("equipmentType");
        //设备ID
        String equipmentID = (String) param.get("equipmentID");

        Rfidcontainer rfidcontainer = new Rfidcontainer();
        Rfidcontainer rfidcontainer2 = null;
        String rifdString = UUIDgen.getId();
        //RFID载体ID
        rfidcontainer.setRfidContainerID(rifdString);
        //RFID标签ID
        rfidcontainer.setRfidCode(rfidCode);
        //RFID重用次数
        rfidcontainer.setRfidReCount(BigDecimal.ONE);
        //绑定类型(0RFID 1 激光码 2 工具盘 9 其他)
        rfidcontainer.setBandType(IConstant.BAND_TYPE_0);
        //标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
        rfidcontainer.setQueryType(IConstant.KNIFE_INVENTORY_TYPE_4);
        //删除区分(0有效1删除)
        rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
        rfidcontainer.setCreateTime(new Date());
        rfidcontainer.setUpdateTime(new Date());
        rfidcontainer.setCreateUser(userID);
        rfidcontainer.setUpdateUser(userID);
        if (IConstant.STRING_0.equals(equipmentType)) {
            Equipment eq = null;
            //加工设备
            eq = new Equipment();
            eq.setEquipmentID(equipmentID);
            eq.setDelFlag(IConstant.DEL_FLAG_0);
            List<Equipment> reList = (List<Equipment>) equipmentDao.searchByList(eq);
            if (reList != null && reList.size() > 0) {
                if (configUserID == null) {
                    //未授权
                    if (reList.get(0).getRfidContainerID() != null) {
                        //已绑定过
                        return -1;
                    }
                } else {
                    //已授权
                    if (reList.get(0).getRfidContainerID() != null) {
                        //已绑定过
                        rfidcontainer2 = new Rfidcontainer();
                        rfidcontainer2.setQueryTypeWhere(IConstant.STRING_4);
                        rfidcontainer2.setRfidContainerIDWhere(reList.get(0).getRfidContainerID());
                        rfidcontainerDao.delete(rfidcontainer2);
                    }
                }
            } else {
                return -2;
            }

            eq = new Equipment();
            //    Wherd条件
            eq.setEquipmentIDWhere(equipmentID);
            eq.setDelFlagWhere(IConstant.DEL_FLAG_0);
            eq.setRfidContainerID(rifdString);
            eq.setUpdateTime(new Date());
            eq.setUpdateUser(userID);
            //提交设备初始化信息
            reValCount += equipmentDao.updateNonQuery(eq);
        } else if (IConstant.STRING_1.equals(equipmentType)) {
            // 修磨设备
            Noticeequipment nq = null;
            nq = new Noticeequipment();
            nq.setNoticeEquipmentID(equipmentID);
            nq.setDelFlag(IConstant.DEL_FLAG_0);
            List<Noticeequipment> reList = (List<Noticeequipment>) noticeequipmentDao.searchByList(nq);
            if (reList != null && reList.size() > 0) {
                if (configUserID == null && reList.get(0).getRfidContainerID() != null) {
                    //未授权并且已绑定过
                    return -1;
                } else if (configUserID != null && reList.get(0).getRfidContainerID() != null) {
                    //已授权并且已绑定过
                    rfidcontainer2 = new Rfidcontainer();
                    rfidcontainer2.setQueryTypeWhere(IConstant.STRING_4);
                    rfidcontainer2.setRfidContainerIDWhere(reList.get(0).getRfidContainerID());
                    rfidcontainerDao.delete(rfidcontainer2);
                }
            } else {
                return -2;
            }
            nq = new Noticeequipment();
            nq.setNoticeEquipmentIDWhere(equipmentID);
            nq.setDelFlagWhere(IConstant.DEL_FLAG_0);
            nq.setRfidContainerID(rifdString);
            nq.setUpdateUser(userID);
            nq.setUpdateTime(new Date());
            //提交设备初始化信息
            reValCount += noticeequipmentDao.updateNonQuery(nq);
        }
        if (reValCount > 0) {
            //加入载体表
            rfidcontainerDao.insert(rfidcontainer);
        }
        return reValCount;
    }

    @Override
    public int submitNocEquipmentRifdCode(Noticeequipment nq) throws Exception {
        return noticeequipmentDao.updateNonQuery(nq);
    }

    @Override
    public int submitContainer(Map<String, Object> param) throws Exception {
        //用户ID
        String userID = (String) param.get("userID");
        //RFID
        String rfidCode = (String) param.get("rfidCode");
        //标签类型
        String carrierType = (String) param.get("carrierType");

        String rifdString = UUIDgen.getId();
        Rfidcontainer rfidcontainer = new Rfidcontainer();
        //RFID载体ID
        rfidcontainer.setRfidContainerID(rifdString);
        //RFID标签ID
        rfidcontainer.setRfidCode(rfidCode);
        //RFID重用次数
        rfidcontainer.setRfidReCount(BigDecimal.ONE);
        //绑定类型(0RFID 1 激光码 2 工具盘 9 其他)
        rfidcontainer.setBandType(IConstant.BAND_TYPE_0);
        //标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
        rfidcontainer.setQueryType(IConstant.KNIFE_INVENTORY_TYPE_5);
        //删除区分(0有效1删除)
        rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
        rfidcontainer.setCreateTime(new Date());
        rfidcontainer.setUpdateTime(new Date());
        rfidcontainer.setCreateUser(userID);
        rfidcontainer.setUpdateUser(userID);

        //容器表
        Containercarrier c = new Containercarrier();
        //容器ID
        c.setContainerCarrierID(UUIDgen.getId());
        //容器类别（0备用刀，1一次性报废 2待分拣容器 3厂内待刃磨 4厂外待刃磨 5刃磨完毕 6刃磨报废 7待涂层 8库房报废 9其他）
        c.setContainerCarrierType(carrierType);
        String containerCode = null;
        String containerName = null;

        Containercarrier parCon = new Containercarrier();
        parCon.setContainerCarrierType(carrierType);
        parCon.setDelFlag(IConstant.DEL_FLAG_0);
        int reVal = containercarrierDao.searchByCount(parCon);
        String conNo = "-";
        if (reVal < 0) {
            conNo = "-1";
        } else {
            conNo = conNo + (reVal + 1);
        }

        if (IConstant.STRING_0.equals(carrierType)) {
            if (reVal > 0) {
                return -1;
            } else {
                containerCode = "BDK" + conNo;
                containerName = "备刀库" + conNo;
            }
        } else if (IConstant.STRING_1.equals(carrierType)) {
            containerCode = "BFRQ" + conNo;
            containerName = "报废容器" + conNo;
        } else if (IConstant.STRING_2.equals(carrierType)) {
            containerCode = "FJRQ" + conNo;
            containerName = "分拣容器" + conNo;
        } else if (IConstant.STRING_3.equals(carrierType)) {
            containerCode = "NDRM" + conNo;
            containerName = "内待刃磨" + conNo;
        } else if (IConstant.STRING_4.equals(carrierType)) {
            containerCode = "WDRM" + conNo;
            containerName = "外待刃磨" + conNo;
        } else if (IConstant.STRING_5.equals(carrierType)) {
            containerCode = "RMWB" + conNo;
            containerName = "刃磨完毕" + conNo;
        } else if (IConstant.STRING_6.equals(carrierType)) {
            if (reVal > 0)
                return -1;
            containerCode = "RMBF" + conNo;
            containerName = "刃磨报废" + conNo;
        } else if (IConstant.STRING_7.equals(carrierType)) {
            if (reVal > 0)
                return -1;
            containerCode = "DTC" + conNo;
            containerName = "待涂层" + conNo;
        } else if (IConstant.STRING_8.equals(carrierType)) {
            if (reVal > 0)
                return -1;
            containerCode = "KFBF" + conNo;
            containerName = "库房报废" + conNo;
        } else if (IConstant.STRING_9.equals(carrierType)) {
            if (reVal > 0)
                return -1;
            containerCode = "BF" + conNo;
            containerName = "报废容器" + conNo;
        } else {
            containerCode = "QT" + conNo;
            containerName = "其他" + conNo;
        }

        //容器编码
        c.setContainerCarrierCode(containerCode);
        //容器名称
        c.setContainerCarrierName(containerName);
        //rfid载体ID
        c.setRfidContainerID(rifdString);
        c.setCreateUser(userID);
        c.setUpdateUser(userID);
        c.setDelFlag(IConstant.DEL_FLAG_0);
        c.setCreateTime(new Date());
        c.setUpdateTime(new Date());
        c.setNote("初始化");
        containercarrierDao.insert(c);
        //加入载体表
        rfidcontainerDao.insert(rfidcontainer);
        return 1;
    }

    @Override
    public List<Noticeequipment> getNoticeList() throws Exception {
        Noticeequipment noticeequipment = new Noticeequipment();
        noticeequipment.setDelFlag(IConstant.DEL_FLAG_0);
        return (List<Noticeequipment>) noticeequipmentDao.searchByList(noticeequipment);
    }

    @Override
    public List<Onoff> search(String s) {
            Onoff onoff =new Onoff();
        onoff.setOnOffCode(s);
        List<Onoff> onflist= null;
        try {
            onflist = (List<Onoff>) onoffDao.searchByList(onoff);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return onflist;
    }
}
