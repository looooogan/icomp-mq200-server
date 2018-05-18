package com.icomp.wsdl.v01c01.c01s011.endpoint;

import java.io.Serializable;

/**
 * 设备列表
 * 
 * @author Administrator
 */
public class EquipmentEntity implements Serializable {
	private static final long serialVersionUID = 6842959254334083567L;
	// 设备ID
	private String equipmentId;
	// RFID
	private String rfidCode;
	// 设备名称
	private String equipmentName;
	// 轴ID
	private String axleID;
	// 轴编码
	private String axleCode;
	public String getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getRfidCode() {
		return rfidCode;
	}
	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getAxleID() {
		return axleID;
	}
	public void setAxleID(String axleID) {
		this.axleID = axleID;
	}
	public String getAxleCode() {
		return axleCode;
	}
	public void setAxleCode(String axleCode) {
		this.axleCode = axleCode;
	}
	
	public String toString() {
        return this.axleCode;
    }

}
