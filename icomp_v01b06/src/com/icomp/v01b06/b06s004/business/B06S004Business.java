package com.icomp.v01b06.b06s004.business;

import com.icomp.common.exception.BusinessException;

import java.util.Map;

/**
 * 刀具供应商分析BUSINESS接口
 * 
 * @ClassName: B06S004Business
 * @author Taoyy
 * @date 2014-8-22 上午09:49:45
 */

public interface B06S004Business {
	/**
	 * 刀具供应商分析列表
	 * 
	 * @title getList
	 * @param param
	 * @param langValue
	 * @return Map<String,Object>
	 */
	public Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue) throws BusinessException;
	/**
	 * 刀具供应商分析统计数量
	 * @title getStatisticalCount 
	 * @param param
	 * @param langValue
	 * @return
	 * Object
	 */
	public String getStatisticalCount(Map<String, Object> param,String langCode, String langValue);

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
}
