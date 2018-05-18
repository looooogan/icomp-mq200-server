package com.icomp.common.service.icomp.v01b06.s004;

import java.util.Map;

import com.icomp.entity.base.Vtoolsupplier;

/**
 * 刀具供应商分析SERVICE接口
 * 
 * @ClassName: ICOMPV01B06S004Service
 * @author Taoyy
 * @date 2014-8-22 上午09:51:57
 */

public interface ICOMPV01B06S004Service {

	/**
	 * 刀具供应商分析列表
	 * 
	 * @title getList
	 * @param entity
	 * @return Map<String,Object>
	 */
	public Map<String, Object> getList(Vtoolsupplier entity);
	/**
	 * 刀具供应商分析统计数量
	 * @title getStatisticalCount 
	 * @param entity
	 * @return
	 * String
	 */
	public String getStatisticalCount(Vtoolsupplier entity);

}
