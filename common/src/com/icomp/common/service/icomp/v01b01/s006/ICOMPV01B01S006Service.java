package com.icomp.common.service.icomp.v01b01.s006;

import java.util.Map;

import com.icomp.entity.base.Vreplacesynthesis;

/**
 * 更替刀具库存查询SERVICE接口
 * @ClassName: ICOMPV01B01S006Service 
 * @author Taoyy
 * @date 2014-8-15 上午10:56:23
 */
public interface ICOMPV01B01S006Service {
	/**
	 * 更替刀具库存列表
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
  public Map<String, Object> getList(Vreplacesynthesis entity);



}
