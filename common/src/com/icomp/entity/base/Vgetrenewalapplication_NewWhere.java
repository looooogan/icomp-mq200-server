/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/12/08 11:43:43
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/12/08 11:43:43
 * 创建者  ：杨作庆
 * 
 */
public class Vgetrenewalapplication_NewWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 合成刀具编码(系统唯一)	*/ 
	private String synthesisParametersCodeWhere;

	/**
	 * 合成刀具编码(系统唯一)取得
	 * @return synthesisParametersCodeWhere
	 */
	public String getSynthesisParametersCodeWhere () {
		return synthesisParametersCodeWhere;
	}

	/**
	 * 合成刀具编码(系统唯一)设定
	 * @param synthesisParametersCodeWhere
	 */
	public void setSynthesisParametersCodeWhere (String synthesisParametersCodeWhere) {
		this.synthesisParametersCodeWhere = synthesisParametersCodeWhere;
	}

	/* 合成刀具编号(例如：001、002、003)	*/ 
	private String synthesisParametersNumberWhere;

	/**
	 * 合成刀具编号(例如：001、002、003)取得
	 * @return synthesisParametersNumberWhere
	 */
	public String getSynthesisParametersNumberWhere () {
		return synthesisParametersNumberWhere;
	}

	/**
	 * 合成刀具编号(例如：001、002、003)设定
	 * @param synthesisParametersNumberWhere
	 */
	public void setSynthesisParametersNumberWhere (String synthesisParametersNumberWhere) {
		this.synthesisParametersNumberWhere = synthesisParametersNumberWhere;
	}

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
}

