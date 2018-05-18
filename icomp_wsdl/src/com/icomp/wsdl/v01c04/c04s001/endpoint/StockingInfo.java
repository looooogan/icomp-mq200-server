package com.icomp.wsdl.v01c04.c04s001.endpoint;

import java.io.Serializable;

public class StockingInfo    implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5403452703963061345L;

	private String toolCode;
	
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	/* RFID */
	private String rfidString;
	public String getRfidString() {
		return rfidString;
	}
	public void setRfidString(String rfidString) {
		this.rfidString = rfidString;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	/* 捆绑数量 */
	private int count;
	/* 库存类型 */
	private String storeType;

	public String getStoreType() {
		return storeType;
	}
	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
	/* 已扫描数量 */
	private int scanfCount;

	public int getScanfCount() {
		return scanfCount;
	}
	public void setScanfCount(int scanfCount) {
		this.scanfCount = scanfCount;
	}
	/* 授权人(盘点出现盘亏盘盈授权)	*/ 
	private String removeUser;

	/**
	 * 授权人(盘点出现盘亏盘盈授权)取得
	 * @return removeUser
	 */
	public String getRemoveUser() {
		return removeUser;
	}

	/**
	 * 授权人(盘点出现盘亏盘盈授权)设定
	 * @param removeUser
	 */
	public void setRemoveUser(String removeUser) {
		this.removeUser = removeUser;
	}
}
