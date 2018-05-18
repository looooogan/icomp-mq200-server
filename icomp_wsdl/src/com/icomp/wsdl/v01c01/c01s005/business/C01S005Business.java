package com.icomp.wsdl.v01c01.c01s005.business;

import com.icomp.wsdl.v01c01.c01s005.endpoint.C01S005Request;
import com.icomp.wsdl.v01c01.c01s005.endpoint.C01S005Respons;


public interface C01S005Business {
	
	/**
	 * 报废
	 * @param request
	 * @return
	 * @throws Exception
	 */
	 C01S005Respons saveScrap(C01S005Request request)throws Exception;

	/**
	 * 获取刀具信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	 C01S005Respons getToolMsg(C01S005Request request)throws Exception;

	/**
	 * 清空当前扫描的标签信息
	 * @param request
	 * @return
	 * @throws Exception
     */
	C01S005Respons delRfidCodeIsNull(C01S005Request request) throws Exception;
}
	
