/*
 * 工具自动生成：业务流实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * 业务流实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class Businessflow extends BusinessflowWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 业务流名称	*/ 
	private String businessFlowName;

	/**
	 * 业务流名称取得
	 * @return businessFlowName
	 */
	public String getBusinessFlowName() {
		return businessFlowName;
	}

	/**
	 * 业务流名称设定
	 * @param businessFlowName
	 */
	public void setBusinessFlowName(String businessFlowName) {
		this.businessFlowName = businessFlowName;
	}
}

