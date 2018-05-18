/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:05
 * 创建者  ：杨作庆
 * 
 */
public class VtransitplanWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 供应商	*/ 
	private String toolSupplierWhere;

	/**
	 * 供应商取得
	 * @return toolSupplierWhere
	 */
	public String getToolSupplierWhere () {
		return toolSupplierWhere;
	}

	/**
	 * 供应商设定
	 * @param toolSupplierWhere
	 */
	public void setToolSupplierWhere (String toolSupplierWhere) {
		this.toolSupplierWhere = toolSupplierWhere;
	}

	/* 品牌	*/ 
	private String toolBrandWhere;

	/**
	 * 品牌取得
	 * @return toolBrandWhere
	 */
	public String getToolBrandWhere () {
		return toolBrandWhere;
	}

	/**
	 * 品牌设定
	 * @param toolBrandWhere
	 */
	public void setToolBrandWhere (String toolBrandWhere) {
		this.toolBrandWhere = toolBrandWhere;
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

	/* 	*/ 
	private String deliveryPlanIDWhere;

	/**
	 * 取得
	 * @return deliveryPlanIDWhere
	 */
	public String getDeliveryPlanIDWhere () {
		return deliveryPlanIDWhere;
	}

	/**
	 * 设定
	 * @param deliveryPlanIDWhere
	 */
	public void setDeliveryPlanIDWhere (String deliveryPlanIDWhere) {
		this.deliveryPlanIDWhere = deliveryPlanIDWhere;
	}

	/* 预计到货时间	*/ 
	private Date theyTimeWhere;

	/**
	 * 预计到货时间取得
	 * @return theyTimeWhere
	 */
	public Date getTheyTimeWhere () {
		return theyTimeWhere;
	}

	/**
	 * 预计到货时间设定
	 * @param theyTimeWhere
	 */
	public void setTheyTimeWhere (Date theyTimeWhere) {
		this.theyTimeWhere = theyTimeWhere;
	}

	/* 预计到货数量	*/ 
	private BigDecimal theyCountWhere;

	/**
	 * 预计到货数量取得
	 * @return theyCountWhere
	 */
	public BigDecimal getTheyCountWhere () {
		return theyCountWhere;
	}

	/**
	 * 预计到货数量设定
	 * @param theyCountWhere
	 */
	public void setTheyCountWhere (BigDecimal theyCountWhere) {
		this.theyCountWhere = theyCountWhere;
	}

	/* 实际到货时间	*/ 
	private Date realityTheyTimeWhere;

	/**
	 * 实际到货时间取得
	 * @return realityTheyTimeWhere
	 */
	public Date getRealityTheyTimeWhere () {
		return realityTheyTimeWhere;
	}

	/**
	 * 实际到货时间设定
	 * @param realityTheyTimeWhere
	 */
	public void setRealityTheyTimeWhere (Date realityTheyTimeWhere) {
		this.realityTheyTimeWhere = realityTheyTimeWhere;
	}

	/* 实际到货数量	*/ 
	private BigDecimal realityTheyCountWhere;

	/**
	 * 实际到货数量取得
	 * @return realityTheyCountWhere
	 */
	public BigDecimal getRealityTheyCountWhere () {
		return realityTheyCountWhere;
	}

	/**
	 * 实际到货数量设定
	 * @param realityTheyCountWhere
	 */
	public void setRealityTheyCountWhere (BigDecimal realityTheyCountWhere) {
		this.realityTheyCountWhere = realityTheyCountWhere;
	}

	/* 货品状态(0未到货1已到货2质检通过3质检未通过)	*/ 
	private String theyStatusWhere;

	/**
	 * 货品状态(0未到货1已到货2质检通过3质检未通过)取得
	 * @return theyStatusWhere
	 */
	public String getTheyStatusWhere () {
		return theyStatusWhere;
	}

	/**
	 * 货品状态(0未到货1已到货2质检通过3质检未通过)设定
	 * @param theyStatusWhere
	 */
	public void setTheyStatusWhere (String theyStatusWhere) {
		this.theyStatusWhere = theyStatusWhere;
	}

	/* 姓名	*/ 
	private String transferPeopleWhere;

	/**
	 * 姓名取得
	 * @return transferPeopleWhere
	 */
	public String getTransferPeopleWhere () {
		return transferPeopleWhere;
	}

	/**
	 * 姓名设定
	 * @param transferPeopleWhere
	 */
	public void setTransferPeopleWhere (String transferPeopleWhere) {
		this.transferPeopleWhere = transferPeopleWhere;
	}

	/* 采购单价	*/ 
	private BigDecimal unitPriceWhere;

	/**
	 * 采购单价取得
	 * @return unitPriceWhere
	 */
	public BigDecimal getUnitPriceWhere () {
		return unitPriceWhere;
	}

	/**
	 * 采购单价设定
	 * @param unitPriceWhere
	 */
	public void setUnitPriceWhere (BigDecimal unitPriceWhere) {
		this.unitPriceWhere = unitPriceWhere;
	}
}

