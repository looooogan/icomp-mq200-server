/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/03/03 10:24:39
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/03/03 10:24:39
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Voplink extends VoplinkWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* OplinkID	*/ 
	private String oplinkID;

	/**
	 * OplinkID取得
	 * @return oplinkID
	 */
	public String getOplinkID() {
		return oplinkID;
	}

	/**
	 * OplinkID设定
	 * @param oplinkID
	 */
	public void setOplinkID(String oplinkID) {
		this.oplinkID = oplinkID;
	}

	/* 	*/ 
	private String lastProcess;

	/**
	 * 取得
	 * @return lastProcess
	 */
	public String getLastProcess() {
		return lastProcess;
	}

	/**
	 * 设定
	 * @param lastProcess
	 */
	public void setLastProcess(String lastProcess) {
		this.lastProcess = lastProcess;
	}

	/* 耐用度	*/ 
	private BigDecimal toolDurable;

	/**
	 * 耐用度取得
	 * @return toolDurable
	 */
	public BigDecimal getToolDurable() {
		return toolDurable;
	}

	/**
	 * 耐用度设定
	 * @param toolDurable
	 */
	public void setToolDurable(BigDecimal toolDurable) {
		this.toolDurable = toolDurable;
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

	/* 流水线编码	*/ 
	private String assemblyLineCode;

	/**
	 * 流水线编码取得
	 * @return assemblyLineCode
	 */
	public String getAssemblyLineCode() {
		return assemblyLineCode;
	}

	/**
	 * 流水线编码设定
	 * @param assemblyLineCode
	 */
	public void setAssemblyLineCode(String assemblyLineCode) {
		this.assemblyLineCode = assemblyLineCode;
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

	/* 工序编码	*/ 
	private String processCode;

	/**
	 * 工序编码取得
	 * @return processCode
	 */
	public String getProcessCode() {
		return processCode;
	}

	/**
	 * 工序编码设定
	 * @param processCode
	 */
	public void setProcessCode(String processCode) {
		this.processCode = processCode;
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

	/* 零部件编码	*/ 
	private String partsCode;

	/**
	 * 零部件编码取得
	 * @return partsCode
	 */
	public String getPartsCode() {
		return partsCode;
	}

	/**
	 * 零部件编码设定
	 * @param partsCode
	 */
	public void setPartsCode(String partsCode) {
		this.partsCode = partsCode;
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

	/* 合成刀具参数ID	*/ 
	private String synthesisParametersID;

	/**
	 * 合成刀具参数ID取得
	 * @return synthesisParametersID
	 */
	public String getSynthesisParametersID() {
		return synthesisParametersID;
	}

	/**
	 * 合成刀具参数ID设定
	 * @param synthesisParametersID
	 */
	public void setSynthesisParametersID(String synthesisParametersID) {
		this.synthesisParametersID = synthesisParametersID;
	}

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
}

