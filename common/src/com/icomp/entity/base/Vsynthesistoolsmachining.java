/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2015/03/11 17:50:19
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2015/03/11 17:50:19
 * 创建者  ：杨作庆
 * 
 */
public class Vsynthesistoolsmachining extends VsynthesistoolsmachiningWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 加工数量	*/ 
	private BigDecimal processAmount;

	/**
	 * 加工数量取得
	 * @return processAmount
	 */
	public BigDecimal getProcessAmount() {
		return processAmount;
	}

	/**
	 * 加工数量设定
	 * @param processAmount
	 */
	public void setProcessAmount(BigDecimal processAmount) {
		this.processAmount = processAmount;
	}
	/**
	 * 按年统计
	 */
	private String  year;
	/**
	 * 按月统计
	 */
	private String  month;
	/**
	 * 按周统计
	 */
	private String  week;
	/**
	 * 按天统计
	 */
	private String  day;
	/**
	 * 起始时间
	 */
	private String  beginTime;
	/**
	 * 结束时间
	 */
	private String  endTime;
	
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	//统计类型
	private String summary;
	private String outDate;

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
		
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	/* 卸下时间	*/ 
	private Date outerTime;

	/**
	 * 卸下时间取得
	 * @return outerTime
	 */
	public Date getOuterTime() {
		return outerTime;
	}

	/**
	 * 卸下时间设定
	 * @param outerTime
	 */
	public void setOuterTime(Date outerTime) {
		this.outerTime = outerTime;
	}

	/* 合成刀具编码(系统唯一)	*/ 
	private String synthesisParametersCode;

	/**
	 * 合成刀具编码(系统唯一)取得
	 * @return synthesisParametersCode
	 */
	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	/**
	 * 合成刀具编码(系统唯一)设定
	 * @param synthesisParametersCode
	 */
	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}

	/* 设备ID	*/ 
	private String equipmentID;

	/**
	 * 设备ID取得
	 * @return equipmentID
	 */
	public String getEquipmentID() {
		return equipmentID;
	}

	/**
	 * 设备ID设定
	 * @param equipmentID
	 */
	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}

	/* 流水线ID	*/ 
	private String assemblyLineID;

	/**
	 * 流水线ID取得
	 * @return assemblyLineID
	 */
	public String getAssemblyLineID() {
		return assemblyLineID;
	}

	/**
	 * 流水线ID设定
	 * @param assemblyLineID
	 */
	public void setAssemblyLineID(String assemblyLineID) {
		this.assemblyLineID = assemblyLineID;
	}

	/* 设备编码	*/ 
	private String equipmentCode;

	/**
	 * 设备编码取得
	 * @return equipmentCode
	 */
	public String getEquipmentCode() {
		return equipmentCode;
	}

	/**
	 * 设备编码设定
	 * @param equipmentCode
	 */
	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}

	/* 设备名称	*/ 
	private String equipmentName;

	/**
	 * 设备名称取得
	 * @return equipmentName
	 */
	public String getEquipmentName() {
		return equipmentName;
	}

	/**
	 * 设备名称设定
	 * @param equipmentName
	 */
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	/* 流水线编码	*/ 
	private String assemblyLineCode;

	/**
	 * 流水线编码取得
	 * @return assemblyLineCode
	 */
	public String getAssemblyLineCode() {
		return assemblyLineCode;
	}

	/**
	 * 流水线编码设定
	 * @param assemblyLineCode
	 */
	public void setAssemblyLineCode(String assemblyLineCode) {
		this.assemblyLineCode = assemblyLineCode;
	}

	/* 流水线名称	*/ 
	private String assemblyLineName;

	/**
	 * 流水线名称取得
	 * @return assemblyLineName
	 */
	public String getAssemblyLineName() {
		return assemblyLineName;
	}

	/**
	 * 流水线名称设定
	 * @param assemblyLineName
	 */
	public void setAssemblyLineName(String assemblyLineName) {
		this.assemblyLineName = assemblyLineName;
	}
}

