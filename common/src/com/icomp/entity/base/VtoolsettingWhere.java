/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:05
 * 创建者  ：杨作庆
 * 
 */
public class VtoolsettingWhere extends BaseEntity implements Serializable {

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

	/* 姓名	*/ 
	private String arrivalUserWhere;

	/**
	 * 姓名取得
	 * @return arrivalUserWhere
	 */
	public String getArrivalUserWhere () {
		return arrivalUserWhere;
	}

	/**
	 * 姓名设定
	 * @param arrivalUserWhere
	 */
	public void setArrivalUserWhere (String arrivalUserWhere) {
		this.arrivalUserWhere = arrivalUserWhere;
	}

	/* 姓名	*/ 
	private String recipientUserWhere;

	/**
	 * 姓名取得
	 * @return recipientUserWhere
	 */
	public String getRecipientUserWhere () {
		return recipientUserWhere;
	}

	/**
	 * 姓名设定
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

	/* 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上)(该状态绑定到带标签的数据上)	*/ 
	private String loadStateWhere;

	/**
	 * 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上)(该状态绑定到带标签的数据上)取得
	 * @return loadStateWhere
	 */
	public String getLoadStateWhere () {
		return loadStateWhere;
	}

	/**
	 * 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上)(该状态绑定到带标签的数据上)设定
	 * @param loadStateWhere
	 */
	public void setLoadStateWhere (String loadStateWhere) {
		this.loadStateWhere = loadStateWhere;
	}

	/* 姓名	*/ 
	private String knifeManWhere;

	/**
	 * 姓名取得
	 * @return knifeManWhere
	 */
	public String getKnifeManWhere () {
		return knifeManWhere;
	}

	/**
	 * 姓名设定
	 * @param knifeManWhere
	 */
	public void setKnifeManWhere (String knifeManWhere) {
		this.knifeManWhere = knifeManWhere;
	}
}

