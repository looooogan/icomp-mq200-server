package com.icomp.wsdl.v01c01.c01s003.endpoint;

import java.io.Serializable;

/**
 * 刀具换领
 * @ClassName: RenewedToolInfo 
 * @author Taoyy
 * @date 2014-9-22 下午4:35:04
 */
public class RenewedToolInfo implements Serializable {
	private static final long serialVersionUID = -7128334643347491760L;
	//库位码
	private String libraryCode;
	//货架
	private String shelf;
	//层
	private String layer;
	//货位
	private String stack;
	//A库数量
	private int	existingNumber_A;
	//B库数量
	private int	existingNumber_B;
	public String getLibraryCode() {
		return libraryCode;
	}
	public void setLibraryCode(String libraryCode) {
		this.libraryCode = libraryCode;
	}
	public String getShelf() {
		return shelf;
	}
	public void setShelf(String shelf) {
		this.shelf = shelf;
	}
	public String getLayer() {
		return layer;
	}
	public void setLayer(String layer) {
		this.layer = layer;
	}
	public String getStack() {
		return stack;
	}
	public void setStack(String stack) {
		this.stack = stack;
	}
	public int getExistingNumber_A() {
		return existingNumber_A;
	}
	public void setExistingNumber_A(int existingNumberA) {
		existingNumber_A = existingNumberA;
	}
	public int getExistingNumber_B() {
		return existingNumber_B;
	}
	public void setExistingNumber_B(int existingNumberB) {
		existingNumber_B = existingNumberB;
	}
	
	
	
	
}
