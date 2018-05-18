/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/03/10 14:58:49
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/03/10 14:58:49
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vworkshopsummary extends VworkshopsummaryWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 流水线名称	*/ 
	private String assemblyLineName;

	/**
	 * 流水线名称取得
	 * @return assemblyLineName
	 */
	public String getAssemblyLineName() {
		return assemblyLineName;
	}

	/**
	 * 流水线名称设定
	 * @param assemblyLineName
	 */
	public void setAssemblyLineName(String assemblyLineName) {
		this.assemblyLineName = assemblyLineName;
	}

	/* 流水线ID	*/ 
	private String assemblyLineID;

	/**
	 * 流水线ID取得
	 * @return assemblyLineID
	 */
	public String getAssemblyLineID() {
		return assemblyLineID;
	}

	/**
	 * 流水线ID设定
	 * @param assemblyLineID
	 */
	public void setAssemblyLineID(String assemblyLineID) {
		this.assemblyLineID = assemblyLineID;
	}

	/* 零部件名称	*/ 
	private String partsName;

	/**
	 * 零部件名称取得
	 * @return partsName
	 */
	public String getPartsName() {
		return partsName;
	}

	/**
	 * 零部件名称设定
	 * @param partsName
	 */
	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}

	/* 零部件ID	*/ 
	private String partsID;

	/**
	 * 零部件ID取得
	 * @return partsID
	 */
	public String getPartsID() {
		return partsID;
	}

	/**
	 * 零部件ID设定
	 * @param partsID
	 */
	public void setPartsID(String partsID) {
		this.partsID = partsID;
	}

	/* 工序名称	*/ 
	private String processName;

	/**
	 * 工序名称取得
	 * @return processName
	 */
	public String getProcessName() {
		return processName;
	}

	/**
	 * 工序名称设定
	 * @param processName
	 */
	public void setProcessName(String processName) {
		this.processName = processName;
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

	/* 零部件型号（0:1.6L,1:1.4T）	*/ 
	private String partsType;

	/**
	 * 零部件型号（0:1.6L,1:1.4T）取得
	 * @return partsType
	 */
	public String getPartsType() {
		return partsType;
	}

	/**
	 * 零部件型号（0:1.6L,1:1.4T）设定
	 * @param partsType
	 */
	public void setPartsType(String partsType) {
		this.partsType = partsType;
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

	/* 卸下时间	*/ 
	private Date outerTime;

	/**
	 * 卸下时间取得
	 * @return outerTime
	 */
	public Date getOuterTime() {
		return outerTime;
	}

	/**
	 * 卸下时间设定
	 * @param outerTime
	 */
	public void setOuterTime(Date outerTime) {
		this.outerTime = outerTime;
	}

	/* 合成刀具编号	*/ 
	private String synthesisParametersCode;

	/**
	 * 合成刀具编号取得
	 * @return synthesisParametersCode
	 */
	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	/**
	 * 合成刀具编号设定
	 * @param synthesisParametersCode
	 */
	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}

	/* 轴编码	*/ 
	private String axleCode;

	/**
	 * 轴编码取得
	 * @return axleCode
	 */
	public String getAxleCode() {
		return axleCode;
	}

	/**
	 * 轴编码设定
	 * @param axleCode
	 */
	public void setAxleCode(String axleCode) {
		this.axleCode = axleCode;
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

	/* 	*/ 
	private BigDecimal processAmount;

	/**
	 * 取得加工数量
	 * @return processAmount
	 */
	public BigDecimal getProcessAmount() {
		return processAmount;
	}

	/**
	 * 设定
	 * @param processAmount
	 */
	public void setProcessAmount(BigDecimal processAmount) {
		this.processAmount = processAmount;
	}

	/* 	*/ 
	private BigDecimal synconsume;

	/**
	 * 取得
	 * @return synconsume
	 */
	public BigDecimal getSynconsume() {
		return synconsume;
	}

	/**
	 * 设定
	 * @param synconsume
	 */
	public void setSynconsume(BigDecimal synconsume) {
		this.synconsume = synconsume;
	}
}

