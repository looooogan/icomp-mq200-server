/*
 * 工具自动生成：厂外修复商家条件实体类
 * 生成时间    : 2016/04/29 15:29:28
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;



/**
 * 厂外修复商家条件实体类
 * @author 工具自动生成
 * 创建时间：2016/04/29 15:29:28
 * 创建者  ：工具自动生成
 * 
 */
public class MerchantsWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 商家ID	*/ 
	private String merchantsIDWhere;

	/**
	 * 商家ID取得
	 * @return merchantsIDWhere
	 */
	public String getMerchantsIDWhere () {
		return merchantsIDWhere;
	}

	/**
	 * 商家ID设定
	 * @param merchantsIDWhere
	 */
	public void setMerchantsIDWhere (String merchantsIDWhere) {
		this.merchantsIDWhere = merchantsIDWhere;
	}

	/* 厂家编号	*/ 
	private String merchantsColdWhere;

	/**
	 * 厂家编号取得
	 * @return merchantsColdWhere
	 */
	public String getMerchantsColdWhere () {
		return merchantsColdWhere;
	}

	/**
	 * 厂家编号设定
	 * @param merchantsColdWhere
	 */
	public void setMerchantsColdWhere (String merchantsColdWhere) {
		this.merchantsColdWhere = merchantsColdWhere;
	}

	/* 商家名称	*/ 
	private String merchantsNameWhere;

	/**
	 * 商家名称取得
	 * @return merchantsNameWhere
	 */
	public String getMerchantsNameWhere () {
		return merchantsNameWhere;
	}

	/**
	 * 商家名称设定
	 * @param merchantsNameWhere
	 */
	public void setMerchantsNameWhere (String merchantsNameWhere) {
		this.merchantsNameWhere = merchantsNameWhere;
	}

	/* 厂家类型	*/ 
	private String merchantsTypeWhere;

	/**
	 * 厂家类型取得
	 * @return merchantsTypeWhere
	 */
	public String getMerchantsTypeWhere () {
		return merchantsTypeWhere;
	}

	/**
	 * 厂家类型设定
	 * @param merchantsTypeWhere
	 */
	public void setMerchantsTypeWhere (String merchantsTypeWhere) {
		this.merchantsTypeWhere = merchantsTypeWhere;
	}

	/* 	*/ 
	private String merchantsAddrssWhere;

	/**
	 * 取得
	 * @return merchantsAddrssWhere
	 */
	public String getMerchantsAddrssWhere () {
		return merchantsAddrssWhere;
	}

	/**
	 * 设定
	 * @param merchantsAddrssWhere
	 */
	public void setMerchantsAddrssWhere (String merchantsAddrssWhere) {
		this.merchantsAddrssWhere = merchantsAddrssWhere;
	}

	/* 联系人(真实姓名)	*/ 
	private String innerNameWhere;

	/**
	 * 联系人(真实姓名)取得
	 * @return innerNameWhere
	 */
	public String getInnerNameWhere () {
		return innerNameWhere;
	}

	/**
	 * 联系人(真实姓名)设定
	 * @param innerNameWhere
	 */
	public void setInnerNameWhere (String innerNameWhere) {
		this.innerNameWhere = innerNameWhere;
	}

	/* 联系电话	*/ 
	private String merchantsTelWhere;

	/**
	 * 联系电话取得
	 * @return merchantsTelWhere
	 */
	public String getMerchantsTelWhere () {
		return merchantsTelWhere;
	}

	/**
	 * 联系电话设定
	 * @param merchantsTelWhere
	 */
	public void setMerchantsTelWhere (String merchantsTelWhere) {
		this.merchantsTelWhere = merchantsTelWhere;
	}
}

