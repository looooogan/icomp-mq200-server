package com.icomp.v01b04.b04s007.business;

import com.icomp.common.exception.BusinessException;

import java.util.Map;

/**
 *  加工信息快速查询BUSINESS接口
 * @ClassName: B04S006Business 
 * @author Taoyy
 * @date 2014-8-20 下午06:17:26
 */

public interface B04S007Business {
	/**
	 * 加工信息快速查询列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
 public	Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue)throws BusinessException;


	Map<String,Object> VwarningAdd(Map<String, Object> param, String userID, String langCode, String langValue)throws BusinessException;

	Map<String,Object> VwarningSsp(Map<String, Object> param, String customerID, String langCode, String langValue) throws BusinessException;

	String getNumber()throws BusinessException;
}
