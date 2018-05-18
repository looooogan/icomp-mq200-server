package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;

import com.icomp.common.entity.BaseEntity;

public class SubProductionDesign  extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;
	//刀具编码 
	private String toolCode;
	//计划年月 
	private String productiontime;
	private String newProductiontime;
	public String getNewProductiontime() {
		return newProductiontime;
	}
	public void setNewProductiontime(String newProductiontime) {
		this.newProductiontime = newProductiontime;
	}
	//计划季度 
	private String productionQuarter;
	//零部件ID
	private String assemblyLineID;
	//零部件名称 
	private String assemblyLineName;
	//计划产量 
	private BigDecimal production;
	//计划年份
	private String productionYear;
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	public String getProductiontime() {
		return productiontime;
	}
	public void setProductiontime(String productiontime) {
		this.productiontime = productiontime;
	}
	public String getProductionQuarter() {
		return productionQuarter;
	}
	public void setProductionQuarter(String productionQuarter) {
		this.productionQuarter = productionQuarter;
	}
	public String getAssemblyLineID() {
		return assemblyLineID;
	}
	public void setAssemblyLineID(String assemblyLineID) {
		this.assemblyLineID = assemblyLineID;
	}
	public String getAssemblyLineName() {
		return assemblyLineName;
	}
	public void setAssemblyLineName(String assemblyLineName) {
		this.assemblyLineName = assemblyLineName;
	}
	public BigDecimal getProduction() {
		return production;
	}
	public void setProduction(BigDecimal production) {
		this.production = production;
	}
	public String getProductionYear() {
		return productionYear;
	}
	public void setProductionYear(String productionYear) {
		this.productionYear = productionYear;
	}
}
