/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/12/03 15:37:51
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/12/03 15:37:51
 * 创建者  ：杨作庆
 * 
 */
public class VtoolshelfWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 工具盘ID	*/ 
	private String toolShelfIDWhere;

	/**
	 * 工具盘ID取得
	 * @return toolShelfIDWhere
	 */
	public String getToolShelfIDWhere () {
		return toolShelfIDWhere;
	}

	/**
	 * 工具盘ID设定
	 * @param toolShelfIDWhere
	 */
	public void setToolShelfIDWhere (String toolShelfIDWhere) {
		this.toolShelfIDWhere = toolShelfIDWhere;
	}

	/* 工具盘编号	*/ 
	private String toolShelfCodeWhere;

	/**
	 * 工具盘编号取得
	 * @return toolShelfCodeWhere
	 */
	public String getToolShelfCodeWhere () {
		return toolShelfCodeWhere;
	}

	/**
	 * 工具盘编号设定
	 * @param toolShelfCodeWhere
	 */
	public void setToolShelfCodeWhere (String toolShelfCodeWhere) {
		this.toolShelfCodeWhere = toolShelfCodeWhere;
	}
}

