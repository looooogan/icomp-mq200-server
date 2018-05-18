package com.icomp.common.service.icomp.v01b02.s005;

import java.util.Map;

import com.icomp.entity.base.Vtoolsetting;

public interface ICOMPV01B02S005Service {
	/**
	 *  对刀工作量汇总列表
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Vtoolsetting entity);



}
