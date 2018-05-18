package com.icomp.common.service.icomp.v01c01.s027;

import com.icomp.entity.base.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 刀具交接
 */
public interface ICOMPV01C01S027Service {
	
	/**
	 * 查询刀具流转列表	 
	 * @param entity 
	 * @return
	 */
	Tooltransfer getTooltransferList(Tooltransfer entity)throws Exception;
	
	/**
	 * 取得刀具参数信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Tool getToolInfo(Tool entity)throws Exception;
	
    /**
     * 取得交接的容器
     *
     * @param map rfidString  交换容器RFID(String)
     * @return
     * @throws Exception
     */
    List<TooltranarMassage> getTransferToolsContarner(Map<String, Object> map) throws Exception;

    /**
     * 刃磨室-->对刀室 提交数据
     *
     * @param map transferToolMsg 容器中的信息(List<TooltranarMassage>)
     *            userId  用户id(String)
     *            gruantUserId 授权人id(String)
     *            rfidContarnerId 载体id
     * @return
     * @throws SQLException
     */
    int saveGrindingToKnifeData(Map<String, Object> map) throws SQLException;

    /**
     * 对刀室-->刃磨室 提交数据
     *
     * @param map transferToolMsg 容器中的信息(List<TooltranarMassage>)
     *            userId  用户id(String)
     *            gruantUserId 授权人id(String)
     *            rfidContarnerIdOut 载体Out_id(String)
     *            rfidContarnerIdIn 载体In_id(String)
     * @return
     * @throws SQLException
     */
    int saveKnifeToGrindingData(Map<String, Object> map) throws SQLException;

	/**
	 * 提交刀具送回信息
	 * @param tt
	 * @return
	 * @throws Exception
     */
	int saveToolBackInfo(Tooltransfer tt)throws Exception;

	List<Rfidcontainer> getRfidcontainerIDs(Rfidcontainer rfidcontainer) throws  SQLException;

	List<Tooltransfer> getToolState(Tooltransfer tt)throws Exception;
}
