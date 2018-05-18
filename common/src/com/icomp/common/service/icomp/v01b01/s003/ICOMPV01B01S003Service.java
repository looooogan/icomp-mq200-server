package com.icomp.common.service.icomp.v01b01.s003;

import java.util.Map;

import com.icomp.entity.base.Vprocessingtools;

/**
 * 待处理刀具信息查询SERVICE
 * @ClassName: ICOMPV01B01S003Service 
 * @author Taoyy
 * @date 2014-8-19 下午04:29:33
 */
public interface ICOMPV01B01S003Service {
	/**
	 * 待处理刀具信息查询
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Vprocessingtools entity);



}
