/*
 * 工具自动生成：实体类
 * 生成时间    : 2016/09/03 09:55:10
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 实体类
 * @author 工具自动生成
 * 创建时间：2016/09/03 09:55:10
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Toolsprice extends ToolspriceWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具id	*/ 
	private String toolID;

	/**
	 * 刀具id取得
	 * @return toolID
	 */
	public String getToolID() {
		return toolID;
	}

	/**
	 * 刀具id设定
	 * @param toolID
	 */
	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	/* 材料号	*/ 
	private String toolCode;

	/**
	 * 材料号取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 材料号设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 平均价	*/ 
	private BigDecimal avgPrices;

	/**
	 * 平均价取得
	 * @return avgPrices
	 */
	public BigDecimal getAvgPrices() {
		return avgPrices;
	}

	/**
	 * 平均价设定
	 * @param avgPrices
	 */
	public void setAvgPrices(BigDecimal avgPrices) {
		this.avgPrices = avgPrices;
	}
}

