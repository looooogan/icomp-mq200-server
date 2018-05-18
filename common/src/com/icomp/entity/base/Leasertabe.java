/*
 * 工具自动生成：实体类
 * 生成时间    : 2016/05/19 09:26:16
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * 实体类
 * @author 工具自动生成
 * 创建时间：2016/05/19 09:26:16
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Leasertabe extends LeasertabeWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 激光码id	*/ 
	private String leaserID;

	/**
	 * 激光码id取得
	 * @return leaserID
	 */
	public String getLeaserID() {
		return leaserID;
	}

	/**
	 * 激光码id设定
	 * @param leaserID
	 */
	public void setLeaserID(String leaserID) {
		this.leaserID = leaserID;
	}

	/* 激光码编码	*/ 
	private String laserCode;

	/**
	 * 激光码编码取得
	 * @return laserCode
	 */
	public String getLaserCode() {
		return laserCode;
	}

	/**
	 * 激光码编码设定
	 * @param laserCode
	 */
	public void setLaserCode(String laserCode) {
		this.laserCode = laserCode;
	}

	/* 激光码状态（0 激活 1未激活）	*/ 
	private String laserState;

	/**
	 * 激光码状态（0 激活 1未激活）取得
	 * @return laserState
	 */
	public String getLaserState() {
		return laserState;
	}

	/**
	 * 激光码状态（0 激活 1未激活）设定
	 * @param laserState
	 */
	public void setLaserState(String laserState) {
		this.laserState = laserState;
	}

	/* 	*/ 
	private String rfid;

	/**
	 * 取得
	 * @return rfid
	 */
	public String getRfid() {
		return rfid;
	}

	/**
	 * 设定
	 * @param rfid
	 */
	public void setRfid(String rfid) {
		this.rfid = rfid;
	}
}

