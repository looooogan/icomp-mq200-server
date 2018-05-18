/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class VgettoolcodeandnumberbyidWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 修复通知流水号	*/ 
	private String toolRepairNoticeIDWhere;

	/**
	 * 修复通知流水号取得
	 * @return toolRepairNoticeIDWhere
	 */
	public String getToolRepairNoticeIDWhere () {
		return toolRepairNoticeIDWhere;
	}

	/**
	 * 修复通知流水号设定
	 * @param toolRepairNoticeIDWhere
	 */
	public void setToolRepairNoticeIDWhere (String toolRepairNoticeIDWhere) {
		this.toolRepairNoticeIDWhere = toolRepairNoticeIDWhere;
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

	/* 	*/ 
	private BigDecimal totalNumberWhere;

	/**
	 * 取得
	 * @return totalNumberWhere
	 */
	public BigDecimal getTotalNumberWhere () {
		return totalNumberWhere;
	}

	/**
	 * 设定
	 * @param totalNumberWhere
	 */
	public void setTotalNumberWhere (BigDecimal totalNumberWhere) {
		this.totalNumberWhere = totalNumberWhere;
	}
}

