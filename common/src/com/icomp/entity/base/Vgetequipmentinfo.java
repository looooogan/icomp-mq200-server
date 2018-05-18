/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/03/08 10:15:56
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/03/08 10:15:56
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vgetequipmentinfo extends VgetequipmentinfoWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 设备ID	*/ 
	private String equipmentID;

	/**
	 * 设备ID取得
	 * @return equipmentID
	 */
	public String getEquipmentID() {
		return equipmentID;
	}

	/**
	 * 设备ID设定
	 * @param equipmentID
	 */
	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
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

	/* 工序ID	*/ 
	private String processID;

	/**
	 * 工序ID取得
	 * @return processID
	 */
	public String getProcessID() {
		return processID;
	}

	/**
	 * 工序ID设定
	 * @param processID
	 */
	public void setProcessID(String processID) {
		this.processID = processID;
	}

	/* 轴ID	*/ 
	private String axleID;

	/**
	 * 轴ID取得
	 * @return axleID
	 */
	public String getAxleID() {
		return axleID;
	}

	/**
	 * 轴ID设定
	 * @param axleID
	 */
	public void setAxleID(String axleID) {
		this.axleID = axleID;
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
}

