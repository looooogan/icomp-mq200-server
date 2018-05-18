package com.icomp.wsdl.v01c01.c01s001.endpoint;

import java.util.List;

import com.icomp.common.pojo.BaseRequest;

public class C01S001Request extends BaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2899122586795753449L;
	
	
	/* RFID*/
	private String rfidCode;
	
	/* 标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）*/
	private String queryType;
	
	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}
	/**
	 * 标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
	 * @param queryType
	 */
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	
	public String getRfidCode() {
		return rfidCode;
	}
	/**
	 * 标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
	 * @return
	 */
	public String getQueryType() {
		return queryType;
	}
	
	
	/* 批次*/
	private String procuredBatch;

	public String getProcuredBatch() {
		return procuredBatch;
	}
	public void setProcuredBatch(String procuredBatch) {
		this.procuredBatch = procuredBatch;
	}
	
	/* 用户ID*/
	private String customerID;

	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	/* 刀具ID*/
	private String toolID;
	
	public String getToolID() {
		return toolID;
	}
	public void setToolID(String toolID) {
		this.toolID = toolID;
	}


	private List<InputTool> inputTool;
	
	public List<InputTool> getInputTool() {
		return inputTool;
	}
	public void setInputTool(List<InputTool> inputTool) {
		this.inputTool = inputTool;
	}
	
	/* 材料号*/
	private String materialNum;
		
	public String getMaterialNum() {
		return materialNum;
	}
	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}

	/* 入库数量*/
	private String storageNum;

	public String getStorageNum() {
		return storageNum;
	}

	public void setStorageNum(String storageNum) {
		this.storageNum = storageNum;
	}

	/* 保存入库信息列表 */
	private List<InputTool> inputToolList;

	public List<InputTool> getInputToolList() {
		return inputToolList;
	}

	public void setInputToolList(List<InputTool> inputToolList) {
		this.inputToolList = inputToolList;
	}
}
