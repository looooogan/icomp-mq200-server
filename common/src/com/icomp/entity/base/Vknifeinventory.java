/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/04/25 15:31:07
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/04/25 15:31:07
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vknifeinventory extends VknifeinventoryWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他	*/ 
	private String toolConsumetype;

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他取得
	 * @return toolConsumetype
	 */
	public String getToolConsumetype() {
		return toolConsumetype;
	}

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他设定
	 * @param toolConsumetype
	 */
	public void setToolConsumetype(String toolConsumetype) {
		this.toolConsumetype = toolConsumetype;
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

	/* 刀具入库编码	*/ 
	private String knifeinventoryCode;

	/**
	 * 刀具入库编码取得
	 * @return knifeinventoryCode
	 */
	public String getKnifeinventoryCode() {
		return knifeinventoryCode;
	}

	/**
	 * 刀具入库编码设定
	 * @param knifeinventoryCode
	 */
	public void setKnifeinventoryCode(String knifeinventoryCode) {
		this.knifeinventoryCode = knifeinventoryCode;
	}

	/* 库存类型(0新刀1出厂回库2封存3返厂4外借5借入9其他)	*/ 
	private String knifeInventoryType;

	/**
	 * 库存类型(0新刀1出厂回库2封存3返厂4外借5借入9其他)取得
	 * @return knifeInventoryType
	 */
	public String getKnifeInventoryType() {
		return knifeInventoryType;
	}

	/**
	 * 库存类型(0新刀1出厂回库2封存3返厂4外借5借入9其他)设定
	 * @param knifeInventoryType
	 */
	public void setKnifeInventoryType(String knifeInventoryType) {
		this.knifeInventoryType = knifeInventoryType;
	}

	/* 姓名	*/ 
	private String userName;

	/**
	 * 姓名取得
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 姓名设定
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/* 采购批次	*/ 
	private String procuredBatch;

	/**
	 * 采购批次取得
	 * @return procuredBatch
	 */
	public String getProcuredBatch() {
		return procuredBatch;
	}

	/**
	 * 采购批次设定
	 * @param procuredBatch
	 */
	public void setProcuredBatch(String procuredBatch) {
		this.procuredBatch = procuredBatch;
	}

	/* 	*/ 
	private BigDecimal inLiberNumber;

	/**
	 * 取得
	 * @return inLiberNumber
	 */
	public BigDecimal getInLiberNumber() {
		return inLiberNumber;
	}

	/**
	 * 设定
	 * @param inLiberNumber
	 */
	public void setInLiberNumber(BigDecimal inLiberNumber) {
		this.inLiberNumber = inLiberNumber;
	}
}

