/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/25 14:29:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/25 14:29:03
 * 创建者  ：杨作庆
 * 
 */
public class Vconsumptiontool extends VconsumptiontoolWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 零部件名称	*/ 
	private String partsName;

	/**
	 * 零部件名称取得
	 * @return partsName
	 */
	public String getPartsName() {
		return partsName;
	}

	/**
	 * 零部件名称设定
	 * @param partsName
	 */
	public void setPartsName(String partsName) {
		this.partsName = partsName;
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

	/* 定额加工量	*/ 
	private BigDecimal quotaProcessingVolume;

	/**
	 * 定额加工量取得
	 * @return quotaProcessingVolume
	 */
	public BigDecimal getQuotaProcessingVolume() {
		return quotaProcessingVolume;
	}

	/**
	 * 定额加工量设定
	 * @param quotaProcessingVolume
	 */
	public void setQuotaProcessingVolume(BigDecimal quotaProcessingVolume) {
		this.quotaProcessingVolume = quotaProcessingVolume;
	}

	/* 加工数量	*/ 
	private BigDecimal processAmount;

	/**
	 * 加工数量取得
	 * @return processAmount
	 */
	public BigDecimal getProcessAmount() {
		return processAmount;
	}

	/**
	 * 加工数量设定
	 * @param processAmount
	 */
	public void setProcessAmount(BigDecimal processAmount) {
		this.processAmount = processAmount;
	}

	/* 	*/ 
	private BigDecimal processAmountSum;

	/**
	 * 取得
	 * @return processAmountSum
	 */
	public BigDecimal getProcessAmountSum() {
		return processAmountSum;
	}

	/**
	 * 设定
	 * @param processAmountSum
	 */
	public void setProcessAmountSum(BigDecimal processAmountSum) {
		this.processAmountSum = processAmountSum;
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

	/* 	*/ 
	private BigDecimal  planGrindingTimes;

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
	private BigDecimal actualGrindingTimes;

	/**
	 * 取得
	 * @return actualGrindingTimes
	 */
	public BigDecimal getactualGrindingTimes() {
		return actualGrindingTimes;
	}

	/**
	 * 设定
	 * @param actualGrindingTimes
	 */
	public void setactualGrindingTimes(BigDecimal actualGrindingTimes) {
		this.actualGrindingTimes = actualGrindingTimes;
	}
}

