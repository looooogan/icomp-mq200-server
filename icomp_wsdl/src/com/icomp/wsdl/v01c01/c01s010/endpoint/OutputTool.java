package com.icomp.wsdl.v01c01.c01s010.endpoint;

import java.io.Serializable;
import java.math.BigDecimal;

public class OutputTool  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7692813260416276048L;
	
	/* 刀具id*/
	private String toolID;

	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	/* 材料号*/
	private String materialNum;

	public String getMaterialNum() {
		return materialNum;
	}

	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}

	/* 刀具类型*/
	private String toolType;

	public String getToolType() {
		return toolType;
	}

	public void setToolType(String toolType) {
		this.toolType = toolType;
	}
	
	/* 刀具数量*/
	private BigDecimal toolCount;

	public BigDecimal getToolCount() {
		return toolCount;
	}

	public void setToolCount(BigDecimal toolCount) {
		this.toolCount = toolCount;
	}
}
