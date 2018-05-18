/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/20 09:58:01
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/20 09:58:01
 * 创建者  ：杨作庆
 * 
 */
public class Vprocessingtools extends VprocessingtoolsWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 	*/ 
	private BigDecimal toolCount;

	/**
	 * 取得
	 * @return toolCount
	 */
	public BigDecimal getToolCount() {
		return toolCount;
	}

	/**
	 * 设定
	 * @param toolCount
	 */
	public void setToolCount(BigDecimal toolCount) {
		this.toolCount = toolCount;
	}

	/* 	*/ 
	private String returnUser;

	/**
	 * 取得
	 * @return returnUser
	 */
	public String getReturnUser() {
		return returnUser;
	}

	/**
	 * 设定
	 * @param returnUser
	 */
	public void setReturnUser(String returnUser) {
		this.returnUser = returnUser;
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

	/* 	*/ 
	private String toolStatus;

	/**
	 * 取得
	 * @return toolStatus
	 */
	public String getToolStatus() {
		return toolStatus;
	}

	/**
	 * 设定
	 * @param toolStatus
	 */
	public void setToolStatus(String toolStatus) {
		this.toolStatus = toolStatus;
	}

}

