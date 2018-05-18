/*
 * 工具自动生成：合成刀库条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * 合成刀库条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class SynthesisknifeWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 合成刀具编码(系统唯一)	*/ 
	private String synthesisParametersCodeWhere;

	/**
	 * 合成刀具编码(系统唯一)取得
	 * @return synthesisParametersCodeWhere
	 */
	public String getSynthesisParametersCodeWhere () {
		return synthesisParametersCodeWhere;
	}

	/**
	 * 合成刀具编码(系统唯一)设定
	 * @param synthesisParametersCodeWhere
	 */
	public void setSynthesisParametersCodeWhere (String synthesisParametersCodeWhere) {
		this.synthesisParametersCodeWhere = synthesisParametersCodeWhere;
	}

	/* 位置号	*/ 
	private BigDecimal synthesisCutterNumberWhere;

	/**
	 * 位置号取得
	 * @return synthesisCutterNumberWhere
	 */
	public BigDecimal getSynthesisCutterNumberWhere () {
		return synthesisCutterNumberWhere;
	}

	/**
	 * 位置号设定
	 * @param synthesisCutterNumberWhere
	 */
	public void setSynthesisCutterNumberWhere (BigDecimal synthesisCutterNumberWhere) {
		this.synthesisCutterNumberWhere = synthesisCutterNumberWhere;
	}

	/* 合成刀具编号(例如：001、002、003)	*/ 
	private String synthesisParametersNumberWhere;

	/**
	 * 合成刀具编号(例如：001、002、003)取得
	 * @return synthesisParametersNumberWhere
	 */
	public String getSynthesisParametersNumberWhere () {
		return synthesisParametersNumberWhere;
	}

	/**
	 * 合成刀具编号(例如：001、002、003)设定
	 * @param synthesisParametersNumberWhere
	 */
	public void setSynthesisParametersNumberWhere (String synthesisParametersNumberWhere) {
		this.synthesisParametersNumberWhere = synthesisParametersNumberWhere;
	}

	/* 业务-流程中间表ID	*/ 
	private String businessFlowLnkIDWhere;

	/**
	 * 业务-流程中间表ID取得
	 * @return businessFlowLnkIDWhere
	 */
	public String getBusinessFlowLnkIDWhere () {
		return businessFlowLnkIDWhere;
	}

	/**
	 * 业务-流程中间表ID设定
	 * @param businessFlowLnkIDWhere
	 */
	public void setBusinessFlowLnkIDWhere (String businessFlowLnkIDWhere) {
		this.businessFlowLnkIDWhere = businessFlowLnkIDWhere;
	}

	/* 设备ID	*/ 
	private String equipmentIDWhere;

	/**
	 * 设备ID取得
	 * @return equipmentIDWhere
	 */
	public String getEquipmentIDWhere () {
		return equipmentIDWhere;
	}

	/**
	 * 设备ID设定
	 * @param equipmentIDWhere
	 */
	public void setEquipmentIDWhere (String equipmentIDWhere) {
		this.equipmentIDWhere = equipmentIDWhere;
	}

	/* 刀具入库编码	*/ 
	private String knifeInventoryCodeWhere;

	/**
	 * 刀具入库编码取得
	 * @return knifeInventoryCodeWhere
	 */
	public String getKnifeInventoryCodeWhere () {
		return knifeInventoryCodeWhere;
	}

	/**
	 * 刀具入库编码设定
	 * @param knifeInventoryCodeWhere
	 */
	public void setKnifeInventoryCodeWhere (String knifeInventoryCodeWhere) {
		this.knifeInventoryCodeWhere = knifeInventoryCodeWhere;
	}

	/* 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上)(该状态绑定到带标签的数据上)	*/ 
	private String loadStateWhere;

	/**
	 * 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上)(该状态绑定到带标签的数据上)取得
	 * @return loadStateWhere
	 */
	public String getLoadStateWhere () {
		return loadStateWhere;
	}

	/**
	 * 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上)(该状态绑定到带标签的数据上)设定
	 * @param loadStateWhere
	 */
	public void setLoadStateWhere (String loadStateWhere) {
		this.loadStateWhere = loadStateWhere;
	}

	/* 卸下方式(0装盒1装盘3保留)	*/ 
	private String offloadTypeWhere;

	/**
	 * 卸下方式(0装盒1装盘3保留)取得
	 * @return offloadTypeWhere
	 */
	public String getOffloadTypeWhere () {
		return offloadTypeWhere;
	}

	/**
	 * 卸下方式(0装盒1装盘3保留)设定
	 * @param offloadTypeWhere
	 */
	public void setOffloadTypeWhere (String offloadTypeWhere) {
		this.offloadTypeWhere = offloadTypeWhere;
	}

	/* 是否安装(0安装1卸下9其他)	*/ 
	private String installFlagWhere;

	/**
	 * 是否安装(0安装1卸下9其他)取得
	 * @return installFlagWhere
	 */
	public String getInstallFlagWhere () {
		return installFlagWhere;
	}

	/**
	 * 是否安装(0安装1卸下9其他)设定
	 * @param installFlagWhere
	 */
	public void setInstallFlagWhere (String installFlagWhere) {
		this.installFlagWhere = installFlagWhere;
	}

	/* RFID(辅具或配套上打孔安装的RFID)	*/ 
	private String rFIDWhere;


	/* X坐标	*/ 
	private BigDecimal xPointWhere;

	public String getrFIDWhere() {
		return rFIDWhere;
	}

	public void setrFIDWhere(String rFIDWhere) {
		this.rFIDWhere = rFIDWhere;
	}

	public BigDecimal getxPointWhere() {
		return xPointWhere;
	}

	public void setxPointWhere(BigDecimal xPointWhere) {
		this.xPointWhere = xPointWhere;
	}
	private BigDecimal yPointWhere;
	public BigDecimal getyPointWhere() {
		return yPointWhere;
	}

	public void setyPointWhere(BigDecimal yPointWhere) {
		this.yPointWhere = yPointWhere;
	}

	

	/* 对刀人	*/ 
	private String knifeManWhere;

	/**
	 * 对刀人取得
	 * @return knifeManWhere
	 */
	public String getKnifeManWhere () {
		return knifeManWhere;
	}

	/**
	 * 对刀人设定
	 * @param knifeManWhere
	 */
	public void setKnifeManWhere (String knifeManWhere) {
		this.knifeManWhere = knifeManWhere;
	}
}

