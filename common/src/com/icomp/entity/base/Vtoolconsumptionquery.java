/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/25 13:42:05
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/25 13:42:05
 * 创建者  ：杨作庆
 * 
 */
public class Vtoolconsumptionquery extends VtoolconsumptionqueryWhere implements Serializable {

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

	/* 库存状态(0正常1报废2返厂3封存9其他)	*/ 
	private String stockState;

	/**
	 * 库存状态(0正常1报废2返厂3封存9其他)取得
	 * @return stockState
	 */
	public String getStockState() {
		return stockState;
	}

	/**
	 * 库存状态(0正常1报废2返厂3封存9其他)设定
	 * @param stockState
	 */
	public void setStockState(String stockState) {
		this.stockState = stockState;
	}

	/* 刀具已刃磨长度	*/ 
	private BigDecimal toolGrindingLength;

	/**
	 * 刀具已刃磨长度取得
	 * @return toolGrindingLength
	 */
	public BigDecimal getToolGrindingLength() {
		return toolGrindingLength;
	}

	/**
	 * 刀具已刃磨长度设定
	 * @param toolGrindingLength
	 */
	public void setToolGrindingLength(BigDecimal toolGrindingLength) {
		this.toolGrindingLength = toolGrindingLength;
	}

	/* 刀具长度	*/ 
	private BigDecimal toolLength;

	/**
	 * 刀具长度取得
	 * @return toolLength
	 */
	public BigDecimal getToolLength() {
		return toolLength;
	}

	/**
	 * 刀具长度设定
	 * @param toolLength
	 */
	public void setToolLength(BigDecimal toolLength) {
		this.toolLength = toolLength;
	}

	/* 可刃磨长度	*/ 
	private BigDecimal toolSharpenLength;

	/**
	 * 可刃磨长度取得
	 * @return toolSharpenLength
	 */
	public BigDecimal getToolSharpenLength() {
		return toolSharpenLength;
	}

	/**
	 * 可刃磨长度设定
	 * @param toolSharpenLength
	 */
	public void setToolSharpenLength(BigDecimal toolSharpenLength) {
		this.toolSharpenLength = toolSharpenLength;
	}

	/* 可使用次数	*/ 
	private BigDecimal toolNum;

	/**
	 * 可使用次数取得
	 * @return toolNum
	 */
	public BigDecimal getToolNum() {
		return toolNum;
	}

	/**
	 * 可使用次数设定
	 * @param toolNum
	 */
	public void setToolNum(BigDecimal toolNum) {
		this.toolNum = toolNum;
	}

	/* 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他	*/ 
	private String toolConsumetype;

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他取得
	 * @return toolConsumetype
	 */
	public String getToolConsumetype() {
		return toolConsumetype;
	}

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他设定
	 * @param toolConsumetype
	 */
	public void setToolConsumetype(String toolConsumetype) {
		this.toolConsumetype = toolConsumetype;
	}

	/* 	*/ 
	private BigDecimal planGrindingTimes;

	/**
	 * 取得
	 * @return planGrindingTimes
	 */
	public BigDecimal getplanGrindingTimes() {
		return planGrindingTimes;
	}

	/**
	 * 设定
	 * @param planGrindingTimes
	 */
	public void setplanGrindingTimes(BigDecimal planGrindingTimes) {
		this.planGrindingTimes = planGrindingTimes;
	}

	/* 可使用(刃磨)次数	*/ 
	private BigDecimal toolSharpennum;

	/**
	 * 可使用(刃磨)次数取得
	 * @return toolSharpennum
	 */
	public BigDecimal getToolSharpennum() {
		return toolSharpennum;
	}

	/**
	 * 可使用(刃磨)次数设定
	 * @param toolSharpennum
	 */
	public void setToolSharpennum(BigDecimal toolSharpennum) {
		this.toolSharpennum = toolSharpennum;
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
}

