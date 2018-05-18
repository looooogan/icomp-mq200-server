package com.icomp.v01b01.b01s011.business;

import java.util.Map;

import com.icomp.common.exception.BusinessException;

/**
 * 在途计划报警BUSINESS接口
 * @ClassName: B01S011Business 
 * @author Taoyy
 * @date 2014-8-15 下午06:05:42
 */
public interface B01S011Business {
	/**
	 * 在途计划报警查询列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Map<String, Object> param, String langCode,String langValue)throws BusinessException;


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
