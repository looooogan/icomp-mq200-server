/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:05
 * 创建者  ：杨作庆
 * 
 */
public class VputequipmentonWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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
}

