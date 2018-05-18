/*
 * 工具自动生成：条件实体类
 * 生成时间    : 2016/05/19 09:26:16
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;



/**
 * 条件实体类
 * @author 工具自动生成
 * 创建时间：2016/05/19 09:26:16
 * 创建者  ：工具自动生成
 * 
 */
public class LeasertabeWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 激光码id	*/ 
	private String leaserIDWhere;

	/**
	 * 激光码id取得
	 * @return leaserIDWhere
	 */
	public String getLeaserIDWhere () {
		return leaserIDWhere;
	}

	/**
	 * 激光码id设定
	 * @param leaserIDWhere
	 */
	public void setLeaserIDWhere (String leaserIDWhere) {
		this.leaserIDWhere = leaserIDWhere;
	}

	/* 激光码编码	*/ 
	private String laserCodeWhere;

	/**
	 * 激光码编码取得
	 * @return laserCodeWhere
	 */
	public String getLaserCodeWhere () {
		return laserCodeWhere;
	}

	/**
	 * 激光码编码设定
	 * @param laserCodeWhere
	 */
	public void setLaserCodeWhere (String laserCodeWhere) {
		this.laserCodeWhere = laserCodeWhere;
	}

	/* 激光码状态（0 激活 1未激活）	*/ 
	private String laserStateWhere;

	/**
	 * 激光码状态（0 激活 1未激活）取得
	 * @return laserStateWhere
	 */
	public String getLaserStateWhere () {
		return laserStateWhere;
	}

	/**
	 * 激光码状态（0 激活 1未激活）设定
	 * @param laserStateWhere
	 */
	public void setLaserStateWhere (String laserStateWhere) {
		this.laserStateWhere = laserStateWhere;
	}

	/* 	*/ 
	private String rfidWhere;

	/**
	 * 取得
	 * @return rfidWhere
	 */
	public String getRfidWhere () {
		return rfidWhere;
	}

	/**
	 * 设定
	 * @param rfidWhere
	 */
	public void setRfidWhere (String rfidWhere) {
		this.rfidWhere = rfidWhere;
	}
}

