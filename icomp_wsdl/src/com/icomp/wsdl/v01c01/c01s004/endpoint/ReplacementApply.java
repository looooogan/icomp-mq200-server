package com.icomp.wsdl.v01c01.c01s004.endpoint;

import java.io.Serializable;

/**
 * 记录补领申请单列表
 * 
 * @author yzq
 * 
 */
public class ReplacementApply implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6510562650515966047L;
	
	//补领单号
	private String replacementNumber;
	public String getReplacementNumber() {
		return replacementNumber;
	}

	public void setReplacementNumber(String replacementNumber) {
		this.replacementNumber = replacementNumber;
	}

	//刀具ID
	private String toolID;

	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}
	
	//RFID标签
	private String rfidCode;

	public String getRfidCode() {
		return rfidCode;
	}

	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}
	
	//材料号
	private String materialNum;

	public String getMaterialNum() {
		return materialNum;
	}

	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}
	
	//申请数量
	private String appliedNumber;

	public String getAppliedNumber() {
		return appliedNumber;
	}

	public void setAppliedNumber(String appliedNumber) {
		this.appliedNumber = appliedNumber;
	}
	
	//出库数量
	private String receiveCount;

	public String getReceiveCount() {
		return receiveCount;
	}

	public void setReceiveCount(String receiveCount) {
		this.receiveCount = receiveCount;
	}

}
