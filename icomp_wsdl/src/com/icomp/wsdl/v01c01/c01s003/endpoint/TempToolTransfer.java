package com.icomp.wsdl.v01c01.c01s003.endpoint;

import java.io.Serializable;
/**
 * 提交刀具信息
 * @ClassName: TempToolTransfer 
 * @author Taoyy
 * @date 2014年10月22日 下午7:21:15
 */
public class TempToolTransfer implements Serializable{

	private static final long serialVersionUID = 2967648086804475686L;
	

	/* 换领申请流水号	*/ 
	private String redemptionAppliedID;

	
	/**
	 * 换领申请流水号取得
	 * @return redemptionAppliedID
	 */
	public String getRedemptionAppliedID() {
		return redemptionAppliedID;
	}

	/**
	 * 换领申请流水号设定
	 * @param redemptionAppliedID
	 */
	public void setRedemptionAppliedID(String redemptionAppliedID) {
		this.redemptionAppliedID = redemptionAppliedID;
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

	/* 换领数量	*/ 
	private int appliedNumber;

	/**
	 * 换领数量取得
	 * @return appliedNumber
	 */
	public int getAppliedNumber() {
		return appliedNumber;
	}

	/**
	 * 换领数量设定
	 * @param appliedNumber
	 */
	public void setAppliedNumber(int appliedNumber) {
		this.appliedNumber = appliedNumber;
	}


}
