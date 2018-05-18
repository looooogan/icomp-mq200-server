/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class Vgrindingworksummary extends VgrindingworksummaryWhere implements Serializable {

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

	/* 修复时间	*/ 
	private Date noticeTime;

	/**
	 * 修复时间取得
	 * @return noticeTime
	 */
	public Date getNoticeTime() {
		return noticeTime;
	}

	/**
	 * 修复时间设定
	 * @param noticeTime
	 */
	public void setNoticeTime(Date noticeTime) {
		this.noticeTime = noticeTime;
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

	/* 修复前测量长度	*/ 
	private BigDecimal noticeLength;

	/**
	 * 修复前测量长度取得
	 * @return noticeLength
	 */
	public BigDecimal getNoticeLength() {
		return noticeLength;
	}

	/**
	 * 修复前测量长度设定
	 * @param noticeLength
	 */
	public void setNoticeLength(BigDecimal noticeLength) {
		this.noticeLength = noticeLength;
	}

	/* 修复后测量长度	*/ 
	private BigDecimal noticeOldLength;

	/**
	 * 修复后测量长度取得
	 * @return noticeOldLength
	 */
	public BigDecimal getNoticeOldLength() {
		return noticeOldLength;
	}

	/**
	 * 修复后测量长度设定
	 * @param noticeOldLength
	 */
	public void setNoticeOldLength(BigDecimal noticeOldLength) {
		this.noticeOldLength = noticeOldLength;
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

	/* 刀具入库编码	*/ 
	private String knifeInventoryCode;

	/**
	 * 刀具入库编码取得
	 * @return knifeInventoryCode
	 */
	public String getKnifeInventoryCode() {
		return knifeInventoryCode;
	}

	/**
	 * 刀具入库编码设定
	 * @param knifeInventoryCode
	 */
	public void setKnifeInventoryCode(String knifeInventoryCode) {
		this.knifeInventoryCode = knifeInventoryCode;
	}

	/* 已使用(刃磨)次数[当使用次数等于可复用次数时刀具报废]	*/ 
	private BigDecimal usageCounter;

	/**
	 * 已使用(刃磨)次数[当使用次数等于可复用次数时刀具报废]取得
	 * @return usageCounter
	 */
	public BigDecimal getUsageCounter() {
		return usageCounter;
	}

	/**
	 * 已使用(刃磨)次数[当使用次数等于可复用次数时刀具报废]设定
	 * @param usageCounter
	 */
	public void setUsageCounter(BigDecimal usageCounter) {
		this.usageCounter = usageCounter;
	}
	/**
	 * 是否超标（0：未超标，1：超标）
	 */
	private String overproof;
	/**
	 * GET是否超标
	 * @title getOverproof 
	 * @return
	 * String
	 */
	public String getOverproof() {
		return overproof;
	}
	/**
	 * SET是否超标
	 * @title setOverproof 
	 * @param overproof
	 * void
	 */
	public void setOverproof(String overproof) {
		this.overproof = overproof;
	}
	/**
	 * 折旧金额
	 */
	private String depreciationAmount;
	/**
	 * 残值
	 */
	private String salvageValue;
	/**
	 * GET折旧金额
	 * @title getDepreciationAmount 
	 * @return
	 * String
	 */
	public String getDepreciationAmount() {
		return depreciationAmount;
	}
	/**
	 * Set折旧金额
	 * @title setDepreciationAmount 
	 * @param depreciationAmount
	 * void
	 */
	public void setDepreciationAmount(String depreciationAmount) {
		this.depreciationAmount = depreciationAmount;
	}
	/**
	 * Get残值
	 * @title getSalvageValue 
	 * @return
	 * String
	 */
	public String getSalvageValue() {
		return salvageValue;
	}
	/**
	 * Set残值
	 * @title setSalvageValue 
	 * @param salvageValue
	 * void
	 */
	public void setSalvageValue(String salvageValue) {
		this.salvageValue = salvageValue;
	}
}

