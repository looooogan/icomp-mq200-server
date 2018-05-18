package com.icomp.common.service.impl.icomp.v01b07.s003;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b07.s003.ICOMPV01B07S003Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.dao.DisplayeditemconfigurationDao;
import com.icomp.dao.ProcurementplansDao;
import com.icomp.dao.ToolprocuredDao;
import com.icomp.dao.VsuggestionpurchaseplanDao;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Procurementplans;
import com.icomp.entity.base.Toolprocured;
import com.icomp.entity.base.Vsuggestionpurchaseplan;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 采购计划处理SERVICE实现类
 * 
 * @ClassName: ICOMPV01B07S003ServiceImpl
 * @author Taoyy
 * @date 2014-9-13 下午03:00:24
 */
@SuppressWarnings("unchecked")
public class ICOMPV01B07S003ServiceImpl extends BaseService implements ICOMPV01B07S003Service {

	
	/**
	 * 系统显示项目配置(兼顾打印项目)
	 */
	private DisplayeditemconfigurationDao displayeditemconfigurationDao;

	public void setDisplayeditemconfigurationDao(DisplayeditemconfigurationDao displayeditemconfigurationDao) {
		this.displayeditemconfigurationDao = displayeditemconfigurationDao;
	}

	/**
	 * 采购计划处理DAO
	 */
	private VsuggestionpurchaseplanDao vsuggestionpurchaseplanDao;

	public void setVsuggestionpurchaseplanDao(VsuggestionpurchaseplanDao vsuggestionpurchaseplanDao) {
		this.vsuggestionpurchaseplanDao = vsuggestionpurchaseplanDao;
	}
	
	/**
	 * 采购计划DAO
	 */
	private ProcurementplansDao procurementplansDao;
	public void setProcurementplansDao(ProcurementplansDao procurementplansDao) {
		this.procurementplansDao = procurementplansDao;
	}
	/**
	 * 刀具采购DAO
	 */
	private ToolprocuredDao toolprocuredDao;
	public ToolprocuredDao getToolprocuredDao() {
		return toolprocuredDao;
	}

	public void setToolprocuredDao(ToolprocuredDao toolprocuredDao) {
		this.toolprocuredDao = toolprocuredDao;
	}

