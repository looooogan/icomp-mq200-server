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
public class Vagency extends VagencyWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 机构ID	*/ 
	private String age_AgencyID;

	/**
	 * 机构ID取得
	 * @return age_AgencyID
	 */
	public String getAge_AgencyID() {
		return age_AgencyID;
	}

	/**
	 * 机构ID设定
	 * @param age_AgencyID
	 */
	public void setAge_AgencyID(String age_AgencyID) {
		this.age_AgencyID = age_AgencyID;
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

	/* 创建者	*/ 
	private String agencyCreateUser;

	/**
	 * 创建者取得
	 * @return agencyCreateUser
	 */
	public String getAgencyCreateUser() {
		return agencyCreateUser;
	}

	/**
	 * 创建者设定
	 * @param agencyCreateUser
	 */
	public void setAgencyCreateUser(String agencyCreateUser) {
		this.agencyCreateUser = agencyCreateUser;
	}

	/* 创建时间	*/ 
	private Date agencyCreateTime;

	/**
	 * 创建时间取得
	 * @return agencyCreateTime
	 */
	public Date getAgencyCreateTime() {
		return agencyCreateTime;
	}

	/**
	 * 创建时间设定
	 * @param agencyCreateTime
	 */
	public void setAgencyCreateTime(Date agencyCreateTime) {
		this.agencyCreateTime = agencyCreateTime;
	}

	/* 更新者	*/ 
	private String agencyUpdateUser;

	/**
	 * 更新者取得
	 * @return agencyUpdateUser
	 */
	public String getAgencyUpdateUser() {
		return agencyUpdateUser;
	}

	/**
	 * 更新者设定
	 * @param agencyUpdateUser
	 */
	public void setAgencyUpdateUser(String agencyUpdateUser) {
		this.agencyUpdateUser = agencyUpdateUser;
	}

	/* 更新时间	*/ 
	private Date agencyUpdateTime;

	/**
	 * 更新时间取得
	 * @return agencyUpdateTime
	 */
	public Date getAgencyUpdateTime() {
		return agencyUpdateTime;
	}

	/**
	 * 更新时间设定
	 * @param agencyUpdateTime
	 */
	public void setAgencyUpdateTime(Date agencyUpdateTime) {
		this.agencyUpdateTime = agencyUpdateTime;
	}

	/* 版本号	*/ 
	private BigDecimal agencyVersion;

	/**
	 * 版本号取得
	 * @return agencyVersion
	 */
	public BigDecimal getAgencyVersion() {
		return agencyVersion;
	}

	/**
	 * 版本号设定
	 * @param agencyVersion
	 */
	public void setAgencyVersion(BigDecimal agencyVersion) {
		this.agencyVersion = agencyVersion;
	}
}

