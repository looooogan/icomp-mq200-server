/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class Vcaplist extends VcaplistWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 功能ID	*/ 
	private String capabilityID;

	/**
	 * 功能ID取得
	 * @return capabilityID
	 */
	public String getCapabilityID() {
		return capabilityID;
	}

	/**
	 * 功能ID设定
	 * @param capabilityID
	 */
	public void setCapabilityID(String capabilityID) {
		this.capabilityID = capabilityID;
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
}

