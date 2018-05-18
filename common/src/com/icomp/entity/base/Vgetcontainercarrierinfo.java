/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/04/25 11:04:49
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/04/25 11:04:49
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vgetcontainercarrierinfo extends VgetcontainercarrierinfoWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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
}

