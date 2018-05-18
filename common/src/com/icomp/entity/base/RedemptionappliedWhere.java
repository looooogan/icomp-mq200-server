/*
 * 工具自动生成：换领申请条件实体类
 * 生成时间    : 2015/01/27 16:45:54
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 换领申请条件实体类
 * @author 工具自动生成
 * 创建时间：2015/01/27 16:45:54
 * 创建者  ：杨作庆
 * 
 */
public class RedemptionappliedWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 备货数量	*/ 
	private BigDecimal stockNumberWhere;

	/**
	 * 备货数量取得
	 * @return stockNumberWhere
	 */
	public BigDecimal getStockNumberWhere () {
		return stockNumberWhere;
	}

	/**
	 * 备货数量设定
	 * @param stockNumberWhere
	 */
	public void setStockNumberWhere (BigDecimal stockNumberWhere) {
		this.stockNumberWhere = stockNumberWhere;
	}

	/* 送回数量	*/ 
	private BigDecimal returnNumberWhere;

	/**
	 * 送回数量取得
	 * @return returnNumberWhere
	 */
	public BigDecimal getReturnNumberWhere () {
		return returnNumberWhere;
	}

	/**
	 * 送回数量设定
	 * @param returnNumberWhere
	 */
	public void setReturnNumberWhere (BigDecimal returnNumberWhere) {
		this.returnNumberWhere = returnNumberWhere;
	}

	/* 断刀数量	*/ 
	private BigDecimal brokenNumberWhere;

	/**
	 * 断刀数量取得
	 * @return brokenNumberWhere
	 */
	public BigDecimal getBrokenNumberWhere () {
		return brokenNumberWhere;
	}

	/**
	 * 断刀数量设定
	 * @param brokenNumberWhere
	 */
	public void setBrokenNumberWhere (BigDecimal brokenNumberWhere) {
		this.brokenNumberWhere = brokenNumberWhere;
	}

	/* 丢失数量	*/ 
	private BigDecimal lostNumberWhere;

	/**
	 * 丢失数量取得
	 * @return lostNumberWhere
	 */
	public BigDecimal getLostNumberWhere () {
		return lostNumberWhere;
	}

	/**
	 * 丢失数量设定
	 * @param lostNumberWhere
	 */
	public void setLostNumberWhere (BigDecimal lostNumberWhere) {
		this.lostNumberWhere = lostNumberWhere;
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

	/* 领取人	*/ 
	private String receiveUserWhere;

	/**
	 * 领取人取得
	 * @return receiveUserWhere
	 */
	public String getReceiveUserWhere () {
		return receiveUserWhere;
	}

	/**
	 * 领取人设定
	 * @param receiveUserWhere
	 */
	public void setReceiveUserWhere (String receiveUserWhere) {
		this.receiveUserWhere = receiveUserWhere;
	}

	/* 领取时间	*/ 
	private Date receiveTimeWhere;

	/**
	 * 领取时间取得
	 * @return receiveTimeWhere
	 */
	public Date getReceiveTimeWhere () {
		return receiveTimeWhere;
	}

	/**
	 * 领取时间设定
	 * @param receiveTimeWhere
	 */
	public void setReceiveTimeWhere (Date receiveTimeWhere) {
		this.receiveTimeWhere = receiveTimeWhere;
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
}

