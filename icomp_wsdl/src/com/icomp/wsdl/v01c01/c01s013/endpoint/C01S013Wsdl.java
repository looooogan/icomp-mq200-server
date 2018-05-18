package com.icomp.wsdl.v01c01.c01s013.endpoint;

import java.net.ConnectException;

import javax.jws.WebParam;
import javax.jws.WebService;
/**
 * 设备卸下-Webservce接口
 * @ClassName: C01S013Wsdl 
 * @author Taoyy
 * @date 2014-9-23 上午11:55:43
 */
@WebService
public interface C01S013Wsdl{
	
	
	
	
	
	/**
	 * 取得合成刀下设备信息
	 * @title getSynthesisToolInfoOutEqu
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 * String
	 */
	public String getSynthesisToolInfoOutEqu(@WebParam(name = "request")String request) throws Exception;
	
	
	
	/**
	 * 提交合成刀下设备信息
	 * @title getSynthesisToolInfoOutEqu
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 * String
	 */
	public String submitSyntheticUnloadEquipmentInfo(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 取得设备下（砂轮）合成刀具信息
	 * @title getSynthesisToolInfoOutWheel 
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 * String
	 */
	public String getSynthesisToolInfoOutWheel(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 提交合成刀下设备信息
	 * @title submitSyntheticUnloadWheelInfo 
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 * String
	 */
	public String submitSyntheticUnloadWheelInfo(@WebParam(name = "request")String request) throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 取得扫描合成刀具信息
	 * @title getSynthesisToolInfo 
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 * String
	 */
	public String getSynthesisToolInfo(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 合成刀具卸下设备
	 * @title saveToolRecovery 
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 * String
	 */
	public String saveToolRecovery(@WebParam(name = "request")String request) throws Exception;
}
