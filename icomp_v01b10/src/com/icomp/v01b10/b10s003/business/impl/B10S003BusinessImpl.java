package com.icomp.v01b10.b10s003.business.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b10.s003.ICOMPV01B10S003Service;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vsystemlog;
import com.icomp.v01b10.b10s003.business.B10S003Business;

public class B10S003BusinessImpl implements B10S003Business{


	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	
	/**
	 * 管理平台日志SERVICE
	 */
	private ICOMPV01B10S003Service icompv01b10s003Service;

	public void setIcompv01b10s003Service(
			ICOMPV01B10S003Service icompv01b10s003Service) {
		this.icompv01b10s003Service = icompv01b10s003Service;
	}
	
	/**
	 * 管理平台日志列表
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Map<String, Object> param,
			String langCode,String langValue) {
		String dateStarStr = param.get("DateStar").toString().trim();
		String dateEndStr = param.get("DateEnd").toString().trim();

		/**
		 *  设置检索条件
		 */
		Vsystemlog entity = new Vsystemlog();
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
		// 日志分类
		entity.setSystemLogFlag(IConstant.STRING_1);
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("UpdateTime desc");
		// 管理平台日志列表
		Map<String, Object> rtn = icompv01b10s003Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vsystemlog>) rtn.get("error")).get(0).getMessageCode(),langCode,langValue);
		}
		return rtn;
	}

	/**
	 * 取得页面grid显示项目列表
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getGridColmun(String pageID,String userID,String langCode,String langValue)throws BusinessException{
		
		//取得页面grid显示项目列表
		Map<String, Object> ret = service.getGridColmun(pageID,
				langCode,IConstant.ITEM_TYPE_1);
		if(ret.size() > 1 && ret.get("error") != null){
			  //取得失败时，返回
			  throw new BusinessException(((List<Displayeditemconfiguration>)ret.get("error")).get(0).getMessageCode(),langCode, langValue);
		}
		return ret;
	}
	

}
