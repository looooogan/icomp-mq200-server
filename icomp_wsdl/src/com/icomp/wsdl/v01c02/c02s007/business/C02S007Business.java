package com.icomp.wsdl.v01c02.c02s007.business;

import com.icomp.wsdl.v01c02.c02s007.endpoint.C02S007Request;
import com.icomp.wsdl.v01c02.c02s007.endpoint.C02S007Respons;

public interface C02S007Business {
	/**
	 * 获取系统支持的语言列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public C02S007Respons getLangageList(C02S007Request request)throws Exception; 
}
