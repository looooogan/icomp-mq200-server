package com.icomp.common.service.icomp.v01b02.s004;

import java.util.Map;

import com.icomp.entity.base.Vtoolsetting;

public interface ICOMPV01B02S004Service {
	/**
	 *  对刀记录查询列表
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Vtoolsetting entity);



}
