package com.icomp.wsdl.v01c02.c02s013.business.impl;

import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c02.s013.ICOMPV01C02S013Service;
import com.icomp.wsdl.v01c02.c02s013.business.C02S013Business;


public class C02S013BusinessImpl implements C02S013Business{
	

	@SuppressWarnings("unused")
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	

	@SuppressWarnings("unused")
	private ICOMPV01C02S013Service iCOMPV01C02S013Service;
	
	public void setiCOMPV01C02S013Service(
			ICOMPV01C02S013Service iCOMPV01C02S013Service) {
		this.iCOMPV01C02S013Service = iCOMPV01C02S013Service;
	}
}
