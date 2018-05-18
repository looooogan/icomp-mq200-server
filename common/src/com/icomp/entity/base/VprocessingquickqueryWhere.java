/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2015/01/04 17:34:49
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2015/01/04 17:34:49
 * 创建者  ：杨作庆
 * 
 */
public class VprocessingquickqueryWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 合成刀具编码(系统唯一)	*/ 
	private String synthesisParametersCodeWhere;

	/**
	 * 合成刀具编码(系统唯一)取得
	 * @return synthesisParametersCodeWhere
	 */
	public String getSynthesisParametersCodeWhere () {
		return synthesisParametersCodeWhere;
	}

	/**
	 * 合成刀具编码(系统唯一)设定
	 * @param synthesisParametersCodeWhere
	 */
	public void setSynthesisParametersCodeWhere (String synthesisParametersCodeWhere) {
		this.synthesisParametersCodeWhere = synthesisParametersCodeWhere;
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

	/* 业务流程名	*/ 
	private String businessNameWhere;

	/**
	 * 业务流程名取得
	 * @return businessNameWhere
	 */
	public String getBusinessNameWhere () {
		return businessNameWhere;
	}

	/**
	 * 业务流程名设定
	 * @param businessNameWhere
	 */
	public void setBusinessNameWhere (String businessNameWhere) {
		this.businessNameWhere = businessNameWhere;
	}

	/* 刀具状态(0断刀1丢失2不合格3借入4申领9其他)	*/ 
	private String toolStateWhere;

	/**
	 * 刀具状态(0断刀1丢失2不合格3借入4申领9其他)取得
	 * @return toolStateWhere
	 */
	public String gettoolStateWhere () {
		return toolStateWhere;
	}

	/**
	 * 刀具状态(0断刀1丢失2不合格3借入4申领9其他)设定
	 * @param toolStateWhere
	 */
	public void settoolStateWhere (String toolStateWhere) {
		this.toolStateWhere = toolStateWhere;
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

	/* 刀具入库编码	*/ 
	private String knifeInventoryCodeWhere;

	/**
	 * 刀具入库编码取得
	 * @return knifeInventoryCodeWhere
	 */
	public String getKnifeInventoryCodeWhere () {
		return knifeInventoryCodeWhere;
	}

	/**
	 * 刀具入库编码设定
	 * @param knifeInventoryCodeWhere
	 */
	public void setKnifeInventoryCodeWhere (String knifeInventoryCodeWhere) {
		this.knifeInventoryCodeWhere = knifeInventoryCodeWhere;
	}

	/* 	*/ 
	private BigDecimal sumProcessAmountWhere;

	/**
	 * 取得
	 * @return sumProcessAmountWhere
	 */
	public BigDecimal getsumProcessAmountWhere () {
		return sumProcessAmountWhere;
	}

	/**
	 * 设定
	 * @param sumProcessAmountWhere
	 */
	public void setsumProcessAmountWhere (BigDecimal sumProcessAmountWhere) {
		this.sumProcessAmountWhere = sumProcessAmountWhere;
	}

	/* 	*/ 
	private BigDecimal avgProcessAmountWhere;

	/**
	 * 取得
	 * @return avgProcessAmountWhere
	 */
	public BigDecimal getavgProcessAmountWhere () {
		return avgProcessAmountWhere;
	}

	/**
	 * 设定
	 * @param avgProcessAmountWhere
	 */
	public void setavgProcessAmountWhere (BigDecimal avgProcessAmountWhere) {
		this.avgProcessAmountWhere = avgProcessAmountWhere;
	}

	/* 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他	*/ 
	private String toolConsumetypeWhere;

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他取得
	 * @return toolConsumetypeWhere
	 */
	public String getToolConsumetypeWhere () {
		return toolConsumetypeWhere;
	}

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他设定
	 * @param toolConsumetypeWhere
	 */
	public void setToolConsumetypeWhere (String toolConsumetypeWhere) {
		this.toolConsumetypeWhere = toolConsumetypeWhere;
	}

	/* 可使用次数	*/ 
	private BigDecimal toolSharpennumWhere;

	/**
	 * 可使用次数取得
	 * @return toolSharpennumWhere
	 */
	public BigDecimal getToolSharpennumWhere () {
		return toolSharpennumWhere;
	}

	/**
	 * 可使用次数设定
	 * @param toolSharpennumWhere
	 */
	public void setToolSharpennumWhere (BigDecimal toolSharpennumWhere) {
		this.toolSharpennumWhere = toolSharpennumWhere;
	}

	/* 可刃磨长度	*/ 
	private BigDecimal toolSharpenLengthWhere;

	/**
	 * 可刃磨长度取得
	 * @return toolSharpenLengthWhere
	 */
	public BigDecimal getToolSharpenLengthWhere () {
		return toolSharpenLengthWhere;
	}

	/**
	 * 可刃磨长度设定
	 * @param toolSharpenLengthWhere
	 */
	public void setToolSharpenLengthWhere (BigDecimal toolSharpenLengthWhere) {
		this.toolSharpenLengthWhere = toolSharpenLengthWhere;
	}

	/* 刀具长度	*/ 
	private BigDecimal toolLengthWhere;

	/**
	 * 刀具长度取得
	 * @return toolLengthWhere
	 */
	public BigDecimal getToolLengthWhere () {
		return toolLengthWhere;
	}

	/**
	 * 刀具长度设定
	 * @param toolLengthWhere
	 */
	public void setToolLengthWhere (BigDecimal toolLengthWhere) {
		this.toolLengthWhere = toolLengthWhere;
	}

	/* 刀具已刃磨长度	*/ 
	private BigDecimal toolGrindingLengthWhere;

	/**
	 * 刀具已刃磨长度取得
	 * @return toolGrindingLengthWhere
	 */
	public BigDecimal getToolGrindingLengthWhere () {
		return toolGrindingLengthWhere;
	}

	/**
	 * 刀具已刃磨长度设定
	 * @param toolGrindingLengthWhere
	 */
	public void setToolGrindingLengthWhere (BigDecimal toolGrindingLengthWhere) {
		this.toolGrindingLengthWhere = toolGrindingLengthWhere;
	}

	/* 已使用(刃磨)次数[当使用次数等于可复用次数时刀具报废]	*/ 
	private BigDecimal usageCounterWhere;

	/**
	 * 已使用(刃磨)次数[当使用次数等于可复用次数时刀具报废]取得
	 * @return usageCounterWhere
	 */
	public BigDecimal getUsageCounterWhere () {
		return usageCounterWhere;
	}

	/**
	 * 已使用(刃磨)次数[当使用次数等于可复用次数时刀具报废]设定
	 * @param usageCounterWhere
	 */
	public void setUsageCounterWhere (BigDecimal usageCounterWhere) {
		this.usageCounterWhere = usageCounterWhere;
	}

	/* 	*/ 
	private String salvageValueWhere;

	/**
	 * 取得
	 * @return salvageValueWhere
	 */
	public String getsalvageValueWhere () {
		return salvageValueWhere;
	}

	/**
	 * 设定
	 * @param salvageValueWhere
	 */
	public void setsalvageValueWhere (String salvageValueWhere) {
		this.salvageValueWhere = salvageValueWhere;
	}
}

