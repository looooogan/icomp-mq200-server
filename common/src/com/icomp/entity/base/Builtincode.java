/*
 * 工具自动生成：内置编码实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * 内置编码实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class Builtincode extends BuiltincodeWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 内置编码ID	*/ 
	private String builtInCodeID;

	/**
	 * 内置编码ID取得
	 * @return builtInCodeID
	 */
	public String getBuiltInCodeID() {
		return builtInCodeID;
	}

	/**
	 * 内置编码ID设定
	 * @param builtInCodeID
	 */
	public void setBuiltInCodeID(String builtInCodeID) {
		this.builtInCodeID = builtInCodeID;
	}

	/* 编码类型	*/ 
	private String codeType;

	/**
	 * 编码类型取得
	 * @return codeType
	 */
	public String getCodeType() {
		return codeType;
	}

	/**
	 * 编码类型设定
	 * @param codeType
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	/* 当前值	*/ 
	private String oldkeyValue;

	/**
	 * 当前值取得
	 * @return oldkeyValue
	 */
	public String getOldkeyValue() {
		return oldkeyValue;
	}

	/**
	 * 当前值设定
	 * @param oldkeyValue
	 */
	public void setOldkeyValue(String oldkeyValue) {
		this.oldkeyValue = oldkeyValue;
	}

	/* 下一个值	*/ 
	private String nextKeyValue;

	/**
	 * 下一个值取得
	 * @return nextKeyValue
	 */
	public String getNextKeyValue() {
		return nextKeyValue;
	}

	/**
	 * 下一个值设定
	 * @param nextKeyValue
	 */
	public void setNextKeyValue(String nextKeyValue) {
		this.nextKeyValue = nextKeyValue;
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

