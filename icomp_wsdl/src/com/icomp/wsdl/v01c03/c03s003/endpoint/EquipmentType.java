package com.icomp.wsdl.v01c03.c03s003.endpoint;

import java.io.Serializable;

public class EquipmentType  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1062906263661664425L;

	private String value;
	private String name;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String toString(){
		return name;
	}
}
