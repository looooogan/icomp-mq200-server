/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/25 13:42:05
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/25 13:42:05
 * 创建者  ：杨作庆
 * 
 */
public class VtoolconsumptionqueryWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 库存状态(0正常1报废2返厂3封存9其他)	*/ 
	private String stockStateWhere;

	/**
	 * 库存状态(0正常1报废2返厂3封存9其他)取得
	 * @return stockStateWhere
	 */
	public String getStockStateWhere () {
		return stockStateWhere;
	}

	/**
	 * 库存状态(0正常1报废2返厂3封存9其他)设定
	 * @param stockStateWhere
	 */
	public void setStockStateWhere (String stockStateWhere) {
		this.stockStateWhere = stockStateWhere;
	}

	/* 刀具已刃磨长度	*/ 
	private BigDecimal toolGrindingLengthWhere;

	/**
	 * 刀具已刃磨长度取得
	 * @return toolGrindingLengthWhere
	 */
	public BigDecimal getToolGrindingLengthWhere () {
		return toolGrindingLengthWhere;
	}

	/**
	 * 刀具已刃磨长度设定
	 * @param toolGrindingLengthWhere
	 */
	public void setToolGrindingLengthWhere (BigDecimal toolGrindingLengthWhere) {
		this.toolGrindingLengthWhere = toolGrindingLengthWhere;
	}

	/* 刀具长度	*/ 
	private BigDecimal toolLengthWhere;

	/**
	 * 刀具长度取得
	 * @return toolLengthWhere
	 */
	public BigDecimal getToolLengthWhere () {
		return toolLengthWhere;
	}

	/**
	 * 刀具长度设定
	 * @param toolLengthWhere
	 */
	public void setToolLengthWhere (BigDecimal toolLengthWhere) {
		this.toolLengthWhere = toolLengthWhere;
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

	/* 可使用次数	*/ 
	private BigDecimal toolNumWhere;

	/**
	 * 可使用次数取得
	 * @return toolNumWhere
	 */
	public BigDecimal getToolNumWhere () {
		return toolNumWhere;
	}

	/**
	 * 可使用次数设定
	 * @param toolNumWhere
	 */
	public void setToolNumWhere (BigDecimal toolNumWhere) {
		this.toolNumWhere = toolNumWhere;
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

	/* 	*/ 
	private BigDecimal planGrindingTimesWhere;

	/**
	 * 取得
	 * @return planGrindingTimesWhere
	 */
	public BigDecimal getplanGrindingTimesWhere () {
		return planGrindingTimesWhere;
	}

	/**
	 * 设定
	 * @param planGrindingTimesWhere
	 */
	public void setplanGrindingTimesWhere (BigDecimal planGrindingTimesWhere) {
		this.planGrindingTimesWhere = planGrindingTimesWhere;
	}

	/* 可使用(刃磨)次数	*/ 
	private BigDecimal toolSharpennumWhere;

	/**
	 * 可使用(刃磨)次数取得
	 * @return toolSharpennumWhere
	 */
	public BigDecimal getToolSharpennumWhere () {
		return toolSharpennumWhere;
	}

	/**
	 * 可使用(刃磨)次数设定
	 * @param toolSharpennumWhere
	 */
	public void setToolSharpennumWhere (BigDecimal toolSharpennumWhere) {
		this.toolSharpennumWhere = toolSharpennumWhere;
	}

	/* 	*/ 
	private BigDecimal toolProcessingVolumeWhere;

	/**
	 * 取得
	 * @return toolProcessingVolumeWhere
	 */
	public BigDecimal getToolProcessingVolumeWhere () {
		return toolProcessingVolumeWhere;
	}

	/**
	 * 设定
	 * @param toolProcessingVolumeWhere
	 */
	public void setToolProcessingVolumeWhere (BigDecimal toolProcessingVolumeWhere) {
		this.toolProcessingVolumeWhere = toolProcessingVolumeWhere;
	}
}

