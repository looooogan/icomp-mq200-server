package com.icomp.wsdl.v01c02.c02s009.business.impl;

import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c02.s009.ICOMPV01C02S009Service;
import com.icomp.wsdl.v01c02.c02s009.business.C02S009Business;


public class C02S009BusinessImpl implements C02S009Business{
	

	@SuppressWarnings("unused")
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	

	@SuppressWarnings("unused")
	private ICOMPV01C02S009Service iCOMPV01C02S009Service;
	
	public void setiCOMPV01C02S009Service(
			ICOMPV01C02S009Service iCOMPV01C02S009Service) {
		this.iCOMPV01C02S009Service = iCOMPV01C02S009Service;
	}
}
