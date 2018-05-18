/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class VgrantlistWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 用户类型(0系统用户1普通用户)	*/ 
	private String userTypeWhere;

	/**
	 * 用户类型(0系统用户1普通用户)取得
	 * @return userTypeWhere
	 */
	public String getUserTypeWhere () {
		return userTypeWhere;
	}

	/**
	 * 用户类型(0系统用户1普通用户)设定
	 * @param userTypeWhere
	 */
	public void setUserTypeWhere (String userTypeWhere) {
		this.userTypeWhere = userTypeWhere;
	}

	/* 用户名[16位数字字母组合]	*/ 
	private String userNameWhere;

	/**
	 * 用户名[16位数字字母组合]取得
	 * @return userNameWhere
	 */
	public String getUserNameWhere () {
		return userNameWhere;
	}

	/**
	 * 用户名[16位数字字母组合]设定
	 * @param userNameWhere
	 */
	public void setUserNameWhere (String userNameWhere) {
		this.userNameWhere = userNameWhere;
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

	/* 职务编码	*/ 
	private String positionCodeWhere;

	/**
	 * 职务编码取得
	 * @return positionCodeWhere
	 */
	public String getPositionCodeWhere () {
		return positionCodeWhere;
	}

	/**
	 * 职务编码设定
	 * @param positionCodeWhere
	 */
	public void setPositionCodeWhere (String positionCodeWhere) {
		this.positionCodeWhere = positionCodeWhere;
	}

	/* 部门名称	*/ 
	private String departmentNameWhere;

	/**
	 * 部门名称取得
	 * @return departmentNameWhere
	 */
	public String getDepartmentNameWhere () {
		return departmentNameWhere;
	}

	/**
	 * 部门名称设定
	 * @param departmentNameWhere
	 */
	public void setDepartmentNameWhere (String departmentNameWhere) {
		this.departmentNameWhere = departmentNameWhere;
	}

	/* 部门编码	*/ 
	private String departmentCodeWhere;

	/**
	 * 部门编码取得
	 * @return departmentCodeWhere
	 */
	public String getDepartmentCodeWhere () {
		return departmentCodeWhere;
	}

	/**
	 * 部门编码设定
	 * @param departmentCodeWhere
	 */
	public void setDepartmentCodeWhere (String departmentCodeWhere) {
		this.departmentCodeWhere = departmentCodeWhere;
	}

	/* 部门电话	*/ 
	private String departmentTelWhere;

	/**
	 * 部门电话取得
	 * @return departmentTelWhere
	 */
	public String getDepartmentTelWhere () {
		return departmentTelWhere;
	}

	/**
	 * 部门电话设定
	 * @param departmentTelWhere
	 */
	public void setDepartmentTelWhere (String departmentTelWhere) {
		this.departmentTelWhere = departmentTelWhere;
	}

	/* 部门负责人	*/ 
	private String departmentHeadWhere;

	/**
	 * 部门负责人取得
	 * @return departmentHeadWhere
	 */
	public String getDepartmentHeadWhere () {
		return departmentHeadWhere;
	}

	/**
	 * 部门负责人设定
	 * @param departmentHeadWhere
	 */
	public void setDepartmentHeadWhere (String departmentHeadWhere) {
		this.departmentHeadWhere = departmentHeadWhere;
	}

	/* 负责人手机	*/ 
	private String departmentHeadMobileWhere;

	/**
	 * 负责人手机取得
	 * @return departmentHeadMobileWhere
	 */
	public String getDepartmentHeadMobileWhere () {
		return departmentHeadMobileWhere;
	}

	/**
	 * 负责人手机设定
	 * @param departmentHeadMobileWhere
	 */
	public void setDepartmentHeadMobileWhere (String departmentHeadMobileWhere) {
		this.departmentHeadMobileWhere = departmentHeadMobileWhere;
	}

	/* 负责人电话	*/ 
	private String departmentHeadTelWhere;

	/**
	 * 负责人电话取得
	 * @return departmentHeadTelWhere
	 */
	public String getDepartmentHeadTelWhere () {
		return departmentHeadTelWhere;
	}

	/**
	 * 负责人电话设定
	 * @param departmentHeadTelWhere
	 */
	public void setDepartmentHeadTelWhere (String departmentHeadTelWhere) {
		this.departmentHeadTelWhere = departmentHeadTelWhere;
	}

	/* 部门成立时间	*/ 
	private String departmentCdateWhere;

	/**
	 * 部门成立时间取得
	 * @return departmentCdateWhere
	 */
	public String getDepartmentCdateWhere () {
		return departmentCdateWhere;
	}

	/**
	 * 部门成立时间设定
	 * @param departmentCdateWhere
	 */
	public void setDepartmentCdateWhere (String departmentCdateWhere) {
		this.departmentCdateWhere = departmentCdateWhere;
	}

	/* 部门描述	*/ 
	private String departmentDescriptionWhere;

	/**
	 * 部门描述取得
	 * @return departmentDescriptionWhere
	 */
	public String getDepartmentDescriptionWhere () {
		return departmentDescriptionWhere;
	}

	/**
	 * 部门描述设定
	 * @param departmentDescriptionWhere
	 */
	public void setDepartmentDescriptionWhere (String departmentDescriptionWhere) {
		this.departmentDescriptionWhere = departmentDescriptionWhere;
	}

	/* 机构编码	*/ 
	private String agencyCodeWhere;

	/**
	 * 机构编码取得
	 * @return agencyCodeWhere
	 */
	public String getAgencyCodeWhere () {
		return agencyCodeWhere;
	}

	/**
	 * 机构编码设定
	 * @param agencyCodeWhere
	 */
	public void setAgencyCodeWhere (String agencyCodeWhere) {
		this.agencyCodeWhere = agencyCodeWhere;
	}

	/* 机构名称	*/ 
	private String agencyNameWhere;

	/**
	 * 机构名称取得
	 * @return agencyNameWhere
	 */
	public String getAgencyNameWhere () {
		return agencyNameWhere;
	}

	/**
	 * 机构名称设定
	 * @param agencyNameWhere
	 */
	public void setAgencyNameWhere (String agencyNameWhere) {
		this.agencyNameWhere = agencyNameWhere;
	}

	/* 机构电话	*/ 
	private String agencyTelWhere;

	/**
	 * 机构电话取得
	 * @return agencyTelWhere
	 */
	public String getAgencyTelWhere () {
		return agencyTelWhere;
	}

	/**
	 * 机构电话设定
	 * @param agencyTelWhere
	 */
	public void setAgencyTelWhere (String agencyTelWhere) {
		this.agencyTelWhere = agencyTelWhere;
	}

	/* 机构创立时间	*/ 
	private String agencyCdateWhere;

	/**
	 * 机构创立时间取得
	 * @return agencyCdateWhere
	 */
	public String getAgencyCdateWhere () {
		return agencyCdateWhere;
	}

	/**
	 * 机构创立时间设定
	 * @param agencyCdateWhere
	 */
	public void setAgencyCdateWhere (String agencyCdateWhere) {
		this.agencyCdateWhere = agencyCdateWhere;
	}

	/* 机构法人	*/ 
	private String agencyCorporateWhere;

	/**
	 * 机构法人取得
	 * @return agencyCorporateWhere
	 */
	public String getAgencyCorporateWhere () {
		return agencyCorporateWhere;
	}

	/**
	 * 机构法人设定
	 * @param agencyCorporateWhere
	 */
	public void setAgencyCorporateWhere (String agencyCorporateWhere) {
		this.agencyCorporateWhere = agencyCorporateWhere;
	}

	/* 权限开始时间	*/ 
	private Date gendDateWhere;

	/**
	 * 权限开始时间取得
	 * @return gendDateWhere
	 */
	public Date getGendDateWhere () {
		return gendDateWhere;
	}

	/**
	 * 权限开始时间设定
	 * @param gendDateWhere
	 */
	public void setGendDateWhere (Date gendDateWhere) {
		this.gendDateWhere = gendDateWhere;
	}

	/* 权限开始时间	*/ 
	private Date gstrDateWhere;

	/**
	 * 权限开始时间取得
	 * @return gstrDateWhere
	 */
	public Date getGstrDateWhere () {
		return gstrDateWhere;
	}

	/**
	 * 权限开始时间设定
	 * @param gstrDateWhere
	 */
	public void setGstrDateWhere (Date gstrDateWhere) {
		this.gstrDateWhere = gstrDateWhere;
	}

	/* 功能编码	*/ 
	private String capabilityCodeWhere;

	/**
	 * 功能编码取得
	 * @return capabilityCodeWhere
	 */
	public String getCapabilityCodeWhere () {
		return capabilityCodeWhere;
	}

	/**
	 * 功能编码设定
	 * @param capabilityCodeWhere
	 */
	public void setCapabilityCodeWhere (String capabilityCodeWhere) {
		this.capabilityCodeWhere = capabilityCodeWhere;
	}

	/* 功能名称	*/ 
	private String capabilityNameWhere;

	/**
	 * 功能名称取得
	 * @return capabilityNameWhere
	 */
	public String getCapabilityNameWhere () {
		return capabilityNameWhere;
	}

	/**
	 * 功能名称设定
	 * @param capabilityNameWhere
	 */
	public void setCapabilityNameWhere (String capabilityNameWhere) {
		this.capabilityNameWhere = capabilityNameWhere;
	}

	/* 功能级别	*/ 
	private BigDecimal capabilityLevelWhere;

	/**
	 * 功能级别取得
	 * @return capabilityLevelWhere
	 */
	public BigDecimal getCapabilityLevelWhere () {
		return capabilityLevelWhere;
	}

	/**
	 * 功能级别设定
	 * @param capabilityLevelWhere
	 */
	public void setCapabilityLevelWhere (BigDecimal capabilityLevelWhere) {
		this.capabilityLevelWhere = capabilityLevelWhere;
	}

	/* 功能顺序	*/ 
	private BigDecimal capabilityOrderWhere;

	/**
	 * 功能顺序取得
	 * @return capabilityOrderWhere
	 */
	public BigDecimal getCapabilityOrderWhere () {
		return capabilityOrderWhere;
	}

	/**
	 * 功能顺序设定
	 * @param capabilityOrderWhere
	 */
	public void setCapabilityOrderWhere (BigDecimal capabilityOrderWhere) {
		this.capabilityOrderWhere = capabilityOrderWhere;
	}

	/* 功能URL	*/ 
	private String capabilityUrlWhere;

	/**
	 * 功能URL取得
	 * @return capabilityUrlWhere
	 */
	public String getCapabilityUrlWhere () {
		return capabilityUrlWhere;
	}

	/**
	 * 功能URL设定
	 * @param capabilityUrlWhere
	 */
	public void setCapabilityUrlWhere (String capabilityUrlWhere) {
		this.capabilityUrlWhere = capabilityUrlWhere;
	}

	/* 功能图片	*/ 
	private String capabilityImgWhere;

	/**
	 * 功能图片取得
	 * @return capabilityImgWhere
	 */
	public String getCapabilityImgWhere () {
		return capabilityImgWhere;
	}

	/**
	 * 功能图片设定
	 * @param capabilityImgWhere
	 */
	public void setCapabilityImgWhere (String capabilityImgWhere) {
		this.capabilityImgWhere = capabilityImgWhere;
	}

	/* 归属区分(0:管理平台1:手持机9:手持机授权)	*/ 
	private String belongFlagWhere;

	/**
	 * 归属区分(0:管理平台1:手持机9:手持机授权)取得
	 * @return belongFlagWhere
	 */
	public String getBelongFlagWhere () {
		return belongFlagWhere;
	}

	/**
	 * 归属区分(0:管理平台1:手持机9:手持机授权)设定
	 * @param belongFlagWhere
	 */
	public void setBelongFlagWhere (String belongFlagWhere) {
		this.belongFlagWhere = belongFlagWhere;
	}

	/* 是否菜单(0是1否)	*/ 
	private String menuFlagWhere;

	/**
	 * 是否菜单(0是1否)取得
	 * @return menuFlagWhere
	 */
	public String getMenuFlagWhere () {
		return menuFlagWhere;
	}

	/**
	 * 是否菜单(0是1否)设定
	 * @param menuFlagWhere
	 */
	public void setMenuFlagWhere (String menuFlagWhere) {
		this.menuFlagWhere = menuFlagWhere;
	}

	/* 系统编码	*/ 
	private String systemCodeWhere;

	/**
	 * 系统编码取得
	 * @return systemCodeWhere
	 */
	public String getSystemCodeWhere () {
		return systemCodeWhere;
	}

	/**
	 * 系统编码设定
	 * @param systemCodeWhere
	 */
	public void setSystemCodeWhere (String systemCodeWhere) {
		this.systemCodeWhere = systemCodeWhere;
	}

	/* 系统名称	*/ 
	private String systemNameWhere;

	/**
	 * 系统名称取得
	 * @return systemNameWhere
	 */
	public String getSystemNameWhere () {
		return systemNameWhere;
	}

	/**
	 * 系统名称设定
	 * @param systemNameWhere
	 */
	public void setSystemNameWhere (String systemNameWhere) {
		this.systemNameWhere = systemNameWhere;
	}

	/* 语言编码	*/ 
	private String positionLanguageCodeWhere;

	/**
	 * 语言编码取得
	 * @return positionLanguageCodeWhere
	 */
	public String getPositionLanguageCodeWhere () {
		return positionLanguageCodeWhere;
	}

	/**
	 * 语言编码设定
	 * @param positionLanguageCodeWhere
	 */
	public void setPositionLanguageCodeWhere (String positionLanguageCodeWhere) {
		this.positionLanguageCodeWhere = positionLanguageCodeWhere;
	}

	/* 删除区分(0有效1删除)	*/ 
	private String positionDelFlagWhere;

	/**
	 * 删除区分(0有效1删除)取得
	 * @return positionDelFlagWhere
	 */
	public String getPositionDelFlagWhere () {
		return positionDelFlagWhere;
	}

	/**
	 * 删除区分(0有效1删除)设定
	 * @param positionDelFlagWhere
	 */
	public void setPositionDelFlagWhere (String positionDelFlagWhere) {
		this.positionDelFlagWhere = positionDelFlagWhere;
	}

	/* 语言编码	*/ 
	private String systemLanguageCodeWhere;

	/**
	 * 语言编码取得
	 * @return systemLanguageCodeWhere
	 */
	public String getSystemLanguageCodeWhere () {
		return systemLanguageCodeWhere;
	}

	/**
	 * 语言编码设定
	 * @param systemLanguageCodeWhere
	 */
	public void setSystemLanguageCodeWhere (String systemLanguageCodeWhere) {
		this.systemLanguageCodeWhere = systemLanguageCodeWhere;
	}

	/* 删除区分(0有效1删除)	*/ 
	private String systemDelFlagWhere;

	/**
	 * 删除区分(0有效1删除)取得
	 * @return systemDelFlagWhere
	 */
	public String getSystemDelFlagWhere () {
		return systemDelFlagWhere;
	}

	/**
	 * 删除区分(0有效1删除)设定
	 * @param systemDelFlagWhere
	 */
	public void setSystemDelFlagWhere (String systemDelFlagWhere) {
		this.systemDelFlagWhere = systemDelFlagWhere;
	}

	/* 语言编码	*/ 
	private String capabilityLanguageCodeWhere;

	/**
	 * 语言编码取得
	 * @return capabilityLanguageCodeWhere
	 */
	public String getCapabilityLanguageCodeWhere () {
		return capabilityLanguageCodeWhere;
	}

	/**
	 * 语言编码设定
	 * @param capabilityLanguageCodeWhere
	 */
	public void setCapabilityLanguageCodeWhere (String capabilityLanguageCodeWhere) {
		this.capabilityLanguageCodeWhere = capabilityLanguageCodeWhere;
	}

	/* 删除区分(0有效1删除)	*/ 
	private String capabilityDelFlagWhere;

	/**
	 * 删除区分(0有效1删除)取得
	 * @return capabilityDelFlagWhere
	 */
	public String getCapabilityDelFlagWhere () {
		return capabilityDelFlagWhere;
	}

	/**
	 * 删除区分(0有效1删除)设定
	 * @param capabilityDelFlagWhere
	 */
	public void setCapabilityDelFlagWhere (String capabilityDelFlagWhere) {
		this.capabilityDelFlagWhere = capabilityDelFlagWhere;
	}

	/* 语言编码	*/ 
	private String agencyLanguageCodeWhere;

	/**
	 * 语言编码取得
	 * @return agencyLanguageCodeWhere
	 */
	public String getAgencyLanguageCodeWhere () {
		return agencyLanguageCodeWhere;
	}

	/**
	 * 语言编码设定
	 * @param agencyLanguageCodeWhere
	 */
	public void setAgencyLanguageCodeWhere (String agencyLanguageCodeWhere) {
		this.agencyLanguageCodeWhere = agencyLanguageCodeWhere;
	}

	/* 删除区分(0有效1删除)	*/ 
	private String agencyDelFlagWhere;

	/**
	 * 删除区分(0有效1删除)取得
	 * @return agencyDelFlagWhere
	 */
	public String getAgencyDelFlagWhere () {
		return agencyDelFlagWhere;
	}

	/**
	 * 删除区分(0有效1删除)设定
	 * @param agencyDelFlagWhere
	 */
	public void setAgencyDelFlagWhere (String agencyDelFlagWhere) {
		this.agencyDelFlagWhere = agencyDelFlagWhere;
	}

	/* 语言编码	*/ 
	private String departmentLanguageCodeWhere;

	/**
	 * 语言编码取得
	 * @return departmentLanguageCodeWhere
	 */
	public String getDepartmentLanguageCodeWhere () {
		return departmentLanguageCodeWhere;
	}

	/**
	 * 语言编码设定
	 * @param departmentLanguageCodeWhere
	 */
	public void setDepartmentLanguageCodeWhere (String departmentLanguageCodeWhere) {
		this.departmentLanguageCodeWhere = departmentLanguageCodeWhere;
	}

	/* 删除区分(0有效1删除)	*/ 
	private String departmentDelFlagWhere;

	/**
	 * 删除区分(0有效1删除)取得
	 * @return departmentDelFlagWhere
	 */
	public String getDepartmentDelFlagWhere () {
		return departmentDelFlagWhere;
	}

	/**
	 * 删除区分(0有效1删除)设定
	 * @param departmentDelFlagWhere
	 */
	public void setDepartmentDelFlagWhere (String departmentDelFlagWhere) {
		this.departmentDelFlagWhere = departmentDelFlagWhere;
	}

	/* 上级功能ID	*/ 
	private String capCapabilityIDWhere;

	/**
	 * 上级功能ID取得
	 * @return capCapabilityIDWhere
	 */
	public String getCapCapabilityIDWhere () {
		return capCapabilityIDWhere;
	}

	/**
	 * 上级功能ID设定
	 * @param capCapabilityIDWhere
	 */
	public void setCapCapabilityIDWhere (String capCapabilityIDWhere) {
		this.capCapabilityIDWhere = capCapabilityIDWhere;
	}

	/* 功能ID	*/ 
	private String capabilityIDWhere;

	/**
	 * 功能ID取得
	 * @return capabilityIDWhere
	 */
	public String getCapabilityIDWhere () {
		return capabilityIDWhere;
	}

	/**
	 * 功能ID设定
	 * @param capabilityIDWhere
	 */
	public void setCapabilityIDWhere (String capabilityIDWhere) {
		this.capabilityIDWhere = capabilityIDWhere;
	}
}

