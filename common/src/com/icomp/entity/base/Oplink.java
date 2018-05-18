/*
 * 工具自动生成：实体类
 * 生成时间    : 2016/03/03 10:24:38
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 实体类
 * @author 工具自动生成
 * 创建时间：2016/03/03 10:24:38
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Oplink extends OplinkWhere implements Serializable {

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


	//2017/08/14 王冉 追加↓↓↓　dazhong@YMSC
	// 零部件名称
	private String partsName;
	// 零部件类型
	private String partsType;
	public String getPartsName() {
		return partsName;
	}
	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}
	public String getPartsType() {
		return partsType;
	}
	public void setPartsType(String partsType) {
		this.partsType = partsType;
	}
	//2017/08/14 王冉 追加↑↑↑　dazhong@YMSC

}

