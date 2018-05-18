/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2015/04/22 18:46:22
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2015/04/22 18:46:22
 * 创建者  ：杨作庆
 * 
 */
public class VcostabsorptionWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 零部件名称	*/ 
	private String partsNameWhere;

	/**
	 * 零部件名称取得
	 * @return partsNameWhere
	 */
	public String getPartsNameWhere () {
		return partsNameWhere;
	}

	/**
	 * 零部件名称设定
	 * @param partsNameWhere
	 */
	public void setPartsNameWhere (String partsNameWhere) {
		this.partsNameWhere = partsNameWhere;
	}

	/* 设备名称	*/ 
	private String equipmentnameWhere;

	/**
	 * 设备名称取得
	 * @return equipmentnameWhere
	 */
	public String getEquipmentnameWhere () {
		return equipmentnameWhere;
	}

	/**
	 * 设备名称设定
	 * @param equipmentnameWhere
	 */
	public void setEquipmentnameWhere (String equipmentnameWhere) {
		this.equipmentnameWhere = equipmentnameWhere;
	}

	/* 工序名称	*/ 
	private String processNameWhere;

	/**
	 * 工序名称取得
	 * @return processNameWhere
	 */
	public String getProcessNameWhere () {
		return processNameWhere;
	}

	/**
	 * 工序名称设定
	 * @param processNameWhere
	 */
	public void setProcessNameWhere (String processNameWhere) {
		this.processNameWhere = processNameWhere;
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

	/* 	*/ 
	private BigDecimal priceWhere;

	/**
	 * 取得
	 * @return priceWhere
	 */
	public BigDecimal getPriceWhere () {
		return priceWhere;
	}

	/**
	 * 设定
	 * @param priceWhere
	 */
	public void setPriceWhere (BigDecimal priceWhere) {
		this.priceWhere = priceWhere;
	}

	/* 	*/ 
	private BigDecimal consumedCountWhere;

	/**
	 * 取得
	 * @return consumedCountWhere
	 */
	public BigDecimal getconsumedCountWhere () {
		return consumedCountWhere;
	}

	/**
	 * 设定
	 * @param consumedCountWhere
	 */
	public void setconsumedCountWhere (BigDecimal consumedCountWhere) {
		this.consumedCountWhere = consumedCountWhere;
	}

	/* 	*/ 
	private BigDecimal processAmountWhere;

	/**
	 * 取得
	 * @return processAmountWhere
	 */
	public BigDecimal getProcessAmountWhere () {
		return processAmountWhere;
	}

	/**
	 * 设定
	 * @param processAmountWhere
	 */
	public void setProcessAmountWhere (BigDecimal processAmountWhere) {
		this.processAmountWhere = processAmountWhere;
	}
}

