/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/03/08 10:09:51
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/03/08 10:09:51
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vgetshelfinformation extends VgetshelfinformationWhere implements Serializable {

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

	/* 库位码主键	*/ 
	private String libraryCodeID;

	/**
	 * 库位码主键取得
	 * @return libraryCodeID
	 */
	public String getLibraryCodeID() {
		return libraryCodeID;
	}

	/**
	 * 库位码主键设定
	 * @param libraryCodeID
	 */
	public void setLibraryCodeID(String libraryCodeID) {
		this.libraryCodeID = libraryCodeID;
	}

	/* 系统编码	*/ 
	private String systeCode;

	/**
	 * 系统编码取得
	 * @return systeCode
	 */
	public String getSysteCode() {
		return systeCode;
	}

	/**
	 * 系统编码设定
	 * @param systeCode
	 */
	public void setSysteCode(String systeCode) {
		this.systeCode = systeCode;
	}

	/* 自定义编码	*/ 
	private String customerCode;

	/**
	 * 自定义编码取得
	 * @return customerCode
	 */
	public String getCustomerCode() {
		return customerCode;
	}

	/**
	 * 自定义编码设定
	 * @param customerCode
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	/* 货架ID	*/ 
	private String stackID;

	/**
	 * 货架ID取得
	 * @return stackID
	 */
	public String getStackID() {
		return stackID;
	}

	/**
	 * 货架ID设定
	 * @param stackID
	 */
	public void setStackID(String stackID) {
		this.stackID = stackID;
	}

	/* 	*/ 
	private String layerText;

	/**
	 * 取得
	 * @return layerText
	 */
	public String getLayerText() {
		return layerText;
	}

	/**
	 * 设定
	 * @param layerText
	 */
	public void setLayerText(String layerText) {
		this.layerText = layerText;
	}

	/* 	*/ 
	private String stackText;

	/**
	 * 取得
	 * @return stackText
	 */
	public String getStackText() {
		return stackText;
	}

	/**
	 * 设定
	 * @param stackText
	 */
	public void setStackText(String stackText) {
		this.stackText = stackText;
	}

	/* 	*/ 
	private String shelfText;

	/**
	 * 取得
	 * @return shelfText
	 */
	public String getShelfText() {
		return shelfText;
	}

	/**
	 * 设定
	 * @param shelfText
	 */
	public void setShelfText(String shelfText) {
		this.shelfText = shelfText;
	}

	/* 	*/ 
	private String depotText;

	/**
	 * 取得
	 * @return depotText
	 */
	public String getDepotText() {
		return depotText;
	}

	/**
	 * 设定
	 * @param depotText
	 */
	public void setDepotText(String depotText) {
		this.depotText = depotText;
	}

	/* 	*/ 
	private BigDecimal a_inverntoryCount;

	/**
	 * 取得
	 * @return a_inverntoryCount
	 */
	public BigDecimal getA_inverntoryCount() {
		return a_inverntoryCount;
	}

	/**
	 * 设定
	 * @param a_inverntoryCount
	 */
	public void setA_inverntoryCount(BigDecimal a_inverntoryCount) {
		this.a_inverntoryCount = a_inverntoryCount;
	}

	/* 	*/ 
	private BigDecimal b_inverntoryCount;

	/**
	 * 取得
	 * @return b_inverntoryCount
	 */
	public BigDecimal getB_inverntoryCount() {
		return b_inverntoryCount;
	}

	/**
	 * 设定
	 * @param b_inverntoryCount
	 */
	public void setB_inverntoryCount(BigDecimal b_inverntoryCount) {
		this.b_inverntoryCount = b_inverntoryCount;
	}
}

