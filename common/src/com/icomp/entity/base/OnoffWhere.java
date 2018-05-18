/*
 * 工具自动生成：条件实体类
 * 生成时间    : 2016/06/30 10:29:47
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 条件实体类
 * @author 工具自动生成
 * 创建时间：2016/06/30 10:29:47
 * 创建者  ：工具自动生成
 * 
 */
public class OnoffWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 授权开关id	*/ 
	private String onOffIDWhere;

	/**
	 * 授权开关id取得
	 * @return onOffIDWhere
	 */
	public String getOnOffIDWhere () {
		return onOffIDWhere;
	}

	/**
	 * 授权开关id设定
	 * @param onOffIDWhere
	 */
	public void setOnOffIDWhere (String onOffIDWhere) {
		this.onOffIDWhere = onOffIDWhere;
	}

	/* 授权开关名称	*/ 
	private String onOffNameWhere;

	/**
	 * 授权开关名称取得
	 * @return onOffNameWhere
	 */
	public String getOnOffNameWhere () {
		return onOffNameWhere;
	}

	/**
	 * 授权开关名称设定
	 * @param onOffNameWhere
	 */
	public void setOnOffNameWhere (String onOffNameWhere) {
		this.onOffNameWhere = onOffNameWhere;
	}

	/* 授权开关编码	*/ 
	private String onOffCodeWhere;

	/**
	 * 授权开关编码取得
	 * @return onOffCodeWhere
	 */
	public String getOnOffCodeWhere () {
		return onOffCodeWhere;
	}

	/**
	 * 授权开关编码设定
	 * @param onOffCodeWhere
	 */
	public void setOnOffCodeWhere (String onOffCodeWhere) {
		this.onOffCodeWhere = onOffCodeWhere;
	}

	/* 授权开关备注	*/ 
	private String onOffNoedWhere;

	/**
	 * 授权开关备注取得
	 * @return onOffNoedWhere
	 */
	public String getOnOffNoedWhere () {
		return onOffNoedWhere;
	}

	/**
	 * 授权开关备注设定
	 * @param onOffNoedWhere
	 */
	public void setOnOffNoedWhere (String onOffNoedWhere) {
		this.onOffNoedWhere = onOffNoedWhere;
	}

	/* 授权开关状态	*/ 
	private BigDecimal onOffStateWhere;

	/**
	 * 授权开关状态取得
	 * @return onOffStateWhere
	 */
	public BigDecimal getOnOffStateWhere () {
		return onOffStateWhere;
	}

	/**
	 * 授权开关状态设定
	 * @param onOffStateWhere
	 */
	public void setOnOffStateWhere (BigDecimal onOffStateWhere) {
		this.onOffStateWhere = onOffStateWhere;
	}
}

