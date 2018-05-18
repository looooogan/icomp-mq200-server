package com.icomp.wsdl.v01c01.c01s004.endpoint;

import java.io.Serializable;

/**
 * 补领出库
 * @ClassName: ReplacementToolInfo 
 * @author Taoyy
 * @date 2016-3-8 下午5:05:50
 */
public class ReplacementApplyInfo implements Serializable {
	private static final long serialVersionUID = 8279334903203236827L;
	//补领单号
	private String replacementNumber;
	public String getReplacementNumber() {
		return replacementNumber;
	}
	public void setReplacementNumber(String replacementNumber) {
		this.replacementNumber = replacementNumber;
	}

	//刀具ID
	private String toolID;
	public String getToolID() {
		return toolID;
	}
	public void setToolID(String toolID) {
		this.toolID = toolID;
	}
	
	//材料号
	private String materialNum;
	public String getMaterialNum() {
		return materialNum;
	}
	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}
	
	//库位码
	private String libraryCodeID;
	public String getLibraryCodeID() {
		return libraryCodeID;
	}
	
	//补领申请数量
	private String appliedCount;
	public String getAppliedCount() {
		return appliedCount;
	}
	public void setAppliedCount(String appliedCount) {
		this.appliedCount = appliedCount;
	}
	public void setLibraryCodeID(String libraryCodeID) {
		this.libraryCodeID = libraryCodeID;
	}
	
	//库存量
	private String inventory;
	public String getInventory() {
		return inventory;
	}
	public void setInventory(String inventory) {
		this.inventory = inventory;
	}
	private String toolType;

	public String getToolType() {
		return toolType;
	}

	public void setToolType(String toolType) {
		this.toolType = toolType;
	}
}
