package com.icomp.v01b02.b02s001.business.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b02.s001.ICOMPV01B02S001Service;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vsynthesisexperience;
import com.icomp.v01b02.b02s001.business.B02S001Business;

/**
 * 待处理刀具信息查询BUSINESS实现类 
 * @ClassName: B02S001BusinessImpl 
 * @author Taoyy
 * @date 2014-8-19 下午05:03:37
 */
public class B02S001BusinessImpl implements B02S001Business{
 

	/**
	 * 待处理刀具信息查询SERVICE
	 */
	private CommonService service;
	private ICOMPV01B02S001Service icompv01b02s001Service;


	public void setService(CommonService service) {
		this.service = service;
	}


	public void setIcompv01b02s001Service(
			ICOMPV01B02S001Service icompv01b02s001Service) {
		this.icompv01b02s001Service = icompv01b02s001Service;
	}


	/**
	 *待处理刀具信息查询
	 */
	@Override
	@SuppressWarnings("unchecked") 
	public Map<String, Object> getList(Map<String, Object> param,String langCode,String langValue)throws BusinessException {
		String dateStarStr = param.get("DateStar").toString().trim();
		String dateEndStr = param.get("DateEnd").toString().trim();

		/**
		 *  设置检索条件
		 */
		Vsynthesisexperience entity = new Vsynthesisexperience();
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
		// 刀具编码  
		entity.setSynthesisParametersCode(StringUtils.isEmpty(param.get("SynthesisParametersCode").toString()) ? null : param.get("SynthesisParametersCode").toString());
		// 刀具状态
		entity.setbusStates(StringUtils.isEmpty(param.get("DivStates").toString()) ? null :new BigDecimal( param.get("DivStates").toString()));
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("UpdateTime desc");		
		// 待处理刀具信息查询-SynthesisParametersCode模糊查询
		Map<String, Object> rtn = icompv01b02s001Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vsynthesisexperience>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
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
