package com.icomp.wsdl.v01c01.c01s020.endpoint;

import com.icomp.common.pojo.BaseRequest;

import java.util.List;

/**
 * 回厂识别 -请求参数
 * 
 * @ClassName: C01S020Request
 * @author Taoyy
 * @date 2014-9-23 上午9:38:45
 */
public class C01S020Request extends BaseRequest {
	private static final long serialVersionUID = 2154387187818395481L;

	//通知单号
	private String orderNum;
	//通知单号ID
	private String outsideFactoryID;
	//rfid
	private String rfidCode;
	//rfid类型(空盒)
	private String rfidType;
//提交回厂入库刀片信息
private List<BackFactoryToolInfo> backFactoryToolInfoList;
	private List<String> rfidCodeList;

	public void setRfidCodeList(List<String> rfidCodeList) {
		this.rfidCodeList = rfidCodeList;
	}
	public List<String> getRfidCodeList() {
		return rfidCodeList;
	}

	//激光码
	private String laserCode;

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getOutsideFactoryID() {
		return outsideFactoryID;
	}

	public void setOutsideFactoryID(String outsideFactoryID) {
		this.outsideFactoryID = outsideFactoryID;
	}

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

	public List<BackFactoryToolInfo> getBackFactoryToolInfoList() {
		return backFactoryToolInfoList;
	}

	public void setBackFactoryToolInfoList(List<BackFactoryToolInfo> backFactoryToolInfoList) {
		this.backFactoryToolInfoList = backFactoryToolInfoList;
	}

	public String getLaserCode() {
		return laserCode;
	}

	public void setLaserCode(String laserCode) {
		this.laserCode = laserCode;
	}

	//用户ID
	private String customerID;


	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	// 扫描获得的Rfid
	private String rfidString;
	// 激光码
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

	// 通知单流水号
	private String toolRepairNoticeID;

	public String getToolRepairNoticeID() {
		return toolRepairNoticeID;
	}

	public void setToolRepairNoticeID(String toolRepairNoticeID) {
		this.toolRepairNoticeID = toolRepairNoticeID;
	}
	
	//刀具信息
	private ToolInfo toolInfo;

	public ToolInfo getToolInfo() {
		return toolInfo;
	}

	public void setToolInfo(ToolInfo toolInfo) {
		this.toolInfo = toolInfo;
	}
	
	//绑定数量
	private int inputCount;

	public int getInputCount() {
		return inputCount;
	}

	public void setInputCount(int inputCount) {
		this.inputCount = inputCount;
	}
	
	//修磨方式
	private String grindingType;

	public String getGrindingType() {
		return grindingType;
	}

	public void setGrindingType(String grindingType) {
		this.grindingType = grindingType;
	}
}
