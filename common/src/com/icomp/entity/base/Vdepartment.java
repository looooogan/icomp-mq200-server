/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class Vdepartment extends VdepartmentWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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
	private String departmentAgencyID;

	/**
	 * 机构ID取得
	 * @return departmentAgencyID
	 */
	public String getDepartmentAgencyID() {
		return departmentAgencyID;
	}

	/**
	 * 机构ID设定
	 * @param departmentAgencyID
	 */
	public void setDepartmentAgencyID(String departmentAgencyID) {
		this.departmentAgencyID = departmentAgencyID;
	}

	/* 语言编码	*/ 
	private String departmentLanguageCode;

	/**
	 * 语言编码取得
	 * @return departmentLanguageCode
	 */
	public String getDepartmentLanguageCode() {
		return departmentLanguageCode;
	}

	/**
	 * 语言编码设定
	 * @param departmentLanguageCode
	 */
	public void setDepartmentLanguageCode(String departmentLanguageCode) {
		this.departmentLanguageCode = departmentLanguageCode;
	}

	/* 部门编码	*/ 
	private String departmentCode;

	/**
	 * 部门编码取得
	 * @return departmentCode
	 */
	public String getDepartmentCode() {
		return departmentCode;
	}

	/**
	 * 部门编码设定
	 * @param departmentCode
	 */
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	/* 部门名称	*/ 
	private String departmentName;

	/**
	 * 部门名称取得
	 * @return departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * 部门名称设定
	 * @param departmentName
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/* 部门电话	*/ 
	private String departmentTel;

	/**
	 * 部门电话取得
	 * @return departmentTel
	 */
	public String getDepartmentTel() {
		return departmentTel;
	}

	/**
	 * 部门电话设定
	 * @param departmentTel
	 */
	public void setDepartmentTel(String departmentTel) {
		this.departmentTel = departmentTel;
	}

	/* 部门负责人	*/ 
	private String departmentHead;

	/**
	 * 部门负责人取得
	 * @return departmentHead
	 */
	public String getDepartmentHead() {
		return departmentHead;
	}

	/**
	 * 部门负责人设定
	 * @param departmentHead
	 */
	public void setDepartmentHead(String departmentHead) {
		this.departmentHead = departmentHead;
	}

	/* 负责人手机	*/ 
	private String departmentHeadMobile;

	/**
	 * 负责人手机取得
	 * @return departmentHeadMobile
	 */
	public String getDepartmentHeadMobile() {
		return departmentHeadMobile;
	}

	/**
	 * 负责人手机设定
	 * @param departmentHeadMobile
	 */
	public void setDepartmentHeadMobile(String departmentHeadMobile) {
		this.departmentHeadMobile = departmentHeadMobile;
	}

	/* 负责人电话	*/ 
	private String departmentHeadTel;

	/**
	 * 负责人电话取得
	 * @return departmentHeadTel
	 */
	public String getDepartmentHeadTel() {
		return departmentHeadTel;
	}

	/**
	 * 负责人电话设定
	 * @param departmentHeadTel
	 */
	public void setDepartmentHeadTel(String departmentHeadTel) {
		this.departmentHeadTel = departmentHeadTel;
	}

	/* 部门成立时间	*/ 
	private String departmentCdate;

	/**
	 * 部门成立时间取得
	 * @return departmentCdate
	 */
	public String getDepartmentCdate() {
		return departmentCdate;
	}

	/**
	 * 部门成立时间设定
	 * @param departmentCdate
	 */
	public void setDepartmentCdate(String departmentCdate) {
		this.departmentCdate = departmentCdate;
	}

	/* 部门描述	*/ 
	private String departmentDescription;

	/**
	 * 部门描述取得
	 * @return departmentDescription
	 */
	public String getDepartmentDescription() {
		return departmentDescription;
	}

	/**
	 * 部门描述设定
	 * @param departmentDescription
	 */
	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}

	/* 删除区分(0有效1删除)	*/ 
	private String departmentDelFlag;

	/**
	 * 删除区分(0有效1删除)取得
	 * @return departmentDelFlag
	 */
	public String getDepartmentDelFlag() {
		return departmentDelFlag;
	}

	/**
	 * 删除区分(0有效1删除)设定
	 * @param departmentDelFlag
	 */
	public void setDepartmentDelFlag(String departmentDelFlag) {
		this.departmentDelFlag = departmentDelFlag;
	}

	/* 创建者	*/ 
	private String departmentCreateUser;

	/**
	 * 创建者取得
	 * @return departmentCreateUser
	 */
	public String getDepartmentCreateUser() {
		return departmentCreateUser;
	}

	/**
	 * 创建者设定
	 * @param departmentCreateUser
	 */
	public void setDepartmentCreateUser(String departmentCreateUser) {
		this.departmentCreateUser = departmentCreateUser;
	}

	/* 创建时间	*/ 
	private Date departmentCreateTime;

	/**
	 * 创建时间取得
	 * @return departmentCreateTime
	 */
	public Date getDepartmentCreateTime() {
		return departmentCreateTime;
	}

	/**
	 * 创建时间设定
	 * @param departmentCreateTime
	 */
	public void setDepartmentCreateTime(Date departmentCreateTime) {
		this.departmentCreateTime = departmentCreateTime;
	}

	/* 更新者	*/ 
	private String departmentUpdateUser;

	/**
	 * 更新者取得
	 * @return departmentUpdateUser
	 */
	public String getDepartmentUpdateUser() {
		return departmentUpdateUser;
	}

	/**
	 * 更新者设定
	 * @param departmentUpdateUser
	 */
	public void setDepartmentUpdateUser(String departmentUpdateUser) {
		this.departmentUpdateUser = departmentUpdateUser;
	}

	/* 更新时间	*/ 
	private Date departmentUpdateTime;

	/**
	 * 更新时间取得
	 * @return departmentUpdateTime
	 */
	public Date getDepartmentUpdateTime() {
		return departmentUpdateTime;
	}

	/**
	 * 更新时间设定
	 * @param departmentUpdateTime
	 */
	public void setDepartmentUpdateTime(Date departmentUpdateTime) {
		this.departmentUpdateTime = departmentUpdateTime;
	}

	/* 版本号	*/ 
	private BigDecimal departmentVersion;

	/**
	 * 版本号取得
	 * @return departmentVersion
	 */
	public BigDecimal getDepartmentVersion() {
		return departmentVersion;
	}

	/**
	 * 版本号设定
	 * @param departmentVersion
	 */
	public void setDepartmentVersion(BigDecimal departmentVersion) {
		this.departmentVersion = departmentVersion;
	}
}

