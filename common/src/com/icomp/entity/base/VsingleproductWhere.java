/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/05/16 13:50:36
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/05/16 13:50:36
 * 创建者  ：工具自动生成
 * 
 */
public class VsingleproductWhere extends BaseEntity implements Serializable {

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

	/* rfid载体ID	*/ 
	private String rfidContainerIDWhere;

	/**
	 * rfid载体ID取得
	 * @return rfidContainerIDWhere
	 */
	public String getRfidContainerIDWhere () {
		return rfidContainerIDWhere;
	}

	/**
	 * rfid载体ID设定
	 * @param rfidContainerIDWhere
	 */
	public void setRfidContainerIDWhere (String rfidContainerIDWhere) {
		this.rfidContainerIDWhere = rfidContainerIDWhere;
	}

	/* 容器ID	*/ 
	private String containerCarrierIDWhere;

	/**
	 * 容器ID取得
	 * @return containerCarrierIDWhere
	 */
	public String getContainerCarrierIDWhere () {
		return containerCarrierIDWhere;
	}

	/**
	 * 容器ID设定
	 * @param containerCarrierIDWhere
	 */
	public void setContainerCarrierIDWhere (String containerCarrierIDWhere) {
		this.containerCarrierIDWhere = containerCarrierIDWhere;
	}

	/* 容器名称	*/ 
	private String toolStateWhere;

	/**
	 * 容器名称取得
	 * @return toolStateWhere
	 */
	public String getToolStateWhere () {
		return toolStateWhere;
	}

	/**
	 * 容器名称设定
	 * @param toolStateWhere
	 */
	public void setToolStateWhere (String toolStateWhere) {
		this.toolStateWhere = toolStateWhere;
	}

	/* 当前数量	*/ 
	private BigDecimal toolDurableWhere;

	/**
	 * 当前数量取得
	 * @return toolDurableWhere
	 */
	public BigDecimal getToolDurableWhere () {
		return toolDurableWhere;
	}

	/**
	 * 当前数量设定
	 * @param toolDurableWhere
	 */
	public void setToolDurableWhere (BigDecimal toolDurableWhere) {
		this.toolDurableWhere = toolDurableWhere;
	}
}

