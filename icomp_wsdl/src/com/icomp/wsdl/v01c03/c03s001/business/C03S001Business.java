package com.icomp.wsdl.v01c03.c03s001.business;

import com.icomp.wsdl.v01c03.c03s001.endpoint.C03S001Request;
import com.icomp.wsdl.v01c03.c03s001.endpoint.C03S001Respons;


public interface C03S001Business {
	
	/**
	 * 验证RFID是否可用
	 * @param request
	 * @return
	 * @throws Exception
	 */
	 C03S001Respons checkRfid(C03S001Request request)throws Exception;
	
	/**
	 * 取得刀具基本信息webService
	 * @param request
	 * @return
	 * @throws Exception
	 */
	 C03S001Respons getToolInfo(C03S001Request request)throws Exception;

	/**
	 * 判断rfid状态
	 * @param request
	 * @return
	 * @throws Exception
	 */
	 C03S001Respons getRfidType(C03S001Request request)throws Exception;
	
	/**
	 * 初始化刀具信息保存webService
	 * @param request
	 * @return
	 * @throws Exception
	 */
	 C03S001Respons saveInitialization(C03S001Request request)throws Exception;
	/*********************************************************************************************/
	/**
	 * 根据材料号查询待初始化旧刀
	 * @param request
	 * @return
	 * @throws Exception
	 */
	 C03S001Respons seachOldRunToolsByToolCode(C03S001Request request)throws Exception;

	/**
	 * 查询当前标签是否已初始化
	 * @param request
     * @return
     */

	 C03S001Respons findInitializeMsg(C03S001Request request)throws Exception;
	/**
	 * 提交流转旧刀初始化数据
	 * @param request
	 * @return
	 */

	 C03S001Respons submitOldRunInItDate(C03S001Request request)throws Exception;
	/**
	 * 查询待初始化库存新刀
	 * @param request
	 * @return
	 */

	 C03S001Respons seachInitNewVentory(C03S001Request request)throws Exception;
	/**
	 * 提交库存新刀初始化数据
	 * @param request
	 * @return
	 */

	 C03S001Respons submitNewVentoryInItDate(C03S001Request request)throws Exception;
	/**
	 * 按材料号查询库存标签信息
	 * @param request
	 * @return
	 */

	 C03S001Respons findLibraryCodeMsg(C03S001Request request)throws Exception;
	/**
	 * 提交库存标签初始化数据
	 * @param request
	 * @return
	 */

	 C03S001Respons submitLibraryCodeMsg(C03S001Request request)throws Exception;
	/**
	 * 查询当前标签是否已初始化(库位标签)
	 * @param request
	 * @return
	 */

	 C03S001Respons findLibraryInitializeMsg(C03S001Request request)throws Exception;
	/**
	 * 查询合成刀具组成信息
	 * @param request
	 * @return
	 */

	 C03S001Respons getSynthesisMsg(C03S001Request request)throws Exception;
	/**
	 * 查询要初始化的合成刀具
	 * @param request
	 * @return
	 */

	 C03S001Respons seachInitSynthesisByRfid(C03S001Request request)throws Exception;
	/**
	 * 提交初始化合成刀具信息
	 * @param request
	 * @return
	 */

	 C03S001Respons submitInitSynthesis(C03S001Request request)throws Exception;


}
