/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2015/07/01 10:59:08
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2015/07/01 10:59:08
 * 创建者  ：杨作庆
 * 
 */
public class Vgrindingquicksearch extends VgrindingquicksearchWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具编码	*/ 
	private String toolCode;

	/**
	 * 刀具编码取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 刀具编码设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 	*/ 
	private BigDecimal noticeOldLength;


	/* 	*/ 
	private BigDecimal noticeLength;


	public BigDecimal getNoticeOldLength() {
		return noticeOldLength;
	}

	public void setNoticeOldLength(BigDecimal noticeOldLength) {
		this.noticeOldLength = noticeOldLength;
	}

	public BigDecimal getNoticeLength() {
		return noticeLength;
	}

	public void setNoticeLength(BigDecimal noticeLength) {
		this.noticeLength = noticeLength;
	}

	public String getIsRepaired() {
		return isRepaired;
	}

	public void setIsRepaired(String isRepaired) {
		this.isRepaired = isRepaired;
	}

	/* 可使用次数	*/ 
	private BigDecimal standardNum;

	/**
	 * 可使用次数取得
	 * @return standardNum
	 */
	public BigDecimal getStandardNum() {
		return standardNum;
	}

	/**
	 * 可使用次数设定
	 * @param standardNum
	 */
	public void setStandardNum(BigDecimal standardNum) {
		this.standardNum = standardNum;
	}

	/* 已使用(刃磨)次数[当使用次数等于可复用次数时刀具报废]	*/ 
	private BigDecimal usageCounter;

	/**
	 * 已使用(刃磨)次数[当使用次数等于可复用次数时刀具报废]取得
	 * @return usageCounter
	 */
	public BigDecimal getUsageCounter() {
		return usageCounter;
	}

	/**
	 * 已使用(刃磨)次数[当使用次数等于可复用次数时刀具报废]设定
	 * @param usageCounter
	 */
	public void setUsageCounter(BigDecimal usageCounter) {
		this.usageCounter = usageCounter;
	}

	/* 可使用(刃磨)次数	*/ 
	private BigDecimal toolSharpennum;

	/**
	 * 可使用(刃磨)次数取得
	 * @return toolSharpennum
	 */
	public BigDecimal getToolSharpennum() {
		return toolSharpennum;
	}

	/**
	 * 可使用(刃磨)次数设定
	 * @param toolSharpennum
	 */
	public void setToolSharpennum(BigDecimal toolSharpennum) {
		this.toolSharpennum = toolSharpennum;
	}

	/* 刀具长度	*/ 
	private BigDecimal toolLength;

	/**
	 * 刀具长度取得
	 * @return toolLength
	 */
	public BigDecimal getToolLength() {
		return toolLength;
	}

	/**
	 * 刀具长度设定
	 * @param toolLength
	 */
	public void setToolLength(BigDecimal toolLength) {
		this.toolLength = toolLength;
	}

	/* 刀具入库编码	*/ 
	private String knifeInventoryCode;

	/**
	 * 刀具入库编码取得
	 * @return knifeInventoryCode
	 */
	public String getKnifeInventoryCode() {
		return knifeInventoryCode;
	}

	/**
	 * 刀具入库编码设定
	 * @param knifeInventoryCode
	 */
	public void setKnifeInventoryCode(String knifeInventoryCode) {
		this.knifeInventoryCode = knifeInventoryCode;
	}

	/* 	*/ 
	private BigDecimal unitPrice;

	/**
	 * 取得
	 * @return unitPrice
	 */
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	/**
	 * 设定
	 * @param unitPrice
	 */
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	/* 修复通知流水号	*/ 
	private String toolRepairNoticeID;

	/**
	 * 修复通知流水号取得
	 * @return toolRepairNoticeID
	 */
	public String getToolRepairNoticeID() {
		return toolRepairNoticeID;
	}

	/**
	 * 修复通知流水号设定
	 * @param toolRepairNoticeID
	 */
	public void setToolRepairNoticeID(String toolRepairNoticeID) {
		this.toolRepairNoticeID = toolRepairNoticeID;
	}

	/* 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)	*/ 
	private String repairWay;

	/**
	 * 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)取得
	 * @return repairWay
	 */
	public String getRepairWay() {
		return repairWay;
	}

	/**
	 * 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)设定
	 * @param repairWay
	 */
	public void setRepairWay(String repairWay) {
		this.repairWay = repairWay;
	}

	/* 	*/ 
	private String isRepaired;

	/**
	 * 取得
	 * @return isRepaired
	 */
	public String getisRepaired() {
		return isRepaired;
	}

	/**
	 * 设定
	 * @param isRepaired
	 */
	public void setisRepaired(String isRepaired) {
		this.isRepaired = isRepaired;
	}
}

