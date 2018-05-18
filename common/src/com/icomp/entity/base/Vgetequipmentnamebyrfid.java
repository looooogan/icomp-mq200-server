/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/10/29 13:11:33
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/10/29 13:11:33
 * 创建者  ：杨作庆
 * 
 */
public class Vgetequipmentnamebyrfid extends VgetequipmentnamebyrfidWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 合成刀具编码(系统唯一)	*/ 
	private String synthesisParametersCode;

	/**
	 * 合成刀具编码(系统唯一)取得
	 * @return synthesisParametersCode
	 */
	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	/**
	 * 合成刀具编码(系统唯一)设定
	 * @param synthesisParametersCode
	 */
	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}
	private String synthesisParametersNumber;
	public String getSynthesisParametersNumber() {
		return synthesisParametersNumber;
	}
	public void setSynthesisParametersNumber(String synthesisParametersNumber) {
		this.synthesisParametersNumber = synthesisParametersNumber;
	}

	/* 业务-流程中间表ID	*/ 
	private String businessFlowLnkID;

	/**
	 * 业务-流程中间表ID取得
	 * @return businessFlowLnkID
	 */
	public String getBusinessFlowLnkID() {
		return businessFlowLnkID;
	}

	/**
	 * 业务-流程中间表ID设定
	 * @param businessFlowLnkID
	 */
	public void setBusinessFlowLnkID(String businessFlowLnkID) {
		this.businessFlowLnkID = businessFlowLnkID;
	}

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

	/* RFID(辅具或配套上打孔安装的RFID)	*/ 
	private String rfid;

	/**
	 * RFID(辅具或配套上打孔安装的RFID)取得
	 * @return rfid
	 */
	public String getRfid() {
		return rfid;
	}

	/**
	 * RFID(辅具或配套上打孔安装的RFID)设定
	 * @param rfid
	 */
	public void setRfid(String rfid) {
		this.rfid = rfid;
	}

	/* X坐标	*/ 
	private BigDecimal xpoint;

	/**
	 * X坐标取得
	 * @return xpoint
	 */
	public BigDecimal getXpoint() {
		return xpoint;
	}

	/**
	 * X坐标设定
	 * @param xpoint
	 */
	public void setXpoint(BigDecimal xpoint) {
		this.xpoint = xpoint;
	}

	/* Y坐标	*/ 
	private BigDecimal ypoint;

	/**
	 * Y坐标取得
	 * @return ypoint
	 */
	public BigDecimal getYpoint() {
		return ypoint;
	}

	/**
	 * Y坐标设定
	 * @param ypoint
	 */
	public void setYpoint(BigDecimal ypoint) {
		this.ypoint = ypoint;
	}

	/* 	*/ 
	private String knifeMan;

	/**
	 * 取得
	 * @return knifeMan
	 */
	public String getKnifeMan() {
		return knifeMan;
	}

	/**
	 * 设定
	 * @param knifeMan
	 */
	public void setKnifeMan(String knifeMan) {
		this.knifeMan = knifeMan;
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
}

