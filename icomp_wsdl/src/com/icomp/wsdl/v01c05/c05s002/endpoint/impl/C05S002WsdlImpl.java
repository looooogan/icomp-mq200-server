package com.icomp.wsdl.v01c05.c05s002.endpoint.impl;

import javax.jws.WebService;

import com.icomp.wsdl.v01c05.c05s002.business.impl.C05S002BusinessImpl;
import com.icomp.wsdl.v01c05.c05s002.endpoint.C05S002Wsdl;
@WebService(endpointInterface = "com.icomp.wsdl.v01c05.c05s002.endpoint.C05S002Wsdl")
public class C05S002WsdlImpl implements C05S002Wsdl{

	@SuppressWarnings("unused")
	private C05S002BusinessImpl c05S002Business;
	
	public void setC05S002Business(C05S002BusinessImpl c05S002Business) {
		this.c05S002Business = c05S002Business;
	}
}
