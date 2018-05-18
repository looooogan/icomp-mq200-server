package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;

import com.icomp.common.entity.BaseEntity;

public class SubAvgProcessAmount  extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;
	//刀具编码
	private String toolCode;
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	//零部件ID 
	private String assemblyLineID;
	//生产年月 
	private String outerTime;
	//最高产量 
	private BigDecimal maxProcessAmount;
	//平均产量 
	private BigDecimal avgProcessAmount;
	public String getAssemblyLineID() {
		return assemblyLineID;
	}
	public void setAssemblyLineID(String assemblyLineID) {
		this.assemblyLineID = assemblyLineID;
	}
	public String getOuterTime() {
		return outerTime;
	}
	public void setOuterTime(String outerTime) {
		this.outerTime = outerTime;
	}
	public BigDecimal getMaxProcessAmount() {
		return maxProcessAmount;
	}
	public void setMaxProcessAmount(BigDecimal maxProcessAmount) {
		this.maxProcessAmount = maxProcessAmount;
	}
	public BigDecimal getAvgProcessAmount() {
		return avgProcessAmount;
	}
	public void setAvgProcessAmount(BigDecimal avgProcessAmount) {
		this.avgProcessAmount = avgProcessAmount;
	}
}
