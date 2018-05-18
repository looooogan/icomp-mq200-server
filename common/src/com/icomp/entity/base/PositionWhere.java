/*
 * 工具自动生成：职务条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * 职务条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class PositionWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 职务ID	*/ 
	private String positionIDWhere;

	/**
	 * 职务ID取得
	 * @return positionIDWhere
	 */
	public String getPositionIDWhere () {
		return positionIDWhere;
	}

	/**
	 * 职务ID设定
	 * @param positionIDWhere
	 */
	public void setPositionIDWhere (String positionIDWhere) {
		this.positionIDWhere = positionIDWhere;
	}

	/* 语言编码	*/ 
	private String languageCodeWhere;

	/**
	 * 语言编码取得
	 * @return languageCodeWhere
	 */
	public String getLanguageCodeWhere () {
		return languageCodeWhere;
	}

	/**
	 * 语言编码设定
	 * @param languageCodeWhere
	 */
	public void setLanguageCodeWhere (String languageCodeWhere) {
		this.languageCodeWhere = languageCodeWhere;
	}

	/* 职务编码	*/ 
	private String positionCodeWhere;

	/**
	 * 职务编码取得
	 * @return positionCodeWhere
	 */
	public String getPositionCodeWhere () {
		return positionCodeWhere;
	}

	/**
	 * 职务编码设定
	 * @param positionCodeWhere
	 */
	public void setPositionCodeWhere (String positionCodeWhere) {
		this.positionCodeWhere = positionCodeWhere;
	}

	/* 职务名称	*/ 
	private String positionNameWhere;

	/**
	 * 职务名称取得
	 * @return positionNameWhere
	 */
	public String getPositionNameWhere () {
		return positionNameWhere;
	}

	/**
	 * 职务名称设定
	 * @param positionNameWhere
	 */
	public void setPositionNameWhere (String positionNameWhere) {
		this.positionNameWhere = positionNameWhere;
	}
}

