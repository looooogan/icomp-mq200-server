/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/09/03 18:55:38
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/09/03 18:55:38
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Synthesistoolsmachininginfo extends SynthesistoolsmachininginfoWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 加工编号(年月日时分秒 14位字符串)	*/ 
	private String synthesisNumber;

	/**
	 * 加工编号(年月日时分秒 14位字符串)取得
	 * @return synthesisNumber
	 */
	public String getSynthesisNumber() {
		return synthesisNumber;
	}

	/**
	 * 加工编号(年月日时分秒 14位字符串)设定
	 * @param synthesisNumber
	 */
	public void setSynthesisNumber(String synthesisNumber) {
		this.synthesisNumber = synthesisNumber;
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

	/* 合成刀具号码	*/ 
	private String synthesisParametersNumber;

	/**
	 * 合成刀具号码取得
	 * @return synthesisParametersNumber
	 */
	public String getSynthesisParametersNumber() {
		return synthesisParametersNumber;
	}

	/**
	 * 合成刀具号码设定
	 * @param synthesisParametersNumber
	 */
	public void setSynthesisParametersNumber(String synthesisParametersNumber) {
		this.synthesisParametersNumber = synthesisParametersNumber;
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

	/* 轴ID	*/ 
	private String processID;

	/**
	 * 轴ID取得
	 * @return processID
	 */
	public String getProcessID() {
		return processID;
	}

	/**
	 * 轴ID设定
	 * @param processID
	 */
	public void setProcessID(String processID) {
		this.processID = processID;
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

	/* 轴名称	*/ 
	private String axleName;

	/**
	 * 轴名称取得
	 * @return axleName
	 */
	public String getAxleName() {
		return axleName;
	}

	/**
	 * 轴名称设定
	 * @param axleName
	 */
	public void setAxleName(String axleName) {
		this.axleName = axleName;
	}

	/* 	*/ 
	private String partsID;

	/**
	 * 取得
	 * @return partsID
	 */
	public String getPartsID() {
		return partsID;
	}

	/**
	 * 设定
	 * @param partsID
	 */
	public void setPartsID(String partsID) {
		this.partsID = partsID;
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

	/* 	*/ 
	private String outerTime;

	/**
	 * 取得
	 * @return outerTime
	 */
	public String getOuterTime() {
		return outerTime;
	}

	/**
	 * 设定
	 * @param outerTime
	 */
	public void setOuterTime(String outerTime) {
		this.outerTime = outerTime;
	}

	/* 	*/ 
	private String outerUser;

	/**
	 * 取得
	 * @return outerUser
	 */
	public String getOuterUser() {
		return outerUser;
	}

	/**
	 * 设定
	 * @param outerUser
	 */
	public void setOuterUser(String outerUser) {
		this.outerUser = outerUser;
	}

	/* 	*/ 
	private String removeReason;

	/**
	 * 取得
	 * @return removeReason
	 */
	public String getRemoveReason() {
		return removeReason;
	}

	/**
	 * 设定
	 * @param removeReason
	 */
	public void setRemoveReason(String removeReason) {
		this.removeReason = removeReason;
	}

	/* 	*/ 
	private String toolDurable;

	/**
	 * 取得
	 * @return toolDurable
	 */
	public String getToolDurable() {
		return toolDurable;
	}

	/**
	 * 设定
	 * @param toolDurable
	 */
	public void setToolDurable(String toolDurable) {
		this.toolDurable = toolDurable;
	}

	/* 加工数量	*/ 
	private BigDecimal processAmount;

	/**
	 * 加工数量取得
	 * @return processAmount
	 */
	public BigDecimal getProcessAmount() {
		return processAmount;
	}

	/**
	 * 加工数量设定
	 * @param processAmount
	 */
	public void setProcessAmount(BigDecimal processAmount) {
		this.processAmount = processAmount;
	}
}

