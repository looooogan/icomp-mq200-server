/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/05/24 19:55:12
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/05/24 19:55:12
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vreplacement extends VreplacementWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;
	private String empCard;

	public String getEmpCard() {
		return empCard;
	}

	public void setEmpCard(String empCard) {
		this.empCard = empCard;
	}

	/* 申领申请流水号	*/
	private String replacementID;

	/**
	 * 申领申请流水号取得
	 * @return replacementID
	 */
	public String getReplacementID() {
		return replacementID;
	}

	/**
	 * 申领申请流水号设定
	 * @param replacementID
	 */
	public void setReplacementID(String replacementID) {
		this.replacementID = replacementID;
	}

	/* 申请时间	*/ 
	private Date applyTime;

	/**
	 * 申请时间取得
	 * @return applyTime
	 */
	public Date getApplyTime() {
		return applyTime;
	}

	/**
	 * 申请时间设定
	 * @param applyTime
	 */
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	/* 申领原因	*/ 
	private String replacementReason;

	/**
	 * 申领原因取得
	 * @return replacementReason
	 */
	public String getReplacementReason() {
		return replacementReason;
	}

	/**
	 * 申领原因设定
	 * @param replacementReason
	 */
	public void setReplacementReason(String replacementReason) {
		this.replacementReason = replacementReason;
	}

	/* 处理状态(0申请中1已补领2未到期3.已归还)	*/ 
	private String stockState;

	/**
	 * 处理状态(0申请中1已补领2未到期3.已归还)取得
	 * @return stockState
	 */
	public String getStockState() {
		return stockState;
	}

	/**
	 * 处理状态(0申请中1已补领2未到期3.已归还)设定
	 * @param stockState
	 */
	public void setStockState(String stockState) {
		this.stockState = stockState;
	}

	/* 版本号	*/ 
	private BigDecimal cycle;

	/**
	 * 版本号取得
	 * @return cycle
	 */
	public BigDecimal getCycle() {
		return cycle;
	}

	/**
	 * 版本号设定
	 * @param cycle
	 */
	public void setCycle(BigDecimal cycle) {
		this.cycle = cycle;
	}

	/* 申请人	*/ 
	private String applyUser;

	/**
	 * 申请人取得
	 * @return applyUser
	 */
	public String getApplyUser() {
		return applyUser;
	}

	/**
	 * 申请人设定
	 * @param applyUser
	 */
	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}

	/* 部门ID	*/ 
	private String departmentID;

	/**
	 * 部门ID取得
	 * @return departmentID
	 */
	public String getDepartmentID() {
		return departmentID;
	}

	/**
	 * 部门ID设定
	 * @param departmentID
	 */
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	/* 部门名称	*/ 
	private String departmentName;

	/**
	 * 部门名称取得
	 * @return departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * 部门名称设定
	 * @param departmentName
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/* 部门电话	*/ 
	private String departmentTel;

	/**
	 * 部门电话取得
	 * @return departmentTel
	 */
	public String getDepartmentTel() {
		return departmentTel;
	}

	/**
	 * 部门电话设定
	 * @param departmentTel
	 */
	public void setDepartmentTel(String departmentTel) {
		this.departmentTel = departmentTel;
	}

	/* 	*/ 
	private String emil;

	/**
	 * 取得
	 * @return emil
	 */
	public String getEmil() {
		return emil;
	}

	/**
	 * 设定
	 * @param emil
	 */
	public void setEmil(String emil) {
		this.emil = emil;
	}

	/* 领取人（借用人）	*/ 
	private String receiveUser;

	/**
	 * 领取人（借用人）取得
	 * @return receiveUser
	 */
	public String getReceiveUser() {
		return receiveUser;
	}

	/**
	 * 领取人（借用人）设定
	 * @param receiveUser
	 */
	public void setReceiveUser(String receiveUser) {
		this.receiveUser = receiveUser;
	}

	/* 申请数量	*/ 
	private BigDecimal appliedNumber;

	/**
	 * 申请数量取得
	 * @return appliedNumber
	 */
	public BigDecimal getAppliedNumber() {
		return appliedNumber;
	}

	/**
	 * 申请数量设定
	 * @param appliedNumber
	 */
	public void setAppliedNumber(BigDecimal appliedNumber) {
		this.appliedNumber = appliedNumber;
	}

	/* 申请人id	*/ 
	private String applyID;

	/**
	 * 申请人id取得
	 * @return applyID
	 */
	public String getApplyID() {
		return applyID;
	}

	/**
	 * 申请人id设定
	 * @param applyID
	 */
	public void setApplyID(String applyID) {
		this.applyID = applyID;
	}

	/* 更新时间	*/ 
	private Date returnTime;

	/**
	 * 更新时间取得
	 * @return returnTime
	 */
	public Date getReturnTime() {
		return returnTime;
	}

	/**
	 * 更新时间设定
	 * @param returnTime
	 */
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
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

	/* 刀具编码	*/ 
	private String toolCode;

	/**
	 * 刀具编码取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 刀具编码设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	public String appliedTotalNumber;

	public String getAppliedTotalNumber() {
		return appliedTotalNumber;
	}

	public void setAppliedTotalNumber(String appliedTotalNumber) {
		this.appliedTotalNumber = appliedTotalNumber;
	}
}

