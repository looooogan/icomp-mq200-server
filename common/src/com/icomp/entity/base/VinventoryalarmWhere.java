/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/17 09:29:24
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/17 09:29:24
 * 创建者  ：杨作庆
 * 
 */
public class VinventoryalarmWhere extends BaseEntity implements Serializable {

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

	/* 刀具周转量	*/ 
	private BigDecimal toolTurnoverWhere;

	/**
	 * 刀具周转量取得
	 * @return toolTurnoverWhere
	 */
	public BigDecimal getToolTurnoverWhere () {
		return toolTurnoverWhere;
	}

	/**
	 * 刀具周转量设定
	 * @param toolTurnoverWhere
	 */
	public void setToolTurnoverWhere (BigDecimal toolTurnoverWhere) {
		this.toolTurnoverWhere = toolTurnoverWhere;
	}

	/* 	*/ 
	private BigDecimal inventoryCountWhere;

	/**
	 * 取得
	 * @return inventoryCountWhere
	 */
	public BigDecimal getInventoryCountWhere () {
		return inventoryCountWhere;
	}

	/**
	 * 设定
	 * @param inventoryCountWhere
	 */
	public void setInventoryCountWhere (BigDecimal inventoryCountWhere) {
		this.inventoryCountWhere = inventoryCountWhere;
	}

	/* 	*/ 
	private BigDecimal transferCountWhere;

	/**
	 * 取得
	 * @return transferCountWhere
	 */
	public BigDecimal getTransferCountWhere () {
		return transferCountWhere;
	}

	/**
	 * 设定
	 * @param transferCountWhere
	 */
	public void setTransferCountWhere (BigDecimal transferCountWhere) {
		this.transferCountWhere = transferCountWhere;
	}

	/* 	*/ 
	private BigDecimal passageCountWhere;

	/**
	 * 取得
	 * @return passageCountWhere
	 */
	public BigDecimal getPassageCountWhere () {
		return passageCountWhere;
	}

	/**
	 * 设定
	 * @param passageCountWhere
	 */
	public void setPassageCountWhere (BigDecimal passageCountWhere) {
		this.passageCountWhere = passageCountWhere;
	}

	/* 	*/ 
	private String  toolAlarmRatioWhere;

	/**
	 * 取得
	 * @return toolAlarmRatioWhere
	 */
	public String  getToolAlarmRatioWhere () {
		return toolAlarmRatioWhere;
	}

	/**
	 * 设定
	 * @param toolAlarmRatioWhere
	 */
	public void setToolAlarmRatioWhere ( String toolAlarmRatioWhere) {
		this.toolAlarmRatioWhere = toolAlarmRatioWhere;
	}

	public int compareTo(Vinventoryalarm o) {
		return 0;
	}

}

