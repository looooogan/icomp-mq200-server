package com.icomp.wsdl.v01c01.c01s027.endpoint;

import com.icomp.common.pojo.BaseRequest;

import java.util.List;

/**
 * 刀具管理-刀具送回-请求参数
 * @ClassName: C01S025Request 
 * @author Taoyy
 * @date 2016-3-9 上午10:51:08
 */
public class C01S027Request extends BaseRequest{
	private static final long serialVersionUID = -3973025099591859546L;
	
	//rfid
	private String rfidCode;
	
	//rfid类型
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
	
	//用户ID
	private String customerID;

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	//签收人ID
	private String signID;

	public String getSignID() {
		return signID;
	}

	public void setSignID(String signID) {
		this.signID = signID;
	}
	


	// 提交刀具送回的刀具信息列表
	private List<ToolBackInfo> toolBackInfoList;

	public List<ToolBackInfo> getToolBackInfoList() {
		return toolBackInfoList;
	}

	public void setToolBackInfoList(List<ToolBackInfo> toolBackInfoList) {
		this.toolBackInfoList = toolBackInfoList;
	}
	
	
	

	//通知单号
	private String orderNum;
	//通知单号ID
	private String outsideFactoryID;

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

	//用户ID
	private String userID;
	//刀具ID
	private String toolID;
	//材料号（刀具编码）
	private String toolCode;
	//回厂数量
	private String backFactoryCount;
	//出厂方式
	private String grindingType;
	//激光码
	private String laserCode;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	public String getBackFactoryCount() {
		return backFactoryCount;
	}

	public void setBackFactoryCount(String backFactoryCount) {
		this.backFactoryCount = backFactoryCount;
	}

	public String getGrindingType() {
		return grindingType;
	}

	public void setGrindingType(String grindingType) {
		this.grindingType = grindingType;
	}

	public String getLaserCode() {
		return laserCode;
	}

	public void setLaserCode(String laserCode) {
		this.laserCode = laserCode;
	}

	//扫描交接的Rfid
	private String rfidStringOut;
	//扫描盛放的Rfid
	private String rfidStringIn;
	//交接信息
	private List<TransferToolMsg> transferToolMsgList;

	public String getRfidStringOut() {
		return rfidStringOut;
	}

	public void setRfidStringOut(String rfidStringOut) {
		this.rfidStringOut = rfidStringOut;
	}

	public String getRfidStringIn() {
		return rfidStringIn;
	}

	public void setRfidStringIn(String rfidStringIn) {
		this.rfidStringIn = rfidStringIn;
	}

	public List<TransferToolMsg> getTransferToolMsgList() {
		return transferToolMsgList;
	}

	public void setTransferToolMsgList(List<TransferToolMsg> transferToolMsgList) {
		this.transferToolMsgList = transferToolMsgList;
	}
}
