/*
 * 工具自动生成：到货计划实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 到货计划实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class Deliveryplan extends DeliveryplanWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 	*/ 
	private String deliveryPlanID;

	/**
	 * 取得
	 * @return deliveryPlanID
	 */
	public String getDeliveryPlanID() {
		return deliveryPlanID;
	}

	/**
	 * 设定
	 * @param deliveryPlanID
	 */
	public void setDeliveryPlanID(String deliveryPlanID) {
		this.deliveryPlanID = deliveryPlanID;
	}

	/* 采购ID	*/ 
	private String toolProcuredID;

	/**
	 * 采购ID取得
	 * @return toolProcuredID
	 */
	public String getToolProcuredID() {
		return toolProcuredID;
	}

	/**
	 * 采购ID设定
	 * @param toolProcuredID
	 */
	public void setToolProcuredID(String toolProcuredID) {
		this.toolProcuredID = toolProcuredID;
	}

	/* 预计到货时间	*/ 
	private Date theyTime;

	/**
	 * 预计到货时间取得
	 * @return theyTime
	 */
	public Date getTheyTime() {
		return theyTime;
	}

	/**
	 * 预计到货时间设定
	 * @param theyTime
	 */
	public void setTheyTime(Date theyTime) {
		this.theyTime = theyTime;
	}

	/* 预计到货数量	*/ 
	private BigDecimal theyCount;

	/**
	 * 预计到货数量取得
	 * @return theyCount
	 */
	public BigDecimal getTheyCount() {
		return theyCount;
	}

	/**
	 * 预计到货数量设定
	 * @param theyCount
	 */
	public void setTheyCount(BigDecimal theyCount) {
		this.theyCount = theyCount;
	}

	/* 实际到货时间	*/ 
	private Date realityTheyTime;

	/**
	 * 实际到货时间取得
	 * @return realityTheyTime
	 */
	public Date getRealityTheyTime() {
		return realityTheyTime;
	}

	/**
	 * 实际到货时间设定
	 * @param realityTheyTime
	 */
	public void setRealityTheyTime(Date realityTheyTime) {
		this.realityTheyTime = realityTheyTime;
	}

	/* 实际到货数量	*/ 
	private BigDecimal realityTheyCount;

	/**
	 * 实际到货数量取得
	 * @return realityTheyCount
	 */
	public BigDecimal getRealityTheyCount() {
		return realityTheyCount;
	}

	/**
	 * 实际到货数量设定
	 * @param realityTheyCount
	 */
	public void setRealityTheyCount(BigDecimal realityTheyCount) {
		this.realityTheyCount = realityTheyCount;
	}

	/* 货品状态(0未到货1已到货2质检通过3质检未通过)	*/ 
	private String theyStatus;

	/**
	 * 货品状态(0未到货1已到货2质检通过3质检未通过)取得
	 * @return theyStatus
	 */
	public String getTheyStatus() {
		return theyStatus;
	}

	/**
	 * 货品状态(0未到货1已到货2质检通过3质检未通过)设定
	 * @param theyStatus
	 */
	public void setTheyStatus(String theyStatus) {
		this.theyStatus = theyStatus;
	}

	/* 到货交接人	*/ 
	private String transferPeople;

	/**
	 * 到货交接人取得
	 * @return transferPeople
	 */
	public String getTransferPeople() {
		return transferPeople;
	}

	/**
	 * 到货交接人设定
	 * @param transferPeople
	 */
	public void setTransferPeople(String transferPeople) {
		this.transferPeople = transferPeople;
	}

	/* 质检人	*/ 
	private String inspectionUser;

	/**
	 * 质检人取得
	 * @return inspectionUser
	 */
	public String getInspectionUser() {
		return inspectionUser;
	}

	/**
	 * 质检人设定
	 * @param inspectionUser
	 */
	public void setInspectionUser(String inspectionUser) {
		this.inspectionUser = inspectionUser;
	}
}

