/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2015/01/27 16:52:27
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2015/01/27 16:52:27
 * 创建者  ：杨作庆
 * 
 */
public class VgetredemptionappdetailedmsgWhere extends BaseEntity implements Serializable {

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

	/* 	*/ 
	private BigDecimal inventoryCount_AWhere;

	/**
	 * 取得
	 * @return inventoryCount_AWhere
	 */
	public BigDecimal getInventoryCount_AWhere () {
		return inventoryCount_AWhere;
	}

	/**
	 * 设定
	 * @param inventoryCount_AWhere
	 */
	public void setInventoryCount_AWhere (BigDecimal inventoryCount_AWhere) {
		this.inventoryCount_AWhere = inventoryCount_AWhere;
	}

	/* 	*/ 
	private BigDecimal inventoryCount_BWhere;

	/**
	 * 取得
	 * @return inventoryCount_BWhere
	 */
	public BigDecimal getInventoryCount_BWhere () {
		return inventoryCount_BWhere;
	}

	/**
	 * 设定
	 * @param inventoryCount_BWhere
	 */
	public void setInventoryCount_BWhere (BigDecimal inventoryCount_BWhere) {
		this.inventoryCount_BWhere = inventoryCount_BWhere;
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

	/* 可刃磨长度	*/ 
	private BigDecimal toolSharpenLengthWhere;

	/**
	 * 可刃磨长度取得
	 * @return toolSharpenLengthWhere
	 */
	public BigDecimal getToolSharpenLengthWhere () {
		return toolSharpenLengthWhere;
	}

	/**
	 * 可刃磨长度设定
	 * @param toolSharpenLengthWhere
	 */
	public void setToolSharpenLengthWhere (BigDecimal toolSharpenLengthWhere) {
		this.toolSharpenLengthWhere = toolSharpenLengthWhere;
	}

	/* 复磨标准	*/ 
	private BigDecimal toolSharpenCriterionWhere;

	/**
	 * 复磨标准取得
	 * @return toolSharpenCriterionWhere
	 */
	public BigDecimal getToolSharpenCriterionWhere () {
		return toolSharpenCriterionWhere;
	}

	/**
	 * 复磨标准设定
	 * @param toolSharpenCriterionWhere
	 */
	public void setToolSharpenCriterionWhere (BigDecimal toolSharpenCriterionWhere) {
		this.toolSharpenCriterionWhere = toolSharpenCriterionWhere;
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
}

