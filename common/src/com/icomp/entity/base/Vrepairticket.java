/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:05
 * 创建者  ：杨作庆
 * 
 */
public class Vrepairticket extends VrepairticketWhere implements Serializable {

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

	/* 姓名	*/ 
	private String receiveUser;

	/**
	 * 姓名取得
	 * @return receiveUser
	 */
	public String getReceiveUser() {
		return receiveUser;
	}

	/**
	 * 姓名设定
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

	/* 	*/ 
	private BigDecimal receiveCount;

	/**
	 * 取得
	 * @return receiveCount
	 */
	public BigDecimal getReceiveCount() {
		return receiveCount;
	}

	/**
	 * 设定
	 * @param receiveCount
	 */
	public void setReceiveCount(BigDecimal receiveCount) {
		this.receiveCount = receiveCount;
	}

	/* 	*/ 
	private String returnUser;

	/**
	 * 取得
	 * @return returnUser
	 */
	public String getReturnUser() {
		return returnUser;
	}

	/**
	 * 设定
	 * @param returnUser
	 */
	public void setReturnUser(String returnUser) {
		this.returnUser = returnUser;
	}

	/* 送回时间	*/ 
	private Date returnTimes;

	/**
	 * 送回时间取得
	 * @return returnTimes
	 */
	public Date getReturnTimes() {
		return returnTimes;
	}

	/**
	 * 送回时间设定
	 * @param returnTimes
	 */
	public void setReturnTimes(Date returnTimes) {
		this.returnTimes = returnTimes;
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

	/* 	*/ 
	private BigDecimal scrapCount;

	/**
	 * 取得
	 * @return scrapCount
	 */
	public BigDecimal getScrapCount() {
		return scrapCount;
	}

	/**
	 * 设定
	 * @param scrapCount
	 */
	public void setScrapCount(BigDecimal scrapCount) {
		this.scrapCount = scrapCount;
	}

	/* 	*/ 
	private BigDecimal processingStatus;

	/**
	 * 取得
	 * @return processingStatus
	 */
	public BigDecimal getProcessingStatus() {
		return processingStatus;
	}

	/**
	 * 设定
	 * @param processingStatus
	 */
	public void setProcessingStatus(BigDecimal processingStatus) {
		this.processingStatus = processingStatus;
	}
}

