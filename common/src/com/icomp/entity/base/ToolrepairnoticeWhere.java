/*
 * 工具自动生成：刀具修复通知(需要领取人到库房领取)条件实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 刀具修复通知(需要领取人到库房领取)条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class ToolrepairnoticeWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 修复通知流水号	*/ 
	private String toolRepairNoticeIDWhere;

	/**
	 * 修复通知流水号取得
	 * @return toolRepairNoticeIDWhere
	 */
	public String getToolRepairNoticeIDWhere () {
		return toolRepairNoticeIDWhere;
	}

	/**
	 * 修复通知流水号设定
	 * @param toolRepairNoticeIDWhere
	 */
	public void setToolRepairNoticeIDWhere (String toolRepairNoticeIDWhere) {
		this.toolRepairNoticeIDWhere = toolRepairNoticeIDWhere;
	}

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

	/* 通知时间	*/ 
	private Date noticeTimeWhere;

	/**
	 * 通知时间取得
	 * @return noticeTimeWhere
	 */
	public Date getNoticeTimeWhere () {
		return noticeTimeWhere;
	}

	/**
	 * 通知时间设定
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

	/* 送回人	*/ 
	private String returnUserWhere;

	/**
	 * 送回人取得
	 * @return returnUserWhere
	 */
	public String getReturnUserWhere () {
		return returnUserWhere;
	}

	/**
	 * 送回人设定
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

	/* 应送回数量	*/ 
	private BigDecimal sentBackNumberWhere;

	/**
	 * 应送回数量取得
	 * @return sentBackNumberWhere
	 */
	public BigDecimal getSentBackNumberWhere () {
		return sentBackNumberWhere;
	}

	/**
	 * 应送回数量设定
	 * @param sentBackNumberWhere
	 */
	public void setSentBackNumberWhere (BigDecimal sentBackNumberWhere) {
		this.sentBackNumberWhere = sentBackNumberWhere;
	}

	/* 实际送回数量	*/ 
	private BigDecimal realSentBackNumberWhere;

	/**
	 * 实际送回数量取得
	 * @return realSentBackNumberWhere
	 */
	public BigDecimal getRealSentBackNumberWhere () {
		return realSentBackNumberWhere;
	}

	/**
	 * 实际送回数量设定
	 * @param realSentBackNumberWhere
	 */
	public void setRealSentBackNumberWhere (BigDecimal realSentBackNumberWhere) {
		this.realSentBackNumberWhere = realSentBackNumberWhere;
	}

	/* 修复丢失	*/ 
	private BigDecimal recoverLostNumberWhere;

	/**
	 * 修复丢失取得
	 * @return recoverLostNumberWhere
	 */
	public BigDecimal getRecoverLostNumberWhere () {
		return recoverLostNumberWhere;
	}

	/**
	 * 修复丢失设定
	 * @param recoverLostNumberWhere
	 */
	public void setRecoverLostNumberWhere (BigDecimal recoverLostNumberWhere) {
		this.recoverLostNumberWhere = recoverLostNumberWhere;
	}

	/* 丢失确认人	*/ 
	private String lostIdentifyingUserWhere;

	/**
	 * 丢失确认人取得
	 * @return lostIdentifyingUserWhere
	 */
	public String getLostIdentifyingUserWhere () {
		return lostIdentifyingUserWhere;
	}

	/**
	 * 丢失确认人设定
	 * @param lostIdentifyingUserWhere
	 */
	public void setLostIdentifyingUserWhere (String lostIdentifyingUserWhere) {
		this.lostIdentifyingUserWhere = lostIdentifyingUserWhere;
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
}

