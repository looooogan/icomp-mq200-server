/*
 * 工具自动生成：授权表条件实体类
 * 生成时间    : 2016/05/17 18:19:15
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;


/**
 * 授权表条件实体类
 * @author 工具自动生成
 * 创建时间：2016/05/17 18:19:15
 * 创建者  ：工具自动生成
 * 
 */
public class AuthorizationWhere extends BaseEntity implements Serializable {

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

	/* 授权人ID	*/ 
	private String authorizationUserIDWhere;

	/**
	 * 授权人ID取得
	 * @return authorizationUserIDWhere
	 */
	public String getAuthorizationUserIDWhere () {
		return authorizationUserIDWhere;
	}

	/**
	 * 授权人ID设定
	 * @param authorizationUserIDWhere
	 */
	public void setAuthorizationUserIDWhere (String authorizationUserIDWhere) {
		this.authorizationUserIDWhere = authorizationUserIDWhere;
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

	/* 刀具类型（0单品，1合成刀具）	*/ 
	private String tooltypeWhere;

	/**
	 * 刀具类型（0单品，1合成刀具）取得
	 * @return tooltypeWhere
	 */
	public String getTooltypeWhere () {
		return tooltypeWhere;
	}

	/**
	 * 刀具类型（0单品，1合成刀具）设定
	 * @param tooltypeWhere
	 */
	public void setTooltypeWhere (String tooltypeWhere) {
		this.tooltypeWhere = tooltypeWhere;
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

	/* 创建人	*/ 
	private String createUserIDWhere;

	/**
	 * 创建人取得
	 * @return createUserIDWhere
	 */
	public String getCreateUserIDWhere () {
		return createUserIDWhere;
	}

	/**
	 * 创建人设定
	 * @param createUserIDWhere
	 */
	public void setCreateUserIDWhere (String createUserIDWhere) {
		this.createUserIDWhere = createUserIDWhere;
	}

	/* 备注（情况简述）	*/ 
	private String noteWhere;

	/**
	 * 备注（情况简述）取得
	 * @return noteWhere
	 */
	public String getNoteWhere () {
		return noteWhere;
	}

	/**
	 * 备注（情况简述）设定
	 * @param noteWhere
	 */
	public void setNoteWhere (String noteWhere) {
		this.noteWhere = noteWhere;
	}
}

