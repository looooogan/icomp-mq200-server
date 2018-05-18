package com.icomp.wsdl.v01c00.c00s000.endpoint;

import java.math.BigDecimal;

import com.icomp.common.pojo.BaseRequest;

public class MenuRequest  extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -237409796490070376L;

	/* 用户名[16位数字字母组合]	*/ 
	private String userName;

	/**
	 * 用户名[16位数字字母组合]取得
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 用户名[16位数字字母组合]设定
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/* 功能级别  */
	private BigDecimal capabilityLevel;

	public BigDecimal getCapabilityLevel() {
		return capabilityLevel;
	}

	public void setCapabilityLevel(BigDecimal capabilityLevel) {
		this.capabilityLevel = capabilityLevel;
	}
	
	/* 父功能ID  */
	private String capCapabilityID;

	public String getCapCapabilityID() {
		return capCapabilityID;
	}

	public void setCapCapabilityID(String capCapabilityID) {
		this.capCapabilityID = capCapabilityID;
	}
	
}
