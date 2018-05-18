package com.icomp.wsdl.v01c02.c02s003.business.impl;

import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c02.s003.ICOMPV01C02S003Service;
import com.icomp.wsdl.v01c02.c02s003.business.C02S003Business;


public class C02S003BusinessImpl implements C02S003Business{
	

	@SuppressWarnings("unused")
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	

	@SuppressWarnings("unused")
	private ICOMPV01C02S003Service iCOMPV01C02S003Service;
	
	public void setiCOMPV01C02S003Service(
			ICOMPV01C02S003Service iCOMPV01C02S003Service) {
		this.iCOMPV01C02S003Service = iCOMPV01C02S003Service;
	}
}
