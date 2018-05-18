/*
 * 工具自动生成：货架基础表实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * 货架基础表实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class Stack extends StackWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 货架ID	*/ 
	private String stackID;

	/**
	 * 货架ID取得
	 * @return stackID
	 */
	public String getStackID() {
		return stackID;
	}

	/**
	 * 货架ID设定
	 * @param stackID
	 */
	public void setStackID(String stackID) {
		this.stackID = stackID;
	}

	/* 库位码主键	*/ 
	private String libraryCodeID;

	/**
	 * 库位码主键取得
	 * @return libraryCodeID
	 */
	public String getLibraryCodeID() {
		return libraryCodeID;
	}

	/**
	 * 库位码主键设定
	 * @param libraryCodeID
	 */
	public void setLibraryCodeID(String libraryCodeID) {
		this.libraryCodeID = libraryCodeID;
	}

	/* 厂区	*/ 
	private String complex;

	/**
	 * 厂区取得
	 * @return complex
	 */
	public String getComplex() {
		return complex;
	}

	/**
	 * 厂区设定
	 * @param complex
	 */
	public void setComplex(String complex) {
		this.complex = complex;
	}

	/* 库房号	*/ 
	private String depot;

	/**
	 * 库房号取得
	 * @return depot
	 */
	public String getDepot() {
		return depot;
	}

	/**
	 * 库房号设定
	 * @param depot
	 */
	public void setDepot(String depot) {
		this.depot = depot;
	}

	/* 货架	*/ 
	private String shelf;

	/**
	 * 货架取得
	 * @return shelf
	 */
	public String getShelf() {
		return shelf;
	}

	/**
	 * 货架设定
	 * @param shelf
	 */
	public void setShelf(String shelf) {
		this.shelf = shelf;
	}

	/* 层	*/ 
	private String layer;

	/**
	 * 层取得
	 * @return layer
	 */
	public String getLayer() {
		return layer;
	}

	/**
	 * 层设定
	 * @param layer
	 */
	public void setLayer(String layer) {
		this.layer = layer;
	}

	/* 货位	*/ 
	private String stack;

	/**
	 * 货位取得
	 * @return stack
	 */
	public String getStack() {
		return stack;
	}

	/**
	 * 货位设定
	 * @param stack
	 */
	public void setStack(String stack) {
		this.stack = stack;
	}
	
	/* 备注	*/ 
	private String remark;

	/**
	 * 取得
	 * @return remark
	 */
	public String getremark() {
		return remark;
	}

	/**
	 * 设定
	 * @param remark
	 */
	public void setremark(String remark) {
		this.remark = remark;
	}
}

