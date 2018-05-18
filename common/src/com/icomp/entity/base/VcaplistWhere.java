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
public class VcaplistWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 功能ID	*/ 
	private String capabilityIDWhere;

	/**
	 * 功能ID取得
	 * @return capabilityIDWhere
	 */
	public String getCapabilityIDWhere () {
		return capabilityIDWhere;
	}

	/**
	 * 功能ID设定
	 * @param capabilityIDWhere
	 */
	public void setCapabilityIDWhere (String capabilityIDWhere) {
		this.capabilityIDWhere = capabilityIDWhere;
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

