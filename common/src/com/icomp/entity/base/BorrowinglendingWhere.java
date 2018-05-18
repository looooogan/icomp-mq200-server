/*
 * 工具自动生成：刀具借入-借出条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 刀具借入-借出条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class BorrowinglendingWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具借入借出ID	*/ 
	private String borrowingLendingIDWhere;

	/**
	 * 刀具借入借出ID取得
	 * @return borrowingLendingIDWhere
	 */
	public String getBorrowingLendingIDWhere () {
		return borrowingLendingIDWhere;
	}

	/**
	 * 刀具借入借出ID设定
	 * @param borrowingLendingIDWhere
	 */
	public void setBorrowingLendingIDWhere (String borrowingLendingIDWhere) {
		this.borrowingLendingIDWhere = borrowingLendingIDWhere;
	}

	/* RFID载体ID	*/ 
	private String rfidContainerIDWhere;

	/**
	 * RFID载体ID取得
	 * @return rfidContainerIDWhere
	 */
	public String getRfidContainerIDWhere () {
		return rfidContainerIDWhere;
	}

	/**
	 * RFID载体ID设定
	 * @param rfidContainerIDWhere
	 */
	public void setRfidContainerIDWhere (String rfidContainerIDWhere) {
		this.rfidContainerIDWhere = rfidContainerIDWhere;
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

	/* 复磨次数	*/ 
	private BigDecimal toolSharpennumWhere;

	/**
	 * 复磨次数取得
	 * @return toolSharpennumWhere
	 */
	public BigDecimal getToolSharpennumWhere () {
		return toolSharpennumWhere;
	}

	/**
	 * 复磨次数设定
	 * @param toolSharpennumWhere
	 */
	public void setToolSharpennumWhere (BigDecimal toolSharpennumWhere) {
		this.toolSharpennumWhere = toolSharpennumWhere;
	}

	/* 耐用度	*/ 
	private BigDecimal toolDurableWhere;

	/**
	 * 耐用度取得
	 * @return toolDurableWhere
	 */
	public BigDecimal getToolDurableWhere () {
		return toolDurableWhere;
	}

	/**
	 * 耐用度设定
	 * @param toolDurableWhere
	 */
	public void setToolDurableWhere (BigDecimal toolDurableWhere) {
		this.toolDurableWhere = toolDurableWhere;
	}

	/* 借入/借出人	*/ 
	private String borrowingLendingUserWhere;

	/**
	 * 借入/借出人取得
	 * @return borrowingLendingUserWhere
	 */
	public String getBorrowingLendingUserWhere () {
		return borrowingLendingUserWhere;
	}

	/**
	 * 借入/借出人设定
	 * @param borrowingLendingUserWhere
	 */
	public void setBorrowingLendingUserWhere (String borrowingLendingUserWhere) {
		this.borrowingLendingUserWhere = borrowingLendingUserWhere;
	}

	/* 借入/借出时间	*/ 
	private Date borrowingLendingTimeWhere;

	/**
	 * 借入/借出时间取得
	 * @return borrowingLendingTimeWhere
	 */
	public Date getBorrowingLendingTimeWhere () {
		return borrowingLendingTimeWhere;
	}

	/**
	 * 借入/借出时间设定
	 * @param borrowingLendingTimeWhere
	 */
	public void setBorrowingLendingTimeWhere (Date borrowingLendingTimeWhere) {
		this.borrowingLendingTimeWhere = borrowingLendingTimeWhere;
	}

	/* 归还人	*/ 
	private String returnUserWhere;

	/**
	 * 归还人取得
	 * @return returnUserWhere
	 */
	public String getReturnUserWhere () {
		return returnUserWhere;
	}

	/**
	 * 归还人设定
	 * @param returnUserWhere
	 */
	public void setReturnUserWhere (String returnUserWhere) {
		this.returnUserWhere = returnUserWhere;
	}

	/* 归还时间	*/ 
	private Date returnTimeWhere;

	/**
	 * 归还时间取得
	 * @return returnTimeWhere
	 */
	public Date getReturnTimeWhere () {
		return returnTimeWhere;
	}

	/**
	 * 归还时间设定
	 * @param returnTimeWhere
	 */
	public void setReturnTimeWhere (Date returnTimeWhere) {
		this.returnTimeWhere = returnTimeWhere;
	}

	/* 借入/借出理由	*/ 
	private String borrowingLendingReasonWhere;

	/**
	 * 借入/借出理由取得
	 * @return borrowingLendingReasonWhere
	 */
	public String getBorrowingLendingReasonWhere () {
		return borrowingLendingReasonWhere;
	}

	/**
	 * 借入/借出理由设定
	 * @param borrowingLendingReasonWhere
	 */
	public void setBorrowingLendingReasonWhere (String borrowingLendingReasonWhere) {
		this.borrowingLendingReasonWhere = borrowingLendingReasonWhere;
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

	/* 库存状态(0正常1报废9其他)(这里刀具状态没有2、3)	*/ 
	private String stockStateWhere;

	/**
	 * 库存状态(0正常1报废9其他)(这里刀具状态没有2、3)取得
	 * @return stockStateWhere
	 */
	public String getStockStateWhere () {
		return stockStateWhere;
	}

	/**
	 * 库存状态(0正常1报废9其他)(这里刀具状态没有2、3)设定
	 * @param stockStateWhere
	 */
	public void setStockStateWhere (String stockStateWhere) {
		this.stockStateWhere = stockStateWhere;
	}

	/* 刀具状态(0断刀1丢失2不合格9其他)(这里刀具状态没有3)	*/ 
	private String toolStateWhere;

	/**
	 * 刀具状态(0断刀1丢失2不合格9其他)(这里刀具状态没有3)取得
	 * @return toolStateWhere
	 */
	public String getToolStateWhere () {
		return toolStateWhere;
	}

	/**
	 * 刀具状态(0断刀1丢失2不合格9其他)(这里刀具状态没有3)设定
	 * @param toolStateWhere
	 */
	public void setToolStateWhere (String toolStateWhere) {
		this.toolStateWhere = toolStateWhere;
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
}

