package com.icomp.wsdl.v01c01.c01s018.business;

import com.icomp.wsdl.v01c01.c01s018.endpoint.C01S018Request;
import com.icomp.wsdl.v01c01.c01s018.endpoint.C01S018Respons;

/**
 * 刀具复磨安上-Business接口
 * 
 * @author Taoyy
 * @ClassName: C01S018Business
 * @date 2014-9-23 下午03:25:04
 */
public interface C01S018Business {
	/**
	 * 取得扫描刀具的信息
	 * 
	 * @param regSwitch
	 * @return C01S018Respons
	 * @title getToolInfo
	 */
	public C01S018Respons getToolInfo(C01S018Request regSwitch)
			throws Exception;

	/**
	 * 复磨刀具安上
	 * 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 *             C01S018Respons
	 * @title saveNoticeToolload
	 */
	public C01S018Respons saveNoticeToolload(C01S018Request regSwitch)
			throws Exception;

	/**
	 * 复磨刀具报废
	 * 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 *             C01S018Respons
	 * @title saveNoticeToolload
	 */
	public C01S018Respons savetoolDelete(C01S018Request regSwitch)
			throws Exception;

	/**
	 * 取得刀具长度和不可刃磨长度
	 */
	public C01S018Respons getToolLength(C01S018Request regSwitch)
			throws Exception;

	/**
	 * 取得报废盒子
	 * 
	 * @param request
	 */
	public C01S018Respons getDiscardBox(C01S018Request request)
			throws Exception;

	/**
	 * 取得盒子的数量
	 * 
	 * @param request
	 * @throws Exception
	 */
	C01S018Respons getToolInfoCount(C01S018Request request) throws Exception;

	/**
	 * 按刀具编码或物料号查询取得刃磨数量(非单品) throws Exception
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	C01S018Respons getToolCodeAndKivCode(C01S018Request request)
			throws Exception;

	/**
	 * 取得刃磨设备信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	C01S018Respons getEquipmentByRfid(C01S018Request request) throws Exception;

	/**
	 * 扫描待放刃磨完刀具的容器(无报废)
	 * 
	 * @param reqeest
	 * @return
	 * @throws Exception
	 */
	C01S018Respons putGrindingContainer(C01S018Request reqeest)
			throws Exception;

	/**
	 * 扫描待放刃磨完刀具的容器(报废)
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	C01S018Respons putScrapGrindingContainer(C01S018Request request)
			throws Exception;

	/**
	 * 取得所有刃磨刀具的设备列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	C01S018Respons getPanGrindingEquipment(C01S018Request request)
			throws Exception;

	// /********************************************************************/

	/**
	 * 取得修磨设备列表
	 * 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 */
	public C01S018Respons getGrindingEqulist(C01S018Request regSwitch)
			throws Exception;

	/**
	 * 取得修磨刀具的信息
	 * 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 */
	public C01S018Respons getGrindingToolsInfo(C01S018Request regSwitch)
			throws Exception;

	/**
	 * 提交刀具修磨设备信息
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 */
	public C01S018Respons submitToolsGrindingEquInfo(C01S018Request regSwitch)
			throws Exception;
}
