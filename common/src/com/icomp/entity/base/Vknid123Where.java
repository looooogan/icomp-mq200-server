/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/02/15 18:57:18
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/02/15 18:57:18
 * 创建者  ：工具自动生成
 * 
 */
public class Vknid123Where extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 	*/ 
	private String systeCodeWhere;

	/**
	 * 取得
	 * @return systeCodeWhere
	 */
	public String getSysteCodeWhere () {
		return systeCodeWhere;
	}

	/**
	 * 设定
	 * @param systeCodeWhere
	 */
	public void setSysteCodeWhere (String systeCodeWhere) {
		this.systeCodeWhere = systeCodeWhere;
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

