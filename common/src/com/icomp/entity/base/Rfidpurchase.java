/*
 * 工具自动生成：标签采购实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 标签采购实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class Rfidpurchase extends RfidpurchaseWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 	*/ 
	private String rfidPurchaseID;

	/**
	 * 取得
	 * @return rfidPurchaseID
	 */
	public String getRfidPurchaseID() {
		return rfidPurchaseID;
	}

	/**
	 * 设定
	 * @param rfidPurchaseID
	 */
	public void setRfidPurchaseID(String rfidPurchaseID) {
		this.rfidPurchaseID = rfidPurchaseID;
	}

	/* 采购数量	*/ 
	private BigDecimal purchaseCount;

	/**
	 * 采购数量取得
	 * @return purchaseCount
	 */
	public BigDecimal getPurchaseCount() {
		return purchaseCount;
	}

	/**
	 * 采购数量设定
	 * @param purchaseCount
	 */
	public void setPurchaseCount(BigDecimal purchaseCount) {
		this.purchaseCount = purchaseCount;
	}

	/* 采购人	*/ 
	private String purchaseUser;

	/**
	 * 采购人取得
	 * @return purchaseUser
	 */
	public String getPurchaseUser() {
		return purchaseUser;
	}

	/**
	 * 采购人设定
	 * @param purchaseUser
	 */
	public void setPurchaseUser(String purchaseUser) {
		this.purchaseUser = purchaseUser;
	}

	/* 剩余数量	*/ 
	private BigDecimal balance;

	/**
	 * 剩余数量取得
	 * @return balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * 剩余数量设定
	 * @param balance
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	/* 使用中	*/ 
	private BigDecimal usingCount;

	/**
	 * 使用中取得
	 * @return usingCount
	 */
	public BigDecimal getUsingCount() {
		return usingCount;
	}

	/**
	 * 使用中设定
	 * @param usingCount
	 */
	public void setUsingCount(BigDecimal usingCount) {
		this.usingCount = usingCount;
	}
}

