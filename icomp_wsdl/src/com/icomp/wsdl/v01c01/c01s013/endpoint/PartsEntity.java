package com.icomp.wsdl.v01c01.c01s013.endpoint;

import java.io.Serializable;

/**
 * 零部件实体
 * 
 * @author shiL
 * 
 */
public class PartsEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 零部件ID
	private String partsID;
	// 零部件名称
	private String partsName;
	// 零部件类型
	private String partsType;
	private String processCount;

	public String getPartsID() {
		return partsID;
	}
	public void setPartsID(String partsID) {
		this.partsID = partsID;
	}
	public String getPartsName() {
		return partsName;
	}
	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}
	public String getPartsType() {
		return partsType;
	}
	public void setPartsType(String partsType) {
		this.partsType = partsType;
	}

	public String getProcessCount() {
		return processCount;
	}

	public void setProcessCount(String processCount) {
		this.processCount = processCount;
	}
}
