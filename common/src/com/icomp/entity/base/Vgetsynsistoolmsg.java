/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/03/26 16:53:46
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/03/26 16:53:46
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vgetsynsistoolmsg extends VgetsynsistoolmsgWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* RFID载体ID	*/ 
	private String rfidContainerID;

	/**
	 * RFID载体ID取得
	 * @return rfidContainerID
	 */
	public String getRfidContainerID() {
		return rfidContainerID;
	}

	/**
	 * RFID载体ID设定
	 * @param rfidContainerID
	 */
	public void setRfidContainerID(String rfidContainerID) {
		this.rfidContainerID = rfidContainerID;
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
}

