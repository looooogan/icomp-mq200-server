package com.icomp.common.service.icomp.v01b01.s001;

import com.icomp.entity.base.Storagerecord;

import java.util.Map;

/**
 * 入库信息查询SERVICE接口
 * @ClassName: ICOMPV01B01S001Service 
 * @author Taoyy
 * @date 2014-8-19 下午03:46:22
 */
public interface ICOMPV01B01S001Service {
	/**
	 * 入库信息查询
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> getList(Storagerecord entity);


	String getNumeber();

}
