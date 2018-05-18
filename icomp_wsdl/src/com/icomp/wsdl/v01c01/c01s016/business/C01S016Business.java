package com.icomp.wsdl.v01c01.c01s016.business;

import java.net.ConnectException;

import com.icomp.wsdl.v01c01.c01s016.endpoint.C01S016Request;
import com.icomp.wsdl.v01c01.c01s016.endpoint.C01S016Respons;

/**
 * 刀具回库-Business接口
 * @ClassName: C01S016Business 
 * @author Taoyy
 * @date 2016-3-1 下午03:13:44
 */
public interface C01S016Business {
	/**
	 * 取得待报废刀具信息
	 * @title getToolLibraryInfo 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 * C01S016Respons
	 */
	public C01S016Respons getToolLibraryInfo(C01S016Request regSwitch)throws Exception;
	
	/**
	 * 提交回库处理刀具信息
	 * @title saveToolLibraryInfo 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 * C01S016Respons
	 */
	public C01S016Respons saveToolLibraryInfo(C01S016Request regSwitch)throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 取得扫描刀具的修复信息
	 * @title getToolInfo 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 * C01S016Respons
	 */
	public C01S016Respons getToolInfo(C01S016Request regSwitch)throws Exception;
	/**
	 * 刀具入库交接处理
	 * @title saveToolJoint 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 * C01S016Respons
	 */
	public C01S016Respons saveToolJoint(C01S016Request regSwitch)throws Exception;
	/**
	 * 非单品-回库处理-刀具回库
	 * @title saveToolJoint 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 * C01S016Respons
	 */
	public C01S016Respons saveToolInfoDetail(C01S016Request regSwitch)throws Exception;
	/**
	 * 取得刀具扫描的详细信息（非单品）
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public C01S016Respons getToolInfoDetail(C01S016Request regSwitch)throws Exception;
}
