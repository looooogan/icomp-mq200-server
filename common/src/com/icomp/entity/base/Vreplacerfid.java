/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/26 13:26:45
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/26 13:26:45
 * 创建者  ：杨作庆
 * 
 */
public class Vreplacerfid extends VreplacerfidWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* RFID标签ID	*/ 
	private String rfidCode;

	/**
	 * RFID标签ID取得
	 * @return rfidCode
	 */
	public String getRfidCode() {
		return rfidCode;
	}

	/**
	 * RFID标签ID设定
	 * @param rfidCode
	 */
	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}

	/* 最后执行业务流程	*/ 
	private String businessFlowLnkID;

	/**
	 * 最后执行业务流程取得
	 * @return businessFlowLnkID
	 */
	public String getBusinessFlowLnkID() {
		return businessFlowLnkID;
	}

	/**
	 * 最后执行业务流程设定
	 * @param businessFlowLnkID
	 */
	public void setBusinessFlowLnkID(String businessFlowLnkID) {
		this.businessFlowLnkID = businessFlowLnkID;
	}

	/* 刀具分类(0刀具1辅具2配套9其他）	*/ 
	private String toolType;

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）取得
	 * @return toolType
	 */
	public String getToolType() {
		return toolType;
	}

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）设定
	 * @param toolType
	 */
	public void setToolType(String toolType) {
		this.toolType = toolType;
	}
}

