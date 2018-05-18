/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2015/07/01 10:59:08
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2015/07/01 10:59:08
 * 创建者  ：杨作庆
 * 
 */
public class VgrindingquicksearchWhere extends BaseEntity implements Serializable {
	/**
	 * 序列化接口属性
	 */
	private static final long serialVersionUID = 3360874101844761814L;


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

	/* 	*/ 
	private BigDecimal noticeOldLengthWhere;


	/* 	*/ 
	private BigDecimal noticeLengthWhere;

	public BigDecimal getNoticeOldLengthWhere() {
		return noticeOldLengthWhere;
	}

	public void setNoticeOldLengthWhere(BigDecimal noticeOldLengthWhere) {
		this.noticeOldLengthWhere = noticeOldLengthWhere;
	}

	public BigDecimal getNoticeLengthWhere() {
		return noticeLengthWhere;
	}

	public void setNoticeLengthWhere(BigDecimal noticeLengthWhere) {
		this.noticeLengthWhere = noticeLengthWhere;
	}

	public String getIsRepairedWhere() {
		return isRepairedWhere;
	}

	public void setIsRepairedWhere(String isRepairedWhere) {
		this.isRepairedWhere = isRepairedWhere;
	}

	/* 可使用次数	*/ 
	private BigDecimal standardNumWhere;

	/**
	 * 可使用次数取得
	 * @return standardNumWhere
	 */
	public BigDecimal getStandardNumWhere () {
		return standardNumWhere;
	}

	/**
	 * 可使用次数设定
	 * @param standardNumWhere
	 */
	public void setStandardNumWhere (BigDecimal standardNumWhere) {
		this.standardNumWhere = standardNumWhere;
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
	private BigDecimal unitPriceWhere;

	/**
	 * 取得
	 * @return unitPriceWhere
	 */
	public BigDecimal getUnitPriceWhere () {
		return unitPriceWhere;
	}

	/**
	 * 设定
	 * @param unitPriceWhere
	 */
	public void setUnitPriceWhere (BigDecimal unitPriceWhere) {
		this.unitPriceWhere = unitPriceWhere;
	}

	/* 修复通知流水号	*/ 
	private String toolRepairNoticeIDWhere;

	/**
	 * 修复通知流水号取得
	 * @return toolRepairNoticeIDWhere
	 */
	public String getToolRepairNoticeIDWhere () {
		return toolRepairNoticeIDWhere;
	}

	/**
	 * 修复通知流水号设定
	 * @param toolRepairNoticeIDWhere
	 */
	public void setToolRepairNoticeIDWhere (String toolRepairNoticeIDWhere) {
		this.toolRepairNoticeIDWhere = toolRepairNoticeIDWhere;
	}

	/* 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)	*/ 
	private String repairWayWhere;

	/**
	 * 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)取得
	 * @return repairWayWhere
	 */
	public String getRepairWayWhere () {
		return repairWayWhere;
	}

	/**
	 * 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)设定
	 * @param repairWayWhere
	 */
	public void setRepairWayWhere (String repairWayWhere) {
		this.repairWayWhere = repairWayWhere;
	}

	/* 	*/ 
	private String isRepairedWhere;

	/**
	 * 取得
	 * @return isRepairedWhere
	 */
	public String getisRepairedWhere () {
		return isRepairedWhere;
	}

	/**
	 * 设定
	 * @param isRepairedWhere
	 */
	public void setisRepairedWhere (String isRepairedWhere) {
		this.isRepairedWhere = isRepairedWhere;
	}
}

