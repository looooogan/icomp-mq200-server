/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/13 14:08:26
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/13 14:08:26
 * 创建者  ：杨作庆
 * 
 */
public class VstockingWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 	*/ 
	private String toolCodeWhere;

	/**
	 * 取得
	 * @return toolCodeWhere
	 */
	public String getToolCodeWhere () {
		return toolCodeWhere;
	}

	/**
	 * 设定
	 * @param toolCodeWhere
	 */
	public void setToolCodeWhere (String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}

	/* 	*/ 
	private Date checkTimeWhere;

	/**
	 * 取得
	 * @return checkTimeWhere
	 */
	public Date getCheckTimeWhere () {
		return checkTimeWhere;
	}

	/**
	 * 设定
	 * @param checkTimeWhere
	 */
	public void setCheckTimeWhere (Date checkTimeWhere) {
		this.checkTimeWhere = checkTimeWhere;
	}

	/* 	*/ 
	private String checkUserWhere;

	/**
	 * 取得
	 * @return checkUserWhere
	 */
	public String getCheckUserWhere () {
		return checkUserWhere;
	}

	/**
	 * 设定
	 * @param checkUserWhere
	 */
	public void setCheckUserWhere (String checkUserWhere) {
		this.checkUserWhere = checkUserWhere;
	}

	/* 	*/ 
	private BigDecimal libraryCountWhere;

	/**
	 * 取得
	 * @return libraryCountWhere
	 */
	public BigDecimal getLibraryCountWhere () {
		return libraryCountWhere;
	}

	/**
	 * 设定
	 * @param libraryCountWhere
	 */
	public void setLibraryCountWhere (BigDecimal libraryCountWhere) {
		this.libraryCountWhere = libraryCountWhere;
	}

	/* 	*/ 
	private BigDecimal realLibraryCountWhere;

	/**
	 * 取得
	 * @return realLibraryCountWhere
	 */
	public BigDecimal getRealLibraryCountWhere () {
		return realLibraryCountWhere;
	}

	/**
	 * 设定
	 * @param realLibraryCountWhere
	 */
	public void setRealLibraryCountWhere (BigDecimal realLibraryCountWhere) {
		this.realLibraryCountWhere = realLibraryCountWhere;
	}

	/* 	*/ 
	private String removeUserWhere;

	/**
	 * 取得
	 * @return removeUserWhere
	 */
	public String getRemoveUserWhere () {
		return removeUserWhere;
	}

	/**
	 * 设定
	 * @param removeUserWhere
	 */
	public void setRemoveUserWhere (String removeUserWhere) {
		this.removeUserWhere = removeUserWhere;
	}
}

