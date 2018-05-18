package com.icomp.wsdl.v01c05.c05s003.business.impl;

import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c05.s003.ICOMPV01C05S003Service;
import com.icomp.wsdl.v01c05.c05s003.business.C05S003Business;


public class C05S003BusinessImpl implements C05S003Business{
	

	@SuppressWarnings("unused")
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	

	@SuppressWarnings("unused")
	private ICOMPV01C05S003Service iCOMPV01C05S003Service;
	
	public void setiCOMPV01C05S003Service(
			ICOMPV01C05S003Service iCOMPV01C05S003Service) {
		this.iCOMPV01C05S003Service = iCOMPV01C05S003Service;
	}
}
