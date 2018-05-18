/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/27 09:58:23
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.util.Date;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/27 09:58:23
 * 创建者  ：杨作庆
 * 
 */
public class VsystemlogWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* system_Log_ID	*/ 
	private String systemLogIDWhere;

	/**
	 * system_Log_ID取得
	 * @return systemLogIDWhere
	 */
	public String getSystemLogIDWhere () {
		return systemLogIDWhere;
	}

	/**
	 * system_Log_ID设定
	 * @param systemLogIDWhere
	 */
	public void setSystemLogIDWhere (String systemLogIDWhere) {
		this.systemLogIDWhere = systemLogIDWhere;
	}

	/* 语言名称	*/ 
	private String languageNameWhere;

	/**
	 * 语言名称取得
	 * @return languageNameWhere
	 */
	public String getLanguageNameWhere () {
		return languageNameWhere;
	}

	/**
	 * 语言名称设定
	 * @param languageNameWhere
	 */
	public void setLanguageNameWhere (String languageNameWhere) {
		this.languageNameWhere = languageNameWhere;
	}

	/* 日志内容	*/ 
	private String systemLogMsgWhere;

	/**
	 * 日志内容取得
	 * @return systemLogMsgWhere
	 */
	public String getSystemLogMsgWhere () {
		return systemLogMsgWhere;
	}

	/**
	 * 日志内容设定
	 * @param systemLogMsgWhere
	 */
	public void setSystemLogMsgWhere (String systemLogMsgWhere) {
		this.systemLogMsgWhere = systemLogMsgWhere;
	}

	/* 日志分类(0手持机1智能管理平台2系统日志)	*/ 
	private String systemLogFlagWhere;

	/**
	 * 日志分类(0手持机1智能管理平台2系统日志)取得
	 * @return systemLogFlagWhere
	 */
	public String getSystemLogFlagWhere () {
		return systemLogFlagWhere;
	}

	/**
	 * 日志分类(0手持机1智能管理平台2系统日志)设定
	 * @param systemLogFlagWhere
	 */
	public void setSystemLogFlagWhere (String systemLogFlagWhere) {
		this.systemLogFlagWhere = systemLogFlagWhere;
	}

	/* 日志级别(0正常1警告2错误9其他)	*/ 
	private String systemLogLevelWhere;

	/**
	 * 日志级别(0正常1警告2错误9其他)取得
	 * @return systemLogLevelWhere
	 */
	public String getSystemLogLevelWhere () {
		return systemLogLevelWhere;
	}

	/**
	 * 日志级别(0正常1警告2错误9其他)设定
	 * @param systemLogLevelWhere
	 */
	public void setSystemLogLevelWhere (String systemLogLevelWhere) {
		this.systemLogLevelWhere = systemLogLevelWhere;
	}

	/* 产生时间	*/ 
	private Date systemLogDateWhere;

	/**
	 * 产生时间取得
	 * @return systemLogDateWhere
	 */
	public Date getSystemLogDateWhere () {
		return systemLogDateWhere;
	}

	/**
	 * 产生时间设定
	 * @param systemLogDateWhere
	 */
	public void setSystemLogDateWhere (Date systemLogDateWhere) {
		this.systemLogDateWhere = systemLogDateWhere;
	}

	/* 	*/ 
	private String systemLogUserWhere;

	/**
	 * 取得
	 * @return systemLogUserWhere
	 */
	public String getSystemLogUserWhere () {
		return systemLogUserWhere;
	}

	/**
	 * 设定
	 * @param systemLogUserWhere
	 */
	public void setSystemLogUserWhere (String systemLogUserWhere) {
		this.systemLogUserWhere = systemLogUserWhere;
	}
}

