package com.icomp.common.service.icomp.v01c01.s026;

import java.util.List;
import java.util.Map;

import com.icomp.entity.base.Vsynthesis;


public interface ICOMPV01C01S026Service {
	
	/**
	 * 取得合成刀具信息
	 * @param synthesisknife
	 * @return
	 */
	public List<Vsynthesis> getToolInfo(Vsynthesis vsynthesis);
	/**
	 * 保存对刀开始数据
	 * @param rfidString
	 * @param langCode
	 * @param langValue
	 * @param customerID
	 */
	public Map<String,Object>  saveToolInfo(String rfidString,double xpoint,double ypoint,String langCode,String langValue,String customerID,String handsetid);
}
