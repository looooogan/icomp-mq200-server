/*
 * 工具自动生成：内置编码映射实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * 内置编码映射实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class Builtincodemapping extends BuiltincodemappingWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 内置编码	*/ 
	private String builtInCode;

	/**
	 * 内置编码取得
	 * @return builtInCode
	 */
	public String getBuiltInCode() {
		return builtInCode;
	}

	/**
	 * 内置编码设定
	 * @param builtInCode
	 */
	public void setBuiltInCode(String builtInCode) {
		this.builtInCode = builtInCode;
	}

	/* 自定义编码	*/ 
	private String userCode;

	/**
	 * 自定义编码取得
	 * @return userCode
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * 自定义编码设定
	 * @param userCode
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/* 前缀	*/ 
	private String prefix;

	/**
	 * 前缀取得
	 * @return prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * 前缀设定
	 * @param prefix
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}