	@Override
	/**
	 * 采购计划处理列表
	 */
	public Map<String, Object> getList(Vsuggestionpurchaseplan entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vsuggestionpurchaseplan> list = (List<Vsuggestionpurchaseplan>) vsuggestionpurchaseplanDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vsuggestionpurchaseplan>();
				Vsuggestionpurchaseplan vsuggestionpurchaseplan = new Vsuggestionpurchaseplan();
				vsuggestionpurchaseplan.setMessageCode(IConstant.EMSG0001);
				vsuggestionpurchaseplan.setRetErrFlag(true);
				list.add(vsuggestionpurchaseplan);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vsuggestionpurchaseplanDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vsuggestionpurchaseplan> list = new ArrayList<Vsuggestionpurchaseplan>();
			Vsuggestionpurchaseplan vsuggestionpurchaseplan = new Vsuggestionpurchaseplan();
			vsuggestionpurchaseplan.setMessageCode(IConstant.EMSG0004);
			vsuggestionpurchaseplan.setRetErrFlag(true);
			vsuggestionpurchaseplan.setExceMessage(e.getMessage());
			list.add(vsuggestionpurchaseplan);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}

	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param lang
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID, String lang) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			Displayeditemconfiguration entity = new Displayeditemconfiguration();
			entity.setPageName(pageID);
			entity.setLanguageCode(lang);

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
			// 错误消息：数据库操作异常,查询失败!
			displayeditemconfiguration.setMessageCode(IConstant.EMSG0004);
			displayeditemconfiguration.setRetErrFlag(true);
			displayeditemconfiguration.setExceMessage(e.getMessage());
			list.add(displayeditemconfiguration);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;

		}
	}

	/**
	 * 取得待采购计划信息
	 */
	@Override
	public List<Vsuggestionpurchaseplan> getProcurementInfo(Vsuggestionpurchaseplan entity) {
		try {
			List<Vsuggestionpurchaseplan> list = (List<Vsuggestionpurchaseplan>) vsuggestionpurchaseplanDao.searchByList(entity);
			if(list == null || list.size() <= 0){
				//该用户无可用权限,请联系系统管理员!
				list = new ArrayList<Vsuggestionpurchaseplan>();
				Vsuggestionpurchaseplan vsuggestionpurchaseplan = new Vsuggestionpurchaseplan();
				vsuggestionpurchaseplan.setMessageCode(IConstant.EMSG0003);
				vsuggestionpurchaseplan.setRetErrFlag(true);
				list.add(vsuggestionpurchaseplan);
				return list;
			}else{
				return list;
			}

		} catch (SQLException e) {
			List<Vsuggestionpurchaseplan> list = new ArrayList<Vsuggestionpurchaseplan>();
			Vsuggestionpurchaseplan vsuggestionpurchaseplan = new Vsuggestionpurchaseplan();
			// 错误消息：数据库操作异常,查询失败!
			vsuggestionpurchaseplan.setMessageCode(IConstant.EMSG0004);
			vsuggestionpurchaseplan.setRetErrFlag(true);
			vsuggestionpurchaseplan.setExceMessage(e.getMessage());
			list.add(vsuggestionpurchaseplan);
			return list;
		}
	}

	/**
	 * 启用采购计划提交
	 */
	@Override
	public Map<String, Object> saveAll(List<Toolprocured> list, String langCode,String pString,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			// 批量增加到刀具采购表中
		//	toolprocuredDao.batchInsert(list);
			//删除采购计划
			Procurementplans entity = new Procurementplans(); 
			entity.setDelFlag(IConstant.DEL_FLAG_1);
			entity.setProcurementPlansCodeWhere(pString);
			procurementplansDao.updateNonQuery(entity);
			//插入成功 返回信息
			rtn.put("message", MessageReSource.getMessageBox(IConstant.IMSG0004, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			Procurementplans entity = new Procurementplans();
			// 错误消息：数据库操作异常,插入失败!
			entity.setMessageCode(IConstant.EMSG0007);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			rtn.put("message", MessageReSource.getMessageBox(IConstant.EMSG0007, langCode,langValue));
			//rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		}
	}
	/**
	 * 建议采购计划删除
	 * @title procurementPlansDel 
	 * @return
	 * String
	 */

	@Override
	public Map<String, Object> procurementPlansDel(Procurementplans entity,
			String langCode, String langValue) {
			Map<String, Object> rtn = new HashMap<String, Object>();
			try {
				Procurementplans  entityS= new Procurementplans();
				entityS.setProcurementPlansCode(entity.getProcurementPlansCodeWhere());
				entityS.setUpdateTime(entity.getUpdateTimeWhere());
				entityS.setUpdateUser(entity.getUpdateUserWhere());
				entityS.setVersion(entity.getVersionWhere());
				List<Procurementplans> list = (List<Procurementplans>) procurementplansDao
						.searchByList(entityS);
				if (list == null || list.size() == 0) {
					entity = new Procurementplans();
					// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
					entity.setMessageCode(IConstant.WMSG0009);
					entity.setRetErrFlag(true);
					rtn.put("error", entity);
					rtn.put("data", null);
					return rtn;
				}
				// 删除成功
				procurementplansDao.delete(entity);
				rtn.put("message", MessageReSource.getMessageBox(
						IConstant.IMSG0003, langCode, langValue));
				rtn.put("status", IConstant.RESULT_CODE_0);
				return rtn;
			} catch (SQLException e) {
				e.printStackTrace();
				Procurementplans entityE = new Procurementplans();
				//错误消息：数据库操作异常，删除失败!
				entityE.setMessageCode(IConstant.EMSG0008);
				entityE.setRetErrFlag(true);
				entityE.setExceMessage(e.getMessage());
				rtn.put("error", entityE);
				rtn.put("data", null);
				return rtn;
			}
		}
}
