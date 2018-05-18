package com.icomp.entity.base;

public class EntityProcurementplansWhere extends Procurementplans {

	/** 
	 * @Fields serialVersionUID :
	 */ 
	private static final long serialVersionUID = 1L;
	/**
	 * 刀具编码
	 */
	private String toolCode;
	/**
	 * 刀具名称
	 */
	private String toolName;
	/**
	 * 刀具定额量
	 */
	private String quotaProcessingVolume;
	/**
	 * 刀具编码
	 * @title getToolCode 
	 * @return
	 * String
	 */
	public String getToolCode() {
		return toolCode;
	}
	/**
	 * 刀具编码
	 * @title setToolCode 
	 * @param toolCode
	 * void
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	/**
	 * 刀具名称
	 * @title getToolName 
	 * @return
	 * String
	 */
	public String getToolName() {
		return toolName;
	}
	/**
	 * 刀具名称
	 * @title setToolName 
	 * @param toolName
	 * void
	 */
	public void setToolName(String toolName) {
		this.toolName = toolName;
	}
	/**
	 * 刀具定额量
	 * @title getQuotaProcessingVolume 
	 * @return
	 * String
	 */
	public String getQuotaProcessingVolume() {
		return quotaProcessingVolume;
	}
	/**
	 * 刀具定额量
	 * @title setQuotaProcessingVolume 
	 * @param quotaProcessingVolume
	 * void
	 */
	public void setQuotaProcessingVolume(String quotaProcessingVolume) {
		this.quotaProcessingVolume = quotaProcessingVolume;
	}
	
	
	
	
}
