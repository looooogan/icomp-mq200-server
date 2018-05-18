/*
 * 工具自动生成：条件实体类
 * 生成时间    : 2016/06/13 13:19:58
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 条件实体类
 * @author 工具自动生成
 * 创建时间：2016/06/13 13:19:58
 * 创建者  ：工具自动生成
 * 
 */
public class FormulasWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 公式ID	*/ 
	private BigDecimal formulaIDWhere;

	/**
	 * 公式ID取得
	 * @return formulaIDWhere
	 */
	public BigDecimal getFormulaIDWhere () {
		return formulaIDWhere;
	}

	/**
	 * 公式ID设定
	 * @param formulaIDWhere
	 */
	public void setFormulaIDWhere (BigDecimal formulaIDWhere) {
		this.formulaIDWhere = formulaIDWhere;
	}

	/* 公式名称	*/ 
	private String formulaNameWhere;

	/**
	 * 公式名称取得
	 * @return formulaNameWhere
	 */
	public String getFormulaNameWhere () {
		return formulaNameWhere;
	}

	/**
	 * 公式名称设定
	 * @param formulaNameWhere
	 */
	public void setFormulaNameWhere (String formulaNameWhere) {
		this.formulaNameWhere = formulaNameWhere;
	}

	/* 公式信息	*/ 
	private String formulaMsgWhere;

	/**
	 * 公式信息取得
	 * @return formulaMsgWhere
	 */
	public String getFormulaMsgWhere () {
		return formulaMsgWhere;
	}

	/**
	 * 公式信息设定
	 * @param formulaMsgWhere
	 */
	public void setFormulaMsgWhere (String formulaMsgWhere) {
		this.formulaMsgWhere = formulaMsgWhere;
	}

	/* 公式描述	*/ 
	private String formulaDescWhere;

	/**
	 * 公式描述取得
	 * @return formulaDescWhere
	 */
	public String getFormulaDescWhere () {
		return formulaDescWhere;
	}

	/**
	 * 公式描述设定
	 * @param formulaDescWhere
	 */
	public void setFormulaDescWhere (String formulaDescWhere) {
		this.formulaDescWhere = formulaDescWhere;
	}
}

