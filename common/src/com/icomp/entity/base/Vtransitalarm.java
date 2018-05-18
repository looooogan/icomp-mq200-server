/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:05
 * 创建者  ：杨作庆
 * 
 */
public class Vtransitalarm extends VtransitalarmWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 采购批次	*/ 
	private String procuredBatch;

	/**
	 * 采购批次取得
	 * @return procuredBatch
	 */
	public String getProcuredBatch() {
		return procuredBatch;
	}

	/**
	 * 采购批次设定
	 * @param procuredBatch
	 */
	public void setProcuredBatch(String procuredBatch) {
		this.procuredBatch = procuredBatch;
	}

	/* 预计到货时间	*/ 
	private String theyTime;

	/**
	 * 预计到货时间取得
	 * @return theyTime
	 */
	public String getTheyTime() {
		return theyTime;
	}

	/**
	 * 预计到货时间设定
	 * @param theyTime
	 */
	public void setTheyTime(String theyTime) {
		this.theyTime = theyTime;
	}

	/* 	*/ 
	private BigDecimal theyCount;

	/**
	 * 取得
	 * @return theyCount
	 */
	public BigDecimal getTheyCount() {
		return theyCount;
	}

	/**
	 * 设定
	 * @param theyCount
	 */
	public void setTheyCount(BigDecimal theyCount) {
		this.theyCount = theyCount;
	}

	/* 货品状态(0未到货1已到货2质检通过3质检未通过)	*/ 
	private String theyStatus;

	/**
	 * 货品状态(0未到货1已到货2质检通过3质检未通过)取得
	 * @return theyStatus
	 */
	public String getTheyStatus() {
		return theyStatus;
	}

	/**
	 * 货品状态(0未到货1已到货2质检通过3质检未通过)设定
	 * @param theyStatus
	 */
	public void setTheyStatus(String theyStatus) {
		this.theyStatus = theyStatus;
	}

	/* 实际到货时间	*/ 
	private Date realityTheyTime;

	/**
	 * 实际到货时间取得
	 * @return realityTheyTime
	 */
	public Date getRealityTheyTime() {
		return realityTheyTime;
	}

	/**
	 * 实际到货时间设定
	 * @param realityTheyTime
	 */
	public void setRealityTheyTime(Date realityTheyTime) {
		this.realityTheyTime = realityTheyTime;
	}

	/* 实际到货数量	*/ 
	private BigDecimal realityTheyCount;

	/**
	 * 实际到货数量取得
	 * @return realityTheyCount
	 */
	public BigDecimal getRealityTheyCount() {
		return realityTheyCount;
	}

	/**
	 * 实际到货数量设定
	 * @param realityTheyCount
	 */
	public void setRealityTheyCount(BigDecimal realityTheyCount) {
		this.realityTheyCount = realityTheyCount;
	}
}

