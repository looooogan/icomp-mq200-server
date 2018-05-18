package com.icomp.common.service.icomp.v01c01.s016;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Vgetequipmentnamebyrfid;


public interface ICOMPV01C01S016Service {
	
	/**
	 * 提交回库处理刀具信息
	 * @param list
	 * @return
	 */
	public Map<String,Object> saveToolLibraryInfo(String customerID,List<Map<String,Object>> list) throws Exception;
	
	
	/**
	 * 待报废刀具流转表信息
	 * 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 */
	List<Tooltransfer> getToolTransferList(
			Tooltransfer entity) throws Exception;
	
    /**
	  * 取得丢刀信息
	  * @param entity
	  * @return
	  * @throws SQLException
	  */
	Tooltransfer getToolTransfer(Tooltransfer entity)throws SQLException;
	
	
	
	/**
	 * 取得扫描RFID的刀具信息
	 * @param rfidString
	 * @return
	 */
	public Map<String,Object> getToolInfo(String rfidString,String langCode);
	

	/**
	 * 保存旧刀交接信息
	 * @param list
	 * @return
	 */
	public Map<String,Object> saveToolJoint(List<Map<String,Object>> list);

	/**
	 * 取得扫描RFID的刀具信息(非单品）
	 * @param rtn
	 * @return
	 */
	public Map<String, Object> getToolInfoDetail(Map<String, Object> rtn);
	/**
	 * 非单品-回库处理-刀具回库
	 * @param rtn
	 * @return
	 */
	public Map<String, Object> saveToolInfoDetail(Map<String, Object> rtn);
	/**
	 * 非单品-回库处理-刀具回库
	 * @param rtn
	 * @return
	 */
	public Map<String, Object> updateTooltransfer(Map<String, Object> rtn);

	Rfidcontainer getRfidContainerIDByRfidCode(Rfidcontainer entity)throws Exception;
}
