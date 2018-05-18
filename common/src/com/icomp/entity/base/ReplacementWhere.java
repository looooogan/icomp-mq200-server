/*
 * 工具自动生成：申领申请条件实体类
 * 生成时间    : 2016/05/24 19:40:49
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 申领申请条件实体类
 * @author 工具自动生成
 * 创建时间：2016/05/24 19:40:49
 * 创建者  ：工具自动生成
 * 
 */
public class ReplacementWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 申领申请流水号	*/ 
	private String replacementIDWhere;

	/**
	 * 申领申请流水号取得
	 * @return replacementIDWhere
	 */
	public String getReplacementIDWhere () {
		return replacementIDWhere;
	}

	/**
	 * 申领申请流水号设定
	 * @param replacementIDWhere
	 */
	public void setReplacementIDWhere (String replacementIDWhere) {
		this.replacementIDWhere = replacementIDWhere;
	}

	/* 刀具编码	*/ 
	private String toolCodeWhere;

	/**
	 * 刀具编码取得
	 * @return toolCodeWhere
	 */
	public String getToolCodeWhere () {
		return toolCodeWhere;
	}

	/**
	 * 刀具编码设定
	 * @param toolCodeWhere
	 */
	public void setToolCodeWhere (String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}

	/* 申请数量	*/ 
	private BigDecimal appliedNumberWhere;

	/**
	 * 申请数量取得
	 * @return appliedNumberWhere
	 */
	public BigDecimal getAppliedNumberWhere () {
		return appliedNumberWhere;
	}

	/**
	 * 申请数量设定
	 * @param appliedNumberWhere
	 */
	public void setAppliedNumberWhere (BigDecimal appliedNumberWhere) {
		this.appliedNumberWhere = appliedNumberWhere;
	}

	/* 申请人	*/ 
	private String applyUserWhere;

	/**
	 * 申请人取得
	 * @return applyUserWhere
	 */
	public String getApplyUserWhere () {
		return applyUserWhere;
	}

	/**
	 * 申请人设定
	 * @param applyUserWhere
	 */
	public void setApplyUserWhere (String applyUserWhere) {
		this.applyUserWhere = applyUserWhere;
	}

	/* 申请时间	*/ 
	private Date applyTimeWhere;

	/**
	 * 申请时间取得
	 * @return applyTimeWhere
	 */
	public Date getApplyTimeWhere () {
		return applyTimeWhere;
	}

	/**
	 * 申请时间设定
	 * @param applyTimeWhere
	 */
	public void setApplyTimeWhere (Date applyTimeWhere) {
		this.applyTimeWhere = applyTimeWhere;
	}

	/* 申领原因	*/ 
	private String replacementReasonWhere;

	/**
	 * 申领原因取得
	 * @return replacementReasonWhere
	 */
	public String getReplacementReasonWhere () {
		return replacementReasonWhere;
	}

	/**
	 * 申领原因设定
	 * @param replacementReasonWhere
	 */
	public void setReplacementReasonWhere (String replacementReasonWhere) {
		this.replacementReasonWhere = replacementReasonWhere;
	}

	/* 领取人（借用人）	*/ 
	private String receiveUserWhere;

	/**
	 * 领取人（借用人）取得
	 * @return receiveUserWhere
	 */
	public String getReceiveUserWhere () {
		return receiveUserWhere;
	}

	/**
	 * 领取人（借用人）设定
	 * @param receiveUserWhere
	 */
	public void setReceiveUserWhere (String receiveUserWhere) {
		this.receiveUserWhere = receiveUserWhere;
	}

	/* 领取时间（借用时间）	*/ 
	private Date receiveTimeWhere;

	/**
	 * 领取时间（借用时间）取得
	 * @return receiveTimeWhere
	 */
	public Date getReceiveTimeWhere () {
		return receiveTimeWhere;
	}

	/**
	 * 领取时间（借用时间）设定
	 * @param receiveTimeWhere
	 */
	public void setReceiveTimeWhere (Date receiveTimeWhere) {
		this.receiveTimeWhere = receiveTimeWhere;
	}

	/* 处理状态(0申请中1已补领2未到期3.已归还)	*/ 
	private String processingStatusWhere;

	/**
	 * 处理状态(0申请中1已补领2未到期3.已归还)取得
	 * @return processingStatusWhere
	 */
	public String getProcessingStatusWhere () {
		return processingStatusWhere;
	}

	/**
	 * 处理状态(0申请中1已补领2未到期3.已归还)设定
	 * @param processingStatusWhere
	 */
	public void setProcessingStatusWhere (String processingStatusWhere) {
		this.processingStatusWhere = processingStatusWhere;
	}

	/* 部门ID	*/ 
	private String departmentIDWhere;

	/**
	 * 部门ID取得
	 * @return departmentIDWhere
	 */
	public String getDepartmentIDWhere () {
		return departmentIDWhere;
	}

	/**
	 * 部门ID设定
	 * @param departmentIDWhere
	 */
	public void setDepartmentIDWhere (String departmentIDWhere) {
		this.departmentIDWhere = departmentIDWhere;
	}

	/* 申领区分(0补领周转1借用2特殊领用)	*/ 
	private String replacementFlagWhere;

	/**
	 * 申领区分(0补领周转1借用2特殊领用)取得
	 * @return replacementFlagWhere
	 */
	public String getReplacementFlagWhere () {
		return replacementFlagWhere;
	}

	/**
	 * 申领区分(0补领周转1借用2特殊领用)设定
	 * @param replacementFlagWhere
	 */
	public void setReplacementFlagWhere (String replacementFlagWhere) {
		this.replacementFlagWhere = replacementFlagWhere;
	}

	/* 申请人id	*/ 
	private String applyIDWhere;

	/**
	 * 申请人id取得
	 * @return applyIDWhere
	 */
	public String getApplyIDWhere () {
		return applyIDWhere;
	}

	/**
	 * 申请人id设定
	 * @param applyIDWhere
	 */
	public void setApplyIDWhere (String applyIDWhere) {
		this.applyIDWhere = applyIDWhere;
	}
	
	/* 申请总数量	*/ 
	private BigDecimal appliedTotalNumberWhere;

	/**
	 * 申请总数量取得
	 * @return appliedTotalNumberWhere
	 */
	public BigDecimal getAppliedTotalNumberWhere () {
		return appliedTotalNumberWhere;
	}

	/**
	 * 申请总数量设定
	 * @param appliedTotalNumberWhere
	 */
	public void setAppliedTotalNumberWhere (BigDecimal appliedTotalNumberWhere) {
		this.appliedTotalNumberWhere = appliedTotalNumberWhere;
	}
}

