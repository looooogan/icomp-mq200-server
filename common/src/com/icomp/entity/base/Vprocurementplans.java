/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:05
 * 创建者  ：杨作庆
 * 
 */
public class Vprocurementplans extends VprocurementplansWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 采购计划ID	*/ 
	private String procurementPlansID;

	/**
	 * 采购计划ID取得
	 * @return procurementPlansID
	 */
	public String getProcurementPlansID() {
		return procurementPlansID;
	}

	/**
	 * 采购计划ID设定
	 * @param procurementPlansID
	 */
	public void setProcurementPlansID(String procurementPlansID) {
		this.procurementPlansID = procurementPlansID;
	}

	/* 刀具ID	*/ 
	private String toolID;

	/**
	 * 刀具ID取得
	 * @return toolID
	 */
	public String getToolID() {
		return toolID;
	}

	/**
	 * 刀具ID设定
	 * @param toolID
	 */
	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	/* 采购者(关联用户ID)	*/ 
	private String procuredUser;

	/**
	 * 采购者(关联用户ID)取得
	 * @return procuredUser
	 */
	public String getProcuredUser() {
		return procuredUser;
	}

	/**
	 * 采购者(关联用户ID)设定
	 * @param procuredUser
	 */
	public void setProcuredUser(String procuredUser) {
		this.procuredUser = procuredUser;
	}

	/* 采购日期	*/ 
	private String procuredTime;

	/**
	 * 采购日期取得
	 * @return procuredTime
	 */
	public String getProcuredTime() {
		return procuredTime;
	}

	/**
	 * 采购日期设定
	 * @param procuredTime
	 */
	public void setProcuredTime(String procuredTime) {
		this.procuredTime = procuredTime;
	}
}

