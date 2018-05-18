/*
 * 工具自动生成：刀具加工条件实体类
 * 生成时间    : 2016/05/24 15:10:32
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 刀具加工条件实体类
 * @author 工具自动生成
 * 创建时间：2016/05/24 15:10:32
 * 创建者  ：工具自动生成
 * 
 */
public class ToolsmachiningWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 加工编号(年月日时分秒 14位字符串)	*/ 
	private String synthesisNumberWhere;

	/**
	 * 加工编号(年月日时分秒 14位字符串)取得
	 * @return synthesisNumberWhere
	 */
	public String getSynthesisNumberWhere () {
		return synthesisNumberWhere;
	}

	/**
	 * 加工编号(年月日时分秒 14位字符串)设定
	 * @param synthesisNumberWhere
	 */
	public void setSynthesisNumberWhere (String synthesisNumberWhere) {
		this.synthesisNumberWhere = synthesisNumberWhere;
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

	/* 流水线ID	*/ 
	private String assemblyLineIDWhere;

	/**
	 * 流水线ID取得
	 * @return assemblyLineIDWhere
	 */
	public String getAssemblyLineIDWhere () {
		return assemblyLineIDWhere;
	}

	/**
	 * 流水线ID设定
	 * @param assemblyLineIDWhere
	 */
	public void setAssemblyLineIDWhere (String assemblyLineIDWhere) {
		this.assemblyLineIDWhere = assemblyLineIDWhere;
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

	/* 轴ID	*/ 
	private String axleIDWhere;

	/**
	 * 轴ID取得
	 * @return axleIDWhere
	 */
	public String getAxleIDWhere () {
		return axleIDWhere;
	}

	/**
	 * 轴ID设定
	 * @param axleIDWhere
	 */
	public void setAxleIDWhere (String axleIDWhere) {
		this.axleIDWhere = axleIDWhere;
	}

	/* 零部件	*/ 
	private String partsIDWhere;

	/**
	 * 零部件取得
	 * @return partsIDWhere
	 */
	public String getPartsIDWhere () {
		return partsIDWhere;
	}

	/**
	 * 零部件设定
	 * @param partsIDWhere
	 */
	public void setPartsIDWhere (String partsIDWhere) {
		this.partsIDWhere = partsIDWhere;
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

	/* 操作人	*/ 
	private String outerUserWhere;

	/**
	 * 操作人取得
	 * @return outerUserWhere
	 */
	public String getOuterUserWhere () {
		return outerUserWhere;
	}

	/**
	 * 操作人设定
	 * @param outerUserWhere
	 */
	public void setOuterUserWhere (String outerUserWhere) {
		this.outerUserWhere = outerUserWhere;
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

	/* 加工数量	*/ 
	private BigDecimal processAmountWhere;

	/**
	 * 加工数量取得
	 * @return processAmountWhere
	 */
	public BigDecimal getProcessAmountWhere () {
		return processAmountWhere;
	}

	/**
	 * 加工数量设定
	 * @param processAmountWhere
	 */
	public void setProcessAmountWhere (BigDecimal processAmountWhere) {
		this.processAmountWhere = processAmountWhere;
	}

	/* 卸下确认人(不合格卸下时需要进行确认)	*/ 
	private String removeUserWhere;

	/**
	 * 卸下确认人(不合格卸下时需要进行确认)取得
	 * @return removeUserWhere
	 */
	public String getRemoveUserWhere () {
		return removeUserWhere;
	}

	/**
	 * 卸下确认人(不合格卸下时需要进行确认)设定
	 * @param removeUserWhere
	 */
	public void setRemoveUserWhere (String removeUserWhere) {
		this.removeUserWhere = removeUserWhere;
	}

	public String rfidContainerIDWhere;

	public String getRfidContainerIDWhere() {
		return rfidContainerIDWhere;
	}

	public void setRfidContainerIDWhere(String rfidContainerIDWhere) {
		this.rfidContainerIDWhere = rfidContainerIDWhere;
	}
}

