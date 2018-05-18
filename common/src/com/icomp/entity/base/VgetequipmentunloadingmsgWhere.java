/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/12/05 11:05:02
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/12/05 11:05:02
 * 创建者  ：杨作庆
 * 
 */
public class VgetequipmentunloadingmsgWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* RFID标签ID	*/ 
	private String rfidWhere;

	/**
	 * RFID标签ID取得
	 * @return rfidWhere
	 */
	public String getRfidWhere () {
		return rfidWhere;
	}

	/**
	 * RFID标签ID设定
	 * @param rfidWhere
	 */
	public void setRfidWhere (String rfidWhere) {
		this.rfidWhere = rfidWhere;
	}

	/* 合成刀具编码(系统唯一)	*/ 
	private String synthesisCutterNumberWhere;

	/**
	 * 合成刀具编码(系统唯一)取得
	 * @return synthesisCutterNumberWhere
	 */
	public String getSynthesisCutterNumberWhere () {
		return synthesisCutterNumberWhere;
	}

	/**
	 * 合成刀具编码(系统唯一)设定
	 * @param synthesisCutterNumberWhere
	 */
	public void setSynthesisCutterNumberWhere (String synthesisCutterNumberWhere) {
		this.synthesisCutterNumberWhere = synthesisCutterNumberWhere;
	}

	/* 合成刀具编号(例如：001、002、003)	*/ 
	private String synthesisParametersNumberWhere;

	/**
	 * 合成刀具编号(例如：001、002、003)取得
	 * @return synthesisParametersNumberWhere
	 */
	public String getSynthesisParametersNumberWhere () {
		return synthesisParametersNumberWhere;
	}

	/**
	 * 合成刀具编号(例如：001、002、003)设定
	 * @param synthesisParametersNumberWhere
	 */
	public void setSynthesisParametersNumberWhere (String synthesisParametersNumberWhere) {
		this.synthesisParametersNumberWhere = synthesisParametersNumberWhere;
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

	/* 工序ID	*/ 
	private String processIDWhere;

	/**
	 * 工序ID取得
	 * @return processIDWhere
	 */
	public String getProcessIDWhere () {
		return processIDWhere;
	}

	/**
	 * 工序ID设定
	 * @param processIDWhere
	 */
	public void setProcessIDWhere (String processIDWhere) {
		this.processIDWhere = processIDWhere;
	}

	/* 工序编码	*/ 
	private String processCodeWhere;

	/**
	 * 工序编码取得
	 * @return processCodeWhere
	 */
	public String getProcessCodeWhere () {
		return processCodeWhere;
	}

	/**
	 * 工序编码设定
	 * @param processCodeWhere
	 */
	public void setProcessCodeWhere (String processCodeWhere) {
		this.processCodeWhere = processCodeWhere;
	}

	/* 工序名称	*/ 
	private String processNameWhere;

	/**
	 * 工序名称取得
	 * @return processNameWhere
	 */
	public String getProcessNameWhere () {
		return processNameWhere;
	}

	/**
	 * 工序名称设定
	 * @param processNameWhere
	 */
	public void setProcessNameWhere (String processNameWhere) {
		this.processNameWhere = processNameWhere;
	}

	/* 流水线名称	*/ 
	private String assemblyLineNameWhere;

	/**
	 * 流水线名称取得
	 * @return assemblyLineNameWhere
	 */
	public String getAssemblyLineNameWhere () {
		return assemblyLineNameWhere;
	}

	/**
	 * 流水线名称设定
	 * @param assemblyLineNameWhere
	 */
	public void setAssemblyLineNameWhere (String assemblyLineNameWhere) {
		this.assemblyLineNameWhere = assemblyLineNameWhere;
	}
}

