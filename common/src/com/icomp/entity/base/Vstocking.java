/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/13 14:08:26
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/13 14:08:26
 * 创建者  ：杨作庆
 * 
 */
public class Vstocking extends VstockingWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 	*/ 
	private String toolCode;

	/**
	 * 取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 	*/ 
	private Date checkTime;

	/**
	 * 取得
	 * @return checkTime
	 */
	public Date getCheckTime() {
		return checkTime;
	}

	/**
	 * 设定
	 * @param checkTime
	 */
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	/* 	*/ 
	private String checkUser;

	/**
	 * 取得
	 * @return checkUser
	 */
	public String getCheckUser() {
		return checkUser;
	}

	/**
	 * 设定
	 * @param checkUser
	 */
	public void setCheckUser(String checkUser) {
		this.checkUser = checkUser;
	}

	/* 	*/ 
	private BigDecimal libraryCount;

	/**
	 * 取得
	 * @return libraryCount
	 */
	public BigDecimal getLibraryCount() {
		return libraryCount;
	}

	/**
	 * 设定
	 * @param libraryCount
	 */
	public void setLibraryCount(BigDecimal libraryCount) {
		this.libraryCount = libraryCount;
	}

	/* 	*/ 
	private BigDecimal realLibraryCount;

	/**
	 * 取得
	 * @return realLibraryCount
	 */
	public BigDecimal getRealLibraryCount() {
		return realLibraryCount;
	}

	/**
	 * 设定
	 * @param realLibraryCount
	 */
	public void setRealLibraryCount(BigDecimal realLibraryCount) {
		this.realLibraryCount = realLibraryCount;
	}

	/* 	*/ 
	private String removeUser;

	/**
	 * 取得
	 * @return removeUser
	 */
	public String getRemoveUser() {
		return removeUser;
	}

	/**
	 * 设定
	 * @param removeUser
	 */
	public void setRemoveUser(String removeUser) {
		this.removeUser = removeUser;
	}
	
	/* 盘点结果	*/ 
	private String inventoryResults;

	/**
	 * 取得
	 * @return inventoryResults
	 */
	public String getInventoryResults() {
		return inventoryResults;
	}

	/**
	 * 设定
	 * @param inventoryResults
	 */
	public void setInventoryResults(String inventoryResults) {
		this.inventoryResults = inventoryResults;
	}
	
	/* 盘点状态	*/ 
	private String inventoryStatus;

	/**
	 * 取得
	 * @return inventoryStatus
	 */
	public String getInventoryStatus() {
		return inventoryStatus;
	}
	
	/**
	 * 设定
	 * @param inventoryStatus
	 */
	public void setInventoryStatus(String inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}

	
}

