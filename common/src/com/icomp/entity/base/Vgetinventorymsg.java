/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/03/29 09:44:08
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/03/29 09:44:08
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vgetinventorymsg extends VgetinventorymsgWhere implements Serializable {

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

	/* 库存数量(钻头数量为1，刀片为当前数量)	*/ 
	private BigDecimal knifelnventoryNumber;

	/**
	 * 库存数量(钻头数量为1，刀片为当前数量)取得
	 * @return knifelnventoryNumber
	 */
	public BigDecimal getKnifelnventoryNumber() {
		return knifelnventoryNumber;
	}

	/**
	 * 库存数量(钻头数量为1，刀片为当前数量)设定
	 * @param knifelnventoryNumber
	 */
	public void setKnifelnventoryNumber(BigDecimal knifelnventoryNumber) {
		this.knifelnventoryNumber = knifelnventoryNumber;
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

	/* 规格型号	*/ 
	private String toolSpecifications;

	/**
	 * 规格型号取得
	 * @return toolSpecifications
	 */
	public String getToolSpecifications() {
		return toolSpecifications;
	}

	/**
	 * 规格型号设定
	 * @param toolSpecifications
	 */
	public void setToolSpecifications(String toolSpecifications) {
		this.toolSpecifications = toolSpecifications;
	}
}

