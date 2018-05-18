package com.icomp.wsdl.v01c01.c01s001.endpoint;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService 
public interface C01S001Wsdl {
	/**
	 * 取得钻头(刀片)入库的信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String getBitInputInf(@WebParam(name = "request") String request)throws Exception;
	
	/**
	 * 提交钻头入库信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String setBitInputInf(@WebParam(name = "request") String request)throws Exception;
	
	/**
	 * 查询钻头（刀片）入库的信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String searchBitInputInf(@WebParam(name = "request") String request)throws Exception;
	
	/**
	 * 提交刀片入库信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String setToolInputInf(@WebParam(name = "request") String request)throws Exception;
	
}
