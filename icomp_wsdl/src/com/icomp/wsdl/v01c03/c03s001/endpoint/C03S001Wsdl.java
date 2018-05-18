package com.icomp.wsdl.v01c03.c03s001.endpoint;

import javax.jws.WebParam;
import javax.jws.WebService;


@WebService 
public interface C03S001Wsdl {

	/**
	 * 验证RFID是否可用
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String checkRfid(@WebParam(name = "request")String request)throws Exception; 
	
	/**
	 * 取得刀具基本信息webService
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String getToolInfo(@WebParam(name = "request")String request)throws Exception;
	
	/**
	 * 判断rfid状态
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String getRfidType(@WebParam(name = "request")String request)throws Exception;
	
	/**
	 * 初始化刀具信息保存webService
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String saveInitialization(@WebParam(name = "request")String request)throws Exception;
	/********************************************************************************************************/
	/**
	 * 根据材料号查询待初始化旧刀webService
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String seachOldRunToolsByToolCode(@WebParam(name = "request")String request)throws Exception;
	/**
	 * 查询当前标签是否已初始化webService
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String findInitializeMsg(@WebParam(name = "request")String request)throws Exception;
	/**
	 * 提交流转旧刀初始化数据webService
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String submitOldRunInItDate(@WebParam(name = "request")String request)throws Exception;
	/**
	 * 查询待初始化库存新刀webService
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String seachInitNewVentory(@WebParam(name = "request")String request)throws Exception;
	/**
	 * 提交库存新刀初始化数据webService
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String submitNewVentoryInItDate(@WebParam(name = "request")String request)throws Exception;
	/**
	 * 按材料号查询库存标签信息webService
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String findLibraryCodeMsg(@WebParam(name = "request")String request)throws Exception;
	/**
	 * 提交库存标签初始化数据webService
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String submitLibraryCodeMsg(@WebParam(name = "request")String request)throws Exception;
	/**
	 * 查询当前标签是否已初始化(库位标签)webService
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String findLibraryInitializeMsg(@WebParam(name = "request")String request)throws Exception;
	/**
	 * 查询合成刀具组成信息webService
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String getSynthesisMsg(@WebParam(name = "request")String request)throws Exception;
	/**
	 * 查询要初始化的合成刀具webService
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String seachInitSynthesisByRfid(@WebParam(name = "request")String request)throws Exception;
	/**
	 * 提交初始化合成刀具信息webService
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String submitInitSynthesis(@WebParam(name = "request")String request)throws Exception;
}
