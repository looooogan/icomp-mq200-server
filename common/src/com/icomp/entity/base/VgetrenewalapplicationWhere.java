/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/10/09 19:48:12
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;

import com.icomp.common.entity.BaseEntity;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/10/09 19:48:12
 * 创建者  ：杨作庆
 * 
 */
public class VgetrenewalapplicationWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* RFID(辅具或配套上打孔安装的RFID)	*/ 
	private String rfidWhere;

	/**
	 * RFID(辅具或配套上打孔安装的RFID)取得
	 * @return rfidWhere
	 */
	public String getRfidWhere () {
		return rfidWhere;
	}

	/**
	 * RFID(辅具或配套上打孔安装的RFID)设定
	 * @param rfidWhere
	 */
	public void setRfidWhere (String rfidWhere) {
		this.rfidWhere = rfidWhere;
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

	/* 刀具名称	*/ 
	private String toolNameWhere;

	/**
	 * 刀具名称取得
	 * @return toolNameWhere
	 */
	public String getToolNameWhere () {
		return toolNameWhere;
	}

	/**
	 * 刀具名称设定
	 * @param toolNameWhere
	 */
	public void setToolNameWhere (String toolNameWhere) {
		this.toolNameWhere = toolNameWhere;
	}

	/* 卸下方式(0装盒1装盘3保留)	*/ 
	private String offloadTypeWhere;

	/**
	 * 卸下方式(0装盒1装盘3保留)取得
	 * @return offloadTypeWhere
	 */
	public String getOffloadTypeWhere () {
		return offloadTypeWhere;
	}

	/**
	 * 卸下方式(0装盒1装盘3保留)设定
	 * @param offloadTypeWhere
	 */
	public void setOffloadTypeWhere (String offloadTypeWhere) {
		this.offloadTypeWhere = offloadTypeWhere;
	}

	/* 是否安装(0安装1卸下9其他)	*/ 
	private String installFlagWhere;

	/**
	 * 是否安装(0安装1卸下9其他)取得
	 * @return installFlagWhere
	 */
	public String getInstallFlagWhere () {
		return installFlagWhere;
	}

	/**
	 * 是否安装(0安装1卸下9其他)设定
	 * @param installFlagWhere
	 */
	public void setInstallFlagWhere (String installFlagWhere) {
		this.installFlagWhere = installFlagWhere;
	}

	/* 组成类型(0刀片1钻头2复合刀具3热套类)	*/ 
	private String createTypeWhere;

	/**
	 * 组成类型(0刀片1钻头2复合刀具3热套类)取得
	 * @return createTypeWhere
	 */
	public String getCreateTypeWhere () {
		return createTypeWhere;
	}

	/**
	 * 组成类型(0刀片1钻头2复合刀具3热套类)设定
	 * @param createTypeWhere
	 */
	public void setCreateTypeWhere (String createTypeWhere) {
		this.createTypeWhere = createTypeWhere;
	}

	/* 	*/ 
	private BigDecimal appleCountWhere;

	/**
	 * 取得
	 * @return appleCountWhere
	 */
	public BigDecimal getAppleCountWhere () {
		return appleCountWhere;
	}

	/**
	 * 设定
	 * @param appleCountWhere
	 */
	public void setAppleCountWhere (BigDecimal appleCountWhere) {
		this.appleCountWhere = appleCountWhere;
	}

	/* 	*/ 
	private BigDecimal inventoryCount_AWhere;

	/**
	 * 取得
	 * @return inventoryCount_AWhere
	 */
	public BigDecimal getInventoryCount_AWhere () {
		return inventoryCount_AWhere;
	}

	/**
	 * 设定
	 * @param inventoryCount_AWhere
	 */
	public void setInventoryCount_AWhere (BigDecimal inventoryCount_AWhere) {
		this.inventoryCount_AWhere = inventoryCount_AWhere;
	}

	/* 	*/ 
	private BigDecimal inventoryCount_BWhere;

	/**
	 * 取得
	 * @return inventoryCount_BWhere
	 */
	public BigDecimal getInventoryCount_BWhere () {
		return inventoryCount_BWhere;
	}

	/**
	 * 设定
	 * @param inventoryCount_BWhere
	 */
	public void setInventoryCount_BWhere (BigDecimal inventoryCount_BWhere) {
		this.inventoryCount_BWhere = inventoryCount_BWhere;
	}

	/* 	*/ 
	private BigDecimal breakKnifeCountWhere;

	/**
	 * 取得
	 * @return breakKnifeCountWhere
	 */
	public BigDecimal getBreakKnifeCountWhere () {
		return breakKnifeCountWhere;
	}

	/**
	 * 设定
	 * @param breakKnifeCountWhere
	 */
	public void setBreakKnifeCountWhere (BigDecimal breakKnifeCountWhere) {
		this.breakKnifeCountWhere = breakKnifeCountWhere;
	}

	/* 	*/ 
	private BigDecimal lostKnifeCountWhere;

	/**
	 * 取得
	 * @return lostKnifeCountWhere
	 */
	public BigDecimal getLostKnifeCountWhere () {
		return lostKnifeCountWhere;
	}

	/**
	 * 设定
	 * @param lostKnifeCountWhere
	 */
	public void setLostKnifeCountWhere (BigDecimal lostKnifeCountWhere) {
		this.lostKnifeCountWhere = lostKnifeCountWhere;
	}

	/* 确认人(断刀、丢失、不合格的状态选择时需要上级确认)	*/ 
	private String confirmedUserWhere;

	/**
	 * 确认人(断刀、丢失、不合格的状态选择时需要上级确认)取得
	 * @return confirmedUserWhere
	 */
	public String getConfirmedUserWhere () {
		return confirmedUserWhere;
	}

	/**
	 * 确认人(断刀、丢失、不合格的状态选择时需要上级确认)设定
	 * @param confirmedUserWhere
	 */
	public void setConfirmedUserWhere (String confirmedUserWhere) {
		this.confirmedUserWhere = confirmedUserWhere;
	}

	/* 	*/ 
	private String confirmedNameWhere;

	/**
	 * 取得
	 * @return confirmedNameWhere
	 */
	public String getConfirmedNameWhere () {
		return confirmedNameWhere;
	}

	/**
	 * 设定
	 * @param confirmedNameWhere
	 */
	public void setConfirmedNameWhere (String confirmedNameWhere) {
		this.confirmedNameWhere = confirmedNameWhere;
	}
}

