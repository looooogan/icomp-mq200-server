/*
 * 工具自动生成：系统-功能实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * 系统-功能实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class Sclink extends SclinkWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* scLinkID	*/ 
	private String scLinkID;

	/**
	 * scLinkID取得
	 * @return scLinkID
	 */
	public String getscLinkID() {
		return scLinkID;
	}

	/**
	 * scLinkID设定
	 * @param scLinkID
	 */
	public void setscLinkID(String scLinkID) {
		this.scLinkID = scLinkID;
	}

	/* SystemID	*/ 
	private String systemID;

	/**
	 * SystemID取得
	 * @return systemID
	 */
	public String getSystemID() {
		return systemID;
	}

	/**
	 * SystemID设定
	 * @param systemID
	 */
	public void setSystemID(String systemID) {
		this.systemID = systemID;
	}

	/* capability_ID	*/ 
	private String capabilityID;

	/**
	 * capability_ID取得
	 * @return capabilityID
	 */
	public String getCapabilityID() {
		return capabilityID;
	}

	/**
	 * capability_ID设定
	 * @param capabilityID
	 */
	public void setCapabilityID(String capabilityID) {
		this.capabilityID = capabilityID;
	}
}

