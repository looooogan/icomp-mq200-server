/*
 * 工具自动生成：厂外修复表条件实体类
 * 生成时间    : 2016/02/25 19:22:51
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 厂外修复表条件实体类
 * @author 工具自动生成
 * 创建时间：2016/02/25 19:22:51
 * 创建者  ：工具自动生成
 * 
 */
public class OutsidefactoryWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 厂外修复ID	*/ 
	private String outsideFactoryIDWhere;

	/**
	 * 厂外修复ID取得
	 * @return outsideFactoryIDWhere
	 */
	public String getOutsideFactoryIDWhere () {
		return outsideFactoryIDWhere;
	}

	/**
	 * 厂外修复ID设定
	 * @param outsideFactoryIDWhere
	 */
	public void setOutsideFactoryIDWhere (String outsideFactoryIDWhere) {
		this.outsideFactoryIDWhere = outsideFactoryIDWhere;
	}

	/* 通知单号	*/ 
	private String orderNumWhere;

	/**
	 * 通知单号取得
	 * @return orderNumWhere
	 */
	public String getOrderNumWhere () {
		return orderNumWhere;
	}

	/**
	 * 通知单号设定
	 * @param orderNumWhere
	 */
	public void setOrderNumWhere (String orderNumWhere) {
		this.orderNumWhere = orderNumWhere;
	}

	/* 商家ID	*/ 
	private String merchantsIDWhere;

	/**
	 * 商家ID取得
	 * @return merchantsIDWhere
	 */
	public String getMerchantsIDWhere () {
		return merchantsIDWhere;
	}

	/**
	 * 商家ID设定
	 * @param merchantsIDWhere
	 */
	public void setMerchantsIDWhere (String merchantsIDWhere) {
		this.merchantsIDWhere = merchantsIDWhere;
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

	/* 材料号	*/ 
	private String materialNumWhere;

	/**
	 * 材料号取得
	 * @return materialNumWhere
	 */
	public String getMaterialNumWhere () {
		return materialNumWhere;
	}

	/**
	 * 材料号设定
	 * @param materialNumWhere
	 */
	public void setMaterialNumWhere (String materialNumWhere) {
		this.materialNumWhere = materialNumWhere;
	}

	/* 修磨数量	*/ 
	private BigDecimal numberGrindingWhere;

	/**
	 * 修磨数量取得
	 * @return numberGrindingWhere
	 */
	public BigDecimal getNumberGrindingWhere () {
		return numberGrindingWhere;
	}

	/**
	 * 修磨数量设定
	 * @param numberGrindingWhere
	 */
	public void setNumberGrindingWhere (BigDecimal numberGrindingWhere) {
		this.numberGrindingWhere = numberGrindingWhere;
	}

	/* 修复类型（0.厂外图层1.厂外复磨）	*/ 
	private String grindingTypeWhere;

	/**
	 * 修复类型（0.厂外图层1.厂外复磨）取得
	 * @return grindingTypeWhere
	 */
	public String getGrindingTypeWhere () {
		return grindingTypeWhere;
	}

	/**
	 * 修复类型（0.厂外图层1.厂外复磨）设定
	 * @param grindingTypeWhere
	 */
	public void setGrindingTypeWhere (String grindingTypeWhere) {
		this.grindingTypeWhere = grindingTypeWhere;
	}

	/* 激光码	*/ 
	private String laserCodeWhere;

	/**
	 * 激光码取得
	 * @return laserCodeWhere
	 */
	public String getLaserCodeWhere () {
		return laserCodeWhere;
	}

	/**
	 * 激光码设定
	 * @param laserCodeWhere
	 */
	public void setLaserCodeWhere (String laserCodeWhere) {
		this.laserCodeWhere = laserCodeWhere;
	}

	/* 刀具类型（0.钻头1.刀片	*/ 
	private String toolTypeWhere;

	/**
	 * 刀具类型（0.钻头1.刀片取得
	 * @return toolTypeWhere
	 */
	public String getToolTypeWhere () {
		return toolTypeWhere;
	}

	/**
	 * 刀具类型（0.钻头1.刀片设定
	 * @param toolTypeWhere
	 */
	public void setToolTypeWhere (String toolTypeWhere) {
		this.toolTypeWhere = toolTypeWhere;
	}

	/* 出厂日期	*/ 
	private Date manufactureDateWhere;

	/**
	 * 出厂日期取得
	 * @return manufactureDateWhere
	 */
	public Date getManufactureDateWhere () {
		return manufactureDateWhere;
	}

	/**
	 * 出厂日期设定
	 * @param manufactureDateWhere
	 */
	public void setManufactureDateWhere (Date manufactureDateWhere) {
		this.manufactureDateWhere = manufactureDateWhere;
	}

	/* 审批人	*/ 
	private String approverWhere;

	/**
	 * 审批人取得
	 * @return approverWhere
	 */
	public String getApproverWhere () {
		return approverWhere;
	}

	/**
	 * 审批人设定
	 * @param approverWhere
	 */
	public void setApproverWhere (String approverWhere) {
		this.approverWhere = approverWhere;
	}

	/* 修复状态(0.未修复1.已修复2.其他）	*/ 
	private String repairStateWhere;

	/**
	 * 修复状态(0.未修复1.已修复2.其他）取得
	 * @return repairStateWhere
	 */
	public String getRepairStateWhere () {
		return repairStateWhere;
	}

	/**
	 * 修复状态(0.未修复1.已修复2.其他）设定
	 * @param repairStateWhere
	 */
	public void setRepairStateWhere (String repairStateWhere) {
		this.repairStateWhere = repairStateWhere;
	}

	/* 备注	*/ 
	private String noteWhere;

	/**
	 * 备注取得
	 * @return noteWhere
	 */
	public String getNoteWhere () {
		return noteWhere;
	}

	/**
	 * 备注设定
	 * @param noteWhere
	 */
	public void setNoteWhere (String noteWhere) {
		this.noteWhere = noteWhere;
	}
}

