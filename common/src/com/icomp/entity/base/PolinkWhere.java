/*
 * 工具自动生成：职务-操作条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.util.Date;


/**
 * 职务-操作条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class PolinkWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* PoLinkID	*/ 
	private String poLinkIDWhere;

	/**
	 * PoLinkID取得
	 * @return poLinkIDWhere
	 */
	public String getPoLinkIDWhere () {
		return poLinkIDWhere;
	}

	/**
	 * PoLinkID设定
	 * @param poLinkIDWhere
	 */
	public void setPoLinkIDWhere (String poLinkIDWhere) {
		this.poLinkIDWhere = poLinkIDWhere;
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

	/* 权限开始时间	*/ 
	private Date gstrDateWhere;

	/**
	 * 权限开始时间取得
	 * @return gstrDateWhere
	 */
	public Date getGstrDateWhere () {
		return gstrDateWhere;
	}

	/**
	 * 权限开始时间设定
	 * @param gstrDateWhere
	 */
	public void setGstrDateWhere (Date gstrDateWhere) {
		this.gstrDateWhere = gstrDateWhere;
	}

	/* 权限开始时间	*/ 
	private Date gendDateWhere;

	/**
	 * 权限开始时间取得
	 * @return gendDateWhere
	 */
	public Date getGendDateWhere () {
		return gendDateWhere;
	}

	/**
	 * 权限开始时间设定
	 * @param gendDateWhere
	 */
	public void setGendDateWhere (Date gendDateWhere) {
		this.gendDateWhere = gendDateWhere;
	}
}

