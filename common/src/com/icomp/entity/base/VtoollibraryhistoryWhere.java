/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/04/25 17:20:14
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/04/25 17:20:14
 * 创建者  ：工具自动生成
 * 
 */
public class VtoollibraryhistoryWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具ID	*/ 
	private String toolIDWhere;

	/**
	 * 刀具ID取得
	 * @return toolIDWhere
	 */
	public String getToolIDWhere () {
		return toolIDWhere;
	}

	/**
	 * 刀具ID设定
	 * @param toolIDWhere
	 */
	public void setToolIDWhere (String toolIDWhere) {
		this.toolIDWhere = toolIDWhere;
	}

	/* 刀具分类(0刀具1辅具2配套9其他）	*/ 
	private String toolTypeWhere;

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）取得
	 * @return toolTypeWhere
	 */
	public String getToolTypeWhere () {
		return toolTypeWhere;
	}

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）设定
	 * @param toolTypeWhere
	 */
	public void setToolTypeWhere (String toolTypeWhere) {
		this.toolTypeWhere = toolTypeWhere;
	}

	/* 刀具编码	*/ 
	private String toolCodeWhere;

	/**
	 * 刀具编码取得
	 * @return toolCodeWhere
	 */
	public String getToolCodeWhere () {
		return toolCodeWhere;
	}

	/**
	 * 刀具编码设定
	 * @param toolCodeWhere
	 */
	public void setToolCodeWhere (String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}

	/* 领取时间	*/ 
	private Date receiveTimeWhere;

	/**
	 * 领取时间取得
	 * @return receiveTimeWhere
	 */
	public Date getReceiveTimeWhere () {
		return receiveTimeWhere;
	}

	/**
	 * 领取时间设定
	 * @param receiveTimeWhere
	 */
	public void setReceiveTimeWhere (Date receiveTimeWhere) {
		this.receiveTimeWhere = receiveTimeWhere;
	}

	/* 	*/ 
	private String libraryUserWhere;

	/**
	 * 取得
	 * @return libraryUserWhere
	 */
	public String getLibraryUserWhere () {
		return libraryUserWhere;
	}

	/**
	 * 设定
	 * @param libraryUserWhere
	 */
	public void setLibraryUserWhere (String libraryUserWhere) {
		this.libraryUserWhere = libraryUserWhere;
	}

	/* 	*/ 
	private String receiveUserWhere;

	/**
	 * 取得
	 * @return receiveUserWhere
	 */
	public String getReceiveUserWhere () {
		return receiveUserWhere;
	}

	/**
	 * 设定
	 * @param receiveUserWhere
	 */
	public void setReceiveUserWhere (String receiveUserWhere) {
		this.receiveUserWhere = receiveUserWhere;
	}

	/* 出库原因(0申领1换领2外借)	*/ 
	private String libraryCauseWhere;

	/**
	 * 出库原因(0申领1换领2外借)取得
	 * @return libraryCauseWhere
	 */
	public String getLibraryCauseWhere () {
		return libraryCauseWhere;
	}

	/**
	 * 出库原因(0申领1换领2外借)设定
	 * @param libraryCauseWhere
	 */
	public void setLibraryCauseWhere (String libraryCauseWhere) {
		this.libraryCauseWhere = libraryCauseWhere;
	}

	/* 	*/ 
	private String replacementReasonWhere;

	/**
	 * 取得
	 * @return replacementReasonWhere
	 */
	public String getReplacementReasonWhere () {
		return replacementReasonWhere;
	}

	/**
	 * 设定
	 * @param replacementReasonWhere
	 */
	public void setReplacementReasonWhere (String replacementReasonWhere) {
		this.replacementReasonWhere = replacementReasonWhere;
	}

	/* 领取数量	*/ 
	private BigDecimal receiveCountWhere;

	/**
	 * 领取数量取得
	 * @return receiveCountWhere
	 */
	public BigDecimal getReceiveCountWhere () {
		return receiveCountWhere;
	}

	/**
	 * 领取数量设定
	 * @param receiveCountWhere
	 */
	public void setReceiveCountWhere (BigDecimal receiveCountWhere) {
		this.receiveCountWhere = receiveCountWhere;
	}
}

