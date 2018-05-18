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
public class Vcomlist extends VcomlistWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* ComlistID	*/ 
	private String comlistID;

	/**
	 * ComlistID取得
	 * @return comlistID
	 */
	public String getComlistID() {
		return comlistID;
	}

	/**
	 * ComlistID设定
	 * @param comlistID
	 */
	public void setComlistID(String comlistID) {
		this.comlistID = comlistID;
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

	/* 区分类型	*/ 
	private String comListType;

	/**
	 * 区分类型取得
	 * @return comListType
	 */
	public String getComListType() {
		return comListType;
	}

	/**
	 * 区分类型设定
	 * @param comListType
	 */
	public void setComListType(String comListType) {
		this.comListType = comListType;
	}

	/* 区分值	*/ 
	private String comListValue;

	/**
	 * 区分值取得
	 * @return comListValue
	 */
	public String getComListValue() {
		return comListValue;
	}

	/**
	 * 区分值设定
	 * @param comListValue
	 */
	public void setComListValue(String comListValue) {
		this.comListValue = comListValue;
	}

	/* 区分文本	*/ 
	private String comListText;

	/**
	 * 区分文本取得
	 * @return comListText
	 */
	public String getComListText() {
		return comListText;
	}

	/**
	 * 区分文本设定
	 * @param comListText
	 */
	public void setComListText(String comListText) {
		this.comListText = comListText;
	}

	/* 区分描述	*/ 
	private String comListMs;

	/**
	 * 区分描述取得
	 * @return comListMs
	 */
	public String getComListMs() {
		return comListMs;
	}

	/**
	 * 区分描述设定
	 * @param comListMs
	 */
	public void setComListMs(String comListMs) {
		this.comListMs = comListMs;
	}

	/* 是否可以修改(0是1否)	*/ 
	private String editFlag;

	/**
	 * 是否可以修改(0是1否)取得
	 * @return editFlag
	 */
	public String getEditFlag() {
		return editFlag;
	}

	/**
	 * 是否可以修改(0是1否)设定
	 * @param editFlag
	 */
	public void setEditFlag(String editFlag) {
		this.editFlag = editFlag;
	}
}

