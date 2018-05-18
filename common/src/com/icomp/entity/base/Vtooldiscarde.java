/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/20 13:12:40
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/20 13:12:40
 * 创建者  ：杨作庆
 * 
 */
public class Vtooldiscarde extends VtooldiscardeWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他	*/ 
	private String toolConsumetype;

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他取得
	 * @return toolConsumetype
	 */
	public String getToolConsumetype() {
		return toolConsumetype;
	}

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他设定
	 * @param toolConsumetype
	 */
	public void setToolConsumetype(String toolConsumetype) {
		this.toolConsumetype = toolConsumetype;
	}

	/* 	*/ 
	private BigDecimal toolCount;

	

	/* 报废确认区分(0未确认1已确认)	*/ 
	private String discardeFlag;

	private String discardeTime;

	public BigDecimal getToolCount() {
		return toolCount;
	}

	public void setToolCount(BigDecimal toolCount) {
		this.toolCount = toolCount;
	}

	public String getDiscardeFlag() {
		return discardeFlag;
	}

	public void setDiscardeFlag(String discardeFlag) {
		this.discardeFlag = discardeFlag;
	}

	public String getDiscardeTime() {
		return discardeTime;
	}

	public void setDiscardeTime(String discardeTime) {
		this.discardeTime = discardeTime;
	}
	
	/* 区分文本	*/ 
	private String toolConsumetypeText;

	/**
	 * 区分文本取得
	 * @return toolConsumetypeText
	 */
	public String getToolConsumetypeText() {
		return toolConsumetypeText;
	}

	/**
	 * 区分文本设定
	 * @param toolConsumetypeText
	 */
	public void setToolConsumetypeText(String toolConsumetypeText) {
		this.toolConsumetypeText = toolConsumetypeText;
	}
}

