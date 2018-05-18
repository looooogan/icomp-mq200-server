package com.icomp.wsdl.v01c01.c01s018.endpoint;

import java.io.Serializable;

public class GrindingonmsgList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8423127344831850200L;
	
	/* RFID标签ID	*/ 
	private String rfidCode;

	/**
	 * RFID标签ID取得
	 * @return rfidCode
	 */
	public String getRfidCode() {
		return rfidCode;
	}

	/**
	 * RFID标签ID设定
	 * @param rfidCode
	 */
	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}

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

	/* 刀具入库编码	*/ 
	private String knifeInventoryCode;

	/**
	 * 刀具入库编码取得
	 * @return knifeInventoryCode
	 */
	public String getKnifeInventoryCode() {
		return knifeInventoryCode;
	}

	/**
	 * 刀具入库编码设定
	 * @param knifeInventoryCode
	 */
	public void setKnifeInventoryCode(String knifeInventoryCode) {
		this.knifeInventoryCode = knifeInventoryCode;
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

	/* 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他	*/ 
	private String toolConsumetype;

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他取得
	 * @return toolConsumetype
	 */
	public String getToolConsumetype() {
		return toolConsumetype;
	}

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他设定
	 * @param toolConsumetype
	 */
	public void setToolConsumetype(String toolConsumetype) {
		this.toolConsumetype = toolConsumetype;
	}
	
	/*库存状态(0正常1报废2返厂3封存4流转9其他)  */
	private String stockState;
	
	/**
	 * 库存状态(0正常1报废2返厂3封存4流转9其他)取得
	 * @return stockState
	 */
	public String getStockState() {
		return stockState;
	}

	/**
	 * 库存状态(0正常1报废2返厂3封存4流转9其他)设定
	 * @param stockState
	 */
	public void setStockState(String stockState) {
		this.stockState = stockState;
	}

	/* 业务-流程中间表ID	*/ 
	private String businessID;

	/**
	 * 业务-流程中间表ID取得
	 * @return businessID
	 */
	public String getBusinessID() {
		return businessID;
	}

	/**
	 * 业务-流程中间表ID设定
	 * @param businessID
	 */
	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}

}
