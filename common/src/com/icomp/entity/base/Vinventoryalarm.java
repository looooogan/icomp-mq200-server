/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/17 09:29:24
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/17 09:29:24
 * 创建者  ：杨作庆
 * 
 */
public class Vinventoryalarm extends VinventoryalarmWhere implements Serializable,Comparable<Vinventoryalarm> {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具ID	*/ 
	private String toolID;

	/**
	 * 刀具ID取得
	 * @return toolID
	 */
	public String getToolID() {
		return toolID;
	}

	/**
	 * 刀具ID设定
	 * @param toolID
	 */
	public void setToolID(String toolID) {
		this.toolID = toolID;
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

	/* 刀具周转量	*/ 
	private BigDecimal toolTurnover;

	/**
	 * 刀具周转量取得
	 * @return toolTurnover
	 */
	public BigDecimal getToolTurnover() {
		return toolTurnover;
	}

	/**
	 * 刀具周转量设定
	 * @param toolTurnover
	 */
	public void setToolTurnover(BigDecimal toolTurnover) {
		this.toolTurnover = toolTurnover;
	}

	/*库存量 	*/ 
	private BigDecimal inventoryCount;

	/**
	 * 取得库存量
	 * @return inventoryCount
	 */
	public BigDecimal getInventoryCount() {
		return inventoryCount;
	}

	/**
	 * 设定库存量
	 * @param inventoryCount
	 */
	public void setInventoryCount(BigDecimal inventoryCount) {
		this.inventoryCount = inventoryCount;
	}

	/* 流转量	*/ 
	private BigDecimal transferCount;

	/**
	 * 取得流转量
	 * @return transferCount
	 */
	public BigDecimal getTransferCount() {
		return transferCount;
	}

	/**
	 * 设定流转量
	 * @param transferCount
	 */
	public void setTransferCount(BigDecimal transferCount) {
		this.transferCount = transferCount;
	}

	/* 在途量	*/ 
	private BigDecimal passageCount;

	/**
	 * 取得在途量
	 * @return passageCount
	 */
	public BigDecimal getPassageCount() {
		return passageCount;
	}

	/**
	 * 设定在途量
	 * @param passageCount
	 */
	public void setPassageCount(BigDecimal passageCount) {
		this.passageCount = passageCount;
	}

	/*告警系数*/ 
	private String toolAlarmRatio;

	/**
	 * 取得告警系数
	 * @return toolAlarmRatio
	 */
	public String getToolAlarmRatio() {
		return toolAlarmRatio;
	}

	/**
	 * 设定告警系数
	 * @param toolAlarmRatio
	 */
	public void setToolAlarmRatio(String toolAlarmRatio) {
		this.toolAlarmRatio = toolAlarmRatio;
	}

	@Override
	public int compareTo(Vinventoryalarm o) {
		return this.getStates().compareTo(o.getStates());
	}

}

