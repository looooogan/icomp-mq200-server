/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/10/22 19:25:59
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;

import com.icomp.common.entity.BaseEntity;

/**
 * VIEW条件实体类
 * 
 * @author 工具自动生成 创建时间：2014/10/22 19:25:59 创建者 ：杨作庆
 * 
 */
public class VsynthesisWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 定额加工量 */
	private BigDecimal quotaProcessingVolumeWhere;

	/**
	 * 定额加工量取得
	 * 
	 * @return quotaProcessingVolumeWhere
	 */
	public BigDecimal getQuotaProcessingVolumeWhere() {
		return quotaProcessingVolumeWhere;
	}

	/**
	 * 定额加工量设定
	 * 
	 * @param quotaProcessingVolumeWhere
	 */
	public void setQuotaProcessingVolumeWhere(
			BigDecimal quotaProcessingVolumeWhere) {
		this.quotaProcessingVolumeWhere = quotaProcessingVolumeWhere;
	}

	/* 合成刀具编码(系统唯一) */
	private String synthesisParametersCodeWhere;

	/**
	 * 合成刀具编码(系统唯一)取得
	 * 
	 * @return synthesisParametersCodeWhere
	 */
	public String getSynthesisParametersCodeWhere() {
		return synthesisParametersCodeWhere;
	}

	/**
	 * 合成刀具编码(系统唯一)设定
	 * 
	 * @param synthesisParametersCodeWhere
	 */
	public void setSynthesisParametersCodeWhere(
			String synthesisParametersCodeWhere) {
		this.synthesisParametersCodeWhere = synthesisParametersCodeWhere;
	}

	/* X坐标 */
	private BigDecimal xPointWhere;

	/* Y坐标 */
	private BigDecimal yPointWhere;

	/* RFID(辅具或配套上打孔安装的RFID) */
	private String rFIDWhere;

	public BigDecimal getxPointWhere() {
		return xPointWhere;
	}

	public void setxPointWhere(BigDecimal xPointWhere) {
		this.xPointWhere = xPointWhere;
	}

	public BigDecimal getyPointWhere() {
		return yPointWhere;
	}

	public void setyPointWhere(BigDecimal yPointWhere) {
		this.yPointWhere = yPointWhere;
	}

	/**
	 * RFID(辅具或配套上打孔安装的RFID)取得
	 * 
	 * @return rFIDWhere
	 */
	public String getrFIDWhere() {
		return rFIDWhere;
	}

	/**
	 * RFID(辅具或配套上打孔安装的RFID)设定
	 * 
	 * @param rFIDWhere
	 */
	public void setrFIDWhere(String rFIDWhere) {
		this.rFIDWhere = rFIDWhere;
	}
}
