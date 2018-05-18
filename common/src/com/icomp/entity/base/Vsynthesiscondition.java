/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/03/10 15:23:42
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/03/10 15:23:42
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vsynthesiscondition extends VsynthesisconditionWhere implements Serializable {

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
	private String numberDevices;

	/**
	 * 取得
	 * @return numberDevices
	 */
	public String getNumberDevices() {
		return numberDevices;
	}

	/**
	 * 设定
	 * @param numberDevices
	 */
	public void setNumberDevices(String numberDevices) {
		this.numberDevices = numberDevices;
	}

	/* 	*/ 
	private String numberToolStorage;

	/**
	 * 取得
	 * @return numberToolStorage
	 */
	public String getNumberToolStorage() {
		return numberToolStorage;
	}

	/**
	 * 设定
	 * @param numberToolStorage
	 */
	public void setNumberToolStorage(String numberToolStorage) {
		this.numberToolStorage = numberToolStorage;
	}

	/* 	*/ 
	private String regulatinRoom;

	/**
	 * 取得
	 * @return regulatinRoom
	 */
	public String getRegulatinRoom() {
		return regulatinRoom;
	}

	/**
	 * 设定
	 * @param regulatinRoom
	 */
	public void setRegulatinRoom(String regulatinRoom) {
		this.regulatinRoom = regulatinRoom;
	}
}

