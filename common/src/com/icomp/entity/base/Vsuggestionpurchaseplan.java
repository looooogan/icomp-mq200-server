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
public class Vsuggestionpurchaseplan extends VsuggestionpurchaseplanWhere implements Serializable {

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

	/* 采购计划编号	*/ 
	private String procurementPlansCode;

	/**
	 * 采购计划编号取得
	 * @return procurementPlansCode
	 */
	public String getProcurementPlansCode() {
		return procurementPlansCode;
	}

	/**
	 * 采购计划编号设定
	 * @param procurementPlansCode
	 */
	public void setProcurementPlansCode(String procurementPlansCode) {
		this.procurementPlansCode = procurementPlansCode;
	}

	/* 应采购数量	*/ 
	private BigDecimal procurementCount;

	/**
	 * 应采购数量取得
	 * @return procurementCount
	 */
	public BigDecimal getProcurementCount() {
		return procurementCount;
	}

	/**
	 * 应采购数量设定
	 * @param procurementCount
	 */
	public void setProcurementCount(BigDecimal procurementCount) {
		this.procurementCount = procurementCount;
	}

	/* 姓名	*/ 
	private String userName;

	/**
	 * 姓名取得
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 姓名设定
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
}

