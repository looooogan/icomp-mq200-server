/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class VgettoolplateWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* RFID标签ID	*/ 
	private String rfidCodeWhere;

	/**
	 * RFID标签ID取得
	 * @return rfidCodeWhere
	 */
	public String getRfidCodeWhere () {
		return rfidCodeWhere;
	}

	/**
	 * RFID标签ID设定
	 * @param rfidCodeWhere
	 */
	public void setRfidCodeWhere (String rfidCodeWhere) {
		this.rfidCodeWhere = rfidCodeWhere;
	}

	/* 工具盘ID	*/ 
	private String toolShelfIDWhere;

	/**
	 * 工具盘ID取得
	 * @return toolShelfIDWhere
	 */
	public String getToolShelfIDWhere () {
		return toolShelfIDWhere;
	}

	/**
	 * 工具盘ID设定
	 * @param toolShelfIDWhere
	 */
	public void setToolShelfIDWhere (String toolShelfIDWhere) {
		this.toolShelfIDWhere = toolShelfIDWhere;
	}

	/* 工具盘编号	*/ 
	private String toolShelfCodeWhere;

	/**
	 * 工具盘编号取得
	 * @return toolShelfCodeWhere
	 */
	public String getToolShelfCodeWhere () {
		return toolShelfCodeWhere;
	}

	/**
	 * 工具盘编号设定
	 * @param toolShelfCodeWhere
	 */
	public void setToolShelfCodeWhere (String toolShelfCodeWhere) {
		this.toolShelfCodeWhere = toolShelfCodeWhere;
	}

	/* 	*/ 
	private String toolShelfPlaceNumberWhere;

	/**
	 * 取得
	 * @return toolShelfPlaceNumberWhere
	 */
	public String getToolShelfPlaceNumberWhere () {
		return toolShelfPlaceNumberWhere;
	}

	/**
	 * 设定
	 * @param toolShelfPlaceNumberWhere
	 */
	public void setToolShelfPlaceNumberWhere (String toolShelfPlaceNumberWhere) {
		this.toolShelfPlaceNumberWhere = toolShelfPlaceNumberWhere;
	}

	/* 刀具入库编码	*/ 
	private String knifeInventoryCodeWhere;

	/**
	 * 刀具入库编码取得
	 * @return knifeInventoryCodeWhere
	 */
	public String getKnifeInventoryCodeWhere () {
		return knifeInventoryCodeWhere;
	}

	/**
	 * 刀具入库编码设定
	 * @param knifeInventoryCodeWhere
	 */
	public void setKnifeInventoryCodeWhere (String knifeInventoryCodeWhere) {
		this.knifeInventoryCodeWhere = knifeInventoryCodeWhere;
	}

	/* 工具盘位置ID	*/ 
	private String toolshelfplaceWhere;

	/**
	 * 工具盘位置ID取得
	 * @return toolshelfplaceWhere
	 */
	public String gettoolshelfplaceWhere () {
		return toolshelfplaceWhere;
	}

	/**
	 * 工具盘位置ID设定
	 * @param toolshelfplaceWhere
	 */
	public void settoolshelfplaceWhere (String toolshelfplaceWhere) {
		this.toolshelfplaceWhere = toolshelfplaceWhere;
	}

	/* 工具盘位置号	*/ 
	private BigDecimal placeNumberWhere;

	/**
	 * 工具盘位置号取得
	 * @return placeNumberWhere
	 */
	public BigDecimal getPlaceNumberWhere () {
		return placeNumberWhere;
	}

	/**
	 * 工具盘位置号设定
	 * @param placeNumberWhere
	 */
	public void setPlaceNumberWhere (BigDecimal placeNumberWhere) {
		this.placeNumberWhere = placeNumberWhere;
	}

	/* 工具盘位置编码	*/ 
	private String placeCodeWhere;

	/**
	 * 工具盘位置编码取得
	 * @return placeCodeWhere
	 */
	public String getPlaceCodeWhere () {
		return placeCodeWhere;
	}

	/**
	 * 工具盘位置编码设定
	 * @param placeCodeWhere
	 */
	public void setPlaceCodeWhere (String placeCodeWhere) {
		this.placeCodeWhere = placeCodeWhere;
	}
}

