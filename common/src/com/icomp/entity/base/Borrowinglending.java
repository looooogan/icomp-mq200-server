/*
 * 工具自动生成：刀具借入-借出实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 刀具借入-借出实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class Borrowinglending extends BorrowinglendingWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具借入借出ID	*/ 
	private String borrowingLendingID;

	/**
	 * 刀具借入借出ID取得
	 * @return borrowingLendingID
	 */
	public String getBorrowingLendingID() {
		return borrowingLendingID;
	}

	/**
	 * 刀具借入借出ID设定
	 * @param borrowingLendingID
	 */
	public void setBorrowingLendingID(String borrowingLendingID) {
		this.borrowingLendingID = borrowingLendingID;
	}

	/* RFID载体ID	*/ 
	private String rfidContainerID;

	/**
	 * RFID载体ID取得
	 * @return rfidContainerID
	 */
	public String getRfidContainerID() {
		return rfidContainerID;
	}

	/**
	 * RFID载体ID设定
	 * @param rfidContainerID
	 */
	public void setRfidContainerID(String rfidContainerID) {
		this.rfidContainerID = rfidContainerID;
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

	/* 复磨次数	*/ 
	private BigDecimal toolSharpennum;

	/**
	 * 复磨次数取得
	 * @return toolSharpennum
	 */
	public BigDecimal getToolSharpennum() {
		return toolSharpennum;
	}

	/**
	 * 复磨次数设定
	 * @param toolSharpennum
	 */
	public void setToolSharpennum(BigDecimal toolSharpennum) {
		this.toolSharpennum = toolSharpennum;
	}

	/* 耐用度	*/ 
	private BigDecimal toolDurable;

	/**
	 * 耐用度取得
	 * @return toolDurable
	 */
	public BigDecimal getToolDurable() {
		return toolDurable;
	}

	/**
	 * 耐用度设定
	 * @param toolDurable
	 */
	public void setToolDurable(BigDecimal toolDurable) {
		this.toolDurable = toolDurable;
	}

	/* 借入/借出人	*/ 
	private String borrowingLendingUser;

	/**
	 * 借入/借出人取得
	 * @return borrowingLendingUser
	 */
	public String getBorrowingLendingUser() {
		return borrowingLendingUser;
	}

	/**
	 * 借入/借出人设定
	 * @param borrowingLendingUser
	 */
	public void setBorrowingLendingUser(String borrowingLendingUser) {
		this.borrowingLendingUser = borrowingLendingUser;
	}

	/* 借入/借出时间	*/ 
	private Date borrowingLendingTime;

	/**
	 * 借入/借出时间取得
	 * @return borrowingLendingTime
	 */
	public Date getBorrowingLendingTime() {
		return borrowingLendingTime;
	}

	/**
	 * 借入/借出时间设定
	 * @param borrowingLendingTime
	 */
	public void setBorrowingLendingTime(Date borrowingLendingTime) {
		this.borrowingLendingTime = borrowingLendingTime;
	}

	/* 归还人	*/ 
	private String returnUser;

	/**
	 * 归还人取得
	 * @return returnUser
	 */
	public String getReturnUser() {
		return returnUser;
	}

	/**
	 * 归还人设定
	 * @param returnUser
	 */
	public void setReturnUser(String returnUser) {
		this.returnUser = returnUser;
	}

	/* 归还时间	*/ 
	private Date returnTime;

	/**
	 * 归还时间取得
	 * @return returnTime
	 */
	public Date getReturnTime() {
		return returnTime;
	}

	/**
	 * 归还时间设定
	 * @param returnTime
	 */
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	/* 借入/借出理由	*/ 
	private String borrowingLendingReason;

	/**
	 * 借入/借出理由取得
	 * @return borrowingLendingReason
	 */
	public String getBorrowingLendingReason() {
		return borrowingLendingReason;
	}

	/**
	 * 借入/借出理由设定
	 * @param borrowingLendingReason
	 */
	public void setBorrowingLendingReason(String borrowingLendingReason) {
		this.borrowingLendingReason = borrowingLendingReason;
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

	/* 库存状态(0正常1报废9其他)(这里刀具状态没有2、3)	*/ 
	private String stockState;

	/**
	 * 库存状态(0正常1报废9其他)(这里刀具状态没有2、3)取得
	 * @return stockState
	 */
	public String getStockState() {
		return stockState;
	}

	/**
	 * 库存状态(0正常1报废9其他)(这里刀具状态没有2、3)设定
	 * @param stockState
	 */
	public void setStockState(String stockState) {
		this.stockState = stockState;
	}

	/* 刀具状态(0断刀1丢失2不合格9其他)(这里刀具状态没有3)	*/ 
	private String toolState;

	/**
	 * 刀具状态(0断刀1丢失2不合格9其他)(这里刀具状态没有3)取得
	 * @return toolState
	 */
	public String getToolState() {
		return toolState;
	}

	/**
	 * 刀具状态(0断刀1丢失2不合格9其他)(这里刀具状态没有3)设定
	 * @param toolState
	 */
	public void setToolState(String toolState) {
		this.toolState = toolState;
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
}

