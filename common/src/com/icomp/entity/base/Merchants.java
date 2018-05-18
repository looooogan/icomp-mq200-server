/*
 * 工具自动生成：厂外修复商家实体类
 * 生成时间    : 2016/04/29 15:29:28
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * 厂外修复商家实体类
 * @author 工具自动生成
 * 创建时间：2016/04/29 15:29:28
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Merchants extends MerchantsWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 商家ID	*/ 
	private String merchantsID;

	/**
	 * 商家ID取得
	 * @return merchantsID
	 */
	public String getMerchantsID() {
		return merchantsID;
	}

	/**
	 * 商家ID设定
	 * @param merchantsID
	 */
	public void setMerchantsID(String merchantsID) {
		this.merchantsID = merchantsID;
	}

	/* 厂家编号	*/ 
	private String merchantsCold;

	/**
	 * 厂家编号取得
	 * @return merchantsCold
	 */
	public String getMerchantsCold() {
		return merchantsCold;
	}

	/**
	 * 厂家编号设定
	 * @param merchantsCold
	 */
	public void setMerchantsCold(String merchantsCold) {
		this.merchantsCold = merchantsCold;
	}

	/* 商家名称	*/ 
	private String merchantsName;

	/**
	 * 商家名称取得
	 * @return merchantsName
	 */
	public String getMerchantsName() {
		return merchantsName;
	}

	/**
	 * 商家名称设定
	 * @param merchantsName
	 */
	public void setMerchantsName(String merchantsName) {
		this.merchantsName = merchantsName;
	}

	/* 厂家类型	*/ 
	private String merchantsType;

	/**
	 * 厂家类型取得
	 * @return merchantsType
	 */
	public String getMerchantsType() {
		return merchantsType;
	}

	/**
	 * 厂家类型设定
	 * @param merchantsType
	 */
	public void setMerchantsType(String merchantsType) {
		this.merchantsType = merchantsType;
	}

	/* 	*/ 
	private String merchantsAddrss;

	/**
	 * 取得
	 * @return merchantsAddrss
	 */
	public String getMerchantsAddrss() {
		return merchantsAddrss;
	}

	/**
	 * 设定厂家地址
	 * @param merchantsAddrss
	 */
	public void setMerchantsAddrss(String merchantsAddrss) {
		this.merchantsAddrss = merchantsAddrss;
	}

	/* 联系人(真实姓名)	*/ 
	private String innerName;

	/**
	 * 联系人(真实姓名)取得
	 * @return innerName
	 */
	public String getInnerName() {
		return innerName;
	}

	/**
	 * 联系人(真实姓名)设定
	 * @param innerName
	 */
	public void setInnerName(String innerName) {
		this.innerName = innerName;
	}

	/* 联系电话	*/ 
	private String merchantsTel;

	/**
	 * 联系电话取得
	 * @return merchantsTel
	 */
	public String getMerchantsTel() {
		return merchantsTel;
	}

	/**
	 * 联系电话设定
	 * @param merchantsTel
	 */
	public void setMerchantsTel(String merchantsTel) {
		this.merchantsTel = merchantsTel;
	}
}

