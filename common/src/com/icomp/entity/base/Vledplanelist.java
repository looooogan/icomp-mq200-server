/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/28 16:09:55
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/28 16:09:55
 * 创建者  ：杨作庆
 * 
 */
public class Vledplanelist extends VledplanelistWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 专机领用申请ID	*/ 
	private String ledPlaneID;

	/**
	 * 专机领用申请ID取得
	 * @return ledPlaneID
	 */
	public String getLedPlaneID() {
		return ledPlaneID;
	}

	/**
	 * 专机领用申请ID设定
	 * @param ledPlaneID
	 */
	public void setLedPlaneID(String ledPlaneID) {
		this.ledPlaneID = ledPlaneID;
	}

	/* 刀具ID	*/ 
	private String toolID;

	/**
	 * 刀具ID取得
	 * @return toolID
	 */
	public String getToolID() {
		return toolID;
	}

	/**
	 * 刀具ID设定
	 * @param toolID
	 */
	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	/* 领用数量	*/ 
	private BigDecimal ledPlaneCount;

	/**
	 * 领用数量取得
	 * @return ledPlaneCount
	 */
	public BigDecimal getLedPlaneCount() {
		return ledPlaneCount;
	}

	/**
	 * 领用数量设定
	 * @param ledPlaneCount
	 */
	public void setLedPlaneCount(BigDecimal ledPlaneCount) {
		this.ledPlaneCount = ledPlaneCount;
	}

	/* 领用时间	*/ 
	private Date ledPlaneTime;

	/**
	 * 领用时间取得
	 * @return ledPlaneTime
	 */
	public Date getLedPlaneTime() {
		return ledPlaneTime;
	}

	/**
	 * 领用时间设定
	 * @param ledPlaneTime
	 */
	public void setLedPlaneTime(Date ledPlaneTime) {
		this.ledPlaneTime = ledPlaneTime;
	}

	/* 领用人	*/ 
	private String ledPlaneUser;

	/**
	 * 领用人取得
	 * @return ledPlaneUser
	 */
	public String getLedPlaneUser() {
		return ledPlaneUser;
	}

	/**
	 * 领用人设定
	 * @param ledPlaneUser
	 */
	public void setLedPlaneUser(String ledPlaneUser) {
		this.ledPlaneUser = ledPlaneUser;
	}

	/* 送回数量	*/ 
	private BigDecimal returnCount;

	/**
	 * 送回数量取得
	 * @return returnCount
	 */
	public BigDecimal getReturnCount() {
		return returnCount;
	}

	/**
	 * 送回数量设定
	 * @param returnCount
	 */
	public void setReturnCount(BigDecimal returnCount) {
		this.returnCount = returnCount;
	}

	/* 送回时间	*/ 
	private Date returnTime;

	/**
	 * 送回时间取得
	 * @return returnTime
	 */
	public Date getReturnTime() {
		return returnTime;
	}

	/**
	 * 送回时间设定
	 * @param returnTime
	 */
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	/* 处理状态(0:新建1备货2领取3送回确认)	*/ 
	private String ledPlaneStauts;

	/**
	 * 处理状态(0:新建1备货2领取3送回确认)取得
	 * @return ledPlaneStauts
	 */
	public String getLedPlaneStauts() {
		return ledPlaneStauts;
	}

	/**
	 * 处理状态(0:新建1备货2领取3送回确认)设定
	 * @param ledPlaneStauts
	 */
	public void setLedPlaneStauts(String ledPlaneStauts) {
		this.ledPlaneStauts = ledPlaneStauts;
	}

	/* 刀具编码	*/ 
	private String toolCode;

	/**
	 * 刀具编码取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 刀具编码设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 姓名	*/ 
	private String userName;

	/**
	 * 姓名取得
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 姓名设定
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
}

