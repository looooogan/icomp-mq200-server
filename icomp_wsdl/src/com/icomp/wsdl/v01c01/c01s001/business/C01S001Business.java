package com.icomp.wsdl.v01c01.c01s001.business;


import com.icomp.wsdl.v01c01.c01s001.endpoint.C01S001Request;
import com.icomp.wsdl.v01c01.c01s001.endpoint.C01S001Respons;


public interface C01S001Business {
	
	/**
	 * 取得钻头(刀片)入库的信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public C01S001Respons getBitInputInf(C01S001Request request)throws Exception; 
	
	/**
	 * 提交钻头入库的信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public C01S001Respons setBitInputInf(C01S001Request request)throws Exception;
	
	/**
	 *
	 * 查询钻头(刀片)入库的信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public C01S001Respons searchBitInputInf(C01S001Request request)throws Exception; 
	
	/**
	 * 提交刀片入库的信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public C01S001Respons setToolInputInf(C01S001Request request)throws Exception;
}
	
