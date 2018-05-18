package com.icomp.wsdl.v01c01.c01s001.endpoint;

import java.util.List;

import com.icomp.common.pojo.BaseRespons;

public class C01S001Respons extends BaseRespons {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3141031861267681716L;
	
	
	
	/* 材料号*/
	private String materialNum;
	
	/* 库位码*/
	private String libraryCodeID;
	
	/* 每盒数量*/
	private String unitnumber;
	
	/* 标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）*/
	private String queryType;
	
	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	/* 批次*/
	private List<String> procuredBatch;
	
	public String getMaterialNum() {
		return materialNum;
	}

	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}

	public String getLibraryCodeID() {
		return libraryCodeID;
	}

	public void setLibraryCodeID(String libraryCodeID) {
		this.libraryCodeID = libraryCodeID;
	}

	public String getUnitnumber() {
		return unitnumber;
	}

	public void setUnitnumber(String unitnumber) {
		this.unitnumber = unitnumber;
	}

	public List<String> getProcuredBatch() {
		return procuredBatch;
	}

	public void setProcuredBatch(List<String> procuredBatch) {
		this.procuredBatch = procuredBatch;
	}

	private String storageNum;

	public String getStorageNum() {
		return storageNum;
	}

	public void setStorageNum(String storageNum) {
		this.storageNum = storageNum;
	}
	
	/* 刀具ID*/
	private String toolID;
	
	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	/* 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他 */
	private String toolConsumetype;

	public String getToolConsumetype() {
		return toolConsumetype;
	}

	public void setToolConsumetype(String toolConsumetype) {
		this.toolConsumetype = toolConsumetype;
	}
	
	/* 采购批次数量列表 */
	private List<ProcuredBatchCount> procuredBatchCount;

	public List<ProcuredBatchCount> getProcuredBatchCount() {
		return procuredBatchCount;
	}

	public void setProcuredBatchCount(List<ProcuredBatchCount> procuredBatchCount) {
		this.procuredBatchCount = procuredBatchCount;
	}
}
