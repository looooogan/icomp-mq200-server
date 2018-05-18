package com.icomp.common.service.impl.icomp.v01c01.s015;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s015.ICOMPV01C01S015Service;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.BusinessDao;
import com.icomp.dao.BusinessflowlnkDao;
import com.icomp.dao.ToolDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.TooltransferhistoryDao;
import com.icomp.dao.ToolwholelifecycleDao;
import com.icomp.dao.VgetbacktoollibraryDao;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Businessflowlnk;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Tooltransferhistory;
import com.icomp.entity.base.Toolwholelifecycle;
import com.icomp.entity.base.Vgetbacktoollibrary;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 回库刀具处理-Service实现类
 * @ClassName: ICOMPV01C01S015ServiceImpl 
 * @author Taoyy
 * @date 2014-10-14 上午11:31:00
 */
public class ICOMPV01C01S015ServiceImpl  extends BaseService implements ICOMPV01C01S015Service{
	
	/**
	 * 取得回库刀具处理信息Dao
	 */
	private VgetbacktoollibraryDao vgetbacktoollibraryDao;
	public void setVgetbacktoollibraryDao(VgetbacktoollibraryDao vgetbacktoollibraryDao) {
		this.vgetbacktoollibraryDao = vgetbacktoollibraryDao;
	}
	/**
	 * 刀具流转
	 */
	private TooltransferDao tooltransferDao;
	public void setTooltransferDao(TooltransferDao tooltransferDao) {
		this.tooltransferDao = tooltransferDao;
	}


