/*
 * 工具自动生成：系统条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * 系统条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class SystemWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* SystemID	*/ 
	private String systemIDWhere;

	/**
	 * SystemID取得
	 * @return systemIDWhere
	 */
	public String getSystemIDWhere () {
		return systemIDWhere;
	}

	/**
	 * SystemID设定
	 * @param systemIDWhere
	 */
	public void setSystemIDWhere (String systemIDWhere) {
		this.systemIDWhere = systemIDWhere;
	}

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

	/* 系统编码	*/ 
	private String systemCodeWhere;

	/**
	 * 系统编码取得
	 * @return systemCodeWhere
	 */
	public String getSystemCodeWhere () {
		return systemCodeWhere;
	}

	/**
	 * 系统编码设定
	 * @param systemCodeWhere
	 */
	public void setSystemCodeWhere (String systemCodeWhere) {
		this.systemCodeWhere = systemCodeWhere;
	}

	/* 系统名称	*/ 
	private String systemNameWhere;

	/**
	 * 系统名称取得
	 * @return systemNameWhere
	 */
	public String getSystemNameWhere () {
		return systemNameWhere;
	}

	/**
	 * 系统名称设定
	 * @param systemNameWhere
	 */
	public void setSystemNameWhere (String systemNameWhere) {
		this.systemNameWhere = systemNameWhere;
	}
}

