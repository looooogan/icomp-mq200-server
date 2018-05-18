package com.icomp.wsdl.v01c03.c03s002.endpoint;

import java.util.List;

import com.icomp.common.pojo.BaseRequest;

public class C03S002Request extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3571979929495892000L;
	
	/*RFID*/
	private String rfidString;

	public String getRfidString() {
		return rfidString;
	}

	public void setRfidString(String rfidString) {
		this.rfidString = rfidString;
	}
	
	/*用户选择初始化类型*/
	private int selectIndex;

	public int getSelectIndex() {
		return selectIndex;
	}

	public void setSelectIndex(int selectIndex) {
		this.selectIndex = selectIndex;
	}
	
	/* 入库类型	*/ 
	private String inputType;
	public String getInputType() {
		return inputType;
	}
	public void setInputType(String inputType) {
		this.inputType = inputType;
	}
	
	/* 合成刀具编码 */
	private String synthesisParametersCode;

	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}
	/*******************************************************************************/
	/* 初始化列表*/
	private List<InputTool> inputToolList;

	public List<InputTool> getInputToolList() {
		return inputToolList;
	}

	public void setInputToolList(List<InputTool> inputToolList) {
		this.inputToolList = inputToolList;
	}
	//用户ID
	private String userID;
	//RfidCode标签
	private String rfidCode;
	//标签类型（4设备）
	private String queryType;
	//设备id
	private String equipmentID;
	//绑定类型（0加工，1修磨）
	private String equipmentType;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getRfidCode() {
		return rfidCode;
	}

	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}
	//容器类别（0一次性报废 2待分拣容器 3厂内待刃磨 4厂外待刃磨 5刃磨完毕 6刃磨报废 7待涂层 8库房报废 9其他）
	private String containerCarrierType;

	public String getContainerCarrierType() {
		return containerCarrierType;
	}

	public void setContainerCarrierType(String containerCarrierType) {
		this.containerCarrierType = containerCarrierType;
	}
}
