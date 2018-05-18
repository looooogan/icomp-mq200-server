package com.icomp.wsdl.v01c02.c02s005.endpoint.impl;

import javax.jws.WebService;

import com.icomp.wsdl.v01c02.c02s005.business.impl.C02S005BusinessImpl;
import com.icomp.wsdl.v01c02.c02s005.endpoint.C02S005Wsdl;
@WebService(endpointInterface = "com.icomp.wsdl.v01c02.c02s005.endpoint.C02S005Wsdl")
public class C02S005WsdlImpl implements C02S005Wsdl{

	@SuppressWarnings("unused")
	private C02S005BusinessImpl c02S005Business;
	
	public void setC02S005Business(C02S005BusinessImpl c02S005Business) {
		this.c02S005Business = c02S005Business;
	}
}
