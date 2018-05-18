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
public class Vgrantlist extends VgrantlistWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 用户类型(0系统用户1普通用户)	*/ 
	private String userType;

	/**
	 * 用户类型(0系统用户1普通用户)取得
	 * @return userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * 用户类型(0系统用户1普通用户)设定
	 * @param userType
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/* 用户名[16位数字字母组合]	*/ 
	private String userName;

	/**
	 * 用户名[16位数字字母组合]取得
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 用户名[16位数字字母组合]设定
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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

	/* 机构编码	*/ 
	private String agencyCode;

	/**
	 * 机构编码取得
	 * @return agencyCode
	 */
	public String getAgencyCode() {
		return agencyCode;
	}

	/**
	 * 机构编码设定
	 * @param agencyCode
	 */
	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

	/* 机构名称	*/ 
	private String agencyName;

	/**
	 * 机构名称取得
	 * @return agencyName
	 */
	public String getAgencyName() {
		return agencyName;
	}

	/**
	 * 机构名称设定
	 * @param agencyName
	 */
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	/* 机构电话	*/ 
	private String agencyTel;

	/**
	 * 机构电话取得
	 * @return agencyTel
	 */
	public String getAgencyTel() {
		return agencyTel;
	}

	/**
	 * 机构电话设定
	 * @param agencyTel
	 */
	public void setAgencyTel(String agencyTel) {
		this.agencyTel = agencyTel;
	}

	/* 机构创立时间	*/ 
	private String agencyCdate;

	/**
	 * 机构创立时间取得
	 * @return agencyCdate
	 */
	public String getAgencyCdate() {
		return agencyCdate;
	}

	/**
	 * 机构创立时间设定
	 * @param agencyCdate
	 */
	public void setAgencyCdate(String agencyCdate) {
		this.agencyCdate = agencyCdate;
	}

	/* 机构法人	*/ 
	private String agencyCorporate;

	/**
	 * 机构法人取得
	 * @return agencyCorporate
	 */
	public String getAgencyCorporate() {
		return agencyCorporate;
	}

	/**
	 * 机构法人设定
	 * @param agencyCorporate
	 */
	public void setAgencyCorporate(String agencyCorporate) {
		this.agencyCorporate = agencyCorporate;
	}

	/* 权限开始时间	*/ 
	private Date gendDate;

	/**
	 * 权限开始时间取得
	 * @return gendDate
	 */
	public Date getGendDate() {
		return gendDate;
	}

	/**
	 * 权限开始时间设定
	 * @param gendDate
	 */
	public void setGendDate(Date gendDate) {
		this.gendDate = gendDate;
	}

	/* 权限开始时间	*/ 
	private Date gstrDate;

	/**
	 * 权限开始时间取得
	 * @return gstrDate
	 */
	public Date getGstrDate() {
		return gstrDate;
	}

	/**
	 * 权限开始时间设定
	 * @param gstrDate
	 */
	public void setGstrDate(Date gstrDate) {
		this.gstrDate = gstrDate;
	}

	/* 功能编码	*/ 
	private String capabilityCode;

	/**
	 * 功能编码取得
	 * @return capabilityCode
	 */
	public String getCapabilityCode() {
		return capabilityCode;
	}

	/**
	 * 功能编码设定
	 * @param capabilityCode
	 */
	public void setCapabilityCode(String capabilityCode) {
		this.capabilityCode = capabilityCode;
	}

	/* 功能名称	*/ 
	private String capabilityName;

	/**
	 * 功能名称取得
	 * @return capabilityName
	 */
	public String getCapabilityName() {
		return capabilityName;
	}

	/**
	 * 功能名称设定
	 * @param capabilityName
	 */
	public void setCapabilityName(String capabilityName) {
		this.capabilityName = capabilityName;
	}

	/* 功能级别	*/ 
	private BigDecimal capabilityLevel;

	/**
	 * 功能级别取得
	 * @return capabilityLevel
	 */
	public BigDecimal getCapabilityLevel() {
		return capabilityLevel;
	}

	/**
	 * 功能级别设定
	 * @param capabilityLevel
	 */
	public void setCapabilityLevel(BigDecimal capabilityLevel) {
		this.capabilityLevel = capabilityLevel;
	}

	/* 功能顺序	*/ 
	private BigDecimal capabilityOrder;

	/**
	 * 功能顺序取得
	 * @return capabilityOrder
	 */
	public BigDecimal getCapabilityOrder() {
		return capabilityOrder;
	}

	/**
	 * 功能顺序设定
	 * @param capabilityOrder
	 */
	public void setCapabilityOrder(BigDecimal capabilityOrder) {
		this.capabilityOrder = capabilityOrder;
	}

	/* 功能URL	*/ 
	private String capabilityUrl;

	/**
	 * 功能URL取得
	 * @return capabilityUrl
	 */
	public String getCapabilityUrl() {
		return capabilityUrl;
	}

	/**
	 * 功能URL设定
	 * @param capabilityUrl
	 */
	public void setCapabilityUrl(String capabilityUrl) {
		this.capabilityUrl = capabilityUrl;
	}

	/* 功能图片	*/ 
	private String capabilityImg;

	/**
	 * 功能图片取得
	 * @return capabilityImg
	 */
	public String getCapabilityImg() {
		return capabilityImg;
	}

	/**
	 * 功能图片设定
	 * @param capabilityImg
	 */
	public void setCapabilityImg(String capabilityImg) {
		this.capabilityImg = capabilityImg;
	}

	/* 归属区分(0:管理平台1:手持机9:手持机授权)	*/ 
	private String belongFlag;

	/**
	 * 归属区分(0:管理平台1:手持机9:手持机授权)取得
	 * @return belongFlag
	 */
	public String getBelongFlag() {
		return belongFlag;
	}

	/**
	 * 归属区分(0:管理平台1:手持机9:手持机授权)设定
	 * @param belongFlag
	 */
	public void setBelongFlag(String belongFlag) {
		this.belongFlag = belongFlag;
	}

	/* 是否菜单(0是1否)	*/ 
	private String menuFlag;

	/**
	 * 是否菜单(0是1否)取得
	 * @return menuFlag
	 */
	public String getMenuFlag() {
		return menuFlag;
	}

	/**
	 * 是否菜单(0是1否)设定
	 * @param menuFlag
	 */
	public void setMenuFlag(String menuFlag) {
		this.menuFlag = menuFlag;
	}

	/* 系统编码	*/ 
	private String systemCode;

	/**
	 * 系统编码取得
	 * @return systemCode
	 */
	public String getSystemCode() {
		return systemCode;
	}

	/**
	 * 系统编码设定
	 * @param systemCode
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	/* 系统名称	*/ 
	private String systemName;

	/**
	 * 系统名称取得
	 * @return systemName
	 */
	public String getSystemName() {
		return systemName;
	}

	/**
	 * 系统名称设定
	 * @param systemName
	 */
	public void setSystemName(String systemName) {
		this.systemName = systemName;
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

	/* 删除区分(0有效1删除)	*/ 
	private String positionDelFlag;

	/**
	 * 删除区分(0有效1删除)取得
	 * @return positionDelFlag
	 */
	public String getPositionDelFlag() {
		return positionDelFlag;
	}

	/**
	 * 删除区分(0有效1删除)设定
	 * @param positionDelFlag
	 */
	public void setPositionDelFlag(String positionDelFlag) {
		this.positionDelFlag = positionDelFlag;
	}

	/* 语言编码	*/ 
	private String systemLanguageCode;

	/**
	 * 语言编码取得
	 * @return systemLanguageCode
	 */
	public String getSystemLanguageCode() {
		return systemLanguageCode;
	}

	/**
	 * 语言编码设定
	 * @param systemLanguageCode
	 */
	public void setSystemLanguageCode(String systemLanguageCode) {
		this.systemLanguageCode = systemLanguageCode;
	}

	/* 删除区分(0有效1删除)	*/ 
	private String systemDelFlag;

	/**
	 * 删除区分(0有效1删除)取得
	 * @return systemDelFlag
	 */
	public String getSystemDelFlag() {
		return systemDelFlag;
	}

	/**
	 * 删除区分(0有效1删除)设定
	 * @param systemDelFlag
	 */
	public void setSystemDelFlag(String systemDelFlag) {
		this.systemDelFlag = systemDelFlag;
	}

	/* 语言编码	*/ 
	private String capabilityLanguageCode;

	/**
	 * 语言编码取得
	 * @return capabilityLanguageCode
	 */
	public String getCapabilityLanguageCode() {
		return capabilityLanguageCode;
	}

	/**
	 * 语言编码设定
	 * @param capabilityLanguageCode
	 */
	public void setCapabilityLanguageCode(String capabilityLanguageCode) {
		this.capabilityLanguageCode = capabilityLanguageCode;
	}

	/* 删除区分(0有效1删除)	*/ 
	private String capabilityDelFlag;

	/**
	 * 删除区分(0有效1删除)取得
	 * @return capabilityDelFlag
	 */
	public String getCapabilityDelFlag() {
		return capabilityDelFlag;
	}

	/**
	 * 删除区分(0有效1删除)设定
	 * @param capabilityDelFlag
	 */
	public void setCapabilityDelFlag(String capabilityDelFlag) {
		this.capabilityDelFlag = capabilityDelFlag;
	}

	/* 语言编码	*/ 
	private String agencyLanguageCode;

	/**
	 * 语言编码取得
	 * @return agencyLanguageCode
	 */
	public String getAgencyLanguageCode() {
		return agencyLanguageCode;
	}

	/**
	 * 语言编码设定
	 * @param agencyLanguageCode
	 */
	public void setAgencyLanguageCode(String agencyLanguageCode) {
		this.agencyLanguageCode = agencyLanguageCode;
	}

	/* 删除区分(0有效1删除)	*/ 
	private String agencyDelFlag;

	/**
	 * 删除区分(0有效1删除)取得
	 * @return agencyDelFlag
	 */
	public String getAgencyDelFlag() {
		return agencyDelFlag;
	}

	/**
	 * 删除区分(0有效1删除)设定
	 * @param agencyDelFlag
	 */
	public void setAgencyDelFlag(String agencyDelFlag) {
		this.agencyDelFlag = agencyDelFlag;
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

	/* 上级功能ID	*/ 
	private String capCapabilityID;

	/**
	 * 上级功能ID取得
	 * @return capCapabilityID
	 */
	public String getCapCapabilityID() {
		return capCapabilityID;
	}

	/**
	 * 上级功能ID设定
	 * @param capCapabilityID
	 */
	public void setCapCapabilityID(String capCapabilityID) {
		this.capCapabilityID = capCapabilityID;
	}

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
}

