package com.icomp.v01b01.b01s009.business;

import java.util.Map;

import com.icomp.common.exception.BusinessException;

/**
 * 质检记录查询BUSINESS接口
 * @ClassName: B01S009Business 
 * @author Taoyy
 * @date 2014-8-15 下午04:03:33
 */
public interface B01S009Business {
	/**
	 * 质检记录查询列表
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
