package com.icomp.common.service.icomp.v01c02.s008;

import com.icomp.entity.base.Customer;


public interface ICOMPV01C02S008Service {
	
	/**
	 * 员工卡绑定处理
	 * @param entity
	 * @return
	 */
	public Customer saveUserBinding(Customer entity);
}
