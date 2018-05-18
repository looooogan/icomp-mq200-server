/*
 * 工具自动生成：用户表条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 用户表条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class CustomerWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 用户ID[自动生成20位字符串]	*/ 
	private String customerIDWhere;

	/**
	 * 用户ID[自动生成20位字符串]取得
	 * @return customerIDWhere
	 */
	public String getCustomerIDWhere () {
		return customerIDWhere;
	}

	/**
	 * 用户ID[自动生成20位字符串]设定
	 * @param customerIDWhere
	 */
	public void setCustomerIDWhere (String customerIDWhere) {
		this.customerIDWhere = customerIDWhere;
	}

	/* 职务ID	*/ 
	private String positionIDWhere;

	/**
	 * 职务ID取得
	 * @return positionIDWhere
	 */
	public String getPositionIDWhere () {
		return positionIDWhere;
	}

	/**
	 * 职务ID设定
	 * @param positionIDWhere
	 */
	public void setPositionIDWhere (String positionIDWhere) {
		this.positionIDWhere = positionIDWhere;
	}

	/* 用户名[16位数字字母组合]	*/ 
	private String userNameWhere;

	/**
	 * 用户名[16位数字字母组合]取得
	 * @return userNameWhere
	 */
	public String getUserNameWhere () {
		return userNameWhere;
	}

	/**
	 * 用户名[16位数字字母组合]设定
	 * @param userNameWhere
	 */
	public void setUserNameWhere (String userNameWhere) {
		this.userNameWhere = userNameWhere;
	}

	/* 用户密码[16位数字字母组合]	*/ 
	private String userPassWhere;

	/**
	 * 用户密码[16位数字字母组合]取得
	 * @return userPassWhere
	 */
	public String getUserPassWhere () {
		return userPassWhere;
	}

	/**
	 * 用户密码[16位数字字母组合]设定
	 * @param userPassWhere
	 */
	public void setUserPassWhere (String userPassWhere) {
		this.userPassWhere = userPassWhere;
	}

	/* 员工卡号[20位员工卡]	*/ 
	private String employeeCardWhere;

	/**
	 * 员工卡号[20位员工卡]取得
	 * @return employeeCardWhere
	 */
	public String getEmployeeCardWhere () {
		return employeeCardWhere;
	}

	/**
	 * 员工卡号[20位员工卡]设定
	 * @param employeeCardWhere
	 */
	public void setEmployeeCardWhere (String employeeCardWhere) {
		this.employeeCardWhere = employeeCardWhere;
	}

	/* 用户类型(0系统用户1普通用户)	*/ 
	private String userTypeWhere;

	/**
	 * 用户类型(0系统用户1普通用户)取得
	 * @return userTypeWhere
	 */
	public String getUserTypeWhere () {
		return userTypeWhere;
	}

	/**
	 * 用户类型(0系统用户1普通用户)设定
	 * @param userTypeWhere
	 */
	public void setUserTypeWhere (String userTypeWhere) {
		this.userTypeWhere = userTypeWhere;
	}

	/* 用户锁定区分(0正常1锁定)	*/ 
	private String userErrFlagWhere;

	/**
	 * 用户锁定区分(0正常1锁定)取得
	 * @return userErrFlagWhere
	 */
	public String getUserErrFlagWhere () {
		return userErrFlagWhere;
	}

	/**
	 * 用户锁定区分(0正常1锁定)设定
	 * @param userErrFlagWhere
	 */
	public void setUserErrFlagWhere (String userErrFlagWhere) {
		this.userErrFlagWhere = userErrFlagWhere;
	}

	/* 错误次数	*/ 
	private BigDecimal errCountWhere;

	/**
	 * 错误次数取得
	 * @return errCountWhere
	 */
	public BigDecimal getErrCountWhere () {
		return errCountWhere;
	}

	/**
	 * 错误次数设定
	 * @param errCountWhere
	 */
	public void setErrCountWhere (BigDecimal errCountWhere) {
		this.errCountWhere = errCountWhere;
	}

	/* 锁定开始时间	*/ 
	private Date errStaTimeWhere;

	/**
	 * 锁定开始时间取得
	 * @return errStaTimeWhere
	 */
	public Date getErrStaTimeWhere () {
		return errStaTimeWhere;
	}

	/**
	 * 锁定开始时间设定
	 * @param errStaTimeWhere
	 */
	public void setErrStaTimeWhere (Date errStaTimeWhere) {
		this.errStaTimeWhere = errStaTimeWhere;
	}
	
	/* RFID载体ID	*/ 
	private String rfidContainerIDWhere;

	/**
	 * 取得
	 * @return rfidContainerIDWhere
	 */
	public String getRfidContainerIDWhere () {
		return rfidContainerIDWhere;
	}

	/**
	 * 设定
	 * @param rfidContainerIDWhere
	 */
	public void setRfidContainerIDWhere (String rfidContainerIDWhere) {
		this.rfidContainerIDWhere = rfidContainerIDWhere;
	}
}

