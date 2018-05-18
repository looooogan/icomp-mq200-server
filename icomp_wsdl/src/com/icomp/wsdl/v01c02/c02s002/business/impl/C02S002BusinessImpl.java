package com.icomp.wsdl.v01c02.c02s002.business.impl;

import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c02.s002.ICOMPV01C02S002Service;
import com.icomp.wsdl.v01c02.c02s002.business.C02S002Business;


public class C02S002BusinessImpl implements C02S002Business{
	

	@SuppressWarnings("unused")
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	

	@SuppressWarnings("unused")
	private ICOMPV01C02S002Service iCOMPV01C02S002Service;
	
	public void setiCOMPV01C02S002Service(
			ICOMPV01C02S002Service iCOMPV01C02S002Service) {
		this.iCOMPV01C02S002Service = iCOMPV01C02S002Service;
	}
}
