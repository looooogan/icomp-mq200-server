package com.icomp.wsdl.v01c01.c01s001.endpoint;

import java.io.Serializable;

public class InputTool  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7692813260416276048L;
	
	/* RFID*/
	private String rfidCode;

	/* 材料号 */
	private String materialNum;
	
	/* 每盒数量 */
	private String unitnumber;
	/* 刀具id*/
	private String toolID;

	public String getRfidCode() {
		return rfidCode;
	}

	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}

	public String getMaterialNum() {
		return materialNum;
	}

	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}

	public String getUnitnumber() {
		return unitnumber;
	}

	public void setUnitnumber(String unitnumber) {
		this.unitnumber = unitnumber;
	}

	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	

	
}
