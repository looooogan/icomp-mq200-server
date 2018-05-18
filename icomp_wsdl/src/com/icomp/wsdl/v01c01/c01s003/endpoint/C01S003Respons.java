package com.icomp.wsdl.v01c01.c01s003.endpoint;

import com.icomp.common.pojo.BaseRespons;
import com.icomp.entity.base.Redemptionapplied;
import com.icomp.entity.base.Vledplanelist;
import com.icomp.entity.base.Vquerytoollist;

import java.util.List;

/**
 * C01S003Respons-返回参数
 * @ClassName: C01S003Respons 
 * @author Taoyy
 * @date 2014-9-22 下午4:13:22
 */
/**
 * C01S003Respons-输出参数
 * 
 * @ClassName: C01S003Respons
 * @author Taoyy
 * @date 2014-9-22 下午4:13:22
 */
public class C01S003Respons extends BaseRespons {

	private static final long serialVersionUID = 5001175783973560215L;
	
	// 取得换领申请人申请列表
	private List<AppliedInfo> appliedInfoList;
	
	public List<AppliedInfo> getAppliedInfoList() {
		return appliedInfoList;
	}

	public void setAppliedInfoList(List<AppliedInfo> appliedInfoList) {
		this.appliedInfoList = appliedInfoList;
	}
	
	// 刀具ID
	private String toolID;
	
	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}
	
	// 材料号
	private String materialNum;

	public String getMaterialNum() {
		return materialNum;
	}

	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}
	
	// 库存量
	private String inventory;

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}
	
	// 刀具类型
	private String toolType;

	public String getToolType() {
		return toolType;
	}

	public void setToolType(String toolType) {
		this.toolType = toolType;
	}
	
	// 库位码
	private String libraryCodeID;

	public String getLibraryCodeID() {
		return libraryCodeID;
	}

	public void setLibraryCodeID(String libraryCodeID) {
		this.libraryCodeID = libraryCodeID;
	}

	
	
	
	
	
	
	
	private Vquerytoollist vquerytoollist;
	
	public Vquerytoollist getVquerytoollist() {
		return vquerytoollist;
	}

	public void setVquerytoollist(Vquerytoollist vquerytoollist) {
		this.vquerytoollist = vquerytoollist;
	}

	// 换领申请单列表
	private List<RedemptionApplied> redemptionappliedList;

	public List<RedemptionApplied> getRedemptionappliedList() {
		return redemptionappliedList;
	}

	public void setRedemptionappliedList(
			List<RedemptionApplied> redemptionappliedList) {
		this.redemptionappliedList = redemptionappliedList;
	}

	//备货信息
	private List<ChoiceDemption> choiceDemptionList;
	
	public List<ChoiceDemption> getChoiceDemptionList() {
		return choiceDemptionList;
	}

	public void setChoiceDemptionList(List<ChoiceDemption> choiceDemptionList) {
		this.choiceDemptionList = choiceDemptionList;
	}

	
	
	
	
	
	
	
	// 申请单列表
	private List<Redemptionapplied> redemptionAppliedList;
	// 申请单列表详细信息
	private List<RedemptionDemption> reDetailedMsgList;
	// 换领最后提交信息
	private List<TempToolTransfer> transfers;
	// 待换领刀具列表
	private List<RenewedToolInfo> renewedToolInfoList;
	// 刀具编码
	private String toolCode;
	// 整盒数量
	private int toolCount;
	// 最后流程
	private String flowName;
	// 操作人
	private String optionName;
	// RFID
	private String rfidString;
	// New_RFID
	private String newRfidString;
	// Old_RFID
	private String oldRfidString;
	// 临时变量
	private int tempNumber;
	// 申请单号
	public String redemptionApplied;
	private boolean existLedplane =false;
	private List<Vledplanelist> ledplaneList;
	private List<LedPlaneStauts> ledPlaneStautsList;
	private List<LedPlaneUser> ledPlaneUserList;

	public List<LedPlaneUser> getLedPlaneUserList() {
		return ledPlaneUserList;
	}

	public void setLedPlaneUserList(List<LedPlaneUser> ledPlaneUserList) {
		this.ledPlaneUserList = ledPlaneUserList;
	}

	public List<LedPlaneStauts> getLedPlaneStautsList() {
		return ledPlaneStautsList;
	}

	public void setLedPlaneStautsList(List<LedPlaneStauts> ledPlaneStautsList) {
		this.ledPlaneStautsList = ledPlaneStautsList;
	}

	public List<Vledplanelist> getLedplaneList() {
		return ledplaneList;
	}

	public void setLedplaneList(List<Vledplanelist> ledplaneList) {
		this.ledplaneList = ledplaneList;
	}

	public boolean isExistLedplane() {
		return existLedplane;
	}

	public void setExistLedplane(boolean existLedplane) {
		this.existLedplane = existLedplane;
	}

	private List<String> ridsList;

	public List<RenewedToolInfo> getRenewedToolInfoList() {
		return renewedToolInfoList;
	}

	public void setRenewedToolInfoList(List<RenewedToolInfo> renewedToolInfoList) {
		this.renewedToolInfoList = renewedToolInfoList;
	}

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	public int getToolCount() {
		return toolCount;
	}

	public void setToolCount(int toolCount) {
		this.toolCount = toolCount;
	}

	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public List<Redemptionapplied> getRedemptionAppliedList() {
		return redemptionAppliedList;
	}

	public void setRedemptionAppliedList(
			List<Redemptionapplied> redemptionAppliedList) {
		this.redemptionAppliedList = redemptionAppliedList;
	}

	/**
	 * 申请单列表详细信息
	 * 
	 * @title getReDetailedMsgList
	 * @return List<RedemptionDemption>
	 */
	public List<RedemptionDemption> getReDetailedMsgList() {
		return reDetailedMsgList;
	}

	/**
	 * 申请单列表详细信息
	 * 
	 * @title setReDetailedMsgList
	 * @param reDetailedMsgList
	 *            void
	 */
	public void setReDetailedMsgList(List<RedemptionDemption> reDetailedMsgList) {
		this.reDetailedMsgList = reDetailedMsgList;
	}

	public String getRfidString() {
		return rfidString;
	}

	public void setRfidString(String rfidString) {
		this.rfidString = rfidString;
	}

	public int getTempNumber() {
		return tempNumber;
	}

	public void setTempNumber(int tempNumber) {
		this.tempNumber = tempNumber;
	}

	public List<String> getRidsList() {
		return ridsList;
	}

	public void setRidsList(List<String> ridsList) {
		this.ridsList = ridsList;
	}

	public List<TempToolTransfer> getTransfers() {
		return transfers;
	}

	public void setTransfers(List<TempToolTransfer> transfers) {
		this.transfers = transfers;
	}

	public String getRedemptionApplied() {
		return redemptionApplied;
	}

	public void setRedemptionApplied(String redemptionApplied) {
		this.redemptionApplied = redemptionApplied;
	}

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

}
