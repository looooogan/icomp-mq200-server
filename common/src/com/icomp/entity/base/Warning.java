/*
 * 工具自动生成：实体类
 * 生成时间    : 2016/03/26 13:54:04
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * 实体类
 * @author 工具自动生成
 * 创建时间：2016/03/26 13:54:04
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Warning extends WarningWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 预警ID	*/ 
	private String warningID;

	/**
	 * 预警ID取得
	 * @return warningID
	 */
	public String getWarningID() {
		return warningID;
	}

	/**
	 * 预警ID设定
	 * @param warningID
	 */
	public void setWarningID(String warningID) {
		this.warningID = warningID;
	}

	/* 功能	*/ 
	private String warningFunction;

	/**
	 * 功能取得
	 * @return warningFunction
	 */
	public String getWarningFunction() {
		return warningFunction;
	}

	/**
	 * 功能设定
	 * @param warningFunction
	 */
	public void setWarningFunction(String warningFunction) {
		this.warningFunction = warningFunction;
	}

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

	/* 员工卡号[20位员工卡]	*/ 
	private String employeeCard;

	/**
	 * 员工卡号[20位员工卡]取得
	 * @return employeeCard
	 */
	public String getEmployeeCard() {
		return employeeCard;
	}

	/**
	 * 员工卡号[20位员工卡]设定
	 * @param employeeCard
	 */
	public void setEmployeeCard(String employeeCard) {
		this.employeeCard = employeeCard;
	}

	/* 启动/停用	*/ 
	private String sorT;

	/**
	 * 启动/停用取得
	 * @return sorT
	 */
	public String getSorT() {
		return sorT;
	}

	/**
	 * 启动/停用设定
	 * @param sorT
	 */
	public void setSorT(String sorT) {
		this.sorT = sorT;
	}
}

