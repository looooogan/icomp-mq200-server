/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/03/16 13:33:01
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/03/16 13:33:01
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vgetdownsynthistoolsmsg extends VgetdownsynthistoolsmsgWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 工序ID	*/ 
	private String processID;

	private String partsID;

	public String getPartsID() {
		return partsID;
	}

	public void setPartsID(String partsID) {
		this.partsID = partsID;
	}

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

	private List<Oplink> oplinks = new ArrayList<> ();

	public List<Oplink> getOplinks() {

		return oplinks;
	}

	public void setOplinks(List<Oplink> oplinks) {
		this.oplinks = oplinks;
	}
}

