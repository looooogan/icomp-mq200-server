/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/03/08 09:51:10
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/03/08 09:51:10
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vgetuserinfo extends VgetuserinfoWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 职务名称	*/ 
	private String positionName;

	/**
	 * 职务名称取得
	 * @return positionName
	 */
	public String getPositionName() {
		return positionName;
	}

	/**
	 * 职务名称设定
	 * @param positionName
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	/* 	*/ 
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

	/* RFID标签ID	*/ 
	private String rfidCode;

	/**
	 * RFID标签ID取得
	 * @return rfidCode
	 */
	public String getRfidCode() {
		return rfidCode;
	}

	/**
	 * RFID标签ID设定
	 * @param rfidCode
	 */
	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}
}

