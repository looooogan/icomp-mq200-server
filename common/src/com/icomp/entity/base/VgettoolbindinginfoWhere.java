/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/03/28 16:33:58
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;



/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/03/28 16:33:58
 * 创建者  ：工具自动生成
 * 
 */
public class VgettoolbindinginfoWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* RFID载体ID	*/ 
	private String rfidContainerIDWhere;

	/**
	 * RFID载体ID取得
	 * @return rfidContainerIDWhere
	 */
	public String getRfidContainerIDWhere () {
		return rfidContainerIDWhere;
	}

	/**
	 * RFID载体ID设定
	 * @param rfidContainerIDWhere
	 */
	public void setRfidContainerIDWhere (String rfidContainerIDWhere) {
		this.rfidContainerIDWhere = rfidContainerIDWhere;
	}

	/* 激光识别码	*/ 
	private String laserIdentificationCodeWhere;

	/**
	 * 激光识别码取得
	 * @return laserIdentificationCodeWhere
	 */
	public String getLaserIdentificationCodeWhere () {
		return laserIdentificationCodeWhere;
	}

	/**
	 * 激光识别码设定
	 * @param laserIdentificationCodeWhere
	 */
	public void setLaserIdentificationCodeWhere (String laserIdentificationCodeWhere) {
		this.laserIdentificationCodeWhere = laserIdentificationCodeWhere;
	}

	/* 刀具ID	*/ 
	private String toolIDWhere;

	/**
	 * 刀具ID取得
	 * @return toolIDWhere
	 */
	public String getToolIDWhere () {
		return toolIDWhere;
	}

	/**
	 * 刀具ID设定
	 * @param toolIDWhere
	 */
	public void setToolIDWhere (String toolIDWhere) {
		this.toolIDWhere = toolIDWhere;
	}

	/* 刀具编码	*/ 
	private String toolCodeWhere;

	/**
	 * 刀具编码取得
	 * @return toolCodeWhere
	 */
	public String getToolCodeWhere () {
		return toolCodeWhere;
	}

	/**
	 * 刀具编码设定
	 * @param toolCodeWhere
	 */
	public void setToolCodeWhere (String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}
}

