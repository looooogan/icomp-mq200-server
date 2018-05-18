package com.icomp.wsdl.v01c01.c01s004.endpoint;

import java.util.List;
import java.util.Map;

import com.icomp.common.pojo.BaseRespons;
import com.icomp.entity.base.Replacement;

/**
 * C01S004Respons-返回参数
 * 
 * @ClassName: C01S004Respons
 * @author Taoyy
 * @date 2014-9-22 下午5:03:19
 */
public class C01S004Respons extends BaseRespons {

	private static final long serialVersionUID = -7650205046744286710L;
	
	// 待补领出库刀具列表
	private List<Replacement> replacementList;
	
	public List<Replacement> getReplacementList() {
		return replacementList;
	}

	public void setReplacementList(List<Replacement> replacementList) {
		this.replacementList = replacementList;
	}
	
	private List<Map<String, Object>> rList;
	
	public List<Map<String, Object>> getrList() {
		return rList;
	}

	public void setrList(List<Map<String, Object>> rList) {
		this.rList = rList;
	}

	// 补领出库申请单信息
	private List<ReplacementApplyInfo> replacementApplyInfoList;

	public List<ReplacementApplyInfo> getReplacementApplyInfoList() {
		return replacementApplyInfoList;
	}

	public void setReplacementApplyInfoList(
			List<ReplacementApplyInfo> replacementApplyInfoList) {
		this.replacementApplyInfoList = replacementApplyInfoList;
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

	// 申领单号
	private String replacementID;
	// 刀具编码
	private String toolCode;
	// 待换领刀具列表
	private List<ReplacementToolInfo> replacementToolInfoList;
	//刀具数量
	private int toolCount;
	public int getToolCount() {
		return toolCount;
	}

	public void setToolCount(int toolCount) {
		this.toolCount = toolCount;
	}

	public String getReplacementID() {
		return replacementID;
	}

	public void setReplacementID(String replacementID) {
		this.replacementID = replacementID;
	}

	public List<ReplacementToolInfo> getReplacementToolInfoList() {
		return replacementToolInfoList;
	}

	public void setReplacementToolInfoList(List<ReplacementToolInfo> replacementToolInfoList) {
		this.replacementToolInfoList = replacementToolInfoList;
	}

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	//修复类型
	private  String  ToolGrinding;

	public String getToolGrinding() {
		return ToolGrinding;
	}

	public void setToolGrinding(String toolGrinding) {
		ToolGrinding = toolGrinding;
	}
}
