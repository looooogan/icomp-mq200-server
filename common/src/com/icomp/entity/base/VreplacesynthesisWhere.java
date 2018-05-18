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
public class VreplacesynthesisWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 合成刀具编码(系统唯一)	*/ 
	private String synthesisParametersCodeWhere;

	/**
	 * 合成刀具编码(系统唯一)取得
	 * @return synthesisParametersCodeWhere
	 */
	public String getSynthesisParametersCodeWhere () {
		return synthesisParametersCodeWhere;
	}

	/**
	 * 合成刀具编码(系统唯一)设定
	 * @param synthesisParametersCodeWhere
	 */
	public void setSynthesisParametersCodeWhere (String synthesisParametersCodeWhere) {
		this.synthesisParametersCodeWhere = synthesisParametersCodeWhere;
	}

	/* 刀具编码(应该装入合成刀的编码)	*/ 
	private String toolCodeWhere;

	/**
	 * 刀具编码(应该装入合成刀的编码)取得
	 * @return toolCodeWhere
	 */
	public String getToolCodeWhere () {
		return toolCodeWhere;
	}

	/**
	 * 刀具编码(应该装入合成刀的编码)设定
	 * @param toolCodeWhere
	 */
	public void setToolCodeWhere (String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}

	/* 替换刀具编码（刀具编码以逗号分隔）	*/ 
	private String tempToolCodeWhere;

	/**
	 * 替换刀具编码（刀具编码以逗号分隔）取得
	 * @return tempToolCodeWhere
	 */
	public String getTempToolCodeWhere () {
		return tempToolCodeWhere;
	}

	/**
	 * 替换刀具编码（刀具编码以逗号分隔）设定
	 * @param tempToolCodeWhere
	 */
	public void setTempToolCodeWhere (String tempToolCodeWhere) {
		this.tempToolCodeWhere = tempToolCodeWhere;
	}

	/* 位置类型(0刀具1辅具2配套9其他)	*/ 
	private String cutterTypeWhere;

	/**
	 * 位置类型(0刀具1辅具2配套9其他)取得
	 * @return cutterTypeWhere
	 */
	public String getCutterTypeWhere () {
		return cutterTypeWhere;
	}

	/**
	 * 位置类型(0刀具1辅具2配套9其他)设定
	 * @param cutterTypeWhere
	 */
	public void setCutterTypeWhere (String cutterTypeWhere) {
		this.cutterTypeWhere = cutterTypeWhere;
	}

	/* 位置号	*/ 
	private BigDecimal synthesisCutterNumberWhere;

	/**
	 * 位置号取得
	 * @return synthesisCutterNumberWhere
	 */
	public BigDecimal getSynthesisCutterNumberWhere () {
		return synthesisCutterNumberWhere;
	}

	/**
	 * 位置号设定
	 * @param synthesisCutterNumberWhere
	 */
	public void setSynthesisCutterNumberWhere (BigDecimal synthesisCutterNumberWhere) {
		this.synthesisCutterNumberWhere = synthesisCutterNumberWhere;
	}

	/* 	*/ 
	private BigDecimal amountWhere;

	/**
	 * 取得
	 * @return amountWhere
	 */
	public BigDecimal getamountWhere () {
		return amountWhere;
	}

	/**
	 * 设定
	 * @param amountWhere
	 */
	public void setamountWhere (BigDecimal amountWhere) {
		this.amountWhere = amountWhere;
	}
}

