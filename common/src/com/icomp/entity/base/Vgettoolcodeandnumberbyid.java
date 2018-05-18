/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class Vgettoolcodeandnumberbyid extends VgettoolcodeandnumberbyidWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 修复通知流水号	*/ 
	private String toolRepairNoticeID;

	/**
	 * 修复通知流水号取得
	 * @return toolRepairNoticeID
	 */
	public String getToolRepairNoticeID() {
		return toolRepairNoticeID;
	}

	/**
	 * 修复通知流水号设定
	 * @param toolRepairNoticeID
	 */
	public void setToolRepairNoticeID(String toolRepairNoticeID) {
		this.toolRepairNoticeID = toolRepairNoticeID;
	}

	/* 刀具编码	*/ 
	private String toolCode;

	/**
	 * 刀具编码取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 刀具编码设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 	*/ 
	private BigDecimal totalNumber;

	/**
	 * 取得
	 * @return totalNumber
	 */
	public BigDecimal getTotalNumber() {
		return totalNumber;
	}

	/**
	 * 设定
	 * @param totalNumber
	 */
	public void setTotalNumber(BigDecimal totalNumber) {
		this.totalNumber = totalNumber;
	}
}

