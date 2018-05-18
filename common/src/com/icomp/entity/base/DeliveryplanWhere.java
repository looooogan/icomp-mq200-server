/*
 * 工具自动生成：到货计划条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 到货计划条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class DeliveryplanWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 	*/ 
	private String deliveryPlanIDWhere;

	/**
	 * 取得
	 * @return deliveryPlanIDWhere
	 */
	public String getDeliveryPlanIDWhere () {
		return deliveryPlanIDWhere;
	}

	/**
	 * 设定
	 * @param deliveryPlanIDWhere
	 */
	public void setDeliveryPlanIDWhere (String deliveryPlanIDWhere) {
		this.deliveryPlanIDWhere = deliveryPlanIDWhere;
	}

	/* 采购ID	*/ 
	private String toolProcuredIDWhere;

	/**
	 * 采购ID取得
	 * @return toolProcuredIDWhere
	 */
	public String getToolProcuredIDWhere () {
		return toolProcuredIDWhere;
	}

	/**
	 * 采购ID设定
	 * @param toolProcuredIDWhere
	 */
	public void setToolProcuredIDWhere (String toolProcuredIDWhere) {
		this.toolProcuredIDWhere = toolProcuredIDWhere;
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

	/* 预计到货数量	*/ 
	private BigDecimal theyCountWhere;

	/**
	 * 预计到货数量取得
	 * @return theyCountWhere
	 */
	public BigDecimal getTheyCountWhere () {
		return theyCountWhere;
	}

	/**
	 * 预计到货数量设定
	 * @param theyCountWhere
	 */
	public void setTheyCountWhere (BigDecimal theyCountWhere) {
		this.theyCountWhere = theyCountWhere;
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

	/* 到货交接人	*/ 
	private String transferPeopleWhere;

	/**
	 * 到货交接人取得
	 * @return transferPeopleWhere
	 */
	public String getTransferPeopleWhere () {
		return transferPeopleWhere;
	}

	/**
	 * 到货交接人设定
	 * @param transferPeopleWhere
	 */
	public void setTransferPeopleWhere (String transferPeopleWhere) {
		this.transferPeopleWhere = transferPeopleWhere;
	}

	/* 质检人	*/ 
	private String inspectionUserWhere;

	/**
	 * 质检人取得
	 * @return inspectionUserWhere
	 */
	public String getInspectionUserWhere () {
		return inspectionUserWhere;
	}

	/**
	 * 质检人设定
	 * @param inspectionUserWhere
	 */
	public void setInspectionUserWhere (String inspectionUserWhere) {
		this.inspectionUserWhere = inspectionUserWhere;
	}
}

