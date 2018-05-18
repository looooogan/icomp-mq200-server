package com.icomp.wsdl.v01c03.c03s003.business;

import com.icomp.wsdl.v01c03.c03s003.endpoint.C03S003Request;
import com.icomp.wsdl.v01c03.c03s003.endpoint.C03S003Respons;


public interface C03S003Business {
	/**
	 * 验证RFID是否可用
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public C03S003Respons getEquipment(C03S003Request request)throws Exception; 
	
	/**
	 * 取得合成刀具列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public C03S003Respons saveEquipmentRfid(C03S003Request request)throws Exception;

	/**
	 * 查询员工信息
	 * @param request
	 * @throws Exception
     */
	public C03S003Respons findMemberMsgByCard(C03S003Request request)throws Exception;

	/**
	 * 初始化员工卡
	 * @param request
	 * @return
	 * @throws Exception
     */
	public C03S003Respons submitEmployeeCardMsg(C03S003Request request)throws Exception;
}
