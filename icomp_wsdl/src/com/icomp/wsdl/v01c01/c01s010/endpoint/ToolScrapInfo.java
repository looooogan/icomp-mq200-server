package com.icomp.wsdl.v01c01.c01s010.endpoint;

import java.io.Serializable;

public class ToolScrapInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1213845897875369558L;

	/* 材料号 */
	private String materialNum;
	
	/* 报废数量 */
	private String scrapCount;
	
	/* 丟刀数量 */
	private String throwingKnifeCount;
	
	/* 丟刀确认人 */
	private String throwingKnifeUser;
	
	/* 当前状态（0报废，1丢刀） */
	private String state;

	public String getMaterialNum() {
		return materialNum;
	}

	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}

	public String getScrapCount() {
		return scrapCount;
	}

	public void setScrapCount(String scrapCount) {
		this.scrapCount = scrapCount;
	}

	public String getThrowingKnifeCount() {
		return throwingKnifeCount;
	}

	public void setThrowingKnifeCount(String throwingKnifeCount) {
		this.throwingKnifeCount = throwingKnifeCount;
	}

	public String getThrowingKnifeUser() {
		return throwingKnifeUser;
	}

	public void setThrowingKnifeUser(String throwingKnifeUser) {
		this.throwingKnifeUser = throwingKnifeUser;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
