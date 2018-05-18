package com.icomp.v01b06.b06s006.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b06.s002.ICOMPV01B06S002Service;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vanalysisabnormalprocessing;
import com.icomp.v01b06.b06s006.business.B06S006Business;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * 定额执行情况分析BUsiness实现类
 * @ClassName: B06S006BusinessImpl 
 * @author Taoyy
 * @date 2014-8-22 上午10:05:24
 */


public class B06S006BusinessImpl implements B06S006Business {
	
	/**
	 * 系统初始化Service
	 */
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	
	/**
	 * 加工异常分析SERVICES
	 */
	public ICOMPV01B06S002Service icompv01b06s002Service;

	public void setIcompv01b06s002Service(ICOMPV01B06S002Service icompv01b06s002Service) {
		this.icompv01b06s002Service = icompv01b06s002Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue)throws BusinessException {
		Vanalysisabnormalprocessing entity = new Vanalysisabnormalprocessing();
		String dateStarStr = param.get("DateStar").toString().trim();
		String dateEndStr = param.get("DateEnd").toString().trim();
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
		/**
		 *  设置检索条件
		 */
		
		// 合成刀具编码
		entity.setSynthesisParametersCode(StringUtils.isEmpty(param.get("SynthesisParametersCode").toString()) ? null : param.get("SynthesisParametersCode").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("SynthesisParametersCode");		
		// 定额执行情况分析列表
		Map<String, Object> rtn = icompv01b06s002Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vanalysisabnormalprocessing>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
		}
		return rtn;
	}

	@Override
	public Object getStatisticalCount(Map<String, Object> param,String langCode, String langValue) {

		Vanalysisabnormalprocessing entity = new Vanalysisabnormalprocessing();
		String dateStarStr = param.get("DateStar").toString().trim();
		String dateEndStr = param.get("DateEnd").toString().trim();
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
		//合成刀具编码
		entity.setSynthesisParametersCode(StringUtils.isEmpty(param.get("SynthesisParametersCode").toString()) ? null : param.get("SynthesisParametersCode").toString());
	//	 return icompv01b06s002Service.getStatisticalCount(entity);  TODO tttttttttttttttttttttttttttttttt
		return null;
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
