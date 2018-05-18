package com.icomp.wsdl.v01c01.c01s002.endpoint;


import com.icomp.common.pojo.BaseRespons;

public class C01S002Respons extends BaseRespons {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3141031861267681716L;
		
	/* 授权用户ID*/
	private String authorizedUsersID;

	public String getAuthorizedUsersID() {
		return authorizedUsersID;
	}

	public void setAuthorizedUsersID(String authorizedUsersID) {
		this.authorizedUsersID = authorizedUsersID;
	}

}
