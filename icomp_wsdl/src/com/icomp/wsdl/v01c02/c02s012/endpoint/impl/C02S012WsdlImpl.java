package com.icomp.wsdl.v01c02.c02s012.endpoint.impl;

import javax.jws.WebService;

import com.icomp.wsdl.v01c02.c02s012.business.impl.C02S012BusinessImpl;
import com.icomp.wsdl.v01c02.c02s012.endpoint.C02S012Wsdl;
@WebService(endpointInterface = "com.icomp.wsdl.v01c02.c02s012.endpoint.C02S012Wsdl")
public class C02S012WsdlImpl implements C02S012Wsdl{

	@SuppressWarnings("unused")
	private C02S012BusinessImpl c02S012Business;
	
	public void setC02S012Business(C02S012BusinessImpl c02S012Business) {
		this.c02S012Business = c02S012Business;
	}
}
