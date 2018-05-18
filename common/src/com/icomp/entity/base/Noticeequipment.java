/*
 * 工具自动生成：修复设备实体类
 * 生成时间    : 2015/02/15 10:33:38
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * 修复设备实体类
 * @author 工具自动生成
 * 创建时间：2015/02/15 10:33:38
 * 创建者  ：杨作庆
 * 
 */
public class Noticeequipment extends NoticeequipmentWhere implements Serializable {

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

	/* 设备类型(0钻头1刀片)	*/ 
	private String equipmentType;

	/**
	 * 设备类型(0钻头1刀片)取得
	 * @return equipmentType
	 */
	public String getEquipmentType() {
		return equipmentType;
	}

	/**
	 * 设备类型(0钻头1刀片)设定
	 * @param equipmentType
	 */
	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
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

	/* 语言编码	*/ 
	private String languageCode;

	/**
	 * 语言编码取得
	 * @return languageCode
	 */
	public String getLanguageCode() {
		return languageCode;
	}

	/**
	 * 语言编码设定
	 * @param languageCode
	 */
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
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

	/* 设备编码	*/ 
	private String equipmentCode;

	/**
	 * 设备编码取得
	 * @return equipmentCode
	 */
	public String getEquipmentCode() {
		return equipmentCode;
	}

	/**
	 * 设备编码设定
	 * @param equipmentCode
	 */
	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}

	/* 刀具入库编码	*/ 
	private String knifeInventoryCode;

	/**
	 * 刀具入库编码取得
	 * @return knifeInventoryCode
	 */
	public String getKnifeInventoryCode() {
		return knifeInventoryCode;
	}

	/**
	 * 刀具入库编码设定
	 * @param knifeInventoryCode
	 */
	public void setKnifeInventoryCode(String knifeInventoryCode) {
		this.knifeInventoryCode = knifeInventoryCode;
	}
}

