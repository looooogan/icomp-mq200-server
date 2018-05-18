/*
 * 工具自动生成：部门-职务中间表实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * 部门-职务中间表实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class Dplink extends DplinkWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* dpLinkID	*/ 
	private String dpLinkID;

	/**
	 * dpLinkID取得
	 * @return dpLinkID
	 */
	public String getdpLinkID() {
		return dpLinkID;
	}

	/**
	 * dpLinkID设定
	 * @param dpLinkID
	 */
	public void setdpLinkID(String dpLinkID) {
		this.dpLinkID = dpLinkID;
	}

	/* 部门ID	*/ 
	private String departmentID;

	/**
	 * 部门ID取得
	 * @return departmentID
	 */
	public String getDepartmentID() {
		return departmentID;
	}

	/**
	 * 部门ID设定
	 * @param departmentID
	 */
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
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

