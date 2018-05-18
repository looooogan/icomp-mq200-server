package com.icomp.wsdl.v01c01.c01s002.endpoint;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService 
public interface C01S002Wsdl {
	/**
	 * 授权
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String saveAuthorized(@WebParam(name = "request") String request)throws Exception;
	
}
