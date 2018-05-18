/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/05/30 11:44:01
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/05/30 11:44:01
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vcostamortization extends VcostamortizationWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 卸下时间	*/ 
	private Date outerTime;

	/**
	 * 卸下时间取得
	 * @return outerTime
	 */
	public Date getOuterTime() {
		return outerTime;
	}

	/**
	 * 卸下时间设定
	 * @param outerTime
	 */
	public void setOuterTime(Date outerTime) {
		this.outerTime = outerTime;
	}

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

	/* 零部件	*/ 
	private String partsID;

	/**
	 * 零部件取得
	 * @return partsID
	 */
	public String getPartsID() {
		return partsID;
	}

	/**
	 * 零部件设定
	 * @param partsID
	 */
	public void setPartsID(String partsID) {
		this.partsID = partsID;
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

	/* 刀具分类(0刀具1辅具2配套9其他）	*/ 
	private String toolType;

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）取得
	 * @return toolType
	 */
	public String getToolType() {
		return toolType;
	}

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）设定
	 * @param toolType
	 */
	public void setToolType(String toolType) {
		this.toolType = toolType;
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

	/* 	*/ 
	private String unitPrice;

	/**
	 * 取得
	 * @return unitPrice
	 */
	public String getUnitPrice() {
		return unitPrice;
	}

	/**
	 * 设定
	 * @param unitPrice
	 */
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	/* 	*/ 
	private BigDecimal userNumber;

	/**
	 * 取得
	 * @return userNumber
	 */
	public BigDecimal getUserNumber() {
		return userNumber;
	}

	/**
	 * 设定
	 * @param userNumber
	 */
	public void setUserNumber(BigDecimal userNumber) {
		this.userNumber = userNumber;
	}

	/* 	*/ 
	private String amortizationRMB;

	/**
	 * 取得
	 * @return amortizationRMB
	 */
	public String getAmortizationRMB() {
		return amortizationRMB;
	}

	/**
	 * 设定
	 * @param amortizationRMB
	 */
	public void setAmortizationRMB(String amortizationRMB) {
		this.amortizationRMB = amortizationRMB;
	}
}

