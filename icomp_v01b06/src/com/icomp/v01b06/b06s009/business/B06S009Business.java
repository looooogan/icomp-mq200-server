package com.icomp.v01b06.b06s009.business;

import java.util.Map;

import com.icomp.common.exception.BusinessException;

/**
 * 成本摊销BUSINESS接口
 * @ClassName: B06S009Business 
 * @author Taoyy
 * @date 2014-8-22 上午10:25:37
 */

public interface B06S009Business {
	/**
	 * 成本摊销列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
public	Map<String, Object> getList(Map<String, Object> param, String langCode,String langValue,int checkType)throws BusinessException;

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
	 * 取得页面下拉列表内容
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getPageSelList(String langCode, String langValue)throws BusinessException;
	
}
