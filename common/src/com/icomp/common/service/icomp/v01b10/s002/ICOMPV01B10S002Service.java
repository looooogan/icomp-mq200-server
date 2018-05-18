package com.icomp.common.service.icomp.v01b10.s002;

import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Vsystemlog;

public interface ICOMPV01B10S002Service {
	
	/**
	 *  手持机日志列表
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> getList(Vsystemlog entity);
	
	/**
	 * 取得页面grid显示项目列表
	 * @param pageID
	 * @param lang
	 * @param langValue 
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID,String langCode, String langValue);




}
