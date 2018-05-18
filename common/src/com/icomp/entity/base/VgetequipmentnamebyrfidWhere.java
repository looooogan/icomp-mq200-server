/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/10/29 13:11:33
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;

import com.icomp.common.entity.BaseEntity;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/10/29 13:11:33
 * 创建者  ：杨作庆
 * 
 */
public class VgetequipmentnamebyrfidWhere extends BaseEntity implements Serializable {

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

	/* 业务-流程中间表ID	*/ 
	private String businessFlowLnkIDWhere;

	/**
	 * 业务-流程中间表ID取得
	 * @return businessFlowLnkIDWhere
	 */
	public String getBusinessFlowLnkIDWhere () {
		return businessFlowLnkIDWhere;
	}

	/**
	 * 业务-流程中间表ID设定
	 * @param businessFlowLnkIDWhere
	 */
	public void setBusinessFlowLnkIDWhere (String businessFlowLnkIDWhere) {
		this.businessFlowLnkIDWhere = businessFlowLnkIDWhere;
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

	/* RFID(辅具或配套上打孔安装的RFID)	*/ 
	private String rfidWhere;

	/**
	 * RFID(辅具或配套上打孔安装的RFID)取得
	 * @return rfidWhere
	 */
	public String getRfidWhere () {
		return rfidWhere;
	}

	/**
	 * RFID(辅具或配套上打孔安装的RFID)设定
	 * @param rfidWhere
	 */
	public void setRfidWhere (String rfidWhere) {
		this.rfidWhere = rfidWhere;
	}

	/* X坐标	*/ 
	private BigDecimal xpointWhere;

	/**
	 * X坐标取得
	 * @return xpointWhere
	 */
	public BigDecimal getXpointWhere () {
		return xpointWhere;
	}

	/**
	 * X坐标设定
	 * @param xpointWhere
	 */
	public void setXpointWhere (BigDecimal xpointWhere) {
		this.xpointWhere = xpointWhere;
	}

	/* Y坐标	*/ 
	private BigDecimal ypointWhere;

	/**
	 * Y坐标取得
	 * @return ypointWhere
	 */
	public BigDecimal getYpointWhere () {
		return ypointWhere;
	}

	/**
	 * Y坐标设定
	 * @param ypointWhere
	 */
	public void setYpointWhere (BigDecimal ypointWhere) {
		this.ypointWhere = ypointWhere;
	}

	/* 	*/ 
	private String knifeManWhere;

	/**
	 * 取得
	 * @return knifeManWhere
	 */
	public String getKnifeManWhere () {
		return knifeManWhere;
	}

	/**
	 * 设定
	 * @param knifeManWhere
	 */
	public void setKnifeManWhere (String knifeManWhere) {
		this.knifeManWhere = knifeManWhere;
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
	
	private String synthesisParametersNumberWhere;
	public String getSynthesisParametersNumberWhere() {
		return synthesisParametersNumberWhere;
	}
	public void setSynthesisParametersNumberWhere(String synthesisParametersNumberWhere) {
		this.synthesisParametersNumberWhere = synthesisParametersNumberWhere;
	}
}

