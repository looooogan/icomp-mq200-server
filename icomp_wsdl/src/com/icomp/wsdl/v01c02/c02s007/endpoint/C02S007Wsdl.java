package com.icomp.wsdl.v01c02.c02s007.endpoint;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService 
public interface C02S007Wsdl {

	/**
	 * 获取系统支持的语言列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String getLangageList(@WebParam(name = "request")String request)throws Exception; 
}
