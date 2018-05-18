/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/12/26 14:30:49
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/12/26 14:30:49
 * 创建者  ：杨作庆
 * 
 */
public class Vtoolplatemessagelist extends VtoolplatemessagelistWhere implements Serializable {

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

	/* 	*/ 
	private String toolShelfPlaceNumber;

	/**
	 * 取得
	 * @return toolShelfPlaceNumber
	 */
	public String getToolShelfPlaceNumber() {
		return toolShelfPlaceNumber;
	}

	/**
	 * 设定
	 * @param toolShelfPlaceNumber
	 */
	public void setToolShelfPlaceNumber(String toolShelfPlaceNumber) {
		this.toolShelfPlaceNumber = toolShelfPlaceNumber;
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

	/* 工具盘位置ID	*/ 
	private String toolshelfplace;

	/**
	 * 工具盘位置ID取得
	 * @return toolshelfplace
	 */
	public String gettoolshelfplace() {
		return toolshelfplace;
	}

	/**
	 * 工具盘位置ID设定
	 * @param toolshelfplace
	 */
	public void settoolshelfplace(String toolshelfplace) {
		this.toolshelfplace = toolshelfplace;
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
}

