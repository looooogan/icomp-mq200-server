/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/26 13:26:45
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/26 13:26:45
 * 创建者  ：杨作庆
 * 
 */
public class VreplacerfidWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* RFID标签ID	*/ 
	private String rfidCodeWhere;

	/**
	 * RFID标签ID取得
	 * @return rfidCodeWhere
	 */
	public String getRfidCodeWhere () {
		return rfidCodeWhere;
	}

	/**
	 * RFID标签ID设定
	 * @param rfidCodeWhere
	 */
	public void setRfidCodeWhere (String rfidCodeWhere) {
		this.rfidCodeWhere = rfidCodeWhere;
	}

	/* 最后执行业务流程	*/ 
	private String businessFlowLnkIDWhere;

	/**
	 * 最后执行业务流程取得
	 * @return businessFlowLnkIDWhere
	 */
	public String getBusinessFlowLnkIDWhere () {
		return businessFlowLnkIDWhere;
	}

	/**
	 * 最后执行业务流程设定
	 * @param businessFlowLnkIDWhere
	 */
	public void setBusinessFlowLnkIDWhere (String businessFlowLnkIDWhere) {
		this.businessFlowLnkIDWhere = businessFlowLnkIDWhere;
	}

	/* 刀具分类(0刀具1辅具2配套9其他）	*/ 
	private String toolTypeWhere;

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）取得
	 * @return toolTypeWhere
	 */
	public String getToolTypeWhere () {
		return toolTypeWhere;
	}

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）设定
	 * @param toolTypeWhere
	 */
	public void setToolTypeWhere (String toolTypeWhere) {
		this.toolTypeWhere = toolTypeWhere;
	}
}

