package com.icomp.v01b07.b07s003.business;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Vsuggestionpurchaseplan;

/**
 * 采购计划处理Business接口
 * @ClassName: B07S003Business 
 * @author Taoyy
 * @date 2014-9-13 下午02:51:05
 */
public interface B07S003Business {

	/**
	 * 采购计划处理列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue)throws BusinessException;
	/**
	 * 取得采购计划信息
	 * @title procurementInfo 
	 * @param param
	 * @param langValue
	 * @return
	 * List<Procurementplans>
	 */
	
	List<Vsuggestionpurchaseplan> procurementInfo(Map<String, Object> param, String langCode, String langValue);
	/**
	 * 启用采购计划提交
	 * @title saveAll 
	 * @param param
	 * @param langValue
	 * @param customer
	 * @param lang
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> saveAll(Map<String, Object> param, String langValue, String customer, String langCode);

	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID, 
			String customerID,String langCode , String langValue) throws BusinessException;
	
	/**
	 * 建议采购计划删除
	 * @title procurementPlansDel 
	 * @return
	 * String
	 */
	Map<String, Object> procurementPlansDel(Map<String, Object> param,
			String langValue, String customer, String langCode);
	
}
