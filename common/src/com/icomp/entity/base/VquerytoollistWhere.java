/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/10/15 16:55:29
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;

import com.icomp.common.entity.BaseEntity;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/10/15 16:55:29
 * 创建者  ：杨作庆
 * 
 */
public class VquerytoollistWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 查询方式(0库存1流转)	*/ 
	private String queryTypeWhere;

	/**
	 * 查询方式(0库存1流转)取得
	 * @return queryTypeWhere
	 */
	public String getQueryTypeWhere () {
		return queryTypeWhere;
	}

	/**
	 * 查询方式(0库存1流转)设定
	 * @param queryTypeWhere
	 */
	public void setQueryTypeWhere (String queryTypeWhere) {
		this.queryTypeWhere = queryTypeWhere;
	}

	/* RFID标签ID	*/ 
	private String rfidCodeWhere;

	/**
	 * RFID标签ID取得
	 * @return rfidCodeWhere
	 */
	public String getRfidCodeWhere () {
		return rfidCodeWhere;
	}

	/**
	 * RFID标签ID设定
	 * @param rfidCodeWhere
	 */
	public void setRfidCodeWhere (String rfidCodeWhere) {
		this.rfidCodeWhere = rfidCodeWhere;
	}

	/* 刀具编码	*/ 
	private String toolCodeWhere;

	/**
	 * 刀具编码取得
	 * @return toolCodeWhere
	 */
	public String getToolCodeWhere () {
		return toolCodeWhere;
	}

	/**
	 * 刀具编码设定
	 * @param toolCodeWhere
	 */
	public void setToolCodeWhere (String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}

	/* 	*/ 
	private String lblCodeWhere;

	/**
	 * 取得
	 * @return lblCodeWhere
	 */
	public String getlblCodeWhere () {
		return lblCodeWhere;
	}

	/**
	 * 设定
	 * @param lblCodeWhere
	 */
	public void setlblCodeWhere (String lblCodeWhere) {
		this.lblCodeWhere = lblCodeWhere;
	}

	/* 货架	*/ 
	private String shelfWhere;

	/**
	 * 货架取得
	 * @return shelfWhere
	 */
	public String getShelfWhere () {
		return shelfWhere;
	}

	/**
	 * 货架设定
	 * @param shelfWhere
	 */
	public void setShelfWhere (String shelfWhere) {
		this.shelfWhere = shelfWhere;
	}

	/* 货位	*/ 
	private String stackWhere;

	/**
	 * 货位取得
	 * @return stackWhere
	 */
	public String getStackWhere () {
		return stackWhere;
	}

	/**
	 * 货位设定
	 * @param stackWhere
	 */
	public void setStackWhere (String stackWhere) {
		this.stackWhere = stackWhere;
	}

	/* 层	*/ 
	private String layerWhere;

	/**
	 * 层取得
	 * @return layerWhere
	 */
	public String getLayerWhere () {
		return layerWhere;
	}

	/**
	 * 层设定
	 * @param layerWhere
	 */
	public void setLayerWhere (String layerWhere) {
		this.layerWhere = layerWhere;
	}

	/* 	*/ 
	private BigDecimal toolCountWhere;

	/**
	 * 取得
	 * @return toolCountWhere
	 */
	public BigDecimal gettoolCountWhere () {
		return toolCountWhere;
	}

	/**
	 * 设定
	 * @param toolCountWhere
	 */
	public void settoolCountWhere (BigDecimal toolCountWhere) {
		this.toolCountWhere = toolCountWhere;
	}
}

