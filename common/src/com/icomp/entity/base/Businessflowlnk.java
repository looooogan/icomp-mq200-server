/*
 * 工具自动生成：业务-流程中间表实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 业务-流程中间表实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class Businessflowlnk extends BusinessflowlnkWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 业务-流程中间表ID	*/ 
	private String businessFlowLnkID;

	/**
	 * 业务-流程中间表ID取得
	 * @return businessFlowLnkID
	 */
	public String getBusinessFlowLnkID() {
		return businessFlowLnkID;
	}

	/**
	 * 业务-流程中间表ID设定
	 * @param businessFlowLnkID
	 */
	public void setBusinessFlowLnkID(String businessFlowLnkID) {
		this.businessFlowLnkID = businessFlowLnkID;
	}

	/* 业务流程ID	*/ 
	private String businessID;

	/**
	 * 业务流程ID取得
	 * @return businessID
	 */
	public String getBusinessID() {
		return businessID;
	}

	/**
	 * 业务流程ID设定
	 * @param businessID
	 */
	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}

	/* 业务流ID	*/ 
	private String businessFlowID;

	/**
	 * 业务流ID取得
	 * @return businessFlowID
	 */
	public String getBusinessFlowID() {
		return businessFlowID;
	}

	/**
	 * 业务流ID设定
	 * @param businessFlowID
	 */
	public void setBusinessFlowID(String businessFlowID) {
		this.businessFlowID = businessFlowID;
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

	/* 流程顺序	*/ 
	private BigDecimal orderNumber;

	/**
	 * 流程顺序取得
	 * @return orderNumber
	 */
	public BigDecimal getOrderNumber() {
		return orderNumber;
	}

	/**
	 * 流程顺序设定
	 * @param orderNumber
	 */
	public void setOrderNumber(BigDecimal orderNumber) {
		this.orderNumber = orderNumber;
	}
}

