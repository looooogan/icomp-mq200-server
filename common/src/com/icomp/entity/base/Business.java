/*
 * 工具自动生成：业务流程实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * 业务流程实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class Business extends BusinessWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 业务流程ID	*/ 
	private String businessID;

	/**
	 * 业务流程ID取得
	 * @return businessID
	 */
	public String getBusinessID() {
		return businessID;
	}

	/**
	 * 业务流程ID设定
	 * @param businessID
	 */
	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}

	/* 业务流编码	*/ 
	private String businessCode;

	/**
	 * 业务流编码取得
	 * @return businessCode
	 */
	public String getBusinessCode() {
		return businessCode;
	}

	/**
	 * 业务流编码设定
	 * @param businessCode
	 */
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	/* 业务流程名	*/ 
	private String businessName;

	/**
	 * 业务流程名取得
	 * @return businessName
	 */
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * 业务流程名设定
	 * @param businessName
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/* 语言编码	*/ 
	private String languageCode;

	/**
	 * 语言编码取得
	 * @return languageCode
	 */
	public String getLanguageCode() {
		return languageCode;
	}

	/**
	 * 语言编码设定
	 * @param languageCode
	 */
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
}

