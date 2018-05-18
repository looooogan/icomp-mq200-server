package com.icomp.wsdl.v01c02.c02s006.endpoint;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService 
public interface C02S006Wsdl {

	/**
	 * 取得部门列表及已注册部门信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String getDepatement(@WebParam(name = "request")String request)throws Exception; 
	
	/**
	 * 手持机注册
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String saveHand(@WebParam(name = "request")String request)throws Exception; 
}
