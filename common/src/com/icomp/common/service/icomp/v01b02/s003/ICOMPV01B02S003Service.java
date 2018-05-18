package com.icomp.common.service.icomp.v01b02.s003;

import java.util.Map;

import com.icomp.entity.base.Vredemptionapplied;

public interface ICOMPV01B02S003Service {
	/**
	 *  换领申请信息列表
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Vredemptionapplied entity);



}
