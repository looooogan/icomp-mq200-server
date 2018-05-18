package com.icomp.wsdl.v01c01.c01s016.endpoint;

import java.util.List;

import com.icomp.common.pojo.BaseRespons;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.wsdl.v01c01.c01s010.endpoint.OutputTool;

/**
 * 回库处理-返回参数
 * 
 * @ClassName: C01S016Respons
 * @author Taoyy
 * @date 2016-3-1 上午9:06:32
 */
public class C01S016Respons extends BaseRespons {

	private static final long serialVersionUID = -4738427815101674859L;
	
	// 待报废刀具
	private List<ToolJoint> toolJoint;

	public List<ToolJoint> getToolJoint() {
		return toolJoint;
	}

	public void setToolJoint(List<ToolJoint> toolJoint) {
		this.toolJoint = toolJoint;
	}

	
	
	
	
	
	// 刀具待报废列表(非单品）
	private List<Tooltransfer> toolInfoDetailList;

	public List<Tooltransfer> getToolInfoDetailList() {
		return toolInfoDetailList;
	}

	public void setToolInfoDetailList(List<Tooltransfer> toolInfoDetailList) {
		this.toolInfoDetailList = toolInfoDetailList;
	}
	
	// 通知单号
	private String ToolRepairNoticeID;
	// 刀具编码
	private String toolCode;
	// 修复方式
	private String toolStatus;
	// 送回数量
	private int lostCount;
	// 处理方式
	private String replacementFlag;
	// 领取数量
	private int sentBackNumber;
	// 修复方式
	private String toolStatusText;
	// 确认人id
	private String IdentifyingUserId;
	// 确认人名称
	private String IdentifyingUserText;
	// 处理方式
	private String replacementFlagText;

	public String getToolStatusText() {
		return toolStatusText;
	}

	public void setToolStatusText(String toolStatusText) {
		this.toolStatusText = toolStatusText;
	}

	// 刀具部门
	private String toolThisState;

	public String getToolThisState() {
		return toolThisState;
	}

	public void setToolThisState(String toolThisState) {
		this.toolThisState = toolThisState;
	}



	public String getReplacementFlagText() {
		return replacementFlagText;
	}

	public void setReplacementFlagText(String replacementFlagText) {
		this.replacementFlagText = replacementFlagText;
	}

	public int getSentBackNumber() {
		return sentBackNumber;
	}

	public void setSentBackNumber(int sentBackNumber) {
		this.sentBackNumber = sentBackNumber;
	}

	public String getToolRepairNoticeID() {
		return ToolRepairNoticeID;
	}

	public void setToolRepairNoticeID(String toolRepairNoticeID) {
		ToolRepairNoticeID = toolRepairNoticeID;
	}

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	public String getToolStatus() {
		return toolStatus;
	}

	public void setToolStatus(String toolStatus) {
		this.toolStatus = toolStatus;
	}

	public int getLostCount() {
		return lostCount;
	}

	public void setLostCount(int lostCount) {
		this.lostCount = lostCount;
	}

	public String getReplacementFlag() {
		return replacementFlag;
	}

	public void setReplacementFlag(String replacementFlag) {
		this.replacementFlag = replacementFlag;
	}

	// 刀具交接信息


	public String getIdentifyingUserId() {
		return IdentifyingUserId;
	}

	public void setIdentifyingUserId(String identifyingUserId) {
		IdentifyingUserId = identifyingUserId;
	}

	public String getIdentifyingUserText() {
		return IdentifyingUserText;
	}

	public void setIdentifyingUserText(String identifyingUserText) {
		IdentifyingUserText = identifyingUserText;
	}

}
