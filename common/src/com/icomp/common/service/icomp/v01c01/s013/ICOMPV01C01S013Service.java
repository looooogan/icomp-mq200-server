package com.icomp.common.service.icomp.v01c01.s013;

import com.icomp.entity.base.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 设备卸下-Service接口
 * @ClassName: ICOMPV01C01S013Service
 * @author Taoyy
 * @date 2014-10-11 下午02:23:46
 */
public interface ICOMPV01C01S013Service {
	/**
	 * 取得设备卸下信息
	 * @title getSynthesisToolInfo
	 * @param entity
	 * @return
	 * List<Vgetrenewalapplication>
	 */
	public List<Vgetequipmentunloadingmsg> getSynthesisToolInfo(Vgetequipmentunloadingmsg entity)throws Exception;
	/**
	 *  合成刀具卸下设备
	 * @title saveToolRecovery
	 * @param map
	 * @return
	 * @throws Exception
	 * int
	 */
	public int saveToolRecovery(Map<String, Object> map)throws Exception;



	/**
	 * 根据合成刀具编码和编号查询信息
	 * @param param
	 * @return
	 */
	Vgetdownsynthistoolsmsg getdownsynthistoolsmsg(Vgetdownsynthistoolsmsg param)throws Exception;
	/**
	 * 根据ID查询零部件列表	 
	 * @param p
	 * 	ProcessID(String)
	 *  EquipmentID(String)
	 *  AxleID(String)
	 * @return
	 */
	List<Parts> getPartsList(Parts p)throws Exception;
	/**
	 * 提交合成刀下设备信息
	 * @param stm
	 * @throws Exception
	 */
	int submitSyntheticUnloadEquipmentInfo(Synthesistoolsmachining stm) throws Exception;
	/**
	 * 取得流水线列表的信息
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Oplink getOplinkInfo(Oplink entity) throws Exception;

	/**
	 * 查询合成刀具编码和编号
	 * @param sk
	 * @return
	 * @throws SQLException
	 */
	List<Synthesisknife> getSynParameNumber(Synthesisknife sk) throws Exception;

	Oplink getoplink(Oplink o)throws Exception;

	/**
	 * 获取设备id
	 * @param equipment
	 * @return
	 * @throws SQLException
	 */
	List<Equipment> getEquipmentID(Equipment equipment) throws Exception;

	/**
	 * 获取设备id
	 * @param
	 * @return
	 * @throws SQLException
	 */
	List<Vgetwheelinfo> getWheelInfo(Vgetwheelinfo wheel) throws Exception;

	/**
	 * 获取设备id
	 * @param
	 * @return
	 * @throws SQLException
	 */
	int submitSyntheticUnloadWheelInfo(Synthesistoolsmachining sm) throws Exception;


	/**
	 * check备刀
	 * @param
	 * @return
	 * @throws SQLException
	 */
	int checkSpareKnifeSum(Synthesistoolsmachining sm) throws Exception;

	/**
	 * 根据合成刀具编码获取合成刀具id
	 * @param
	 * @return
	 * @throws SQLException
	 */
	Synthesisparameters getSynthesisId(Synthesisparameters sp)throws Exception;
	/**
	 * 根据RFID载体取得所有刀具信息
	 * @param
	 * @return
	 * @throws SQLException
	 */
	List<Tooltransfer> getAllTool(String rfidConner,String customerID) throws Exception;

	//2017/08/14 王冉 追加↓↓↓　dazhong@YMSC
	/**
	 * 根据合成刀具ID查询生产关联关系
	 * @param
	 * @return
	 * @throws SQLException
	 */
	List<Oplink> getOplinkList(Oplink oplink) throws Exception;
	//2017/08/14 王冉 追加↑↑↑　dazhong@YMSC



}
