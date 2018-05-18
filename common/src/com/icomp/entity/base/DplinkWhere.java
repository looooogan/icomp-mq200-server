/*
 * 工具自动生成：部门-职务中间表条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * 部门-职务中间表条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class DplinkWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* dpLinkID	*/ 
	private String dpLinkIDWhere;

	/**
	 * dpLinkID取得
	 * @return dpLinkIDWhere
	 */
	public String getdpLinkIDWhere () {
		return dpLinkIDWhere;
	}

	/**
	 * dpLinkID设定
	 * @param dpLinkIDWhere
	 */
	public void setdpLinkIDWhere (String dpLinkIDWhere) {
		this.dpLinkIDWhere = dpLinkIDWhere;
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
}

