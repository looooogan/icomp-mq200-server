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
public class Vgettoolshelfmessage extends VgettoolshelfmessageWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 工具盘ID	*/ 
	private String toolShelfID;

	/**
	 * 工具盘ID取得
	 * @return toolShelfID
	 */
	public String getToolShelfID() {
		return toolShelfID;
	}

	/**
	 * 工具盘ID设定
	 * @param toolShelfID
	 */
	public void setToolShelfID(String toolShelfID) {
		this.toolShelfID = toolShelfID;
	}

	/* 工具盘编号	*/ 
	private String toolShelfCode;

	/**
	 * 工具盘编号取得
	 * @return toolShelfCode
	 */
	public String getToolShelfCode() {
		return toolShelfCode;
	}

	/**
	 * 工具盘编号设定
	 * @param toolShelfCode
	 */
	public void setToolShelfCode(String toolShelfCode) {
		this.toolShelfCode = toolShelfCode;
	}

	/* 工具盘位置号	*/ 
	private BigDecimal placeNumber;

	/**
	 * 工具盘位置号取得
	 * @return placeNumber
	 */
	public BigDecimal getPlaceNumber() {
		return placeNumber;
	}

	/**
	 * 工具盘位置号设定
	 * @param placeNumber
	 */
	public void setPlaceNumber(BigDecimal placeNumber) {
		this.placeNumber = placeNumber;
	}

	/* 工具盘位置编码	*/ 
	private String placeCode;

	/**
	 * 工具盘位置编码取得
	 * @return placeCode
	 */
	public String getPlaceCode() {
		return placeCode;
	}

	/**
	 * 工具盘位置编码设定
	 * @param placeCode
	 */
	public void setPlaceCode(String placeCode) {
		this.placeCode = placeCode;
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

	/* 绑定类型(0RFID 1 激光码 2 工具盘 9 其他)	*/ 
	private String bandType;

	/**
	 * 绑定类型(0RFID 1 激光码 2 工具盘 9 其他)取得
	 * @return bandType
	 */
	public String getBandType() {
		return bandType;
	}

	/**
	 * 绑定类型(0RFID 1 激光码 2 工具盘 9 其他)设定
	 * @param bandType
	 */
	public void setBandType(String bandType) {
		this.bandType = bandType;
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
}

