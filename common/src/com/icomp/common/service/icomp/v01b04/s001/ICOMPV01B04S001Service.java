package com.icomp.common.service.icomp.v01b04.s001;

import java.util.Map;

import com.icomp.entity.base.Vworkloadqueries;

/**
 * 工作量查询SERVICE接口
 * @ClassName: ICOMPV01B03S001Service 
 * @author Taoyy
 * @date 2014-8-20 下午03:31:52
 */
public interface ICOMPV01B04S001Service {

	/**
	 * 工作量查询
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> getAssemblyLineNameList(Vworkloadqueries entity);
	/**
	 * 工作量查询
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> getProcessNameList(Vworkloadqueries entity);
	/**
	 * 工作量查询
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	
	public Map<String, Object> getList(Vworkloadqueries entity);

}
