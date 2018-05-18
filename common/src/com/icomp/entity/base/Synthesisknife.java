/*
 * 工具自动生成：合成刀库实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 合成刀库实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 *
 */
public class Synthesisknife extends SynthesisknifeWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 合成刀具编号(例如：001、002、003)	*/
	private String synthesisParametersNumber;

	/**
	 * 合成刀具编号(例如：001、002、003)取得
	 * @return synthesisParametersNumber
	 */
	public String getSynthesisParametersNumber() {
		return synthesisParametersNumber;
	}

	/**
	 * 合成刀具编号(例如：001、002、003)设定
	 * @param synthesisParametersNumber
	 */
	public void setSynthesisParametersNumber(String synthesisParametersNumber) {
		this.synthesisParametersNumber = synthesisParametersNumber;
	}

	/* 业务-流程中间表ID	*/
	private String businessFlowLnkID;

	/**
	 * 业务-流程中间表ID取得
	 * @return businessFlowLnkID
	 */
	public String getBusinessFlowLnkID() {
		return businessFlowLnkID;
	}

	/**
	 * 业务-流程中间表ID设定
	 * @param businessFlowLnkID
	 */
	public void setBusinessFlowLnkID(String businessFlowLnkID) {
		this.businessFlowLnkID = businessFlowLnkID;
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

	/* 刀具入库编码	*/
	private String knifeInventoryCode;

	/**
	 * 刀具入库编码取得
	 * @return knifeInventoryCode
	 */
	public String getKnifeInventoryCode() {
		return knifeInventoryCode;
	}

	/**
	 * 刀具入库编码设定
	 * @param knifeInventoryCode
	 */
	public void setKnifeInventoryCode(String knifeInventoryCode) {
		this.knifeInventoryCode = knifeInventoryCode;
	}

	/* 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上)(该状态绑定到带标签的数据上)	*/
	private String loadState;

	/**
	 * 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上)(该状态绑定到带标签的数据上)取得
	 * @return loadState
	 */
	public String getLoadState() {
		return loadState;
	}

	/**
	 * 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上)(该状态绑定到带标签的数据上)设定
	 * @param loadState
	 */
	public void setLoadState(String loadState) {
		this.loadState = loadState;
	}

	/* 卸下方式(0装盒1装盘3保留)	*/
	private String offloadType;

	/**
	 * 卸下方式(0装盒1装盘3保留)取得
	 * @return offloadType
	 */
	public String getOffloadType() {
		return offloadType;
	}

	/**
	 * 卸下方式(0装盒1装盘3保留)设定
	 * @param offloadType
	 */
	public void setOffloadType(String offloadType) {
		this.offloadType = offloadType;
	}

	/* 是否安装(0安装1卸下9其他)	*/
	private String installFlag;

	/**
	 * 是否安装(0安装1卸下9其他)取得
	 * @return installFlag
	 */
	public String getInstallFlag() {
		return installFlag;
	}

	/**
	 * 是否安装(0安装1卸下9其他)设定
	 * @param installFlag
	 */
	public void setInstallFlag(String installFlag) {
		this.installFlag = installFlag;
	}

	/* RFID(辅具或配套上打孔安装的RFID)	*/
	private String rFID;

	/**
	 * RFID(辅具或配套上打孔安装的RFID)取得
	 * @return rFID
	 */
	public String getrFID() {
		return rFID;
	}

	/**
	 * RFID(辅具或配套上打孔安装的RFID)设定
	 * @param rFID
	 */
	public void setrFID(String rFID) {
		this.rFID = rFID;
	}

	/* X坐标	*/
	private BigDecimal xPoint;

	public BigDecimal getxPoint() {
		return xPoint;
	}

	public void setxPoint(BigDecimal xPoint) {
		this.xPoint = xPoint;
	}

	public BigDecimal getyPoint() {
		return yPoint;
	}

	public void setyPoint(BigDecimal yPoint) {
		this.yPoint = yPoint;
	}

	/* Y坐标	*/
	private BigDecimal yPoint;

	/* 对刀人	*/
	private String knifeMan;

	/**
	 * 对刀人取得
	 * @return knifeMan
	 */
	public String getKnifeMan() {
		return knifeMan;
	}

	/**
	 * 对刀人设定
	 * @param knifeMan
	 */
	public void setKnifeMan(String knifeMan) {
		this.knifeMan = knifeMan;
	}

	// 2017/08/30 宋健 追加↓↓↓　dazhong@YMSC
	private String bdSum;

	public String getBdSum() {
		return bdSum;
	}

	public void setBdSum(String bdSum) {
		this.bdSum = bdSum;
	}

	private String asSum;

	public String getAsSum() {
		return asSum;
	}

	public void setAsSum(String asSum) {
		this.asSum = asSum;
	}

	private String dzzSum;

	public String getDzzSum() {
		return dzzSum;
	}

	public void setDzzSum(String dzzSum) {
		this.dzzSum = dzzSum;
	}

	private String totalSum;

	public String getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(String totalSum) {
		this.totalSum = totalSum;
	}
	// 2017/08/30 宋健 追加↑↑↑　dazhong@YMSC

	// 2017/09/12 宋健 追加↓↓↓　dazhong@YMSC
	private String createType;

	public String getCreateType() {
		return createType;
	}

	public void setCreateType(String createType) {
		this.createType = createType;
	}
	// 2017/09/12 宋健 追加↑↑↑　dazhong@YMSC
}

