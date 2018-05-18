package com.icomp.wsdl.v01c01.c01s004.endpoint;


import java.net.ConnectException;
import javax.jws.WebParam;
import javax.jws.WebService;
/**
 * 补领出库Webservce接口
 * @ClassName: C01S004Wsdl 
 * @author Taoyy
 * @date 2016-3-8 上午11:38:23
 */

@WebService
public interface C01S004Wsdl {
	
	/**
	 * 取得补领出库申请列表
	 * @title getReplacementList 
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 * String
	 */
	public String getReplacementList(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 取得补领出库申请单信息
	 * @title getReplacementApply 
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 * String
	 */
	public String getReplacementApply(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 取得要补领出库的刀具信息
	 * @title getReplacementTool 
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 * String
	 */
	public String getReplacementTool(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 提交补领出库的刀具信息
	 * @title saveReplacementTool 
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 * String
	 */
	public String saveReplacementTool(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 生成申领单号
	 * @title getApplyNumber 
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 * String
	 */
	public String getApplyNumber(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 取得待申领刀具信息
	 * @title getApplyToolInfo 
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 * String
	 */
	public String getApplyToolInfo(@WebParam(name = "request")String request) throws Exception;
	/**
	 * 扫描rfid，取得当前rfid对应的信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String getRfidToolInfo(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 更新备货刀具状态
	 * @title saveStockingToolStauts 
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 * String
	 */
	public String saveStockingToolStauts(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 备货刀具出库
	 * @title saveOutputStockingTool 
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 * String
	 */
	public String saveOutputStockingTool(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 申领结束，记录申请单
	 * @title saveApplyInfo 
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 * String
	 */
	public String saveApplyInfo(@WebParam(name = "request")String request) throws Exception;
	

}
