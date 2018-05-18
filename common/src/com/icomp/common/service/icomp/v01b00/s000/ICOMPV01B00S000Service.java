package com.icomp.common.service.icomp.v01b00.s000;


import java.util.List;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Vgrantlist;

/**
 * 用户登录Service
 * @author yzq
 *
 */
public interface ICOMPV01B00S000Service {


	/**
	 * 用户登录
	 * @param entity 登录用户名
	 * @return 登录用户信息
	 * @throws BusinessException
	 */
	public Customer login (Customer entity);

	/**
	 * 取得用户权限信息
	 * @param entity 权限信息查询条件
	 * @return 用户权限信息
	 */
	public List<Vgrantlist> getUserGrant (Vgrantlist entity);
}
