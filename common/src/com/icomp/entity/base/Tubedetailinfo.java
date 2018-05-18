/*
 * 工具自动生成：筒刀详细实体类
 * 生成时间    : 2017/7/10 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 筒刀详细实体类
 * @author 工具自动生成
 * 创建时间：2017/7/10 18:19:03
 * 创建者  ：宋健
 *
 */
public class Tubedetailinfo extends TubedetailinfoWhere implements Serializable {

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

	/* 刀具编号	*/
	private String toolCode;
	/**
	 * 刀具编号取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}
	/**
	 * 刀具编号设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 使用状态(0装入1卸下2修磨3修磨完成4报废)	*/
	private String loadState;

	/**
	 * 使用状态(0装入1卸下2修磨3修磨完成4报废)取得
	 * @return loadState
	 */
	public String getLoadState() {
		return loadState;
	}

	/**
	 * 使用状态(0装入1卸下2修磨3修磨完成4报废)设定
	 * @param loadState
	 */
	public void setLoadState(String loadState) {
		this.loadState = loadState;
	}

	/* 修磨次数	*/
	private BigDecimal grindingSum;
	/**
	 * 修磨次数取得
	 * @return grindingSum
	 */
	public BigDecimal getGrindingSum() {
		return grindingSum;
	}
	/**
	 * 修磨次数设定
	 * @param grindingSum
	 */
	public void setGrindingSum(BigDecimal grindingSum) {
		this.grindingSum = grindingSum;
	}

	/* 刀具数量	*/
	private BigDecimal toolCount;
	/**
	 * 刀具数量取得
	 * @return toolCount
	 */
	public BigDecimal getToolCount() {
		return toolCount;
	}
	/**
	 * 刀具数量设定
	 * @param toolCount
	 */
	public void setToolCount(BigDecimal toolCount) {
		this.toolCount = toolCount;
	}

	/* rfId	*/
	private String rfId;

	/**
	 * rfId取得
	 * @return rfId
	 */
	public String getRfId() {
		return rfId;
	}

	/**
	 * rfId设定
	 * @param rfId
	 */
	public void setRfId(String rfId) {
		this.rfId = rfId;
	}

	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	// 2017/09/16 宋健 追加↓↓↓　dazhong@YMSC
	private String laserIdentificationCode;

	public String getLaserIdentificationCode() {
		return laserIdentificationCode;
	}

	public void setLaserIdentificationCode(String laserIdentificationCode) {
		this.laserIdentificationCode = laserIdentificationCode;
	}

	private String splitUser;

	public String getSplitUser() {
		return splitUser;
	}

	public void setSplitUser(String splitUser) {
		this.splitUser = splitUser;
	}

	private String installUser;

	public String getInstallUser() {
		return installUser;
	}

	public void setInstallUser(String installUser) {
		this.installUser = installUser;
	}

	private String splitTime;

	public String getSplitTime() {
		return splitTime;
	}

	public void setSplitTime(String splitTime) {
		this.splitTime = splitTime;
	}

	private String splitTimeStar;

	public String getSplitTimeStar() {
		return splitTimeStar;
	}

	public void setSplitTimeStar(String splitTimeStar) {
		this.splitTimeStar = splitTimeStar;
	}

	private String splitTimeEnd;

	public String getSplitTimeEnd() {
		return splitTimeEnd;
	}

	public void setSplitTimeEnd(String splitTimeEnd) {
		this.splitTimeEnd = splitTimeEnd;
	}

	private String installTime;

	public String getInstallTime() {
		return installTime;
	}

	public void setInstallTime(String installTime) {
		this.installTime = installTime;
	}

	private String installTimeStar;

	public String getInstallTimeStar() {
		return installTimeStar;
	}

	public void setInstallTimeStar(String installTimeStar) {
		this.installTimeStar = installTimeStar;
	}

	private String installTimeEnd;

	public String getInstallTimeEnd() {
		return installTimeEnd;
	}

	public void setInstallTimeEnd(String installTimeEnd) {
		this.installTimeEnd = installTimeEnd;
	}

	private String thickness;

	public String getThickness() {
		return thickness;
	}

	public void setThickness(String thickness) {
		this.thickness = thickness;
	}

	private String angle;

	public String getAngle() {
		return angle;
	}

	public void setAngle(String angle) {
		this.angle = angle;
	}

	private String hxSum;

	public String getHxSum() {
		return hxSum;
	}

	public void setHxSum(String hxSum) {
		this.hxSum = hxSum;
	}

	private String hxCount;

	public String getHxCount() {
		return hxCount;
	}

	public void setHxCount(String hxCount) {
		this.hxCount = hxCount;
	}

	// 2017/09/16 宋健 追加↑↑↑　dazhong@YMSC
}