/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2015/06/12 16:25:16
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2015/06/12 16:25:16
 * 创建者  ：杨作庆
 * 
 */
public class Vtoolrealtimedistribution extends VtoolrealtimedistributionWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 	*/ 
	private String departmentName;

	/**
	 * 取得
	 * @return departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * 设定
	 * @param departmentName
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/* 	*/ 
	private String departmentID;

	/**
	 * 取得
	 * @return departmentID
	 */
	public String getDepartmentID() {
		return departmentID;
	}

	/**
	 * 设定
	 * @param departmentID
	 */
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	/* 合成刀具编码(系统唯一)	*/ 
	private String synthesisParametersCode;

	/**
	 * 合成刀具编码(系统唯一)取得
	 * @return synthesisParametersCode
	 */
	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	/**
	 * 合成刀具编码(系统唯一)设定
	 * @param synthesisParametersCode
	 */
	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}

	/* 合成刀具编号(例如：001、002、003)	*/ 
	private String synthesisParametersNumber;

	/**
	 * 合成刀具编号(例如：001、002、003)取得
	 * @return synthesisParametersNumber
	 */
	public String getSynthesisParametersNumber() {
		return synthesisParametersNumber;
	}

	/**
	 * 合成刀具编号(例如：001、002、003)设定
	 * @param synthesisParametersNumber
	 */
	public void setSynthesisParametersNumber(String synthesisParametersNumber) {
		this.synthesisParametersNumber = synthesisParametersNumber;
	}

	/* 业务流程ID	*/ 
	private String businessid;

	/**
	 * 业务流程ID取得
	 * @return businessid
	 */
	public String getBusinessid() {
		return businessid;
	}

	/**
	 * 业务流程ID设定
	 * @param businessid
	 */
	public void setBusinessid(String businessid) {
		this.businessid = businessid;
	}

	/* 业务流程名	*/ 
	private String businessName;

	/**
	 * 业务流程名取得
	 * @return businessName
	 */
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * 业务流程名设定
	 * @param businessName
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/* 	*/ 
	private String toolCount;

	/**
	 * 取得
	 * @return toolCount
	 */
	public String getToolCount() {
		return toolCount;
	}

	/**
	 * 设定
	 * @param toolCount
	 */
	public void setToolCount(String toolCount) {
		this.toolCount = toolCount;
	}
}

