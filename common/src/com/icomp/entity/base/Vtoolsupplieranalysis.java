/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:05
 * 创建者  ：杨作庆
 * 
 */
public class Vtoolsupplieranalysis extends VtoolsupplieranalysisWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 供应商	*/ 
	private String toolSupplier;

	/**
	 * 供应商取得
	 * @return toolSupplier
	 */
	public String getToolSupplier() {
		return toolSupplier;
	}

	/**
	 * 供应商设定
	 * @param toolSupplier
	 */
	public void setToolSupplier(String toolSupplier) {
		this.toolSupplier = toolSupplier;
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

	/* 采购数量	*/ 
	private BigDecimal procuredCount;

	/**
	 * 采购数量取得
	 * @return procuredCount
	 */
	public BigDecimal getProcuredCount() {
		return procuredCount;
	}

	/**
	 * 采购数量设定
	 * @param procuredCount
	 */
	public void setProcuredCount(BigDecimal procuredCount) {
		this.procuredCount = procuredCount;
	}

	/* 刀具ID	*/ 
	private String toolID;

	/**
	 * 刀具ID取得
	 * @return toolID
	 */
	public String gettoolID() {
		return toolID;
	}

	/**
	 * 刀具ID设定
	 * @param toolID
	 */
	public void settoolID(String toolID) {
		this.toolID = toolID;
	}

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

	/* 	*/ 
	private BigDecimal consumedCount;

	/**
	 * 取得
	 * @return consumedCount
	 */
	public BigDecimal getConsumedCount() {
		return consumedCount;
	}

	/**
	 * 设定
	 * @param consumedCount
	 */
	public void setConsumedCount(BigDecimal consumedCount) {
		this.consumedCount = consumedCount;
	}

	/* 	*/ 
	private BigDecimal toolProcessingVolume;

	/**
	 * 取得
	 * @return toolProcessingVolume
	 */
	public BigDecimal getToolProcessingVolume() {
		return toolProcessingVolume;
	}

	/**
	 * 设定
	 * @param toolProcessingVolume
	 */
	public void setToolProcessingVolume(BigDecimal toolProcessingVolume) {
		this.toolProcessingVolume = toolProcessingVolume;
	}

	/* 采购日期	*/ 
	private String procuredTime;

	/**
	 * 采购日期取得
	 * @return procuredTime
	 */
	public String getProcuredTime() {
		return procuredTime;
	}

	/**
	 * 采购日期设定
	 * @param procuredTime
	 */
	public void setProcuredTime(String procuredTime) {
		this.procuredTime = procuredTime;
	}

	/* 预计到货时间	*/ 
	private Date theyTime;

	/**
	 * 预计到货时间取得
	 * @return theyTime
	 */
	public Date getTheyTime() {
		return theyTime;
	}

	/**
	 * 预计到货时间设定
	 * @param theyTime
	 */
	public void setTheyTime(Date theyTime) {
		this.theyTime = theyTime;
	}

	/* 实际到货时间	*/ 
	private Date realityTheyTime;

	/**
	 * 实际到货时间取得
	 * @return realityTheyTime
	 */
	public Date getRealityTheyTime() {
		return realityTheyTime;
	}

	/**
	 * 实际到货时间设定
	 * @param realityTheyTime
	 */
	public void setRealityTheyTime(Date realityTheyTime) {
		this.realityTheyTime = realityTheyTime;
	}
	
	/**
	 * 单品加工量
	 */
	private String avgProcessing;
	/**
	 * 单品加工量
	 * @title getAvgProcessing 
	 * @return
	 * String
	 */
	public String getAvgProcessing() {
		return avgProcessing;
	}
	/**
	 * 单品加工量
	 * @title setAvgProcessing 
	 * @param avgProcessing
	 * void
	 */
	public void setAvgProcessing(String avgProcessing) {
		this.avgProcessing = avgProcessing;
	}
}

