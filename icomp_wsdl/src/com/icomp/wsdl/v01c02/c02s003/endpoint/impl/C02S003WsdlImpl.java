package com.icomp.wsdl.v01c02.c02s003.endpoint.impl;

import javax.jws.WebService;

import com.icomp.wsdl.v01c02.c02s003.business.impl.C02S003BusinessImpl;
import com.icomp.wsdl.v01c02.c02s003.endpoint.C02S003Wsdl;
@WebService(endpointInterface = "com.icomp.wsdl.v01c02.c02s003.endpoint.C02S003Wsdl")
public class C02S003WsdlImpl implements C02S003Wsdl{

	@SuppressWarnings("unused")
	private C02S003BusinessImpl c02S003Business;
	
	public void setC02S003Business(C02S003BusinessImpl c02S003Business) {
		this.c02S003Business = c02S003Business;
	}
}
