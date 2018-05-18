/*
 * 工具自动生成：实体类
 * 生成时间    : 2016/06/13 13:19:58
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 实体类
 * @author 工具自动生成
 * 创建时间：2016/06/13 13:19:58
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Formulas extends FormulasWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 公式ID	*/ 
	private BigDecimal formulaID;

	/**
	 * 公式ID取得
	 * @return formulaID
	 */
	public BigDecimal getFormulaID() {
		return formulaID;
	}

	/**
	 * 公式ID设定
	 * @param formulaID
	 */
	public void setFormulaID(BigDecimal formulaID) {
		this.formulaID = formulaID;
	}

	/* 公式名称	*/ 
	private String formulaName;

	/**
	 * 公式名称取得
	 * @return formulaName
	 */
	public String getFormulaName() {
		return formulaName;
	}

	/**
	 * 公式名称设定
	 * @param formulaName
	 */
	public void setFormulaName(String formulaName) {
		this.formulaName = formulaName;
	}

	/* 公式信息	*/ 
	private String formulaMsg;

	/**
	 * 公式信息取得
	 * @return formulaMsg
	 */
	public String getFormulaMsg() {
		return formulaMsg;
	}

	/**
	 * 公式信息设定
	 * @param formulaMsg
	 */
	public void setFormulaMsg(String formulaMsg) {
		this.formulaMsg = formulaMsg;
	}

	/* 公式描述	*/ 
	private String formulaDesc;

	/**
	 * 公式描述取得
	 * @return formulaDesc
	 */
	public String getFormulaDesc() {
		return formulaDesc;
	}

	/**
	 * 公式描述设定
	 * @param formulaDesc
	 */
	public void setFormulaDesc(String formulaDesc) {
		this.formulaDesc = formulaDesc;
	}
}

