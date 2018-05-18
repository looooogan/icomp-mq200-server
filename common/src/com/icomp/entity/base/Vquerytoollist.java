/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/10/15 16:55:29
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/10/15 16:55:29
 * 创建者  ：杨作庆
 * 
 */
public class Vquerytoollist extends VquerytoollistWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 查询方式(0库存1流转)	*/ 
	private String queryType;

	/**
	 * 查询方式(0库存1流转)取得
	 * @return queryType
	 */
	public String getQueryType() {
		return queryType;
	}

	/**
	 * 查询方式(0库存1流转)设定
	 * @param queryType
	 */
	public void setQueryType(String queryType) {
		this.queryType = queryType;
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

	/* 	*/ 
	private String lblCode;

	/**
	 * 取得
	 * @return lblCode
	 */
	public String getlblCode() {
		return lblCode;
	}

	/**
	 * 设定
	 * @param lblCode
	 */
	public void setlblCode(String lblCode) {
		this.lblCode = lblCode;
	}

	/* 货架	*/ 
	private String shelf;

	/**
	 * 货架取得
	 * @return shelf
	 */
	public String getShelf() {
		return shelf;
	}

	/**
	 * 货架设定
	 * @param shelf
	 */
	public void setShelf(String shelf) {
		this.shelf = shelf;
	}

	/* 货位	*/ 
	private String stack;

	/**
	 * 货位取得
	 * @return stack
	 */
	public String getStack() {
		return stack;
	}

	/**
	 * 货位设定
	 * @param stack
	 */
	public void setStack(String stack) {
		this.stack = stack;
	}

	/* 层	*/ 
	private String layer;

	/**
	 * 层取得
	 * @return layer
	 */
	public String getLayer() {
		return layer;
	}

	/**
	 * 层设定
	 * @param layer
	 */
	public void setLayer(String layer) {
		this.layer = layer;
	}

	/* 	*/ 
	private BigDecimal toolCount;

	public BigDecimal getToolCount() {
		return toolCount;
	}

	public void setToolCount(BigDecimal toolCount) {
		this.toolCount = toolCount;
	}
}

