package com.icomp.wsdl.v01c01.c01s019.business;

import com.icomp.wsdl.v01c01.c01s019.endpoint.C01S019Request;
import com.icomp.wsdl.v01c01.c01s019.endpoint.C01S019Respons;

/**
 * 对刀结束-Business接口
 * @ClassName: C01S019Business 
 * @author Taoyy
 * @date 2014-9-23 下午03:29:13
 */
public interface C01S019Business {
	/**
	 * 取得合成刀具信息
	 * @title getToolInfo 
	 * @param regSwitch
	 * @return
	 * C01S019Respons
	 */
	public C01S019Respons getToolInfo(C01S019Request regSwitch)throws Exception;
	/**
	 * 对刀结束
	 * @title saveToolInfo 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 * C01S019Respons
	 */
	public C01S019Respons saveToolInfo(C01S019Request regSwitch)throws Exception;
/***************************************************************************/
	/**
	 * 取得要绑定的刀具信息
	 * @param regSwitch
	 * @throws Exception
     */
	C01S019Respons getBindingToolInfo(C01S019Request regSwitch)throws Exception;

	/**
	 * 取得激光码
	 * @param regSwitch
	 * @return
	 * @throws Exception
     */
	C01S019Respons getLaserCode(C01S019Request regSwitch)throws Exception;

	/**
	 * 提交激光码
	 * @param regSwitch
	 * @return
	 * @throws Exception
     */
	C01S019Respons setLaserCode(C01S019Request regSwitch)throws Exception;

	/**
	 * 提交刀具绑定信息
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 */
	C01S019Respons submitToolBindingInfo(C01S019Request regSwitch)throws Exception;

	/**
	 * 取得要出厂的刀具信息
	 * @param regSwitch
	 * @return
	 * @throws Exception
     */
	C01S019Respons getOutfactTools(C01S019Request regSwitch)throws Exception;

	/**
	 * 提交出厂刀具信息
	 * @param regSwitch
	 * @return
	 * @throws Exception
     */
	C01S019Respons submitOutFackterTools(C01S019Request regSwitch)throws Exception;

}