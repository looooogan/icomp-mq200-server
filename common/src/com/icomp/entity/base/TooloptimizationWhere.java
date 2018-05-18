/*
 * 工具自动生成：刀具优化条件实体类
 * 生成时间    : 2016/04/12 15:51:11
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;

import java.math.BigDecimal;


/**
 * 刀具优化条件实体类
 * @author 工具自动生成
 * 创建时间：2016/04/12 15:51:11
 * 创建者  ：工具自动生成
 * 
 */
public class TooloptimizationWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 优化ID	*/ 
	private String optimizationIDWhere;

	/**
	 * 优化ID取得
	 * @return optimizationIDWhere
	 */
	public String getOptimizationIDWhere () {
		return optimizationIDWhere;
	}

	/**
	 * 优化ID设定
	 * @param optimizationIDWhere
	 */
	public void setOptimizationIDWhere (String optimizationIDWhere) {
		this.optimizationIDWhere = optimizationIDWhere;
	}

	/* 刀具ID	*/ 
	private String toolIDWhere;

	/**
	 * 刀具ID取得
	 * @return toolIDWhere
	 */
	public String getToolIDWhere () {
		return toolIDWhere;
	}

	/**
	 * 刀具ID设定
	 * @param toolIDWhere
	 */
	public void setToolIDWhere (String toolIDWhere) {
		this.toolIDWhere = toolIDWhere;
	}

	/* 材料号	*/ 
	private String toolCodeWhere;

	/**
	 * 材料号取得
	 * @return toolCodeWhere
	 */
	public String getToolCodeWhere () {
		return toolCodeWhere;
	}

	/**
	 * 材料号设定
	 * @param toolCodeWhere
	 */
	public void setToolCodeWhere (String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}

	/* 优化次数	*/ 
	private BigDecimal optimizationNumWhere;

	/**
	 * 优化次数取得
	 * @return optimizationNumWhere
	 */
	public BigDecimal getOptimizationNumWhere () {
		return optimizationNumWhere;
	}

	/**
	 * 优化次数设定
	 * @param optimizationNumWhere
	 */
	public void setOptimizationNumWhere (BigDecimal optimizationNumWhere) {
		this.optimizationNumWhere = optimizationNumWhere;
	}

	/* 申请表文件名称	*/ 
	private String applicationFileNameWhere;

	/**
	 * 申请表文件名称取得
	 * @return applicationFileNameWhere
	 */
	public String getApplicationFileNameWhere () {
		return applicationFileNameWhere;
	}

	/**
	 * 申请表文件名称设定
	 * @param applicationFileNameWhere
	 */
	public void setApplicationFileNameWhere (String applicationFileNameWhere) {
		this.applicationFileNameWhere = applicationFileNameWhere;
	}

	/* 申请表文件路径	*/ 
	private String applicationFileSrcWhere;

	/**
	 * 申请表文件路径取得
	 * @return applicationFileSrcWhere
	 */
	public String getApplicationFileSrcWhere () {
		return applicationFileSrcWhere;
	}

	/**
	 * 申请表文件路径设定
	 * @param applicationFileSrcWhere
	 */
	public void setApplicationFileSrcWhere (String applicationFileSrcWhere) {
		this.applicationFileSrcWhere = applicationFileSrcWhere;
	}

	/* 技术方案文件名称	*/ 
	private String technicalFileNameWhere;

	/**
	 * 技术方案文件名称取得
	 * @return technicalFileNameWhere
	 */
	public String getTechnicalFileNameWhere () {
		return technicalFileNameWhere;
	}

	/**
	 * 技术方案文件名称设定
	 * @param technicalFileNameWhere
	 */
	public void setTechnicalFileNameWhere (String technicalFileNameWhere) {
		this.technicalFileNameWhere = technicalFileNameWhere;
	}

	/* 技术方案文件路径	*/ 
	private String technicalFileSrcWhere;

	/**
	 * 技术方案文件路径取得
	 * @return technicalFileSrcWhere
	 */
	public String getTechnicalFileSrcWhere () {
		return technicalFileSrcWhere;
	}

	/**
	 * 技术方案文件路径设定
	 * @param technicalFileSrcWhere
	 */
	public void setTechnicalFileSrcWhere (String technicalFileSrcWhere) {
		this.technicalFileSrcWhere = technicalFileSrcWhere;
	}

	/* 实验通知单文件名称	*/ 
	private String experimentalFileNameWhere;

	/**
	 * 实验通知单文件名称取得
	 * @return experimentalFileNameWhere
	 */
	public String getExperimentalFileNameWhere () {
		return experimentalFileNameWhere;
	}

	/**
	 * 实验通知单文件名称设定
	 * @param experimentalFileNameWhere
	 */
	public void setExperimentalFileNameWhere (String experimentalFileNameWhere) {
		this.experimentalFileNameWhere = experimentalFileNameWhere;
	}

	/* 实验通知单文件路径	*/ 
	private String experimentalFileSrcWhere;

	/**
	 * 实验通知单文件路径取得
	 * @return experimentalFileSrcWhere
	 */
	public String getExperimentalFileSrcWhere () {
		return experimentalFileSrcWhere;
	}

	/**
	 * 实验通知单文件路径设定
	 * @param experimentalFileSrcWhere
	 */
	public void setExperimentalFileSrcWhere (String experimentalFileSrcWhere) {
		this.experimentalFileSrcWhere = experimentalFileSrcWhere;
	}

	/* 实验报告文件名称	*/ 
	private String reportFileNameWhere;

	/**
	 * 实验报告文件名称取得
	 * @return reportFileNameWhere
	 */
	public String getReportFileNameWhere () {
		return reportFileNameWhere;
	}

	/**
	 * 实验报告文件名称设定
	 * @param reportFileNameWhere
	 */
	public void setReportFileNameWhere (String reportFileNameWhere) {
		this.reportFileNameWhere = reportFileNameWhere;
	}

	/* 实验报告文件路径	*/ 
	private String reportFileSrcWhere;

	/**
	 * 实验报告文件路径取得
	 * @return reportFileSrcWhere
	 */
	public String getReportFileSrcWhere () {
		return reportFileSrcWhere;
	}

	/**
	 * 实验报告文件路径设定
	 * @param reportFileSrcWhere
	 */
	public void setReportFileSrcWhere (String reportFileSrcWhere) {
		this.reportFileSrcWhere = reportFileSrcWhere;
	}

	/* 备注	*/ 
	private String noteFileWhere;

	/**
	 * 备注取得
	 * @return noteFileWhere
	 */
	public String getNoteFileWhere () {
		return noteFileWhere;
	}

	/**
	 * 备注设定
	 * @param noteFileWhere
	 */
	public void setNoteFileWhere (String noteFileWhere) {
		this.noteFileWhere = noteFileWhere;
	}
}

