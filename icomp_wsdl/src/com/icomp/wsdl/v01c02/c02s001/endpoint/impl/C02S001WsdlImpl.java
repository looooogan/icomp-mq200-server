package com.icomp.wsdl.v01c02.c02s001.endpoint.impl;

import javax.jws.WebService;

import com.icomp.wsdl.v01c02.c02s001.business.impl.C02S001BusinessImpl;
import com.icomp.wsdl.v01c02.c02s001.endpoint.C02S001Wsdl;
@WebService(endpointInterface = "com.icomp.wsdl.v01c02.c02s001.endpoint.C02S001Wsdl")
public class C02S001WsdlImpl implements C02S001Wsdl{

	@SuppressWarnings("unused")
	private C02S001BusinessImpl c02S001Business;
	
	public void setC02S001Business(C02S001BusinessImpl c02S001Business) {
		this.c02S001Business = c02S001Business;
	}
}
