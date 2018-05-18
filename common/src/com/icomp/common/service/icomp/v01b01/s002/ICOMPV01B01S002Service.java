package com.icomp.common.service.icomp.v01b01.s002;

import com.icomp.entity.base.Vtoollibraryhistory;

import java.util.Map;

/**
 * 出库信息查询SERVICE接口
 * @ClassName: ICOMPV01B01S002Service 
 * @author Taoyy
 * @date 2014-8-14 下午02:13:21
 */
public interface ICOMPV01B01S002Service {
	/**
	 * 出库信息查询-模糊查询
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Vtoollibraryhistory entity);


	String getNumber();

}
