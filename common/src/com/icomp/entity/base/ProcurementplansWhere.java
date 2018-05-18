/*
 * 工具自动生成：采购计划条件实体类
 * 生成时间    : 2015/02/16 09:49:28
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * 采购计划条件实体类
 * @author 工具自动生成
 * 创建时间：2015/02/16 09:49:28
 * 创建者  ：杨作庆
 * 
 */
public class ProcurementplansWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 采购计划ID	*/ 
	private String procurementPlansIDWhere;

	/**
	 * 采购计划ID取得
	 * @return procurementPlansIDWhere
	 */
	public String getProcurementPlansIDWhere () {
		return procurementPlansIDWhere;
	}

	/**
	 * 采购计划ID设定
	 * @param procurementPlansIDWhere
	 */
	public void setProcurementPlansIDWhere (String procurementPlansIDWhere) {
		this.procurementPlansIDWhere = procurementPlansIDWhere;
	}

	/* 采购计划编号	*/ 
	private String procurementPlansCodeWhere;

	/**
	 * 采购计划编号取得
	 * @return procurementPlansCodeWhere
	 */
	public String getProcurementPlansCodeWhere () {
		return procurementPlansCodeWhere;
	}

	/**
	 * 采购计划编号设定
	 * @param procurementPlansCodeWhere
	 */
	public void setProcurementPlansCodeWhere (String procurementPlansCodeWhere) {
		this.procurementPlansCodeWhere = procurementPlansCodeWhere;
	}

	/* 刀具ID	*/ 
	private String toolIDWhere;

	/**
	 * 刀具ID取得
	 * @return toolIDWhere
	 */
	public String getToolIDWhere () {
		return toolIDWhere;
	}

	/**
	 * 刀具ID设定
	 * @param toolIDWhere
	 */
	public void setToolIDWhere (String toolIDWhere) {
		this.toolIDWhere = toolIDWhere;
	}

	/* 库存量	*/ 
	private BigDecimal inventoryWhere;

	/**
	 * 库存量取得
	 * @return inventoryWhere
	 */
	public BigDecimal getInventoryWhere () {
		return inventoryWhere;
	}

	/**
	 * 库存量设定
	 * @param inventoryWhere
	 */
	public void setInventoryWhere (BigDecimal inventoryWhere) {
		this.inventoryWhere = inventoryWhere;
	}

	/* 生产计划(总数)	*/ 
	private BigDecimal productionPlanWhere;

	/**
	 * 生产计划(总数)取得
	 * @return productionPlanWhere
	 */
	public BigDecimal getProductionPlanWhere () {
		return productionPlanWhere;
	}

	/**
	 * 生产计划(总数)设定
	 * @param productionPlanWhere
	 */
	public void setProductionPlanWhere (BigDecimal productionPlanWhere) {
		this.productionPlanWhere = productionPlanWhere;
	}

	/* 计划周期(天数)	*/ 
	private BigDecimal planningCyclesWhere;

	/**
	 * 计划周期(天数)取得
	 * @return planningCyclesWhere
	 */
	public BigDecimal getPlanningCyclesWhere () {
		return planningCyclesWhere;
	}

	/**
	 * 计划周期(天数)设定
	 * @param planningCyclesWhere
	 */
	public void setPlanningCyclesWhere (BigDecimal planningCyclesWhere) {
		this.planningCyclesWhere = planningCyclesWhere;
	}

	/* 加工效率(个/每天)	*/ 
	private BigDecimal efficiencyWhere;

	/**
	 * 加工效率(个/每天)取得
	 * @return efficiencyWhere
	 */
	public BigDecimal getEfficiencyWhere () {
		return efficiencyWhere;
	}

	/**
	 * 加工效率(个/每天)设定
	 * @param efficiencyWhere
	 */
	public void setEfficiencyWhere (BigDecimal efficiencyWhere) {
		this.efficiencyWhere = efficiencyWhere;
	}

	/* 应采购数量	*/ 
	private BigDecimal procurementCountWhere;

	/**
	 * 应采购数量取得
	 * @return procurementCountWhere
	 */
	public BigDecimal getProcurementCountWhere () {
		return procurementCountWhere;
	}

	/**
	 * 应采购数量设定
	 * @param procurementCountWhere
	 */
	public void setProcurementCountWhere (BigDecimal procurementCountWhere) {
		this.procurementCountWhere = procurementCountWhere;
	}

	/* 删除区分(0有效1删除)	*/ 
	private String delFlag2Where;

	/**
	 * 删除区分(0有效1删除)取得
	 * @return delFlag2Where
	 */
	public String getDelFlag2Where () {
		return delFlag2Where;
	}

	/**
	 * 删除区分(0有效1删除)设定
	 * @param delFlag2Where
	 */
	public void setDelFlag2Where (String delFlag2Where) {
		this.delFlag2Where = delFlag2Where;
	}
}

