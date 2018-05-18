package com.icomp.wsdl.v01c02.c02s002.endpoint.impl;

import javax.jws.WebService;

import com.icomp.wsdl.v01c02.c02s002.business.impl.C02S002BusinessImpl;
import com.icomp.wsdl.v01c02.c02s002.endpoint.C02S002Wsdl;
@WebService(endpointInterface = "com.icomp.wsdl.v01c02.c02s002.endpoint.C02S002Wsdl")
public class C02S002WsdlImpl implements C02S002Wsdl{

	@SuppressWarnings("unused")
	private C02S002BusinessImpl c02S002Business;
	
	public void setC02S002Business(C02S002BusinessImpl c02S002Business) {
		this.c02S002Business = c02S002Business;
	}
}
