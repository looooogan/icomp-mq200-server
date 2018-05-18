/*
 * 工具自动生成：修复设备条件实体类
 * 生成时间    : 2015/02/15 10:33:38
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;


/**
 * 修复设备条件实体类
 * @author 工具自动生成
 * 创建时间：2015/02/15 10:33:38
 * 创建者  ：杨作庆
 * 
 */
public class NoticeequipmentWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 设备ID	*/ 
	private String noticeEquipmentIDWhere;

	/**
	 * 设备ID取得
	 * @return noticeEquipmentIDWhere
	 */
	public String getNoticeEquipmentIDWhere () {
		return noticeEquipmentIDWhere;
	}

	/**
	 * 设备ID设定
	 * @param noticeEquipmentIDWhere
	 */
	public void setNoticeEquipmentIDWhere (String noticeEquipmentIDWhere) {
		this.noticeEquipmentIDWhere = noticeEquipmentIDWhere;
	}

	/* 设备类型(0钻头1刀片)	*/ 
	private String equipmentTypeWhere;

	/**
	 * 设备类型(0钻头1刀片)取得
	 * @return equipmentTypeWhere
	 */
	public String getEquipmentTypeWhere () {
		return equipmentTypeWhere;
	}

	/**
	 * 设备类型(0钻头1刀片)设定
	 * @param equipmentTypeWhere
	 */
	public void setEquipmentTypeWhere (String equipmentTypeWhere) {
		this.equipmentTypeWhere = equipmentTypeWhere;
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

	/* 语言编码	*/ 
	private String languageCodeWhere;

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

	/* 刀具入库编码	*/ 
	private String knifeInventoryCodeWhere;

	/**
	 * 刀具入库编码取得
	 * @return knifeInventoryCodeWhere
	 */
	public String getKnifeInventoryCodeWhere () {
		return knifeInventoryCodeWhere;
	}

	/**
	 * 刀具入库编码设定
	 * @param knifeInventoryCodeWhere
	 */
	public void setKnifeInventoryCodeWhere (String knifeInventoryCodeWhere) {
		this.knifeInventoryCodeWhere = knifeInventoryCodeWhere;
	}
}

