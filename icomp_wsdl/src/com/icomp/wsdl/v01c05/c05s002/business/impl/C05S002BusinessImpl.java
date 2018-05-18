package com.icomp.wsdl.v01c05.c05s002.business.impl;

import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c05.s002.ICOMPV01C05S002Service;
import com.icomp.wsdl.v01c05.c05s002.business.C05S002Business;


public class C05S002BusinessImpl implements C05S002Business{
	

	@SuppressWarnings("unused")
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	

	@SuppressWarnings("unused")
	private ICOMPV01C05S002Service iCOMPV01C05S002Service;
	
	public void setiCOMPV01C05S002Service(
			ICOMPV01C05S002Service iCOMPV01C05S002Service) {
		this.iCOMPV01C05S002Service = iCOMPV01C05S002Service;
	}
}
