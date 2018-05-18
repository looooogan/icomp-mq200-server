/*
 * 工具自动生成：工具盘位置实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 工具盘位置实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class Toolshelfplace extends ToolshelfplaceWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 工具盘位置ID	*/ 
	private String toolShelfPlaceID;

	/**
	 * 工具盘位置ID取得
	 * @return toolShelfPlaceID
	 */
	public String getToolShelfPlaceID() {
		return toolShelfPlaceID;
	}

	/**
	 * 工具盘位置ID设定
	 * @param toolShelfPlaceID
	 */
	public void setToolShelfPlaceID(String toolShelfPlaceID) {
		this.toolShelfPlaceID = toolShelfPlaceID;
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

