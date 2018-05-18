/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2015/04/22 18:46:22
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2015/04/22 18:46:22
 * 创建者  ：杨作庆
 * 
 */
public class Vcostabsorption extends VcostabsorptionWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 设备名称	*/ 
	private String equipmentname;

	/**
	 * 设备名称取得
	 * @return equipmentname
	 */
	public String getEquipmentname() {
		return equipmentname;
	}

	/**
	 * 设备名称设定
	 * @param equipmentname
	 */
	public void setEquipmentname(String equipmentname) {
		this.equipmentname = equipmentname;
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

	/* 刀具编码	*/ 
	private String toolCode;

	/**
	 * 刀具编码取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 刀具编码设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 刀具名称	*/ 
	private String toolName;

	/**
	 * 刀具名称取得
	 * @return toolName
	 */
	public String getToolName() {
		return toolName;
	}

	/**
	 * 刀具名称设定
	 * @param toolName
	 */
	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	/* 	*/ 
	private BigDecimal price;

	/**
	 * 取得
	 * @return price
	 */
	public BigDecimal  getPrice() {
		return price;
	}

	/**
	 * 设定
	 * @param price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/* 	*/ 
	private BigDecimal consumedCount;

	/**
	 * 取得
	 * @return consumedCount
	 */
	public BigDecimal getconsumedCount() {
		return consumedCount;
	}

	/**
	 * 设定
	 * @param consumedCount
	 */
	public void setconsumedCount(BigDecimal consumedCount) {
		this.consumedCount = consumedCount;
	}

	/* 	*/ 
	private BigDecimal processAmount;

	/**
	 * 取得
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
}

