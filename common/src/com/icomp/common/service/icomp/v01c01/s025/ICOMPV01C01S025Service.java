package com.icomp.common.service.icomp.v01c01.s025;

import java.util.Map;


public interface ICOMPV01C01S025Service {

	/**
	 * 保存对刀开始数据
	 * @param rfidString
	 * @param langCode
	 * @param langValue
	 * @param customerID
	 */
	public Map<String,Object>  saveToolInfo(String equipmentID,String rfidString,String langCode,String langValue,String customerID,String handsetid);
	
	/**
	 * 取得对刀设备列表
	 * @param rfidString
	 * @param langCode
	 * @param langValue
	 * @param customerID
	 */
	public Map<String,Object>  getEquipment(String rfidString);
}
