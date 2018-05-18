/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/21 10:16:00
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/21 10:16:00
 * 创建者  ：杨作庆
 * 
 */
public class Vsynthesisexperience extends VsynthesisexperienceWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 业务-流程中间表ID	*/ 
	private String businessFlowLnkID;

	/**
	 * 业务-流程中间表ID取得
	 * @return businessFlowLnkID
	 */
	public String getBusinessFlowLnkID() {
		return businessFlowLnkID;
	}

	/**
	 * 业务-流程中间表ID设定
	 * @param businessFlowLnkID
	 */
	public void setBusinessFlowLnkID(String businessFlowLnkID) {
		this.businessFlowLnkID = businessFlowLnkID;
	}

	/* 	*/ 
	private BigDecimal busStates;

	/**
	 * 取得
	 * @return busStates
	 */
	public BigDecimal getbusStates() {
		return busStates;
	}

	/**
	 * 设定
	 * @param busStates
	 */
	public void setbusStates(BigDecimal busStates) {
		this.busStates = busStates;
	}

	/* 业务流程名	*/ 
	private String businessName;

	/**
	 * 业务流程名取得
	 * @return businessName
	 */
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * 业务流程名设定
	 * @param businessName
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/* 	*/ 
	private String upBusinessName;

	/**
	 * 取得
	 * @return upBusinessName
	 */
	public String getUpBusinessName() {
		return upBusinessName;
	}

	/**
	 * 设定
	 * @param upBusinessName
	 */
	public void setUpBusinessName(String upBusinessName) {
		this.upBusinessName = upBusinessName;
	}

	/* 	*/ 
	private String downBusinessName;

	/**
	 * 取得
	 * @return downBusinessName
	 */
	public String getDownBusinessName() {
		return downBusinessName;
	}

	/**
	 * 设定
	 * @param downBusinessName
	 */
	public void setDownBusinessName(String downBusinessName) {
		this.downBusinessName = downBusinessName;
	}
}

