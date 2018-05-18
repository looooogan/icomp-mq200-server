/*
 * 工具自动生成：刀具修复通知(需要领取人到库房领取)实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 刀具修复通知(需要领取人到库房领取)实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class Toolrepairnotice extends ToolrepairnoticeWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 修复通知流水号	*/ 
	private String toolRepairNoticeID;

	/**
	 * 修复通知流水号取得
	 * @return toolRepairNoticeID
	 */
	public String getToolRepairNoticeID() {
		return toolRepairNoticeID;
	}

	/**
	 * 修复通知流水号设定
	 * @param toolRepairNoticeID
	 */
	public void setToolRepairNoticeID(String toolRepairNoticeID) {
		this.toolRepairNoticeID = toolRepairNoticeID;
	}

	/* RFID标签ID	*/ 
	private String rfidCode;

	/**
	 * RFID标签ID取得
	 * @return rfidCode
	 */
	public String getRfidCode() {
		return rfidCode;
	}

	/**
	 * RFID标签ID设定
	 * @param rfidCode
	 */
	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}

	/* 通知时间	*/ 
	private Date noticeTime;

	/**
	 * 通知时间取得
	 * @return noticeTime
	 */
	public Date getNoticeTime() {
		return noticeTime;
	}

	/**
	 * 通知时间设定
	 * @param noticeTime
	 */
	public void setNoticeTime(Date noticeTime) {
		this.noticeTime = noticeTime;
	}

	/* 操作人	*/ 
	private String toolRepairNoticeUser;

	/**
	 * 操作人取得
	 * @return toolRepairNoticeUser
	 */
	public String getToolRepairNoticeUser() {
		return toolRepairNoticeUser;
	}

	/**
	 * 操作人设定
	 * @param toolRepairNoticeUser
	 */
	public void setToolRepairNoticeUser(String toolRepairNoticeUser) {
		this.toolRepairNoticeUser = toolRepairNoticeUser;
	}

	/* 领取人	*/ 
	private String receiveUser;

	/**
	 * 领取人取得
	 * @return receiveUser
	 */
	public String getReceiveUser() {
		return receiveUser;
	}

	/**
	 * 领取人设定
	 * @param receiveUser
	 */
	public void setReceiveUser(String receiveUser) {
		this.receiveUser = receiveUser;
	}

	/* 领取时间	*/ 
	private Date receiveTime;

	/**
	 * 领取时间取得
	 * @return receiveTime
	 */
	public Date getReceiveTime() {
		return receiveTime;
	}

	/**
	 * 领取时间设定
	 * @param receiveTime
	 */
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	/* 送回人	*/ 
	private String returnUser;

	/**
	 * 送回人取得
	 * @return returnUser
	 */
	public String getReturnUser() {
		return returnUser;
	}

	/**
	 * 送回人设定
	 * @param returnUser
	 */
	public void setReturnUser(String returnUser) {
		this.returnUser = returnUser;
	}

	/* 送回时间	*/ 
	private Date returnTime;

	/**
	 * 送回时间取得
	 * @return returnTime
	 */
	public Date getReturnTime() {
		return returnTime;
	}

	/**
	 * 送回时间设定
	 * @param returnTime
	 */
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	/* 应送回数量	*/ 
	private BigDecimal sentBackNumber;

	/**
	 * 应送回数量取得
	 * @return sentBackNumber
	 */
	public BigDecimal getSentBackNumber() {
		return sentBackNumber;
	}

	/**
	 * 应送回数量设定
	 * @param sentBackNumber
	 */
	public void setSentBackNumber(BigDecimal sentBackNumber) {
		this.sentBackNumber = sentBackNumber;
	}

	/* 实际送回数量	*/ 
	private BigDecimal realSentBackNumber;

	/**
	 * 实际送回数量取得
	 * @return realSentBackNumber
	 */
	public BigDecimal getRealSentBackNumber() {
		return realSentBackNumber;
	}

	/**
	 * 实际送回数量设定
	 * @param realSentBackNumber
	 */
	public void setRealSentBackNumber(BigDecimal realSentBackNumber) {
		this.realSentBackNumber = realSentBackNumber;
	}

	/* 修复丢失	*/ 
	private BigDecimal recoverLostNumber;

	/**
	 * 修复丢失取得
	 * @return recoverLostNumber
	 */
	public BigDecimal getRecoverLostNumber() {
		return recoverLostNumber;
	}

	/**
	 * 修复丢失设定
	 * @param recoverLostNumber
	 */
	public void setRecoverLostNumber(BigDecimal recoverLostNumber) {
		this.recoverLostNumber = recoverLostNumber;
	}

	/* 丢失确认人	*/ 
	private String lostIdentifyingUser;

	/**
	 * 丢失确认人取得
	 * @return lostIdentifyingUser
	 */
	public String getLostIdentifyingUser() {
		return lostIdentifyingUser;
	}

	/**
	 * 丢失确认人设定
	 * @param lostIdentifyingUser
	 */
	public void setLostIdentifyingUser(String lostIdentifyingUser) {
		this.lostIdentifyingUser = lostIdentifyingUser;
	}

	/* 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)	*/ 
	private String repairWay;

	/**
	 * 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)取得
	 * @return repairWay
	 */
	public String getRepairWay() {
		return repairWay;
	}

	/**
	 * 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)设定
	 * @param repairWay
	 */
	public void setRepairWay(String repairWay) {
		this.repairWay = repairWay;
	}
}

