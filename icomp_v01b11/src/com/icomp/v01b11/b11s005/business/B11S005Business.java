package com.icomp.v01b11.b11s005.business;

import com.icomp.common.exception.BusinessException;

import java.util.Map;

/**
 *  加工信息快速查询BUSINESS接口
 * @ClassName: B04S006Business 
 * @author Taoyy
 * @date 2014-8-20 下午06:17:26
 */

public interface B11S005Business {
	/**
	 * 加工信息快速查询列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
 	Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue)throws BusinessException;



	Map<String,Object> leaserSp(Map<String, Object> param, String customerID, String langCode, String langValue) throws BusinessException;


		}
