package com.icomp.wsdl.v01c03.c03s003.endpoint;

import java.io.Serializable;

public class EquipmentInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1142872779924598250L;
	
	private String EquipmentID;
	private String EquipmentName;
	public String getEquipmentID() {
		return EquipmentID;
	}
	public void setEquipmentID(String equipmentID) {
		EquipmentID = equipmentID;
	}
	public String getEquipmentName() {
		return EquipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		EquipmentName = equipmentName;
	}

	public String toString(){
		return EquipmentName;
	}
}
