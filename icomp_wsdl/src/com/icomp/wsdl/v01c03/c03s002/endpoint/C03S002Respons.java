package com.icomp.wsdl.v01c03.c03s002.endpoint;

import java.util.List;

import com.icomp.common.pojo.BaseRespons;

public class C03S002Respons extends BaseRespons{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1144200545371114905L;


	//所有流水线和设备
	private List<EquipmentEntity> equipmentList ;

	public List<EquipmentEntity> getEquipmentList() {
		return equipmentList;
	}

	public void setEquipmentList(List<EquipmentEntity> equipmentList) {
		this.equipmentList = equipmentList;
	}

	//修魔设备列表
	private List<Equipments> nocequipmentList ;

	public List<Equipments> getNocequipmentList() {
		return nocequipmentList;
	}

	public void setNocequipmentList(List<Equipments> nocequipmentList) {
		this.nocequipmentList = nocequipmentList;
	}

	/* 合成刀具编码列表 */
	private List<String> synthesisCodeList;

	public List<String> getSynthesisCodeList() {
		return synthesisCodeList;
	}

	public void setSynthesisCodeList(List<String> synthesisCodeList) {
		this.synthesisCodeList = synthesisCodeList;
	} 
	/* 合成刀具配置列表 */
	private List<ToolParameters> toolParametersList;

	public List<ToolParameters> getToolParametersList() {
		return toolParametersList;
	}

	public void setToolParametersList(List<ToolParameters> toolParametersList) {
		this.toolParametersList = toolParametersList;
	}























}
