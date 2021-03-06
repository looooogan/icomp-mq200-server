/*
 * 工具自动生成：系统显示项目配置(兼顾打印项目)条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * 系统显示项目配置(兼顾打印项目)条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class DisplayeditemconfigurationWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 	*/ 
	private String displayedItemConfigurationIDWhere;

	/**
	 * 取得
	 * @return displayedItemConfigurationIDWhere
	 */
	public String getDisplayedItemConfigurationIDWhere () {
		return displayedItemConfigurationIDWhere;
	}

	/**
	 * 设定
	 * @param displayedItemConfigurationIDWhere
	 */
	public void setDisplayedItemConfigurationIDWhere (String displayedItemConfigurationIDWhere) {
		this.displayedItemConfigurationIDWhere = displayedItemConfigurationIDWhere;
	}

	/* 项目类别(0手持机1平台2打印项目)	*/ 
	private String itemTypeWhere;

	/**
	 * 项目类别(0手持机1平台2打印项目)取得
	 * @return itemTypeWhere
	 */
	public String getItemTypeWhere () {
		return itemTypeWhere;
	}

	/**
	 * 项目类别(0手持机1平台2打印项目)设定
	 * @param itemTypeWhere
	 */
	public void setItemTypeWhere (String itemTypeWhere) {
		this.itemTypeWhere = itemTypeWhere;
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

	/* 页面名称	*/ 
	private String pageNameWhere;

	/**
	 * 页面名称取得
	 * @return pageNameWhere
	 */
	public String getPageNameWhere () {
		return pageNameWhere;
	}

	/**
	 * 页面名称设定
	 * @param pageNameWhere
	 */
	public void setPageNameWhere (String pageNameWhere) {
		this.pageNameWhere = pageNameWhere;
	}

	/* 项目名称	*/ 
	private String colNameWhere;

	/**
	 * 项目名称取得
	 * @return colNameWhere
	 */
	public String getColNameWhere () {
		return colNameWhere;
	}

	/**
	 * 项目名称设定
	 * @param colNameWhere
	 */
	public void setColNameWhere (String colNameWhere) {
		this.colNameWhere = colNameWhere;
	}

	/* 是否显示(0显示1不显示)	*/ 
	private String displayedFlagWhere;

	/**
	 * 是否显示(0显示1不显示)取得
	 * @return displayedFlagWhere
	 */
	public String getDisplayedFlagWhere () {
		return displayedFlagWhere;
	}

	/**
	 * 是否显示(0显示1不显示)设定
	 * @param displayedFlagWhere
	 */
	public void setDisplayedFlagWhere (String displayedFlagWhere) {
		this.displayedFlagWhere = displayedFlagWhere;
	}

	/* 项目文本	*/ 
	private String itemTextWhere;

	/**
	 * 项目文本取得
	 * @return itemTextWhere
	 */
	public String getItemTextWhere () {
		return itemTextWhere;
	}

	/**
	 * 项目文本设定
	 * @param itemTextWhere
	 */
	public void setItemTextWhere (String itemTextWhere) {
		this.itemTextWhere = itemTextWhere;
	}
}

