package com.icomp.wsdl.v01c03.c03s001.endpoint;

public class InputInitialization {

	/*库位码*/
	private String libraryCode;
	/*厂区*/
	private String complex;
	/*货架*/
	private String shelf;
	/*层*/
	private String layer;
	/*货位*/
	private String stack;
	/*库房*/
	private String depot;
	/*每盒数量*/
	private int toolUnitnumber;
	/*刀具编码*/
	private String toolCode;
	public String getLibraryCode() {
		return libraryCode;
	}
	public void setLibraryCode(String libraryCode) {
		this.libraryCode = libraryCode;
	}
	public String getComplex() {
		return complex;
	}
	public void setComplex(String complex) {
		this.complex = complex;
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
	public String getDepot() {
		return depot;
	}
	public void setDepot(String depot) {
		this.depot = depot;
	}
	public int getToolUnitnumber() {
		return toolUnitnumber;
	}
	public void setToolUnitnumber(int toolUnitnumber) {
		this.toolUnitnumber = toolUnitnumber;
	}
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
}
