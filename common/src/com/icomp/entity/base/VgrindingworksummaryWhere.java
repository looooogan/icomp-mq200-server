/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class VgrindingworksummaryWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 修复时间	*/ 
	private Date noticeTimeWhere;

	/**
	 * 修复时间取得
	 * @return noticeTimeWhere
	 */
	public Date getNoticeTimeWhere () {
		return noticeTimeWhere;
	}

	/**
	 * 修复时间设定
	 * @param noticeTimeWhere
	 */
	public void setNoticeTimeWhere (Date noticeTimeWhere) {
		this.noticeTimeWhere = noticeTimeWhere;
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

	/* 	*/ 
	private BigDecimal toolProcessingVolumeWhere;

	/**
	 * 取得
	 * @return toolProcessingVolumeWhere
	 */
	public BigDecimal getToolProcessingVolumeWhere () {
		return toolProcessingVolumeWhere;
	}

	/**
	 * 设定
	 * @param toolProcessingVolumeWhere
	 */
	public void setToolProcessingVolumeWhere (BigDecimal toolProcessingVolumeWhere) {
		this.toolProcessingVolumeWhere = toolProcessingVolumeWhere;
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
}

