/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:05
 * 创建者  ：杨作庆
 * 
 */
public class VtoolstackWhere extends BaseEntity implements Serializable {

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

	/* 绑定类型(0RFID 1 激光码 2 工具盘 9 其他)	*/ 
	private String bandTypeWhere;

	/**
	 * 绑定类型(0RFID 1 激光码 2 工具盘 9 其他)取得
	 * @return bandTypeWhere
	 */
	public String getBandTypeWhere () {
		return bandTypeWhere;
	}

	/**
	 * 绑定类型(0RFID 1 激光码 2 工具盘 9 其他)设定
	 * @param bandTypeWhere
	 */
	public void setBandTypeWhere (String bandTypeWhere) {
		this.bandTypeWhere = bandTypeWhere;
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

	/* 	*/ 
	private BigDecimal existingNumberWhere;

	/**
	 * 取得
	 * @return existingNumberWhere
	 */
	public BigDecimal getexistingNumberWhere () {
		return existingNumberWhere;
	}

	/**
	 * 设定
	 * @param existingNumberWhere
	 */
	public void setexistingNumberWhere (BigDecimal existingNumberWhere) {
		this.existingNumberWhere = existingNumberWhere;
	}

	/* 	*/ 
	private String toolIDWhere;

	/**
	 * 取得
	 * @return toolIDWhere
	 */
	public String getToolIDWhere () {
		return toolIDWhere;
	}

	/**
	 * 设定
	 * @param toolIDWhere
	 */
	public void setToolIDWhere (String toolIDWhere) {
		this.toolIDWhere = toolIDWhere;
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

	/* 刀具每盒数量	*/ 
	private BigDecimal toolUnitnumberWhere;

	/**
	 * 刀具每盒数量取得
	 * @return toolUnitnumberWhere
	 */
	public BigDecimal getToolUnitnumberWhere () {
		return toolUnitnumberWhere;
	}

	/**
	 * 刀具每盒数量设定
	 * @param toolUnitnumberWhere
	 */
	public void setToolUnitnumberWhere (BigDecimal toolUnitnumberWhere) {
		this.toolUnitnumberWhere = toolUnitnumberWhere;
	}

	/* 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他	*/ 
	private String toolConsumetypeWhere;

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他取得
	 * @return toolConsumetypeWhere
	 */
	public String getToolConsumetypeWhere () {
		return toolConsumetypeWhere;
	}

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他设定
	 * @param toolConsumetypeWhere
	 */
	public void setToolConsumetypeWhere (String toolConsumetypeWhere) {
		this.toolConsumetypeWhere = toolConsumetypeWhere;
	}

	/* 厂区	*/ 
	private String complexWhere;

	/**
	 * 厂区取得
	 * @return complexWhere
	 */
	public String getComplexWhere () {
		return complexWhere;
	}

	/**
	 * 厂区设定
	 * @param complexWhere
	 */
	public void setComplexWhere (String complexWhere) {
		this.complexWhere = complexWhere;
	}

	/* 库房号	*/ 
	private String depotWhere;

	/**
	 * 库房号取得
	 * @return depotWhere
	 */
	public String getDepotWhere () {
		return depotWhere;
	}

	/**
	 * 库房号设定
	 * @param depotWhere
	 */
	public void setDepotWhere (String depotWhere) {
		this.depotWhere = depotWhere;
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

	/* 	*/ 
	private String libraryCodeWhere;

	/**
	 * 取得
	 * @return libraryCodeWhere
	 */
	public String getLibraryCodeWhere () {
		return libraryCodeWhere;
	}

	/**
	 * 设定
	 * @param libraryCodeWhere
	 */
	public void setLibraryCodeWhere (String libraryCodeWhere) {
		this.libraryCodeWhere = libraryCodeWhere;
	}
}

