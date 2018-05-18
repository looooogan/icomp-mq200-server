package com.icomp.wsdl.v01c01.c01s024.endpoint;

import java.net.ConnectException;

import javax.jws.WebParam;
import javax.jws.WebService;
/**
 * 刀具管理-刀具状态查询-Webservce接口
 * @ClassName: C01S024Wsdl 
 * @author Taoyy
 * @date 2014-9-23 下午12:14:23
 */
@WebService
public interface C01S024Wsdl {
	
	/**
	 * 取得单品刀具信息
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public String getToolInfo(@WebParam(name = "request")String request) throws  Exception;
	/**
	 * 取得信息
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public String getInformation(@WebParam(name = "request")String request) throws  Exception;


}

