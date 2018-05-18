/*
 * 工具自动生成：工具盘位置信息条件实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * 工具盘位置信息条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class ToolshelflnkWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* ToolShelfLnkID	*/ 
	private String toolShelfLnkIDWhere;

	/**
	 * ToolShelfLnkID取得
	 * @return toolShelfLnkIDWhere
	 */
	public String getToolShelfLnkIDWhere () {
		return toolShelfLnkIDWhere;
	}

	/**
	 * ToolShelfLnkID设定
	 * @param toolShelfLnkIDWhere
	 */
	public void setToolShelfLnkIDWhere (String toolShelfLnkIDWhere) {
		this.toolShelfLnkIDWhere = toolShelfLnkIDWhere;
	}

	/* 	*/ 
	private String toolShelfPlaceNumberWhere;

	/**
	 * 取得
	 * @return toolShelfPlaceNumberWhere
	 */
	public String getToolShelfPlaceNumberWhere () {
		return toolShelfPlaceNumberWhere;
	}

	/**
	 * 设定
	 * @param toolShelfPlaceNumberWhere
	 */
	public void setToolShelfPlaceNumberWhere (String toolShelfPlaceNumberWhere) {
		this.toolShelfPlaceNumberWhere = toolShelfPlaceNumberWhere;
	}

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

	/* 刀具入库编码	*/ 
	private String knifeInventoryCodeWhere;

	/**
	 * 刀具入库编码取得
	 * @return knifeInventoryCodeWhere
	 */
	public String getKnifeInventoryCodeWhere () {
		return knifeInventoryCodeWhere;
	}

	/**
	 * 刀具入库编码设定
	 * @param knifeInventoryCodeWhere
	 */
	public void setKnifeInventoryCodeWhere (String knifeInventoryCodeWhere) {
		this.knifeInventoryCodeWhere = knifeInventoryCodeWhere;
	}
}

