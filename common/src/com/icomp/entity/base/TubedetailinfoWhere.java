/*
 * 工具自动生成：合成刀库实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 合成刀库实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class TubedetailinfoWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 合成刀具编码(系统唯一)	*/
	private String synthesisParametersCodeWhere;

	/**
	 * 合成刀具编码(系统唯一)取得
	 * @return synthesisParametersCodeWhere
	 */
	public String getSynthesisParametersCodeWhere() {
		return synthesisParametersCodeWhere;
	}
	/**
	 * 合成刀具编码(系统唯一)设定
	 * @param synthesisParametersCodeWhere
	 */
	public void setSynthesisParametersCodeWhere(String synthesisParametersCodeWhere) {
		this.synthesisParametersCodeWhere = synthesisParametersCodeWhere;
	}

	/* 位置号	*/
	private BigDecimal synthesisCutterNumberWhere;

	/**
	 * 位置号取得
	 * @return synthesisCutterNumberWhere
	 */
	public BigDecimal getSynthesisCutterNumberWhere() {
		return synthesisCutterNumberWhere;
	}
	/**
	 * 位置号设定
	 * @param synthesisCutterNumberWhere
	 */
	public void setSynthesisCutterNumberWhere(BigDecimal synthesisCutterNumberWhere) {
		this.synthesisCutterNumberWhere = synthesisCutterNumberWhere;
	}

	/* 刀具编号	*/
	private String toolCodeWhere;
	/**
	 * 刀具编号取得
	 * @return toolCodeWhere
	 */
	public String getToolCodeWhere() {
		return toolCodeWhere;
	}
	/**
	 * 刀具编号设定
	 * @param toolCodeWhere
	 */
	public void setToolCodeWhere(String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}

	/* 使用状态(0装入1卸下2修磨3修磨完成4报废)	*/
	private String loadStateWhere;

	/**
	 * 使用状态(0装入1卸下2修磨3修磨完成4报废)取得
	 * @return loadStateWhere
	 */
	public String getLoadStateWhere() {
		return loadStateWhere;
	}
	/**
	 * 使用状态(0装入1卸下2修磨3修磨完成4报废)设定
	 * @param loadStateWhere
	 */
	public void setLoadStateWhere(String loadStateWhere) {
		this.loadStateWhere = loadStateWhere;
	}

	/* 修磨次数	*/
	private BigDecimal grindingSumWhere;
	/**
	 * 修磨次数取得
	 * @return grindingSumWhere
	 */
	public BigDecimal getGrindingSumWhere() {
		return grindingSumWhere;
	}
	/**
	 * 修磨次数设定
	 * @param grindingSumWhere
	 */
	public void setGrindingSumWhere(BigDecimal grindingSumWhere) {
		this.grindingSumWhere = grindingSumWhere;
	}

	/* 刀具数量	*/
	private BigDecimal toolCountWhere;
	/**
	 * 刀具数量取得
	 * @return toolCountWhere
	 */
	public BigDecimal getToolCountWhere() {
		return toolCountWhere;
	}
	/**
	 * 刀具数量设定
	 * @param toolCountWhere
	 */
	public void setToolCountWhere(BigDecimal toolCountWhere) {
		this.toolCountWhere = toolCountWhere;
	}
}

