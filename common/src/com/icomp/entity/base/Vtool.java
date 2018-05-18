/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/03/10 09:33:30
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/03/10 09:33:30
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vtool extends VtoolWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 	*/ 
	private String toolCode;

	/**
	 * 取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 刀具名称	*/ 
	private String toolName;

	/**
	 * 刀具名称取得
	 * @return toolName
	 */
	public String getToolName() {
		return toolName;
	}

	/**
	 * 刀具名称设定
	 * @param toolName
	 */
	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	/* 刀具分类(0刀具1辅具2配套9其他）	*/ 
	private String toolType;

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）取得
	 * @return toolType
	 */
	public String getToolType() {
		return toolType;
	}

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）设定
	 * @param toolType
	 */
	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

	/* 刀具图纸	*/ 
	private String toolPic;

	/**
	 * 刀具图纸取得
	 * @return toolPic
	 */
	public String getToolPic() {
		return toolPic;
	}

	/**
	 * 刀具图纸设定
	 * @param toolPic
	 */
	public void setToolPic(String toolPic) {
		this.toolPic = toolPic;
	}

	/* 刀具每盒数量	*/ 
	private BigDecimal toolUnitnumber;

	/**
	 * 刀具每盒数量取得
	 * @return toolUnitnumber
	 */
	public BigDecimal getToolUnitnumber() {
		return toolUnitnumber;
	}

	/**
	 * 刀具每盒数量设定
	 * @param toolUnitnumber
	 */
	public void setToolUnitnumber(BigDecimal toolUnitnumber) {
		this.toolUnitnumber = toolUnitnumber;
	}

	/* 规格型号	*/ 
	private String toolSpecifications;

	/**
	 * 规格型号取得
	 * @return toolSpecifications
	 */
	public String getToolSpecifications() {
		return toolSpecifications;
	}

	/**
	 * 规格型号设定
	 * @param toolSpecifications
	 */
	public void setToolSpecifications(String toolSpecifications) {
		this.toolSpecifications = toolSpecifications;
	}

	/* 供应商	*/ 
	private String toolSupplier;

	/**
	 * 供应商取得
	 * @return toolSupplier
	 */
	public String getToolSupplier() {
		return toolSupplier;
	}

	/**
	 * 供应商设定
	 * @param toolSupplier
	 */
	public void setToolSupplier(String toolSupplier) {
		this.toolSupplier = toolSupplier;
	}

	/* 品牌	*/ 
	private String toolBrand;

	/**
	 * 品牌取得
	 * @return toolBrand
	 */
	public String getToolBrand() {
		return toolBrand;
	}

	/**
	 * 品牌设定
	 * @param toolBrand
	 */
	public void setToolBrand(String toolBrand) {
		this.toolBrand = toolBrand;
	}

	/* 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他	*/ 
	private String toolConsumetype;

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他取得
	 * @return toolConsumetype
	 */
	public String getToolConsumetype() {
		return toolConsumetype;
	}

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他设定
	 * @param toolConsumetype
	 */
	public void setToolConsumetype(String toolConsumetype) {
		this.toolConsumetype = toolConsumetype;
	}

	/* 刃口数	*/ 
	private BigDecimal toolCutNumber;

	/**
	 * 刃口数取得
	 * @return toolCutNumber
	 */
	public BigDecimal getToolCutNumber() {
		return toolCutNumber;
	}

	/**
	 * 刃口数设定
	 * @param toolCutNumber
	 */
	public void setToolCutNumber(BigDecimal toolCutNumber) {
		this.toolCutNumber = toolCutNumber;
	}

	/* 可使用次数	*/ 
	private BigDecimal toolSharpennum;

	/**
	 * 可使用次数取得
	 * @return toolSharpennum
	 */
	public BigDecimal getToolSharpennum() {
		return toolSharpennum;
	}

	/**
	 * 可使用次数设定
	 * @param toolSharpennum
	 */
	public void setToolSharpennum(BigDecimal toolSharpennum) {
		this.toolSharpennum = toolSharpennum;
	}

	/* 复磨标准	*/ 
	private BigDecimal toolSharpenCriterion;

	/**
	 * 复磨标准取得
	 * @return toolSharpenCriterion
	 */
	public BigDecimal getToolSharpenCriterion() {
		return toolSharpenCriterion;
	}

	/**
	 * 复磨标准设定
	 * @param toolSharpenCriterion
	 */
	public void setToolSharpenCriterion(BigDecimal toolSharpenCriterion) {
		this.toolSharpenCriterion = toolSharpenCriterion;
	}

	/* 刀具长度	*/ 
	private BigDecimal toolLength;

	/**
	 * 刀具长度取得
	 * @return toolLength
	 */
	public BigDecimal getToolLength() {
		return toolLength;
	}

	/**
	 * 刀具长度设定
	 * @param toolLength
	 */
	public void setToolLength(BigDecimal toolLength) {
		this.toolLength = toolLength;
	}

	/* 可刃磨长度	*/ 
	private BigDecimal toolSharpenLength;

	/**
	 * 可刃磨长度取得
	 * @return toolSharpenLength
	 */
	public BigDecimal getToolSharpenLength() {
		return toolSharpenLength;
	}

	/**
	 * 可刃磨长度设定
	 * @param toolSharpenLength
	 */
	public void setToolSharpenLength(BigDecimal toolSharpenLength) {
		this.toolSharpenLength = toolSharpenLength;
	}

	/* 最大库存量	*/ 
	private BigDecimal toolMax;

	/**
	 * 最大库存量取得
	 * @return toolMax
	 */
	public BigDecimal getToolMax() {
		return toolMax;
	}

	/**
	 * 最大库存量设定
	 * @param toolMax
	 */
	public void setToolMax(BigDecimal toolMax) {
		this.toolMax = toolMax;
	}

	/* 最小库存量	*/ 
	private BigDecimal toolMin;

	/**
	 * 最小库存量取得
	 * @return toolMin
	 */
	public BigDecimal getToolMin() {
		return toolMin;
	}

	/**
	 * 最小库存量设定
	 * @param toolMin
	 */
	public void setToolMin(BigDecimal toolMin) {
		this.toolMin = toolMin;
	}

	/* 可刃磨次数	*/ 
	private BigDecimal toolNumber;

	/**
	 * 可刃磨次数取得
	 * @return toolNumber
	 */
	public BigDecimal getToolNumber() {
		return toolNumber;
	}

	/**
	 * 可刃磨次数设定
	 * @param toolNumber
	 */
	public void setToolNumber(BigDecimal toolNumber) {
		this.toolNumber = toolNumber;
	}

	/* 修磨类别(0:厂内，1厂外）	*/ 
	private String toolGrinding;

	/**
	 * 修磨类别(0:厂内，1厂外）取得
	 * @return toolGrinding
	 */
	public String getToolGrinding() {
		return toolGrinding;
	}

	/**
	 * 修磨类别(0:厂内，1厂外）设定
	 * @param toolGrinding
	 */
	public void setToolGrinding(String toolGrinding) {
		this.toolGrinding = toolGrinding;
	}

	/* 刀具库存周转量	*/ 
	private BigDecimal toolTurnover;

	/**
	 * 刀具库存周转量取得
	 * @return toolTurnover
	 */
	public BigDecimal getToolTurnover() {
		return toolTurnover;
	}

	/**
	 * 刀具库存周转量设定
	 * @param toolTurnover
	 */
	public void setToolTurnover(BigDecimal toolTurnover) {
		this.toolTurnover = toolTurnover;
	}

	/* 万台耗刀量	*/ 
	private BigDecimal per10k;

	/**
	 * 万台耗刀量取得
	 * @return per10k
	 */
	public BigDecimal getPer10k() {
		return per10k;
	}

	/**
	 * 万台耗刀量设定
	 * @param per10k
	 */
	public void setPer10k(BigDecimal per10k) {
		this.per10k = per10k;
	}

	/* 采购周期(自然日)	*/ 
	private BigDecimal purchasingCycle;

	/**
	 * 采购周期(自然日)取得
	 * @return purchasingCycle
	 */
	public BigDecimal getPurchasingCycle() {
		return purchasingCycle;
	}

	/**
	 * 采购周期(自然日)设定
	 * @param purchasingCycle
	 */
	public void setPurchasingCycle(BigDecimal purchasingCycle) {
		this.purchasingCycle = purchasingCycle;
	}

	/* 唯一标识(可以是SAP物料号也可以是其他系统标识)	*/ 
	private String uniquelyIdentify;

	/**
	 * 唯一标识(可以是SAP物料号也可以是其他系统标识)取得
	 * @return uniquelyIdentify
	 */
	public String getUniquelyIdentify() {
		return uniquelyIdentify;
	}

	/**
	 * 唯一标识(可以是SAP物料号也可以是其他系统标识)设定
	 * @param uniquelyIdentify
	 */
	public void setUniquelyIdentify(String uniquelyIdentify) {
		this.uniquelyIdentify = uniquelyIdentify;
	}

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

	/* 库位码	*/ 
	private String libraryCodeID;

	/**
	 * 库位码取得
	 * @return libraryCodeID
	 */
	public String getLibraryCodeID() {
		return libraryCodeID;
	}

	/**
	 * 库位码设定
	 * @param libraryCodeID
	 */
	public void setLibraryCodeID(String libraryCodeID) {
		this.libraryCodeID = libraryCodeID;
	}

	/* 库位码	*/ 
	private String libraryCode;

	/**
	 * 库位码取得
	 * @return libraryCode
	 */
	public String getLibraryCode() {
		return libraryCode;
	}

	/**
	 * 库位码设定
	 * @param libraryCode
	 */
	public void setLibraryCode(String libraryCode) {
		this.libraryCode = libraryCode;
	}

	/* 区分文本	*/ 
	private String toolTypeName;

	/**
	 * 区分文本取得
	 * @return toolTypeName
	 */
	public String getToolTypeName() {
		return toolTypeName;
	}

	/**
	 * 区分文本设定
	 * @param toolTypeName
	 */
	public void setToolTypeName(String toolTypeName) {
		this.toolTypeName = toolTypeName;
	}

	/* 区分文本	*/ 
	private String toolConsumetypeName;

	/**
	 * 区分文本取得
	 * @return toolConsumetypeName
	 */
	public String getToolConsumetypeName() {
		return toolConsumetypeName;
	}

	/**
	 * 区分文本设定
	 * @param toolConsumetypeName
	 */
	public void setToolConsumetypeName(String toolConsumetypeName) {
		this.toolConsumetypeName = toolConsumetypeName;
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

	// 2017/11/16 王冉 追加↓↓↓　dazhong@YMSC
	private BigDecimal toolPrice;

	private BigDecimal toolAveragePrice;

	private String toolParametersType;

	public BigDecimal getToolPrice() {
		return toolPrice;
	}

	public void setToolPrice(BigDecimal toolPrice) {
		this.toolPrice = toolPrice;
	}

	public BigDecimal getToolAveragePrice() {
		return toolAveragePrice;
	}

	public void setToolAveragePrice(BigDecimal toolAveragePrice) {
		this.toolAveragePrice = toolAveragePrice;
	}

	public String getToolParametersType() {
		return toolParametersType;
	}

	public void setToolParametersType(String toolParametersType) {
		this.toolParametersType = toolParametersType;
	}

	// 2017/11/16 王冉 追加↑↑↑　dazhong@YMSC
}

