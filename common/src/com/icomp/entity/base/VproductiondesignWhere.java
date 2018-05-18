/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/17 14:16:49
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/17 14:16:49
 * 创建者  ：杨作庆
 * 
 */
public class VproductiondesignWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 生产计划ID	*/ 
	private String productionDesignIDWhere;

	/**
	 * 生产计划ID取得
	 * @return productionDesignIDWhere
	 */
	public String getProductionDesignIDWhere () {
		return productionDesignIDWhere;
	}

	/**
	 * 生产计划ID设定
	 * @param productionDesignIDWhere
	 */
	public void setProductionDesignIDWhere (String productionDesignIDWhere) {
		this.productionDesignIDWhere = productionDesignIDWhere;
	}

	/* 计划年	*/ 
	private String productionYearWhere;

	/**
	 * 计划年取得
	 * @return productionYearWhere
	 */
	public String getProductionYearWhere () {
		return productionYearWhere;
	}

	/**
	 * 计划年设定
	 * @param productionYearWhere
	 */
	public void setProductionYearWhere (String productionYearWhere) {
		this.productionYearWhere = productionYearWhere;
	}

	/* 所属季度	*/ 
	private String productionQuarterWhere;

	/**
	 * 所属季度取得
	 * @return productionQuarterWhere
	 */
	public String getProductionQuarterWhere () {
		return productionQuarterWhere;
	}

	/**
	 * 所属季度设定
	 * @param productionQuarterWhere
	 */
	public void setProductionQuarterWhere (String productionQuarterWhere) {
		this.productionQuarterWhere = productionQuarterWhere;
	}

	/* 计划月	*/ 
	private String productionMonthWhere;

	/**
	 * 计划月取得
	 * @return productionMonthWhere
	 */
	public String getProductionMonthWhere () {
		return productionMonthWhere;
	}

	/**
	 * 计划月设定
	 * @param productionMonthWhere
	 */
	public void setProductionMonthWhere (String productionMonthWhere) {
		this.productionMonthWhere = productionMonthWhere;
	}

	/* 生产零部件	*/ 
	private String assemblyLineIDWhere;

	/**
	 * 生产零部件取得
	 * @return assemblyLineIDWhere
	 */
	public String getAssemblyLineIDWhere () {
		return assemblyLineIDWhere;
	}

	/**
	 * 生产零部件设定
	 * @param assemblyLineIDWhere
	 */
	public void setAssemblyLineIDWhere (String assemblyLineIDWhere) {
		this.assemblyLineIDWhere = assemblyLineIDWhere;
	}

	/* 流水线名称	*/ 
	private String assemblyLineNameWhere;

	/**
	 * 流水线名称取得
	 * @return assemblyLineNameWhere
	 */
	public String getAssemblyLineNameWhere () {
		return assemblyLineNameWhere;
	}

	/**
	 * 流水线名称设定
	 * @param assemblyLineNameWhere
	 */
	public void setAssemblyLineNameWhere (String assemblyLineNameWhere) {
		this.assemblyLineNameWhere = assemblyLineNameWhere;
	}

	/* 生产量	*/ 
	private BigDecimal productionWhere;

	/**
	 * 生产量取得
	 * @return productionWhere
	 */
	public BigDecimal getProductionWhere () {
		return productionWhere;
	}

	/**
	 * 生产量设定
	 * @param productionWhere
	 */
	public void setProductionWhere (BigDecimal productionWhere) {
		this.productionWhere = productionWhere;
	}
}

