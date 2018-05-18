package com.icomp.wsdl.v01c01.c01s024.business;

import com.icomp.wsdl.v01c01.c01s024.endpoint.C01S024Request;
import com.icomp.wsdl.v01c01.c01s024.endpoint.C01S024Respons;

/**
 * 刀具管理-刀具状态查询-Business接口
 * @ClassName: C01S024Business 
 * @author Taoyy
 * @date 2014-9-23 下午04:27:06
 */
public interface C01S024Business {
	/**
	 * 取得单品刀具信息
	 * @title getToolInfo 
	 * @param regSwitch
	 * @return
	 * C01S024Respons
	 */
	public C01S024Respons getToolInfo(C01S024Request regSwitch)throws Exception;

	/**
	 * 取得要查询的信息
	 * @title getToolInfo
	 * @param regSwitch
	 * @return
	 * C01S024Respons
	 */
	public C01S024Respons getInformation(C01S024Request regSwitch)throws Exception;

}
