package com.icomp.wsdl.v01c01.c01s003.endpoint;

import java.util.ArrayList;
import java.util.List;

import com.icomp.common.pojo.BaseRequest;
import com.icomp.entity.base.Redemptionapplied;
import com.icomp.entity.base.Vledplanelist;

/**
 * C01S003Request-请求参数
 * @ClassName: C01S003Request 
 * @author Taoyy
 * @date 2014-9-22 下午4:12:48
 */
public class C01S003Request extends BaseRequest{

	
	private static final long serialVersionUID = -4570079384246511279L;
	
	// 换领申请人名称
	String redemptionApplyUserName;
	
	public String getRedemptionApplyUserName() {
		return redemptionApplyUserName;
	}

	public void setRedemptionApplyUserName(String redemptionApplyUserName) {
		this.redemptionApplyUserName = redemptionApplyUserName;
	}
	
	// 换领申请人UserID
	String redemptionApplyUserID;
	
	public String getRedemptionApplyUserID() {
		return redemptionApplyUserID;
	}

	public void setRedemptionApplyUserID(String redemptionApplyUserID) {
		this.redemptionApplyUserID = redemptionApplyUserID;
	}
	
	// 用户ID
	String customerID;
	
	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	// RFID
	String rfidCode;
	
	public String getRfidCode() {
		return rfidCode;
	}

	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}
	
	// 标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
	String queryType;

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	
	// 签收人ID
	String signID;

	public String getSignID() {
		return signID;
	}

	public void setSignID(String signID) {
		this.signID = signID;
	}

	// 扫描列表
	public List<RedemptionApply> redemptionApplyInputList;
	
	public List<RedemptionApply> getRedemptionApplyInputList() {
		return redemptionApplyInputList;
	}

	public void setRedemptionApplyInputList(
			List<RedemptionApply> redemptionApplyInputList) {
		this.redemptionApplyInputList = redemptionApplyInputList;
	}

	
	// 扫描列表
	public List<Redemptionapplied> redemptionAppliedInputList;
	
	public List<Redemptionapplied> getRedemptionAppliedInputList() {
		return redemptionAppliedInputList;
	}

	public void setRedemptionAppliedInputList(
			List<Redemptionapplied> redemptionAppliedInputList) {
		this.redemptionAppliedInputList = redemptionAppliedInputList;
	}

	// 申请人
	String userName;

	// 申请时间
	String userTime;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTime() {
		return userTime;
	}

	public void setUserTime(String userTime) {
		this.userTime = userTime;
	}
	 //备货RFID列表
	private List<StockMsgList> stockLists = new ArrayList<StockMsgList>();

    public List<StockMsgList> getStockLists() {
        return stockLists;
    }

    public void setStockLists(List<StockMsgList> stockLists) {
        this.stockLists = stockLists;
    }

    private List<Vledplanelist> vledplanelist;
    //换领申请单号

    public List<Vledplanelist> getVledplanelist() {
        return vledplanelist;
    }

    public void setVledplanelist(List<Vledplanelist> vledplanelist) {
        this.vledplanelist = vledplanelist;
    }

    private String redemptionAppliedID;
	//刀具编码
	private String toolCode;
	private int toolCount;
	public int getToolCount() {
		return toolCount;
	}
	public void setToolCount(int toolCount) {
		this.toolCount = toolCount;
	}
	//库位码
	private String libraryCode;
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
	//要清空的rfid
	private List<String> delRfidList;
	//换领最后提交信息
	private List<TempToolTransfer> transfers;
	private List<TempToolTransfer> transfersThree;
	public List<TempToolTransfer> getTransfersThree() {
		return transfersThree;
	}
	public void setTransfersThree(List<TempToolTransfer> transfersThree) {
		this.transfersThree = transfersThree;
	}
	//Old_RFID
	private String oldRfidString;
	private String userID;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	private String ledPlaneStauts;
	public String getLedPlaneStauts() {
		return ledPlaneStauts;
	}
	public void setLedPlaneStauts(String ledPlaneStauts) {
		this.ledPlaneStauts = ledPlaneStauts;
	}
	//备货分盒数量
	private int tempNumber;
	public String getRedemptionAppliedID() {
		return redemptionAppliedID;
	}
	public void setRedemptionAppliedID(String redemptionAppliedID) {
		this.redemptionAppliedID = redemptionAppliedID;
	}
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	public String getLibraryCode() {
		return libraryCode;
	}
	public void setLibraryCode(String libraryCode) {
		this.libraryCode = libraryCode;
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
	public List<TempToolTransfer> getTransfers() {
		return transfers;
	}
	public void setTransfers(List<TempToolTransfer> transfers) {
		this.transfers = transfers;
	}
	public List<String> getDelRfidList() {
		return delRfidList;
	}
	public void setDelRfidList(List<String> delRfidList) {
		this.delRfidList = delRfidList;
	}
	
	
	
}
