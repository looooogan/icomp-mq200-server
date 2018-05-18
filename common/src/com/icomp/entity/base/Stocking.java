/*
 * 工具自动生成：库存盘点实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 库存盘点实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class Stocking extends StockingWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 	*/ 
	private String stockingID;

	/**
	 * 取得
	 * @return stockingID
	 */
	public String getStockingID() {
		return stockingID;
	}

	/**
	 * 设定
	 * @param stockingID
	 */
	public void setStockingID(String stockingID) {
		this.stockingID = stockingID;
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

	/* 盘点时间	*/ 
	private Date checkTime;

	/**
	 * 盘点时间取得
	 * @return checkTime
	 */
	public Date getCheckTime() {
		return checkTime;
	}

	/**
	 * 盘点时间设定
	 * @param checkTime
	 */
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	/* 盘点人	*/ 
	private String checkUser;

	/**
	 * 盘点人取得
	 * @return checkUser
	 */
	public String getCheckUser() {
		return checkUser;
	}

	/**
	 * 盘点人设定
	 * @param checkUser
	 */
	public void setCheckUser(String checkUser) {
		this.checkUser = checkUser;
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

	/* 批次	*/ 
	private String procuredBatch;

	/**
	 * 批次取得
	 * @return procuredBatch
	 */
	public String getProcuredBatch() {
		return procuredBatch;
	}

	/**
	 * 批次设定
	 * @param procuredBatch
	 */
	public void setProcuredBatch(String procuredBatch) {
		this.procuredBatch = procuredBatch;
	}

	/* 应在库数量	*/ 
	private BigDecimal libraryCount;

	/**
	 * 应在库数量取得
	 * @return libraryCount
	 */
	public BigDecimal getLibraryCount() {
		return libraryCount;
	}

	/**
	 * 应在库数量设定
	 * @param libraryCount
	 */
	public void setLibraryCount(BigDecimal libraryCount) {
		this.libraryCount = libraryCount;
	}

	/* 实际在库数量	*/ 
	private BigDecimal realLibraryCount;

	/**
	 * 实际在库数量取得
	 * @return realLibraryCount
	 */
	public BigDecimal getRealLibraryCount() {
		return realLibraryCount;
	}

	/**
	 * 实际在库数量设定
	 * @param realLibraryCount
	 */
	public void setRealLibraryCount(BigDecimal realLibraryCount) {
		this.realLibraryCount = realLibraryCount;
	}

	/* 单价	*/ 
	private BigDecimal unitPrice;

	/**
	 * 单价取得
	 * @return unitPrice
	 */
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	/**
	 * 单价设定
	 * @param unitPrice
	 */
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	/* 在库金额	*/ 
	private BigDecimal baseAmount;

	/**
	 * 在库金额取得
	 * @return baseAmount
	 */
	public BigDecimal getBaseAmount() {
		return baseAmount;
	}

	/**
	 * 在库金额设定
	 * @param baseAmount
	 */
	public void setBaseAmount(BigDecimal baseAmount) {
		this.baseAmount = baseAmount;
	}

	/* 授权人(盘点出现盘亏盘盈授权)	*/ 
	private String removeUser;

	/**
	 * 授权人(盘点出现盘亏盘盈授权)取得
	 * @return removeUser
	 */
	public String getRemoveUser() {
		return removeUser;
	}

	/**
	 * 授权人(盘点出现盘亏盘盈授权)设定
	 * @param removeUser
	 */
	public void setRemoveUser(String removeUser) {
		this.removeUser = removeUser;
	}

	/* 操作人	*/ 
	private String systemLogUser;

	/**
	 * 操作人取得
	 * @return systemLogUser
	 */
	public String getSystemLogUser() {
		return systemLogUser;
	}

	/**
	 * 操作人设定
	 * @param systemLogUser
	 */
	public void setSystemLogUser(String systemLogUser) {
		this.systemLogUser = systemLogUser;
	}
}

