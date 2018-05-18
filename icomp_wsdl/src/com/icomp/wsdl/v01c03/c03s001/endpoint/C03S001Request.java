package com.icomp.wsdl.v01c03.c03s001.endpoint;

import com.icomp.common.pojo.BaseRequest;

import java.util.List;

public class C03S001Request  extends BaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4268913865521041825L;
	//rfid集合
	private List<String> rfidCodeList;

	public List<String> getRfidCodeList() {
		return rfidCodeList;
	}

	public void setRfidCodeList(List<String> rfidCodeList) {
		this.rfidCodeList = rfidCodeList;
	}
	//材料号
	private String toolCode;

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;

	}
	//合成刀具rfid
	private String synthesisParametersRfid;

	public String getSynthesisParametersRfid() {
		return synthesisParametersRfid;
	}

	public void setSynthesisParametersRfid(String synthesisParametersRfid) {
		this.synthesisParametersRfid = synthesisParametersRfid;
	}
	//rfid标签

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

	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}

	private String rfidCode;
	//标签类型
	private String queryType;



	//用户ID
	private String customerID;
	//刀具类型（消耗类别）
	private String toolConsumeType;
	//初始化类型（0备用刀，1其它）

	@Override
	public String getCustomerID() {
		return customerID;
	}

	@Override
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getToolConsumeType() {
		return toolConsumeType;
	}

	public void setToolConsumeType(String toolConsumeType) {
		this.toolConsumeType = toolConsumeType;
	}

	public String getInitializeType() {
		return initializeType;
	}

	public void setInitializeType(String initializeType) {
		this.initializeType = initializeType;
	}

	private String initializeType;
	//输入类型(0Rfid,1材料号)(0:RFID,1合成刀具编码)

	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	private String infoType;
	//库存数量

	public String getKnifelnventoryNumber() {
		return knifelnventoryNumber;
	}

	public void setKnifelnventoryNumber(String knifelnventoryNumber) {
		this.knifelnventoryNumber = knifelnventoryNumber;
	}

	private String knifelnventoryNumber ;
	//刀具ID
	private String toolID;

	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}
	//合成刀具编码（输入类型为1时，必须传入）
	private String synthesisParametersCode;




















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
	/* 库位码 */
	private String libraryCode;

	public String getLibraryCode() {
		return libraryCode;
	}

	public void setLibraryCode(String libraryCode) {
		this.libraryCode = libraryCode;
	}
	
	/* 保存入库信息列表 */
	private List<InputTool> inputToolList;

	public List<InputTool> getInputToolList() {
		return inputToolList;
	}

	public void setInputToolList(List<InputTool> inputToolList) {
		this.inputToolList = inputToolList;
	}
	
	/* 保存入库rfid信息 */
	private List<InputRfid> inputRfidList;
	public List<InputRfid> getInputRfidList() {
		return inputRfidList;
	}

	public void setInputRfidList(List<InputRfid> inputRfidList) {
		this.inputRfidList = inputRfidList;
	}
	
}
