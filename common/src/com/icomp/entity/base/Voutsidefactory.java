/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/05/09 17:49:35
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/05/09 17:49:35
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Voutsidefactory extends VoutsidefactoryWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 厂外修复ID	*/ 
	private String outsideFactoryID;

	/**
	 * 厂外修复ID取得
	 * @return outsideFactoryID
	 */
	public String getOutsideFactoryID() {
		return outsideFactoryID;
	}

	/**
	 * 厂外修复ID设定
	 * @param outsideFactoryID
	 */
	public void setOutsideFactoryID(String outsideFactoryID) {
		this.outsideFactoryID = outsideFactoryID;
	}

	/* 通知单号	*/ 
	private String orderNum;

	/**
	 * 通知单号取得
	 * @return orderNum
	 */
	public String getOrderNum() {
		return orderNum;
	}

	/**
	 * 通知单号设定
	 * @param orderNum
	 */
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	/* 刀具编码	*/ 
	private String toolCode;

	/**
	 * 刀具编码取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 刀具编码设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 商家ID	*/ 
	private String merchantsID;

	/**
	 * 商家ID取得
	 * @return merchantsID
	 */
	public String getMerchantsID() {
		return merchantsID;
	}

	/**
	 * 商家ID设定
	 * @param merchantsID
	 */
	public void setMerchantsID(String merchantsID) {
		this.merchantsID = merchantsID;
	}

	/* 商家名称	*/ 
	private String merchantsName;

	/**
	 * 商家名称取得
	 * @return merchantsName
	 */
	public String getMerchantsName() {
		return merchantsName;
	}

	/**
	 * 商家名称设定
	 * @param merchantsName
	 */
	public void setMerchantsName(String merchantsName) {
		this.merchantsName = merchantsName;
	}

	/* 修磨数量	*/ 
	private BigDecimal numberGrinding;

	/**
	 * 修磨数量取得
	 * @return numberGrinding
	 */
	public BigDecimal getNumberGrinding() {
		return numberGrinding;
	}

	/**
	 * 修磨数量设定
	 * @param numberGrinding
	 */
	public void setNumberGrinding(BigDecimal numberGrinding) {
		this.numberGrinding = numberGrinding;
	}

	/* 修复类型（0.厂外图层1.厂外复磨）	*/ 
	private String grindingType;

	/**
	 * 修复类型（0.厂外图层1.厂外复磨）取得
	 * @return grindingType
	 */
	public String getGrindingType() {
		return grindingType;
	}

	/**
	 * 修复类型（0.厂外图层1.厂外复磨）设定
	 * @param grindingType
	 */
	public void setGrindingType(String grindingType) {
		this.grindingType = grindingType;
	}

	/* 修复状态(0.未修复1.已修复2.其他）	*/ 
	private String repairState;

	/**
	 * 修复状态(0.未修复1.已修复2.其他）取得
	 * @return repairState
	 */
	public String getRepairState() {
		return repairState;
	}

	/**
	 * 修复状态(0.未修复1.已修复2.其他）设定
	 * @param repairState
	 */
	public void setRepairState(String repairState) {
		this.repairState = repairState;
	}

	/* 出厂日期	*/ 
	private Date manufactureDate;

	/**
	 * 出厂日期取得
	 * @return manufactureDate
	 */
	public Date getManufactureDate() {
		return manufactureDate;
	}

	/**
	 * 出厂日期设定
	 * @param manufactureDate
	 */
	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	/* 审批人	*/ 
	private String approverouser;

	/**
	 * 审批人取得
	 * @return approverouser
	 */
	public String getApproverouser() {
		return approverouser;
	}

	/**
	 * 审批人设定
	 * @param approverouser
	 */
	public void setApproverouser(String approverouser) {
		this.approverouser = approverouser;
	}

	/* 备注	*/ 
	private String note;

	/**
	 * 备注取得
	 * @return note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * 备注设定
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
	}
}

