package com.icomp.wsdl.v01c05.c05s003.endpoint.impl;

import javax.jws.WebService;

import com.icomp.wsdl.v01c05.c05s003.business.impl.C05S003BusinessImpl;
import com.icomp.wsdl.v01c05.c05s003.endpoint.C05S003Wsdl;
@WebService(endpointInterface = "com.icomp.wsdl.v01c05.c05s003.endpoint.C05S003Wsdl")
public class C05S003WsdlImpl implements C05S003Wsdl{

	@SuppressWarnings("unused")
	private C05S003BusinessImpl c05S003Business;
	
	public void setC05S003Business(C05S003BusinessImpl c05S003Business) {
		this.c05S003Business = c05S003Business;
	}
}
