package com.icomp.wsdl.v01c01.c01s013.business;

import com.icomp.wsdl.v01c01.c01s013.endpoint.C01S013Request;
import com.icomp.wsdl.v01c01.c01s013.endpoint.C01S013Respons;

/**
 * 设备卸下-Business接口
 * 
 * @ClassName: C01S013Business
 * @author Taoyy
 * @date 2014-9-23 下午02:57:16
 */
public interface C01S013Business {

	/**
	 * 取得合成刀下设备信息
	 * 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 */

	public C01S013Respons getSynthesisToolInfoOutEqu(C01S013Request regSwitch)throws Exception;

	/**
	 * 提交合成刀下设备信息
	 * 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 */

	public C01S013Respons submitSyntheticUnloadEquipmentInfo(C01S013Request regSwitch)throws Exception;
	
	/**
	 * 取得设备（砂轮）卸下合成刀具信息
	 * 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 */
	
	public C01S013Respons getSynthesisToolInfoOutWheel(C01S013Request regSwitch)throws Exception;
	/**
	 * 提交设备（砂轮）卸下合成刀具信息
	 * 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 */
	
	public C01S013Respons submitSyntheticUnloadWheelInfo(C01S013Request regSwitch)throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 取得扫描合成刀具信息
	 * 
	 * @title getSynthesisToolInfo
	 * @param regSwitch
	 * @return C01S013Respons
	 */
	public C01S013Respons getSynthesisToolInfo(C01S013Request regSwitch)
			throws Exception;

	/**
	 * 合成刀具卸下设备
	 * 
	 * @title saveToolRecovery
	 * @param regSwitch
	 * @return C01S013Respons
	 */
	public C01S013Respons saveToolRecovery(C01S013Request regSwitch)
			throws Exception;

}
