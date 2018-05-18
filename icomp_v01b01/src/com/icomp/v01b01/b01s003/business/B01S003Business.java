package com.icomp.v01b01.b01s003.business;

import java.util.Map;

import com.icomp.common.exception.BusinessException;

/**
 * 待处理刀具信息查询BUSINESS
 * @ClassName: B01S003Business 
 * @author Taoyy
 * @date 2014-8-19 下午04:26:05
 */
public interface B01S003Business {
	/**
	 * 待处理刀具信息查询
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue)throws BusinessException;

	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID, 
			String departmentID,String langCode , String langValue) throws BusinessException;

	
}
