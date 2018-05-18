package com.icomp.common.service.icomp.v01b07.s006;

import java.util.Map;

import com.icomp.entity.base.Vtoolprocured;

/**
 * 工作记录SERVICE接口
 * @ClassName: ICOMPV01B07S006Service 
 * @author Licc
 * @date 2014-9-25 下午04:17:50
 */
public interface ICOMPV01B07S006Service {
	
 /**
  * 工作记录列表
  * @title getList 
  * @param entity
  * @return
  * Map<String,Object>
  */
 public	Map<String, Object> getList(Vtoolprocured entity);



}
