/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/19 11:52:35
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/19 11:52:35
 * 创建者  ：杨作庆
 * 
 */
public class VscrapanalysisWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 刀具状态(0断刀1丢失2不合格3借入4申领9其他)	*/ 
	private String toolStateWhere;

	/**
	 * 刀具状态(0断刀1丢失2不合格3借入4申领9其他)取得
	 * @return toolStateWhere
	 */
	public String getToolStateWhere () {
		return toolStateWhere;
	}

	/**
	 * 刀具状态(0断刀1丢失2不合格3借入4申领9其他)设定
	 * @param toolStateWhere
	 */
	public void setToolStateWhere (String toolStateWhere) {
		this.toolStateWhere = toolStateWhere;
	}

	/* 供应商	*/ 
	private String toolSupplierWhere;

	/**
	 * 供应商取得
	 * @return toolSupplierWhere
	 */
	public String getToolSupplierWhere () {
		return toolSupplierWhere;
	}

	/**
	 * 供应商设定
	 * @param toolSupplierWhere
	 */
	public void setToolSupplierWhere (String toolSupplierWhere) {
		this.toolSupplierWhere = toolSupplierWhere;
	}

	/* 品牌	*/ 
	private String toolBrandWhere;

	/**
	 * 品牌取得
	 * @return toolBrandWhere
	 */
	public String getToolBrandWhere () {
		return toolBrandWhere;
	}

	/**
	 * 品牌设定
	 * @param toolBrandWhere
	 */
	public void setToolBrandWhere (String toolBrandWhere) {
		this.toolBrandWhere = toolBrandWhere;
	}

	/* 采购批次	*/ 
	private String procuredBatchWhere;

	/**
	 * 采购批次取得
	 * @return procuredBatchWhere
	 */
	public String getProcuredBatchWhere () {
		return procuredBatchWhere;
	}

	/**
	 * 采购批次设定
	 * @param procuredBatchWhere
	 */
	public void setProcuredBatchWhere (String procuredBatchWhere) {
		this.procuredBatchWhere = procuredBatchWhere;
	}

	/* 采购单价	*/ 
	private BigDecimal unitPriceWhere;

	/**
	 * 采购单价取得
	 * @return unitPriceWhere
	 */
	public BigDecimal getUnitPriceWhere () {
		return unitPriceWhere;
	}

	/**
	 * 采购单价设定
	 * @param unitPriceWhere
	 */
	public void setUnitPriceWhere (BigDecimal unitPriceWhere) {
		this.unitPriceWhere = unitPriceWhere;
	}

	/* 	*/ 
	private String confirmedUserWhere;

	/**
	 * 取得
	 * @return confirmedUserWhere
	 */
	public String getConfirmedUserWhere () {
		return confirmedUserWhere;
	}

	/**
	 * 设定
	 * @param confirmedUserWhere
	 */
	public void setConfirmedUserWhere (String confirmedUserWhere) {
		this.confirmedUserWhere = confirmedUserWhere;
	}

	/* 设备名称	*/ 
	private String equipmentNameWhere;

	/**
	 * 设备名称取得
	 * @return equipmentNameWhere
	 */
	public String getEquipmentNameWhere () {
		return equipmentNameWhere;
	}

	/**
	 * 设备名称设定
	 * @param equipmentNameWhere
	 */
	public void setEquipmentNameWhere (String equipmentNameWhere) {
		this.equipmentNameWhere = equipmentNameWhere;
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

	/* 可使用次数	*/ 
	private BigDecimal toolSharpennumWhere;

	/**
	 * 可使用次数取得
	 * @return toolSharpennumWhere
	 */
	public BigDecimal getToolSharpennumWhere () {
		return toolSharpennumWhere;
	}

	/**
	 * 可使用次数设定
	 * @param toolSharpennumWhere
	 */
	public void setToolSharpennumWhere (BigDecimal toolSharpennumWhere) {
		this.toolSharpennumWhere = toolSharpennumWhere;
	}

	/* 可刃磨长度	*/ 
	private BigDecimal toolSharpenLengthWhere;

	/**
	 * 可刃磨长度取得
	 * @return toolSharpenLengthWhere
	 */
	public BigDecimal getToolSharpenLengthWhere () {
		return toolSharpenLengthWhere;
	}

	/**
	 * 可刃磨长度设定
	 * @param toolSharpenLengthWhere
	 */
	public void setToolSharpenLengthWhere (BigDecimal toolSharpenLengthWhere) {
		this.toolSharpenLengthWhere = toolSharpenLengthWhere;
	}
}

