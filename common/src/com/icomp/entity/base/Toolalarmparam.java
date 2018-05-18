/*
 * 工具自动生成：刀具告警参数
实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 刀具告警参数
实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class Toolalarmparam extends ToolalarmparamWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 	*/ 
	private String toolAlarmParamID;

	/**
	 * 取得
	 * @return toolAlarmParamID
	 */
	public String getToolAlarmParamID() {
		return toolAlarmParamID;
	}

	/**
	 * 设定
	 * @param toolAlarmParamID
	 */
	public void setToolAlarmParamID(String toolAlarmParamID) {
		this.toolAlarmParamID = toolAlarmParamID;
	}

	/* 告警类别(0库存异常报警1在途计划报警2加工异常报警)	*/ 
	private String toolAlarmType;

	/**
	 * 告警类别(0库存异常报警1在途计划报警2加工异常报警)取得
	 * @return toolAlarmType
	 */
	public String getToolAlarmType() {
		return toolAlarmType;
	}

	/**
	 * 告警类别(0库存异常报警1在途计划报警2加工异常报警)设定
	 * @param toolAlarmType
	 */
	public void setToolAlarmType(String toolAlarmType) {
		this.toolAlarmType = toolAlarmType;
	}

	/* 告警系数	*/ 
	private BigDecimal toolAlarmRatio;

	/**
	 * 告警系数取得
	 * @return toolAlarmRatio
	 */
	public BigDecimal getToolAlarmRatio() {
		return toolAlarmRatio;
	}

	/**
	 * 告警系数设定
	 * @param toolAlarmRatio
	 */
	public void setToolAlarmRatio(BigDecimal toolAlarmRatio) {
		this.toolAlarmRatio = toolAlarmRatio;
	}

	/* 操作人	*/ 
	private String systemLogUser;

	/**
	 * 操作人取得
	 * @return systemLogUser
	 */
	public String getSystemLogUser() {
		return systemLogUser;
	}

	/**
	 * 操作人设定
	 * @param systemLogUser
	 */
	public void setSystemLogUser(String systemLogUser) {
		this.systemLogUser = systemLogUser;
	}
}

