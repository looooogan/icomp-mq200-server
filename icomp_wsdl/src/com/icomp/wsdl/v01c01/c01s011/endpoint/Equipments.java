package com.icomp.wsdl.v01c01.c01s011.endpoint;

import java.io.Serializable;
/**
 * 设备列表
 * @author Administrator
 */
public class Equipments implements Serializable {
	private static final long serialVersionUID = 6842959254334083567L;
	
	private String equipmentId;
	private String equipmentCode;
	private String equipmentName;
	public String getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getEquipmentCode() {
		return equipmentCode;
	}
	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	@Override
	public String toString() {
		return equipmentName;
	}
	
	
	
}
