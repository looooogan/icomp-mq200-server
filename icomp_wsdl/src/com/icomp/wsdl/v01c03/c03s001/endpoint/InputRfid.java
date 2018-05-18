package com.icomp.wsdl.v01c03.c03s001.endpoint;

import java.io.Serializable;

public class InputRfid   implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2659240985033724180L;

	/* 刀具编码 */
	private String toolCode;
	private String rfidString;
	/* 入库类型	*/ 
	private String inputType;
	private int inputNumber;
	public String getInputType() {
		return inputType;
	}
	public void setInputType(String inputType) {
		this.inputType = inputType;
	}
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	public String getRfidString() {
		return rfidString;
	}
	public void setRfidString(String rfidString) {
		this.rfidString = rfidString;
	}

	public int getInputNumber() {
		return inputNumber;
	}

	public void setInputNumber(int inputNumber) {
		this.inputNumber = inputNumber;
	}
}
