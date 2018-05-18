/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class Vgetbackworkshopmag extends VgetbackworkshopmagWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* RFID(辅具或配套上打孔安装的RFID)	*/ 
	private String rfid;

	/**
	 * RFID(辅具或配套上打孔安装的RFID)取得
	 * @return rfid
	 */
	public String getRfid() {
		return rfid;
	}

	/**
	 * RFID(辅具或配套上打孔安装的RFID)设定
	 * @param rfid
	 */
	public void setRfid(String rfid) {
		this.rfid = rfid;
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

	/* 工序ID	*/ 
	private String processID;

	/**
	 * 工序ID取得
	 * @return processID
	 */
	public String getProcessID() {
		return processID;
	}

	/**
	 * 工序ID设定
	 * @param processID
	 */
	public void setProcessID(String processID) {
		this.processID = processID;
	}

	/* 工序编码	*/ 
	private String processCode;

	/**
	 * 工序编码取得
	 * @return processCode
	 */
	public String getProcessCode() {
		return processCode;
	}

	/**
	 * 工序编码设定
	 * @param processCode
	 */
	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

	/* 工序名称	*/ 
	private String processName;

	/**
	 * 工序名称取得
	 * @return processName
	 */
	public String getProcessName() {
		return processName;
	}

	/**
	 * 工序名称设定
	 * @param processName
	 */
	public void setProcessName(String processName) {
		this.processName = processName;
	}

	/* 语言编码	*/ 
	private String processLanguageCode;

	/**
	 * 语言编码取得
	 * @return processLanguageCode
	 */
	public String getProcessLanguageCode() {
		return processLanguageCode;
	}

	/**
	 * 语言编码设定
	 * @param processLanguageCode
	 */
	public void setProcessLanguageCode(String processLanguageCode) {
		this.processLanguageCode = processLanguageCode;
	}

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

	/* 	*/ 
	private String knifeManName;

	/**
	 * 取得
	 * @return knifeManName
	 */
	public String getKnifeManName() {
		return knifeManName;
	}

	/**
	 * 设定
	 * @param knifeManName
	 */
	public void setKnifeManName(String knifeManName) {
		this.knifeManName = knifeManName;
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
}

