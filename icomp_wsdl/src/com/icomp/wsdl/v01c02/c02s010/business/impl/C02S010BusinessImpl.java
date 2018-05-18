package com.icomp.wsdl.v01c02.c02s010.business.impl;

import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c02.s010.ICOMPV01C02S010Service;
import com.icomp.wsdl.v01c02.c02s010.business.C02S010Business;


public class C02S010BusinessImpl implements C02S010Business{
	

	@SuppressWarnings("unused")
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	

	@SuppressWarnings("unused")
	private ICOMPV01C02S010Service iCOMPV01C02S010Service;
	
	public void setiCOMPV01C02S010Service(
			ICOMPV01C02S010Service iCOMPV01C02S010Service) {
		this.iCOMPV01C02S010Service = iCOMPV01C02S010Service;
	}
}
