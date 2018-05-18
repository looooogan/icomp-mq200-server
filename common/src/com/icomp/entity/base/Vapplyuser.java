/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/05/16 18:54:36
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/05/16 18:54:36
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vapplyuser extends VapplyuserWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 用户ID[自动生成20位字符串]	*/ 
	private String customerID;

	/**
	 * 用户ID[自动生成20位字符串]取得
	 * @return customerID
	 */
	public String getCustomerID() {
		return customerID;
	}

	/**
	 * 用户ID[自动生成20位字符串]设定
	 * @param customerID
	 */
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	/* 姓名	*/ 
	private String userName;

	/**
	 * 姓名取得
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 姓名设定
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/* 身份证号	*/ 
	private String userCardID;

	/**
	 * 身份证号取得
	 * @return userCardID
	 */
	public String getUserCardID() {
		return userCardID;
	}

	/**
	 * 身份证号设定
	 * @param userCardID
	 */
	public void setUserCardID(String userCardID) {
		this.userCardID = userCardID;
	}

	/* 部门名称	*/ 
	private String departmentName;

	/**
	 * 部门名称取得
	 * @return departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * 部门名称设定
	 * @param departmentName
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/* 部门ID	*/ 
	private String departmentID;

	/**
	 * 部门ID取得
	 * @return departmentID
	 */
	public String getDepartmentID() {
		return departmentID;
	}

	/**
	 * 部门ID设定
	 * @param departmentID
	 */
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}
}

