package com.icomp.v01b01.b01s006.business;

import java.util.Map;

import com.icomp.common.exception.BusinessException;

/**
 * 更替刀具库存查询BUSINESS接口
 * @ClassName: B01S006Business 
 * @author Taoyy
 * @date 2014-8-15 上午10:43:44
 */
public interface B01S006Business {
	/**
	 * 更替刀具库存列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue)throws BusinessException;


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
