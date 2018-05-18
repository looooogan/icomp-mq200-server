/*
 * 工具自动生成：系统实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * 系统实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class System extends SystemWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* SystemID	*/ 
	private String systemID;

	/**
	 * SystemID取得
	 * @return systemID
	 */
	public String getSystemID() {
		return systemID;
	}

	/**
	 * SystemID设定
	 * @param systemID
	 */
	public void setSystemID(String systemID) {
		this.systemID = systemID;
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

	/* 系统编码	*/ 
	private String systemCode;

	/**
	 * 系统编码取得
	 * @return systemCode
	 */
	public String getSystemCode() {
		return systemCode;
	}

	/**
	 * 系统编码设定
	 * @param systemCode
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	/* 系统名称	*/ 
	private String systemName;

	/**
	 * 系统名称取得
	 * @return systemName
	 */
	public String getSystemName() {
		return systemName;
	}

	/**
	 * 系统名称设定
	 * @param systemName
	 */
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
}

