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
public class Vdisplayeditemconfiguration extends VdisplayeditemconfigurationWhere implements Serializable {

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

	/* 	*/ 
	private String displayeditemconfigurationID;

	/**
	 * 取得
	 * @return displayeditemconfigurationID
	 */
	public String getdisplayeditemconfigurationID() {
		return displayeditemconfigurationID;
	}

	/**
	 * 设定
	 * @param displayeditemconfigurationID
	 */
	public void setdisplayeditemconfigurationID(String displayeditemconfigurationID) {
		this.displayeditemconfigurationID = displayeditemconfigurationID;
	}

	/* 项目类别(0手持机1平台2打印项目)	*/ 
	private String itemType;

	/**
	 * 项目类别(0手持机1平台2打印项目)取得
	 * @return itemType
	 */
	public String getItemType() {
		return itemType;
	}

	/**
	 * 项目类别(0手持机1平台2打印项目)设定
	 * @param itemType
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	/* 页面名称	*/ 
	private String pageName;

	/**
	 * 页面名称取得
	 * @return pageName
	 */
	public String getPageName() {
		return pageName;
	}

	/**
	 * 页面名称设定
	 * @param pageName
	 */
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	/* 项目名称	*/ 
	private String colName;

	/**
	 * 项目名称取得
	 * @return colName
	 */
	public String getColName() {
		return colName;
	}

	/**
	 * 项目名称设定
	 * @param colName
	 */
	public void setColName(String colName) {
		this.colName = colName;
	}

	/* 是否显示(0显示1不显示)	*/ 
	private String displayedFlag;

	/**
	 * 是否显示(0显示1不显示)取得
	 * @return displayedFlag
	 */
	public String getDisplayedFlag() {
		return displayedFlag;
	}

	/**
	 * 是否显示(0显示1不显示)设定
	 * @param displayedFlag
	 */
	public void setDisplayedFlag(String displayedFlag) {
		this.displayedFlag = displayedFlag;
	}

	/* 项目文本	*/ 
	private String itemText;

	/**
	 * 项目文本取得
	 * @return itemText
	 */
	public String getItemText() {
		return itemText;
	}

	/**
	 * 项目文本设定
	 * @param itemText
	 */
	public void setItemText(String itemText) {
		this.itemText = itemText;
	}
}

