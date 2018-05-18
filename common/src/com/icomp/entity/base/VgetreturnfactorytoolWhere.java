/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class VgetreturnfactorytoolWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* RFID标签ID	*/ 
	private String rfidCodeWhere;

	/**
	 * RFID标签ID取得
	 * @return rfidCodeWhere
	 */
	public String getRfidCodeWhere () {
		return rfidCodeWhere;
	}

	/**
	 * RFID标签ID设定
	 * @param rfidCodeWhere
	 */
	public void setRfidCodeWhere (String rfidCodeWhere) {
		this.rfidCodeWhere = rfidCodeWhere;
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

	/* 刀具名称	*/ 
	private String toolNameWhere;

	/**
	 * 刀具名称取得
	 * @return toolNameWhere
	 */
	public String getToolNameWhere () {
		return toolNameWhere;
	}

	/**
	 * 刀具名称设定
	 * @param toolNameWhere
	 */
	public void setToolNameWhere (String toolNameWhere) {
		this.toolNameWhere = toolNameWhere;
	}

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

	/* 	*/ 
	private BigDecimal thisCountWhere;

	/**
	 * 取得
	 * @return thisCountWhere
	 */
	public BigDecimal getthisCountWhere () {
		return thisCountWhere;
	}

	/**
	 * 设定
	 * @param thisCountWhere
	 */
	public void setthisCountWhere (BigDecimal thisCountWhere) {
		this.thisCountWhere = thisCountWhere;
	}

	/* 	*/ 
	private BigDecimal inventoryCountWhere;

	/**
	 * 取得
	 * @return inventoryCountWhere
	 */
	public BigDecimal getInventoryCountWhere () {
		return inventoryCountWhere;
	}

	/**
	 * 设定
	 * @param inventoryCountWhere
	 */
	public void setInventoryCountWhere (BigDecimal inventoryCountWhere) {
		this.inventoryCountWhere = inventoryCountWhere;
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

	/* 	*/ 
	private String userNameWhere;

	/**
	 * 取得
	 * @return userNameWhere
	 */
	public String getUserNameWhere () {
		return userNameWhere;
	}

	/**
	 * 设定
	 * @param userNameWhere
	 */
	public void setUserNameWhere (String userNameWhere) {
		this.userNameWhere = userNameWhere;
	}
}

