/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/08/04 11:22:50
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.Date;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/08/04 11:22:50
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vauthorization extends VauthorizationWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 授权ID	*/ 
	private String authorizationID;

	/**
	 * 授权ID取得
	 * @return authorizationID
	 */
	public String getAuthorizationID() {
		return authorizationID;
	}

	/**
	 * 授权ID设定
	 * @param authorizationID
	 */
	public void setAuthorizationID(String authorizationID) {
		this.authorizationID = authorizationID;
	}

	/* 授权原因（0.断刀1.丢刀2.补领）	*/ 
	private String authorizedReason;

	/**
	 * 授权原因（0.断刀1.丢刀2.补领）取得
	 * @return authorizedReason
	 */
	public String getAuthorizedReason() {
		return authorizedReason;
	}

	/**
	 * 授权原因（0.断刀1.丢刀2.补领）设定
	 * @param authorizedReason
	 */
	public void setAuthorizedReason(String authorizedReason) {
		this.authorizedReason = authorizedReason;
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

	/* 材料号或合成刀具编码	*/ 
	private String toolCode;

	/**
	 * 材料号或合成刀具编码取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 材料号或合成刀具编码设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 授权时间	*/ 
	private Date authorizedTime;

	/**
	 * 授权时间取得
	 * @return authorizedTime
	 */
	public Date getAuthorizedTime() {
		return authorizedTime;
	}

	/**
	 * 授权时间设定
	 * @param authorizedTime
	 */
	public void setAuthorizedTime(Date authorizedTime) {
		this.authorizedTime = authorizedTime;
	}

	/* 	*/ 
	private String authorizationUser;

	/**
	 * 取得
	 * @return authorizationUser
	 */
	public String getAuthorizationUser() {
		return authorizationUser;
	}

	/**
	 * 设定
	 * @param authorizationUser
	 */
	public void setAuthorizationUser(String authorizationUser) {
		this.authorizationUser = authorizationUser;
	}

	/* 	*/ 
	private String empCard;

	/**
	 * 取得
	 * @return empCard
	 */
	public String getEmpCard() {
		return empCard;
	}

	/**
	 * 设定
	 * @param empCard
	 */
	public void setEmpCard(String empCard) {
		this.empCard = empCard;
	}

	/* 	*/ 
	private String businessID;

	/**
	 * 取得
	 * @return businessID
	 */
	public String getBusinessID() {
		return businessID;
	}

	/**
	 * 设定
	 * @param businessID
	 */
	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}

	/* 	*/ 
	private String businessName;

	/**
	 * 取得
	 * @return businessName
	 */
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * 设定
	 * @param businessName
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/* 业务流程编码	*/ 
	private String businessCode;

	/**
	 * 业务流程编码取得
	 * @return businessCode
	 */
	public String getBusinessCode() {
		return businessCode;
	}

	/**
	 * 业务流程编码设定
	 * @param businessCode
	 */
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	/* 备注（情况简介）	*/ 
	private String note;

	/**
	 * 备注（情况简介）取得
	 * @return note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * 备注（情况简介）设定
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/* 授权原因（0.断刀1.丢刀2.补领）	*/ 
	private String toolReason;

	/**
	 * 授权原因（0.断刀1.丢刀2.补领）取得
	 * @return toolReason
	 */
	public String getToolReason() {
		return toolReason;
	}

	/**
	 * 授权原因（0.断刀1.丢刀2.补领）设定
	 * @param toolReason
	 */
	public void setToolReason(String toolReason) {
		this.toolReason = toolReason;
	}

	/* 	*/ 
	private String operator;

	/**
	 * 取得
	 * @return operator
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * 设定
	 * @param operator
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
}

