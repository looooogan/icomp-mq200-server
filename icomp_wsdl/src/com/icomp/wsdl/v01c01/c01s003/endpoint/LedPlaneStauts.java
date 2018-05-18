package com.icomp.wsdl.v01c01.c01s003.endpoint;

import java.io.Serializable;

public class LedPlaneStauts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -108119501599529465L;

	private String name;
	private String value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String toString(){
		return name;
	}
}
