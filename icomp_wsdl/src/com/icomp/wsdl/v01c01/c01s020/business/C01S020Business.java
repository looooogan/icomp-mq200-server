package com.icomp.wsdl.v01c01.c01s020.business;

import com.icomp.wsdl.v01c01.c01s020.endpoint.C01S020Request;
import com.icomp.wsdl.v01c01.c01s020.endpoint.C01S020Respons;

/**
 * 回厂识别-Business接口
 * @ClassName: C01S020Business 
 * @author Taoyy
 * @date 2014-9-23 下午03:32:01
 */
public interface C01S020Business {
	/**
	 * 取得出厂单号列表
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 */
	C01S020Respons getNotificationList(C01S020Request regSwitch)throws Exception;
	/**
	 * 取得通知单号信息
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 */
	C01S020Respons getNotificationListInfo(C01S020Request regSwitch)throws Exception;
	/**
	 * 取得盛放入库刀具的空盒信息
	 * @param regSwitch
	 * @return
	 * @throws Exception
     */
	C01S020Respons getEmptyBoxInfo(C01S020Request regSwitch)throws Exception;
	/**
	 * 提交回厂入库刀片信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	C01S020Respons submitBackFactoryToolInfo(C01S020Request request)throws Exception;
	/**
	 * 提交钻头激光码
	 * @param request
	 * @return
	 * @throws Exception
	 */
	C01S020Respons submitBitLaserCode(C01S020Request request)throws Exception;


	/*****************************************/





	/**
	 * 取得出厂单号列表
	 * @title getFactoryNoList 
	 * @param regSwitch
	 * @return
	 * C01S020Respons
	 */
	public C01S020Respons getFactoryNoList(C01S020Request regSwitch)throws Exception;
	/**
	 * 取得出厂刀具列表
	 * @title getFactoryToolList 
	 * @param regSwitch
	 * @return
	 * C01S020Respons
	 */
	public C01S020Respons getFactoryToolList(C01S020Request regSwitch)throws Exception;
	/**
	 * 回厂刀片绑定
	 * @title saveFactoryBlade 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 * C01S020Respons
	 */
	public C01S020Respons saveFactoryBlade(C01S020Request regSwitch)throws Exception;
	/**th
	 * 回厂钻头绑定
	 * @title saveFactoryBoringCrown 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 * C01S020Respons
	 */
	public C01S020Respons saveFactoryBoringCrown(C01S020Request regSwitch)throws Exception;
	/**
	 * 验证当前RFID 是否绑定
	 * @title checkRfid 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 * C01S020Respons
	 */
	public C01S020Respons checkRfid(C01S020Request regSwitch)throws Exception;

	/**
	 * 扫描rfid（只能是空标签
	 * @param request
	 * @return
	 * @throws Exception
     */
	C01S020Respons getRFIDnullCode(C01S020Request request) throws Exception;

	/**
	 * 提交扫描信息并初始化
	 * @param request
	 * @return
	 * @throws Exception
     */
	C01S020Respons submitOutFactInData(C01S020Request request) throws Exception;
}
