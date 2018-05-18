package com.icomp.wsdl.v01c01.c01s010.endpoint;

import java.io.Serializable;

public class ScrapGrindingMsg implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5112465236495962251L;

	/*材料号*/
	private String materialNum;
	
	/*刀具类型*/
	private String toolType;
	
	/*总数量*/
	private String totalNumber;
	
	/*换装数量*/
	private String grindingCount;
	
	/*状态*/
	private String state;

	public String getMaterialNum() {
		return materialNum;
	}

	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}

	public String getToolType() {
		return toolType;
	}

	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

	public String getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(String totalNumber) {
		this.totalNumber = totalNumber;
	}

	public String getGrindingCount() {
		return grindingCount;
	}

	public void setGrindingCount(String grindingCount) {
		this.grindingCount = grindingCount;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
