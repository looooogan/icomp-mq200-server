package com.icomp.v01b08.b08s005.business.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b08.s005.ICOMPV01B08S005Service;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vcomlist;
import com.icomp.v01b08.b08s005.business.B08S005Business;

public class B08S005BusinessImpl implements B08S005Business {

	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	private ICOMPV01B08S005Service iCOMPV01B08S005Service;

	public void setiCOMPV01B08S005Service(
			ICOMPV01B08S005Service iCOMPV01B08S005Service) {
		this.iCOMPV01B08S005Service = iCOMPV01B08S005Service;
	}

	/**
	 * 取得系统区分列表
	 * 
	 * @param flagType
	 *            区分定义名称
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType, String langCode,String langValue)
			throws BusinessException {
		Comlist entity = new Comlist();
		entity.setComListType(flagType);
		entity.setLanguageCode(langCode);
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		List<Comlist> list = service.getComList(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode, langValue);
		}
		return list;
	}
	
	/**
	 * 取得系统码表配置列表
	 * 
	 * @param param
	 *            页面检索条件
	 * @param lang
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Map<String, Object> param, String langCode,String langValue)
			throws BusinessException {
		// 设置检索条件
		Vcomlist entity = new Vcomlist();
		// 区分文本
		entity.setComListText(StringUtils.isEmpty(param.get("ComListText").toString())?null:param.get("ComListText").toString());
		// 删除区分
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("ComlistID");				
		Map<String,Object> rtn = iCOMPV01B08S005Service.getList(entity);
		if(rtn.size() > 1 && rtn.get("error") != null){
			  //检索错误时，返回
			  throw new BusinessException(((List<Vcomlist>)rtn.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return rtn;
	}

	/**
	 * 删除系统码表配置信息
	 * @param param 页面检索条件
	 * @param langValue 
	 * @param customerID
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> comlistDelete(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
	    Comlist comlist = new Comlist();
		comlist.setDelFlag(IConstant.DEL_FLAG_1);
		comlist.setUpdateTime(new Date());
		comlist.setUpdateUser(customerID);
	    comlist.setVersion(new BigDecimal(param.get("version").toString()).add(BigDecimal.ONE));
		comlist.setComlistIDWhere(param.get("comlistID").toString());
		comlist.setUpdateTimeWhere(Ctl.strToDate(param.get("updatetime").toString().replace("T", " ")));
		comlist.setUpdateUserWhere(param.get("updateuser").toString());
		comlist.setVersionWhere(new BigDecimal(param.get("version").toString()));
		Map<String,Object> ret = iCOMPV01B08S005Service.comlistDelete(comlist,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //删除失败时，返回
			  throw new BusinessException(((Comlist)ret.get("error")).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	/**
	 * 新建系统码表配置信息
	 * @param param 页面检索条件
	 * @param langValue 
	 * @param customerID
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> comlistAdd(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
		//系统码表输入验证
		Map<String,Object> ret = iCOMPV01B08S005Service.checkInput(param,langCode,langValue,customerID,1);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Comlist)ret.get("error")).getMessageCode(),langCode, langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Comlist comlist = new Comlist();
		comlist.setDelFlag(param.get("DIVDelFlag").toString());
		comlist.setLanguageCode(param.get("DIVLanguageCode").toString());
		comlist.setComListType(param.get("DIVComListType").toString());
		comlist.setComListValue(param.get("DIVComListValue").toString());
		comlist.setComListText(param.get("DIVComListText").toString());
		comlist.setComListMs(param.get("DIVComListMs").toString());
		comlist.setEditFlag(param.get("DIVEditFlag").toString());
		comlist.setUpdateTime(new Date());
		comlist.setUpdateUser(customerID);
		comlist.setCreateTime(new Date());
		comlist.setCreateUser(customerID);
		comlist.setVersion(new BigDecimal(param.get("DivVersion").toString()));

		//保存系统码表信息
		ret = iCOMPV01B08S005Service.comlistAdd(comlist,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Comlist)ret.get("error")).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	@Override
	public Map<String, Object> comlistEdit(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
		//系统码表输入验证
		Map<String,Object> ret = iCOMPV01B08S005Service.checkInput(param,langCode,langValue,customerID,2);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Comlist)ret.get("error")).getMessageCode(),langCode,langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Comlist comlist = new Comlist();
		comlist.setComlistID(param.get("DivComlistID").toString());
		comlist.setDelFlag(param.get("DIVDelFlag").toString());
		comlist.setLanguageCode(param.get("DIVLanguageCode").toString());
		comlist.setComListType(param.get("DIVComListType").toString());
		comlist.setComListValue(param.get("DIVComListValue").toString());
		comlist.setComListText(param.get("DIVComListText").toString());
		comlist.setComListMs(param.get("DIVComListMs").toString());
		comlist.setEditFlag(param.get("DIVEditFlag").toString());
		comlist.setUpdateTime(new Date());
		comlist.setUpdateUser(customerID);
//		comlist.setVersion(BigDecimal.ONE);
		comlist.setVersion(new BigDecimal(param.get("DivVersion").toString()).add(BigDecimal.ONE));
		comlist.setComlistIDWhere(param.get("DivComlistID").toString());
		comlist.setUpdateTimeWhere(Ctl.strToDate(param.get("DivUpdateTime").toString().replace("T", " ")));
		comlist.setUpdateUserWhere(param.get("DivUpdateUser").toString());
		comlist.setVersionWhere(new BigDecimal(param.get("DivVersion").toString()));

		//保存系统码表信息
		ret = iCOMPV01B08S005Service.comlistEdit(comlist,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Comlist)ret.get("error")).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	@Override
	public Map<String, Object> comlistInfo(Map<String, Object> param,
			String langCode,String langValue) throws BusinessException {
		Map<String,Object> ret = new HashMap<String,Object>();
		String comlistID = param.get("comlistID").toString();
		if (StringUtils.equals("edit", (String) param.get("opt"))) {
			//取得待编辑系统码表信息
			Comlist entity = new Comlist();
			entity.setComlistID(comlistID);
			ret = iCOMPV01B08S005Service.getComlistInfo(entity);
			if(ret.size() > 1 && ret.get("error") != null){
				  //检索错误时，返回
				  throw new BusinessException(((Comlist)ret.get("error")).getMessageCode(), langCode, langValue);
			}
		}
		return ret;
	}


	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getGridColmun(String pageID, String userID,
			String langCode, String langValue) throws BusinessException {

		// 取得页面grid显示项目列表
		Map<String, Object> ret = service.getGridColmun(pageID,
				langCode,IConstant.ITEM_TYPE_1);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 取得失败时，返回
			throw new BusinessException(((List<Displayeditemconfiguration>) ret
					.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return ret;
	}
}
