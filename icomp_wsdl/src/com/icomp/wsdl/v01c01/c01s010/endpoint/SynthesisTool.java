package com.icomp.wsdl.v01c01.c01s010.endpoint;

import java.io.Serializable;

public class SynthesisTool implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2421085261653289860L;

	/* 刀具id */
	private String toolID;
	
	/* 材料号 */
	private String materialNum;
	
	/* 刀具类型 */
	private String toolType;
	
	/* 刀具数量 */
	private String toolCount;
	
	/* 换装数量 */
	private String repsetCount;
	
	/* 丢刀数量 */
	private String loseCount;


	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

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

	public String getToolCount() {
		return toolCount;
	}

	public void setToolCount(String toolCount) {
		this.toolCount = toolCount;
	}
	public String getRepsetCount() {
		return repsetCount;
	}
	
	public void setRepsetCount(String repsetCount) {
		this.repsetCount = repsetCount;
	}
	
	public String getLoseCount() {
		return loseCount;
	}
	
	public void setLoseCount(String loseCount) {
		this.loseCount = loseCount;
	}
}
