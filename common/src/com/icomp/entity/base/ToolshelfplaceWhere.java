/*
 * 工具自动生成：工具盘位置条件实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * 工具盘位置条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class ToolshelfplaceWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 工具盘位置ID	*/ 
	private String toolShelfPlaceIDWhere;

	/**
	 * 工具盘位置ID取得
	 * @return toolShelfPlaceIDWhere
	 */
	public String getToolShelfPlaceIDWhere () {
		return toolShelfPlaceIDWhere;
	}

	/**
	 * 工具盘位置ID设定
	 * @param toolShelfPlaceIDWhere
	 */
	public void setToolShelfPlaceIDWhere (String toolShelfPlaceIDWhere) {
		this.toolShelfPlaceIDWhere = toolShelfPlaceIDWhere;
	}

	/* 工具盘位置号	*/ 
	private BigDecimal placeNumberWhere;

	/**
	 * 工具盘位置号取得
	 * @return placeNumberWhere
	 */
	public BigDecimal getPlaceNumberWhere () {
		return placeNumberWhere;
	}

	/**
	 * 工具盘位置号设定
	 * @param placeNumberWhere
	 */
	public void setPlaceNumberWhere (BigDecimal placeNumberWhere) {
		this.placeNumberWhere = placeNumberWhere;
	}

	/* 工具盘位置编码	*/ 
	private String placeCodeWhere;

	/**
	 * 工具盘位置编码取得
	 * @return placeCodeWhere
	 */
	public String getPlaceCodeWhere () {
		return placeCodeWhere;
	}

	/**
	 * 工具盘位置编码设定
	 * @param placeCodeWhere
	 */
	public void setPlaceCodeWhere (String placeCodeWhere) {
		this.placeCodeWhere = placeCodeWhere;
	}
}

