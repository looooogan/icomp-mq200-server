/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class VpositionWhere extends BaseEntity implements Serializable {

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
	private String positionLanguageCodeWhere;

	/**
	 * 语言编码取得
	 * @return positionLanguageCodeWhere
	 */
	public String getPositionLanguageCodeWhere () {
		return positionLanguageCodeWhere;
	}

	/**
	 * 语言编码设定
	 * @param positionLanguageCodeWhere
	 */
	public void setPositionLanguageCodeWhere (String positionLanguageCodeWhere) {
		this.positionLanguageCodeWhere = positionLanguageCodeWhere;
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

	/* 部门ID	*/ 
	private String departmentIDWhere;

	/**
	 * 部门ID取得
	 * @return departmentIDWhere
	 */
	public String getDepartmentIDWhere () {
		return departmentIDWhere;
	}

	/**
	 * 部门ID设定
	 * @param departmentIDWhere
	 */
	public void setDepartmentIDWhere (String departmentIDWhere) {
		this.departmentIDWhere = departmentIDWhere;
	}
}

