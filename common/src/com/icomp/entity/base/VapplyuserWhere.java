/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/05/16 18:54:36
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;



/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/05/16 18:54:36
 * 创建者  ：工具自动生成
 * 
 */
public class VapplyuserWhere extends BaseEntity implements Serializable {

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

	/* 姓名	*/ 
	private String userNameWhere;

	/**
	 * 姓名取得
	 * @return userNameWhere
	 */
	public String getUserNameWhere () {
		return userNameWhere;
	}

	/**
	 * 姓名设定
	 * @param userNameWhere
	 */
	public void setUserNameWhere (String userNameWhere) {
		this.userNameWhere = userNameWhere;
	}

	/* 身份证号	*/ 
	private String userCardIDWhere;

	/**
	 * 身份证号取得
	 * @return userCardIDWhere
	 */
	public String getUserCardIDWhere () {
		return userCardIDWhere;
	}

	/**
	 * 身份证号设定
	 * @param userCardIDWhere
	 */
	public void setUserCardIDWhere (String userCardIDWhere) {
		this.userCardIDWhere = userCardIDWhere;
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

	/* 部门ID	*/ 
	private String departmentIDWhere;

	/**
	 * 部门ID取得
	 * @return departmentIDWhere
	 */
	public String getDepartmentIDWhere () {
		return departmentIDWhere;
	}

	/**
	 * 部门ID设定
	 * @param departmentIDWhere
	 */
	public void setDepartmentIDWhere (String departmentIDWhere) {
		this.departmentIDWhere = departmentIDWhere;
	}
}

