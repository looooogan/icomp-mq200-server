/*
 * 工具自动生成：手持机实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * 手持机实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class Handset extends HandsetWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 手持机ID	*/ 
	private String handSetID;

	/**
	 * 手持机ID取得
	 * @return handSetID
	 */
	public String getHandSetID() {
		return handSetID;
	}

	/**
	 * 手持机ID设定
	 * @param handSetID
	 */
	public void setHandSetID(String handSetID) {
		this.handSetID = handSetID;
	}

	/* 注册部门	*/ 
	private String departmentID;

	/**
	 * 注册部门取得
	 * @return departmentID
	 */
	public String getDepartmentID() {
		return departmentID;
	}

	/**
	 * 注册部门设定
	 * @param departmentID
	 */
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	/* 手持机编码	*/ 
	private String handSetCode;

	/**
	 * 手持机编码取得
	 * @return handSetCode
	 */
	public String getHandSetCode() {
		return handSetCode;
	}

	/**
	 * 手持机编码设定
	 * @param handSetCode
	 */
	public void setHandSetCode(String handSetCode) {
		this.handSetCode = handSetCode;
	}

	/* 手持机名称	*/ 
	private String handSetName;

	/**
	 * 手持机名称取得
	 * @return handSetName
	 */
	public String getHandSetName() {
		return handSetName;
	}

	/**
	 * 手持机名称设定
	 * @param handSetName
	 */
	public void setHandSetName(String handSetName) {
		this.handSetName = handSetName;
	}

	/* 手持机状态(0停用1启用)	*/ 
	private String handSetStauts;

	/**
	 * 手持机状态(0停用1启用)取得
	 * @return handSetStauts
	 */
	public String getHandSetStauts() {
		return handSetStauts;
	}

	/**
	 * 手持机状态(0停用1启用)设定
	 * @param handSetStauts
	 */
	public void setHandSetStauts(String handSetStauts) {
		this.handSetStauts = handSetStauts;
	}

	/* 是否注册(0注册1未注册)	*/ 
	private String isRegistration;

	/**
	 * 是否注册(0注册1未注册)取得
	 * @return isRegistration
	 */
	public String getIsRegistration() {
		return isRegistration;
	}

	/**
	 * 是否注册(0注册1未注册)设定
	 * @param isRegistration
	 */
	public void setIsRegistration(String isRegistration) {
		this.isRegistration = isRegistration;
	}

	/* 登录状态(0登录1未登录)	*/ 
	private String loginStauts;

	/**
	 * 登录状态(0登录1未登录)取得
	 * @return loginStauts
	 */
	public String getLoginStauts() {
		return loginStauts;
	}

	/**
	 * 登录状态(0登录1未登录)设定
	 * @param loginStauts
	 */
	public void setLoginStauts(String loginStauts) {
		this.loginStauts = loginStauts;
	}
}

