package com.icomp.wsdl.v01c01.c01s013.endpoint;

import com.icomp.common.pojo.BaseRespons;
import com.icomp.entity.base.Vgetequipmentunloadingmsg;
import com.icomp.entity.base.Vgetwheelinfo;

import java.util.List;

/**
 * 设备卸下-返回参数
 * 
 * @ClassName: C01S013Respons
 * @author Taoyy
 * @date 2014-9-22 下午6:38:15
 */
public class C01S013Respons extends BaseRespons {
	private static final long serialVersionUID = 1992915594816381379L;
	// 对应工序ID
	private String processID;
	// 对应工序编码
	private String processCode;
	// 设备名称
	private String equipmentName;
	// 设备ID
	private String equipmentID;
	// 轴号名称
	private String axleName;
	//2017/10/23 王冉 追加↓↓↓　dazhong@YMSC
	private String partsID;
	//2017/10/23 王冉 追加↑↑↑　dazhong@YMSC

	public String getAxleName() {
		return axleName;
	}

	public void setAxleName(String axleName) {
		this.axleName = axleName;
	}

	public String getAxleID() {
		return axleID;
	}

	public void setAxleID(String axleID) {
		this.axleID = axleID;
	}

	public String getProcessID() {
		return processID;
	}

	public void setProcessID(String processID) {
		this.processID = processID;
	}

	public String getProcessCode() {
		return processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
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


	public List<PartsEntity> getPartsList() {
		return partsList;
	}

	public void setPartsList(List<PartsEntity> partsList) {
		this.partsList = partsList;
	}

	public String getSynthesisParametersID() {
		return synthesisParametersID;
	}

	public void setSynthesisParametersID(String synthesisParametersID) {
		this.synthesisParametersID = synthesisParametersID;
	}

	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}

	// 轴号ID
	private String axleID;
	// 零部件列表
	private List<PartsEntity> partsList;
	// 合成刀具ID
	private String synthesisParametersID;
	// 合成刀具编码
	private String synthesisParametersCode;
	
	
	// 流水线id
	private String assemblyLineID;
	// 流水线名称
	private String assemblyLineName;
	// 载体id
	private String rfidContainerId;
	//2017/11/14 王冉 变更↓↓↓　dazhong@YMSC
	// 合成刀具编码列表
	private List<Vgetwheelinfo> synthesisParametersCodeList;
	//2017/11/14 王冉 变更↑↑↑　dazhong@YMSC

	public String getAssemblyLineID() {
		return assemblyLineID;
	}

	public void setAssemblyLineID(String assemblyLineID) {
		this.assemblyLineID = assemblyLineID;
	}

	public String getAssemblyLineName() {
		return assemblyLineName;
	}

	public void setAssemblyLineName(String assemblyLineName) {
		this.assemblyLineName = assemblyLineName;
	}

	public String getRfidContainerId() {
		return rfidContainerId;
	}

	public void setRfidContainerId(String rfidContainerId) {
		this.rfidContainerId = rfidContainerId;
	}

	//2017/11/14 王冉 变更↓↓↓　dazhong@YMSC
	public List<Vgetwheelinfo> getSynthesisParametersCodeList() {
		return synthesisParametersCodeList;
	}

	public void setSynthesisParametersCodeList(
			List<Vgetwheelinfo> synthesisParametersCodeList) {
		this.synthesisParametersCodeList = synthesisParametersCodeList;
	}
	//2017/11/14 王冉 变更↑↑↑　dazhong@YMSC

	/*********************************************************************************/
	/**
	 * 取得设备卸下信息list
	 */
	private List<Vgetequipmentunloadingmsg> vgetequipmentunloadingmsgs;

	public List<Vgetequipmentunloadingmsg> getVgetequipmentunloadingmsgs() {
		return vgetequipmentunloadingmsgs;
	}

	public void setVgetequipmentunloadingmsgs(
			List<Vgetequipmentunloadingmsg> vgetequipmentunloadingmsgs) {
		this.vgetequipmentunloadingmsgs = vgetequipmentunloadingmsgs;
	}

	//2017/10/23 王冉 追加↓↓↓　dazhong@YMSC
	public String getPartsID() {
		return partsID;
	}

	public void setPartsID(String partsID) {
		this.partsID = partsID;
	}
	// 合成刀具编码列表
	private List<String> processAmountList;

	public List<String> getProcessAmountList() {
		return processAmountList;
	}

	public void setProcessAmountList(List<String> processAmountList) {
		this.processAmountList = processAmountList;
	}

	//2017/10/23 王冉 追加↑↑↑　dazhong@YMSC
}
