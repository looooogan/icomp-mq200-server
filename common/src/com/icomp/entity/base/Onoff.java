/*
 * 工具自动生成：实体类
 * 生成时间    : 2016/06/30 10:29:47
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 实体类
 * @author 工具自动生成
 * 创建时间：2016/06/30 10:29:47
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Onoff extends OnoffWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 授权开关id	*/ 
	private String onOffID;

	/**
	 * 授权开关id取得
	 * @return onOffID
	 */
	public String getOnOffID() {
		return onOffID;
	}

	/**
	 * 授权开关id设定
	 * @param onOffID
	 */
	public void setOnOffID(String onOffID) {
		this.onOffID = onOffID;
	}

	/* 授权开关名称	*/ 
	private String onOffName;

	/**
	 * 授权开关名称取得
	 * @return onOffName
	 */
	public String getOnOffName() {
		return onOffName;
	}

	/**
	 * 授权开关名称设定
	 * @param onOffName
	 */
	public void setOnOffName(String onOffName) {
		this.onOffName = onOffName;
	}

	/* 授权开关编码	*/ 
	private String onOffCode;

	/**
	 * 授权开关编码取得
	 * @return onOffCode
	 */
	public String getOnOffCode() {
		return onOffCode;
	}

	/**
	 * 授权开关编码设定
	 * @param onOffCode
	 */
	public void setOnOffCode(String onOffCode) {
		this.onOffCode = onOffCode;
	}

	/* 授权开关备注	*/ 
	private String onOffNoed;

	/**
	 * 授权开关备注取得
	 * @return onOffNoed
	 */
	public String getOnOffNoed() {
		return onOffNoed;
	}

	/**
	 * 授权开关备注设定
	 * @param onOffNoed
	 */
	public void setOnOffNoed(String onOffNoed) {
		this.onOffNoed = onOffNoed;
	}

	/* 授权开关状态	*/ 
	private BigDecimal onOffState;

	/**
	 * 授权开关状态取得
	 * @return onOffState
	 */
	public BigDecimal getOnOffState() {
		return onOffState;
	}

	/**
	 * 授权开关状态设定
	 * @param onOffState
	 */
	public void setOnOffState(BigDecimal onOffState) {
		this.onOffState = onOffState;
	}
}

