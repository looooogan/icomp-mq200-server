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
public class Vsynthesis extends VsynthesisWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 定额加工量	*/ 
	private BigDecimal quotaProcessingVolume;

	/**
	 * 定额加工量取得
	 * @return quotaProcessingVolume
	 */
	public BigDecimal getQuotaProcessingVolume() {
		return quotaProcessingVolume;
	}

	/**
	 * 定额加工量设定
	 * @param quotaProcessingVolume
	 */
	public void setQuotaProcessingVolume(BigDecimal quotaProcessingVolume) {
		this.quotaProcessingVolume = quotaProcessingVolume;
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

	public String getrFID() {
		return rFID;
	}

	public void setrFID(String rFID) {
		this.rFID = rFID;
	}

	/* Y坐标	*/ 
	private BigDecimal yPoint;

	
	/* RFID(辅具或配套上打孔安装的RFID)	*/ 
	private String rFID;
}

