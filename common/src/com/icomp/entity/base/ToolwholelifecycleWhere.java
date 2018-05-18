/*
 * 工具自动生成：刀具全生命周期条件实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * 刀具全生命周期条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class ToolwholelifecycleWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;
	//加工数量
	private String processAmount;

	public String getProcessAmount() {
		return processAmount;
	}

	public void setProcessAmount(String processAmount) {
		this.processAmount = processAmount;
	}

	/* 刀具全生命周期ID	*/
	private String toolWholeLifecycleIDWhere;

	/**
	 * 刀具全生命周期ID取得
	 * @return toolWholeLifecycleIDWhere
	 */
	public String getToolWholeLifecycleIDWhere () {
		return toolWholeLifecycleIDWhere;
	}

	/**
	 * 刀具全生命周期ID设定
	 * @param toolWholeLifecycleIDWhere
	 */
	public void setToolWholeLifecycleIDWhere (String toolWholeLifecycleIDWhere) {
		this.toolWholeLifecycleIDWhere = toolWholeLifecycleIDWhere;
	}
	/* 刀具全生命周期ID	*/
	private String toolIDWhere;

	public String getToolIDWhere() {
		return toolIDWhere;
	}

	public void setToolIDWhere(String toolIDWhere) {
		this.toolIDWhere = toolIDWhere;
	}
	private String partsID;

	public String getPartsID() {
		return partsID;
	}

	public void setPartsID(String partsID) {
		this.partsID = partsID;
	}

	/* 业务-流程中间表ID	*/
	private String businessFlowLnkIDWhere;

	/**
	 * 业务-流程中间表ID取得
	 * @return businessFlowLnkIDWhere
	 */
	public String getBusinessFlowLnkIDWhere () {
		return businessFlowLnkIDWhere;
	}

	/**
	 * 业务-流程中间表ID设定
	 * @param businessFlowLnkIDWhere
	 */
	public void setBusinessFlowLnkIDWhere (String businessFlowLnkIDWhere) {
		this.businessFlowLnkIDWhere = businessFlowLnkIDWhere;
	}

	/* 操作手持机	*/ 
	private String handSetIDWhere;

	/**
	 * 操作手持机取得
	 * @return handSetIDWhere
	 */
	public String getHandSetIDWhere () {
		return handSetIDWhere;
	}

	/**
	 * 操作手持机设定
	 * @param handSetIDWhere
	 */
	public void setHandSetIDWhere (String handSetIDWhere) {
		this.handSetIDWhere = handSetIDWhere;
	}

	/* 刀具名称	*/ 
	private String toolNameWhere;

	/**
	 * 刀具名称取得
	 * @return toolNameWhere
	 */
	public String getToolNameWhere () {
		return toolNameWhere;
	}

	/**
	 * 刀具名称设定
	 * @param toolNameWhere
	 */
	public void setToolNameWhere (String toolNameWhere) {
		this.toolNameWhere = toolNameWhere;
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

	/* 刀具入库编码	*/ 
	private String knifeInventoryCodeWhere;

	/**
	 * 刀具入库编码取得
	 * @return knifeInventoryCodeWhere
	 */
	public String getKnifeInventoryCodeWhere () {
		return knifeInventoryCodeWhere;
	}

	/**
	 * 刀具入库编码设定
	 * @param knifeInventoryCodeWhere
	 */
	public void setKnifeInventoryCodeWhere (String knifeInventoryCodeWhere) {
		this.knifeInventoryCodeWhere = knifeInventoryCodeWhere;
	}
}

