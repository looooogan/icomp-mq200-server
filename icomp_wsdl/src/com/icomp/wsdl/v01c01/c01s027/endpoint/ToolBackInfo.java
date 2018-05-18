package com.icomp.wsdl.v01c01.c01s027.endpoint;

import java.io.Serializable;
import java.math.BigDecimal;

public class ToolBackInfo implements Serializable {

    private static final long serialVersionUID = 2776704132721946484L;
    //刀具Id
    private String toolID;
    
	public String getToolID() {
		return toolID;
	}
	public void setToolID(String toolID) {
		this.toolID = toolID;
	}
	
	//RFID
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
	
	//实际数量
    private int factCount;

	public int getFactCount() {
		return factCount;
	}
	public void setFactCount(int factCount) {
		this.factCount = factCount;
	}

}
