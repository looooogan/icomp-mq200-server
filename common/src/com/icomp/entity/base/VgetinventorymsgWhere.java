/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/03/29 09:44:08
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;

import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/03/29 09:44:08
 * 创建者  ：工具自动生成
 * 
 */
public class VgetinventorymsgWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* RFID载体ID	*/ 
	private String rfidContainerIDWhere;

	/**
	 * RFID载体ID取得
	 * @return rfidContainerIDWhere
	 */
	public String getRfidContainerIDWhere () {
		return rfidContainerIDWhere;
	}

	/**
	 * RFID载体ID设定
	 * @param rfidContainerIDWhere
	 */
	public void setRfidContainerIDWhere (String rfidContainerIDWhere) {
		this.rfidContainerIDWhere = rfidContainerIDWhere;
	}

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

	/* 库存数量(钻头数量为1，刀片为当前数量)	*/ 
	private BigDecimal knifelnventoryNumberWhere;

	/**
	 * 库存数量(钻头数量为1，刀片为当前数量)取得
	 * @return knifelnventoryNumberWhere
	 */
	public BigDecimal getKnifelnventoryNumberWhere () {
		return knifelnventoryNumberWhere;
	}

	/**
	 * 库存数量(钻头数量为1，刀片为当前数量)设定
	 * @param knifelnventoryNumberWhere
	 */
	public void setKnifelnventoryNumberWhere (BigDecimal knifelnventoryNumberWhere) {
		this.knifelnventoryNumberWhere = knifelnventoryNumberWhere;
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

	/* 刀具名称	*/ 
	private String toolNameWhere;

	/**
	 * 刀具名称取得
	 * @return toolNameWhere
	 */
	public String getToolNameWhere () {
		return toolNameWhere;
	}

	/**
	 * 刀具名称设定
	 * @param toolNameWhere
	 */
	public void setToolNameWhere (String toolNameWhere) {
		this.toolNameWhere = toolNameWhere;
	}

	/* 规格型号	*/ 
	private String toolSpecificationsWhere;

	/**
	 * 规格型号取得
	 * @return toolSpecificationsWhere
	 */
	public String getToolSpecificationsWhere () {
		return toolSpecificationsWhere;
	}

	/**
	 * 规格型号设定
	 * @param toolSpecificationsWhere
	 */
	public void setToolSpecificationsWhere (String toolSpecificationsWhere) {
		this.toolSpecificationsWhere = toolSpecificationsWhere;
	}
}

