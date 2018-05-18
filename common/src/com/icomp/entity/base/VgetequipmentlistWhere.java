/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/03/18 16:15:15
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;



/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/03/18 16:15:15
 * 创建者  ：工具自动生成
 * 
 */
public class VgetequipmentlistWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 轴ID	*/ 
	private String axleIDWhere;

	/**
	 * 轴ID取得
	 * @return axleIDWhere
	 */
	public String getAxleIDWhere () {
		return axleIDWhere;
	}

	/**
	 * 轴ID设定
	 * @param axleIDWhere
	 */
	public void setAxleIDWhere (String axleIDWhere) {
		this.axleIDWhere = axleIDWhere;
	}

	/* 轴编码	*/ 
	private String axleCodeWhere;

	/**
	 * 轴编码取得
	 * @return axleCodeWhere
	 */
	public String getAxleCodeWhere () {
		return axleCodeWhere;
	}

	/**
	 * 轴编码设定
	 * @param axleCodeWhere
	 */
	public void setAxleCodeWhere (String axleCodeWhere) {
		this.axleCodeWhere = axleCodeWhere;
	}
	
	/* 合成刀具编码(系统唯一)	*/ 
	private String synthesisParametersCodeWhere;

	/**
	 * 合成刀具编码(系统唯一)取得
	 * @return synthesisParametersCodeWhere
	 */
	public String getSynthesisParametersCodeWhere () {
		return synthesisParametersCodeWhere;
	}

	/**
	 * 合成刀具编码(系统唯一)设定
	 * @param synthesisParametersCodeWhere
	 */
	public void setSynthesisParametersCodeWhere (String synthesisParametersCodeWhere) {
		this.synthesisParametersCodeWhere = synthesisParametersCodeWhere;
	}
}

