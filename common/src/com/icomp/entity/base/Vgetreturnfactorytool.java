/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class Vgetreturnfactorytool extends VgetreturnfactorytoolWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 	*/ 
	private BigDecimal thisCount;

	/**
	 * 取得
	 * @return thisCount
	 */
	public BigDecimal getthisCount() {
		return thisCount;
	}

	/**
	 * 设定
	 * @param thisCount
	 */
	public void setthisCount(BigDecimal thisCount) {
		this.thisCount = thisCount;
	}

	/* 	*/ 
	private BigDecimal inventoryCount;

	/**
	 * 取得
	 * @return inventoryCount
	 */
	public BigDecimal getInventoryCount() {
		return inventoryCount;
	}

	/**
	 * 设定
	 * @param inventoryCount
	 */
	public void setInventoryCount(BigDecimal inventoryCount) {
		this.inventoryCount = inventoryCount;
	}

	/* 质检人	*/ 
	private String inspectionUser;

	/**
	 * 质检人取得
	 * @return inspectionUser
	 */
	public String getInspectionUser() {
		return inspectionUser;
	}

	/**
	 * 质检人设定
	 * @param inspectionUser
	 */
	public void setInspectionUser(String inspectionUser) {
		this.inspectionUser = inspectionUser;
	}

	/* 	*/ 
	private String userName;

	/**
	 * 取得
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设定
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
}

