package com.icomp.wsdl.v01c01.c01s014.endpoint;

import com.icomp.common.pojo.BaseRequest;
import com.icomp.entity.base.Toolrepairnotice;

import java.util.List;
/**
 * 刀具分拣-请求参数
 * @ClassName: C01S014Request 
 * @author Taoyy
 * @date 2016-2-29 下午6:45:26
 */
public class C01S014Request  extends BaseRequest{

	private static final long serialVersionUID = -8243186184980391736L;
	
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
	
	/* 保存刀具分拣信息列表 */
	private List<InputTool> inputToolList;
	
	public List<InputTool> getInputToolList() {
		return inputToolList;
	}
	public void setInputToolList(List<InputTool> inputToolList) {
		this.inputToolList = inputToolList;
	}
	
	
	
	
	
	
	
	

	

	//待修复rfid列表
	private List<String> rfidList;
	//修复方式列表
	private List<String> repairWayList;
	//扫描刀具rfid
	private String rfidString;
	//刀具修复通知
	private List<Toolrepairnotice> trnList;
	public List<String> getRfidList() {
		return rfidList;
	}
	public void setRfidList(List<String> rfidList) {
		this.rfidList = rfidList;
	}
	public List<String> getRepairWayList() {
		return repairWayList;
	}
	public void setRepairWayList(List<String> repairWayList) {
		this.repairWayList = repairWayList;
	}
	public String getRfidString() {
		return rfidString;
	}
	public void setRfidString(String rfidString) {
		this.rfidString = rfidString;
	}
	public List<Toolrepairnotice> getTrnList() {
		return trnList;
	}
	public void setTrnList(List<Toolrepairnotice> trnList) {
		this.trnList = trnList;
	}
	private  List<ReplaceGringding> gringdingList;

	public List<ReplaceGringding> getGringdingList() {
		return gringdingList;
	}

	public void setGringdingList(List<ReplaceGringding> gringdingList) {
		this.gringdingList = gringdingList;
	}
}
