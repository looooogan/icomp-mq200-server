/*
 * 工具自动生成：语言条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * 语言条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class LanguagetableWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 语言编码	*/ 
	private String languageCodeWhere;

	/**
	 * 语言编码取得
	 * @return languageCodeWhere
	 */
	public String getLanguageCodeWhere () {
		return languageCodeWhere;
	}

	/**
	 * 语言编码设定
	 * @param languageCodeWhere
	 */
	public void setLanguageCodeWhere (String languageCodeWhere) {
		this.languageCodeWhere = languageCodeWhere;
	}

	/* 语言值	*/ 
	private String languageValueWhere;

	/**
	 * 语言值取得
	 * @return languageValueWhere
	 */
	public String getLanguageValueWhere () {
		return languageValueWhere;
	}

	/**
	 * 语言值设定
	 * @param languageValueWhere
	 */
	public void setLanguageValueWhere (String languageValueWhere) {
		this.languageValueWhere = languageValueWhere;
	}

	/* 语言名称	*/ 
	private String languageNameWhere;

	/**
	 * 语言名称取得
	 * @return languageNameWhere
	 */
	public String getLanguageNameWhere () {
		return languageNameWhere;
	}

	/**
	 * 语言名称设定
	 * @param languageNameWhere
	 */
	public void setLanguageNameWhere (String languageNameWhere) {
		this.languageNameWhere = languageNameWhere;
	}
}

