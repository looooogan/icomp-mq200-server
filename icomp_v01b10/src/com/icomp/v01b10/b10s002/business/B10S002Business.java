package com.icomp.v01b10.b10s002.business;

import java.util.Map;

import com.icomp.common.exception.BusinessException;

/**
 * 手持机日志BUSINESS接口
 * @ClassName: B01S002Business 
 * @author Taoyy
 * @date 2014-8-14 下午02:01:40
 */
public interface B10S002Business {
	
	/**
	 * 手持机日志列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue);
	
	/**
	 * 取得页面grid显示项目列表
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String string, String langValue, String customerID,
			String langCode);


	
}
