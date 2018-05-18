package com.icomp.common.service.icomp.v01c01.s017;

import java.util.List;
import java.util.Map;

import com.icomp.entity.base.Noticeequipment;
import com.icomp.entity.base.Vgrindingtoolmsg;

/**
 * 刀具复磨卸下-Service接口
 * @ClassName: ICOMPV01C01S017Service 
 * @author Taoyy
 * @date 2014-10-16 下午02:48:49
 */
public interface ICOMPV01C01S017Service {
	/**
	 * 取得刃磨中设备列表
	 * @title getNoticeEquipmentList 
	 * @param entity
	 * @return
	 * @throws Exception
	 * List<Noticeequipment>
	 */
   public List<Noticeequipment> getNoticeEquipmentList(Noticeequipment entity)throws Exception;
   	/**
   	 * 取得刃磨设备中刀具信息
   	 * @title getNoticeToolInfo 
   	 * @param entity
   	 * @return
   	 * Vgrindingtoolmsg
   	 */
	public Vgrindingtoolmsg getNoticeToolInfo(Vgrindingtoolmsg entity)throws Exception;
	/**
	 * 卸下刃磨中刀具
	 * @title saveNoticeTool 
	 * @param map
	 * @return
	 * @throws Exception
	 * int
	 */
	public int saveNoticeTool(Map<String, Object> map)throws Exception;
}
