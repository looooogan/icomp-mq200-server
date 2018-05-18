package com.icomp.common.service.icomp.v01b06.s007;

import java.util.Map;

import com.icomp.entity.base.Vconsumptiontool;

/**
 * 刀具消耗量分析SERVICES接口
 * 
 * @ClassName: ICOMPV01B06S007Service
 * @author Taoyy
 * @date 2014-8-22 上午10:16:38
 */

public interface ICOMPV01B06S007Service {
	/**
	 * 刀具消耗量分析
	 * 
	 * @title getList
	 * @param entity
	 * @return Map<String,Object>
	 */
	public Map<String, Object> getList(Vconsumptiontool entity);
	/**
	 * 刀具消耗量分析统计
	 * @title getStatisticalCount 
	 * @param entity
	 * @return
	 * Object
	 */
	public Object getStatisticalCount(Vconsumptiontool entity);
	/**
	 * 验证参数信息
	 * 
	 * @param param
	 * @param langValue
	 * @return
	 */
	Map<String, Object> checkInput(Map<String, Object> param, String langCode,
			String customerID, String langValue, int checkType);

}
