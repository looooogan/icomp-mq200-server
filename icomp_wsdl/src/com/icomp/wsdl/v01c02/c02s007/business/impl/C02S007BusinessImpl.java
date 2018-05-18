package com.icomp.wsdl.v01c02.c02s007.business.impl;

import java.util.List;

import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c02.s007.ICOMPV01C02S007Service;
import com.icomp.entity.base.Languagetable;
import com.icomp.wsdl.v01c02.c02s007.business.C02S007Business;
import com.icomp.wsdl.v01c02.c02s007.endpoint.C02S007Request;
import com.icomp.wsdl.v01c02.c02s007.endpoint.C02S007Respons;


public class C02S007BusinessImpl implements C02S007Business{
	

	@SuppressWarnings("unused")
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	

	private ICOMPV01C02S007Service iCOMPV01C02S007Service;
	
	public void setiCOMPV01C02S007Service(
			ICOMPV01C02S007Service iCOMPV01C02S007Service) {
		this.iCOMPV01C02S007Service = iCOMPV01C02S007Service;
	}
	
	/**
	 * 获取系统支持的语言列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public C02S007Respons getLangageList(C02S007Request request)throws Exception{
		C02S007Respons respons = new C02S007Respons();
		Languagetable entity = new Languagetable();
		List<Languagetable> list = (List<Languagetable>)iCOMPV01C02S007Service.getLangageList(entity);
		if(list.size() == 1 && list.get(0).isRetErrFlag()){
			  throw new BusinessException(list.get(0).getMessageCode(), request.getLanguageCode(),request.getLanguageValue());
		}
		respons.setList(list);
		
		return respons;
	}
}
