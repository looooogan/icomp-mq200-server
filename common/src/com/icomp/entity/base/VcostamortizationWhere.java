/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/05/30 11:44:01
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/05/30 11:44:01
 * 创建者  ：工具自动生成
 * 
 */
public class VcostamortizationWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 零部件名称	*/ 
	private String partsNameWhere;

	/**
	 * 零部件名称取得
	 * @return partsNameWhere
	 */
	public String getPartsNameWhere () {
		return partsNameWhere;
	}

	/**
	 * 零部件名称设定
	 * @param partsNameWhere
	 */
	public void setPartsNameWhere (String partsNameWhere) {
		this.partsNameWhere = partsNameWhere;
	}

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
	private String unitPriceWhere;

	/**
	 * 取得
	 * @return unitPriceWhere
	 */
	public String getUnitPriceWhere () {
		return unitPriceWhere;
	}

	/**
	 * 设定
	 * @param unitPriceWhere
	 */
	public void setUnitPriceWhere (String unitPriceWhere) {
		this.unitPriceWhere = unitPriceWhere;
	}

	/* 	*/ 
	private BigDecimal userNumberWhere;

	/**
	 * 取得
	 * @return userNumberWhere
	 */
	public BigDecimal getUserNumberWhere () {
		return userNumberWhere;
	}

	/**
	 * 设定
	 * @param userNumberWhere
	 */
	public void setUserNumberWhere (BigDecimal userNumberWhere) {
		this.userNumberWhere = userNumberWhere;
	}

	/* 	*/ 
	private String amortizationRMBWhere;

	/**
	 * 取得
	 * @return amortizationRMBWhere
	 */
	public String getAmortizationRMBWhere () {
		return amortizationRMBWhere;
	}

	/**
	 * 设定
	 * @param amortizationRMBWhere
	 */
	public void setAmortizationRMBWhere (String amortizationRMBWhere) {
		this.amortizationRMBWhere = amortizationRMBWhere;
	}
}

