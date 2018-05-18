/*
 * 工具自动生成：功能条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * 功能条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class CapabilityWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 功能ID	*/ 
	private String capabilityIDWhere;

	/**
	 * 功能ID取得
	 * @return capabilityIDWhere
	 */
	public String getCapabilityIDWhere () {
		return capabilityIDWhere;
	}

	/**
	 * 功能ID设定
	 * @param capabilityIDWhere
	 */
	public void setCapabilityIDWhere (String capabilityIDWhere) {
		this.capabilityIDWhere = capabilityIDWhere;
	}

	/* 上级功能ID	*/ 
	private String capCapabilityIDWhere;

	/**
	 * 上级功能ID取得
	 * @return capCapabilityIDWhere
	 */
	public String getCapCapabilityIDWhere () {
		return capCapabilityIDWhere;
	}

	/**
	 * 上级功能ID设定
	 * @param capCapabilityIDWhere
	 */
	public void setCapCapabilityIDWhere (String capCapabilityIDWhere) {
		this.capCapabilityIDWhere = capCapabilityIDWhere;
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

	/* 功能编码	*/ 
	private String capabilityCodeWhere;

	/**
	 * 功能编码取得
	 * @return capabilityCodeWhere
	 */
	public String getCapabilityCodeWhere () {
		return capabilityCodeWhere;
	}

	/**
	 * 功能编码设定
	 * @param capabilityCodeWhere
	 */
	public void setCapabilityCodeWhere (String capabilityCodeWhere) {
		this.capabilityCodeWhere = capabilityCodeWhere;
	}

	/* 功能名称	*/ 
	private String capabilityNameWhere;

	/**
	 * 功能名称取得
	 * @return capabilityNameWhere
	 */
	public String getCapabilityNameWhere () {
		return capabilityNameWhere;
	}

	/**
	 * 功能名称设定
	 * @param capabilityNameWhere
	 */
	public void setCapabilityNameWhere (String capabilityNameWhere) {
		this.capabilityNameWhere = capabilityNameWhere;
	}

	/* 功能级别	*/ 
	private BigDecimal capabilityLevelWhere;

	/**
	 * 功能级别取得
	 * @return capabilityLevelWhere
	 */
	public BigDecimal getCapabilityLevelWhere () {
		return capabilityLevelWhere;
	}

	/**
	 * 功能级别设定
	 * @param capabilityLevelWhere
	 */
	public void setCapabilityLevelWhere (BigDecimal capabilityLevelWhere) {
		this.capabilityLevelWhere = capabilityLevelWhere;
	}

	/* 功能顺序	*/ 
	private BigDecimal capabilityOrderWhere;

	/**
	 * 功能顺序取得
	 * @return capabilityOrderWhere
	 */
	public BigDecimal getCapabilityOrderWhere () {
		return capabilityOrderWhere;
	}

	/**
	 * 功能顺序设定
	 * @param capabilityOrderWhere
	 */
	public void setCapabilityOrderWhere (BigDecimal capabilityOrderWhere) {
		this.capabilityOrderWhere = capabilityOrderWhere;
	}

	/* 功能URL	*/ 
	private String capabilityUrlWhere;

	/**
	 * 功能URL取得
	 * @return capabilityUrlWhere
	 */
	public String getCapabilityUrlWhere () {
		return capabilityUrlWhere;
	}

	/**
	 * 功能URL设定
	 * @param capabilityUrlWhere
	 */
	public void setCapabilityUrlWhere (String capabilityUrlWhere) {
		this.capabilityUrlWhere = capabilityUrlWhere;
	}

	/* 功能图片	*/ 
	private String capabilityImgWhere;

	/**
	 * 功能图片取得
	 * @return capabilityImgWhere
	 */
	public String getCapabilityImgWhere () {
		return capabilityImgWhere;
	}

	/**
	 * 功能图片设定
	 * @param capabilityImgWhere
	 */
	public void setCapabilityImgWhere (String capabilityImgWhere) {
		this.capabilityImgWhere = capabilityImgWhere;
	}

	/* 归属区分(0:管理平台1:手持机9:手持机授权)	*/ 
	private String belongFlagWhere;

	/**
	 * 归属区分(0:管理平台1:手持机9:手持机授权)取得
	 * @return belongFlagWhere
	 */
	public String getBelongFlagWhere () {
		return belongFlagWhere;
	}

	/**
	 * 归属区分(0:管理平台1:手持机9:手持机授权)设定
	 * @param belongFlagWhere
	 */
	public void setBelongFlagWhere (String belongFlagWhere) {
		this.belongFlagWhere = belongFlagWhere;
	}

	/* 是否菜单(0是1否)	*/ 
	private String menuFlagWhere;

	/**
	 * 是否菜单(0是1否)取得
	 * @return menuFlagWhere
	 */
	public String getMenuFlagWhere () {
		return menuFlagWhere;
	}

	/**
	 * 是否菜单(0是1否)设定
	 * @param menuFlagWhere
	 */
	public void setMenuFlagWhere (String menuFlagWhere) {
		this.menuFlagWhere = menuFlagWhere;
	}
}

