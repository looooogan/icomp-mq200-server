/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/05/24 19:55:12
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;

import java.util.Date;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/05/24 19:55:12
 * 创建者  ：工具自动生成
 * 
 */
public class VreplacementWhere extends BaseEntity implements Serializable {

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

	/* 处理状态(0申请中1已补领2未到期3.已归还)	*/ 
	private String stockStateWhere;

	/**
	 * 处理状态(0申请中1已补领2未到期3.已归还)取得
	 * @return stockStateWhere
	 */
	public String getStockStateWhere () {
		return stockStateWhere;
	}

	/**
	 * 处理状态(0申请中1已补领2未到期3.已归还)设定
	 * @param stockStateWhere
	 */
	public void setStockStateWhere (String stockStateWhere) {
		this.stockStateWhere = stockStateWhere;
	}

	/* 版本号	*/ 
	private BigDecimal cycleWhere;

	/**
	 * 版本号取得
	 * @return cycleWhere
	 */
	public BigDecimal getCycleWhere () {
		return cycleWhere;
	}

	/**
	 * 版本号设定
	 * @param cycleWhere
	 */
	public void setCycleWhere (BigDecimal cycleWhere) {
		this.cycleWhere = cycleWhere;
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

	/* 部门名称	*/ 
	private String departmentNameWhere;

	/**
	 * 部门名称取得
	 * @return departmentNameWhere
	 */
	public String getDepartmentNameWhere () {
		return departmentNameWhere;
	}

	/**
	 * 部门名称设定
	 * @param departmentNameWhere
	 */
	public void setDepartmentNameWhere (String departmentNameWhere) {
		this.departmentNameWhere = departmentNameWhere;
	}

	/* 部门电话	*/ 
	private String departmentTelWhere;

	/**
	 * 部门电话取得
	 * @return departmentTelWhere
	 */
	public String getDepartmentTelWhere () {
		return departmentTelWhere;
	}

	/**
	 * 部门电话设定
	 * @param departmentTelWhere
	 */
	public void setDepartmentTelWhere (String departmentTelWhere) {
		this.departmentTelWhere = departmentTelWhere;
	}

	/* 	*/ 
	private String emilWhere;

	/**
	 * 取得
	 * @return emilWhere
	 */
	public String getEmilWhere () {
		return emilWhere;
	}

	/**
	 * 设定
	 * @param emilWhere
	 */
	public void setEmilWhere (String emilWhere) {
		this.emilWhere = emilWhere;
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

	/* 更新时间	*/ 
	private Date returnTimeWhere;

	/**
	 * 更新时间取得
	 * @return returnTimeWhere
	 */
	public Date getReturnTimeWhere () {
		return returnTimeWhere;
	}

	/**
	 * 更新时间设定
	 * @param returnTimeWhere
	 */
	public void setReturnTimeWhere (Date returnTimeWhere) {
		this.returnTimeWhere = returnTimeWhere;
	}

	/* 领取人（借用人）	*/
	private String knifeInventoryCodeWhere;

	/**
	 * 领取人（借用人）取得
	 * @return knifeInventoryCodeWhere
	 */
	public String getKnifeInventoryCodeWhere () {
		return knifeInventoryCodeWhere;
	}

	/**
	 * 领取人（借用人）设定
	 * @param knifeInventoryCodeWhere
	 */
	public void setKnifeInventoryCodeWhere (String knifeInventoryCodeWhere) {
		this.knifeInventoryCodeWhere = knifeInventoryCodeWhere;
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
}

