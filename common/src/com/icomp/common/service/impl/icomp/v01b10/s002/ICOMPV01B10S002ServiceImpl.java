package com.icomp.common.service.impl.icomp.v01b10.s002;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b10.s002.ICOMPV01B10S002Service;
import com.icomp.dao.DisplayeditemconfigurationDao;
import com.icomp.dao.VsystemlogDao;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vsystemlog;

public class ICOMPV01B10S002ServiceImpl extends BaseService implements ICOMPV01B10S002Service {

	/**
	 * 系统显示项目配置(兼顾打印项目)
	 */
	private DisplayeditemconfigurationDao displayeditemconfigurationDao;

	public void setDisplayeditemconfigurationDao(
			DisplayeditemconfigurationDao displayeditemconfigurationDao) {
		this.displayeditemconfigurationDao = displayeditemconfigurationDao;
	}

	/**
	 * 手持机日志DAO接口
	 */
	private VsystemlogDao vsystemlogDao;
	
	public void setVsystemlogDao(VsystemlogDao vsystemlogDao) {
		this.vsystemlogDao = vsystemlogDao;
	}

	/**
	 * 手持机日志列表
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Vsystemlog entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vsystemlog> list = (List<Vsystemlog>) vsystemlogDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vsystemlog>();
				Vsystemlog vsystemlog = new Vsystemlog();
				//消息：检索为0
				vsystemlog.setMessageCode(IConstant.EMSG0001);
				vsystemlog.setRetErrFlag(true);
				list.add(vsystemlog);
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
			Vsystemlog vsystemlog = new Vsystemlog();
			//错误消息：数据库操作异常，查询失败!
			vsystemlog.setMessageCode(IConstant.EMSG0004);
			vsystemlog.setRetErrFlag(true);
			vsystemlog.setExceMessage(e.getMessage());
			list.add(vsystemlog);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}

	/**
	 * 取得页面grid显示项目列表
	 * @param pageID
	 * @param lang
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getGridColmun(String pageID,String langCode, String langValue){
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			Displayeditemconfiguration entity = new Displayeditemconfiguration();
			entity.setPageName(pageID);
			entity.setLanguageCode(langCode);
			
			List<Displayeditemconfiguration> list = (List<Displayeditemconfiguration>) displayeditemconfigurationDao.searchByList(entity);
			if (list.size() <= 0) {
				// 列表取得失败!
				list = new ArrayList<Displayeditemconfiguration>();
				Displayeditemconfiguration displayeditemconfiguration = new Displayeditemconfiguration();
				displayeditemconfiguration.setMessageCode(IConstant.WMSG0008);
				displayeditemconfiguration.setRetErrFlag(true);
				list.add(displayeditemconfiguration);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				for (Displayeditemconfiguration displayeditemconfiguration : list) {
					rtn.put(displayeditemconfiguration.getColName(), IConstant.DISPLAYED_FLAG_0.equals(displayeditemconfiguration.getDisplayedFlag()) ? true : false);
				}
				return rtn;
			}
		} catch (SQLException e) {
			List<Displayeditemconfiguration> list = new ArrayList<Displayeditemconfiguration>();
			Displayeditemconfiguration displayeditemconfiguration = new Displayeditemconfiguration();
			//错误消息：数据库操作异常，查询失败!
			displayeditemconfiguration.setMessageCode(IConstant.EMSG0004);
			displayeditemconfiguration.setRetErrFlag(true);
			displayeditemconfiguration.setExceMessage(e.getMessage());
			list.add(displayeditemconfiguration);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
	
		}
	}

}
