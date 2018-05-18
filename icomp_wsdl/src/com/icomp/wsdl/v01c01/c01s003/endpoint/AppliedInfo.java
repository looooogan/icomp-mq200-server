package com.icomp.wsdl.v01c01.c01s003.endpoint;

import java.io.Serializable;

/**
 * 取得换领申请人申请列表
 * 
 * @author yzq
 * 
 */
public class AppliedInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6510562650515966047L;

	// 材料号
	private String materialNum;

	public String getMaterialNum() {
		return materialNum;
	}

	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}
	
	// 库位码
	private String libraryCodeID;

	public String getLibraryCodeID() {
		return libraryCodeID;
	}

	public void setLibraryCodeID(String libraryCodeID) {
		this.libraryCodeID = libraryCodeID;
	}
	
	// 申请数量
	private String appliedNumber;

	public String getAppliedNumber() {
		return appliedNumber;
	}

	public void setAppliedNumber(String appliedNumber) {
		this.appliedNumber = appliedNumber;
	}

	// 扫描数量
	private String scanNumber;

	public String getScanNumber() {
		return scanNumber;
	}

	public void setScanNumber(String scanNumber) {
		this.scanNumber = scanNumber;
	}
	
	// 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他
	private String toolConsumetype;

	public String getToolConsumetype() {
		return toolConsumetype;
	}

	public void setToolConsumetype(String toolConsumetype) {
		this.toolConsumetype = toolConsumetype;
	}
}
