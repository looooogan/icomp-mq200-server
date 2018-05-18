package com.icomp.common.service.icomp.v01b10.s003;

import java.util.Map;

import com.icomp.entity.base.Vsystemlog;

public interface ICOMPV01B10S003Service {
	/**
	 *  管理平台日志列表
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Vsystemlog entity);



}
