/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/08/15 14:40:51
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/08/15 14:40:51
 * 创建者  ：工具自动生成
 * 
 */
public class VtoolshertoolWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 	*/ 
	private String toolIDWhere;

	/**
	 * 取得
	 * @return toolIDWhere
	 */
	public String getToolIDWhere () {
		return toolIDWhere;
	}

	/**
	 * 设定
	 * @param toolIDWhere
	 */
	public void setToolIDWhere (String toolIDWhere) {
		this.toolIDWhere = toolIDWhere;
	}

	/* 	*/ 
	private String toolCodeWhere;

	/**
	 * 取得
	 * @return toolCodeWhere
	 */
	public String getToolCodeWhere () {
		return toolCodeWhere;
	}

	/**
	 * 设定
	 * @param toolCodeWhere
	 */
	public void setToolCodeWhere (String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}

	/* 	*/ 
	private String toolDurableWhere;

	/**
	 * 取得
	 * @return toolDurableWhere
	 */
	public String getToolDurableWhere () {
		return toolDurableWhere;
	}

	/**
	 * 设定
	 * @param toolDurableWhere
	 */
	public void setToolDurableWhere (String toolDurableWhere) {
		this.toolDurableWhere = toolDurableWhere;
	}

	/* 	*/ 
	private BigDecimal toolMaxWhere;

	/**
	 * 取得
	 * @return toolMaxWhere
	 */
	public BigDecimal getToolMaxWhere () {
		return toolMaxWhere;
	}

	/**
	 * 设定
	 * @param toolMaxWhere
	 */
	public void setToolMaxWhere (BigDecimal toolMaxWhere) {
		this.toolMaxWhere = toolMaxWhere;
	}

	/* 	*/ 
	private BigDecimal toolMinWhere;

	/**
	 * 取得
	 * @return toolMinWhere
	 */
	public BigDecimal getToolMinWhere () {
		return toolMinWhere;
	}

	/**
	 * 设定
	 * @param toolMinWhere
	 */
	public void setToolMinWhere (BigDecimal toolMinWhere) {
		this.toolMinWhere = toolMinWhere;
	}
}

