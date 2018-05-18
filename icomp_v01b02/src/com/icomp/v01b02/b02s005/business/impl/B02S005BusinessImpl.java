package com.icomp.v01b02.b02s005.business.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b02.s005.ICOMPV01B02S005Service;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vtoolsetting;
import com.icomp.v01b02.b02s005.business.B02S005Business;

public class B02S005BusinessImpl implements B02S005Business {

	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	private ICOMPV01B02S005Service icompv01b02s005service;

	public void setIcompv01b02s005service(ICOMPV01B02S005Service icompv01b02s005service) {
		this.icompv01b02s005service = icompv01b02s005service;
	}

	/**
	 * 取得系统区分列表
	 * 
	 * @param flagType
	 *            区分定义名称
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType, String langCode,String langValue) throws BusinessException {
		Comlist entity = new Comlist();
		entity.setComListType(flagType);
		entity.setLanguageCode(langCode);
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		List<Comlist> list = service.getComList(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,langValue);
		}
		return list;
	}

	/**
	 * 取得对刀工作量汇总列表
	 * 
	 * @param param
	 *            页面检索条件
	 * @param lang
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Map<String, Object> param, String langCode,String langValue)throws BusinessException {
		String dateStarStr = param.get("DateStar").toString().trim();
		String dateEndStr = param.get("DateEnd").toString().trim();
		/**
		 * 设置检索条件
		 */
		Vtoolsetting entity = new Vtoolsetting();
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
		// 对刀人
		entity.setKnifeMan(StringUtils.isEmpty(param.get("KnifeMan").toString()) ? null : param.get("KnifeMan").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("SynthesisParametersCode");
		// 对刀记录列表
		Map<String, Object> rtn = icompv01b02s005service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vtoolsetting>) rtn.get("error")).get(0).getMessageCode(), langCode,langValue);
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
