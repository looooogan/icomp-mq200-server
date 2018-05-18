package com.icomp.v01b06.b06s003.business;

import java.util.Map;

import com.icomp.common.exception.BusinessException;

/**
 * 建议采购计划BUSINESS接口
 * @ClassName: B06S003Business 
 * @author Taoyy
 * @date 2014-8-22 上午09:40:22
 */
public interface B06S003Business {
	/**
	 * 建议采购计划列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 * Map<String,Object>
	 */
	public	Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue)throws BusinessException;

	/**
	 * 取得页面grid显示项目列表
	 * @title getGridColmun 
	 * @param string
	 * @param langValue
	 * @param customerID
	 * @param langValue2
	 * @return
	 * Object
	 */
	public Object getGridColmun(String string, String langCode, String customerID, String langValue);
	/**
	 *  增加建议采购计划
	 * @title saveAll 
	 * @param param
	 * @param langValue
	 * @param customerID
	 * @param lang
	 * @return
	 * Map<String,Object>
	 */

	public Map<String, Object> saveAll(Map<String, Object> param, String langValue, String customerID, String lang);
	
}
