package com.icomp.v01b10.b10s003.business;

import java.util.Map;

import com.icomp.common.exception.BusinessException;

/**
 * 管理平台日志BUSINESS接口
 * @ClassName: B01S003Business 
 * @author Licc
 * @date 2014-8-14 下午02:01:40
 */
public interface B10S003Business {
	/**
	 * 管理平台日志列表
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
