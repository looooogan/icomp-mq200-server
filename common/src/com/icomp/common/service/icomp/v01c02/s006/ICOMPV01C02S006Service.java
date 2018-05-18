package com.icomp.common.service.icomp.v01c02.s006;

import java.util.List;
import java.util.Map;

import com.icomp.entity.base.Department;
import com.icomp.entity.base.Handset;

public interface ICOMPV01C02S006Service {
	
	/**
	 * 取得部门列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Department> getDepatement(Department entity); 

	/**
	 * 取得已注册部门信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Handset> getHandsets(Handset entity); 
	
	/**
	 * 手持机注册
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> saveHand(Handset entity); 
}
