package com.icomp.wsdl.v01c02.c02s004.endpoint.impl;

import javax.jws.WebService;

import com.icomp.wsdl.v01c02.c02s004.business.impl.C02S004BusinessImpl;
import com.icomp.wsdl.v01c02.c02s004.endpoint.C02S004Wsdl;
@WebService(endpointInterface = "com.icomp.wsdl.v01c02.c02s004.endpoint.C02S004Wsdl")
public class C02S004WsdlImpl implements C02S004Wsdl{

	@SuppressWarnings("unused")
	private C02S004BusinessImpl c02S004Business;
	
	public void setC02S004Business(C02S004BusinessImpl c02S004Business) {
		this.c02S004Business = c02S004Business;
	}
}
