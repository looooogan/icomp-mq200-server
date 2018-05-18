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
public class VtreasuryrepairtoolWhere extends BaseEntity implements Serializable {

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

	/* 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)	*/ 
	private String repairWayWhere;

	/**
	 * 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)取得
	 * @return repairWayWhere
	 */
	public String getRepairWayWhere () {
		return repairWayWhere;
	}

	/**
	 * 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)设定
	 * @param repairWayWhere
	 */
	public void setRepairWayWhere (String repairWayWhere) {
		this.repairWayWhere = repairWayWhere;
	}

	/* 	*/ 
	private BigDecimal repairCountWhere;

	/**
	 * 取得
	 * @return repairCountWhere
	 */
	public BigDecimal getrepairCountWhere () {
		return repairCountWhere;
	}

	/**
	 * 设定
	 * @param repairCountWhere
	 */
	public void setrepairCountWhere (BigDecimal repairCountWhere) {
		this.repairCountWhere = repairCountWhere;
	}
}

