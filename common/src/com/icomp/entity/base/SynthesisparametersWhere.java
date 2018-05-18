/*
 * 工具自动生成：合成刀具参数条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * 合成刀具参数条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class SynthesisparametersWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 合成刀具参数ID	*/ 
	private String synthesisParametersIDWhere;

	/**
	 * 合成刀具参数ID取得
	 * @return synthesisParametersIDWhere
	 */
	public String getSynthesisParametersIDWhere () {
		return synthesisParametersIDWhere;
	}

	/**
	 * 合成刀具参数ID设定
	 * @param synthesisParametersIDWhere
	 */
	public void setSynthesisParametersIDWhere (String synthesisParametersIDWhere) {
		this.synthesisParametersIDWhere = synthesisParametersIDWhere;
	}

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

	/* 位置数	*/ 
	private BigDecimal synthesisCountWhere;

	/**
	 * 位置数取得
	 * @return synthesisCountWhere
	 */
	public BigDecimal getSynthesisCountWhere () {
		return synthesisCountWhere;
	}

	/**
	 * 位置数设定
	 * @param synthesisCountWhere
	 */
	public void setSynthesisCountWhere (BigDecimal synthesisCountWhere) {
		this.synthesisCountWhere = synthesisCountWhere;
	}

	/* 是否工艺试验(0是1否)	*/ 
	private String technicalTestWhere;

	/**
	 * 是否工艺试验(0是1否)取得
	 * @return technicalTestWhere
	 */
	public String getTechnicalTestWhere () {
		return technicalTestWhere;
	}

	/**
	 * 是否工艺试验(0是1否)设定
	 * @param technicalTestWhere
	 */
	public void setTechnicalTestWhere (String technicalTestWhere) {
		this.technicalTestWhere = technicalTestWhere;
	}

	/* 组成类型(0刀片1钻头2复合刀具3热套类)	*/ 
	private String createTypeWhere;

	/**
	 * 组成类型(0刀片1钻头2复合刀具3热套类)取得
	 * @return createTypeWhere
	 */
	public String getCreateTypeWhere () {
		return createTypeWhere;
	}

	/**
	 * 组成类型(0刀片1钻头2复合刀具3热套类)设定
	 * @param createTypeWhere
	 */
	public void setCreateTypeWhere (String createTypeWhere) {
		this.createTypeWhere = createTypeWhere;
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
}

