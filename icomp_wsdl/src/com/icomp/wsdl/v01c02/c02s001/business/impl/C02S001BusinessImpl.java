package com.icomp.wsdl.v01c02.c02s001.business.impl;

import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c02.s001.ICOMPV01C02S001Service;
import com.icomp.wsdl.v01c02.c02s001.business.C02S001Business;


public class C02S001BusinessImpl implements C02S001Business{
	

	@SuppressWarnings("unused")
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	

	@SuppressWarnings("unused")
	private ICOMPV01C02S001Service iCOMPV01C02S001Service;
	
	public void setiCOMPV01C02S001Service(
			ICOMPV01C02S001Service iCOMPV01C02S001Service) {
		this.iCOMPV01C02S001Service = iCOMPV01C02S001Service;
	}
}
