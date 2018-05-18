package com.icomp.wsdl.v01c02.c02s011.endpoint.impl;

import javax.jws.WebService;

import com.icomp.wsdl.v01c02.c02s011.business.impl.C02S011BusinessImpl;
import com.icomp.wsdl.v01c02.c02s011.endpoint.C02S011Wsdl;
@WebService(endpointInterface = "com.icomp.wsdl.v01c02.c02s011.endpoint.C02S011Wsdl")
public class C02S011WsdlImpl implements C02S011Wsdl{

	@SuppressWarnings("unused")
	private C02S011BusinessImpl c02S011Business;
	
	public void setC02S011Business(C02S011BusinessImpl c02S011Business) {
		this.c02S011Business = c02S011Business;
	}
}
