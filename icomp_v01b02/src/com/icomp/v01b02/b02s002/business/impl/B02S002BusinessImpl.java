package com.icomp.v01b02.b02s002.business.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b02.s002.ICOMPV01B02S002Service;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vredemptionapplied;
import com.icomp.v01b02.b02s002.business.B02S002Business;


public class B02S002BusinessImpl implements B02S002Business{
	
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	
	private ICOMPV01B02S002Service icompv01b02s002Service;

	public void setIcompv01b02s002Service(
			ICOMPV01B02S002Service icompv01b02s002Service) {
		this.icompv01b02s002Service = icompv01b02s002Service;
	}	
	/**
	 * 取得系统区分列表
	 * @param flagType 区分定义名称
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType,String langCode,String langValue)throws BusinessException{
		Comlist entity = new Comlist();
		entity.setComListType(flagType);
		entity.setLanguageCode(langCode);
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		List<Comlist> list = service.getComList(entity);
		if(list.size() == 1 && list.get(0).isRetErrFlag()){
			  throw new BusinessException(list.get(0).getMessageCode(), langCode,langValue);
		}
		return list;
	}

	/**
	 * 取得换领申请信息列表
	 * @param param 页面检索条件
	 * @param语言编码
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Map<String, Object> param,String langCode,String langValue) throws BusinessException {
		String dateStarStr = param.get("DateStar").toString().trim();
		String dateEndStr = param.get("DateEnd").toString().trim();

		/**
		 *  设置检索条件
		 */
		Vredemptionapplied entity = new Vredemptionapplied();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			// 申请起始时间
			if (dateStarStr != null && dateStarStr != "") {
				dateStarStr+=" 00:00:00";
				entity.setDateStar(format.parse(dateStarStr));
			}
			// 申请结束时间
			if (dateEndStr != null && dateEndStr != "") {
				dateEndStr+=" 23:59:59";
				entity.setDateEnd(format.parse(dateEndStr));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 换领申请流水号 
	//	entity.setRedemptionAppliedID(StringUtils.isEmpty(param.get("RedemptionAppliedID").toString()) ? null : param.get("RedemptionAppliedID").toString());
		// 申请人
		//entity.setApplyUserName(StringUtils.isEmpty(param.get("ApplyUser").toString()) ? null : param.get("ApplyUser").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("RedemptionAppliedID,ToolCode");
		// 换领申请信息列表
		Map<String, Object> rtn = icompv01b02s002Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vredemptionapplied>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
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
