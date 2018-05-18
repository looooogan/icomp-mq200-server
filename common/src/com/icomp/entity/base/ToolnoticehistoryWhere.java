/*
 * 工具自动生成：条件实体类
 * 生成时间    : 2016/02/29 16:14:14
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 条件实体类
 * @author 工具自动生成
 * 创建时间：2016/02/29 16:14:14
 * 创建者  ：工具自动生成
 * 
 */
public class ToolnoticehistoryWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具入库编码	*/ 
	private String knifeInventoryCodeWhere;

	/**
	 * 刀具入库编码取得
	 * @return knifeInventoryCodeWhere
	 */
	public String getKnifeInventoryCodeWhere () {
		return knifeInventoryCodeWhere;
	}

	/**
	 * 刀具入库编码设定
	 * @param knifeInventoryCodeWhere
	 */
	public void setKnifeInventoryCodeWhere (String knifeInventoryCodeWhere) {
		this.knifeInventoryCodeWhere = knifeInventoryCodeWhere;
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

	/* 修磨设备ID	*/ 
	private String noticeEquipmentIDWhere;

	/**
	 * 修磨设备ID取得
	 * @return noticeEquipmentIDWhere
	 */
	public String getNoticeEquipmentIDWhere () {
		return noticeEquipmentIDWhere;
	}

	/**
	 * 修磨设备ID设定
	 * @param noticeEquipmentIDWhere
	 */
	public void setNoticeEquipmentIDWhere (String noticeEquipmentIDWhere) {
		this.noticeEquipmentIDWhere = noticeEquipmentIDWhere;
	}

	/* 修复数量	*/ 
	private BigDecimal noticeCountWhere;

	/**
	 * 修复数量取得
	 * @return noticeCountWhere
	 */
	public BigDecimal getNoticeCountWhere () {
		return noticeCountWhere;
	}

	/**
	 * 修复数量设定
	 * @param noticeCountWhere
	 */
	public void setNoticeCountWhere (BigDecimal noticeCountWhere) {
		this.noticeCountWhere = noticeCountWhere;
	}

	/* 修复时间	*/ 
	private Date noticeTimeWhere;

	/**
	 * 修复时间取得
	 * @return noticeTimeWhere
	 */
	public Date getNoticeTimeWhere () {
		return noticeTimeWhere;
	}

	/**
	 * 修复时间设定
	 * @param noticeTimeWhere
	 */
	public void setNoticeTimeWhere (Date noticeTimeWhere) {
		this.noticeTimeWhere = noticeTimeWhere;
	}

	/* 操作人	*/ 
	private String toolRepairNoticeUserWhere;

	/**
	 * 操作人取得
	 * @return toolRepairNoticeUserWhere
	 */
	public String getToolRepairNoticeUserWhere () {
		return toolRepairNoticeUserWhere;
	}

	/**
	 * 操作人设定
	 * @param toolRepairNoticeUserWhere
	 */
	public void setToolRepairNoticeUserWhere (String toolRepairNoticeUserWhere) {
		this.toolRepairNoticeUserWhere = toolRepairNoticeUserWhere;
	}

	/* 领取人	*/ 
	private String receiveUserWhere;

	/**
	 * 领取人取得
	 * @return receiveUserWhere
	 */
	public String getReceiveUserWhere () {
		return receiveUserWhere;
	}

	/**
	 * 领取人设定
	 * @param receiveUserWhere
	 */
	public void setReceiveUserWhere (String receiveUserWhere) {
		this.receiveUserWhere = receiveUserWhere;
	}

	/* 领取时间	*/ 
	private Date receiveTimeWhere;

	/**
	 * 领取时间取得
	 * @return receiveTimeWhere
	 */
	public Date getReceiveTimeWhere () {
		return receiveTimeWhere;
	}

	/**
	 * 领取时间设定
	 * @param receiveTimeWhere
	 */
	public void setReceiveTimeWhere (Date receiveTimeWhere) {
		this.receiveTimeWhere = receiveTimeWhere;
	}

	/* 修复后测量长度	*/ 
	private BigDecimal noticeOldLengthWhere;

	/**
	 * 修复后测量长度取得
	 * @return noticeOldLengthWhere
	 */
	public BigDecimal getNoticeOldLengthWhere () {
		return noticeOldLengthWhere;
	}

	/**
	 * 修复后测量长度设定
	 * @param noticeOldLengthWhere
	 */
	public void setNoticeOldLengthWhere (BigDecimal noticeOldLengthWhere) {
		this.noticeOldLengthWhere = noticeOldLengthWhere;
	}

	/* 修复前测量长度	*/ 
	private BigDecimal noticeLengthWhere;

	/**
	 * 修复前测量长度取得
	 * @return noticeLengthWhere
	 */
	public BigDecimal getNoticeLengthWhere () {
		return noticeLengthWhere;
	}

	/**
	 * 修复前测量长度设定
	 * @param noticeLengthWhere
	 */
	public void setNoticeLengthWhere (BigDecimal noticeLengthWhere) {
		this.noticeLengthWhere = noticeLengthWhere;
	}

	/* 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)	*/ 
	private String repairWayWhere;

	/**
	 * 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)取得
	 * @return repairWayWhere
	 */
	public String getRepairWayWhere () {
		return repairWayWhere;
	}

	/**
	 * 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)设定
	 * @param repairWayWhere
	 */
	public void setRepairWayWhere (String repairWayWhere) {
		this.repairWayWhere = repairWayWhere;
	}

	/* 修复原因(0断刀1正常刃磨)	*/ 
	private String repairedBecauseWhere;

	/**
	 * 修复原因(0断刀1正常刃磨)取得
	 * @return repairedBecauseWhere
	 */
	public String getRepairedBecauseWhere () {
		return repairedBecauseWhere;
	}

	/**
	 * 修复原因(0断刀1正常刃磨)设定
	 * @param repairedBecauseWhere
	 */
	public void setRepairedBecauseWhere (String repairedBecauseWhere) {
		this.repairedBecauseWhere = repairedBecauseWhere;
	}

	private String rfidContainerIDWhere;

	public String getRfidContainerIDWhere() {
		return rfidContainerIDWhere;
	}

	public void setRfidContainerIDWhere(String rfidContainerIDWhere) {
		this.rfidContainerIDWhere = rfidContainerIDWhere;
	}
}

