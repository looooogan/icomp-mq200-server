/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/24 10:03:49
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/24 10:03:49
 * 创建者  ：杨作庆
 * 
 */
public class VpriceWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 	*/ 
	private String toolCodeWhere;

	/**
	 * 取得
	 * @return toolCodeWhere
	 */
	public String getToolCodeWhere () {
		return toolCodeWhere;
	}

	/**
	 * 设定
	 * @param toolCodeWhere
	 */
	public void setToolCodeWhere (String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}


	/* 	*/ 
	private String businessFlowLnkIDWhere;

	/**
	 * 取得
	 * @return businessFlowLnkIDWhere
	 */
	public String getBusinessFlowLnkIDWhere () {
		return businessFlowLnkIDWhere;
	}

	/**
	 * 设定
	 * @param businessFlowLnkIDWhere
	 */
	public void setBusinessFlowLnkIDWhere (String businessFlowLnkIDWhere) {
		this.businessFlowLnkIDWhere = businessFlowLnkIDWhere;
	}

	/* 	*/ 
	private BigDecimal unitPriceWhere;

	/**
	 * 取得
	 * @return unitPriceWhere
	 */
	public BigDecimal getUnitPriceWhere () {
		return unitPriceWhere;
	}

	/**
	 * 设定
	 * @param unitPriceWhere
	 */
	public void setUnitPriceWhere (BigDecimal unitPriceWhere) {
		this.unitPriceWhere = unitPriceWhere;
	}
}

