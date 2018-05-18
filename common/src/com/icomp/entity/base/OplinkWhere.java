/*
 * 工具自动生成：条件实体类
 * 生成时间    : 2016/03/03 10:24:38
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;

import java.math.BigDecimal;


/**
 * 条件实体类
 * @author 工具自动生成
 * 创建时间：2016/03/03 10:24:38
 * 创建者  ：工具自动生成
 * 
 */
public class OplinkWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* OplinkID	*/ 
	private String oplinkIDWhere;

	/**
	 * OplinkID取得
	 * @return oplinkIDWhere
	 */
	public String getOplinkIDWhere () {
		return oplinkIDWhere;
	}

	/**
	 * OplinkID设定
	 * @param oplinkIDWhere
	 */
	public void setOplinkIDWhere (String oplinkIDWhere) {
		this.oplinkIDWhere = oplinkIDWhere;
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

	/* 流水线ID	*/ 
	private String assemblyLineIDWhere;

	/**
	 * 流水线ID取得
	 * @return assemblyLineIDWhere
	 */
	public String getAssemblyLineIDWhere () {
		return assemblyLineIDWhere;
	}

	/**
	 * 流水线ID设定
	 * @param assemblyLineIDWhere
	 */
	public void setAssemblyLineIDWhere (String assemblyLineIDWhere) {
		this.assemblyLineIDWhere = assemblyLineIDWhere;
	}

	/* 合成刀具参数ID	*/ 
	private String synthesisParametersIDWhere;

	/**
	 * 合成刀具参数ID取得
	 * @return synthesisParametersIDWhere
	 */
	public String getSynthesisParametersIDWhere () {
		return synthesisParametersIDWhere;
	}

	/**
	 * 合成刀具参数ID设定
	 * @param synthesisParametersIDWhere
	 */
	public void setSynthesisParametersIDWhere (String synthesisParametersIDWhere) {
		this.synthesisParametersIDWhere = synthesisParametersIDWhere;
	}

	/* 零部件ID	*/ 
	private String partsIDWhere;

	/**
	 * 零部件ID取得
	 * @return partsIDWhere
	 */
	public String getPartsIDWhere () {
		return partsIDWhere;
	}

	/**
	 * 零部件ID设定
	 * @param partsIDWhere
	 */
	public void setPartsIDWhere (String partsIDWhere) {
		this.partsIDWhere = partsIDWhere;
	}

	/* 轴ID	*/ 
	private String axleIDWhere;

	/**
	 * 轴ID取得
	 * @return axleIDWhere
	 */
	public String getAxleIDWhere () {
		return axleIDWhere;
	}

	/**
	 * 轴ID设定
	 * @param axleIDWhere
	 */
	public void setAxleIDWhere (String axleIDWhere) {
		this.axleIDWhere = axleIDWhere;
	}

	/* 耐用度	*/ 
	private BigDecimal toolDurableWhere;

	/**
	 * 耐用度取得
	 * @return toolDurableWhere
	 */
	public BigDecimal getToolDurableWhere () {
		return toolDurableWhere;
	}

	/**
	 * 耐用度设定
	 * @param toolDurableWhere
	 */
	public void setToolDurableWhere (BigDecimal toolDurableWhere) {
		this.toolDurableWhere = toolDurableWhere;
	}
}

