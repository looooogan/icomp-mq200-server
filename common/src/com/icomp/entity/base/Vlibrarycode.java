/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class Vlibrarycode extends VlibrarycodeWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 库位码	*/ 
	private String systeCodeShow;

	/**
	 * 取得 库位码
	 * @return systeCodeShow
	 */
	public String getSysteCodeShow() {
		return systeCodeShow;
	}

	/**
	 * 设定 库位码
	 * @param systeCodeShow
	 */
	public void setSysteCodeShow(String systeCodeShow) {
		this.systeCodeShow = systeCodeShow;
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
}

