package com.icomp.wsdl.v01c02.c02s005.business.impl;

import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c02.s005.ICOMPV01C02S005Service;
import com.icomp.wsdl.v01c02.c02s005.business.C02S005Business;


public class C02S005BusinessImpl implements C02S005Business{
	

	@SuppressWarnings("unused")
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	

	@SuppressWarnings("unused")
	private ICOMPV01C02S005Service iCOMPV01C02S005Service;
	
	public void setiCOMPV01C02S005Service(
			ICOMPV01C02S005Service iCOMPV01C02S005Service) {
		this.iCOMPV01C02S005Service = iCOMPV01C02S005Service;
	}
}
