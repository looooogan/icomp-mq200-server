package com.icomp.wsdl.v01c03.c03s003.endpoint;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService 
public interface C03S003Wsdl {
	/**
	 * 取得设备类型及设备列表
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public String getEquipment(@WebParam(name = "request")String request)throws Exception;
	
	/**
	 * 绑定设备标签
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public String saveEquipmentRfid(@WebParam(name = "request")String request)throws Exception;




	/**
	 * 查询员工信息
	 * @param request
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public String findMemberMsgByCard(@WebParam(name = "request")String request)throws Exception;
	/**
	 * 初始化员工卡
	 * @param request
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public String submitEmployeeCardMsg(@WebParam(name = "request")String request)throws Exception;

}
