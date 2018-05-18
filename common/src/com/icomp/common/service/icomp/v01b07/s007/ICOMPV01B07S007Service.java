package com.icomp.common.service.icomp.v01b07.s007;

import java.util.Map;

import com.icomp.entity.base.Rfidpurchase;

/**
 * 标签采购SERVICE接口
 * @ClassName: ICOMPV01B07S007Service 
 * @author Licc
 * @date 2014-8-21 下午04:17:50
 */
public interface ICOMPV01B07S007Service {
	
 /**
  * 标签采购列表
  * @title getList 
  * @param entity
  * @return
  * Map<String,Object>
  */
 public	Map<String, Object> getList(Rfidpurchase entity);



}
