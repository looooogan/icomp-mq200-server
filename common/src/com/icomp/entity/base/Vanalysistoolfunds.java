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
public class Vanalysistoolfunds extends VanalysistoolfundsWhere implements Serializable {

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

	/* 刀具状态(0断刀1丢失2不合格3借入4申领9其他)	*/ 
	private String toolState;

	/**
	 * 刀具状态(0断刀1丢失2不合格3借入4申领9其他)取得
	 * @return toolState
	 */
	public String getToolState() {
		return toolState;
	}

	/**
	 * 刀具状态(0断刀1丢失2不合格3借入4申领9其他)设定
	 * @param toolState
	 */
	public void setToolState(String toolState) {
		this.toolState = toolState;
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

