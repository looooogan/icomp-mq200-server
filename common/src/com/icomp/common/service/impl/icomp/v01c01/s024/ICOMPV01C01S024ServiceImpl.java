package com.icomp.common.service.impl.icomp.v01c01.s024;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s024.ICOMPV01C01S024Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.dao.*;
import com.icomp.entity.base.*;

import java.lang.System;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ICOMPV01C01S024ServiceImpl extends BaseService implements ICOMPV01C01S024Service {

    private RfidcontainerDao rfidcontainerDao;
    private VgettoolinformationDao vgettoolinformationDao;
    private VgetuserinfoDao vgetuserinfoDao;
    private VgetsynthsisinfoDao vgetsynthsisinfoDao;
    private VgetequipmentinfoDao vgetequipmentinfoDao;
    private VgetcontainercarrierinfoDao vgetcontainercarrierinfoDao;

    public void setVgetcustomermsgDao(VgetcustomermsgDao vgetcustomermsgDao) {
        this.vgetcustomermsgDao = vgetcustomermsgDao;
    }

    private VgetcustomermsgDao vgetcustomermsgDao;

    public void setVgetknifeinventoryinfoDao(VgetknifeinventoryinfoDao vgetknifeinventoryinfoDao) {
        this.vgetknifeinventoryinfoDao = vgetknifeinventoryinfoDao;
    }

    private VgetknifeinventoryinfoDao vgetknifeinventoryinfoDao;

    public void setContainercarrierDao(ContainercarrierDao containercarrierDao) {
        this.containercarrierDao = containercarrierDao;
    }

    private ContainercarrierDao containercarrierDao;

    public void setNoticeequipmentDao(NoticeequipmentDao noticeequipmentDao) {
        this.noticeequipmentDao = noticeequipmentDao;
    }

    private NoticeequipmentDao noticeequipmentDao;

    public void setVgetinventorymsgDao(VgetinventorymsgDao vgetinventorymsgDao) {
        this.vgetinventorymsgDao = vgetinventorymsgDao;
    }

    private VgetinventorymsgDao vgetinventorymsgDao;

    public void setVgetcontainercarrierinfoDao(VgetcontainercarrierinfoDao vgetcontainercarrierinfoDao) {
        this.vgetcontainercarrierinfoDao = vgetcontainercarrierinfoDao;
    }

    public void setVgetequipmentinfoDao(VgetequipmentinfoDao vgetequipmentinfoDao) {
        this.vgetequipmentinfoDao = vgetequipmentinfoDao;
    }

    public void setVgetsynthsisinfoDao(VgetsynthsisinfoDao vgetsynthsisinfoDao) {
        this.vgetsynthsisinfoDao = vgetsynthsisinfoDao;
    }

    public void setVgetuserinfoDao(VgetuserinfoDao vgetuserinfoDao) {
        this.vgetuserinfoDao = vgetuserinfoDao;
    }

    public void setVgettoolinformationDao(VgettoolinformationDao vgettoolinformationDao) {
        this.vgettoolinformationDao = vgettoolinformationDao;
    }

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    private KnifeinventoryDao knifeinventoryDao;

    public void setKnifeinventoryDao(KnifeinventoryDao knifeinventoryDao) {
        this.knifeinventoryDao = knifeinventoryDao;
    }

    /* 刀具Dao */
    private ToolDao toolDao;

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    private UserdetailDao userdetailDao;

    public void setUserdetailDao(UserdetailDao userdetailDao) {
        this.userdetailDao = userdetailDao;
    }

    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    private TooltransferDao tooltransferDao;

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    private SynthesisknifeDao synthesisknifeDao;

    public void setSynthesisknifeDao(SynthesisknifeDao synthesisknifeDao) {
        this.synthesisknifeDao = synthesisknifeDao;
    }

    private BusinessflowlnkDao businessflowlnkDao;

    public void setBusinessflowlnkDao(BusinessflowlnkDao businessflowlnkDao) {
        this.businessflowlnkDao = businessflowlnkDao;
    }

    private BusinessDao businessDao;

    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    private VprocessamountDao vprocessamountDao;

    public void setVprocessamountDao(VprocessamountDao vprocessamountDao) {
        this.vprocessamountDao = vprocessamountDao;
    }

    private SynthesisparametersDao synthesisparametersDao;

    public void setSynthesisparametersDao(SynthesisparametersDao synthesisparametersDao) {
        this.synthesisparametersDao = synthesisparametersDao;
    }

    private SynthesiscutterlocationDao synthesiscutterlocationDao;

    public void setSynthesiscutterlocationDao(SynthesiscutterlocationDao synthesiscutterlocationDao) {
        this.synthesiscutterlocationDao = synthesiscutterlocationDao;
    }

    private ToolnoticehistoryDao toolnoticehistoryDao;

    public void setToolnoticehistoryDao(ToolnoticehistoryDao toolnoticehistoryDao) {
        this.toolnoticehistoryDao = toolnoticehistoryDao;
    }

    private SynthesistoolsmachiningDao synthesistoolsmachiningDao;

    public void setSynthesistoolsmachiningDao(SynthesistoolsmachiningDao synthesistoolsmachiningDao) {
        this.synthesistoolsmachiningDao = synthesistoolsmachiningDao;
    }
    
    private VgetsynthsistooltransferinfoDao vgetsynthsistooltransferinfoDao;

    public void setVgetsynthsistooltransferinfoDao(
			VgetsynthsistooltransferinfoDao vgetsynthsistooltransferinfoDao) {
		this.vgetsynthsistooltransferinfoDao = vgetsynthsistooltransferinfoDao;
	}

	/**
     * 刀具状态查询
     *
     * @param rfidString
     * @return
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> getToolInfo(String rfidString, String languageCode, String languageValue) {
        Map<String, Object> ret = new HashMap<String, Object>();
        try {
            // 取得RFID信息
            Rfidcontainer rfidcontainer = new Rfidcontainer();
            rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
            rfidcontainer.setRfidCode(rfidString);
            List<Rfidcontainer> rfidList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
            if (rfidList == null || rfidList.size() == 0) {
                // 当前扫描的RFID未绑定刀具!
                ret.put("status", IConstant.RESULT_CODE_1);
                ret.put("messageCode", IConstant.WMSG0143);
                return ret;
            }
            // 判断当前刀具类型
            rfidcontainer = rfidList.get(0);
            ret.put("QueryType", rfidcontainer.getQueryType());
            if (IConstant.QUERY_TYPE_0.equals(rfidcontainer.getQueryType())) {// 库存
                // 单品刀具
                // 取得当前刀具的刀具参数信息
                Knifeinventory knifeinventory = new Knifeinventory();
                knifeinventory.setRfidContainerID(rfidcontainer.getRfidContainerID());
                List<Knifeinventory> knifeinventoryList = (List<Knifeinventory>) knifeinventoryDao.searchByList(knifeinventory);
                ret.put("toolCount", knifeinventoryList.size());//本盒数量
                knifeinventory = knifeinventoryList.get(0);
                Tool tool = new Tool();
                tool.setToolID(knifeinventory.getToolID());
                List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
                if (toolList == null || toolList.size() <= 0) {
                    // 当前刀具编码未记录!
                    ret.put("status", IConstant.RESULT_CODE_1);
                    ret.put("messageCode", IConstant.WMSG0116);
                    return ret;
                } else {
                    tool = toolList.get(0);
                }
                // 已转角次数:
                ret.put("UsageCounter", 0);

                //   ret.put("SynthesisCount", BigDecimal.ONE);
                // 一次性刀片
                if (IConstant.TOOL_CONSUME_TYPE_2.equals(tool.getToolConsumetype())) {
                    //显示类型
                    ret.put("DisplayType", IConstant.STRING_0);//单品刀具(一次性刀片)
                    // 刀具类型：
                    ret.put("ToolType", IConstant.WMSG0233);
                    // 可转角次数：
                    ret.put("ToolSharpennum", tool.getToolSharpennum());

                } else if (IConstant.TOOL_CONSUME_TYPE_1.equals(tool.getToolConsumetype())) {
                    // 可刃磨刀片
                    //显示类型
                    ret.put("DisplayType", IConstant.STRING_1);//单品刀具(可刃磨刀片)
                    // 刀具类型：
                    ret.put("ToolType", IConstant.WMSG0234);
                    // 可刃磨次数
                    ret.put("ToolSharpennum", tool.getToolSharpennum());
                    // 可刃磨长度：
                    ret.put("ToolSharpennumLength", tool.getToolSharpenLength());
                } else if (IConstant.TOOL_CONSUME_TYPE_0.equals(tool.getToolConsumetype())) {
                    // 可刃磨钻头
                    //显示类型
                    ret.put("DisplayType", IConstant.STRING_2);//单品刀具(可刃磨钻头)
                    // 刀具类型：
                    ret.put("ToolType", IConstant.WMSG0235);
                    // 可刃磨次数
                    ret.put("ToolSharpennum", tool.getToolSharpennum());
                    // 可刃磨长度：
                    ret.put("ToolSharpennumLength", tool.getToolSharpenLength());
                    // 已刃磨次数
                    ret.put("toolNoticeCount", 0);
                }
                // 加工数量：
                ret.put("MachiningCount", 0);
                // 当前操作者
                Customer customer = new Customer();
                customer.setCustomerID(knifeinventory.getUpdateUser());
                customer = (Customer) customerDao.searchByPrimaryKey(customer);
                Userdetail userdetail = new Userdetail();
                userdetail.setCustomerID(customer.getCustomerID());
                List<Userdetail> userdetailList = (List<Userdetail>) userdetailDao.searchByList(userdetail);
                if (userdetailList == null || userdetailList.size() == 0) {
                    ret.put("UserName", customer.getUserName());
                } else {
                    ret.put("UserName", userdetailList.get(0).getUserName());
                }
                // 当前状态:
                ret.put("knifeInventoryType", knifeinventory.getKnifeInventoryType());
                ret.put("ToolStaut", MessageReSource.getMessageBox(IConstant.C01S001, languageCode, languageValue));
                // 额定加工量:
                //				ret.put("QuotaProcessingVolume", tool
                //						.getQuotaProcessingVolume());
                // 刀具编码：
                ret.put("ToolCode", tool.getToolCode());

            } else if (IConstant.QUERY_TYPE_1.equals(rfidcontainer.getQueryType())) {// 流转
                // 取得流转刀具信息
                // 取得流转刀具信息
                Tooltransfer tooltransfer = new Tooltransfer();
                tooltransfer.setRfidContainerID(rfidcontainer.getRfidContainerID());// 取得载体ID
                tooltransfer.setDelFlag(IConstant.DEL_FLAG_0);
                List<Tooltransfer> tooltransferList = (List<Tooltransfer>) tooltransferDao.searchByList(tooltransfer);
                if (tooltransferList.size() < 1) {
                    // 当前刀具编码未记录!
                    ret.put("status", IConstant.RESULT_CODE_1);
                    ret.put("messageCode", IConstant.WMSG0116_1);
                    return ret;
                }
                // 取得当前刀具的最后执行业务流程
                tooltransfer = tooltransferList.get(0);
                //      ret.put("SynthesisCount",tooltransfer.getn);
                Synthesisknife sk = new Synthesisknife();
                sk.setrFID(tooltransfer.getRfidContainerID());
                sk.setDelFlag(IConstant.DEL_FLAG_0);
                List<Synthesisknife> sklist = (List<Synthesisknife>) synthesisknifeDao.searchByList(sk);
                if (sklist.size() < 1) {
                    // 单品刀具
                    ret.put("toolState", tooltransfer.getToolState()); //刀具状态(0断刀1丢失2不合格3借入4申领9其他)
                    ret.put("toolCount", tooltransferList.size());//本盒数量
                    Tool tool = new Tool();
                    tool.setToolID(tooltransfer.getToolID());
                    List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
                    if (toolList == null || toolList.size() <= 0) {
                        // 当前刀具编码未记录!
                        ret.put("status", IConstant.RESULT_CODE_1);
                        ret.put("messageCode", IConstant.WMSG0116);
                        return ret;
                    } else {
                        tool = toolList.get(0);
                    }
                    // 已转角次数:
                    if (tooltransfer.getUsageCounter() == null) {
                        tooltransfer.setUsageCounter(BigDecimal.ZERO);
                    }
                    ret.put("UsageCounter", tooltransfer.getUsageCounter());
                    // 一次性刀片
                    if (IConstant.TOOL_CONSUME_TYPE_2.equals(tool.getToolConsumetype())) {
                        //显示类型
                        ret.put("DisplayType", IConstant.STRING_0);//单品刀具(一次性刀片)
                        // 刀具类型：
                        ret.put("ToolType", IConstant.WMSG0233);
                        // 可转角次数：
                        ret.put("ToolSharpennum", tool.getToolSharpennum());

                    } else if (IConstant.TOOL_CONSUME_TYPE_1.equals(tool.getToolConsumetype())) {
                        // 可刃磨刀片
                        //显示类型
                        ret.put("DisplayType", IConstant.STRING_1);//单品刀具(可刃磨刀片)
                        // 刀具类型：
                        ret.put("ToolType", IConstant.WMSG0234);
                        // 可使用(刃磨)次数
                        ret.put("ToolSharpennum", tooltransfer.getToolSharpennum());
                        // 可刃磨长度：
                        ret.put("ToolSharpennumLength", tooltransfer.getToolSharpenLength());
                        // 已刃磨长度
                        ret.put("ToolGrindingLength", tooltransfer.getToolGrindingLength());
                    } else if (IConstant.TOOL_CONSUME_TYPE_0.equals(tool.getToolConsumetype())) {
                        // 可刃磨钻头
                        //显示类型
                        ret.put("DisplayType", IConstant.STRING_2);//单品刀具(可刃磨钻头)
                        // 刀具类型：
                        ret.put("ToolType", IConstant.WMSG0235);
                        // 可使用(刃磨)次数
                        ret.put("ToolSharpennum", tooltransfer.getToolSharpennum());
                        // 可刃磨长度：
                        ret.put("ToolSharpennumLength", tooltransfer.getToolSharpenLength());
                        // 根据刀具入库编码取得当前钻头已刃磨次数
                        Toolnoticehistory toolnoticehistory = new Toolnoticehistory();
                        toolnoticehistory.setKnifeInventoryCode(tooltransfer.getKnifeInventoryCode());
                        // 已刃磨次数
                        ret.put("toolNoticeCount", toolnoticehistoryDao.searchByCount(toolnoticehistory));
                        // 已刃磨长度
                        ret.put("ToolGrindingLength", tooltransfer.getToolGrindingLength());
                    }
                    // 单品刀具加工数量：
                    Vprocessamount vprocessamount = new Vprocessamount();
                    vprocessamount.setKnifeInventoryCode(tooltransfer.getKnifeInventoryCode());
                    List<Vprocessamount> vprocessamountList = (List<Vprocessamount>) vprocessamountDao.searchByList(vprocessamount);
                    if (vprocessamountList == null || vprocessamountList.size() == 0) {
                        ret.put("MachiningCount", 0);
                    } else {
                        ret.put("MachiningCount", vprocessamountList.get(0).getProcessAmount());
                    }

                    // 当前操作者
                    Customer customer = new Customer();
                    customer.setCustomerID(tooltransfer.getUpdateUser());
                    customer = (Customer) customerDao.searchByPrimaryKey(customer);
                    Userdetail userdetail = new Userdetail();
                    userdetail.setCustomerID(customer.getCustomerID());
                    List<Userdetail> userdetailList = (List<Userdetail>) userdetailDao.searchByList(userdetail);
                    if (userdetailList == null || userdetailList.size() == 0) {
                        ret.put("UserName", customer.getUserName());
                    } else {
                        ret.put("UserName", userdetailList.get(0).getUserName());
                    }
                    // 当前状态:
                    // 取得当前刀具的最后执行业务流程
                    Businessflowlnk businessflowlnk = new Businessflowlnk();
                    businessflowlnk.setBusinessFlowLnkID(tooltransfer.getBusinessFlowLnkID());
                    Businessflowlnk flowLink = (Businessflowlnk) businessflowlnkDao.searchByList(businessflowlnk).get(0);
                    // 取得业务流程ID
                    Business business = new Business();
                    business.setBusinessID(flowLink.getBusinessID());
                    business = (Business) businessDao.searchByPrimaryKey(business);
                    ret.put("stockState", tooltransfer.getStockState()); //刀具状态
                    ret.put("ToolStaut", business.getBusinessName());

                    // 刀具编码：
                    ret.put("ToolCode", tool.getToolCode());
                } else {
                    // 合成刀具
                    //显示类型
                    ret.put("DisplayType", IConstant.STRING_3);//合成刀具
                    // 刀具类型：
                    ret.put("ToolType", IConstant.WMSG0236);
                    // 取得合成刀信息
                    Synthesisknife synthesisknife = new Synthesisknife();
                    synthesisknife.setrFID(rfidcontainer.getRfidContainerID());
                    synthesisknife.setSynthesisCutterNumber(BigDecimal.ZERO);
                    synthesisknife.setDelFlag(IConstant.DEL_FLAG_0);
                    List<Synthesisknife> listSynthesisknife = (List<Synthesisknife>) synthesisknifeDao.searchByList(synthesisknife);
                    synthesisknife = listSynthesisknife.get(0);
                    // 合成刀具编码
                    ret.put("ToolCode", synthesisknife.getSynthesisParametersCode());
                    // 合成刀具状态
                    // 取得当前刀具的最后执行业务流程
                    Businessflowlnk businessflowlnk = new Businessflowlnk();
                    businessflowlnk.setBusinessFlowLnkID(synthesisknife.getBusinessFlowLnkID());
                    Businessflowlnk flowLink = (Businessflowlnk) businessflowlnkDao.searchByPrimaryKey(businessflowlnk);
                    // 取得业务流程ID
                    Business business = new Business();
                    business.setBusinessID(flowLink.getBusinessID());
                    business = (Business) businessDao.searchByPrimaryKey(business);
                    ret.put("ToolStaut", business.getBusinessName());
                    // X坐标
                    ret.put("xPoint", synthesisknife.getxPoint());
                    // Y坐标
                    ret.put("yPoint", synthesisknife.getyPoint());
                    // 当前操作者
                    Customer customer = new Customer();
                    customer.setCustomerID(synthesisknife.getUpdateUser());
                    customer = (Customer) customerDao.searchByPrimaryKey(customer);
                    Userdetail userdetail = new Userdetail();
                    userdetail.setCustomerID(customer.getCustomerID());
                    List<Userdetail> userdetailList = (List<Userdetail>) userdetailDao.searchByList(userdetail);
                    if (userdetailList == null || userdetailList.size() == 0) {
                        ret.put("UserName", customer.getUserName());
                    } else {
                        ret.put("UserName", userdetailList.get(0).getUserName());
                    }
                    // 合成刀具加工数量
                    Synthesistoolsmachining stm = new Synthesistoolsmachining();
                    // stm.setSynthesisCutterNumber(BigDecimal.ZERO);
                    // stm.setSynthesisParametersNumber(synthesisknife.getSynthesisParametersNumber());
                    // stm.setSynthesisParametersCode(synthesisknife.getSynthesisParametersCode());
                    stm.setDelFlag(IConstant.DEL_FLAG_0);
                    try {
                        ret.put("MachiningCount", synthesistoolsmachiningDao.searchSumCountByEntity(stm));
                    } catch (Exception e) {
                        ret.put("MachiningCount", 0);
                        System.out.println(e);
                    }


                   /*
                    // 取得合成刀具参数
                    Synthesisparameters synthesisparameters = new Synthesisparameters();
                    synthesisparameters.setSynthesisParametersCode(listSynthesisknife.get(0).getSynthesisParametersCode());
                    List<Synthesisparameters> synthesisparametersList = (List<Synthesisparameters>) synthesisparametersDao.searchByList(synthesisparameters);
                    synthesisparameters = synthesisparametersList.get(0);
                   	ret.put("QuotaProcessingVolume", synthesisparameters
                    // 定额加工量
                    							.getQuotaProcessingVolume());
                   // 孔位数
                    					if (synthesisparameters.getSynthesisCount().signum()>0) {
                    						ret.put("SynthesisCount", synthesisparameters.getSynthesisCount().subtract(BigDecimal.ONE));
                    					}
                    					Synthesiscutterlocation synthesiscutterlocation = new Synthesiscutterlocation();
                    					synthesiscutterlocation.setSynthesisParametersID(synthesisparameters.getSynthesisParametersID());
                    					List<Synthesiscutterlocation> synthesiscutterlocationList = (List<Synthesiscutterlocation>)
                    							synthesiscutterlocationDao.searchByList(synthesiscutterlocation);
                    					int Auxiliary = 0, drill = 0, blades = 0;
                    					for (Synthesiscutterlocation synthesiscutterlocation2 : synthesiscutterlocationList) {
                    						if(IConstant.CUTTER_TYPE_0.equals(synthesiscutterlocation2.getCutterType())){
                    							Tool tool = new Tool();
                    							tool.setToolCode(synthesiscutterlocation2.getToolCode());
                    							List<Tool> toolList = (List<Tool>) toolDao
                    									.searchByList(tool);
                    							if (toolList == null || toolList.size() <= 0) {
                    								// 当前刀具编码未记录!
                    								ret.put("status", IConstant.RESULT_CODE_1);
                    								ret.put("messageCode", IConstant.WMSG0116);
                    								return ret;
                    							} else {
                    								tool = toolList.get(0);
                    							}
                    							if(IConstant.TOOL_CONSUME_TYPE_0.equals(tool.getToolConsumetype())){
                    								drill ++;
                    							}else{
                    								blades ++;
                    							}
                    						}else if(IConstant.CUTTER_TYPE_1.equals(synthesiscutterlocation2.getCutterType())){
                    							Auxiliary++;
                    						}
                    					}


                    // 辅具数
                    				ret.put("Auxiliary", Auxiliary);
                    // 钻头数
                    					ret.put("drill", drill);
                    // 刀片数
                    				ret.put("blades", blades);
                    				*/
                }
            } else {
                // 所扫描的rfid标签不是刀具!
                ret.put("status", IConstant.RESULT_CODE_1);
                ret.put("messageCode", IConstant.WMSG0120);
                return ret;
            }
            ret.put("status", IConstant.RESULT_CODE_0);
            return ret;
        } catch (SQLException e) {
            ret.put("status", IConstant.RESULT_CODE_1);
            ret.put("messageCode", IConstant.EMSG0004);
            return ret;
        }
    }

    /**
     * 查询单品刀信息
     *
     * @param r
     * @return
     * @throws Exception
     */
    @Override
    public Vgettoolinformation gettoolinformation(Vgettoolinformation r) throws Exception {
        return vgettoolinformationDao.gettoolinformation(r);
    }

    /**
     * 查询员工卡
     *
     * @param r
     * @return
     * @throws Exception
     */
    @Override
    public Vgetcustomermsg getUserInfo(Vgetcustomermsg r) throws Exception {
        List<Vgetcustomermsg> reVal = (List<Vgetcustomermsg>) vgetcustomermsgDao.searchByList(r);
        if (reVal == null || reVal.size() < 1) {
            return null;
        } else {
            return reVal.get(0);

        }
    }

    /**
     * 查询合成刀
     *
     * @param rfc
     * @return
     * @throws Exception
     */
    @Override
    public Vgetsynthsisinfo getsynthsisinfo(Vgetsynthsisinfo rfc) throws Exception {
        List<Vgetsynthsisinfo> reList = (List<Vgetsynthsisinfo>) vgetsynthsisinfoDao.searchByList(rfc);
        Vgetsynthsisinfo reEntit = new Vgetsynthsisinfo();
        if (reList.size() < 1) {
            //未找到相应数据
            return null;
        } else {
            reEntit = reList.get(0);
        }
        return reEntit;
    }

    /**
     * 查询设备
     *
     * @param r
     * @return
     * @throws Exception
     */
    @Override
    public List<Vgetequipmentinfo> getequipmentinfo(Vgetequipmentinfo r) throws Exception {
        return vgetequipmentinfoDao.getequipmentinfo(r);
    }

    /**
     * 查询容器
     *
     * @param r
     * @return
     * @throws Exception
     */
    @Override
    public Vgetcontainercarrierinfo getcontainercarrierinfo(Vgetcontainercarrierinfo r) throws Exception {
        return vgetcontainercarrierinfoDao.getcontainercarrierinfo(r);
    }

    /**
     * 查询库位标签
     *
     * @param r
     * @return
     * @throws Exception
     */
    @Override
    public Vgetinventorymsg getInventoryMsg(Vgetinventorymsg r) throws Exception {
        return vgetinventorymsgDao.getInventoryMsg(r);
    }

    /**
     * 查询标签类型
     *
     * @param r
     * @return
     * @throws Exception
     */
    @Override
    public Rfidcontainer getQeryType(Rfidcontainer r) throws Exception {
        return (Rfidcontainer) rfidcontainerDao.searchByPrimaryKey(r);
    }

    @Override
    public List<Vgetequipmentinfo> getequipmentinfolist(Vgetequipmentinfo vv) throws Exception {
        return (List<Vgetequipmentinfo>) vgetequipmentinfoDao.searchByList(vv);
    }

    @Override
    public Noticeequipment getNoticeEqu(Noticeequipment ne) throws Exception {
        List<Noticeequipment> reList = (List<Noticeequipment>) noticeequipmentDao.searchByList(ne);
        Noticeequipment reEntit = new Noticeequipment();
        if (reList.size() < 1) {
            //未找到相应数据
            reEntit.setRetErrFlag(true);
        } else {
            reEntit = reList.get(0);
        }
        return reEntit;
    }

    @Override
    public List<Vgetcontainercarrierinfo> getcontainercarrierinfolist(Vgetcontainercarrierinfo vv) throws Exception {
        return (List<Vgetcontainercarrierinfo>) vgetcontainercarrierinfoDao.searchByList(vv);
    }

    @Override
    public List<Vgetcontainercarrierinfo> getcontainercarrierinfolist1(Vgetcontainercarrierinfo vv) throws Exception {
        return vgetcontainercarrierinfoDao.searchByListGroud(vv);
    }

    @Override
    public Containercarrier getContainerName(Containercarrier cc) throws Exception {
        List<Containercarrier> reList = (List<Containercarrier>) containercarrierDao.searchByList(cc);
        Containercarrier reEntit = new Containercarrier();
        if (reList.size() < 1) {
            //未找到相应数据
            reEntit.setRetErrFlag(true);
        } else {
            reEntit = reList.get(0);
        }
        return reEntit;

    }

    @Override
    public Vgetknifeinventoryinfo getKnifeInfo(Vgetknifeinventoryinfo vvv) throws Exception {
        List<Vgetknifeinventoryinfo> reList = (List<Vgetknifeinventoryinfo>) vgetknifeinventoryinfoDao.searchByList(vvv);
        Vgetknifeinventoryinfo reEntit = new Vgetknifeinventoryinfo();
        if (reList.size() < 1) {
            //未找到相应数据
            reEntit.setRetErrFlag(true);
        } else {
            reEntit = reList.get(0);
        }
        return reEntit;

    }

	@Override
	public List<Vgetsynthsistooltransferinfo> getSynthsisTooltransferInfo(
			Vgetsynthsistooltransferinfo vtt) throws Exception {

        List<Vgetsynthsistooltransferinfo> vttList = (List<Vgetsynthsistooltransferinfo>) vgetsynthsistooltransferinfoDao.searchByList(vtt);
        return vttList;

	}

	@Override
	public List<Vgetinventorymsg> getNumber(Vgetinventorymsg msg)
			throws Exception {
		List<Vgetinventorymsg> msgList = (List<Vgetinventorymsg>) vgetinventorymsgDao.searchByList(msg);
		return msgList;
	}

    @Override
    public List<Synthesisparameters> getSynthsisTools(Synthesisparameters sp) throws Exception {
        return synthesisparametersDao.getSysthesCodeByToolCode ( sp );
    }


}
