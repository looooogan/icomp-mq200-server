package com.icomp.wsdl.v01c01.c01s018.endpoint;

import java.io.Serializable;

public class NoticeequipmentSelect implements Serializable {

	private static final long serialVersionUID = 8180546821886727882L;
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

	@Override
	public String toString() {
		return equipmentName;
	}
	/**
	 * 设备类型(3钻头4刀片)
	 */
	private String equipmentType;

	/**
	 * 设备类型(3钻头4刀片)
	 * @return
	 */
	public String getEquipmentType() {
		return equipmentType;
	}

	/**
	 * 设备类型(3钻头4刀片)
	 * @param equipmentType
	 */
	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

}
