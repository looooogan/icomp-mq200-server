/*
 * 工具自动生成：条件实体类
 * 生成时间    : 2016/02/26 11:55:25
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 条件实体类
 * @author 工具自动生成
 * 创建时间：2016/02/26 11:55:25
 * 创建者  ：工具自动生成
 * 
 */
public class SynthesistoolsmachiningWhere extends BaseEntity implements Serializable {

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

	/*  合成刀具编码(系统唯一)	*/ 
	private String synthesisParametersCodeWhere;

	/**
	 *  合成刀具编码(系统唯一)取得
	 * @return synthesisParametersCodeWhere
	 */
	public String getSynthesisParametersCodeWhere () {
		return synthesisParametersCodeWhere;
	}

	/**
	 *  合成刀具编码(系统唯一)设定
	 * @param synthesisParametersCodeWhere
	 */
	public void setSynthesisParametersCodeWhere (String synthesisParametersCodeWhere) {
		this.synthesisParametersCodeWhere = synthesisParametersCodeWhere;
	}

	/* 合成刀具编号(例如：001、002、003)	*/ 
	private String synthesisParametersNumberWhere;

	/**
	 * 合成刀具编号(例如：001、002、003)取得
	 * @return synthesisParametersNumberWhere
	 */
	public String getSynthesisParametersNumberWhere () {
		return synthesisParametersNumberWhere;
	}

	/**
	 * 合成刀具编号(例如：001、002、003)设定
	 * @param synthesisParametersNumberWhere
	 */
	public void setSynthesisParametersNumberWhere (String synthesisParametersNumberWhere) {
		this.synthesisParametersNumberWhere = synthesisParametersNumberWhere;
	}

	/* 零部件ID（卸下设备后插入）	*/ 
	private String partsIDWhere;

	/**
	 * 零部件ID（卸下设备后插入）取得
	 * @return partsIDWhere
	 */
	public String getPartsIDWhere () {
		return partsIDWhere;
	}

	/**
	 * 零部件ID（卸下设备后插入）设定
	 * @param partsIDWhere
	 */
	public void setPartsIDWhere (String partsIDWhere) {
		this.partsIDWhere = partsIDWhere;
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

	/* 装入时间	*/ 
	private Date loadTimeWhere;

	/**
	 * 装入时间取得
	 * @return loadTimeWhere
	 */
	public Date getLoadTimeWhere () {
		return loadTimeWhere;
	}

	/**
	 * 装入时间设定
	 * @param loadTimeWhere
	 */
	public void setLoadTimeWhere (Date loadTimeWhere) {
		this.loadTimeWhere = loadTimeWhere;
	}

	/* 操作人	*/ 
	private String loadUserWhere;

	/**
	 * 操作人取得
	 * @return loadUserWhere
	 */
	public String getLoadUserWhere () {
		return loadUserWhere;
	}

	/**
	 * 操作人设定
	 * @param loadUserWhere
	 */
	public void setLoadUserWhere (String loadUserWhere) {
		this.loadUserWhere = loadUserWhere;
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

	/* 卸下人	*/ 
	private String outerUserWhere;

	/**
	 * 卸下人取得
	 * @return outerUserWhere
	 */
	public String getOuterUserWhere () {
		return outerUserWhere;
	}

	/**
	 * 卸下人设定
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

	private String rfidContainerIDWhere;


	public String getRfidContainerIDWhere() {
		return rfidContainerIDWhere;
	}

	public void setRfidContainerIDWhere(String rfidContainerIDWhere) {
		this.rfidContainerIDWhere = rfidContainerIDWhere;
	}
}

