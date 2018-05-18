/*
 * 工具自动生成：库位码条件实体类
 * 生成时间    : 2015/03/09 18:54:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * 库位码条件实体类
 * @author 工具自动生成
 * 创建时间：2015/03/09 18:54:03
 * 创建者  ：杨作庆
 * 
 */
public class LibrarycodeWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 库位码主键	*/ 
	private String libraryCodeIDWhere;

	/**
	 * 库位码主键取得
	 * @return libraryCodeIDWhere
	 */
	public String getLibraryCodeIDWhere () {
		return libraryCodeIDWhere;
	}

	/**
	 * 库位码主键设定
	 * @param libraryCodeIDWhere
	 */
	public void setLibraryCodeIDWhere (String libraryCodeIDWhere) {
		this.libraryCodeIDWhere = libraryCodeIDWhere;
	}

	/* 系统编码	*/ 
	private String systeCodeWhere;

	/**
	 * 系统编码取得
	 * @return systeCodeWhere
	 */
	public String getSysteCodeWhere () {
		return systeCodeWhere;
	}

	/**
	 * 系统编码设定
	 * @param systeCodeWhere
	 */
	public void setSysteCodeWhere (String systeCodeWhere) {
		this.systeCodeWhere = systeCodeWhere;
	}

	/* 自定义编码	*/ 
	private String customerCodeWhere;

	/**
	 * 自定义编码取得
	 * @return customerCodeWhere
	 */
	public String getCustomerCodeWhere () {
		return customerCodeWhere;
	}

	/**
	 * 自定义编码设定
	 * @param customerCodeWhere
	 */
	public void setCustomerCodeWhere (String customerCodeWhere) {
		this.customerCodeWhere = customerCodeWhere;
	}

	/* 操作人	*/ 
	private String systemLogUserWhere;

	/**
	 * 操作人取得
	 * @return systemLogUserWhere
	 */
	public String getSystemLogUserWhere () {
		return systemLogUserWhere;
	}

	/**
	 * 操作人设定
	 * @param systemLogUserWhere
	 */
	public void setSystemLogUserWhere (String systemLogUserWhere) {
		this.systemLogUserWhere = systemLogUserWhere;
	}

	/* 	*/ 
	private String remarkWhere;

	public String getRemarkWhere() {
		return remarkWhere;
	}

	public void setRemarkWhere(String remarkWhere) {
		this.remarkWhere = remarkWhere;
	}

}

