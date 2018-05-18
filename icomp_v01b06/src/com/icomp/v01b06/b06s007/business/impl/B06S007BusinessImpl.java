package com.icomp.v01b06.b06s007.business.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b06.s007.ICOMPV01B06S007Service;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vconsumptiontool;
import com.icomp.v01b06.b06s007.business.B06S007Business;

/**
 * 单品刀具分析BUsiness实现类
 * @ClassName: B06S007BusinessImpl 
 * @author Taoyy
 * @date 2014-8-22 上午10:15:06
 */



public class B06S007BusinessImpl implements B06S007Business {
	/**
	 * 系统区Service
	 */
	private CommonService service;
	public void setService(CommonService service) {
		this.service = service;
	}
	/**
	 * 单品刀具分析SERVICES
	 */
	public ICOMPV01B06S007Service icompv01b06s007Service;

	public void setIcompv01b06s007Service(ICOMPV01B06S007Service icompv01b06s007Service) {
		this.icompv01b06s007Service = icompv01b06s007Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue)throws BusinessException {

		/**
		 * 设置检索条件
		 */
		Vconsumptiontool entity = new Vconsumptiontool();
		// 刀具编码
		entity.setToolCode(StringUtils.isEmpty(param.get("ToolCode").toString())? null : param.get("ToolCode").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("ToolCode");				
		// 单品刀具分析列表
		Map<String, Object> rtn = icompv01b06s007Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vconsumptiontool>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
		}
		return rtn;
	}

	/**
	 * 取得系统区分列表
	 * @param flagType 区分定义名称
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String toolConsumeType,String langCode, String langValue)throws BusinessException{
		Comlist entity = new Comlist();
		entity.setComListType(toolConsumeType);
		entity.setLanguageCode(langCode);
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		List<Comlist> list = service.getComList(entity);
		if(list.size() == 1 && list.get(0).isRetErrFlag()){
			  throw new BusinessException(list.get(0).getMessageCode(),langCode, langValue);
		}
		return list;
	}
	
	/**
	 * 单品刀具分析统计
	 */
	@Override
	public Map<String, Object>  getStatisticalCount(Map<String, Object> param,String customerID,String langCode, String langValue) {
		Vconsumptiontool entity = new Vconsumptiontool();
		// 刀具编码
		entity.setToolCode(StringUtils.isEmpty(param.get("ToolCode").toString())? null : param.get("ToolCode").toString());
		 Map<String, Object> ret= icompv01b06s007Service.getList(entity);
		
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Vconsumptiontool)ret.get("error")).getMessageCode(), langCode,langValue);
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
