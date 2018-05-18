package com.icomp.common.service.impl.icomp.v01c01.s009;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s009.ICOMPV01C01S009Service;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.*;
import com.icomp.entity.base.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

/**
 * 刀具送回车间-Serviecs实现类
 * @ClassName: ICOMPV01C01S009ServiceImpl
 * @author Taoyy
 * @date 2014-9-29 上午11:23:39
 */
public class ICOMPV01C01S009ServiceImpl extends BaseService implements ICOMPV01C01S009Service {

	/**
	 * 取得待送回车间信息Dao
	 */
	private VgetbackworkshopmagDao vgetbackworkshopmagDao;

	public void setVgetbackworkshopmagDao(VgetbackworkshopmagDao vgetbackworkshopmagDao) {
		this.vgetbackworkshopmagDao = vgetbackworkshopmagDao;
	}

	/**
	 * 合成刀库Dao
	 */
	private SynthesisknifeDao synthesisknifeDao;

	public void setSynthesisknifeDao(SynthesisknifeDao synthesisknifeDao) {
		this.synthesisknifeDao = synthesisknifeDao;
	}

	/**
	 * 业务-流程中间表Dao
	 */
	private BusinessflowlnkDao businessflowlnkDao;

	public void setBusinessflowlnkDao(BusinessflowlnkDao businessflowlnkDao) {
		this.businessflowlnkDao = businessflowlnkDao;
	}

	/**
	 * 合成刀流转履历Dao
	 */
	private SynthesisexperienceDao synthesisexperienceDao;

	public void setSynthesisexperienceDao(SynthesisexperienceDao synthesisexperienceDao) {
		this.synthesisexperienceDao = synthesisexperienceDao;
	}

	// 刀具流转
	private TooltransferDao tooltransferDao;

	public void setTooltransferDao(TooltransferDao tooltransferDao) {
		this.tooltransferDao = tooltransferDao;
	}

