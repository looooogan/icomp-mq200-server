package com.icomp.wsdl.v01c01.c01s018.endpoint;

import java.io.Serializable;

public class GrindingEquipmentEntity implements Serializable {

	/**
	 * 修磨设备列表
	 */
	private static final long serialVersionUID = 1L;
    //修磨设备
	private String equipmentID;
	//RFID
	private String equipmentRfid;
	//设备名称
	private String equipmentName;
	//设备类型
	private String equipmenttype;


	public String getEquipmenttype() {
		return equipmenttype;
	}

	public void setEquipmenttype(String equipmenttype) {
		this.equipmenttype = equipmenttype;
	}

	public String getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}

	public String getEquipmentRfid() {
		return equipmentRfid;
	}

	public void setEquipmentRfid(String equipmentRfid) {
		this.equipmentRfid = equipmentRfid;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
}
