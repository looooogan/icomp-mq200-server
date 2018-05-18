/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2015/01/04 17:34:49
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2015/01/04 17:34:49
 * 创建者  ：杨作庆
 * 
 */
public class Vprocessingquickquery extends VprocessingquickqueryWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 合成刀具编码(系统唯一)	*/ 
	private String synthesisParametersCode;

	/**
	 * 合成刀具编码(系统唯一)取得
	 * @return synthesisParametersCode
	 */
	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	/**
	 * 合成刀具编码(系统唯一)设定
	 * @param synthesisParametersCode
	 */
	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
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

	/* 业务流程名	*/ 
	private String businessName;

	/**
	 * 业务流程名取得
	 * @return businessName
	 */
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * 业务流程名设定
	 * @param businessName
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/* 刀具状态(0断刀1丢失2不合格3借入4申领9其他)	*/ 
	private String toolState;

	/**
	 * 刀具状态(0断刀1丢失2不合格3借入4申领9其他)取得
	 * @return toolState
	 */
	public String gettoolState() {
		return toolState;
	}

	/**
	 * 刀具状态(0断刀1丢失2不合格3借入4申领9其他)设定
	 * @param toolState
	 */
	public void settoolState(String toolState) {
		this.toolState = toolState;
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

	/* 	*/ 
	private BigDecimal sumProcessAmount;

	/**
	 * 取得
	 * @return sumProcessAmount
	 */
	public BigDecimal getsumProcessAmount() {
		return sumProcessAmount;
	}

	/**
	 * 设定
	 * @param sumProcessAmount
	 */
	public void setsumProcessAmount(BigDecimal sumProcessAmount) {
		this.sumProcessAmount = sumProcessAmount;
	}

	/* 	*/ 
	private BigDecimal avgProcessAmount;

	/**
	 * 取得
	 * @return avgProcessAmount
	 */
	public BigDecimal getavgProcessAmount() {
		return avgProcessAmount;
	}

	/**
	 * 设定
	 * @param avgProcessAmount
	 */
	public void setavgProcessAmount(BigDecimal avgProcessAmount) {
		this.avgProcessAmount = avgProcessAmount;
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

	/* 可使用次数	*/ 
	private BigDecimal toolSharpennum;

	/**
	 * 可使用次数取得
	 * @return toolSharpennum
	 */
	public BigDecimal getToolSharpennum() {
		return toolSharpennum;
	}

	/**
	 * 可使用次数设定
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

	/* 	*/ 
	private String salvageValue;

	/**
	 * 取得
	 * @return salvageValue
	 */
	public String getsalvageValue() {
		return salvageValue;
	}

	/**
	 * 设定
	 * @param salvageValue
	 */
	public void setsalvageValue(String salvageValue) {
		this.salvageValue = salvageValue;
	}
}

