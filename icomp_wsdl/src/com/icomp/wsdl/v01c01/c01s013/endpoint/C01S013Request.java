package com.icomp.wsdl.v01c01.c01s013.endpoint;

import com.icomp.common.pojo.BaseRequest;

/**
 * 设备卸下-请求参数
 * 
 * @ClassName: C01S013Request
 * @author Taoyy
 * @date 2014-9-22 下午6:37:53
 */
public class C01S013Request extends BaseRequest {

	private static final long serialVersionUID = 5722566548210608771L;

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
	//用户ID
	private String customerID ;
	//零部件ID
	private String partsID ;
	//零部件名称
	private String partsName ;
	//合成刀具ID
	private String synthesisParametersID ;
	//设备ID
	private String equipmentID ;
	//轴号ID
	private String axisID ;
	
	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getPartsID() {
		return partsID;
	}

	public void setPartsID(String partsID) {
		this.partsID = partsID;
	}

	public String getPartsName() {
		return partsName;
	}

	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}

	public String getSynthesisParametersID() {
		return synthesisParametersID;
	}

	public void setSynthesisParametersID(String synthesisParametersID) {
		this.synthesisParametersID = synthesisParametersID;
	}

	public String getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}

	public String getAxisID() {
		return axisID;
	}

	public void setAxisID(String axisID) {
		this.axisID = axisID;
	}


	// 扫描合成刀具rfid
	private String rfidString;
	// 合成刀具编码
	private String synthesisParametersCode;
	// 卸下原因(0正常卸下1打刀2不合格9其他)(可维护)
	private String removeReason;
	// 加工数量
	private int processAmount;
	// 流水线id
	private String assemblyLineID;
	// 工序id
	private String processID;
	// 载体id
	private String rfidContainerId;
	
	public String getAssemblyLineID() {
		return assemblyLineID;
	}

	public void setAssemblyLineID(String assemblyLineID) {
		this.assemblyLineID = assemblyLineID;
	}

	public String getProcessID() {
		return processID;
	}

	public void setProcessID(String processID) {
		this.processID = processID;
	}

	public String getRfidContainerId() {
		return rfidContainerId;
	}

	public void setRfidContainerId(String rfidContainerId) {
		this.rfidContainerId = rfidContainerId;
	}

	private  int removeNum;

	public int getRemoveNum() {
		return removeNum;
	}

	public void setRemoveNum(int removeNum) {
		this.removeNum = removeNum;
	}

	/*******************************************************/
	
	// 零部件种类
	private String assemblyLineName;
	//合成刀具编号
	private String synthesisParametersNumber;

	public String getRfidString() {
		return rfidString;
	}

	public void setRfidString(String rfidString) {
		this.rfidString = rfidString;
	}

	public String getRemoveReason() {
		return removeReason;
	}

	public void setRemoveReason(String removeReason) {
		this.removeReason = removeReason;
	}

	public int getProcessAmount() {
		return processAmount;
	}

	public void setProcessAmount(int processAmount) {
		this.processAmount = processAmount;
	}

	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}

	public String getAssemblyLineName() {
		return assemblyLineName;
	}

	public void setAssemblyLineName(String assemblyLineName) {
		this.assemblyLineName = assemblyLineName;
	}

	public String getSynthesisParametersNumber() {
		return synthesisParametersNumber;
	}

	public void setSynthesisParametersNumber(String synthesisParametersNumber) {
		this.synthesisParametersNumber = synthesisParametersNumber;
	}

}
