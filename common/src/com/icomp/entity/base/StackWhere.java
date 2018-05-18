/*
 * 工具自动生成：货架基础表条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * 货架基础表条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class StackWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 货架ID	*/ 
	private String stackIDWhere;

	/**
	 * 货架ID取得
	 * @return stackIDWhere
	 */
	public String getStackIDWhere () {
		return stackIDWhere;
	}

	/**
	 * 货架ID设定
	 * @param stackIDWhere
	 */
	public void setStackIDWhere (String stackIDWhere) {
		this.stackIDWhere = stackIDWhere;
	}

	/* 库位码主键	*/ 
	private String libraryCodeIDWhere;

	/**
	 * 库位码主键取得
	 * @return libraryCodeIDWhere
	 */
	public String getLibraryCodeIDWhere () {
		return libraryCodeIDWhere;
	}

	/**
	 * 库位码主键设定
	 * @param libraryCodeIDWhere
	 */
	public void setLibraryCodeIDWhere (String libraryCodeIDWhere) {
		this.libraryCodeIDWhere = libraryCodeIDWhere;
	}

	/* 厂区	*/ 
	private String complexWhere;

	/**
	 * 厂区取得
	 * @return complexWhere
	 */
	public String getComplexWhere () {
		return complexWhere;
	}

	/**
	 * 厂区设定
	 * @param complexWhere
	 */
	public void setComplexWhere (String complexWhere) {
		this.complexWhere = complexWhere;
	}

	/* 库房号	*/ 
	private String depotWhere;

	/**
	 * 库房号取得
	 * @return depotWhere
	 */
	public String getDepotWhere () {
		return depotWhere;
	}

	/**
	 * 库房号设定
	 * @param depotWhere
	 */
	public void setDepotWhere (String depotWhere) {
		this.depotWhere = depotWhere;
	}

	/* 货架	*/ 
	private String shelfWhere;

	/**
	 * 货架取得
	 * @return shelfWhere
	 */
	public String getShelfWhere () {
		return shelfWhere;
	}

	/**
	 * 货架设定
	 * @param shelfWhere
	 */
	public void setShelfWhere (String shelfWhere) {
		this.shelfWhere = shelfWhere;
	}

	/* 层	*/ 
	private String layerWhere;

	/**
	 * 层取得
	 * @return layerWhere
	 */
	public String getLayerWhere () {
		return layerWhere;
	}

	/**
	 * 层设定
	 * @param layerWhere
	 */
	public void setLayerWhere (String layerWhere) {
		this.layerWhere = layerWhere;
	}

	/* 货位	*/ 
	private String stackWhere;

	/**
	 * 货位取得
	 * @return stackWhere
	 */
	public String getStackWhere () {
		return stackWhere;
	}

	/**
	 * 货位设定
	 * @param stackWhere
	 */
	public void setStackWhere (String stackWhere) {
		this.stackWhere = stackWhere;
	}
	/* 	备注*/ 
	private String remarkWhere;

	/**
	 * 取得
	 * @return remarkWhere
	 */
	public String getremarkWhere () {
		return remarkWhere;
	}

	/**
	 * 设定
	 * @param remarkWhere
	 */
	public void setremarkWhere (String remarkWhere) {
		this.remarkWhere = remarkWhere;
	}
}

