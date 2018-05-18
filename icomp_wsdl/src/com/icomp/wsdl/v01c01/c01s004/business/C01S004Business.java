package com.icomp.wsdl.v01c01.c01s004.business;


/**
 * 刀具申领Business接口
 * @ClassName: C01S004Business 
 * @author Taoyy
 * @date 2014-9-23 下午01:35:41
 */

import com.icomp.wsdl.v01c01.c01s004.endpoint.C01S004Request;
import com.icomp.wsdl.v01c01.c01s004.endpoint.C01S004Respons;


public interface C01S004Business {
	
	/**
	 * 取得补领出库申请列表
	 * @title getReplacementList 
	 * @param regSwitch
	 * @return
	 * C01S003Respons
	 */
	public C01S004Respons getReplacementList(C01S004Request regSwitch)throws Exception;
	
	/**
	 * 取得补领出库申请单信息
	 * @title getReplacementApply 
	 * @param regSwitch
	 * @return
	 * C01S003Respons
	 */
	public C01S004Respons getReplacementApply(C01S004Request regSwitch)throws Exception;
	
	/**
	 * 取得要补领出库的刀具信息
	 * @title getReplacementApply 
	 * @param regSwitch
	 * @return
	 * C01S003Respons
	 */
	public C01S004Respons getReplacementTool(C01S004Request regSwitch)throws Exception;
	
	/**
	 * 提交补领出库的刀具信息
	 * @title saveReplacementTool 
	 * @param regSwitch
	 * @return
	 * C01S003Respons
	 */
	public C01S004Respons saveReplacementTool(C01S004Request regSwitch)throws Exception;

	/**
	 * 生成申领单号
	 * @title getApplyNumber 
	 * @param regSwitch
	 * @return
	 * C01S003Respons
	 */
	public C01S004Respons getApplyNumber(C01S004Request regSwitch)throws Exception;
	/**
	 * 取得待申领刀具信息
	 * @title getApplyToolInfo 
	 * @param regSwitch
	 * @return
	 * C01S004Respons
	 */
	public C01S004Respons getApplyToolInfo(C01S004Request regSwitch)throws Exception;
	
	/**
	 * 扫描rfid，取得当前rfid对应的信息
	 * @title getRfidToolInfo 
	 * @param regSwitch
	 * @return
	 * C01S004Respons
	 */
	public C01S004Respons getRfidToolInfo(C01S004Request regSwitch)throws Exception;
	
	/**
	 * 申领结束，记录申请单
	 * @title saveApplyInfo 
	 * @param regSwitch
	 * @return
	 * C01S004Respons
	 */
	public C01S004Respons saveApplyInfo(C01S004Request regSwitch)throws Exception;
	/**
	 * 备货刀具出库
	 * @title saveOutputStockingTool 
	 * @param regSwitch
	 * @return
	 * C01S004Respons
	 */
	public C01S004Respons saveOutputStockingTool(C01S004Request regSwitch)throws Exception;
	/**
	 * 更新备货刀具状态
	 * @title saveStockingToolStauts 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 * C01S004Respons
	 */
	public C01S004Respons saveStockingToolStauts(C01S004Request regSwitch)throws Exception;
	
}
