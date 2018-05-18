/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/20 09:58:01
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/20 09:58:01
 * 创建者  ：杨作庆
 * 
 */
public class VprocessingtoolsWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 	*/ 
	private BigDecimal toolCountWhere;

	/**
	 * 取得
	 * @return toolCountWhere
	 */
	public BigDecimal getToolCountWhere () {
		return toolCountWhere;
	}

	/**
	 * 设定
	 * @param toolCountWhere
	 */
	public void setToolCountWhere (BigDecimal toolCountWhere) {
		this.toolCountWhere = toolCountWhere;
	}

	/* 	*/ 
	private String returnUserWhere;

	/**
	 * 取得
	 * @return returnUserWhere
	 */
	public String getReturnUserWhere () {
		return returnUserWhere;
	}

	/**
	 * 设定
	 * @param returnUserWhere
	 */
	public void setReturnUserWhere (String returnUserWhere) {
		this.returnUserWhere = returnUserWhere;
	}

	/* 送回时间	*/ 
	private Date returnTimeWhere;

	/**
	 * 送回时间取得
	 * @return returnTimeWhere
	 */
	public Date getReturnTimeWhere () {
		return returnTimeWhere;
	}

	/**
	 * 送回时间设定
	 * @param returnTimeWhere
	 */
	public void setReturnTimeWhere (Date returnTimeWhere) {
		this.returnTimeWhere = returnTimeWhere;
	}

	/* 	*/ 
	private String toolStatusWhere;

	/**
	 * 取得
	 * @return toolStatusWhere
	 */
	public String getToolStatusWhere () {
		return toolStatusWhere;
	}

	/**
	 * 设定
	 * @param toolStatusWhere
	 */
	public void setToolStatusWhere (String toolStatusWhere) {
		this.toolStatusWhere = toolStatusWhere;
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
}

