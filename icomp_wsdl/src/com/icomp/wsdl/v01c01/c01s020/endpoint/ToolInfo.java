package com.icomp.wsdl.v01c01.c01s020.endpoint;

import java.io.Serializable;

public class ToolInfo  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2776704132721946483L;
	//刀具编码
	private String toolCode;
	//刀具数量
	private int toolCount;
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	public int getToolCount() {
		return toolCount;
	}
	public void setToolCount(int toolCount) {
		this.toolCount = toolCount;
	}

}
