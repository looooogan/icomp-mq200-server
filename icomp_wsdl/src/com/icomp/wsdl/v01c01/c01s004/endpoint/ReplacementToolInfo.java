package com.icomp.wsdl.v01c01.c01s004.endpoint;

import java.io.Serializable;

/**
 * 待换领刀具
 * @ClassName: ReplacementToolInfo 
 * @author Taoyy
 * @date 2014-9-22 下午5:05:50
 */
public class ReplacementToolInfo implements Serializable {
	private static final long serialVersionUID = 8279334903203236827L;
	//库位码
	private String libraryCode;
	//货架
	private String shelf;
	//层
	private String layer;
	//货位
	private String stack;
	//刀具编成
	private String toolCode;
	//在A库数量
	private int existingNumber_A;
	//在B库数量
	private int existingNumber_B;
	
	
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
	public void setExistingNumber_A(int existingNumber_A) {
		this.existingNumber_A = existingNumber_A;
	}
	public int getExistingNumber_B() {
		return existingNumber_B;
	}
	public void setExistingNumber_B(int existingNumber_B) {
		this.existingNumber_B = existingNumber_B;
	}
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	
	
	
}
