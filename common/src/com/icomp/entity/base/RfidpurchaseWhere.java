/*
 * 工具自动生成：标签采购条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * 标签采购条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class RfidpurchaseWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 	*/ 
	private String rfidPurchaseIDWhere;

	/**
	 * 取得
	 * @return rfidPurchaseIDWhere
	 */
	public String getRfidPurchaseIDWhere () {
		return rfidPurchaseIDWhere;
	}

	/**
	 * 设定
	 * @param rfidPurchaseIDWhere
	 */
	public void setRfidPurchaseIDWhere (String rfidPurchaseIDWhere) {
		this.rfidPurchaseIDWhere = rfidPurchaseIDWhere;
	}

	/* 采购数量	*/ 
	private BigDecimal purchaseCountWhere;

	/**
	 * 采购数量取得
	 * @return purchaseCountWhere
	 */
	public BigDecimal getPurchaseCountWhere () {
		return purchaseCountWhere;
	}

	/**
	 * 采购数量设定
	 * @param purchaseCountWhere
	 */
	public void setPurchaseCountWhere (BigDecimal purchaseCountWhere) {
		this.purchaseCountWhere = purchaseCountWhere;
	}

	/* 采购人	*/ 
	private String purchaseUserWhere;

	/**
	 * 采购人取得
	 * @return purchaseUserWhere
	 */
	public String getPurchaseUserWhere () {
		return purchaseUserWhere;
	}

	/**
	 * 采购人设定
	 * @param purchaseUserWhere
	 */
	public void setPurchaseUserWhere (String purchaseUserWhere) {
		this.purchaseUserWhere = purchaseUserWhere;
	}

	/* 剩余数量	*/ 
	private BigDecimal balanceWhere;

	/**
	 * 剩余数量取得
	 * @return balanceWhere
	 */
	public BigDecimal getBalanceWhere () {
		return balanceWhere;
	}

	/**
	 * 剩余数量设定
	 * @param balanceWhere
	 */
	public void setBalanceWhere (BigDecimal balanceWhere) {
		this.balanceWhere = balanceWhere;
	}

	/* 使用中	*/ 
	private BigDecimal usingCountWhere;

	/**
	 * 使用中取得
	 * @return usingCountWhere
	 */
	public BigDecimal getUsingCountWhere () {
		return usingCountWhere;
	}

	/**
	 * 使用中设定
	 * @param usingCountWhere
	 */
	public void setUsingCountWhere (BigDecimal usingCountWhere) {
		this.usingCountWhere = usingCountWhere;
	}
}

