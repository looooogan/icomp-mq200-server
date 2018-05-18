package com.icomp.wsdl.v01c02.c02s006.endpoint;


import com.icomp.common.pojo.BaseRequest;

public class C02S006Request  extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5335345126409942526L;

	/**
	 * 手持机MAC地址
	 */
	private String handMacCode;
	
	public String getHandMacCode() {
		return handMacCode;
	}

	public void setHandMacCode(String handMacCode) {
		this.handMacCode = handMacCode;
	}

	/**
	 * 部门ID
	 */
	private String departmentID;

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}
}
