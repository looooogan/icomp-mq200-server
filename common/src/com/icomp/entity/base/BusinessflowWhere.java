/*
 * 工具自动生成：业务流条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * 业务流条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class BusinessflowWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 业务流ID	*/ 
	private String businessFlowIDWhere;

	/**
	 * 业务流ID取得
	 * @return businessFlowIDWhere
	 */
	public String getBusinessFlowIDWhere () {
		return businessFlowIDWhere;
	}

	/**
	 * 业务流ID设定
	 * @param businessFlowIDWhere
	 */
	public void setBusinessFlowIDWhere (String businessFlowIDWhere) {
		this.businessFlowIDWhere = businessFlowIDWhere;
	}

	/* 业务流名称	*/ 
	private String businessFlowNameWhere;

	/**
	 * 业务流名称取得
	 * @return businessFlowNameWhere
	 */
	public String getBusinessFlowNameWhere () {
		return businessFlowNameWhere;
	}

	/**
	 * 业务流名称设定
	 * @param businessFlowNameWhere
	 */
	public void setBusinessFlowNameWhere (String businessFlowNameWhere) {
		this.businessFlowNameWhere = businessFlowNameWhere;
	}
}

