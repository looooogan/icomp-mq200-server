/*
 * 工具自动生成：条件实体类
 * 生成时间    : 2016/03/26 13:54:04
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;



/**
 * 条件实体类
 * @author 工具自动生成
 * 创建时间：2016/03/26 13:54:04
 * 创建者  ：工具自动生成
 * 
 */
public class WarningWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 预警ID	*/ 
	private String warningIDWhere;

	/**
	 * 预警ID取得
	 * @return warningIDWhere
	 */
	public String getWarningIDWhere () {
		return warningIDWhere;
	}

	/**
	 * 预警ID设定
	 * @param warningIDWhere
	 */
	public void setWarningIDWhere (String warningIDWhere) {
		this.warningIDWhere = warningIDWhere;
	}

	/* 功能	*/ 
	private String warningFunctionWhere;

	/**
	 * 功能取得
	 * @return warningFunctionWhere
	 */
	public String getWarningFunctionWhere () {
		return warningFunctionWhere;
	}

	/**
	 * 功能设定
	 * @param warningFunctionWhere
	 */
	public void setWarningFunctionWhere (String warningFunctionWhere) {
		this.warningFunctionWhere = warningFunctionWhere;
	}

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

	/* 启动/停用	*/ 
	private String sorTWhere;

	/**
	 * 启动/停用取得
	 * @return sorTWhere
	 */
	public String getSorTWhere () {
		return sorTWhere;
	}

	/**
	 * 启动/停用设定
	 * @param sorTWhere
	 */
	public void setSorTWhere (String sorTWhere) {
		this.sorTWhere = sorTWhere;
	}
}

