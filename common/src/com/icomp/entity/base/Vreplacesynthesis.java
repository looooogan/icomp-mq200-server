/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:05
 * 创建者  ：杨作庆
 * 
 */
public class Vreplacesynthesis extends VreplacesynthesisWhere implements Serializable {

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

	/* 刀具编码(应该装入合成刀的编码)	*/ 
	private String toolCode;

	/**
	 * 刀具编码(应该装入合成刀的编码)取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 刀具编码(应该装入合成刀的编码)设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 替换刀具编码（刀具编码以逗号分隔）	*/ 
	private String tempToolCode;

	/**
	 * 替换刀具编码（刀具编码以逗号分隔）取得
	 * @return tempToolCode
	 */
	public String getTempToolCode() {
		return tempToolCode;
	}

	/**
	 * 替换刀具编码（刀具编码以逗号分隔）设定
	 * @param tempToolCode
	 */
	public void setTempToolCode(String tempToolCode) {
		this.tempToolCode = tempToolCode;
	}

	/* 位置类型(0刀具1辅具2配套9其他)	*/ 
	private String cutterType;

	/**
	 * 位置类型(0刀具1辅具2配套9其他)取得
	 * @return cutterType
	 */
	public String getCutterType() {
		return cutterType;
	}

	/**
	 * 位置类型(0刀具1辅具2配套9其他)设定
	 * @param cutterType
	 */
	public void setCutterType(String cutterType) {
		this.cutterType = cutterType;
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

	/* 	*/ 
	private BigDecimal amount;

	/**
	 * 取得
	 * @return amount
	 */
	public BigDecimal getamount() {
		return amount;
	}

	/**
	 * 设定
	 * @param amount
	 */
	public void setamount(BigDecimal amount) {
		this.amount = amount;
	}
}

