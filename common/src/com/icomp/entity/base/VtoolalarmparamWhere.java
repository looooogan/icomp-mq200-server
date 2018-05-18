/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/05/27 11:57:12
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/05/27 11:57:12
 * 创建者  ：工具自动生成
 * 
 */
public class VtoolalarmparamWhere extends BaseEntity implements Serializable {

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

	/* 标准库存量	*/ 
	private BigDecimal standardWhere;

	/**
	 * 标准库存量取得
	 * @return standardWhere
	 */
	public BigDecimal getStandardWhere () {
		return standardWhere;
	}

	/**
	 * 标准库存量设定
	 * @param standardWhere
	 */
	public void setStandardWhere (BigDecimal standardWhere) {
		this.standardWhere = standardWhere;
	}

	/* 	*/ 
	private BigDecimal knifelnventoryNumberWhere;

	/**
	 * 取得
	 * @return knifelnventoryNumberWhere
	 */
	public BigDecimal getKnifelnventoryNumberWhere () {
		return knifelnventoryNumberWhere;
	}

	/**
	 * 设定
	 * @param knifelnventoryNumberWhere
	 */
	public void setKnifelnventoryNumberWhere (BigDecimal knifelnventoryNumberWhere) {
		this.knifelnventoryNumberWhere = knifelnventoryNumberWhere;
	}

	/* 	*/ 
	private BigDecimal cstandardWhere;

	/**
	 * 取得
	 * @return cstandardWhere
	 */
	public BigDecimal getCstandardWhere () {
		return cstandardWhere;
	}

	/**
	 * 设定
	 * @param cstandardWhere
	 */
	public void setCstandardWhere (BigDecimal cstandardWhere) {
		this.cstandardWhere = cstandardWhere;
	}
}

