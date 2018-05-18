/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/06/13 18:51:57
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/06/13 18:51:57
 * 创建者  ：工具自动生成
 * 
 */
public class VtoolsopWhere extends BaseEntity implements Serializable {

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

	/* 材料号	*/ 
	private String toolCodeWhere;

	/**
	 * 材料号取得
	 * @return toolCodeWhere
	 */
	public String getToolCodeWhere () {
		return toolCodeWhere;
	}

	/**
	 * 材料号设定
	 * @param toolCodeWhere
	 */
	public void setToolCodeWhere (String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}

	/* 入库数量	*/ 
	private BigDecimal storageNumWhere;

	/**
	 * 入库数量取得
	 * @return storageNumWhere
	 */
	public BigDecimal getStorageNumWhere () {
		return storageNumWhere;
	}

	/**
	 * 入库数量设定
	 * @param storageNumWhere
	 */
	public void setStorageNumWhere (BigDecimal storageNumWhere) {
		this.storageNumWhere = storageNumWhere;
	}

	/* 	*/ 
	private BigDecimal receiveCountWhere;

	/**
	 * 取得
	 * @return receiveCountWhere
	 */
	public BigDecimal getReceiveCountWhere () {
		return receiveCountWhere;
	}

	/**
	 * 设定
	 * @param receiveCountWhere
	 */
	public void setReceiveCountWhere (BigDecimal receiveCountWhere) {
		this.receiveCountWhere = receiveCountWhere;
	}

	/* 	*/ 
	private String inLiberWhere;

	/**
	 * 取得
	 * @return inLiberWhere
	 */
	public String getInLiberWhere () {
		return inLiberWhere;
	}

	/**
	 * 设定
	 * @param inLiberWhere
	 */
	public void setInLiberWhere (String inLiberWhere) {
		this.inLiberWhere = inLiberWhere;
	}

	/* 	*/ 
	private String outLiberWhere;

	/**
	 * 取得
	 * @return outLiberWhere
	 */
	public String getOutLiberWhere () {
		return outLiberWhere;
	}

	/**
	 * 设定
	 * @param outLiberWhere
	 */
	public void setOutLiberWhere (String outLiberWhere) {
		this.outLiberWhere = outLiberWhere;
	}

	/* 创建者	*/ 
	private String libraryUserWhere;

	/**
	 * 创建者取得
	 * @return libraryUserWhere
	 */
	public String getLibraryUserWhere () {
		return libraryUserWhere;
	}

	/**
	 * 创建者设定
	 * @param libraryUserWhere
	 */
	public void setLibraryUserWhere (String libraryUserWhere) {
		this.libraryUserWhere = libraryUserWhere;
	}

	/* 上传状态	*/ 
	private BigDecimal stateTsWhere;

	/**
	 * 上传状态取得
	 * @return stateTsWhere
	 */
	public BigDecimal getStateTsWhere () {
		return stateTsWhere;
	}

	/**
	 * 上传状态设定
	 * @param stateTsWhere
	 */
	public void setStateTsWhere (BigDecimal stateTsWhere) {
		this.stateTsWhere = stateTsWhere;
	}

	/* 上传状态	*/ 
	private BigDecimal stateStWhere;

	/**
	 * 上传状态取得
	 * @return stateStWhere
	 */
	public BigDecimal getStateStWhere () {
		return stateStWhere;
	}

	/**
	 * 上传状态设定
	 * @param stateStWhere
	 */
	public void setStateStWhere (BigDecimal stateStWhere) {
		this.stateStWhere = stateStWhere;
	}
}

