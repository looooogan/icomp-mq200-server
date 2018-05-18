package com.icomp.wsdl.v01c01.c01s016.endpoint;

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

	/* 材料号*/
	private String materialNum;

	public String getMaterialNum() {
		return materialNum;
	}

	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}
	
	/* 报废数量*/
	private String scrapCount;

	public String getScrapCount() {
		return scrapCount;
	}

	public void setScrapCount(String scrapCount) {
		this.scrapCount = scrapCount;
	}
	
	/* 丢刀数量*/
	private String lostCount;

	public String getLostCount() {
		return lostCount;
	}

	public void setLostCount(String lostCount) {
		this.lostCount = lostCount;
	}
	
	/* 丢刀确认人*/
	private String lostUser;

	public String getLostUser() {
		return lostUser;
	}

	public void setLostUser(String lostUser) {
		this.lostUser = lostUser;
	}
	
	/* 确认数量*/
	private String confirmCount;

	public String getConfirmCount() {
		return confirmCount;
	}

	public void setConfirmCount(String confirmCount) {
		this.confirmCount = confirmCount;
	}
}
