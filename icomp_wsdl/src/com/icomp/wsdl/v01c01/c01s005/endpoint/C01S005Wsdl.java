package com.icomp.wsdl.v01c01.c01s005.endpoint;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService 
public interface C01S005Wsdl {
	/**
	 * 报废
	 * @param request
	 * @return
	 * @throws Exception
	 */
	 String saveScrap(@WebParam(name = "request") String request)throws Exception;

	/**
	 * 获取刀具信息
	 * @param request
	 * @return
	 * @throws Exception
     */
	 String getToolMsg(@WebParam(name = "request") String request)throws Exception;

	/**
	 * 清空当前扫描的标签信息
	 * @param request
	 * @return
	 * @throws Exception
     */
	 String delRfidCodeIsNull(@WebParam(name = "request") String request)throws Exception;


}
