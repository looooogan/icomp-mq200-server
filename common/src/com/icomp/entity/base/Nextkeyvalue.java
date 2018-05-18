/*
 * 工具自动生成：主键生成实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 主键生成实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class Nextkeyvalue extends NextkeyvalueWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* Next_Key_Value_ID	*/ 
	private BigDecimal nextKeyValueID;

	/**
	 * Next_Key_Value_ID取得
	 * @return nextKeyValueID
	 */
	public BigDecimal getNextKeyValueID() {
		return nextKeyValueID;
	}

	/**
	 * Next_Key_Value_ID设定
	 * @param nextKeyValueID
	 */
	public void setNextKeyValueID(BigDecimal nextKeyValueID) {
		this.nextKeyValueID = nextKeyValueID;
	}

	/* 表名	*/ 
	private String tableName;

	/**
	 * 表名取得
	 * @return tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * 表名设定
	 * @param tableName
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/* 字段名	*/ 
	private String colName;

	/**
	 * 字段名取得
	 * @return colName
	 */
	public String getColName() {
		return colName;
	}

	/**
	 * 字段名设定
	 * @param colName
	 */
	public void setColName(String colName) {
		this.colName = colName;
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
}

