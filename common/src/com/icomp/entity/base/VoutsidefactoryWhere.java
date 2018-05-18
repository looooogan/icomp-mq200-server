/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/05/09 17:49:35
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/05/09 17:49:35
 * 创建者  ：工具自动生成
 * 
 */
public class VoutsidefactoryWhere extends BaseEntity implements Serializable {

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

	/* 商家名称	*/ 
	private String merchantsNameWhere;

	/**
	 * 商家名称取得
	 * @return merchantsNameWhere
	 */
	public String getMerchantsNameWhere () {
		return merchantsNameWhere;
	}

	/**
	 * 商家名称设定
	 * @param merchantsNameWhere
	 */
	public void setMerchantsNameWhere (String merchantsNameWhere) {
		this.merchantsNameWhere = merchantsNameWhere;
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
	private String approverouserWhere;

	/**
	 * 审批人取得
	 * @return approverouserWhere
	 */
	public String getApproverouserWhere () {
		return approverouserWhere;
	}

	/**
	 * 审批人设定
	 * @param approverouserWhere
	 */
	public void setApproverouserWhere (String approverouserWhere) {
		this.approverouserWhere = approverouserWhere;
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

