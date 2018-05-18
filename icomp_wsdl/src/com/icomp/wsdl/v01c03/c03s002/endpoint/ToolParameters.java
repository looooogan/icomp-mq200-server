package com.icomp.wsdl.v01c03.c03s002.endpoint;

import java.io.Serializable;

public class ToolParameters   implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8711638524346278897L;
	
	/* 刀具编码 */
	private String toolCode;
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	public String getToolType() {
		return toolType;
	}
	public void setToolType(String toolType) {
		this.toolType = toolType;
	}
	public int getToolCount() {
		return toolCount;
	}
	public void setToolCount(int toolCount) {
		this.toolCount = toolCount;
	}
	/* 刀具类型 */
	private String toolType;
	/* 数量 */
	private int toolCount;
	//合成刀具编码
	private String synthesisParametersCode;
	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}
	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}
}
