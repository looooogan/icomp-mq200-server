package com.icomp.common.service.icomp.v01b01.s010;

import java.util.Map;

import com.icomp.entity.base.Vtoolquicksearch;

/**
 * 库存信息快速查询SERVICE接口
 * @ClassName: ICOMPV01B01S010Service 
 * @author Taoyy
 * @date 2014-8-15 下午05:03:56
 */
public interface ICOMPV01B01S010Service {
	/**
	 * 库存信息快速查询列表
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Vtoolquicksearch entity);



}
