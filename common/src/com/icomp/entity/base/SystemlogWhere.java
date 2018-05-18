/*
 * 工具自动生成：日志条件实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.util.Date;


/**
 * 日志条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class SystemlogWhere extends BaseEntity implements Serializable {

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

	/* 语言编码	*/ 
	private String languageCodeWhere;

	/**
	 * 语言编码取得
	 * @return languageCodeWhere
	 */
	public String getLanguageCodeWhere () {
		return languageCodeWhere;
	}

	/**
	 * 语言编码设定
	 * @param languageCodeWhere
	 */
	public void setLanguageCodeWhere (String languageCodeWhere) {
		this.languageCodeWhere = languageCodeWhere;
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

	/* 操作人	*/ 
	private String systemLogUserWhere;

	/**
	 * 操作人取得
	 * @return systemLogUserWhere
	 */
	public String getSystemLogUserWhere () {
		return systemLogUserWhere;
	}

	/**
	 * 操作人设定
	 * @param systemLogUserWhere
	 */
	public void setSystemLogUserWhere (String systemLogUserWhere) {
		this.systemLogUserWhere = systemLogUserWhere;
	}
}

