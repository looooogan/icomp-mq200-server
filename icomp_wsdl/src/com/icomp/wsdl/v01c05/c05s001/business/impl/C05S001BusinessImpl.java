package com.icomp.wsdl.v01c05.c05s001.business.impl;

import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c05.s001.ICOMPV01C05S001Service;
import com.icomp.wsdl.v01c05.c05s001.business.C05S001Business;


public class C05S001BusinessImpl implements C05S001Business{
	

	@SuppressWarnings("unused")
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	

	@SuppressWarnings("unused")
	private ICOMPV01C05S001Service iCOMPV01C05S001Service;
	
	public void setiCOMPV01C05S001Service(
			ICOMPV01C05S001Service iCOMPV01C05S001Service) {
		this.iCOMPV01C05S001Service = iCOMPV01C05S001Service;
	}
}
