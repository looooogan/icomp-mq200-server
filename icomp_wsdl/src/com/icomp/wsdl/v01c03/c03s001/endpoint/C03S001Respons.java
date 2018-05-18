package com.icomp.wsdl.v01c03.c03s001.endpoint;


import com.icomp.common.pojo.BaseRespons;

import java.util.List;

public class C03S001Respons extends BaseRespons {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8919395590284143839L;

	/* 刀具编码  */
	public String toolCode;


	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	public String getToolConsumeType() {
		return toolConsumeType;
	}

	public void setToolConsumeType(String toolConsumeType) {
		this.toolConsumeType = toolConsumeType;
	}
	//刀具ID
	private String toolID;
	//刀具类型
	private String toolConsumeType;
	//是否已初始化（0未初始化，1已初始化）
	private String isHas;

	public String getIsHas() {
		return isHas;
	}

	public void setIsHas(String isHas) {
		this.isHas = isHas;
	}


	public String getLibraryCodeID() {
		return LibraryCodeID;
	}

	public void setLibraryCodeID(String libraryCodeID) {
		LibraryCodeID = libraryCodeID;
	}

	//库位码（xx-xx-xx）
	private String LibraryCodeID;



	public String getKnifelnventoryNumber() {
		return knifelnventoryNumber;
	}

	public void setKnifelnventoryNumber(String knifelnventoryNumber) {
		this.knifelnventoryNumber = knifelnventoryNumber;
	}
	//库存数量
	private String knifelnventoryNumber ;




	//扫描合成刀具编码
	private String synthesisParametersCode;

	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}

	//合成刀具信息
	private List<SynthesisEntity> synthesisList;

	public List<SynthesisEntity> getSynthesisList() {
		return synthesisList;
	}

	public void setSynthesisList(List<SynthesisEntity> synthesisList) {
		this.synthesisList = synthesisList;
	}


























	/* 厂区 */
	private String complex;

	public String getComplex() {
		return complex;
	}


	public void setComplex(String complex) {
		this.complex = complex;
	}

	/* 库房 */
	private String depot;

	/* 货架 */
	private String shelf;

	/* 层 */
	private String layer;

	/* 货位 */
	private String stack;

	/* 现有数量 */
	private int existingNumber;

	/* 每盒数量 */
	private int toolUnitnumber;

	/* 库位码 */
	private String libraryCode;

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	public String getLibraryCode() {
		return libraryCode;
	}

	public void setLibraryCode(String libraryCode) {
		this.libraryCode = libraryCode;
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

	public int getExistingNumber() {
		return existingNumber;
	}

	public void setExistingNumber(int existingNumber) {
		this.existingNumber = existingNumber;
	}

	public int getToolUnitnumber() {
		return toolUnitnumber;
	}

	public void setToolUnitnumber(int toolUnitnumber) {
		this.toolUnitnumber = toolUnitnumber;
	}


}
