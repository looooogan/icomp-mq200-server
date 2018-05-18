/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/24 15:52:33
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/24 15:52:33
 * 创建者  ：杨作庆
 * 
 */
public class VgrindingrecordWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 	*/ 
	private String toolStateWhere;

	/**
	 * 取得
	 * @return toolStateWhere
	 */
	public String getToolStateWhere () {
		return toolStateWhere;
	}

	/**
	 * 设定
	 * @param toolStateWhere
	 */
	public void setToolStateWhere (String toolStateWhere) {
		this.toolStateWhere = toolStateWhere;
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

	/* 可使用(刃磨)次数	*/ 
	private BigDecimal toolSharpennumWhere;

	/**
	 * 可使用(刃磨)次数取得
	 * @return toolSharpennumWhere
	 */
	public BigDecimal getToolSharpennumWhere () {
		return toolSharpennumWhere;
	}

	/**
	 * 可使用(刃磨)次数设定
	 * @param toolSharpennumWhere
	 */
	public void setToolSharpennumWhere (BigDecimal toolSharpennumWhere) {
		this.toolSharpennumWhere = toolSharpennumWhere;
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

	/* 复磨标准	*/ 
	private BigDecimal toolSharpenCriterionWhere;

	/**
	 * 复磨标准取得
	 * @return toolSharpenCriterionWhere
	 */
	public BigDecimal getToolSharpenCriterionWhere () {
		return toolSharpenCriterionWhere;
	}

	/**
	 * 复磨标准设定
	 * @param toolSharpenCriterionWhere
	 */
	public void setToolSharpenCriterionWhere (BigDecimal toolSharpenCriterionWhere) {
		this.toolSharpenCriterionWhere = toolSharpenCriterionWhere;
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

	/* 	*/ 
	private BigDecimal processAmountWhere;

	/**
	 * 取得
	 * @return processAmountWhere
	 */
	public BigDecimal getProcessAmountWhere () {
		return processAmountWhere;
	}

	/**
	 * 设定
	 * @param processAmountWhere
	 */
	public void setProcessAmountWhere (BigDecimal processAmountWhere) {
		this.processAmountWhere = processAmountWhere;
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

	/* 姓名	*/ 
	private String userNameWhere;

	/**
	 * 姓名取得
	 * @return userNameWhere
	 */
	public String getUserNameWhere () {
		return userNameWhere;
	}

	/**
	 * 姓名设定
	 * @param userNameWhere
	 */
	public void setUserNameWhere (String userNameWhere) {
		this.userNameWhere = userNameWhere;
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

	/* 修复前测量长度	*/ 
	private BigDecimal noticeLengthWhere;

	/**
	 * 修复前测量长度取得
	 * @return noticeLengthWhere
	 */
	public BigDecimal getNoticeLengthWhere () {
		return noticeLengthWhere;
	}

	/**
	 * 修复前测量长度设定
	 * @param noticeLengthWhere
	 */
	public void setNoticeLengthWhere (BigDecimal noticeLengthWhere) {
		this.noticeLengthWhere = noticeLengthWhere;
	}

	/* 修复后测量长度	*/ 
	private BigDecimal noticeOldLengthWhere;

	/**
	 * 修复后测量长度取得
	 * @return noticeOldLengthWhere
	 */
	public BigDecimal getNoticeOldLengthWhere () {
		return noticeOldLengthWhere;
	}

	/**
	 * 修复后测量长度设定
	 * @param noticeOldLengthWhere
	 */
	public void setNoticeOldLengthWhere (BigDecimal noticeOldLengthWhere) {
		this.noticeOldLengthWhere = noticeOldLengthWhere;
	}

	/* 通知时间	*/ 
	private Date noticeTimeWhere;

	/**
	 * 通知时间取得
	 * @return noticeTimeWhere
	 */
	public Date getNoticeTimeWhere () {
		return noticeTimeWhere;
	}

	/**
	 * 通知时间设定
	 * @param noticeTimeWhere
	 */
	public void setNoticeTimeWhere (Date noticeTimeWhere) {
		this.noticeTimeWhere = noticeTimeWhere;
	}

	/* 采购批次	*/ 
	private String procuredBatchWhere;

	/**
	 * 采购批次取得
	 * @return procuredBatchWhere
	 */
	public String getProcuredBatchWhere () {
		return procuredBatchWhere;
	}

	/**
	 * 采购批次设定
	 * @param procuredBatchWhere
	 */
	public void setProcuredBatchWhere (String procuredBatchWhere) {
		this.procuredBatchWhere = procuredBatchWhere;
	}

	/* 采购单价	*/ 
	private BigDecimal unitPriceWhere;

	/**
	 * 采购单价取得
	 * @return unitPriceWhere
	 */
	public BigDecimal getUnitPriceWhere () {
		return unitPriceWhere;
	}

	/**
	 * 采购单价设定
	 * @param unitPriceWhere
	 */
	public void setUnitPriceWhere (BigDecimal unitPriceWhere) {
		this.unitPriceWhere = unitPriceWhere;
	}
}

