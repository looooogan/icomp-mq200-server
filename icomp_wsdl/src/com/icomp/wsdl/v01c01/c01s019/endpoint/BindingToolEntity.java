package com.icomp.wsdl.v01c01.c01s019.endpoint;


import java.io.Serializable;

public class BindingToolEntity implements Serializable {
	private static final long serialVersionUID = 2776704132721946483L;
	//刀具ID
	private String toolID;
	//材料号（刀具编码）
	private String toolCode;



	//激光码
	private String laserCode;

	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	public String getLaserCode() {
		return laserCode;
	}

	public void setLaserCode(String laserCode) {
		this.laserCode = laserCode;
	}


}
