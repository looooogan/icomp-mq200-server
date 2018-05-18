/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:05
 * 创建者  ：杨作庆
 * 
 */
public class VqualityinspectionWhere extends BaseEntity implements Serializable {

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

	/* 采购者(关联用户ID)	*/ 
	private String procuredUserWhere;

	/**
	 * 采购者(关联用户ID)取得
	 * @return procuredUserWhere
	 */
	public String getProcuredUserWhere () {
		return procuredUserWhere;
	}

	/**
	 * 采购者(关联用户ID)设定
	 * @param procuredUserWhere
	 */
	public void setProcuredUserWhere (String procuredUserWhere) {
		this.procuredUserWhere = procuredUserWhere;
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

	/* 	*/ 
	private String deliveryPlanIDWhere;

	/**
	 * 取得
	 * @return deliveryPlanIDWhere
	 */
	public String getdeliveryPlanIDWhere () {
		return deliveryPlanIDWhere;
	}

	/**
	 * 设定
	 * @param deliveryPlanIDWhere
	 */
	public void setdeliveryPlanIDWhere (String deliveryPlanIDWhere) {
		this.deliveryPlanIDWhere = deliveryPlanIDWhere;
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
}

