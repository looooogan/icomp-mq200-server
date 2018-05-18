package com.icomp.wsdl.v01c01.c01s002.endpoint;

import com.icomp.common.pojo.BaseRequest;

public class C01S002Request extends BaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2899122586795753449L;
	
	
	/* 用户ID*/
	private String customerID;

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	/* RFID（员工卡）*/
	private String rfidCode;

	public String getRfidCode() {
		return rfidCode;
	}

	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}
	
	/* 用户名*/
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/* 密码*/
	private String userPass;

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
	/* 授权原因*/
	private String authorizedReason;

	public String getAuthorizedReason() {
		return authorizedReason;
	}

	public void setAuthorizedReason(String authorizedReason) {
		this.authorizedReason = authorizedReason;
	}
	
	/* 刀具ID*/
	private String toolID;

	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}
	
	/* 流程ID*/
	private String businessID;

	public String getBusinessID() {
		return businessID;
	}

	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}
	
	/* 授权类型(0:登陆;1:扫描)*/
	private String authorizedType;

	public String getAuthorizedType() {
		return authorizedType;
	}

	public void setAuthorizedType(String authorizedType) {
		this.authorizedType = authorizedType;
	}
	
}
