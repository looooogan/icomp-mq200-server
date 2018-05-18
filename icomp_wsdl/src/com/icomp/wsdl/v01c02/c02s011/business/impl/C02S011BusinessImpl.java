package com.icomp.wsdl.v01c02.c02s011.business.impl;

import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c02.s011.ICOMPV01C02S011Service;
import com.icomp.wsdl.v01c02.c02s011.business.C02S011Business;


public class C02S011BusinessImpl implements C02S011Business{
	

	@SuppressWarnings("unused")
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	

	@SuppressWarnings("unused")
	private ICOMPV01C02S011Service iCOMPV01C02S011Service;
	
	public void setiCOMPV01C02S011Service(
			ICOMPV01C02S011Service iCOMPV01C02S011Service) {
		this.iCOMPV01C02S011Service = iCOMPV01C02S011Service;
	}
}
