/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:05
 * 创建者  ：杨作庆
 * 
 */
public class VprocurementplansWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 采购计划ID	*/ 
	private String procurementPlansIDWhere;

	/**
	 * 采购计划ID取得
	 * @return procurementPlansIDWhere
	 */
	public String getProcurementPlansIDWhere () {
		return procurementPlansIDWhere;
	}

	/**
	 * 采购计划ID设定
	 * @param procurementPlansIDWhere
	 */
	public void setProcurementPlansIDWhere (String procurementPlansIDWhere) {
		this.procurementPlansIDWhere = procurementPlansIDWhere;
	}

	/* 刀具ID	*/ 
	private String toolIDWhere;

	/**
	 * 刀具ID取得
	 * @return toolIDWhere
	 */
	public String getToolIDWhere () {
		return toolIDWhere;
	}

	/**
	 * 刀具ID设定
	 * @param toolIDWhere
	 */
	public void setToolIDWhere (String toolIDWhere) {
		this.toolIDWhere = toolIDWhere;
	}

	/* 采购者(关联用户ID)	*/ 
	private String procuredUserWhere;

	/**
	 * 采购者(关联用户ID)取得
	 * @return procuredUserWhere
	 */
	public String getProcuredUserWhere () {
		return procuredUserWhere;
	}

	/**
	 * 采购者(关联用户ID)设定
	 * @param procuredUserWhere
	 */
	public void setProcuredUserWhere (String procuredUserWhere) {
		this.procuredUserWhere = procuredUserWhere;
	}

	/* 采购日期	*/ 
	private String procuredTimeWhere;

	/**
	 * 采购日期取得
	 * @return procuredTimeWhere
	 */
	public String getProcuredTimeWhere () {
		return procuredTimeWhere;
	}

	/**
	 * 采购日期设定
	 * @param procuredTimeWhere
	 */
	public void setProcuredTimeWhere (String procuredTimeWhere) {
		this.procuredTimeWhere = procuredTimeWhere;
	}
}

