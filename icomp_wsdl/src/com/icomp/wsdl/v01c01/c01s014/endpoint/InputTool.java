package com.icomp.wsdl.v01c01.c01s014.endpoint;

import java.io.Serializable;

public class InputTool  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7692813260416276048L;
	
	/* 刀具ID*/
	private String toolID;
	
	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	/* RFID标签*/
	private String rfidCode;

	public String getRfidCode() {
		return rfidCode;
	}

	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}
	
	/* 修磨方式(0:厂内，1厂外）*/
	private String grindingMode;

	public String getGrindingMode() {
		return grindingMode;
	}

	public void setGrindingMode(String grindingMode) {
		this.grindingMode = grindingMode;
	}
	
	/* 确认数量*/
	private String confirmCount;

	public String getConfirmCount() {
		return confirmCount;
	}

	public void setConfirmCount(String confirmCount) {
		this.confirmCount = confirmCount;
	}
	
	/* 扫描数量*/
	private String scanCount;

	public String getScanCount() {
		return scanCount;
	}

	public void setScanCount(String scanCount) {
		this.scanCount = scanCount;
	}



	

	
}
