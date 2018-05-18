/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/19 09:33:34
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/19 09:33:34
 * 创建者  ：杨作庆
 * 
 */
public class Voperationrecord extends VoperationrecordWhere implements Serializable {

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

	/* 业务流程名	*/ 
	private String businessName;

	/**
	 * 业务流程名取得
	 * @return businessName
	 */
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * 业务流程名设定
	 * @param businessName
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/* 业务流编码	*/ 
	private String businessCode;

	/**
	 * 业务流编码取得
	 * @return businessCode
	 */
	public String getBusinessCode() {
		return businessCode;
	}

	/**
	 * 业务流编码设定
	 * @param businessCode
	 */
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	/* 操作时间	*/ 
	private Date operationTime;

	/**
	 * 操作时间取得
	 * @return operationTime
	 */
	public Date getOperationTime() {
		return operationTime;
	}

	/**
	 * 操作时间设定
	 * @param operationTime
	 */
	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}

	/* 	*/ 
	private String recipientUser;

	/**
	 * 取得
	 * @return recipientUser
	 */
	public String getRecipientUser() {
		return recipientUser;
	}

	/**
	 * 设定
	 * @param recipientUser
	 */
	public void setRecipientUser(String recipientUser) {
		this.recipientUser = recipientUser;
	}

	/* 交接原因(0送入车间1旧刀回收2不合格送回3对刀)	*/ 
	private String transitionBecause;

	/**
	 * 交接原因(0送入车间1旧刀回收2不合格送回3对刀)取得
	 * @return transitionBecause
	 */
	public String getTransitionBecause() {
		return transitionBecause;
	}

	/**
	 * 交接原因(0送入车间1旧刀回收2不合格送回3对刀)设定
	 * @param transitionBecause
	 */
	public void setTransitionBecause(String transitionBecause) {
		this.transitionBecause = transitionBecause;
	}

	/* 	*/ 
	private BigDecimal count;

	/**
	 * 取得
	 * @return count
	 */
	public BigDecimal getcount() {
		return count;
	}

	/**
	 * 设定
	 * @param count
	 */
	public void setcount(BigDecimal count) {
		this.count = count;
	}
}

