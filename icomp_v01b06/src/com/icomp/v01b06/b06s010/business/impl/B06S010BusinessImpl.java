package com.icomp.v01b06.b06s010.business.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b06.s010.ICOMPV01B06S010Service;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Vtooldiscarde;
import com.icomp.v01b06.b06s010.business.B06S010Business;

/**
 * 成本摊销BUsiness实现类
 * 
 * @ClassName: B06S010BusinessImpl
 * @author Taoyy
 * @date 2014-8-22 上午10:10:39
 */

public class B06S010BusinessImpl implements B06S010Business {

	/**
	 * 系统初始化Service
	 */
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	/**
	 * 成本摊销SERVICES
	 */
	public ICOMPV01B06S010Service icompv01b06s010Service;

	public void setIcompv01b06s010Service(
			ICOMPV01B06S010Service icompv01b06s010Service) {
		this.icompv01b06s010Service = icompv01b06s010Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getList(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException {
		Vtooldiscarde entity = new Vtooldiscarde();
		entity.setToolCode(StringUtils
				.isEmpty(param.get("ToolCode").toString()) ? null : param.get(
				"ToolCode").toString());
		String dateStarStr = param.get("dstar").toString().trim();
		String dateEndStr = param.get("dend").toString().trim();
		// 起始时间
		if (dateStarStr != null && dateStarStr != "") {
			entity.setStringStar(dateStarStr.replace("-", ""));
		}
		// 结束时间
		if (dateEndStr != null && dateEndStr != "") {
			entity.setStringEnd(dateEndStr.replace("-", ""));
		}
		entity.setDiscardeFlag(StringUtils.isEmpty(param.get("DiscardeFlag")
				.toString()) ? null : param.get("DiscardeFlag").toString());
		entity.setToolConsumetype(StringUtils.isEmpty(param.get(
				"ToolConsumetype").toString()) ? null : param.get(
				"ToolConsumetype").toString());
		entity.setOrderString("discardeTime");
		Map<String, Object> rtn = icompv01b06s010Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(
					((List<Vtooldiscarde>) rtn.get("error")).get(0)
							.getMessageCode(), langCode, langValue);
		}
		return rtn;
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
		Map<String, Object> ret = service.getGridColmun(pageID, langCode,
				IConstant.ITEM_TYPE_1);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 取得失败时，返回
			throw new BusinessException(((List<Displayeditemconfiguration>) ret
					.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	/**
	 * 取得系统区分列表
	 * 
	 * @param flagType
	 *            区分定义名称
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType, String langCode,
			String langValue) throws BusinessException {
		Comlist entity = new Comlist();
		entity.setComListType(flagType);
		entity.setLanguageCode(langCode);
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		List<Comlist> list = service.getComList(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,
					langValue);
		}
		return list;
	}
	

	
	/**
	 * 刀具报废列表
	 * 
	 * @title getList
	 * @param param
	 * @param langValue
	 * @return Map<String,Object>
	 */
	public Map<String, Object> b06s010Save(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException{
		String toolCode = param.get("ToolCode").toString();
		String discardeTime = param.get("DiscardeTime").toString();
		Map<String, Object>  ret = icompv01b06s010Service.b06s010Save(toolCode,discardeTime,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Tooltransfer)ret.get("error")).getMessageCode(), langCode,  langValue);
		}
		return ret;
	}
}
