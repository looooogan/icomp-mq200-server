package com.icomp.wsdl.v01c01.c01s010.endpoint;

import java.io.Serializable;

public class InputTool  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7692813260416276048L;
	
	/* 材料号*/
	private String materialNum;

	public String getMaterialNum() {
		return materialNum;
	}

	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}
	
	/* 报废数量*/
	private String scrapCount;

	public String getScrapCount() {
		return scrapCount;
	}

	public void setScrapCount(String scrapCount) {
		this.scrapCount = scrapCount;
	}
	
	/* 丟刀数量*/
	private String throwingKnifeCount;

	public String getThrowingKnifeCount() {
		return throwingKnifeCount;
	}

	public void setThrowingKnifeCount(String throwingKnifeCount) {
		this.throwingKnifeCount = throwingKnifeCount;
	}
	
	/* 丟刀确认人*/
	private String throwingKnifeUser;

	public String getThrowingKnifeUser() {
		return throwingKnifeUser;
	}

	public void setThrowingKnifeUser(String throwingKnifeUser) {
		this.throwingKnifeUser = throwingKnifeUser;
	}
	
	/* 当前状态（0报废，1丢刀）*/
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
