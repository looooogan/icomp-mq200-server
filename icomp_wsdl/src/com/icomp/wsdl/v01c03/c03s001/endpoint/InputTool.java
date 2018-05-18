package com.icomp.wsdl.v01c03.c03s001.endpoint;

import java.io.Serializable;

public class InputTool  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7692813260416276048L;
	
	/* 刀具编码 */
	private String toolCode;

	/* 厂区 */
	private String complex;

	/* 库房 */
	private String depot;

	/* 货架 */
	private String shelf;

	/* 层 */
	private String layer;

	/* 货位 */
	private String stack;

	/* 入库数量 */
	private int inputNumber;
	
	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	public String getFactoryFloor() {
		return complex;
	}

	public void setComplex(String complex) {
		this.complex = complex;
	}

	public String getDepot() {
		return depot;
	}

	public void setDepot(String depot) {
		this.depot = depot;
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

	public int getInputNumber() {
		return inputNumber;
	}

	public void setInputNumber(int inputNumber) {
		this.inputNumber = inputNumber;
	}
}
