package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;

import com.icomp.common.entity.BaseEntity;

public class SubToolAvgToolSharpennum  extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;
	// 刀具编码
	private String toolCode;
	// 采购周期
	private BigDecimal purchasingCycle;
	// 订单日期 
	private String procuredTime;
	// 到货日期 
	private String realityTheyTime;
	// 使用次数 
	private BigDecimal sycs;
	// 报废个数 
	private BigDecimal bfgs;
	// 平均使用次数
	private BigDecimal avgcs;
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	public BigDecimal getPurchasingCycle() {
		return purchasingCycle;
	}
	public void setPurchasingCycle(BigDecimal purchasingCycle) {
		this.purchasingCycle = purchasingCycle;
	}
	public String getProcuredTime() {
		return procuredTime;
	}
	public void setProcuredTime(String procuredTime) {
		this.procuredTime = procuredTime;
	}
	public String getRealityTheyTime() {
		return realityTheyTime;
	}
	public void setRealityTheyTime(String realityTheyTime) {
		this.realityTheyTime = realityTheyTime;
	}
	public BigDecimal getSycs() {
		return sycs;
	}
	public void setSycs(BigDecimal sycs) {
		this.sycs = sycs;
	}
	public BigDecimal getBfgs() {
		return bfgs;
	}
	public void setBfgs(BigDecimal bfgs) {
		this.bfgs = bfgs;
	}
	public BigDecimal getAvgcs() {
		return avgcs;
	}
	public void setAvgcs(BigDecimal avgcs) {
		this.avgcs = avgcs;
	}
}
