/*
 * 工具自动生成：刀具告警参数
条件实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * 刀具告警参数
条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class ToolalarmparamWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 	*/ 
	private String toolAlarmParamIDWhere;

	/**
	 * 取得
	 * @return toolAlarmParamIDWhere
	 */
	public String getToolAlarmParamIDWhere () {
		return toolAlarmParamIDWhere;
	}

	/**
	 * 设定
	 * @param toolAlarmParamIDWhere
	 */
	public void setToolAlarmParamIDWhere (String toolAlarmParamIDWhere) {
		this.toolAlarmParamIDWhere = toolAlarmParamIDWhere;
	}

	/* 告警类别(0库存异常报警1在途计划报警2加工异常报警)	*/ 
	private String toolAlarmTypeWhere;

	/**
	 * 告警类别(0库存异常报警1在途计划报警2加工异常报警)取得
	 * @return toolAlarmTypeWhere
	 */
	public String getToolAlarmTypeWhere () {
		return toolAlarmTypeWhere;
	}

	/**
	 * 告警类别(0库存异常报警1在途计划报警2加工异常报警)设定
	 * @param toolAlarmTypeWhere
	 */
	public void setToolAlarmTypeWhere (String toolAlarmTypeWhere) {
		this.toolAlarmTypeWhere = toolAlarmTypeWhere;
	}

	/* 告警系数	*/ 
	private BigDecimal toolAlarmRatioWhere;

	/**
	 * 告警系数取得
	 * @return toolAlarmRatioWhere
	 */
	public BigDecimal getToolAlarmRatioWhere () {
		return toolAlarmRatioWhere;
	}

	/**
	 * 告警系数设定
	 * @param toolAlarmRatioWhere
	 */
	public void setToolAlarmRatioWhere (BigDecimal toolAlarmRatioWhere) {
		this.toolAlarmRatioWhere = toolAlarmRatioWhere;
	}

	/* 操作人	*/ 
	private String systemLogUserWhere;

	/**
	 * 操作人取得
	 * @return systemLogUserWhere
	 */
	public String getSystemLogUserWhere () {
		return systemLogUserWhere;
	}

	/**
	 * 操作人设定
	 * @param systemLogUserWhere
	 */
	public void setSystemLogUserWhere (String systemLogUserWhere) {
		this.systemLogUserWhere = systemLogUserWhere;
	}
}

