/*
 * 工具自动生成：工具盘实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * 工具盘实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class Toolshelf extends ToolshelfWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 工具盘编号	*/ 
	private String toolShelfCode;

	/**
	 * 工具盘编号取得
	 * @return toolShelfCode
	 */
	public String getToolShelfCode() {
		return toolShelfCode;
	}

	/**
	 * 工具盘编号设定
	 * @param toolShelfCode
	 */
	public void setToolShelfCode(String toolShelfCode) {
		this.toolShelfCode = toolShelfCode;
	}
}

