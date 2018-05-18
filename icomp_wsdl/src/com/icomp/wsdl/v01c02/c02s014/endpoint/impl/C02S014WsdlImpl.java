package com.icomp.wsdl.v01c02.c02s014.endpoint.impl;

import javax.jws.WebService;

import com.icomp.wsdl.v01c02.c02s014.business.impl.C02S014BusinessImpl;
import com.icomp.wsdl.v01c02.c02s014.endpoint.C02S014Wsdl;
@WebService(endpointInterface = "com.icomp.wsdl.v01c02.c02s014.endpoint.C02S014Wsdl")
public class C02S014WsdlImpl implements C02S014Wsdl{

	@SuppressWarnings("unused")
	private C02S014BusinessImpl c02S014Business;
	
	public void setC02S014Business(C02S014BusinessImpl c02S014Business) {
		this.c02S014Business = c02S014Business;
	}
}
