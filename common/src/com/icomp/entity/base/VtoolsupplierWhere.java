/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/22 10:56:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/22 10:56:03
 * 创建者  ：杨作庆
 * 
 */
public class VtoolsupplierWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具编码	*/ 
	private String toolCodeWhere;

	/* 供应商	*/ 
	private String toolSupplierWhere;

	/* 采购批次	*/ 
	private String procuredBatchWhere;

	/* 采购单价	*/ 
	private BigDecimal unitPriceWhere;

	/* 采购数量	*/ 
	private BigDecimal procuredCountWhere;

	/* 定额加工量	*/ 
	private BigDecimal quotaProcessingVolumeWhere;

	/* 实际到货数量	*/ 
	private BigDecimal realityTheyCountWhere;

	/* 预计到货时间	*/ 
	private Date theyTimeWhere;

	/* 实际到货时间	*/ 
	private Date realityTheyTimeWhere;

	/* 	*/ 
	private BigDecimal discardeCountWhere;

	/* 	*/ 
	private BigDecimal avgCountWhere;

	/* 	*/ 
	private BigDecimal unitCountWhere;

	/* 	*/ 
	private BigDecimal excDiscardeWhere;

	public String getToolCodeWhere() {
		return toolCodeWhere;
	}

	public void setToolCodeWhere(String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}

	public String getToolSupplierWhere() {
		return toolSupplierWhere;
	}

	public void setToolSupplierWhere(String toolSupplierWhere) {
		this.toolSupplierWhere = toolSupplierWhere;
	}

	public String getProcuredBatchWhere() {
		return procuredBatchWhere;
	}

	public void setProcuredBatchWhere(String procuredBatchWhere) {
		this.procuredBatchWhere = procuredBatchWhere;
	}

	public BigDecimal getUnitPriceWhere() {
		return unitPriceWhere;
	}

	public void setUnitPriceWhere(BigDecimal unitPriceWhere) {
		this.unitPriceWhere = unitPriceWhere;
	}

	public BigDecimal getProcuredCountWhere() {
		return procuredCountWhere;
	}

	public void setProcuredCountWhere(BigDecimal procuredCountWhere) {
		this.procuredCountWhere = procuredCountWhere;
	}

	public BigDecimal getQuotaProcessingVolumeWhere() {
		return quotaProcessingVolumeWhere;
	}

	public void setQuotaProcessingVolumeWhere(BigDecimal quotaProcessingVolumeWhere) {
		this.quotaProcessingVolumeWhere = quotaProcessingVolumeWhere;
	}

	public BigDecimal getRealityTheyCountWhere() {
		return realityTheyCountWhere;
	}

	public void setRealityTheyCountWhere(BigDecimal realityTheyCountWhere) {
		this.realityTheyCountWhere = realityTheyCountWhere;
	}

	public Date getTheyTimeWhere() {
		return theyTimeWhere;
	}

	public void setTheyTimeWhere(Date theyTimeWhere) {
		this.theyTimeWhere = theyTimeWhere;
	}

	public Date getRealityTheyTimeWhere() {
		return realityTheyTimeWhere;
	}

	public void setRealityTheyTimeWhere(Date realityTheyTimeWhere) {
		this.realityTheyTimeWhere = realityTheyTimeWhere;
	}

	public BigDecimal getDiscardeCountWhere() {
		return discardeCountWhere;
	}

	public void setDiscardeCountWhere(BigDecimal discardeCountWhere) {
		this.discardeCountWhere = discardeCountWhere;
	}

	public BigDecimal getAvgCountWhere() {
		return avgCountWhere;
	}

	public void setAvgCountWhere(BigDecimal avgCountWhere) {
		this.avgCountWhere = avgCountWhere;
	}

	public BigDecimal getUnitCountWhere() {
		return unitCountWhere;
	}

	public void setUnitCountWhere(BigDecimal unitCountWhere) {
		this.unitCountWhere = unitCountWhere;
	}

	public BigDecimal getExcDiscardeWhere() {
		return excDiscardeWhere;
	}

	public void setExcDiscardeWhere(BigDecimal excDiscardeWhere) {
		this.excDiscardeWhere = excDiscardeWhere;
	}
}

