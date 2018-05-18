package com.icomp.v01b04.b04s006.business;

import java.util.Map;

import com.icomp.common.exception.BusinessException;

/**
 *  加工信息快速查询BUSINESS接口
 * @ClassName: B04S006Business 
 * @author Taoyy
 * @date 2014-8-20 下午06:17:26
 */

public interface B04S006Business {
	/**
	 * 加工信息快速查询列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
 public	Map<String, Object> getList(Map<String, Object> param, String langCode,String langValue)throws BusinessException;
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
