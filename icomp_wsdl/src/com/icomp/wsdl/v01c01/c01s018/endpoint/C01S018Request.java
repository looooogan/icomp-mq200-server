package com.icomp.wsdl.v01c01.c01s018.endpoint;

import com.icomp.common.pojo.BaseRequest;

import java.math.BigDecimal;
import java.util.List;

/**
 * 刀具复磨安上-请求参数
 * @ClassName: C01S018Request 
 * @author Taoyy
 * @date 2014-9-23 上午9:25:59
 */
public class C01S018Request extends BaseRequest{
	private static final long serialVersionUID = 7975513741634283725L;
	
	//标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
	private String rfidType;
	//RFID
	private String rfidCode;
	
	public String getRfidType() {
		return rfidType;
	}

	public void setRfidType(String rfidType) {
		this.rfidType = rfidType;
	}

	public String getRfidCode() {
		return rfidCode;
	}

	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}
	
	//用户ID
	private String customerID;
	//修磨设备ID
	private String noticeEquipmentID;

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getNoticeEquipmentID() {
		return noticeEquipmentID;
	}

	public void setNoticeEquipmentID(String noticeEquipmentID) {
		this.noticeEquipmentID = noticeEquipmentID;
	}

	//刀具修磨信息
	private List<ToolNoticeInfo> toolNoticeInfoList ;

	public List<ToolNoticeInfo> getToolNoticeInfoList() {
		return toolNoticeInfoList;
	}

	public void setToolNoticeInfoList(List<ToolNoticeInfo> toolNoticeInfoList) {
		this.toolNoticeInfoList = toolNoticeInfoList;
	}






	// 刀具类型
	private String toolType;

	public String getToolType() {
		return toolType;
	}

	public void setToolType(String toolType) {
		this.toolType = toolType;
	}
	//扫描刀具Rfid
	private String rfidString;
	
	//测量长度
	private double noticeLength;
	//入库编码 
	private String knifeInventoryCode;
	//库存状态
	private String stockState;
	//业务-流程中间表ID
	private String businessFlowLnkID;
    private String newRfidString;
	private String toolCode;

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	//物料号
    private String kivCode;
	//刃磨数量
    private int gringCount;
    private String oldRfidString;
    private int tempNumber;
	//报废数量
    private int scrapCount;


    public String getNewRfidString() {
        return newRfidString;
    }

    public void setNewRfidString(String newRfidString) {
        this.newRfidString = newRfidString;
    }

    public String getOldRfidString() {
        return oldRfidString;
    }

    public void setOldRfidString(String oldRfidString) {
        this.oldRfidString = oldRfidString;
    }

    public int getTempNumber() {
        return tempNumber;
    }

    public void setTempNumber(int tempNumber) {
        this.tempNumber = tempNumber;
    }

    public String getRfidString() {
		return rfidString;
	}
	public void setRfidString(String rfidString) {
		this.rfidString = rfidString;
	}
	
	public double getNoticeLength() {
		return noticeLength;
	}
	public void setNoticeLength(double noticeLength) {
		this.noticeLength = noticeLength;
	}
	public String getKnifeInventoryCode() {
		return knifeInventoryCode;
	}
	public void setKnifeInventoryCode(String knifeInventoryCode) {
		this.knifeInventoryCode = knifeInventoryCode;
	}
	public String getStockState() {
		return stockState;
	}
	public void setStockState(String stockState) {
		this.stockState = stockState;
	}
	public String getBusinessFlowLnkID() {
		return businessFlowLnkID;
	}
	public void setBusinessFlowLnkID(String businessFlowLnkID) {
		this.businessFlowLnkID = businessFlowLnkID;
	}

	

	public String getKivCode() {
		return kivCode;
	}

	public void setKivCode(String kivCode) {
		this.kivCode = kivCode;
	}

	public int getGringCount() {
		return gringCount;
	}

	public void setGringCount(int gringCount) {
		this.gringCount = gringCount;
	}

	public int getScrapCount() {
		return scrapCount;
	}

	public void setScrapCount(int scrapCount) {
		this.scrapCount = scrapCount;
	}

private BigDecimal noticeCount;
	public BigDecimal getNoticeCount() {
		return noticeCount;
	}
}
