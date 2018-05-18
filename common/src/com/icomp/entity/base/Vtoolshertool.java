/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/08/15 14:40:51
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/08/15 14:40:51
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vtoolshertool extends VtoolshertoolWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 	*/ 
	private String toolID;

	/**
	 * 取得
	 * @return toolID
	 */
	public String getToolID() {
		return toolID;
	}

	/**
	 * 设定
	 * @param toolID
	 */
	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	/* 	*/ 
	private String toolCode;

	/**
	 * 取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 	*/ 
	private String toolDurable;

	/**
	 * 取得
	 * @return toolDurable
	 */
	public String getToolDurable() {
		return toolDurable;
	}

	/**
	 * 设定
	 * @param toolDurable
	 */
	public void setToolDurable(String toolDurable) {
		this.toolDurable = toolDurable;
	}

	/* 	*/ 
	private BigDecimal toolMax;

	/**
	 * 取得
	 * @return toolMax
	 */
	public BigDecimal getToolMax() {
		return toolMax;
	}

	/**
	 * 设定
	 * @param toolMax
	 */
	public void setToolMax(BigDecimal toolMax) {
		this.toolMax = toolMax;
	}

	/* 	*/ 
	private BigDecimal toolMin;

	/**
	 * 取得
	 * @return toolMin
	 */
	public BigDecimal getToolMin() {
		return toolMin;
	}

	/**
	 * 设定
	 * @param toolMin
	 */
	public void setToolMin(BigDecimal toolMin) {
		this.toolMin = toolMin;
	}
}

