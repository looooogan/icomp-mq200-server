/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/04/16 15:48:01
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;



/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/04/16 15:48:01
 * 创建者  ：工具自动生成
 * 
 */
public class VgettoolinfolistWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 刀具状态(0断刀1丢失2不合格3待分拣4待换装,5到寿,6厂内待刃磨,7.厂外待刃磨8刃磨完毕,9其他)	*/ 
	private String toolStateWhere;

	/**
	 * 刀具状态(0断刀1丢失2不合格3待分拣4待换装,5到寿,6厂内待刃磨,7.厂外待刃磨8刃磨完毕,9其他)取得
	 * @return toolStateWhere
	 */
	public String getToolStateWhere () {
		return toolStateWhere;
	}

	/**
	 * 刀具状态(0断刀1丢失2不合格3待分拣4待换装,5到寿,6厂内待刃磨,7.厂外待刃磨8刃磨完毕,9其他)设定
	 * @param toolStateWhere
	 */
	public void setToolStateWhere (String toolStateWhere) {
		this.toolStateWhere = toolStateWhere;
	}
}

