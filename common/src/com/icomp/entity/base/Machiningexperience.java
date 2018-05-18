/*
 * 工具自动生成：加工履历（在刀具安上设备上需要记录当前合成刀与刀具的绑定关系）实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 加工履历（在刀具安上设备上需要记录当前合成刀与刀具的绑定关系）实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class Machiningexperience extends MachiningexperienceWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 合成刀具编码(系统唯一)	*/ 
	private String synthesisParametersCode;

	/**
	 * 合成刀具编码(系统唯一)取得
	 * @return synthesisParametersCode
	 */
	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	/**
	 * 合成刀具编码(系统唯一)设定
	 * @param synthesisParametersCode
	 */
	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}

	/* 合成刀具编号(例如：001、002、003)	*/ 
	private String synthesisParametersNumber;

	/**
	 * 合成刀具编号(例如：001、002、003)取得
	 * @return synthesisParametersNumber
	 */
	public String getSynthesisParametersNumber() {
		return synthesisParametersNumber;
	}

	/**
	 * 合成刀具编号(例如：001、002、003)设定
	 * @param synthesisParametersNumber
	 */
	public void setSynthesisParametersNumber(String synthesisParametersNumber) {
		this.synthesisParametersNumber = synthesisParametersNumber;
	}

	/* 加工编号(年月日时分秒 14位字符串)	*/ 
	private String synthesisNumber;

	/**
	 * 加工编号(年月日时分秒 14位字符串)取得
	 * @return synthesisNumber
	 */
	public String getSynthesisNumber() {
		return synthesisNumber;
	}

	/**
	 * 加工编号(年月日时分秒 14位字符串)设定
	 * @param synthesisNumber
	 */
	public void setSynthesisNumber(String synthesisNumber) {
		this.synthesisNumber = synthesisNumber;
	}

	/* 位置号	*/ 
	private BigDecimal synthesisCutterNumber;

	/**
	 * 位置号取得
	 * @return synthesisCutterNumber
	 */
	public BigDecimal getSynthesisCutterNumber() {
		return synthesisCutterNumber;
	}

	/**
	 * 位置号设定
	 * @param synthesisCutterNumber
	 */
	public void setSynthesisCutterNumber(BigDecimal synthesisCutterNumber) {
		this.synthesisCutterNumber = synthesisCutterNumber;
	}

	/* 刀具入库编码	*/ 
	private String knifeInventoryCode;

	/**
	 * 刀具入库编码取得
	 * @return knifeInventoryCode
	 */
	public String getKnifeInventoryCode() {
		return knifeInventoryCode;
	}

	/**
	 * 刀具入库编码设定
	 * @param knifeInventoryCode
	 */
	public void setKnifeInventoryCode(String knifeInventoryCode) {
		this.knifeInventoryCode = knifeInventoryCode;
	}

	/* 刀具损耗	*/ 
	private BigDecimal toolWastage;

	/**
	 * 刀具损耗取得
	 * @return toolWastage
	 */
	public BigDecimal getToolWastage() {
		return toolWastage;
	}

	/**
	 * 刀具损耗设定
	 * @param toolWastage
	 */
	public void setToolWastage(BigDecimal toolWastage) {
		this.toolWastage = toolWastage;
	}
}

