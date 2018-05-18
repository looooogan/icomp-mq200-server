/*
 * 工具自动生成：合成刀流转履历条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 合成刀流转履历条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class SynthesisexperienceWhere extends BaseEntity implements Serializable {

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

	/* 位置号	*/ 
	private BigDecimal synthesisCutterNumberWhere;

	/**
	 * 位置号取得
	 * @return synthesisCutterNumberWhere
	 */
	public BigDecimal getSynthesisCutterNumberWhere () {
		return synthesisCutterNumberWhere;
	}

	/**
	 * 位置号设定
	 * @param synthesisCutterNumberWhere
	 */
	public void setSynthesisCutterNumberWhere (BigDecimal synthesisCutterNumberWhere) {
		this.synthesisCutterNumberWhere = synthesisCutterNumberWhere;
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

	/* 最后执行业务流程	*/ 
	private String businessFlowLnkIDWhere;

	/**
	 * 最后执行业务流程取得
	 * @return businessFlowLnkIDWhere
	 */
	public String getBusinessFlowLnkIDWhere () {
		return businessFlowLnkIDWhere;
	}

	/**
	 * 最后执行业务流程设定
	 * @param businessFlowLnkIDWhere
	 */
	public void setBusinessFlowLnkIDWhere (String businessFlowLnkIDWhere) {
		this.businessFlowLnkIDWhere = businessFlowLnkIDWhere;
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

	/* 转出人	*/ 
	private String arrivalUserWhere;

	/**
	 * 转出人取得
	 * @return arrivalUserWhere
	 */
	public String getArrivalUserWhere () {
		return arrivalUserWhere;
	}

	/**
	 * 转出人设定
	 * @param arrivalUserWhere
	 */
	public void setArrivalUserWhere (String arrivalUserWhere) {
		this.arrivalUserWhere = arrivalUserWhere;
	}

	/* 接收人	*/ 
	private String recipientUserWhere;

	/**
	 * 接收人取得
	 * @return recipientUserWhere
	 */
	public String getRecipientUserWhere () {
		return recipientUserWhere;
	}

	/**
	 * 接收人设定
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
}

