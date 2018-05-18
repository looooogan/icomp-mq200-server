/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/03/25 15:26:55
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;

import java.util.Date;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/03/25 15:26:55
 * 创建者  ：工具自动生成
 * 
 */
public class VanalysisWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 零部件ID	*/ 
	private String partsIDWhere;

	/**
	 * 零部件ID取得
	 * @return partsIDWhere
	 */
	public String getPartsIDWhere () {
		return partsIDWhere;
	}

	/**
	 * 零部件ID设定
	 * @param partsIDWhere
	 */
	public void setPartsIDWhere (String partsIDWhere) {
		this.partsIDWhere = partsIDWhere;
	}

	/* 零部件名称	*/ 
	private String partsNameWhere;

	/**
	 * 零部件名称取得
	 * @return partsNameWhere
	 */
	public String getPartsNameWhere () {
		return partsNameWhere;
	}

	/**
	 * 零部件名称设定
	 * @param partsNameWhere
	 */
	public void setPartsNameWhere (String partsNameWhere) {
		this.partsNameWhere = partsNameWhere;
	}

	/* 工序ID	*/ 
	private String processIDWhere;

	/**
	 * 工序ID取得
	 * @return processIDWhere
	 */
	public String getProcessIDWhere () {
		return processIDWhere;
	}

	/**
	 * 工序ID设定
	 * @param processIDWhere
	 */
	public void setProcessIDWhere (String processIDWhere) {
		this.processIDWhere = processIDWhere;
	}

	/* 工序名称	*/ 
	private String processNameWhere;

	/**
	 * 工序名称取得
	 * @return processNameWhere
	 */
	public String getProcessNameWhere () {
		return processNameWhere;
	}

	/**
	 * 工序名称设定
	 * @param processNameWhere
	 */
	public void setProcessNameWhere (String processNameWhere) {
		this.processNameWhere = processNameWhere;
	}

	/* 设备ID	*/ 
	private String equipmentIDWhere;

	/**
	 * 设备ID取得
	 * @return equipmentIDWhere
	 */
	public String getEquipmentIDWhere () {
		return equipmentIDWhere;
	}

	/**
	 * 设备ID设定
	 * @param equipmentIDWhere
	 */
	public void setEquipmentIDWhere (String equipmentIDWhere) {
		this.equipmentIDWhere = equipmentIDWhere;
	}

	/* 设备名称	*/ 
	private String equipmentNameWhere;

	/**
	 * 设备名称取得
	 * @return equipmentNameWhere
	 */
	public String getEquipmentNameWhere () {
		return equipmentNameWhere;
	}

	/**
	 * 设备名称设定
	 * @param equipmentNameWhere
	 */
	public void setEquipmentNameWhere (String equipmentNameWhere) {
		this.equipmentNameWhere = equipmentNameWhere;
	}

	/* 卸下时间	*/ 
	private Date outerTimeWhere;

	/**
	 * 卸下时间取得
	 * @return outerTimeWhere
	 */
	public Date getOuterTimeWhere () {
		return outerTimeWhere;
	}

	/**
	 * 卸下时间设定
	 * @param outerTimeWhere
	 */
	public void setOuterTimeWhere (Date outerTimeWhere) {
		this.outerTimeWhere = outerTimeWhere;
	}

	/* 卸下原因(0正常卸下1打刀2不合格9其他)(可维护)	*/ 
	private String removeReasonWhere;

	/**
	 * 卸下原因(0正常卸下1打刀2不合格9其他)(可维护)取得
	 * @return removeReasonWhere
	 */
	public String getRemoveReasonWhere () {
		return removeReasonWhere;
	}

	/**
	 * 卸下原因(0正常卸下1打刀2不合格9其他)(可维护)设定
	 * @param removeReasonWhere
	 */
	public void setRemoveReasonWhere (String removeReasonWhere) {
		this.removeReasonWhere = removeReasonWhere;
	}

	/* 	*/ 
	private String outerUserWhere;

	/**
	 * 取得
	 * @return outerUserWhere
	 */
	public String getOuterUserWhere () {
		return outerUserWhere;
	}

	/**
	 * 设定
	 * @param outerUserWhere
	 */
	public void setOuterUserWhere (String outerUserWhere) {
		this.outerUserWhere = outerUserWhere;
	}
}

