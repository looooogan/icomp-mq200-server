/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/20 13:12:40
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/20 13:12:40
 * 创建者  ：杨作庆
 * 
 */
public class VtooldiscardeWhere extends BaseEntity implements Serializable {

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

	/* 	*/ 
	private BigDecimal toolCountWhere;


	public BigDecimal getToolCountWhere() {
		return toolCountWhere;
	}

	public void setToolCountWhere(BigDecimal toolCountWhere) {
		this.toolCountWhere = toolCountWhere;
	}

	public String getDiscardeFlagWhere() {
		return discardeFlagWhere;
	}

	public void setDiscardeFlagWhere(String discardeFlagWhere) {
		this.discardeFlagWhere = discardeFlagWhere;
	}

	/* 报废确认区分(0未确认1已确认)	*/ 
	private String discardeFlagWhere;

	
	private String discardeTime;

	public String getDiscardeTime() {
		return discardeTime;
	}

	public void setDiscardeTime(String discardeTime) {
		this.discardeTime = discardeTime;
	}
	
	/* 区分文本	*/ 
	private String toolConsumetypeTextWhere;

	/**
	 * 区分文本取得
	 * @return toolConsumetypeTextWhere
	 */
	public String getToolConsumetypeTextWhere () {
		return toolConsumetypeTextWhere;
	}

	/**
	 * 区分文本设定
	 * @param toolConsumetypeTextWhere
	 */
	public void setToolConsumetypeTextWhere (String toolConsumetypeTextWhere) {
		this.toolConsumetypeTextWhere = toolConsumetypeTextWhere;
	}
}

