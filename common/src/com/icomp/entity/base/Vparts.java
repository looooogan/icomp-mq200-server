/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/03/03 16:41:44
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/03/03 16:41:44
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vparts extends VpartsWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 零部件ID	*/ 
	private String partsID;

	/**
	 * 零部件ID取得
	 * @return partsID
	 */
	public String getPartsID() {
		return partsID;
	}

	/**
	 * 零部件ID设定
	 * @param partsID
	 */
	public void setPartsID(String partsID) {
		this.partsID = partsID;
	}

	/* 零部件编码	*/ 
	private String partsCode;

	/**
	 * 零部件编码取得
	 * @return partsCode
	 */
	public String getPartsCode() {
		return partsCode;
	}

	/**
	 * 零部件编码设定
	 * @param partsCode
	 */
	public void setPartsCode(String partsCode) {
		this.partsCode = partsCode;
	}

	/* 零部件名称	*/ 
	private String partsName;

	/**
	 * 零部件名称取得
	 * @return partsName
	 */
	public String getPartsName() {
		return partsName;
	}

	/**
	 * 零部件名称设定
	 * @param partsName
	 */
	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}

	/* 零部件型号（0:1.6L,1:1.4T）	*/ 
	private String partsType;

	/**
	 * 零部件型号（0:1.6L,1:1.4T）取得
	 * @return partsType
	 */
	public String getPartsType() {
		return partsType;
	}

	/**
	 * 零部件型号（0:1.6L,1:1.4T）设定
	 * @param partsType
	 */
	public void setPartsType(String partsType) {
		this.partsType = partsType;
	}
}

