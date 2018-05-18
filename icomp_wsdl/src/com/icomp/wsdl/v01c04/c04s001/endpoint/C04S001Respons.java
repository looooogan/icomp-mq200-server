package com.icomp.wsdl.v01c04.c04s001.endpoint;


import java.util.List;

import com.icomp.common.pojo.BaseRespons;

public class C04S001Respons extends BaseRespons{

	/**
	 * 
	 */
	//刀具编码
	private String toolCode;
	//库存数量
	private String libraryCount;
	//刀具类型（0非单品刀具，1单品刀具）
	private String toolConsumetype;
	//刀具ID
	private String toolID;


	public String getLibraryCount() {
		return libraryCount;
	}

	public void setLibraryCount(String libraryCount) {
		this.libraryCount = libraryCount;
	}

	public String getToolConsumetype() {
		return toolConsumetype;
	}

	public void setToolConsumetype(String toolConsumetype) {
		this.toolConsumetype = toolConsumetype;
	}

	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	private static final long serialVersionUID = 1533948940999809072L;
	/* 刀具类型  */
	private String toolType;
	
	public String getToolType() {
		return toolType;
	}
	public void setToolType(String toolType) {
		this.toolType = toolType;
	}
	/*库位码*/
	private String libraryCodeID;
	public String getLibraryCodeID() {
		return libraryCodeID;
	}
	public void setLibraryCodeID(String libraryCodeID) {
		this.libraryCodeID = libraryCodeID;
	}
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

	//在库数量
	private int toolCount;
	private List<StockingInfo> stockingInfoList;
	public List<StockingInfo> getStockingInfoList() {
		return stockingInfoList;
	}
	public void setStockingInfoList(List<StockingInfo> stockingInfoList) {
		this.stockingInfoList = stockingInfoList;
	}
}
