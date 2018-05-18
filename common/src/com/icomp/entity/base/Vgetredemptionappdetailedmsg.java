/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2015/01/27 16:52:27
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2015/01/27 16:52:27
 * 创建者  ：杨作庆
 * 
 */
public class Vgetredemptionappdetailedmsg extends VgetredemptionappdetailedmsgWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 换领申请流水号	*/ 
	private String redemptionAppliedID;

	/**
	 * 换领申请流水号取得
	 * @return redemptionAppliedID
	 */
	public String getRedemptionAppliedID() {
		return redemptionAppliedID;
	}

	/**
	 * 换领申请流水号设定
	 * @param redemptionAppliedID
	 */
	public void setRedemptionAppliedID(String redemptionAppliedID) {
		this.redemptionAppliedID = redemptionAppliedID;
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

	/* 申请数量	*/ 
	private BigDecimal appliedNumber;

	/**
	 * 申请数量取得
	 * @return appliedNumber
	 */
	public BigDecimal getAppliedNumber() {
		return appliedNumber;
	}

	/**
	 * 申请数量设定
	 * @param appliedNumber
	 */
	public void setAppliedNumber(BigDecimal appliedNumber) {
		this.appliedNumber = appliedNumber;
	}

	/* 	*/ 
	private BigDecimal inventoryCount_A;

	/**
	 * 取得
	 * @return inventoryCount_A
	 */
	public BigDecimal getInventoryCount_A() {
		return inventoryCount_A;
	}

	/**
	 * 设定
	 * @param inventoryCount_A
	 */
	public void setInventoryCount_A(BigDecimal inventoryCount_A) {
		this.inventoryCount_A = inventoryCount_A;
	}

	/* 	*/ 
	private BigDecimal inventoryCount_B;

	/**
	 * 取得
	 * @return inventoryCount_B
	 */
	public BigDecimal getInventoryCount_B() {
		return inventoryCount_B;
	}

	/**
	 * 设定
	 * @param inventoryCount_B
	 */
	public void setInventoryCount_B(BigDecimal inventoryCount_B) {
		this.inventoryCount_B = inventoryCount_B;
	}

	/* 送回数量	*/ 
	private BigDecimal returnNumber;

	/**
	 * 送回数量取得
	 * @return returnNumber
	 */
	public BigDecimal getReturnNumber() {
		return returnNumber;
	}

	/**
	 * 送回数量设定
	 * @param returnNumber
	 */
	public void setReturnNumber(BigDecimal returnNumber) {
		this.returnNumber = returnNumber;
	}

	/* 断刀数量	*/ 
	private BigDecimal brokenNumber;

	/**
	 * 断刀数量取得
	 * @return brokenNumber
	 */
	public BigDecimal getBrokenNumber() {
		return brokenNumber;
	}

	/**
	 * 断刀数量设定
	 * @param brokenNumber
	 */
	public void setBrokenNumber(BigDecimal brokenNumber) {
		this.brokenNumber = brokenNumber;
	}

	/* 丢失数量	*/ 
	private BigDecimal lostNumber;

	/**
	 * 丢失数量取得
	 * @return lostNumber
	 */
	public BigDecimal getLostNumber() {
		return lostNumber;
	}

	/**
	 * 丢失数量设定
	 * @param lostNumber
	 */
	public void setLostNumber(BigDecimal lostNumber) {
		this.lostNumber = lostNumber;
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

	/* 复磨标准	*/ 
	private BigDecimal toolSharpenCriterion;

	/**
	 * 复磨标准取得
	 * @return toolSharpenCriterion
	 */
	public BigDecimal getToolSharpenCriterion() {
		return toolSharpenCriterion;
	}

	/**
	 * 复磨标准设定
	 * @param toolSharpenCriterion
	 */
	public void setToolSharpenCriterion(BigDecimal toolSharpenCriterion) {
		this.toolSharpenCriterion = toolSharpenCriterion;
	}

	/* 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )	*/ 
	private String processingStatus;

	/**
	 * 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )取得
	 * @return processingStatus
	 */
	public String getProcessingStatus() {
		return processingStatus;
	}

	/**
	 * 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )设定
	 * @param processingStatus
	 */
	public void setProcessingStatus(String processingStatus) {
		this.processingStatus = processingStatus;
	}

	/* 备货数量	*/ 
	private BigDecimal stockNumber;

	/**
	 * 备货数量取得
	 * @return stockNumber
	 */
	public BigDecimal getStockNumber() {
		return stockNumber;
	}

	/**
	 * 备货数量设定
	 * @param stockNumber
	 */
	public void setStockNumber(BigDecimal stockNumber) {
		this.stockNumber = stockNumber;
	}
}