	// 取得当前刀具的最后执行业务流程
	private BusinessflowlnkDao businessflowlnkDao;
	// 取得业务流程ID
	private BusinessDao businessDao;
	public void setBusinessflowlnkDao(BusinessflowlnkDao businessflowlnkDao) {
		this.businessflowlnkDao = businessflowlnkDao;
	}

	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}

	// 生命周期
	private ToolwholelifecycleDao toolwholelifecycleDao;
	public void setToolwholelifecycleDao(ToolwholelifecycleDao toolwholelifecycleDao) {
		this.toolwholelifecycleDao = toolwholelifecycleDao;
	}

	public void setTooltransferhistoryDao(
			TooltransferhistoryDao tooltransferhistoryDao) {
		this.tooltransferhistoryDao = tooltransferhistoryDao;
	}
	//刀具流转履历
	private TooltransferhistoryDao tooltransferhistoryDao;

	// 刀具参数
	private ToolDao toolDao;
	public void setToolDao(ToolDao toolDao) {
		this.toolDao = toolDao;
	}

	/**
	 * 取得回库刀具处理信息
	 * getToolInfo
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Vgetbacktoollibrary getToolInfo(Vgetbacktoollibrary entity)throws Exception {
		Vgetbacktoollibrary vgetbacktoollibrary = new Vgetbacktoollibrary();
		try {
			//取得回库刀具处理信息
			List<Vgetbacktoollibrary>  list = (List<Vgetbacktoollibrary>)vgetbacktoollibraryDao.searchByList(entity);
			if(list == null || list.size() == 0){
				//回库刀具处理未找到相应数据!
				vgetbacktoollibrary.setMessageCode(IConstant.WMSG0138);
				vgetbacktoollibrary.setRetErrFlag(true);
			}else {
				//检索成功
				vgetbacktoollibrary.setMessageCode(IConstant.IMSG0001);
				vgetbacktoollibrary.setRetErrFlag(false);
				vgetbacktoollibrary = list.get(0);
				//可刃磨长度  < 复磨标准 = 到寿
				if (vgetbacktoollibrary.getToolSharpenLength().doubleValue() <  vgetbacktoollibrary.getToolSharpenCriterion().doubleValue()) {
					vgetbacktoollibrary.setToolState(IConstant.STRING_5);
				}
			}
		} catch (SQLException e) {
			//数据库操作异常，查询失败!
			vgetbacktoollibrary.setMessageCode(IConstant.EMSG0004);
			vgetbacktoollibrary.setRetErrFlag(true);
			vgetbacktoollibrary.setExceMessage(e.getMessage());
		}
		return vgetbacktoollibrary;
	}

	/**
	 * 提交刀具报废确认（RFID载体ID，确认人）
	 * toolScrapConfirmation
	 * @param rfidContainerID
	 * @param customerID
	 * @return
	 * @throws SQLException 
	 */
	@Override
	public int toolScrapConfirmation(String rfidContainerID, String customerID) throws SQLException {
		Tooltransfer tt1 = new Tooltransfer();//查询条件
		tt1.setRfidContainerID(rfidContainerID);//载体Id
		tt1 = (Tooltransfer)tooltransferDao.searchByList(tt1).get(0);//查询
		Tooltransfer tt2 = new Tooltransfer();//修改条件
		tt2.setRfidContainerIDWhere(rfidContainerID);
		//要修改的数据 
		tt2.setConfirmedUser(customerID);//确认人
		tt2.setStockState(IConstant.STOCK_STATE_0);//库存状态(0正常1报废2返厂3封存9其他)
		tt2.setUpdateTime(new Date());//更新时间
		tt2.setUpdateUser(customerID);//更新者
		tt2.setVersion(new BigDecimal(tt1.getVersion().intValue()+1));//版本号
		return tooltransferDao.updateNonQuery(tt2);
	}
	/**
	 * 刀具回B库处理（最后执行业务流程）
	 * saveToolInfo
	 * @param tooltransfer
	 * @param handId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int saveToolInfo(Tooltransfer tooltransfer,String handId,String userId) throws Exception {
		Tooltransfer tt1 = new Tooltransfer();//查询条件
		tt1.setRfidContainerID(tooltransfer.getRfidContainerID());//载体Id
		List<Tooltransfer> list = (List<Tooltransfer>)tooltransferDao.searchByList(tt1);//查询
		tt1 = list.get(0);
		Tooltransfer tt2 = new Tooltransfer();//修改条件
		tt2.setRfidContainerIDWhere(tt1.getRfidContainerID());
		// 取得业务流程下一个ID
		Business business = new Business();
		business.setBusinessCode("C01S015");
		List<Business> businessList = (List<Business>) businessDao.searchByList(business);
		business = businessList.get(0);
		Businessflowlnk businessflowlnks = new Businessflowlnk();
		businessflowlnks.setBusinessID(business.getBusinessID());
		List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnks);
		businessflowlnks = list1.get(0);
		
		Toolwholelifecycle toolwholelifecycle = null;
		List<Toolwholelifecycle> tlcList = new ArrayList<Toolwholelifecycle>();
		Tooltransferhistory tth = null;
		List<Tooltransferhistory>  tthList = new ArrayList<Tooltransferhistory>();
		// 取得刀具信息
		Tool tool = new Tool();
		tool.setToolID(tt1.getToolID());
		List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
		tool = toolList.get(0);
		// 刀具流转信息
		for (Tooltransfer tt : list) {
			// 记录刀具生命周期数据
			toolwholelifecycle = new Toolwholelifecycle();
			toolwholelifecycle.setBusinessFlowLnkID(businessflowlnks.getBusinessFlowLnkID());
			toolwholelifecycle.setHandSetID(handId);
			
			toolwholelifecycle.setToolCode(tool.getToolCode());
			toolwholelifecycle.setToolName(tool.getToolName());
			toolwholelifecycle.setKnifeInventoryCode(tt.getKnifeInventoryCode());
			toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
			toolwholelifecycle.setCreateTime(new Date());
			toolwholelifecycle.setUpdateTime(new Date());
			toolwholelifecycle.setCreateUser(userId);
			toolwholelifecycle.setUpdateUser(userId);
			toolwholelifecycle.setVersion(BigDecimal.ZERO);
			toolwholelifecycle.setToolWholeLifecycleID(
					NextKeyValue.getNextkeyvalue(IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, userId));
			tlcList.add(toolwholelifecycle);
			
			//添加刀具流转履历
			tth = new Tooltransferhistory();
			tth.setToolTransferHistoryID(NextKeyValue.getNextkeyvalue(IConstant.TOOL_TRANSFER_HISTORY, IConstant.TOOL_TRANSFER_HISTORY_ID, userId));		// id
			tth.setRfidContainerID(tt.getRfidContainerID());	// RFID载体ID
			tth.setKnifeInventoryCode(tt.getKnifeInventoryCode());	// 刀具入库编码
			tth.setToolID(tt.getToolID());// 刀具ID
			tth.setToolProcuredID(tt.getProcuredBatch());	// 采购ID
			tth.setBusinessFlowLnkID(businessflowlnks.getBusinessFlowLnkID());// 最后执行业务流程(刀具安上)
			tth.setToolDurable(tt.getToolDurable());// 耐用度
			tth.setToolSharpennum(tt.getToolDurable());// 可使用(刃磨)次数
			tth.setToolSharpenCriterion(tt.getToolSharpenCriterion());	// 复磨标准
			tth.setToolLength(tt.getToolLength());// 刀具长度
			tth.setToolSharpenLength(tt.getToolSharpenLength());// 可刃磨长度
			tth.setUsageCounter(tt.getUsageCounter());	// 已使用(刃磨)次数
			tth.setToolGrindingLength(tt.getToolGrindingLength());// 刀具已刃磨长度
			tth.setInstallationState(IConstant.INSTALLATION_STATE_1);// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
            tth.setStockState(IConstant.STOCK_STATE_4);
			tth.setDelFlag(IConstant.DEL_FLAG_0);	// 删除区分
			tth.setCreateTime(new Date());// 创建时间
			tth.setCreateUser(userId);	// 创建者
			tth.setVersion(BigDecimal.ZERO);// 版本号
			tthList.add( tth);
		}

		//批量添加【生命周期】
		toolwholelifecycleDao.insertBatchs(tlcList);
		//批量添加【刀具流转履历】
		tooltransferhistoryDao.insertBatchDefined(tthList);
		
		tt2.setBusinessFlowLnkID(businessflowlnks.getBusinessFlowLnkID());
		//要修改的数据 
		tt2.setConfirmedUser(tooltransfer.getConfirmedUser());//确认人
		if(!IConstant.STRING_0.equals(tool.getToolConsumetype()) && !IConstant.STRING_1.equals(tool.getToolConsumetype())){
			tt2.setStockState(IConstant.STOCK_STATE_1);//库存状态(0正常1报废2返厂3封存9其他)
		}
		tt2.setUpdateTime(new Date());//更新时间
		tt2.setUpdateUser(userId);//更新者
		tt2.setVersion(new BigDecimal(tt1.getVersion().intValue()+1));//版本号
		return tooltransferDao.updateNonQuery(tt2);
		
		
		
	}

}
