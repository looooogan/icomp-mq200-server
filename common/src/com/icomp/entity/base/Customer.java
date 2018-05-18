/*
 * 工具自动生成：用户表实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 用户表实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class Customer extends CustomerWhere implements Serializable {

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

	/* 职务ID	*/ 
	private String positionID;

	/**
	 * 职务ID取得
	 * @return positionID
	 */
	public String getPositionID() {
		return positionID;
	}

	/**
	 * 职务ID设定
	 * @param positionID
	 */
	public void setPositionID(String positionID) {
		this.positionID = positionID;
	}

	/* 用户名[16位数字字母组合]	*/ 
	private String userName;

	/**
	 * 用户名[16位数字字母组合]取得
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 用户名[16位数字字母组合]设定
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/* 用户密码[16位数字字母组合]	*/ 
	private String userPass;

	/**
	 * 用户密码[16位数字字母组合]取得
	 * @return userPass
	 */
	public String getUserPass() {
		return userPass;
	}

	/**
	 * 用户密码[16位数字字母组合]设定
	 * @param userPass
	 */
	public void setUserPass(String userPass) {
		this.userPass = userPass;
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

	/* 用户类型(0系统用户1普通用户)	*/ 
	private String userType;

	/**
	 * 用户类型(0系统用户1普通用户)取得
	 * @return userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * 用户类型(0系统用户1普通用户)设定
	 * @param userType
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/* 用户锁定区分(0正常1锁定)	*/ 
	private String userErrFlag;

	/**
	 * 用户锁定区分(0正常1锁定)取得
	 * @return userErrFlag
	 */
	public String getUserErrFlag() {
		return userErrFlag;
	}

	/**
	 * 用户锁定区分(0正常1锁定)设定
	 * @param userErrFlag
	 */
	public void setUserErrFlag(String userErrFlag) {
		this.userErrFlag = userErrFlag;
	}

	/* 错误次数	*/ 
	private BigDecimal errCount;

	/**
	 * 错误次数取得
	 * @return errCount
	 */
	public BigDecimal getErrCount() {
		return errCount;
	}

	/**
	 * 错误次数设定
	 * @param errCount
	 */
	public void setErrCount(BigDecimal errCount) {
		this.errCount = errCount;
	}

	/* 锁定开始时间	*/ 
	private Date errStaTime;

	/**
	 * 锁定开始时间取得
	 * @return errStaTime
	 */
	public Date getErrStaTime() {
		return errStaTime;
	}

	/**
	 * 锁定开始时间设定
	 * @param errStaTime
	 */
	public void setErrStaTime(Date errStaTime) {
		this.errStaTime = errStaTime;
	}
	
	/* RFID载体ID	*/ 
	private String rfidContainerID;

	/**
	 * 取得
	 * @return rfidContainerID
	 */
	public String getRfidContainerID() {
		return rfidContainerID;
	}

	/**
	 * 设定
	 * @param rfidContainerID
	 */
	public void setRfidContainerID(String rfidContainerID) {
		this.rfidContainerID = rfidContainerID;
	}
}

