package com.icomp.wsdl.v01c02.c02s006.business;

import com.icomp.wsdl.v01c02.c02s006.endpoint.C02S006Request;
import com.icomp.wsdl.v01c02.c02s006.endpoint.C02S006Respons;

public interface C02S006Business {

	/**
	 * 取得部门列表及已注册部门信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public C02S006Respons getDepatement(C02S006Request request)throws Exception; 
	
	/**
	 * 手持机注册
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public C02S006Respons saveHand(C02S006Request request)throws Exception; 
}
