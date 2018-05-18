/*
 * 工具自动生成：内置编码映射条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * 内置编码映射条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class BuiltincodemappingWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 内置编码	*/ 
	private String builtInCodeWhere;

	/**
	 * 内置编码取得
	 * @return builtInCodeWhere
	 */
	public String getBuiltInCodeWhere () {
		return builtInCodeWhere;
	}

	/**
	 * 内置编码设定
	 * @param builtInCodeWhere
	 */
	public void setBuiltInCodeWhere (String builtInCodeWhere) {
		this.builtInCodeWhere = builtInCodeWhere;
	}

	/* 自定义编码	*/ 
	private String userCodeWhere;

	/**
	 * 自定义编码取得
	 * @return userCodeWhere
	 */
	public String getUserCodeWhere () {
		return userCodeWhere;
	}

	/**
	 * 自定义编码设定
	 * @param userCodeWhere
	 */
	public void setUserCodeWhere (String userCodeWhere) {
		this.userCodeWhere = userCodeWhere;
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

