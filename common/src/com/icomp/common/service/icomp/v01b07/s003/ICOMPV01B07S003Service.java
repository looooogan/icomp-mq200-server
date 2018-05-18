package com.icomp.common.service.icomp.v01b07.s003;

import java.util.List;
import java.util.Map;

import com.icomp.entity.base.Procurementplans;
import com.icomp.entity.base.Toolprocured;
import com.icomp.entity.base.Vsuggestionpurchaseplan;

/**
 * 采购计划处理SERVICE接口
 * 
 * @ClassName: ICOMPV01B07S003Service
 * @author Licc
 * @date 2014-8-28 下午04:17:50
 */
public interface ICOMPV01B07S003Service {
	/**
	 * 采购计划处理列表
	 * 
	 * @title getList
	 * @param entity
	 * @return Map<String,Object>
	 */
	public Map<String, Object> getList(Vsuggestionpurchaseplan entity);

	/**
	 *  取得待采购计划信息
	 * @title getProcurementInfo 
	 * @param entity
	 * @return
	 * List<Vsuggestionpurchaseplan>
	 */
	public List<Vsuggestionpurchaseplan> getProcurementInfo(Vsuggestionpurchaseplan entity);
	/**
	 * 启用采购计划提交
	 * @title saveAll 
	 * @param list
	 * @param lang
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> saveAll(List<Toolprocured> list, String langCode, String pString,String langValue);
	/**
	 * 建议采购计划删除
	 * @title procurementPlansDel 
	 * @return
	 * String
	 */
	public Map<String, Object> procurementPlansDel(Procurementplans entity,
			String langCode, String langValue);

}
