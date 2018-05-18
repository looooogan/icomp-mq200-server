package com.icomp.common.service.icomp.v01c01.s015;

import java.sql.SQLException;

import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Vgetbacktoollibrary;

/**
 * 回库刀具处理-Service接口
 * 
 * @ClassName: ICOMPV01C01S015Service
 * @author Taoyy
 * @date 2014-10-14 上午11:30:44
 */
public interface ICOMPV01C01S015Service {
	/**
	 * 取得回库刀具处理信息
	 * 
	 * @title getToolInfo
	 * @param entity
	 * @return
	 * Vgetbacktoollibrary
	 */
	public Vgetbacktoollibrary getToolInfo(Vgetbacktoollibrary entity)throws Exception;
	/**
	 * 提交刀具报废确认（RFID载体ID，确认人）
	 * @title toolScrapConfirmation 
	 * @param rfidContainerID
	 * @param customerID
	 * @return
	 * int
	 * @throws SQLException 
	 */
	public int toolScrapConfirmation(String rfidContainerID, String customerID) throws Exception;
	/**
	 * 刀具回B库处理（最后执行业务流程）
	 * @title saveToolInfo 
	 * @param rfidContainerID
	 * @param customerID
	 * @return
	 * @throws Exception
	 * int
	 */
	public int saveToolInfo(Tooltransfer tooltransfer,String handId,String userId)throws Exception;
}
