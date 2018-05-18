/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/25 14:29:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/25 14:29:03
 * 创建者  ：杨作庆
 * 
 */
public class VconsumptiontoolWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 零部件名称	*/ 
	private String partsNameWhere;

	/**
	 * 零部件名称取得
	 * @return partsNameWhere
	 */
	public String getPartsNameWhere () {
		return partsNameWhere;
	}

	/**
	 * 零部件名称设定
	 * @param partsNameWhere
	 */
	public void setPartsNameWhere (String partsNameWhere) {
		this.partsNameWhere = partsNameWhere;
	}

	/* 刀具编码	*/ 
	private String toolCodeWhere;

	/**
	 * 刀具编码取得
	 * @return toolCodeWhere
	 */
	public String getToolCodeWhere () {
		return toolCodeWhere;
	}

	/**
	 * 刀具编码设定
	 * @param toolCodeWhere
	 */
	public void setToolCodeWhere (String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}

	/* 刀具名称	*/ 
	private String toolNameWhere;

	/**
	 * 刀具名称取得
	 * @return toolNameWhere
	 */
	public String getToolNameWhere () {
		return toolNameWhere;
	}

	/**
	 * 刀具名称设定
	 * @param toolNameWhere
	 */
	public void setToolNameWhere (String toolNameWhere) {
		this.toolNameWhere = toolNameWhere;
	}

	/* 	*/ 
	private BigDecimal consumedCountWhere;

	/**
	 * 取得
	 * @return consumedCountWhere
	 */
	public BigDecimal getconsumedCountWhere () {
		return consumedCountWhere;
	}

	/**
	 * 设定
	 * @param consumedCountWhere
	 */
	public void setconsumedCountWhere (BigDecimal consumedCountWhere) {
		this.consumedCountWhere = consumedCountWhere;
	}

	/* 定额加工量	*/ 
	private BigDecimal quotaProcessingVolumeWhere;

	/**
	 * 定额加工量取得
	 * @return quotaProcessingVolumeWhere
	 */
	public BigDecimal getQuotaProcessingVolumeWhere () {
		return quotaProcessingVolumeWhere;
	}

	/**
	 * 定额加工量设定
	 * @param quotaProcessingVolumeWhere
	 */
	public void setQuotaProcessingVolumeWhere (BigDecimal quotaProcessingVolumeWhere) {
		this.quotaProcessingVolumeWhere = quotaProcessingVolumeWhere;
	}

	/* 加工数量	*/ 
	private BigDecimal processAmountWhere;

	/**
	 * 加工数量取得
	 * @return processAmountWhere
	 */
	public BigDecimal getProcessAmountWhere () {
		return processAmountWhere;
	}

	/**
	 * 加工数量设定
	 * @param processAmountWhere
	 */
	public void setProcessAmountWhere (BigDecimal processAmountWhere) {
		this.processAmountWhere = processAmountWhere;
	}

	/* 	*/ 
	private BigDecimal processAmountSumWhere;

	/**
	 * 取得
	 * @return processAmountSumWhere
	 */
	public BigDecimal getProcessAmountSumWhere () {
		return processAmountSumWhere;
	}

	/**
	 * 设定
	 * @param processAmountSumWhere
	 */
	public void setProcessAmountSumWhere (BigDecimal processAmountSumWhere) {
		this.processAmountSumWhere = processAmountSumWhere;
	}

	/* 	*/ 
	private String avgNumWhere;

	/**
	 * 取得
	 * @return avgNumWhere
	 */
	public String getAvgNumWhere () {
		return avgNumWhere;
	}

	/**
	 * 设定
	 * @param avgNumWhere
	 */
	public void setAvgNumWhere (String avgNumWhere) {
		this.avgNumWhere = avgNumWhere;
	}

	/* 	*/ 
	private BigDecimal planGrindingTimesWhere;

	/**
	 * 取得
	 * @return planGrindingTimesWhere
	 */
	public BigDecimal getplanGrindingTimesWhere () {
		return planGrindingTimesWhere;
	}

	/**
	 * 设定
	 * @param planGrindingTimesWhere
	 */
	public void setplanGrindingTimesWhere (BigDecimal planGrindingTimesWhere) {
		this.planGrindingTimesWhere = planGrindingTimesWhere;
	}

	/* 	*/ 
	private BigDecimal actualGrindingTimesWhere;

	/**
	 * 取得
	 * @return actualGrindingTimesWhere
	 */
	public BigDecimal getactualGrindingTimesWhere () {
		return actualGrindingTimesWhere;
	}

	/**
	 * 设定
	 * @param actualGrindingTimesWhere
	 */
	public void setactualGrindingTimesWhere (BigDecimal actualGrindingTimesWhere) {
		this.actualGrindingTimesWhere = actualGrindingTimesWhere;
	}
}

