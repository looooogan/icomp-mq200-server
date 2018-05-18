/*
 * 工具自动生成：库位码实体类
 * 生成时间    : 2015/03/09 18:54:03
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * 库位码实体类
 * @author 工具自动生成
 * 创建时间：2015/03/09 18:54:03
 * 创建者  ：杨作庆
 * 
 */
public class Librarycode extends LibrarycodeWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 库位码主键	*/ 
	private String libraryCodeID;

	/**
	 * 库位码主键取得
	 * @return libraryCodeID
	 */
	public String getLibraryCodeID() {
		return libraryCodeID;
	}

	/**
	 * 库位码主键设定
	 * @param libraryCodeID
	 */
	public void setLibraryCodeID(String libraryCodeID) {
		this.libraryCodeID = libraryCodeID;
	}

	/* 系统编码	*/ 
	private String systeCode;

	/**
	 * 系统编码取得
	 * @return systeCode
	 */
	public String getSysteCode() {
		return systeCode;
	}

	/**
	 * 系统编码设定
	 * @param systeCode
	 */
	public void setSysteCode(String systeCode) {
		this.systeCode = systeCode;
	}

	/* 自定义编码	*/ 
	private String customerCode;

	/**
	 * 自定义编码取得
	 * @return customerCode
	 */
	public String getCustomerCode() {
		return customerCode;
	}

	/**
	 * 自定义编码设定
	 * @param customerCode
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	/* 操作人	*/ 
	private String systemLogUser;

	/**
	 * 操作人取得
	 * @return systemLogUser
	 */
	public String getSystemLogUser() {
		return systemLogUser;
	}

	/**
	 * 操作人设定
	 * @param systemLogUser
	 */
	public void setSystemLogUser(String systemLogUser) {
		this.systemLogUser = systemLogUser;
	}

	/* 	*/ 
	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}

