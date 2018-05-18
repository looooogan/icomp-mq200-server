package com.icomp.wsdl.v01c01.c01s010.endpoint;

import java.io.Serializable;

public class GrindingBitInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5159620753941276146L;
	
	/* 材料号 */
	private String materialNum;
	
	/* 数量 */
	private String count;
	
	/* 状态（待定） */
	private String state;
	
	/* 刀具类型 */
	private String toolType;
	private String singleToolRfid;

	public String getSingleToolRfid() {
		return singleToolRfid;
	}

	public void setSingleToolRfid(String singleToolRfid) {
		this.singleToolRfid = singleToolRfid;
	}

	public String getMaterialNum() {
		return materialNum;
	}

	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getToolType() {
		return toolType;
	}

	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

}
