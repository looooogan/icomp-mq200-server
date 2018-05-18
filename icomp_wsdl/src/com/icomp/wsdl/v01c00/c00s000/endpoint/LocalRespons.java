package com.icomp.wsdl.v01c00.c00s000.endpoint;

import com.icomp.common.pojo.BaseRespons;

public class LocalRespons  extends BaseRespons {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3035796273029384677L;
	
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
