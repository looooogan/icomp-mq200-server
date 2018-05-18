package com.icomp.common.service.icomp.v01c01.s018;

import com.icomp.entity.base.*;

import java.util.List;
import java.util.Map;

/**
 * 回库刀具处理-Service接口
 * 
 * @author Taoyy
 * @ClassName: ICOMPV01C01S018Service
 * @date 2014-10-15 下午02:37:57
 */
public interface ICOMPV01C01S018Service {
	/**
	 * 取得刀具复磨按上信息
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 *             List<Vgetgrindingonmsg>
	 * @title getToolInfo
	 */
	List<Vgetgrindingonmsg> getToolInfo(Vgetgrindingonmsg entity)
			throws Exception;

	/**
	 * 取得刃磨设备列表
	 * 
	 * @return
	 * @throws Exception
	 *             List<Noticeequipment>
	 * @title searchByList
	 */
	List<Noticeequipment> searchByList(Noticeequipment noticeequipment)
			throws Exception;

	/**
	 * 复磨刀具安上
	 * 
	 * @param map
	 * @return int
	 * @title toolScrapConfirmation
	 */
	int toolScrapConfirmation(Map<String, Object> map) throws Exception;

	/**
	 * 取得刀具长度和不可刃磨长度
	 */
	List<Tool> getToolLength(Tooltransfer entity) throws Exception;

	/**
	 * 报废更新设备上的刀具为空
	 * 
	 * @param map
	 * @return
	 */
	int updateNoticeequipment(Map<String, Object> map) throws Exception;

	/**
	 * 取得盒子的数量
	 * 
	 * @param rfidString
	 * @return
	 * @throws Exception
	 */
	int getToolInfoCount(String rfidString) throws Exception;

	/**
	 * 按刀具编码或物料号查询取得刃磨数量
	 * 
	 * @param map
	 *            toolCode 刀具编码(String) kiCode 物料号(String)
	 * @return
	 * @throws Exception
	 */
	List<TooltranarMassage> getToolCodeAndKivCode(Map<String, Object> map)
			throws Exception;

	/**
	 * 扫描待放刃磨完刀具的容器(报废)
	 * 
	 * @param map
	 *            scrapCount 报废数量(int) userId 当前用户ID(String) rfidContarnerId
	 *            容器rifd载体(String) gruantUserId 授权人id(String)
	 * @return
	 * @throws Exception
	 */
	int putScrapGrindingContainer(Map<String, Object> map) throws Exception;

	/**
	 * 扫描待放刃磨完刀具的容器(无报废)
	 * 
	 * @param map
	 *            scrapCount 报废数量(int) grindingCount 刃磨数量(int) userId
	 *            当前用户ID(String) rfidContarnerId 容器rifd载体(String) gruantUserId
	 *            授权人id(String)
	 * @return
	 * @throws Exception
	 */
	int putGrindingContainer(Map<String, Object> map) throws Exception;

	/*************************************************************************************/

	/**
	 * 取得修磨设备列表
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Vgetnoticeequipmentlist> getNoticeEquipmentList() throws Exception;



	/**
	 * 取得修磨刀具列表
	 * 
	 * @return
	 * @throws Exception
	 */
	Vgettoolinfolist getToolInfoList(Vgettoolinfolist vv) throws Exception;



	/**
	 * 提交刀具修磨信息
	 * @param entity
	 * @return
	 * @throws Exception
     */
	Map<String, Object> submitToolsGrindingEquInfo(List<Map<String, Object>> toolList,Toolnoticehistory entity);



}
