/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/03/08 09:51:10
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;



/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/03/08 09:51:10
 * 创建者  ：工具自动生成
 * 
 */
public class VgetuserinfoWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 职务名称	*/ 
	private String positionNameWhere;

	/**
	 * 职务名称取得
	 * @return positionNameWhere
	 */
	public String getPositionNameWhere () {
		return positionNameWhere;
	}

	/**
	 * 职务名称设定
	 * @param positionNameWhere
	 */
	public void setPositionNameWhere (String positionNameWhere) {
		this.positionNameWhere = positionNameWhere;
	}

	/* 	*/ 
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

	/* RFID标签ID	*/ 
	private String rfidCodeWhere;

	/**
	 * RFID标签ID取得
	 * @return rfidCodeWhere
	 */
	public String getRfidCodeWhere () {
		return rfidCodeWhere;
	}

	/**
	 * RFID标签ID设定
	 * @param rfidCodeWhere
	 */
	public void setRfidCodeWhere (String rfidCodeWhere) {
		this.rfidCodeWhere = rfidCodeWhere;
	}
}

