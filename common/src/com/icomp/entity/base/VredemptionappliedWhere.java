/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/08/04 10:42:50
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/08/04 10:42:50
 * 创建者  ：工具自动生成
 * 
 */
public class VredemptionappliedWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具编码	*/ 
	private String toolTypeWhere;

	/**
	 * 刀具编码取得
	 * @return toolTypeWhere
	 */
	public String getToolTypeWhere () {
		return toolTypeWhere;
	}

	/**
	 * 刀具编码设定
	 * @param toolTypeWhere
	 */
	public void setToolTypeWhere (String toolTypeWhere) {
		this.toolTypeWhere = toolTypeWhere;
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

	/* 换领申请流水号	*/ 
	private String redemptionAppliedIDWhere;

	/**
	 * 换领申请流水号取得
	 * @return redemptionAppliedIDWhere
	 */
	public String getRedemptionAppliedIDWhere () {
		return redemptionAppliedIDWhere;
	}

	/**
	 * 换领申请流水号设定
	 * @param redemptionAppliedIDWhere
	 */
	public void setRedemptionAppliedIDWhere (String redemptionAppliedIDWhere) {
		this.redemptionAppliedIDWhere = redemptionAppliedIDWhere;
	}

	/* 申请时间	*/ 
	private String applyTimeWhere;

	/**
	 * 申请时间取得
	 * @return applyTimeWhere
	 */
	public String getApplyTimeWhere () {
		return applyTimeWhere;
	}

	/**
	 * 申请时间设定
	 * @param applyTimeWhere
	 */
	public void setApplyTimeWhere (String applyTimeWhere) {
		this.applyTimeWhere = applyTimeWhere;
	}

	/* 领取数量	*/ 
	private BigDecimal receiveNumberWhere;

	/**
	 * 领取数量取得
	 * @return receiveNumberWhere
	 */
	public BigDecimal getReceiveNumberWhere () {
		return receiveNumberWhere;
	}

	/**
	 * 领取数量设定
	 * @param receiveNumberWhere
	 */
	public void setReceiveNumberWhere (BigDecimal receiveNumberWhere) {
		this.receiveNumberWhere = receiveNumberWhere;
	}

	/* 	*/ 
	private String receiveUserWhere;

	/**
	 * 取得
	 * @return receiveUserWhere
	 */
	public String getReceiveUserWhere () {
		return receiveUserWhere;
	}

	/**
	 * 设定
	 * @param receiveUserWhere
	 */
	public void setReceiveUserWhere (String receiveUserWhere) {
		this.receiveUserWhere = receiveUserWhere;
	}

	/* 	*/ 
	private String receiveCadWhere;

	/**
	 * 取得
	 * @return receiveCadWhere
	 */
	public String getReceiveCadWhere () {
		return receiveCadWhere;
	}

	/**
	 * 设定
	 * @param receiveCadWhere
	 */
	public void setReceiveCadWhere (String receiveCadWhere) {
		this.receiveCadWhere = receiveCadWhere;
	}

	/* 创建者	*/ 
	private String libraryUserWhere;

	/**
	 * 创建者取得
	 * @return libraryUserWhere
	 */
	public String getLibraryUserWhere () {
		return libraryUserWhere;
	}

	/**
	 * 创建者设定
	 * @param libraryUserWhere
	 */
	public void setLibraryUserWhere (String libraryUserWhere) {
		this.libraryUserWhere = libraryUserWhere;
	}

	/* 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )	*/ 
	private String processingStatusWhere;

	/**
	 * 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )取得
	 * @return processingStatusWhere
	 */
	public String getProcessingStatusWhere () {
		return processingStatusWhere;
	}

	/**
	 * 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )设定
	 * @param processingStatusWhere
	 */
	public void setProcessingStatusWhere (String processingStatusWhere) {
		this.processingStatusWhere = processingStatusWhere;
	}

	/* 	*/ 
	private BigDecimal appliedNumberWhere;

	/**
	 * 取得
	 * @return appliedNumberWhere
	 */
	public BigDecimal getAppliedNumberWhere () {
		return appliedNumberWhere;
	}

	/**
	 * 设定
	 * @param appliedNumberWhere
	 */
	public void setAppliedNumberWhere (BigDecimal appliedNumberWhere) {
		this.appliedNumberWhere = appliedNumberWhere;
	}

	/* 	*/ 
	private BigDecimal returnNumberWhere;

	/**
	 * 取得
	 * @return returnNumberWhere
	 */
	public BigDecimal getReturnNumberWhere () {
		return returnNumberWhere;
	}

	/**
	 * 设定
	 * @param returnNumberWhere
	 */
	public void setReturnNumberWhere (BigDecimal returnNumberWhere) {
		this.returnNumberWhere = returnNumberWhere;
	}

	/* 	*/ 
	private BigDecimal lostNumberWhere;

	/**
	 * 取得
	 * @return lostNumberWhere
	 */
	public BigDecimal getLostNumberWhere () {
		return lostNumberWhere;
	}

	/**
	 * 设定
	 * @param lostNumberWhere
	 */
	public void setLostNumberWhere (BigDecimal lostNumberWhere) {
		this.lostNumberWhere = lostNumberWhere;
	}

	/* 	*/ 
	private String applyUserWhere;

	/**
	 * 取得
	 * @return applyUserWhere
	 */
	public String getApplyUserWhere () {
		return applyUserWhere;
	}

	/**
	 * 设定
	 * @param applyUserWhere
	 */
	public void setApplyUserWhere (String applyUserWhere) {
		this.applyUserWhere = applyUserWhere;
	}

	/* 	*/ 
	private String applyCadWhere;

	/**
	 * 取得
	 * @return applyCadWhere
	 */
	public String getApplyCadWhere () {
		return applyCadWhere;
	}

	/**
	 * 设定
	 * @param applyCadWhere
	 */
	public void setApplyCadWhere (String applyCadWhere) {
		this.applyCadWhere = applyCadWhere;
	}

	/* 申请人	*/ 
	private String applyIDWhere;

	/**
	 * 申请人取得
	 * @return applyIDWhere
	 */
	public String getApplyIDWhere () {
		return applyIDWhere;
	}

	/**
	 * 申请人设定
	 * @param applyIDWhere
	 */
	public void setApplyIDWhere (String applyIDWhere) {
		this.applyIDWhere = applyIDWhere;
	}
}

