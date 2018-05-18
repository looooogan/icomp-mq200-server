package com.icomp.wsdl.v01c01.c01s016.endpoint;

import java.io.Serializable;
import java.util.List;
/**
 * 刀具交接类
 * @ClassName: ToolJoint 
 * @author Taoyy
 * @date 2014-9-23 上午9:12:26
 */
public class ToolJoint implements Serializable {

	private static final long serialVersionUID = 4552935074814293238L;
	
	//刀具ID
	private String toolID;
		
	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}
	
	//材料号
	private String materialNumber;
		
	public String getMaterialNumber() {
		return materialNumber;
	}

	public void setMaterialNumber(String materialNumber) {
		this.materialNumber = materialNumber;
	}
	
	//报废数量
	private String scrapCount;

	public String getScrapCount() {
		return scrapCount;
	}

	public void setScrapCount(String scrapCount) {
		this.scrapCount = scrapCount;
	}
	
	//丢刀数量
	private String lostCount;
	
	public String getLostCount() {
		return lostCount;
	}
	public void setLostCount(String lostCount) {
		this.lostCount = lostCount;
	}
	
	//丟刀确认人
	private String lostIdentifyingUser;

	public String getLostIdentifyingUser() {
		return lostIdentifyingUser;
	}

	public void setLostIdentifyingUser(String lostIdentifyingUser) {
		this.lostIdentifyingUser = lostIdentifyingUser;
	}

	//刀具状态
	private String toolState;

	public String getToolState() {
		return toolState;
	}

	public void setToolState(String toolState) {
		this.toolState = toolState;
	}

	//通知单号
	private String ToolRepairNoticeID;
	//刀具rfid
	private List<String> rfidString;
	//送回数量
	private int returnCount;
	//新刀数量
	private int newCount;
	//旧刀数量
	private int oldCount;
	//确认人
	private String IdentifyingUser;
	//报废数量
	private int delCount;
	//领取数量
	private int sentBackNumber;
	//刀具编码
	private String toolCode;
	//授权人ID
	private String gruantUserID;
	// 送回数量列表
	private List<Integer> returnCountList;
	public List<Integer> getReturnCountList() {
		return returnCountList;
	}

	public void setReturnCountList(List<Integer> returnCountList) {
		this.returnCountList = returnCountList;
	}
	//刀具部门
	private String toolThisType;
	
	public String getToolThisType() {
		return toolThisType;
	}
	public void setToolThisType(String toolThisType) {
		this.toolThisType = toolThisType;
	}
	public String getGruantUserID() {
		return gruantUserID;
	}
	public void setGruantUserID(String gruantUserID) {
		this.gruantUserID = gruantUserID;
	}
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	public int getSentBackNumber() {
		return sentBackNumber;
	}
	public void setSentBackNumber(int sentBackNumber) {
		this.sentBackNumber = sentBackNumber;
	}
	public int getDelCount() {
		return delCount;
	}
	public void setDelCount(int delCount) {
		this.delCount = delCount;
	}
	public String getToolRepairNoticeID() {
		return ToolRepairNoticeID;
	}
	public void setToolRepairNoticeID(String toolRepairNoticeID) {
		ToolRepairNoticeID = toolRepairNoticeID;
	}
	public  List<String> getRfidString() {
		return rfidString;
	}
	public void setRfidString( List<String> rfidString) {
		this.rfidString = rfidString;
	}
	public int getReturnCount() {
		return returnCount;
	}
	public void setReturnCount(int returnCount) {
		this.returnCount = returnCount;
	}
	public int getNewCount() {
		return newCount;
	}
	public void setNewCount(int newCount) {
		this.newCount = newCount;
	}
	public int getOldCount() {
		return oldCount;
	}
	public void setOldCount(int oldCount) {
		this.oldCount = oldCount;
	}

	public String getIdentifyingUser() {
		return IdentifyingUser;
	}
	public void setIdentifyingUser(String identifyingUser) {
		IdentifyingUser = identifyingUser;
	}
	
	
	
}
