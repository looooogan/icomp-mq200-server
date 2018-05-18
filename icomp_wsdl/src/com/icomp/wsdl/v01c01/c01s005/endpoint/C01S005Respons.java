package com.icomp.wsdl.v01c01.c01s005.endpoint;


import com.icomp.common.pojo.BaseRespons;

public class C01S005Respons extends BaseRespons {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3141031861267681716L;
	//材料号
	private String material;
	//刀具ID
	private String toolID;
	//刀具类型（0:可刃磨钻头1可刃磨刀片2一次性刀片9其他）
	private String toolConsumetype;

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	public String getToolConsumetype() {
		return toolConsumetype;
	}

	public void setToolConsumetype(String toolConsumetype) {
		this.toolConsumetype = toolConsumetype;
	}
}
