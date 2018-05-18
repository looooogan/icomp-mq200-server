/*
 * 工具自动生成：加工履历（在刀具安上设备上需要记录当前合成刀与刀具的绑定关系）条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * 加工履历（在刀具安上设备上需要记录当前合成刀与刀具的绑定关系）条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class MachiningexperienceWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

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

	/* 合成刀具编号(例如：001、002、003)	*/ 
	private String synthesisParametersNumberWhere;

	/**
	 * 合成刀具编号(例如：001、002、003)取得
	 * @return synthesisParametersNumberWhere
	 */
	public String getSynthesisParametersNumberWhere () {
		return synthesisParametersNumberWhere;
	}

	/**
	 * 合成刀具编号(例如：001、002、003)设定
	 * @param synthesisParametersNumberWhere
	 */
	public void setSynthesisParametersNumberWhere (String synthesisParametersNumberWhere) {
		this.synthesisParametersNumberWhere = synthesisParametersNumberWhere;
	}

	/* 加工编号(年月日时分秒 14位字符串)	*/ 
	private String synthesisNumberWhere;

	/**
	 * 加工编号(年月日时分秒 14位字符串)取得
	 * @return synthesisNumberWhere
	 */
	public String getSynthesisNumberWhere () {
		return synthesisNumberWhere;
	}

	/**
	 * 加工编号(年月日时分秒 14位字符串)设定
	 * @param synthesisNumberWhere
	 */
	public void setSynthesisNumberWhere (String synthesisNumberWhere) {
		this.synthesisNumberWhere = synthesisNumberWhere;
	}

	/* 位置号	*/ 
	private BigDecimal synthesisCutterNumberWhere;

	/**
	 * 位置号取得
	 * @return synthesisCutterNumberWhere
	 */
	public BigDecimal getSynthesisCutterNumberWhere () {
		return synthesisCutterNumberWhere;
	}

	/**
	 * 位置号设定
	 * @param synthesisCutterNumberWhere
	 */
	public void setSynthesisCutterNumberWhere (BigDecimal synthesisCutterNumberWhere) {
		this.synthesisCutterNumberWhere = synthesisCutterNumberWhere;
	}

	/* 刀具入库编码	*/ 
	private String knifeInventoryCodeWhere;

	/**
	 * 刀具入库编码取得
	 * @return knifeInventoryCodeWhere
	 */
	public String getKnifeInventoryCodeWhere () {
		return knifeInventoryCodeWhere;
	}

	/**
	 * 刀具入库编码设定
	 * @param knifeInventoryCodeWhere
	 */
	public void setKnifeInventoryCodeWhere (String knifeInventoryCodeWhere) {
		this.knifeInventoryCodeWhere = knifeInventoryCodeWhere;
	}

	/* 刀具损耗	*/ 
	private BigDecimal toolWastageWhere;

	/**
	 * 刀具损耗取得
	 * @return toolWastageWhere
	 */
	public BigDecimal getToolWastageWhere () {
		return toolWastageWhere;
	}

	/**
	 * 刀具损耗设定
	 * @param toolWastageWhere
	 */
	public void setToolWastageWhere (BigDecimal toolWastageWhere) {
		this.toolWastageWhere = toolWastageWhere;
	}
}

