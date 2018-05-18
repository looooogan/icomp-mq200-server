/*
 * 工具自动生成：合成刀位置实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * 合成刀位置实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class Synthesiscutterlocation extends SynthesiscutterlocationWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 合成刀具参数ID	*/ 
	private String synthesisParametersID;

	/**
	 * 合成刀具参数ID取得
	 * @return synthesisParametersID
	 */
	public String getSynthesisParametersID() {
		return synthesisParametersID;
	}

	/**
	 * 合成刀具参数ID设定
	 * @param synthesisParametersID
	 */
	public void setSynthesisParametersID(String synthesisParametersID) {
		this.synthesisParametersID = synthesisParametersID;
	}

	/* 位置类型(0刀具1辅具2配套9其他)	*/ 
	private String cutterType;

	/**
	 * 位置类型(0刀具1辅具2配套9其他)取得
	 * @return cutterType
	 */
	public String getCutterType() {
		return cutterType;
	}

	/**
	 * 位置类型(0刀具1辅具2配套9其他)设定
	 * @param cutterType
	 */
	public void setCutterType(String cutterType) {
		this.cutterType = cutterType;
	}

	/* 位置号	*/ 
	private BigDecimal synthesisCutterNumber;

	/**
	 * 位置号取得
	 * @return synthesisCutterNumber
	 */
	public BigDecimal getSynthesisCutterNumber() {
		return synthesisCutterNumber;
	}

	/**
	 * 位置号设定
	 * @param synthesisCutterNumber
	 */
	public void setSynthesisCutterNumber(BigDecimal synthesisCutterNumber) {
		this.synthesisCutterNumber = synthesisCutterNumber;
	}

	/* 刀具编码(应该装入合成刀的编码)	*/ 
	private String toolCode;

	/**
	 * 刀具编码(应该装入合成刀的编码)取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 刀具编码(应该装入合成刀的编码)设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 替换刀具编码（刀具编码以逗号分隔）	*/ 
	private String tempToolCode;

	/**
	 * 替换刀具编码（刀具编码以逗号分隔）取得
	 * @return tempToolCode
	 */
	public String getTempToolCode() {
		return tempToolCode;
	}

	/**
	 * 替换刀具编码（刀具编码以逗号分隔）设定
	 * @param tempToolCode
	 */
	public void setTempToolCode(String tempToolCode) {
		this.tempToolCode = tempToolCode;
	}

	// 2017/09/18 王冉 追加↓↓↓　dazhong@YMSC

	private String toolCount;

	public String getToolCount() {
		return toolCount;
	}

	public void setToolCount(String toolCount) {
		this.toolCount = toolCount;
	}
	// 2017/09/18 王冉 追加↑↑↑　dazhong@YMSC


	private List<ToolReplace> replaceCodes;

	public List<ToolReplace> getReplaceCodes() {
		return replaceCodes;
	}

	public void setReplaceCodes(List<ToolReplace> replaceCodes) {
		this.replaceCodes = replaceCodes;
	}
}

