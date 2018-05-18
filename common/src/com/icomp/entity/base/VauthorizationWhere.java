/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/08/04 11:22:50
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/08/04 11:22:50
 * 创建者  ：工具自动生成
 * 
 */
public class VauthorizationWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 授权ID	*/ 
	private String authorizationIDWhere;

	/**
	 * 授权ID取得
	 * @return authorizationIDWhere
	 */
	public String getAuthorizationIDWhere () {
		return authorizationIDWhere;
	}

	/**
	 * 授权ID设定
	 * @param authorizationIDWhere
	 */
	public void setAuthorizationIDWhere (String authorizationIDWhere) {
		this.authorizationIDWhere = authorizationIDWhere;
	}

	/* 授权原因（0.断刀1.丢刀2.补领）	*/ 
	private String authorizedReasonWhere;

	/**
	 * 授权原因（0.断刀1.丢刀2.补领）取得
	 * @return authorizedReasonWhere
	 */
	public String getAuthorizedReasonWhere () {
		return authorizedReasonWhere;
	}

	/**
	 * 授权原因（0.断刀1.丢刀2.补领）设定
	 * @param authorizedReasonWhere
	 */
	public void setAuthorizedReasonWhere (String authorizedReasonWhere) {
		this.authorizedReasonWhere = authorizedReasonWhere;
	}

	/* 刀具ID	*/ 
	private String toolIDWhere;

	/**
	 * 刀具ID取得
	 * @return toolIDWhere
	 */
	public String getToolIDWhere () {
		return toolIDWhere;
	}

	/**
	 * 刀具ID设定
	 * @param toolIDWhere
	 */
	public void setToolIDWhere (String toolIDWhere) {
		this.toolIDWhere = toolIDWhere;
	}

	/* 材料号或合成刀具编码	*/ 
	private String toolCodeWhere;

	/**
	 * 材料号或合成刀具编码取得
	 * @return toolCodeWhere
	 */
	public String getToolCodeWhere () {
		return toolCodeWhere;
	}

	/**
	 * 材料号或合成刀具编码设定
	 * @param toolCodeWhere
	 */
	public void setToolCodeWhere (String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}

	/* 授权时间	*/ 
	private Date authorizedTimeWhere;

	/**
	 * 授权时间取得
	 * @return authorizedTimeWhere
	 */
	public Date getAuthorizedTimeWhere () {
		return authorizedTimeWhere;
	}

	/**
	 * 授权时间设定
	 * @param authorizedTimeWhere
	 */
	public void setAuthorizedTimeWhere (Date authorizedTimeWhere) {
		this.authorizedTimeWhere = authorizedTimeWhere;
	}

	/* 	*/ 
	private String authorizationUserWhere;

	/**
	 * 取得
	 * @return authorizationUserWhere
	 */
	public String getAuthorizationUserWhere () {
		return authorizationUserWhere;
	}

	/**
	 * 设定
	 * @param authorizationUserWhere
	 */
	public void setAuthorizationUserWhere (String authorizationUserWhere) {
		this.authorizationUserWhere = authorizationUserWhere;
	}

	/* 	*/ 
	private String empCardWhere;

	/**
	 * 取得
	 * @return empCardWhere
	 */
	public String getEmpCardWhere () {
		return empCardWhere;
	}

	/**
	 * 设定
	 * @param empCardWhere
	 */
	public void setEmpCardWhere (String empCardWhere) {
		this.empCardWhere = empCardWhere;
	}

	/* 	*/ 
	private String businessIDWhere;

	/**
	 * 取得
	 * @return businessIDWhere
	 */
	public String getBusinessIDWhere () {
		return businessIDWhere;
	}

	/**
	 * 设定
	 * @param businessIDWhere
	 */
	public void setBusinessIDWhere (String businessIDWhere) {
		this.businessIDWhere = businessIDWhere;
	}

	/* 	*/ 
	private String businessNameWhere;

	/**
	 * 取得
	 * @return businessNameWhere
	 */
	public String getBusinessNameWhere () {
		return businessNameWhere;
	}

	/**
	 * 设定
	 * @param businessNameWhere
	 */
	public void setBusinessNameWhere (String businessNameWhere) {
		this.businessNameWhere = businessNameWhere;
	}

	/* 业务流程编码	*/ 
	private String businessCodeWhere;

	/**
	 * 业务流程编码取得
	 * @return businessCodeWhere
	 */
	public String getBusinessCodeWhere () {
		return businessCodeWhere;
	}

	/**
	 * 业务流程编码设定
	 * @param businessCodeWhere
	 */
	public void setBusinessCodeWhere (String businessCodeWhere) {
		this.businessCodeWhere = businessCodeWhere;
	}

	/* 备注（情况简介）	*/ 
	private String noteWhere;

	/**
	 * 备注（情况简介）取得
	 * @return noteWhere
	 */
	public String getNoteWhere () {
		return noteWhere;
	}

	/**
	 * 备注（情况简介）设定
	 * @param noteWhere
	 */
	public void setNoteWhere (String noteWhere) {
		this.noteWhere = noteWhere;
	}

	/* 授权原因（0.断刀1.丢刀2.补领）	*/ 
	private String toolReasonWhere;

	/**
	 * 授权原因（0.断刀1.丢刀2.补领）取得
	 * @return toolReasonWhere
	 */
	public String getToolReasonWhere () {
		return toolReasonWhere;
	}

	/**
	 * 授权原因（0.断刀1.丢刀2.补领）设定
	 * @param toolReasonWhere
	 */
	public void setToolReasonWhere (String toolReasonWhere) {
		this.toolReasonWhere = toolReasonWhere;
	}

	/* 	*/ 
	private String operatorWhere;

	/**
	 * 取得
	 * @return operatorWhere
	 */
	public String getOperatorWhere () {
		return operatorWhere;
	}

	/**
	 * 设定
	 * @param operatorWhere
	 */
	public void setOperatorWhere (String operatorWhere) {
		this.operatorWhere = operatorWhere;
	}
}

