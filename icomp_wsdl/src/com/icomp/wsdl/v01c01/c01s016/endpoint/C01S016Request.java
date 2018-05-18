package com.icomp.wsdl.v01c01.c01s016.endpoint;

import java.util.List;

import com.icomp.common.pojo.BaseRequest;
import com.icomp.entity.base.Tooltransfer;

/**
 * 回库处理-请求参数
 * @ClassName: C01S016Request 
 * @author Taoyy
 * @date 2016-3-1 上午9:06:11
 */
public class C01S016Request  extends BaseRequest{

	private static final long serialVersionUID = 2961967533552420327L;
	
	//用户ID
	private String customerID;
		
	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	//RFID标签
	private String rfidCode;	
	
	public String getRfidCode() {
		return rfidCode;
	}

	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}
	
	//标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
	private String queryType;

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	
	//提交回库处理刀具信息
	private List<InputTool> inputToolList;

	public List<InputTool> getInputToolList() {
		return inputToolList;
	}

	public void setInputToolList(List<InputTool> inputToolList) {
		this.inputToolList = inputToolList;
	}
	
	
	
	
	

	

	

	

	// 刀具待报废列表(非单品）
	private List<Tooltransfer> toolInfoDetailList;

	public List<Tooltransfer> getToolInfoDetailList() {
		return toolInfoDetailList;
	}

	public void setToolInfoDetailList(List<Tooltransfer> toolInfoDetailList) {
		this.toolInfoDetailList = toolInfoDetailList;
	}
	//扫描刀具rfid
	private String rfidString;
	//刀具交接列表
	private List<ToolJoint> toolJointList;
	//送回人
	private String returnUser;
	public String getRfidString() {
		return rfidString;
	}
	public void setRfidString(String rfidString) {
		this.rfidString = rfidString;
	}
	public List<ToolJoint> getToolJointList() {
		return toolJointList;
	}
	public void setToolJointList(List<ToolJoint> toolJointList) {
		this.toolJointList = toolJointList;
	}
	public String getReturnUser() {
		return returnUser;
	}
	public void setReturnUser(String returnUser) {
		this.returnUser = returnUser;
	}

	private List<ToolJoint> gruant;
	public List<ToolJoint> getGruant() {
		return gruant;
	}
	public void setGruant(List<ToolJoint> gruant) {
		this.gruant = gruant;
	}
	
}
