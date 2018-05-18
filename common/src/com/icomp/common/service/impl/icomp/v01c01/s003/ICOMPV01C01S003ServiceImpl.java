package com.icomp.common.service.impl.icomp.v01c01.s003;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s003.ICOMPV01C01S003Service;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.common.utils.UUIDgen;
import com.icomp.dao.BusinessDao;
import com.icomp.dao.BusinessflowlnkDao;
import com.icomp.dao.ContainercarrierDao;
import com.icomp.dao.KnifeinventoryDao;
import com.icomp.dao.LedplaneDao;
import com.icomp.dao.RedemptionappliedDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.ToolDao;
import com.icomp.dao.ToollibraryhistoryDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.TooltransferhistoryDao;
import com.icomp.dao.ToolwholelifecycleDao;
import com.icomp.dao.UserdetailDao;
import com.icomp.dao.VbusinessDao;
import com.icomp.dao.VgetredemptionappdetailedmsgDao;
import com.icomp.dao.VgetshelfinformationDao;
import com.icomp.dao.VledplanelistDao;
import com.icomp.dao.VquerytoollistDao;
import com.icomp.dao.VredemptionappdetailedmsgnewDao;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Businessflowlnk;
import com.icomp.entity.base.Containercarrier;
import com.icomp.entity.base.Knifeinventory;
import com.icomp.entity.base.Ledplane;
import com.icomp.entity.base.Redemptionapplied;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Toollibraryhistory;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Tooltransferhistory;
import com.icomp.entity.base.Toolwholelifecycle;
import com.icomp.entity.base.Vbusiness;
import com.icomp.entity.base.Vgetredemptionappdetailedmsg;
import com.icomp.entity.base.Vgetshelfinformation;
import com.icomp.entity.base.Vledplanelist;
import com.icomp.entity.base.Vquerytoollist;
import com.icomp.entity.base.Vredemptionappdetailedmsgnew;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 刀具换领-Serbice实现类
 * 
 * @author Taoyy
 * @ClassName: ICOMPV01C01S003ServiceImpl
 * @date 2016-3-4 下午05:27:15
 */
