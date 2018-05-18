/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class Vbatchlist extends VbatchlistWhere implements Serializable {

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

	/* 货品状态(0未到货1已到货2质检通过3质检未通过)	*/ 
	private String theyStatus;

	/**
	 * 货品状态(0未到货1已到货2质检通过3质检未通过)取得
	 * @return theyStatus
	 */
	public String getTheyStatus() {
		return theyStatus;
	}

	/**
	 * 货品状态(0未到货1已到货2质检通过3质检未通过)设定
	 * @param theyStatus
	 */
	public void setTheyStatus(String theyStatus) {
		this.theyStatus = theyStatus;
	}

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
	
	/**
	 * 采购数量
	 */
	public BigDecimal procuredCount;

	public BigDecimal getProcuredCount() {
		return procuredCount;
	}

	public void setProcuredCount(BigDecimal procuredCount) {
		this.procuredCount = procuredCount;
	}
	
	/**
	 * 入库量
	 */
	public BigDecimal inventoryCount;

	public BigDecimal getInventoryCount() {
		return inventoryCount;
	}

	public void setInventoryCount(BigDecimal inventoryCount) {
		this.inventoryCount = inventoryCount;
	}
}

