package com.icomp.wsdl.v01c04.c04s001.endpoint;


import java.util.List;

import com.icomp.common.pojo.BaseRequest;

public class C04S001Request extends BaseRequest{
	private static final long serialVersionUID = 3637282318912199903L;
	/**
	 * 
	 */
	//用户ID
	private String customerID ;
	//rfid标签
	private String rfidCode;
	//标签类型（0库位标签）
	private String queryType;
	//材料号
	private String toolCode;
	//输入类型(0Rfid,1材料号)
	private String infoType;

	//在库数量
	private String libraryCount;
	//刀具ID
	private String toolID;
	//rfidList（list<String>）【当是单品刀具时为必须】
	private List<String> rfidCodelist;
	//实际数量
	private String realLibraryCount;

	public String getToolConsumetype() {
		return toolConsumetype;
	}

	public void setToolConsumetype(String toolConsumetype) {
		this.toolConsumetype = toolConsumetype;
	}

	//刀具类型（0非单品刀具，1单品刀具）
	private String toolConsumetype;

	@Override
	public String getCustomerID() {
		return customerID;
	}

	@Override
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
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

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	public String getLibraryCount() {
		return libraryCount;
	}

	public void setLibraryCount(String libraryCount) {
		this.libraryCount = libraryCount;
	}

	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	public List<String> getRfidCodelist() {
		return rfidCodelist;
	}

	public void setRfidCodelist(List<String> rfidCodelist) {
		this.rfidCodelist = rfidCodelist;
	}

	public String getRealLibraryCount() {
		return realLibraryCount;
	}

	public void setRealLibraryCount(String realLibraryCount) {
		this.realLibraryCount = realLibraryCount;
	}



















	//已盘点数据
	private List<StockingInfo> stockingInfoList;
	public List<StockingInfo> getStockingInfoList() {
		return stockingInfoList;
	}
	public void setStockingInfoList(List<StockingInfo> stockingInfoList) {
		this.stockingInfoList = stockingInfoList;
	}
	/*RFID*/
	private String rfidString;

	public String getRfidString() {
		return rfidString;
	}

	public void setRfidString(String rfidString) {
		this.rfidString = rfidString;
	}

	/* 已扫描的rfid列表 */
	private List<String> rfids;

	public List<String> getRfids() {
		return rfids;
	}

	public void setRfids(List<String> rfids) {
		this.rfids = rfids;
	} 
}
