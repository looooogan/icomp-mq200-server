package com.icomp.common.service.impl.icomp.v01b10.s003;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b10.s003.ICOMPV01B10S003Service;
import com.icomp.dao.DisplayeditemconfigurationDao;
import com.icomp.dao.VsystemlogDao;
import com.icomp.entity.base.Vsystemlog;

public class ICOMPV01B10S003ServiceImpl extends BaseService implements ICOMPV01B10S003Service {

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
	 * 管理平台日志DAO接口
	 */
	private VsystemlogDao vsystemlogDao;
	
	public void setVsystemlogDao(VsystemlogDao vsystemlogDao) {
		this.vsystemlogDao = vsystemlogDao;
	}


	/**
	 * 管理平台日志列表
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Vsystemlog entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vsystemlog> list = (List<Vsystemlog>) vsystemlogDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vsystemlog>();
				Vsystemlog systemlog = new Vsystemlog();
				//消息：检索为0
				systemlog.setMessageCode(IConstant.EMSG0001);
				systemlog.setRetErrFlag(true);
				list.add(systemlog);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vsystemlogDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vsystemlog> list = new ArrayList<Vsystemlog>();
			Vsystemlog systemlog = new Vsystemlog();
			//错误消息：数据库操作异常，查询失败!
			systemlog.setMessageCode(IConstant.EMSG0004);
			systemlog.setRetErrFlag(true);
			systemlog.setExceMessage(e.getMessage());
			list.add(systemlog);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}

}
