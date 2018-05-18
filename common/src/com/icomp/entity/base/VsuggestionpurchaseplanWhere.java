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
public class VsuggestionpurchaseplanWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 库存量	*/ 
	private BigDecimal inventoryWhere;

	/**
	 * 库存量取得
	 * @return inventoryWhere
	 */
	public BigDecimal getInventoryWhere () {
		return inventoryWhere;
	}

	/**
	 * 库存量设定
	 * @param inventoryWhere
	 */
	public void setInventoryWhere (BigDecimal inventoryWhere) {
		this.inventoryWhere = inventoryWhere;
	}

	/* 采购计划编号	*/ 
	private String procurementPlansCodeWhere;

	/**
	 * 采购计划编号取得
	 * @return procurementPlansCodeWhere
	 */
	public String getProcurementPlansCodeWhere () {
		return procurementPlansCodeWhere;
	}

	/**
	 * 采购计划编号设定
	 * @param procurementPlansCodeWhere
	 */
	public void setProcurementPlansCodeWhere (String procurementPlansCodeWhere) {
		this.procurementPlansCodeWhere = procurementPlansCodeWhere;
	}

	/* 应采购数量	*/ 
	private BigDecimal procurementCountWhere;

	/**
	 * 应采购数量取得
	 * @return procurementCountWhere
	 */
	public BigDecimal getProcurementCountWhere () {
		return procurementCountWhere;
	}

	/**
	 * 应采购数量设定
	 * @param procurementCountWhere
	 */
	public void setProcurementCountWhere (BigDecimal procurementCountWhere) {
		this.procurementCountWhere = procurementCountWhere;
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
}

