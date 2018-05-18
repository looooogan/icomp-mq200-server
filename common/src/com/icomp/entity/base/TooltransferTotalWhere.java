/*
 * 工具自动生成：条件实体类
 * 生成时间    : 2016/03/11 13:10:45
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;

import java.math.BigDecimal;


/**
 * 条件实体类
 * @author 工具自动生成
 * 创建时间：2016/03/11 13:10:45
 * 创建者  ：工具自动生成
 *
 */
public class TooltransferTotalWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具材料号	*/
	private String toolCodeWhere;

	/**
	 * 刀具材料号取得
	 * @return toolCodeWhere
	 */
	public String getToolCodeWhere() {
		return toolCodeWhere;
	}

	/**
	 * 刀具材料号设定
	 * @param toolCodeWhere
	 */
	public void setToolCodeWhere(String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}

	/* 备刀数量	*/
	private BigDecimal spareKnifeSumWhere;

	/**
	 * 备刀数量取得
	 * @return spareKnifeSumWhere
	 */
	public BigDecimal getSpareKnifeSumWhere() {
		return spareKnifeSumWhere;
	}

	/**
	 * 备刀数量设定
	 * @param spareKnifeSumWhere
	 */
	public void setSpareKnifeSumWhere(BigDecimal spareKnifeSumWhere) {
		this.spareKnifeSumWhere = spareKnifeSumWhere;
	}

	/* 厂内修磨数量	*/
	private BigDecimal grindingFactorySnumWhere;

	/**
	 * 厂内修磨数量取得
	 * @return grindingFactorySnumWhere
	 */
	public BigDecimal getGrindingFactorySnumWhere() {
		return grindingFactorySnumWhere;
	}

	/**
	 * 厂内修磨数量设定
	 * @param grindingFactorySnumWhere
	 */
	public void setGrindingFactorySnumWhere(BigDecimal grindingFactorySnumWhere) {
		this.grindingFactorySnumWhere = grindingFactorySnumWhere;
	}

	/* 厂外修磨数量	*/
	private BigDecimal externalGrindingSumWhere;

	/**
	 * 厂外修磨数量取得
	 * @return externalGrindingSumWhere
	 */
	public BigDecimal getExternalGrindingSumWhere() {
		return externalGrindingSumWhere;
	}

	/**
	 * 厂外修磨数量设定
	 * @param externalGrindingSumWhere
	 */
	public void setExternalGrindingSumWhere(BigDecimal externalGrindingSumWhere) {
		this.externalGrindingSumWhere = externalGrindingSumWhere;
	}

	/* 生成中刀具数量	*/
	private BigDecimal productionLineSumWhere;

	/**
	 * 生成中刀具数量取得
	 * @return productionLineSumWhere
	 */
	public BigDecimal getProductionLineSumWhere() {
		return productionLineSumWhere;
	}

	/**
	 * 生成中刀具数量设定
	 * @param productionLineSumWhere
	 */
	public void setProductionLineSumWhere(BigDecimal productionLineSumWhere) {
		this.productionLineSumWhere = productionLineSumWhere;
	}
}

