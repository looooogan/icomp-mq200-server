package com.icomp.v01b01.b01s008.business;

import java.util.Map;

import com.icomp.common.exception.BusinessException;

/**
 * 采购计划查询BUSINESS接口
 * @ClassName: B01S008Business 
 * @author Taoyy
 * @date 2014-8-15 下午03:15:16
 */
public interface B01S008Business {
	/**
	 * 采购计划查询列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> getList(Map<String, Object> param, String langCode,  String langValue)throws BusinessException;


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
