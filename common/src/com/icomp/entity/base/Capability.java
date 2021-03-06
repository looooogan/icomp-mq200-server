/*
 * 工具自动生成：功能实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 功能实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class Capability extends CapabilityWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 功能ID	*/ 
	private String capabilityID;

	/**
	 * 功能ID取得
	 * @return capabilityID
	 */
	public String getCapabilityID() {
		return capabilityID;
	}

	/**
	 * 功能ID设定
	 * @param capabilityID
	 */
	public void setCapabilityID(String capabilityID) {
		this.capabilityID = capabilityID;
	}

	/* 上级功能ID	*/ 
	private String capCapabilityID;

	/**
	 * 上级功能ID取得
	 * @return capCapabilityID
	 */
	public String getCapCapabilityID() {
		return capCapabilityID;
	}

	/**
	 * 上级功能ID设定
	 * @param capCapabilityID
	 */
	public void setCapCapabilityID(String capCapabilityID) {
		this.capCapabilityID = capCapabilityID;
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

	/* 功能编码	*/ 
	private String capabilityCode;

	/**
	 * 功能编码取得
	 * @return capabilityCode
	 */
	public String getCapabilityCode() {
		return capabilityCode;
	}

	/**
	 * 功能编码设定
	 * @param capabilityCode
	 */
	public void setCapabilityCode(String capabilityCode) {
		this.capabilityCode = capabilityCode;
	}

	/* 功能名称	*/ 
	private String capabilityName;

	/**
	 * 功能名称取得
	 * @return capabilityName
	 */
	public String getCapabilityName() {
		return capabilityName;
	}

	/**
	 * 功能名称设定
	 * @param capabilityName
	 */
	public void setCapabilityName(String capabilityName) {
		this.capabilityName = capabilityName;
	}

	/* 功能级别	*/ 
	private BigDecimal capabilityLevel;

	/**
	 * 功能级别取得
	 * @return capabilityLevel
	 */
	public BigDecimal getCapabilityLevel() {
		return capabilityLevel;
	}

	/**
	 * 功能级别设定
	 * @param capabilityLevel
	 */
	public void setCapabilityLevel(BigDecimal capabilityLevel) {
		this.capabilityLevel = capabilityLevel;
	}

	/* 功能顺序	*/ 
	private BigDecimal capabilityOrder;

	/**
	 * 功能顺序取得
	 * @return capabilityOrder
	 */
	public BigDecimal getCapabilityOrder() {
		return capabilityOrder;
	}

	/**
	 * 功能顺序设定
	 * @param capabilityOrder
	 */
	public void setCapabilityOrder(BigDecimal capabilityOrder) {
		this.capabilityOrder = capabilityOrder;
	}

	/* 功能URL	*/ 
	private String capabilityUrl;

	/**
	 * 功能URL取得
	 * @return capabilityUrl
	 */
	public String getCapabilityUrl() {
		return capabilityUrl;
	}

	/**
	 * 功能URL设定
	 * @param capabilityUrl
	 */
	public void setCapabilityUrl(String capabilityUrl) {
		this.capabilityUrl = capabilityUrl;
	}

	/* 功能图片	*/ 
	private String capabilityImg;

	/**
	 * 功能图片取得
	 * @return capabilityImg
	 */
	public String getCapabilityImg() {
		return capabilityImg;
	}

	/**
	 * 功能图片设定
	 * @param capabilityImg
	 */
	public void setCapabilityImg(String capabilityImg) {
		this.capabilityImg = capabilityImg;
	}

	/* 归属区分(0:管理平台1:手持机9:手持机授权)	*/ 
	private String belongFlag;

	/**
	 * 归属区分(0:管理平台1:手持机9:手持机授权)取得
	 * @return belongFlag
	 */
	public String getBelongFlag() {
		return belongFlag;
	}

	/**
	 * 归属区分(0:管理平台1:手持机9:手持机授权)设定
	 * @param belongFlag
	 */
	public void setBelongFlag(String belongFlag) {
		this.belongFlag = belongFlag;
	}

	/* 是否菜单(0是1否)	*/ 
	private String menuFlag;

	/**
	 * 是否菜单(0是1否)取得
	 * @return menuFlag
	 */
	public String getMenuFlag() {
		return menuFlag;
	}

	/**
	 * 是否菜单(0是1否)设定
	 * @param menuFlag
	 */
	public void setMenuFlag(String menuFlag) {
		this.menuFlag = menuFlag;
	}
}

