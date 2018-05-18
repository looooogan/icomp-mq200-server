package com.icomp.v01b06.b06s004.business.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b06.s004.ICOMPV01B06S004Service;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vtoolsupplier;
import com.icomp.v01b06.b06s004.business.B06S004Business;

/**
 * 刀具供应商分析BUsiness实现类
 * 
 * @ClassName: B06S004BusinessImpl
 * @author Taoyy
 * @date 2014-8-22 上午09:50:51
 */
@SuppressWarnings("unchecked")
public class B06S004BusinessImpl implements B06S004Business {

	/**
	 * 系统初始化Service
	 */
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	/**
	 * 刀具供应商分析SERVICES
	 */
	public ICOMPV01B06S004Service icompv01b06s004Service;

	public void setIcompv01b06s004Service(
			ICOMPV01B06S004Service icompv01b06s004Service) {
		this.icompv01b06s004Service = icompv01b06s004Service;
	}


	@Override
	public Map<String, Object> getList(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException {
		// 取得供应商基本数据
		Vtoolsupplier entity = new Vtoolsupplier();
		String dateStarStr =param.get("DateStar")==null ? null : param.get("DateStar").toString().trim();
		String dateEndStr = param.get("DateEnd")==null ? null :param.get("DateEnd").toString().trim();
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
		// 供应商
		entity.setToolSupplier(StringUtils.isEmpty(param.get("ToolSupplier")
				.toString()) ? null : param.get("ToolSupplier").toString());
		// 刀具编码
		entity.setToolCode(StringUtils
				.isEmpty(param.get("ToolCode").toString()) ? null : param.get(
				"ToolCode").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString()) - 1)
				* IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("ToolCode,ToolSupplier");
		// 刀具供应商分析列表
		Map<String, Object> rtn = icompv01b06s004Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vtoolsupplier>) rtn
					.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return rtn;
	}

	/**
	 * 刀具供应商分析统计数量
	 */
	@Override
	public String getStatisticalCount(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException {
		Vtoolsupplier entity = new Vtoolsupplier();
		// 供应商
		entity.setToolSupplier(StringUtils.isEmpty(param.get("ToolSupplier")
				.toString()) ? null : param.get("ToolSupplier").toString());
		// 刀具编码
		entity.setToolCode(StringUtils
				.isEmpty(param.get("ToolCode").toString()) ? null : param.get(
				"ToolCode").toString());
		return icompv01b06s004Service.getStatisticalCount(entity);
	}

	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
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
}
