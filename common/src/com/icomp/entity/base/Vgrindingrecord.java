/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/24 16:59:01
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/24 16:59:01
 * 创建者  ：杨作庆
 * 
 */
public class Vgrindingrecord extends VgrindingrecordWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 	*/ 
	private String toolState;

	/**
	 * 取得
	 * @return toolState
	 */
	public String getToolState() {
		return toolState;
	}

	/**
	 * 设定
	 * @param toolState
	 */
	public void setToolState(String toolState) {
		this.toolState = toolState;
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

	/* 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他	*/ 
	private String toolConsumetype;

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他取得
	 * @return toolConsumetype
	 */
	public String gettoolConsumetype() {
		return toolConsumetype;
	}

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他设定
	 * @param toolConsumetype
	 */
	public void settoolConsumetype(String toolConsumetype) {
		this.toolConsumetype = toolConsumetype;
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

	/* 	*/ 
	private BigDecimal usageTimes;

	/**
	 * 取得
	 * @return usageTimes
	 */
	public  BigDecimal getusageTimes() {
		return usageTimes;
	}

	/**
	 * 设定
	 * @param usageTimes
	 */
	public void setusageTimes(BigDecimal usageTimes) {
		this.usageTimes = usageTimes;
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

	/* 	*/ 
	private BigDecimal standardTimes;

	/**
	 * 取得
	 * @return standardTimes
	 */
	public BigDecimal getstandardTimes() {
		return standardTimes;
	}

	/**
	 * 设定
	 * @param standardTimes
	 */
	public void setstandardTimes(BigDecimal standardTimes) {
		this.standardTimes = standardTimes;
	}

	/* 	*/ 
	private BigDecimal consumedCount;

	/**
	 * 取得
	 * @return consumedCount
	 */
	public BigDecimal getconsumedCount() {
		return consumedCount;
	}

	/**
	 * 设定
	 * @param consumedCount
	 */
	public void setconsumedCount(BigDecimal consumedCount) {
		this.consumedCount = consumedCount;
	}

	/* 	*/ 
	private BigDecimal processAmount;

	/**
	 * 取得
	 * @return processAmount
	 */
	public BigDecimal getProcessAmount() {
		return processAmount;
	}

	/**
	 * 设定
	 * @param processAmount
	 */
	public void setProcessAmount(BigDecimal processAmount) {
		this.processAmount = processAmount;
	}

	/* 	*/ 
	private String avgNum;

	/**
	 * 取得
	 * @return avgNum
	 */
	public String getAvgNum() {
		return avgNum;
	}

	/**
	 * 设定
	 * @param avgNum
	 */
	public void setAvgNum(String avgNum) {
		this.avgNum = avgNum;
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

	/* 通知时间	*/ 
	private Date noticeTime;

	/**
	 * 通知时间取得
	 * @return noticeTime
	 */
	public Date getNoticeTime() {
		return noticeTime;
	}

	/**
	 * 通知时间设定
	 * @param noticeTime
	 */
	public void setNoticeTime(Date noticeTime) {
		this.noticeTime = noticeTime;
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
	 * GET残值
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
	
	/* 剩余长度	*/ 
	private String toolRemainingLength;
	
    /**
     * 取得
	 * @param toolRemainingLength
     */
	public String getToolRemainingLength() {
		return toolRemainingLength;
	}
	/**
     * 设定
	 * @param toolRemainingLength
     */
	public void setToolRemainingLength(String toolRemainingLength) {
		this.toolRemainingLength = toolRemainingLength;
	}
	
	/* 剩余面数	*/ 
	private String toolRemainingNum;
	
    /**
     * 取得
	 * @param toolRemainingNum
     */
	public String getToolRemainingNum() {
		return toolRemainingNum;
	}
	/**
     * 设定
	 * @param toolRemainingNum
     */
	public void setToolRemainingNum(String toolRemainingNum) {
		this.toolRemainingNum = toolRemainingNum;
	}
}