/*
 * 工具自动生成：主键生成条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * 主键生成条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class NextkeyvalueWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* Next_Key_Value_ID	*/ 
	private BigDecimal nextKeyValueIDWhere;

	/**
	 * Next_Key_Value_ID取得
	 * @return nextKeyValueIDWhere
	 */
	public BigDecimal getNextKeyValueIDWhere () {
		return nextKeyValueIDWhere;
	}

	/**
	 * Next_Key_Value_ID设定
	 * @param nextKeyValueIDWhere
	 */
	public void setNextKeyValueIDWhere (BigDecimal nextKeyValueIDWhere) {
		this.nextKeyValueIDWhere = nextKeyValueIDWhere;
	}

	/* 表名	*/ 
	private String tableNameWhere;

	/**
	 * 表名取得
	 * @return tableNameWhere
	 */
	public String getTableNameWhere () {
		return tableNameWhere;
	}

	/**
	 * 表名设定
	 * @param tableNameWhere
	 */
	public void setTableNameWhere (String tableNameWhere) {
		this.tableNameWhere = tableNameWhere;
	}

	/* 字段名	*/ 
	private String colNameWhere;

	/**
	 * 字段名取得
	 * @return colNameWhere
	 */
	public String getColNameWhere () {
		return colNameWhere;
	}

	/**
	 * 字段名设定
	 * @param colNameWhere
	 */
	public void setColNameWhere (String colNameWhere) {
		this.colNameWhere = colNameWhere;
	}

	/* 前缀	*/ 
	private String prefixWhere;

	/**
	 * 前缀取得
	 * @return prefixWhere
	 */
	public String getPrefixWhere () {
		return prefixWhere;
	}

	/**
	 * 前缀设定
	 * @param prefixWhere
	 */
	public void setPrefixWhere (String prefixWhere) {
		this.prefixWhere = prefixWhere;
	}

	/* 当前值	*/ 
	private String oldkeyValueWhere;

	/**
	 * 当前值取得
	 * @return oldkeyValueWhere
	 */
	public String getOldkeyValueWhere () {
		return oldkeyValueWhere;
	}

	/**
	 * 当前值设定
	 * @param oldkeyValueWhere
	 */
	public void setOldkeyValueWhere (String oldkeyValueWhere) {
		this.oldkeyValueWhere = oldkeyValueWhere;
	}

	/* 下一个值	*/ 
	private String nextKeyValueWhere;

	/**
	 * 下一个值取得
	 * @return nextKeyValueWhere
	 */
	public String getNextKeyValueWhere () {
		return nextKeyValueWhere;
	}

	/**
	 * 下一个值设定
	 * @param nextKeyValueWhere
	 */
	public void setNextKeyValueWhere (String nextKeyValueWhere) {
		this.nextKeyValueWhere = nextKeyValueWhere;
	}
}