	// 流程
	private BusinessDao businessDao;

	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}

	// 刀具参数
	private ToolDao toolDao;

	public void setToolDao(ToolDao toolDao) {
		this.toolDao = toolDao;
	}

	// 刀具流转履历
	private TooltransferhistoryDao tooltransferhistoryDao;

	public void setTooltransferhistoryDao(TooltransferhistoryDao tooltransferhistoryDao) {
		this.tooltransferhistoryDao = tooltransferhistoryDao;
	}

	// 生命周期
	private ToolwholelifecycleDao toolwholelifecycleDao;

	public void setToolwholelifecycleDao(ToolwholelifecycleDao toolwholelifecycleDao) {
		this.toolwholelifecycleDao = toolwholelifecycleDao;
	}

	private RfidcontainerDao rfidcontainerDao;

	/**
	 * 取得待送回车间信息 getBackWorkshopMag
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vgetbackworkshopmag> getBackWorkshopMag(Vgetbackworkshopmag entity) throws Exception {
		List<Vgetbackworkshopmag> retList = new ArrayList<Vgetbackworkshopmag>();
		try {
			List<Vgetbackworkshopmag> list = (List<Vgetbackworkshopmag>) vgetbackworkshopmagDao.searchByList(entity);
			if (list == null || list.size() <= 0) { // 没有数据!
				Vgetbackworkshopmag vgetbackworkshopmag = new Vgetbackworkshopmag();
				vgetbackworkshopmag.setMessageCode(IConstant.WMSG0131_1);
				vgetbackworkshopmag.setRetErrFlag(true);
				retList.add(vgetbackworkshopmag);
			} else {
				List<String> flowlinks = new ArrayList<String>();
				Business business = new Business();
				business.setBusinessCode("C01S009");
				List<Business> businessList = (List<Business>) businessDao.searchByList(business);
				business = businessList.get(0);
				Businessflowlnk businessflowlnks = new Businessflowlnk();
				businessflowlnks.setBusinessID(business.getBusinessID());
				List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);
				for (Businessflowlnk businessflowlnk : list1) {
					businessflowlnks = new Businessflowlnk();
					businessflowlnks.setBusinessFlowID(businessflowlnk.getBusinessFlowID());
					businessflowlnks.setOrderNumber(businessflowlnk.getOrderNumber().subtract(BigDecimal.ONE));
					List<Businessflowlnk> tempList = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);
					if (tempList.size() > 0) {
						businessflowlnks = new Businessflowlnk();
						businessflowlnks.setBusinessID(tempList.get(0).getBusinessID());
						tempList = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);
						for (Businessflowlnk businessflowlnk2 : tempList) {
							flowlinks.add(businessflowlnk2.getBusinessFlowLnkID());
						}

					}
				}
				business = new Business();
				business.setBusinessCode("C03S001");
				businessList = (List<Business>) businessDao.searchByList(business);
				business = businessList.get(0);
				businessflowlnks = new Businessflowlnk();
				businessflowlnks.setBusinessID(business.getBusinessID());
				list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);
				for (Businessflowlnk businessflowlnk : list1) {
					flowlinks.add(businessflowlnk.getBusinessFlowLnkID());
				}
				business = new Business();
				business.setBusinessCode("C03S002");
				businessList = (List<Business>) businessDao.searchByList(business);
				business = businessList.get(0);
				businessflowlnks = new Businessflowlnk();
				businessflowlnks.setBusinessID(business.getBusinessID());
				list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);
				for (Businessflowlnk businessflowlnk : list1) {
					flowlinks.add(businessflowlnk.getBusinessFlowLnkID());
				}

				for (Vgetbackworkshopmag vgetbackworkshopmag : list) {
					if (flowlinks.contains(vgetbackworkshopmag.getBusinessFlowLnkID())) {
						retList.add(vgetbackworkshopmag);
					}
				}
			}
		} catch (SQLException e) {
			// 数据库操作异常，查询失败!
			Vgetbackworkshopmag vgetbackworkshopmag = new Vgetbackworkshopmag();
			vgetbackworkshopmag.setMessageCode(IConstant.EMSG0004);
			vgetbackworkshopmag.setRetErrFlag(true);
			vgetbackworkshopmag.setExceMessage(e.getMessage());
			retList.add(vgetbackworkshopmag);
		}
		return retList;
	}

	/**
	 * 根据合成刀具编码修改相应的合成刀库状态 saveSynthesisToolInfo
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int saveSynthesisToolInfo(Map<String, Object> map) throws Exception {
		int reVal = 0;
		Synthesisexperience se = null;// 合成刀流转履历实体

		String userId = map.get("CustomerID").toString();// 当前用户ID
		String handsetid = map.get("handsetid").toString();// 手持机ID
		List<String> rfidList = (List<String>) map.get("listRfid");// RFidList
		// List<String> synCodeList = (List<String>) map.get("synCodeList");

		// 所有要更新的合成刀库
		List<Synthesisknife> skAllList = new ArrayList<Synthesisknife>();
		for (String rfidString : rfidList) {
			// 载体id
			Rfidcontainer rfidcontainer = new Rfidcontainer();
			rfidcontainer.setRfidCode(rfidString);
			rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
			rfidcontainer = (Rfidcontainer) rfidcontainerDao.searchByList(rfidcontainer).get(0);
			String rfidconString = rfidcontainer.getRfidContainerID();
			Synthesisknife sk = new Synthesisknife();
			Synthesisknife sk1 = new Synthesisknife();
			// 合成刀库
			sk.setrFID(rfidconString);
			sk.setDelFlag(IConstant.DEL_FLAG_0);
			sk = (Synthesisknife) synthesisknifeDao.searchByList(sk).get(0);
			sk1.setSynthesisParametersCode(sk.getSynthesisParametersCode());
			sk1.setSynthesisParametersNumber(sk.getSynthesisParametersNumber());
			sk1.setDelFlag(IConstant.DEL_FLAG_0);
			skAllList.addAll((List<Synthesisknife>) synthesisknifeDao.searchByList(sk1));
		}

		// 取得刀具流转信息
		List<Tooltransfer> ttList = tooltransferDao.searchHalfByList(rfidList);
		Tooltransfer tooltransfer = new Tooltransfer();
		// 取得当前刀具的最后执行业务流程
		Businessflowlnk businessflowlnk = new Businessflowlnk();
		tooltransfer = ttList.get(0);
		businessflowlnk.setBusinessFlowLnkID(tooltransfer.getBusinessFlowLnkID());
		// Businessflowlnk flowLink = (Businessflowlnk)
		// businessflowlnkDao.searchByPrimaryKey(businessflowlnk);
		// 取得业务流程ID
		Business business = new Business();
		business.setBusinessCode("C01S009");
		List<Business> businessList = (List<Business>) businessDao.searchByList(business);
		business = businessList.get(0);
		Businessflowlnk businessflowlnks = new Businessflowlnk();
		businessflowlnks.setBusinessID(business.getBusinessID());
		List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);
		businessflowlnk = list1.get(0);
		// businessflowlnks.setBusinessID(flowLink.getBusinessID());
		// List<Businessflowlnk> list2 = (List<Businessflowlnk>)
		// businessflowlnkDao
		// .searchByList(businessflowlnks);
		// for (Businessflowlnk temp1 : list1) {
		// for (Businessflowlnk temp2 : list2) {
		// if (temp1.getBusinessFlowID().equals(temp2.getBusinessFlowID())
		// && temp1.getOrderNumber().intValue() == temp2
		// .getOrderNumber().add(BigDecimal.ONE)
		// .intValue()) {
		// businessflowlnk = temp1;
		// }
		// }
		// }
		// 下一个流程
		String businessFlowLnkID = businessflowlnk.getBusinessFlowLnkID();

		Tooltransferhistory tth = null;
		List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory>();
		List<Toolwholelifecycle> twlList = new ArrayList<Toolwholelifecycle>();
		Toolwholelifecycle toolwholelifecycle = null;
		Tool tool = null;

		// 刀具流转
		for (Tooltransfer tt : ttList) {
			// 记录生命周期
			toolwholelifecycle = new Toolwholelifecycle();
			toolwholelifecycle.setBusinessFlowLnkID(businessFlowLnkID);
			toolwholelifecycle.setHandSetID(handsetid);
			// 取得刀具信息
			tool = new Tool();
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
			toolwholelifecycle.setUpdateUser(userId);
			toolwholelifecycle.setVersion(BigDecimal.ZERO);
			toolwholelifecycle.setToolWholeLifecycleID(NextKeyValue.getNextkeyvalue(IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, userId));
			twlList.add(toolwholelifecycle);

			// 刀具流转履历
			tth = new Tooltransferhistory();
			tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(IConstant.TOOLTRANSFERHISTORY, IConstant.TOOLTRANSFERHISTORYID, userId));
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
			/*
			 * //更新以前的载体Id为当前的载体Id Tooltransferhistory tth1 = new
			 * Tooltransferhistory();
			 * tth1.setRfidContainerID(tt.getRfidContainerID());
			 * tth1.setKnifeInventoryCodeWhere(tt.getKnifeInventoryCode());
			 * tooltransferhistoryDao.updateNonQuery(tth1);
			 */
		}
		// 批量增加生命周期
		toolwholelifecycleDao.insertBatchs(twlList);
		// 批量增加【刀具流转履历】
		tooltransferhistoryDao.insertBatchDefined(tthList);
		// 更新刀具流转
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("installationState", IConstant.INSTALLATION_STATE_1);
		map2.put("businessFlowLnkID", businessFlowLnkID);
		map2.put("userId", userId);
		map2.put("list", rfidList);
		reVal += tooltransferDao.updateBatchByRfid(map2);

		// 更新合成刀库
		map2 = new HashMap<String, Object>();
		// 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回)(该状态绑定到带标签的数据上)
		map2.put("loadState", IConstant.LOADSTATE_1);
		map2.put("businessFlowLnkID", businessFlowLnkID);
		map2.put("userId", userId);
		map2.put("list", rfidList);
		reVal += synthesisknifeDao.updateBatchByRfid(map2);

		List<Synthesisexperience> list = new ArrayList<Synthesisexperience>();
		// 获取合成刀库列表
		for (Synthesisknife sk : skAllList) {
			se = new Synthesisexperience();
			se.setSynthesisParametersCode(sk.getSynthesisParametersCode());// 合成刀具编码
			se.setSynthesisCutterNumber(sk.getSynthesisCutterNumber());// 位置号
			se.setSynthesisParametersNumber(sk.getSynthesisParametersNumber()); // 合成刀具编号(例如：001、002、003)
			se.setBusinessFlowLnkID(businessFlowLnkID);// 最后执行业务流程
			se.setOperationTime(new Date());// 操作时间
			se.setArrivalUser(ttList.get(0).getUpdateUser());// 转出人
			se.setRecipientUser(userId);// 接收人
			se.setTransitionBecause(IConstant.TRANSITION_BECAUSE_0);// 交接原因(0送入车间1旧刀回收2不合格送回3对刀)
			se.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分(0有效1删除)
			se.setUpdateTime(new Date());// 更新时间
			se.setUpdateUser(userId);// 更新者
			se.setCreateTime(new Date());// 创建时间
			se.setCreateUser(userId);// 创建者
			se.setVersion(BigDecimal.ZERO);// 版本号
			list.add(se);// 添加到履历list中
		}
		// 批量添加合成刀流转履
		synthesisexperienceDao.batchInsert(list);
		return reVal;
	}

	public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
		this.rfidcontainerDao = rfidcontainerDao;
	}

}
