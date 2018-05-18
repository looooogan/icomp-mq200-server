/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:05
 * 创建者  ：杨作庆
 * 
 */
public class VtoolprocuredWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 采购批次	*/ 
	private String procuredBatchWhere;

	/**
	 * 采购批次取得
	 * @return procuredBatchWhere
	 */
	public String getProcuredBatchWhere () {
		return procuredBatchWhere;
	}

	/**
	 * 采购批次设定
	 * @param procuredBatchWhere
	 */
	public void setProcuredBatchWhere (String procuredBatchWhere) {
		this.procuredBatchWhere = procuredBatchWhere;
	}

	/* 采购日期	*/ 
	private String procuredTimeWhere;

	/**
	 * 采购日期取得
	 * @return procuredTimeWhere
	 */
	public String getProcuredTimeWhere () {
		return procuredTimeWhere;
	}

	/**
	 * 采购日期设定
	 * @param procuredTimeWhere
	 */
	public void setProcuredTimeWhere (String procuredTimeWhere) {
		this.procuredTimeWhere = procuredTimeWhere;
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

	/* 	*/ 
	private String procuredUserWhere;

	/**
	 * 取得
	 * @return procuredUserWhere
	 */
	public String getProcuredUserWhere () {
		return procuredUserWhere;
	}

	/**
	 * 设定
	 * @param procuredUserWhere
	 */
	public void setProcuredUserWhere (String procuredUserWhere) {
		this.procuredUserWhere = procuredUserWhere;
	}

	/* 采购数量	*/ 
	private BigDecimal procuredCountWhere;

	/**
	 * 采购数量取得
	 * @return procuredCountWhere
	 */
	public BigDecimal getProcuredCountWhere () {
		return procuredCountWhere;
	}

	/**
	 * 采购数量设定
	 * @param procuredCountWhere
	 */
	public void setProcuredCountWhere (BigDecimal procuredCountWhere) {
		this.procuredCountWhere = procuredCountWhere;
	}

	/* 是否付费(0是1否9其他)	*/ 
	private String procuredPayingWhere;

	/**
	 * 是否付费(0是1否9其他)取得
	 * @return procuredPayingWhere
	 */
	public String getProcuredPayingWhere () {
		return procuredPayingWhere;
	}

	/**
	 * 是否付费(0是1否9其他)设定
	 * @param procuredPayingWhere
	 */
	public void setProcuredPayingWhere (String procuredPayingWhere) {
		this.procuredPayingWhere = procuredPayingWhere;
	}

	/* 采购类型(0新采购1外委图层2外委复磨9其他)	*/ 
	private String procuredTypeWhere;

	/**
	 * 采购类型(0新采购1外委图层2外委复磨9其他)取得
	 * @return procuredTypeWhere
	 */
	public String getProcuredTypeWhere () {
		return procuredTypeWhere;
	}

	/**
	 * 采购类型(0新采购1外委图层2外委复磨9其他)设定
	 * @param procuredTypeWhere
	 */
	public void setProcuredTypeWhere (String procuredTypeWhere) {
		this.procuredTypeWhere = procuredTypeWhere;
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
}

