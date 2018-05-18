package com.icomp.common.service.impl.icomp.v01b01.s010;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b01.s010.ICOMPV01B01S010Service;
import com.icomp.dao.SubToolAvgToolSharpennumDao;
import com.icomp.dao.SubToolProcessAmountDao;
import com.icomp.dao.VtoolquicksearchDao;
import com.icomp.entity.base.SubToolAvgToolSharpennum;
import com.icomp.entity.base.SubToolProcessAmount;
import com.icomp.entity.base.Vinventoryalarm;
import com.icomp.entity.base.Vtoolquicksearch;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 库存信息快速查询SERVICE实现类
 * @ClassName: ICOMPV01B01S010ServiceImpl 
 * @author Taoyy
 * @date 2014-8-15 下午05:05:31
 */
public class ICOMPV01B01S010ServiceImpl extends BaseService implements ICOMPV01B01S010Service {


	/**
	 * 库存信息快速查询Dao
	 */
	private VtoolquicksearchDao vtoolquicksearchDao;
	public void setVtoolquicksearchDao(VtoolquicksearchDao vtoolquicksearchDao) {
		this.vtoolquicksearchDao = vtoolquicksearchDao;
	}
    
	/**
	 * 刀具每天平均使用次数
	 */
	private SubToolAvgToolSharpennumDao subToolAvgToolSharpennumDao;
	
	public void setSubToolAvgToolSharpennumDao(
			SubToolAvgToolSharpennumDao subToolAvgToolSharpennumDao) {
		this.subToolAvgToolSharpennumDao = subToolAvgToolSharpennumDao;
	}
	
	/**
	 * 刀具平均使用寿命
	 */
	private SubToolProcessAmountDao subToolProcessAmountDao;
	
	public void setSubToolProcessAmountDao(
			SubToolProcessAmountDao subToolProcessAmountDao) {
		this.subToolProcessAmountDao = subToolProcessAmountDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 库存信息快速查询列表-ToolCode模糊查询
	 */
	public Map<String, Object> getList(Vtoolquicksearch entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//ToolCode模糊查询
			List<Vtoolquicksearch> list = (List<Vtoolquicksearch>) vtoolquicksearchDao.searchByList_F(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vtoolquicksearch>();
				Vtoolquicksearch vtoolquicksearch = new Vtoolquicksearch();
				vtoolquicksearch.setMessageCode(IConstant.EMSG0001);
				vtoolquicksearch.setRetErrFlag(true);
				list.add(vtoolquicksearch);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				@SuppressWarnings("unused")
				List<Vinventoryalarm> resultList = new ArrayList<Vinventoryalarm>();
				for(Vtoolquicksearch temp : list){
					// 根据刀具编码取得 该类刀具的安上次数及间隔天数
					SubToolProcessAmount subToolProcessAmount = new SubToolProcessAmount();
					subToolProcessAmount.setToolCode(temp.getToolCode());
					List<SubToolProcessAmount> subToolProcessAmountList = (List<SubToolProcessAmount>) subToolProcessAmountDao
							.searchByList(subToolProcessAmount);
					String staTime = IConstant.STRING_0, endTime = IConstant.STRING_1;
					if (subToolProcessAmountList.size() > 0) {
						if (subToolProcessAmountList.get(0).getLoadTime() != null
								&& !subToolProcessAmountList.get(0)
										.getLoadTime().equals("")) {
							staTime = subToolProcessAmountList.get(0)
									.getLoadTime(); // 开始时间
							endTime = subToolProcessAmountList.get(
									subToolProcessAmountList.size() - 1)
									.getLoadTime();// 结束时间
						}
					}
					// 间隔天数
					int loadTime = Integer.parseInt(endTime)
							- Integer.parseInt(staTime);
					int loadCount = 0; // 安装次数
					for (SubToolProcessAmount subToolProcessAmountEntity : subToolProcessAmountList) {
						loadCount += subToolProcessAmountEntity.getLoadCount()
								.intValue();
					}
					// 平均每天使用刀具次数
					int avgToolCount=0;
					if(loadTime!=0){
						avgToolCount = loadCount / loadTime;
					}

					SubToolAvgToolSharpennum subToolAvgToolSharpennum = new SubToolAvgToolSharpennum();
					subToolAvgToolSharpennum.setToolCode(temp.getToolCode());
					List<SubToolAvgToolSharpennum> subToolAvgToolSharpennumList = (List<SubToolAvgToolSharpennum>) subToolAvgToolSharpennumDao
							.searchByList(subToolAvgToolSharpennum);
					int purchasingCycle = 30;// 初始值
					int avgcs = 1;// 初始值
					if (subToolAvgToolSharpennumList.size() > 0) {
						// 采购周期(天数)
						purchasingCycle = subToolAvgToolSharpennumList.get(0)
								.getPurchasingCycle().intValue();
						// 刀具平均使用次数
						avgcs = subToolAvgToolSharpennumList.get(0).getAvgcs()
								.intValue();
					} else {

					}
					if (avgcs != 0 && avgToolCount != 0 && purchasingCycle != 0) {// 如果分母或分子不等于0,才更新周转量
						// 周转量= 采购周期(天) * 平均每天使用刀具次数/刀具平均使用次数
						int toolTurnover = purchasingCycle * avgToolCount/ avgcs;
						// 赋值周转量
						temp.setToolTurnover(new BigDecimal(toolTurnover));
					}
				}
				for (Vtoolquicksearch vq : list) {
					//金额= 采购数量 * 单价
					if(vq.getInventory()==null)vq.setInventory(BigDecimal.ZERO);
					if(vq.getUnitPrice()==null)vq.setUnitPrice(BigDecimal.ZERO);
					vq.setAmountMoney((vq.getInventory().doubleValue()*vq.getUnitPrice().doubleValue())+"");
				}
				int total = vtoolquicksearchDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vtoolquicksearch> list = new ArrayList<Vtoolquicksearch>();
			Vtoolquicksearch vtoolquicksearch = new Vtoolquicksearch();
			vtoolquicksearch.setMessageCode(IConstant.EMSG0004);
			vtoolquicksearch.setRetErrFlag(true);
			vtoolquicksearch.setExceMessage(e.getMessage());
			list.add(vtoolquicksearch);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
		
		
		
	}

}
