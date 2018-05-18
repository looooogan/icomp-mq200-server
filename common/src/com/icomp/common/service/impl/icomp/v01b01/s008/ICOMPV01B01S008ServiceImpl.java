package com.icomp.common.service.impl.icomp.v01b01.s008;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b01.s008.ICOMPV01B01S008Service;
import com.icomp.dao.DisplayeditemconfigurationDao;
import com.icomp.dao.VpurchaseplanDao;
import com.icomp.entity.base.Vpurchaseplan;
/**
 * 采购计划查询SERVICE实现类
 * @ClassName: ICOMPV01B01S008ServiceImpl 
 * @author Taoyy
 * @date 2014-8-15 下午03:20:48
 */
public class ICOMPV01B01S008ServiceImpl extends BaseService implements ICOMPV01B01S008Service {

	/**
	 * 系统显示项目配置(兼顾打印项目)
	 */
	@SuppressWarnings("unused")
	private DisplayeditemconfigurationDao displayeditemconfigurationDao;

	public void setDisplayeditemconfigurationDao(
			DisplayeditemconfigurationDao displayeditemconfigurationDao) {
		this.displayeditemconfigurationDao = displayeditemconfigurationDao;
	}
	/**
	 * 采购计划查询Dao
	 */
	private VpurchaseplanDao vpurchaseplanDao;
	public void setVpurchaseplanDao(VpurchaseplanDao vpurchaseplanDao) {
		this.vpurchaseplanDao = vpurchaseplanDao;
	}



	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 采购计划查询列表
	 */
	public Map<String, Object> getList(Vpurchaseplan entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vpurchaseplan> list = (List<Vpurchaseplan>) vpurchaseplanDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vpurchaseplan>();
				Vpurchaseplan vpurchaseplan = new Vpurchaseplan();
				vpurchaseplan.setMessageCode(IConstant.EMSG0001);
				vpurchaseplan.setRetErrFlag(true);
				list.add(vpurchaseplan);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				for (Vpurchaseplan vp : list) {
					//金额= 采购数量 * 单价
					vp.setAmountMoney((vp.getProcuredCount().doubleValue()*vp.getUnitPrice().doubleValue())+"");
				}
				int total = vpurchaseplanDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vpurchaseplan> list = new ArrayList<Vpurchaseplan>();
			Vpurchaseplan vpurchaseplan = new Vpurchaseplan();
			vpurchaseplan.setMessageCode(IConstant.EMSG0004);
			vpurchaseplan.setRetErrFlag(true);
			vpurchaseplan.setExceMessage(e.getMessage());
			list.add(vpurchaseplan);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}

}
