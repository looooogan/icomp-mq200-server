package com.icomp.entity.base;

import java.io.Serializable;

/**
 * 记录
 */
public class GrindingBitMsge implements Serializable {
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
