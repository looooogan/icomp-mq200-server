/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/22 10:56:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/22 10:56:03
 * 创建者  ：杨作庆
 * 
 */
public class Vtoolsupplier extends VtoolsupplierWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具编码	*/ 
	private String toolCode;
	/* 供应商	*/ 
	private String toolSupplier;
	/* 采购批次	*/ 
	private String procuredBatch;
	/* 采购单价	*/ 
	private BigDecimal unitPrice;
	/* 采购数量	*/ 
	private BigDecimal procuredCount;

	/* 定额加工量	*/ 
	private BigDecimal quotaProcessingVolume;

	/* 实际到货数量	*/ 
	private BigDecimal realityTheyCount;
	/* 预计到货时间	*/ 
	private Date theyTime;

	/* 实际到货时间	*/ 
	private Date realityTheyTime;
	/* 	*/ 
	private BigDecimal discardeCount;
	/* 	*/ 
	private BigDecimal avgCount;
	/* 	*/ 
	private BigDecimal unitCount;
	/* 	*/ 
	private BigDecimal excDiscarde;
	/* 到货准确率 */
	private BigDecimal plan;
	public BigDecimal getPlan() {
		return plan;
	}
	public void setPlan(BigDecimal plan) {
		this.plan = plan;
	}
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	public String getToolSupplier() {
		return toolSupplier;
	}
	public void setToolSupplier(String toolSupplier) {
		this.toolSupplier = toolSupplier;
	}
	public String getProcuredBatch() {
		return procuredBatch;
	}
	public void setProcuredBatch(String procuredBatch) {
		this.procuredBatch = procuredBatch;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public BigDecimal getProcuredCount() {
		return procuredCount;
	}
	public void setProcuredCount(BigDecimal procuredCount) {
		this.procuredCount = procuredCount;
	}
	public BigDecimal getQuotaProcessingVolume() {
		return quotaProcessingVolume;
	}
	public void setQuotaProcessingVolume(BigDecimal quotaProcessingVolume) {
		this.quotaProcessingVolume = quotaProcessingVolume;
	}
	public BigDecimal getRealityTheyCount() {
		return realityTheyCount;
	}
	public void setRealityTheyCount(BigDecimal realityTheyCount) {
		this.realityTheyCount = realityTheyCount;
	}
	public Date getTheyTime() {
		return theyTime;
	}
	public void setTheyTime(Date theyTime) {
		this.theyTime = theyTime;
	}
	public Date getRealityTheyTime() {
		return realityTheyTime;
	}
	public void setRealityTheyTime(Date realityTheyTime) {
		this.realityTheyTime = realityTheyTime;
	}
	public BigDecimal getDiscardeCount() {
		return discardeCount;
	}
	public void setDiscardeCount(BigDecimal discardeCount) {
		this.discardeCount = discardeCount;
	}
	public BigDecimal getAvgCount() {
		return avgCount;
	}
	public void setAvgCount(BigDecimal avgCount) {
		this.avgCount = avgCount;
	}
	public BigDecimal getUnitCount() {
		return unitCount;
	}
	public void setUnitCount(BigDecimal unitCount) {
		this.unitCount = unitCount;
	}
	public BigDecimal getExcDiscarde() {
		return excDiscarde;
	}
	public void setExcDiscarde(BigDecimal excDiscarde) {
		this.excDiscarde = excDiscarde;
	}
}

