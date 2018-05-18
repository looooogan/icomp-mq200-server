/*
 * 工具自动生成：日志实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.Date;


/**
 * 日志实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class Systemlog extends SystemlogWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* system_Log_ID	*/ 
	private String systemLogID;

	/**
	 * system_Log_ID取得
	 * @return systemLogID
	 */
	public String getSystemLogID() {
		return systemLogID;
	}

	/**
	 * system_Log_ID设定
	 * @param systemLogID
	 */
	public void setSystemLogID(String systemLogID) {
		this.systemLogID = systemLogID;
	}

	/* 语言编码	*/ 
	private String languageCode;

	/**
	 * 语言编码取得
	 * @return languageCode
	 */
	public String getLanguageCode() {
		return languageCode;
	}

	/**
	 * 语言编码设定
	 * @param languageCode
	 */
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	/* 日志内容	*/ 
	private String systemLogMsg;

	/**
	 * 日志内容取得
	 * @return systemLogMsg
	 */
	public String getSystemLogMsg() {
		return systemLogMsg;
	}

	/**
	 * 日志内容设定
	 * @param systemLogMsg
	 */
	public void setSystemLogMsg(String systemLogMsg) {
		this.systemLogMsg = systemLogMsg;
	}

	/* 日志分类(0手持机1智能管理平台2系统日志)	*/ 
	private String systemLogFlag;

	/**
	 * 日志分类(0手持机1智能管理平台2系统日志)取得
	 * @return systemLogFlag
	 */
	public String getSystemLogFlag() {
		return systemLogFlag;
	}

	/**
	 * 日志分类(0手持机1智能管理平台2系统日志)设定
	 * @param systemLogFlag
	 */
	public void setSystemLogFlag(String systemLogFlag) {
		this.systemLogFlag = systemLogFlag;
	}

	/* 日志级别(0正常1警告2错误9其他)	*/ 
	private String systemLogLevel;

	/**
	 * 日志级别(0正常1警告2错误9其他)取得
	 * @return systemLogLevel
	 */
	public String getSystemLogLevel() {
		return systemLogLevel;
	}

	/**
	 * 日志级别(0正常1警告2错误9其他)设定
	 * @param systemLogLevel
	 */
	public void setSystemLogLevel(String systemLogLevel) {
		this.systemLogLevel = systemLogLevel;
	}

	/* 产生时间	*/ 
	private Date systemLogDate;

	/**
	 * 产生时间取得
	 * @return systemLogDate
	 */
	public Date getSystemLogDate() {
		return systemLogDate;
	}

	/**
	 * 产生时间设定
	 * @param systemLogDate
	 */
	public void setSystemLogDate(Date systemLogDate) {
		this.systemLogDate = systemLogDate;
	}

	/* 操作人	*/ 
	private String systemLogUser;

	/**
	 * 操作人取得
	 * @return systemLogUser
	 */
	public String getSystemLogUser() {
		return systemLogUser;
	}

	/**
	 * 操作人设定
	 * @param systemLogUser
	 */
	public void setSystemLogUser(String systemLogUser) {
		this.systemLogUser = systemLogUser;
	}
}

