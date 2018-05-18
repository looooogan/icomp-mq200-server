package com.icomp.wsdl.v01c01.c01s003.endpoint;

import java.io.Serializable;

public class LedPlaneUser implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7285465152885552106L;
	private String userName;
	private String userID;
	
	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String toString(){
		return userName;
	}
}
