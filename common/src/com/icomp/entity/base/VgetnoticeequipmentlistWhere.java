/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/03/04 17:41:30
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;



/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/03/04 17:41:30
 * 创建者  ：工具自动生成
 * 
 */
public class VgetnoticeequipmentlistWhere extends BaseEntity implements Serializable {

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

	/* RFID标签ID	*/ 
	private String rfidCodeWhere;

	/**
	 * RFID标签ID取得
	 * @return rfidCodeWhere
	 */
	public String getRfidCodeWhere () {
		return rfidCodeWhere;
	}

	/**
	 * RFID标签ID设定
	 * @param rfidCodeWhere
	 */
	public void setRfidCodeWhere (String rfidCodeWhere) {
		this.rfidCodeWhere = rfidCodeWhere;
	}

	/* 设备类型(3钻头4刀片)	*/ 
	private String equipmentTypeWhere;

	/**
	 * 设备类型(3钻头4刀片)取得
	 * @return equipmentTypeWhere
	 */
	public String getEquipmentTypeWhere () {
		return equipmentTypeWhere;
	}

	/**
	 * 设备类型(3钻头4刀片)设定
	 * @param equipmentTypeWhere
	 */
	public void setEquipmentTypeWhere (String equipmentTypeWhere) {
		this.equipmentTypeWhere = equipmentTypeWhere;
	}
}

