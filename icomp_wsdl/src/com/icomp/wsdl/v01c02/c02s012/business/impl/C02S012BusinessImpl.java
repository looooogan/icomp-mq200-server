package com.icomp.wsdl.v01c02.c02s012.business.impl;

import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c02.s012.ICOMPV01C02S012Service;
import com.icomp.wsdl.v01c02.c02s012.business.C02S012Business;


public class C02S012BusinessImpl implements C02S012Business{
	

	@SuppressWarnings("unused")
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	

	@SuppressWarnings("unused")
	private ICOMPV01C02S012Service iCOMPV01C02S012Service;
	
	public void setiCOMPV01C02S012Service(
			ICOMPV01C02S012Service iCOMPV01C02S012Service) {
		this.iCOMPV01C02S012Service = iCOMPV01C02S012Service;
	}
}
