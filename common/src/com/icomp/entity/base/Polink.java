/*
 * 工具自动生成：职务-操作实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.Date;


/**
 * 职务-操作实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class Polink extends PolinkWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* PoLinkID	*/ 
	private String poLinkID;

	/**
	 * PoLinkID取得
	 * @return poLinkID
	 */
	public String getPoLinkID() {
		return poLinkID;
	}

	/**
	 * PoLinkID设定
	 * @param poLinkID
	 */
	public void setPoLinkID(String poLinkID) {
		this.poLinkID = poLinkID;
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
}

