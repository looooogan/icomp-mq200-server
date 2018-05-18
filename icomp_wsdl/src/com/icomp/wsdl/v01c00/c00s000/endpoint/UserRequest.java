package com.icomp.wsdl.v01c00.c00s000.endpoint;

import com.icomp.common.pojo.BaseRequest;

public class UserRequest extends BaseRequest {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5706183297961996870L;
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
	
	/**
	 * 权限编码
	 */
	public String activityName;
	/**
	 *登录类型(0输入登陆，1扫卡登陆)

	 */
	public String loginType;

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
}
