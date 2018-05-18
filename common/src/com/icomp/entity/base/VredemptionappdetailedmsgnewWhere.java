/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2015/03/09 14:13:26
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2015/03/09 14:13:26
 * 创建者  ：杨作庆
 * 
 */
public class VredemptionappdetailedmsgnewWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 	*/ 
	private String lblCodeWhere;

	/**
	 * 取得
	 * @return lblCodeWhere
	 */
	public String getlblCodeWhere () {
		return lblCodeWhere;
	}

	/**
	 * 设定
	 * @param lblCodeWhere
	 */
	public void setlblCodeWhere (String lblCodeWhere) {
		this.lblCodeWhere = lblCodeWhere;
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

	/* 申请时间	*/ 
	private String applyTimeWhere;

	/**
	 * 申请时间取得
	 * @return applyTimeWhere
	 */
	public String  getApplyTimeWhere () {
		return  applyTimeWhere;
	}

	/**
	 * 申请时间设定
	 * @param applyTimeWhere
	 */
	public void setApplyTimeWhere (String applyTimeWhere) {
		this.applyTimeWhere = applyTimeWhere;
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

	/* 到寿数量	*/ 
	private BigDecimal lifeOverNumberWhere;

	/**
	 * 到寿数量取得
	 * @return lifeOverNumberWhere
	 */
	public BigDecimal getLifeOverNumberWhere () {
		return lifeOverNumberWhere;
	}

	/**
	 * 到寿数量设定
	 * @param lifeOverNumberWhere
	 */
	public void setLifeOverNumberWhere (BigDecimal lifeOverNumberWhere) {
		this.lifeOverNumberWhere = lifeOverNumberWhere;
	}

    private String processingStatusWhere;

    public String getProcessingStatusWhere() {
        return processingStatusWhere;
    }

    public void setProcessingStatusWhere(String processingStatusWhere) {
        this.processingStatusWhere = processingStatusWhere;
    }
}

