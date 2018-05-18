/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class Vgrindingtoolmsg extends VgrindingtoolmsgWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 刀具ID	*/ 
	private String toolID;

	/**
	 * 刀具ID取得
	 * @return toolID
	 */
	public String getToolID() {
		return toolID;
	}

	/**
	 * 刀具ID设定
	 * @param toolID
	 */
	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

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

	/* 刀具名称	*/ 
	private String toolName;

	/**
	 * 刀具名称取得
	 * @return toolName
	 */
	public String getToolName() {
		return toolName;
	}

	/**
	 * 刀具名称设定
	 * @param toolName
	 */
	public void setToolName(String toolName) {
		this.toolName = toolName;
	}
	
	/* 刀具消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他)  */
	private String toolConsumetype;
	
	/**
	 * 刀具消耗类别取得
	 * @return
	 */

	public String getToolConsumetype() {
		return toolConsumetype;
	}

	/**
	 * 刀具消耗类别设定
	 * @param toolConsumetype
	 */
	public void setToolConsumetype(String toolConsumetype) {
		this.toolConsumetype = toolConsumetype;
	}
	
	/* 刀具复磨标准  */
	private String toolSharpenCriterion;
	
	/**
	 * 复磨标准取得
	 * @return
	 */

	public String getToolSharpenCriterion() {
		return toolSharpenCriterion;
	}

	/**
	 * 复磨标准设定
	 * @param toolSharpenCriterion
	 */
	public void setToolSharpenCriterion(String toolSharpenCriterion) {
		this.toolSharpenCriterion = toolSharpenCriterion;
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

	/* 修复前测量长度	*/ 
	private BigDecimal noticeLength;

	/**
	 * 修复前测量长度取得
	 * @return noticeLength
	 */
	public BigDecimal getNoticeLength() {
		return noticeLength;
	}

	/**
	 * 修复前测量长度设定
	 * @param noticeLength
	 */
	public void setNoticeLength(BigDecimal noticeLength) {
		this.noticeLength = noticeLength;
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
	
	/* 刀具可刃磨长度  */
	private String toolSharpenLength;
	
	/**
	 * 可刃磨长度的取得
	 * @return
	 */

	public String getToolSharpenLength() {
		return toolSharpenLength;
	}
	
	/**
	 * 可刃磨长度设定
	 * @param toolSharpenLength
	 */

	public void setToolSharpenLength(String toolSharpenLength) {
		this.toolSharpenLength = toolSharpenLength;
	}

	/* 最后执行业务流程	*/ 
	private String businessFlowLnkID;

	/**
	 * 最后执行业务流程取得
	 * @return businessFlowLnkID
	 */
	public String getBusinessFlowLnkID() {
		return businessFlowLnkID;
	}

	/**
	 * 最后执行业务流程设定
	 * @param businessFlowLnkID
	 */
	public void setBusinessFlowLnkID(String businessFlowLnkID) {
		this.businessFlowLnkID = businessFlowLnkID;
	}

	/* RFID载体ID	*/ 
	private String rfidContainerID;

	/**
	 * RFID载体ID取得
	 * @return rfidContainerID
	 */
	public String getRfidContainerID() {
		return rfidContainerID;
	}

	/**
	 * RFID载体ID设定
	 * @param rfidContainerID
	 */
	public void setRfidContainerID(String rfidContainerID) {
		this.rfidContainerID = rfidContainerID;
	}

	/* 版本号	*/ 
	private BigDecimal tooltransferVersion;

	/**
	 * 版本号取得
	 * @return tooltransferVersion
	 */
	public BigDecimal gettooltransferVersion() {
		return tooltransferVersion;
	}

	/**
	 * 版本号设定
	 * @param tooltransferVersion
	 */
	public void settooltransferVersion(BigDecimal tooltransferVersion) {
		this.tooltransferVersion = tooltransferVersion;
	}
}

