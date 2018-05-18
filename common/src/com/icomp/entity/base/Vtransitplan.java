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
public class Vtransitplan extends VtransitplanWhere implements Serializable {

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

	/* 	*/ 
	private String deliveryPlanID;

	/**
	 * 取得
	 * @return deliveryPlanID
	 */
	public String getDeliveryPlanID() {
		return deliveryPlanID;
	}

	/**
	 * 设定
	 * @param deliveryPlanID
	 */
	public void setDeliveryPlanID(String deliveryPlanID) {
		this.deliveryPlanID = deliveryPlanID;
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

	/* 预计到货数量	*/ 
	private BigDecimal theyCount;

	/**
	 * 预计到货数量取得
	 * @return theyCount
	 */
	public BigDecimal getTheyCount() {
		return theyCount;
	}

	/**
	 * 预计到货数量设定
	 * @param theyCount
	 */
	public void setTheyCount(BigDecimal theyCount) {
		this.theyCount = theyCount;
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

	/* 实际到货数量	*/ 
	private BigDecimal realityTheyCount;

	/**
	 * 实际到货数量取得
	 * @return realityTheyCount
	 */
	public BigDecimal getRealityTheyCount() {
		return realityTheyCount;
	}

	/**
	 * 实际到货数量设定
	 * @param realityTheyCount
	 */
	public void setRealityTheyCount(BigDecimal realityTheyCount) {
		this.realityTheyCount = realityTheyCount;
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

	/* 姓名	*/ 
	private String transferPeople;

	/**
	 * 姓名取得
	 * @return transferPeople
	 */
	public String getTransferPeople() {
		return transferPeople;
	}

	/**
	 * 姓名设定
	 * @param transferPeople
	 */
	public void setTransferPeople(String transferPeople) {
		this.transferPeople = transferPeople;
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

