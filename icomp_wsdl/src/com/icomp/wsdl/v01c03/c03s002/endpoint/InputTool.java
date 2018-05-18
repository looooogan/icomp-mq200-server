package com.icomp.wsdl.v01c03.c03s002.endpoint;

import java.io.Serializable;

public class InputTool   implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2942853420898210667L;
	/*RFID*/
	private String rfidString;

	public String getRfidString() {
		return rfidString;
	}

	public void setRfidString(String rfidString) {
		this.rfidString = rfidString;
	}
	
	/*用户选择初始化类型*/
	private int selectIndex;

	public int getSelectIndex() {
		return selectIndex;
	}

	public void setSelectIndex(int selectIndex) {
		this.selectIndex = selectIndex;
	}
	
	/* 入库类型	*/ 
	private String inputType;
	public String getInputType() {
		return inputType;
	}
	public void setInputType(String inputType) {
		this.inputType = inputType;
	}
	
	/* 合成刀具编码 */
	private String synthesisParametersCode;

	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}
}
