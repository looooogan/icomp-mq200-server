/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:05
 * 创建者  ：杨作庆
 * 
 */
public class Vstack extends VstackWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 区分文本	*/ 
	private String complexName;

	/**
	 * 区分文本取得
	 * @return complexName
	 */
	public String getComplexName() {
		return complexName;
	}

	/**
	 * 区分文本设定
	 * @param complexName
	 */
	public void setComplexName(String complexName) {
		this.complexName = complexName;
	}

	/* 区分文本	*/ 
	private String depotName;

	/**
	 * 区分文本取得
	 * @return depotName
	 */
	public String getDepotName() {
		return depotName;
	}

	/**
	 * 区分文本设定
	 * @param depotName
	 */
	public void setDepotName(String depotName) {
		this.depotName = depotName;
	}

	/* 区分文本	*/ 
	private String layerName;

	/**
	 * 区分文本取得
	 * @return layerName
	 */
	public String getLayerName() {
		return layerName;
	}

	/**
	 * 区分文本设定
	 * @param layerName
	 */
	public void setLayerName(String layerName) {
		this.layerName = layerName;
	}

	/* 区分文本	*/ 
	private String shelfName;

	/**
	 * 区分文本取得
	 * @return shelfName
	 */
	public String getShelfName() {
		return shelfName;
	}

	/**
	 * 区分文本设定
	 * @param shelfName
	 */
	public void setShelfName(String shelfName) {
		this.shelfName = shelfName;
	}

	/* 区分文本	*/ 
	private String stackName;

	/**
	 * 区分文本取得
	 * @return stackName
	 */
	public String getStackName() {
		return stackName;
	}

	/**
	 * 区分文本设定
	 * @param stackName
	 */
	public void setStackName(String stackName) {
		this.stackName = stackName;
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

	/* 系统编码	*/ 
	private String systeCode;

	/**
	 * 系统编码取得
	 * @return systeCode
	 */
	public String getSysteCode() {
		return systeCode;
	}

	/**
	 * 系统编码设定
	 * @param systeCode
	 */
	public void setSysteCode(String systeCode) {
		this.systeCode = systeCode;
	}

	/* 自定义编码	*/ 
	private String customerCode;

	/**
	 * 自定义编码取得
	 * @return customerCode
	 */
	public String getCustomerCode() {
		return customerCode;
	}

	/**
	 * 自定义编码设定
	 * @param customerCode
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	/* 	*/ 
	private String systeCodeShow;

	/**
	 * 取得
	 * @return systeCodeShow
	 */
	public String getSysteCodeShow() {
		return systeCodeShow;
	}

	/**
	 * 设定
	 * @param systeCodeShow
	 */
	public void setSysteCodeShow(String systeCodeShow) {
		this.systeCodeShow = systeCodeShow;
	}

	/* 操作人	*/ 
	private String systemLogUser;

	/**
	 * 操作人取得
	 * @return systemLogUser
	 */
	public String getSystemLogUser() {
		return systemLogUser;
	}

	/**
	 * 操作人设定
	 * @param systemLogUser
	 */
	public void setSystemLogUser(String systemLogUser) {
		this.systemLogUser = systemLogUser;
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

