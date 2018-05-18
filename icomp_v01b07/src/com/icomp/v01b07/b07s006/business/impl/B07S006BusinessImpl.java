package com.icomp.v01b07.b07s006.business.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b07.s006.ICOMPV01B07S006Service;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vtoolprocured;
import com.icomp.v01b07.b07s006.business.B07S006Business;

public class B07S006BusinessImpl implements B07S006Business{

	/**
	 * 系统初始化SERVICE
	 */
	private CommonService service;
	public void setService(CommonService service) {
		this.service = service;
	}
	/**
	 * 工作记录查询SERVICES
	 */
	private ICOMPV01B07S006Service icompv01b07s006Service;
	
	public void setIcompv01b07s006Service(
			ICOMPV01B07S006Service icompv01b07s006Service) {
		this.icompv01b07s006Service = icompv01b07s006Service;
	}
	
	/**
	 * 工作记录列表
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue) throws BusinessException {
		String dateStarStr = param.get("DateStar").toString().trim();
		String dateEndStr = param.get("DateEnd").toString().trim();

		/**
		 *  设置检索条件
		 */
		Vtoolprocured entity = new Vtoolprocured();
			//起始时间 
			if (dateStarStr != null && dateStarStr != "") {
				entity.setStringStar(dateStarStr.replaceAll("-",""));
			}
			//结束时间
			if (dateEndStr != null && dateEndStr != "") {
				entity.setStringEnd(dateEndStr.replaceAll("-",""));
			}
		// 采购者
		entity.setProcuredUser(StringUtils.isEmpty(param.get("ProcuredUser").toString()) ? null : param.get("ProcuredUser").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("ProcuredUser");		
		// 工作记录查询列表
		Map<String, Object> rtn = icompv01b07s006Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vtoolprocured>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
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
