/*
 * 工具自动生成：设备实体类
 * 生成时间    : 2014/11/26 17:38:56
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * 设备实体类
 * @author 工具自动生成
 * 创建时间：2014/11/26 17:38:56
 * 创建者  ：杨作庆
 * 
 */
public class Equipment extends EquipmentWhere implements Serializable {

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

	/* 语言编码	*/ 
	private String languageCode;
	/**
	 * 当前是否使用(0是,1否)
	 */
	private String statues;

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

	/* 设备类型(0:加工设备1:对刀设备2:专机)	*/ 
	private String equipmentType;

	/**
	 * 设备类型(0:加工设备1:对刀设备2:专机)取得
	 * @return equipmentType
	 */
	public String getEquipmentType() {
		return equipmentType;
	}

	/**
	 * 设备类型(0:加工设备1:对刀设备2:专机)设定
	 * @param equipmentType
	 */
	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	/**
	 * 当前是否使用(0是,1否)
	 * @return
	 */
	public String getStatues() {
		return statues;
	}

	/**
	 * 当前是否使用(0是,1否)
	 * @param statues
	 */
	public void setStatues(String statues) {
		this.statues = statues;
	}
}

