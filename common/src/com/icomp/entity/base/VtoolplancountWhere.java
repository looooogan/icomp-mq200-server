/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/22 13:55:41
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/22 13:55:41
 * 创建者  ：杨作庆
 * 
 */
public class VtoolplancountWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具编码	*/ 
	private String toolCodeWhere;

	/* 	*/ 
	private BigDecimal planCountWhere;

	/* 	*/ 
	private BigDecimal subCountWhere;

	public String getToolCodeWhere() {
		return toolCodeWhere;
	}

	public void setToolCodeWhere(String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}

	public BigDecimal getPlanCountWhere() {
		return planCountWhere;
	}

	public void setPlanCountWhere(BigDecimal planCountWhere) {
		this.planCountWhere = planCountWhere;
	}

	public BigDecimal getSubCountWhere() {
		return subCountWhere;
	}

	public void setSubCountWhere(BigDecimal subCountWhere) {
		this.subCountWhere = subCountWhere;
	}

}

