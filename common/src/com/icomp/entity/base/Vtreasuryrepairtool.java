/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:05
 * 创建者  ：杨作庆
 * 
 */
public class Vtreasuryrepairtool extends VtreasuryrepairtoolWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具编码	*/ 
	private String toolCode;

	/**
	 * 刀具编码取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 刀具编码设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)	*/ 
	private String repairWay;

	/**
	 * 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)取得
	 * @return repairWay
	 */
	public String getRepairWay() {
		return repairWay;
	}

	/**
	 * 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)设定
	 * @param repairWay
	 */
	public void setRepairWay(String repairWay) {
		this.repairWay = repairWay;
	}

	/* 	*/ 
	private BigDecimal repairCount;

	/**
	 * 取得
	 * @return repairCount
	 */
	public BigDecimal getrepairCount() {
		return repairCount;
	}

	/**
	 * 设定
	 * @param repairCount
	 */
	public void setrepairCount(BigDecimal repairCount) {
		this.repairCount = repairCount;
	}
}

