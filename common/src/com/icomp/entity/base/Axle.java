/*
 * 工具自动生成：实体类
 * 生成时间    : 2016/03/03 10:24:38
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * 实体类
 * @author 工具自动生成
 * 创建时间：2016/03/03 10:24:38
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Axle extends AxleWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 轴ID	*/ 
	private String axleID;

	/**
	 * 轴ID取得
	 * @return axleID
	 */
	public String getAxleID() {
		return axleID;
	}

	/**
	 * 轴ID设定
	 * @param axleID
	 */
	public void setAxleID(String axleID) {
		this.axleID = axleID;
	}

	/* 轴编码	*/ 
	private String axleCode;

	/**
	 * 轴编码取得
	 * @return axleCode
	 */
	public String getAxleCode() {
		return axleCode;
	}

	/**
	 * 轴编码设定
	 * @param axleCode
	 */
	public void setAxleCode(String axleCode) {
		this.axleCode = axleCode;
	}

	/* 轴名称	*/ 
	private String axleName;

	/**
	 * 轴名称取得
	 * @return axleName
	 */
	public String getAxleName() {
		return axleName;
	}

	/**
	 * 轴名称设定
	 * @param axleName
	 */
	public void setAxleName(String axleName) {
		this.axleName = axleName;
	}
}

