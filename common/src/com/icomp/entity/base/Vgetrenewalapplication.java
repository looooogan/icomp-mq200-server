/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/09/30 15:17:34
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/09/30 15:17:34
 * 创建者  ：杨作庆
 * 
 */
public class Vgetrenewalapplication extends VgetrenewalapplicationWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 申请数量	*/ 
	private BigDecimal appleCount;

	/**
	 * 申请数量取得
	 * @return appleCount
	 */
	public BigDecimal getAppleCount() {
		return appleCount;
	}

	/**
	 * 申请数量设定
	 * @param appleCount
	 */
	public void setAppleCount(BigDecimal appleCount) {
		this.appleCount = appleCount;
	}

	/* A库库存	*/ 
	private BigDecimal inventoryCount_A;

	/**
	 * A库库存取得
	 * @return inventoryCount_A
	 */
	public BigDecimal getInventoryCount_A() {
		return inventoryCount_A;
	}

	/**
	 * A库库存设定
	 * @param inventoryCount_A
	 */
	public void setInventoryCount_A(BigDecimal inventoryCount_A) {
		this.inventoryCount_A = inventoryCount_A;
	}

	/* B库库存	*/ 
	private BigDecimal inventoryCount_B;

	/**
	 *B库库存 取得
	 * @return inventoryCount_B
	 */
	public BigDecimal getInventoryCount_B() {
		return inventoryCount_B;
	}

	/**
	 * B库库存设定
	 * @param inventoryCount_B
	 */
	public void setInventoryCount_B(BigDecimal inventoryCount_B) {
		this.inventoryCount_B = inventoryCount_B;
	}

	/* 断刀数量	*/ 
	private BigDecimal breakKnifeCount;

	/**
	 * 断刀数量取得
	 * @return breakKnifeCount
	 */
	public BigDecimal getBreakKnifeCount() {
		return breakKnifeCount;
	}

	/**
	 * 断刀数量设定
	 * @param breakKnifeCount
	 */
	public void setBreakKnifeCount(BigDecimal breakKnifeCount) {
		this.breakKnifeCount = breakKnifeCount;
	}

	/* 丢刀数量	*/ 
	private BigDecimal lostKnifeCount;

	/**
	 * 丢刀数量取得
	 * @return lostKnifeCount
	 */
	public BigDecimal getLostKnifeCount() {
		return lostKnifeCount;
	}

	/**
	 * 丢刀数量设定
	 * @param lostKnifeCount
	 */
	public void setLostKnifeCount(BigDecimal lostKnifeCount) {
		this.lostKnifeCount = lostKnifeCount;
	}

	/* 确认人(断刀、丢失、不合格的状态选择时需要上级确认)	*/ 
	private String confirmedUser;

	/**
	 * 确认人(断刀、丢失、不合格的状态选择时需要上级确认)取得
	 * @return confirmedUser
	 */
	public String getConfirmedUser() {
		return confirmedUser;
	}

	/**
	 * 确认人(断刀、丢失、不合格的状态选择时需要上级确认)设定
	 * @param confirmedUser
	 */
	public void setConfirmedUser(String confirmedUser) {
		this.confirmedUser = confirmedUser;
	}

	/*确认人名称 	*/ 
	private String confirmedName;

	/**
	 * 确认人名称取得
	 * @return confirmedName
	 */
	public String getConfirmedName() {
		return confirmedName;
	}

	/**
	 * 确认人名称设定
	 * @param confirmedName
	 */
	public void setConfirmedName(String confirmedName) {
		this.confirmedName = confirmedName;
	}
	//送回数量[申请数量—(断刀数量+丢刀数量)]
	private int returnCount;
	
	/**
	 * 送回数量[申请数量—(断刀数量+丢刀数量)]
	 * @title getReturnCount 
	 * @return
	 * int
	 */
	public int getReturnCount() {
		return returnCount;
	}
	
	/**
	 * 送回数量[申请数量—(断刀数量+丢刀数量)]
	 * @title setReturnCount 
	 * @param returnCount
	 * void
	 */
	public void setReturnCount(int returnCount) {
		this.returnCount = returnCount;
	} 
	
	
}

