package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;

import com.icomp.common.entity.BaseEntity;

public class SubToolProcessAmount  extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;
	// 刀具编码
	private String toolCode;
	// 加工数量
	private BigDecimal processAmount;
	// 安上日期 
	private String loadTime;
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	public BigDecimal getProcessAmount() {
		return processAmount;
	}
	public void setProcessAmount(BigDecimal processAmount) {
		this.processAmount = processAmount;
	}
	public String getLoadTime() {
		return loadTime;
	}
	public void setLoadTime(String loadTime) {
		this.loadTime = loadTime;
	}
	// 安上次数
	private BigDecimal loadCount;
	public BigDecimal getLoadCount() {
		return loadCount;
	}
	public void setLoadCount(BigDecimal loadCount) {
		this.loadCount = loadCount;
	}
	
}
