package com.icomp.v01b06.b06s006.business;

import java.util.Map;

import com.icomp.common.exception.BusinessException;

/**
 * 定额执行情况分析BUSINESS接口
 * 
 * @ClassName: B06S006Business
 * @author Taoyy
 * @date 2014-8-22 上午10:03:57
 */

public interface B06S006Business {
	/**
	 * 定额执行情况分析列表
	 * 
	 * @title getList
	 * @param param
	 * @param langValue
	 * @return Map<String,Object>
	 */
	public Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue) throws BusinessException;
	/**
	 * 定额执行情况分析统计
	 * @title getStatisticalCount 
	 * @param param
	 * @param langValue
	 * @return
	 * Object
	 */
	public Object getStatisticalCount(Map<String, Object> param, String langCode, String langValue);

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
