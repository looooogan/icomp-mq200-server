package com.icomp.v01b03.b03s004.business.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b03.s004.ICOMPV01B03S004Service;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vgrindingworksummary;
import com.icomp.v01b03.b03s004.business.B03S004Business;

/**
 * 刃磨工作量汇总BUSINESS实体类
 * 
 * @ClassName: B03S004BusinessImpl
 * @author Taoyy
 * @date 2014-8-13 上午10:39:35
 */
public class B03S004BusinessImpl implements B03S004Business {

	private CommonService service;
	public void setService(CommonService service) {
		this.service = service;
	}
	/**
	 * 刃磨工作量汇总SERVICE
	 */
	private ICOMPV01B03S004Service icompv01b03s004Service;

	public void setIcompv01b03s004Service(
			ICOMPV01B03S004Service icompv01b03s004Service) {
		this.icompv01b03s004Service = icompv01b03s004Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 刃磨工作量汇总列表
	 */
	public Map<String, Object> getList(Map<String, Object> param,String langCode,String langValue) throws BusinessException {
		String dateStarStr = param.get("DateStar").toString().trim();
		String dateEndStr = param.get("DateEnd").toString().trim();
		/**
		 *  设置检索条件
		 */
		Vgrindingworksummary entity = new Vgrindingworksummary();
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
		// 操作人
		entity.setUserName(StringUtils.isEmpty(param.get("UserName").toString()) ? null : param.get("UserName").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("UserName");			
		//刃磨工作量汇总列表
		Map<String, Object> rtn = icompv01b03s004Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vgrindingworksummary>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
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
