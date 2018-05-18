package com.icomp.common.service.icomp.v01b01.s011;

import java.util.Map;

import com.icomp.entity.base.Vtransitalarm;

/**
 * 在途计划报警查询SERVICE接口
 * @ClassName: ICOMPV01B01S011Service 
 * @author Taoyy
 * @date 2014-8-15 下午06:10:00
 */
public interface ICOMPV01B01S011Service {
	/**
	 * 在途计划报警查询列表
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Vtransitalarm entity);



}
