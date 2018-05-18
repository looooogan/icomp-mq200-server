package com.icomp.wsdl.v01c03.c03s002.business;

import com.icomp.wsdl.v01c03.c03s002.endpoint.C03S002Request;
import com.icomp.wsdl.v01c03.c03s002.endpoint.C03S002Respons;


public interface C03S002Business {
	/**
	 * 验证RFID是否可用
	 * @param request
	 * @return
	 * @throws Exception
	 */
	 C03S002Respons checkRfid(C03S002Request request)throws Exception;
	
	/**
	 * 取得合成刀具列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	 C03S002Respons getToolList(C03S002Request request)throws Exception;
	
	/**
	 * 取得合成刀具配置信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	 C03S002Respons getToolInfo(C03S002Request request)throws Exception;
	
	/**
	 * 保存初始化合成刀具信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	 C03S002Respons saveToolList(C03S002Request request)throws Exception;

	/**
	 * 查询所有流水线和设备
	 * @param request
	 * @return
	 * @throws Exception
     */
	 C03S002Respons findAllEquipment(C03S002Request request)throws Exception;

	/**
	 * 加工设备标签绑定
	 * @param request
	 * @return
	 * @throws Exception
     */
	 C03S002Respons submitEquipmentRifdCode(C03S002Request request)throws Exception;

	/**
	 * 容器标签绑定
	 * @param regSwitch
	 * @return
	 * @throws Exception
     */
	 C03S002Respons submitContainer(C03S002Request regSwitch)throws Exception;

	/**
	 * 查询所有刃磨设备
	 * @param regSwitch
	 * @return
	 * @throws Exception
     */
	 C03S002Respons findGrindEquipment(C03S002Request regSwitch)throws Exception;

}
