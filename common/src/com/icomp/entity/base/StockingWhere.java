/*
 * 工具自动生成：库存盘点条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 库存盘点条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class StockingWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 	*/ 
	private String stockingIDWhere;

	/**
	 * 取得
	 * @return stockingIDWhere
	 */
	public String getStockingIDWhere () {
		return stockingIDWhere;
	}

	/**
	 * 设定
	 * @param stockingIDWhere
	 */
	public void setStockingIDWhere (String stockingIDWhere) {
		this.stockingIDWhere = stockingIDWhere;
	}

	/* RFID载体ID	*/ 
	private String rfidContainerIDWhere;

	/**
	 * RFID载体ID取得
	 * @return rfidContainerIDWhere
	 */
	public String getRfidContainerIDWhere () {
		return rfidContainerIDWhere;
	}

	/**
	 * RFID载体ID设定
	 * @param rfidContainerIDWhere
	 */
	public void setRfidContainerIDWhere (String rfidContainerIDWhere) {
		this.rfidContainerIDWhere = rfidContainerIDWhere;
	}

	/* 盘点时间	*/ 
	private Date checkTimeWhere;

	/**
	 * 盘点时间取得
	 * @return checkTimeWhere
	 */
	public Date getCheckTimeWhere () {
		return checkTimeWhere;
	}

	/**
	 * 盘点时间设定
	 * @param checkTimeWhere
	 */
	public void setCheckTimeWhere (Date checkTimeWhere) {
		this.checkTimeWhere = checkTimeWhere;
	}

	/* 盘点人	*/ 
	private String checkUserWhere;

	/**
	 * 盘点人取得
	 * @return checkUserWhere
	 */
	public String getCheckUserWhere () {
		return checkUserWhere;
	}

	/**
	 * 盘点人设定
	 * @param checkUserWhere
	 */
	public void setCheckUserWhere (String checkUserWhere) {
		this.checkUserWhere = checkUserWhere;
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

	/* 批次	*/ 
	private String procuredBatchWhere;

	/**
	 * 批次取得
	 * @return procuredBatchWhere
	 */
	public String getProcuredBatchWhere () {
		return procuredBatchWhere;
	}

	/**
	 * 批次设定
	 * @param procuredBatchWhere
	 */
	public void setProcuredBatchWhere (String procuredBatchWhere) {
		this.procuredBatchWhere = procuredBatchWhere;
	}

	/* 应在库数量	*/ 
	private BigDecimal libraryCountWhere;

	/**
	 * 应在库数量取得
	 * @return libraryCountWhere
	 */
	public BigDecimal getLibraryCountWhere () {
		return libraryCountWhere;
	}

	/**
	 * 应在库数量设定
	 * @param libraryCountWhere
	 */
	public void setLibraryCountWhere (BigDecimal libraryCountWhere) {
		this.libraryCountWhere = libraryCountWhere;
	}

	/* 实际在库数量	*/ 
	private BigDecimal realLibraryCountWhere;

	/**
	 * 实际在库数量取得
	 * @return realLibraryCountWhere
	 */
	public BigDecimal getRealLibraryCountWhere () {
		return realLibraryCountWhere;
	}

	/**
	 * 实际在库数量设定
	 * @param realLibraryCountWhere
	 */
	public void setRealLibraryCountWhere (BigDecimal realLibraryCountWhere) {
		this.realLibraryCountWhere = realLibraryCountWhere;
	}

	/* 单价	*/ 
	private BigDecimal unitPriceWhere;

	/**
	 * 单价取得
	 * @return unitPriceWhere
	 */
	public BigDecimal getUnitPriceWhere () {
		return unitPriceWhere;
	}

	/**
	 * 单价设定
	 * @param unitPriceWhere
	 */
	public void setUnitPriceWhere (BigDecimal unitPriceWhere) {
		this.unitPriceWhere = unitPriceWhere;
	}

	/* 在库金额	*/ 
	private BigDecimal baseAmountWhere;

	/**
	 * 在库金额取得
	 * @return baseAmountWhere
	 */
	public BigDecimal getBaseAmountWhere () {
		return baseAmountWhere;
	}

	/**
	 * 在库金额设定
	 * @param baseAmountWhere
	 */
	public void setBaseAmountWhere (BigDecimal baseAmountWhere) {
		this.baseAmountWhere = baseAmountWhere;
	}

	/* 授权人(盘点出现盘亏盘盈授权)	*/ 
	private String removeUserWhere;

	/**
	 * 授权人(盘点出现盘亏盘盈授权)取得
	 * @return removeUserWhere
	 */
	public String getRemoveUserWhere () {
		return removeUserWhere;
	}

	/**
	 * 授权人(盘点出现盘亏盘盈授权)设定
	 * @param removeUserWhere
	 */
	public void setRemoveUserWhere (String removeUserWhere) {
		this.removeUserWhere = removeUserWhere;
	}

	/* 操作人	*/ 
	private String systemLogUserWhere;

	/**
	 * 操作人取得
	 * @return systemLogUserWhere
	 */
	public String getSystemLogUserWhere () {
		return systemLogUserWhere;
	}

	/**
	 * 操作人设定
	 * @param systemLogUserWhere
	 */
	public void setSystemLogUserWhere (String systemLogUserWhere) {
		this.systemLogUserWhere = systemLogUserWhere;
	}
}

