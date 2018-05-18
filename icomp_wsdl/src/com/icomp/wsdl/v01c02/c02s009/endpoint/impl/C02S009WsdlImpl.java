package com.icomp.wsdl.v01c02.c02s009.endpoint.impl;

import javax.jws.WebService;

import com.icomp.wsdl.v01c02.c02s009.business.impl.C02S009BusinessImpl;
import com.icomp.wsdl.v01c02.c02s009.endpoint.C02S009Wsdl;
@WebService(endpointInterface = "com.icomp.wsdl.v01c02.c02s009.endpoint.C02S009Wsdl")
public class C02S009WsdlImpl implements C02S009Wsdl{

	@SuppressWarnings("unused")
	private C02S009BusinessImpl c02S009Business;
	
	public void setC02S009Business(C02S009BusinessImpl c02S009Business) {
		this.c02S009Business = c02S009Business;
	}
}
