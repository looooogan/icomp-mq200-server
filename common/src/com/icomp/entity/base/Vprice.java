/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/24 10:03:49
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/24 10:03:49
 * 创建者  ：杨作庆
 * 
 */
public class Vprice extends VpriceWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;
	
	private String businessCode;
	
	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}


	/* 	*/ 
	private String toolCode;

	/**
	 * 取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}


	/* 	*/ 
	private String businessFlowLnkID;

	/**
	 * 取得
	 * @return businessFlowLnkID
	 */
	public String getBusinessFlowLnkID() {
		return businessFlowLnkID;
	}

	/**
	 * 设定
	 * @param businessFlowLnkID
	 */
	public void setBusinessFlowLnkID(String businessFlowLnkID) {
		this.businessFlowLnkID = businessFlowLnkID;
	}

	/* 	*/ 
	private BigDecimal unitPrice;

	/**
	 * 取得
	 * @return unitPrice
	 */
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	/**
	 * 设定
	 * @param unitPrice
	 */
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
}

