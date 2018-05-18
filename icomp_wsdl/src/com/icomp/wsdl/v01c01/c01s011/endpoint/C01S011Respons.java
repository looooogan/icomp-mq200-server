package com.icomp.wsdl.v01c01.c01s011.endpoint;

import java.util.List;

import com.icomp.common.pojo.BaseRespons;
/**
 * 设备安上-返回参数
 * @ClassName: C01S011Respons 
 * @author 
 * @date 
 */
public class C01S011Respons extends BaseRespons {

	private static final long serialVersionUID = 3273451186566190630L;
	
	/* 合成刀具ID */
	private String synthesisParametersID;

	
	//合成刀具编码
	private String synthesisParametersCode;

	//设备列表
	private List<EquipmentEntity> equipments;
	
	/* 合成刀具ID */
	
	public String getSynthesisParametersID() {
		return synthesisParametersID;
	}
	public void setSynthesisParametersID(String synthesisParametersID) {
		this.synthesisParametersID = synthesisParametersID;
	}
	
	//合成刀具编码
	
	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}
	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}
	//设备列表
	public List<EquipmentEntity> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<EquipmentEntity> equipments) {
		this.equipments = equipments;
	}


	
	
	
	
	
	
	
	
	



















	//待安装设备
	private List<Equipments> equipmentList;
	//对刀参数X
	private double xpoint;
	//对刀参数Y
	private double ypoint;

	private String equipmentName;
	private String equipmentID;
	private String synthesisParametersNumber;
	public String getSynthesisParametersNumber() {
		return synthesisParametersNumber;
	}
	public void setSynthesisParametersNumber(String synthesisParametersNumber) {
		this.synthesisParametersNumber = synthesisParametersNumber;
	}
	private String equipmentId;
	public String getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	

	public List<Equipments> getEquipmentList() {
		return equipmentList;
	}
	public void setEquipmentList(List<Equipments> equipmentList) {
		this.equipmentList = equipmentList;
	}
	public double getXpoint() {
		return xpoint;
	}
	public void setXpoint(double xpoint) {
		this.xpoint = xpoint;
	}
	public double getYpoint() {
		return ypoint;
	}
	public void setYpoint(double ypoint) {
		this.ypoint = ypoint;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getEquipmentID() {
		return equipmentID;
	}
	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}

	
}
