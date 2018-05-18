/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/12/19 11:14:12
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/12/19 11:14:12
 * 创建者  ：杨作庆
 * 
 */
public class Vgetpositioncapability extends VgetpositioncapabilityWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 用户ID[自动生成20位字符串]	*/ 
	private String customerID;

	/**
	 * 用户ID[自动生成20位字符串]取得
	 * @return customerID
	 */
	public String getCustomerID() {
		return customerID;
	}

	/**
	 * 用户ID[自动生成20位字符串]设定
	 * @param customerID
	 */
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	/* 姓名	*/ 
	private String userName;

	/**
	 * 姓名取得
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 姓名设定
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/* 用户名[16位数字字母组合]	*/ 
	private String loginName;

	/**
	 * 用户名[16位数字字母组合]取得
	 * @return loginName
	 */
	public String getloginName() {
		return loginName;
	}

	/**
	 * 用户名[16位数字字母组合]设定
	 * @param loginName
	 */
	public void setloginName(String loginName) {
		this.loginName = loginName;
	}

	/* 职务ID	*/ 
	private String positionID;

	/**
	 * 职务ID取得
	 * @return positionID
	 */
	public String getPositionID() {
		return positionID;
	}

	/**
	 * 职务ID设定
	 * @param positionID
	 */
	public void setPositionID(String positionID) {
		this.positionID = positionID;
	}

	/* 职务编码	*/ 
	private String positionCode;

	/**
	 * 职务编码取得
	 * @return positionCode
	 */
	public String getPositionCode() {
		return positionCode;
	}

	/**
	 * 职务编码设定
	 * @param positionCode
	 */
	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	/* 职务名称	*/ 
	private String positionName;

	/**
	 * 职务名称取得
	 * @return positionName
	 */
	public String getPositionName() {
		return positionName;
	}

	/**
	 * 职务名称设定
	 * @param positionName
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

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
}

