/*
 * 工具自动生成：刀具优化实体类
 * 生成时间    : 2016/04/12 15:51:11
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 刀具优化实体类
 * @author 工具自动生成
 * 创建时间：2016/04/12 15:51:11
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Tooloptimization extends TooloptimizationWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 优化ID	*/ 
	private String optimizationID;

	/**
	 * 优化ID取得
	 * @return optimizationID
	 */
	public String getOptimizationID() {
		return optimizationID;
	}

	/**
	 * 优化ID设定
	 * @param optimizationID
	 */
	public void setOptimizationID(String optimizationID) {
		this.optimizationID = optimizationID;
	}

	/* 刀具ID	*/ 
	private String toolID;

	/**
	 * 刀具ID取得
	 * @return toolID
	 */
	public String getToolID() {
		return toolID;
	}

	/**
	 * 刀具ID设定
	 * @param toolID
	 */
	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	/* 材料号	*/ 
	private String toolCode;

	/**
	 * 材料号取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 材料号设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 优化次数	*/ 
	private BigDecimal optimizationNum;

	/**
	 * 优化次数取得
	 * @return optimizationNum
	 */
	public BigDecimal getOptimizationNum() {
		return optimizationNum;
	}

	/**
	 * 优化次数设定
	 * @param optimizationNum
	 */
	public void setOptimizationNum(BigDecimal optimizationNum) {
		this.optimizationNum = optimizationNum;
	}

	/* 申请表文件名称	*/ 
	private String applicationFileName;

	/**
	 * 申请表文件名称取得
	 * @return applicationFileName
	 */
	public String getApplicationFileName() {
		return applicationFileName;
	}

	/**
	 * 申请表文件名称设定
	 * @param applicationFileName
	 */
	public void setApplicationFileName(String applicationFileName) {
		this.applicationFileName = applicationFileName;
	}

	/* 申请表文件路径	*/ 
	private String applicationFileSrc;

	/**
	 * 申请表文件路径取得
	 * @return applicationFileSrc
	 */
	public String getApplicationFileSrc() {
		return applicationFileSrc;
	}

	/**
	 * 申请表文件路径设定
	 * @param applicationFileSrc
	 */
	public void setApplicationFileSrc(String applicationFileSrc) {
		this.applicationFileSrc = applicationFileSrc;
	}

	/* 技术方案文件名称	*/ 
	private String technicalFileName;

	/**
	 * 技术方案文件名称取得
	 * @return technicalFileName
	 */
	public String getTechnicalFileName() {
		return technicalFileName;
	}

	/**
	 * 技术方案文件名称设定
	 * @param technicalFileName
	 */
	public void setTechnicalFileName(String technicalFileName) {
		this.technicalFileName = technicalFileName;
	}

	/* 技术方案文件路径	*/ 
	private String technicalFileSrc;

	/**
	 * 技术方案文件路径取得
	 * @return technicalFileSrc
	 */
	public String getTechnicalFileSrc() {
		return technicalFileSrc;
	}

	/**
	 * 技术方案文件路径设定
	 * @param technicalFileSrc
	 */
	public void setTechnicalFileSrc(String technicalFileSrc) {
		this.technicalFileSrc = technicalFileSrc;
	}

	/* 实验通知单文件名称	*/ 
	private String experimentalFileName;

	/**
	 * 实验通知单文件名称取得
	 * @return experimentalFileName
	 */
	public String getExperimentalFileName() {
		return experimentalFileName;
	}

	/**
	 * 实验通知单文件名称设定
	 * @param experimentalFileName
	 */
	public void setExperimentalFileName(String experimentalFileName) {
		this.experimentalFileName = experimentalFileName;
	}

	/* 实验通知单文件路径	*/ 
	private String experimentalFileSrc;

	/**
	 * 实验通知单文件路径取得
	 * @return experimentalFileSrc
	 */
	public String getExperimentalFileSrc() {
		return experimentalFileSrc;
	}

	/**
	 * 实验通知单文件路径设定
	 * @param experimentalFileSrc
	 */
	public void setExperimentalFileSrc(String experimentalFileSrc) {
		this.experimentalFileSrc = experimentalFileSrc;
	}

	/* 实验报告文件名称	*/ 
	private String reportFileName;

	/**
	 * 实验报告文件名称取得
	 * @return reportFileName
	 */
	public String getReportFileName() {
		return reportFileName;
	}

	/**
	 * 实验报告文件名称设定
	 * @param reportFileName
	 */
	public void setReportFileName(String reportFileName) {
		this.reportFileName = reportFileName;
	}

	/* 实验报告文件路径	*/ 
	private String reportFileSrc;

	/**
	 * 实验报告文件路径取得
	 * @return reportFileSrc
	 */
	public String getReportFileSrc() {
		return reportFileSrc;
	}

	/**
	 * 实验报告文件路径设定
	 * @param reportFileSrc
	 */
	public void setReportFileSrc(String reportFileSrc) {
		this.reportFileSrc = reportFileSrc;
	}

	/* 备注	*/ 
	private String noteFile;

	/**
	 * 备注取得
	 * @return noteFile
	 */
	public String getNoteFile() {
		return noteFile;
	}

	/**
	 * 备注设定
	 * @param noteFile
	 */
	public void setNoteFile(String noteFile) {
		this.noteFile = noteFile;
	}
}

