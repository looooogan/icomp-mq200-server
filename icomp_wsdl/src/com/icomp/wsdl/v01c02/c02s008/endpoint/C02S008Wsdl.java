package com.icomp.wsdl.v01c02.c02s008.endpoint;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService 
public interface C02S008Wsdl {

	/**
	 * 保存用户卡绑定信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String saveUserBinding(@WebParam(name = "request")String request)throws Exception; 
}
