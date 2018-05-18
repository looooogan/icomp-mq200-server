/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/08/04 10:42:50
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/08/04 10:42:50
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vredemptionapplied extends VredemptionappliedWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具编码	*/ 
	private String toolType;

	/**
	 * 刀具编码取得
	 * @return toolType
	 */
	public String getToolType() {
		return toolType;
	}

	/**
	 * 刀具编码设定
	 * @param toolType
	 */
	public void setToolType(String toolType) {
		this.toolType = toolType;
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

	/* 换领申请流水号	*/ 
	private String redemptionAppliedID;

	/**
	 * 换领申请流水号取得
	 * @return redemptionAppliedID
	 */
	public String getRedemptionAppliedID() {
		return redemptionAppliedID;
	}

	/**
	 * 换领申请流水号设定
	 * @param redemptionAppliedID
	 */
	public void setRedemptionAppliedID(String redemptionAppliedID) {
		this.redemptionAppliedID = redemptionAppliedID;
	}

	/* 申请时间	*/ 
	private String applyTime;

	/**
	 * 申请时间取得
	 * @return applyTime
	 */
	public String getApplyTime() {
		return applyTime;
	}

	/**
	 * 申请时间设定
	 * @param applyTime
	 */
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	/* 领取数量	*/ 
	private BigDecimal receiveNumber;

	/**
	 * 领取数量取得
	 * @return receiveNumber
	 */
	public BigDecimal getReceiveNumber() {
		return receiveNumber;
	}

	/**
	 * 领取数量设定
	 * @param receiveNumber
	 */
	public void setReceiveNumber(BigDecimal receiveNumber) {
		this.receiveNumber = receiveNumber;
	}

	/* 	*/ 
	private String receiveUser;

	/**
	 * 取得
	 * @return receiveUser
	 */
	public String getReceiveUser() {
		return receiveUser;
	}

	/**
	 * 设定
	 * @param receiveUser
	 */
	public void setReceiveUser(String receiveUser) {
		this.receiveUser = receiveUser;
	}

	/* 	*/ 
	private String receiveCad;

	/**
	 * 取得
	 * @return receiveCad
	 */
	public String getReceiveCad() {
		return receiveCad;
	}

	/**
	 * 设定
	 * @param receiveCad
	 */
	public void setReceiveCad(String receiveCad) {
		this.receiveCad = receiveCad;
	}

	/* 创建者	*/ 
	private String libraryUser;

	/**
	 * 创建者取得
	 * @return libraryUser
	 */
	public String getLibraryUser() {
		return libraryUser;
	}

	/**
	 * 创建者设定
	 * @param libraryUser
	 */
	public void setLibraryUser(String libraryUser) {
		this.libraryUser = libraryUser;
	}

	/* 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )	*/ 
	private String processingStatus;

	/**
	 * 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )取得
	 * @return processingStatus
	 */
	public String getProcessingStatus() {
		return processingStatus;
	}

	/**
	 * 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )设定
	 * @param processingStatus
	 */
	public void setProcessingStatus(String processingStatus) {
		this.processingStatus = processingStatus;
	}

	/* 	*/ 
	private BigDecimal appliedNumber;

	/**
	 * 取得
	 * @return appliedNumber
	 */
	public BigDecimal getAppliedNumber() {
		return appliedNumber;
	}

	/**
	 * 设定
	 * @param appliedNumber
	 */
	public void setAppliedNumber(BigDecimal appliedNumber) {
		this.appliedNumber = appliedNumber;
	}

	/* 	*/ 
	private BigDecimal returnNumber;

	/**
	 * 取得
	 * @return returnNumber
	 */
	public BigDecimal getReturnNumber() {
		return returnNumber;
	}

	/**
	 * 设定
	 * @param returnNumber
	 */
	public void setReturnNumber(BigDecimal returnNumber) {
		this.returnNumber = returnNumber;
	}

	/* 	*/ 
	private BigDecimal lostNumber;

	/**
	 * 取得
	 * @return lostNumber
	 */
	public BigDecimal getLostNumber() {
		return lostNumber;
	}

	/**
	 * 设定
	 * @param lostNumber
	 */
	public void setLostNumber(BigDecimal lostNumber) {
		this.lostNumber = lostNumber;
	}

	/* 	*/ 
	private String applyUser;

	/**
	 * 取得
	 * @return applyUser
	 */
	public String getApplyUser() {
		return applyUser;
	}

	/**
	 * 设定
	 * @param applyUser
	 */
	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}

	/* 	*/ 
	private String applyCad;

	/**
	 * 取得
	 * @return applyCad
	 */
	public String getApplyCad() {
		return applyCad;
	}

	/**
	 * 设定
	 * @param applyCad
	 */
	public void setApplyCad(String applyCad) {
		this.applyCad = applyCad;
	}

	/* 申请人	*/ 
	private String applyID;

	/**
	 * 申请人取得
	 * @return applyID
	 */
	public String getApplyID() {
		return applyID;
	}

	/**
	 * 申请人设定
	 * @param applyID
	 */
	public void setApplyID(String applyID) {
		this.applyID = applyID;
	}
}

