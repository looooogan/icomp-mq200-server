package com.icomp.wsdl.v01c01.c01s011.business;

import com.icomp.common.exception.BusinessException;
import com.icomp.wsdl.v01c01.c01s011.endpoint.C01S011Request;
import com.icomp.wsdl.v01c01.c01s011.endpoint.C01S011Respons;
/**
 * 设备安上-Business接口
 * @ClassName: C01S011Business 
 * @author Taoyy
 * @update Shil
 * @date 2014-9-23 下午02:48:46
 * @udateTime 2016-2-23 19:05:27 
 */
public interface C01S011Business {
	
	
	/**
	 * 取得合成刀信息和设备列表
	 * @title getSyntheticInfoEquipmentList 
	 * @param regSwitch
	 * @return
	 * @throws Exception 
	 * C01S011Respons
	 */
	public C01S011Respons getSyntheticInfoEquipmentList(C01S011Request regSwitch) throws BusinessException, Exception;

	/**
	 * 提交合成刀具安上设备信息
	 * @title submitSyntheticInstallEquipmentInfo 
	 * @param regSwitch
	 * @return
	 * C01S011Respons
	 * @throws Exception 
	 */
	public C01S011Respons submitSyntheticInstallEquipmentInfo(C01S011Request regSwitch)throws BusinessException, Exception;






















/**************************************************************************************************/
	/**
	 * 取得合成刀具安装设备信息
	 * @title getEquipmentToolInfo 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 * C01S011Respons
	 */
	public C01S011Respons getEquipmentToolInfo(C01S011Request regSwitch)throws Exception;
	
	/**
	 * 取得设备信息
	 * @title getEquipmentToolInfo 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 * C01S011Respons
	 */
	public C01S011Respons getEquipmentInfo(C01S011Request regSwitch)throws Exception;
	
	/**
	 * 合成刀具安上设备
	 * @title saveToolInEquipment 
	 * @param regSwitch
	 * @return
	 * C01S011Respons
	 * @throws Exception 
	 */
	public C01S011Respons saveToolInEquipment(C01S011Request regSwitch)throws Exception;

;
	
	
	
}
