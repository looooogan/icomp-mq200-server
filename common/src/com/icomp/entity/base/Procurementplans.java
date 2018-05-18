/*
 * 工具自动生成：采购计划实体类
 * 生成时间    : 2015/02/16 09:49:28
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 采购计划实体类
 * @author 工具自动生成
 * 创建时间：2015/02/16 09:49:28
 * 创建者  ：杨作庆
 * 
 */
public class Procurementplans extends ProcurementplansWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 采购计划ID	*/ 
	private String procurementPlansID;

	/**
	 * 采购计划ID取得
	 * @return procurementPlansID
	 */
	public String getProcurementPlansID() {
		return procurementPlansID;
	}

	/**
	 * 采购计划ID设定
	 * @param procurementPlansID
	 */
	public void setProcurementPlansID(String procurementPlansID) {
		this.procurementPlansID = procurementPlansID;
	}

	/* 采购计划编号	*/ 
	private String procurementPlansCode;

	/**
	 * 采购计划编号取得
	 * @return procurementPlansCode
	 */
	public String getProcurementPlansCode() {
		return procurementPlansCode;
	}

	/**
	 * 采购计划编号设定
	 * @param procurementPlansCode
	 */
	public void setProcurementPlansCode(String procurementPlansCode) {
		this.procurementPlansCode = procurementPlansCode;
	}

	/* 刀具ID	*/ 
	private String toolID;

	/**
	 * 刀具ID取得
	 * @return toolID
	 */
	public String getToolID() {
		return toolID;
	}

	/**
	 * 刀具ID设定
	 * @param toolID
	 */
	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	/* 库存量	*/ 
	private BigDecimal inventory;

	/**
	 * 库存量取得
	 * @return inventory
	 */
	public BigDecimal getInventory() {
		return inventory;
	}

	/**
	 * 库存量设定
	 * @param inventory
	 */
	public void setInventory(BigDecimal inventory) {
		this.inventory = inventory;
	}

	/* 生产计划(总数)	*/ 
	private BigDecimal productionPlan;

	/**
	 * 生产计划(总数)取得
	 * @return productionPlan
	 */
	public BigDecimal getProductionPlan() {
		return productionPlan;
	}

	/**
	 * 生产计划(总数)设定
	 * @param productionPlan
	 */
	public void setProductionPlan(BigDecimal productionPlan) {
		this.productionPlan = productionPlan;
	}

	/* 计划周期(天数)	*/ 
	private BigDecimal planningCycles;

	/**
	 * 计划周期(天数)取得
	 * @return planningCycles
	 */
	public BigDecimal getPlanningCycles() {
		return planningCycles;
	}

	/**
	 * 计划周期(天数)设定
	 * @param planningCycles
	 */
	public void setPlanningCycles(BigDecimal planningCycles) {
		this.planningCycles = planningCycles;
	}

	/* 加工效率(个/每天)	*/ 
	private BigDecimal efficiency;

	/**
	 * 加工效率(个/每天)取得
	 * @return efficiency
	 */
	public BigDecimal getEfficiency() {
		return efficiency;
	}

	/**
	 * 加工效率(个/每天)设定
	 * @param efficiency
	 */
	public void setEfficiency(BigDecimal efficiency) {
		this.efficiency = efficiency;
	}

	/* 应采购数量	*/ 
	private BigDecimal procurementCount;

	/**
	 * 应采购数量取得
	 * @return procurementCount
	 */
	public BigDecimal getProcurementCount() {
		return procurementCount;
	}

	/**
	 * 应采购数量设定
	 * @param procurementCount
	 */
	public void setProcurementCount(BigDecimal procurementCount) {
		this.procurementCount = procurementCount;
	}

	/* 删除区分(0有效1删除)	*/ 
	private String delFlag2;

	/**
	 * 删除区分(0有效1删除)取得
	 * @return delFlag2
	 */
	public String getDelFlag2() {
		return delFlag2;
	}

	/**
	 * 删除区分(0有效1删除)设定
	 * @param delFlag2
	 */
	public void setDelFlag2(String delFlag2) {
		this.delFlag2 = delFlag2;
	}
}