@SuppressWarnings("unchecked")
public class ICOMPV01C01S003ServiceImpl extends BaseService implements
		ICOMPV01C01S003Service {

	// 用户明细Dao
	private UserdetailDao userdetailDao;

	public void setUserdetailDao(UserdetailDao userdetailDao) {
		this.userdetailDao = userdetailDao;
	}

	// 换领申请Dao
	private RedemptionappliedDao redemptionappliedDao;
	// 取得换领申请单明细Dao
	private VgetredemptionappdetailedmsgDao vgetredemptionappdetailedmsgDao;
	// 取得货架信息Dao
	private VgetshelfinformationDao vgetshelfinformationDao;
	// 刀具流转
	private TooltransferDao tooltransferDao;
	// 刀具流转履历
	private TooltransferhistoryDao tooltransferhistoryDao;
	// 载体rfid
	private RfidcontainerDao rfidcontainerDao;
	// 新库
	private KnifeinventoryDao knifeinventoryDao;
	// 流程Id
	private VbusinessDao vbusinessDao;
	// 取得当前刀具的最后执行业务流程Dao
	private BusinessflowlnkDao businessflowlnkDao;
	// 取得业务流程Dao
	private BusinessDao businessDao;
	// 刀具参数Dao
	private ToolDao toolDao;
	// 生命周期Dao
	private ToolwholelifecycleDao toolwholelifecycleDao;

	private VledplanelistDao vledplanelistDao;
	// 出库履历
	private ToollibraryhistoryDao toollibraryhistoryDao;

	public void setVledplanelistDao(VledplanelistDao vledplanelistDao) {
		this.vledplanelistDao = vledplanelistDao;
	}

	private LedplaneDao ledplaneDao;

	public void setLedplaneDao(LedplaneDao ledplaneDao) {
		this.ledplaneDao = ledplaneDao;
	}

	private VquerytoollistDao vquerytoollistDao;

	public void setVquerytoollistDao(VquerytoollistDao vquerytoollistDao) {
		this.vquerytoollistDao = vquerytoollistDao;
	}

	private VredemptionappdetailedmsgnewDao vredemptionappdetailedmsgnewDao;

	public void setVredemptionappdetailedmsgnewDao(
			VredemptionappdetailedmsgnewDao vredemptionappdetailedmsgnewDao) {
		this.vredemptionappdetailedmsgnewDao = vredemptionappdetailedmsgnewDao;
	}
	
	private ContainercarrierDao containercarrierDao;

	public void setContainercarrierDao(ContainercarrierDao containercarrierDao) {
		this.containercarrierDao = containercarrierDao;
	}
	
	/**
	 * 专机领取保存
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 *             C01S023Respons
	 * @title getToolInfo
	 */
	public int saveLedplane(Map<String, Object> map) throws Exception {
		int reVal = 0;
		Map<String, Object> ret = new HashMap<String, Object>();
		List<String> rfidList = (List<String>) map.get("rfidlist");// 扫描的rfidlist
		List<Ledplane> ledplanes = (List<Ledplane>) map.get("ledplaneList");// 要提交的数据
		String confirmID = map.get("gruantUserID").toString();// 确认人ID
		String handId = map.get("handId").toString();// 手持机ID
		String userId = map.get("userId").toString();// 用户ID
		List<String> itRfidList = new ArrayList<String>();
		List<String> ttRfidList = new ArrayList<String>();
		List<Tooltransfer> ttList = new ArrayList<Tooltransfer>();
		List<Knifeinventory> itList = new ArrayList<Knifeinventory>();
		List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory>();
		Rfidcontainer rf = null;
		// 查询方式(0库存1流转)
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
		String businessFlowLnkID = null;
		// 取得业务流程ID
		Business business = new Business();
		business.setBusinessCode("C01S003");
		List<Business> businessList = (List<Business>) businessDao
				.searchByList(business);
		business = businessList.get(0);
		Businessflowlnk businessflowlnks = new Businessflowlnk();
		businessflowlnks.setBusinessID(business.getBusinessID());
		List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao
				.searchByList(businessflowlnks);
		// 当前流程
		businessFlowLnkID = list1.get(0).getBusinessFlowLnkID();
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
			toolwholelifecycle
					.setKnifeInventoryCode(tt.getKnifeInventoryCode());
			toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
			toolwholelifecycle.setCreateTime(new Date());
			toolwholelifecycle.setUpdateTime(new Date());
			toolwholelifecycle.setCreateUser(userId);
			toolwholelifecycle.setUpdateUser(userId);
			toolwholelifecycle.setVersion(BigDecimal.ZERO);
			String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue(
					IConstant.TOOLWHOLELIFECYCLE,
					IConstant.TOOLWHOLELIFECYCLEID, userId);
			toolwholelifecycle.setToolWholeLifecycleID(toolWholeLifecycleID);
			tlcList.add(toolwholelifecycle);

			// 刀具流转履历
			tth = new Tooltransferhistory();
			tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(
					IConstant.TOOLTRANSFERHISTORY,
					IConstant.TOOLTRANSFERHISTORYID, userId));
			tth.setRfidContainerID(tt.getRfidContainerID()); // RFID载体ID
			tth.setKnifeInventoryCode(tt.getKnifeInventoryCode());// 刀具入库编码
			tth.setToolID(tt.getToolID());// 刀具ID
			tth.setToolProcuredID(tt.getProcuredBatch());// 采购ID
			tth.setBusinessFlowLnkID(tt.getBusinessFlowLnkID());// 最后执行业务流程(刀具安上)
			tth.setToolDurable(tt.getToolDurable());// 耐用度
			tth.setToolSharpennum(tt.getToolDurable());// 可使用(刃磨)次数
			tth.setToolSharpenCriterion(tt.getToolSharpenCriterion());// 复磨标准
			tth.setToolLength(tt.getToolLength());// 刀具长度
			tth.setToolSharpenLength(tt.getToolSharpenLength());// 可刃磨长度
			tth.setUsageCounter(tt.getUsageCounter());// 已使用(刃磨)次数
			tth.setToolGrindingLength(tt.getToolGrindingLength());// 刀具已刃磨长度
			tth.setInstallationState(IConstant.INSTALLATION_STATE_2);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
			tth.setToolState(IConstant.TOOL_STATE_9);// 刀具状态(0断刀1丢失2不合格3借入4申领9其他)
			tth.setStockState(IConstant.STOCK_STATE_1); // 报废
			tth.setoutUser(confirmID);// 转出人
			tth.setinUser(userId);// 接收人
			tth.setUpdateTime(new Date());// 更新时间
			tth.setUpdateUser(userId);// 更新者
			tth.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
			tth.setCreateTime(new Date());// 创建时间
			tth.setCreateUser(userId);// 创建者
			tth.setVersion(BigDecimal.ZERO);// 版本号
			tthList.add(tth);

		}

		List<String> delList = new ArrayList<String>();
		List<Toollibraryhistory> tlhList = new ArrayList<Toollibraryhistory>();
		Toollibraryhistory tlh = null;
		Rfidcontainer prf = null;
		// 新库加入中刀具流转（新刀）
		for (Knifeinventory ki1 : itList) {
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
			toolwholelifecycle.setKnifeInventoryCode(ki1
					.getKnifeInventoryCode());
			toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
			toolwholelifecycle.setCreateTime(new Date());
			toolwholelifecycle.setUpdateTime(new Date());
			toolwholelifecycle.setCreateUser(userId);
			toolwholelifecycle.setUpdateUser(userId);
			toolwholelifecycle.setVersion(BigDecimal.ZERO);
			String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue(
					IConstant.TOOLWHOLELIFECYCLE,
					IConstant.TOOLWHOLELIFECYCLEID, userId);
			toolwholelifecycle.setToolWholeLifecycleID(toolWholeLifecycleID);
			tlcList.add(toolwholelifecycle);
			// 刀具流转
			tt1 = new Tooltransfer();
			prf = new Rfidcontainer();
			prf.setRfidContainerIDWhere(ki1.getRfidContainerID());
			prf.setDelFlagWhere(IConstant.DEL_FLAG_0);
			prf.setQueryType(IConstant.QUERY_TYPE_1);
			int i = rfidcontainerDao.updateNonQuery(prf);
			tt1.setRfidContainerID(ki1.getRfidContainerID());
			tt1.setKnifeInventoryCode(ki1.getKnifeInventoryCode());
			tt1.setToolID(ki1.getToolID());
			tt1.setProcuredBatch(ki1.getProcuredBatch());
			tt1.setBusinessFlowLnkID(businessFlowLnkID);// 最后流程
			//tt1.setToolDurable(tool.getToolDurable());
			tt1.setToolSharpennum(tool.getToolSharpennum());// 刃磨次数
			tt1.setToolSharpenCriterion(tool.getToolSharpenCriterion());
			tt1.setToolLength(tool.getToolLength());
			tt1.setToolSharpenLength(tool.getToolSharpenLength());
			tt1.setUsageCounter(BigDecimal.ZERO);// 已使用(刃磨)次数
			tt1.setToolGrindingLength(BigDecimal.ZERO);// 刀具已刃磨长度
			tt1.setInstallationState(IConstant.INSTALLATION_STATE_0);
			tt1.setToolState(IConstant.TOOL_STATE_9);
			tt1.setReplacementFlag(null);
			tt1.setConfirmedUser(confirmID);
			tt1.setStockState(IConstant.STOCK_STATE_1);// 报废
			tt1.setDelFlag(IConstant.DEL_FLAG_0);
			tt1.setUpdateTime(new Date());
			tt1.setUpdateUser(userId);
			tt1.setCreateTime(new Date());
			tt1.setCreateUser(userId);
			tt1.setVersion(BigDecimal.ZERO);
			ttList1.add(tt1);

			// 刀具流转履历
			tth = new Tooltransferhistory();
			tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(
					IConstant.TOOLTRANSFERHISTORY,
					IConstant.TOOLTRANSFERHISTORYID, userId));
			tth.setRfidContainerID(ki1.getRfidContainerID()); // RFID载体ID
			tth.setKnifeInventoryCode(ki1.getKnifeInventoryCode());// 刀具入库编码
			delList.add(ki1.getKnifeInventoryCode());// 加入删除的RFID
			tth.setToolID(ki1.getToolID());// 刀具ID
			tth.setToolProcuredID(ki1.getProcuredBatch());// 采购ID
			tth.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程(刀具安上)
			tth.setToolDurable(ki1.getToolDurable());// 耐用度
			tth.setToolSharpennum(ki1.getToolDurable());// 可使用(刃磨)次数
			tth.setToolSharpenCriterion(ki1.getToolSharpenCriterion());// 复磨标准
			tth.setToolLength(ki1.getToolLength());// 刀具长度
			tth.setToolSharpenLength(ki1.getToolSharpenLength());// 可刃磨长度
			tth.setUsageCounter(BigDecimal.ZERO);// 已使用(刃磨)次数
			tth.setToolGrindingLength(BigDecimal.ZERO);// 刀具已刃磨长度
			tth.setInstallationState(IConstant.INSTALLATION_STATE_2);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
			tth.setToolState(IConstant.TOOL_STATE_9);// 刀具状态(0断刀1丢失2不合格3借入4申领9其他)
			tth.setStockState(IConstant.STOCK_STATE_1);// 报废
			tth.setoutUser(ki1.getUpdateUser());// 转出人
			tth.setinUser(confirmID);// 接收人
			tth.setUpdateTime(new Date());// 更新时间
			tth.setUpdateUser(userId);// 更新者
			tth.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
			tth.setCreateTime(new Date());// 创建时间
			tth.setCreateUser(userId);// 创建者
			tth.setVersion(BigDecimal.ZERO);// 版本号
			tthList.add(tth);

			// 刀具出库履历
			tlh = new Toollibraryhistory();
			tlh.setKnifeInventoryCode(ki1.getKnifeInventoryCode());// 刀具入库编码
			tlh.setReceiveUser(confirmID);// 领取人
			tlh.setReceiveTime(new Date());// 领取时间
			tlh.setLibraryCause(IConstant.LIBRARY_CAUSE_1);// 出库原因(0申领1换领2外借)
			tlh.setUpdateTime(new Date());// 更新时间
			tlh.setUpdateUser(userId);// 更新者
			tlh.setCreateTime(new Date());// 创建时间
			tlh.setCreateUser(userId);// 创建者
			tlh.setVersion(BigDecimal.ZERO);// 版本号
			tlh.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分(0有效1删除)
			tlhList.add(tlh);
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

		Map<String, Object> map2 = new HashMap<String, Object>();
		if (delList.size() > 0) {
			// 根据刀具入库编号删除出库的信息
			map2.put("userId", userId);
			map2.put("updateTime", new Date());
			map2.put("list", delList);
			knifeinventoryDao.deleteToolByknifeCode(map2);
		}
		if (ttRfidList.size() > 0) {
			// 更新刀具流转
			map2 = new HashMap<String, Object>();
			// map2.put("installationState", IConstant.INSTALLATION_STATE_2);
			map2.put("businessFlowLnkID", businessFlowLnkID);
			map2.put("userId", userId);
			map2.put("list", ttRfidList);
			tooltransferDao.updateBatchByRfid(map2);
		}
		Ledplane ledplane = null;
		for (Ledplane led : ledplanes) {
			ledplane = new Ledplane();
			ledplane.setLedPlaneIDWhere(led.getLedPlaneID());
			ledplane.setDelFlagWhere(IConstant.DEL_FLAG_0);
			ledplane.setConfirmUser(confirmID);
			ledplane.setReturnCount(led.getReturnCount());

			ledplane.setReturnTime(new Date());
			if (led.getLedPlaneCount() == null) {
				led.setLedPlaneCount(BigDecimal.ZERO);
			}
			if (led.getReturnCount() == null) {
				led.setReturnCount(BigDecimal.ZERO);
			}
			if (led.getLedPlaneCount().subtract(led.getReturnCount())
					.intValue() > 0) {
				ledplane.setLedPlaneStauts(IConstant.LEDPLANE_STAUTS_0); // 申请
			} else {
				ledplane.setLedPlaneStauts(IConstant.LEDPLANE_STAUTS_1);// 已领取
			}
			ledplane.setUpdateTime(new Date());
			ledplane.setUpdateUser(userId);
			reVal = ledplaneDao.updateNonQuery(ledplane);
		}
		return reVal;
	}

	@Override
	public List<Redemptionapplied> getRequestList() throws Exception {
		List<Redemptionapplied> list = new ArrayList<Redemptionapplied>();
		try {
			// 取得申请单数据
			list = (List<Redemptionapplied>) redemptionappliedDao
					.getRequestList();
			if (list == null || list.size() <= 0) {
				// 暂时没有要处理的数据!
				list = new ArrayList<Redemptionapplied>();
				Redemptionapplied reEentiy = new Redemptionapplied();
				reEentiy.setMessageCode(IConstant.WMSGC01S003_1);
				reEentiy.setRetErrFlag(true);
				list.add(reEentiy);
				return list;
			} else {
				return list;
			}
		} catch (SQLException e) {
			Redemptionapplied reEentiy = new Redemptionapplied();
			reEentiy.setMessageCode(IConstant.EMSG0004);
			reEentiy.setRetErrFlag(true);
			reEentiy.setExceMessage(e.getMessage());
			list.add(reEentiy);
			return list;
		}
	}

	/**
	 * 获取申请单列表详细信息_新
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public List<Vredemptionappdetailedmsgnew> getChoiceList(
			Vredemptionappdetailedmsgnew entity) {
		try {
			// 取得当前扫描刀具数据
			List<Vredemptionappdetailedmsgnew> list = (List<Vredemptionappdetailedmsgnew>) vredemptionappdetailedmsgnewDao
					.searchByList(entity);
			if (list == null || list.size() <= 0) {
				// 刀具信息快速查询未找到相应数据!
				list = new ArrayList<Vredemptionappdetailedmsgnew>();
				Vredemptionappdetailedmsgnew vquerytoollist = new Vredemptionappdetailedmsgnew();
				vquerytoollist.setMessageCode(IConstant.WMSG0150);
				vquerytoollist.setRetErrFlag(true);
				list.add(vquerytoollist);
				return list;
			} else {
				return list;
			}
		} catch (SQLException e) {
			List<Vredemptionappdetailedmsgnew> list = new ArrayList<Vredemptionappdetailedmsgnew>();
			Vredemptionappdetailedmsgnew vquerytoollist = new Vredemptionappdetailedmsgnew();
			vquerytoollist.setMessageCode(IConstant.EMSG0004);
			vquerytoollist.setRetErrFlag(true);
			vquerytoollist.setExceMessage(e.getMessage());
			list.add(vquerytoollist);
			return list;
		}
	}

	/**
	 * 备货信息提交_新
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public int stockMsgSubmit(Map<String, Object> map) throws Exception {
		int reVal = 0;
		String userID = map.get("userId").toString();
		List<Redemptionapplied> redeList = (List<Redemptionapplied>) map
				.get("reList");
		Redemptionapplied entity = null; // 参数
		Redemptionapplied tempred = null;// 临时参数
		for (Redemptionapplied ra : redeList) {
			entity = new Redemptionapplied();
			entity.setDelFlag(IConstant.DEL_FLAG_0);
			entity.setApplyTime(ra.getApplyTime());
			entity.setApplyUser(ra.getApplyUser());
			entity.setToolCode(ra.getToolCode());
			List<Redemptionapplied> findList = (List<Redemptionapplied>) redemptionappliedDao
					.searchByList(entity);
			if (findList.size() > 0) {
				tempred = findList.get(0);
				entity = new Redemptionapplied();
				entity.setToolCodeWhere(ra.getToolCode());// 刀具编码
				entity.setApplyUserWhere(ra.getApplyUser());// 申请人
				entity.setApplyTimeWhere(ra.getApplyTime());// 申请时间
				entity.setDelFlagWhere(IConstant.DEL_FLAG_0);
				entity.setStockNumber(ra.getStockNumber());
				if (ra.getRfidList() != null
						&& !"null".equals(ra.getRfidList())
						&& !"".equals(ra.getRfidList())) {
					if (tempred.getRfidList() != null
							&& !"".equals(tempred.getRfidList())) { // rfid
						entity.setRfidList(tempred.getRfidList() + ","
								+ ra.getRfidList());
					} else {
						entity.setRfidList(ra.getRfidList());
					}
				}
				entity.setUpdateTime(new Date());
				entity.setUpdateUser(userID);
				entity.setProcessingStatus(IConstant.PROCESSING_STATUS_1);
				entity.setVersion(tempred.getVersion().add(BigDecimal.ONE));
				reVal += redemptionappliedDao.updateNonQuery(entity);
			}
		}
		return reVal;
	}

	/**
	 * 领刀授权提交
	 * 
	 * @param map
	 * @return
	 */
	@Override
	public int saveGetChangeTool(Map<String, Object> map) throws Exception {
		List<String> delList = new ArrayList<String>();
		int reVal = 0;
		String userId = map.get("userId").toString();
		String handId = map.get("handerId").toString();
		String gruantUserID = map.get("gruantUserID").toString();
		List<Redemptionapplied> redeList = (List<Redemptionapplied>) map
				.get("reList");
		List<String> itRfidList = new ArrayList<String>();
		List<String> ttRfidList = new ArrayList<String>();
		List<Tooltransfer> ttList = new ArrayList<Tooltransfer>();
		List<Knifeinventory> itList = new ArrayList<Knifeinventory>();
		List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory>();
		List<Toollibraryhistory> tlhList = new ArrayList<Toollibraryhistory>();
		Redemptionapplied entity = null; // 参数
		Redemptionapplied tempred = null;// 临时参数
		Tooltransfer tt1 = null;
		List<Tooltransfer> ttList1 = new ArrayList<Tooltransfer>();
		List<Toolwholelifecycle> tlcList = new ArrayList<Toolwholelifecycle>();
		Tooltransferhistory tth = null;
		Toolwholelifecycle toolwholelifecycle = null;
		String businessFlowLnkID = null;
		// 取得业务流程ID
		Business business = new Business();
		business.setBusinessCode("C01S003");
		List<Business> businessList = (List<Business>) businessDao
				.searchByList(business);
		business = businessList.get(0);
		Businessflowlnk businessflowlnks = new Businessflowlnk();
		businessflowlnks.setBusinessID(business.getBusinessID());
		List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao
				.searchByList(businessflowlnks);
		if (list1 == null || list1.size() < 1) {
			return 0;
		}
		// 当前流程
		businessFlowLnkID = list1.get(0).getBusinessFlowLnkID();

		for (Redemptionapplied ra : redeList) {
			String rfids = null;
			entity = new Redemptionapplied();
			entity.setDelFlag(IConstant.DEL_FLAG_0);
			entity.setApplyTime(ra.getApplyTime());
			entity.setApplyUser(ra.getApplyUser());
			entity.setToolCode(ra.getToolCode());
			List<Redemptionapplied> findList = (List<Redemptionapplied>) redemptionappliedDao
					.searchByList(entity);
			if (findList.size() > 0) {
				tempred = findList.get(0);
				entity = new Redemptionapplied();
				entity.setToolCodeWhere(ra.getToolCode());// 刀具编码
				entity.setApplyUserWhere(ra.getApplyUser());// 申请人
				entity.setApplyTimeWhere(ra.getApplyTime());// 申请时间
				entity.setDelFlagWhere(IConstant.DEL_FLAG_0);
				entity.setStockNumber(BigDecimal.ZERO);
				if (tempred.getReceiveNumber().equals(BigDecimal.ZERO)) { // 实际领取数量
					entity.setReceiveNumber(ra.getReceiveNumber());
				} else {
					entity.setReceiveNumber(ra.getReceiveNumber().add(
							tempred.getReceiveNumber()));
				}
				rfids = tempred.getRfidList();
				entity.setUpdateTime(new Date());
				entity.setUpdateUser(userId);
				// 申请数量=领取数量(刚领取+已领取) = (送回数量+丢刀数量)
				if (tempred.getAppliedNumber().equals(
						ra.getReceiveNumber().add(tempred.getReceiveNumber()))
						&& tempred.getAppliedNumber().equals(
								tempred.getReturnNumber().add(
										tempred.getLostNumber()))) {
					entity.setProcessingStatus(IConstant.PROCESSING_STATUS_4); // 换领完成
				} else // 申请数量 > 领取数量 &&　申请数量＝（送回数量+丢刀数量）
				if (tempred.getAppliedNumber().intValue() > (ra
						.getReceiveNumber().add(tempred.getReceiveNumber())
						.intValue())
						&& tempred.getAppliedNumber().equals(
								tempred.getReturnNumber().add(
										tempred.getLostNumber()))) {
					entity.setProcessingStatus(IConstant.STSATIC_TWO); // 换领已送回
				} else // 申请数量 >(送回数量+丢刀数量)
				if (tempred.getAppliedNumber().intValue() > (tempred
						.getReturnNumber().add(tempred.getLostNumber())
						.intValue())) {
					entity.setProcessingStatus(IConstant.PROCESSING_STATUS_3); // 换领未送回
				}
				entity.setReceiveTime(new Date());
				entity.setReceiveUser(gruantUserID);
				entity.setVersion(tempred.getVersion().add(BigDecimal.ONE));
				if (rfids != null) {
					List<String> rfidList = new ArrayList<String>();
					rfidList = Arrays.asList(rfids.split(","));
					Rfidcontainer rf = null;
					// 查询方式(0库存1流转)
					for (String rfid : rfidList) {
						rf = new Rfidcontainer();
						rf.setRfidCode(rfid);
						rf.setDelFlag(IConstant.DEL_FLAG_0);
						rf = (Rfidcontainer) rfidcontainerDao.searchByList(rf)
								.get(0);
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

					// 刀具流转(旧刀)
					for (Tooltransfer tt : ttList) {
						// 记录生命周期
						toolwholelifecycle = new Toolwholelifecycle();
						toolwholelifecycle
								.setBusinessFlowLnkID(businessFlowLnkID);
						toolwholelifecycle.setHandSetID(handId);
						// 取得刀具信息
						Tool tool = new Tool();
						tool.setToolID(tt.getToolID());
						List<Tool> toolList = (List<Tool>) toolDao
								.searchByList(tool);
						if (toolList != null && toolList.size() > 0) {
							tool = toolList.get(0);
							toolwholelifecycle.setToolCode(tool.getToolCode());
							toolwholelifecycle.setToolName(tool.getToolName());
						}

						toolwholelifecycle.setKnifeInventoryCode(tt
								.getKnifeInventoryCode());
						toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
						toolwholelifecycle.setCreateTime(new Date());
						toolwholelifecycle.setUpdateTime(new Date());
						toolwholelifecycle.setCreateUser(userId);
						toolwholelifecycle.setUpdateUser(userId);
						toolwholelifecycle.setVersion(BigDecimal.ZERO);
						String toolWholeLifecycleID = NextKeyValue
								.getNextkeyvalue(IConstant.TOOLWHOLELIFECYCLE,
										IConstant.TOOLWHOLELIFECYCLEID, userId);
						toolwholelifecycle
								.setToolWholeLifecycleID(toolWholeLifecycleID);
						tlcList.add(toolwholelifecycle);

						// 刀具流转履历
						tth = new Tooltransferhistory();
						tth
								.setToolTransferHistoryID(NextKeyValue
										.getNextkeyvalue(
												IConstant.TOOLTRANSFERHISTORY,
												IConstant.TOOLTRANSFERHISTORYID,
												userId));
						tth.setRfidContainerID(tt.getRfidContainerID()); // RFID载体ID
						tth.setKnifeInventoryCode(businessFlowLnkID);// 刀具入库编码
						tth.setToolID(tt.getToolID());// 刀具ID
						tth.setToolProcuredID(tt.getProcuredBatch());// 采购ID
						tth.setBusinessFlowLnkID(tt.getBusinessFlowLnkID());// 最后执行业务流程(刀具安上)
						tth.setToolDurable(tt.getToolDurable());// 耐用度
						tth.setToolSharpennum(tt.getToolDurable());// 可使用(刃磨)次数
						tth.setToolSharpenCriterion(tt
								.getToolSharpenCriterion());// 复磨标准
						tth.setToolLength(tt.getToolLength());// 刀具长度
						tth.setToolSharpenLength(tt.getToolSharpenLength());// 可刃磨长度
						tth.setUsageCounter(tt.getUsageCounter());// 已使用(刃磨)次数
						tth.setToolGrindingLength(tt.getToolGrindingLength());// 刀具已刃磨长度
						tth
								.setInstallationState(IConstant.INSTALLATION_STATE_2);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
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

						Tooltransfer tto = new Tooltransfer();
						tto.setRfidContainerIDWhere(tt.getRfidContainerID());
						tto.setKnifeInventoryCodeWhere(tt
								.getKnifeInventoryCode());
						tto.setDelFlagWhere(IConstant.DEL_FLAG_0);
						tto.setBusinessFlowLnkID(businessFlowLnkID);
						tto
								.setInstallationState(IConstant.INSTALLATION_STATE_2);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
						tto.setStockState(IConstant.STOCK_STATE_4);
						tto.setUpdateTime(new Date());// 更新时间
						tto.setUpdateUser(userId);// 更新者
						tto.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
						tto.setCreateTime(new Date());// 创建时间
						tto.setCreateUser(userId);// 创建者
						tto.setVersion(BigDecimal.ZERO);// 版本号
						tooltransferDao.updateNonQuery(tto);
					}

					// 刀具出库
					Toollibraryhistory tlh = null;
					Rfidcontainer prf = null;
					// 新库加入中刀具流转（新刀）
					for (Knifeinventory ki1 : itList) {
						delList.add(ki1.getKnifeInventoryCode());// 加入删除的RFID
						// 记录生命周期
						toolwholelifecycle = new Toolwholelifecycle();
						toolwholelifecycle
								.setBusinessFlowLnkID(businessFlowLnkID);
						toolwholelifecycle.setHandSetID(handId);
						// 取得刀具信息
						Tool tool = new Tool();
						tool.setToolID(ki1.getToolID());
						List<Tool> toolList = (List<Tool>) toolDao
								.searchByList(tool);
						if (toolList != null && toolList.size() > 0) {
							tool = toolList.get(0);
							toolwholelifecycle.setToolCode(tool.getToolCode());
							toolwholelifecycle.setToolName(tool.getToolName());
						}
						toolwholelifecycle.setKnifeInventoryCode(ki1
								.getKnifeInventoryCode());
						toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
						toolwholelifecycle.setCreateTime(new Date());
						toolwholelifecycle.setUpdateTime(new Date());
						toolwholelifecycle.setCreateUser(userId);
						toolwholelifecycle.setUpdateUser(userId);
						toolwholelifecycle.setVersion(BigDecimal.ZERO);
						String toolWholeLifecycleID = NextKeyValue
								.getNextkeyvalue(IConstant.TOOLWHOLELIFECYCLE,
										IConstant.TOOLWHOLELIFECYCLEID, userId);
						toolwholelifecycle
								.setToolWholeLifecycleID(toolWholeLifecycleID);
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
						tt1.setProcuredBatch(ki1.getProcuredBatch());
						tt1.setBusinessFlowLnkID(businessFlowLnkID);// 最后流程
						//tt1.setToolDurable(tool.getToolDurable());
						tt1.setToolSharpennum(tool.getToolSharpennum());// 刃磨次数
						tt1.setToolSharpenCriterion(tool
								.getToolSharpenCriterion());
						tt1.setToolLength(tool.getToolLength());
						tt1.setToolSharpenLength(tool.getToolSharpenLength());
						tt1.setUsageCounter(BigDecimal.ZERO);// 已使用(刃磨)次数
						tt1.setToolGrindingLength(BigDecimal.ZERO);// 刀具已刃磨长度
						tt1
								.setInstallationState(IConstant.INSTALLATION_STATE_0);
						tt1.setStockState(IConstant.STOCK_STATE_4);
						tt1.setToolState(IConstant.TOOL_STATE_9);
						tt1.setReplacementFlag(null);
						tt1.setConfirmedUser(null);
						tt1.setStockState(IConstant.STOCK_STATE_4);
						tt1.setDelFlag(IConstant.DEL_FLAG_0);
						tt1.setUpdateTime(new Date());
						tt1.setUpdateUser(userId);
						tt1.setCreateTime(ki1.getCreateTime());
						tt1.setCreateUser(ki1.getCreateUser());
						tt1.setVersion(BigDecimal.ZERO);
						ttList1.add(tt1);

						// 刀具流转履历
						tth = new Tooltransferhistory();
						tth
								.setToolTransferHistoryID(NextKeyValue
										.getNextkeyvalue(
												IConstant.TOOLTRANSFERHISTORY,
												IConstant.TOOLTRANSFERHISTORYID,
												userId));
						tth.setRfidContainerID(ki1.getRfidContainerID()); // RFID载体ID
						tth.setKnifeInventoryCode(ki1.getKnifeInventoryCode());// 刀具入库编码
						tth.setToolID(ki1.getToolID());// 刀具ID
						tth.setToolProcuredID(ki1.getProcuredBatch());// 采购ID
						tth.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程(刀具安上)
						tth.setToolDurable(ki1.getToolDurable());// 耐用度
						tth.setToolSharpennum(ki1.getToolDurable());// 可使用(刃磨)次数
						tth.setToolSharpenCriterion(ki1
								.getToolSharpenCriterion());// 复磨标准
						tth.setToolLength(ki1.getToolLength());// 刀具长度
						tth.setToolSharpenLength(ki1.getToolSharpenLength());// 可刃磨长度
						tth.setUsageCounter(BigDecimal.ZERO);// 已使用(刃磨)次数
						tth.setToolGrindingLength(BigDecimal.ZERO);// 刀具已刃磨长度
						tth
								.setInstallationState(IConstant.INSTALLATION_STATE_2);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
						tth.setToolState(IConstant.TOOL_STATE_9);// 刀具状态(0断刀1丢失2不合格3借入4申领9其他)
						tth.setStockState(IConstant.STOCK_STATE_4);
						tth.setoutUser(ki1.getUpdateUser());// 转出人
						tth.setinUser(userId);// 接收人
						tth.setUpdateTime(new Date());// 更新时间
						tth.setUpdateUser(userId);// 更新者
						tth.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
						tth.setCreateTime(new Date());// 创建时间
						tth.setCreateUser(userId);// 创建者
						tth.setVersion(BigDecimal.ZERO);// 版本号
						tthList.add(tth);

						// 刀具出库履历
						tlh = new Toollibraryhistory();
						tlh.setKnifeInventoryCode(ki1.getKnifeInventoryCode());// 刀具入库编码
						tlh.setReceiveUser(userId);// 领取人
						tlh.setReceiveTime(new Date());// 领取时间
						tlh.setLibraryCause(IConstant.LIBRARY_CAUSE_1);// 出库原因(0申领1换领2外借)
						tlh.setUpdateTime(new Date());// 更新时间
						tlh.setUpdateUser(userId);// 更新者
						tlh.setCreateTime(new Date());// 创建时间
						tlh.setCreateUser(userId);// 创建者
						tlh.setVersion(BigDecimal.ZERO);// 版本号
						tlh.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分(0有效1删除)
						tlhList.add(tlh);
					}

				}
				reVal += redemptionappliedDao.updateRfidNullByAnything(entity); // 更新状态
				// 根据刀具入库编号删除出库的信息
				if (delList.size() > 0) {
					map = new HashMap<String, Object>();
					map.put("updateTime", new Date());
					map.put("userId", userId);
					map.put("list", delList);
					reVal += knifeinventoryDao.deleteToolByknifeCode(map);

				}
			}
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
		return reVal;
	}

	/**
	 * 刀具信息快速查询每盒中的数量和刀具编码
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 *             C01S023Respons
	 * @title getToolInfo
	 */
	public List<Vquerytoollist> getToolInfo(Vquerytoollist entity) {
		List<Vquerytoollist> list = new ArrayList<Vquerytoollist>();
		Vquerytoollist vquerytoollist = new Vquerytoollist();

		try {
			// 载体表(old)
			Rfidcontainer rfidcontainer = new Rfidcontainer();
			rfidcontainer.setRfidCode(entity.getRfidCode());
			rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
			rfidcontainer = (Rfidcontainer) rfidcontainerDao.searchByList(
					rfidcontainer).get(0);
			String oldContainerID = rfidcontainer.getRfidContainerID();
			// 查询方式(0库存1流转)
			String stateOld = rfidcontainer.getQueryType();
			String toolCode = null;
			// 0：新库 1：流转
			if (IConstant.STRING_0.equals(stateOld)) {
				// 新刀出库
				Knifeinventory ki = new Knifeinventory();
				ki.setRfidContainerID(oldContainerID);
				ki.setDelFlag(IConstant.DEL_FLAG_0);
				List<Knifeinventory> kilList = (List<Knifeinventory>) knifeinventoryDao
						.searchByList(ki);
				if (kilList.size() < 1) {
					throw new SQLException();
				}
				Tool tool = new Tool();
				tool.setToolID(kilList.get(0).getToolID());
				List<Tool> tools = (List<Tool>) toolDao.searchByList(tool);
				if (tools.size() < 1) {
					throw new SQLException();
				}
				toolCode = tools.get(0).getToolCode();
				vquerytoollist.setToolCode(toolCode); // 刀具编码
				vquerytoollist.setToolCount(new BigDecimal(kilList.size()));// 刀具数量
				list.add(vquerytoollist);
			} else {
				Tooltransfer tt = new Tooltransfer();
				tt.setRfidContainerID(oldContainerID);
				tt.setDelFlag(IConstant.DEL_FLAG_0);
				List<Tooltransfer> tooltransfers = (List<Tooltransfer>) tooltransferDao
						.searchByList(tt);
				if (tooltransfers.size() < 0) {
					throw new SQLException();
				}
				// (0正常1报废2返厂3封存4流转
				String stockState = tooltransfers.get(0).getStockState();
				if (!IConstant.STOCK_STATE_0.equals(stockState)
						|| IConstant.STOCK_STATE_3.equals(stockState)) {
					list = new ArrayList<Vquerytoollist>();
					vquerytoollist = new Vquerytoollist();
					vquerytoollist.setMessageCode(IConstant.EMSG0004_2);
					vquerytoollist.setRetErrFlag(true);
					list.add(vquerytoollist);
					return list;
				}
				Tool tool = new Tool();
				tool.setToolID(tooltransfers.get(0).getToolID());
				List<Tool> tools = (List<Tool>) toolDao.searchByList(tool);
				if (tools.size() < 1) {
					throw new SQLException();
				}
				toolCode = tools.get(0).getToolCode();
				vquerytoollist.setToolCode(toolCode); // 刀具编码
				vquerytoollist
						.setToolCount(new BigDecimal(tooltransfers.size()));// 刀具数量
				list.add(vquerytoollist);
			}
			return list;
		} catch (SQLException e) {
			list = new ArrayList<Vquerytoollist>();
			vquerytoollist = new Vquerytoollist();
			vquerytoollist.setMessageCode(IConstant.EMSG0004);
			vquerytoollist.setRetErrFlag(true);
			vquerytoollist.setExceMessage(e.getMessage());
			list.add(vquerytoollist);
			return list;
		}
	}

	/**
	 * 验证是否存在专机领用数据
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 *             C01S003Respons
	 * @title existLedplane
	 */
	public List<Vledplanelist> existLedplane(Vledplanelist entity)
			throws Exception {
		try {
			return (List<Vledplanelist>) vledplanelistDao.searchByList(entity);
		} catch (Exception e) {
			// 数据库操作异常,查询失败!
			List<Vledplanelist> list = new ArrayList<Vledplanelist>();
			Vledplanelist vledplanelist = new Vledplanelist();
			vledplanelist.setMessageCode(IConstant.EMSG0004);
			vledplanelist.setRetErrFlag(true);
			vledplanelist.setExceMessage(e.getMessage());
			list.add(vledplanelist);
			return list;
		}
	}

	/**
	 * 取得换领申请单 getRedemptionInfo
	 * 
	 * @param entity
	 *            处理状态((0申请中1已备货 2换领已送回 3换领未送回 4换领完毕 )
	 * @return
	 */
	@Override
	public List<Redemptionapplied> getRedemptionInfo(Redemptionapplied entity) {
		List<Redemptionapplied> list = new ArrayList<Redemptionapplied>();
		try {
			list = (List<Redemptionapplied>) redemptionappliedDao
					.searchListById(entity);
			if (list == null || list.size() <= 0) {
				// 换领申请未找到相应的数据!
				list = new ArrayList<Redemptionapplied>();
				Redemptionapplied vedemptionapplied = new Redemptionapplied();
				vedemptionapplied.setMessageCode(IConstant.WMSG0124);
				vedemptionapplied.setRetErrFlag(true);
				list.add(vedemptionapplied);
			}
		} catch (Exception e) {
			// 数据库操作异常,查询失败!
			Redemptionapplied vedemptionapplied = new Redemptionapplied();
			vedemptionapplied.setMessageCode(IConstant.EMSG0004);
			vedemptionapplied.setRetErrFlag(true);
			vedemptionapplied.setExceMessage(e.getMessage());
			list.add(vedemptionapplied);
		}
		return list;

	}

	/**
	 * 获取申请单送回列表信息
	 * 
	 * @param entity
	 * @return
	 */
	public List<Redemptionapplied> getRemand(Redemptionapplied entity) {
		List<Redemptionapplied> list = new ArrayList<Redemptionapplied>();
		try {
			list = (List<Redemptionapplied>) redemptionappliedDao
					.searchByList(entity);
			if (list == null || list.size() <= 0) {
				// 换领申请未找到相应的数据!
				list = new ArrayList<Redemptionapplied>();
				Redemptionapplied vedemptionapplied = new Redemptionapplied();
				vedemptionapplied.setMessageCode(IConstant.WMSG0124);
				vedemptionapplied.setRetErrFlag(true);
				list.add(vedemptionapplied);
			}
		} catch (Exception e) {
			// 数据库操作异常,查询失败!
			Redemptionapplied vedemptionapplied = new Redemptionapplied();
			vedemptionapplied.setMessageCode(IConstant.EMSG0004);
			vedemptionapplied.setRetErrFlag(true);
			vedemptionapplied.setExceMessage(e.getMessage());
			list.add(vedemptionapplied);
		}
		return list;
	}

	/**
	 * 取得换领申请单明细
	 */
	@Override
	public List<Vgetredemptionappdetailedmsg> getRedemptionDetail(
			Vgetredemptionappdetailedmsg entity) throws Exception {
		String rlod = entity.getToolCode(); // 角色权限
		List<String> pstList = new ArrayList<String>();
		List<Vgetredemptionappdetailedmsg> list = new ArrayList<Vgetredemptionappdetailedmsg>();
		Map<String, Object> map = new HashMap<String, Object>();
		if (rlod != null && rlod != "") {
			// 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕)
			if ("D".equals(rlod)) {
				// 库房管理员： 申请中，已备货 ，换领未送回(0,1,3)
				pstList.add(IConstant.STRING_0);
				pstList.add(IConstant.STRING_1);
				pstList.add(IConstant.STRING_3);
			} else {
				// R: 领刀人： 已备货（只读），充许换领（可操作）， 换领未送回（只读）[0.1.2.3]
				pstList.add(IConstant.STRING_0);
				pstList.add(IConstant.STRING_1);
				pstList.add(IConstant.STRING_2);
				pstList.add(IConstant.STRING_3);
			}
		}
		try {
			map.put("redemptionAppliedID", entity.getRedemptionAppliedID());
			map.put("list", pstList);
			list = (List<Vgetredemptionappdetailedmsg>) vgetredemptionappdetailedmsgDao
					.searchListByRold(map);
			if (list == null || list.size() <= 0) {
				// 换领申请单明细未找到相应的数据!
				list = new ArrayList<Vgetredemptionappdetailedmsg>();
				Vgetredemptionappdetailedmsg vgetredemptionappdetailedmsg = new Vgetredemptionappdetailedmsg();
				vgetredemptionappdetailedmsg.setMessageCode(IConstant.WMSG0125);
				vgetredemptionappdetailedmsg.setRetErrFlag(true);
				list.add(vgetredemptionappdetailedmsg);
			}

		} catch (Exception e) {
			list = new ArrayList<Vgetredemptionappdetailedmsg>();
			Vgetredemptionappdetailedmsg vgetredemptionappdetailedmsg = new Vgetredemptionappdetailedmsg();
			vgetredemptionappdetailedmsg.setMessageCode(IConstant.EMSG0004);
			vgetredemptionappdetailedmsg.setRetErrFlag(true);
			vgetredemptionappdetailedmsg.setExceMessage(e.getMessage());
			list.add(vgetredemptionappdetailedmsg);
		}
		return list;
	}

	/**
	 * 取得货架信息
	 */
	@Override
	public List<Vgetshelfinformation> getRedemptionToolInfo(
			Vgetshelfinformation entity) throws Exception {
		try {
			List<Vgetshelfinformation> list = (List<Vgetshelfinformation>) vgetshelfinformationDao
					.searchByList(entity);
			if (list == null || list.size() <= 0) {
				list = new ArrayList<Vgetshelfinformation>();
				// 货架信息未找到相应的数据!
				Vgetshelfinformation vgetshelfinformation = new Vgetshelfinformation();
				vgetshelfinformation.setMessageCode(IConstant.WMSG0126);
				vgetshelfinformation.setRetErrFlag(true);
				list.add(vgetshelfinformation);
				return list;
			} else {
				return list;
			}

		} catch (Exception e) {
			List<Vgetshelfinformation> list = new ArrayList<Vgetshelfinformation>();
			Vgetshelfinformation vgetshelfinformation = new Vgetshelfinformation();
			vgetshelfinformation.setMessageCode(IConstant.EMSG0004);
			vgetshelfinformation.setRetErrFlag(true);
			vgetshelfinformation.setExceMessage(e.getMessage());
			list.add(vgetshelfinformation);
			return list;
		}
	}

	/**
	 * 更新备货刀具状态 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕)
	 */
	@Override
	public int saveStockingToolStauts(Map<String, Object> map) throws Exception {
		int reVal = 0;
		Map<String, Object> mapParam = new HashMap<String, Object>();
		Map<String, Object> map2 = null;
		List<String> toolCodeList = new ArrayList<String>();
		String appliedID = map.get("appliedID").toString();
		String userId = map.get("userId").toString();
		List<String> delList = (List<String>) map.get("delList");
		List<String> rfidList = (List<String>) map.get("rfidList");
		List<Redemptionapplied> reList = (List<Redemptionapplied>) map
				.get("reList");// 换领申请
		String state = map.get("state").toString(); // 状态
		int parno = (Integer) map.get("paramNumber");
		if (rfidList != null && rfidList.size() > 0) {
			toolCodeList = getTClistByRFid(rfidList);
		}

		if (delList != null && delList.size() > 0) {
			map2 = new HashMap<String, Object>();
			map2.put("userId", userId);
			map2.put("updateTime", new Date());
			map2.put("list", delList);
			reVal += rfidcontainerDao.updateDelByRfid(map2);
		}

		if (toolCodeList.size() > 0) {
			mapParam.put("redemptionAppliedID", appliedID);
			mapParam.put("list", toolCodeList);
			mapParam.put("updateTime", new Date());
			mapParam.put("updateUser", userId);
			if (IConstant.STRING_0.equals(state)) {// 申请中-->已备货
				mapParam.put("status", IConstant.PROCESSING_STATUS_0);
				mapParam.put("processingStatus", IConstant.PROCESSING_STATUS_1);
				reVal += redemptionappliedDao.updateBatchStateByRfid(mapParam);
			} else if (IConstant.STRING_1.equals(state)) {// 已备货-->2换领已送回
				// -->3换领未送回
				if (forWordToNextflow(map) > 0) {
					// 2换领已送回
					mapParam.put("status", IConstant.STRING_1);
					mapParam.put("processingStatus",
							IConstant.PROCESSING_STATUS_2);
					reVal += redemptionappliedDao
							.updateBatchStateByRfid(mapParam);
					// 3换领未送回
					mapParam.put("processingStatus", IConstant.STRING_3);
					reVal += redemptionappliedDao
							.updateBatchNotStateByRfid(mapParam);
					if (reList != null && reList.size() > 0) {
						// 根据申请单号的刀具编码修改实际送回数量
						Redemptionapplied red = null;
						for (Redemptionapplied redemptionapplied : reList) {
							red = new Redemptionapplied();
							red.setDelFlagWhere(IConstant.DEL_FLAG_0);
							red.setRedemptionAppliedIDWhere(redemptionapplied
									.getRedemptionAppliedID());// 申请单号
							red.setToolCodeWhere(redemptionapplied
									.getToolCode());// 刀具编码
							red.setReturnNumber(redemptionapplied
									.getReceiveNumber()); // 送回数量
							red.setUpdateTime(new Date());
							red
									.setUpdateUser(redemptionapplied
											.getUpdateUser());
							// 按任意条件修改任意属性
							reVal += redemptionappliedDao.updateByAnything(red);

						}
						// reVal +=
						// redemptionappliedDao.updateReceiveByIdAndToolCode(reList);
					}
				}
				/*
				 * } else if (IConstant.STRING_4.equals(state)) {// 允许换领-->2换领已送回 // -->3换领未送回
				 * // 2换领已送回 mapParam.put("status", IConstant.STRING_4);
				 * mapParam.put("processingStatus",
				 * IConstant.PROCESSING_STATUS_2); reVal +=
				 * redemptionappliedDao.updateBatchStateByRfid(mapParam); //
				 * 3换领未送回 mapParam.put("processingStatus", IConstant.STRING_3); reVal +=
				 * redemptionappliedDao.updateBatchNotStateByRfid(mapParam); if
				 * (reList != null && reList.size() > 0) { //
				 * 根据申请单号的刀具编码修改实际送回数量 reVal +=
				 * redemptionappliedDao.updateReceiveByIdAndToolCode(reList); }
				 */
			} else if (IConstant.STRING_3.equals(state)) {// 3换领未送回 修改为 4.换领完毕
				if (forWordToNextflow(map) > 0) {
					mapParam.put("processingStatus", IConstant.STRING_4);
					mapParam.put("status", IConstant.STRING_3);
					reVal += redemptionappliedDao
							.updateBatchStateByRfid(mapParam);
					if (reList != null && reList.size() > 0) {
						// 根据申请单号的刀具编码修改实际送回数量
						reVal += redemptionappliedDao
								.updateReceiveByIdAndToolCode(reList);
					}
				}
			}
		} else {
			if (IConstant.STRING_1.equals(state) && parno > 0) {
				mapParam.put("redemptionAppliedID", appliedID);
				mapParam.put("updateTime", new Date());
				mapParam.put("updateUser", userId);
				mapParam.put("status", IConstant.STRING_1);
				// 3换领未送回
				mapParam.put("processingStatus", IConstant.STRING_3);
				reVal += redemptionappliedDao
						.updateBatchNotStateByState(mapParam);

			}
		}
		return reVal;
	}

	/**
	 * 送回的旧刀进行流程转换
	 * 
	 * @param map
	 * @return int
	 * @title forWordToNextflow
	 */

	private int forWordToNextflow(Map<String, Object> map) throws Exception {
		List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory>();
		int reVal = 0;
		String userId = map.get("userId").toString();// 用户ID
		List<String> rfidList = (List<String>) map.get("rfidList");// rfidList
		String handId = map.get("handerId").toString();// 手持机Id
		List<Tooltransfer> ttList = new ArrayList<Tooltransfer>();

		if (rfidList.size() > 0) {
			// 取得刀具流转信息
			ttList = tooltransferDao.searchHalfByList(rfidList);
		}

		String businessFlowLnkID = null;

		Business business = new Business();
		business.setBusinessCode("C01S003");
		List<Business> businessList = (List<Business>) businessDao
				.searchByList(business);
		business = businessList.get(0);
		Businessflowlnk businessflowlnks = new Businessflowlnk();
		businessflowlnks.setBusinessID(business.getBusinessID());
		List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao
				.searchByList(businessflowlnks);
		// 下一个流程
		businessFlowLnkID = list1.get(0).getBusinessFlowLnkID();
		// }

		Tooltransferhistory tth = null;
		List<Toolwholelifecycle> tlcList = new ArrayList<Toolwholelifecycle>();
		Toolwholelifecycle toolwholelifecycle = null;
		// 刀具流转
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
			toolwholelifecycle
					.setKnifeInventoryCode(tt.getKnifeInventoryCode());
			toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
			toolwholelifecycle.setCreateTime(new Date());
			toolwholelifecycle.setUpdateTime(new Date());
			toolwholelifecycle.setCreateUser(userId);
			toolwholelifecycle.setUpdateUser(userId);
			toolwholelifecycle.setVersion(BigDecimal.ZERO);
			String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue(
					IConstant.TOOLWHOLELIFECYCLE,
					IConstant.TOOLWHOLELIFECYCLEID, userId);
			toolwholelifecycle.setToolWholeLifecycleID(toolWholeLifecycleID);
			tlcList.add(toolwholelifecycle);

			// 刀具流转履历
			tth = new Tooltransferhistory();
			tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(
					IConstant.TOOLTRANSFERHISTORY,
					IConstant.TOOLTRANSFERHISTORYID, userId));
			tth.setRfidContainerID(tt.getRfidContainerID()); // RFID载体ID
			tth.setKnifeInventoryCode(tt.getKnifeInventoryCode());// 刀具入库编码
			tth.setToolID(tt.getToolID());// 刀具ID
			tth.setToolProcuredID(tt.getProcuredBatch());// 采购ID
			tth.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程(刀具安上)
			tth.setToolDurable(tt.getToolDurable());// 耐用度
			tth.setToolSharpennum(tt.getToolDurable());// 可使用(刃磨)次数
			tth.setToolSharpenCriterion(tt.getToolSharpenCriterion());// 复磨标准
			tth.setToolLength(tt.getToolLength());// 刀具长度
			tth.setToolSharpenLength(tt.getToolSharpenLength());// 可刃磨长度
			tth.setUsageCounter(tt.getUsageCounter());// 已使用(刃磨)次数
			tth.setToolGrindingLength(tt.getToolGrindingLength());// 刀具已刃磨长度
			tth.setInstallationState(IConstant.INSTALLATION_STATE_2);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
			tth.setToolState(IConstant.TOOL_STATE_9);// 刀具状态(0断刀1丢失2不合格3借入4申领9其他)
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
		if (tlcList.size() > 0) {
			toolwholelifecycleDao.insertBatchs(tlcList);
		}
		// 批量增加【刀具流转履历】
		if (tthList.size() > 0) {
			tooltransferhistoryDao.insertBatchDefined(tthList);
		}

		Map<String, Object> map2 = new HashMap<String, Object>();
		if (rfidList.size() > 0) {
			// 更新刀具流转
			map2.put("installationState", IConstant.INSTALLATION_STATE_2);
			map2.put("businessFlowLnkID", businessFlowLnkID);
			map2.put("userId", userId);
			map2.put("list", rfidList);
			reVal += tooltransferDao.updateBatchByRfid(map2);
		}
		return reVal;
	}

	/**
	 * 新旧RFID交换
	 */
	@Override
	public int saveOutputStockingTool(Map<String, Object> map) throws Exception {
		int reVal = 0;
		String newRfidString = map.get("newRfid").toString();// 新RFID
		String oldRfidString = map.get("oldRfid").toString();// 旧RFID
		String tempNumber = map.get("tempNumbe").toString();// 换领数量
		String userId = map.get("userId").toString();
		// 载体表(old)
		Rfidcontainer rfidcontainer = new Rfidcontainer();
		rfidcontainer.setRfidCode(oldRfidString);
		rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
		rfidcontainer = (Rfidcontainer) rfidcontainerDao.searchByList(
				rfidcontainer).get(0);
		String oldContainerID = rfidcontainer.getRfidContainerID();
		// 查询方式(0库存1流转)
		String stateOld = rfidcontainer.getQueryType();

		// 载体表(new)
		rfidcontainer = new Rfidcontainer();
		rfidcontainer.setRfidCode(newRfidString);
		rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
		rfidcontainer = (Rfidcontainer) rfidcontainerDao.searchByList(
				rfidcontainer).get(0);
		String newContainerID = rfidcontainer.getRfidContainerID();

		List<String> kicList = new ArrayList<String>();
		List<Tooltransfer> ttList1 = new ArrayList<Tooltransfer>();
		Tooltransfer tt1 = null;
		List<Tooltransfer> ttList = new ArrayList<Tooltransfer>();
		Tooltransferhistory tth = null;
		List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory>();
		List<String> toolknife = new ArrayList<String>();

		// 最后流程
		Vbusiness bVbusiness = new Vbusiness();
		bVbusiness.setBusinessCode("C01S005");// 上一个为旧刀回收
		bVbusiness = (Vbusiness) vbusinessDao.searchByList(bVbusiness).get(0);
		String businessFlowLnkId = bVbusiness.getBusinessFlowLnkID();

		// 0：新库 1：流转
		if (IConstant.STRING_0.equals(stateOld)) {
			// 新刀出库
			Knifeinventory ki = new Knifeinventory();
			ki.setRfidContainerID(oldContainerID);
			ki.setDelFlag(IConstant.DEL_FLAG_0);
			ki.setStaIndex(0);
			ki.setRowCount(Integer.parseInt(tempNumber));
			List<Knifeinventory> kilList = (List<Knifeinventory>) knifeinventoryDao
					.searchByList(ki);
			if (kilList.size() < 1) {
				return reVal;
			}
			// 添加流转和流转履历
			for (Knifeinventory ki1 : kilList) {
				// 刀具流转
				tt1 = new Tooltransfer();
				Rfidcontainer rfidcontainer2 = new Rfidcontainer();
				rfidcontainer2.setRfidContainerIDWhere(newContainerID);
				rfidcontainer2.setDelFlagWhere(IConstant.DEL_FLAG_0);
				rfidcontainer2.setQueryType(IConstant.QUERY_TYPE_1);
				reVal += rfidcontainerDao.updateNonQuery(rfidcontainer2);
				tt1.setRfidContainerID(newContainerID);

				tt1.setKnifeInventoryCode(ki1.getKnifeInventoryCode());
				toolknife.add(ki1.getKnifeInventoryCode());
				kicList.add(ki1.getKnifeInventoryCode());
				tt1.setToolID(ki1.getToolID());
				tt1.setProcuredBatch(ki1.getProcuredBatch());
				tt1.setBusinessFlowLnkID(businessFlowLnkId);// 最后流程
				tt1.setToolDurable(ki1.getToolDurable());
				tt1.setToolSharpennum(ki1.getToolSharpennum());
				tt1.setToolSharpenCriterion(ki1.getToolSharpenCriterion());
				tt1.setToolLength(ki1.getToolLength());
				tt1.setToolSharpenLength(ki1.getToolSharpenLength());
				tt1.setUsageCounter(BigDecimal.ZERO);// 已使用(刃磨)次数
				tt1.setToolGrindingLength(BigDecimal.ZERO);// 刀具已刃磨长度
				tt1.setInstallationState(IConstant.INSTALLATION_STATE_0);
				tt1.setToolState(IConstant.TOOL_STATE_9);
				tt1.setReplacementFlag(null);
				tt1.setConfirmedUser(null);
				tt1.setStockState(IConstant.STOCK_STATE_4);
				tt1.setDelFlag(IConstant.DEL_FLAG_0);
				tt1.setUpdateTime(new Date());
				tt1.setUpdateUser(userId);
				tt1.setCreateTime(ki1.getCreateTime());
				tt1.setCreateUser(ki1.getCreateUser());
				tt1.setVersion(BigDecimal.ZERO);
				ttList1.add(tt1);
				// 刀具流转履历
				tth = new Tooltransferhistory();
				tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(
						IConstant.TOOLTRANSFERHISTORY,
						IConstant.TOOLTRANSFERHISTORYID, userId));
				tth.setRfidContainerID(newContainerID); // RFID载体ID
				tth.setKnifeInventoryCode(ki1.getKnifeInventoryCode());// 刀具入库编码
				tth.setToolID(ki1.getToolID());// 刀具ID
				tth.setToolProcuredID(ki1.getProcuredBatch());// 采购ID
				tth.setBusinessFlowLnkID(businessFlowLnkId);// 最后执行业务流程(刀具安上)
				tth.setToolDurable(ki1.getToolDurable());// 耐用度
				tth.setToolSharpennum(ki1.getToolDurable());// 可使用(刃磨)次数
				tth.setToolSharpenCriterion(ki1.getToolSharpenCriterion());// 复磨标准
				tth.setToolLength(ki1.getToolLength());// 刀具长度
				tth.setToolSharpenLength(ki1.getToolSharpenLength());// 可刃磨长度
				tth.setUsageCounter(BigDecimal.ZERO);// 已使用(刃磨)次数
				tth.setToolGrindingLength(BigDecimal.ZERO);// 刀具已刃磨长度
				tth.setInstallationState(IConstant.INSTALLATION_STATE_1);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
				tth.setoutUser(userId);// 转出人
				tth.setinUser(userId);// 接收人
				tth.setUpdateTime(new Date());// 更新时间
				tth.setUpdateUser(userId);// 更新者
				tth.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
				tth.setCreateTime(new Date());// 创建时间
				tth.setCreateUser(userId);// 创建者
				tth.setVersion(BigDecimal.ZERO);// 版本号
				tthList.add(tth);

			}
			if (ttList1.size() > 0) {
				// 添加刀具流转
				tooltransferDao.insertBatchs(ttList1);
			}
			if (tthList.size() > 0) {
				// 添加刀具流转履历
				tooltransferhistoryDao.insertBatchDefined(tthList);
			}

			// 根据刀具入库编号删除出库的信息
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("userId", userId);
			map2.put("updateTime", new Date());
			map2.put("list", toolknife);
			reVal += knifeinventoryDao.deleteToolByknifeCode(map2);
			/*
			 * 新库修改为流转 rfidcontainer = new Rfidcontainer();
			 * rfidcontainer.setRfidContainerIDWhere(oldContainerID);
			 * rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
			 * rfidcontainer.setQueryType(IConstant.QUERY_TYPE_1); reVal +=
			 * rfidcontainerDao.updateNonQuery(rfidcontainer);
			 */
		} else {// 流转刀具
			ttList1 = new ArrayList<Tooltransfer>();
			// 流转查询
			tt1 = new Tooltransfer();
			tt1.setRfidContainerID(oldContainerID);
			tt1.setDelFlag(IConstant.DEL_FLAG_0);
			tt1.setStaIndex(0);
			tt1.setRowCount(Integer.parseInt(tempNumber));
			ttList = (List<Tooltransfer>) tooltransferDao.searchByList(tt1);
			if (ttList.size() < 1) {
				return reVal;
			}
			// 添加流转（newRFID）
			for (Tooltransfer tt : ttList) {
				tt1 = new Tooltransfer();
				tt1.setRfidContainerID(newContainerID);
				tt1.setKnifeInventoryCode(tt.getKnifeInventoryCode());
				kicList.add(tt.getKnifeInventoryCode());
				tt1.setToolID(tt.getToolID());
				tt1.setProcuredBatch(tt.getProcuredBatch());
				tt1.setBusinessFlowLnkID(tt.getBusinessFlowLnkID());
				tt1.setToolDurable(tt.getToolDurable());
				tt1.setToolSharpennum(tt.getToolSharpennum());
				tt1.setToolSharpenCriterion(tt.getToolSharpenCriterion());
				tt1.setToolLength(tt.getToolLength());
				tt1.setToolSharpenLength(tt.getToolSharpenLength());
				tt1.setUsageCounter(tt.getUsageCounter());
				tt1.setToolGrindingLength(tt.getToolGrindingLength());
				tt1.setInstallationState(tt.getInstallationState());
				tt1.setToolState(tt.getToolState());
				tt1.setReplacementFlag(tt.getReplacementFlag());
				tt1.setConfirmedUser(tt.getConfirmedUser());
				tt1.setStockState(IConstant.STOCK_STATE_4);
				tt1.setDelFlag(IConstant.DEL_FLAG_0);
				tt1.setUpdateTime(new Date());
				tt1.setUpdateUser(userId);
				tt1.setCreateTime(tt.getCreateTime());
				tt1.setCreateUser(tt.getCreateUser());
				tt1.setVersion(tt.getVersion().add(BigDecimal.ONE));
				ttList1.add(tt1);
			}
			// 添加新Rfid
			tooltransferDao.insertBatchs(ttList1);

		}

		// 修改刀具流转履历
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("userId", userId);
		map2.put("newRfid", newContainerID);
		map2.put("list", kicList);
		reVal += tooltransferhistoryDao.updateByList(map2);

		// 删除从盒中拿出来的刀具
		map2 = new HashMap<String, Object>();
		map2.put("userId", userId);
		map2.put("oldRfid", oldContainerID);
		map2.put("list", kicList);
		reVal += tooltransferDao.updateDelFlagByRfid(map2);

		return reVal;
	}

	/**
	 * 取得旧用户
	 */
	@Override
	public Redemptionapplied findOldUserId(String redemptionAppliedID)
			throws Exception {
		Redemptionapplied entity = new Redemptionapplied();
		entity.setRedemptionAppliedID(redemptionAppliedID);
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		return ((List<Redemptionapplied>) redemptionappliedDao
				.searchByList(entity)).get(0);
	}

	/**
	 * 换领结束
	 */
	@Override
	public int saveRedemptionInfo(Map<String, Object> map) throws Exception {
		List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory>();
		int reVal = 0;

		String userId = map.get("userId").toString();// 用户ID
		List<String> rfidList = (List<String>) map.get("rfidList");// rfidList
		String handId = map.get("handerId").toString();// 手持机Id
		List<Redemptionapplied> list = (List<Redemptionapplied>) map
				.get("reList");// 换领申请
		List<Redemptionapplied> listThree = (List<Redemptionapplied>) map
				.get("listThree");// 换领申请(未送回)
		List<String> itRfidList = new ArrayList<String>();
		List<String> ttRfidList = new ArrayList<String>();
		List<Tooltransfer> ttList = new ArrayList<Tooltransfer>();
		List<Knifeinventory> itList = new ArrayList<Knifeinventory>();

		Rfidcontainer rf = null;
		// 查询方式(0库存1流转)
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
		String businessFlowLnkID = null;
		// 取得业务流程ID
		Business business = new Business();
		business.setBusinessCode("C01S003");
		List<Business> businessList = (List<Business>) businessDao
				.searchByList(business);
		business = businessList.get(0);
		Businessflowlnk businessflowlnks = new Businessflowlnk();
		businessflowlnks.setBusinessID(business.getBusinessID());
		List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao
				.searchByList(businessflowlnks);
		if (list1 == null || list1.size() < 1) {
			return 0;
		}
		// 当前流程
		businessFlowLnkID = list1.get(0).getBusinessFlowLnkID();

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

			toolwholelifecycle
					.setKnifeInventoryCode(tt.getKnifeInventoryCode());
			toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
			toolwholelifecycle.setCreateTime(new Date());
			toolwholelifecycle.setUpdateTime(new Date());
			toolwholelifecycle.setCreateUser(userId);
			toolwholelifecycle.setUpdateUser(userId);
			toolwholelifecycle.setVersion(BigDecimal.ZERO);
			String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue(
					IConstant.TOOLWHOLELIFECYCLE,
					IConstant.TOOLWHOLELIFECYCLEID, userId);
			toolwholelifecycle.setToolWholeLifecycleID(toolWholeLifecycleID);
			tlcList.add(toolwholelifecycle);

			// 刀具流转履历
			tth = new Tooltransferhistory();
			tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(
					IConstant.TOOLTRANSFERHISTORY,
					IConstant.TOOLTRANSFERHISTORYID, userId));
			tth.setRfidContainerID(tt.getRfidContainerID()); // RFID载体ID
			tth.setKnifeInventoryCode(tt.getKnifeInventoryCode());// 刀具入库编码
			tth.setToolID(tt.getToolID());// 刀具ID
			tth.setToolProcuredID(tt.getProcuredBatch());// 采购ID
			tth.setBusinessFlowLnkID(tt.getBusinessFlowLnkID());// 最后执行业务流程(刀具安上)
			tth.setToolDurable(tt.getToolDurable());// 耐用度
			tth.setToolSharpennum(tt.getToolDurable());// 可使用(刃磨)次数
			tth.setToolSharpenCriterion(tt.getToolSharpenCriterion());// 复磨标准
			tth.setToolLength(tt.getToolLength());// 刀具长度
			tth.setToolSharpenLength(tt.getToolSharpenLength());// 可刃磨长度
			tth.setUsageCounter(tt.getUsageCounter());// 已使用(刃磨)次数
			tth.setToolGrindingLength(tt.getToolGrindingLength());// 刀具已刃磨长度
			tth.setInstallationState(IConstant.INSTALLATION_STATE_2);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
			tth.setToolState(IConstant.TOOL_STATE_9);// 刀具状态(0断刀1丢失2不合格3借入4申领9其他)
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

		// 刀具出库
		List<String> delList = new ArrayList<String>();
		List<Toollibraryhistory> tlhList = new ArrayList<Toollibraryhistory>();
		Toollibraryhistory tlh = null;
		Rfidcontainer prf = null;
		// 新库加入中刀具流转（新刀）
		for (Knifeinventory ki1 : itList) {
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
			toolwholelifecycle.setKnifeInventoryCode(ki1
					.getKnifeInventoryCode());
			toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
			toolwholelifecycle.setCreateTime(new Date());
			toolwholelifecycle.setUpdateTime(new Date());
			toolwholelifecycle.setCreateUser(userId);
			toolwholelifecycle.setUpdateUser(userId);
			toolwholelifecycle.setVersion(BigDecimal.ZERO);
			String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue(
					IConstant.TOOLWHOLELIFECYCLE,
					IConstant.TOOLWHOLELIFECYCLEID, userId);
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
			tt1.setProcuredBatch(ki1.getProcuredBatch());
			tt1.setBusinessFlowLnkID(businessFlowLnkID);// 最后流程
			//tt1.setToolDurable(tool.getToolDurable());
			tt1.setToolSharpennum(tool.getToolSharpennum());// 刃磨次数
			tt1.setToolSharpenCriterion(tool.getToolSharpenCriterion());
			tt1.setToolLength(tool.getToolLength());
			tt1.setToolSharpenLength(tool.getToolSharpenLength());
			tt1.setUsageCounter(BigDecimal.ZERO);// 已使用(刃磨)次数
			tt1.setToolGrindingLength(BigDecimal.ZERO);// 刀具已刃磨长度
			tt1.setInstallationState(IConstant.INSTALLATION_STATE_0);
			tt1.setToolState(IConstant.TOOL_STATE_9);
			tt1.setReplacementFlag(null);
			tt1.setConfirmedUser(null);
			tt1.setStockState(IConstant.STOCK_STATE_4);
			tt1.setDelFlag(IConstant.DEL_FLAG_0);
			tt1.setUpdateTime(new Date());
			tt1.setUpdateUser(userId);
			tt1.setCreateTime(ki1.getCreateTime());
			tt1.setCreateUser(ki1.getCreateUser());
			tt1.setVersion(BigDecimal.ZERO);
			ttList1.add(tt1);

			// 刀具流转履历
			tth = new Tooltransferhistory();
			tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(
					IConstant.TOOLTRANSFERHISTORY,
					IConstant.TOOLTRANSFERHISTORYID, userId));
			tth.setRfidContainerID(ki1.getRfidContainerID()); // RFID载体ID
			tth.setKnifeInventoryCode(ki1.getKnifeInventoryCode());// 刀具入库编码
			delList.add(ki1.getKnifeInventoryCode());// 加入删除的RFID
			tth.setToolID(ki1.getToolID());// 刀具ID
			tth.setToolProcuredID(ki1.getProcuredBatch());// 采购ID
			tth.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程(刀具安上)
			tth.setToolDurable(ki1.getToolDurable());// 耐用度
			tth.setToolSharpennum(ki1.getToolDurable());// 可使用(刃磨)次数
			tth.setToolSharpenCriterion(ki1.getToolSharpenCriterion());// 复磨标准
			tth.setToolLength(ki1.getToolLength());// 刀具长度
			tth.setToolSharpenLength(ki1.getToolSharpenLength());// 可刃磨长度
			tth.setUsageCounter(BigDecimal.ZERO);// 已使用(刃磨)次数
			tth.setToolGrindingLength(BigDecimal.ZERO);// 刀具已刃磨长度
			tth.setInstallationState(IConstant.INSTALLATION_STATE_2);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
			tth.setToolState(IConstant.TOOL_STATE_9);// 刀具状态(0断刀1丢失2不合格3借入4申领9其他)
			tth.setoutUser(ki1.getUpdateUser());// 转出人
			tth.setinUser(userId);// 接收人
			tth.setUpdateTime(new Date());// 更新时间
			tth.setUpdateUser(userId);// 更新者
			tth.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
			tth.setCreateTime(new Date());// 创建时间
			tth.setCreateUser(userId);// 创建者
			tth.setVersion(BigDecimal.ZERO);// 版本号
			tthList.add(tth);

			// 刀具出库履历
			tlh = new Toollibraryhistory();
			tlh.setKnifeInventoryCode(ki1.getKnifeInventoryCode());// 刀具入库编码
			tlh.setReceiveUser(userId);// 领取人
			tlh.setReceiveTime(new Date());// 领取时间
			tlh.setLibraryCause(IConstant.LIBRARY_CAUSE_1);// 出库原因(0申领1换领2外借)
			tlh.setUpdateTime(new Date());// 更新时间
			tlh.setUpdateUser(userId);// 更新者
			tlh.setCreateTime(new Date());// 创建时间
			tlh.setCreateUser(userId);// 创建者
			tlh.setVersion(BigDecimal.ZERO);// 版本号
			tlh.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分(0有效1删除)
			tlhList.add(tlh);
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
		Map<String, Object> map2 = new HashMap<String, Object>();
		if (delList.size() > 0) {
			// 根据刀具入库编号删除出库的信息
			map2.put("userId", userId);
			map2.put("updateTime", new Date());
			map2.put("list", delList);
			reVal += knifeinventoryDao.deleteToolByknifeCode(map2);
		}
		if (ttRfidList.size() > 0) {
			// 更新刀具流转
			map2 = new HashMap<String, Object>();
			// map2.put("installationState", IConstant.INSTALLATION_STATE_2);
			map2.put("businessFlowLnkID", businessFlowLnkID);
			map2.put("userId", userId);
			map2.put("list", ttRfidList);
			reVal += tooltransferDao.updateBatchByRfid(map2);
		}

		Redemptionapplied redemptionapplied1 = null;
		if (listThree.size() > 0) {
			// 更新换领申请表为实际送回数量
			for (Redemptionapplied red : listThree) {
				redemptionapplied1 = new Redemptionapplied();
				redemptionapplied1.setDelFlagWhere(IConstant.DEL_FLAG_0);
				redemptionapplied1.setRedemptionAppliedIDWhere(red
						.getRedemptionAppliedID());// 换领申请单号
				redemptionapplied1.setToolCodeWhere(red.getToolCode());// 刀具编码
				redemptionapplied1.setProcessingStatusWhere(IConstant.STRING_3);

				redemptionapplied1.setReceiveNumber(red.getReceiveNumber());
				redemptionapplied1.setReceiveTime(new Date());
				redemptionapplied1.setReceiveUser(userId);
				redemptionapplied1.setUpdateTime(new Date());
				redemptionapplied1.setUpdateUser(userId);
				reVal += redemptionappliedDao
						.updateByAnything(redemptionapplied1);
			}
		}

		Redemptionapplied redemptionapplied = null;
		if (list.size() > 0) {
			// 更新换领申请表为已换领已送回
			for (Redemptionapplied red : list) {
				redemptionapplied = new Redemptionapplied();
				redemptionapplied.setDelFlagWhere(IConstant.DEL_FLAG_0);
				redemptionapplied.setRedemptionAppliedIDWhere(red
						.getRedemptionAppliedID());
				redemptionapplied.setToolCodeWhere(red.getToolCode());
				String processingStatus = " '1' OR  ProcessingStatus = '2' ";
				redemptionapplied.setProcessingStatusWhere(processingStatus);

				redemptionapplied.setReceiveNumber(red.getReceiveNumber());
				redemptionapplied.setReceiveTime(new Date());
				redemptionapplied.setReceiveUser(userId);
				redemptionapplied.setProcessingStatus(IConstant.STRING_4);
				redemptionapplied.setUpdateTime(new Date());
				redemptionapplied.setUpdateUser(userId);
				reVal += redemptionappliedDao
						.updateByAnythingFour(redemptionapplied);

			}
		}

		return reVal;
	}

	/**
	 * 非单品-换领出库
	 */
	@Override
	public Map<String, Object> saveRedemptionApplied(Map<String, Object> map) {
		// 返回值
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			// 获取参数
			Redemptionapplied redemptionapplied = (Redemptionapplied) map
					.get("redemptionapplied");
			String handId = (String) map.get("handId");
			String userId = (String) map.get("userId");
			String gruantUserID = (String) map.get("gruantUserID");
			int receiveNumber = redemptionapplied.getReceiveNumber().intValue();
			String toolCode = redemptionapplied.getToolCode();
			// 当前流程ID
			String businessFlowLnkID = null;

			// 刀具流转履历
			List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory>();

			Toolwholelifecycle toolwholelifecycle = null;

			Tooltransfer tt1 = null;
			List<Tooltransfer> ttList1 = new ArrayList<Tooltransfer>();
			Tooltransferhistory tth = null;
			List<Toolwholelifecycle> tlcList = new ArrayList<Toolwholelifecycle>();

			// 刀具出库
			List<String> delList = new ArrayList<String>();
			List<Toollibraryhistory> tlhList = new ArrayList<Toollibraryhistory>();
			Toollibraryhistory tlh = null;

			Tool tEntity = new Tool();
			tEntity.setToolCode(toolCode);
			tEntity.setDelFlag(IConstant.DEL_FLAG_0);
			List<Tool> ttList = (List<Tool>) toolDao.searchByList(tEntity);

			Tooltransfer tfEntity = new Tooltransfer();
			if (ttList.size() < 0) {
				rtn.put("masg", "查无刀具编码");
				rtn.put("status", IConstant.RESULT_CODE_1);
				return rtn;
			}
			Tool tool = ttList.get(0);
			tfEntity.setToolID(tool.getToolID());
			tfEntity.setStockState(IConstant.STSATIC_ZERO);
			tfEntity.setDelFlag(IConstant.DEL_FLAG_0);
			tfEntity.setOrderString("createTime");
			tfEntity.setStaIndex(0);
			tfEntity.setRowCount(receiveNumber);
			List<Tooltransfer> tfList = (List<Tooltransfer>) tooltransferDao
					.searchByList(tfEntity);

			// 取得业务流程ID
			Business business = new Business();
			business.setBusinessCode("C01S003");
			List<Business> businessList = (List<Business>) businessDao
					.searchByList(business);
			business = businessList.get(0);
			Businessflowlnk businessflowlnks = new Businessflowlnk();
			businessflowlnks.setBusinessID(business.getBusinessID());
			List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao
					.searchByList(businessflowlnks);
			if (list1 == null || list1.size() < 1) {
				rtn.put("masg", "查无此流程");
				rtn.put("status", IConstant.RESULT_CODE_1);
			}
			// 当前流程
			businessFlowLnkID = list1.get(0).getBusinessFlowLnkID();

			// 刀具流转(旧刀)
			for (Tooltransfer tt : tfList) {
				// 记录生命周期
				toolwholelifecycle = new Toolwholelifecycle();
				toolwholelifecycle.setBusinessFlowLnkID(businessFlowLnkID);
				toolwholelifecycle.setHandSetID(handId);
				toolwholelifecycle.setToolCode(tool.getToolCode());
				toolwholelifecycle.setToolName(tool.getToolName());
				toolwholelifecycle.setKnifeInventoryCode(tt
						.getKnifeInventoryCode());
				toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
				toolwholelifecycle.setCreateTime(new Date());
				toolwholelifecycle.setUpdateTime(new Date());
				toolwholelifecycle.setCreateUser(userId);
				toolwholelifecycle.setUpdateUser(userId);
				toolwholelifecycle.setVersion(BigDecimal.ZERO);
				String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue(
						IConstant.TOOLWHOLELIFECYCLE,
						IConstant.TOOLWHOLELIFECYCLEID, userId);
				toolwholelifecycle
						.setToolWholeLifecycleID(toolWholeLifecycleID);
				tlcList.add(toolwholelifecycle);

				// 刀具流转履历
				tth = new Tooltransferhistory();
				tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(
						IConstant.TOOLTRANSFERHISTORY,
						IConstant.TOOLTRANSFERHISTORYID, userId));
				tth.setRfidContainerID(tt.getRfidContainerID()); // RFID载体ID
				tth.setKnifeInventoryCode(tt.getKnifeInventoryCode());// 刀具入库编码
				tth.setToolID(tool.getToolID());// 刀具ID
				tth.setToolProcuredID(tt.getProcuredBatch());// 采购ID
				tth.setBusinessFlowLnkID(tt.getBusinessFlowLnkID());// 最后执行业务流程(刀具安上)
				tth.setToolDurable(tt.getToolDurable());// 耐用度
				tth.setToolSharpennum(tt.getToolDurable());// 可使用(刃磨)次数
				tth.setToolSharpenCriterion(tt.getToolSharpenCriterion());// 复磨标准
				tth.setToolLength(tt.getToolLength());// 刀具长度
				tth.setToolSharpenLength(tt.getToolSharpenLength());// 可刃磨长度
				tth.setUsageCounter(tt.getUsageCounter());// 已使用(刃磨)次数
				tth.setToolGrindingLength(tt.getToolGrindingLength());// 刀具已刃磨长度
				tth.setInstallationState(IConstant.INSTALLATION_STATE_2);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
				tth.setToolState(IConstant.TOOL_STATE_9);// 刀具状态(0断刀1丢失2不合格3借入4申领9其他)
				tth.setoutUser(userId);// 转出人
				tth.setinUser(gruantUserID);// 接收人
				tth.setUpdateTime(new Date());// 更新时间
				tth.setUpdateUser(userId);// 更新者
				tth.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
				tth.setCreateTime(new Date());// 创建时间
				tth.setCreateUser(userId);// 创建者
				tth.setVersion(BigDecimal.ZERO);// 版本号
				tthList.add(tth);

				// 刀具流转
				tt.setRfidContainerID(IConstant.KNIFE_CONTARNERID); // RFID载体ID当交接人已交接成后.申领出来的刀具默认在对刀室
				tt.setKnifeInventoryCodeWhere(tt.getKnifeInventoryCode());
				tt.setToolIDWhere(tt.getToolIDWhere());
				tt.setDelFlagWhere(IConstant.DEL_FLAG_0);
				tt.setStockState(IConstant.STOCK_STATE_4);
				tt.setToolThisState(IConstant.STSATIC_ONE);// 刀具部门(0库存,1对刀室,2刃磨室,3,车间)
				tt.setUpdateTime(new Date());
				tt.setUpdateUser(userId);
				tooltransferDao.updateNonQuery(tt);// 更新旧刀
				// 刀具出库履历
				tlh = new Toollibraryhistory();
				tlh.setKnifeInventoryCode(tt1.getKnifeInventoryCode());// 刀具入库编码
				tlh.setReceiveUser(gruantUserID);// grandid 领取人
				tlh.setReceiveTime(new Date());// 领取时间
				tlh.setLibraryCause(IConstant.LIBRARY_CAUSE_1);// 出库原因(0申领1换领2外借)
				tlh.setUpdateTime(new Date());// 更新时间
				tlh.setUpdateUser(userId);// 更新者
				tlh.setCreateTime(new Date());// 创建时间
				tlh.setCreateUser(userId);// 创建者
				tlh.setVersion(BigDecimal.ZERO);// 版本号
				tlh.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分(0有效1删除)
				tlhList.add(tlh);
			}

			/**
			 * 先从流转表中出库，如果不够，再从新刀库中出库
			 */
			if (tfList.size() <= receiveNumber) {
				// 剩余待出库数量
				receiveNumber -= tfList.size();
				Knifeinventory kiEntity = new Knifeinventory();
				kiEntity.setDelFlag(IConstant.DEL_FLAG_0);
				kiEntity.setToolID(ttList.get(0).getToolID());
				kiEntity.setStaIndex(0);
				kiEntity.setRowCount(receiveNumber);
				List<Knifeinventory> kiList = (List<Knifeinventory>) knifeinventoryDao
						.searchByList(kiEntity);

				// 新库加入中刀具流转（新刀）
				for (Knifeinventory ki1 : kiList) {
					// 更新新刀
					ki1.setDelFlag(IConstant.DEL_FLAG_1);
					ki1.setKnifeInventoryCodeWhere(ki1.getKnifeInventoryCode());
					knifeinventoryDao.updateNonQuery(ki1);

					// 记录生命周期
					toolwholelifecycle = new Toolwholelifecycle();
					toolwholelifecycle.setBusinessFlowLnkID(businessFlowLnkID);
					toolwholelifecycle.setHandSetID(handId);
					toolwholelifecycle.setToolCode(toolCode);
					toolwholelifecycle.setToolName(tool.getToolName());
					toolwholelifecycle.setKnifeInventoryCode(ki1
							.getKnifeInventoryCode());
					toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
					toolwholelifecycle.setCreateTime(new Date());
					toolwholelifecycle.setUpdateTime(new Date());
					toolwholelifecycle.setCreateUser(userId);
					toolwholelifecycle.setUpdateUser(userId);
					toolwholelifecycle.setVersion(BigDecimal.ZERO);
					String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue(
							IConstant.TOOLWHOLELIFECYCLE,
							IConstant.TOOLWHOLELIFECYCLEID, userId);
					toolwholelifecycle
							.setToolWholeLifecycleID(toolWholeLifecycleID);
					tlcList.add(toolwholelifecycle);
					// 刀具流转
					tt1 = new Tooltransfer();
					tt1.setRfidContainerID(IConstant.KNIFE_CONTARNERID);
					tt1.setKnifeInventoryCode(ki1.getKnifeInventoryCode());
					delList.add(ki1.getKnifeInventoryCode());// 加入删除的刀具入库编码
					tt1.setToolID(ki1.getToolID());
					tt1.setProcuredBatch(ki1.getProcuredBatch());
					tt1.setBusinessFlowLnkID(businessFlowLnkID);// 最后流程
					//tt1.setToolDurable(tool.getToolDurable());
					tt1.setToolSharpennum(tool.getToolSharpennum());// 刃磨次数
					tt1.setToolSharpenCriterion(tool.getToolSharpenCriterion());
					tt1.setToolLength(tool.getToolLength());
					tt1.setToolSharpenLength(tool.getToolSharpenLength());
					tt1.setUsageCounter(BigDecimal.ZERO);// 已使用(刃磨)次数
					tt1.setToolGrindingLength(BigDecimal.ZERO);// 刀具已刃磨长度
					tt1.setInstallationState(IConstant.INSTALLATION_STATE_0);
					tt1.setToolState(IConstant.TOOL_STATE_9);
					tt1.setReplacementFlag(null);
					tt1.setConfirmedUser(null);
					tt1.setStockState(IConstant.STOCK_STATE_4);
					tt1.setDelFlag(IConstant.DEL_FLAG_0);
					tt1.setUpdateTime(new Date());
					tt1.setUpdateUser(userId);
					tt1.setCreateTime(ki1.getCreateTime());
					tt1.setCreateUser(ki1.getCreateUser());
					tt1.setVersion(BigDecimal.ZERO);
					tt1.setToolThisState(IConstant.STSATIC_ONE);// 刀具部门(0库存,1对刀室,2刃磨室,3,车间)
					ttList1.add(tt1);

					// 刀具流转履历
					tth = new Tooltransferhistory();
					tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(
							IConstant.TOOLTRANSFERHISTORY,
							IConstant.TOOLTRANSFERHISTORYID, userId));
					tth.setRfidContainerID(ki1.getRfidContainerID()); // RFID载体ID
					tth.setKnifeInventoryCode(ki1.getKnifeInventoryCode());// 刀具入库编码
					tth.setToolID(ki1.getToolID());// 刀具ID
					tth.setToolProcuredID(ki1.getProcuredBatch());// 采购ID
					tth.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程(刀具安上)
					tth.setToolDurable(ki1.getToolDurable());// 耐用度
					tth.setToolSharpennum(ki1.getToolDurable());// 可使用(刃磨)次数
					tth.setToolSharpenCriterion(ki1.getToolSharpenCriterion());// 复磨标准
					tth.setToolLength(ki1.getToolLength());// 刀具长度
					tth.setToolSharpenLength(ki1.getToolSharpenLength());// 可刃磨长度
					tth.setUsageCounter(BigDecimal.ZERO);// 已使用(刃磨)次数
					tth.setToolGrindingLength(BigDecimal.ZERO);// 刀具已刃磨长度
					tth.setInstallationState(IConstant.INSTALLATION_STATE_2);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
					tth.setToolState(IConstant.TOOL_STATE_9);// 刀具状态(0断刀1丢失2不合格3借入4申领9其他)
					tth.setoutUser(userId);// 转出人
					tth.setinUser(gruantUserID);// 接收人
					tth.setUpdateTime(new Date());// 更新时间
					tth.setUpdateUser(userId);// 更新者
					tth.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
					tth.setCreateTime(new Date());// 创建时间
					tth.setCreateUser(userId);// 创建者
					tth.setVersion(BigDecimal.ZERO);// 版本号
					tthList.add(tth);

					// 刀具出库履历
					tlh = new Toollibraryhistory();
					tlh.setKnifeInventoryCode(ki1.getKnifeInventoryCode());// 刀具入库编码
					tlh.setReceiveUser(gruantUserID);// 领取人
					tlh.setReceiveTime(new Date());// 领取时间
					tlh.setLibraryCause(IConstant.LIBRARY_CAUSE_1);// 出库原因(0申领1换领2外借)
					tlh.setUpdateTime(new Date());// 更新时间
					tlh.setUpdateUser(userId);// 更新者
					tlh.setCreateTime(new Date());// 创建时间
					tlh.setCreateUser(userId);// 创建者
					tlh.setVersion(BigDecimal.ZERO);// 版本号
					tlh.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分(0有效1删除)
					tlhList.add(tlh);
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
			}
			// 删除出库刀的刀具
			if (delList.size() > 0) {
				map = new HashMap<String, Object>();
				map.put("updateTime ", new Date());
				map.put("userId", userId);
				map.put("list", delList);
				int i = knifeinventoryDao.deleteToolByknifeCode(map);
			}
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (Exception e) {
			e.printStackTrace();
			rtn.put("masg", e.getMessage());
			rtn.put("status", IConstant.RESULT_CODE_1);
			return rtn;
		}

	}

	/**
	 * 刀具送回信息提交
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int rereToolSubmit(Map<String, Object> map) throws Exception {
		List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory>();
		int reVal = 0;
		String userId = map.get("userId").toString();// 用户ID
		List<String> rfidList = (List<String>) map.get("rfids");// rfidList
		String handId = map.get("handerId").toString();// 手持机Id
		List<Tooltransfer> ttList = new ArrayList<Tooltransfer>();

		if (rfidList.size() > 0) {
			// 取得刀具流转信息
			ttList = tooltransferDao.searchHalfByList(rfidList);
		}

		String businessFlowLnkID = null;
		Business business = new Business();
		business.setBusinessCode("C01S003");
		List<Business> businessList = (List<Business>) businessDao
				.searchByList(business);
		business = businessList.get(0);
		Businessflowlnk businessflowlnks = new Businessflowlnk();
		businessflowlnks.setBusinessID(business.getBusinessID());
		List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao
				.searchByList(businessflowlnks);
		// 下一个流程
		businessFlowLnkID = list1.get(0).getBusinessFlowLnkID();
		// }

		Tooltransferhistory tth = null;
		List<Toolwholelifecycle> tlcList = new ArrayList<Toolwholelifecycle>();
		Toolwholelifecycle toolwholelifecycle = null;
		// 刀具流转
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
			toolwholelifecycle
					.setKnifeInventoryCode(tt.getKnifeInventoryCode());
			toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
			toolwholelifecycle.setCreateTime(new Date());
			toolwholelifecycle.setUpdateTime(new Date());
			toolwholelifecycle.setCreateUser(userId);
			toolwholelifecycle.setUpdateUser(userId);
			toolwholelifecycle.setVersion(BigDecimal.ZERO);
			String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue(
					IConstant.TOOLWHOLELIFECYCLE,
					IConstant.TOOLWHOLELIFECYCLEID, userId);
			toolwholelifecycle.setToolWholeLifecycleID(toolWholeLifecycleID);
			tlcList.add(toolwholelifecycle);

			// 刀具流转履历
			tth = new Tooltransferhistory();
			tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(
					IConstant.TOOLTRANSFERHISTORY,
					IConstant.TOOLTRANSFERHISTORYID, userId));
			tth.setRfidContainerID(tt.getRfidContainerID()); // RFID载体ID
			tth.setKnifeInventoryCode(tt.getKnifeInventoryCode());// 刀具入库编码
			tth.setToolID(tt.getToolID());// 刀具ID
			tth.setToolProcuredID(tt.getProcuredBatch());// 采购ID
			tth.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程(刀具安上)
			tth.setToolDurable(tt.getToolDurable());// 耐用度
			tth.setToolSharpennum(tt.getToolDurable());// 可使用(刃磨)次数
			tth.setToolSharpenCriterion(tt.getToolSharpenCriterion());// 复磨标准
			tth.setToolLength(tt.getToolLength());// 刀具长度
			tth.setToolSharpenLength(tt.getToolSharpenLength());// 可刃磨长度
			tth.setUsageCounter(tt.getUsageCounter());// 已使用(刃磨)次数
			tth.setToolGrindingLength(tt.getToolGrindingLength());// 刀具已刃磨长度
			tth.setInstallationState(IConstant.INSTALLATION_STATE_2);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
			tth.setToolState(IConstant.TOOL_STATE_9);// 刀具状态(0断刀1丢失2不合格3借入4申领9其他)
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
		if (tlcList.size() > 0) {
			toolwholelifecycleDao.insertBatchs(tlcList);
		}
		// 批量增加【刀具流转履历】
		if (tthList.size() > 0) {
			tooltransferhistoryDao.insertBatchDefined(tthList);
		}

		Map<String, Object> map2 = new HashMap<String, Object>();
		if (rfidList.size() > 0) {
			// 更新刀具流转
			map2.put("installationState", IConstant.INSTALLATION_STATE_2);
			map2.put("businessFlowLnkID", businessFlowLnkID);
			map2.put("userId", userId);
			map2.put("list", rfidList);
			reVal += tooltransferDao.updateBatchByRfid(map2);
		}

		// 更新换领申请表中的数据 增加送回数量
		List<Redemptionapplied> list = (List<Redemptionapplied>) map
				.get("stockLists");
		Redemptionapplied entity;
		Redemptionapplied tempred = null;// 临时参数
		for (Redemptionapplied ra : list) {
			entity = new Redemptionapplied();
			entity.setDelFlag(IConstant.DEL_FLAG_0);
			entity.setApplyTime(ra.getApplyTime());
			entity.setApplyUser(ra.getApplyUser());
			entity.setToolCode(ra.getToolCode());
			List<Redemptionapplied> findList = (List<Redemptionapplied>) redemptionappliedDao
					.searchByList(entity);
			if (findList.size() > 0) {
				tempred = findList.get(0);
				entity = new Redemptionapplied();
				entity.setToolCodeWhere(ra.getToolCode());// 刀具编码
				entity.setApplyUserWhere(ra.getApplyUser());// 申请人
				entity.setApplyTimeWhere(ra.getApplyTime());// 申请时间
				entity.setDelFlagWhere(IConstant.DEL_FLAG_0);
				entity.setReturnNumber(ra.getReturnNumber());// 送回数量
				// 申请数量=领取数量(刚领取+已领取) = (送回数量+丢刀数量)
				if (tempred.getAppliedNumber().equals(
						tempred.getReceiveNumber())
						&& tempred.getAppliedNumber().equals(
								ra.getReturnNumber().add(
										tempred.getReturnNumber()).add(
										tempred.getLostNumber()))) {
					entity.setProcessingStatus(IConstant.PROCESSING_STATUS_4); // 换领完成
				} else // 申请数量 > 领取数量 &&　申请数量＝（送回数量+丢刀数量）
				if (tempred.getAppliedNumber().intValue() > (tempred
						.getReceiveNumber()).intValue()
						&& tempred.getAppliedNumber().equals(
								ra.getReturnNumber().add(
										tempred.getReturnNumber()).add(
										entity.getReturnNumber()).add(
										tempred.getLostNumber()))) {
					entity.setProcessingStatus(IConstant.STSATIC_TWO); // 换领已送回
				} else // 申请数量 >(送回数量+丢刀数量)
				if (tempred.getAppliedNumber().intValue() > (ra
						.getReturnNumber().add(entity.getReturnNumber()).add(
								tempred.getLostNumber()).intValue())) {
					entity.setProcessingStatus(IConstant.PROCESSING_STATUS_3); // 换领未送回
				}
				entity.setUpdateTime(new Date());
				entity.setUpdateUser(userId);
				entity.setVersion(tempred.getVersion().add(BigDecimal.ONE));
				reVal += redemptionappliedDao.updateNonQuery(entity);
			} else {
				throw new SQLException();
			}
		}
		return reVal;
	}

	/**
	 * 取得已备货的刀具信息
	 * 
	 * @param map
	 *            rfidString RFIDCODE userId 查询人Id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Redemptionapplied getReadiedToolsMessage(Map<String, Object> map)
			throws Exception {
		Redemptionapplied reRed = new Redemptionapplied();
		String rfidString = map.get("rfidString").toString();
		// String userId = map.get("userId").toString();
		try {
			List<Redemptionapplied> redList = redemptionappliedDao
					.getReadiedToolsMessage();
			for (Redemptionapplied red : redList) {
				String rfidlist = red.getRfidList();
				if (rfidlist != null) {
					for (String rfidStr : rfidlist.split(",")) {
						if (rfidString.equals(rfidStr)) {
							reRed.setApplyTime(red.getApplyTime());
							reRed.setApplyUser(red.getApplyUser());
							return reRed;
						}
					}
				}
			}
			reRed.setMessageCode(IConstant.EWMSG0273);
			reRed.setRetErrFlag(true);
		} catch (SQLException e) {
			reRed.setMessageCode(IConstant.EMSG0004);
			reRed.setRetErrFlag(true);
			reRed.setExceMessage(e.getMessage());
		}
		return reRed;
	}

	/**
	 * 根据RFID找到刀具编码
	 * 
	 * @param rfidList
	 * @return List<String>
	 * @title getTClistByRFid
	 */
	public List<String> getTClistByRFid(List<String> rfidList) throws Exception {
		List<String> reList = new ArrayList<String>();
		List<Rfidcontainer> listrf = rfidcontainerDao
				.searchToolCodeByRfid(rfidList);
		if (listrf != null && listrf.size() > 0) {
			for (Rfidcontainer rf : listrf) {
				if (!reList.contains(rf.getToolShelfID())) {
					reList.add(rf.getToolShelfID());
				}
			}
		}
		return reList;
	}

	public void setRedemptionappliedDao(
			RedemptionappliedDao redemptionappliedDao) {
		this.redemptionappliedDao = redemptionappliedDao;
	}

	public void setVgetredemptionappdetailedmsgDao(
			VgetredemptionappdetailedmsgDao vgetredemptionappdetailedmsgDao) {
		this.vgetredemptionappdetailedmsgDao = vgetredemptionappdetailedmsgDao;
	}

	public void setVgetshelfinformationDao(
			VgetshelfinformationDao vgetshelfinformationDao) {
		this.vgetshelfinformationDao = vgetshelfinformationDao;
	}

	public void setTooltransferDao(TooltransferDao tooltransferDao) {
		this.tooltransferDao = tooltransferDao;
	}

	public void setTooltransferhistoryDao(
			TooltransferhistoryDao tooltransferhistoryDao) {
		this.tooltransferhistoryDao = tooltransferhistoryDao;
	}

	public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
		this.rfidcontainerDao = rfidcontainerDao;
	}

	public void setKnifeinventoryDao(KnifeinventoryDao knifeinventoryDao) {
		this.knifeinventoryDao = knifeinventoryDao;
	}

	public void setVbusinessDao(VbusinessDao vbusinessDao) {
		this.vbusinessDao = vbusinessDao;
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

	public void setToolwholelifecycleDao(
			ToolwholelifecycleDao toolwholelifecycleDao) {
		this.toolwholelifecycleDao = toolwholelifecycleDao;
	}

	public void setToollibraryhistoryDao(
			ToollibraryhistoryDao toollibraryhistoryDao) {
		this.toollibraryhistoryDao = toollibraryhistoryDao;
	}

	/**
	 * 非单品-获取换领出库申请人
	 */
	@Override
	public Map<String, Object> getApplyUser() {
		Map<String, Object> ret = new HashMap<String, Object>();
		try {
			Redemptionapplied entity = new Redemptionapplied();
			List<Redemptionapplied> list =  redemptionappliedDao.getApplyUser(entity);
			if (list == null || list.size() <= 0) {
				// 查无换领申请
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
	 * 非单品-获取换领出库申请单
	 */
	@Override
	public Map<String, Object> getRedemptionappliedListCodeByUserid() {
		Map<String, Object> ret = new HashMap<String, Object>();
		try {
			Redemptionapplied entity = new Redemptionapplied();
			List<Redemptionapplied> list = (List<Redemptionapplied>) redemptionappliedDao
					.getRedemptionappliedListCodeByUserid(entity);
			if (list == null || list.size() <= 0) {
				// 查无换领
				ret.put("MessageCode", IConstant.EMSG0004);
				ret.put("message", "查无换领");
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
	 * 非单品--换领出库
	 */
	@Override
	public Map<String, Object> updateRedemptionApplied(
			Redemptionapplied redemptionapplied) throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();
		try {
			Redemptionapplied entity = new Redemptionapplied();
			entity.setApplyUser(redemptionapplied.getApplyUser());// 申请人
			entity.setToolCode(redemptionapplied.getToolCode());// 刀具编码
			entity.setToolCode(redemptionapplied.getToolCode());// 刀具编码
			List<Redemptionapplied> list = (List<Redemptionapplied>) redemptionappliedDao
					.searchByList_Redemption(entity);
			if (list == null || list.size() <= 0) {
				// 查无换领
				ret.put("MessageCode", IConstant.EMSG0004);
				ret.put("message", "查无换领申请");
				ret.put("status", IConstant.RESULT_CODE_1);
				return ret;
			} else {
				int receiveTotalNumber = redemptionapplied.getReceiveNumber()
						.intValue();// 页面传递的申请总数
				for (Redemptionapplied redemptionapplied2 : list) {
					int AppliedNumber = redemptionapplied2.getAppliedNumber()
							.intValue();// 申请数量
					int receiveNumber = redemptionapplied2.getReceiveNumber()
							.intValue();// 领取数量
					if (receiveTotalNumber >= (AppliedNumber - receiveNumber)) {
						redemptionapplied2.setReceiveNumber(new BigDecimal(
								AppliedNumber));
						receiveTotalNumber -= (AppliedNumber - receiveNumber);
					} else if (receiveTotalNumber <= 0) {
						break;
					} else if (receiveTotalNumber < (AppliedNumber - receiveNumber)) {
						redemptionapplied2.setReceiveNumber(new BigDecimal(
								receiveTotalNumber + receiveNumber));
						receiveTotalNumber = 0;
					}
					redemptionapplied2
							.setRedemptionAppliedIDWhere(redemptionapplied2
									.getRedemptionAppliedID());
					// 领取人
					redemptionapplied2.setReceiveUser(redemptionapplied
							.getReceiveUser());
					redemptionapplied2.setReceiveTime(new Date());
					redemptionappliedDao.updateNonQuery(redemptionapplied2);
				}
				if (receiveTotalNumber < 0) {
					ret.put("status", IConstant.RESULT_CODE_2);
					ret.put("MessageCode", IConstant.EMSG0004); // 换领申请单更新异常
				}

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
	 * 取得刀具参数信息
	 * 
	 * @param entity
	 * @return
	 */
	public Vquerytoollist findToolInfo(Vquerytoollist entity) {
		try {
			String RFIDString = entity.getRfidCode();
			String toolCode = null;
			if (RFIDString != null && !"".equals(RFIDString)) {
				toolCode = getToolCodeByRFIDString(RFIDString);
			}
			if (toolCode != null && !"".equals(toolCode)) {
				entity.setToolCode(toolCode);
				entity.setlblCode(null);
				entity.setRfidCode(null);
			}
			List<Vquerytoollist> list = (List<Vquerytoollist>) vquerytoollistDao
					.searchByQueryList(entity);
			if (list == null || list.size() <= 0) {
				// 刀具参数未找到相应数据!
				entity.setMessageCode(IConstant.WMSG0122);
				entity.setRetErrFlag(true);
				return entity;
			} else {
				return list.get(0);
			}

		} catch (SQLException e) {
			// 数据库操作异常，查询失败!
			entity.setMessageCode(IConstant.EMSG0004);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			return entity;
		}
	}

	/**
	 * 根据RFID查询对应的刀具编码 (只支持单品刀具)
	 * 
	 * @param RFIDString
	 * @return
	 */
	public String getToolCodeByRFIDString(String RFIDString)
			throws SQLException {
		// 查询RFID载体
		Rfidcontainer rfidcontainer = new Rfidcontainer();
		rfidcontainer.setRfidCode(RFIDString);
		rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
		List<Rfidcontainer> rfList = (List<Rfidcontainer>) rfidcontainerDao
				.searchByList(rfidcontainer);
		if (rfList.size() > 0) {
			// 载体ID
			String rfidContainerId = rfList.get(0).getRfidContainerID();
			// 查询rfid是不是单品刀具
			Knifeinventory ki = new Knifeinventory();
			ki.setRfidContainerID(rfidContainerId);
			List<Knifeinventory> kiList = (List<Knifeinventory>) knifeinventoryDao
					.searchByList(ki);
			if (kiList.size() > 0) {
				Tool tool = new Tool();
				tool.setToolID(kiList.get(0).getToolID());
				// tool.setDelFlag(IConstant.DEL_FLAG_0);
				List<Tool> tools = (List<Tool>) toolDao.searchByList(tool);
				if (tools.size() > 0)
					return tools.get(0).getToolCode();
			}

			// 初始化的单品刀具
			Tooltransfer tt = new Tooltransfer();
			tt.setRfidContainerID(rfidContainerId);
			List<Tooltransfer> ttList = (List<Tooltransfer>) tooltransferDao
					.searchByList(tt);
			if (ttList.size() > 0) {
				Tool tool = new Tool();
				tool.setToolID(ttList.get(0).getToolID());
				tool.setDelFlag(IConstant.DEL_FLAG_0);
				List<Tool> tools = (List<Tool>) toolDao.searchByList(tool);
				if (tools.size() > 0)
					return tools.get(0).getToolCode();
			}
		}
		return null;
	}

	/**
	 * 查询用户是否存在
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public Redemptionapplied searchUserExit(Redemptionapplied entity) {
		try {
			List<Redemptionapplied> list = (List<Redemptionapplied>) redemptionappliedDao
					.searchByList(entity);
			if (list == null || list.size() <= 0) {
				// 您所查询的RFID类型不存在!
				Redemptionapplied userdetail = new Redemptionapplied();
				userdetail.setMessageCode(IConstant.WMSG0122);
				userdetail.setRetErrFlag(true);
				return userdetail;
			} else {
				return list.get(0);
			}

		} catch (SQLException e) {
			// 数据库操作异常，查询失败!
			Redemptionapplied userdetail = new Redemptionapplied();
			userdetail.setMessageCode(IConstant.EMSG0004);
			userdetail.setRetErrFlag(true);
			userdetail.setExceMessage(e.getMessage());
			return userdetail;
		}
	}

	/**
	 * 取得换领申请人申请信息
	 * 
	 * @param
	 * @return
	 */
	@Override
	public Map<String, Object> getApplyInfo(Redemptionapplied entity) throws Exception {
		Map<String, Object> ret = new HashMap<String, Object>();
		try {
			Redemptionapplied raentity = new Redemptionapplied();
			// 申请人
			raentity.setApplyUser(entity.getApplyUser());
			// 删除区分(0有效1删除)
			raentity.setDelFlag(IConstant.DEL_FLAG_0);
			List<Redemptionapplied> list =  redemptionappliedDao.getApplyInfo(raentity);
			if (list == null || list.size() <= 0) {
				// 查无换领
				ret.put("MessageCode", IConstant.EMSG0004);
				ret.put("message", "查无换领");
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
	 * 取得新刀库存信息
	 * 
	 * @param
	 * @return
	 */
	@Override
	public Knifeinventory searchToolIn(Knifeinventory entity)
			throws SQLException {
		List<Knifeinventory> reList = (List<Knifeinventory>) knifeinventoryDao
				.searchByList(entity);
		Knifeinventory reEntity = new Knifeinventory();
		if (reList.size() < 1) {
			// 未找到相应数据
			reEntity.setRetErrFlag(true);
		} else {
			reEntity = reList.get(0);
		}
		return reEntity;
	}

	/**
	 * 取得要换领出库的刀具信息
	 * 
	 * @param
	 * @return
	 * @throws SQLException 
	 */
	@Override
	public Tool getRedemptionapplyInfo(Tool entity) throws SQLException {
		Tool tl = new Tool();
		tl.setToolID(entity.getToolID());
		List<Tool> reList = (List<Tool>) toolDao.getRedemptionapplyInfo(tl);
		Tool tlEntity = new Tool();
		if (reList.size() < 1) {
			// 未找到相应数据
			tlEntity.setRetErrFlag(true);
		} else {
			tlEntity = reList.get(0);
		}
		return tlEntity;
	}

	/**
	 * 提交换领出库的刀具信息
	 * 
	 * @param
	 * @return
	 * @throws SQLException 
	 */
	@Override
	public Map<String, Object> saveRedemptionapplyInfo(List<Map<String, Object>> toolList)
			throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		//出库总数量
		int countA = 0;
		//优先处理的换领申请单的领取数量
		int countB = 0;
		//优先处理的换领申请单的申请数量
		int countC = 0;
		//保存出库总数量
		int countD = 0;

		Toolwholelifecycle toolwholelifecycle = null;
		List<Toolwholelifecycle> twlList = new ArrayList<Toolwholelifecycle>();
		for (Map<String, Object> map : toolList) {
			String userID = map.get("CustomerID").toString();
			String signID = map.get("SignID").toString();
			//手持机id
			String handSetID = map.get("HandSetID").toString();
			//消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀具9其他
			String toolConsumetype = map.get("ToolConsumetype").toString();
			//刀具id
			String toolID = map.get("ToolID").toString();
			//rfidCode
			String rfidCode = map.get("RfidCode").toString();
			//出库总数量
			countA = Integer.parseInt(map.get("ReceiveCount")==null?IConstant.STRING_0:map.get("ReceiveCount").toString());
			countD = countA;
//			String rfidContainerID = map.get("RfidContainerID").toString();
//			// 取得刀具流转表的丢刀数量
//			Tooltransfer entity = new Tooltransfer();
//			entity.setRfidContainerID(rfidContainerID);
//			entity.setToolID(map.get("ToolID").toString());
//			entity.setDelFlag(IConstant.DEL_FLAG_0);
//			entity.setToolState(IConstant.DEL_FLAG_1);
//			List<Tooltransfer> findList = (List<Tooltransfer>) tooltransferDao.searchByList(entity);
//			// 丢刀数量
//			int lostTool = 0;
//			if (findList.size() > 0) {
//				BigDecimal count = findList.get(0).getToolDurable();
//				// 丢刀数量
//				if (null==findList.get(0).getToolDurable()){
//					count = BigDecimal.ZERO;
//				}
//				lostTool =count.intValue();
//			}
			while (countA > 0) {
				// 取得换领申请的信息
				Redemptionapplied reentity = new Redemptionapplied();
				// 刀具编码
				reentity.setToolCode(map.get("MaterialNum").toString());
				// 选择创建时间与当前时间距离最远的换领申请单优先处理
				reentity.setOrderString("CreateTime");
				reentity.setDelFlag(IConstant.DEL_FLAG_0);
				List<Redemptionapplied> redempList = (List<Redemptionapplied>) redemptionappliedDao
						.searchByList(reentity);
				// 优先处理的换领申请单的领取数量
				countB = Integer.parseInt(redempList.get(0).getReceiveNumber() == null ? IConstant.STRING_0: redempList.get(0).getReceiveNumber().toString());
				// 优先处理的换领申请单的申请数量
				countC = Integer.parseInt(redempList.get(0).getAppliedNumber() == null ? IConstant.STRING_0: redempList.get(0).getAppliedNumber().toString());

				if (redempList.size() > 0) {
					if (countA + countB <= countC) {
						// 只处理一张换领申请单就足够了
						Redemptionapplied ra = new Redemptionapplied();
						// 更新条件：换领申请流水号
						ra.setRedemptionAppliedIDWhere(redempList.get(0).getRedemptionAppliedID());
						// 丢失数量
						// ra.setLostNumber(new BigDecimal(lostTool));
						// 领取数量
						ra.setReceiveNumber(new BigDecimal(countA + countB));
						// 领取人
						ra.setReceiveUser(signID);
						// 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )
						ra.setProcessingStatus(IConstant.DEL_FLAG_0);
						if (countA + countB == countC) {
							// 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )
							ra.setProcessingStatus(IConstant.STRING_4);
							ra.setDelFlag(IConstant.DEL_FLAG_1);
						}
						ra.setReceiveTime(new Date());
						ra.setUpdateTime(new Date());
						ra.setUpdateUser(userID);
						redemptionappliedDao.updateNonQuery(ra);
						// 出库数量变为0
						countA = 0;
					} else {
						// 一张换领申请单的(申请数量-领取数量)小于出库总数量
						Redemptionapplied ra2 = new Redemptionapplied();
						// 更新条件：换领申请流水号
						ra2.setRedemptionAppliedIDWhere(redempList.get(0).getRedemptionAppliedID());
						// 领取数量
						ra2.setReceiveNumber(new BigDecimal(countC));
						// 领取人
						ra2.setReceiveUser(signID);
						// 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )
						ra2.setProcessingStatus(IConstant.STRING_4);
						ra2.setDelFlag(IConstant.DEL_FLAG_1);
						ra2.setReceiveTime(new Date());
						ra2.setUpdateTime(new Date());
						ra2.setUpdateUser(userID);
						redemptionappliedDao.updateNonQuery(ra2);

						// 剩余出库总数量=出库总数量-(一张换领单的申请数量-一张换领单的领取数量)
						countA = countA - (countC - countB);
					}
				} else {
					result.put("status", IConstant.RESULT_CODE_2);
					// 数据库操作异常,查询失败!
					result.put("messagetext", "刀具换领出库失败");
					return result;
				}
			}
			
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
					//更新流转表
					//先查询原有的周转量
					Tooltransfer tt = new Tooltransfer();
					tt.setRfidContainerID(ccList.get(0).getRfidContainerID());
					tt.setToolID(toolID);
					tt.setToolState(IConstant.STRING_4);
					tt.setDelFlag(IConstant.STRING_0);
					List<Tooltransfer> ttList = (List<Tooltransfer>) tooltransferDao.searchByList(tt);
					if (ttList.size()>0) {
						BigDecimal number = ttList.get(0).getToolDurable();
						tt.setRfidContainerIDWhere(ccList.get(0).getRfidContainerID());
						tt.setToolIDWhere(toolID);
						tt.setToolStateWhere(IConstant.STRING_4);
						tt.setDelFlagWhere(IConstant.STRING_0);
						tt.setToolDurable(number.add(new BigDecimal(countD)));
						tooltransferDao.updateNonQuery(tt);
					}
					
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
				tt.setBusinessFlowLnkID(IConstant.C01S003);//换领出库
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
					k.setKnifelnventoryNumber((Integer.parseInt(number)-countD)+"");
					knifeinventoryDao.updateNonQuery(k);
				}
				
				// 刀具入库编码
				knifeCode = kiList.get(0).getKnifeInventoryCode();
				
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
				}
				
				// 刀具入库编码
				knifeCode = kiList.get(0).getKnifeInventoryCode();
				
				toolwholelifecycle = new Toolwholelifecycle();
				//生命周期id
                toolwholelifecycle.setToolWholeLifecycleID(UUIDgen.getId());
                //刀具入库编码
                toolwholelifecycle.setKnifeInventoryCode(String.valueOf(knifeCode));
                //流程id
                toolwholelifecycle.setBusinessFlowLnkID(IConstant.C01S003);
                //手持机id
                toolwholelifecycle.setHandSetID(handSetID);
                //刀具id
                toolwholelifecycle.setToolID(toolID);
                //零部件id
                toolwholelifecycle.setPartsID("");
                //加工数量
                toolwholelifecycle.setProcessAmount("0");
                //删除区分(0有效1删除)
                toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
                //更新时间
                toolwholelifecycle.setUpdateTime(new Date());
                //更新者
                toolwholelifecycle.setUpdateUser(userID);
                //创建时间
                toolwholelifecycle.setCreateTime(new Date());
                //创建者
                toolwholelifecycle.setCreateUser(userID);
                //刃磨次数
                toolwholelifecycle.setVersion(BigDecimal.ZERO);
                twlList.add(toolwholelifecycle);
                
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
				tlentity.setReceiveCount(new BigDecimal(countD));
			}else {
				tlentity.setReceiveCount(BigDecimal.ONE);
			}
			// 领取时间
			tlentity.setReceiveTime(new Date());
			// 出库原因(0申领1换领2外借)
			tlentity.setLibraryCause(IConstant.DEL_FLAG_1);
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
		result.put("messagetext", "刀具换领出库成功");
		return result;
	}

	@Override
	public List<Knifeinventory> getKnifeinventoryInfo(Knifeinventory ki) throws Exception {
		List<Knifeinventory> kiList = (List<Knifeinventory>) knifeinventoryDao.searchByList(ki);
		return kiList;
	}

}
