/*
 * 工具自动生成：刀具流转履历条件实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * 刀具流转履历条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class TooltransferhistoryWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 	*/ 
	private String toolTransferHistoryIDWhere;

	/**
	 * 取得
	 * @return toolTransferHistoryIDWhere
	 */
	public String getToolTransferHistoryIDWhere () {
		return toolTransferHistoryIDWhere;
	}

	/**
	 * 设定
	 * @param toolTransferHistoryIDWhere
	 */
	public void setToolTransferHistoryIDWhere (String toolTransferHistoryIDWhere) {
		this.toolTransferHistoryIDWhere = toolTransferHistoryIDWhere;
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

	/* 采购ID	*/ 
	private String toolProcuredIDWhere;

	/**
	 * 采购ID取得
	 * @return toolProcuredIDWhere
	 */
	public String getToolProcuredIDWhere () {
		return toolProcuredIDWhere;
	}

	/**
	 * 采购ID设定
	 * @param toolProcuredIDWhere
	 */
	public void setToolProcuredIDWhere (String toolProcuredIDWhere) {
		this.toolProcuredIDWhere = toolProcuredIDWhere;
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

	/* 转出人	*/ 
	private String outUserWhere;

	/**
	 * 转出人取得
	 * @return outUserWhere
	 */
	public String getoutUserWhere () {
		return outUserWhere;
	}

	/**
	 * 转出人设定
	 * @param outUserWhere
	 */
	public void setoutUserWhere (String outUserWhere) {
		this.outUserWhere = outUserWhere;
	}

	/* 接收人	*/ 
	private String inUserWhere;

	/**
	 * 接收人取得
	 * @return inUserWhere
	 */
	public String getinUserWhere () {
		return inUserWhere;
	}

	/**
	 * 接收人设定
	 * @param inUserWhere
	 */
	public void setinUserWhere (String inUserWhere) {
		this.inUserWhere = inUserWhere;
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

