package com.icomp.wsdl.v01c04.c04s001.endpoint;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService 
public interface C04S001Wsdl {
	/**
	 * 取得当前扫描刀具数据webService
	 * @param request
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public String getToolList(@WebParam(name = "request")String  request) throws Exception ;
	/**
	 * 取得盘点数据列表webService
	 * @param request
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	 String getStockingList(@WebParam(name = "request")String  request) throws Exception ;
	/**
	 * 保存盘点数据列表webService
	 * @param request
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	 String saveStockingList(@WebParam(name = "request")String  request) throws Exception ;/**
	 * 根据材料号查询刀具在库数量webService
	 * @param request
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	 String seachInitNewVentory(@WebParam(name = "request")String  request) throws Exception ;/**
	 * 提交在库盘点刀具webService
	 * @param request
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	 String submitCheckToolDate(@WebParam(name = "request")String  request) throws Exception ;

	/**
	 * 查询当前标签是什么类型
	 * @param request
	 * @return
	 * @throws Exception
     */
	 String checkRFIDType(@WebParam(name = "request")String  request) throws Exception ;

}
