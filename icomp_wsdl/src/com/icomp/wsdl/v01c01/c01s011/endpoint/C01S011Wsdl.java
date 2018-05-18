package com.icomp.wsdl.v01c01.c01s011.endpoint;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.net.ConnectException;
/**
 * 设备安上-Webservce接口
 * @ClassName: C01S011Wsdl 
 * @author Taoyy
 * @date 2014-9-22 下午6:23:11
 */
@WebService
public interface C01S011Wsdl  {
	
	/**
	 *  取得合成刀信息和设备列表
	 * @title getSyntheticInfoEquipmentList
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 * String
	 */
	 String getSyntheticInfoEquipmentList(@WebParam(name = "request")String request) throws Exception;

	/**
	 * 提交合成刀具安上设备信息
	 * @title submitSyntheticInstallEquipmentInfo 
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 * String
	 */
	 String submitSyntheticInstallEquipmentInfo(@WebParam(name = "request")String request) throws Exception;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/***********************************************************************************/
	
	
	/**
	 * 取得设备信息
	 * @title getEquipmentToolInfo 
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 * C01S011Respons
	 */
	public String getEquipmentInfo(@WebParam(name = "request")String request) throws Exception;

	/**
	 * 合成刀具安上设备
	 * @title saveToolInEquipment 
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 * String
	 */
	public String saveToolInEquipment(@WebParam(name = "request")String request) throws Exception;
}
