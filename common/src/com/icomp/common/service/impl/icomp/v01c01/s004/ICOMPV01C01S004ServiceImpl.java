package com.icomp.common.service.impl.icomp.v01c01.s004;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s004.ICOMPV01C01S004Service;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.common.utils.UUIDgen;
import com.icomp.dao.BusinessDao;
import com.icomp.dao.BusinessflowlnkDao;
import com.icomp.dao.ContainercarrierDao;
import com.icomp.dao.KnifeinventoryDao;
import com.icomp.dao.LibrarycodeDao;
import com.icomp.dao.ReplacementDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.ScrapDao;
import com.icomp.dao.ToolDao;
import com.icomp.dao.ToollibraryhistoryDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.TooltransferhistoryDao;
import com.icomp.dao.ToolwholelifecycleDao;
import com.icomp.dao.VgetshelfinformationDao;
import com.icomp.dao.VreplacementDao;
import com.icomp.dao.impl.BusinessDaoImpl;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Businessflowlnk;
import com.icomp.entity.base.Containercarrier;
import com.icomp.entity.base.Knifeinventory;
import com.icomp.entity.base.Librarycode;
import com.icomp.entity.base.Replacement;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Scrap;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Toollibraryhistory;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Tooltransferhistory;
import com.icomp.entity.base.Toolwholelifecycle;
import com.icomp.entity.base.Vgetshelfinformation;
import com.icomp.entity.base.Vreplacement;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ICOMPV01C01S004ServiceImpl extends BaseService implements ICOMPV01C01S004Service {

    /**
     * 取得货架信息
     */
    private VgetshelfinformationDao vgetshelfinformationDao;

    public void setVreplacementDao(VreplacementDao vreplacementDao) {
        this.vreplacementDao = vreplacementDao;
    }

    private VreplacementDao vreplacementDao;

    public void setVgetshelfinformationDao(VgetshelfinformationDao vgetshelfinformationDao) {
        this.vgetshelfinformationDao = vgetshelfinformationDao;
    }

    //刀具流转dao
    private TooltransferDao tooltransferDao;

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    //刀具流转履历Dao
    private TooltransferhistoryDao tooltransferhistoryDao;

    public void setTooltransferhistoryDao(TooltransferhistoryDao tooltransferhistoryDao) {
        this.tooltransferhistoryDao = tooltransferhistoryDao;
    }

    /**
     * 库位码
     */
    private LibrarycodeDao librarycodeDao;

    public void setLibrarycodeDao(LibrarycodeDao librarycodeDao) {
        this.librarycodeDao = librarycodeDao;
    }

    //申请单号
    private ReplacementDao replacementDao;

    public void setReplacementDao(ReplacementDao replacementDao) {
        this.replacementDao = replacementDao;
    }

    private RfidcontainerDao rfidcontainerDao;
    private KnifeinventoryDao knifeinventoryDao;
    private BusinessDao businessDao;
    private BusinessflowlnkDao businessflowlnkDao;
    private ToolDao toolDao;
    private ToolwholelifecycleDao toolwholelifecycleDao;
    private ToollibraryhistoryDao toollibraryhistoryDao;

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    public void setKnifeinventoryDao(KnifeinventoryDao knifeinventoryDao) {
        this.knifeinventoryDao = knifeinventoryDao;
    }

    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    public void setBusinessflowlnkDao(BusinessflowlnkDao businessflowlnkDao) {
        this.businessflowlnkDao = businessflowlnkDao;
    }

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    public void setToolwholelifecycleDao(ToolwholelifecycleDao toolwholelifecycleDao) {
        this.toolwholelifecycleDao = toolwholelifecycleDao;
    }

    public void setToollibraryhistoryDao(ToollibraryhistoryDao toollibraryhistoryDao) {
        this.toollibraryhistoryDao = toollibraryhistoryDao;
    }
    
    private ContainercarrierDao containercarrierDao;

    public void setContainercarrierDao(ContainercarrierDao containercarrierDao) {
		this.containercarrierDao = containercarrierDao;
	}
    
    // 刀具报废dao
    private ScrapDao scrapDao;

	public void setScrapDao(ScrapDao scrapDao) {
		this.scrapDao = scrapDao;
	}

	/**
     * 获取生成申领单号
     * getApplyNumber
     *
     * @return
     * @throws Exception
     */
    public String getApplyNumber(String customerID) {
        // 获取申领申请表(Replacement)主键
        return NextKeyValue.getNextkeyvalueNo(IConstant.REPLACEMENT, IConstant.REPLACEMENT_ID, customerID);
    }

    /**
     * 取得待申领刀具信息
     * getApplyToolInfo
     *
     * @param map
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<Vgetshelfinformation> getApplyToolInfo(Map<String, Object> map) {
        Vgetshelfinformation entity = new Vgetshelfinformation();
        List<Librarycode> list1 = new ArrayList<Librarycode>();
        List<Librarycode> list2 = new ArrayList<Librarycode>();
        Librarycode librarycode2 = null;
        List<Vgetshelfinformation> list = new ArrayList<Vgetshelfinformation>();
        String toolCode = map.get("toolCood").toString();// 刀具编码
        String libraryCode = map.get("liberCocd").toString();//库位码
        int appleNumber = (Integer) map.get("appleNumber");// 申请数量
        try {
            // 如果是自定义库位码，或者中系统库位码，两者只能有一个
            if (libraryCode != null && !"".equals(libraryCode.trim())) {
                librarycode2 = new Librarycode();
                librarycode2.setCustomerCode(libraryCode);
                librarycode2.setDelFlag(IConstant.DEL_FLAG_0);
                list1 = (List<Librarycode>) librarycodeDao.searchByList(librarycode2);
                if (list1.size() > 0) {
                    entity.setCustomerCode(libraryCode);

                }
                librarycode2 = new Librarycode();
                librarycode2.setSysteCode(libraryCode);
                librarycode2.setDelFlag(IConstant.DEL_FLAG_0);
                list2 = (List<Librarycode>) librarycodeDao.searchByList(librarycode2);
                if (list2.size() > 0) {
                    entity.setSysteCode(libraryCode);
                }
            }

            if (list1.size() == 0 && list2.size() == 0 && (toolCode == null || "".equals(toolCode))) {
                list = new ArrayList<Vgetshelfinformation>();
                Vgetshelfinformation vgetshelfinformation = new Vgetshelfinformation();
                vgetshelfinformation.setMessageCode(IConstant.WMSG0240);
                vgetshelfinformation.setRetErrFlag(true);
                list.add(vgetshelfinformation);
                return list;
            }

            // 根据刀具编码查询
            if (toolCode != null && toolCode.length() > 1) {
                entity.setToolCode(toolCode);
            }

            // 取得待申领刀具信息列表
            list = (List<Vgetshelfinformation>) vgetshelfinformationDao.searchByList(entity);
            if (list == null || list.size() <= 0) {
                // 申领刀具未找到相应的数据!
                Vgetshelfinformation vgetshelfinformation = new Vgetshelfinformation();
                vgetshelfinformation.setMessageCode(IConstant.WMSG0127);
                vgetshelfinformation.setRetErrFlag(true);
                list.add(vgetshelfinformation);
            }
        } catch (SQLException e) {
            // 数据库操作异常，查询失败!
            list = new ArrayList<Vgetshelfinformation>();
            Vgetshelfinformation vgetshelfinformation = new Vgetshelfinformation();
            vgetshelfinformation.setMessageCode(IConstant.EMSG0004);
            vgetshelfinformation.setRetErrFlag(true);
            vgetshelfinformation.setExceMessage(e.getMessage());
            list.add(vgetshelfinformation);
        }
        return list;
    }

    /**
     * 扫描rfid，取得当前rfid对应的信息
     * getRfidToolInfo
     *
     * @param entity
     * @return
     * @throws Exception
     */
    public List<Vreplacement> getRfidToolInfo(Vreplacement entity) throws Exception {
        List<Vreplacement> list = new ArrayList<Vreplacement>();
        /*
        try {
			// 取得当前待申领刀具信息列表
			list = (List<Vreplacement>) vreplacementDao.searchByList(entity);
			if (list == null || list.size() <= 0) {
				// 当前申领刀具信息失败!
				Vreplacement vreplacement = new Vreplacement();
				vreplacement.setMessageCode(IConstant.EMSG0001);
				vreplacement.setRetErrFlag(true);
				list.add(vreplacement);
			}
		} catch (SQLException e) {
			// 数据库操作异常，查询失败!
			list = new ArrayList<Vreplacement>();
			Vreplacement vreplacement = new Vreplacement();
			vreplacement.setMessageCode(IConstant.EMSG0004);
			vreplacement.setRetErrFlag(true);
			vreplacement.setExceMessage(e.getMessage());
			list.add(vreplacement);
		}
		 */
        return list;
    }

    /**
     * 申领结束，记录申请单
     * getRfidToolInfo
     *
     * @param map
     * @return
     * @throws Exception
     */
    public int saveApplyInfo(Map<String, Object> map) throws Exception {
        List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory>();
        List<String> rfidList = (List<String>) map.get("rfidList");//所有扫描的RFID
        String userId = map.get("userId").toString(); //操作人
        String gruantUserID = map.get("gruantUserID").toString();//授权人
        String appliendReason = map.get("appliendReason") + "";//申请原因
        String handId = map.get("handerId") + "";
        List<Replacement> replacementList = (List<Replacement>) map.get("replacementList");//申领信息
        List<String> itRfidList = new ArrayList<String>();
        List<String> ttRfidList = new ArrayList<String>();
        List<Tooltransfer> ttList = new ArrayList<Tooltransfer>();
        List<Knifeinventory> itList = new ArrayList<Knifeinventory>();
        int reVal = 0;
        Rfidcontainer rf = null;
        // 查询方式(0库存1流转)
        Date recederTime = new Date ();
        for (String rfid : rfidList) {
            rf = new Rfidcontainer();
            rf.setRfidCode(rfid);
            rf.setDelFlag(IConstant.DEL_FLAG_0);
            rf = (Rfidcontainer) rfidcontainerDao.searchByList(rf).get(0);
            if (IConstant.STRING_0.equals(rf.getQueryType())) {// 0库存
                itRfidList.add(rfid);
            } else {// 1流转
                ttRfidList.add(rfid);
            }
        }
        if (ttRfidList.size() > 0) {
            // 取得刀具流转信息
            ttList = tooltransferDao.searchHalfByList(ttRfidList);
        }
        if (itRfidList.size() > 0) {
            // 取得新库中的刀具
            itList = knifeinventoryDao.searchListByRfid(itRfidList);
        }
        // 取得业务流程ID
        Business business = new Business();
        BusinessDao businessDao = new BusinessDaoImpl();
        business.setBusinessCode(IConstant.C01S010);
        List<Business> businessList = (List<Business>) businessDao.searchByList(business);
        business = businessList.get(0);
        Businessflowlnk businessflowlnks = new Businessflowlnk();
        businessflowlnks.setBusinessID(business.getBusinessID());
        List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);
        String businessFlowLnkID = list1.get(0).getBusinessFlowLnkID();
        Tooltransfer tt1 = null;
        List<Tooltransfer> ttList1 = new ArrayList<Tooltransfer>();
        Tooltransferhistory tth = null;
        List<Toolwholelifecycle> tlcList = new ArrayList<Toolwholelifecycle>();
        Toolwholelifecycle toolwholelifecycle = null;
        // 刀具流转(旧刀)
        for (Tooltransfer tt : ttList) {
            // 记录生命周期
            toolwholelifecycle = new Toolwholelifecycle();
            toolwholelifecycle.setBusinessFlowLnkID(businessFlowLnkID);
            toolwholelifecycle.setHandSetID(handId);
            // 取得刀具信息
            Tool tool = new Tool();
            tool.setToolID(tt.getToolID());
            List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
            if (toolList != null && toolList.size() > 0) {
                tool = toolList.get(0);
                toolwholelifecycle.setToolCode(tool.getToolCode());
                toolwholelifecycle.setToolName(tool.getToolName());
            }

            toolwholelifecycle.setKnifeInventoryCode(tt.getKnifeInventoryCode());
            toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
            toolwholelifecycle.setCreateTime(new Date());
            toolwholelifecycle.setUpdateTime(new Date());
            toolwholelifecycle.setCreateUser(userId);
            toolwholelifecycle.setUpdateUser(gruantUserID);
            toolwholelifecycle.setVersion(BigDecimal.ZERO);
            String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue(IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, userId);
            toolwholelifecycle.setToolWholeLifecycleID(toolWholeLifecycleID);
            tlcList.add(toolwholelifecycle);
            Tooltransfer entity = new Tooltransfer();
            entity.setKnifeInventoryCodeWhere(tt.getKnifeInventoryCode());
            entity.setStockState(IConstant.STOCK_STATE_1);//报废
            entity.setInstallationState(IConstant.INSTALLATION_STATE_0);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
            entity.setToolState(IConstant.TOOL_STATE_4);// 刀具状态(0断刀1丢失2不合格3借入4申领9其他)
            entity.setConfirmedUser(gruantUserID);
            entity.setUpdateTime(new Date());// 更新时间
            entity.setUpdateUser(gruantUserID);// 更新者
            entity.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
            entity.setVersion(tt.getVersion().add(BigDecimal.ONE));// 版本号
            reVal += tooltransferDao.updateNonQuery(entity);

            // 刀具流转履历
            tth = new Tooltransferhistory();
            tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(IConstant.TOOLTRANSFERHISTORY, IConstant.TOOLTRANSFERHISTORYID, userId));
            tth.setRfidContainerID(tt.getRfidContainerID()); // RFID载体ID
            tth.setKnifeInventoryCode(tt.getKnifeInventoryCode());// 刀具入库编码
            tth.setToolID(tt.getToolID());// 刀具ID
            tth.setToolProcuredID(tt.getProcuredBatch());// 采购ID
            tth.setBusinessFlowLnkID(tt.getBusinessFlowLnkID());// 最后执行业务流程
            tth.setToolDurable(tt.getToolDurable());// 耐用度
            tth.setToolSharpennum(tt.getToolDurable());// 可使用(刃磨)次数
            tth.setToolSharpenCriterion(tt.getToolSharpenCriterion());// 复磨标准
            tth.setToolLength(tt.getToolLength());// 刀具长度
            tth.setToolSharpenLength(tt.getToolSharpenLength());// 可刃磨长度
            tth.setUsageCounter(tt.getUsageCounter());// 已使用(刃磨)次数
            tth.setToolGrindingLength(tt.getToolGrindingLength());// 刀具已刃磨长度
            tth.setInstallationState(IConstant.INSTALLATION_STATE_0);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
            tth.setToolState(IConstant.TOOL_STATE_4);// 刀具状态(0断刀1丢失2不合格3借入4申领9其他)
            tth.setoutUser(tt.getUpdateUser());// 转出人
            tth.setinUser(gruantUserID);// 接收人
            tth.setStockState(IConstant.STOCK_STATE_1);//报废
            tth.setUpdateTime(new Date());// 更新时间
            tth.setUpdateUser(gruantUserID);// 更新者
            tth.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
            tth.setCreateTime(new Date());// 创建时间
            tth.setCreateUser(userId);// 创建者
            tth.setVersion(BigDecimal.ZERO);// 版本号
            tthList.add(tth);

        }

        // 刀具出库
        List<String> delList = new ArrayList<String>();
        List<Toollibraryhistory> tlhList = new ArrayList<Toollibraryhistory>();
        Toollibraryhistory tlh = null;
        Rfidcontainer prf = null;
        // 新库加入中刀具流转（新刀）
        for (Knifeinventory ki1 : itList) {
            delList.add(ki1.getKnifeInventoryCode());// 加入删除刀具入库编码
            // 记录生命周期
            toolwholelifecycle = new Toolwholelifecycle();
            toolwholelifecycle.setBusinessFlowLnkID(businessFlowLnkID);
            toolwholelifecycle.setHandSetID(handId);
            // 取得刀具信息
            Tool tool = new Tool();
            tool.setToolID(ki1.getToolID());
            List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
            if (toolList != null && toolList.size() > 0) {
                tool = toolList.get(0);
                toolwholelifecycle.setToolCode(tool.getToolCode());
                toolwholelifecycle.setToolName(tool.getToolName());
            }
            toolwholelifecycle.setKnifeInventoryCode(ki1.getKnifeInventoryCode());
            toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
            toolwholelifecycle.setCreateTime(new Date());
            toolwholelifecycle.setUpdateTime(new Date());
            toolwholelifecycle.setCreateUser(userId);
            toolwholelifecycle.setUpdateUser(gruantUserID);
            toolwholelifecycle.setVersion(BigDecimal.ZERO);
            String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue(IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, userId);
            toolwholelifecycle.setToolWholeLifecycleID(toolWholeLifecycleID);
            tlcList.add(toolwholelifecycle);
            // 刀具流转
            tt1 = new Tooltransfer();
            prf = new Rfidcontainer();
            prf.setRfidContainerIDWhere(ki1.getRfidContainerID());
            prf.setDelFlagWhere(IConstant.DEL_FLAG_0);
            prf.setQueryType(IConstant.QUERY_TYPE_1);
            reVal += rfidcontainerDao.updateNonQuery(prf);
            tt1.setRfidContainerID(ki1.getRfidContainerID());
            tt1.setKnifeInventoryCode(ki1.getKnifeInventoryCode());
            tt1.setToolID(ki1.getToolID());
            //tt1.setProcuredBatch(ki1.getToolProcuredID());
            tt1.setBusinessFlowLnkID(businessFlowLnkID);// 最后流程
           // tt1.setToolDurable(tool.getToolDurable());
            tt1.setToolSharpennum(tool.getToolSharpennum());// 刃磨次数
            tt1.setToolSharpenCriterion(tool.getToolSharpenCriterion());
            tt1.setToolLength(tool.getToolLength());
            tt1.setToolSharpenLength(tool.getToolSharpenLength());
            tt1.setUsageCounter(BigDecimal.ZERO);// 已使用(刃磨)次数
            tt1.setToolGrindingLength(BigDecimal.ZERO);// 刀具已刃磨长度
            tt1.setInstallationState(IConstant.INSTALLATION_STATE_0);
            tt1.setToolState(IConstant.TOOL_STATE_4);
            tt1.setReplacementFlag(appliendReason);
            tt1.setConfirmedUser(gruantUserID);
            tt1.setStockState(IConstant.STOCK_STATE_1);//报废
            tt1.setDelFlag(IConstant.DEL_FLAG_0);
            tt1.setUpdateTime(new Date());
            tt1.setUpdateUser(gruantUserID);
            tt1.setCreateTime(new Date());
            tt1.setCreateUser(gruantUserID);
            tt1.setVersion(BigDecimal.ZERO);
            ttList1.add(tt1);

            // 刀具流转履历
            tth = new Tooltransferhistory();
            tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(IConstant.TOOLTRANSFERHISTORY, IConstant.TOOLTRANSFERHISTORYID, userId));
            tth.setRfidContainerID(ki1.getRfidContainerID()); // RFID载体ID
            tth.setKnifeInventoryCode(ki1.getKnifeInventoryCode());// 刀具入库编码
            tth.setToolID(ki1.getToolID());// 刀具ID
           // tth.setToolProcuredID(ki1.getToolProcuredID());// 采购ID
            tth.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程(刀具安上)
            tth.setToolDurable(ki1.getToolDurable());// 耐用度
            tth.setToolSharpennum(ki1.getToolDurable());// 可使用(刃磨)次数
            tth.setToolSharpenCriterion(ki1.getToolSharpenCriterion());// 复磨标准
            tth.setToolLength(ki1.getToolLength());// 刀具长度
            tth.setToolSharpenLength(ki1.getToolSharpenLength());// 可刃磨长度
            tth.setUsageCounter(BigDecimal.ZERO);// 已使用(刃磨)次数
            tth.setToolGrindingLength(BigDecimal.ZERO);// 刀具已刃磨长度
            tth.setInstallationState(IConstant.INSTALLATION_STATE_1);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
            tth.setToolState(IConstant.TOOL_STATE_4);// 刀具状态(0断刀1丢失2不合格3借入4申领9其他)
            tth.setoutUser(userId);// 转出人
            tth.setStockState(IConstant.STOCK_STATE_1);//报废
            tth.setinUser(gruantUserID);// 接收人
            tth.setUpdateTime(new Date());// 更新时间
            tth.setUpdateUser(gruantUserID);// 更新者
            tth.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
            tth.setCreateTime(new Date());// 创建时间
            tth.setCreateUser(gruantUserID);// 创建者
            tth.setVersion(BigDecimal.ZERO);// 版本号
            tthList.add(tth);

            // 刀具出库履历
            tlh = new Toollibraryhistory();
            tlh.setKnifeInventoryCode(ki1.getKnifeInventoryCode());// 刀具入库编码
            tlh.setReceiveUser(gruantUserID);// 领取人
            tlh.setReceiveTime(recederTime);// 领取时间
            tlh.setLibraryCause(IConstant.LIBRARY_CAUSE_0);// 出库原因(0申领1换领2外借)
            tlh.setUpdateTime(new Date());// 更新时间
            tlh.setUpdateUser(gruantUserID);// 更新者
            tlh.setCreateTime(new Date());// 创建时间
            tlh.setCreateUser(userId);// 创建者
            tlh.setVersion(BigDecimal.ZERO);// 版本号
            tlh.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分(0有效1删除)
            tlhList.add(tlh);
            Knifeinventory ki2 = new Knifeinventory();
            ki2.setKnifeInventoryCodeWhere(ki1.getKnifeInventoryCode());
            ki2.setKnifeInventoryType(IConstant.KNIFE_INVENTORY_TYPE_9);
            ki2.setDelFlag(IConstant.DEL_FLAG_1);
            knifeinventoryDao.updateNonQuery(ki2); // 更新刀库表
        }
        // 增加刀具流转
        if (ttList1.size() > 0) {
            tooltransferDao.insertBatchs(ttList1);
        }
        // 增加生命周期
        if (tlcList.size() > 0) {
            toolwholelifecycleDao.insertBatchs(tlcList);
        }
        // 批量增加【刀具流转履历】
        if (tthList.size() > 0) {
            tooltransferhistoryDao.insertBatchDefined(tthList);
        }
        // 添加出库履历
        if (tlhList.size() > 0) {
            toollibraryhistoryDao.insertBatchs(tlhList);
        }
        //添加申领申请表
        for (Replacement replacement : replacementList) {
            replacementDao.insert(replacement);
        }
        if (delList.size() > 0) {
            map = new HashMap<String, Object>();
            map.put("updateTime", new Date());
            map.put("userId", userId);
            map.put("list", delList);
            reVal += knifeinventoryDao.deleteToolByknifeCode(map);
        }
        return reVal;
    }

    @Override
    public Replacement searchUserExitq(Replacement entity) throws Exception {
        try {
            List<Replacement> list = (List<Replacement>) replacementDao
                    .searchByList(entity);
            if (list == null || list.size() <= 0) {
                // 您所查询的RFID类型不存在!
                Replacement userdetail = new Replacement();
                userdetail.setMessageCode(IConstant.WMSG0122);
                userdetail.setRetErrFlag(true);
                return userdetail;
            } else {
                return list.get(0);
            }

        } catch (SQLException e) {
            // 数据库操作异常，查询失败!
            Replacement userdetail = new Replacement();
            userdetail.setMessageCode(IConstant.EMSG0004);
            userdetail.setRetErrFlag(true);
            userdetail.setExceMessage(e.getMessage());
            return userdetail;
        }
    }

    @Override
    public List<Vreplacement> saveOutputStockingTool(Vreplacement entity) throws Exception {
        return (List<Vreplacement>) vreplacementDao.searchByList(entity);
    }


    /**
     * 取得补领出库申请列表
     * getReplacementList
     *
     * @param 
     * @return
     * @throws Exception
     */
	@Override
	public Map<String, Object> getReplacementList() throws Exception {
		Map<String, Object> ret = new HashMap<String, Object>();
		try {
			Replacement entity = new Replacement();
			List<Replacement> list = replacementDao.getReplacementList(entity);
			if (list == null || list.size() <= 0) {
				// 查无补领申请
				ret.put("MessageCode", IConstant.EMSG0004);
				ret.put("status", IConstant.RESULT_CODE_1);
				return ret;
			} else {
				ret.put("data", list);
				ret.put("status", IConstant.RESULT_CODE_0);
				return ret;
			}
		} catch (SQLException e) {
			ret.put("status", IConstant.RESULT_CODE_2);
			ret.put("MessageCode", IConstant.EMSG0004); // 数据库操作异常,查询失败!
			ret.put("ExceMessage", e.getMessage());
			return ret;
		}
	}

	 /**
     * 取得补领出库申请单信息
     * getReplacementApply
     *
     * @param 
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getReplacementApply(Map<String, Object> map) throws Exception {
		Map<String, Object> ret = new HashMap<String, Object>();
		// 时间格式化
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// 补领原因为补充周转量或特殊领用
			// 申请人名称
			String applyUser = map.get("applyUser").toString();
			// 申请时间
			String applyTime = map.get("applyTime").toString();
			// 查询补领申请表
			Replacement raentity = new Replacement();
			// 申请人名称
			raentity.setApplyUser(applyUser);
			// 申请时间
			raentity.setApplyTime(format.parse(applyTime));
			// 删除区分(0有效1删除)
			raentity.setDelFlag(IConstant.DEL_FLAG_0);
			List<Replacement> list =  replacementDao.getReplacementApply(raentity);
			if (list.size()<=0) {
				// 补领原因为借用
				raentity = new Replacement();
				// 申请人名称
				raentity.setApplyID(applyUser);
				// 申请时间
				raentity.setApplyTime(format.parse(applyTime));
				// 删除区分(0有效1删除)
				raentity.setDelFlag(IConstant.DEL_FLAG_0);
				List<Replacement> list2 =  replacementDao.getReplacementApplyElse(raentity);
				if (list2.size()>0) {
					ret.put("data", list2);
				}
			}else {
				ret.put("data", list);
			}
			ret.put("status", IConstant.RESULT_CODE_0);
			return ret;
		} catch (SQLException e) {
			ret.put("status", IConstant.RESULT_CODE_2);
			ret.put("MessageCode", IConstant.EMSG0004); // 数据库操作异常,查询失败!
			ret.put("ExceMessage", e.getMessage());
			return ret;
		}
	}

	/**
     * 提交补领出库的刀具信息
     * saveReplacementapplyInfo
     *
     * @param 
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> saveReplacementapplyInfo(
			List<Map<String, Object>> toolList) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		Toolwholelifecycle twl = null;
		List<Toolwholelifecycle> twlList = new ArrayList<Toolwholelifecycle>();
		List<Replacement> redempList = new ArrayList<Replacement>();
		int count = 0;
		int ccount = 0;
		String userID = null;
		String gruantUserID = null;
		String signID = null;
		String toolID = null;
		String rfidContainerID = null;
		String rfidCode = null;
		String replacementNumber = null;
		String toolCode = null;
		// 根据材料号查找对应的刀具消耗类别
		String toolConsumetype = null;
        Date recederTime = new Date ();

		for (Map<String, Object> map : toolList) {
			userID = map.get("CustomerID").toString();
			gruantUserID = map.get("gruantUserID").toString();
			signID = map.get("SignID").toString();
			toolID = map.get("ToolID").toString();
			rfidContainerID = map.get("RfidContainerID").toString();
			rfidCode = map.get("RfidCode").toString();
			replacementNumber = map.get("ReplacementNumber").toString();
			// 材料号
			toolCode = map.get("MaterialNum").toString();
			Tool tool = new Tool();
			tool.setToolCode(toolCode);
			tool.setDelFlag(IConstant.STRING_0);
			List<Tool> tList = (List<Tool>) toolDao.searchByList(tool);
			if (tList.size()>0){
				toolConsumetype = tList.get(0).getToolConsumetype();
			}
			// 取得补领申请的信息
			Replacement reentity = new Replacement();
			// 补领单号
			reentity.setReplacementID(replacementNumber);
			//刀具编码
			reentity.setToolCode(toolCode);
			reentity.setDelFlag(IConstant.DEL_FLAG_0);
			redempList = (List<Replacement>) replacementDao.searchByList(reentity);
            count =Integer.parseInt(map.get("AppliedNumber").toString());
            ccount = 0;
            if (!IConstant.STRING_0.equals(toolConsumetype)) {
				//刀片
            	ccount = Integer.parseInt(String.valueOf(map.get("ReceiveCount")));
			}
			
			// 如果补领原因是补充周转量
			if ("1".equals(redempList.get(0).getReplacementReason())) {
				// 增加备刀库周转量
				if (!IConstant.STRING_0.equals(toolConsumetype)) {
					//刀片（更新操作）
					//查询装备用刀容器的载体id
					Containercarrier cc = new Containercarrier();
					//备用刀
					cc.setContainerCarrierType(IConstant.STRING_0);
					cc.setDelFlag(IConstant.STRING_0);
					List<Containercarrier> ccList = (List<Containercarrier>) containercarrierDao.searchByList(cc);
					if (ccList.size()>0) {
						//更新或插入流转表
						//先查询原有的周转量
						Tooltransfer tt = new Tooltransfer();
						tt.setRfidContainerID(ccList.get(0).getRfidContainerID());
						tt.setToolID(toolID);
						tt.setToolState(IConstant.STRING_4);
						tt.setDelFlag(IConstant.STRING_0);
						List<Tooltransfer> ttList = (List<Tooltransfer>) tooltransferDao.searchByList(tt);
						if (ttList.size()>0) {
							//更新流转表
							//原有数量
							BigDecimal number = ttList.get(0).getToolDurable();
							tt.setRfidContainerIDWhere(ccList.get(0).getRfidContainerID());
							tt.setToolIDWhere(toolID);
							tt.setToolStateWhere(IConstant.STRING_4);
							tt.setDelFlagWhere(IConstant.STRING_0);
							tt.setToolDurable(number.add(new BigDecimal(ccount)));
							tooltransferDao.updateNonQuery(tt);
						}else {
							//插入流转表
							//刀具入库编码
							tt.setKnifeInventoryCode(UUIDgen.getId());
							//最后流程
							tt.setBusinessFlowLnkID(IConstant.C01S004);
							//数量
							tt.setToolDurable(new BigDecimal(ccount));
							//刀具安装合成刀状态(0未安装1已安装2卸下9其他)
							tt.setInstallationState(IConstant.STRING_0);
							//刀具部门(0库存,1对刀室,2刃磨室,3,车间4,初始化
							tt.setToolThisState(IConstant.STRING_1);
							//库存状态(0正常1报废2返厂3封存4.流转9其他)
							tt.setStockState(IConstant.STRING_4);
							tt.setCreateTime(new Date());
							tt.setCreateUser(userID);
							tt.setUpdateTime(new Date());
							tt.setUpdateUser(userID);
							tt.setDelFlag(IConstant.STRING_0);
							tt.setVersion(BigDecimal.ONE);
							tooltransferDao.insert(tt);
						}
					}else {
						result.put("status", IConstant.STRING_1);
				        // 请初始化备用刀容器！
				        result.put("messagetext", "请初始化备用刀容器后再执行补领出库");
				        return result;
					}
				}else {
					//钻头（插入操作）
					Rfidcontainer r = new Rfidcontainer();
					r.setRfidCode(rfidCode);
					r.setDelFlag(IConstant.STRING_0);
					//载体id
					String rfidcontainerID = ((List<Rfidcontainer>)rfidcontainerDao.searchByList(r)).get(0).getRfidContainerID();
					//插入到流转表
					Tooltransfer tt = new Tooltransfer();
					tt.setRfidContainerID(rfidcontainerID);
					//获取刀具入库编码
					Knifeinventory k = new Knifeinventory();
					k.setRfidContainerID(rfidcontainerID);
					k.setDelFlag(IConstant.STRING_0);
					List<Knifeinventory> kiList = (List<Knifeinventory>) knifeinventoryDao.searchByList(k);
					if (kiList.size()>0) {
						tt.setKnifeInventoryCode(kiList.get(0).getKnifeInventoryCode());
					}else {
						tt.setKnifeInventoryCode("");
					}
					tt.setToolID(toolID);//刀具id
					tt.setBusinessFlowLnkID(IConstant.C01S004);//最后流程
					tt.setToolDurable(new BigDecimal(IConstant.STRING_1));//数量
					tt.setToolState(IConstant.STRING_4);//待换装
					tt.setToolThisState(IConstant.STRING_1);//刀具部门：对刀室
					tt.setStockState(IConstant.STRING_4);//流转
					tt.setDelFlag(IConstant.STRING_0);
					tt.setCreateTime(new Date());
					tt.setCreateUser(userID);
					tt.setUpdateTime(new Date());
					tt.setUpdateUser(userID);
					tooltransferDao.insert(tt);
				}
			}else {
				// 补领原因为借用或特殊领用，则出库报废
				// 插入到报废表中
				Scrap scrap = new Scrap();
				// 报废ID
				scrap.setScrapID(UUIDgen.getId());
				// 刀具类型
				scrap.setToolType(toolConsumetype);
				// 流程id
				scrap.setBusinessID(IConstant.C01S004);
				// 材料号
				scrap.setMaterial(toolCode);
				// 刀具id
				scrap.setToolID(toolID);
				// 报废数量
				if (!IConstant.STRING_0.equals(toolConsumetype)) {
					// 刀片
					scrap.setScrapNumber(new BigDecimal (ccount ));
				} else {
					// 钻头
					scrap.setScrapNumber(BigDecimal.ONE);
				}
				// 报废状态：出库报废
				scrap.setScrapState(IConstant.STRING_3);
				// 报废时间
				scrap.setScrapTime(new Date());
				// 授权人id
				scrap.setAuthorizationID(gruantUserID);
				// 创建者
				scrap.setCreateUser(userID);
				// 创建时间
				scrap.setCreateTime(new Date());
				// 更新者
				scrap.setUpdateUser(userID);
				// 更新时间
				scrap.setUpdateTime(new Date());
				// 删除区分
				scrap.setDelFlag(IConstant.STRING_0);
				scrapDao.insert(scrap);
			}
			
			// 刀具入库编码
			String knifeCode = null;
			
			// 减少库存量
			if (!IConstant.STRING_0.equals(toolConsumetype)) {
				//刀片
				Rfidcontainer r = new Rfidcontainer();
				r.setRfidCode(rfidCode);
				r.setDelFlag(IConstant.STRING_0);
				//载体id
				String rfidcontainerID = ((List<Rfidcontainer>)rfidcontainerDao.searchByList(r)).get(0).getRfidContainerID();
				//在新刀库存表中查询当前库位标签的库存量
				Knifeinventory k = new Knifeinventory();
				k.setRfidContainerID(rfidcontainerID);
				k.setDelFlag(IConstant.STRING_0);
				List<Knifeinventory> kiList = (List<Knifeinventory>) knifeinventoryDao.searchByList(k);
				if (kiList.size()>0) {
					String number = kiList.get(0).getKnifelnventoryNumber();
					//更新库存表
					k.setRfidContainerIDWhere(rfidcontainerID);
					k.setDelFlagWhere(IConstant.STRING_0);
					//剩余库存量
					k.setKnifelnventoryNumber((Integer.parseInt(number)-ccount)+"");
					knifeinventoryDao.updateNonQuery(k);
					
					//刀具入库编码
					knifeCode = kiList.get(0).getKnifeInventoryCode();
				}
				
			}else {
				//钻头
				Rfidcontainer r = new Rfidcontainer();
				r.setRfidCode(rfidCode);
				r.setDelFlag(IConstant.STRING_0);
				//载体id
				String rfidcontainerID = ((List<Rfidcontainer>)rfidcontainerDao.searchByList(r)).get(0).getRfidContainerID();
				//在新刀库存表中更新当前单品刀标签的库存状态（删除区分置为1）
				Knifeinventory k = new Knifeinventory();
				k.setRfidContainerID(rfidcontainerID);
				k.setDelFlag(IConstant.STRING_0);
				List<Knifeinventory> kiList = (List<Knifeinventory>) knifeinventoryDao.searchByList(k);
				if (kiList.size()>0) {
					//更新库存表
					k.setRfidContainerIDWhere(rfidcontainerID);
					k.setDelFlagWhere(IConstant.STRING_0);
					k.setDelFlag(IConstant.STRING_1);
					knifeinventoryDao.updateNonQuery(k);
					
					//刀具入库编码
					knifeCode = kiList.get(0).getKnifeInventoryCode();
				}
				
				// 建立刀具生命周期
				twl = new Toolwholelifecycle();
				// 刀具全生命周期id
				twl.setToolWholeLifecycleID(UUIDgen.getId());
				// 刀具入库编码
				twl.setKnifeInventoryCode(knifeCode);
				// 流程id
				twl.setBusinessFlowLnkID(IConstant.C01S004);
				// 手持机id
				twl.setHandSetID(map.get("HandSetID").toString());
				// 刀具id
				twl.setToolID(toolID);
				//零部件id
				twl.setPartsID("");
                //加工数量
				twl.setProcessAmount("0");
                //删除区分(0有效1删除)
				twl.setDelFlag(IConstant.DEL_FLAG_0);
                //更新时间
				twl.setUpdateTime(new Date());
                //更新者
				twl.setUpdateUser(userID);
                //创建时间
				twl.setCreateTime(new Date());
                //创建者
				twl.setCreateUser(userID);
                //刃磨次数
				twl.setVersion(BigDecimal.ZERO);
                twlList.add(twl);
			}
			
			//更改补领单刀片的数量
			if(redempList.size() > 0&&!IConstant.STRING_0.equals(toolConsumetype)){
				Replacement redempentity = new Replacement();
				redempentity.setReplacementIDWhere(redempList.get(0).getReplacementID());
				redempentity.setToolCodeWhere(toolCode);
				//申请数量
				redempentity.setAppliedNumber(new BigDecimal(count - ccount));
				//领取人
				redempentity.setReceiveUser(signID);
				redempentity.setReceiveTime(recederTime);
	            if (count-ccount==0) {
					//全部补领完毕
	            	redempentity.setDelFlag(IConstant.STRING_1);
				}
	            redempentity.setUpdateTime(new Date());
	            redempentity.setUpdateUser(userID);
				replacementDao.updateNonQuery(redempentity);
			}//更改补领单中钻头的数量
			 else if(redempList.size() > 0&&IConstant.STRING_0.equals(toolConsumetype)){
				Replacement redempentity = new Replacement();
				redempentity.setReplacementIDWhere(redempList.get(0).getReplacementID());
				redempentity.setToolCodeWhere(toolCode);
				//申请数量
				redempentity.setAppliedNumber(new BigDecimal(count - 1));
				//领取人
				redempentity.setReceiveUser(signID);
				redempentity.setReceiveTime(recederTime);
	            if (count-1==0) {
					//全部补领完毕
	            	redempentity.setDelFlag(IConstant.STRING_1);
				}
	            redempentity.setUpdateTime(new Date());
	            redempentity.setUpdateUser(userID);
				replacementDao.updateNonQuery(redempentity);
				
				//修改从前台传过来的list，for循环处理完一个钻头，则将其申请数量减1
				for (Map<String, Object> mapList : toolList) {
					if (toolCode.equals(mapList.get("MaterialNum"))) {
						mapList.put("AppliedNumber", (Integer.parseInt((String)mapList.get("AppliedNumber"))-1)+"");
					}
				}
			}
			
			// 建立刀具出库履历
			Toollibraryhistory tlentity = new Toollibraryhistory();
			// 出库履历id
			tlentity.setToolLiberyID(UUIDgen.getId());
			// 刀具入库编码
			tlentity.setKnifeInventoryCode(knifeCode);
			// 刀具id
			tlentity.setToolID(map.get("ToolID").toString());
			// 领取人
			tlentity.setReceiveUser(signID);
			// 领取数量
			if (!IConstant.STRING_0.equals(toolConsumetype)) {
				//刀片
				tlentity.setReceiveCount(new BigDecimal(ccount));
			}else {
				tlentity.setReceiveCount(BigDecimal.ONE);
			}
			// 领取时间
			tlentity.setReceiveTime(recederTime);
			// 出库原因(0申领1换领2外借)
			tlentity.setLibraryCause(IConstant.DEL_FLAG_0);
			tlentity.setCreateTime(new Date());
			tlentity.setCreateUser(userID);
			tlentity.setUpdateTime(new Date());
			tlentity.setUpdateUser(userID);
			tlentity.setVersion(BigDecimal.ONE);
			tlentity.setDelFlag(IConstant.DEL_FLAG_0);
			toollibraryhistoryDao.insert(tlentity);
		}
		
		if (twlList.size()>0) {
			toolwholelifecycleDao.insertBatchs(twlList);
		}
        result.put("status", IConstant.RESULT_CODE_0);
        // 入库成功！
        result.put("messagetext", IConstant.WMSG0227);
		return result;
	}

	@Override
	public List<Replacement> getToolCode(Replacement entity) throws Exception {
		List<Replacement> list = (List<Replacement>) replacementDao.searchByList(entity);
		return list;
	}

}
