package com.icomp.wsdl.v01c02.c02s004.business.impl;

import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c02.s004.ICOMPV01C02S004Service;
import com.icomp.wsdl.v01c02.c02s004.business.C02S004Business;


public class C02S004BusinessImpl implements C02S004Business{
	

	@SuppressWarnings("unused")
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	

	@SuppressWarnings("unused")
	private ICOMPV01C02S004Service iCOMPV01C02S004Service;
	
	public void setiCOMPV01C02S004Service(
			ICOMPV01C02S004Service iCOMPV01C02S004Service) {
		this.iCOMPV01C02S004Service = iCOMPV01C02S004Service;
	}
}
