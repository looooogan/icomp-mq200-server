package com.icomp.wsdl.v01c02.c02s008.business.impl;


import java.util.Date;

import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c02.s008.ICOMPV01C02S008Service;
import com.icomp.entity.base.Customer;
import com.icomp.wsdl.v01c02.c02s008.business.C02S008Business;
import com.icomp.wsdl.v01c02.c02s008.endpoint.C02S008Request;
import com.icomp.wsdl.v01c02.c02s008.endpoint.C02S008Respons;


public class C02S008BusinessImpl implements C02S008Business{
	

	@SuppressWarnings("unused")
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	

	private ICOMPV01C02S008Service iCOMPV01C02S008Service;
	
	public void setiCOMPV01C02S008Service(
			ICOMPV01C02S008Service iCOMPV01C02S008Service) {
		this.iCOMPV01C02S008Service = iCOMPV01C02S008Service;
	}

	/**
	 * 保存用户卡绑定信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public C02S008Respons saveUserBinding(C02S008Request request)throws Exception{
		C02S008Respons respons = new C02S008Respons();
		Customer entity = new Customer();
		entity.setUserName(request.getUserName());
		entity.setEmployeeCard(request.getEmployeeCard());
		entity.setUpdateTime(new Date());
		entity.setUpdateUser(request.getCustomerID()== null?"system":request.getCustomerID());
		Customer ret = (Customer)iCOMPV01C02S008Service.saveUserBinding(entity);
		if(ret.isRetErrFlag()){
			  throw new BusinessException(ret.getMessageCode(), request.getLanguageCode(),request.getLanguageValue());
		}
		return respons;
	}
}
