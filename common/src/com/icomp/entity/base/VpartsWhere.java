/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/03/03 16:41:44
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;



/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/03/03 16:41:44
 * 创建者  ：工具自动生成
 * 
 */
public class VpartsWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 零部件ID	*/ 
	private String partsIDWhere;

	/**
	 * 零部件ID取得
	 * @return partsIDWhere
	 */
	public String getPartsIDWhere () {
		return partsIDWhere;
	}

	/**
	 * 零部件ID设定
	 * @param partsIDWhere
	 */
	public void setPartsIDWhere (String partsIDWhere) {
		this.partsIDWhere = partsIDWhere;
	}

	/* 零部件编码	*/ 
	private String partsCodeWhere;

	/**
	 * 零部件编码取得
	 * @return partsCodeWhere
	 */
	public String getPartsCodeWhere () {
		return partsCodeWhere;
	}

	/**
	 * 零部件编码设定
	 * @param partsCodeWhere
	 */
	public void setPartsCodeWhere (String partsCodeWhere) {
		this.partsCodeWhere = partsCodeWhere;
	}

	/* 零部件名称	*/ 
	private String partsNameWhere;

	/**
	 * 零部件名称取得
	 * @return partsNameWhere
	 */
	public String getPartsNameWhere () {
		return partsNameWhere;
	}

	/**
	 * 零部件名称设定
	 * @param partsNameWhere
	 */
	public void setPartsNameWhere (String partsNameWhere) {
		this.partsNameWhere = partsNameWhere;
	}

	/* 零部件型号（0:1.6L,1:1.4T）	*/ 
	private String partsTypeWhere;

	/**
	 * 零部件型号（0:1.6L,1:1.4T）取得
	 * @return partsTypeWhere
	 */
	public String getPartsTypeWhere () {
		return partsTypeWhere;
	}

	/**
	 * 零部件型号（0:1.6L,1:1.4T）设定
	 * @param partsTypeWhere
	 */
	public void setPartsTypeWhere (String partsTypeWhere) {
		this.partsTypeWhere = partsTypeWhere;
	}
}

