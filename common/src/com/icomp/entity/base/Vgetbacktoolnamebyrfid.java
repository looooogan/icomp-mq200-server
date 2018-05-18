/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class Vgetbacktoolnamebyrfid extends VgetbacktoolnamebyrfidWhere implements Serializable {

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

	/* 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上)(该状态绑定到带标签的数据上)	*/ 
	private String loadState;

	/**
	 * 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上)(该状态绑定到带标签的数据上)取得
	 * @return loadState
	 */
	public String getLoadState() {
		return loadState;
	}

	/**
	 * 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上)(该状态绑定到带标签的数据上)设定
	 * @param loadState
	 */
	public void setLoadState(String loadState) {
		this.loadState = loadState;
	}

	/* 	*/ 
	private String operationMan;

	/**
	 * 取得
	 * @return operationMan
	 */
	public String getOperationMan() {
		return operationMan;
	}

	/**
	 * 设定
	 * @param operationMan
	 */
	public void setOperationMan(String operationMan) {
		this.operationMan = operationMan;
	}

	/* 语言编码	*/ 
	private String equipment_LanguageCode;

	/**
	 * 语言编码取得
	 * @return equipment_LanguageCode
	 */
	public String getEquipment_LanguageCode() {
		return equipment_LanguageCode;
	}

	/**
	 * 语言编码设定
	 * @param equipment_LanguageCode
	 */
	public void setEquipment_LanguageCode(String equipment_LanguageCode) {
		this.equipment_LanguageCode = equipment_LanguageCode;
	}

	/* 语言编码	*/ 
	private String process_LanguageCode;

	/**
	 * 语言编码取得
	 * @return process_LanguageCode
	 */
	public String getProcess_LanguageCode() {
		return process_LanguageCode;
	}

	/**
	 * 语言编码设定
	 * @param process_LanguageCode
	 */
	public void setProcess_LanguageCode(String process_LanguageCode) {
		this.process_LanguageCode = process_LanguageCode;
	}
}

