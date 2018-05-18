package com.icomp.common.service.icomp.v01b01.s014;

import java.util.Map;

import com.icomp.entity.base.Vstocking;

/**
 * 库存盘点查询SERVICE接口
 * @ClassName: ICOMPV01B01S014Service 
 * @author Licc
 * @date 2014-11-12 下午03:46:22
 */
public interface ICOMPV01B01S014Service {
	
	/**
	 * 库存盘点查询
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> getList(Vstocking entity);



}
