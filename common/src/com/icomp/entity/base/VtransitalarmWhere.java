/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:05
 * 创建者  ：杨作庆
 * 
 */
public class VtransitalarmWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 采购批次	*/ 
	private String procuredBatchWhere;

	/**
	 * 采购批次取得
	 * @return procuredBatchWhere
	 */
	public String getProcuredBatchWhere () {
		return procuredBatchWhere;
	}

	/**
	 * 采购批次设定
	 * @param procuredBatchWhere
	 */
	public void setProcuredBatchWhere (String procuredBatchWhere) {
		this.procuredBatchWhere = procuredBatchWhere;
	}

	/* 预计到货时间	*/ 
	private Date theyTimeWhere;

	/**
	 * 预计到货时间取得
	 * @return theyTimeWhere
	 */
	public Date getTheyTimeWhere () {
		return theyTimeWhere;
	}

	/**
	 * 预计到货时间设定
	 * @param theyTimeWhere
	 */
	public void setTheyTimeWhere (Date theyTimeWhere) {
		this.theyTimeWhere = theyTimeWhere;
	}

	/* 	*/ 
	private BigDecimal theyCountWhere;

	/**
	 * 取得
	 * @return theyCountWhere
	 */
	public BigDecimal getTheyCountWhere () {
		return theyCountWhere;
	}

	/**
	 * 设定
	 * @param theyCountWhere
	 */
	public void setTheyCountWhere (BigDecimal theyCountWhere) {
		this.theyCountWhere = theyCountWhere;
	}

	/* 货品状态(0未到货1已到货2质检通过3质检未通过)	*/ 
	private String theyStatusWhere;

	/**
	 * 货品状态(0未到货1已到货2质检通过3质检未通过)取得
	 * @return theyStatusWhere
	 */
	public String getTheyStatusWhere () {
		return theyStatusWhere;
	}

	/**
	 * 货品状态(0未到货1已到货2质检通过3质检未通过)设定
	 * @param theyStatusWhere
	 */
	public void setTheyStatusWhere (String theyStatusWhere) {
		this.theyStatusWhere = theyStatusWhere;
	}

	/* 实际到货时间	*/ 
	private Date realityTheyTimeWhere;

	/**
	 * 实际到货时间取得
	 * @return realityTheyTimeWhere
	 */
	public Date getRealityTheyTimeWhere () {
		return realityTheyTimeWhere;
	}

	/**
	 * 实际到货时间设定
	 * @param realityTheyTimeWhere
	 */
	public void setRealityTheyTimeWhere (Date realityTheyTimeWhere) {
		this.realityTheyTimeWhere = realityTheyTimeWhere;
	}

	/* 实际到货数量	*/ 
	private BigDecimal realityTheyCountWhere;

	/**
	 * 实际到货数量取得
	 * @return realityTheyCountWhere
	 */
	public BigDecimal getRealityTheyCountWhere () {
		return realityTheyCountWhere;
	}

	/**
	 * 实际到货数量设定
	 * @param realityTheyCountWhere
	 */
	public void setRealityTheyCountWhere (BigDecimal realityTheyCountWhere) {
		this.realityTheyCountWhere = realityTheyCountWhere;
	}
}

