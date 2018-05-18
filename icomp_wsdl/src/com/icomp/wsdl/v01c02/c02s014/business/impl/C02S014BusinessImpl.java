package com.icomp.wsdl.v01c02.c02s014.business.impl;

import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c02.s014.ICOMPV01C02S014Service;
import com.icomp.wsdl.v01c02.c02s014.business.C02S014Business;


public class C02S014BusinessImpl implements C02S014Business{
	

	@SuppressWarnings("unused")
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	

	@SuppressWarnings("unused")
	private ICOMPV01C02S014Service iCOMPV01C02S014Service;
	
	public void setiCOMPV01C02S014Service(
			ICOMPV01C02S014Service iCOMPV01C02S014Service) {
		this.iCOMPV01C02S014Service = iCOMPV01C02S014Service;
	}
}
