/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/06/13 16:54:39
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/06/13 16:54:39
 * 创建者  ：工具自动生成
 * 
 */
public class VpartsmachiningmsgWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 零部件	*/ 
	private String partsIDWhere;

	/**
	 * 零部件取得
	 * @return partsIDWhere
	 */
	public String getPartsIDWhere () {
		return partsIDWhere;
	}

	/**
	 * 零部件设定
	 * @param partsIDWhere
	 */
	public void setPartsIDWhere (String partsIDWhere) {
		this.partsIDWhere = partsIDWhere;
	}

	/* 卸下时间	*/ 
	private Date outerTimeWhere;

	/**
	 * 卸下时间取得
	 * @return outerTimeWhere
	 */
	public Date getOuterTimeWhere () {
		return outerTimeWhere;
	}

	/**
	 * 卸下时间设定
	 * @param outerTimeWhere
	 */
	public void setOuterTimeWhere (Date outerTimeWhere) {
		this.outerTimeWhere = outerTimeWhere;
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

	/* 刀具分类(0刀具1辅具2配套9其他）	*/ 
	private String toolTypeWhere;

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）取得
	 * @return toolTypeWhere
	 */
	public String getToolTypeWhere () {
		return toolTypeWhere;
	}

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）设定
	 * @param toolTypeWhere
	 */
	public void setToolTypeWhere (String toolTypeWhere) {
		this.toolTypeWhere = toolTypeWhere;
	}

	/* 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他	*/ 
	private String toolConsumetypeWhere;

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他取得
	 * @return toolConsumetypeWhere
	 */
	public String getToolConsumetypeWhere () {
		return toolConsumetypeWhere;
	}

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他设定
	 * @param toolConsumetypeWhere
	 */
	public void setToolConsumetypeWhere (String toolConsumetypeWhere) {
		this.toolConsumetypeWhere = toolConsumetypeWhere;
	}

	/* 修磨类别(0:厂内修磨，1厂外修磨，2厂外涂层	*/ 
	private String toolGrindingWhere;

	/**
	 * 修磨类别(0:厂内修磨，1厂外修磨，2厂外涂层取得
	 * @return toolGrindingWhere
	 */
	public String getToolGrindingWhere () {
		return toolGrindingWhere;
	}

	/**
	 * 修磨类别(0:厂内修磨，1厂外修磨，2厂外涂层设定
	 * @param toolGrindingWhere
	 */
	public void setToolGrindingWhere (String toolGrindingWhere) {
		this.toolGrindingWhere = toolGrindingWhere;
	}

	/* 加工数量	*/ 
	private BigDecimal processAmountWhere;

	/**
	 * 加工数量取得
	 * @return processAmountWhere
	 */
	public BigDecimal getProcessAmountWhere () {
		return processAmountWhere;
	}

	/**
	 * 加工数量设定
	 * @param processAmountWhere
	 */
	public void setProcessAmountWhere (BigDecimal processAmountWhere) {
		this.processAmountWhere = processAmountWhere;
	}

	/* 	*/ 
	private String avgFrequencyUseWhere;

	/**
	 * 取得
	 * @return avgFrequencyUseWhere
	 */
	public String getAvgFrequencyUseWhere () {
		return avgFrequencyUseWhere;
	}

	/**
	 * 设定
	 * @param avgFrequencyUseWhere
	 */
	public void setAvgFrequencyUseWhere (String avgFrequencyUseWhere) {
		this.avgFrequencyUseWhere = avgFrequencyUseWhere;
	}

	/* 	*/ 
	private String usedCountsWhere;

	/**
	 * 取得
	 * @return usedCountsWhere
	 */
	public String getUsedCountsWhere () {
		return usedCountsWhere;
	}

	/**
	 * 设定
	 * @param usedCountsWhere
	 */
	public void setUsedCountsWhere (String usedCountsWhere) {
		this.usedCountsWhere = usedCountsWhere;
	}

	/* 	*/ 
	private String stockCountsWhere;

	/**
	 * 取得
	 * @return stockCountsWhere
	 */
	public String getStockCountsWhere () {
		return stockCountsWhere;
	}

	/**
	 * 设定
	 * @param stockCountsWhere
	 */
	public void setStockCountsWhere (String stockCountsWhere) {
		this.stockCountsWhere = stockCountsWhere;
	}

	/* 	*/ 
	private String activeCountsWhere;

	/**
	 * 取得
	 * @return activeCountsWhere
	 */
	public String getActiveCountsWhere () {
		return activeCountsWhere;
	}

	/**
	 * 设定
	 * @param activeCountsWhere
	 */
	public void setActiveCountsWhere (String activeCountsWhere) {
		this.activeCountsWhere = activeCountsWhere;
	}

	/* 	*/ 
	private String goingNewCountsWhere;

	/**
	 * 取得
	 * @return goingNewCountsWhere
	 */
	public String getGoingNewCountsWhere () {
		return goingNewCountsWhere;
	}

	/**
	 * 设定
	 * @param goingNewCountsWhere
	 */
	public void setGoingNewCountsWhere (String goingNewCountsWhere) {
		this.goingNewCountsWhere = goingNewCountsWhere;
	}

	/* 	*/ 
	private String goingOldCountsWhere;

	/**
	 * 取得
	 * @return goingOldCountsWhere
	 */
	public String getGoingOldCountsWhere () {
		return goingOldCountsWhere;
	}

	/**
	 * 设定
	 * @param goingOldCountsWhere
	 */
	public void setGoingOldCountsWhere (String goingOldCountsWhere) {
		this.goingOldCountsWhere = goingOldCountsWhere;
	}

	/* 	*/ 
	private String procuresCycleWhere;

	/**
	 * 取得
	 * @return procuresCycleWhere
	 */
	public String getProcuresCycleWhere () {
		return procuresCycleWhere;
	}

	/**
	 * 设定
	 * @param procuresCycleWhere
	 */
	public void setProcuresCycleWhere (String procuresCycleWhere) {
		this.procuresCycleWhere = procuresCycleWhere;
	}

	/* 	*/ 
	private String purchaseCountsWhere;

	/**
	 * 取得
	 * @return purchaseCountsWhere
	 */
	public String getPurchaseCountsWhere () {
		return purchaseCountsWhere;
	}

	/**
	 * 设定
	 * @param purchaseCountsWhere
	 */
	public void setPurchaseCountsWhere (String purchaseCountsWhere) {
		this.purchaseCountsWhere = purchaseCountsWhere;
	}
}

