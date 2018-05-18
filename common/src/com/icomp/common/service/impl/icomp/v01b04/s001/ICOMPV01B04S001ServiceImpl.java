package com.icomp.common.service.impl.icomp.v01b04.s001;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b04.s001.ICOMPV01B04S001Service;
import com.icomp.dao.VworkloadqueriesDao;
import com.icomp.entity.base.Vworkloadqueries;

/**
 * 工作量查询SERVICE实现类
 * @ClassName: ICOMPV01B03S001ServiceImpl
 * @author Taoyy
 * @date 2014-8-20 下午03:41:04
 */
public class ICOMPV01B04S001ServiceImpl extends BaseService implements ICOMPV01B04S001Service {
	/**
	 * 工作量查询DAO
	 */
	private VworkloadqueriesDao vworkloadqueriesDao;

	public void setVworkloadqueriesDao(VworkloadqueriesDao vworkloadqueriesDao) {
		this.vworkloadqueriesDao = vworkloadqueriesDao;
	}
	public Map<String, Object> getAssemblyLineNameList(Vworkloadqueries entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vworkloadqueries> list = (List<Vworkloadqueries>) vworkloadqueriesDao.searchAssemblyLineNameByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vworkloadqueries>();
				Vworkloadqueries vworkloadqueries = new Vworkloadqueries();
				vworkloadqueries.setMessageCode(IConstant.EMSG0001);
				vworkloadqueries.setRetErrFlag(true);
				list.add(vworkloadqueries);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vworkloadqueriesDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vworkloadqueries> list = new ArrayList<Vworkloadqueries>();
			Vworkloadqueries vworkloadqueries = new Vworkloadqueries();
			vworkloadqueries.setMessageCode(IConstant.EMSG0004);
			vworkloadqueries.setRetErrFlag(true);
			vworkloadqueries.setExceMessage(e.getMessage());
			list.add(vworkloadqueries);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
	
	public Map<String, Object> getProcessNameList(Vworkloadqueries entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vworkloadqueries> list = (List<Vworkloadqueries>) vworkloadqueriesDao.searchProcessNameByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vworkloadqueries>();
				Vworkloadqueries vworkloadqueries = new Vworkloadqueries();
				vworkloadqueries.setMessageCode(IConstant.EMSG0001);
				vworkloadqueries.setRetErrFlag(true);
				list.add(vworkloadqueries);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vworkloadqueriesDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vworkloadqueries> list = new ArrayList<Vworkloadqueries>();
			Vworkloadqueries vworkloadqueries = new Vworkloadqueries();
			vworkloadqueries.setMessageCode(IConstant.EMSG0004);
			vworkloadqueries.setRetErrFlag(true);
			vworkloadqueries.setExceMessage(e.getMessage());
			list.add(vworkloadqueries);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Vworkloadqueries entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vworkloadqueries> list = (List<Vworkloadqueries>) vworkloadqueriesDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vworkloadqueries>();
				Vworkloadqueries vworkloadqueries = new Vworkloadqueries();
				vworkloadqueries.setMessageCode(IConstant.EMSG0001);
				vworkloadqueries.setRetErrFlag(true);
				list.add(vworkloadqueries);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vworkloadqueriesDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vworkloadqueries> list = new ArrayList<Vworkloadqueries>();
			Vworkloadqueries vworkloadqueries = new Vworkloadqueries();
			vworkloadqueries.setMessageCode(IConstant.EMSG0004);
			vworkloadqueries.setRetErrFlag(true);
			vworkloadqueries.setExceMessage(e.getMessage());
			list.add(vworkloadqueries);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}


}
