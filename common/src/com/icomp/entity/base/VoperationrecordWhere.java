/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/19 09:33:34
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/19 09:33:34
 * 创建者  ：杨作庆
 * 
 */
public class VoperationrecordWhere extends BaseEntity implements Serializable {

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

	/* 业务流程名	*/ 
	private String businessNameWhere;

	/**
	 * 业务流程名取得
	 * @return businessNameWhere
	 */
	public String getBusinessNameWhere () {
		return businessNameWhere;
	}

	/**
	 * 业务流程名设定
	 * @param businessNameWhere
	 */
	public void setBusinessNameWhere (String businessNameWhere) {
		this.businessNameWhere = businessNameWhere;
	}

	/* 业务流编码	*/ 
	private String businessCodeWhere;

	/**
	 * 业务流编码取得
	 * @return businessCodeWhere
	 */
	public String getBusinessCodeWhere () {
		return businessCodeWhere;
	}

	/**
	 * 业务流编码设定
	 * @param businessCodeWhere
	 */
	public void setBusinessCodeWhere (String businessCodeWhere) {
		this.businessCodeWhere = businessCodeWhere;
	}

	/* 操作时间	*/ 
	private Date operationTimeWhere;

	/**
	 * 操作时间取得
	 * @return operationTimeWhere
	 */
	public Date getOperationTimeWhere () {
		return operationTimeWhere;
	}

	/**
	 * 操作时间设定
	 * @param operationTimeWhere
	 */
	public void setOperationTimeWhere (Date operationTimeWhere) {
		this.operationTimeWhere = operationTimeWhere;
	}

	/* 	*/ 
	private String recipientUserWhere;

	/**
	 * 取得
	 * @return recipientUserWhere
	 */
	public String getRecipientUserWhere () {
		return recipientUserWhere;
	}

	/**
	 * 设定
	 * @param recipientUserWhere
	 */
	public void setRecipientUserWhere (String recipientUserWhere) {
		this.recipientUserWhere = recipientUserWhere;
	}

	/* 交接原因(0送入车间1旧刀回收2不合格送回3对刀)	*/ 
	private String transitionBecauseWhere;

	/**
	 * 交接原因(0送入车间1旧刀回收2不合格送回3对刀)取得
	 * @return transitionBecauseWhere
	 */
	public String getTransitionBecauseWhere () {
		return transitionBecauseWhere;
	}

	/**
	 * 交接原因(0送入车间1旧刀回收2不合格送回3对刀)设定
	 * @param transitionBecauseWhere
	 */
	public void setTransitionBecauseWhere (String transitionBecauseWhere) {
		this.transitionBecauseWhere = transitionBecauseWhere;
	}

	/* 	*/ 
	private BigDecimal countWhere;

	/**
	 * 取得
	 * @return countWhere
	 */
	public BigDecimal getcountWhere () {
		return countWhere;
	}

	/**
	 * 设定
	 * @param countWhere
	 */
	public void setcountWhere (BigDecimal countWhere) {
		this.countWhere = countWhere;
	}
}

