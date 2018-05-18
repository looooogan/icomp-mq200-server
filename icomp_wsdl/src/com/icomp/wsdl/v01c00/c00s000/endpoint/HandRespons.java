package com.icomp.wsdl.v01c00.c00s000.endpoint;

import com.icomp.common.pojo.BaseRespons;

public class HandRespons  extends BaseRespons {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3000956214255332730L;

	/* 手持机是否注册 true：是 false：否 */
	private boolean handFlag;

	public boolean isHandFlag() {
		return handFlag;
	}

	public void setHandFlag(boolean handFlag) {
		this.handFlag = handFlag;
	} 

	private String handsetID;

	public String getHandsetID() {
		return handsetID;
	}

	public void setHandsetID(String handsetID) {
		this.handsetID = handsetID;
	}
	
	//手持机是否需要多次登录
	private String loginStauts;

	public String getLoginStauts() {
		return loginStauts;
	}

	public void setLoginStauts(String loginStauts) {
		this.loginStauts = loginStauts;
	}
	
}
