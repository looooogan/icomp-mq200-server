/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/03/26 16:53:46
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;



/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/03/26 16:53:46
 * 创建者  ：工具自动生成
 * 
 */
public class VgetsynsistoolmsgWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* RFID载体ID	*/ 
	private String rfidContainerIDWhere;

	/**
	 * RFID载体ID取得
	 * @return rfidContainerIDWhere
	 */
	public String getRfidContainerIDWhere () {
		return rfidContainerIDWhere;
	}

	/**
	 * RFID载体ID设定
	 * @param rfidContainerIDWhere
	 */
	public void setRfidContainerIDWhere (String rfidContainerIDWhere) {
		this.rfidContainerIDWhere = rfidContainerIDWhere;
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

	/* 刀具编码(应该装入合成刀的编码)	*/ 
	private String toolCodeWhere;

	/**
	 * 刀具编码(应该装入合成刀的编码)取得
	 * @return toolCodeWhere
	 */
	public String getToolCodeWhere () {
		return toolCodeWhere;
	}

	/**
	 * 刀具编码(应该装入合成刀的编码)设定
	 * @param toolCodeWhere
	 */
	public void setToolCodeWhere (String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}

	/* 位置类型(0刀具1辅具2配套9其他)	*/ 
	private String cutterTypeWhere;

	/**
	 * 位置类型(0刀具1辅具2配套9其他)取得
	 * @return cutterTypeWhere
	 */
	public String getCutterTypeWhere () {
		return cutterTypeWhere;
	}

	/**
	 * 位置类型(0刀具1辅具2配套9其他)设定
	 * @param cutterTypeWhere
	 */
	public void setCutterTypeWhere (String cutterTypeWhere) {
		this.cutterTypeWhere = cutterTypeWhere;
	}
}

