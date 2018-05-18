/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/12/08 11:43:43
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/12/08 11:43:43
 * 创建者  ：杨作庆
 * 
 */
public class Vgetrenewalapplication_New extends Vgetrenewalapplication_NewWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 合成刀具编码(系统唯一)	*/ 
	private String synthesisParametersCode;

	/**
	 * 合成刀具编码(系统唯一)取得
	 * @return synthesisParametersCode
	 */
	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	/**
	 * 合成刀具编码(系统唯一)设定
	 * @param synthesisParametersCode
	 */
	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}

	/* 合成刀具编号(例如：001、002、003)	*/ 
	private String synthesisParametersNumber;

	/**
	 * 合成刀具编号(例如：001、002、003)取得
	 * @return synthesisParametersNumber
	 */
	public String getSynthesisParametersNumber() {
		return synthesisParametersNumber;
	}

	/**
	 * 合成刀具编号(例如：001、002、003)设定
	 * @param synthesisParametersNumber
	 */
	public void setSynthesisParametersNumber(String synthesisParametersNumber) {
		this.synthesisParametersNumber = synthesisParametersNumber;
	}

	/* RFID(辅具或配套上打孔安装的RFID)	*/ 
	private String rfid;

	/**
	 * RFID(辅具或配套上打孔安装的RFID)取得
	 * @return rfid
	 */
	public String getRfid() {
		return rfid;
	}

	/**
	 * RFID(辅具或配套上打孔安装的RFID)设定
	 * @param rfid
	 */
	public void setRfid(String rfid) {
		this.rfid = rfid;
	}

	/* 刀具ID	*/ 
	private String toolID;

	/**
	 * 刀具ID取得
	 * @return toolID
	 */
	public String getToolID() {
		return toolID;
	}

	/**
	 * 刀具ID设定
	 * @param toolID
	 */
	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	/* 刀具编码	*/ 
	private String toolCode;

	/**
	 * 刀具编码取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 刀具编码设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 刀具名称	*/ 
	private String toolName;

	/**
	 * 刀具名称取得
	 * @return toolName
	 */
	public String getToolName() {
		return toolName;
	}

	/**
	 * 刀具名称设定
	 * @param toolName
	 */
	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	/* 卸下方式(0装盒1装盘3保留)	*/ 
	private String offloadType;

	/**
	 * 卸下方式(0装盒1装盘3保留)取得
	 * @return offloadType
	 */
	public String getOffloadType() {
		return offloadType;
	}

	/**
	 * 卸下方式(0装盒1装盘3保留)设定
	 * @param offloadType
	 */
	public void setOffloadType(String offloadType) {
		this.offloadType = offloadType;
	}

	/* 是否安装(0安装1卸下9其他)	*/ 
	private String installFlag;

	/**
	 * 是否安装(0安装1卸下9其他)取得
	 * @return installFlag
	 */
	public String getInstallFlag() {
		return installFlag;
	}

	/**
	 * 是否安装(0安装1卸下9其他)设定
	 * @param installFlag
	 */
	public void setInstallFlag(String installFlag) {
		this.installFlag = installFlag;
	}

	/* 组成类型(0刀片1钻头2复合刀具3热套类)	*/ 
	private String createType;

	/**
	 * 组成类型(0刀片1钻头2复合刀具3热套类)取得
	 * @return createType
	 */
	public String getCreateType() {
		return createType;
	}

	/**
	 * 组成类型(0刀片1钻头2复合刀具3热套类)设定
	 * @param createType
	 */
	public void setCreateType(String createType) {
		this.createType = createType;
	}

	/* 	*/ 
	private BigDecimal appleCount;

	/**
	 * 取得
	 * @return appleCount
	 */
	public BigDecimal getAppleCount() {
		return appleCount;
	}

	/**
	 * 设定
	 * @param appleCount
	 */
	public void setAppleCount(BigDecimal appleCount) {
		this.appleCount = appleCount;
	}

	/* 	*/ 
	private BigDecimal inventoryCount_A;

	/**
	 * 取得
	 * @return inventoryCount_A
	 */
	public BigDecimal getInventoryCount_A() {
		return inventoryCount_A;
	}

	/**
	 * 设定
	 * @param inventoryCount_A
	 */
	public void setInventoryCount_A(BigDecimal inventoryCount_A) {
		this.inventoryCount_A = inventoryCount_A;
	}

	/* 	*/ 
	private BigDecimal inventoryCount_B;

	/**
	 * 取得
	 * @return inventoryCount_B
	 */
	public BigDecimal getInventoryCount_B() {
		return inventoryCount_B;
	}

	/**
	 * 设定
	 * @param inventoryCount_B
	 */
	public void setInventoryCount_B(BigDecimal inventoryCount_B) {
		this.inventoryCount_B = inventoryCount_B;
	}
}

