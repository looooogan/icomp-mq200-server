package com.icomp.common.service.icomp.v01c03.s003;

import java.util.List;
import java.util.Map;

import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Equipment;
import com.icomp.entity.base.Vgetcustomerinfo;

public interface ICOMPV01C03S003Service {
	/**
	 * 取得设备类型及设备列表
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public Map<String,Object> getEquipment(String value,String langCode);

	/**
	 * 绑定设备标签
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public Map<String,Object> saveEquipmentRfid(Equipment entity);

	/**
	 * 用户信息
	 * @return
	 * @throws Exception
	 * @param c
	 */
	Vgetcustomerinfo findMemberMsgByCard(Vgetcustomerinfo c)throws Exception;

	/**
	 * 提交员工初始化信息
	 * @param parMap
	 * @return
	 * @throws Exception
     */
	int submitEmployeeCardMsg(Map<String,Object> parMap)throws Exception;



}
