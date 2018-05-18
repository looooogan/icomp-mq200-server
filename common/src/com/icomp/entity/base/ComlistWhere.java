/*
 * 工具自动生成：区分定义条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;

import com.icomp.common.entity.BaseEntity;


/**
 * 区分定义条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class ComlistWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* ComlistID	*/ 
	private String comlistIDWhere;

	/**
	 * ComlistID取得
	 * @return comlistIDWhere
	 */
	public String getComlistIDWhere () {
		return comlistIDWhere;
	}

	/**
	 * ComlistID设定
	 * @param comlistIDWhere
	 */
	public void setComlistIDWhere (String comlistIDWhere) {
		this.comlistIDWhere = comlistIDWhere;
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

	/* 区分类型	*/ 
	private String comListTypeWhere;

	/**
	 * 区分类型取得
	 * @return comListTypeWhere
	 */
	public String getComListTypeWhere () {
		return comListTypeWhere;
	}

	/**
	 * 区分类型设定
	 * @param comListTypeWhere
	 */
	public void setComListTypeWhere (String comListTypeWhere) {
		this.comListTypeWhere = comListTypeWhere;
	}

	/* 区分值	*/ 
	private String comListValueWhere;

	/**
	 * 区分值取得
	 * @return comListValueWhere
	 */
	public String getComListValueWhere () {
		return comListValueWhere;
	}

	/**
	 * 区分值设定
	 * @param comListValueWhere
	 */
	public void setComListValueWhere (String comListValueWhere) {
		this.comListValueWhere = comListValueWhere;
	}

	/* 区分文本	*/ 
	private String comListTextWhere;

	/**
	 * 区分文本取得
	 * @return comListTextWhere
	 */
	public String getComListTextWhere () {
		return comListTextWhere;
	}

	/**
	 * 区分文本设定
	 * @param comListTextWhere
	 */
	public void setComListTextWhere (String comListTextWhere) {
		this.comListTextWhere = comListTextWhere;
	}

	/* 区分描述	*/ 
	private String comListMsWhere;

	/**
	 * 区分描述取得
	 * @return comListMsWhere
	 */
	public String getComListMsWhere () {
		return comListMsWhere;
	}

	/**
	 * 区分描述设定
	 * @param comListMsWhere
	 */
	public void setComListMsWhere (String comListMsWhere) {
		this.comListMsWhere = comListMsWhere;
	}

	/* 是否可以修改(0是1否)	*/ 
	private String editFlagWhere;

	/**
	 * 是否可以修改(0是1否)取得
	 * @return editFlagWhere
	 */
	public String getEditFlagWhere () {
		return editFlagWhere;
	}

	/**
	 * 是否可以修改(0是1否)设定
	 * @param editFlagWhere
	 */
	public void setEditFlagWhere (String editFlagWhere) {
		this.editFlagWhere = editFlagWhere;
	}
}

