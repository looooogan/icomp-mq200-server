package com.icomp.common.service.icomp.v01c03.s002;

import java.util.List;
import java.util.Map;

import com.icomp.entity.base.*;

public interface ICOMPV01C03S002Service {
	/**
	 * 验证RFID是否可用
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Rfidcontainer checkRfid(Rfidcontainer entity);

	/**
	 * 取得合成刀具列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Synthesisparameters> getToolList(Synthesisparameters entity);
	
	/**
	 * 取得合成刀具配置信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public List<Vtoollist> getToolInfo(Vtoollist entity)throws Exception;
	
	/**
	 * 取得合成刀具配置信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> saveToolList( Map<String,Object> map)throws Exception;

	/**
	 * 流水线及设备列表
	 * @return
	 * @throws Exception
     */
	List<Vgetassequipmentlist> getEquipmentList()throws Exception;

	/**
	 * 提交设备初始化信息
	 * @param param
	 * @return
	 * @throws Exception
     */
	int submitEquipmentRifdCode(Map<String,Object> param)throws Exception;

	/**
	 * 提交设备初始化信息
	 * @param nq
	 * @return
	 * @throws Exception
     */
	int submitNocEquipmentRifdCode(Noticeequipment nq)throws Exception;

	/**
	 * 提交容器初始化信息
	 * @param param
	 * @return
	 * @throws Exception
     */
	int submitContainer(Map<String ,Object> param)throws Exception;

	/**
	 * 查询修魔设备列表
	 * @return
	 * @throws Exception
     */
	List<Noticeequipment> getNoticeList()throws Exception;


	List<Onoff> search(String s);

}
