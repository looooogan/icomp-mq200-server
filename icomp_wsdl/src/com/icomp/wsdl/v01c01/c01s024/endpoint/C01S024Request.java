package com.icomp.wsdl.v01c01.c01s024.endpoint;

import com.icomp.common.pojo.BaseRequest;

/**
 * 刀具管理-刀具状态查询-请求参数
 * @ClassName: C01S024Request 
 * @author Taoyy
 * @date 2014-9-23 上午10:13:22
 */
public class C01S024Request  extends BaseRequest{

	private static final long serialVersionUID = -9171808484653226851L;

	//RFID标签
	private String rfidCode;
	//标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
	private String rfidType;

	public String getRfidCode() {
		return rfidCode;
	}

	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}

	public String getRfidType() {
		return rfidType;
	}

	public void setRfidType(String rfidType) {
		this.rfidType = rfidType;
	}

	//扫描获得的Rfid
	private String rfidString;

	public String getRfidString() {
		return rfidString;
	}

	public void setRfidString(String rfidString) {
		this.rfidString = rfidString;
	}
	
	
}
