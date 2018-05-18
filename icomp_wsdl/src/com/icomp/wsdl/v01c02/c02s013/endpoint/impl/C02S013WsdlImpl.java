package com.icomp.wsdl.v01c02.c02s013.endpoint.impl;

import javax.jws.WebService;

import com.icomp.wsdl.v01c02.c02s013.business.impl.C02S013BusinessImpl;
import com.icomp.wsdl.v01c02.c02s013.endpoint.C02S013Wsdl;
@WebService(endpointInterface = "com.icomp.wsdl.v01c02.c02s013.endpoint.C02S013Wsdl")
public class C02S013WsdlImpl implements C02S013Wsdl{

	@SuppressWarnings("unused")
	private C02S013BusinessImpl c02S013Business;
	
	public void setC02S013Business(C02S013BusinessImpl c02S013Business) {
		this.c02S013Business = c02S013Business;
	}
}
