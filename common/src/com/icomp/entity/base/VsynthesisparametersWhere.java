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
public class VsynthesisparametersWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 合成刀具参数ID	*/ 
	private String synthesisParametersIDWhere;

	/**
	 * 合成刀具参数ID取得
	 * @return synthesisParametersIDWhere
	 */
	public String getSynthesisParametersIDWhere () {
		return synthesisParametersIDWhere;
	}

	/**
	 * 合成刀具参数ID设定
	 * @param synthesisParametersIDWhere
	 */
	public void setSynthesisParametersIDWhere (String synthesisParametersIDWhere) {
		this.synthesisParametersIDWhere = synthesisParametersIDWhere;
	}

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

	/* 位置数	*/ 
	private BigDecimal synthesisCountWhere;

	/**
	 * 位置数取得
	 * @return synthesisCountWhere
	 */
	public BigDecimal getSynthesisCountWhere () {
		return synthesisCountWhere;
	}

	/**
	 * 位置数设定
	 * @param synthesisCountWhere
	 */
	public void setSynthesisCountWhere (BigDecimal synthesisCountWhere) {
		this.synthesisCountWhere = synthesisCountWhere;
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

	/* 刀具图纸	*/ 
	private String toolPicWhere;

	/**
	 * 刀具图纸取得
	 * @return toolPicWhere
	 */
	public String getToolPicWhere () {
		return toolPicWhere;
	}

	/**
	 * 刀具图纸设定
	 * @param toolPicWhere
	 */
	public void setToolPicWhere (String toolPicWhere) {
		this.toolPicWhere = toolPicWhere;
	}
}

