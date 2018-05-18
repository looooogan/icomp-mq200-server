package com.icomp.common.service.impl.icomp.v01b06.s004;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b06.s004.ICOMPV01B06S004Service;
import com.icomp.dao.SubAvgProcessAmountDao;
import com.icomp.dao.ToolDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.VtoolplancountDao;
import com.icomp.dao.VtoolsupplierDao;
import com.icomp.entity.base.SubAvgProcessAmount;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Vtoolplancount;
import com.icomp.entity.base.Vtoolsupplier;
import com.icomp.entity.base.Vtoolsupplieranalysis;

/**
 * 刀具供应商分析SERVICE实现类
 * 
 * @ClassName: ICOMPV01B06S004ServiceImpl
 * @author Taoyy
 * @date 2014-8-22 上午09:52:28
 */

public class ICOMPV01B06S004ServiceImpl extends BaseService implements
		ICOMPV01B06S004Service {

	private VtoolsupplierDao vtoolsupplierDao;

	public void setVtoolsupplierDao(VtoolsupplierDao vtoolsupplierDao) {
		this.vtoolsupplierDao = vtoolsupplierDao;
	}

	private SubAvgProcessAmountDao subAvgProcessAmountDao;

	public void setSubAvgProcessAmountDao(
			SubAvgProcessAmountDao subAvgProcessAmountDao) {
		this.subAvgProcessAmountDao = subAvgProcessAmountDao;
	}

	private ToolDao toolDao;

	public void setToolDao(ToolDao toolDao) {
		this.toolDao = toolDao;
	}
	
	private TooltransferDao tooltransferDao;

	public void setTooltransferDao(TooltransferDao tooltransferDao) {
		this.tooltransferDao = tooltransferDao;
	}
	
	private VtoolplancountDao vtoolplancountDao;
	public void setVtoolplancountDao(VtoolplancountDao vtoolplancountDao) {
		this.vtoolplancountDao = vtoolplancountDao;
	}

	/**
	 * 刀具供应商分析
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Vtoolsupplier entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			// 列表
			List<Vtoolsupplier> list = (List<Vtoolsupplier>) vtoolsupplierDao
					.searchByList_F(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vtoolsupplier>();
				Vtoolsupplier vtoolsupplier = new Vtoolsupplier();
				vtoolsupplier.setMessageCode(IConstant.EMSG0001);
				vtoolsupplier.setRetErrFlag(true);
				list.add(vtoolsupplier);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				// 总数量
				int total = vtoolsupplierDao.searchByCount(entity);
				for (Vtoolsupplier vtoolsupplier : list) {
					String toolCode = vtoolsupplier.getToolCode();
					// 取得 平均加工数量
					SubAvgProcessAmount subAvgProcessAmount = new SubAvgProcessAmount();
					subAvgProcessAmount.setToolCode(toolCode);
					List<SubAvgProcessAmount> subAvgProcessAmountList = (List<SubAvgProcessAmount>) subAvgProcessAmountDao
							.searchByList(subAvgProcessAmount);
					BigDecimal avgProcessAmount = BigDecimal.ZERO;
					if (subAvgProcessAmountList.size() > 0) {
						// 平均产量
						avgProcessAmount = subAvgProcessAmountList.get(0)
								.getAvgProcessAmount();
					}
					vtoolsupplier.setAvgCount(avgProcessAmount);
					// 取得 单次加工成本
					BigDecimal unitPrice = BigDecimal.ZERO;
					// 取得 异常报废
					BigDecimal excDiscarde = BigDecimal.ZERO;
					Tool tool = new Tool();
					tool.setToolCode(toolCode);
					List<Tool> toolList = (List<Tool>) toolDao
							.searchByList(tool);
					tool = toolList.get(0);
					Tooltransfer tooltransfer = new Tooltransfer();
					tooltransfer.setToolID(tool.getToolID());
					tooltransfer.setStockState(IConstant.STOCK_STATE_1);
					List<Tooltransfer> tooltransferList = (List<Tooltransfer>)tooltransferDao.searchByList(tooltransfer);//取得库存所有可流转刀具
					if(vtoolsupplier.getUnitPrice() == null)
					{
						vtoolsupplier.setUnitPrice(BigDecimal.ZERO);
					}
					// 可刃磨钻头
					if (IConstant.TOOL_CONSUME_TYPE_0.equals(tool
							.getToolConsumetype())) {
						if(avgProcessAmount.equals(BigDecimal.ZERO)){
							if(tool.getQuotaProcessingVolume()!=null&&tool.getQuotaProcessingVolume().doubleValue()!=0)
							unitPrice = vtoolsupplier.getUnitPrice().divide(tool.getQuotaProcessingVolume(),2,BigDecimal.ROUND_HALF_DOWN);
						}else{
						unitPrice = vtoolsupplier.getUnitPrice().divide(avgProcessAmount,2,BigDecimal.ROUND_HALF_DOWN);
						}
						for(Tooltransfer temp : tooltransferList){
							if(temp.getToolSharpenLength().floatValue() > 0){
								excDiscarde.add(BigDecimal.ONE);
							}
						}
					} else if (IConstant.TOOL_CONSUME_TYPE_2.equals(tool
							.getToolConsumetype())
							|| IConstant.TOOL_CONSUME_TYPE_1.equals(tool
									.getToolConsumetype())) {
						// 一次性刀片、可刃磨刀片
						if(avgProcessAmount.equals(BigDecimal.ZERO)){
							if(tool.getQuotaProcessingVolume()!=null&&tool.getQuotaProcessingVolume().doubleValue()!=0)
							unitPrice = vtoolsupplier.getUnitPrice().divide(tool.getQuotaProcessingVolume(),2,BigDecimal.ROUND_HALF_DOWN);
						}else{
							if(avgProcessAmount.doubleValue()!=0)
							unitPrice = vtoolsupplier.getUnitPrice().divide(avgProcessAmount,2,BigDecimal.ROUND_HALF_DOWN);
						}
						for(Tooltransfer temp : tooltransferList){
							if(temp.getToolSharpennum().intValue() > 0){
								excDiscarde.add(BigDecimal.ONE);
							}
						}
					}
					vtoolsupplier.setUnitCount(unitPrice);
					// 取得 异常报废比
					if(vtoolsupplier.getDiscardeCount().equals(BigDecimal.ZERO)){
						excDiscarde = vtoolsupplier.getDiscardeCount();
					}else{
						
						excDiscarde = excDiscarde.divide(vtoolsupplier.getDiscardeCount(),2,BigDecimal.ROUND_HALF_DOWN);
					}
					vtoolsupplier.setExcDiscarde(excDiscarde);
					// 取得到货计划总数、按时及提前到货数
					Vtoolplancount vtoolplancount = new Vtoolplancount();
					vtoolplancount.setToolCode(toolCode);
					List<Vtoolplancount> vtoolplancountList = (List<Vtoolplancount>)vtoolplancountDao.searchByList(vtoolplancount);
					vtoolplancount = vtoolplancountList.get(0);
					// 到货周期准确率
					BigDecimal plan = BigDecimal.ZERO;
					if(vtoolplancount.getPlanCount().equals(BigDecimal.ZERO)){
						plan = vtoolplancount.getPlanCount();
					}else{
						
						plan = vtoolplancount.getSubCount().divide(vtoolplancount.getPlanCount(),2,BigDecimal.ROUND_HALF_DOWN);
					}
					vtoolsupplier.setPlan(plan);
				}
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE)
						/ IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vtoolsupplier> list = new ArrayList<Vtoolsupplier>();
			entity = new Vtoolsupplier();
			entity.setMessageCode(IConstant.EMSG0004);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			list.add(entity);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}

	/**
	 * 单品加工量值
	 * 
	 * @title getAvgCount
	 * @param v
	 * @return String
	 */
	@SuppressWarnings("unused")
	private String getAvgCount(Vtoolsupplieranalysis v) {
		DecimalFormat df = new DecimalFormat("#");
		Double double1 = 0.0;
		if (v.getToolProcessingVolume() != null && v.getConsumedCount() != null) {
			double1 = ((v.getToolProcessingVolume().doubleValue()) / (v
					.getConsumedCount().doubleValue()));
		}
		return df.format(double1);
	}

	/**
	 * 刀具供应商分析统计数量
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String getStatisticalCount(Vtoolsupplier entity) {
		// 提前送到
		int i = 0;
		// 准时送到
		int j = 0;
		// 延误送到
		int k = 0;
		try {
			// 列表
			List<Vtoolsupplier> list = (List<Vtoolsupplier>) vtoolsupplierDao
					.searchByList(entity);
				// 总数量
				for (Vtoolsupplier vtoolsupplier : list) {
					// 实际到达时间 < 预计到达时间
				 if(vtoolsupplier.getRealityTheyTime()!=null&&vtoolsupplier.getTheyTime()!=null){
						if (vtoolsupplier.getRealityTheyTime().getTime() <vtoolsupplier.getTheyTime()
								.getTime()) {
							i++;
						} else if (vtoolsupplier.getRealityTheyTime().getTime() == vtoolsupplier
								.getRealityTheyTime().getTime()) {
							j++;
						} else {
							k++;
						}
				 }
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i + "," + j + "," + k;
	}
}
