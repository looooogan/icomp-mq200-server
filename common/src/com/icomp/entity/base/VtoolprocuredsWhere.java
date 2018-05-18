/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/03/11 13:10:45
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;


import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/03/11 13:10:45
 * 创建者  ：工具自动生成
 * 
 */
public class VtoolprocuredsWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 采购ID	*/ 
	private String toolProcuredIDWhere;

	/**
	 * 采购ID取得
	 * @return toolProcuredIDWhere
	 */
	public String getToolProcuredIDWhere () {
		return toolProcuredIDWhere;
	}

	/**
	 * 采购ID设定
	 * @param toolProcuredIDWhere
	 */
	public void setToolProcuredIDWhere (String toolProcuredIDWhere) {
		this.toolProcuredIDWhere = toolProcuredIDWhere;
	}

	/* 订单号	*/ 
	private String toolsOrdeNOWhere;

	/**
	 * 订单号取得
	 * @return toolsOrdeNOWhere
	 */
	public String getToolsOrdeNOWhere () {
		return toolsOrdeNOWhere;
	}

	/**
	 * 订单号设定
	 * @param toolsOrdeNOWhere
	 */
	public void setToolsOrdeNOWhere (String toolsOrdeNOWhere) {
		this.toolsOrdeNOWhere = toolsOrdeNOWhere;
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
	private String supplierWhere;

	/**
	 * 取得
	 * @return supplierWhere
	 */
	public String getSupplierWhere () {
		return supplierWhere;
	}

	/**
	 * 设定
	 * @param supplierWhere
	 */
	public void setSupplierWhere (String supplierWhere) {
		this.supplierWhere = supplierWhere;
	}

	/* 采购批次	*/ 
	private String procuredBatchWhere;

	/**
	 * 采购批次取得
	 * @return procuredBatchWhere
	 */
	public String getProcuredBatchWhere () {
		return procuredBatchWhere;
	}

	/**
	 * 采购批次设定
	 * @param procuredBatchWhere
	 */
	public void setProcuredBatchWhere (String procuredBatchWhere) {
		this.procuredBatchWhere = procuredBatchWhere;
	}

	/* 采购日期	*/ 
	private String procuredTimeWhere;

	/**
	 * 采购日期取得
	 * @return procuredTimeWhere
	 */
	public String getProcuredTimeWhere () {
		return procuredTimeWhere;
	}

	/**
	 * 采购日期设定
	 * @param procuredTimeWhere
	 */
	public void setProcuredTimeWhere (String procuredTimeWhere) {
		this.procuredTimeWhere = procuredTimeWhere;
	}

	/* 采购单价	*/ 
	private String unitPriceWhere;

	/**
	 * 采购单价取得
	 * @return unitPriceWhere
	 */
	public String getUnitPriceWhere () {
		return unitPriceWhere;
	}

	/**
	 * 采购单价设定
	 * @param unitPriceWhere
	 */
	public void setUnitPriceWhere (String unitPriceWhere) {
		this.unitPriceWhere = unitPriceWhere;
	}

	/* 	*/ 
	private String procuredUserWhere;

	/**
	 * 取得
	 * @return procuredUserWhere
	 */
	public String getProcuredUserWhere () {
		return procuredUserWhere;
	}

	/**
	 * 设定
	 * @param procuredUserWhere
	 */
	public void setProcuredUserWhere (String procuredUserWhere) {
		this.procuredUserWhere = procuredUserWhere;
	}

	/* 采购数量	*/ 
	private BigDecimal procuredCountWhere;

	/**
	 * 采购数量取得
	 * @return procuredCountWhere
	 */
	public BigDecimal getProcuredCountWhere () {
		return procuredCountWhere;
	}

	/**
	 * 采购数量设定
	 * @param procuredCountWhere
	 */
	public void setProcuredCountWhere (BigDecimal procuredCountWhere) {
		this.procuredCountWhere = procuredCountWhere;
	}

	/* 是否入库(0是1否)	*/ 
	private String procuredIntoWhere;

	/**
	 * 是否入库(0是1否)取得
	 * @return procuredIntoWhere
	 */
	public String getProcuredIntoWhere () {
		return procuredIntoWhere;
	}

	/**
	 * 是否入库(0是1否)设定
	 * @param procuredIntoWhere
	 */
	public void setProcuredIntoWhere (String procuredIntoWhere) {
		this.procuredIntoWhere = procuredIntoWhere;
	}
}

