/*
 * 工具自动生成：条件实体类
 * 生成时间    : 2016/09/03 09:55:10
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 条件实体类
 * @author 工具自动生成
 * 创建时间：2016/09/03 09:55:10
 * 创建者  ：工具自动生成
 * 
 */
public class ToolspriceWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具id	*/ 
	private String toolIDWhere;

	/**
	 * 刀具id取得
	 * @return toolIDWhere
	 */
	public String getToolIDWhere () {
		return toolIDWhere;
	}

	/**
	 * 刀具id设定
	 * @param toolIDWhere
	 */
	public void setToolIDWhere (String toolIDWhere) {
		this.toolIDWhere = toolIDWhere;
	}

	/* 材料号	*/ 
	private String toolCodeWhere;

	/**
	 * 材料号取得
	 * @return toolCodeWhere
	 */
	public String getToolCodeWhere () {
		return toolCodeWhere;
	}

	/**
	 * 材料号设定
	 * @param toolCodeWhere
	 */
	public void setToolCodeWhere (String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}

	/* 平均价	*/ 
	private BigDecimal avgPricesWhere;

	/**
	 * 平均价取得
	 * @return avgPricesWhere
	 */
	public BigDecimal getAvgPricesWhere () {
		return avgPricesWhere;
	}

	/**
	 * 平均价设定
	 * @param avgPricesWhere
	 */
	public void setAvgPricesWhere (BigDecimal avgPricesWhere) {
		this.avgPricesWhere = avgPricesWhere;
	}
}

