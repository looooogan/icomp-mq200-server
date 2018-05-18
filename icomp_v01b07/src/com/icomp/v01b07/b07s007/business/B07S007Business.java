package com.icomp.v01b07.b07s007.business;

import java.util.Map;

import com.icomp.common.exception.BusinessException;

/**
 * 标签采购BUSINESS接口
 * @ClassName: B07S007Business 
 * @author Licc
 * @date 2014-8-21 上午10:34:59
 */
public interface B07S007Business {
	/**
	 * 标签采购列表
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
			String customerID,String langCode , String langValue) throws BusinessException;
	
}
