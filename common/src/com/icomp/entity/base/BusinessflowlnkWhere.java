/*
 * 工具自动生成：业务-流程中间表条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * 业务-流程中间表条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class BusinessflowlnkWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 业务-流程中间表ID	*/ 
	private String businessFlowLnkIDWhere;

	/**
	 * 业务-流程中间表ID取得
	 * @return businessFlowLnkIDWhere
	 */
	public String getBusinessFlowLnkIDWhere () {
		return businessFlowLnkIDWhere;
	}

	/**
	 * 业务-流程中间表ID设定
	 * @param businessFlowLnkIDWhere
	 */
	public void setBusinessFlowLnkIDWhere (String businessFlowLnkIDWhere) {
		this.businessFlowLnkIDWhere = businessFlowLnkIDWhere;
	}

	/* 业务流程ID	*/ 
	private String businessIDWhere;

	/**
	 * 业务流程ID取得
	 * @return businessIDWhere
	 */
	public String getBusinessIDWhere () {
		return businessIDWhere;
	}

	/**
	 * 业务流程ID设定
	 * @param businessIDWhere
	 */
	public void setBusinessIDWhere (String businessIDWhere) {
		this.businessIDWhere = businessIDWhere;
	}

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

	/* 功能ID	*/ 
	private String capabilityIDWhere;

	/**
	 * 功能ID取得
	 * @return capabilityIDWhere
	 */
	public String getCapabilityIDWhere () {
		return capabilityIDWhere;
	}

	/**
	 * 功能ID设定
	 * @param capabilityIDWhere
	 */
	public void setCapabilityIDWhere (String capabilityIDWhere) {
		this.capabilityIDWhere = capabilityIDWhere;
	}

	/* 流程顺序	*/ 
	private BigDecimal orderNumberWhere;

	/**
	 * 流程顺序取得
	 * @return orderNumberWhere
	 */
	public BigDecimal getOrderNumberWhere () {
		return orderNumberWhere;
	}

	/**
	 * 流程顺序设定
	 * @param orderNumberWhere
	 */
	public void setOrderNumberWhere (BigDecimal orderNumberWhere) {
		this.orderNumberWhere = orderNumberWhere;
	}
}

