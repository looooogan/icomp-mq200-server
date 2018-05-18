/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/17 14:16:49
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/17 14:16:49
 * 创建者  ：杨作庆
 * 
 */
public class Vproductiondesign extends VproductiondesignWhere implements Serializable {

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

	/* 流水线名称	*/ 
	private String assemblyLineName;

	/**
	 * 流水线名称取得
	 * @return assemblyLineName
	 */
	public String getAssemblyLineName() {
		return assemblyLineName;
	}

	/**
	 * 流水线名称设定
	 * @param assemblyLineName
	 */
	public void setAssemblyLineName(String assemblyLineName) {
		this.assemblyLineName = assemblyLineName;
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

