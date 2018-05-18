/*
 * 工具自动生成：生产计划实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 生产计划实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class Productiondesign extends ProductiondesignWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 生产计划ID	*/ 
	private String productionDesignID;

	/**
	 * 生产计划ID取得
	 * @return productionDesignID
	 */
	public String getProductionDesignID() {
		return productionDesignID;
	}

	/**
	 * 生产计划ID设定
	 * @param productionDesignID
	 */
	public void setProductionDesignID(String productionDesignID) {
		this.productionDesignID = productionDesignID;
	}

	/* 计划年	*/ 
	private String productionYear;

	/**
	 * 计划年取得
	 * @return productionYear
	 */
	public String getProductionYear() {
		return productionYear;
	}

	/**
	 * 计划年设定
	 * @param productionYear
	 */
	public void setProductionYear(String productionYear) {
		this.productionYear = productionYear;
	}

	/* 计划月	*/ 
	private String productionMonth;

	/**
	 * 计划月取得
	 * @return productionMonth
	 */
	public String getProductionMonth() {
		return productionMonth;
	}

	/**
	 * 计划月设定
	 * @param productionMonth
	 */
	public void setProductionMonth(String productionMonth) {
		this.productionMonth = productionMonth;
	}

	/* 所属季度	*/ 
	private String productionQuarter;

	/**
	 * 所属季度取得
	 * @return productionQuarter
	 */
	public String getProductionQuarter() {
		return productionQuarter;
	}

	/**
	 * 所属季度设定
	 * @param productionQuarter
	 */
	public void setProductionQuarter(String productionQuarter) {
		this.productionQuarter = productionQuarter;
	}

	/* 生产零部件	*/ 
	private String assemblyLineID;

	/**
	 * 生产零部件取得
	 * @return assemblyLineID
	 */
	public String getAssemblyLineID() {
		return assemblyLineID;
	}

	/**
	 * 生产零部件设定
	 * @param assemblyLineID
	 */
	public void setAssemblyLineID(String assemblyLineID) {
		this.assemblyLineID = assemblyLineID;
	}

	/* 生产量	*/ 
	private BigDecimal production;

	/**
	 * 生产量取得
	 * @return production
	 */
	public BigDecimal getProduction() {
		return production;
	}

	/**
	 * 生产量设定
	 * @param production
	 */
	public void setProduction(BigDecimal production) {
		this.production = production;
	}
}

