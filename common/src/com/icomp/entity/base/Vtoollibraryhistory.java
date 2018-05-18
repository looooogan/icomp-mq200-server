/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/04/25 17:20:14
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/04/25 17:20:14
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vtoollibraryhistory extends VtoollibraryhistoryWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具ID	*/ 
	private String toolID;

	/**
	 * 刀具ID取得
	 * @return toolID
	 */
	public String getToolID() {
		return toolID;
	}

	/**
	 * 刀具ID设定
	 * @param toolID
	 */
	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	/* 刀具分类(0刀具1辅具2配套9其他）	*/ 
	private String toolType;

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）取得
	 * @return toolType
	 */
	public String getToolType() {
		return toolType;
	}

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）设定
	 * @param toolType
	 */
	public void setToolType(String toolType) {
		this.toolType = toolType;
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
	private String libraryUser;

	/**
	 * 取得
	 * @return libraryUser
	 */
	public String getLibraryUser() {
		return libraryUser;
	}

	/**
	 * 设定
	 * @param libraryUser
	 */
	public void setLibraryUser(String libraryUser) {
		this.libraryUser = libraryUser;
	}

	/* 	*/ 
	private String receiveUser;

	/**
	 * 取得
	 * @return receiveUser
	 */
	public String getReceiveUser() {
		return receiveUser;
	}

	/**
	 * 设定
	 * @param receiveUser
	 */
	public void setReceiveUser(String receiveUser) {
		this.receiveUser = receiveUser;
	}

	/* 出库原因(0申领1换领2外借)	*/ 
	private String libraryCause;

	/**
	 * 出库原因(0申领1换领2外借)取得
	 * @return libraryCause
	 */
	public String getLibraryCause() {
		return libraryCause;
	}

	/**
	 * 出库原因(0申领1换领2外借)设定
	 * @param libraryCause
	 */
	public void setLibraryCause(String libraryCause) {
		this.libraryCause = libraryCause;
	}

	/* 	*/ 
	private String replacementReason;

	/**
	 * 取得
	 * @return replacementReason
	 */
	public String getReplacementReason() {
		return replacementReason;
	}

	/**
	 * 设定
	 * @param replacementReason
	 */
	public void setReplacementReason(String replacementReason) {
		this.replacementReason = replacementReason;
	}

	/* 领取数量	*/ 
	private BigDecimal receiveCount;

	/**
	 * 领取数量取得
	 * @return receiveCount
	 */
	public BigDecimal getReceiveCount() {
		return receiveCount;
	}

	/**
	 * 领取数量设定
	 * @param receiveCount
	 */
	public void setReceiveCount(BigDecimal receiveCount) {
		this.receiveCount = receiveCount;
	}

	public String receiveCard;
	public String libraryCard;

	public String getReceiveCard() {
		return receiveCard;
	}

	public void setReceiveCard(String receiveCard) {
		this.receiveCard = receiveCard;
	}

	public String getLibraryCard() {
		return libraryCard;
	}

	public void setLibraryCard(String libraryCard) {
		this.libraryCard = libraryCard;
	}
}

