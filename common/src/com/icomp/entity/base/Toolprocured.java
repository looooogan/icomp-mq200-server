/*
 * 工具自动生成：实体类
 * 生成时间    : 2016/06/14 11:40:15
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 实体类
 * @author 工具自动生成
 * 创建时间：2016/06/14 11:40:15
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Toolprocured extends ToolprocuredWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 采购ID	*/ 
	private String toolProcuredID;

	/**
	 * 采购ID取得
	 * @return toolProcuredID
	 */
	public String getToolProcuredID() {
		return toolProcuredID;
	}

	/**
	 * 采购ID设定
	 * @param toolProcuredID
	 */
	public void setToolProcuredID(String toolProcuredID) {
		this.toolProcuredID = toolProcuredID;
	}

	/* 订单号	*/ 
	private String toolsOrdeNO;

	/**
	 * 订单号取得
	 * @return toolsOrdeNO
	 */
	public String getToolsOrdeNO() {
		return toolsOrdeNO;
	}

	/**
	 * 订单号设定
	 * @param toolsOrdeNO
	 */
	public void setToolsOrdeNO(String toolsOrdeNO) {
		this.toolsOrdeNO = toolsOrdeNO;
	}

	/* 材料号	*/ 
	private String toolCode;

	/**
	 * 材料号取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 材料号设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 采购批次	*/ 
	private String procuredBatch;

	/**
	 * 采购批次取得
	 * @return procuredBatch
	 */
	public String getProcuredBatch() {
		return procuredBatch;
	}

	/**
	 * 采购批次设定
	 * @param procuredBatch
	 */
	public void setProcuredBatch(String procuredBatch) {
		this.procuredBatch = procuredBatch;
	}

	/* 采购日期	*/ 
	private String procuredTime;

	/**
	 * 采购日期取得
	 * @return procuredTime
	 */
	public String getProcuredTime() {
		return procuredTime;
	}

	/**
	 * 采购日期设定
	 * @param procuredTime
	 */
	public void setProcuredTime(String procuredTime) {
		this.procuredTime = procuredTime;
	}

	/* 采购单价	*/ 
	private String unitPrice;

	/**
	 * 采购单价取得
	 * @return unitPrice
	 */
	public String getUnitPrice() {
		return unitPrice;
	}

	/**
	 * 采购单价设定
	 * @param unitPrice
	 */
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	/* 采购者(关联用户ID)	*/ 
	private String procuredUser;

	/**
	 * 采购者(关联用户ID)取得
	 * @return procuredUser
	 */
	public String getProcuredUser() {
		return procuredUser;
	}

	/**
	 * 采购者(关联用户ID)设定
	 * @param procuredUser
	 */
	public void setProcuredUser(String procuredUser) {
		this.procuredUser = procuredUser;
	}

	/* 采购数量	*/ 
	private BigDecimal procuredCount;

	/**
	 * 采购数量取得
	 * @return procuredCount
	 */
	public BigDecimal getProcuredCount() {
		return procuredCount;
	}

	/**
	 * 采购数量设定
	 * @param procuredCount
	 */
	public void setProcuredCount(BigDecimal procuredCount) {
		this.procuredCount = procuredCount;
	}

	/* 是否入库(0是1否)	*/ 
	private String procuredInto;

	/**
	 * 是否入库(0是1否)取得
	 * @return procuredInto
	 */
	public String getProcuredInto() {
		return procuredInto;
	}

	/**
	 * 是否入库(0是1否)设定
	 * @param procuredInto
	 */
	public void setProcuredInto(String procuredInto) {
		this.procuredInto = procuredInto;
	}

	/* 是否付费(0是1否9其他)	*/ 
	private String procuredPaying;

	/**
	 * 是否付费(0是1否9其他)取得
	 * @return procuredPaying
	 */
	public String getProcuredPaying() {
		return procuredPaying;
	}

	/**
	 * 是否付费(0是1否9其他)设定
	 * @param procuredPaying
	 */
	public void setProcuredPaying(String procuredPaying) {
		this.procuredPaying = procuredPaying;
	}

	/* 采购类型(0新采购1外委图层2外委复磨9其他)	*/ 
	private String procuredType;

	/**
	 * 采购类型(0新采购1外委图层2外委复磨9其他)取得
	 * @return procuredType
	 */
	public String getProcuredType() {
		return procuredType;
	}

	/**
	 * 采购类型(0新采购1外委图层2外委复磨9其他)设定
	 * @param procuredType
	 */
	public void setProcuredType(String procuredType) {
		this.procuredType = procuredType;
	}

	/* 采购数量	*/ 
	private BigDecimal procuredNumber;

	/**
	 * 采购数量取得
	 * @return procuredNumber
	 */
	public BigDecimal getProcuredNumber() {
		return procuredNumber;
	}

	/**
	 * 采购数量设定
	 * @param procuredNumber
	 */
	public void setProcuredNumber(BigDecimal procuredNumber) {
		this.procuredNumber = procuredNumber;
	}
}

