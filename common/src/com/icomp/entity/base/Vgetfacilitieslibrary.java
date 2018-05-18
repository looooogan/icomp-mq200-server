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
public class Vgetfacilitieslibrary extends VgetfacilitieslibraryWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* RFID标签ID	*/ 
	private String rfidCode;

	/**
	 * RFID标签ID取得
	 * @return rfidCode
	 */
	public String getRfidCode() {
		return rfidCode;
	}

	/**
	 * RFID标签ID设定
	 * @param rfidCode
	 */
	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
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

	/* 厂区	*/ 
	private String complex;

	/**
	 * 厂区取得
	 * @return complex
	 */
	public String getComplex() {
		return complex;
	}

	/**
	 * 厂区设定
	 * @param complex
	 */
	public void setComplex(String complex) {
		this.complex = complex;
	}

	/* 	*/ 
	private String complexText;

	/**
	 * 取得
	 * @return complexText
	 */
	public String getComplexText() {
		return complexText;
	}

	/**
	 * 设定
	 * @param complexText
	 */
	public void setComplexText(String complexText) {
		this.complexText = complexText;
	}

	/* 库房号	*/ 
	private String depot;

	/**
	 * 库房号取得
	 * @return depot
	 */
	public String getDepot() {
		return depot;
	}

	/**
	 * 库房号设定
	 * @param depot
	 */
	public void setDepot(String depot) {
		this.depot = depot;
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

	/* 货架	*/ 
	private String shelf;

	/**
	 * 货架取得
	 * @return shelf
	 */
	public String getShelf() {
		return shelf;
	}

	/**
	 * 货架设定
	 * @param shelf
	 */
	public void setShelf(String shelf) {
		this.shelf = shelf;
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

	/* 层	*/ 
	private String layer;

	/**
	 * 层取得
	 * @return layer
	 */
	public String getLayer() {
		return layer;
	}

	/**
	 * 层设定
	 * @param layer
	 */
	public void setLayer(String layer) {
		this.layer = layer;
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

	/* 货位	*/ 
	private String stack;

	/**
	 * 货位取得
	 * @return stack
	 */
	public String getStack() {
		return stack;
	}

	/**
	 * 货位设定
	 * @param stack
	 */
	public void setStack(String stack) {
		this.stack = stack;
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
	private BigDecimal totleCount;

	/**
	 * 取得
	 * @return totleCount
	 */
	public BigDecimal getTotleCount() {
		return totleCount;
	}

	/**
	 * 设定
	 * @param totleCount
	 */
	public void setTotleCount(BigDecimal totleCount) {
		this.totleCount = totleCount;
	}
}

