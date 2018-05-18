/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/04/25 15:31:07
 */
package com.icomp.entity.base;


import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/04/25 15:31:07
 * 创建者  ：工具自动生成
 * 
 */
public class VknifeinventoryWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他	*/ 
	private String toolConsumetypeWhere;

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他取得
	 * @return toolConsumetypeWhere
	 */
	public String getToolConsumetypeWhere () {
		return toolConsumetypeWhere;
	}

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他设定
	 * @param toolConsumetypeWhere
	 */
	public void setToolConsumetypeWhere (String toolConsumetypeWhere) {
		this.toolConsumetypeWhere = toolConsumetypeWhere;
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

	/* 刀具入库编码	*/ 
	private String knifeinventoryCodeWhere;

	/**
	 * 刀具入库编码取得
	 * @return knifeinventoryCodeWhere
	 */
	public String getKnifeinventoryCodeWhere () {
		return knifeinventoryCodeWhere;
	}

	/**
	 * 刀具入库编码设定
	 * @param knifeinventoryCodeWhere
	 */
	public void setKnifeinventoryCodeWhere (String knifeinventoryCodeWhere) {
		this.knifeinventoryCodeWhere = knifeinventoryCodeWhere;
	}

	/* 库存类型(0新刀1出厂回库2封存3返厂4外借5借入9其他)	*/ 
	private String knifeInventoryTypeWhere;

	/**
	 * 库存类型(0新刀1出厂回库2封存3返厂4外借5借入9其他)取得
	 * @return knifeInventoryTypeWhere
	 */
	public String getKnifeInventoryTypeWhere () {
		return knifeInventoryTypeWhere;
	}

	/**
	 * 库存类型(0新刀1出厂回库2封存3返厂4外借5借入9其他)设定
	 * @param knifeInventoryTypeWhere
	 */
	public void setKnifeInventoryTypeWhere (String knifeInventoryTypeWhere) {
		this.knifeInventoryTypeWhere = knifeInventoryTypeWhere;
	}

	/* 姓名	*/ 
	private String userNameWhere;

	/**
	 * 姓名取得
	 * @return userNameWhere
	 */
	public String getUserNameWhere () {
		return userNameWhere;
	}

	/**
	 * 姓名设定
	 * @param userNameWhere
	 */
	public void setUserNameWhere (String userNameWhere) {
		this.userNameWhere = userNameWhere;
	}

	/* 采购批次	*/ 
	private String procuredBatchWhere;

	/**
	 * 采购批次取得
	 * @return procuredBatchWhere
	 */
	public String getProcuredBatchWhere () {
		return procuredBatchWhere;
	}

	/**
	 * 采购批次设定
	 * @param procuredBatchWhere
	 */
	public void setProcuredBatchWhere (String procuredBatchWhere) {
		this.procuredBatchWhere = procuredBatchWhere;
	}

	/* 	*/ 
	private BigDecimal inLiberNumberWhere;

	/**
	 * 取得
	 * @return inLiberNumberWhere
	 */
	public BigDecimal getInLiberNumberWhere () {
		return inLiberNumberWhere;
	}

	/**
	 * 设定
	 * @param inLiberNumberWhere
	 */
	public void setInLiberNumberWhere (BigDecimal inLiberNumberWhere) {
		this.inLiberNumberWhere = inLiberNumberWhere;
	}
}

