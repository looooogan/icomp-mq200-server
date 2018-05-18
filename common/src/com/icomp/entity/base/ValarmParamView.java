/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;

import com.icomp.common.entity.BaseEntity;


/**
 * 手写,用于首页显示
 * @author 
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class ValarmParamView extends BaseEntity   implements Serializable {

	private static final long serialVersionUID = 1L;
	/* 刀具编码	*/ 
	private String toolCode;
	/* 刀具名称	*/ 
	private String toolName;
	/* 刀具告警参数	*/ 
	private String toolAlarmParam;
	/* 刀具告警类别	*/ 
	private String toolAlarmType;
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	public String getToolName() {
		return toolName;
	}
	public void setToolName(String toolName) {
		this.toolName = toolName;
	}
	public String getToolAlarmParam() {
		return toolAlarmParam;
	}
	public void setToolAlarmParam(String toolAlarmParam) {
		this.toolAlarmParam = toolAlarmParam;
	}
	public String getToolAlarmType() {
		return toolAlarmType;
	}
	public void setToolAlarmType(String toolAlarmType) {
		this.toolAlarmType = toolAlarmType;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

