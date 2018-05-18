/*
 * 工具自动生成：语言实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * 语言实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class Languagetable extends LanguagetableWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 语言值	*/ 
	private String languageValue;

	/**
	 * 语言值取得
	 * @return languageValue
	 */
	public String getLanguageValue() {
		return languageValue;
	}

	/**
	 * 语言值设定
	 * @param languageValue
	 */
	public void setLanguageValue(String languageValue) {
		this.languageValue = languageValue;
	}

	/* 语言名称	*/ 
	private String languageName;

	/**
	 * 语言名称取得
	 * @return languageName
	 */
	public String getLanguageName() {
		return languageName;
	}

	/**
	 * 语言名称设定
	 * @param languageName
	 */
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
}

