/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:05
 * 创建者  ：杨作庆
 * 
 */
public class VrepairticketWhere extends BaseEntity implements Serializable {

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

	/* 姓名	*/ 
	private String receiveUserWhere;

	/**
	 * 姓名取得
	 * @return receiveUserWhere
	 */
	public String getReceiveUserWhere () {
		return receiveUserWhere;
	}

	/**
	 * 姓名设定
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

	/* 	*/ 
	private BigDecimal receiveCountWhere;

	/**
	 * 取得
	 * @return receiveCountWhere
	 */
	public BigDecimal getReceiveCountWhere () {
		return receiveCountWhere;
	}

	/**
	 * 设定
	 * @param receiveCountWhere
	 */
	public void setReceiveCountWhere (BigDecimal receiveCountWhere) {
		this.receiveCountWhere = receiveCountWhere;
	}

	/* 	*/ 
	private String returnUserWhere;

	/**
	 * 取得
	 * @return returnUserWhere
	 */
	public String getReturnUserWhere () {
		return returnUserWhere;
	}

	/**
	 * 设定
	 * @param returnUserWhere
	 */
	public void setReturnUserWhere (String returnUserWhere) {
		this.returnUserWhere = returnUserWhere;
	}

	/* 送回时间	*/ 
	private Date returnTimesWhere;

	/**
	 * 送回时间取得
	 * @return returnTimesWhere
	 */
	public Date getReturnTimesWhere () {
		return returnTimesWhere;
	}

	/**
	 * 送回时间设定
	 * @param returnTimesWhere
	 */
	public void setReturnTimesWhere (Date returnTimesWhere) {
		this.returnTimesWhere = returnTimesWhere;
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

	/* 	*/ 
	private BigDecimal scrapCountWhere;

	/**
	 * 取得
	 * @return scrapCountWhere
	 */
	public BigDecimal getScrapCountWhere () {
		return scrapCountWhere;
	}

	/**
	 * 设定
	 * @param scrapCountWhere
	 */
	public void setScrapCountWhere (BigDecimal scrapCountWhere) {
		this.scrapCountWhere = scrapCountWhere;
	}

	/* 	*/ 
	private BigDecimal processingStatusWhere;

	/**
	 * 取得
	 * @return processingStatusWhere
	 */
	public BigDecimal getProcessingStatusWhere () {
		return processingStatusWhere;
	}

	/**
	 * 设定
	 * @param processingStatusWhere
	 */
	public void setProcessingStatusWhere (BigDecimal processingStatusWhere) {
		this.processingStatusWhere = processingStatusWhere;
	}
}

