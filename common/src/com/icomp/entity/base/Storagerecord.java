/*
 * 工具自动生成：实体类
 * 生成时间    : 2016/06/13 17:12:07
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 实体类
 * @author 工具自动生成
 * 创建时间：2016/06/13 17:12:07
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Storagerecord extends StoragerecordWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 入库履历	*/ 
	private String storageID;

	/**
	 * 入库履历取得
	 * @return storageID
	 */
	public String getStorageID() {
		return storageID;
	}

	/**
	 * 入库履历设定
	 * @param storageID
	 */
	public void setStorageID(String storageID) {
		this.storageID = storageID;
	}

	/* 刀具id	*/ 
	private String toolID;

	/**
	 * 刀具id取得
	 * @return toolID
	 */
	public String getToolID() {
		return toolID;
	}

	/**
	 * 刀具id设定
	 * @param toolID
	 */
	public void setToolID(String toolID) {
		this.toolID = toolID;
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

	/* 库存状态（0.新刀）	*/ 
	private String storageState;

	/**
	 * 库存状态（0.新刀）取得
	 * @return storageState
	 */
	public String getStorageState() {
		return storageState;
	}

	/**
	 * 库存状态（0.新刀）设定
	 * @param storageState
	 */
	public void setStorageState(String storageState) {
		this.storageState = storageState;
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

	/* 入库数量	*/ 
	private BigDecimal storageNum;

	/**
	 * 入库数量取得
	 * @return storageNum
	 */
	public BigDecimal getStorageNum() {
		return storageNum;
	}

	/**
	 * 入库数量设定
	 * @param storageNum
	 */
	public void setStorageNum(BigDecimal storageNum) {
		this.storageNum = storageNum;
	}

	/* 刀具类型	*/ 
	private String storageType;

	/**
	 * 刀具类型取得
	 * @return storageType
	 */
	public String getStorageType() {
		return storageType;
	}

	/**
	 * 刀具类型设定
	 * @param storageType
	 */
	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}

	/* 上传状态	*/ 
	private BigDecimal state;

	/**
	 * 上传状态取得
	 * @return state
	 */
	public BigDecimal getState() {
		return state;
	}

	/**
	 * 上传状态设定
	 * @param state
	 */
	public void setState(BigDecimal state) {
		this.state = state;
	}


	private String employeeCard;

	public String getEmployeeCard() {

		return employeeCard;
	}

	public void setEmployeeCard(String employeeCard) {
		this.employeeCard = employeeCard;
	}
}

