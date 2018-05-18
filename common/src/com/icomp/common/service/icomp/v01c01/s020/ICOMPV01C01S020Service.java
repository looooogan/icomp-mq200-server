package com.icomp.common.service.icomp.v01c01.s020;

import com.icomp.entity.base.Outsidefactory;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tooltransfer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ICOMPV01C01S020Service {



	/**
	 *  提交回厂入库刀片信息
	 * @param tt
	 * @return
	 * @throws SQLException
	 */
	int submitBackFactoryToolInfo(Tooltransfer tt)throws SQLException;
	/**
	 *  提交钻头激光码
	 * @param rff
	 * @return
	 * @throws SQLException
	 */
	int submitBitLaserCode(Rfidcontainer rff)throws Exception;

	/**
	 * 查询刀具入库编码
	 * @param ttf
	 * @return
	 * @throws Exception
	 */
	Tooltransfer getToolInFactory(Tooltransfer ttf)throws Exception;

	/**
	 * 根据激光码查询RFID载体
	 * @param rf
	 * @return
	 * @throws Exception
	 */
	Rfidcontainer getRfidContainerIDByLaserCode(Rfidcontainer rf)throws Exception;

	/**
	 * 根据rfid查询rfid载体
	 * @param rfc
	 * @return
	 * @throws Exception
     */
	Rfidcontainer getRfidContainerIDByRfidCode(Rfidcontainer rfc)throws Exception;
	/**
	 * 取得通知单号列表
	 * @param out
	 * @return
	 * @throws Exception
	 */
	List<Outsidefactory> getBackFactoryToolInfolist(Outsidefactory out)throws Exception;

	/**
	 * 取得通知单号信息
	 * @param out
	 * @return
	 * @throws Exception
	 */
	Outsidefactory getBackFactoryToolInfo(Outsidefactory out)throws Exception;
	
	/**
	 * 相同材料号记录合并，数量累加
	 * @param out
	 * @return
	 * @throws Exception
	 */
	List<Outsidefactory> getBackFactoryToolSumInfo(Outsidefactory out)throws Exception;











	/*****************************************/
	/**
	 * 验证标签是否已被使用
	 * @param entity
	 * @return
	 */
	public Rfidcontainer checkRfid(Rfidcontainer entity);
	
	/**
	 * 验证标签是否已被使用
	 * @param entity
	 * @return
	 */
	public Rfidcontainer checkLaserIdentificationCode(Rfidcontainer entity);

	/**
	 * 刀具激光码保存
	 * @param entity
	 * @return
	 */
	public Rfidcontainer saveFactoryBoringCrown(Rfidcontainer entity);

	/**
	 * 查询标签是否绑定有数据
	 * @param tt
	 * @return
	 * @throws Exception
     */
	int getToolmsg(Tooltransfer tt)throws Exception;

	/**
	 * 提交扫描信息并初始化
	 * @param map
	 * @return
	 * @throws SQLException
     */
	int submitOutFactInData(Map<String, Object> map) throws SQLException;
}
