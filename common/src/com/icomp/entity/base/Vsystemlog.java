/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/27 09:58:23
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.Date;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/27 09:58:23
 * 创建者  ：杨作庆
 * 
 */
public class Vsystemlog extends VsystemlogWhere implements Serializable {

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

	/* 语言名称	*/ 
	private String languageName;

	/**
	 * 语言名称取得
	 * @return languageName
	 */
	public String getLanguageName() {
		return languageName;
	}

	/**
	 * 语言名称设定
	 * @param languageName
	 */
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
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

	/* 	*/ 
	private String systemLogUser;

	/**
	 * 取得
	 * @return systemLogUser
	 */
	public String getSystemLogUser() {
		return systemLogUser;
	}

	/**
	 * 设定
	 * @param systemLogUser
	 */
	public void setSystemLogUser(String systemLogUser) {
		this.systemLogUser = systemLogUser;
	}
}

