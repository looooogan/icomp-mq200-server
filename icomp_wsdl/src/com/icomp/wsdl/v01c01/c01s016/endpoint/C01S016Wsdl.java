package com.icomp.wsdl.v01c01.c01s016.endpoint;

import java.net.ConnectException;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 回库处理-Webservce接口
 * @ClassName: C01S016Wsdl 
 * @author Taoyy
 * @date 2016-3-1 下午12:00:27
 */
@WebService
public interface C01S016Wsdl {
	/**
	 * 取得待报废刀具信息
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public String getToolLibraryInfo(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 提交回库处理刀具信息
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public String saveToolLibraryInfo(@WebParam(name = "request")String request) throws Exception;
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * 取得扫描刀具的修复信息
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public String getToolInfo(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 刀具入库交接处理
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public String saveToolJoint(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 取得刀具扫描的详细信息（非单品）
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public String getToolInfoDetail(@WebParam(name = "request")String request) throws Exception;
	/**
	 * 取得刀具扫描的详细信息（非单品）
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public String saveToolInfoDetail(@WebParam(name = "request")String request) throws Exception;
}
