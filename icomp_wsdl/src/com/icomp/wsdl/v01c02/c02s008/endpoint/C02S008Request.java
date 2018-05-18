package com.icomp.wsdl.v01c02.c02s008.endpoint;

import com.icomp.common.pojo.BaseRequest;

public class C02S008Request  extends BaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4841825285010503646L;

	private String userName;
	private String employeeCard;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmployeeCard() {
		return employeeCard;
	}
	public void setEmployeeCard(String employeeCard) {
		this.employeeCard = employeeCard;
	}

}
