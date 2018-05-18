/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:05
 * 创建者  ：杨作庆
 * 
 */
public class Vtoolsetting extends VtoolsettingWhere implements Serializable {

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

	/* 位置号	*/ 
	private BigDecimal synthesisCutterNumber;

	/**
	 * 位置号取得
	 * @return synthesisCutterNumber
	 */
	public BigDecimal getSynthesisCutterNumber() {
		return synthesisCutterNumber;
	}

	/**
	 * 位置号设定
	 * @param synthesisCutterNumber
	 */
	public void setSynthesisCutterNumber(BigDecimal synthesisCutterNumber) {
		this.synthesisCutterNumber = synthesisCutterNumber;
	}

	/* 最后执行业务流程	*/ 
	private String businessFlowLnkID;

	/**
	 * 最后执行业务流程取得
	 * @return businessFlowLnkID
	 */
	public String getBusinessFlowLnkID() {
		return businessFlowLnkID;
	}

	/**
	 * 最后执行业务流程设定
	 * @param businessFlowLnkID
	 */
	public void setBusinessFlowLnkID(String businessFlowLnkID) {
		this.businessFlowLnkID = businessFlowLnkID;
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

	/* 转出人	*/ 
	private String arrivalUser;

	/**
	 * 转出人取得
	 * @return arrivalUser
	 */
	public String getArrivalUser() {
		return arrivalUser;
	}

	/**
	 * 转出人设定
	 * @param arrivalUser
	 */
	public void setArrivalUser(String arrivalUser) {
		this.arrivalUser = arrivalUser;
	}

	/* 接收人	*/ 
	private String recipientUser;

	/**
	 * 接收人取得
	 * @return recipientUser
	 */
	public String getRecipientUser() {
		return recipientUser;
	}

	/**
	 * 接收人设定
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

	/* 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上)(该状态绑定到带标签的数据上)	*/ 
	private String loadState;

	/**
	 * 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上)(该状态绑定到带标签的数据上)取得
	 * @return loadState
	 */
	public String getLoadState() {
		return loadState;
	}

	/**
	 * 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上)(该状态绑定到带标签的数据上)设定
	 * @param loadState
	 */
	public void setLoadState(String loadState) {
		this.loadState = loadState;
	}

	/* 对刀人	*/ 
	private String knifeMan;

	/**
	 * 对刀人取得
	 * @return knifeMan
	 */
	public String getKnifeMan() {
		return knifeMan;
	}

	/**
	 * 对刀人设定
	 * @param knifeMan
	 */
	public void setKnifeMan(String knifeMan) {
		this.knifeMan = knifeMan;
	}
}

