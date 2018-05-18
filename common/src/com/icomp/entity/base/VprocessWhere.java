/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/03/07 09:47:32
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/03/07 09:47:32
 * 创建者  ：工具自动生成
 * 
 */
public class VprocessWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 流水线名称	*/
	private String assemblyLineNameWhere;

	/**
	 * 流水线名称取得
	 * @return assemblyLineNameWhere
	 */
	public String getAssemblyLineNameWhere () {
		return assemblyLineNameWhere;
	}

	/**
	 * 流水线名称设定
	 * @param assemblyLineNameWhere
	 */
	public void setAssemblyLineNameWhere (String assemblyLineNameWhere) {
		this.assemblyLineNameWhere = assemblyLineNameWhere;
	}

	/* 流水线ID	*/
	private String assemblyLineIDWhere;

	/**
	 * 流水线ID取得
	 * @return assemblyLineIDWhere
	 */
	public String getAssemblyLineIDWhere () {
		return assemblyLineIDWhere;
	}

	/**
	 * 流水线ID设定
	 * @param assemblyLineIDWhere
	 */
	public void setAssemblyLineIDWhere (String assemblyLineIDWhere) {
		this.assemblyLineIDWhere = assemblyLineIDWhere;
	}

	/* 工序ID	*/ 
	private String processIDWhere;

	/**
	 * 工序ID取得
	 * @return processIDWhere
	 */
	public String getProcessIDWhere () {
		return processIDWhere;
	}

	/**
	 * 工序ID设定
	 * @param processIDWhere
	 */
	public void setProcessIDWhere (String processIDWhere) {
		this.processIDWhere = processIDWhere;
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

	/* 工序编码	*/ 
	private String processCodeWhere;

	/**
	 * 工序编码取得
	 * @return processCodeWhere
	 */
	public String getProcessCodeWhere () {
		return processCodeWhere;
	}

	/**
	 * 工序编码设定
	 * @param processCodeWhere
	 */
	public void setProcessCodeWhere (String processCodeWhere) {
		this.processCodeWhere = processCodeWhere;
	}

	/* 工序名称	*/ 
	private String processNameWhere;

	/**
	 * 工序名称取得
	 * @return processNameWhere
	 */
	public String getProcessNameWhere () {
		return processNameWhere;
	}

	/**
	 * 工序名称设定
	 * @param processNameWhere
	 */
	public void setProcessNameWhere (String processNameWhere) {
		this.processNameWhere = processNameWhere;
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
}

