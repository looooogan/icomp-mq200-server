/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class VgetbacktoollibraryWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* RFID标签ID	*/ 
	private String rfidCodeWhere;

	/**
	 * RFID标签ID取得
	 * @return rfidCodeWhere
	 */
	public String getRfidCodeWhere () {
		return rfidCodeWhere;
	}

	/**
	 * RFID标签ID设定
	 * @param rfidCodeWhere
	 */
	public void setRfidCodeWhere (String rfidCodeWhere) {
		this.rfidCodeWhere = rfidCodeWhere;
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

	/* 刀具ID	*/ 
	private String toolIDWhere;

	/**
	 * 刀具ID取得
	 * @return toolIDWhere
	 */
	public String getToolIDWhere () {
		return toolIDWhere;
	}

	/**
	 * 刀具ID设定
	 * @param toolIDWhere
	 */
	public void setToolIDWhere (String toolIDWhere) {
		this.toolIDWhere = toolIDWhere;
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
	private String toolConsumetypeWhere;
	public String getToolConsumetypeWhere() {
		return toolConsumetypeWhere;
	}

	public void setToolConsumetypeWhere(String toolConsumetypeWhere) {
		this.toolConsumetypeWhere = toolConsumetypeWhere;
	}

	/* 	*/ 
	private BigDecimal toolCountWhere;

	/**
	 * 取得
	 * @return toolCountWhere
	 */
	public BigDecimal getToolCountWhere () {
		return toolCountWhere;
	}

	/**
	 * 设定
	 * @param toolCountWhere
	 */
	public void setToolCountWhere (BigDecimal toolCountWhere) {
		this.toolCountWhere = toolCountWhere;
	}

	/* 最后执行业务流程	*/ 
	private String businessFlowLnkIDWhere;

	/**
	 * 最后执行业务流程取得
	 * @return businessFlowLnkIDWhere
	 */
	public String getBusinessFlowLnkIDWhere () {
		return businessFlowLnkIDWhere;
	}

	/**
	 * 最后执行业务流程设定
	 * @param businessFlowLnkIDWhere
	 */
	public void setBusinessFlowLnkIDWhere (String businessFlowLnkIDWhere) {
		this.businessFlowLnkIDWhere = businessFlowLnkIDWhere;
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

	/* 刀具安装合成刀状态(0未安装1已安装2卸下9其他)	*/ 
	private String installationStateWhere;

	/**
	 * 刀具安装合成刀状态(0未安装1已安装2卸下9其他)取得
	 * @return installationStateWhere
	 */
	public String getInstallationStateWhere () {
		return installationStateWhere;
	}

	/**
	 * 刀具安装合成刀状态(0未安装1已安装2卸下9其他)设定
	 * @param installationStateWhere
	 */
	public void setInstallationStateWhere (String installationStateWhere) {
		this.installationStateWhere = installationStateWhere;
	}

	/* 确认人(断刀、丢失、不合格的状态选择时需要上级确认)	*/ 
	private String confirmedUserWhere;

	/**
	 * 确认人(断刀、丢失、不合格的状态选择时需要上级确认)取得
	 * @return confirmedUserWhere
	 */
	public String getConfirmedUserWhere () {
		return confirmedUserWhere;
	}

	/**
	 * 确认人(断刀、丢失、不合格的状态选择时需要上级确认)设定
	 * @param confirmedUserWhere
	 */
	public void setConfirmedUserWhere (String confirmedUserWhere) {
		this.confirmedUserWhere = confirmedUserWhere;
	}

	/* 	*/ 
	private BigDecimal lostKnifeCountWhere;

	/**
	 * 取得
	 * @return lostKnifeCountWhere
	 */
	public BigDecimal getlostKnifeCountWhere () {
		return lostKnifeCountWhere;
	}

	/**
	 * 设定
	 * @param lostKnifeCountWhere
	 */
	public void setlostKnifeCountWhere (BigDecimal lostKnifeCountWhere) {
		this.lostKnifeCountWhere = lostKnifeCountWhere;
	}

	/* 刀具状态(0断刀1丢失2不合格3借入4申领9其他)	*/ 
	private String toolStateWhere;

	/**
	 * 刀具状态(0断刀1丢失2不合格3借入4申领9其他)取得
	 * @return toolStateWhere
	 */
	public String getToolStateWhere () {
		return toolStateWhere;
	}

	/**
	 * 刀具状态(0断刀1丢失2不合格3借入4申领9其他)设定
	 * @param toolStateWhere
	 */
	public void setToolStateWhere (String toolStateWhere) {
		this.toolStateWhere = toolStateWhere;
	}

	/* 申领区分(0扩能1外借2工艺试验)	*/ 
	private String replacementFlagWhere;

	/**
	 * 申领区分(0扩能1外借2工艺试验)取得
	 * @return replacementFlagWhere
	 */
	public String getReplacementFlagWhere () {
		return replacementFlagWhere;
	}

	/**
	 * 申领区分(0扩能1外借2工艺试验)设定
	 * @param replacementFlagWhere
	 */
	public void setReplacementFlagWhere (String replacementFlagWhere) {
		this.replacementFlagWhere = replacementFlagWhere;
	}

	/* 库存状态(0正常1报废2返厂3封存9其他)	*/ 
	private String stockStateWhere;

	/**
	 * 库存状态(0正常1报废2返厂3封存9其他)取得
	 * @return stockStateWhere
	 */
	public String getStockStateWhere () {
		return stockStateWhere;
	}

	/**
	 * 库存状态(0正常1报废2返厂3封存9其他)设定
	 * @param stockStateWhere
	 */
	public void setStockStateWhere (String stockStateWhere) {
		this.stockStateWhere = stockStateWhere;
	}
}

