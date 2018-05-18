package com.icomp.wsdl.v01c03.c03s003.endpoint;


import java.util.List;

import com.icomp.common.pojo.BaseRespons;

public class C03S003Respons extends BaseRespons{

	/**
	 * 
	 */
	private static final long serialVersionUID = 565016731545719350L;

	private List<EquipmentInfo> equipmentInfoList;
	private List<EquipmentType> equipmentTypeList;
	public List<EquipmentInfo> getEquipmentInfoList() {
		return equipmentInfoList;
	}
	public void setEquipmentInfoList(List<EquipmentInfo> equipmentInfoList) {
		this.equipmentInfoList = equipmentInfoList;
	}
	public List<EquipmentType> getEquipmentTypeList() {
		return equipmentTypeList;
	}
	public void setEquipmentTypeList(List<EquipmentType> equipmentTypeList) {
		this.equipmentTypeList = equipmentTypeList;
	}
	//用户ID
	private String blindCustomerID;
	//真实姓名
	private String userName;
	//员工卡号
	private String employeeCard;
	//部门
	private String departmentName;
	public String getBlindCustomerID() {
		return blindCustomerID;
	}
	//1）是否已初始化（0未初始化，1已初始化）
	private String isHas;

	public String getIsHas() {
		return isHas;
	}

	public void setIsHas(String isHas) {
		this.isHas = isHas;
	}

	public void setBlindCustomerID(String blindCustomerID) {
		this.blindCustomerID = blindCustomerID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmployeeCard() {
		return employeeCard;
	}

	public void setEmployeeCard(String employeeCard) {
		this.employeeCard = employeeCard;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


}
