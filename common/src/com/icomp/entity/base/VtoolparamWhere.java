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
public class VtoolparamWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具ID	*/ 
	private String toolIDWhere;

	/**
	 * 刀具ID取得
	 * @return toolIDWhere
	 */
	public String getToolIDWhere () {
		return toolIDWhere;
	}

	/**
	 * 刀具ID设定
	 * @param toolIDWhere
	 */
	public void setToolIDWhere (String toolIDWhere) {
		this.toolIDWhere = toolIDWhere;
	}

	/* 库位码	*/ 
	private String libraryCodeIDWhere;

	/**
	 * 库位码取得
	 * @return libraryCodeIDWhere
	 */
	public String getLibraryCodeIDWhere () {
		return libraryCodeIDWhere;
	}

	/**
	 * 库位码设定
	 * @param libraryCodeIDWhere
	 */
	public void setLibraryCodeIDWhere (String libraryCodeIDWhere) {
		this.libraryCodeIDWhere = libraryCodeIDWhere;
	}

	/* 系统编码	*/ 
	private String systeCodeWhere;

	/**
	 * 系统编码取得
	 * @return systeCodeWhere
	 */
	public String getSysteCodeWhere () {
		return systeCodeWhere;
	}

	/**
	 * 系统编码设定
	 * @param systeCodeWhere
	 */
	public void setSysteCodeWhere (String systeCodeWhere) {
		this.systeCodeWhere = systeCodeWhere;
	}

	/* 自定义编码	*/ 
	private String customerCodeWhere;

	/**
	 * 自定义编码取得
	 * @return customerCodeWhere
	 */
	public String getCustomerCodeWhere () {
		return customerCodeWhere;
	}

	/**
	 * 自定义编码设定
	 * @param customerCodeWhere
	 */
	public void setCustomerCodeWhere (String customerCodeWhere) {
		this.customerCodeWhere = customerCodeWhere;
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

	/* 刀具分类(0刀具1辅具2配套9其他）	*/ 
	private String toolTypeWhere;

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）取得
	 * @return toolTypeWhere
	 */
	public String getToolTypeWhere () {
		return toolTypeWhere;
	}

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）设定
	 * @param toolTypeWhere
	 */
	public void setToolTypeWhere (String toolTypeWhere) {
		this.toolTypeWhere = toolTypeWhere;
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
}

