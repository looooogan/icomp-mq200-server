/*
 * 工具自动生成：条件实体类
 * 生成时间    : 2016/03/03 10:24:38
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;




/**
 * 条件实体类
 * @author 工具自动生成
 * 创建时间：2016/03/03 10:24:38
 * 创建者  ：工具自动生成
 * 
 */
public class AxleWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 轴ID	*/ 
	private String axleIDWhere;

	/**
	 * 轴ID取得
	 * @return axleIDWhere
	 */
	public String getAxleIDWhere () {
		return axleIDWhere;
	}

	/**
	 * 轴ID设定
	 * @param axleIDWhere
	 */
	public void setAxleIDWhere (String axleIDWhere) {
		this.axleIDWhere = axleIDWhere;
	}

	/* 轴编码	*/ 
	private String axleCodeWhere;

	/**
	 * 轴编码取得
	 * @return axleCodeWhere
	 */
	public String getAxleCodeWhere () {
		return axleCodeWhere;
	}

	/**
	 * 轴编码设定
	 * @param axleCodeWhere
	 */
	public void setAxleCodeWhere (String axleCodeWhere) {
		this.axleCodeWhere = axleCodeWhere;
	}

	/* 轴名称	*/ 
	private String axleNameWhere;

	/**
	 * 轴名称取得
	 * @return axleNameWhere
	 */
	public String getAxleNameWhere () {
		return axleNameWhere;
	}

	/**
	 * 轴名称设定
	 * @param axleNameWhere
	 */
	public void setAxleNameWhere (String axleNameWhere) {
		this.axleNameWhere = axleNameWhere;
	}
}

