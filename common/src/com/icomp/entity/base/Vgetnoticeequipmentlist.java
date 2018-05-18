/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/03/04 17:41:30
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/03/04 17:41:30
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vgetnoticeequipmentlist extends VgetnoticeequipmentlistWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 设备ID	*/ 
	private String noticeEquipmentID;

	/**
	 * 设备ID取得
	 * @return noticeEquipmentID
	 */
	public String getNoticeEquipmentID() {
		return noticeEquipmentID;
	}

	/**
	 * 设备ID设定
	 * @param noticeEquipmentID
	 */
	public void setNoticeEquipmentID(String noticeEquipmentID) {
		this.noticeEquipmentID = noticeEquipmentID;
	}

	/* RFID载体ID	*/ 
	private String rfidContainerID;

	/**
	 * RFID载体ID取得
	 * @return rfidContainerID
	 */
	public String getRfidContainerID() {
		return rfidContainerID;
	}

	/**
	 * RFID载体ID设定
	 * @param rfidContainerID
	 */
	public void setRfidContainerID(String rfidContainerID) {
		this.rfidContainerID = rfidContainerID;
	}

	/* 设备名称	*/ 
	private String equipmentName;

	/**
	 * 设备名称取得
	 * @return equipmentName
	 */
	public String getEquipmentName() {
		return equipmentName;
	}

	/**
	 * 设备名称设定
	 * @param equipmentName
	 */
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	/* RFID标签ID	*/ 
	private String rfidCode;

	/**
	 * RFID标签ID取得
	 * @return rfidCode
	 */
	public String getRfidCode() {
		return rfidCode;
	}

	/**
	 * RFID标签ID设定
	 * @param rfidCode
	 */
	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}

	/* 设备类型(3钻头4刀片)	*/ 
	private String equipmentType;

	/**
	 * 设备类型(3钻头4刀片)取得
	 * @return equipmentType
	 */
	public String getEquipmentType() {
		return equipmentType;
	}

	/**
	 * 设备类型(3钻头4刀片)设定
	 * @param equipmentType
	 */
	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}
}

