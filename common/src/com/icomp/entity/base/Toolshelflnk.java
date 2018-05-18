/*
 * 工具自动生成：工具盘位置信息实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * 工具盘位置信息实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class Toolshelflnk extends ToolshelflnkWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* ToolShelfLnkID	*/ 
	private String toolShelfLnkID;

	/**
	 * ToolShelfLnkID取得
	 * @return toolShelfLnkID
	 */
	public String getToolShelfLnkID() {
		return toolShelfLnkID;
	}

	/**
	 * ToolShelfLnkID设定
	 * @param toolShelfLnkID
	 */
	public void setToolShelfLnkID(String toolShelfLnkID) {
		this.toolShelfLnkID = toolShelfLnkID;
	}

	/* 	*/ 
	private String toolShelfPlaceNumber;

	/**
	 * 取得
	 * @return toolShelfPlaceNumber
	 */
	public String getToolShelfPlaceNumber() {
		return toolShelfPlaceNumber;
	}

	/**
	 * 设定
	 * @param toolShelfPlaceNumber
	 */
	public void setToolShelfPlaceNumber(String toolShelfPlaceNumber) {
		this.toolShelfPlaceNumber = toolShelfPlaceNumber;
	}

	/* 工具盘ID	*/ 
	private String toolShelfID;

	/**
	 * 工具盘ID取得
	 * @return toolShelfID
	 */
	public String getToolShelfID() {
		return toolShelfID;
	}

	/**
	 * 工具盘ID设定
	 * @param toolShelfID
	 */
	public void setToolShelfID(String toolShelfID) {
		this.toolShelfID = toolShelfID;
	}

	/* 刀具入库编码	*/ 
	private String knifeInventoryCode;

	/**
	 * 刀具入库编码取得
	 * @return knifeInventoryCode
	 */
	public String getKnifeInventoryCode() {
		return knifeInventoryCode;
	}

	/**
	 * 刀具入库编码设定
	 * @param knifeInventoryCode
	 */
	public void setKnifeInventoryCode(String knifeInventoryCode) {
		this.knifeInventoryCode = knifeInventoryCode;
	}
}

