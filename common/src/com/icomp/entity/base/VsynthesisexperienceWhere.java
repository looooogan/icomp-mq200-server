/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/21 10:16:00
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/21 10:16:00
 * 创建者  ：杨作庆
 * 
 */
public class VsynthesisexperienceWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 合成刀具编码(系统唯一)	*/ 
	private String synthesisParametersCodeWhere;

	/**
	 * 合成刀具编码(系统唯一)取得
	 * @return synthesisParametersCodeWhere
	 */
	public String getSynthesisParametersCodeWhere () {
		return synthesisParametersCodeWhere;
	}

	/**
	 * 合成刀具编码(系统唯一)设定
	 * @param synthesisParametersCodeWhere
	 */
	public void setSynthesisParametersCodeWhere (String synthesisParametersCodeWhere) {
		this.synthesisParametersCodeWhere = synthesisParametersCodeWhere;
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

	/* 	*/ 
	private BigDecimal busStatesWhere;

	/**
	 * 取得
	 * @return busStatesWhere
	 */
	public BigDecimal getbusStatesWhere () {
		return busStatesWhere;
	}

	/**
	 * 设定
	 * @param busStatesWhere
	 */
	public void setbusStatesWhere (BigDecimal busStatesWhere) {
		this.busStatesWhere = busStatesWhere;
	}

	/* 业务流程名	*/ 
	private String businessNameWhere;

	/**
	 * 业务流程名取得
	 * @return businessNameWhere
	 */
	public String getBusinessNameWhere () {
		return businessNameWhere;
	}

	/**
	 * 业务流程名设定
	 * @param businessNameWhere
	 */
	public void setBusinessNameWhere (String businessNameWhere) {
		this.businessNameWhere = businessNameWhere;
	}

	/* 	*/ 
	private String upBusinessNameWhere;

	/**
	 * 取得
	 * @return upBusinessNameWhere
	 */
	public String getUpBusinessNameWhere () {
		return upBusinessNameWhere;
	}

	/**
	 * 设定
	 * @param upBusinessNameWhere
	 */
	public void setUpBusinessNameWhere (String upBusinessNameWhere) {
		this.upBusinessNameWhere = upBusinessNameWhere;
	}

	/* 	*/ 
	private String downBusinessNameWhere;

	/**
	 * 取得
	 * @return downBusinessNameWhere
	 */
	public String getDownBusinessNameWhere () {
		return downBusinessNameWhere;
	}

	/**
	 * 设定
	 * @param downBusinessNameWhere
	 */
	public void setDownBusinessNameWhere (String downBusinessNameWhere) {
		this.downBusinessNameWhere = downBusinessNameWhere;
	}
}

