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
public class Vgetbacktoollibrary extends VgetbacktoollibraryWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* RFID标签ID	*/ 
	private String rfidCode;

	/**
	 * RFID标签ID取得
	 * @return rfidCode
	 */
	public String getRfidCode() {
		return rfidCode;
	}

	/**
	 * RFID标签ID设定
	 * @param rfidCode
	 */
	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
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

	private String toolConsumetype;
	
	public String getToolConsumetype() {
		return toolConsumetype;
	}

	public void setToolConsumetype(String toolConsumetype) {
		this.toolConsumetype = toolConsumetype;
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

	/* 	*/ 
	private BigDecimal toolCount;

	/**
	 * 取得
	 * @return toolCount
	 */
	public BigDecimal getToolCount() {
		return toolCount;
	}

	/**
	 * 设定
	 * @param toolCount
	 */
	public void setToolCount(BigDecimal toolCount) {
		this.toolCount = toolCount;
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

	/* 可刃磨长度	*/ 
	private BigDecimal toolSharpenLength;

	/**
	 * 可刃磨长度取得
	 * @return toolSharpenLength
	 */
	public BigDecimal getToolSharpenLength() {
		return toolSharpenLength;
	}

	/**
	 * 可刃磨长度设定
	 * @param toolSharpenLength
	 */
	public void setToolSharpenLength(BigDecimal toolSharpenLength) {
		this.toolSharpenLength = toolSharpenLength;
	}

	/* 复磨标准	*/ 
	private BigDecimal toolSharpenCriterion;

	/**
	 * 复磨标准取得
	 * @return toolSharpenCriterion
	 */
	public BigDecimal getToolSharpenCriterion() {
		return toolSharpenCriterion;
	}

	/**
	 * 复磨标准设定
	 * @param toolSharpenCriterion
	 */
	public void setToolSharpenCriterion(BigDecimal toolSharpenCriterion) {
		this.toolSharpenCriterion = toolSharpenCriterion;
	}

	/* 刀具安装合成刀状态(0未安装1已安装2卸下9其他)	*/ 
	private String installationState;

	/**
	 * 刀具安装合成刀状态(0未安装1已安装2卸下9其他)取得
	 * @return installationState
	 */
	public String getInstallationState() {
		return installationState;
	}

	/**
	 * 刀具安装合成刀状态(0未安装1已安装2卸下9其他)设定
	 * @param installationState
	 */
	public void setInstallationState(String installationState) {
		this.installationState = installationState;
	}

	/* 确认人(断刀、丢失、不合格的状态选择时需要上级确认)	*/ 
	private String confirmedUser;

	/**
	 * 确认人(断刀、丢失、不合格的状态选择时需要上级确认)取得
	 * @return confirmedUser
	 */
	public String getConfirmedUser() {
		return confirmedUser;
	}

	/**
	 * 确认人(断刀、丢失、不合格的状态选择时需要上级确认)设定
	 * @param confirmedUser
	 */
	public void setConfirmedUser(String confirmedUser) {
		this.confirmedUser = confirmedUser;
	}

	/* 	*/ 
	private BigDecimal lostKnifeCount;

	/**
	 * 取得
	 * @return lostKnifeCount
	 */
	public BigDecimal getlostKnifeCount() {
		return lostKnifeCount;
	}

	/**
	 * 设定
	 * @param lostKnifeCount
	 */
	public void setlostKnifeCount(BigDecimal lostKnifeCount) {
		this.lostKnifeCount = lostKnifeCount;
	}

	/* 刀具状态(0断刀1丢失2不合格3借入4申领9其他)	*/ 
	private String toolState;

	/**
	 * 刀具状态(0断刀1丢失2不合格3借入4申领9其他)取得
	 * @return toolState
	 */
	public String getToolState() {
		return toolState;
	}

	/**
	 * 刀具状态(0断刀1丢失2不合格3借入4申领9其他)设定
	 * @param toolState
	 */
	public void setToolState(String toolState) {
		this.toolState = toolState;
	}

	/* 申领区分(0扩能1外借2工艺试验)	*/ 
	private String replacementFlag;

	/**
	 * 申领区分(0扩能1外借2工艺试验)取得
	 * @return replacementFlag
	 */
	public String getReplacementFlag() {
		return replacementFlag;
	}

	/**
	 * 申领区分(0扩能1外借2工艺试验)设定
	 * @param replacementFlag
	 */
	public void setReplacementFlag(String replacementFlag) {
		this.replacementFlag = replacementFlag;
	}

	/* 库存状态(0正常1报废2返厂3封存9其他)	*/ 
	private String stockState;

	/**
	 * 库存状态(0正常1报废2返厂3封存9其他)取得
	 * @return stockState
	 */
	public String getStockState() {
		return stockState;
	}

	/**
	 * 库存状态(0正常1报废2返厂3封存9其他)设定
	 * @param stockState
	 */
	public void setStockState(String stockState) {
		this.stockState = stockState;
	}
}

