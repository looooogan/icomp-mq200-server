package com.icomp.wsdl.v01c00.c00s000.endpoint;


import javax.jws.WebService;
import javax.jws.WebParam;
@WebService 
//@SOAPBinding(style = Style.RPC)
public interface  C00S000Wsdl {
	/**
	 * 用户登录
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String userLogin(@WebParam(name = "request")String request)throws Exception; 
	
	/**
	 * 用户授权
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String userGruant(@WebParam(name = "request")String request)throws Exception; 
	
	/**
	 * 用户信息取得
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String userInfo(@WebParam(name = "request")String request)throws Exception; 
	
	/**
	 * 用户权限取得
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String getMenu(@WebParam(name = "request")String request)throws Exception; 
	
	/**
	 * 取得系统默认语言
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String getSysLocal(@WebParam(name = "request")String request)throws Exception; 
	
	/**
	 * 判断当前手持机是否注册
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String getHandParam(@WebParam(name = "request")String request)throws Exception;
}
