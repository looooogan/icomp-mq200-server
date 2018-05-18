package com.icomp.wsdl.v01c01.c01s004.endpoint;

import java.util.List;

import com.icomp.common.pojo.BaseRequest;
import com.icomp.wsdl.v01c01.c01s003.endpoint.RedemptionApply;
import com.icomp.wsdl.v01c01.c01s003.endpoint.TempToolTransfer;

/**
 * C01S004Request- 请求参数
 * @ClassName: C01S004Request 
 * @author Taoyy
 * @date 2014-9-22 下午4:50:56
 */
public class C01S004Request  extends BaseRequest{

	private static final long serialVersionUID = -2412039837048112584L;
	// 用户ID
	private String customerID;
		
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	// 补领单号
	private String replacementNumber;
		
	public String getReplacementNumber() {
		return replacementNumber;
	}
	public void setReplacementNumber(String replacementNumber) {
		this.replacementNumber = replacementNumber;
	}
	
	// 申请人名称
	private String applyUser;

	public String getApplyUser() {
		return applyUser;
	}
	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}
	
	// 申请时间
	private String applyTime;

	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	
	// RFID
	private String rfidCode;

	public String getRfidCode() {
		return rfidCode;
	}
	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}
	
	// 标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
	private String queryType;

	public String getQueryType() {
		return queryType;
	}
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	
	// 签收人ID
	private String signID;
	
	public String getSignID() {
		return signID;
	}
	public void setSignID(String signID) {
		this.signID = signID;
	}

	// 补领出库的刀具列表
	public List<ReplacementApply> replacementApplyInputList;

	public List<ReplacementApply> getReplacementApplyInputList() {
		return replacementApplyInputList;
	}
	public void setReplacementApplyInputList(
			List<ReplacementApply> replacementApplyInputList) {
		this.replacementApplyInputList = replacementApplyInputList;
	}

	//库位码
	private String libraryCode;
	//刀具编码
	private String toolCode;
	//申领数量
	private int appliedNumber;
	//申领原因
	private int appliendReason;
	//货架
	private String shelf;
	//层
	private String layer;
	//货位
	private String stack;
	//备货数量
	private int existingNumber;
	//备货刀具盒
	private String rfidString;
	//备货分盒
	private String newRfidString;
	//备货出库列表
	private List<String> rfidList;
	//申领单号
	private String replacementID;
	
	/**
	 * 申领数据
	 */
	private List<TempToolTransfer> toolTransfers;
	public String getLibraryCode() {
		return libraryCode;
	}
	public void setLibraryCode(String libraryCode) {
		this.libraryCode = libraryCode;
	}
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	public int getAppliedNumber() {
		return appliedNumber;
	}
	public void setAppliedNumber(int appliedNumber) {
		this.appliedNumber = appliedNumber;
	}
	public String getShelf() {
		return shelf;
	}
	public void setShelf(String shelf) {
		this.shelf = shelf;
	}
	public String getLayer() {
		return layer;
	}
	public void setLayer(String layer) {
		this.layer = layer;
	}
	public String getStack() {
		return stack;
	}
	public void setStack(String stack) {
		this.stack = stack;
	}
	public int getExistingNumber() {
		return existingNumber;
	}
	public void setExistingNumber(int existingNumber) {
		this.existingNumber = existingNumber;
	}
	public String getRfidString() {
		return rfidString;
	}
	public void setRfidString(String rfidString) {
		this.rfidString = rfidString;
	}
	public String getNewRfidString() {
		return newRfidString;
	}
	public void setNewRfidString(String newRfidString) {
		this.newRfidString = newRfidString;
	}
	public List<String> getRfidList() {
		return rfidList;
	}
	public void setRfidList(List<String> rfidList) {
		this.rfidList = rfidList;
	}
	public String getReplacementID() {
		return replacementID;
	}
	public void setReplacementID(String replacementID) {
		this.replacementID = replacementID;
	}
	public List<TempToolTransfer> getToolTransfers() {
		return toolTransfers;
	}
	public void setToolTransfers(List<TempToolTransfer> toolTransfers) {
		this.toolTransfers = toolTransfers;
	}
	public int getAppliendReason() {
		return appliendReason;
	}
	public void setAppliendReason(int appliendReason) {
		this.appliendReason = appliendReason;
	}


	
}
