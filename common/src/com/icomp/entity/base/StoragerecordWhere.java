/*
 * 工具自动生成：条件实体类
 * 生成时间    : 2016/06/13 17:12:07
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 条件实体类
 * @author 工具自动生成
 * 创建时间：2016/06/13 17:12:07
 * 创建者  ：工具自动生成
 * 
 */
public class StoragerecordWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 入库履历	*/ 
	private String storageIDWhere;

	/**
	 * 入库履历取得
	 * @return storageIDWhere
	 */
	public String getStorageIDWhere () {
		return storageIDWhere;
	}

	/**
	 * 入库履历设定
	 * @param storageIDWhere
	 */
	public void setStorageIDWhere (String storageIDWhere) {
		this.storageIDWhere = storageIDWhere;
	}

	/* 刀具id	*/ 
	private String toolIDWhere;

	/**
	 * 刀具id取得
	 * @return toolIDWhere
	 */
	public String getToolIDWhere () {
		return toolIDWhere;
	}

	/**
	 * 刀具id设定
	 * @param toolIDWhere
	 */
	public void setToolIDWhere (String toolIDWhere) {
		this.toolIDWhere = toolIDWhere;
	}

	/* 材料号	*/ 
	private String toolCodeWhere;

	/**
	 * 材料号取得
	 * @return toolCodeWhere
	 */
	public String getToolCodeWhere () {
		return toolCodeWhere;
	}

	/**
	 * 材料号设定
	 * @param toolCodeWhere
	 */
	public void setToolCodeWhere (String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}

	/* 订单号	*/ 
	private String toolsOrdeNOWhere;

	/**
	 * 订单号取得
	 * @return toolsOrdeNOWhere
	 */
	public String getToolsOrdeNOWhere () {
		return toolsOrdeNOWhere;
	}

	/**
	 * 订单号设定
	 * @param toolsOrdeNOWhere
	 */
	public void setToolsOrdeNOWhere (String toolsOrdeNOWhere) {
		this.toolsOrdeNOWhere = toolsOrdeNOWhere;
	}

	/* 库存状态（0.新刀）	*/ 
	private String storageStateWhere;

	/**
	 * 库存状态（0.新刀）取得
	 * @return storageStateWhere
	 */
	public String getStorageStateWhere () {
		return storageStateWhere;
	}

	/**
	 * 库存状态（0.新刀）设定
	 * @param storageStateWhere
	 */
	public void setStorageStateWhere (String storageStateWhere) {
		this.storageStateWhere = storageStateWhere;
	}

	/* 刀具入库编码	*/ 
	private String knifeInventoryCodeWhere;

	/**
	 * 刀具入库编码取得
	 * @return knifeInventoryCodeWhere
	 */
	public String getKnifeInventoryCodeWhere () {
		return knifeInventoryCodeWhere;
	}

	/**
	 * 刀具入库编码设定
	 * @param knifeInventoryCodeWhere
	 */
	public void setKnifeInventoryCodeWhere (String knifeInventoryCodeWhere) {
		this.knifeInventoryCodeWhere = knifeInventoryCodeWhere;
	}

	/* 入库数量	*/ 
	private BigDecimal storageNumWhere;

	/**
	 * 入库数量取得
	 * @return storageNumWhere
	 */
	public BigDecimal getStorageNumWhere () {
		return storageNumWhere;
	}

	/**
	 * 入库数量设定
	 * @param storageNumWhere
	 */
	public void setStorageNumWhere (BigDecimal storageNumWhere) {
		this.storageNumWhere = storageNumWhere;
	}

	/* 刀具类型	*/ 
	private String storageTypeWhere;

	/**
	 * 刀具类型取得
	 * @return storageTypeWhere
	 */
	public String getStorageTypeWhere () {
		return storageTypeWhere;
	}

	/**
	 * 刀具类型设定
	 * @param storageTypeWhere
	 */
	public void setStorageTypeWhere (String storageTypeWhere) {
		this.storageTypeWhere = storageTypeWhere;
	}

	/* 上传状态	*/ 
	private BigDecimal stateWhere;

	/**
	 * 上传状态取得
	 * @return stateWhere
	 */
	public BigDecimal getStateWhere () {
		return stateWhere;
	}

	/**
	 * 上传状态设定
	 * @param stateWhere
	 */
	public void setStateWhere (BigDecimal stateWhere) {
		this.stateWhere = stateWhere;
	}
}

