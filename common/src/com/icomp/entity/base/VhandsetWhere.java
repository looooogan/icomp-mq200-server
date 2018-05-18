/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class VhandsetWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 手持机ID	*/ 
	private String handSetIDWhere;

	/**
	 * 手持机ID取得
	 * @return handSetIDWhere
	 */
	public String getHandSetIDWhere () {
		return handSetIDWhere;
	}

	/**
	 * 手持机ID设定
	 * @param handSetIDWhere
	 */
	public void setHandSetIDWhere (String handSetIDWhere) {
		this.handSetIDWhere = handSetIDWhere;
	}

	/* 注册部门	*/ 
	private String departmentIDWhere;

	/**
	 * 注册部门取得
	 * @return departmentIDWhere
	 */
	public String getDepartmentIDWhere () {
		return departmentIDWhere;
	}

	/**
	 * 注册部门设定
	 * @param departmentIDWhere
	 */
	public void setDepartmentIDWhere (String departmentIDWhere) {
		this.departmentIDWhere = departmentIDWhere;
	}

	/* 部门名称	*/ 
	private String departmentNameWhere;

	/**
	 * 部门名称取得
	 * @return departmentNameWhere
	 */
	public String getDepartmentNameWhere () {
		return departmentNameWhere;
	}

	/**
	 * 部门名称设定
	 * @param departmentNameWhere
	 */
	public void setDepartmentNameWhere (String departmentNameWhere) {
		this.departmentNameWhere = departmentNameWhere;
	}

	/* 手持机编码	*/ 
	private String handSetCodeWhere;

	/**
	 * 手持机编码取得
	 * @return handSetCodeWhere
	 */
	public String getHandSetCodeWhere () {
		return handSetCodeWhere;
	}

	/**
	 * 手持机编码设定
	 * @param handSetCodeWhere
	 */
	public void setHandSetCodeWhere (String handSetCodeWhere) {
		this.handSetCodeWhere = handSetCodeWhere;
	}

	/* 手持机名称	*/ 
	private String handSetNameWhere;

	/**
	 * 手持机名称取得
	 * @return handSetNameWhere
	 */
	public String getHandSetNameWhere () {
		return handSetNameWhere;
	}

	/**
	 * 手持机名称设定
	 * @param handSetNameWhere
	 */
	public void setHandSetNameWhere (String handSetNameWhere) {
		this.handSetNameWhere = handSetNameWhere;
	}

	/* 手持机状态(0停用1启用)	*/ 
	private String handSetStautsWhere;

	/**
	 * 手持机状态(0停用1启用)取得
	 * @return handSetStautsWhere
	 */
	public String getHandSetStautsWhere () {
		return handSetStautsWhere;
	}

	/**
	 * 手持机状态(0停用1启用)设定
	 * @param handSetStautsWhere
	 */
	public void setHandSetStautsWhere (String handSetStautsWhere) {
		this.handSetStautsWhere = handSetStautsWhere;
	}

	/* 是否注册(0注册1未注册)	*/ 
	private String isRegistrationWhere;

	/**
	 * 是否注册(0注册1未注册)取得
	 * @return isRegistrationWhere
	 */
	public String getIsRegistrationWhere () {
		return isRegistrationWhere;
	}

	/**
	 * 是否注册(0注册1未注册)设定
	 * @param isRegistrationWhere
	 */
	public void setIsRegistrationWhere (String isRegistrationWhere) {
		this.isRegistrationWhere = isRegistrationWhere;
	}

	/* 登录状态(0登录1未登录)	*/ 
	private String loginStautsWhere;

	/**
	 * 登录状态(0登录1未登录)取得
	 * @return loginStautsWhere
	 */
	public String getLoginStautsWhere () {
		return loginStautsWhere;
	}

	/**
	 * 登录状态(0登录1未登录)设定
	 * @param loginStautsWhere
	 */
	public void setLoginStautsWhere (String loginStautsWhere) {
		this.loginStautsWhere = loginStautsWhere;
	}
}

