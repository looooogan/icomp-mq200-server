/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/05/24 17:19:47
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.Date;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/05/24 17:19:47
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public class Vscrap extends VscrapWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具类型	*/
	private String toolType;

	/**
	 * 刀具类型取得
	 * @return toolType
	 */
	public String getToolType() {
		return toolType;
	}

	/**
	 * 刀具类型设定
	 * @param toolType
	 */
	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

	/* 刀具编码	*/
	private String toolCode;

	/**
	 * 刀具编码取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 刀具编码设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

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

	/* 报废ID	*/
	private String scrapID;

	/**
	 * 报废ID取得
	 * @return scrapID
	 */
	public String getScrapID() {
		return scrapID;
	}

	/**
	 * 报废ID设定
	 * @param scrapID
	 */
	public void setScrapID(String scrapID) {
		this.scrapID = scrapID;
	}

	/* 创建时间	*/
	private Date createTimes;

	/**
	 * 创建时间取得
	 * @return createTimes
	 */
	public Date getCreateTimes() {
		return createTimes;
	}

	/**
	 * 创建时间设定
	 * @param createTimes
	 */
	public void setCreateTimes(Date createTimes) {
		this.createTimes = createTimes;
	}

	/* 业务流程ID	*/
	private String businessID;

	/**
	 * 业务流程ID取得
	 * @return businessID
	 */
	public String getBusinessID() {
		return businessID;
	}

	/**
	 * 业务流程ID设定
	 * @param businessID
	 */
	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}

	/* 业务流程名	*/
	private String businessName;

	/**
	 * 业务流程名取得
	 * @return businessName
	 */
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * 业务流程名设定
	 * @param businessName
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/* 	*/
	private String createUsers;

	/**
	 * 取得
	 * @return createUsers
	 */
	public String getCreateUsers() {
		return createUsers;
	}

	/**
	 * 设定
	 * @param createUsers
	 */
	public void setCreateUsers(String createUsers) {
		this.createUsers = createUsers;
	}

	/* 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）	*/
	private String scrapCause;

	/**
	 * 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）取得
	 * @return scrapCause
	 */
	public String getScrapCause() {
		return scrapCause;
	}

	/**
	 * 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）设定
	 * @param scrapCause
	 */
	public void setScrapCause(String scrapCause) {
		this.scrapCause = scrapCause;
	}

	/* 	*/
	private String authorizationUser;

	/**
	 * 取得
	 * @return authorizationUser
	 */
	public String getAuthorizationUser() {
		return authorizationUser;
	}

	/**
	 * 设定
	 * @param authorizationUser
	 */
	public void setAuthorizationUser(String authorizationUser) {
		this.authorizationUser = authorizationUser;
	}

	// 2017/08/21 宋健 追加↓↓↓　dazhong@YMSC
	/* 报废数量	*/
	private String scrapNumber;

	/**
	 * 取得
	 * @return scrapNumber
	 */
	public String getScrapNumber() {
		return scrapNumber;
	}

	/**
	 * 设定
	 * @param scrapNumber
	 */
	public void setScrapNumber(String scrapNumber) {
		this.scrapNumber = scrapNumber;
	}
	// 2017/08/21 宋健 追加↑↑↑　dazhong@YMSC
}

