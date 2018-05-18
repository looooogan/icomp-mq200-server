/*
 * 工具自动生成：设备条件实体类
 * 生成时间    : 2014/11/26 17:38:56
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;


/**
 * 设备条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/26 17:38:56
 * 创建者  ：杨作庆
 * 
 */
public class EquipmentWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 设备ID	*/ 
	private String equipmentIDWhere;

	/**
	 * 设备ID取得
	 * @return equipmentIDWhere
	 */
	public String getEquipmentIDWhere () {
		return equipmentIDWhere;
	}

	/**
	 * 设备ID设定
	 * @param equipmentIDWhere
	 */
	public void setEquipmentIDWhere (String equipmentIDWhere) {
		this.equipmentIDWhere = equipmentIDWhere;
	}

	/* RFID载体ID	*/ 
	private String rfidContainerIDWhere;

	/**
	 * RFID载体ID取得
	 * @return rfidContainerIDWhere
	 */
	public String getRfidContainerIDWhere () {
		return rfidContainerIDWhere;
	}

	/**
	 * RFID载体ID设定
	 * @param rfidContainerIDWhere
	 */
	public void setRfidContainerIDWhere (String rfidContainerIDWhere) {
		this.rfidContainerIDWhere = rfidContainerIDWhere;
	}

	/* 工序ID	*/ 
	private String processIDWhere;

	/**
	 * 工序ID取得
	 * @return processIDWhere
	 */
	public String getProcessIDWhere () {
		return processIDWhere;
	}

	/**
	 * 工序ID设定
	 * @param processIDWhere
	 */
	public void setProcessIDWhere (String processIDWhere) {
		this.processIDWhere = processIDWhere;
	}

	/* 语言编码	*/ 
	private String languageCodeWhere;
	//当前是否使用(0是,1否)
	private String statuesWhere;

	/**
	 * 语言编码取得
	 * @return languageCodeWhere
	 */
	public String getLanguageCodeWhere () {
		return languageCodeWhere;
	}

	/**
	 * 语言编码设定
	 * @param languageCodeWhere
	 */
	public void setLanguageCodeWhere (String languageCodeWhere) {
		this.languageCodeWhere = languageCodeWhere;
	}

	/* 设备编码	*/ 
	private String equipmentCodeWhere;

	/**
	 * 设备编码取得
	 * @return equipmentCodeWhere
	 */
	public String getEquipmentCodeWhere () {
		return equipmentCodeWhere;
	}

	/**
	 * 设备编码设定
	 * @param equipmentCodeWhere
	 */
	public void setEquipmentCodeWhere (String equipmentCodeWhere) {
		this.equipmentCodeWhere = equipmentCodeWhere;
	}

	/* 设备名称	*/ 
	private String equipmentNameWhere;

	/**
	 * 设备名称取得
	 * @return equipmentNameWhere
	 */
	public String getEquipmentNameWhere () {
		return equipmentNameWhere;
	}

	/**
	 * 设备名称设定
	 * @param equipmentNameWhere
	 */
	public void setEquipmentNameWhere (String equipmentNameWhere) {
		this.equipmentNameWhere = equipmentNameWhere;
	}

	/* 设备类型(0:加工设备1:对刀设备2:专机)	*/ 
	private String equipmentTypeWhere;

	/**
	 * 设备类型(0:加工设备1:对刀设备2:专机)取得
	 * @return equipmentTypeWhere
	 */
	public String getEquipmentTypeWhere () {
		return equipmentTypeWhere;
	}

	/**
	 * 设备类型(0:加工设备1:对刀设备2:专机)设定
	 * @param equipmentTypeWhere
	 */
	public void setEquipmentTypeWhere (String equipmentTypeWhere) {
		this.equipmentTypeWhere = equipmentTypeWhere;
	}

	public String getStatuesWhere() {
		return statuesWhere;
	}

	public void setStatuesWhere(String statuesWhere) {
		this.statuesWhere = statuesWhere;
	}
}

