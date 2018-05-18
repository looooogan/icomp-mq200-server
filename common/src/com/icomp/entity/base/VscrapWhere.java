/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/05/24 17:19:47
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/05/24 17:19:47
 * 创建者  ：工具自动生成
 * 
 */
public class VscrapWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具类型	*/ 
	private String toolTypeWhere;

	/**
	 * 刀具类型取得
	 * @return toolTypeWhere
	 */
	public String getToolTypeWhere () {
		return toolTypeWhere;
	}

	/**
	 * 刀具类型设定
	 * @param toolTypeWhere
	 */
	public void setToolTypeWhere (String toolTypeWhere) {
		this.toolTypeWhere = toolTypeWhere;
	}

	/* 刀具编码	*/ 
	private String toolCodeWhere;

	/**
	 * 刀具编码取得
	 * @return toolCodeWhere
	 */
	public String getToolCodeWhere () {
		return toolCodeWhere;
	}

	/**
	 * 刀具编码设定
	 * @param toolCodeWhere
	 */
	public void setToolCodeWhere (String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}

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

	/* 报废ID	*/ 
	private String scrapIDWhere;

	/**
	 * 报废ID取得
	 * @return scrapIDWhere
	 */
	public String getScrapIDWhere () {
		return scrapIDWhere;
	}

	/**
	 * 报废ID设定
	 * @param scrapIDWhere
	 */
	public void setScrapIDWhere (String scrapIDWhere) {
		this.scrapIDWhere = scrapIDWhere;
	}

	/* 创建时间	*/ 
	private Date createTimesWhere;

	/**
	 * 创建时间取得
	 * @return createTimesWhere
	 */
	public Date getCreateTimesWhere () {
		return createTimesWhere;
	}

	/**
	 * 创建时间设定
	 * @param createTimesWhere
	 */
	public void setCreateTimesWhere (Date createTimesWhere) {
		this.createTimesWhere = createTimesWhere;
	}

	/* 业务流程ID	*/ 
	private String businessIDWhere;

	/**
	 * 业务流程ID取得
	 * @return businessIDWhere
	 */
	public String getBusinessIDWhere () {
		return businessIDWhere;
	}

	/**
	 * 业务流程ID设定
	 * @param businessIDWhere
	 */
	public void setBusinessIDWhere (String businessIDWhere) {
		this.businessIDWhere = businessIDWhere;
	}

	/* 业务流程名	*/ 
	private String businessNameWhere;

	/**
	 * 业务流程名取得
	 * @return businessNameWhere
	 */
	public String getBusinessNameWhere () {
		return businessNameWhere;
	}

	/**
	 * 业务流程名设定
	 * @param businessNameWhere
	 */
	public void setBusinessNameWhere (String businessNameWhere) {
		this.businessNameWhere = businessNameWhere;
	}

	/* 	*/ 
	private String createUsersWhere;

	/**
	 * 取得
	 * @return createUsersWhere
	 */
	public String getCreateUsersWhere () {
		return createUsersWhere;
	}

	/**
	 * 设定
	 * @param createUsersWhere
	 */
	public void setCreateUsersWhere (String createUsersWhere) {
		this.createUsersWhere = createUsersWhere;
	}

	/* 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）	*/ 
	private String scrapCauseWhere;

	/**
	 * 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）取得
	 * @return scrapCauseWhere
	 */
	public String getScrapCauseWhere () {
		return scrapCauseWhere;
	}

	/**
	 * 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）设定
	 * @param scrapCauseWhere
	 */
	public void setScrapCauseWhere (String scrapCauseWhere) {
		this.scrapCauseWhere = scrapCauseWhere;
	}

	/* 	*/ 
	private String authorizationUserWhere;

	/**
	 * 取得
	 * @return authorizationUserWhere
	 */
	public String getAuthorizationUserWhere () {
		return authorizationUserWhere;
	}

	/**
	 * 设定
	 * @param authorizationUserWhere
	 */
	public void setAuthorizationUserWhere (String authorizationUserWhere) {
		this.authorizationUserWhere = authorizationUserWhere;
	}
}

