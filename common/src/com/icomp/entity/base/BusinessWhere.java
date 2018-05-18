/*
 * 工具自动生成：业务流程条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * 业务流程条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class BusinessWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 业务流程ID	*/ 
	private String businessIDWhere;

	/**
	 * 业务流程ID取得
	 * @return businessIDWhere
	 */
	public String getBusinessIDWhere () {
		return businessIDWhere;
	}

	/**
	 * 业务流程ID设定
	 * @param businessIDWhere
	 */
	public void setBusinessIDWhere (String businessIDWhere) {
		this.businessIDWhere = businessIDWhere;
	}

	/* 业务流编码	*/ 
	private String businessCodeWhere;

	/**
	 * 业务流编码取得
	 * @return businessCodeWhere
	 */
	public String getBusinessCodeWhere () {
		return businessCodeWhere;
	}

	/**
	 * 业务流编码设定
	 * @param businessCodeWhere
	 */
	public void setBusinessCodeWhere (String businessCodeWhere) {
		this.businessCodeWhere = businessCodeWhere;
	}

	/* 业务流程名	*/ 
	private String businessNameWhere;

	/**
	 * 业务流程名取得
	 * @return businessNameWhere
	 */
	public String getBusinessNameWhere () {
		return businessNameWhere;
	}

	/**
	 * 业务流程名设定
	 * @param businessNameWhere
	 */
	public void setBusinessNameWhere (String businessNameWhere) {
		this.businessNameWhere = businessNameWhere;
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
}

