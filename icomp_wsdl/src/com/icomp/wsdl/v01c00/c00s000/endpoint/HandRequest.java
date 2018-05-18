package com.icomp.wsdl.v01c00.c00s000.endpoint;

import com.icomp.common.pojo.BaseRequest;

public class HandRequest  extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9135933644086020064L;

	private String handMacCode;

	public String getHandMacCode() {
		return handMacCode;
	}

	public void setHandMacCode(String handMacCode) {
		this.handMacCode = handMacCode;
	}
}