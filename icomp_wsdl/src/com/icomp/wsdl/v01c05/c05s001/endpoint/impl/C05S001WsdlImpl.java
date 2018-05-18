package com.icomp.wsdl.v01c05.c05s001.endpoint.impl;

import javax.jws.WebService;

import com.icomp.wsdl.v01c05.c05s001.business.impl.C05S001BusinessImpl;
import com.icomp.wsdl.v01c05.c05s001.endpoint.C05S001Wsdl;
@WebService(endpointInterface = "com.icomp.wsdl.v01c05.c05s001.endpoint.C05S001Wsdl")
public class C05S001WsdlImpl implements C05S001Wsdl{

	@SuppressWarnings("unused")
	private C05S001BusinessImpl c05S001Business;
	
	public void setC05S001Business(C05S001BusinessImpl c05S001Business) {
		this.c05S001Business = c05S001Business;
	}
}
