package com.icomp.common.service.icomp.v01b01.s009;

import java.util.Map;

import com.icomp.entity.base.Vinspectionrecord;

/**
 * 质检记录查询SERVICE接口
 * @ClassName: ICOMPV01B01S009Service 
 * @author Taoyy
 * @date 2014-8-15 下午04:22:21
 */
public interface ICOMPV01B01S009Service {
	/**
	 * 质检记录查询列表
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Vinspectionrecord entity);



}
