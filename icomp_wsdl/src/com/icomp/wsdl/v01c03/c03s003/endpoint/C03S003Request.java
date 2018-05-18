package com.icomp.wsdl.v01c03.c03s003.endpoint;


import com.icomp.common.pojo.BaseRequest;

public class C03S003Request extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1914111583956642712L;

	private String rfidString;
	private String value;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	private String equipmentID;
	public String getRfidString() {
		return rfidString;
	}
	public void setRfidString(String rfidString) {
		this.rfidString = rfidString;
	}
	public String getEquipmentID() {
		return equipmentID;
	}
	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}

	//rfid类型
	private String rfidType;
	//rfid
	private String rfidCode;
	//员工卡号
	private String employeeCard;
	//绑定用户ID
	private String blindCustomerID;

	public String getBlindCustomerID() {
		return blindCustomerID;
	}

	public void setBlindCustomerID(String blindCustomerID) {
		this.blindCustomerID = blindCustomerID;
	}


	public String getRfidType() {
		return rfidType;
	}

	public void setRfidType(String rfidType) {
		this.rfidType = rfidType;
	}

	public String getRfidCode() {
		return rfidCode;
	}

	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}

	public String getEmployeeCard() {
		return employeeCard;
	}

	public void setEmployeeCard(String employeeCard) {
		this.employeeCard = employeeCard;
	}
}
