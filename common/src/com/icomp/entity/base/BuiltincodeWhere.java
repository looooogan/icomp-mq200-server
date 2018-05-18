/*
 * 工具自动生成：内置编码条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * 内置编码条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class BuiltincodeWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 内置编码ID	*/ 
	private String builtInCodeIDWhere;

	/**
	 * 内置编码ID取得
	 * @return builtInCodeIDWhere
	 */
	public String getBuiltInCodeIDWhere () {
		return builtInCodeIDWhere;
	}

	/**
	 * 内置编码ID设定
	 * @param builtInCodeIDWhere
	 */
	public void setBuiltInCodeIDWhere (String builtInCodeIDWhere) {
		this.builtInCodeIDWhere = builtInCodeIDWhere;
	}

	/* 编码类型	*/ 
	private String codeTypeWhere;

	/**
	 * 编码类型取得
	 * @return codeTypeWhere
	 */
	public String getCodeTypeWhere () {
		return codeTypeWhere;
	}

	/**
	 * 编码类型设定
	 * @param codeTypeWhere
	 */
	public void setCodeTypeWhere (String codeTypeWhere) {
		this.codeTypeWhere = codeTypeWhere;
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
}

