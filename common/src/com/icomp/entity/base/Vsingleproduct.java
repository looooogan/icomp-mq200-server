/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/05/16 13:50:36
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/05/16 13:50:36
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vsingleproduct extends VsingleproductWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* rfid载体ID	*/ 
	private String rfidContainerID;

	/**
	 * rfid载体ID取得
	 * @return rfidContainerID
	 */
	public String getRfidContainerID() {
		return rfidContainerID;
	}

	/**
	 * rfid载体ID设定
	 * @param rfidContainerID
	 */
	public void setRfidContainerID(String rfidContainerID) {
		this.rfidContainerID = rfidContainerID;
	}

	/* 容器ID	*/ 
	private String containerCarrierID;

	/**
	 * 容器ID取得
	 * @return containerCarrierID
	 */
	public String getContainerCarrierID() {
		return containerCarrierID;
	}

	/**
	 * 容器ID设定
	 * @param containerCarrierID
	 */
	public void setContainerCarrierID(String containerCarrierID) {
		this.containerCarrierID = containerCarrierID;
	}

	/* 容器名称	*/ 
	private String toolState;

	/**
	 * 容器名称取得
	 * @return toolState
	 */
	public String getToolState() {
		return toolState;
	}

	/**
	 * 容器名称设定
	 * @param toolState
	 */
	public void setToolState(String toolState) {
		this.toolState = toolState;
	}

	/* 当前数量	*/ 
	private BigDecimal toolDurable;

	/**
	 * 当前数量取得
	 * @return toolDurable
	 */
	public BigDecimal getToolDurable() {
		return toolDurable;
	}

	/**
	 * 当前数量设定
	 * @param toolDurable
	 */
	public void setToolDurable(BigDecimal toolDurable) {
		this.toolDurable = toolDurable;
	}
}

