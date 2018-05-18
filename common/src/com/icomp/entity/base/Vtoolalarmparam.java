/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/05/27 11:57:12
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/05/27 11:57:12
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vtoolalarmparam extends VtoolalarmparamWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具ID	*/ 
	private String toolID;

	/**
	 * 刀具ID取得
	 * @return toolID
	 */
	public String getToolID() {
		return toolID;
	}

	/**
	 * 刀具ID设定
	 * @param toolID
	 */
	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	/* 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他	*/ 
	private String toolConsumetype;

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他取得
	 * @return toolConsumetype
	 */
	public String getToolConsumetype() {
		return toolConsumetype;
	}

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他设定
	 * @param toolConsumetype
	 */
	public void setToolConsumetype(String toolConsumetype) {
		this.toolConsumetype = toolConsumetype;
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

	/* 标准库存量	*/ 
	private BigDecimal standard;

	/**
	 * 标准库存量取得
	 * @return standard
	 */
	public BigDecimal getStandard() {
		return standard;
	}

	/**
	 * 标准库存量设定
	 * @param standard
	 */
	public void setStandard(BigDecimal standard) {
		this.standard = standard;
	}

	/* 	*/ 
	private BigDecimal knifelnventoryNumber;

	/**
	 * 取得
	 * @return knifelnventoryNumber
	 */
	public BigDecimal getKnifelnventoryNumber() {
		return knifelnventoryNumber;
	}

	/**
	 * 设定
	 * @param knifelnventoryNumber
	 */
	public void setKnifelnventoryNumber(BigDecimal knifelnventoryNumber) {
		this.knifelnventoryNumber = knifelnventoryNumber;
	}

	/* 	*/ 
	private BigDecimal cstandard;

	/**
	 * 取得
	 * @return cstandard
	 */
	public BigDecimal getCstandard() {
		return cstandard;
	}

	/**
	 * 设定
	 * @param cstandard
	 */
	public void setCstandard(BigDecimal cstandard) {
		this.cstandard = cstandard;
	}
}

