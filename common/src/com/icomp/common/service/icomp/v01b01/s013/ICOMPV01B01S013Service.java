package com.icomp.common.service.icomp.v01b01.s013;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Vtoolsop;

import java.util.Map;

/**
 * 库存状况查询SERVICE接口
 * @ClassName: ICOMPV01B01S013Service 
 * @author Licc
 * @date 2014-11-10 下午03:46:22
 */
public interface ICOMPV01B01S013Service {
	
	/**
	 * 库存状况查询
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> getList(Vtoolsop entity);

	/**
	 * 编辑用户信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> sapEdit(Map<String, Object> param,String langCode,String langValue) throws Exception;



}
