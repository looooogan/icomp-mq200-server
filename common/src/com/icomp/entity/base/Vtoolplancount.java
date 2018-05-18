/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/22 13:55:41
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/22 13:55:41
 * 创建者  ：杨作庆
 * 
 */
public class Vtoolplancount extends VtoolplancountWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具编码	*/ 
	private String toolCode;
	/* 	*/ 
	private BigDecimal planCount;
	/* 	*/ 
	private BigDecimal subCount;
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	public BigDecimal getPlanCount() {
		return planCount;
	}
	public void setPlanCount(BigDecimal planCount) {
		this.planCount = planCount;
	}
	public BigDecimal getSubCount() {
		return subCount;
	}
	public void setSubCount(BigDecimal subCount) {
		this.subCount = subCount;
	}
}

