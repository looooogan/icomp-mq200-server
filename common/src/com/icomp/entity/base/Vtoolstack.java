/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:05
 * 创建者  ：杨作庆
 * 
 */
public class Vtoolstack extends VtoolstackWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 查询方式(0库存1流转)	*/ 
	private String queryType;

	/**
	 * 查询方式(0库存1流转)取得
	 * @return queryType
	 */
	public String getQueryType() {
		return queryType;
	}

	/**
	 * 查询方式(0库存1流转)设定
	 * @param queryType
	 */
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	/* 绑定类型(0RFID 1 激光码 2 工具盘 9 其他)	*/ 
	private String bandType;

	/**
	 * 绑定类型(0RFID 1 激光码 2 工具盘 9 其他)取得
	 * @return bandType
	 */
	public String getBandType() {
		return bandType;
	}

	/**
	 * 绑定类型(0RFID 1 激光码 2 工具盘 9 其他)设定
	 * @param bandType
	 */
	public void setBandType(String bandType) {
		this.bandType = bandType;
	}

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

	/* 	*/ 
	private BigDecimal existingNumber;

	/**
	 * 取得
	 * @return existingNumber
	 */
	public BigDecimal getexistingNumber() {
		return existingNumber;
	}

	/**
	 * 设定
	 * @param existingNumber
	 */
	public void setexistingNumber(BigDecimal existingNumber) {
		this.existingNumber = existingNumber;
	}

	/* 	*/ 
	private String toolID;

	/**
	 * 取得
	 * @return toolID
	 */
	public String getToolID() {
		return toolID;
	}

	/**
	 * 设定
	 * @param toolID
	 */
	public void setToolID(String toolID) {
		this.toolID = toolID;
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

	/* 刀具每盒数量	*/ 
	private BigDecimal toolUnitnumber;

	/**
	 * 刀具每盒数量取得
	 * @return toolUnitnumber
	 */
	public BigDecimal getToolUnitnumber() {
		return toolUnitnumber;
	}

	/**
	 * 刀具每盒数量设定
	 * @param toolUnitnumber
	 */
	public void setToolUnitnumber(BigDecimal toolUnitnumber) {
		this.toolUnitnumber = toolUnitnumber;
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
	private String libraryCode;

	/**
	 * 取得
	 * @return libraryCode
	 */
	public String getLibraryCode() {
		return libraryCode;
	}

	/**
	 * 设定
	 * @param libraryCode
	 */
	public void setLibraryCode(String libraryCode) {
		this.libraryCode = libraryCode;
	}
}

