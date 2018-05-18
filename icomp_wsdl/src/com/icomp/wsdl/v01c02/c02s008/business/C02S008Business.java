package com.icomp.wsdl.v01c02.c02s008.business;

import com.icomp.wsdl.v01c02.c02s008.endpoint.C02S008Request;
import com.icomp.wsdl.v01c02.c02s008.endpoint.C02S008Respons;


public interface C02S008Business {

	/**
	 * 保存用户卡绑定信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public C02S008Respons saveUserBinding(C02S008Request request)throws Exception;
}
