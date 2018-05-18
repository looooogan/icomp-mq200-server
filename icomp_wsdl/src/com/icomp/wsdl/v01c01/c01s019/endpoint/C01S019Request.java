package com.icomp.wsdl.v01c01.c01s019.endpoint;

import com.icomp.common.pojo.BaseRequest;
import com.icomp.wsdl.v01c01.c01s018.endpoint.ToolNoticeInfo;

import java.util.List;

/**
 * 对刀结束	-请求参数
 * @ClassName: C01S019Request 
 * @author Taoyy
 * @date 2014-9-23 上午9:32:14
 */
public class C01S019Request  extends BaseRequest{

	private static final long serialVersionUID = -4073056722999804642L;
	//rfid
	private String rfidCode;
	//标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
	private String rfidType;
	//材料号
	private String toolCode;

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
	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	//激光码
    private String laserCode;

	public String getLaserCode() {
		return laserCode;
	}

	public void setLaserCode(String laserCode) {
		this.laserCode = laserCode;
	}
	
	//原有激光码
	private String oldLaserCode;
	
	public String getOldLaserCode() {
		return oldLaserCode;
	}

	public void setOldLaserCode(String oldLaserCode) {
		this.oldLaserCode = oldLaserCode;
	}
	
	//修改后的激光码
	private String newLaserCode;
	
	public String getNewLaserCode() {
		return newLaserCode;
	}

	public void setNewLaserCode(String newLaserCode) {
		this.newLaserCode = newLaserCode;
	}
	private  String customerID;

	@Override
	public String getCustomerID() {
		return customerID;
	}

	@Override
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	//扫描获得的Rfid
	private String rfidString;
	//激光码
	private String laserIdentificationCode;
	public String getRfidString() {
		return rfidString;
	}
	public void setRfidString(String rfidString) {
		this.rfidString = rfidString;
	}
	public String getLaserIdentificationCode() {
		return laserIdentificationCode;
	}
	public void setLaserIdentificationCode(String laserIdentificationCode) {
		this.laserIdentificationCode = laserIdentificationCode;
	}
		//刀具修磨信息
	private List<ToolNoticeInfo> toolNoticeInfoList ;

	public List<ToolNoticeInfo> getToolNoticeInfoList() {
		return toolNoticeInfoList;
	}

	public void setToolNoticeInfoList(List<ToolNoticeInfo> toolNoticeInfoList) {
		this.toolNoticeInfoList = toolNoticeInfoList;
	}
}
