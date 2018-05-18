package com.icomp.wsdl.v01c01.c01s010.endpoint;

import java.io.Serializable;

/**
 * 记录
 */
public class GrindingBitMsg implements Serializable {
    private static final long serialVersionUID = 1213845897875369558L;
    /* 材料号 */
	private String toolCode;
	
	/* rfid */
	private String rfidCode;

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	public String getRfidCode() {
		return rfidCode;
	}

	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}
}
