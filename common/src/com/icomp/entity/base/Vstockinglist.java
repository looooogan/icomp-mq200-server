/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:05
 * 创建者  ：杨作庆
 * 
 */
public class Vstockinglist extends VstockinglistWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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
	private String libCode;

	/**
	 * 取得
	 * @return libCode
	 */
	public String getlibCode() {
		return libCode;
	}

	/**
	 * 设定
	 * @param libCode
	 */
	public void setlibCode(String libCode) {
		this.libCode = libCode;
	}

	/* 	*/ 
	private String toolType;

	/**
	 * 取得
	 * @return toolType
	 */
	public String getToolType() {
		return toolType;
	}

	/**
	 * 设定
	 * @param toolType
	 */
	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

	/* 	*/ 
	private String rfidCode;

	/**
	 * 取得
	 * @return rfidCode
	 */
	public String getRfidCode() {
		return rfidCode;
	}

	/**
	 * 设定
	 * @param rfidCode
	 */
	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}

	/* 	*/ 
	private String queryType;

	/**
	 * 取得
	 * @return queryType
	 */
	public String getQueryType() {
		return queryType;
	}

	/**
	 * 设定
	 * @param queryType
	 */
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	
	private int toolCount;

	public int getToolCount() {
		return toolCount;
	}

	public void setToolCount(int toolCount) {
		this.toolCount = toolCount;
	}
}

