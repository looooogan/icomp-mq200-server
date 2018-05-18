package com.icomp.wsdl.v01c02.c02s010.endpoint.impl;

import javax.jws.WebService;

import com.icomp.wsdl.v01c02.c02s010.business.impl.C02S010BusinessImpl;
import com.icomp.wsdl.v01c02.c02s010.endpoint.C02S010Wsdl;
@WebService(endpointInterface = "com.icomp.wsdl.v01c02.c02s010.endpoint.C02S010Wsdl")
public class C02S010WsdlImpl implements C02S010Wsdl{

	@SuppressWarnings("unused")
	private C02S010BusinessImpl c02S010Business;
	
	public void setC02S010Business(C02S010BusinessImpl c02S010Business) {
		this.c02S010Business = c02S010Business;
	}
}
