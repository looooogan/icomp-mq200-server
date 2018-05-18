/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:05
 * 创建者  ：杨作庆
 * 
 */
public class Vtoolquicksearch extends VtoolquicksearchWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 采购ID	*/ 
	private String toolProcuredID;

	/**
	 * 采购ID取得
	 * @return toolProcuredID
	 */
	public String getToolProcuredID() {
		return toolProcuredID;
	}

	/**
	 * 采购ID设定
	 * @param toolProcuredID
	 */
	public void setToolProcuredID(String toolProcuredID) {
		this.toolProcuredID = toolProcuredID;
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

	/* 采购批次	*/ 
	private String procuredBatch;

	/**
	 * 采购批次取得
	 * @return procuredBatch
	 */
	public String getProcuredBatch() {
		return procuredBatch;
	}

	/**
	 * 采购批次设定
	 * @param procuredBatch
	 */
	public void setProcuredBatch(String procuredBatch) {
		this.procuredBatch = procuredBatch;
	}

	/* 采购单价	*/ 
	private BigDecimal unitPrice;

	/**
	 * 采购单价取得
	 * @return unitPrice
	 */
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	/**
	 * 采购单价设定
	 * @param unitPrice
	 */
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	/* 库存量	*/ 
	private BigDecimal inventory;

	/**
	 * 库存量取得
	 * @return inventory
	 */
	public BigDecimal getInventory() {
		return inventory;
	}

	/**
	 * 库存量设定
	 * @param inventory
	 */
	public void setInventory(BigDecimal inventory) {
		this.inventory = inventory;
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
	
	/**
	 * 总金额
	 */
	private String amountMoney;
	/**
	 * Get总金额
	 * @return
	 */
	public String getAmountMoney() {
		return amountMoney;
	}
	/**
	 * set总金额
	 * @param amountMoney
	 */
	public void setAmountMoney(String amountMoney) {
		this.amountMoney = amountMoney;
	}
}

