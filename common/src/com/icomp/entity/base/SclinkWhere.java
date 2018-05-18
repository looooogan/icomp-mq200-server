/*
 * 工具自动生成：系统-功能条件实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;


/**
 * 系统-功能条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class SclinkWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* scLinkID	*/ 
	private String scLinkIDWhere;

	/**
	 * scLinkID取得
	 * @return scLinkIDWhere
	 */
	public String getscLinkIDWhere () {
		return scLinkIDWhere;
	}

	/**
	 * scLinkID设定
	 * @param scLinkIDWhere
	 */
	public void setscLinkIDWhere (String scLinkIDWhere) {
		this.scLinkIDWhere = scLinkIDWhere;
	}

	/* SystemID	*/ 
	private String systemIDWhere;

	/**
	 * SystemID取得
	 * @return systemIDWhere
	 */
	public String getSystemIDWhere () {
		return systemIDWhere;
	}

	/**
	 * SystemID设定
	 * @param systemIDWhere
	 */
	public void setSystemIDWhere (String systemIDWhere) {
		this.systemIDWhere = systemIDWhere;
	}

	/* capability_ID	*/ 
	private String capabilityIDWhere;

	/**
	 * capability_ID取得
	 * @return capabilityIDWhere
	 */
	public String getCapabilityIDWhere () {
		return capabilityIDWhere;
	}

	/**
	 * capability_ID设定
	 * @param capabilityIDWhere
	 */
	public void setCapabilityIDWhere (String capabilityIDWhere) {
		this.capabilityIDWhere = capabilityIDWhere;
	}
}

