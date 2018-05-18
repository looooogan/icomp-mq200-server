package com.icomp.common.service.icomp.v01b01.s008;

import java.util.Map;

import com.icomp.entity.base.Vpurchaseplan;

/**
 * 采购计划查询SERVICE接口
 * @ClassName: ICOMPV01B01S008Service 
 * @author Taoyy
 * @date 2014-8-15 下午03:19:35
 */
public interface ICOMPV01B01S008Service {
	/**
	 * 采购计划查询列表
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
 public	Map<String, Object> getList(Vpurchaseplan entity);



}
