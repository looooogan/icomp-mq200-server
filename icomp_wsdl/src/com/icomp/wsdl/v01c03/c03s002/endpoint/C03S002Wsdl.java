package com.icomp.wsdl.v01c03.c03s002.endpoint;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService 
public interface C03S002Wsdl {
	/**
	 * 验证RFID是否可用
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String checkRfid(@WebParam(name = "request")String request)throws Exception; 
	
	/**
	 * 取得合成刀编码列表webService
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public String getToolList(@WebParam(name = "request")String request)throws Exception; 
	
	/**
	 * 取得合成刀具配置信息webService
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public String getToolInfo(@WebParam(name = "request")String request)throws Exception; 

	/**
	 * 保存初始化合成刀具信息webService
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public String saveToolList(@WebParam(name = "request")String request)throws Exception;
	/**
	 * 查询所有流水线和设备
	 * @param request
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public String findAllEquipment(@WebParam(name = "request")String request)throws Exception;
	/**
	 * 设备标签绑定
	 * @param request
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public String submitEquipmentRifdCode(@WebParam(name = "request")String request)throws Exception;
	/**
	 * 容器标签绑定
	 * @param request
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public String submitContainer(@WebParam(name = "request")String request)throws Exception;
	/**
	 * 查询所有刃磨设备
	 * @param request
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public String findGrindEquipment(@WebParam(name = "request")String request)throws Exception;

}
