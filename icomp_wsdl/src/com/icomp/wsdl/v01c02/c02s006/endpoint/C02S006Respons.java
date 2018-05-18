package com.icomp.wsdl.v01c02.c02s006.endpoint;

import java.util.List;

import com.icomp.common.pojo.BaseRespons;
import com.icomp.entity.base.Department;

public class C02S006Respons extends BaseRespons {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2193930122393625883L;

	/**
	 * 部门ID
	 */
	private String departmentID;

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}
	
	/**
	 * 部门名称
	 */
	private String departmentName;
	
	
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * 部门列表
	 */
	private List<Department> list;

	public List<Department> getList() {
		return list;
	}

	public void setList(List<Department> list) {
		this.list = list;
	}
}
