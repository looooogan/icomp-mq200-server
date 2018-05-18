/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2015/04/14 10:52:09
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2015/04/14 10:52:09
 * 创建者  ：杨作庆
 * 
 */
public class Vposition extends VpositionWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 语言编码	*/ 
	private String positionLanguageCode;

	/**
	 * 语言编码取得
	 * @return positionLanguageCode
	 */
	public String getPositionLanguageCode() {
		return positionLanguageCode;
	}

	/**
	 * 语言编码设定
	 * @param positionLanguageCode
	 */
	public void setPositionLanguageCode(String positionLanguageCode) {
		this.positionLanguageCode = positionLanguageCode;
	}

	/* 职务编码	*/ 
	private String positionCode;

	/**
	 * 职务编码取得
	 * @return positionCode
	 */
	public String getPositionCode() {
		return positionCode;
	}

	/**
	 * 职务编码设定
	 * @param positionCode
	 */
	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
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

	/* 机构ID	*/ 
	private String agencyID;

	/**
	 * 机构ID取得
	 * @return agencyID
	 */
	public String getAgencyID() {
		return agencyID;
	}

	/**
	 * 机构ID设定
	 * @param agencyID
	 */
	public void setAgencyID(String agencyID) {
		this.agencyID = agencyID;
	}
}

