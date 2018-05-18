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
public class VgrindingtoolmsgWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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
	
	/* 刀具消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他)  */
	private String toolConsumetypeWhere;
	
	/**
	 * 刀具消耗类别取得
	 * @return
	 */

	public String getToolConsumetypeWhere() {
		return toolConsumetypeWhere;
	}

	/**
	 * 刀具消耗类别设定
	 * @param toolConsumetype
	 */
	public void setToolConsumetypeWhere(String toolConsumetypeWhere) {
		this.toolConsumetypeWhere = toolConsumetypeWhere;
	}
	
	/* 刀具复磨标准  */
	private String toolSharpenCriterionWhere;
	
	/**
	 * 复磨标准取得
	 * @return
	 */

	public String getToolSharpenCriterionWhere() {
		return toolSharpenCriterionWhere;
	}
	
	/**
	 * 复磨标准设定
	 * @param toolSharpenCriterionWhere
	 */

	public void setToolSharpenCriterionWhere(String toolSharpenCriterionWhere) {
		this.toolSharpenCriterionWhere = toolSharpenCriterionWhere;
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
	
	/* 刀具可刃磨长度  */
	private String toolSharpenLengthWhere;
	
	/**
	 * 可刃磨长度取得
	 * @return
	 */

	public String getToolSharpenLengthWhere() {
		return toolSharpenLengthWhere;
	}

	/**
	 * 可刃磨长度设定
	 * @param toolSharpenLengthWhere
	 */
	public void setToolSharpenLengthWhere(String toolSharpenLengthWhere) {
		this.toolSharpenLengthWhere = toolSharpenLengthWhere;
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

	/* 版本号	*/ 
	private BigDecimal tooltransferVersionWhere;

	/**
	 * 版本号取得
	 * @return tooltransferVersionWhere
	 */
	public BigDecimal gettooltransferVersionWhere () {
		return tooltransferVersionWhere;
	}

	/**
	 * 版本号设定
	 * @param tooltransferVersionWhere
	 */
	public void settooltransferVersionWhere (BigDecimal tooltransferVersionWhere) {
		this.tooltransferVersionWhere = tooltransferVersionWhere;
	}
}

