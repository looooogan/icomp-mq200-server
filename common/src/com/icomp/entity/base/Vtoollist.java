/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/10/09 18:37:22
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/10/09 18:37:22
 * 创建者  ：杨作庆
 * 
 */
public class Vtoollist extends VtoollistWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 	*/ 
	private String cutterType;

	/**
	 * 取得
	 * @return cutterType
	 */
	public String getCutterType() {
		return cutterType;
	}

	/**
	 * 设定
	 * @param cutterType
	 */
	public void setCutterType(String cutterType) {
		this.cutterType = cutterType;
	}

	/* 	*/ 
	private String toolCode;

	/**
	 * 取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 	*/ 
	private String synthesisParametersCode;

	/**
	 * 取得
	 * @return synthesisParametersCode
	 */
	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	/**
	 * 设定
	 * @param synthesisParametersCode
	 */
	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}

	/* 	*/ 
	private String rFID;

	/**
	 * 取得
	 * @return rFID
	 */
	public String getrFID() {
		return rFID;
	}

	/**
	 * 设定
	 * @param rFID
	 */
	public void setrFID(String rFID) {
		this.rFID = rFID;
	}
}

