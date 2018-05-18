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
public class Vinspectionrecord extends VinspectionrecordWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 采购ID	*/ 
	private String toolprocured;

	/**
	 * 采购ID取得
	 * @return toolprocured
	 */
	public String gettoolprocured() {
		return toolprocured;
	}

	/**
	 * 采购ID设定
	 * @param toolprocured
	 */
	public void settoolprocured(String toolprocured) {
		this.toolprocured = toolprocured;
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

	/* 品牌	*/ 
	private String toolBrand;

	/**
	 * 品牌取得
	 * @return toolBrand
	 */
	public String getToolBrand() {
		return toolBrand;
	}

	/**
	 * 品牌设定
	 * @param toolBrand
	 */
	public void setToolBrand(String toolBrand) {
		this.toolBrand = toolBrand;
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

	/* 	*/ 
	private String inspectionUser;

	/**
	 * 取得
	 * @return inspectionUser
	 */
	public String getInspectionUser() {
		return inspectionUser;
	}

	/**
	 * 设定
	 * @param inspectionUser
	 */
	public void setInspectionUser(String inspectionUser) {
		this.inspectionUser = inspectionUser;
	}
}

