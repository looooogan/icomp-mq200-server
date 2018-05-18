package com.icomp.wsdl.v01c01.c01s002.business;

import com.icomp.wsdl.v01c01.c01s002.endpoint.C01S002Request;
import com.icomp.wsdl.v01c01.c01s002.endpoint.C01S002Respons;


public interface C01S002Business {
	
	/**
	 * 授权
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public C01S002Respons saveAuthorized(C01S002Request request)throws Exception; 
	
}
	
