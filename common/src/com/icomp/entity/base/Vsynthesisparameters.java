/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:05
 * 创建者  ：杨作庆
 * 
 */
public class Vsynthesisparameters extends VsynthesisparametersWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 合成刀具参数ID	*/ 
	private String synthesisParametersID;

	/**
	 * 合成刀具参数ID取得
	 * @return synthesisParametersID
	 */
	public String getSynthesisParametersID() {
		return synthesisParametersID;
	}

	/**
	 * 合成刀具参数ID设定
	 * @param synthesisParametersID
	 */
	public void setSynthesisParametersID(String synthesisParametersID) {
		this.synthesisParametersID = synthesisParametersID;
	}

	/* 合成刀具编码(系统唯一)	*/ 
	private String synthesisParametersCode;

	/**
	 * 合成刀具编码(系统唯一)取得
	 * @return synthesisParametersCode
	 */
	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	/**
	 * 合成刀具编码(系统唯一)设定
	 * @param synthesisParametersCode
	 */
	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}

	/* 位置数	*/ 
	private BigDecimal synthesisCount;

	/**
	 * 位置数取得
	 * @return synthesisCount
	 */
	public BigDecimal getSynthesisCount() {
		return synthesisCount;
	}

	/**
	 * 位置数设定
	 * @param synthesisCount
	 */
	public void setSynthesisCount(BigDecimal synthesisCount) {
		this.synthesisCount = synthesisCount;
	}

	/* 位置号	*/ 
	private BigDecimal synthesisCutterNumber;

	/**
	 * 位置号取得
	 * @return synthesisCutterNumber
	 */
	public BigDecimal getSynthesisCutterNumber() {
		return synthesisCutterNumber;
	}

	/**
	 * 位置号设定
	 * @param synthesisCutterNumber
	 */
	public void setSynthesisCutterNumber(BigDecimal synthesisCutterNumber) {
		this.synthesisCutterNumber = synthesisCutterNumber;
	}

	/* 刀具编码(应该装入合成刀的编码)	*/ 
	private String toolCode;

	/**
	 * 刀具编码(应该装入合成刀的编码)取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 刀具编码(应该装入合成刀的编码)设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 替换刀具编码（刀具编码以逗号分隔）	*/ 
	private String tempToolCode;

	/**
	 * 替换刀具编码（刀具编码以逗号分隔）取得
	 * @return tempToolCode
	 */
	public String getTempToolCode() {
		return tempToolCode;
	}

	/**
	 * 替换刀具编码（刀具编码以逗号分隔）设定
	 * @param tempToolCode
	 */
	public void setTempToolCode(String tempToolCode) {
		this.tempToolCode = tempToolCode;
	}

	/* 刀具图纸	*/ 
	private String toolPic;

	/**
	 * 刀具图纸取得
	 * @return toolPic
	 */
	public String getToolPic() {
		return toolPic;
	}

	/**
	 * 刀具图纸设定
	 * @param toolPic
	 */
	public void setToolPic(String toolPic) {
		this.toolPic = toolPic;
	}
	
	/* 设备ID	*/ 
	private String equipmentID;

	/**
	 * 设备ID取得
	 * @return equipmentID
	 */
	public String getEquipmentID() {
		return equipmentID;
	}

	/**
	 * 设备ID设定
	 * @param equipmentID
	 */
	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}
	/* 设备名称	*/ 
	private String equipmentName;

	/**
	 * 设备名称取得
	 * @return equipmentName
	 */
	public String getEquipmentName() {
		return equipmentName;
	}

	/**
	 * 设备名称设定
	 * @param equipmentName
	 */
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
}

