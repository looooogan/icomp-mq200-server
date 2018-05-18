/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/03/10 09:33:30
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;

import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/03/10 09:33:30
 * 创建者  ：工具自动生成
 * 
 */
public class VtoolWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 	*/ 
	private String toolCodeWhere;

	/**
	 * 取得
	 * @return toolCodeWhere
	 */
	public String getToolCodeWhere () {
		return toolCodeWhere;
	}

	/**
	 * 设定
	 * @param toolCodeWhere
	 */
	public void setToolCodeWhere (String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}

	/* 刀具名称	*/ 
	private String toolNameWhere;

	/**
	 * 刀具名称取得
	 * @return toolNameWhere
	 */
	public String getToolNameWhere () {
		return toolNameWhere;
	}

	/**
	 * 刀具名称设定
	 * @param toolNameWhere
	 */
	public void setToolNameWhere (String toolNameWhere) {
		this.toolNameWhere = toolNameWhere;
	}

	/* 刀具分类(0刀具1辅具2配套9其他）	*/ 
	private String toolTypeWhere;

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）取得
	 * @return toolTypeWhere
	 */
	public String getToolTypeWhere () {
		return toolTypeWhere;
	}

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）设定
	 * @param toolTypeWhere
	 */
	public void setToolTypeWhere (String toolTypeWhere) {
		this.toolTypeWhere = toolTypeWhere;
	}

	/* 刀具图纸	*/ 
	private String toolPicWhere;

	/**
	 * 刀具图纸取得
	 * @return toolPicWhere
	 */
	public String getToolPicWhere () {
		return toolPicWhere;
	}

	/**
	 * 刀具图纸设定
	 * @param toolPicWhere
	 */
	public void setToolPicWhere (String toolPicWhere) {
		this.toolPicWhere = toolPicWhere;
	}

	/* 刀具每盒数量	*/ 
	private BigDecimal toolUnitnumberWhere;

	/**
	 * 刀具每盒数量取得
	 * @return toolUnitnumberWhere
	 */
	public BigDecimal getToolUnitnumberWhere () {
		return toolUnitnumberWhere;
	}

	/**
	 * 刀具每盒数量设定
	 * @param toolUnitnumberWhere
	 */
	public void setToolUnitnumberWhere (BigDecimal toolUnitnumberWhere) {
		this.toolUnitnumberWhere = toolUnitnumberWhere;
	}

	/* 规格型号	*/ 
	private String toolSpecificationsWhere;

	/**
	 * 规格型号取得
	 * @return toolSpecificationsWhere
	 */
	public String getToolSpecificationsWhere () {
		return toolSpecificationsWhere;
	}

	/**
	 * 规格型号设定
	 * @param toolSpecificationsWhere
	 */
	public void setToolSpecificationsWhere (String toolSpecificationsWhere) {
		this.toolSpecificationsWhere = toolSpecificationsWhere;
	}

	/* 供应商	*/ 
	private String toolSupplierWhere;

	/**
	 * 供应商取得
	 * @return toolSupplierWhere
	 */
	public String getToolSupplierWhere () {
		return toolSupplierWhere;
	}

	/**
	 * 供应商设定
	 * @param toolSupplierWhere
	 */
	public void setToolSupplierWhere (String toolSupplierWhere) {
		this.toolSupplierWhere = toolSupplierWhere;
	}

	/* 品牌	*/ 
	private String toolBrandWhere;

	/**
	 * 品牌取得
	 * @return toolBrandWhere
	 */
	public String getToolBrandWhere () {
		return toolBrandWhere;
	}

	/**
	 * 品牌设定
	 * @param toolBrandWhere
	 */
	public void setToolBrandWhere (String toolBrandWhere) {
		this.toolBrandWhere = toolBrandWhere;
	}

	/* 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他	*/ 
	private String toolConsumetypeWhere;

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他取得
	 * @return toolConsumetypeWhere
	 */
	public String getToolConsumetypeWhere () {
		return toolConsumetypeWhere;
	}

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他设定
	 * @param toolConsumetypeWhere
	 */
	public void setToolConsumetypeWhere (String toolConsumetypeWhere) {
		this.toolConsumetypeWhere = toolConsumetypeWhere;
	}

	/* 刃口数	*/ 
	private BigDecimal toolCutNumberWhere;

	/**
	 * 刃口数取得
	 * @return toolCutNumberWhere
	 */
	public BigDecimal getToolCutNumberWhere () {
		return toolCutNumberWhere;
	}

	/**
	 * 刃口数设定
	 * @param toolCutNumberWhere
	 */
	public void setToolCutNumberWhere (BigDecimal toolCutNumberWhere) {
		this.toolCutNumberWhere = toolCutNumberWhere;
	}

	/* 可使用次数	*/ 
	private BigDecimal toolSharpennumWhere;

	/**
	 * 可使用次数取得
	 * @return toolSharpennumWhere
	 */
	public BigDecimal getToolSharpennumWhere () {
		return toolSharpennumWhere;
	}

	/**
	 * 可使用次数设定
	 * @param toolSharpennumWhere
	 */
	public void setToolSharpennumWhere (BigDecimal toolSharpennumWhere) {
		this.toolSharpennumWhere = toolSharpennumWhere;
	}

	/* 复磨标准	*/ 
	private BigDecimal toolSharpenCriterionWhere;

	/**
	 * 复磨标准取得
	 * @return toolSharpenCriterionWhere
	 */
	public BigDecimal getToolSharpenCriterionWhere () {
		return toolSharpenCriterionWhere;
	}

	/**
	 * 复磨标准设定
	 * @param toolSharpenCriterionWhere
	 */
	public void setToolSharpenCriterionWhere (BigDecimal toolSharpenCriterionWhere) {
		this.toolSharpenCriterionWhere = toolSharpenCriterionWhere;
	}

	/* 刀具长度	*/ 
	private BigDecimal toolLengthWhere;

	/**
	 * 刀具长度取得
	 * @return toolLengthWhere
	 */
	public BigDecimal getToolLengthWhere () {
		return toolLengthWhere;
	}

	/**
	 * 刀具长度设定
	 * @param toolLengthWhere
	 */
	public void setToolLengthWhere (BigDecimal toolLengthWhere) {
		this.toolLengthWhere = toolLengthWhere;
	}

	/* 可刃磨长度	*/ 
	private BigDecimal toolSharpenLengthWhere;

	/**
	 * 可刃磨长度取得
	 * @return toolSharpenLengthWhere
	 */
	public BigDecimal getToolSharpenLengthWhere () {
		return toolSharpenLengthWhere;
	}

	/**
	 * 可刃磨长度设定
	 * @param toolSharpenLengthWhere
	 */
	public void setToolSharpenLengthWhere (BigDecimal toolSharpenLengthWhere) {
		this.toolSharpenLengthWhere = toolSharpenLengthWhere;
	}

	/* 最大库存量	*/ 
	private BigDecimal toolMaxWhere;

	/**
	 * 最大库存量取得
	 * @return toolMaxWhere
	 */
	public BigDecimal getToolMaxWhere () {
		return toolMaxWhere;
	}

	/**
	 * 最大库存量设定
	 * @param toolMaxWhere
	 */
	public void setToolMaxWhere (BigDecimal toolMaxWhere) {
		this.toolMaxWhere = toolMaxWhere;
	}

	/* 最小库存量	*/ 
	private BigDecimal toolMinWhere;

	/**
	 * 最小库存量取得
	 * @return toolMinWhere
	 */
	public BigDecimal getToolMinWhere () {
		return toolMinWhere;
	}

	/**
	 * 最小库存量设定
	 * @param toolMinWhere
	 */
	public void setToolMinWhere (BigDecimal toolMinWhere) {
		this.toolMinWhere = toolMinWhere;
	}

	/* 可刃磨次数	*/ 
	private BigDecimal toolNumberWhere;

	/**
	 * 可刃磨次数取得
	 * @return toolNumberWhere
	 */
	public BigDecimal getToolNumberWhere () {
		return toolNumberWhere;
	}

	/**
	 * 可刃磨次数设定
	 * @param toolNumberWhere
	 */
	public void setToolNumberWhere (BigDecimal toolNumberWhere) {
		this.toolNumberWhere = toolNumberWhere;
	}

	/* 修磨类别(0:厂内，1厂外）	*/ 
	private String toolGrindingWhere;

	/**
	 * 修磨类别(0:厂内，1厂外）取得
	 * @return toolGrindingWhere
	 */
	public String getToolGrindingWhere () {
		return toolGrindingWhere;
	}

	/**
	 * 修磨类别(0:厂内，1厂外）设定
	 * @param toolGrindingWhere
	 */
	public void setToolGrindingWhere (String toolGrindingWhere) {
		this.toolGrindingWhere = toolGrindingWhere;
	}

	/* 刀具库存周转量	*/ 
	private BigDecimal toolTurnoverWhere;

	/**
	 * 刀具库存周转量取得
	 * @return toolTurnoverWhere
	 */
	public BigDecimal getToolTurnoverWhere () {
		return toolTurnoverWhere;
	}

	/**
	 * 刀具库存周转量设定
	 * @param toolTurnoverWhere
	 */
	public void setToolTurnoverWhere (BigDecimal toolTurnoverWhere) {
		this.toolTurnoverWhere = toolTurnoverWhere;
	}

	/* 万台耗刀量	*/ 
	private BigDecimal per10kWhere;

	/**
	 * 万台耗刀量取得
	 * @return per10kWhere
	 */
	public BigDecimal getPer10kWhere () {
		return per10kWhere;
	}

	/**
	 * 万台耗刀量设定
	 * @param per10kWhere
	 */
	public void setPer10kWhere (BigDecimal per10kWhere) {
		this.per10kWhere = per10kWhere;
	}

	/* 采购周期(自然日)	*/ 
	private BigDecimal purchasingCycleWhere;

	/**
	 * 采购周期(自然日)取得
	 * @return purchasingCycleWhere
	 */
	public BigDecimal getPurchasingCycleWhere () {
		return purchasingCycleWhere;
	}

	/**
	 * 采购周期(自然日)设定
	 * @param purchasingCycleWhere
	 */
	public void setPurchasingCycleWhere (BigDecimal purchasingCycleWhere) {
		this.purchasingCycleWhere = purchasingCycleWhere;
	}

	/* 唯一标识(可以是SAP物料号也可以是其他系统标识)	*/ 
	private String uniquelyIdentifyWhere;

	/**
	 * 唯一标识(可以是SAP物料号也可以是其他系统标识)取得
	 * @return uniquelyIdentifyWhere
	 */
	public String getUniquelyIdentifyWhere () {
		return uniquelyIdentifyWhere;
	}

	/**
	 * 唯一标识(可以是SAP物料号也可以是其他系统标识)设定
	 * @param uniquelyIdentifyWhere
	 */
	public void setUniquelyIdentifyWhere (String uniquelyIdentifyWhere) {
		this.uniquelyIdentifyWhere = uniquelyIdentifyWhere;
	}

	/* 定额加工量	*/ 
	private BigDecimal quotaProcessingVolumeWhere;

	/**
	 * 定额加工量取得
	 * @return quotaProcessingVolumeWhere
	 */
	public BigDecimal getQuotaProcessingVolumeWhere () {
		return quotaProcessingVolumeWhere;
	}

	/**
	 * 定额加工量设定
	 * @param quotaProcessingVolumeWhere
	 */
	public void setQuotaProcessingVolumeWhere (BigDecimal quotaProcessingVolumeWhere) {
		this.quotaProcessingVolumeWhere = quotaProcessingVolumeWhere;
	}

	/* 库位码	*/ 
	private String libraryCodeIDWhere;

	/**
	 * 库位码取得
	 * @return libraryCodeIDWhere
	 */
	public String getLibraryCodeIDWhere () {
		return libraryCodeIDWhere;
	}

	/**
	 * 库位码设定
	 * @param libraryCodeIDWhere
	 */
	public void setLibraryCodeIDWhere (String libraryCodeIDWhere) {
		this.libraryCodeIDWhere = libraryCodeIDWhere;
	}

	/* 库位码	*/ 
	private String libraryCodeWhere;

	/**
	 * 库位码取得
	 * @return libraryCodeWhere
	 */
	public String getLibraryCodeWhere () {
		return libraryCodeWhere;
	}

	/**
	 * 库位码设定
	 * @param libraryCodeWhere
	 */
	public void setLibraryCodeWhere (String libraryCodeWhere) {
		this.libraryCodeWhere = libraryCodeWhere;
	}

	/* 区分文本	*/ 
	private String toolTypeNameWhere;

	/**
	 * 区分文本取得
	 * @return toolTypeNameWhere
	 */
	public String getToolTypeNameWhere () {
		return toolTypeNameWhere;
	}

	/**
	 * 区分文本设定
	 * @param toolTypeNameWhere
	 */
	public void setToolTypeNameWhere (String toolTypeNameWhere) {
		this.toolTypeNameWhere = toolTypeNameWhere;
	}

	/* 区分文本	*/ 
	private String toolConsumetypeNameWhere;

	/**
	 * 区分文本取得
	 * @return toolConsumetypeNameWhere
	 */
	public String getToolConsumetypeNameWhere () {
		return toolConsumetypeNameWhere;
	}

	/**
	 * 区分文本设定
	 * @param toolConsumetypeNameWhere
	 */
	public void setToolConsumetypeNameWhere (String toolConsumetypeNameWhere) {
		this.toolConsumetypeNameWhere = toolConsumetypeNameWhere;
	}
	private BigDecimal beiMin;
	private BigDecimal beiMax;

	public BigDecimal getBeiMin() {
		return beiMin;
	}

	public void setBeiMin(BigDecimal beiMin) {
		this.beiMin = beiMin;
	}

	public BigDecimal getBeiMax() {
		return beiMax;
	}

	public void setBeiMax(BigDecimal beiMax) {
		this.beiMax = beiMax;
	}
}

