package com.icomp.wsdl.v01c01.c01s011.endpoint;

import com.icomp.common.pojo.BaseRequest;

/**
 * 设备安上-请求参数
 * 
 * @ClassName: C01S011Request
 * @author Taoyy
 * @date 2014-9-22 下午6:23:44
 */
public class C01S011Request extends BaseRequest {

	private static final long serialVersionUID = 3335750458782455214L;

	/* RFID */
	private String rfidCode;

	/* 标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库） */
	private String queryType;

	/**
	 * RFID
	 * 
	 * @return
	 */
	public String getRfidCode() {
		return rfidCode;
	}

	/**
	 * RFID
	 * 
	 * @param rfidCode
	 */
	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}

	/**
	 * 标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
	 * 
	 * @return
	 */
	public String getQueryType() {
		return queryType;
	}

	/**
	 * 标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
	 * 
	 * @param queryType
	 */
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	// 用户ID
	private String customerID;

	// 合成刀具ID
	private String synthesisParametersID;

	// 装入设备的轴号ID
	private String equipmentAxisNumberID;

	// 合成刀具RFID
	private String synthesisParametersRfid;

	// 设备ID
	private String equipmentID;
	// 合成刀具编码
	private String synthesisParametersCode;

	/**
	 * 用户ID
	 */
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	/**
	 * 合成刀具ID
	 * 
	 * @return
	 */
	public String getSynthesisParametersID() {
		return synthesisParametersID;
	}

	public void setSynthesisParametersID(String synthesisParametersID) {
		this.synthesisParametersID = synthesisParametersID;
	}

	/**
	 * 装入设备的轴号ID
	 * 
	 * @return
	 */
	public String getEquipmentAxisNumberID() {
		return equipmentAxisNumberID;
	}

	public void setEquipmentAxisNumberID(String equipmentAxisNumberID) {
		this.equipmentAxisNumberID = equipmentAxisNumberID;
	}

	/**
	 * 合成刀具RFID
	 * 
	 * @return
	 */
	public String getSynthesisParametersRfid() {
		return synthesisParametersRfid;
	}

	public void setSynthesisParametersRfid(String synthesisParametersRfid) {
		this.synthesisParametersRfid = synthesisParametersRfid;
	}

	/**
	 * 设备ID
	 * 
	 * @param equipmentID
	 */
	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}
    /**
     * 合成刀具编码
     * @param synthesisParametersCode
     */
	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 合成刀具rfid
	private String rfidString;

	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	public String getRfidString() {
		return rfidString;
	}

	public void setRfidString(String rfidString) {
		this.rfidString = rfidString;
	}

	private String synthesisParametersNumber;

	public String getSynthesisParametersNumber() {
		return synthesisParametersNumber;
	}

	public void setSynthesisParametersNumber(String synthesisParametersNumber) {
		this.synthesisParametersNumber = synthesisParametersNumber;
	}

	public String getEquipmentID() {
		return equipmentID;
	}

	public String synthesisParametersRfid() {

		return null;
	}

	public String getAxleID() {

		return null;
	}



}
